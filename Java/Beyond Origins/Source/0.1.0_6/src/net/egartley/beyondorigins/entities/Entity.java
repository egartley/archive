package net.egartley.beyondorigins.entities;

import net.egartley.beyondorigins.main.Game;

public abstract class Entity {
	public static Player player;
	public static TestDummy td;
	public static Paige pge;

	public static void init() {
		player = new Player(129, 197, 400, 256);
		td = new TestDummy();
		pge = new Paige();
	}

	public static void checkData() {
		if (Game.getProgress() == 1) {
			pge.setCords(500, 100);
		}
	}
}
