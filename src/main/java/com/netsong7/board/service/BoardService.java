package com.netsong7.board.service;

import java.sql.SQLException;
import java.util.List;

import com.netsong7.board.repository.BoardDto;
//인터페이스
public interface BoardService {
	//전체 글 가져오기
	public List getList() throws SQLException;
	
	//특정 글 가져오기(읽기 기능)
	public BoardDto findBySeq(int seq) throws SQLException;
	
	//글 저장하기
	public void write(BoardDto dto) throws SQLException;
	
	//글 수정하기
	public void update(BoardDto dto) throws SQLException;
	
	//글 삭제하기
	public void delete(int seq) throws SQLException;
}
