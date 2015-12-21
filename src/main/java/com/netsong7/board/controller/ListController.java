package com.netsong7.board.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.netsong7.board.service.BoardService;
//DB로부터 가져온값을 list에게 넘겨줘야한다.
//BoardServiceImpl를 
@Controller
public class ListController{
	private BoardService boardService;
	public void setBoardService(BoardService boardService) {//여기에 들어간다.
		this.boardService = boardService;
	}
	@RequestMapping("/list.board")
	public ModelAndView pageHandler(){
		ModelAndView mav = new ModelAndView("/WEB-INF/views/board/list.jsp");
		
		try {
		List list = boardService.getList();//getList()함수가 list 결과값을 가지고 온다.
	
	
		mav.addObject("list", list);
		//System.out.println("데이터 크기:"+list.size());
		}
		catch(Exception err){
			System.out.println("ListController:pageHandler():" + err);
		}
		return mav;
	}
	
	
}
