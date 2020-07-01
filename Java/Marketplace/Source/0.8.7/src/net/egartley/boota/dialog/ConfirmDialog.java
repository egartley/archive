package net.egartley.boota.dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import net.egartley.boota.Marketplace;
import net.egartley.boota.Utils;

public class ConfirmDialog extends JDialog implements ActionListener{

	/*
	 * © 2016 Evan Gartley - All Rights Reserved
	 */
	
	private static final long serialVersionUID = 1L;
	
	private static AppDetailsDialog appFrame;
	private JButton yesButton, noButton;

	public ConfirmDialog() {
		this.getContentPane().setLayout(null);
		
		JLabel heading = new JLabel("<html><h2>Are you sure?</h2></html>");
		heading.setBounds(45, 30, 170, 48);
		
		yesButton = new JButton("Yes");
		yesButton.setBounds(210, 200 - 96, 96, 27);
		yesButton.setFocusable(false);
		yesButton.addActionListener(this);
		
		noButton = new JButton("No");
		noButton.setBounds(90, 200 - 96, 96, 27);
		noButton.setFocusable(true);
		noButton.addActionListener(this);
		
		add(heading);
		add(yesButton);
		add(noButton);
	}
	
	public static void createFrame(AppDetailsDialog appFrame) {
		ConfirmDialog.appFrame = appFrame;
		JDialog frame = new ConfirmDialog();
		frame.setTitle("Confirmation");
		frame.setSize(350, 200);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		frame.setIconImage(Marketplace.stlibGraphics.loadImage("/agreement.png"));
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			Utils.println(e.getMessage(), Utils.EXCEPTION);
			e.printStackTrace();
		}
		SwingUtilities.updateComponentTreeUI(frame);
	}
	
	public void actionPerformed(ActionEvent e) {
		String ac = e.getActionCommand();
		
		if (ac.equals(yesButton.getActionCommand())) {
			appFrame.uninstallApp();
			this.dispose();
		} else if (ac.equals(noButton.getActionCommand())) {
			this.dispose();
		}
	}
	
}
