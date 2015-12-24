package com.netsong7.member.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import com.netsong7.exception.IdPasswordNotMachingException;
import com.netsong7.member.repository.LoginCommand;
import com.netsong7.member.repository.Member;
import com.netsong7.member.service.MemberService;

//로그인 컨트롤러
@Controller
public class LoginController {
	private MemberService memberService;
	
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@RequestMapping("/login.member")   
	public String form(LoginCommand loginCommand, @CookieValue(value="remember", required=false) Cookie cook){ //로그인 페이지 이동, 매개변수 LoginCommand를 선언한 이유는 email, password, rememberemail을 전달 받기 위해서이다...
						//Spring에서는 밑에 LoginCommand loginCommand과 지금 LoginCommand loginCommand은 같은 객체로 처리해준다.
						//@CookieValue(value="remember", required=false) Cookie cook이란 우선 밑에 쿠키 값을 읽어오는 역할을하는 annotation이다., required=false필수로 ,
		
		if(cook != null){
			loginCommand.setEmail(cook.getValue());
		}
		
		return "login"; //bundleview사용 -->사용방법: bundleview.properties에 경로 및 사용할 이름을 적는다.(view-config.xml에 BundleViewResolver를 설정했다고 가정하에... )
	}
	
	@RequestMapping(value="/login.member", params={"command=submit"})//params={"command=submit"}이란 parame값을 통해 같은 요청에 대한 구분을 할수 있다.
	public String submit(LoginCommand loginCommand, HttpSession session, HttpServletResponse resp){ //로그인 페이지에서 입력된 값 수행
		try{															//HttpServletResponse는 사용자 쪽으로 넘겨줄려면
			Member result = memberService.authenticate(loginCommand.getEmail(), loginCommand.getPassword());//이메일,비번 인증
		
			if(result != null){ // 값이 null아닌경우
				session.setAttribute("name", result.getName()); //이름을 seesion에 저장 누가 로그인 성공했는지 이름을 출력하기위해서...
			}
		}
		catch(IdPasswordNotMachingException err){
			return "login";
		}
		
		//여기서 이메일을 쿠키에 저장할 한다.
		Cookie rememberCook= new Cookie("remember", loginCommand.getEmail()); //쿠키를 remember이름으로 저장
		if(loginCommand.isRememberEmail()){//loginCommand 즉, dto에 isRememberEmail()사용한다.
			rememberCook.setMaxAge(60*60*24*30);//쿠키는 어제까지 저장할찌 지정해줘야한다. 지정안하면 접속이 끊어지는 순간 값이 사라진다.
		}
		else{
			rememberCook.setMaxAge(0);
		}
		resp.addCookie(rememberCook);//사용자 페이지에 보내준다.
		return "loginSuccess";
	}
}
