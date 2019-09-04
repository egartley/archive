package net.egartley.beyondorigins.gfx;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;

import net.egartley.beyondorigins.main.Game;

public class Notification{

	private FontMetrics fm;
	public String text = "";
	int time, alpha, alpha2;
	double yy = -36;
	public boolean r1, rendering;

	public Notification(String t) {
		text = t;
	}

	public void tick() {
		time++;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isStarted() {
		return r1;
	}

	public void start() {
		this.r1 = true;
		if (Game.sound) {
			Game.st.playSound(Game.mainDir + "assets\\notification.wav");
		}
		Game.logger.log("Notification: '" + text + "'");
	}

	public void reset() {
		time = 0;
		alpha = 0;
		alpha2 = 0;
		yy = -36;
	}
	
	public void cancel() {
		this.r1 = false;
		this.rendering = false;
	}

	public void render(Graphics g) {
		if (time < 60 * 4) {
			fm = g.getFontMetrics(Game.buttonTextFont);
			if (alpha < 255 - 8) {
				alpha += 8;
			}
			if (alpha2 < 156 - 4) {
				alpha2 += 4;
			}
			if (yy < 0) {
				yy += 2.0;
			}
			g.setColor(new Color(0, 0, 0, alpha2));
			g.fillRect(0, (int) yy, Game.width, 35);
			g.setFont(Game.buttonTextFont);
			g.setColor(new Color(255, 255, 255, alpha));
			g.drawString(text, Game.width / 2 - (fm.stringWidth(text) / 2), (int) yy + 22);
		} else if (time >= 60 * 4 && time < (int) 60 * 4.17) {
			fm = g.getFontMetrics(Game.buttonTextFont);
			if (alpha > 8 || alpha >= 0) {
				alpha -= 8;
			}
			if (alpha2 > 4 || alpha2 >= 0) {
				alpha2 -= 4;
			}
			if (yy <= 0 && yy > -38) {
				yy -= 2.0;
			}
			g.setColor(new Color(0, 0, 0, alpha2));
			g.fillRect(0, (int) yy, Game.width, 35);
			g.setFont(Game.buttonTextFont);
			g.setColor(new Color(255, 255, 255, alpha));
			g.drawString(text, Game.width / 2 - (fm.stringWidth(text) / 2), (int) yy + 22);
		} else if (time >= (int) 60 * 4.17) {
			reset();
			cancel();
		}
	}
	
}