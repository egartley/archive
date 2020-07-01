package net.egartley.boota.console;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;
import javax.swing.text.DefaultCaret;

import net.egartley.boota.Marketplace;
import net.egartley.boota.input.InputKeyListener;

public class Console extends JFrame {

	/*
	 * © 2015 Evan Gartley - All Rights Reserved
	 */

	private static final long serialVersionUID = 1L;
	public static JTextArea textArea;
	static JTextField inputField;
	private static JScrollPane scrollPane;
	public static String consoleText = "";

	public static void appendText(String newText) {
		String t = newText + "\n";
		if (scrollPane != null) {
			textArea.append(t);
			consoleText = textArea.getText();
			return;
		}
		consoleText += t;
	}

	public static void doCommand() {
		CommandHandler.processInput(inputField.getText());
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				inputField.setText("");
			}
		});
	}

	public static JComponent getPanel() {
		SpringLayout layout = new SpringLayout();
		JPanel panel = new JPanel(layout);

		textArea = new JTextArea(consoleText);
		textArea.setBounds(5, 5, Marketplace.WINDOW_WIDTH - 22, Marketplace.WINDOW_HEIGHT - 98);
		textArea.setFocusable(false);
		textArea.setEditable(false);

		scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(textArea.getBounds());
		scrollPane.setFocusable(false);

		inputField = new JTextField();
		inputField.addKeyListener(new InputKeyListener());
		
		layout.putConstraint(SpringLayout.WEST, inputField, 5, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.SOUTH	, inputField, -5, SpringLayout.SOUTH, panel);
		layout.putConstraint(SpringLayout.NORTH, inputField, -24, SpringLayout.SOUTH, inputField);
		layout.putConstraint(SpringLayout.EAST, inputField, -5, SpringLayout.EAST, panel);
		
		layout.putConstraint(SpringLayout.NORTH, scrollPane, 5, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, scrollPane, 5, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.SOUTH, scrollPane, -5, SpringLayout.NORTH, inputField);
		layout.putConstraint(SpringLayout.EAST, scrollPane, -5, SpringLayout.EAST, panel);

		panel.add(scrollPane);
		panel.add(inputField);
		
		DefaultCaret caret = (DefaultCaret) textArea.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

		return panel;
	}

	public static JScrollPane getScrollPane() {
		return scrollPane;
	}

}
