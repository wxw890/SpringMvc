package com.netsong7.member.repository;

import java.util.Date;

import com.netsong7.exception.IdPasswordNotMachingException;

public class Member {
	private Long id;
	private String email;
	private String password;
	private String name;
	private Date registerDate;
	public Member(){
		
	}
	public Member(String email, String password, String name, Date registerDate) {
		
		this.email = email;
		this.password = password;
		this.name = name;
		this.registerDate = registerDate;
	}
	
	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Date getRegisterDate() {
		return registerDate;
	}



	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}



	public void changePassword(String oldPassword, String newPassword){
		
		if(!password.equals(oldPassword))//패스워드 일치 확인
		{
			throw new IdPasswordNotMachingException();
		}
		this.password = newPassword;
	}
	
	public boolean matchPassword(String password){ //실제 패스워드가 맞는 지 검사
		return this.password.equals(password);
	}
	
	
}
