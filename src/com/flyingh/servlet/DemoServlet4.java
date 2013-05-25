package com.flyingh.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DemoServlet4")
public class DemoServlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int count;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.getOutputStream().write(String.valueOf(++count).getBytes());
		// response.setHeader("Refresh", "3");
		response.setHeader("Refresh", "3;url=http://www.baidu.com");
	}

}
