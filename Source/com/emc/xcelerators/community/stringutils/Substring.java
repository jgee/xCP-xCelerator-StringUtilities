package com.emc.xcelerators.community.stringutils;

public class Substring {

	private String	string;

	public Substring() {

	}

	public Substring(final String string) {
		this.string = string;
	}

	public String getString() {
		return string;
	}

	public void setString(final String string) {
		this.string = string;
	}

	@Override
	public String toString() {
		return "Substring[" + string + "]";
	}

}
