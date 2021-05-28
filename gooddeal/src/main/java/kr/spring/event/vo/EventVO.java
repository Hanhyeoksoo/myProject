package kr.spring.event.vo;

import java.sql.Date;

import javax.validation.constraints.NotEmpty;

public class EventVO {
	@NotEmpty
	private int eve_num;
	@NotEmpty
    private int mem_num;
    @NotEmpty
    private String eve_title;
    @NotEmpty
    private String eve_content;
    @NotEmpty
    private String eve_user;
    @NotEmpty
    private String eve_start;
    @NotEmpty
    private String eve_end;
    @NotEmpty
    private Date eve_date;
    @NotEmpty
    private int eve_status;
    
    
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
	public String getEve_content() {
		return eve_content;
	}
	public void setEve_content(String eve_content) {
		this.eve_content = eve_content;
	}
	public String getEve_user() {
		return eve_user;
	}
	public void setEve_user(String eve_user) {
		this.eve_user = eve_user;
	}
	public String getEve_start() {
		return eve_start;
	}
	public void setEve_start(String eve_start) {
		this.eve_start = eve_start;
	}
	public String getEve_end() {
		return eve_end;
	}
	public void setEve_end(String eve_end) {
		this.eve_end = eve_end;
	}
	public Date getEve_date() {
		return eve_date;
	}
	public void setEve_date(Date eve_date) {
		this.eve_date = eve_date;
	}
	public int getEve_status() {
		return eve_status;
	}
	public void setEve_status(int eve_status) {
		this.eve_status = eve_status;
	}
	
	@Override
	public String toString() {
		return "EventVO [eve_num=" + eve_num + ", mem_num=" + mem_num + ", eve_title=" + eve_title + ", eve_content="
				+ eve_content + ", eve_user=" + eve_user + ", eve_start=" + eve_start + ", eve_end=" + eve_end
				+ ", eve_date=" + eve_date + ", eve_status=" + eve_status + "]";
	}
    
    
    
    
}
