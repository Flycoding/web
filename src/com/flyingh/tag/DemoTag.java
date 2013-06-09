package com.flyingh.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class DemoTag extends TagSupport {
	private static final long serialVersionUID = 1L;
	private int count;

	@Override
	public int doStartTag() throws JspException {
		return EVAL_BODY_INCLUDE;
	}

	@Override
	public int doAfterBody() throws JspException {
		return ++count != 5 ? EVAL_BODY_AGAIN : SKIP_BODY;
	}
}
