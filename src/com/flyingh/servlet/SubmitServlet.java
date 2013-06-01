package com.flyingh.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SubmitServlet")
public class SubmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (isTokenValid(request)) {
			request.getSession().removeAttribute("token");
			request.setAttribute("info", request.getParameter("info"));
			System.out.println("success!");
			return;
		}
		System.out.println("don't submit repeatedly");
	}

	private boolean isTokenValid(HttpServletRequest request) {
		Object token = request.getSession().getAttribute("token");
		String tokenParameter = request.getParameter("token");
		return token != null && tokenParameter != null
				&& tokenParameter.equals(token.toString());
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
