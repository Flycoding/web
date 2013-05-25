package com.flyingh.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class A {
	public void fun(String str) {

	}
}

class B extends A {
	@Override
	public void fun(String str) throws IllegalArgumentException {
		super.fun(str);
	}
}

@WebServlet("/DemoServlet6")
public class DemoServlet6 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int count;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("DemoServlet6.init()");
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		synchronized (this) {
			// System.out.println(getServletContext().getRealPath("/"));
			++count;
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(count);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
