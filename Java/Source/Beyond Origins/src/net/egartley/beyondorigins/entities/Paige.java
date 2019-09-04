package net.egartley.beyondorigins.entities;

import java.awt.*;
import java.awt.image.BufferedImage;

import net.egartley.beyondorigins.gfx.Animate;
import net.egartley.beyondorigins.gfx.ImageManager;
import net.egartley.beyondorigins.main.Game;

public class Paige extends Entity {

	private static Animate a;
	public static BufferedImage cf;

	// movement
	public static float x = 200, y = 200, rx, ry;
	public static byte upCount = 1, downCount = 1, leftCount = 1,
			rightCount = 1;
	public static boolean up, down, left, right, stopped;
	public static byte lastDir, speed, t, t2, stop;

	public Paige() {
		a = new Animate();
	}

	public void tick() {
		if (up) {
			upCount += 1;
			y -= 1;
			if (upCount == 42) {
				upCount = 1;
			}
			lastDir = 1;
		} else
			upCount = 0;

		if (down) {
			downCount += 1;
			y += 1;
			if (downCount == 42) {
				downCount = 1;
			}
			lastDir = 2;
		} else
			downCount = 0;

		if (left) {
			leftCount += 1;
			x -= 1;
			if (leftCount == 42) {
				leftCount = 1;
			}
			lastDir = 3;
		} else
			leftCount = 0;

		if (right) {
			rightCount += 1;
			x += 1;
			if (rightCount == 42) {
				rightCount = 1;
			}
			lastDir = 4;
		} else
			rightCount = 0;
	}

	public void setCords(int x, int y) {
		Paige.x = x;
		Paige.y = y;
	}

	public void render(Graphics g) {
		rx = x - Game.getMap().x;
		ry = y - Game.getMap().y;
		if (rx >= -33 && ry >= -33 && rx <= Game.width && ry <= Game.height) {
			a.animateEntity(g, (int) rx, (int) ry, ImageManager.paige_up,
					upCount);
			a.animateEntity(g, (int) rx, (int) ry, ImageManager.paige_down,
					downCount);
			a.animateEntity(g, (int) rx, (int) ry, ImageManager.paige_left,
					leftCount);
			a.animateEntity(g, (int) rx, (int) ry, ImageManager.paige_right,
					rightCount);
			if (!up && lastDir == 1) {
				g.drawImage(ImageManager.paige_up[1], (int) rx, (int) ry, null);
				cf = ImageManager.paige_up[1];
			}
			if (!down && lastDir == 2) {
				g.drawImage(ImageManager.paige_down[1], (int) rx, (int) ry,
						null);
				cf = ImageManager.paige_down[1];
			}
			if (!left && lastDir == 3) {
				g.drawImage(ImageManager.paige_left[1], (int) rx, (int) ry,
						null);
				cf = ImageManager.paige_left[1];
			}
			if (!right && lastDir == 4) {
				g.drawImage(ImageManager.paige_right[1], (int) rx, (int) ry,
						null);
				cf = ImageManager.paige_right[1];
			}
			if (!up && !down && !left && !right && lastDir == 0) {
				g.drawImage(ImageManager.paige_down[1], (int) rx, (int) ry,
						null);
				cf = ImageManager.paige_down[1];
			}
		}
	}

}
