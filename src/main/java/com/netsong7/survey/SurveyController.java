package com.netsong7.survey;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SurveyController {
	@RequestMapping("/survy.form")
	public String form(){
		System.out.println("1실행되니??");
		return "surveyForm";
	}
	
	@RequestMapping(value="/survy.form", method=RequestMethod.POST)
	public ModelAndView submit(@ModelAttribute AnsweredData answ){
		ModelAndView mav = new ModelAndView("submitted");
		System.out.println("2실행되니??"+answ.getRes().getAge());
		mav.addObject("answ", answ);
		
		return mav;
	}
}
