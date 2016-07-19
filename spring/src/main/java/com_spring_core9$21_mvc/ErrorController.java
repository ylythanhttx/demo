package com_spring_core9$21_mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {

	@RequestMapping(value="/404")
	public String handle(HttpServletRequest request, Model model){
		
		model.addAttribute("error", request.getAttribute("javax.servlet.error.status_code"));
		return "404";
	}
}
