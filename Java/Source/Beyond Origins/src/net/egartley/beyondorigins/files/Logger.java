package net.egartley.beyondorigins.files;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import net.egartley.beyondorigins.main.Game;

public class Logger {

	public File log = new File(Game.mainDir + "\\logs\\session.txt");

	public Logger() {
		try {
			if (!log.exists()) {
				log.createNewFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void log(String text) {
		String date = new SimpleDateFormat("[MM-dd-yy ").format(Calendar
				.getInstance().getTime());
		String time = new SimpleDateFormat("HH:mm:ss] ").format(Calendar
				.getInstance().getTime());
		String stamp = date + time;
		try (PrintWriter out = new PrintWriter(new BufferedWriter(
				new FileWriter(log, true)))) {
			out.println(stamp + text);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
