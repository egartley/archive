package net.egartley.bolauncher;

import java.io.*;

public class Go extends Thread{

	/*
	 * Copyright (c) 2014 Evan Gartley - All rights reserved
	 */
	String type;
	
	public Go(String newType) {
		type = newType;
		this.start();
		this.setPriority(NORM_PRIORITY);
	}

	public void run() {
		// pre
		// assign booleans to equals() String type
		boolean typeIsInstall = type.equals("install");
		boolean typeIsUpdate = type.equals("update");
		if (typeIsInstall) {
			// if type is type "install"
			Main.setStatus("Installing...");
			Main.progressBar.setString("Creating directories...");
		} else if (typeIsUpdate) {
			// if type is type "update"
			Main.setStatus("Updating...");
			Main.progressBar.setString("Updating directories...");
		}
		// show progress bar and set indeterminate true
		Main.progressBar.setVisible(true);
		Main.progressBar.setIndeterminate(true);
		// core
		try {
			// create/update directories
			setupDirectories();
		} catch (Exception e) {
			// error while creating/updating directories
			Main.progressBar.setString("Directory Update Failed");
			Main.setStatus("Error updating directories! See \"Console\" tab!");
			Main.println(e.getMessage());
			// exit run() method
			return;
		}
		Main.println("Directories successfully updated/created");
		try {
			Main.progressBar.setString("Downloading game...");
			Main.progressBar.setIndeterminate(false);
			Main.progressBar.setValue(20);
			// download game .jar file
			Main.downloadFile(Main.mainDir + "\\bin\\BeyondOrigins.jar",
					"https://dl.dropboxusercontent.com/s/qj2pdfkwbsqea7l/BeyondOrigins.jar?dl=1");
			Main.progressBar.setValue(100);
			// download assets
			Main.downloadAssets();
		} catch (IOException e) {
			// error while downloading game/asset files
			Main.progressBar.setString("Installation/Update Failed");
			Main.setStatus("Error downloading content/update(s)! See \"Console\" tab!");
			Main.println(e.getMessage());
			return;
		}
		// finish
		Main.progressBar.setString("Done");
		Main.progressBar.setIndeterminate(true);
		Main.progressBar.setValue(0);
		Main.println("Done installing/updating");
		Main.installButton.setEnabled(false);
		Main.launchButton.setEnabled(true);
		// update local bin build file
		Main.checkForUpdates();
	}

	private void setupDirectories() throws Exception {
		File control_old = new File(Main.tempDir + "\\folders.txt");
		if (control_old.exists() && control_old.delete()) {
			// if old control file exists, delete it, may be out of date
			Main.println("Deleted old folder control file");
		}
		// make main directory in Roaming
		File mainFolder = new File(Main.mainDir);
		mainFolder.mkdirs();
		// download control file for folders
		Main.downloadFile(Main.tempDir + "\\folders.txt",
				"https://dl.dropboxusercontent.com/s/mkor80smcwmk9fy/folders.txt?dl=1");
		// create File object for new control file
		File control = new File(Main.tempDir + "\\folders.txt");
		FileReader fileReader = new FileReader(control);
		BufferedReader buffRdr = new BufferedReader(new FileReader(control));
		LineNumberReader lineNumRdr = new LineNumberReader(fileReader);
		// get number of lines
		int lineNum = 0;
		while (lineNumRdr.readLine() != null) {
			lineNum++;
		}
		for (int i = 0; i < lineNum; i++) {
			// assign folder name based on current line to temp String name
			String name = buffRdr.readLine();
			createDirectory(Main.mainDir + "\\" + name);
		}
		// close readers
		buffRdr.close();
		lineNumRdr.close();
		if(control.exists() && control.delete()) {
			// if control file exists (which it should) then delete it
			Main.println("Deleted temp folder control file");
		} else {
			// control file doesn't exist or can't be deleted
			Main.println("Temp folder control file never existed");
		}
	}

	public static void createDirectory(String path) {
		// create temp File object f to given file path
		File f = new File(path);
		if (!f.exists()) 
			f.mkdirs();
		else
			return;
		// directort successfully made
		Main.println("Made folder: " + path);
	}

}
