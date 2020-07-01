package net.egartley.beyondorigins.entities;

import java.awt.Graphics;

import net.egartley.beyondorigins.gfx.ImageManager;

public class Cloud extends Entity{
	
	public double x, y, sx;
	
	public Cloud(double x, double y) {
		this.x = x;
		this.y = y;
		
		this.sx = x;
	}
	
	public void tick(int bx, double speed, int i) {
		if (i == 1) {
			if (x < bx) {
				x += speed;
			} else {
				x = sx;
			}
		} else if (i == 0) {
			if (x > bx) {
				x -= speed;
			} else {
				x = sx;
			}
		}
	}

	public void render(Graphics g) {
		g.drawImage(ImageManager.cloud1, (int) x, (int) y, null);
	}
	
}
