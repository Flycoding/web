package com.flyingh.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RefererServlet")
public class RefererServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String referer = request.getHeader("Referer");
		if (referer == null || !referer.startsWith(getPath(request))) {
			response.sendRedirect(request.getContextPath() + "/1.jsp");
		} else {
			request.getRequestDispatcher("/yf.jpg").forward(request, response);
		}
	}

	private String getPath(HttpServletRequest request) {
		StringBuilder sb = new StringBuilder();
		sb.append(request.getScheme()).append("://").append(request.getServerName()).append(":")
				.append(request.getServerPort()).append(request.getContextPath());
		return sb.toString();
	}

	@SuppressWarnings("unused")
	private void test(HttpServletRequest request) {
		System.out.println(request.getRequestURL());
		System.out.println(request.getRequestURI());
		System.out.println(request.getPathInfo());
		System.out.println(request.getPathTranslated());
		System.out.println(request.getLocalAddr());
		System.out.println(request.getServerName());
		System.out.println(request.getServerPort());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		doGet(request, response);
	}

}
