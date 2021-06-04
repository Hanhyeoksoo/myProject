package kr.spring.event.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import kr.spring.product.vo.ProductVO;
import kr.spring.util.PagingUtil;

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

		//진행중 이벤트 페이지
		@RequestMapping(value="/event/eventDo.do",method=RequestMethod.GET)
		public String eventdo() {
			return "eventDo";
		}
		


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
			eventVO.setMem_num((Integer)session.getAttribute("user_num"));
			//ip 셋팅
			eventVO.setIp(request.getRemoteAddr());
			//글쓰기
			eventService.insertBoard(eventVO);
			
			return "redirect:/event/eventCheck.do";
		}
		
		//=====게시판 글 목록=====//
		@RequestMapping("/event/eventCheck.do")
		public ModelAndView process(
		@RequestParam(value="pageNum",defaultValue="1") int currentPage) {
			
			//총 레코드 수
			int count = eventService.selectRowCount();
			
			if(log.isDebugEnabled()) {
				log.debug("<<pageNum>> : " + currentPage);
				log.debug("<<count>> : " + count);
			}
			
			//페이징 처리
			PagingUtil page = 
					new PagingUtil(currentPage,count,10,10,"eventCheck.do");
			
			List<EventVO> list = null;
			if(count > 0) {
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("start", page.getStartCount());
				map.put("end", page.getEndCount());
				list = eventService.selectList(map);
			}
			
			ModelAndView mav = new ModelAndView();
			mav.setViewName("eventList");
			mav.addObject("count", count);
			mav.addObject("list",list);
			mav.addObject("pagingHtml",page.getPagingHtml());
			
			return mav;
		}
		@RequestMapping("/event/detail.do")
		public ModelAndView detail(@RequestParam int eve_num) {
			EventVO board = eventService.selectBoard(eve_num);
									//뷰 이름			속성명	속성값
			return new ModelAndView("eventDoDetail","board",board);
		}
		
		
	}
