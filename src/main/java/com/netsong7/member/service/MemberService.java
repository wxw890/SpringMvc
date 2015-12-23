package com.netsong7.member.service;

import java.sql.SQLException;

import com.netsong7.board.repository.BoardDto;
import com.netsong7.member.repository.Member;

public interface MemberService {

		//글 저장하기
		public void write(Member dto) throws SQLException;
}
