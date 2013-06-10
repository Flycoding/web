package com.flyingh.simple.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class WhenTag extends SimpleTagSupport {
	private boolean test;
	
	@Override
	public void doTag() throws JspException, IOException {
		ChooseTag parent = (ChooseTag) getParent();
		if(test&&!parent.isWhenDo()){
			parent.setWhenDo(true);
			getJspBody().invoke(null);
		}
	}

	public boolean isTest() {
		return test;
	}

	public void setTest(boolean test) {
		this.test = test;
	}
}
