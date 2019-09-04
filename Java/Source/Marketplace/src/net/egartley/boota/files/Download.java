package net.egartley.boota.files;

import java.io.*;
import java.net.*;
import java.nio.file.Files;

import net.egartley.boota.Utils;

public class Download {

	/*
	 * © 2015 Evan Gartley - All Rights Reserved
	 */
	
	URL[] urls;
	File[] files;

	public Download(String url, File file) {
		this.files = new File[] { file };
		try {
			this.urls = new URL[] { new URL(url) };
		} catch (MalformedURLException e) {
			Utils.handleException(e);
		}
	}

	public Download(String[] urls, File[] files) {
		this.urls = new URL[urls.length];
		for (int i = 0; i < urls.length; i++) {
			try {
				this.urls[i] = new URL(urls[i]);
			} catch (MalformedURLException e) {
				Utils.handleException(e);
			}
		}
		this.files = new File[files.length];
		for (int i = 0; i < files.length; i++) {
			this.files[i] = files[i];
		}
	}

	public void fetch() {
		InputStream stream = null;
		long startTime = System.currentTimeMillis();
		long connectionTime, downloadTime;
		for (int i = 0; i < files.length; i++) {
			try {
				HttpURLConnection connection = (HttpURLConnection) urls[i].openConnection();
				connection.connect();
				int rc = connection.getResponseCode();
				if (rc / 100 != 2) {
					Utils.handleError("Response for " + getFileName(i) + " was " + rc + "!");
					connection.disconnect();
					return;
				}
				connectionTime = System.currentTimeMillis() - startTime;
				int bytes = connection.getContentLength();
				if (bytes < 1) {
					Utils.handleError("Invaild content length " + getFileName(i) + "!");
					connection.disconnect();
					return;
				}
				stream = connection.getInputStream();
				Files.copy(stream, files[i].toPath());
				downloadTime = System.currentTimeMillis() - startTime;
				Utils.println(getFileName(i) + " of " + bytes + " bytes (totalTime=" + (connectionTime + downloadTime)
						+ ", exists=" + files[i].exists() + ")", Utils.DOWNLOAD);
				if (stream != null) {
					stream.close();
				}
			} catch (Exception e) {
				Utils.handleException(e);
			}
		}
	}

	public File getFile(int i) {
		return files[i];
	}

	public URL getDownloadURL(int i) {
		return urls[i];
	}

	public String getFileName(int i) {
		return files[i].getName();
	}

	public int getSize(int i) {
		return (int) files[i].length();
	}

}