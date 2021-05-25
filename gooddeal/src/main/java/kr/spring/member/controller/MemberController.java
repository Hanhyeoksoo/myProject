package kr.spring.member.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.annotation.Resource;
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
import org.springframework.web.bind.annotation.ResponseBody;

import kr.spring.member.service.MemberService;
import kr.spring.member.vo.MemberVO;
import kr.spring.util.AuthCheckException;

@Controller
public class MemberController {
	private Logger log = Logger.getLogger(this.getClass());
	
	//의존 관계 설정
	@Resource
	private MemberService memberService;
	
	//자바빈(VO) 초기화
	@ModelAttribute
	public MemberVO initCommand() {
		return new MemberVO();
	}
	
	//=======회원가입=======//
	//아이디 중복 체크
	@RequestMapping("/member/confirmId.do")
	@ResponseBody
	public Map<String,String> process(@RequestParam("mem_id") String mem_id){
		
		if(log.isDebugEnabled()) {
			log.debug("<<mem_id>> : " + mem_id);
		}
		
		Map<String,String> map = new HashMap<String,String>();
		
		MemberVO member = memberService.selectCheckMember(mem_id);
		if(member!=null) {
			//아이디 중복
			map.put("result", "idDuplicated");
		}else {
			if(!Pattern.matches("^[A-Za-z0-9+]{4,12}$", mem_id)) {
				//패턴 불일치
				map.put("result", "notMatchPattern");
			}else {
				//아이디 미중복
				map.put("result", "idNotFound");
			}
		}
		
		return map;
	}
	//회원 등록 폼 호출
	@RequestMapping(value="/member/registerUser.do",method=RequestMethod.GET)
	
	public String form() {
			// 뷰 이름(타일스 식별자)
		return "memberRegister";
	}
	//회원 등록 데이터 전송
	@RequestMapping(value="/member/registerUser.do",method=RequestMethod.POST)
	public String submit(@Valid MemberVO memberVO,
						 BindingResult result) {
		
		if(log.isDebugEnabled()) {
			log.debug("<<회원 가입>> : " + memberVO);
		}
		
		//유효성 체크 결과 오류가 있으면 폼을 호출
		if(result.hasErrors()) {
			return form();
		}
		
		//회원 가입
		memberService.insertMember(memberVO);
		
		return "redirect:/main/main.do";
	}
	
	//========회원 로그인========//
	//로그인 폼 호출
	@RequestMapping(value="/member/login.do",method=RequestMethod.GET)
	public String formLogin() {
		return "memberLogin";
	}
	
	//로그인 폼에 전송된 데이터 처리
	@RequestMapping(value="/member/login.do",method=RequestMethod.POST)
	public String submitLogin(@Valid MemberVO memberVO,
							  BindingResult result,
							  HttpSession session) {
		
		if(log.isDebugEnabled()) {
			log.debug("<<회원 로그인>> : " + memberVO);
		}
		
		//유효성 체크 결과 오류가 있으면 폼 호출
		//id와 password 필드만 체크
		if(result.hasFieldErrors("mem_id") || result.hasFieldErrors("mem_password")) {
			return formLogin();
		}
		
		//로그인 체크(입력한 id와 비밀번호가 DB에 저장된 id와 비밀번호가 일치하는지 여부)
		try {
			MemberVO member = memberService.selectCheckMember(memberVO.getMem_id());
			if(log.isDebugEnabled()) {
				log.debug("<<DB 테이터>> : " + member);
			}
			boolean check = false;
			
			if(member!=null) {
				//비밀번호 일치 여부 체크
				check = member.isCheckedPassword(memberVO.getMem_password());
			}
			if(check) {//인증 성공, 로그인 처리
				//회원 번호 저장
				session.setAttribute("user_num", member.getMem_num());
				//회원 아이디 저장
				session.setAttribute("user_id", member.getMem_id());
				
				return "redirect:/main/main.do";
				
			}else {//인증 실패
				throw new AuthCheckException();
			}
		}catch(AuthCheckException e) {
			//에러 메시지 처리
			result.reject("invalidIdOrPassword");
			//인증 실패로 로그인 폼 호출
			return formLogin();
		}
		
		
	}
	
	//=====회원 로그아웃=====//
	@RequestMapping("/member/logout.do")
	public String processLogout(HttpSession session) {
		//로그아웃
		session.invalidate();
		
		
		return "redirect:/main/main.do";
	}
}
