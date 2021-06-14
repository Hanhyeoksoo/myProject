package kr.spring.eve.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.spring.eve.service.EveService;
import kr.spring.eve.vo.EveReplyVO;
import kr.spring.util.PagingUtil;

@Controller
public class EveAjaxController {
	private Logger log = Logger.getLogger(this.getClass());
	private int rowCount = 10;
	private int pageCount = 10;

	@Resource
	private EveService eveService;

	//댓글 등록
	@RequestMapping("/eve/writeReply.do")
	@ResponseBody
	public Map<String,String> writeReply(
			EveReplyVO eveReplyVO,
			HttpSession session,
			HttpServletRequest request){

		if(log.isDebugEnabled()) {
			log.debug("<<EveReplyVO>> : " + 
					eveReplyVO);
		}

		Map<String,String> map = 
				new HashMap<String,String>();
		
		Integer user_num = 
				(Integer)session.getAttribute("user_num");
		if(user_num==null) {
			//로그인 안 됨
			map.put("result", "logout");
		}else {
			//댓글 등록
			eveService.insertReply(eveReplyVO);
			map.put("result", "success");
		}

		return map;
	}
	//댓글 목록
	@RequestMapping("/eve/listReply.do")
	@ResponseBody
	public Map<String,Object> getList(
			@RequestParam(value="pageNum",defaultValue="1")
			int currentPage,
			@RequestParam("eve_num") int eve_num,
			HttpSession session){
		//(******주의)댓글 좋아요 처리시만 HttpSession 넣을 것
		if(log.isDebugEnabled()) {
			log.debug("<<currentPage>> : " + currentPage);
			log.debug("<<eve_num>> : " + eve_num);
		}

		Map<String,Object> map = 
				new HashMap<String,Object>();
		map.put("eve_num", eve_num);

		//총 글의 갯수
		int count = eveService.selectRowCountReply(map);

		PagingUtil page = new PagingUtil(currentPage,count,
				rowCount,pageCount,null);
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		//(***주의)댓글 좋아요 처리할 경우만
		map.put("eve_num", eve_num);
		
		Integer user_num = 
				(Integer)session.getAttribute("user_num");
		if(user_num!=null) {
			map.put("mem_num", user_num);
		}else {
			map.put("mem_num", 0); 
		}
		List<EveReplyVO> list = null;
		if(count > 0) {
			list = eveService.selectListReply(map);
		}else {
			list = Collections.emptyList();
		}

		Map<String,Object> mapJson = 
				new HashMap<String,Object>();
		mapJson.put("count", count);
		mapJson.put("rowCount", rowCount);
		mapJson.put("list", list);

		return mapJson;
	}
	//댓글 삭제
	@RequestMapping("/eve/deleteReply.do")
	@ResponseBody
	public Map<String,String> deleteReply(
			@RequestParam("rep_num") int rep_num,
			@RequestParam("mem_num") int mem_num,
			HttpSession session){
   
		if(log.isDebugEnabled()) {
			log.debug("<<rep_num>> : " + rep_num);
			log.debug("<<mem_num>> : " + mem_num);
		}

		Map<String,String> map = 
				new HashMap<String,String>();

		Integer user_num = 
				(Integer)session.getAttribute("user_num");
		if(user_num==null) {
			//로그인이 되어있지 않음
			map.put("result", "logout");
		}else if(user_num!=null && user_num==mem_num) {
			//로그인 되어 있고 로그인한 아이디와 작성자 아이디 일치
			eveService.deleteReply(rep_num);
			map.put("result", "success");
		}else {
			//로그인 아이디와 작성자 아이디 불일치
			map.put("result", "wrongAccess");
		}		
		return map;
	}
	//댓글 수정
	@RequestMapping("/eve/updateReply.do")
	@ResponseBody
	public Map<String,String> modifyReply(
			EveReplyVO eveReplyVO,
			HttpSession session,
			HttpServletRequest request){

		if(log.isDebugEnabled()) {
			log.debug("<<EveReplyVO>> : " + 
					eveReplyVO);
		}

		Map<String,String> map = 
				new HashMap<String,String>();

		Integer user_num = 
				(Integer)session.getAttribute("user_num");
		if(user_num==null) {
			//로그인이 안 되어있는 경우
			map.put("result", "logout");
		}else if(user_num!=null && user_num==eveReplyVO.getMem_num()){
			//로그인 회원 번호와 작성자 회원번호 일치

			//댓글 수정
			eveService.updateReply(eveReplyVO);
			map.put("result", "success");
		}else {
			//로그인 아이디와 작성자 아이디 불일치
			map.put("result", "wrongAccess");
		}

		return map;
	}
}












