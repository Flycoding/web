package com.flyingh.simple.tag;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class LangTag extends SimpleTagSupport {
	private String key;
	private String baseName;

	@Override
	public void doTag() throws JspException, IOException {
		PageContext pageContext = (PageContext) getJspContext();
		String lang = (String) pageContext.getSession().getAttribute("lang");
		Locale locale = isBlank(lang) ? pageContext.getRequest().getLocale()
				: new Locale(lang);
		ResourceBundle bundle = ResourceBundle.getBundle(baseName, locale);
		pageContext.getOut().write(bundle.getString(key));
	}

	private boolean isBlank(String lang) {
		return lang == null || lang.trim().isEmpty();
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setBaseName(String baseName) {
		this.baseName = baseName;
	}
}
