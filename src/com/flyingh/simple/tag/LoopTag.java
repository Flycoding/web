package com.flyingh.simple.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class LoopTag extends SimpleTagSupport {
	private int count;

	@Override
	public void doTag() throws JspException, IOException {
		for (int i = 0; i < count; i++) {
			getJspBody().invoke(null);
		}
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
