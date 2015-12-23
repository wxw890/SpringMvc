package com.netsong7.member.service;

import java.sql.SQLException;


import com.netsong7.member.repository.Member;

import mybatis.MemberManager;

public class MemberServiceImpl implements MemberService {

	public void write(Member dto) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("이름 값:"+dto.getName());
		MemberManager.write2(dto);
	}

}
