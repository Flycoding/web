package com.flyingh.servlet;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CalcServlet")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String firstNum = request.getParameter("firstNum");
		String operator = request.getParameter("operator");
		String secondNum = request.getParameter("secondNum");
		request.setAttribute("resultInfo", calc(firstNum, operator, secondNum));
		request.getRequestDispatcher("/calc.jsp").forward(request, response);

	}

	private Object calc(String firstNum, String operator, String secondNum) {
		String str = firstNum + operator + secondNum + "=";
		BigDecimal first = new BigDecimal(firstNum);
		BigDecimal second = new BigDecimal(secondNum);
		switch (operator) {
		case "+":
			return str += first.add(second);
		case "-":
			return str += first.subtract(second);
		case "*":
			return str += first.multiply(second);
		case "/":
			if (second.doubleValue() == 0) {
				return str += "/ by 0";
			}
			return str += first.divide(second, 3, BigDecimal.ROUND_HALF_UP);
		default:
			break;
		}
		return null;
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
