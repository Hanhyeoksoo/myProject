package kr.spring.eve.controller;

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

import kr.spring.eve.service.EveService;
import kr.spring.eve.vo.EveVO;
import kr.spring.util.PagingUtil;


@Controller
public class EveController {
	private Logger log = Logger.getLogger(this.getClass());

	//의존 관계 설정
	@Resource
	private EveService eveService;

	//자바빈(VO) 초기화
	@ModelAttribute("eveVO")
	public EveVO initCommand() {
		return new EveVO();
	}

	//====상품 등록 페이지====
	//상품 등록폼
	@RequestMapping(value="/eve/write.do",method=RequestMethod.GET)
	public String form() {
		return "eveWrite";
	}

	//전송된 데이터 처리
	@RequestMapping(value="/eve/write.do",method=RequestMethod.POST)
	public String submit(@Valid EveVO eveVO,
			BindingResult result,
			HttpServletRequest request,
			HttpSession session) {

		//유효성 체크 결과 오류가 있으면 폼 호출
		if(result.hasErrors()) {
			return "eveWrite";
		}

		//회원 번호 셋팅
		eveVO.setMem_num((Integer)session.getAttribute("user_num"));
		//글쓰기
		eveService.insertEve(eveVO);

		return "redirect:/eve/list.do";

	}

	//===상품 목록 페이지 ===//
	//상품 목록
	@RequestMapping("/eve/list.do")
	public ModelAndView process(
			@RequestParam(value="pageNum",defaultValue="1") int currentPage,
			@RequestParam(value="keyword",defaultValue="") String keyword) {

		Map<String,Object> map = new HashMap<String,Object>();
		map.put("keyword", keyword);
		//총 레코드 수
		int count = eveService.selectRowCount(map);

		if(log.isDebugEnabled()) {
			log.debug("<<pageNum>> : " + currentPage);
			log.debug("<<count>> : " + count);
		}

		//페이징 처리
		PagingUtil page = 
				new PagingUtil(currentPage,count,9,10,"list.do","&keyword="+keyword);

		List<EveVO> list = null;
		if(count > 0) {
			map.put("start", page.getStartCount());
			map.put("end", page.getEndCount());
			list = eveService.selectList(map);
		}

		ModelAndView mav = new ModelAndView();
		mav.setViewName("eveList");
		mav.addObject("count", count);
		mav.addObject("list",list);
		mav.addObject("pagingHtml",page.getPagingHtml());

		return mav;
	}

	//====상품  상세======//
	@RequestMapping("/eve/detail.do")
	public ModelAndView detail(@RequestParam int eve_num) {
		if(log.isDebugEnabled()) {
			log.debug("<<eve_num>> : " + eve_num);
		}

		EveVO eve = eveService.selectEve(eve_num);

		return new ModelAndView("eveView","eve",eve);

	}

	//=====상품 수정======//
	//수정 폼
	@RequestMapping(value="/eve/update.do",method=RequestMethod.GET)
	public String formUpdate(@RequestParam int eve_num,Model model) {
		EveVO eveVO = eveService.selectEve(eve_num);
		model.addAttribute("eveVO", eveVO);

		return "eveModify";
	}
	//수정 폼에서 전송된 데이터 처리
	@RequestMapping(value="/eve/update.do",method=RequestMethod.POST)
	public String submitUpdate(@Valid EveVO eveVO,
			BindingResult result,
			HttpServletRequest request) {
		//유효성 체크 결과 오류가 있으면 폼 호출
		if(result.hasErrors()) {
			return "eveModify";
		}

		//글 수정
		eveService.updateEve(eveVO);

		return "redirect:/eve/list.do";
	}

	//======상품 삭제========//
	@RequestMapping("/eve/delete.do")
	public String submitDelete(@RequestParam int eve_num) {
		//상품 삭제
		eveService.deleteEve(eve_num);

		return "redirect:/eve/list.do";
	}

	//이미지 출력
	@RequestMapping("/eve/imageView.do")
	public ModelAndView viewImage(@RequestParam int eve_num, @RequestParam int img_num) {
		EveVO eve = eveService.selectEve(eve_num);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("imageView");
		
		if(img_num == 1) {
			mav.addObject("imageFile",eve.getEve_uploadfile1());
			mav.addObject("filename", eve.getEve_filename1());
		}else if(img_num == 2) {
			mav.addObject("imageFile",eve.getEve_uploadfile2());
			mav.addObject("filename", eve.getEve_filename2());
		}else if(img_num == 3) {
			mav.addObject("imageFile",eve.getEve_uploadfile3());
			mav.addObject("filename", eve.getEve_filename3());
		}
		
		return mav;
	}

}
