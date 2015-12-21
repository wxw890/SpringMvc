package com.netsong7.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ListController{
	@RequestMapping("/list.board")
	public ModelAndView pageHandler(){
		return new ModelAndView("/WEB-INF/views/board/list.jsp");
	}
}
