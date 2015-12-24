package com.netsong7.member.service;

import java.sql.SQLException;

import com.netsong7.board.repository.BoardDto;
import com.netsong7.member.repository.Member;

public interface MemberService {

		//글 저장하기
		public void write(Member dto) throws SQLException;//회원가입 입력
		

		public Member selectByEmail(String email);//같은 이메일인지 검증
		
		public Member authenticate(String email, String password);//로그인 인증
			
		
}
