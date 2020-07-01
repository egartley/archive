package net.egartley.bolauncher;

import java.io.*;
import java.net.*;

public class Downloader {

	/*
	 * Copyright (c) 2014 Evan Gartley - All rights reserved
	 * 
	 * Some methods in this class include code from the Apache Commons IO
	 * Library. See the EULA for more info.
	 */

	public Downloader() {

	}

	public static void copyFromURLToFile(String path, String url)
			throws MalformedURLException, IOException {
		/*
		 * Some code from Apache Commons IO Library
		 */
		File f = new File(path);
		if (!f.exists()) {
			URL source = new URL(url);
			InputStream input = source.openStream();
			copyInputStreamToFile(input, f);
			Main.println("Downloaded file '" + new File(path).getName()
					+ "' from the web");
		} else {
			Main.println("File '" + new File(path).getName()
					+ "' already exists, can't download");
		}
	}

	public static void copyInputStreamToFile(InputStream source,
			File destination) throws IOException {
		/*
		 * Code from Apache Commons IO Library
		 */
		try {
			FileOutputStream output = openOutputStream(destination);
			try {
				copy(source, output);
				output.close();
			} finally {
			}
		} finally {
			source.close();
		}
	}

	public static FileOutputStream openOutputStream(File file)
			throws IOException {
		/*
		 * Code from Apache Commons IO Library
		 */
		return openOutputStream(file, false);
	}

	public static FileOutputStream openOutputStream(File file, boolean append)
			throws IOException {
		/*
		 * Code from Apache Commons IO Library
		 */
		if (file.exists()) {
			if (file.isDirectory()) {
				throw new IOException("File '" + file
						+ "' exists but is a directory");
			}
			if (!file.canWrite()) {
				throw new IOException("File '" + file
						+ "' cannot be written to");
			}
		} else {
			File parent = file.getParentFile();
			if ((parent != null) && (!parent.mkdirs())
					&& (!parent.isDirectory())) {
				throw new IOException("Directory '" + parent
						+ "' could not be created");
			}
		}

		return new FileOutputStream(file, append);
	}

	public static FileInputStream openInputStream(File file) throws IOException {
		/*
		 * Code from Apache Commons IO Library
		 */
		if (file.exists()) {
			if (file.isDirectory()) {
				throw new IOException("File '" + file
						+ "' exists but is a directory");
			}
			if (!file.canRead()) {
				throw new IOException("File '" + file + "' cannot be read");
			}
		} else {

		}
		return new FileInputStream(file);
	}

	public static int copy(InputStream input, OutputStream output)
			throws IOException {
		/*
		 * Code from Apache Commons IO Library
		 */
		long count = copyLarge(input, output);
		if (count > 2147483647L) {
			return -1;
		}
		return (int) count;
	}

	public static long copyLarge(InputStream input, OutputStream output)
			throws IOException {
		/*
		 * Code from Apache Commons IO Library
		 */
		return copyLarge(input, output, new byte[4096]);
	}

	public static long copyLarge(InputStream input, OutputStream output,
			byte[] buffer) throws IOException {
		/*
		 * Code from Apache Commons IO Library
		 */
		long count = 0L;
		int n = 0;
		while (-1 != (n = input.read(buffer))) {
			output.write(buffer, 0, n);
			count += n;
		}
		return count;
	}

}
