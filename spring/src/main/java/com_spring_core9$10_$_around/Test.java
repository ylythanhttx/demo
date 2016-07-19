package com_spring_core9$10_$_around;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	@SuppressWarnings({ "resource" })
	public static void main(String[] args) throws IOException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, ClassNotFoundException,
			NoSuchMethodException, SecurityException {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:**/spring10-5.xml");

		Y y = context.getBean("y", Y.class);
		System.out.println("by " + y.getX());
		X x = new X();
		System.out.println("bean y:" + x.getY());

		System.out.println(com_dtsc_helijobfair_main_server_utils_test.Test
				.test());
		// X x = (X) context.getBean("x");
		// X x = new X();
		// String temp = X.getBeanName();
		// String temp = X.getBeanName();
		// System.out.println(temp);

		// ProxyFactory proxyFactory = new ProxyFactory();
		// proxyFactory.setTargetClass(X.class);
		//
		// Map<String, String> obj = System.getenv();
		// String path = System.getProperty("user.dir");
		// Properties properties = System.getProperties();
		//
		// path = path
		// + "\\src\\main\\java\\com\\spring\\core9$10\\$\\around\\tenv.txt";
		// File file = FileUtils.createFileIfNotExists(path);
		// file.delete();
		// file = FileUtils.createFileIfNotExists(path);
		// String path1 = System.getProperty("user.dir")
		// + "\\src\\main\\java\\com\\spring\\core9$10\\$\\around\\p.txt";
		// File file1 = FileUtils.createFileIfNotExists(path1);
		// file1.delete();
		// file1 = FileUtils.createFileIfNotExists(path1);
		// FileOutputStream fileOutputStream = new FileOutputStream(file);
		// FileOutputStream fileOutputStream1 = new FileOutputStream(file1);
		// for (String str : obj.keySet()) {
		// byte[] data = (str + "=" + obj.get(str) + "\n")
		// .getBytes(StandardCharsets.UTF_8);
		// fileOutputStream.write(data, 0, data.length);
		// }
		//
		// for (Object str : properties.keySet()) {
		// byte[] data = (str + "=" + System.getProperty(str.toString()) + "\n")
		// .getBytes(StandardCharsets.UTF_8);
		// fileOutputStream1.write(data, 0, data.length);
		// }

		// Class<X> clazz = (Class<X>) proxyFactory.getTargetClass();
		// Method[] methods = clazz.getDeclaredMethods();
		// methods[1].invoke(null);
		// System.out.println(methods[0].getName());
		// System.setProperty(key, value)
	}

}
