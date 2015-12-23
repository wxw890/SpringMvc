package com.netsong7.board.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.netsong7.board.repository.BoardDto;
import com.netsong7.board.service.BoardService;

@Controller
public class ReadController {
	private BoardService boardService;
	
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}

	@RequestMapping("/read.board")
	public ModelAndView PageMove(int b_seq) throws SQLException{//int b_seq는 @requestParameter를 이용한것
		ModelAndView mav = new ModelAndView("/board/read");
		BoardDto dto = boardService.findBySeq(b_seq);
		mav.addObject("dto",dto);
		return mav;
	}
}
