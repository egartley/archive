package net.egartley.beyondorigins.quests;

import java.awt.Graphics;

public abstract class Quest {

	public static Quest activeQuest, testQuest;
	
	public static void init() {
		activeQuest = new TestQuest();
	}
	
	public static Quest getActiveQuest() {
		return activeQuest;
	}
	
	public void render(Graphics g) {
		activeQuest.render(g);
	}

}
