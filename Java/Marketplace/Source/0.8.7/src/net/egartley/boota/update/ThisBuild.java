package net.egartley.boota.update;

import java.util.Calendar;

import org.json.simple.JSONObject;

import net.egartley.boota.Marketplace;
import net.egartley.boota.StringManager;
import net.egartley.boota.Utils;
import net.egartley.boota.object.BuildType;
import net.egartley.boota.object.BuildVersion;

public class ThisBuild {

	/*
	 * © 2015 Evan Gartley - All Rights Reserved
	 */

	private static BuildType TYPE;
	private static BuildVersion VERSION;
	private static String AUTHOR;
	public static String COPYRIGHT, URL_DIR;

	public static void init() {
		COPYRIGHT = "© " + Calendar.getInstance().get(Calendar.YEAR);
		try {
			JSONObject outer = Marketplace.getJSONManager().getBuildFileJSONObject();
			JSONObject buildVersion = (JSONObject) outer.get("BuildVersion");
			JSONObject buildType = (JSONObject) outer.get("BuildType");

			VERSION = new BuildVersion((double) buildVersion.get("double"), (String) buildVersion.get("string"));
			URL_DIR = (String) buildVersion.get("url-dir");
			String typeString = (String) buildType.get("string");
			if (typeString.equalsIgnoreCase(BuildType.STABLE.getString())) {
				TYPE = BuildType.STABLE;
			} else if (typeString.equalsIgnoreCase(BuildType.PRE_RELEASE.getString())) {
				TYPE = BuildType.PRE_RELEASE;
			} else {
				TYPE = null;
			}
			AUTHOR = (String) outer.get("author");
		} catch (Exception e) {
			Utils.handleException(e);
		}
		StringManager.THIS_BUILD_DIR_URL = getURLDir();
		StringManager.DATA_FILE_URL = StringManager.SERVER_URL + "files/marketplace/" + StringManager.THIS_BUILD_DIR_URL
				+ "/" + StringManager.DATA_FILE_NAME;
		StringManager.APPS_FILE_URL = StringManager.SERVER_URL + "files/marketplace/" + StringManager.THIS_BUILD_DIR_URL
				+ "/apps/" + StringManager.APPS_FILE_NAME;
	}

	public static BuildVersion getVersion() {
		return VERSION;
	}

	public static BuildType getType() {
		return TYPE;
	}

	public static String getAuthor() {
		return AUTHOR;
	}

	public static String getURLDir() {
		return URL_DIR;
	}

}