package net.egartley.bolauncher;

import javax.swing.*;

public class ConsoleSIM extends JFrame{
	
	/*
	 * Copyright (c) 2014 Evan Gartley - All rights reserved
	 */
	
	private static final long serialVersionUID = 1L;
	public static JTextArea text;
	
	public static void appendText(String newText) {
		// append (add) given String newText to JTextArea text then create new line
		text.append(newText + "\n");
	}

}
