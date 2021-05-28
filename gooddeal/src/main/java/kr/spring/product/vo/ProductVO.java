package kr.spring.product.vo;

import java.io.IOException;
import java.sql.Date;

import javax.validation.constraints.NotEmpty;

import org.springframework.web.multipart.MultipartFile;

public class ProductVO {
	private int pro_num;
	private int mem_num;
	@NotEmpty
	private String pro_title;
	private String pro_tag;
	private int pro_price;
	private String pro_content;
	private int pro_status;
	private Date pro_date;
	private int pro_buy;

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
	public Date getPro_date() {
		return pro_date;
	}
	public void setPro_date(Date pro_date) {
		this.pro_date = pro_date;
	}
	public int getPro_buy() {
		return pro_buy;
	}
	public void setPro_buy(int pro_buy) {
		this.pro_buy = pro_buy;
	}
	
	//업로드 파일 처리
//		public void setUpload(MultipartFile upload)throws IOException{
//			//MultipartFile -> byte[] 변환
//			setUploadfile(upload.getBytes());
//			//파일명 구하기
//			setFilename(upload.getOriginalFilename());
//		}
}
