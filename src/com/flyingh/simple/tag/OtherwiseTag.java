package com.flyingh.simple.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class OtherwiseTag extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		ChooseTag parent = (ChooseTag) getParent();
		if (!parent.isWhenDo()) {
			getJspBody().invoke(null);
		}
	}
}
