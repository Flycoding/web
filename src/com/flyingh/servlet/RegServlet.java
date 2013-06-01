package com.flyingh.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/RegServlet")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String codeParameter = request.getParameter("code");
		if (codeParameter == null) {
			response.sendRedirect(request.getContextPath() + "/reg.jsp");
			return;
		}
		HttpSession session = request.getSession(false);
		if (session == null) {
			response.sendRedirect(request.getContextPath() + "/reg.jsp");
			return;
		}
		if (!codeParameter.equalsIgnoreCase((String) session
				.getAttribute("validationCode"))) {
			request.setAttribute("error", "validate code is not valid!");
			request.getRequestDispatcher("/reg.jsp").forward(request, response);
			return;
		}
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("reg success:" + username + "-->" + password);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
