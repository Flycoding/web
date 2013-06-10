package com.flyingh.simple.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.flyingh.simple.tag.util.Singleton;

public class ElseTag extends SimpleTagSupport {
	private Singleton singleton = Singleton.singleton;

	@Override
	public void doTag() throws JspException, IOException {
		if (!singleton.isFlag()) {
			getJspBody().invoke(null);
		}
	}
}
