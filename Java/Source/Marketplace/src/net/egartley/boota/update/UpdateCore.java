package net.egartley.boota.update;

import java.io.File;

import org.json.simple.JSONObject;

import net.egartley.boota.Marketplace;
import net.egartley.boota.StringManager;
import net.egartley.boota.Utils;
import net.egartley.boota.dialog.UpdateCompleteDialog;
import net.egartley.boota.dialog.UpdateDialog;
import net.egartley.boota.files.FileManager;
import net.egartley.boota.object.BuildType;
import net.egartley.boota.object.Build;
import net.egartley.boota.files.Download;
import net.egartley.boota.settings.Settings;

public class UpdateCore {

	/*
	 * © 2015 Evan Gartley - All Rights Reserved
	 */

	private static Build CURRENT_STABLE, CURRENT_PRE;
	private static boolean hasLatestBuild;
	private static boolean didUpdate = false;

	private static BuildType availavleBuildType = null;

	public static void check(boolean isManual) {
		if (isManual)
			Utils.downloadDataFile();
		else {
			// is auto, so data.json should exist
		}

		// error checking
		if (!FileManager.DATA_FILE.exists()) {
			Utils.handleError(
					"Cannot check for updates without " + FileManager.DATA_FILE.getName() + " being existent!");
			return;
		}
		if (!FileManager.UPDATE_CONFIG_FILE.getExists()) {
			Utils.handleError("Cannot check for updates without " + FileManager.UPDATE_CONFIG_FILE.getFileName()
					+ " being existent!");
			return;
		}

		feedback("Getting build channel...");
		String channel = getBuildChannel();
		boolean pre = channel.equalsIgnoreCase(StringManager.CHANNEL_PRE);
		boolean stable = channel.equalsIgnoreCase(StringManager.CHANNEL_STABLE);
		if (pre) {
			// pre-release channel
			feedback("Build channel is \"" + channel + "\"");
			checkForBoth();
		} else if (stable) {
			// stable channel
			feedback("Build channel is \"" + channel + "\"");
			checkForStable();
		} else {
			updateFailed("Unknown build channel (\"" + channel + "\")! Cannot continue!");
			return;
		}

		boolean hasLatestBuild = getHasLatestBuild();
		if (hasLatestBuild && !isManual) {
			// user has latest build, but the check was auto, so don't show the
			// update frame
			return;
		}
		if (!hasLatestBuild) {
			if (getAvailableBuildType().equals(BuildType.PRE_RELEASE)) {
				feedback("Prompting user with new pre-release build...");
				UpdateDialog.createDialog(CURRENT_PRE, hasLatestBuild);
			} else if (getAvailableBuildType().equals(BuildType.STABLE)) {
				feedback("Prompting user with new stable build...");
				UpdateDialog.createDialog(CURRENT_STABLE, hasLatestBuild);
			} else if (getAvailableBuildType() == null) {
				updateFailed("Available build is null; cannot continue!");
				return;
			} else {
				updateFailed("Unknown available build type; cannot continue!");
				return;
			}
		} else {
			if (isManual) {
				UpdateDialog.createDialog(null, hasLatestBuild);
			}
		}

		if (isManual)
			FileManager.DATA_FILE.delete();
	}

	public static void downloadAvailableBuild() {
		Build newBuild = getAvailableBuild();
		File put = new File(StringManager.MARKETPLACE_DIR + File.separator + newBuild.getFileName());
		Download download = new Download(newBuild.getURL(), put);
		if (newBuild.equals(null)) {
			Utils.handleError("Error with new build! Try again later or tell @egartley on Twitter!");
			return;
		}
		download.fetch();
		Utils.launchJar(put, StringManager.ARG_UPDATE);
		Marketplace.close();
	}

	public static void setDidUpdate(boolean b) {
		didUpdate = b;
	}

	public static void completeUpdate() {
		UpdateCompleteDialog.createDialog();
		didUpdate = true;
	}

	public static void syncChannel() {
		Marketplace.getJSONManager().updateConfig_writeFile();
		Settings.GET_PRE_BUILDS.getCheckBox().setEnabled(!getIsInstalledBuild_preRelease());
		Settings.GET_PRE_BUILDS.setValue(getBuildChannel().equalsIgnoreCase(StringManager.CHANNEL_PRE), true);
	}

	private static void readDataFile() {
		feedback("Reading data file...");
		JSONObject outer = Marketplace.getJSONManager().getDataFileJSONObject();
		JSONObject buildObject = (JSONObject) outer.get(StringManager.JSON_KEY_DATA_BUILD);

		CURRENT_PRE = new Build(BuildType.PRE_RELEASE, (JSONObject) buildObject.get(BuildType.PRE_RELEASE.getString()));

		if (buildObject.containsKey(BuildType.STABLE.getString())) {
			CURRENT_STABLE = new Build(BuildType.STABLE, (JSONObject) buildObject.get(BuildType.STABLE.getString()));
		} else
			CURRENT_STABLE = new Build(BuildType.STABLE, null);
	}

	private static void checkForBoth() {
		feedback("Checking for new pre-release and stable builds...");
		readDataFile();
		if (!CURRENT_STABLE.isAvailable()) {
			feedback("Stable builds are not currently available");
			if (getIsNewBuild_PreRelease()) {
				feedback("New pre-release build available!");
				availavleBuildType = BuildType.PRE_RELEASE;
				setHasLatestBuild(false);
			} else {
				feedback("You have the latest pre-release build");
				availavleBuildType = null;
				setHasLatestBuild(true);
			}
		} else {
			if (getIsNewBuild_PreRelease() && getIsNewBuild_Stable()) {
				feedback("New pre-release and stable builds available!");
				availavleBuildType = BuildType.STABLE;
				feedback("Update to stable build first!");
			} else if (getIsNewBuild_PreRelease() && !getIsNewBuild_Stable()) {
				feedback("New pre-release build available!");
				availavleBuildType = BuildType.PRE_RELEASE;
			} else if (getIsNewBuild_Stable() && !getIsNewBuild_PreRelease()) {
				feedback("New stable build available!");
				availavleBuildType = BuildType.STABLE;
			} else {
				feedback("You have the latest build");
				availavleBuildType = null;
				setHasLatestBuild(true);
				return;
			}
			setHasLatestBuild(false);
		}

	}

	private static void checkForStable() {
		feedback("Checking for new stable builds...");
		readDataFile();
		if (!CURRENT_STABLE.isAvailable()) {
			feedback("Stable builds are not currently available");
			availavleBuildType = null;
			setHasLatestBuild(true);
			return;
		}
		if (getIsNewBuild_Stable()) {
			feedback("New stable build available!");
			availavleBuildType = BuildType.STABLE;
			setHasLatestBuild(false);
		} else {
			feedback("You have the latest stable build");
			availavleBuildType = null;
			setHasLatestBuild(true);
		}
	}

	private static void feedback(String s) {
		if (Settings.EXTRA_UPDATE_FEEDBACK.getValue()) {
			Utils.println(s, Utils.UPDATE);
		} else {
			System.out.println("UPDATE: " + s);
		}
	}

	private static void updateFailed(String s) {
		feedback("Update failed: " + s);
	}

	private static void setHasLatestBuild(boolean has) {
		hasLatestBuild = has;
	}

	private static double getInstalledBuildVersionDouble() {
		return ThisBuild.getVersion().getDouble();
	}

	public static boolean getHasLatestBuild() {
		return hasLatestBuild;
	}

	public static boolean getIsInstalledBuild_preRelease() {
		return getInstalledBuildType().equals(BuildType.PRE_RELEASE);
	}

	public static boolean getIsInstalledBuild_stable() {
		return getInstalledBuildType().equals(BuildType.STABLE);
	}

	public static boolean getDidUpdate() {
		return didUpdate;
	}

	private static boolean getIsNewBuild_PreRelease() {
		if (CURRENT_PRE.getVersion().getDouble() < getInstalledBuildVersionDouble()) {
			feedback("You have an in-development build installed");
			setHasLatestBuild(true);
			return false;
		}
		return !getInstalledBuildVersionString().equalsIgnoreCase(CURRENT_PRE.getVersion().getString());
	}

	private static boolean getIsNewBuild_Stable() {
		if (getIsInstalledBuild_stable()) {
			if (CURRENT_STABLE.getVersion().getDouble() < getInstalledBuildVersionDouble()) {
				// has in dev build installed
				setHasLatestBuild(true);
				return false;
			}
		}
		return !getInstalledBuildVersionString().equalsIgnoreCase(CURRENT_STABLE.getVersion().getString());
	}

	private static Build getAvailableBuild() {
		if (getAvailableBuildType().equals(BuildType.PRE_RELEASE))
			return CURRENT_PRE;
		else if (getAvailableBuildType().equals(BuildType.STABLE))
			return CURRENT_STABLE;
		else {
			return null;
		}
	}

	private static BuildType getInstalledBuildType() {
		return ThisBuild.getType();
	}

	public static BuildType getAvailableBuildType() {
		return availavleBuildType;
	}

	private static String getInstalledBuildVersionString() {
		return ThisBuild.getVersion().getString();
	}

	public static String getBuildChannel() {
		return Marketplace.getJSONManager().getJSONObject(FileManager.UPDATE_CONFIG_FILE).get("channel").toString();
	}

	public static String getAvailableBuildURL() {
		return getAvailableBuild().getURL();
	}

}