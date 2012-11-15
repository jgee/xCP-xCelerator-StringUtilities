package com.emc.xcelerators.community.stringutils;

public class Prefix {

	private String	string;

	public Prefix() {
	}

	public Prefix(final String string) {
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
		return "Prefix[" + string + "]";
	}

}
