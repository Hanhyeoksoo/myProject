package kr.spring.product.vo;

import kr.spring.util.DurationFromNow;

public class ProductReplyVO {
	private int rep_num;
	private String rep_content;
	private String rep_date;
	private int pro_num;
	private int mem_num;
	private String mem_id;
	public int getRep_num() {
		return rep_num;
	}
	public void setRep_num(int rep_num) {
		this.rep_num = rep_num;
	}
	public String getRep_content() {
		return rep_content;
	}
	public void setRep_content(String rep_content) {
		this.rep_content = rep_content;
	}
	public String getRep_date() {
		return rep_date;
	}
	public void setRep_date(String rep_date) {
		this.rep_date = rep_date;
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
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	@Override
	public String toString() {
		return "ProductReplyVO [rep_num=" + rep_num + ", rep_content=" + rep_content + ", rep_date=" + rep_date
				+ ", pro_num=" + pro_num + ", mem_num=" + mem_num + ", mem_id=" + mem_id + "]";
	}
}
