package kr.spring.cheat.controller;

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


import kr.spring.cheat.service.CheatService;
import kr.spring.cheat.vo.CheatVO;
import kr.spring.member.service.MemberService;
import kr.spring.member.vo.MemberVO;
import kr.spring.util.PagingUtil;
import kr.spring.util.StringUtil;

@Controller
public class CheatController {

	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private CheatService cheatService;
	@Resource
	private MemberService memberService;
	
	@ModelAttribute
	public CheatVO initCommand() {
		return new CheatVO();
	}
	
	//목록
	@RequestMapping("/cheat/list.do")
	public ModelAndView process(
			@RequestParam(value="pageNum",defaultValue="1") int currentPage) {
				
				//총 레코드 수
				int count = cheatService.selectRowCount();
				
				if(log.isDebugEnabled()) {
					log.debug("<<pageNum>> : " + currentPage);
					log.debug("<<count>> : " + count);
				}
				
				//페이징 처리
				PagingUtil page = 
						new PagingUtil(currentPage,count,10,10,"list.do");
				
				List<CheatVO> list = null;
				if(count > 0) {
					Map<String,Object> map = new HashMap<String,Object>();
					map.put("start", page.getStartCount());
					map.put("end", page.getEndCount());
					list = cheatService.selectList(map);
				}
				
				ModelAndView mav = new ModelAndView();
				mav.setViewName("cheatList");
				mav.addObject("count", count);
				mav.addObject("list",list);
				mav.addObject("pagingHtml",page.getPagingHtml());
				
				return mav;
			}
	
	//게시글 상세
	@RequestMapping("/cheat/detail.do")
	public ModelAndView detail(@RequestParam int che_num) {
		if(log.isDebugEnabled()) {
			log.debug("<<che_num>> : " + che_num);
		}
		
		//조회수 증가
		cheatService.updateHit(che_num);
		
		CheatVO cheat = cheatService.selectBoard(che_num);
		//HTML 태그 불허
		cheat.setChe_title(StringUtil.useBrNoHtml(cheat.getChe_title()));
		//HTML태그 불허 및 줄바꿈 처리
		cheat.setChe_content(StringUtil.useBrNoHtml(cheat.getChe_content()));
		
		return new ModelAndView("cheatView","cheat",cheat);
	}
	
	//글쓰기
	@RequestMapping(value="/cheat/write.do",method=RequestMethod.GET)
	public String form() {
		return "cheatRegister";
	}
	
	@RequestMapping(value="/cheat/write.do",method=RequestMethod.POST)
	public String submit(@Valid CheatVO cheatVO,
			             BindingResult result,
			             HttpServletRequest request,
			             HttpSession session) {
		
		//유효성 체크 결과 오류가 있으면 폼 호출
		if(result.hasErrors()) {
			return "cheatRegister";
		}
		
		//회원 번호 셋팅
		cheatVO.setMem_num((Integer)session.getAttribute("user_num"));
		//글쓰기
		cheatService.insertBoard(cheatVO);
		
		return "redirect:/cheat/list.do";
	}
	
	//=====게시판 글 수정======//
	//수정 폼
	@RequestMapping(value="/cheat/update.do",method=RequestMethod.GET)
	public String formUpdate(@RequestParam int che_num,Model model) {
		CheatVO cheatVO = cheatService.selectBoard(che_num);
		model.addAttribute("cheatVO", cheatVO);
		
		return "cheatModify";
	}
	//수정 폼에서 전송된 데이터 처리
	@RequestMapping(value="/cheat/update.do",method=RequestMethod.POST)
	public String submitUpdate(@Valid CheatVO cheatVO,
			                   BindingResult result,
			                   HttpServletRequest request) {
		//유효성 체크 결과 오류가 있으면 폼 호출
		if(result.hasErrors()) {
			return "cheatModify";
		}
		
		//글 수정
		cheatService.updateBoard(cheatVO);
		
		return "redirect:/cheat/list.do";
	}
	
	//======게시판 글 삭제========//
	@RequestMapping("/cheat/delete.do")
	public String submitDelete(@RequestParam int che_num) {
		//글 삭제
		cheatService.deleteBoard(che_num);
		
		return "redirect:/cheat/list.do";
	}
	//관리자가 확인
	@RequestMapping(value="/cheat/adminCheck.do",method=RequestMethod.POST)
	public String checkCheatting(@RequestParam int che_num,@RequestParam int che_pnum) {
		
		//글 수정
		cheatService.updateCheatByAdmin(che_num);
		//신고당한 사람의 포인트 정보 읽기
		MemberVO memberVO = memberService.selectMember(che_pnum);
		//포인트 차감
		if(memberVO.getMem_credit()>0) {
			memberService.updateCredit(che_pnum);
		}
		
		return "redirect:/cheat/detail.do?che_num="+che_num;
	}
}
