package kr.spring.event.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.event.service.EventService;
import kr.spring.event.vo.EventVO;

@Controller
public class EventController {

	private Logger log = Logger.getLogger(this.getClass());
	
	//의존 관계 설정
	@Resource
	private EventService eventService;
	
	//자바빈(VO) 초기화
	@ModelAttribute("eventVO")
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

	
		//이벤트 체크 페이지 글등록
		@RequestMapping(value="/event/eventCheck.do",method=RequestMethod.GET)
		public String form() {
			return "eventCheck";
		}
		
		//전송된 데이터 처리
		@RequestMapping(value="/event/eventCheck.do",method=RequestMethod.POST)
		public String submit(@Valid EventVO eventVO,
				             BindingResult result,
				             HttpServletRequest request,
				             HttpSession session) {
			
			//유효성 체크 결과 오류가 있으면 폼 호출
			if(result.hasErrors()) {
				return "eventCheck";
			}
			
			//회원 번호 셋팅
			eventVO.setMem_num((Integer)session.getAttribute("eve_user"));
			//ip 셋팅
			eventVO.setIp(request.getRemoteAddr());
			//글쓰기
			eventService.insertBoard(eventVO);
			
			return "redirect:/event/eventCheck.do";
		}
		
		//====게시판 글 상세======//
		@RequestMapping("/event/eventCheckDetail.do")
		public ModelAndView detail(@RequestParam int eve_num) {
			if(log.isDebugEnabled()) {
				log.debug("<<eve_num>> : " + eve_num);
			}
			
			//해당 글의 조회수 증가
			eventService.updateHit(eve_num);
			
			EventVO board = eventService.selectBoard(eve_num);
			
			return new ModelAndView("evnetCheckDetail","event",board);
			
		}
	
	}
