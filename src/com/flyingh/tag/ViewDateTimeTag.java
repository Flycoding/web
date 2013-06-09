package com.flyingh.tag;

import java.io.IOException;
import java.util.GregorianCalendar;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class ViewDateTimeTag extends TagSupport {
	private static final long serialVersionUID = -4588572930198535097L;

	@Override
	public int doStartTag() throws JspException {
		try {
			pageContext.getOut().print(
					String.format("%1$tF %1$tT", new GregorianCalendar()));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return super.doStartTag();
	}
}
