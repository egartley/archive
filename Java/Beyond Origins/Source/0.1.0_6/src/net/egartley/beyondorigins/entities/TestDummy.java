package net.egartley.beyondorigins.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import net.egartley.beyondorigins.gfx.Animate;
import net.egartley.beyondorigins.gfx.ImageManager;
import net.egartley.beyondorigins.main.Game;

public class TestDummy extends Entity{

	private Random r = new Random();
	private int num;
	private static Random r2 = new Random();
	private static int num2;

	public static boolean isDead = false, test, flashRequest;
	public static BufferedImage cf;

	private static Animate a;

	// movement
	public static float x = 200, y = 200, rx, ry;
	public static byte upCount = 1, downCount = 1, leftCount = 1,
			rightCount = 1;
	public static boolean up, down, left, right, stopped;
	public static byte lastDir, speed, t, t2, stop;

	// health
	public static double maxHealth = 20.0, health = 20.0;

	// combat
	private static int attackRadius = 32;

	public TestDummy() {
		a = new Animate();
	}

	public static void kill() {
		if (isDead == false) {
			num2 = r2.nextInt(5);
			Game.getPlayer().exp += (15 + num2);
		}
		isDead = true;
	}

	public static void takeDamage(double d) {
		if (!isDead)
			a.flashRequest = true;
		if (health >= d)
			health -= d;
		if (health <= d)
			kill();
	}

	public static void dealDamage() {
		t2++;
		if (t2 >= 42) {
			Game.getPlayer().takeDamage(2.0);
			t2 = 0;
		}
	}

	public static void reset() {
		isDead = false;
		health = maxHealth;
	}

	private void decideMovement(int n) {
		if (n == 0 && stop == 0 && y >= 11) {
			up = true;
		} else
			up = false;
		if (n == 1 && stop == 0 && y <= 969) {
			down = true;
		} else
			down = false;
		if (n == 2 && stop == 0 && x >= 11) {
			left = true;
		} else
			left = false;
		if (n == 3 && stop == 0 && x <= 780) {
			right = true;
		} else
			right = false;
	}

	public void tick() {
		if (!isDead) {

			// spawn fix
			if (lastDir == 0)
				lastDir = 2;

			// off map fix
			if (y <= 11) {
				up = false;
				down = true;
			}
			if (y >= 969) {
				down = false;
				up = true;
			}
			if (x <= 11) {
				left = false;
				right = true;
			}
			if (x >= 1000) {
				right = false;
				left = true;
			}

			t += 1;
			if (t == 35) {
				num = r.nextInt(4);
				decideMovement(num);
			}
			if (t >= 200) {
				t = 0;
				stopped = !stopped;
				if (stopped) {
					if (up) {
						stop = 1;
					}
					if (down) {
						stop = 2;
					}
					if (left) {
						stop = 3;
					}
					if (right) {
						stop = 4;
					}
				} else {
					stop = 0;
				}
			}

			// move(up, 1, upCount);
			// move(down, 2, downCount);
			// move(left, 3, leftCount);
			// move(right, 4, rightCount);

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

		if ((Math.sqrt((rx - Game.getPlayer().x) * (rx - Game.getPlayer().x)
				+ (ry - Game.getPlayer().y) * (ry - Game.getPlayer().y)) <= attackRadius)) {
			dealDamage();
		}
	}

	public void render(Graphics g) {

		if (!isDead) {
			rx = x - Game.getMap().x;
			ry = y - Game.getMap().y;
			if (rx >= -33 && ry >= -33 && rx <= Game.width && ry <= Game.height) {
				a.animateEntity(g, (int) rx, (int) ry,
						ImageManager.testDummy_up, upCount);
				a.animateEntity(g, (int) rx, (int) ry,
						ImageManager.testDummy_down, downCount);
				a.animateEntity(g, (int) rx, (int) ry,
						ImageManager.testDummy_left, leftCount);
				a.animateEntity(g, (int) rx, (int) ry,
						ImageManager.testDummy_right, rightCount);
				if (!up && lastDir == 1) {
					g.drawImage(ImageManager.testDummy_up[1], (int) rx,
							(int) ry, null);
					cf = ImageManager.testDummy_up[1];
				}
				if (!down && lastDir == 2) {
					g.drawImage(ImageManager.testDummy_down[1], (int) rx,
							(int) ry, null);
					cf = ImageManager.testDummy_down[1];
				}
				if (!left && lastDir == 3) {
					g.drawImage(ImageManager.testDummy_left[1], (int) rx,
							(int) ry, null);
					cf = ImageManager.testDummy_left[1];
				}
				if (!right && lastDir == 4) {
					g.drawImage(ImageManager.testDummy_right[1], (int) rx,
							(int) ry, null);
					cf = ImageManager.testDummy_right[1];
				}
				if (a.flashRequest) {
					a.imageFlash(g, a.getCurrentFrame(), rx, ry, new Color(255,
							0, 0, 128));
				}
			}

		}

	}

}
