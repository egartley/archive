package net.egartley.boota.app;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import net.egartley.boota.Marketplace;
import net.egartley.boota.Utils;
import net.egartley.boota.files.FileManager;

public class AppFetcher {

	/*
	 * © 2015 Evan Gartley - All Rights Reserved
	 */

	static int n;
	private static ArrayList<Application> appList;

	public static void readAppData() {
		JSONObject outer = Marketplace.getJSONManager().getJSONObject(FileManager.APPS_FILE);
		JSONArray apps = (JSONArray) outer.get("apps");
		try {
			n = apps.size();
			appList = new ArrayList<Application>(n);
			for (int i = 0; i < n; i++) {
				appList.add(new Application((JSONObject) apps.get(i)));
			}
			Utils.println(n + " app(s) have been loaded", Utils.APPLICATIONS);
		} catch (Exception e) {
			Utils.handleException(e);
		}
	}

	public static int getNumberOfApps() {
		return n;
	}

	public static Application getApp(int i) {
		return appList.get(i);
	}

}
