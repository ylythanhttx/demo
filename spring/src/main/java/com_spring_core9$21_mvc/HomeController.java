package com_spring_core9$21_mvc;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Controller
@SessionAttributes("testsessionattributes")
public class HomeController{

//	@Resource(name="testHttpRequest")
//	private TestHttpRequest testHttpRequest;
//	
//	@Resource(name="testHttpSession")
//	private TestHttpSession testHttpSession;
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private SessionLocaleResolver localeResolver;
	
	@ResponseBody
	@RequestMapping(value="/upload",method={RequestMethod.POST})
	public void handlUpLoad(@RequestParam("file") MultipartFile file) throws IOException{
		byte[] bytes = file.getBytes();
		System.out.println(file.getOriginalFilename());
		File file1 = new File("D:/t.png");
		Files.write(Paths.get(file1.getPath()), bytes);
				
	}
	
	@ModelAttribute
	public void modelAtributeMethod(Model model){

		model.addAttribute("modelAtributeMethod", "modelAtributeMethod");

	}
	
	@RequestMapping(value="/testmodelattribute")
	public String modelAtribute(@ModelAttribute("sv") Sv sv){
		

		System.out.println(sv.getName()); 
		return "home";
	}
	
	@RequestMapping(value="/testsessionattributes",method={RequestMethod.POST})
	public String testSessionAttributes(Model model,String testsessionattributes,HttpServletRequest request){
		

//		HttpSession session = request.getSession();
//		
//		if(session.getAttribute("1")==null){
//			List<Integer> list = new ArrayList<Integer>();
//			list.add(1);
//			session.setAttribute("1",list);
//		}else{
//			@SuppressWarnings("unchecked")
//			List<Integer> temp = (List<Integer>) session.getAttribute("1");
//			temp.add(temp.get(temp.size()-1)+1);
//			session.setAttribute("1", temp);
//			session.setAttribute(temp.get(temp.size()-1)+"", temp.get(temp.size()-1));
//		}
//		
		
		model.addAttribute("testsessionattributes", testsessionattributes); 
		return "redirect:/home";
	}
	
	@RequestMapping(value="/testi18n")
	public String changer(Locale locale,Model model){
		
		System.out.println(LocaleContextHolder.getTimeZone());
		model.addAttribute("testi18n", messageSource.getMessage("language", null, LocaleContextHolder.getLocale()));
		return "home";
	}
	
	@RequestMapping(value="/home" , method={RequestMethod.GET,RequestMethod.POST})
	public String getHome(){
		
		return "home";
	}
	
	@RequestMapping(value="/void" , method={RequestMethod.GET,RequestMethod.POST})
	public void testvoid(){
		
	}
	
	@RequestMapping(value="/int" , method={RequestMethod.GET,RequestMethod.POST})
	public int testint(){
		
	    return 1;
	}
	
	@RequestMapping(value="/map" , method={RequestMethod.GET,RequestMethod.POST})
	public Map<String, String> testmap(){
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("home", "demo");
	    return map;
	}
	
	@RequestMapping(value="/testgetparam" , method={RequestMethod.GET,RequestMethod.POST})
	public String testGetParama(String test, Model model){
		
		model.addAttribute("test", test);
	    return "home";
	}
	
	@RequestMapping(value="/testmatrix/{test}" , method={RequestMethod.GET,RequestMethod.POST})
	public String testMatrix(@MatrixVariable String a, Model model){
		

		System.out.println(a);
		return "home";
	}
	
	@RequestMapping(value="/testjson" , method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public String testjson(String test, Model model){
		
	    return test;
	}
	
	@RequestMapping(value="/testhttpsevlet" , method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public String testjson(HttpServletRequest request, HttpServletResponse response){
		
	    return request.getParameter("test");
	}
	
	@RequestMapping(value="/testpathvariable/{test}" , method={RequestMethod.GET,RequestMethod.POST})
	public String testPathVariable(@PathVariable String test){
		System.out.println(test);
	    return "home";
	}
	
	@ExceptionHandler(Exception.class)
	public String handleException(Exception ex){
		if(ex instanceof RuntimeException){
			System.out.println(ex.getMessage());
		}
		return "redirect:/home";
	}
	
	@RequestMapping(value="/testexception" , method={RequestMethod.GET,RequestMethod.POST})
	public String testexception(){

		throw new RuntimeException("/testexception");
	}
}
