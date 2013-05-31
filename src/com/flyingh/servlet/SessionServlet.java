package com.flyingh.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		System.out.println(session.getMaxInactiveInterval());
		Cookie cookie = new Cookie("JSESSIONID", session.getId());
		cookie.setPath(request.getContextPath());
		cookie.setMaxAge(30 * 60);
		response.addCookie(cookie);
		session.setAttribute("info", "Hello world!!!");
		response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/session.jsp"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		doGet(request, response);
	}

}
