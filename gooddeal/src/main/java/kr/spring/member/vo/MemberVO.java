package kr.spring.member.vo;

import java.io.IOException;
import java.sql.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

public class MemberVO {

	private int mem_num;
	private int mem_credit;
	@Pattern(regexp="^[A-Za-z0-9]{4,12}$") //^는 시작 [A-Z]까지 [a-z]까지 [0-9]까지 +는 반복 가능 {}는 size $는 끝
	private String mem_id;
	private int mem_now;
	@NotEmpty
	private String mem_name;
	private byte[] mem_propick;
	private String mem_filename;
	@Pattern(regexp="^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[!@#$%])[A-Za-z0-9!@#$%]{6,15}$")
	private String mem_password;
	@Pattern(regexp="^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[!@#$%])[A-Za-z0-9!@#$%]{6,15}$")
	private String mem_password2;
	@NotEmpty
	private String mem_phone;
	@NotEmpty
	@Email
	private String mem_email;
	@Size(min=5,max=5)
	private String mem_zipcode;
	@NotEmpty
	private String mem_address1;
	@NotEmpty
	private String mem_address2;
	private Date mem_date;
	
	@Pattern(regexp="^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[!@#$%])[A-Za-z0-9!@#$%]{6,15}$")
	private String now_password;


	
	//업로드 파일 처리
	public void setUpload(MultipartFile upload)throws IOException{
		//MultipartFile -> byte[] 변환
		setMem_propick(upload.getBytes());
		//파일명 구하기
		setMem_filename(upload.getOriginalFilename());
	}

	//로그인 비밀번호 체크//
	public boolean isCheckedPassword(String user_password) {
		if(mem_now > 1 && mem_password.equals(user_password)) {
			return true;
		}
		return false;
	}
	


	public int getMem_num() {
		return mem_num;
	}


	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}


	public int getMem_credit() {
		return mem_credit;
	}


	public void setMem_credit(int mem_credit) {
		this.mem_credit = mem_credit;
	}


	public String getMem_id() {
		return mem_id;
	}


	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}


	public int getMem_now() {
		return mem_now;
	}


	public void setMem_now(int mem_now) {
		this.mem_now = mem_now;
	}


	public String getMem_name() {
		return mem_name;
	}


	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}


	public byte[] getMem_propick() {
		return mem_propick;
	}


	public void setMem_propick(byte[] mem_propick) {
		this.mem_propick = mem_propick;
	}


	public String getMem_filename() {
		return mem_filename;
	}


	public void setMem_filename(String mem_filename) {
		this.mem_filename = mem_filename;
	}


	public String getMem_password() {
		return mem_password;
	}


	public void setMem_password(String mem_password) {
		this.mem_password = mem_password;
	}


	public String getMem_password2() {
		return mem_password2;
	}


	public void setMem_password2(String mem_password2) {
		this.mem_password2 = mem_password2;
	}


	public String getMem_phone() {
		return mem_phone;
	}


	public void setMem_phone(String mem_phone) {
		this.mem_phone = mem_phone;
	}


	public String getMem_email() {
		return mem_email;
	}


	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}


	public String getMem_zipcode() {
		return mem_zipcode;
	}


	public void setMem_zipcode(String mem_zipcode) {
		this.mem_zipcode = mem_zipcode;
	}


	public String getMem_address1() {
		return mem_address1;
	}


	public void setMem_address1(String mem_address1) {
		this.mem_address1 = mem_address1;
	}


	public String getMem_address2() {
		return mem_address2;
	}


	public void setMem_address2(String mem_address2) {
		this.mem_address2 = mem_address2;
	}


	public Date getMem_date() {
		return mem_date;
	}


	public void setMem_date(Date mem_date) {
		this.mem_date = mem_date;
	}

	public String getNow_password() {
		return now_password;
	}


	public void setNow_password(String now_password) {
		this.now_password = now_password;
	}


	@Override
	public String toString() {
		return "MemberVO [mem_num=" + mem_num + ", mem_credit=" + mem_credit + ", mem_id=" + mem_id + ", mem_now="
				+ mem_now + ", mem_name=" + mem_name + ", mem_password=" + mem_password + ", mem_password2="
				+ mem_password2 + ", mem_phone=" + mem_phone + ", mem_email=" + mem_email + ", mem_zipcode="
				+ mem_zipcode + ", mem_address1=" + mem_address1 + ", mem_address2=" + mem_address2 + ", mem_date="
				+ mem_date + ", modify_date=" + ", modify_passwd=" + now_password + "]";
	}





}
