package net.egartley.beyondorigins.maps;

import java.awt.Graphics;

public abstract class Map {
	protected int x;
	protected int y;

	public Map() {
	
	}

	public abstract void tick();

	public abstract void render(Graphics g);
}