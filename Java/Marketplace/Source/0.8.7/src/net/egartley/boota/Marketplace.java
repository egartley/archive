package net.egartley.boota;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import net.egartley.boota.app.AppFetcher;
import net.egartley.boota.app.Application;
import net.egartley.boota.console.CommandHandler;
import net.egartley.boota.console.Console;
import net.egartley.boota.dialog.CellRenderer;
import net.egartley.boota.files.FileManager;
import net.egartley.boota.files.JSONManager;
import net.egartley.boota.files.Structure;
import net.egartley.boota.input.CellMouseListener;
import net.egartley.boota.object.BuildType;
import net.egartley.boota.settings.Settings;
import net.egartley.boota.update.ThisBuild;
import net.egartley.boota.update.UpdateCore;
import net.egartley.stlib.*;

public class Marketplace extends JPanel implements ActionListener {

	/*
	 * © 2016 Evan Gartley - All Rights Reserved
	 */

	/*
	 * Startup process
	 * 
	 * init(), -handle arguments-, createMainFrame(), Startup.run()
	 */

	private static final long serialVersionUID = 1L;

	private static final int SCALE = 52;
	public static final int WINDOW_WIDTH = 16 * SCALE, WINDOW_HEIGHT = 9 * SCALE;
	private static ArrayList<String> iconNames;

	private static JFrame frame;
	public static JTabbedPane tabbedPane;
	public static JEditorPane eulaPane, newsPane, clPane;
	private static JProgressBar homeProgressBar;
	private static JLabel copyrightLabel;
	private static JList<String> appList;
	private static JScrollPane eulaScrollPane, newsScrollPane, clScrollPane;

	public static Application[] applications;

	public static FontMetrics fontMetrics;
	public static STLib stlib;
	public static STLibSwing stlibSwing;
	public static STLibFile stlibFile;
	public static STLibString stlibString;
	public static STLibGraphics stlibGraphics;
	private static JSONManager jsonManager;
	private static JSONParser jsonParser;

	private Marketplace() {
		super(new GridLayout(1, 1));

		tabbedPane = new JTabbedPane();
		tabbedPane.setFocusable(false);
		tabbedPane.setTabPlacement(JTabbedPane.TOP);

		iconNames = new ArrayList<String>();
		createTab("Home", getHomePanel(), "home");
		createTab("Agreement", getEULAPanel(), "agreement");
		// createTab("Changelog", getChangelogPanel(), "changelog");
		if (Settings.ADVANCED_MODE.getValue())
			createTab("Console", getConsolePanel(), "console");
		createTab("Settings", getSettingsPanel(), "settings");
		tabbedPane.setUI(new CustomGUI());

		for (int i = 0; i < iconNames.size(); i++) {
			tabbedPane.setIconAt(i, new ImageIcon(stlibGraphics.loadImage("/" + iconNames.get(i) + ".png")));
			tabbedPane.setMnemonicAt(i, 49 + i);
		}

		add(tabbedPane);
	}

	private static void createTab(String title, JComponent panel, String icon) {
		tabbedPane.addTab(title, panel);
		iconNames.add(icon.toLowerCase());
	}

	public static void main(String[] args) throws Exception {
		init();
		if (args.length != 0) {
			if (args[0].equalsIgnoreCase(StringManager.ARG_RESET)) {
				stlib.cout("Resetting...");
				Structure.cleanDirectory(FileManager.MARKETPLACE_FOLDER, true);
				Structure.verifyDirectories();
			} else if (args[0].equalsIgnoreCase(StringManager.ARG_UPDATE)) {
				stlib.cout("Finishing update...");
				UpdateCore.setDidUpdate(true);
			} else {
				stlib.cout("Unknown argument(s) provided! Continuing as normal...");
			}
		}
		createMainFrame();
		Startup.run();
	}

	private static void init() {
		// external lib
		stlib = new STLib();
		stlibSwing = new STLibSwing();
		stlibFile = new STLibFile();
		stlibGraphics = new STLibGraphics();
		stlibString = new STLibString();
		jsonParser = new JSONParser();

		// this
		jsonManager = new JSONManager();
		StringManager.init();
		FileManager.init(); // requires StringManager.init()
		CommandHandler.init();
		Utils.init();
		BuildType.init(); // requires StringManager.init()
		ThisBuild.init(); // requires StringManager.init() and BuildType.init()

		Structure.verifyDirectories();
		Settings.loadToggles(false);
		
	}

	private static void createMainFrame() {
		// init() should have already been called
		frame = new JFrame(
				"Marketplace " + ThisBuild.getVersion().getString() + " " + ThisBuild.getType().getPrettyString());
		stlibSwing.setSystemLookAndFeel(frame);
		frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		frame.setMinimumSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		stlibSwing.centerFrame(frame);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.add(new Marketplace(), null);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(JFrame.class.getResource("/icon64.png")));
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent windowEvent) {
				close();
			}
		});
	}

	public static void restart() {
		Utils.println("Restarting...", Utils.INFO);
		Utils.launchSelf();
		close();
	}

	public static void restart(String arg) {
		Utils.println("Restarting with arg \"" + arg + "\"...", Utils.INFO);
		Utils.launchThisJar(arg);
		close();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
	}

	public static void updateEULA() {
		eulaPane.setText(getPaneContent("eula"));
		eulaScrollPane.getVerticalScrollBar().setValue(0);
	}

	public static void updateNews() {
		newsPane.setText(getPaneContent("news"));
		newsScrollPane.getVerticalScrollBar().setValue(0);
	}

	public static void updateAppList() {
		if (!appList.isEnabled())
			appList.setEnabled(true);
		if (!FileManager.APPS_FILE.exists()) {
			Utils.handleError("Failed to update app list (apps.json doesn't exist!)");
			return;
		}
		try {
			AppFetcher.readAppData();
			int n = AppFetcher.getNumberOfApps();
			applications = new Application[n];
			String[] listData = new String[n];
			for (int i = 0; i < n; i++) {
				Application app = AppFetcher.getApp(i);
				listData[i] = app.getCellListData();
				applications[i] = app;
			}
			updateAppListObject(listData);
		} catch (Exception e) {
			Utils.handleException(e);
		}
		FileManager.APPS_FILE.delete();
	}

	private static void updateAppListObject(String[] datalist) {
		appList.setListData(datalist);
		appList.setFixedCellHeight(64);
		appList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		appList.setFixedCellWidth(appList.getWidth());
		appList.setCellRenderer(new CellRenderer());
		appList.addMouseListener(new CellMouseListener(appList));
	}

	public static void close() {
		Utils.println("Closing...", Utils.INFO);
		try {
			Structure.cleanDirectory(new File(StringManager.TEMP_DIR), false);
		} catch (IOException e) {
			Utils.handleException(e);
		}
		frame.dispose();
		stlib.systemExit();
	}

	public static void showProgressBar() {
		homeProgressBar.setVisible(true);
		copyrightLabel.setVisible(false);
	}

	public static void hideProgressBar() {
		homeProgressBar.setVisible(false);
		resetProgressString();
		resetProgressValue();
		copyrightLabel.setVisible(true);
	}

	public static boolean progressBarIsShowing() {
		return homeProgressBar.isVisible();
	}

	public static String getProgressString() {
		return homeProgressBar.getString();
	}

	public static int getProgressValue() {
		return homeProgressBar.getValue();
	}

	public static void setProgressString(String s) {
		homeProgressBar.setString(s);
	}

	public static void setProgressValue(int n) {
		homeProgressBar.setValue(n);
	}

	public static void setProgressIndeterminate(boolean b) {
		homeProgressBar.setIndeterminate(b);
	}

	public static void resetProgressString() {
		homeProgressBar.setString("");
	}

	public static void resetProgressValue() {
		homeProgressBar.setValue(0);
	}

	public static void failedToLoadContent() {
		Utils.println("Failed to fetch content files during startup, please try again later!", Utils.ERROR);
		hideProgressBar();
		appList.setListData(new String[] { StringManager.NO_CONTENT_HTML });
		eulaPane.setText(StringManager.NO_CONTENT_HTML);
		newsPane.setText(StringManager.NO_CONTENT_HTML);
		appList.setEnabled(false);
	}

	public static JProgressBar getProgressBar() {
		return homeProgressBar;
	}

	public static Application[] getApplications() {
		return applications;
	}

	public static JFrame getFrame() {
		return frame;
	}

	public static JList<String> getAppList() {
		return appList;
	}

	public static JLabel getCopyrightLabel() {
		return copyrightLabel;
	}

	public JComponent getHomePanel() {

		SpringLayout layout = new SpringLayout();
		JPanel panel = new JPanel(layout);

		Font statusFont = new Font("Arial", Font.PLAIN, 12);
		fontMetrics = getFontMetrics(statusFont);

		homeProgressBar = new JProgressBar(0, 100);
		homeProgressBar.setStringPainted(true);
		homeProgressBar.setString("Loading...");
		homeProgressBar.setIndeterminate(true);

		copyrightLabel = new JLabel(
				"Copyright " + ThisBuild.COPYRIGHT + " " + ThisBuild.getAuthor() + " - All Rights Reserved");
		copyrightLabel.setVisible(false);

		JLabel newsLabel = new JLabel("News and Info");
		newsLabel.setFocusable(false);
		newsPane = new JEditorPane("text/html", StringManager.LOADING_HTML);
		newsPane.setFocusable(false);
		newsPane.setEditable(false);
		newsPane.addHyperlinkListener(new HyperlinkListener() {
			@Override
			public void hyperlinkUpdate(HyperlinkEvent hle) {
				if (HyperlinkEvent.EventType.ACTIVATED.equals(hle.getEventType())) {
					try {
						Desktop.getDesktop().browse(hle.getURL().toURI());
					} catch (Exception e) {
						Utils.handleException(e);
					}
				}
			}
		});

		JLabel appListLabel = new JLabel("Applications");
		appListLabel.setFocusable(false);
		appList = new JList<String>();
		appList.setListData(new String[] { StringManager.LOADING_HTML });
		appList.setFocusable(false);

		CellMouseListener cml = new CellMouseListener(appList);
		if (Settings.FETCH_CONTENT.getValue())
			appList.addMouseListener(cml);
		copyrightLabel.addMouseListener(cml);

		JScrollPane appScrollPane = new JScrollPane(appList);
		appScrollPane.setFocusable(false);

		newsScrollPane = new JScrollPane(newsPane);
		newsScrollPane.setFocusable(false);

		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, copyrightLabel, 0, SpringLayout.HORIZONTAL_CENTER, panel);
		layout.putConstraint(SpringLayout.SOUTH, copyrightLabel, -7, SpringLayout.SOUTH, panel);

		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, homeProgressBar, 0, SpringLayout.HORIZONTAL_CENTER, panel);
		layout.putConstraint(SpringLayout.SOUTH, homeProgressBar, -5, SpringLayout.SOUTH, panel);
		layout.putConstraint(SpringLayout.WEST, homeProgressBar, 5, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.EAST, homeProgressBar, -5, SpringLayout.EAST, panel);

		layout.putConstraint(SpringLayout.EAST, newsScrollPane, -3, SpringLayout.HORIZONTAL_CENTER, panel);
		layout.putConstraint(SpringLayout.WEST, newsScrollPane, 5, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, newsScrollPane, 26, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.SOUTH, newsScrollPane, -8, SpringLayout.NORTH, homeProgressBar);
		layout.putConstraint(SpringLayout.WEST, newsLabel, 7, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, newsLabel, 5, SpringLayout.NORTH, panel);

		layout.putConstraint(SpringLayout.EAST, appScrollPane, -5, SpringLayout.EAST, panel);
		layout.putConstraint(SpringLayout.WEST, appScrollPane, 3, SpringLayout.HORIZONTAL_CENTER, panel);
		layout.putConstraint(SpringLayout.NORTH, appScrollPane, 26, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.SOUTH, appScrollPane, -8, SpringLayout.NORTH, homeProgressBar);
		layout.putConstraint(SpringLayout.WEST, appListLabel, 5, SpringLayout.HORIZONTAL_CENTER, panel);
		layout.putConstraint(SpringLayout.NORTH, appListLabel, 5, SpringLayout.NORTH, panel);

		panel.add(homeProgressBar);
		panel.add(copyrightLabel);
		panel.add(appListLabel);
		panel.add(appScrollPane);
		panel.add(newsLabel);
		panel.add(newsScrollPane);

		return panel;
	}

	public JComponent getEULAPanel() {
		SpringLayout layout = new SpringLayout();
		JPanel panel = new JPanel(layout);

		eulaPane = new JEditorPane("text/html", StringManager.LOADING_HTML);
		eulaPane.setFocusable(false);
		eulaPane.setEditable(false);
		eulaPane.addHyperlinkListener(new HyperlinkListener() {
			@Override
			public void hyperlinkUpdate(HyperlinkEvent hle) {
				if (HyperlinkEvent.EventType.ACTIVATED.equals(hle.getEventType())) {
					try {
						Desktop.getDesktop().browse(hle.getURL().toURI());
					} catch (Exception e) {
						Utils.handleException(e);
					}
				}
			}
		});

		eulaScrollPane = new JScrollPane(eulaPane);

		layout.putConstraint(SpringLayout.NORTH, eulaScrollPane, 5, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.SOUTH, eulaScrollPane, -5, SpringLayout.SOUTH, panel);
		layout.putConstraint(SpringLayout.EAST, eulaScrollPane, -5, SpringLayout.EAST, panel);
		layout.putConstraint(SpringLayout.WEST, eulaScrollPane, 5, SpringLayout.WEST, panel);

		panel.add(eulaScrollPane);

		return panel;
	}

	public JComponent getConsolePanel() {
		return Console.getPanel();
	}

	public JComponent getSettingsPanel() {
		return Settings.getPanel();
	}

	public JComponent getChangelogPanel() {
		SpringLayout layout = new SpringLayout();
		JPanel panel = new JPanel(layout);

		clPane = new JEditorPane();
		clPane.setFocusable(false);
		clPane.setEditable(false);
		clPane.addHyperlinkListener(new HyperlinkListener() {
			@Override
			public void hyperlinkUpdate(HyperlinkEvent hle) {
				if (HyperlinkEvent.EventType.ACTIVATED.equals(hle.getEventType())) {
					try {
						Desktop.getDesktop().browse(hle.getURL().toURI());
					} catch (Exception e) {
						Utils.handleException(e);
					}
				}
			}
		});
		try {
			clPane.setPage("http://egartley.net/projects/marketplace/changelog/");
		} catch (IOException e) {
			Utils.handleException(e);
			clPane.setContentType("text/html");
			clPane.setText(StringManager.NO_CONTENT_HTML);
		}

		clScrollPane = new JScrollPane(clPane);

		layout.putConstraint(SpringLayout.NORTH, clScrollPane, 5, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.SOUTH, clScrollPane, -5, SpringLayout.SOUTH, panel);
		layout.putConstraint(SpringLayout.EAST, clScrollPane, -5, SpringLayout.EAST, panel);
		layout.putConstraint(SpringLayout.WEST, clScrollPane, 5, SpringLayout.WEST, panel);

		panel.add(clScrollPane);

		return panel;
	}

	public static String getPaneContent(String what) {
		String content = StringManager.NO_CONTENT_HTML;
		try {
			JSONObject mainObject = getJSONManager().getDataFileJSONObject();
			JSONObject panesObject = (JSONObject) mainObject.get("panes");
			content = panesObject.get(what).toString();
		} catch (Exception e) {
			Utils.handleException(e);
		}
		return content;
	}

	public static JSONManager getJSONManager() {
		return jsonManager;
	}

	public static JSONParser getJSONParser() {
		return jsonParser;
	}

}