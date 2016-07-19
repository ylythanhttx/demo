package com_spring_core7_$32_resource_classpath;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

public class Test {

	public static void main(String[] args) throws IOException {

		@SuppressWarnings("resource")
		ApplicationContext  context = new ClassPathXmlApplicationContext(
				"classpath:**/spring732.xml");

        Resource resource = context.getResource("classpath:com/spring/core7/$32/resource/classpath/test.txt");
        File file = resource.getFile();
		Path path = Paths.get(file.getPath());
		Charset charset = StandardCharsets.UTF_8;
        String content = new String(Files.readAllBytes(path), charset);
        System.out.println(content);
	}

}
