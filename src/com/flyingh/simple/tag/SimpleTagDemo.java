package com.flyingh.simple.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SimpleTagDemo extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		for (int i = 0; i < 5; i++) {
			getJspBody().invoke(getJspContext().getOut());
		}
	}
}
