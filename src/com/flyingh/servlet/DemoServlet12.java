package com.flyingh.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DemoServlet12")
public class DemoServlet12 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		final String PATH = "/WEB-INF/classes/config.properties";
		System.out.println(new File(getServletContext().getRealPath(PATH))
				.getName());
		String path = getServletContext().getResource(PATH).getPath();
		System.out.println(getServletContext().getRealPath("/"));
		System.out.println(path);
		System.out.println(new File(path));
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
