package com.flyingh.servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DemoServlet5")
public class DemoServlet5 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
//		response.setHeader("Content-Disposition", "attachment;filename=mm.jpg");

		InputStream is = getServletContext().getResourceAsStream("/yf2.jpg");
		int len = 0;
		byte[] b = new byte[1024];
		ServletOutputStream os = response.getOutputStream();
		while ((len = is.read(b)) != -1) {
			os.write(b, 0, len);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
