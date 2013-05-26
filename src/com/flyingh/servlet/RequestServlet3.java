package com.flyingh.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RequestServlet3")
public class RequestServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(getServletContext().getRealPath("/"));
		System.out.println(getServletContext().getContextPath());
		response.sendRedirect(getServletContext().getContextPath() + "/1.jsp");
	}

	@SuppressWarnings("unused")
	private void test1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/1.jsp").forward(request, response);
	}

	@SuppressWarnings("unused")
	private void test3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/1.jsp").include(request, response);
		response.getWriter().write("this is the content!");
		request.getRequestDispatcher("/2.jsp").include(request, response);
	}

	@SuppressWarnings("unused")
	private void test2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/1.jsp").forward(request, response);
	}

	@SuppressWarnings("unused")
	private void test(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setDateHeader("Expires", -1);
		// response.getWriter().write("<h1>hello world</h1>");
		// response.getOutputStream().write("<h1>hello world</h1>".getBytes());
		request.getRequestDispatcher("/yf.jpg").forward(request, response);
		// request.getRequestDispatcher("/yf2.jpg").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		doGet(request, response);
	}

}
