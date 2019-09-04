package net.egartley.stlib;

import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class STLibSwing {

	/**
	 * Sets the look and feel of the given {@code JFrame} to that of the user's
	 * current operating system, for example Windows 10.
	 * 
	 * @param frame
	 *            The {@code JFrame} in which to apply the change in look and
	 *            feel
	 */
	public void setSystemLookAndFeel(JFrame frame) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		SwingUtilities.updateComponentTreeUI(frame);
	}

	/**
	 * Creates and displays a new JLabel with the given String "text" as its
	 * text.
	 * 
	 * @param frame
	 *            The JFrame in which to display the new JLabel.
	 * @param f
	 *            The Font in which to display the String "t".
	 * @param t
	 *            The text in which to apply to the new JLabel.
	 * @param x
	 *            The x coordinate.
	 * @param y
	 *            The y coordinate.
	 * @param w
	 *            The width of the JLabel.
	 * @param h
	 *            The height of the JLabel.
	 */
	public void addFrameText(JFrame frame, Font f, String t, int x, int y, int w, int h) {
		JLabel l = new JLabel(t);
		l.setBounds(x, y, w, h);
		l.setFont(f);
		l.setOpaque(true);
		frame.add(l);
	}

	/**
	 * Creates and displays a new JLabel with the given String "text" as its
	 * text.
	 * 
	 * @param frame
	 *            The JFrame in which to display the new JLabel.
	 * @param t
	 *            The text in which to apply to the new JLabel.
	 * @param x
	 *            The x coordinate.
	 * @param y
	 *            The y coordinate.
	 * @param w
	 *            The width of the JLabel.
	 * @param h
	 *            The height of the JLabel.
	 */
	public void addFrameText(JFrame frame, String t, int x, int y, int w, int h) {
		JLabel l = new JLabel(t);
		l.setBounds(x, y, w, h);
		l.setOpaque(true);
		frame.add(l);
	}

	/**
	 * Sets the icon image of the given JFrame to the image file located at
	 * String "iconPath".
	 * 
	 * @param frame
	 *            The JFrame in which to apply the change in image icon.
	 * @param iconPath
	 *            The path to the image file.
	 */
	public void setAbsoluteFrameIcon(JFrame frame, String iconPath) {
		/*
		 * Sets the given file to the frame icon of the given JFrame.
		 */
		Image icon = null;
		try {
			icon = (Image) ImageIO.read(new File(iconPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		frame.setIconImage(icon);
	}

	/**
	 * Postions the JFrame in the center of the screen.
	 * 
	 * @param frame
	 *            The JFrame in which to center.
	 */
	public void centerFrame(JFrame frame) {
		frame.setLocationRelativeTo(null);
	}

	/**
	 * Adds a JLabel to JFrame "frame", with only the supplied ImageIcon
	 * "image", no text.
	 * 
	 * @param frame
	 *            The JFrame in which to place the image.
	 * @param image
	 *            The ImageIcon in which to place in the JFrame.
	 * @param x
	 *            The x coordinate.
	 * @param y
	 *            The y coordinate.
	 */
	public void addFrameImage(JFrame frame, ImageIcon image, int x, int y) {
		JLabel logoLabel = new JLabel();
		logoLabel.setIcon(image);
		logoLabel.setBounds(x, y, image.getIconWidth(), image.getIconHeight());
		frame.add(logoLabel);
	}

}
