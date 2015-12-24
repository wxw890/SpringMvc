package com.netsong7.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {

	@RequestMapping("/logout.member")
	public String pageMove(){
		return "logout";
	}
}
