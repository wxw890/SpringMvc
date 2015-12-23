package com.netsong7.board.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.netsong7.board.repository.BoardDto;
import com.netsong7.board.service.BoardService;
//write.jsp로 이동하는 작업, DB로 입력하는 작업, 즉, 두가지의 작업이 있으므로 메서드도 2개가 필요하다.
@Controller
public class WriteController {
	private BoardService boardService;
	
	public void setBoardService(BoardService boardService) {//여기에 들어간다.
		this.boardService = boardService;
	}
	//페이지 이동
	@RequestMapping(value="/write.board",  method=RequestMethod.GET)//GET방싱 이동, 예 href로 통해 이동
	public String pageHandler(){
		return "/board/write"; 
	}
	//구지 페이지 이동만하기때문에 modelanview를 쓸필요하는 없다. 데이터를 가지고 넘어가는 것이 아니기때문에...
	@RequestMapping(value="/write.board", method=RequestMethod.POST)//POST방식 이동, 예from로 통해 이동
	public String  submitted(@ModelAttribute BoardDto dto){//@ModelAttribute란
		//System.out.println("글 저장....");
		//System.out.println(dto.getB_title() +","+ dto.getB_content());
		try {
			boardService.write(dto);
		} catch (Exception err) {
			System.out.println("writeErrorMessage:"+ err);
		}
		return "redirect:list.board";//"/WEB-INF/views/board/list.jsp";//dB를 거치지 않고 가기때문에 입력한 결과값이 보지 않고 나온다. list.board는 액션
																		//이것을 해결하기위해 redirect:를 사용한다. 마치 클라이언트가 다시 서버에 요청한것 처럼...결과를 준다.
	}
	
}
