package kr.spring.eve.vo;

import java.io.IOException;
import java.sql.Date;

import javax.validation.constraints.NotEmpty;

import org.springframework.web.multipart.MultipartFile;

import kr.spring.util.DurationFromNow;

public class EveVO {
	private int eve_num;
	private int mem_num;
	@NotEmpty
	private String eve_title;
	private String eve_tag;
	private int eve_price;
	private String eve_content;
	private int eve_status;
	private String eve_date;
	private int eve_buy;
	private byte[] eve_uploadfile1;
	private String eve_filename1;
	private byte[] eve_uploadfile2;
	private String eve_filename2;
	private byte[] eve_uploadfile3;
	private String eve_filename3;
	private String mem_id;

	
	//업로드 파일 처리
		public void setUpload1(MultipartFile upload1)throws IOException{
			//MultipartFile -> byte[] 변환
			setEve_uploadfile1(upload1.getBytes());
			//파일명 구하기
			setEve_filename1(upload1.getOriginalFilename());
		}
		public void setUpload2(MultipartFile upload2)throws IOException{
			//MultipartFile -> byte[] 변환
			setEve_uploadfile2(upload2.getBytes());
			//파일명 구하기
			setEve_filename2(upload2.getOriginalFilename());
		}
		public void setUpload3(MultipartFile upload3)throws IOException{
			//MultipartFile -> byte[] 변환
			setEve_uploadfile3(upload3.getBytes());
			//파일명 구하기
			setEve_filename3(upload3.getOriginalFilename());
		}

	
	public int getEve_num() {
		return eve_num;
	}
	public void setEve_num(int eve_num) {
		this.eve_num = eve_num;
	}
	public int getMem_num() {
		return mem_num;
	}
	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}
	public String getEve_title() {
		return eve_title;
	}
	public void setEve_title(String eve_title) {
		this.eve_title = eve_title;
	}
	public String getEve_tag() {
		return eve_tag;
	}
	public void setEve_tag(String eve_tag) {
		this.eve_tag = eve_tag;
	}
	public int getEve_price() {
		return eve_price;
	}
	public void setEve_price(int eve_price) {
		this.eve_price = eve_price;
	}
	public String getEve_content() {
		return eve_content;
	}
	public void setEve_content(String eve_content) {
		this.eve_content = eve_content;
	}
	public int getEve_status() {
		return eve_status;
	}
	public void setEve_status(int eve_status) {
		this.eve_status = eve_status;
	}
	public String getEve_date() {
		return eve_date;
	}
	public void setEve_date(String eve_date) {
		this.eve_date = eve_date;
	}
	public int getEve_buy() {
		return eve_buy;
	}
	public void setEve_buy(int eve_buy) {
		this.eve_buy = eve_buy;
	}
	public byte[] getEve_uploadfile1() {
		return eve_uploadfile1;
	}
	public void setEve_uploadfile1(byte[] eve_uploadfile1) {
		this.eve_uploadfile1 = eve_uploadfile1;
	}
	public String getEve_filename1() {
		return eve_filename1;
	}
	public void setEve_filename1(String eve_filename1) {
		this.eve_filename1 = eve_filename1;
	}
	public byte[] getEve_uploadfile2() {
		return eve_uploadfile2;
	}
	public void setEve_uploadfile2(byte[] eve_uploadfile2) {
		this.eve_uploadfile2 = eve_uploadfile2;
	}
	public String getEve_filename2() {
		return eve_filename2;
	}
	public void setEve_filename2(String eve_filename2) {
		this.eve_filename2 = eve_filename2;
	}
	public byte[] getEve_uploadfile3() {
		return eve_uploadfile3;
	}
	public void setEve_uploadfile3(byte[] eve_uploadfile3) {
		this.eve_uploadfile3 = eve_uploadfile3;
	}
	public String getEve_filename3() {
		return eve_filename3;
	}
	public void setEve_filename3(String eve_filename3) {
		this.eve_filename3 = eve_filename3;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	
	
	
	
}
