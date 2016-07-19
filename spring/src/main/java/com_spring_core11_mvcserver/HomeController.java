package com_spring_core11_mvcserver;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;

@Controller
public class HomeController {

	
	@RequestMapping(value="/getabc", method={RequestMethod.GET,RequestMethod.POST})
	public String getABC(String ab){
		
		return ab+"c";
		
	}
}
