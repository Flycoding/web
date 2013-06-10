package com.flyingh.simple.tag;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class HtmlFilterTag extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		StringWriter out = new StringWriter();
		getJspBody().invoke(out);
		getJspContext().getOut().write(
				out.toString().replaceAll("&", "$amp;").replaceAll("<", "&lt;")
						.replaceAll(">", "&gt;").replaceAll("\"", "&quot;"));
	}
}
