package kr.spring.member.controller;

import java.util.HashMap;
import java.util.List;
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
import org.springframework.web.servlet.ModelAndView;


import kr.spring.member.service.MemberService;
import kr.spring.member.vo.MemberVO;
import kr.spring.util.AuthCheckException;
import kr.spring.util.PagingUtil;

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
	
	

	//=====회원 상세 정보=====//
	@RequestMapping("/member/myPage.do")
	public String process(HttpSession session, Model model) {
		Integer user_num = (Integer)session.getAttribute("user_num");
		
		MemberVO member = memberService.selectMember(user_num);
		
		model.addAttribute("member", member);
				
		return "memberView";
	}
	//이미지 출력
	@RequestMapping("/member/imageView.do")
	public ModelAndView viewImage(@RequestParam int mem_num) {
		MemberVO member = memberService.selectMember(mem_num);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("imageView");
		mav.addObject("imageFile",member.getMem_propick());
		mav.addObject("filename",member.getMem_filename());
	
		return mav;
	}
	
	
	//=====회원 정보 수정=====//
	//수정 폼
	@RequestMapping(value="/member/update.do",method=RequestMethod.GET)
	public String formUpdate(HttpSession session, Model model) {
		Integer user_num = (Integer)session.getAttribute("user_num");
		
		MemberVO memberVO = memberService.selectMember(user_num);
		
		model.addAttribute("memberVO", memberVO);
		
		return "memberModify";
	}
	//수정폼에서 전송된 데이터 처리
	@RequestMapping(value="/member/update.do",method=RequestMethod.POST)
	public String submitUpdate(@Valid MemberVO memberVO,
							   BindingResult result,
							   HttpSession session) {
		
		if(log.isDebugEnabled()) {
			log.debug("<<회원 정보 수정>> : " + memberVO);
		}
		
		//유효성 체크 결과 오류가 있으면 폼 호출
		if(result.hasErrors()) {
			return "memberModify";
		}
		
		//회원 번호 구하기
		Integer user_num = (Integer)session.getAttribute("user_num");
		memberVO.setMem_num(user_num);
		
		//회원 정보 수정
		memberService.updateMember(memberVO);
		
		return "redirect:/member/myPage.do";
	}
	
	

	//=====비밀번호 수정=====//
	//비밀번호 수정 폼
	@RequestMapping(value="/member/changePassword.do",method=RequestMethod.GET)
	public String formChangePassword() {
		return "memberChangePassword";
	}
	
	//비밀번호 수정 폼에서 전송된 데이터 처리
	@RequestMapping(value="/member/changePassword.do",method=RequestMethod.POST)
	public String submitChangePassword(@Valid MemberVO memberVO,
									   BindingResult result,
									   HttpSession session) {
		if(log.isDebugEnabled()) {
			log.debug("<<비밀번호 변경 처리>> : " + memberVO);
		}
		
		//유효성 체크 결과 오류가 있으면 폼 호출
		//now_passwd와 mem_password만 체크
		if(result.hasFieldErrors("now_password") || result.hasFieldErrors("mem_password")) {
			return formChangePassword();
		}
		
		//비밀번호 일치 여부 체크
		Integer user_num = (Integer)session.getAttribute("user_num");
		MemberVO member = memberService.selectMember(user_num);
		//폼에서 전송한 현재 비밀번호와 DB에서 받아온 현재 비밀번호 일치 여부 체크
		if(!member.getMem_password().equals(memberVO.getNow_password())) {
			//인증 실패시
			result.rejectValue("now_password", "invalidPassword");
			return formChangePassword();
		}
		
		//비밀번호 변경
		memberVO.setMem_num(user_num);
		memberService.updatePassword(memberVO);
		
		return "redirect:/member/myPage.do";
	}
	
	
	//=====회원 정보 삭제(회원 탈퇴)=====//
	//회원 정보 삭제 폼
	@RequestMapping(value="/member/delete.do",method=RequestMethod.GET)
	public String formDelete() {
		
		return "memberDelete";
	}
	//회원 정보 삭제를 위한 데이터 처리
	@RequestMapping(value="/member/delete.do",method=RequestMethod.POST)
	public String submitDelete(@Valid MemberVO memberVO,
							   BindingResult result,
							   HttpSession session) {
		if(log.isDebugEnabled()) {
			log.debug("<<회원 탈퇴>> : " + memberVO);
		}
		
		//유효성 체크 결과 오류가 있으면 폼을 호출
		//id와 password만 체크
		if(result.hasFieldErrors("mem_id") || result.hasFieldErrors("mem_password")) {
			return "memberDelete";
		}
		
		Integer user_num = (Integer)session.getAttribute("user_num");
		//아이디와 비밀번호 인증
		try {
			MemberVO member = memberService.selectMember(user_num);
			boolean check = false;
			
			if(member!=null && memberVO.getMem_id().equals(member.getMem_id())) {
				//비밀번호 일치 여부 체크
				check = member.isCheckedPassword(memberVO.getMem_password());
			}
			if(check) {
				//인증 성공, 회원 정보 삭제
				memberService.deleteMember(user_num);
				//로그아웃
				session.invalidate();
				
				return "redirect:/main/main.do";
			}else {
				//인증 실패
				throw new AuthCheckException();
			}
			
		}catch(AuthCheckException e) {
			result.reject("invalidIdOrPassword");
			return formDelete();
		}
		
		
	}
	
	
	//=====판매내역 목록=====//
	
}
