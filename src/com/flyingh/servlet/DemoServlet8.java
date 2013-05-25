package com.flyingh.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DemoServlet8")
public class DemoServlet8 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println(getInitParameter("name"));
		System.out.println("*************");
		Enumeration<String> initParameterNames = getInitParameterNames();
		while (initParameterNames.hasMoreElements()) {
			System.out.println(getInitParameter(initParameterNames
					.nextElement()));
		}
		System.out.println(getServletName());
		System.out.println(getServletContext().getServletContextName());
		System.out.println(getServletContext().getMajorVersion() + "-->"
				+ getServletContext().getMinorVersion());
		System.out.println(getServletContext().getRealPath("/"));
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
