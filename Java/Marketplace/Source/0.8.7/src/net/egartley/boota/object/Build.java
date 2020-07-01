package net.egartley.boota.object;

import org.json.simple.JSONObject;

public class Build {

	/*
	 * © 2015 Evan Gartley - All Rights Reserved
	 */

	private String verKey = "version", verStringKey = "string", verDoubleKey = "double";
	private String fileKey = "file", fileNameKey = "name", fileURLDirKey = "url-dir", fileURLKey = "url-fetch";
	private String nullValueString = "none";
	private double nullValueDouble = 0;

	private BuildType type;
	private BuildVersion version;
	private JSONObject buildObject;
	private JSONObject versionObject;
	private JSONObject fileObject;
	private boolean isAvailable = false;

	public Build(BuildType type, JSONObject buildObject) {
		this.type = type;
		this.buildObject = buildObject;
		if (buildObject == null) {
			versionObject = null;
			fileObject = null;
			version = null;
			return;
		}
		if (buildObject.containsKey(verKey) && buildObject.containsKey(fileKey)) {
			isAvailable = true;
		}
		versionObject = (JSONObject) this.buildObject.get(verKey);
		fileObject = (JSONObject) this.buildObject.get(fileKey);
		version = new BuildVersion(getVersionDouble(), getVersionString());
	}

	public BuildType getType() {
		return type;
	}

	public BuildVersion getVersion() {
		return version;
	}

	private String getVersionString() {
		return versionObject.get(verStringKey).toString();
	}

	private double getVersionDouble() {
		String val = versionObject.get(verDoubleKey).toString();
		if (val.equalsIgnoreCase(nullValueString))
			return nullValueDouble;
		return Double.parseDouble(val);
	}

	public String getFileName() {
		return fileObject.get(fileNameKey).toString();
	}

	public String getURLDir() {
		return fileObject.get(fileURLDirKey).toString();
	}

	public String getURL() {
		return fileObject.get(fileURLKey).toString();
	}

	public JSONObject getJSONObject() {
		return buildObject;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

}
