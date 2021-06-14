package kr.spring.eve.vo;

import kr.spring.util.DurationFromNow;

public class EveReplyVO {
	private int rep_num;
	private String rep_content;
	private String rep_date;
	private int eve_num;
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
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	@Override
	public String toString() {
		return "EveReplyVO [rep_num=" + rep_num + ", rep_content=" + rep_content + ", rep_date=" + rep_date
				+ ", eve_num=" + eve_num + ", mem_num=" + mem_num + ", mem_id=" + mem_id + "]";
	}
	
}
