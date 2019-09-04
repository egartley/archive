package net.egartley.boota.settings;

import javax.swing.*;

public class Toggle {

	/*
	 * © 2015 Evan Gartley - All Rights Reserved
	 */

	JCheckBox checkBox;
	String name;
	boolean defaultValue, requiresRestart, value;
	
	public Toggle(String name, boolean defaultVal, boolean requiresRestart) {
		this.name = name;
		this.defaultValue = defaultVal;
		this.value = defaultVal;
		this.requiresRestart = requiresRestart;
		Settings.getToggleList().add(this);
	}

	public void setValue(boolean newVal, boolean checkbox) {
		value = newVal;
		if (checkbox) {
			checkBox.setSelected(newVal);
		}
	}
	
	public void setCheckBox(JCheckBox cb) {
		checkBox = cb;
	}
	
	public boolean getValue() {
		return value;
	}

	public boolean getDefaultValue() {
		return defaultValue;
	}

	public boolean getDoesRequireRestart() {
		return requiresRestart;
	}

	public JCheckBox getCheckBox() {
		return checkBox;
	}

	public String getName() {
		return name;
	}
	
}