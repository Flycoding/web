package com.flyingh.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RefreshServlet")
public class RefreshServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int count;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Refresh", "1;url=http://www.baidu.com");
		request.getRequestDispatcher("/1.jsp").forward(request, response);
	}

	@SuppressWarnings("unused")
	private void test(HttpServletResponse response) throws IOException {
		response.setHeader("Refresh", "1;url=http://www.baidu.com");
		response.getWriter().write(String.valueOf(++count));
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
