package net.egartley.boota.app;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JDialog;

import org.json.simple.JSONObject;

import net.egartley.boota.Marketplace;
import net.egartley.boota.StringManager;
import net.egartley.boota.Utils;
import net.egartley.boota.dialog.AppDetailsDialog;
import net.egartley.boota.files.Structure;
import net.egartley.boota.files.Download;

public class Application {

	/*
	 * © 2015 Evan Gartley - All Rights Reserved
	 */

	private JSONObject appObject, fileObject, versionObject;
	private File appFolder;
	private boolean frameShowing = false;

	private AppDetailsDialog frame = new AppDetailsDialog(null);
	private JDialog detailsDialog;

	public Application(JSONObject obj) {
		appObject = obj;
		fileObject = (JSONObject) this.appObject.get("file");
		versionObject = (JSONObject) this.appObject.get("version");

		appFolder = new File(StringManager.MARKETPLACE_DIR + File.separator + "apps" + File.separator + getID());
	}

	public void install() {
		File file = new File(appFolder.getAbsolutePath() + File.separator + getFileName());
		Structure.createRootDir("apps" + File.separator + getID());
		Download download = new Download(getDownloadLink(), file);
		download.fetch();
	}

	public void launch() {
		// todo
	}

	public void uninstall() {
		try {
			Structure.cleanDirectory(appFolder, true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		new AppDetailsDialog(this).createFrame(this);
	}

	public void setDetailsFrame(JDialog newFrame) {
		detailsDialog = newFrame;
	}

	public void setShowing(boolean val) {
		frameShowing = val;
	}

	public void showDetails() {
		frame.createFrame(this);
		frameShowing = true;
	}

	public void downloadIcon() {
		if (isDefaultIcon()) {
			Utils.handleError("Internal error! Please try again later! (Cannot call downloadIcon() with default icon)");
			return;
		}
		Download d = new Download(StringManager.SERVER_URL + "files/marketplace/apps/" + getID() + "/icon.png",
				new File(getIconPath()));
		d.fetch();
	}

	public boolean isShowing() {
		return frameShowing;
	}

	public boolean isInstalled() {
		return appFolder.exists();
	}

	public JDialog getDetailsFrame() {
		return detailsDialog;
	}

	public BufferedImage getIcon() {
		BufferedImage icon;
		if (isDefaultIcon()) {
			icon = Marketplace.stlibGraphics.loadImage("/default_icon.png");
		} else {
			downloadIcon();
			icon = Marketplace.stlibGraphics.loadImage(getIconPath());
		}
		return icon;
	}

	private boolean isDefaultIcon() {
		return !Boolean.valueOf(appObject.get("has-icon").toString());
	}

	public String getTempPath() {
		return StringManager.TEMP_DIR + File.separator + getID();
	}

	public String getIconPath() {
		return getTempPath() + File.separator + "icon.png";
	}

	public String getAppURL() {
		return StringManager.SERVER_URL + "files/marketplace/" + StringManager.THIS_BUILD_DIR_URL + "/apps/" + getID() + "/";
	}

	public String getDownloadLink() {
		return getAppURL() + getFileName();
	}

	public String getFileName() {
		return fileObject.get("name").toString();
	}

	public String getVersionString() {
		return versionObject.get("string").toString();
	}

	public double getVersionDouble() {
		return Double.parseDouble(versionObject.get("double").toString());
	}

	public String getDisplayName() {
		return appObject.get("display-name").toString();
	}

	public String getSize() {
		return fileObject.get("size").toString();
	}

	public String getID() {
		return appObject.get("id").toString();
	}

	public String getShortDesc() {
		return appObject.get("short-desc").toString();
	}

	public String getFullDesc() {
		return appObject.get("full-desc").toString();
	}

	public String getExtension() {
		String name = fileObject.get("name").toString();
		return name.substring(name.lastIndexOf(".") - 1);
	}

	public String getCompatability() {
		int c = Integer.valueOf(appObject.get("compatability").toString());
		if (c == 1) {
			return "Windows";
		} else if (c == 2) {
			return "Windows and OS X";
		} else {
			return "COMAPTABILITY_UNKNOWN";
		}
	}

	public String getCellListData() {
		return "<html><b>" + getDisplayName() + "</b><br>" + getShortDesc() + "</html>";
	}

}