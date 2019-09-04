package net.egartley.beyondorigins.gfx;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Animate {

	private BufferedImage cf;
	private short time;

	public boolean flashRequest = false;

	public void animateEntity(Graphics g, int x, int y, BufferedImage[] frame,
			short count) {
		for(int i = 1; i < frame.length; i++) {
			int c = i * 10 + 1;
			int cc = c - 9;
			if (count >= cc && count <= c) {
				g.drawImage(frame[i], x, y, null);
				cf = frame[i];
			}
		}
	}

	public void animateTile(Graphics g, int x, int y, BufferedImage[] frame,
			short count) {
		for(int i = 1; i < frame.length; i++) {
			int c = i * 10 + 1;
			int cc = c - 9;
			if (count >= cc && count <= c) {
				g.drawImage(frame[i], x, y, null);
				cf = frame[i];
			}
		}
	}

	
	public void imageBreak(Graphics g, BufferedImage i, short x, short y) {
		/*
		 * BufferedImage c1 = i.getSubimage(0, 0, 16, 16); BufferedImage c2 =
		 * i.getSubimage(16, 0, 16, 16); BufferedImage c3 = i.getSubimage(16,
		 * 16, 16, 16); BufferedImage c4 = i.getSubimage(0, 16, 16, 16);
		 * 
		 * short c1x = x, c1y = y, c2x = (short) (x + 16), c2y = y; short c3x =
		 * (short) (x + 16), c3y = (short) (y + 16), c4x = x, c4y = (short) (y +
		 * 16);
		 */
	}

	public BufferedImage getCurrentFrame() {
		return cf;
	}

	public void imageFlash(Graphics g, BufferedImage image, float ex, float ey,
			Color c) {
		g.setColor(c);
		for (int x = 0; x < image.getWidth(); x++) {
			for (int y = 0; y < image.getHeight(); y++) {
				if (!isTransparent(x, y, image)) {
					g.fillRect((int) ex + x, (int) ey + y, 1, 1);
				}
			}
		}
		time++;
		if (time >= 0.5 * 60) {
			flashRequest = false;
			time = 0;
		}
	}

	public boolean isTransparent(int x, int y, BufferedImage i) {
		int pixel = i.getRGB(x, y);
		if ((pixel >> 24) == 0x00) {
			return true;
		}
		return false;
	}

}
