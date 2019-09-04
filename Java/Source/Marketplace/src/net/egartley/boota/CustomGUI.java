package net.egartley.boota;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JComponent;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicGraphicsUtils;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

public class CustomGUI extends BasicTabbedPaneUI {

	/*
	 * © 2015 Evan Gartley - All Rights Reserved
	 */

	private static final Insets NO_INSETS = new Insets(0, 0, 0, 0);
	public static Color selectedColor = new Color(51, 168, 255);
	private Insets contentInsets = new Insets(10, 10, 10, 10);
	private int lastRollOverTab = -1;

	public static ComponentUI createUI(JComponent c) {
		return new CustomGUI();
	}

	public CustomGUI() {
		setContentInsets(0);
	}

	public void setContentInsets(Insets i) {
		contentInsets = i;
	}

	public void setContentInsets(int i) {
		contentInsets = new Insets(i, i, i, i);
	}

	public int getTabRunCount(JTabbedPane pane) {
		return 1;
	}

	@Override
	protected void installDefaults() {
		super.installDefaults();

		RollOverListener l = new RollOverListener();
		tabPane.addMouseListener(l);
		tabPane.addMouseMotionListener(l);

		tabAreaInsets = NO_INSETS;
		tabInsets = new Insets(0, 0, 0, 0);
	}

	protected boolean scrollableTabLayoutEnabled() {
		return true;
	}

	@Override
	protected Insets getContentBorderInsets(int tabPlacement) {
		return contentInsets;
	}

	@Override
	protected int calculateTabHeight(int tabPlacement, int tabIndex, int fontHeight) {
		return 32;
	}

	@Override
	protected int calculateTabWidth(int tabPlacement, int tabIndex, FontMetrics metrics) {
		int w = Marketplace.getFrame().getWidth() - 18;
		int count = Marketplace.tabbedPane.getTabCount();
		return (int) w / count;
	}

	@Override
	protected int calculateMaxTabHeight(int tabPlacement) {
		return super.calculateMaxTabHeight(tabPlacement);
	}

	@Override
	protected void paintTabArea(Graphics g, int tabPlacement, int selectedIndex) {
		g.setColor(UIManager.getColor("TabbedPane.background"));
		g.fillRect(0, 0, tabPane.getWidth(), tabPane.getHeight());
		super.paintTabArea(g, tabPlacement, selectedIndex);
	}

	@Override
	protected void paintText(Graphics g, int tabPlacement, java.awt.Font font, FontMetrics metrics, int tabIndex,
			String title, Rectangle textRect, boolean isSelected) {
		g.setColor(Color.black);
		g.setFont(font);
		int ascent = metrics.getAscent();
		int memIndex = tabPane.getDisplayedMnemonicIndexAt(tabIndex);
		if (tabPane.isEnabled() && tabPane.isEnabledAt(tabIndex)) {
			if (memIndex != -1)
				BasicGraphicsUtils.drawStringUnderlineCharAt(g, title, memIndex, textRect.x, textRect.y);
			else {
				g.drawString(title, textRect.x, textRect.y + ascent);
			}
		} else {
			if (memIndex != -1)
				BasicGraphicsUtils.drawStringUnderlineCharAt(g, title, memIndex, textRect.x, textRect.y);
			else {
				g.drawString(title, textRect.x, textRect.y + ascent);
			}

			if (memIndex != -1)
				BasicGraphicsUtils.drawStringUnderlineCharAt(g, title, memIndex, textRect.x + 1,
						textRect.y + 1 + ascent);
			else {
				g.drawString(title, textRect.x + 1, textRect.y + 1 + ascent);
			}
		}
	}

	@Override
	protected void paintTabBackground(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h,
			boolean isSelected) {
		Graphics2D g2d = (Graphics2D) g;
		Rectangle rect = rects[tabIndex];
		if (isSelected || getRolloverTab() == tabIndex) {
			g2d.setColor(UIManager.getColor("TabbedPane.background"));
		} else {
			g2d.setColor(UIManager.getColor("TabbedPane.light"));
		}
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.fillRect(rect.x, 0, rect.width, rect.height);
	}

	@Override
	protected void paintTabBorder(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h,
			boolean isSelected) {
		g.drawRect(x, y, w, h);
	}

	@Override
	protected void paintContentBorderTopEdge(Graphics g, int tabPlacement, int selectedIndex, int x, int y, int w,
			int h) {}

	@Override
	protected void paintContentBorderRightEdge(Graphics g, int tabPlacement, int selectedIndex, int x, int y, int w,
			int h) {}

	@Override
	protected void paintContentBorderLeftEdge(Graphics g, int tabPlacement, int selectedIndex, int x, int y, int w,
			int h) {}

	@Override
	protected void paintContentBorderBottomEdge(Graphics g, int tabPlacement, int selectedIndex, int x, int y, int w,
			int h) {}

	@Override
	protected void paintFocusIndicator(Graphics g, int tabPlacement, Rectangle[] rects, int tabIndex,
			Rectangle iconRect, Rectangle textRect, boolean isSelected) {}

	@Override
	protected int getTabLabelShiftY(int tabPlacement, int tabIndex, boolean isSelected) {return 0;}

	private class RollOverListener implements MouseMotionListener, MouseListener {
		public void mouseDragged(MouseEvent e) {}

		public void mouseMoved(MouseEvent e) {checkRollOver();}

		public void mouseClicked(MouseEvent e) {}

		public void mousePressed(MouseEvent e) {}

		public void mouseReleased(MouseEvent e) {}

		public void mouseEntered(MouseEvent e) {checkRollOver();}

		public void mouseExited(MouseEvent e) {checkRollOver();}

		private void checkRollOver() {
			int currentRollOver = getRolloverTab();
			if (currentRollOver != lastRollOverTab) {
				lastRollOverTab = currentRollOver;
				Rectangle tabsRect = new Rectangle(0, 0, tabPane.getWidth(), tabPane.getHeight());
				tabPane.repaint(tabsRect);
			}
		}
	}
}