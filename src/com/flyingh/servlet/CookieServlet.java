package com.flyingh.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().write("<h1>lastAccessTime:</h1>");
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("lastAccessTime".equals(cookie.getName())) {
					response.getWriter().write("<h1>" + cookie.getValue() + "</h1>");
				}
			}
		}
		response.getWriter().write("<a href='" + request.getContextPath() + "/ClearCookieServlet" + "'>Clear</a>");
		Cookie cookie = new Cookie("lastAccessTime", String.format("%1$tF %1$tT", new Date()));
		cookie.setMaxAge(24 * 3600);
		cookie.setPath(request.getContextPath());
		response.addCookie(cookie);

		Cookie sessionCookie = new Cookie("JSESSIONID", String.valueOf(request.getSession().getId()));
		cookie.setPath(request.getContextPath());
		sessionCookie.setMaxAge(24 * 3600);
		response.addCookie(sessionCookie);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		doGet(request, response);
	}

}
