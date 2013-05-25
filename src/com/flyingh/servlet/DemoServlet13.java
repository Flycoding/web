package com.flyingh.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DemoServlet13")
public class DemoServlet13 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("今天天气不错");
	}

	@SuppressWarnings("unused")
	private void test3(HttpServletResponse response) throws IOException,
			UnsupportedEncodingException {
		response.setContentType("text/html;charset=utf-8");
		response.getOutputStream().write("1".getBytes("utf-8"));
	}

	@SuppressWarnings("unused")
	private void test2(HttpServletResponse response) throws IOException,
			UnsupportedEncodingException {
		ServletOutputStream os = response.getOutputStream();
		response.setContentType("text/html");
		os.write("<meta http-equiv='Content-Type' Content='text/html;charset=utf-8'/>"
				.getBytes("utf-8"));
		os.write("心情好".getBytes("utf-8"));
	}

	@SuppressWarnings("unused")
	private void test(HttpServletResponse response) throws IOException {
		// response.setContentType("text/html;charset=utf-8");
		// System.out.println(Charset.defaultCharset().name());
		// response.getOutputStream().write("澶╂皵涓嶉敊鍟�.getBytes("UTF-8"));
		System.out.println(Charset.defaultCharset().name());
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("今天天气不错!");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
