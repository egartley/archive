package net.egartley.boota.files;

import java.io.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import net.egartley.boota.*;
import net.egartley.boota.object.LocalDataFile;
import net.egartley.boota.settings.Settings;
import net.egartley.boota.settings.Toggle;
import net.egartley.boota.update.UpdateCore;

public class JSONManager {

	/*
	 * © 2015 Evan Gartley - All Rights Reserved
	 */

	private JSONObject settings_Object = new JSONObject(), updateConfig_Object = new JSONObject();
	private JSONObject dataFileJSONObject;
	private boolean isDataFileLoaded;
	private long dataFileLastModified = 0;

	public void settings_writeFile(Toggle t) {
		LocalDataFile settingsFile = FileManager.SETTINGS_FILE;
		// if we should load default values
		boolean current = settingsFile.getExists();
		// construct data to write
		if (t == null) {
			settings_construct(current);
		} else {
			settings_construct_oneToggle(t);
		}
		
		try {
			// delete existing to write anew
			settingsFile.getFile().delete();
			FileWriter writer = new FileWriter(settingsFile.getFile());
			// write
			writer.write(settings_Object.toJSONString());
			// cleanup
			writer.flush();
			writer.close();
		} catch (IOException e) {
			Utils.handleException(e);
		}
	}

	public void updateConfig_writeFile() {
		LocalDataFile file = FileManager.UPDATE_CONFIG_FILE;
		// construct data to write
		updateConfig_construct();
		try {
			// delete existing to write anew
			file.getFile().delete();
			FileWriter writer = new FileWriter(file.getFile());
			// write
			writer.write(updateConfig_Object.toJSONString());
			// cleanup
			writer.flush();
			writer.close();
		} catch (IOException e) {
			Utils.handleException(e);
		}
	}

	@SuppressWarnings("unchecked")
	private void updateConfig_construct() {
		String c = "channel";
		if (UpdateCore.getIsInstalledBuild_preRelease()) {
			// has pre-release build, channel must be set to "pre"
			updateConfig_Object.put(c, StringManager.CHANNEL_PRE);
		} else {
			// has stable build installed, channel selection is optional
			if (Settings.GET_PRE_BUILDS.getValue())
				// opted into getting pre-release builds
				updateConfig_Object.put(c, StringManager.CHANNEL_PRE);
			else
				// don't get pre-release builds, default selection with stable installation
				updateConfig_Object.put(c, StringManager.CHANNEL_STABLE);
		}
	}

	@SuppressWarnings("unchecked")
	private void settings_construct(boolean current) {
		JSONArray toggleArray = new JSONArray();
		for (int i = 0; i < Settings.getToggleList().size(); i++) {
			// check for each toggle in Settings.getToggleList()
			Toggle curToggle = Settings.getToggle(i);
			if (curToggle == null)
				continue;
			JSONObject toggleObject = new JSONObject();
			if (!current)
				toggleObject.put(curToggle.getName(), curToggle.getDefaultValue());
			else {
				toggleObject.put(curToggle.getName(), curToggle.getValue());
			}
			toggleArray.add(toggleObject);
		}
		settings_Object.put(StringManager.JSON_KEY_SETTINGS_TOGGLES, toggleArray);
	}
	
	@SuppressWarnings("unchecked")
	private void settings_construct_oneToggle(Toggle t) {
		Utils.println("Toggle \"" + t.getName() + "\" set to \"" + t.getValue() + "\"", Utils.INFO);
		JSONArray toggleArray = new JSONArray();
		for (int i = 0; i < Settings.getToggleList().size(); i++) {
			Toggle curToggle = Settings.getToggle(i);
			if (curToggle == null)
				continue;
			JSONObject toggleObject = new JSONObject();
			if (curToggle.equals(t)) {
				// changed toggle
				toggleObject.put(t.getName(), t.getValue());
			} else {
				toggleObject.put(curToggle.getName(), curToggle.getValue());
			}
			toggleArray.add(toggleObject);
		}
		settings_Object.put(StringManager.JSON_KEY_SETTINGS_TOGGLES, toggleArray);
	}

	public JSONObject getJSONObject(File file) {
		if (!file.exists()) {
			Utils.handleError("getJSONObject(\"" + file.getName() + "\") cannot be called without \"" + file.getName()
					+ "\" existing!");
			return null;
		}
		JSONObject obj = null;
		try {
			FileReader reader = new FileReader(file);
			obj = (JSONObject) Marketplace.getJSONParser().parse(reader);
			Marketplace.getJSONParser().reset();
			reader.close();
		} catch (Exception e) {
			Utils.handleException(e);
		}
		return obj;
	}
	
	public JSONObject getJSONObject(LocalDataFile file) {
		if (!file.getExists()) {
			Utils.handleError("getJSONObject(\"" + file.getFileName() + "\") cannot be called without \"" + file.getFileName()
					+ "\" existing!");
			return null;
		}
		JSONObject obj = null;
		try {
			FileReader reader = new FileReader(file.getFile());
			obj = (JSONObject) Marketplace.getJSONParser().parse(reader);
			Marketplace.getJSONParser().reset();
			reader.close();
		} catch (Exception e) {
			Utils.handleException(e);
		}
		return obj;
	}

	public JSONObject getDataFileJSONObject() {
		File dataFile = FileManager.DATA_FILE;
		if (!dataFile.exists()) {
			Utils.handleError("getDataFileJSONObject() failed, because data.json does not exist!");
			return null;
		}
		if (dataFileLastModified == 0) {
			dataFileLastModified = dataFile.lastModified();
			isDataFileLoaded = false;
		} else {
			if (dataFile.lastModified() > dataFileLastModified) {
				isDataFileLoaded = false;
				dataFileLastModified = dataFile.lastModified();
			}
		}
		if (!isDataFileLoaded) {
			try {
				FileReader reader = new FileReader(dataFile);
				dataFileJSONObject = (JSONObject) Marketplace.getJSONParser().parse(reader);
				Marketplace.getJSONParser().reset();
				reader.close();
				isDataFileLoaded = true;
			} catch (Exception e) {
				Utils.handleException(e);
			}
		}
		return dataFileJSONObject;
	}
	
	public JSONObject getBuildFileJSONObject() {
		JSONObject obj = null;
	    try {
	      BufferedReader reader = new BufferedReader(
	        new java.io.InputStreamReader(Marketplace.class.getResource("/build.json").openStream()));
	      obj = ((JSONObject)Marketplace.getJSONParser().parse(reader));
	      Marketplace.getJSONParser().reset();
	      reader.close();
	    } catch (Exception e) {
	      Utils.handleException(e);
	    }
	    return obj;
	  }

}