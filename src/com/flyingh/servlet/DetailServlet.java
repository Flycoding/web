package com.flyingh.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flyingh.db.util.DB;

@WebServlet("/DetailServlet")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		request.setAttribute("book", DB.get(Integer.valueOf(id)));

		appendHistoryCookie(request, response, id);
		request.getRequestDispatcher("/detail.jsp").forward(request, response);
	}

	private void appendHistoryCookie(HttpServletRequest request, HttpServletResponse response, String id) {
		Cookie[] cookies = request.getCookies();
		if (cookies == null) {
			return;
		}
		for (Cookie cookie : cookies) {
			if ("history".equals(cookie.getName())) {
				String value = cookie.getValue();
				if (!value.contains(id)) {
					addCookie(request, response, cookie, id + "-" + value);
				} else {
					if (value.contains("-")) {
						String[] strs = value.split("-");
						LinkedList<String> strsList = new LinkedList<>(Arrays.asList(strs));
						strsList.remove(id);
						strsList.addFirst(id);
						addCookie(request, response, cookie, join(strsList, "-"));
					} else {
						addCookie(request, response, cookie, id);
					}
				}
				return;
			}
		}
		Cookie cookie = new Cookie("history", id);
		addCookie(request, response, cookie, id);
	}

	private String join(LinkedList<String> strsList, String separator) {
		if (separator == null) {
			throw new IllegalArgumentException("separator should not be null");
		} else if (strsList == null || strsList.isEmpty()) {
			throw new IllegalArgumentException("strsList should not be null or empty");
		}
		StringBuilder sb = new StringBuilder();
		for (String str : strsList) {
			sb.append(str).append(separator);
		}
		return sb.delete(sb.length() - separator.length(), sb.length()).toString();
	}

	private void addCookie(HttpServletRequest request, HttpServletResponse response, Cookie cookie, String value) {
		if (value.contains("-")) {
			String[] strs = value.split("-");
			if (strs.length > ListAllServlet.MAX_HISTORY_NUMBER) {
				value = value.substring(0, value.lastIndexOf("-"));
			}
		}
		cookie.setValue(value);
		cookie.setMaxAge(24 * 3600);
		cookie.setPath(request.getContextPath());
		response.addCookie(cookie);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		doGet(request, response);
	}

}
