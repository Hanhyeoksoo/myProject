package kr.spring.cheat.vo;

import java.sql.Date;

import javax.validation.constraints.NotEmpty;
  
public class CheatVO {
    private int che_num;
    private int mem_num;
    @NotEmpty
    private String che_title;
    @NotEmpty
    private String che_content;
    private int che_pnum;
    private int che_view;
    private int che_admincheck;
    private Date che_date;
    private String mem_id;

    
	public int getChe_num() {
		return che_num;
	}
	public void setChe_num(int che_num) {
		this.che_num = che_num;
	}
	public int getMem_num() {
		return mem_num;
	}
	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}
	public String getChe_title() {
		return che_title;
	}
	public void setChe_title(String che_title) {
		this.che_title = che_title;
	}
	public String getChe_content() {
		return che_content;
	}
	public void setChe_content(String che_content) {
		this.che_content = che_content;
	}
	public int getChe_pnum() {
		return che_pnum;
	}
	public void setChe_pnum(int che_pnum) {
		this.che_pnum = che_pnum;
	}
	public int getChe_view() {
		return che_view;
	}
	public void setChe_view(int che_view) {
		this.che_view = che_view;
	}
	public int getChe_admincheck() {
		return che_admincheck;
	}
	public void setChe_admincheck(int che_admincheck) {
		this.che_admincheck = che_admincheck;
	}
	public Date getChe_date() {
		return che_date;
	}
	public void setChe_date(Date che_date) {
		this.che_date = che_date;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

};
