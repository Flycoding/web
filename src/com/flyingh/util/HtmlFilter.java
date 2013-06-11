package com.flyingh.util;

public class HtmlFilter {
	public static String filter(String str) {
		if (str == null) {
			return null;
		}
		return str.replaceAll("&", "&amp;").replaceAll("<", "&lt;")
				.replaceAll(">", "&gt;").replaceAll("\"", "&quot;");
	}
}
