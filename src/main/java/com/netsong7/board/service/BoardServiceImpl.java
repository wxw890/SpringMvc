package com.netsong7.board.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

import com.netsong7.board.repository.BoardDto;

//이곳이 DB관련 데이터를 수정, 삭제, 입력, 등의 기능을 하는 클래스이다.
public class BoardServiceImpl implements BoardService {
	private JdbcTemplate JdbcTemplate;
	
	

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {// 여기들어간다.
		JdbcTemplate = jdbcTemplate;
	}

	public List getList() throws SQLException {
		/*
		// TODO Auto-generated method stub
		List list = new ArrayList();
		list.add("aaaa");
		list.add("aaaaaaa");
		list.add("aaaaaaaaa");
		*/
		String sql = "select * from tblSpringBoard order by b_seq desc";//desc는 내림차순
		List<BoardDto> list = new ArrayList<BoardDto>();//<>는 제네릭스 표현방식 즉, list와 ArrayList 안에 담을수 있는 자료형은 BoardDto클래스 타입뿐이라는 뜻이다.
		
		
		RowMapper rowmap = new RowMapper(){//RowMapper는 ResultSet의 레코드와 객체를 매핑 시키는 역할

			public Object mapRow(ResultSet rs, int arg1) throws SQLException {//오버라이딩
				BoardDto dto = new BoardDto();
				dto.setB_content(rs.getString("b_content"));
				dto.setB_hitcount(rs.getInt("b_hitcount"));
				dto.setB_password(rs.getString("b_password"));
				dto.setB_regdate(rs.getString("b_regdate"));
				dto.setB_seq(rs.getInt("b_seq"));
				dto.setB_title(rs.getString("b_title"));
				dto.setB_writer(rs.getString("b_writer"));
				return dto;
			}
			
		};
		list = JdbcTemplate.query(sql, rowmap);//rowmap는 리스트 결과를 매핑한것
		return list;
	}

	public BoardDto findBySeq() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public void write(BoardDto dto) throws SQLException {
		// TODO Auto-generated method stub
		String sql="insert into tblSpringBoard(b_title, b_content, b_writer,"+
		"b_regdate, b_hitcount, b_password) values(?,?,?,now(),0,?)";
		//파라미터 넘기는 방법 : 
		//1, object[]로 넘기는 방법(쉽고 간단하며 사용하기 편하다. 하지만 파라미터 재사용 못함)  
		//2,preparestatementsetter라는 인터페이스를 사용(파리미터 재사용이 가능)
		
		//JdbcTemplate.update(sql, new WriteParams(dto));//PreparedStatementSetter을 사용할때
		Object[] values = new Object[]{dto.getB_title(), dto.getB_content(), dto.getB_writer(), dto.getB_password()};
		JdbcTemplate.update(sql, values);//Object[]를 사용할때
		
	}
	/*class WriteParams implements PreparedStatementSetter{ //파라미터를 처리하기 위해서 PreparedStatementSetter 인터페이스 사용(파라미터를 재활용하기위해서씀)
		private BoardDto dto;
		
		public WriteParams(BoardDto dto){
			this.dto = dto;
		}
		public void setValues(PreparedStatement pstmt) throws SQLException {//PreparedStatement로 데이터를 묶어줄수 있다.
			pstmt.setString(1, dto.getB_title());
			pstmt.setString(2, dto.getB_content());
			pstmt.setString(3, dto.getB_writer());
			pstmt.setString(4, dto.getB_password());
			
			
		}
		
	}*/

	public void update(BoardDto dto) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void delete(int seq) throws SQLException {
		// TODO Auto-generated method stub

	}

}
