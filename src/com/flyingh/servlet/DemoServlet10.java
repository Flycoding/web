package com.flyingh.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DemoServlet10")
public class DemoServlet10 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		InputStream is = /*
						 * getClass().getClassLoader().getResourceAsStream(
						 * "config.properties")
						 */getServletContext().getResourceAsStream(
				"/WEB-INF/classes/config.properties");
		System.out.println(is);
		Properties properties = new Properties();
		properties.load(is);
		properties.list(System.out);
		System.out.println("***********************");
		for (String propertyName : properties.stringPropertyNames()) {
			System.out.println(properties.getProperty(propertyName));
		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
