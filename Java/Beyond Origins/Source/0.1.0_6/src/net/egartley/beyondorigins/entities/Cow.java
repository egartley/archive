package net.egartley.beyondorigins.entities;

import java.awt.Graphics;
import java.util.Random;

import net.egartley.beyondorigins.gfx.ImageManager;
import net.egartley.beyondorigins.main.Game;

public class Cow extends Entity{
	Random r = new Random();
	private int r1;
	public static float cowX = 300.0F;
	public static float cowY = 300.0F;
	public static float renderX;
	public static float renderY;
	private static double cowSpeed = 1.0;
	public int x;
	public int y;
	private boolean up;
	private boolean down;
	private boolean left;
	private boolean right;
	private int upCount = 1;
	private int downCount = 1;
	private int leftCount = 1;
	private int rightCount = 1;
	private static int lastDir = 0;
	private static int stop = 0;
	private static boolean isStopped = false;
	private static int time = 0;
	private static int time2 = 0;

	public Cow() {

	}

	public void tick() {
		time += 1;
		time2 += 1;
		if (time == 1) {
			this.r1 = this.r.nextInt(101);
		}
		if (time == 100) {
			time = 0;

			isStopped = !isStopped;
			if (isStopped) {
				if (this.up) {
					stop = 1;
				}
				if (this.down) {
					stop = 2;
				}
				if (this.left) {
					stop = 3;
				}
				if (this.right) {
					stop = 4;
				}
			} else {
				stop = 0;
			}
		}
		if (time2 == 4) {
			time2 = 0;
		}
		if ((this.r1 <= 24) && (stop == 0) && (cowY >= 11.0F)) {
			this.up = true;
		} else {
			this.up = false;
		}
		if ((this.r1 <= 49) && (this.r1 > 24) && (stop == 0)
				&& (cowY <= 969.0F)) {
			this.down = true;
		} else {
			this.down = false;
		}
		if ((this.r1 <= 74) && (this.r1 > 49) && (stop == 0) && (cowX >= 11.0F)) {
			this.left = true;
		} else {
			this.left = false;
		}
		if ((this.r1 <= 99) && (this.r1 > 74) && (stop == 0)
				&& (cowX <= 780.0F)) {
			this.right = true;
		} else {
			this.right = false;
		}
		if (this.up) {
			this.upCount += 1;
			if (time2 != 1) {
				cowY -= (int) cowSpeed;
			}
			if (this.upCount == 42) {
				this.upCount = 1;
			}
			lastDir = 1;
		} else {
			this.upCount = 0;
		}
		if (this.down) {
			this.downCount += 1;
			if (time2 != 1) {
				cowY += (int) cowSpeed;
			}
			if (this.downCount == 42) {
				this.downCount = 1;
			}
			lastDir = 2;
		} else {
			this.downCount = 0;
		}
		if (this.left) {
			this.leftCount += 1;
			if (time2 != 1) {
				cowX -= (int) cowSpeed;
			}
			if (this.leftCount == 42) {
				this.leftCount = 1;
			}
			lastDir = 3;
		} else {
			this.leftCount = 0;
		}
		if (this.right) {
			this.rightCount += 1;
			if (time2 != 1) {
				cowX += (int) cowSpeed;
			}
			if (this.rightCount == 42) {
				this.rightCount = 1;
			}
			lastDir = 4;
		} else {
			this.rightCount = 0;
		}
		if (stop == 1 || stop == 2 || stop == 3 || stop == 4) {
			this.up = false;
			this.down = false;
			this.left = false;
			this.right = false;
			lastDir = stop;
		}
	}

	public void render(Graphics g) {
		renderX = cowX - Game.getMap().x;
		renderY = cowY - Game.getMap().y;
		if ((this.upCount >= 1) && (this.upCount <= 11)) {
			g.drawImage(ImageManager.cow_up[1], (int) renderX, (int) renderY,
					32, 32, null);
		}
		if ((this.upCount >= 12) && (this.upCount <= 21)) {
			g.drawImage(ImageManager.cow_up[2], (int) renderX, (int) renderY,
					32, 32, null);
		}
		if ((this.upCount >= 22) && (this.upCount <= 31)) {
			g.drawImage(ImageManager.cow_up[3], (int) renderX, (int) renderY,
					32, 32, null);
		}
		if ((this.upCount >= 32) && (this.upCount <= 41)) {
			g.drawImage(ImageManager.cow_up[4], (int) renderX, (int) renderY,
					32, 32, null);
		}
		if ((this.downCount >= 1) && (this.downCount <= 11) && (this.down)) {
			g.drawImage(ImageManager.cow_down[1], (int) renderX, (int) renderY,
					32, 32, null);
		}
		if ((this.downCount >= 12) && (this.downCount <= 21) && (this.down)) {
			g.drawImage(ImageManager.cow_down[2], (int) renderX, (int) renderY,
					32, 32, null);
		}
		if ((this.downCount >= 22) && (this.downCount <= 31) && (this.down)) {
			g.drawImage(ImageManager.cow_down[3], (int) renderX, (int) renderY,
					32, 32, null);
		}
		if ((this.downCount >= 32) && (this.downCount <= 41) && (this.down)) {
			g.drawImage(ImageManager.cow_down[4], (int) renderX, (int) renderY,
					32, 32, null);
		}
		if ((this.leftCount >= 1) && (this.leftCount <= 11) && (this.left)) {
			g.drawImage(ImageManager.cow_left[1], (int) renderX, (int) renderY,
					32, 32, null);
		}
		if ((this.leftCount >= 12) && (this.leftCount <= 21) && (this.left)) {
			g.drawImage(ImageManager.cow_left[2], (int) renderX, (int) renderY,
					32, 32, null);
		}
		if ((this.leftCount >= 22) && (this.leftCount <= 31) && (this.left)) {
			g.drawImage(ImageManager.cow_left[3], (int) renderX, (int) renderY,
					32, 32, null);
		}
		if ((this.leftCount >= 32) && (this.leftCount <= 41) && (this.left)) {
			g.drawImage(ImageManager.cow_left[4], (int) renderX, (int) renderY,
					32, 32, null);
		}
		if ((this.rightCount >= 1) && (this.rightCount <= 11) && (this.right)) {
			g.drawImage(ImageManager.cow_right[1], (int) renderX,
					(int) renderY, 32, 32, null);
		}
		if ((this.rightCount >= 12) && (this.rightCount <= 21) && (this.right)) {
			g.drawImage(ImageManager.cow_right[2], (int) renderX,
					(int) renderY, 32, 32, null);
		}
		if ((this.rightCount >= 22) && (this.rightCount <= 31) && (this.right)) {
			g.drawImage(ImageManager.cow_right[3], (int) renderX,
					(int) renderY, 32, 32, null);
		}
		if ((this.rightCount >= 32) && (this.rightCount <= 41) && (this.right)) {
			g.drawImage(ImageManager.cow_right[4], (int) renderX,
					(int) renderY, 32, 32, null);
		}
		if ((lastDir == 0) && (!this.up) && (!this.down) && (!this.left)
				&& (!this.right)) {
			g.drawImage(ImageManager.cow_down[1], (int) renderX, (int) renderY,
					32, 32, null);
		}
		if ((lastDir == 1) && (!this.up)) {
			g.drawImage(ImageManager.cow_up[1], (int) renderX, (int) renderY,
					32, 32, null);
		}
		if ((lastDir == 2) && (!this.down)) {
			g.drawImage(ImageManager.cow_down[1], (int) renderX, (int) renderY,
					32, 32, null);
		}
		if ((lastDir == 3) && (!this.left)) {
			g.drawImage(ImageManager.cow_left[1], (int) renderX, (int) renderY,
					32, 32, null);
		}
		if ((lastDir == 4) && (!this.right)) {
			g.drawImage(ImageManager.cow_right[1], (int) renderX,
					(int) renderY, 32, 32, null);
		}
	}
}