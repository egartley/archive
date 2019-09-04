package net.egartley.boota.files;

import java.io.File;

import net.egartley.boota.StringManager;
import net.egartley.boota.object.LocalDataFile;

public class FileManager {

	/*
	 * © 2016 Evan Gartley - All Rights Reserved
	 */

	public static File DATA_FILE, APPS_FILE;
	public static LocalDataFile SETTINGS_FILE, UPDATE_CONFIG_FILE;
	public static File MARKETPLACE_FOLDER, TEMP_FOLDER, EGARTLEY_FOLDER;
	public static File UPDATE_FOLDER;

	public static void init() {
		// folders
		EGARTLEY_FOLDER = new File(StringManager.EGARTLEY_DIR);
		MARKETPLACE_FOLDER = new File(StringManager.MARKETPLACE_DIR);
		TEMP_FOLDER = new File(StringManager.TEMP_DIR);
		UPDATE_FOLDER = new File(StringManager.MARKETPLACE_DIR + File.separator + "update");

		// content files
		DATA_FILE = new File(StringManager.TEMP_DIR + File.separator + StringManager.DATA_FILE_NAME);
		APPS_FILE = new File(StringManager.TEMP_DIR + File.separator + StringManager.APPS_FILE_NAME);

		// local data files
		SETTINGS_FILE = new LocalDataFile(
				new File(StringManager.MARKETPLACE_DIR + File.separator + "data" + File.separator + "settings.json"));
		UPDATE_CONFIG_FILE = new LocalDataFile(
				new File(UPDATE_FOLDER.getAbsolutePath() + File.separator + StringManager.UPDATE_CONFIG_FILE_NAME));
	}

}