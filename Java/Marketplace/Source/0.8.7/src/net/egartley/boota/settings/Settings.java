package net.egartley.boota.settings;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import net.egartley.boota.Marketplace;
import net.egartley.boota.StringManager;
import net.egartley.boota.Utils;
import net.egartley.boota.files.FileManager;
import net.egartley.boota.update.UpdateCore;

public class Settings implements ActionListener {

	/*
	 * © 2015 Evan Gartley - All Rights Reserved
	 */

	private static JButton checkNow;

	private static ArrayList<Toggle> toggles = new ArrayList<Toggle>();
	public static Toggle AUTO_UPDATE = new Toggle("autoUpdate", true, false);
	public static Toggle ADVANCED_MODE = new Toggle("advancedMode", false, true);
	public static Toggle GET_PRE_BUILDS = new Toggle("getPreBuilds", false, false);
	public static Toggle EXTRA_UPDATE_FEEDBACK = new Toggle("extraUpdateFeedback", false, false);
	public static Toggle FETCH_CONTENT = new Toggle("fetchContent", true, true);

	// new toggle todo
	// setupToggle(), add() in getPanel()

	public static JComponent getPanel() {
		SpringLayout l = new SpringLayout();
		JPanel panel = new JPanel(l);

		// update
		JLabel updateLabel = new JLabel("Updates");
		updateLabel.setFocusable(false);
		updateLabel.setBounds(50, 30, 100, 38);
		updateLabel.setFont(new Font("Arial", Font.PLAIN, 16));

		setupToggle(l, panel, AUTO_UPDATE, "Check for new Marketplace builds on startup", true, 0, 0,
				"Check for new builds upon startup");
		l.putConstraint(SpringLayout.WEST, updateLabel, 5, SpringLayout.WEST, AUTO_UPDATE.getCheckBox());
		l.putConstraint(SpringLayout.SOUTH, updateLabel, -24, SpringLayout.NORTH, AUTO_UPDATE.getCheckBox());

		checkNow = new JButton("Check now");
		checkNow.setFocusable(false);
		checkNow.addActionListener(new Settings());
		checkNow.setToolTipText("Check for a new Marketplace build now");
		l.putConstraint(SpringLayout.WEST, checkNow, 32, SpringLayout.WEST, AUTO_UPDATE.getCheckBox());
		l.putConstraint(SpringLayout.NORTH, checkNow, 6, SpringLayout.SOUTH, AUTO_UPDATE.getCheckBox());

		setupToggle(l, panel, GET_PRE_BUILDS, "Get pre-release builds", true, 2, 0,
				"Receive pre-release builds, in addition to stable builds");
		UpdateCore.syncChannel();

		setupToggle(l, panel, EXTRA_UPDATE_FEEDBACK, "Output additional feedback when updating", true, 3, 0,
				"Output additional feedback when checking for updates");

		// other
		JLabel otherLabel = new JLabel("Other");
		otherLabel.setFocusable(false);
		otherLabel.setFont(new Font("Arial", Font.PLAIN, 16));

		setupToggle(l, panel, ADVANCED_MODE, "Advanced mode", true, 0, 1, "Turn on advanced features and additions");
		setupToggle(l, panel, FETCH_CONTENT, "Fetch content", true, 1, 1,
				"Fetch online content during startup (experimental)");

		l.putConstraint(SpringLayout.WEST, otherLabel, 5, SpringLayout.WEST, ADVANCED_MODE.getCheckBox());
		l.putConstraint(SpringLayout.SOUTH, otherLabel, -24, SpringLayout.NORTH, ADVANCED_MODE.getCheckBox());

		panel.add(updateLabel);
		panel.add(AUTO_UPDATE.getCheckBox());
		panel.add(checkNow);
		panel.add(GET_PRE_BUILDS.getCheckBox());
		panel.add(EXTRA_UPDATE_FEEDBACK.getCheckBox());
		panel.add(otherLabel);
		panel.add(ADVANCED_MODE.getCheckBox());
		panel.add(FETCH_CONTENT.getCheckBox());

		return panel;
	}

	private static void setupToggle(SpringLayout l, JPanel panel, Toggle t, String label, boolean enable, int index,
			int col, String tt) {
		t.setCheckBox(new JCheckBox());
		if (t.getDoesRequireRestart()) {
			t.getCheckBox().setText(label + " (Requires restart)");
		} else {
			t.getCheckBox().setText(label);
		}
		t.getCheckBox().setToolTipText(tt);
		t.getCheckBox().setFocusable(false);
		t.getCheckBox().setBounds(50 + (320 * col), 68 + (30 * index), Marketplace.fontMetrics.stringWidth(label) + 24,
				32);
		t.getCheckBox().addActionListener(new Settings());
		t.getCheckBox().setActionCommand(t.getName());
		t.getCheckBox().setEnabled(enable);
		if (col == 0)
			l.putConstraint(SpringLayout.WEST, t.getCheckBox(), -256, SpringLayout.HORIZONTAL_CENTER, panel);
		else if (col == 1) {
			l.putConstraint(SpringLayout.WEST, t.getCheckBox(), 32, SpringLayout.HORIZONTAL_CENTER, panel);
		}
		l.putConstraint(SpringLayout.NORTH, t.getCheckBox(), -68 + 30 * index, SpringLayout.VERTICAL_CENTER, panel);
		t.getCheckBox().setSelected(t.getValue());
	}

	public static void loadToggles(boolean applyChanges) {
		if (!FileManager.SETTINGS_FILE.getExists()) {
			loadInDefaultValues(true);
			return;
		}
		loadInCurrentValues();
		if (applyChanges)
			applyChange(null);
	}

	private static void loadInDefaultValues(boolean applyChanges) {
		for (int i = 0; i < toggles.size(); i++) {
			Toggle toggle = getToggle(i);
			if (toggle == null) {
				break;
			}
			toggle.setValue(toggle.getDefaultValue(), false);
		}
		if (applyChanges)
			applyChange(null);
	}

	private static void loadInCurrentValues() {
		try {
			JSONArray togglesArray = (JSONArray) Marketplace.getJSONManager().getJSONObject(FileManager.SETTINGS_FILE)
					.get(StringManager.JSON_KEY_SETTINGS_TOGGLES);
			for (int i = 0; i < toggles.size(); i++) {
				if (getToggle(i) == null)
					continue;
				Toggle t = getToggle(i);
				JSONObject curToggleObject = (JSONObject) togglesArray.get(i);
				if (curToggleObject == null) {
					// unknown toggle
					Utils.println("Unknown toggle detected, using default value...", Utils.INFO);
					t.setValue(t.getDefaultValue(), false);
					continue;
				}
				boolean b = Boolean.valueOf(curToggleObject.get(t.getName()).toString());
				t.setValue(b, false);
			}
		} catch (Exception e) {
			Utils.handleException(e);
		}
	}

	private static void applyChange(Toggle t) {
		if (t == null) {
			// default values
			for (int i = 0 ; i < getToggleList().size(); i++) {
				Toggle cur = getToggle(i);
				if (cur == null)
					continue;
				if (cur.getCheckBox() == null) {
					cur.setValue(cur.getDefaultValue(), false);
				} else {
					cur.getCheckBox().setSelected(cur.getValue());
				}
				Marketplace.getJSONManager().settings_writeFile(null);
			}
			return;
		}
		t.setValue(t.getCheckBox().isSelected(), false);
		Marketplace.getJSONManager().settings_writeFile(t);
	}

	public static ArrayList<Toggle> getToggleList() {
		return toggles;
	}
	
	public static Toggle getToggle(String name) {
		for (int i = 0; i < toggles.size(); i++) {
			Toggle toggle = getToggle(i);
			if (name.equalsIgnoreCase(toggle.getName()))
				return toggle;
			else
				continue;
		}
		return null;
	}

	public static Toggle getToggle(int i) {
		return toggles.get(i);
	}

	public void actionPerformed(ActionEvent e) {
		String ac = e.getActionCommand();
		if (ac.equals(checkNow.getActionCommand())) {
			// pressed check now button
			Utils.runInNewThread(new Runnable() {
				public void run() {
					UpdateCore.check(true);
				}
			});
			return;
		}
		Toggle t = getToggle(ac);
		applyChange(t);
		if (t.getDoesRequireRestart()) {
			Marketplace.restart();
		}
	}

}