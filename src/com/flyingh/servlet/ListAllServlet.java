package com.flyingh.servlet;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flyingh.db.util.DB;
import com.flyingh.vo.Book;

@WebServlet("/ListAllServlet")
public class ListAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int MAX_HISTORY_NUMBER = 3;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("books", DB.getAll());
		request.setAttribute("history", getHistory(request));
		request.getRequestDispatcher("/listAll.jsp").forward(request, response);
	}

	private Object getHistory(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (cookies == null) {
			return null;
		}
		for (Cookie cookie : cookies) {
			if ("history".equals(cookie.getName())) {
				String value = cookie.getValue();
				if (value == null || value.length() == 0) {
					return null;
				}
				Map<Integer, Book> historyBooks = new LinkedHashMap<>();
				if (!value.contains("-")) {
					Integer id = Integer.valueOf(value);
					historyBooks.put(id, DB.get(id));
					return historyBooks;
				}
				String[] strs = value.split("-");
				for (int i = 0, len = Math.min(strs.length, MAX_HISTORY_NUMBER); i < len; ++i) {
					Integer id = Integer.valueOf(strs[i]);
					historyBooks.put(id, DB.get(id));
				}
				return historyBooks;
			}
		}
		return null;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		doGet(request, response);
	}

}
