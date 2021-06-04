package kr.spring.board.controller;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.board.service.BoardService;
import kr.spring.board.vo.BoardVO;
import kr.spring.util.PagingUtil;
import kr.spring.util.StringUtil;

@Controller
public class BoardController {
	private Logger log = Logger.getLogger(this.getClass());
	
	//의존 관계 설정
	@Resource
	private BoardService boardService;
	
	//자바빈(VO) 초기화
	@ModelAttribute("boardVO")
	public BoardVO initCommand() {
		return new BoardVO();
	}
	//====게시판 글 등록=======//
	//등록 폼
	@RequestMapping(value="/board/write.do",method=RequestMethod.GET)
	public String form() {
		return "boardWrite";
	}
	//전송된 데이터 처리
	@RequestMapping(value="/board/write.do",method=RequestMethod.POST)
	public String submit(@Valid BoardVO boardVO,
			             BindingResult result,
			             HttpServletRequest request,
			             HttpSession session) {
		
		//유효성 체크 결과 오류가 있으면 폼 호출
		if(result.hasErrors()) {
			return "boardWrite";
		}
		
		//회원 번호 셋팅
		boardVO.setMem_num((Integer)session.getAttribute("user_num"));
		//ip 셋팅
		boardVO.setIp(request.getRemoteAddr());
		//글쓰기
		boardService.insertBoard(boardVO);
		
		return "redirect:/board/list.do";
	}
	
	//=====게시판 글 목록=====//
	@RequestMapping("/board/list.do")
	public ModelAndView process(
	@RequestParam(value="pageNum",defaultValue="1") int currentPage) {
		
		//총 레코드 수
		int count = boardService.selectRowCount();
		
		if(log.isDebugEnabled()) {
			log.debug("<<pageNum>> : " + currentPage);
			log.debug("<<count>> : " + count);
		}
		
		//페이징 처리
		PagingUtil page = 
				new PagingUtil(currentPage,count,10,10,"list.do");
		
		List<BoardVO> list = null;
		if(count > 0) {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("start", page.getStartCount());
			map.put("end", page.getEndCount());
			list = boardService.selectList(map);
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("boardList");
		mav.addObject("count", count);
		mav.addObject("list",list);
		mav.addObject("pagingHtml",page.getPagingHtml());
		
		return mav;
	}
	
	//====게시판 글 상세======//
	@RequestMapping("/board/detail.do")
	public ModelAndView detail(@RequestParam int board_num) {
		if(log.isDebugEnabled()) {
			log.debug("<<board_num>> : " + board_num);
		}
		
		//해당 글의 조회수 증가
		boardService.updateHit(board_num);
		
		BoardVO board = boardService.selectBoard(board_num);
		//HTML 태그 불허
		board.setTitle(StringUtil.useNoHtml(board.getTitle()));
		//HTML 태그 불허 및 줄바꿈 처리
		board.setContent(StringUtil.useBrNoHtml(board.getContent()));
		
		return new ModelAndView("boardView","board",board);
		
	}
	//이미지 출력
	@RequestMapping("/board/imageView.do")
	public ModelAndView viewImage(@RequestParam int board_num) {
		BoardVO board = boardService.selectBoard(board_num);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("imageView");
		mav.addObject("imageFile",board.getUploadfile());
		mav.addObject("filename", board.getFilename());
		
		return mav;
	}
	
	//=====게시판 글 수정======//
	//수정 폼
	@RequestMapping(value="/board/update.do",method=RequestMethod.GET)
	public String formUpdate(@RequestParam int board_num,Model model) {
		BoardVO boardVO = boardService.selectBoard(board_num);
		model.addAttribute("boardVO", boardVO);
		
		return "boardModify";
	}
	//수정 폼에서 전송된 데이터 처리
	@RequestMapping(value="/board/update.do",method=RequestMethod.POST)
	public String submitUpdate(@Valid BoardVO boardVO,
			                   BindingResult result,
			                   HttpServletRequest request) {
		//유효성 체크 결과 오류가 있으면 폼 호출
		if(result.hasErrors()) {
			return "boardModify";
		}
		
		//ip셋팅
		boardVO.setIp(request.getRemoteAddr());
		//글 수정
		boardService.updateBoard(boardVO);
		
		return "redirect:/board/list.do";
	}
	
	//======게시판 글 삭제========//
	@RequestMapping("/board/delete.do")
	public String submitDelete(@RequestParam int board_num) {
		//글 삭제
		boardService.deleteBoard(board_num);
		
		return "redirect:/board/list.do";
	}
	
}




