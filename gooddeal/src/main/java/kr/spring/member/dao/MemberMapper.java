package kr.spring.member.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.spring.member.vo.MemberVO;

public interface MemberMapper {
	//회원관리
	//회원번호 구하기
	@Select("SELECT member_seq.nextval FROM dual")
	public int selectMem_num();
	//회원 등록
	@Insert("INSERT INTO member (mem_num,mem_id) VALUES(#{mem_num},#{mem_id})")
	public void insertMember(MemberVO member);
	@Insert("INSERT INTO member_detail (mem_num,mem_name,mem_password,mem_propick,mem_filename,mem_credit,mem_phone,mem_email,mem_zipcode,mem_address1,mem_address2,mem_date) VALUES (#{mem_num},#{mem_name},#{mem_password},#{mem_propick},#{mem_filename},#{mem_credit},#{mem_phone},#{mem_email},#{mem_zipcode},#{mem_address1},#{mem_address2},SYSDATE)")
	public void insertMember_detail(MemberVO member);
	//아이디 중복 체크 및 로그인 체크
	@Select("SELECT m.mem_num,m.mem_id,m.mem_now,d.mem_password FROM member m LEFT OUTER JOIN member_detail d ON m.mem_num=d.mem_num WHERE m.mem_id=#{mem_id}")
	public MemberVO selectCheckMember(String mem_id);
	//회원 상세 정보
	@Select("SELECT * FROM sprmember m JOIN sprmember_detail d ON m.mem_num=d.mem_num WHERE m.mem_num=#{mem_num}")
	public MemberVO selectMember(Integer mem_num);
	//회원 정보 수정
	@Update("UPDATE sprmember_detail SET name=#{name},phone=#{phone},email=#{email},zipcode=#{zipcode},address1=#{address1},address2=#{address2},modify_date=SYSDATE WHERE mem_num=#{mem_num}")
	public void updateMember(MemberVO member);
	//비밀번호 수정
	@Update("UPDATE sprmember_detail SET passwd=#{passwd} WHERE mem_num=#{mem_num}")
	public void updatePassword(MemberVO member);
	//회원 탈퇴
	@Update("UPDATE sprmember SET auth=0 WHERE mem_num=#{mem_num}")
	public void deleteMember(Integer mem_num);
	@Delete("DELETE FROM sprmember_detail WHERE mem_num=#{mem_num}")
	public void deleteMember_detail(Integer mem_num);
}
