package net.egartley.bolauncher;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;

import javax.swing.*;

import net.egartley.stlib.*;

public class Main extends JPanel implements ActionListener {

	/*
	 * Copyright (c) 2014 Evan Gartley - All rights reserved
	 * 
	 * Some methods in this class include code from the Apache Commons IO
	 * Library. See the EULA for more info.
	 */

	private static final long serialVersionUID = 1L;
	public static JFrame frame;
	public static JProgressBar progressBar;
	public static JButton launchButton;
	public static JButton installButton;
	public static JButton checkButton;
	private static JLabel statusLabel;
	public static int scale = 46;
	public static int width = 16 * scale, height = 9 * scale;
	public static String windowTitle = "Beyond Origins Launcher Beta";
	public static String launchButtonText = "Launch Game";
	public static String installButtonText = "Install";
	public static String checkButtonText = "Check";
	public static String user = System.getProperty("user.name");
	public static String mainDir = System.getenv("SystemDrive") + "\\Users\\"
			+ user + "\\AppData\\Roaming\\Beyond Origins";
	public static String installedBuild;
	public static String remoteBuild;
	public static String status = "Loading...";
	public static String verKey = "7204UN37GK017562";
	public static String tempDir = System.getenv("SystemDrive") + "\\Users\\"
			+ user + "\\AppData\\Local\\Temp";
	public static String currentEULA;
	public static String currentChangeLog;
	public static Font buttonTextFont = new Font("Arial", Font.PLAIN, 12);
	private static File binBuildFile = new File(mainDir + "\\bin\\version.txt"),
			tempBuildFile = new File(tempDir + "\\version.txt");
	private static BufferedImage gameLogo;
	private static FontMetrics fm;
	public static STLib st;
	public static STLibSwing stSwing;
	public static STLibGraphics stGraphics;
	public static STLibFile stFile;

	private Main() {
		super(new GridLayout(1, 1));

		JTabbedPane tp = new JTabbedPane();
		tp.setFocusable(false);

		setStatus("Loading...");
		JComponent mainPanel = getMainPanel();
		tp.addTab("Play Game", mainPanel);
		tp.setMnemonicAt(0, KeyEvent.VK_1);

		JComponent eulaPanel = getEULAPanel();
		tp.addTab("Agreement", eulaPanel);
		tp.setMnemonicAt(1, KeyEvent.VK_2);

		JComponent changesPanel = getChangesPanel();
		tp.addTab("Change Log", changesPanel);
		tp.setMnemonicAt(2, KeyEvent.VK_3);

		JComponent consolePanel = getConsolePanel();
		tp.addTab("Console", consolePanel);
		tp.setMnemonicAt(3, KeyEvent.VK_4);

		add(tp);
	}

	public static void main(String[] args) throws Exception {
		// prevent any errors when starting launcher
		SwingUtilities.invokeLater(new Runnable() {
			@SuppressWarnings("unused")
			public void run() {
				st = new STLib();
				stSwing = new STLibSwing();
				stGraphics = new STLibGraphics();
				stFile = new STLibFile();
				// set system look and feel (not using STLib)
				try {
					UIManager.setLookAndFeel(UIManager
							.getSystemLookAndFeelClassName());
				} catch (Exception e) {
					e.printStackTrace();
				}
				// create main application frame
				frame = new JFrame(windowTitle);
				frame.setSize(width, height);
				frame.setResizable(false);
				stSwing.centerFrame(frame);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
						JFrame.class.getResource("/icon32.png")));
				frame.add(new Main(), null);
				frame.setVisible(true);
				Checker ch = new Checker();
				updateEditorPanes();
			}
		});
	}

	public static void updateEditorPanes() {
		Thread worker = new Thread() {
			public void run() {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						EULA.license.setText(getCurrentEULA());
						ChangeLog.changesPane.setText(getCurrentChangeLog());
					}
				});
			}
		};
		worker.start();
	}

	public static void println(String t) {
		st.cout(t);
		if(ConsoleSIM.text != null)
			ConsoleSIM.appendText(t);
	}

	public JComponent getMainPanel() {
		JPanel panel = new JPanel(false);
		panel.setLayout(null);

		fm = getFontMetrics(buttonTextFont);
		launchButton = new JButton(launchButtonText);
		installButton = new JButton(installButtonText);
		checkButton = new JButton(checkButtonText);
		statusLabel = new JLabel();
		JLabel logo = new JLabel();

		statusLabel.setText("Loading...");

		gameLogo = stGraphics.loadImage("/logo.png");
		logo.setIcon(new ImageIcon(gameLogo));

		launchButton.setBounds(width / 2 - (178 / 2), 161, 178, 32);
		installButton.setBounds(width / 2 - (178 / 2), 185 - (48 - 64),
				178 / 2 - 4, 32);
		checkButton.setBounds(width / 2 + 4, 185 - (48 - 64), 178 / 2 - 4, 32);

		launchButton.addActionListener(this);
		installButton.addActionListener(this);
		checkButton.addActionListener(this);

		launchButton.setFocusable(false);
		installButton.setFocusable(false);
		checkButton.setFocusable(false);

		launchButton.setEnabled(false);
		installButton.setEnabled(false);
		checkButton.setEnabled(true);

		statusLabel.setFont(buttonTextFont);

		logo.setBounds(width / 2 - (gameLogo.getWidth() / 2), 35,
				gameLogo.getWidth(), gameLogo.getHeight());
		progressBar = new JProgressBar(0, 100);
		progressBar.setBounds(width / 2 - (176 / 2), height - 122, 176, 16);

		progressBar.setFocusable(false);
		progressBar.setVisible(true);
		progressBar.setIndeterminate(true);
		progressBar.setStringPainted(true);

		panel.add(logo);
		panel.add(launchButton);
		panel.add(installButton);
		panel.add(checkButton);
		panel.add(statusLabel);
		panel.add(progressBar);

		return panel;
	}

	public JComponent getEULAPanel() {
		JPanel panel = new JPanel(false);
		panel.setLayout(null);

		EULA.license = new JEditorPane("text/html", getCurrentEULA());
		EULA.license.setBounds(5, 5, width - 22, height - 66);
		EULA.license.setFocusable(false);

		JScrollPane sp = new JScrollPane(EULA.license);
		sp.setBounds(EULA.license.getBounds());

		panel.add(sp);

		return panel;
	}

	public JComponent getChangesPanel() {
		JPanel panel = new JPanel(false);
		panel.setLayout(null);

		ChangeLog.changesPane = new JEditorPane("text/html", "");
		ChangeLog.changesPane.setBounds(5, 5, width - 22, height - 66);
		ChangeLog.changesPane.setEditable(false);
		ChangeLog.changesPane.setFocusable(false);

		JScrollPane sp = new JScrollPane(ChangeLog.changesPane);
		sp.setBounds(ChangeLog.changesPane.getBounds());

		panel.add(sp);

		return panel;
	}

	public JComponent getConsolePanel() {
		JPanel panel = new JPanel(false);
		panel.setLayout(null);

		ConsoleSIM.text = new JTextArea();
		ConsoleSIM.text.setBounds(5, 5, width - 22, height - 66);
		ConsoleSIM.text.setEditable(false);
		ConsoleSIM.text.setFocusable(false);

		JScrollPane sp = new JScrollPane(ConsoleSIM.text);
		sp.setBounds(ConsoleSIM.text.getBounds());

		panel.add(sp);

		return panel;
	}

	public static String getCurrentEULA() {
		// create temp String eula for file content
		String eula = "";
		try {
			// download raw file
			downloadFile(tempDir + "\\eula.html",
					"https://dl.dropboxusercontent.com/s/rcvtpfb84f5t6ys/eula.html?dl=1");
			// create File object for reading
			File file = new File(tempDir + "\\eula.html");
			// read the file contents
			FileInputStream fis = new FileInputStream(file);
			byte[] data = new byte[(int) file.length()];
			fis.read(data);
			fis.close();
			// assign contents to String eula
			eula = new String(data, "UTF-8");
			// delete temp file eula.html
			file.delete();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		println("Returned current EULA");
		return eula;
	}
	
	public static String getCurrentChangeLog() {
		// create temp String cl for file content
		String cl = "";
		try {
			// download raw file
			downloadFile(tempDir + "\\changes.html",
					"https://dl.dropboxusercontent.com/s/cxx7qrwnxabd8hd/changes.html?dl=1");
			// create File object for reading
			File file = new File(tempDir + "\\changes.html");
			// read the file contents
			FileInputStream fis = new FileInputStream(file);
			byte[] data = new byte[(int) file.length()];
			fis.read(data);
			fis.close();
			// assign contents to String cl
			cl = new String(data, "UTF-8");
			// delete temp file changes.html
			file.delete();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		println("Returned current change log");
		return cl;
	}

	public static void setStatus(final String text) {
		// setup in background (separate thread)
		Thread worker = new Thread() {
			public void run() {
				// set String status to parm text
				status = text;
				// check for null
				if (statusLabel != null) {
					// set statusLabel text to parm text
					statusLabel.setText(text);
					statusLabel.setBounds(width / 2 - (fm.stringWidth(text) / 2),
							250, width, 27);
					// confirm change of status
					println("Set status to: " + text);
					return;
				}
				println("Status label is null, did not set status");
			}
		};
		// start new thread
		worker.start();
	}

	public static void writeBinBuildFile() {
		println("Writing bin version file...");
		// setup to write to bin verison file
		try (FileWriter fw = new FileWriter(binBuildFile.getAbsolutePath())) {
			PrintWriter pw = new PrintWriter(fw);
			pw.println(installedBuild);
			pw.close();
			// confirm written build
			println("Wrote in bin build file: " + installedBuild);
		} catch (IOException e) {
			println(e.getMessage());
		}
		try {
			// encrypt bin build file
			stFile.encryptFileContents(verKey, binBuildFile, binBuildFile);
			println("Encrypted bin build file");
		} catch (Exception e) {
			// error while trying to encrypt bin build file
			println(e.getMessage());
		}
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String a = ae.getActionCommand();
		if (a.equals(launchButtonText)) {
			// clicked the launch button
			try {
				launchGame();
			} catch (IOException e) {
				// error launching game
				println(e.getMessage());
			}
		} else if (a.equals("install_update")) {
			// clicked install button with type "update"
			installUpdate();
		} else if (a.equals("install_game")) {
			// clicekd install button with type "install"
			installGame();
		} else if (a.equals("Check")) {
			// clicked check button
			checkForUpdates();
		}
	}

	private void launchGame() throws IOException {
		if (new File(mainDir).exists() && new File(mainDir + "\\bin").exists()
				&& new File(mainDir + "\\bin\\BeyondOrigins.jar").exists()) {
			// all game contents looks good, all exists
			String cmd = "java -jar \"C:\\Users\\"
					+ user
					+ "\\AppData\\Roaming\\Beyond Origins\\bin\\BeyondOrigins.jar\"";
			// execute String cmd within current Runtime
			Runtime.getRuntime().exec(cmd);
			// dramatic pause
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// close launcher
			System.exit(0);
		} else {
			// all or some of game's contents do not look right
			setStatus("Unable to launch game; 'BeyondOrigins.jar' and/or its folders do not exist!");
		}
	}

	@SuppressWarnings("unused")
	private void installGame() {
		// run Go constructor with type "install"
		Go install = new Go("install");
	}

	@SuppressWarnings("unused")
	private void installUpdate() {
		// run Go constructor with type "update"
		Go update = new Go("update");
	}

	public static void downloadFile(String path, String url) {
		try {
			Downloader.copyFromURLToFile(path, url);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void downloadAssets() throws MalformedURLException,
			IOException {
		progressBar.setString("Downloading assets...");
		progressBar.setValue(0);
		// create temp int to represent interval for assets progress
		int interval = 0;
		// create File object for the old (installed) control file
		File control_old = new File(tempDir + "\\whatToAssets.txt");
		if (control_old.exists() && control_old.delete()) {
			// if old_control exists, then attempt deletion
			println("Deleted old assets control file");
		} else {
			// error while deleting control_old, or it never existed
			println("Old assets control file wasn't deleted");
		}
		// download current whatToAssets.txt from Dropbox
		downloadFile(tempDir + "\\whatToAssets.txt",
				"https://dl.dropboxusercontent.com/s/27760a7c789pp5l/whatToAssets.txt?dl=1");
		// create File object for new (current) control file
		File control = new File(tempDir + "\\whatToAssets.txt");
		// setup readers
		FileReader fileReader = new FileReader(control);
		BufferedReader buffRdr = new BufferedReader(new FileReader(control));
		LineNumberReader lineNumRdr = new LineNumberReader(fileReader);
		// setup for number of lines reading
		int lineNum = 0;
		while (lineNumRdr.readLine() != null) {
			// while the current line isn't null, add one to lineNum
			lineNum++;
		}
		/*
		 * calc number of assets based on predefined format as shown below
		 * 
		 * fileNameOfAsset.extension ---------------------------
		 * dropboxFileIDForURL ---------------------------------
		 */
		int numOfAssets = (int) lineNum / 2;
		// calc the interval for progress bar value
		interval = (int) 100 / numOfAssets;
		// download assets given the number of assets in control file
		for (int i = 0; i < numOfAssets; i++) {
			// for however many assets there are in control file, download them
			// with given info from readers
			String name = buffRdr.readLine();
			String id = buffRdr.readLine();
			progressBar.setValue((int) interval * i);
			downloadFile(mainDir + "\\assets\\" + name,
					"https://dl.dropboxusercontent.com/s/" + id + "/" + name
							+ "?dl=1");
		}
		// close readers
		progressBar.setValue(100);
		lineNumRdr.close();
		buffRdr.close();
		if (control.exists() && control.delete()) {
			// if control exists, then attempt deletion
			println("Deleted temp assets control file");
		} else {
			// error while deleting control file, or it never existed
			println("Temp assets control file wasn't deleted");
		}
	}

	public static void checkBuilds(boolean dir) {
		if (dir) {
			// main folder/directory exists
			println("Main directory exists");
			// fetch remote build
			try {
				downloadFile(tempDir + "\\version.txt",
						"https://dl.dropboxusercontent.com/s/63k5w7t3z0tk6cu/version.txt?dl=1");
				// apply remote build to String remoteBuild
				BufferedReader rdr = new BufferedReader(new FileReader(tempDir
						+ "\\version.txt"));
				remoteBuild = rdr.readLine();
				rdr.close(); // this line fixes stupid bug! yay!
				// confirm remote build
				println("Remote build is: " + remoteBuild);
			} catch (IOException e) {
				println(e.getMessage());
			}
			// fetch installed build, if bin build file exists
			if (binBuildFile.exists()) {
				// bin build file exists, continue
				println("Bin build file exists");
				try {
					// decrypt bin build file
					stFile.decryptFileContents(verKey, binBuildFile, binBuildFile);
				} catch (Exception e) {
					// error while decryting bin build file
					println(e.getMessage());
					return;
				}
				println("Decrypted bin version");
				// apply the installed build to String installedBuild
				try (BufferedReader rdr = new BufferedReader(new FileReader(
						binBuildFile))) {
					installedBuild = rdr.readLine();
					println("The installed build is: " + installedBuild);
				} catch (IOException e) {
					println(e.getMessage());
				}
			} else {
				// no installed build, probably null, but write build file
				println("Bin build file does not exist");
				installedBuild = remoteBuild;
				writeBinBuildFile();
			}
			try {
				if (tempBuildFile.delete())
					println("Deleted temp build file");
				else
					println("Error deleting temp version file");
			} catch (SecurityException e) {
				println(e.getMessage());
			}
		} else {
			// no installed version, as directory does not exist, so
			// installedBuild is null, don't write bin version file
			println("Directory does not exist");
			installedBuild = null;
		}
	}

	@SuppressWarnings("unused")
	public static void checkForUpdates() {
		// run Checker class's construtor
		Checker ch = new Checker();
	}

}