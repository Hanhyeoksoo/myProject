package kr.spring.event.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.cheat.vo.CheatVO;
import kr.spring.event.vo.EventVO;

@Controller
public class EventController {

	private Logger log = Logger.getLogger(this.getClass());
	
	@ModelAttribute
	public EventVO initCommand() {
		return new EventVO();
	}
	
	//목록
	@RequestMapping("/event/list.do")
	public ModelAndView process() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("eventList");
		return mav;
	}
	
	//게시글 상세
	/*@RequestMapping("/cheat/detail.do")
	public ModelAndView detail(@RequestParam int cheat_num) {
		if(log.isDebugEnabled()) {
			log.debug("<<cheat_num>> : " + cheat_num);
		}
		
		//조회수 증가
		cheatService.updateHit(board_num);
		
	}*/
	
	//글쓰기
	@RequestMapping(value="/event/write.do",method=RequestMethod.GET)
	public String form() {
		return "eventRegister";
	}
}
