package com.emc.xcelerators.community.stringutils;

public class Separator {

	private String	string;

	public Separator() {
	}

	public Separator(final String string) {
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
		return "Separator[" + string + "]";
	}

}
