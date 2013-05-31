package com.flyingh.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flyingh.db.util.DB;
import com.flyingh.vo.Book;

@WebServlet("/BuyServlet")
public class BuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Book book = DB.get(Integer.valueOf(id));
		HttpSession session = request.getSession();
		List<Book> boughtBooks = (List<Book>) session.getAttribute("boughtBooks");
		if (boughtBooks == null) {
			session.setAttribute("boughtBooks", new ArrayList<Book>(Arrays.asList(book)));
		} else {
			boughtBooks.add(book);
		}
		response.sendRedirect(request.getContextPath()+"/bought.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		doGet(request, response);
	}

}
