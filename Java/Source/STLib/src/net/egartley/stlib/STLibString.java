package net.egartley.stlib;

public class STLibString {

	/**
	 * Removes the {@code char}, or single character {@code String} located at
	 * <b>param</b> {@code index}.
	 * 
	 * @param s
	 *            The {@code String} in which to remove the unwanted
	 *            {@code char}
	 * @param index
	 *            The "location", or index of the unwanted char
	 * @return The given {@code String} with the char at <b>param</b>
	 *         {@code index} removed
	 */
	public String removeCharAt(String s, int index) {
		return s.substring(0, index) + s.substring(index + 1);
	}

	/**
	 * Converts <b>param</b> {@code i} into a {@code String}.
	 * 
	 * @param i
	 *            The int in which to convert
	 * 
	 * @return The String reprsentation of <b>param</b> {@code i}
	 */
	public String toString(int i) {
		return String.valueOf(i);
	}

	/**
	 * Converts <b>param</b> {@code i} into a {@code String}.
	 * 
	 * @param i
	 *            The double in which to convert.
	 * @return The String reprsentation of <b>param</b> {@code i}
	 */
	public String toString(double i) {
		return String.valueOf(i);
	}

	/**
	 * Converts <b>param</b> {@code i} into a {@code String}.
	 * 
	 * @param i
	 *            The short in which to convert
	 * @return The String reprsentation of <b>param</b> {@code i}
	 */
	public String toString(short i) {
		return String.valueOf(i);
	}

	/**
	 * Converts <b>param</b> {@code i} into a {@code String}.
	 * 
	 * @param i
	 *            The float in which to convert
	 * @return The String reprsentation of <b>param</b> {@code i}
	 */
	public String toString(float i) {
		return String.valueOf(i);
	}

	/**
	 * Converts <b>param</b> {@code i} into a {@code String}.
	 * 
	 * @param i
	 *            The byte in which to convert
	 * @return The String reprsentation of <b>param</b> {@code i}
	 */
	public String toString(byte i) {
		return String.valueOf(i);
	}

	/**
	 * Converts <b>param</b> {@code i} into a {@code String}.
	 * 
	 * @param i
	 *            The long in which to convert
	 * @return The String reprsentation of <b>param</b> {@code i}
	 */
	public String toString(long i) {
		return String.valueOf(i);
	}

	/**
	 * Converts <b>param</b> {@code i} into a {@code String}.
	 * 
	 * @param i
	 *            The char in which to convert
	 * @return The String reprsentation of <b>param</b> {@code i}
	 */
	public String toString(char i) {
		return String.valueOf(i);
	}

	/**
	 * Converts <b>param</b> {@code i} into a {@code String}..
	 * 
	 * @param i
	 *            The boolean in which to convert
	 * @return The String reprsentation of <b>param</b> {@code i}
	 */
	public String toString(boolean i) {
		return String.valueOf(i);
	}

}
