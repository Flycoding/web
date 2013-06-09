package com.flyingh.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class UpperTag extends BodyTagSupport {

	private static final long serialVersionUID = -1806959837409054816L;

	@Override
	public int doStartTag() throws JspException {
		return EVAL_BODY_BUFFERED;
	}

	@Override
	public int doEndTag() throws JspException {
		try {
			pageContext.getOut().print(bodyContent.getString().toUpperCase());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return super.doEndTag();
	}

}
