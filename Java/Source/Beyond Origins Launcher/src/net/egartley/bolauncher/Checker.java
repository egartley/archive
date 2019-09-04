package net.egartley.bolauncher;

import java.io.*;

public class Checker extends Thread {

	public Checker() {
		this.start();
		this.setPriority(NORM_PRIORITY);
	}

	public void run() {
		// setup progress bar
		Main.setStatus("Checking for new builds...");
		Main.progressBar.setString("Checking for new builds...");
		Main.progressBar.setVisible(true);
		// run checkVersions() in class Main
		Main.checkBuilds(new File(Main.mainDir).exists());
		// start comparing versions
		Main.println("Comparing versions...");
		Main.progressBar.setString("Comparing builds...");
		File gameFile = new File(Main.mainDir + "\\bin\\BeyondOrigins.jar");
		if (Main.installedBuild != null
				&& Main.installedBuild.equals(Main.remoteBuild)
				&& gameFile.exists()) {
			// if:
			// -----the installed build is not null
			// -----the installed build is equal to the remote build
			// -----game .jar exists
			// then:
			// -----user has current build
			Main.setStatus("You have the current build! (Build "
					+ Main.installedBuild + ")");
			Main.launchButton.setEnabled(true);
			Main.installButton.setEnabled(false);
			// set JButton installButton's action command to "install_update"
			Main.installButton.setActionCommand("install_update");
		} else if (Main.installedBuild == null && !gameFile.exists()) {
			// if:
			// -----the installed build is equal to null
			// -----game .jar does not exist
			// then:
			// -----user does not have the game installed
			Main.setStatus("Click the 'Install Game' button to install Beyond Origins!");
			Main.launchButton.setEnabled(false);
			Main.installButton.setEnabled(true);
			// set JButton installButton's action command to "install_game"
			Main.installButton.setActionCommand("install_game");
		} else if (Main.installedBuild != Main.remoteBuild) {
			// if:
			// -----the installed build is not equal to the remote build
			// then:
			// -----user does not have the current build, needs to update
			Main.setStatus("A new update is ready to be installed! (Build "
					+ Main.remoteBuild + ")");
			Main.launchButton.setEnabled(false);
			Main.installButton.setEnabled(true);
			// set JButton installButton's action command to "install_update"
			Main.installButton.setActionCommand("install_update");
		}
		// final build check, no matter the outcome of above if statement
		if (Main.installedBuild != Main.remoteBuild) {
			// if:
			// -----the installed build is not equal to the remote build
			// then:
			// -----the bin build file does not have the current build, write
			// new build file

			// set the installedBuild to the remoteBuild
			Main.installedBuild = Main.remoteBuild;
			Main.progressBar.setString("Writing build file...");
			// write new build file
			Main.writeBinBuildFile();
		}
		// finish
		Main.progressBar.setString("Done");
		// hide progress bar
		Main.progressBar.setVisible(false);
	}

}
