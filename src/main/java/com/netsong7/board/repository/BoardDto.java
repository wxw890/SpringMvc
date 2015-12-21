package com.netsong7.board.repository;
//dto
public class BoardDto {
	private int b_seq; 
    private String b_title; 
    private String b_content;
    private String b_writer;
    private String b_regdate; 
    private int b_hitcount;
    private String b_password;
    
    
	public int getB_seq() {
		return b_seq;
	}
	public void setB_seq(int b_seq) {
		this.b_seq = b_seq;
	}
	public String getB_title() {
		return b_title;
	}
	public void setB_title(String b_title) {
		this.b_title = b_title;
	}
	public String getB_content() {
		return b_content;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	public String getB_writer() {
		return b_writer;
	}
	public void setB_writer(String b_writer) {
		this.b_writer = b_writer;
	}
	public String getB_regdate() {
		return b_regdate;
	}
	public void setB_regdate(String b_regdate) {
		this.b_regdate = b_regdate;
	}
	public int getB_hitcount() {
		return b_hitcount;
	}
	public void setB_hitcount(int b_hitcount) {
		this.b_hitcount = b_hitcount;
	}
	public String getB_password() {
		return b_password;
	}
	public void setB_password(String b_password) {
		this.b_password = b_password;
	}
    
    
}
