package com.netsong7.board.controller;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
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
	//private Logger log = Logger.getLogger(this.getClass());//this.getClass()는 현재클래스의 주소, Log4J꺼로 사용해야한다.
	public void setBoardService(BoardService boardService) {//여기에 들어간다.
		this.boardService = boardService;
	}
	@RequestMapping("/list.board")
	public ModelAndView pageHandler(){
		//log.info("연습삼아 해보는 로그");
		ModelAndView mav = new ModelAndView("/board/list");
		
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
