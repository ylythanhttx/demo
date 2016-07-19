package com_spring_core11_restclient;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class HomeController {

	@RequestMapping(value = "/getabc", method = { RequestMethod.GET,
			RequestMethod.POST })
	@ResponseBody
	public String getABC(String ab) {
		Object obj = this;
		System.out.println(obj instanceof HttpServlet);
		return ab + "c";
	}

	@RequestMapping(value = "/postabc", method = { RequestMethod.POST })
	@ResponseBody
	public String postABC(/* @RequestBody Map<String, String> ab, */
	HttpServletRequest request, HttpServletResponse response,
			HttpEntity<byte[]> bytes) throws IOException {

		// request.getInputStream().
		// byte[] bytess = file.getBytes();
		File file1 = new File("D:/test12");
		// Path path = Paths.get(file1.getPath());
		// Charset charset = StandardCharsets.UTF_8;
		Files.write(Paths.get(file1.getPath()), bytes.getBody());

		// byte[] bytes = new byte[]{123,34,97,98,34,58,34,97,98,34,125};
		// System.out.println(new String(bytes));
		return /* ab.get("ab") + */"c";
	}

	@RequestMapping(value = "/testconsumes", method = { RequestMethod.POST }, consumes = "application/json")
	@ResponseBody
	public void testConsumes() {

	}
	
	@ExceptionHandler(Exception.class)
	public void ex(Exception ex){
		System.out.println(ex.getMessage());
	}
}
