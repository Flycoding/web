package com.flyingh.simple.tag.util;

public enum Singleton {
	singleton;
	private boolean flag;

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

}
