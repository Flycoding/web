package com.flyingh.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class ViewIPTag extends TagSupport {

	private static final long serialVersionUID = 1L;

	@Override
	public int doStartTag() throws JspException {
		try {
			pageContext.getOut()
					.print(pageContext.getRequest().getRemoteAddr());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return super.doStartTag();
	}
}
