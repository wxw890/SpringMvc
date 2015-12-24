package com.netsong7.member.service;

import java.sql.SQLException;

import com.netsong7.exception.IdPasswordNotMachingException;
import com.netsong7.member.repository.Member;

import mybatis.MemberManager;
//구현 클래스
public class MemberServiceImpl implements MemberService {
	//인증서비스를 할때 나중에 내가 인증서비스를 사용할거면 class, 나중에 인증서비스를 할필요가 없으면 여기에 따로 메서드를 만들면된다.
	public void write(Member dto) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("이름 값:"+dto.getName());
		MemberManager.write2(dto);
	}

	public Member selectByEmail(String email) {
		
		return MemberManager.selectByEmail(email); //주입된 이메일 값 전달
	}

	public Member authenticate(String email, String password) {// 다가져가는게 좋다.
		// TODO Auto-generated method stub
		Member dto = MemberManager.selectByEmail(email);//dto는 여기서 모든 정보를 가져오고 있다.
		
		if(dto == null){//입력한 email에 관한 정보가 DB에 없을 경우
			throw new IdPasswordNotMachingException(); //
		}
		
		if(!dto.matchPassword(password)){
			throw new IdPasswordNotMachingException();
		}
		
		return dto;
	}

}
