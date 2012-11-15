package com.emc.xcelerators.community.stringutils;

public class Regex {

	private String	pattern;

	public Regex() {
	}

	public Regex(final String pattern) {
		this.pattern = pattern;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(final String pattern) {
		this.pattern = pattern;
	}

	@Override
	public String toString() {
		return "Regex[" + pattern + "]";
	}

}
