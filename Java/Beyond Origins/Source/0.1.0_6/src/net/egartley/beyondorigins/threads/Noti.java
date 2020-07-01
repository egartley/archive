package net.egartley.beyondorigins.threads;

import java.awt.Graphics;

import net.egartley.beyondorigins.gfx.Notification;
import net.egartley.beyondorigins.main.Game;

public class Noti extends Thread {

	public static Notification gre = new Notification(
			"Graphics have been reloaded!");
	public static Notification fre = new Notification("null");
	public static Notification aut = new Notification(
			"Game has been auto saved!");
	public static Notification cms = new Notification("Coming Soon!");

	public Noti() {
		this.start();
		this.setPriority(NORM_PRIORITY);;
	}

	public static boolean isNotifying() {
		if (gre.rendering || fre.rendering || aut.rendering || cms.rendering) {
			return true;
		}
		return false;
	}

	public static void startNotify(Notification n) {
		cancelActiveNotification();
		n.start();
	}

	public static void checkNotify() {
		if (gre.isStarted())
			gre.rendering = true;
		if (fre.isStarted())
			fre.rendering = true;
		if (aut.isStarted())
			aut.rendering = true;
		if (cms.isStarted())
			cms.rendering = true;
		if (isNotifying()) {
			getActiveNotification().tick();
		}
	}

	public static void cancelActiveNotification() {
		if (isNotifying()) {
			getActiveNotification().reset();
			getActiveNotification().cancel();
		}
	}

	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		double ns = 16666666.666666666;
		double delta = 0.0D;
		while (Game.running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if (delta >= 1.0D) {
				checkNotify();
				delta -= 1.0D;
				if (System.currentTimeMillis() - timer > 1000L) {
					timer += 1000L;
				}
			}
			try {
				Thread.sleep(1L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static Notification getActiveNotification() {
		if (gre.rendering)
			return gre;
		if (fre.rendering)
			return fre;
		if (aut.rendering)
			return aut;
		if (cms.rendering)
			return cms;
		return null;
	}

	public static void render(Graphics g) {
		if (isNotifying()) {
			getActiveNotification().render(g);
		}
	}

}
