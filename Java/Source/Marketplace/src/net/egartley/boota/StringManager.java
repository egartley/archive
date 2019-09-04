package net.egartley.boota;

public class StringManager {

	/*
	 * © 2015 Evan Gartley - All Rights Reserved
	 */

	private static String USER_NAME;
	public static String OS_NAME;
	public static String EGARTLEY_DIR;
	public static String MARKETPLACE_DIR;
	public static String TEMP_DIR;

	public static String SERVER_URL;
	public static String SERVER_ERROR_DESC;
	public static String BUILD_TYPE_STABLE, BUILD_TYPE_PRE;
	public static String DATE_FORMAT;
	public static String ARG_UPDATE;
	public static String ARG_RESET;
	public static String DATA_FILE_NAME, DATA_FILE_URL;
	public static String DECIMAL_FORMAT;
	public static String APPS_FILE_NAME, APPS_FILE_URL;
	public static String THIS_BUILD_DIR_URL;
	public static String NO_CONTENT_HTML, LOADING_HTML;
	public static String UPDATE_CONFIG_FILE_NAME;
	public static String CHANNEL_PRE, CHANNEL_STABLE;

	public static String JSON_KEY_SETTINGS_TOGGLES;
	public static String JSON_KEY_DATA_BUILD;
	public static String JSON_KEY_UPDATE_CONFIG;

	public static void init() {
		USER_NAME = System.getProperty("user.name");
		OS_NAME = System.getProperty("os.name");

		constructFilePaths();

		SERVER_URL = "https://egartley.net/";
		SERVER_ERROR_DESC = "It seems that your Internet connection is not working correctly. Otherwise, the servers may be down. "
				+ "Check your connection and try again later.";
		BUILD_TYPE_PRE = "pre";
		BUILD_TYPE_STABLE = "stable";
		DATE_FORMAT = "HH:mm:ss:SS";
		DECIMAL_FORMAT = "#,##0.0";
		ARG_UPDATE = "update";
		ARG_RESET = "reset";
		DATA_FILE_NAME = "data.json";
		APPS_FILE_NAME = "apps.json";
		THIS_BUILD_DIR_URL = "error";
		DATA_FILE_URL = "error";
		APPS_FILE_URL = "error";
		NO_CONTENT_HTML = "<html><head><style>body{font-family:arial;font-size:9px;}</style></head><body>No content available</body></html>";
		LOADING_HTML = "<html><head><style>body{font-family:arial;font-size:9px;}</style></head><body>Loading...</body></html>";
		UPDATE_CONFIG_FILE_NAME = "config.json";
		CHANNEL_PRE = BUILD_TYPE_PRE;
		CHANNEL_STABLE = BUILD_TYPE_STABLE;

		JSON_KEY_SETTINGS_TOGGLES = "toggles";
		JSON_KEY_DATA_BUILD = "build";
		JSON_KEY_UPDATE_CONFIG = "updateConfig";
	}

	private static void constructFilePaths() {
		EGARTLEY_DIR = System.getenv("SystemDrive") + "\\Users\\" + USER_NAME + "\\AppData\\Roaming\\.egartley";
		MARKETPLACE_DIR = EGARTLEY_DIR + "\\Marketplace";
		TEMP_DIR = MARKETPLACE_DIR + "\\temp";
	}
	
}
