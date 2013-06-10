package com.flyingh.simple.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.flyingh.simple.tag.util.Singleton;

public class IfTag2 extends SimpleTagSupport {
	private boolean test;
	private Singleton singleton = Singleton.singleton;

	@Override
	public void doTag() throws JspException, IOException {
		singleton.setFlag(test);
		if (test) {
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
