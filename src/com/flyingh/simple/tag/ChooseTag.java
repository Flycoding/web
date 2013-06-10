package com.flyingh.simple.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ChooseTag extends SimpleTagSupport {
	private boolean isWhenDo;

	@Override
	public void doTag() throws JspException, IOException {
		getJspBody().invoke(null);
	}

	public boolean isWhenDo() {
		return isWhenDo;
	}

	public void setWhenDo(boolean isWhenDo) {
		this.isWhenDo = isWhenDo;
	}

}
