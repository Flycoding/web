package com.flyingh.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DemoServlet11")
public class DemoServlet11 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		File file = new File("test/config.properties");
		File parentFile = file.getParentFile();
		if (!parentFile.exists()) {
			parentFile.mkdir();
		}
		file.createNewFile();
		System.out.println(file.getAbsolutePath());
		FileInputStream is = new FileInputStream(file);
		System.out.println(is);
		System.out.println("***********");
		System.out.println(new URL("http://www.baidu.com/hello.jsp?info=abc")
				.getPath() + "-->getPath");
		System.out.println(new URL("http://www.baidu.com/hello.jsp?info=abc")
				.getFile() + "-->getFile");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
