package net.egartley.beyondorigins.maps;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import net.egartley.beyondorigins.gfx.Animate;
import net.egartley.beyondorigins.gfx.ImageManager;
import net.egartley.beyondorigins.main.Game;

public class GrassMap extends Map {
	// private static int sizeX = 53;
	// private static int sizeY = 35;
	// public static int[][] grassmap = new int[sizeX][sizeY];
	public int w, h;
	public int y;
	public int x;
	public static int[][] tiles;
	double waterCount = 2.0D;
	private static Animate a;

	public GrassMap(BufferedImage mapImage, int sx, int sy) {
		a = new Animate();
		x = sx;
		y = sy;
		w = mapImage.getWidth();
		h = mapImage.getHeight();
		load(mapImage);
	}

	public void tick() {
		this.waterCount += 0.2D;
		if (this.waterCount >= 42.0D) {
			this.waterCount = 2.0D;
		}
	}

	private void load(BufferedImage mapImage) {
		tiles = new int[mapImage.getWidth()][mapImage.getHeight()];
		for (int y = 0; y < mapImage.getHeight(); y++) {
			for (int x = 0; x < mapImage.getWidth(); x++) {
				Color c = new Color(mapImage.getRGB(x, y));
				String h = String.format("%02x%02x%02x", c.getRed(), c.getGreen(), c.getBlue());
				switch (h) {
				case "00a012": // grass
					tiles[x][y] = 1;
					break;
				case "00600b": // bush
					tiles[x][y] = 2;
					break;
				case "0e69ce": // water
					tiles[x][y] = 3;
					break;
				case "007f0e": // tree
					tiles[x][y] = 4;
					break;
				default: // default = grass
					tiles[x][y] = 1;
					break;
				}
				// 99 = building
				// 98 = door into main player's house
			}
		}
	}

	public void render(Graphics g) {
		for (int x = 0; x < w; x++) {
			for (int y = 0; y < h; y++) {
				
				int gx = 32 * x - this.x;
				
				if ((gx >= -33) && (gx <= Game.width)) {
					
					int gy = 32 * y - this.y;
					
					if ((gy >= -33) && (gy <= Game.height)) {
						
						int tileID = tiles[x][y];
						
						if (tileID == 1 || tileID == 99 || tileID == 98) {
							g.drawImage(ImageManager.grassFull, gx, gy, null);
						} else if (tileID == 2) {
							g.drawImage(ImageManager.grassBarrier, gx, gy, null);
						} else if (tileID == 3) {
							a.animateTile(g, gx, gy, ImageManager.water, (short) (int) this.waterCount);
						} else if (tileID == 4) {
							g.drawImage(ImageManager.tree, gx, gy, null);
						} else {
							g.setColor(Color.DARK_GRAY);
							g.fillRect(gx, gy, 32, 32);
						}
						
					}
					
				}
				
			}
		}
	}

	public int getTileID(int x, int y) {
		return tiles[x][y];
	}
}
