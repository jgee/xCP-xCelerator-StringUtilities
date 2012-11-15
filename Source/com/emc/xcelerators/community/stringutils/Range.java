package com.emc.xcelerators.community.stringutils;

public class Range {

	private int	min;
	private int	max;

	public Range() {
	}

	public Range(final int min, final int max) {
		this.min = min;
		this.max = max;
	}

	public int getMax() {
		return max;
	}

	public int getMin() {
		return min;
	}

	public void setMax(final int max) {
		this.max = max;
	}

	public void setMin(final int min) {
		this.min = min;
	}

	@Override
	public String toString() {
		return "Range[" + min + " - " + max + "]";
	}

}
