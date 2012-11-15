package com.emc.xcelerators.community.stringutils;

public class Suffix {

	private String	string;

	public Suffix() {
	}

	public Suffix(final String string) {
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
		return "Suffix[" + string + "]";
	}

}
