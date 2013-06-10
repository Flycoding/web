package com.flyingh.simple.tag;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ForEachTag extends SimpleTagSupport {
	private String var;
	private Object items;

	@Override
	public void doTag() throws JspException, IOException {
		if (items == null) {
			return;
		}
		Class<? extends Object> cls = items.getClass();
		JspContext jspContext = getJspContext();
		JspFragment jspBody = getJspBody();
		if (cls.isArray()) {
			for (int i = 0; i < Array.getLength(items); i++) {
				jspContext.setAttribute(var, Array.get(items, i));
				jspBody.invoke(null);
			}
		} else if (Collection.class.isAssignableFrom(cls)) {
			for (Object obj : (Collection<?>) items) {
				jspContext.setAttribute(var, obj);
				jspBody.invoke(null);
			}
		} else if (Enumeration.class.isAssignableFrom(cls)) {
			Enumeration<?> enumeration = (Enumeration<?>) items;
			while (enumeration.hasMoreElements()) {
				jspContext.setAttribute(var, enumeration.nextElement());
				jspBody.invoke(null);
			}
		} else if (Map.class.isAssignableFrom(cls)) {
			Map<?, ?> map = (Map<?, ?>) items;
			for (Map.Entry<?, ?> me : map.entrySet()) {
				jspContext.setAttribute(var, me);
				jspBody.invoke(null);
			}
		}
	}

	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}

	public Object getItems() {
		return items;
	}

	public void setItems(Object items) {
		this.items = items;
	}
}
