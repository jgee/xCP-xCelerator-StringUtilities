package com.emc.xcelerators.community.stringutils;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.documentum.fc.client.DfSingleDocbaseModule;
import com.documentum.fc.common.DfException;

public class StringUtils extends DfSingleDocbaseModule {

	final private static ResourceBundle	RESOURCES	= ResourceBundle.getBundle(StringUtils.class.getCanonicalName());

	public void assertContains(final String value, final Substring substring) throws DfException {
		assertTrue(contains(value, substring), getString("assertContains", value, substring));
	}

	public void assertContains(final String[] values, final Substring substring) throws DfException {
		assertTrue(contains(values, substring), getString("assertContains", values, substring));
	}

	public void assertContains(final String[] values, final Substring[] substrings) throws DfException {
		assertTrue(contains(values, substrings), getString("assertContains", values, substrings));
	}

	public void assertEndsWith(final String value, final Substring suffix) throws DfException {
		assertTrue(endsWith(value, suffix), getString("assertContains", value, suffix));
	}

	public void assertEndsWith(final String[] value, final Substring suffix) throws DfException {
		assertTrue(endsWith(value, suffix), getString("assertEndsWith", value, suffix));
	}

	public void assertEndsWith(final String[] value, final Substring[] suffixes) throws DfException {
		assertTrue(endsWith(value, suffixes), getString("assertEndsWith", value, suffixes));
	}

	public void assertLengthWithin(final String value, final Range range) throws DfException {
		assertTrue(lengthWithin(value, range), getString("assertLengthWithin", value, range));
	}

	public void assertLengthWithin(final String[] values, final Range range) throws DfException {
		assertTrue(lengthWithin(values, range), getString("assertLengthWithin", values, range));
	}

	public void assertLengthWithin(final String[] values, final Range[] range) throws DfException {
		assertTrue(lengthWithin(values, range), getString("assertLengthWithin", values, range));
	}

	public void assertMatches(final String value, final Regex pattern) throws DfException {
		assertTrue(matches(value, pattern), getString("assertMatches", value, pattern));
	}

	public void assertMatches(final String[] value, final Regex pattern) throws DfException {
		assertTrue(matches(value, pattern), getString("assertMatches", value, pattern));
	}

	public void assertMatches(final String[] value, final Regex[] pattern) throws DfException {
		assertTrue(matches(value, pattern), getString("assertMatches", value, pattern));
	}

	public void assertStartsWith(final String value, final Substring prefix) throws DfException {
		assertTrue(startsWith(value, prefix), getString("assertStartsWith", value, prefix));
	}

	
	public void assertStartsWith(final String[] value, final Substring prefix) throws DfException {
		assertTrue(startsWith(value, prefix), getString("assertStartsWith", value, prefix));
	}

	
	public void assertStartsWith(final String[] value, final Substring[] prefixes) throws DfException {
		assertTrue(startsWith(value, prefixes), getString("assertStartsWith", value, prefixes));
	}

	private void assertTrue(final boolean value, final String msg) throws DfException {
		if (!value) {
			throw new DfException(msg);
		}
	}

	private void assertTrue(final boolean[] values, final String msg) throws DfException {
		for (final boolean value : values) {
			assertTrue(value, msg);
		}
	}

	
	public boolean contains(final String value, final Substring substring) {
		return value.contains(substring.getString());
	}

	
	public boolean[] contains(final String[] values, final Substring substring) {
		final boolean[] result = new boolean[values.length];
		for (int i = 0; i < values.length; ++i) {
			result[i] = contains(values[i], substring);
		}
		return result;
	}

	
	public boolean[] contains(final String[] values, final Substring[] substring) {
		final boolean[] result = new boolean[values.length];
		for (int i = 0; i < values.length; ++i) {
			result[i] = contains(values[i], substring[i]);
		}
		return result;
	}

	
	public boolean containsAll(final String[] values, final Substring substring) {
		for (int i = 0; i < values.length; ++i) {
			if (!contains(values[i], substring)) {
				return false;
			}
		}
		return true;
	}

	
	public boolean containsAll(final String[] values, final Substring[] substring) {
		for (int i = 0; i < values.length; ++i) {
			if (!contains(values[i], substring[i])) {
				return false;
			}
		}
		return true;
	}

	
	public boolean endsWith(final String value, final Substring suffix) {
		return value.endsWith(suffix.getString());
	}

	
	public boolean[] endsWith(final String values[], final Substring suffix) {
		final boolean[] result = new boolean[values.length];
		for (int i = 0; i < values.length; ++i) {
			result[i] = endsWith(values[i], suffix);
		}
		return result;
	}

	
	public boolean[] endsWith(final String values[], final Substring[] suffix) {
		final boolean[] result = new boolean[values.length];
		for (int i = 0; i < values.length; ++i) {
			result[i] = endsWith(values[i], suffix[i]);
		}
		return result;
	}

	
	public boolean endsWithAll(final String[] values, final Substring suffix) {
		for (int i = 0; i < values.length; ++i) {
			if (!endsWith(values[i], suffix)) {
				return false;
			}
		}
		return true;
	}

	
	public boolean endsWithAll(final String[] values, final Substring[] suffix) {
		for (int i = 0; i < values.length; ++i) {
			if (!endsWith(values[i], suffix[i])) {
				return false;
			}
		}
		return true;
	}

	
	public String format(final String msgFormat, final String[] arguments) {
		final MessageFormat format = new MessageFormat(msgFormat);
		final String result = format.format(arguments);
		return result;
	}

	private String getString(final String key, final Object... arguments) {
		final String template = RESOURCES.getString(key);
		final MessageFormat format = new MessageFormat(template);
		return format.format(arguments);
	}

	
	public int length(final String value) {
		return value.length();
	}

	
	public int[] length(final String[] values) {
		final int[] result = new int[values.length];
		for (int i = 0; i < values.length; ++i) {
			result[i] = values[i].length();
		}
		return result;
	}

	
	public boolean lengthWithin(final String value, final Range range) {
		final int length = length(value);
		return length > range.getMin() && length < range.getMax();
	}

	
	public boolean[] lengthWithin(final String[] values, final Range range) {
		final boolean[] result = new boolean[values.length];
		for (int i = 0; i < values.length; ++i) {
			result[i] = lengthWithin(values[i], range);
		}
		return result;
	}

	
	public boolean[] lengthWithin(final String[] values, final Range[] range) {
		final boolean[] result = new boolean[values.length];
		for (int i = 0; i < values.length; ++i) {
			result[i] = lengthWithin(values[i], range[i]);
		}
		return result;
	}

	
	public boolean lengthWithinAll(final String[] values, final Range range) {
		for (final String value : values) {
			if (!lengthWithin(value, range)) {
				return false;
			}
		}
		return true;
	}

	
	public boolean lengthWithinAll(final String[] value, final Range[] range) {
		for (int i = 0; i < value.length; ++i) {
			if (!lengthWithin(value[i], range[i])) {
				return false;
			}
		}
		return true;
	}

	
	public boolean matches(final String value, final Regex patternDefinition) {
		final Pattern pattern = Pattern.compile(patternDefinition.getPattern());
		final Matcher m = pattern.matcher(value);
		return m.matches();
	}

	
	public boolean[] matches(final String[] values, final Regex pattern) {
		final boolean[] result = new boolean[values.length];
		for (int i = 0; i < values.length; ++i) {
			result[i] = matches(values[i], pattern);
		}
		return result;
	}

	
	public boolean[] matches(final String[] values, final Regex[] pattern) {
		final boolean[] result = new boolean[values.length];
		for (int i = 0; i < values.length; ++i) {
			result[i] = matches(values[i], pattern[i]);
		}
		return result;
	}

	
	public boolean matchesAll(final String[] values, final Regex pattern) {
		for (int i = 0; i < values.length; ++i) {
			if (!matches(values[i], pattern)) {
				return false;
			}
		}
		return true;
	}

	
	public boolean matchesAll(final String[] values, final Regex[] pattern) {
		for (int i = 0; i < values.length; ++i) {
			if (!matches(values[i], pattern[i])) {
				return false;
			}
		}
		return true;
	}

	
	public String merge(final String[] values, final Prefix before, final Suffix after, final Separator separator) {
		final StringBuilder result = new StringBuilder();
		boolean first = true;
		result.append(before.getString());
		for (final String value : values) {
			if (first) {
				first = false;
			} else {
				result.append(separator.getString());
			}
			result.append(value);
		}
		result.append(after.getString());
		return result.toString();
	}

	
	public String[] split(final String value, final Regex patternDefinition) {
		return value.split(patternDefinition.getPattern());
	}

	
	public String[] split(final String value, final Substring splitOn) {
		return value.split(Pattern.quote(splitOn.getString()));
	}

	
	public String splitAndGetFirst(final String value, final Regex pattern) {
		final String[] values = split(value, pattern);
		final int length = values.length;
		final int index = 0;
		if (length > 0) {
			return values[index];
		} else {
			throw new RuntimeException("No occurrence found.");
		}
	}

	
	public String[] splitAndGetFirst(final String[] value, final Regex pattern) {
		final String[] result = new String[value.length];
		for (int i = 0; i < result.length; ++i) {
			result[i] = splitAndGetFirst(value[i], pattern);
		}
		return result;

	}

	
	public String[] splitAndGetFirst(final String[] value, final Regex[] pattern) {
		final String[] result = new String[value.length];
		for (int i = 0; i < result.length; ++i) {
			result[i] = splitAndGetFirst(value[i], pattern[i]);
		}
		return result;
	}

	
	public String splitAndGetLast(final String value, final Regex pattern) {
		final String[] values = split(value, pattern);
		final int length = values.length;
		final int index = length - 1;
		if (index > 0) {
			return values[index];
		} else {
			throw new RuntimeException("No occurrence found.");
		}
	}

	
	public String[] splitAndGetLast(final String[] value, final Regex pattern) {
		final String[] result = new String[value.length];
		for (int i = 0; i < result.length; ++i) {
			result[i] = splitAndGetLast(value[i], pattern);
		}
		return result;
	}

	
	public String[] splitAndGetLast(final String[] value, final Regex[] pattern) {
		final String[] result = new String[value.length];
		for (int i = 0; i < result.length; ++i) {
			result[i] = splitAndGetLast(value[i], pattern[i]);
		}
		return result;
	}

	
	public boolean startsWith(final String value, final Substring prefix) {
		return value.startsWith(prefix.getString());
	}

	
	public boolean[] startsWith(final String[] values, final Substring prefix) {
		final boolean[] result = new boolean[values.length];
		for (int i = 0; i < values.length; ++i) {
			result[i] = startsWith(values[i], prefix);
		}
		return result;
	}

	
	public boolean[] startsWith(final String[] values, final Substring[] prefix) {
		final boolean[] result = new boolean[values.length];
		for (int i = 0; i < values.length; ++i) {
			result[i] = startsWith(values[i], prefix[i]);
		}
		return result;
	}

	
	public boolean startsWithAll(final String[] values, final Substring prefix) {
		for (int i = 0; i < values.length; ++i) {
			if (!startsWith(values[i], prefix)) {
				return false;
			}
		}
		return true;
	}

	
	public boolean startsWithAll(final String[] values, final Substring[] prefix) {
		for (int i = 0; i < values.length; ++i) {
			if (!startsWith(values[i], prefix[i])) {
				return false;
			}
		}
		return true;
	}

	
	public String substring(final String value, final int index, final int length) {
		return value.substring(index, index + length);
	}

	
	public String substring(final String value, final Regex pattern) {
		return substring(value, pattern, 1);
	}

	
	public String substring(final String value, final Regex patternDefinition, final int group) {
		final Pattern pattern = Pattern.compile(patternDefinition.getPattern());
		final Matcher m = pattern.matcher(value);
		if (m.matches()) {
			return m.group(group);
		}
		return null;
	}

	
	public String[] substring(final String[] values, final int index, final int length) {
		for (int i = 0; i < values.length; ++i) {
			values[i] = values[i].substring(index, index + length);
		}
		return values;
	}

	
	public String[] substring(final String[] value, final Regex[] patternDefinition) {
		final int[] groups = new int[patternDefinition.length];
		Arrays.fill(groups, 1);
		return substring(value, patternDefinition, groups);
	}

	
	public String[] substring(final String[] values, final Regex[] patternDefinition, final int[] group) {
		final String[] result = new String[values.length];
		for (int i = 0; i < values.length; ++i) {
			result[i] = substring(values[i], patternDefinition[i], group[i]);
		}
		return result;
	}

	
	public String trim(final String value) {
		return value.trim();
	}

	
	public String[] trim(final String[] values) {
		for (int i = 0; i < values.length; ++i) {
			values[i] = values[i].trim();
		}
		return values;
	}

}
