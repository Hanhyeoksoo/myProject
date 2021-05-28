package kr.spring.member.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.member.dao.MemberMapper;
import kr.spring.member.vo.MemberVO;

@Service("memberService")
public class MemberService {
	@Resource
	private MemberMapper memberMapper;
	
	//회원 가입
	public void insertMember(MemberVO member) {
		//회원 번호를 생성해서 자바빈에 저장
		member.setMem_num(memberMapper.selectMem_num());
		memberMapper.insertMember(member);
		memberMapper.insertMember_detail(member);
	}
	
	//아이디 중복 체크 및 로그인 체크
	public MemberVO selectCheckMember(String mem_id) {
		return memberMapper.selectCheckMember(mem_id);
	}
	
	//회원 상세 정보
	public MemberVO selectMember(Integer mem_num) {
		return memberMapper.selectMember(mem_num);
	}
	
	//회원 정보 수정
	public void updateMember(MemberVO member) {
		memberMapper.updateMember(member);
	}
	
	//비밀번호 수정
	public void updatePassword(MemberVO member) {
		memberMapper.updatePassword(member);
	}
	
	//회원 탈퇴
	public void deleteMember(Integer mem_num) {
		memberMapper.deleteMember(mem_num);
		memberMapper.deleteMember_detail(mem_num);
	}
	
	
	//로우카운트
	public int selectRowCount() {
		return memberMapper.selectRowCount();
	}
	//판매 글 목록
	public List<MemberVO> selectList(Map<String,Object> map){
		return memberMapper.selectList(map);
	}
	

}
