package com_spring_core7_$5_resourceaware;

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
import org.springframework.core.io.ResourceLoader;

public class Test {

	public static void main(String[] args) throws IOException {

		ResourceLoader resourceLoader = ResourceL.getResourceL();
        Resource resource = resourceLoader.getResource("file:///D:/mvnsts/workspacecodenameone/spring-core/src/main/java/com/spring/core7/$5/resourceaware/spring75.xml");
        File file = resource.getFile();
		Path path = Paths.get(file.getPath());
		Charset charset = StandardCharsets.UTF_8;
        String content = new String(Files.readAllBytes(path), charset);
        System.out.println(content);
	}

}
