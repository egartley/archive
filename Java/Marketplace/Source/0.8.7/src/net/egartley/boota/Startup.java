package net.egartley.boota;

import net.egartley.boota.files.FileManager;
import net.egartley.boota.settings.Settings;
import net.egartley.boota.task.CommonTask;
import net.egartley.boota.update.ThisBuild;
import net.egartley.boota.update.UpdateCore;

public class Startup {

	/*
	 * © 2015 Evan Gartley - All Rights Reserved
	 */

	private static long startTime;
	private static int meanStartTime = 5;

	public static void run() {
		Marketplace.showProgressBar();
		Marketplace.resetProgressValue();
		Marketplace.setProgressIndeterminate(false);
		Marketplace.setProgressString("Starting up...");
		startTime = System.currentTimeMillis();
		Utils.println("Starting build with ID \"" + ThisBuild.getURLDir() + "\"...", Utils.STARTUP);

		if (Settings.FETCH_CONTENT.getValue()) {
			// download content file
			Marketplace.setProgressString("Downloading content files...");
			Marketplace.setProgressValue(25);
			Utils.downloadContentFiles();
			if (!FileManager.APPS_FILE.exists() || !FileManager.DATA_FILE.exists()) {
				outputStartup();
				Marketplace.failedToLoadContent();
				return;
			}

			// refresh panes (eula and news)
			Marketplace.setProgressString("Refreshing panes...");
			Marketplace.setProgressValue(50);
			CommonTask.refreshPanes();
			Utils.println("Refreshed panes", Utils.STARTUP);

			// start AppFetcher
			Marketplace.setProgressString("Fetching apps...");
			Marketplace.setProgressValue(75);
			Marketplace.updateAppList();

			// check for updates
			Marketplace.setProgressString("Checking for updates...");
			Marketplace.setProgressValue(100);
			if (Settings.AUTO_UPDATE.getValue())
				UpdateCore.check(false);

			// delete data.json
			FileManager.DATA_FILE.delete();
		} else {
			Marketplace.failedToLoadContent();
		}

		// clean up home GUI
		Marketplace.hideProgressBar();

		outputStartup();

		if (UpdateCore.getDidUpdate())
			UpdateCore.completeUpdate();
	}

	private static void outputStartup() {
		String s = "";
		long now = System.currentTimeMillis();
		double dif = now - startTime;
		double timeTook = dif / 1000;
		if (timeTook <= meanStartTime) {
			s = "Startup took " + timeTook + " seconds";
		} else {
			s = "Startup took " + timeTook + " seconds (slow)!";
		}
		Utils.println(s, Utils.STARTUP);
	}

}
