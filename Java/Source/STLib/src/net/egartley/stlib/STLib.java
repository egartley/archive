package net.egartley.stlib;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 * If you are to use any part of this library, please include the license found
 * at http://egartley.net/files/stlib/license.txt/ in each class that uses any
 * method found in STLib.<br>
 * <em>For questions, comments or concerns, please email contact@egartley.net</em>
 * 
 * @author Evan Gartley
 * @version 1.0 internal
 */

public class STLib {

	/**
	 * Opens the system's default web browser with {@code url} as the URL.<br>
	 * Tested with Windows 7, 8.1 and 10.
	 * 
	 * @param url
	 *            Should include "http(s)" and "www" if applicable.
	 */
	public void launchURL(String url) {
		String cmd = "cmd.exe /c start " + url;
		try {
			Runtime.getRuntime().exec(cmd);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Runs {@code System.exit(0)} with no errors.
	 */
	public void systemExit() {
		System.exit(0);
	}

	/**
	 * Prints {@code t} to the console.
	 * 
	 * @param t
	 *            The text to print to console.
	 */
	public void cout(String t) {
		System.out.println(t);
	}

	/**
	 * Plays the given sound file at default volume.<br>
	 * <b>NOTE:</b> only tested with WAV files, but it should work with others.
	 * 
	 * @param path
	 *            The absolute/relative path to the audio file.
	 */
	public void playSound(String path) {
		try {
			InputStream inputStream = new FileInputStream(path);
			AudioStream audioStream = new AudioStream(inputStream);
			AudioPlayer.player.start(audioStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Rounds the {@code toRound} up to the nearest multiple, {@code multiple}
	 * 
	 * @param toRound
	 *            The number to round up.
	 * @param multiple
	 *            The mutliple in which to round up with.
	 * @return {@code toRound} if multiple equals zero, or if the result of
	 *         "{@code toRound} <b>modulus</b> {@code multiple}" is zero.
	 *         Otherwise, {@code toRound} is returned after being rounded.
	 */
	public int roundUp(int toRound, int multiple) {
		if (multiple == 0) {
			return toRound;
		}
		int remains = toRound % multiple;
		if (remains == 0) {
			return toRound;
		}
		return toRound + multiple - remains;
	}

}