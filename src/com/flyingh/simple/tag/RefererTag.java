package com.flyingh.simple.tag;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class RefererTag extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		PageContext pageContext = (PageContext) getJspContext();
		HttpServletRequest request = (HttpServletRequest) pageContext
				.getRequest();
		HttpServletResponse response = (HttpServletResponse) pageContext
				.getResponse();
		String referer = request.getHeader("Referer");
		boolean flag = referer == null
				|| !referer.startsWith("http://localhost:8080"
						+ request.getContextPath());
		if (flag) {
			response.setHeader("Refresh", "3;url=http://www.baidu.com");
			try {
				request.getRequestDispatcher("/referer.jsp").forward(request,
						response);
			} catch (ServletException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
