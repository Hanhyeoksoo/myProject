package kr.spring.product.vo;

import java.io.IOException;
import java.sql.Date;

import javax.validation.constraints.NotEmpty;

import org.springframework.web.multipart.MultipartFile;



public class ProductVO {
	@NotEmpty
	private int pro_num;
	@NotEmpty
	private int mem_num;
	@NotEmpty
	private String pro_title;
	@NotEmpty
	private String pro_tag;
	@NotEmpty
	private int pro_price;
	@NotEmpty
	private String pro_content;
	@NotEmpty
	private int pro_satus;
	private Date pro_date;
	@NotEmpty
	private int pro_buy;
	
	//업로드 파일 처리
//		public void setUpload(MultipartFile upload)throws IOException{
//			//MultipartFile -> byte[] 변환
//			setUploadfile(upload.getBytes());
//			//파일명 구하기
//			setFilename(upload.getOriginalFilename());
//		}
}
