package kr.spring.product.vo;

import java.io.IOException;
import java.sql.Date;

import javax.validation.constraints.NotEmpty;

import org.springframework.web.multipart.MultipartFile;

import kr.spring.util.DurationFromNow;

public class ProductVO {
	private int pro_num;
	private int mem_num;
	@NotEmpty
	private String pro_title;
	private String pro_tag;
	private int pro_price;
	private String pro_content;
	private int pro_status;
	private String pro_date;
	private int pro_buy;
	private byte[] pro_uploadfile1;
	private String pro_filename1;
	private byte[] pro_uploadfile2;
	private String pro_filename2;
	private byte[] pro_uploadfile3;
	private String pro_filename3;
	private String mem_id;

	//업로드 파일 처리
	public void setUpload1(MultipartFile upload1)throws IOException{
		//MultipartFile -> byte[] 변환
		setPro_uploadfile1(upload1.getBytes());
		//파일명 구하기
		setPro_filename1(upload1.getOriginalFilename());
	}
	public void setUpload2(MultipartFile upload2)throws IOException{
		//MultipartFile -> byte[] 변환
		setPro_uploadfile2(upload2.getBytes());
		//파일명 구하기
		setPro_filename2(upload2.getOriginalFilename());
	}
	public void setUpload3(MultipartFile upload3)throws IOException{
		//MultipartFile -> byte[] 변환
		setPro_uploadfile3(upload3.getBytes());
		//파일명 구하기
		setPro_filename3(upload3.getOriginalFilename());
	}

	public int getPro_num() {
		return pro_num;
	}
	public void setPro_num(int pro_num) {
		this.pro_num = pro_num;
	}
	public int getMem_num() {
		return mem_num;
	}
	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}
	public String getPro_title() {
		return pro_title;
	}
	public void setPro_title(String pro_title) {
		this.pro_title = pro_title;
	}
	public String getPro_tag() {
		return pro_tag;
	}
	public void setPro_tag(String pro_tag) {
		this.pro_tag = pro_tag;
	}
	public int getPro_price() {
		return pro_price;
	}
	public void setPro_price(int pro_price) {
		this.pro_price = pro_price;
	}
	public String getPro_content() {
		return pro_content;
	}
	public void setPro_content(String pro_content) {
		this.pro_content = pro_content;
	}
	public int getPro_status() {
		return pro_status;
	}
	public void setPro_status(int pro_status) {
		this.pro_status = pro_status;
	}
	
	public String getPro_date() {
		return pro_date;
	}
	public void setPro_date(String pro_date) {
		this.pro_date = DurationFromNow.getTimeDiffLabel(pro_date);
	}
	public int getPro_buy() {
		return pro_buy;
	}
	public void setPro_buy(int pro_buy) {
		this.pro_buy = pro_buy;
	}
	public byte[] getPro_uploadfile1() {
		return pro_uploadfile1;
	}
	public void setPro_uploadfile1(byte[] pro_uploadfile1) {
		this.pro_uploadfile1 = pro_uploadfile1;
	}
	public String getPro_filename1() {
		return pro_filename1;
	}
	public void setPro_filename1(String pro_filename1) {
		this.pro_filename1 = pro_filename1;
	}
	public byte[] getPro_uploadfile2() {
		return pro_uploadfile2;
	}
	public void setPro_uploadfile2(byte[] pro_uploadfile2) {
		this.pro_uploadfile2 = pro_uploadfile2;
	}
	public String getPro_filename2() {
		return pro_filename2;
	}
	public void setPro_filename2(String pro_filename2) {
		this.pro_filename2 = pro_filename2;
	}
	public byte[] getPro_uploadfile3() {
		return pro_uploadfile3;
	}
	public void setPro_uploadfile3(byte[] pro_uploadfile3) {
		this.pro_uploadfile3 = pro_uploadfile3;
	}
	public String getPro_filename3() {
		return pro_filename3;
	}
	public void setPro_filename3(String pro_filename3) {
		this.pro_filename3 = pro_filename3;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	
}
