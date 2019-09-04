package net.egartley.beyondorigins.main;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import net.egartley.beyondorigins.files.Save;
import net.egartley.beyondorigins.files.WriteXML;

public class Profile3 {

	public static String name, backup_name, lastPlayed, made;
	public static File file = new File(Game.save3Path);
	public static int progress = 0;

	public static void save() throws IOException{
		if (!file.exists()) {
			Save.profileReset();
			made = new SimpleDateFormat("MM-dd-yyyy").format(Calendar
					.getInstance().getTime());
			lastPlayed = new SimpleDateFormat("MM-dd-yyyy").format(Calendar
					.getInstance().getTime());
		} else if (file.exists()) {
			file.delete();
			lastPlayed = new SimpleDateFormat("MM-dd-yyyy").format(Calendar
					.getInstance().getTime());
		}
		Save.dataSave();
		WriteXML.writeSaveFile(file.getAbsolutePath(), file, 3);
	}

}
