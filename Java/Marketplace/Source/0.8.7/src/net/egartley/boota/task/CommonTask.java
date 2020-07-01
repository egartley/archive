package net.egartley.boota.task;

import net.egartley.boota.Marketplace;
import net.egartley.boota.StringManager;
import net.egartley.boota.Utils;

public class CommonTask {

	/*
	 * © 2015 Evan Gartley - All Rights Reserved
	 */
	
	public static void checkConnection(boolean throwError) {
		if (!Utils.isConnectionActive() && throwError) {
			Utils.throwConnectionError();
		}
	}
	
	public static void refreshPanes() {
		Marketplace.updateEULA();
		Marketplace.updateNews();
	}
	
	public static void reset() {
		Marketplace.restart(StringManager.ARG_RESET);
	}
	
	public static void refreshContent() {
		Utils.downloadContentFiles();
		refreshPanes();
		Marketplace.updateAppList();
		Utils.cleanTempFolder();
	}
	
}