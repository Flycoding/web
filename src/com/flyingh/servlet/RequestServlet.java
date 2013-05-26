package com.flyingh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.flyingh.vo.User;

@WebServlet("/RequestServlet")
public class RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ServletInputStream is = request.getInputStream();
		int len = 0;
		byte[] buf = new byte[1024];
		while ((len = is.read(buf)) != -1) {
			System.out.println(new String(buf, 0, len));
		}
	}

	@SuppressWarnings("unused")
	private void test6(HttpServletRequest request) {
		Map<String, String[]> parameterMap = request.getParameterMap();
		for (Entry<String, String[]> me : parameterMap.entrySet()) {
			System.out.println(me.getKey() + ":");
			for (String str : me.getValue()) {
				System.out.println("\t" + str);
			}
		}
		User user = new User();
		try {
			BeanUtils.populate(user, parameterMap);
			System.out.println(user);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	private void test5(HttpServletRequest request) {
		Enumeration<String> parameterNames = request.getParameterNames();
		while (parameterNames.hasMoreElements()) {
			String parameterName = parameterNames.nextElement();
			System.out.println(parameterName + ":");
			String[] parameterValues = request
					.getParameterValues(parameterName);
			for (String parameterValue : parameterValues) {
				System.out.println(parameterValue);
			}
		}
	}

	@SuppressWarnings("unused")
	private void test4(HttpServletRequest request) {
		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String headerName = headerNames.nextElement();
			System.out.println(headerName + "--->"
					+ request.getHeader(headerName));
		}
	}

	@SuppressWarnings("unused")
	private void test3(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException, ServletException, IOException {
		System.out.println(request.getHeader("Accept-Encoding"));
		System.out.println(request.getDateHeader("Expires"));
		System.out.println(request.getAuthType());// null
		System.out.println(request.getCharacterEncoding());// null
		request.setCharacterEncoding("utf-8");
		request.getRequestDispatcher("/RequestServlet2").forward(request,
				response);
	}

	@SuppressWarnings("unused")
	private void test2(HttpServletRequest request) {
		System.out.println(request.getRequestURI());
		System.out.println(request.getRequestURL());
		System.out.println(request.getQueryString());
		System.out.println(request.getRemoteAddr());
		System.out.println(request.getRemoteHost());
		System.out.println(request.getRemotePort());
		System.out.println(request.getLocalAddr());
		System.out.println(request.getLocalName());
		System.out.println(request.getLocalPort());
		System.out.println(request.getLocale());
	}

	@SuppressWarnings("unused")
	private void test(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		PrintWriter writer = response.getWriter();
		System.out.println(request.getContextPath());
		writer.write(request.getMethod() + "<br/>" + request.getRemoteUser()
				+ "<br/>" + request.getRequestURI() + "<br/>"
				+ request.getRequestURL().toString());
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
