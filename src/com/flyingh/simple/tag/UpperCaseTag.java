package com.flyingh.simple.tag;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class UpperCaseTag extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		StringWriter writer = new StringWriter();
		getJspBody().invoke(writer);
		getJspContext().getOut().write(writer.toString().toUpperCase());
	}
}
