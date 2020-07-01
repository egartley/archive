package net.egartley.boota;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import net.egartley.boota.console.Console;
import net.egartley.boota.dialog.ErrorDialog;
import net.egartley.boota.files.Download;
import net.egartley.boota.files.FileManager;
import net.egartley.boota.files.Structure;
import net.egartley.boota.input.CellMouseListener;
import net.egartley.boota.object.OutputType;

public class Utils {

	/*
	 * © 2015 Evan Gartley - All Rights Reserved
	 */

	public static OutputType UPDATE, INFO, EXCEPTION, STACKTRACE, DOWNLOAD, STARTUP, APPLICATIONS, ERROR;
	public static boolean sslTrusted = false;
	
	public static void init() {
		UPDATE = new OutputType("UPDATE");
		INFO = new OutputType("INFO");
		EXCEPTION = new OutputType("EXCEPN");
		STACKTRACE = new OutputType("STACKTRACE");
		DOWNLOAD = new OutputType("DWNLD");
		STARTUP = new OutputType("STARTUP");
		APPLICATIONS = new OutputType("APPS");
		ERROR = new OutputType("ERR");
	}

	public static void println(String t, OutputType type) {
		String out = "[" + new SimpleDateFormat(StringManager.DATE_FORMAT).format(new Date()) + " " + type.getString()
				+ "]: " + t;
		System.out.println(out);
		Console.appendText(out);
	}

	public static void downloadDataFile() {
		FileManager.DATA_FILE.delete();
		Download download = new Download(StringManager.DATA_FILE_URL, FileManager.DATA_FILE);
		download.fetch();
	}

	public static void downloadAppsFile() {
		FileManager.APPS_FILE.delete();
		Download download = new Download(StringManager.APPS_FILE_URL, FileManager.APPS_FILE);
		
		download.fetch();
	}

	public static void downloadContentFiles() {
		cleanTempFolder();
		if (!sslTrusted) trustSSL();
		Download download = new Download(new String[] { StringManager.APPS_FILE_URL, StringManager.DATA_FILE_URL },
				new File[] { FileManager.APPS_FILE, FileManager.DATA_FILE });
		System.out.println(StringManager.APPS_FILE_URL);
		download.fetch();
	}

	public static void cleanTempFolder() {
		try {
			Structure.cleanDirectory(FileManager.TEMP_FOLDER, false);
		} catch (IOException e) {
			Utils.handleException(e);
		}
	}

	public static void handleException(Exception e) {
		println(e.getMessage(), EXCEPTION);
		for (int i = 0; i < e.getStackTrace().length; i++) {
			StackTraceElement element = e.getStackTrace()[i];
			if (element.getClassName().startsWith("net.egartley"))
				println(element.toString(), STACKTRACE);
		}
	}

	public static void handleError(String msg) {
		println(msg, ERROR);
	}

	public static void runInNewThread(Runnable todo) {
		Thread t = new Thread(todo);
		t.start();
	}

	public static boolean rootFolderExists(String name) {
		File egartDir = FileManager.EGARTLEY_FOLDER;
		File mrktDir = FileManager.MARKETPLACE_FOLDER;
		if (egartDir.exists()) {
			if (mrktDir.exists()) {
				File folder = new File(StringManager.MARKETPLACE_DIR + File.separator + name);
				if (folder.exists())
					return true;
				else
					return false;
			} else
				return false;
		} else
			return false;
	}

	public boolean isMousePressed() {
		return CellMouseListener.pressed;
	}

	public static boolean isConnectionActive() {
		try {
			HttpURLConnection connection = (HttpURLConnection) new URL(StringManager.SERVER_URL).openConnection();
			connection.setRequestMethod("HEAD");
			int responseCode = connection.getResponseCode();
			if (responseCode != 200) {
				// return false, not an active connection to egartley.net 
				handleError("Either the server(s) are down, or your Internet connection is not working!");
				return false;
			} else {
				// everything is fine
				println("Connection to " + StringManager.SERVER_URL + " is active", INFO);
				return true;
			}
		} catch (Exception e) {
			handleException(e);
		}
		return false;
	}

	public static void throwConnectionError() {
		ErrorDialog.createDialog(StringManager.SERVER_ERROR_DESC, "Connection Error");
	}

	public static void launchSelf() {
		final String javaBin = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
		File currentJar;
		try {
			currentJar = new File(Marketplace.class.getProtectionDomain().getCodeSource().getLocation().getPath());
			String path = currentJar.getParentFile().getPath();
			
			// java -jar Marketplace.jar
			final ArrayList<String> command = new ArrayList<String>();
			command.add(javaBin);
			command.add("-jar");
			command.add(path);

			final ProcessBuilder builder = new ProcessBuilder(command);
			builder.start();
		} catch (Exception e) {
			handleException(e);
		}
	}

	public static void launchExternalFile(File toLaunch) {
		final String javaBin = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
		try {
			// java -jar Marketplace.jar
			final ArrayList<String> command = new ArrayList<String>();
			command.add(javaBin);
			command.add("-jar");
			command.add(toLaunch.getPath());
			final ProcessBuilder builder = new ProcessBuilder(command);
			builder.start();
		} catch (Exception e) {
			handleException(e);
		}
	}

	public static void launchThisJar(String arg) {
		final String javaBin = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
		File currentJar;
		try {
			currentJar = new File(Marketplace.class.getProtectionDomain().getCodeSource().getLocation().toURI());

			// java -jar Marketplace.jar
			final ArrayList<String> command = new ArrayList<String>();
			command.add(javaBin);
			command.add("-jar");
			command.add(currentJar.getPath());
			command.add(arg);
			final ProcessBuilder builder = new ProcessBuilder(command);
			builder.start();
		} catch (Exception e) {
			handleException(e);
		}
	}

	public static void launchJar(File toLaunch, String arg) {
		final String javaBin = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
		try {
			// java -jar Marketplace.jar
			final ArrayList<String> command = new ArrayList<String>();
			command.add(javaBin);
			command.add("-jar");
			command.add(toLaunch.getPath());
			command.add(arg);
			final ProcessBuilder builder = new ProcessBuilder(command);
			builder.start();
		} catch (Exception e) {
			handleException(e);
		}
	}

	public static void trustSSL() {
		TrustManager[] trustAllCerts = new TrustManager[]{
		    new X509TrustManager() {
		        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
		            return null;
		        }
		        public void checkClientTrusted(
		            java.security.cert.X509Certificate[] certs, String authType) {
		        }
		        public void checkServerTrusted(
		            java.security.cert.X509Certificate[] certs, String authType) {
		        }
		    }
		};
		try {
		    SSLContext sc = SSLContext.getInstance("SSL");
		    sc.init(null, trustAllCerts, new java.security.SecureRandom());
		    HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		} catch (Exception e) {handleException(e);}
		sslTrusted = true;
	}
	
	public static String getSizeString(String inBytes) {
		double bytes = Double.parseDouble(inBytes);
		double result;
		int minKB = 1024;
		int minMB = 1046576;
		int minGB = 1073741824;
		String type;
		if (bytes < minKB) {
			// is bytes
			return inBytes + " bytes";
		} else if (bytes >= minKB && bytes < minMB) {
			// is kb
			result = bytes / minKB;
			type = "KB";
		} else if (bytes >= minMB && bytes < minGB) {
			// is mb
			result = bytes / minMB;
			type = "MB";
		} else if (bytes >= minGB) {
			// is gb
			result = bytes / minGB;
			type = "GB";
		} else {
			handleError("Bytes are one TB or larger! Returning OUT_OF_RANGE!");
			return "OUT_OF_RANGE";
		}
		double newResult = Math.round(result * 1000) / 1000.0;
		DecimalFormat oneDigit = new DecimalFormat(StringManager.DECIMAL_FORMAT);
		newResult = Double.valueOf(oneDigit.format(newResult));
		return newResult + " " + type;
	}

}