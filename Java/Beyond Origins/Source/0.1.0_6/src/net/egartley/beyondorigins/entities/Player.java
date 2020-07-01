package net.egartley.beyondorigins.entities;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import net.egartley.beyondorigins.buildings.PlayerHouse;
import net.egartley.beyondorigins.gfx.Animate;
import net.egartley.beyondorigins.gfx.ImageManager;
import net.egartley.beyondorigins.main.Game;
import net.egartley.beyondorigins.menus.F3Menu;

public class Player extends Entity {

	public String name = "Roland";
	public String defaultName = this.name;
	public String typedName = "";
	public double maxHealth = 50.0D, health = 50.0D, damage = 1.5D;
	public byte attackRadius = 32;
	public boolean flashRequest;
	public byte moveCount = 1;
	public short level = 1, exp = 0, maxLevel = 99;
	public int[] expLevels;
	public boolean canMoveUp = true, canMoveDown = true, canMoveLeft = true, canMoveRight = true;
	public int x, y;
	public byte lastDir;
	public static byte catchingUp;
	public boolean up = false, down = false, left = false, right = false;
	public double SPEED = 1.0D;
	public boolean movingUp, movingDown, movingLeft, movingRight;
	public boolean mapMovement = true, insideMovement = false;
	public short mbX = 1232, mbY = 800, pbX = 801, pbY = 1;
	public int tileX, tileY;
	private static Animate a;
	private static FontMetrics fm;
	private static Color hColor;
	public boolean isAttacking = false, isSwimming = false, isInBuilding = false;
	private int hpc = 83, xpc = 83;
	private int regenTime = 60;
	private int time;

	public Player(int x, int y, int mx, int my) {
		this.x = x;
		this.y = y;
		a = new Animate();
		this.expLevels = new int[99];
		this.expLevels[1] = 0;
		this.expLevels[2] = 100;
		this.expLevels[3] = 300;
		this.expLevels[4] = 500;
		this.expLevels[5] = 800;
		this.expLevels[6] = 1100;
		this.expLevels[7] = 1400;
		this.expLevels[8] = 1700;
		this.expLevels[9] = 1900;
		this.expLevels[10] = 2100;
	}

	public void tick() {
		this.time += 1;
		if ((this.time >= this.regenTime) && (this.health < this.maxHealth)) {
			this.health += 0.5D;
			this.time = 0;
			healthBarCheck();
		}
		if ((this.hpc >= 2) || (this.health > 0.0D)) {
			this.hpc = ((int) (this.health * (83.0D / this.maxHealth)));
		}
		if (this.health == this.maxHealth) {
			this.hpc = 83;
		}
		if ((this.xpc >= 2) || (this.exp > 0)) {
			this.xpc = (83 * (this.exp - this.expLevels[this.level])
					/ (this.expLevels[(this.level + 1)] - this.expLevels[this.level]));
		}
		if ((this.exp >= this.expLevels[(this.level + 1)]) && (this.level < this.maxLevel)) {
			this.level = ((short) (this.level + 1));
		}

		if (isInBuilding) {
			insideMovement();
		} else {
			this.tileX = ((this.x + 16 + (Game.getMap().x)) / 32);
			this.tileY = ((this.y + 16 + (Game.getMap().y)) / 32);
			int curTile = getCurrentTile();
			if (curTile == 1) {
				isSwimming = false;
			} else if (curTile == 3) {
				isSwimming = true;
			} else if (curTile == 98) {
				PlayerHouse.enter();
			}
			mapMovement();
		}
	}

	public int getCurrentTile() {
		return Game.getMap().getTileID(this.tileX, this.tileY);
	}

	public boolean isNextTileValid(int dir) {
		if (dir == 1) { // up -- done
			int check1 = Game.getMap().getTileID((this.x + 16 + (Game.getMap().x) + 16) / 32,
					((this.y + (Game.getMap().y) - 1) / 32));
			int check2 = Game.getMap().getTileID((this.x + 16 + (Game.getMap().x) - 16) / 32,
					((this.y + (Game.getMap().y) - 1) / 32));
			if ((check1 != 1 && check1 != 3 && check1 != 98) || (check2 != 1 && check2 != 3 && check2 != 98)) {
				return false;
			}
		} else if (dir == 2) { // right -- done
			int check1 = Game.getMap().getTileID(((this.x + Game.getMap().x + 33)) / 32,
					(this.y + 16 + (Game.getMap().y) - 16) / 32);
			int check2 = Game.getMap().getTileID(((this.x + Game.getMap().x + 33)) / 32,
					(this.y + 16 + (Game.getMap().y) + 16) / 32);
			if ((check1 != 1 && check1 != 3) || (check2 != 1 && check2 != 3)) {
				return false;
			}
		} else if (dir == 3) { // down -- done
			int check1 = Game.getMap().getTileID(((this.x + 16 + Game.getMap().x + 16)) / 32,
					((this.y + (Game.getMap().y) + 33) / 32));
			int check2 = Game.getMap().getTileID(((this.x + 16 + Game.getMap().x - 16)) / 32,
					((this.y + (Game.getMap().y) + 33) / 32));
			if ((check1 != 1 && check1 != 3) || (check2 != 1 && check2 != 3)) {
				return false;
			}
		} else if (dir == 4) { // left -- done
			int check1 = Game.getMap().getTileID(((this.x + Game.getMap().x - 1)) / 32,
					((this.y + 32 + Game.getMap().y)) / 32);
			int check2 = Game.getMap().getTileID(((this.x + Game.getMap().x - 1)) / 32,
					((this.y + 32 + Game.getMap().y - 32)) / 32);
			if ((check1 != 1 && check1 != 3) || (check2 != 1 && check2 != 3)) {
				return false;
			}
		}
		return true;
	}

	public void attack() {
		this.isAttacking = true;
		if (Math.sqrt((this.x - TestDummy.rx) * (this.x - TestDummy.rx)
				+ (this.y - TestDummy.ry) * (this.y - TestDummy.ry)) <= this.attackRadius) {
			TestDummy.takeDamage(this.damage);
		}
	}

	public void takeDamage(double d) {
		if ((this.health >= d) && (!TestDummy.isDead)) {
			this.health -= d;
			a.flashRequest = true;
		} else if (this.health == 0.0D) {
			kill();
		}
		healthBarCheck();
	}

	public void fixPos() {
		if (this.x < 32) {
			this.x = 32;
		} else if (this.x > Game.width - 32) {
			this.x = (Game.width - 32);
		}
		if (this.y < 32) {
			this.y = 32;
		} else if (this.y > Game.height - 32) {
			this.y = (Game.height - 32);
		}
	}

	public void kill() {
		Game.isInGame = false;
		Game.getMainMenu().menuState = 6;
	}

	public void respawn() {
		this.health = this.maxHealth;
		this.x = Game.pMidX;
		this.y = Game.pMidY;
		Game.getMap().x = 0;
		Game.getMap().y = 0;
		this.lastDir = 3;
		Game.getMainMenu().menuState = 0;
		Game.isInGame = true;
		healthBarCheck();
	}

	public void healthBarCheck() {
		if ((this.health >= 0.0D) && (this.health <= this.maxHealth / 3.0D)) {
			hColor = new Color(127, 0, 0);
		} else if ((this.health > this.maxHealth / 3.0D) && (this.health <= this.maxHealth / 3.0D * 2.0D)) {
			hColor = new Color(255, 216, 0);
		} else if (this.health <= this.maxHealth) {
			hColor = new Color(0, 255, 33);
		}
	}

	public void drawPlayerHUD(Graphics g) {
		fm = g.getFontMetrics(new Font("MoolBoran", Font.PLAIN + Font.BOLD, 19));
		g.drawImage(ImageManager.player_hud, 5, 5, null);
		g.setFont(new Font("MoolBoran", Font.PLAIN + Font.BOLD, 19));
		g.setColor(new Color(0, 0, 0, 147));
		g.drawString(this.name + ": Lvl " + this.level, 108 - (fm.stringWidth(this.name + ": Lvl " + this.level) / 2),
				21);
		drawHealthBar(g);
		drawExpBar(g);
		g.drawImage(ImageManager.player_down[1], 22, 22, null);
	}

	private void drawHealthBar(Graphics g) {
		fm = g.getFontMetrics(Game.pHUDBar);
		g.setColor(hColor);
		g.fillRect(67, 34, this.hpc, 8);
		g.setFont(Game.pHUDBar);
		g.setColor(Color.black);
		g.drawString(String.valueOf(this.health), 108 - fm.stringWidth(String.valueOf(this.health)) / 2, 42);
	}

	private void drawExpBar(Graphics g) {
		fm = g.getFontMetrics(Game.pHUDBar);
		g.setColor(Color.blue);
		g.fillRect(67, 50, this.xpc, 8);
		g.setFont(Game.pHUDBar);
		g.setColor(Color.white);
		g.drawString(String.valueOf(this.exp), 108 - fm.stringWidth(String.valueOf(this.exp)) / 2, 58);
	}

	public void mapMovement() {
		if (up || down || left || right) {
			if ((this.up) && (this.canMoveUp)) {
				if ((this.y <= (Game.height / 2 - 16)) && (isNextTileValid(1)) && Game.getMap().y > 0) {
					Game.getMap().y = ((int) (Game.getMap().y - this.SPEED));
				} else if ((isNextTileValid(1))) {
					this.y = ((int) (this.y - this.SPEED));
				}
				moveCount = (byte) (int) (moveCount + this.SPEED);
				this.movingDown = false;
				this.movingUp = true;
				this.movingLeft = false;
				this.movingRight = false;
				this.lastDir = 1;
				if (moveCount >= 42) {
					moveCount = 2;
				}
			} else if ((this.down) && (this.canMoveDown)) {
				if ((this.y >= (Game.height / 2 - 16)) && (isNextTileValid(3)) && (this.y < Game.height)
						&& Game.getMap().y < 608) {
					Game.getMap().y = ((int) (Game.getMap().y + this.SPEED));
				} else if ((this.y + 32 < Game.height) && (isNextTileValid(3))) {
					this.y = ((int) (this.y + this.SPEED));
				}
				moveCount = (byte) (int) (moveCount + this.SPEED);
				this.movingDown = true;
				this.movingUp = false;
				this.movingLeft = false;
				this.movingRight = false;
				this.lastDir = 3;
				if (moveCount >= 42) {
					moveCount = 2;
				}
			}

			if ((this.right) && (this.x <= this.pbX) && (this.canMoveRight)) {
				if ((this.x >= Game.width / 2 - 16) && (isNextTileValid(2)) && (this.x < 771)
						&& Game.getMap().x < 896) {
					Game.getMap().x = ((int) (Game.getMap().x + this.SPEED));
				} else if ((this.x < 771) && (isNextTileValid(2))) {
					this.x = ((int) (this.x + this.SPEED));
				}
				moveCount = (byte) (int) (moveCount + this.SPEED);
				this.movingDown = false;
				this.movingUp = false;
				this.movingLeft = false;
				this.movingRight = true;
				this.lastDir = 2;
				if (moveCount >= 42) {
					moveCount = 2;
				}
			} else if ((this.left) && (this.canMoveLeft)) {
				if ((this.x <= (Game.width / 2 - 16)) && (isNextTileValid(4) && Game.getMap().x > 0)) {
					Game.getMap().x = ((int) (Game.getMap().x - this.SPEED));
				} else if ((isNextTileValid(4))) {
					this.x = ((int) (this.x - this.SPEED));
				}
				moveCount = (byte) (int) (moveCount + this.SPEED);
				this.movingDown = false;
				this.movingUp = false;
				this.movingLeft = true;
				this.movingRight = false;
				this.lastDir = 4;
				if (moveCount >= 42) {
					moveCount = 2;
				}
			}
		} else {
			moveCount = 7;
		}
	}

	public void insideMovement() {
		if (up || down || left || right) {
			if ((this.up) && (this.canMoveUp)) {
				y = ((int) (y - SPEED));
				moveCount = (byte) (int) (moveCount + this.SPEED);
				this.movingDown = false;
				this.movingUp = true;
				this.movingLeft = false;
				this.movingRight = false;
				this.lastDir = 1;
				if (moveCount >= 42) {
					moveCount = 2;
				}
			} else if ((this.down) && (this.canMoveDown)) {
				y = ((int) (y + SPEED));
				moveCount = (byte) (int) (moveCount + this.SPEED);
				this.movingDown = true;
				this.movingUp = false;
				this.movingLeft = false;
				this.movingRight = false;
				this.lastDir = 3;
				if (moveCount >= 42) {
					moveCount = 2;
				}
			}

			if ((this.right) && (this.x <= this.pbX) && (this.canMoveRight)) {
				x = ((int) (x + SPEED));
				moveCount = (byte) (int) (moveCount + this.SPEED);
				this.movingDown = false;
				this.movingUp = false;
				this.movingLeft = false;
				this.movingRight = true;
				this.lastDir = 2;
				if (moveCount >= 42) {
					moveCount = 2;
				}
			} else if ((this.left) && (this.canMoveLeft)) {
				x = ((int) (x - SPEED));
				moveCount = (byte) (int) (moveCount + this.SPEED);
				this.movingDown = false;
				this.movingUp = false;
				this.movingLeft = true;
				this.movingRight = false;
				this.lastDir = 4;
				if (moveCount >= 42) {
					moveCount = 2;
				}
			}
		} else {
			moveCount = 7;
		}
	}

	public void render(Graphics g) {
		if (F3Menu.f3menu) {
			g.setColor(Color.yellow);
			g.drawRect(x, y, 32, 32);
		}
		if (!this.isAttacking) {
			if (isSwimming) {
				if (movingUp) {
					a.animateEntity(g, this.x, this.y, ImageManager.player_up_swim, moveCount);
				} else if (movingDown) {
					a.animateEntity(g, this.x, this.y, ImageManager.player_down_swim, moveCount);
				} else if (movingLeft) {
					a.animateEntity(g, this.x, this.y, ImageManager.player_left_swim, moveCount);
				} else if (movingRight) {
					a.animateEntity(g, this.x, this.y, ImageManager.player_right_swim, moveCount);
				}
			} else {
				if (movingUp) {
					a.animateEntity(g, this.x, this.y, ImageManager.player_up, moveCount);
				} else if (movingDown) {
					a.animateEntity(g, this.x, this.y, ImageManager.player_down, moveCount);
				} else if (movingLeft) {
					a.animateEntity(g, this.x, this.y, ImageManager.player_left, moveCount);
				} else if (movingRight) {
					a.animateEntity(g, this.x, this.y, ImageManager.player_right, moveCount);
				}
			}
		} else if (this.isAttacking) {
			if (movingUp) {
				a.animateEntity(g, this.x, this.y, ImageManager.player_up_attack, moveCount);
			} else if (movingDown) {
				a.animateEntity(g, this.x, this.y, ImageManager.player_down_attack, moveCount);
			} else if (movingLeft) {
				a.animateEntity(g, this.x, this.y, ImageManager.player_left_attack, moveCount);
			} else if (movingRight) {
				a.animateEntity(g, this.x, this.y, ImageManager.player_right_attack, moveCount);
			}
		}
		if ((!this.up) && (!this.down) && (!this.left) && (!this.right) && (this.lastDir == 0)) {
			if (isSwimming) {
				g.drawImage(ImageManager.player_down_swim[1], x, y, 32, 32, null);
			} else
				g.drawImage(ImageManager.player_down[1], this.x, this.y, 32, 32, null);
		}
		if ((!this.right) && (this.lastDir == 2)) {
			if (isSwimming) {
				g.drawImage(ImageManager.player_right_swim[1], x, y, 32, 32, null);
			} else
				g.drawImage(ImageManager.player_right[1], this.x, this.y, 32, 32, null);
			if (a.flashRequest) {
				a.imageFlash(g, ImageManager.player_right[1], this.x, this.y, new Color(255, 0, 0, 128));
			}
		}
		if ((!this.left) && (this.lastDir == 4)) {
			if (isSwimming) {
				g.drawImage(ImageManager.player_left_swim[1], x, y, 32, 32, null);
			} else
				g.drawImage(ImageManager.player_left[1], this.x, this.y, 32, 32, null);
			if (a.flashRequest) {
				a.imageFlash(g, ImageManager.player_left[1], this.x, this.y, new Color(255, 0, 0, 128));
			}
		}
		if ((!this.up) && (this.lastDir == 1)) {
			if (isSwimming) {
				g.drawImage(ImageManager.player_up_swim[1], x, y, 32, 32, null);
			} else
				g.drawImage(ImageManager.player_up[1], this.x, this.y, 32, 32, null);
			if (a.flashRequest) {
				a.imageFlash(g, ImageManager.player_up[1], this.x, this.y, new Color(255, 0, 0, 128));
			}
		}
		if ((!this.down) && (this.lastDir == 3)) {
			if (isSwimming) {
				g.drawImage(ImageManager.player_down_swim[1], x, y, 32, 32, null);
			} else
				g.drawImage(ImageManager.player_down[1], this.x, this.y, 32, 32, null);
			if (a.flashRequest) {
				a.imageFlash(g, ImageManager.player_down[1], this.x, this.y, new Color(255, 0, 0, 128));
			}
		}
		if ((a.flashRequest) && ((this.movingUp) || (this.movingDown) || (this.movingLeft) || (this.movingRight))) {
			a.imageFlash(g, a.getCurrentFrame(), this.x, this.y, new Color(255, 0, 0, 128));
		}
		if (F3Menu.f3menu) {
			g.setColor(Color.yellow);
			g.drawString(getCurrentTile() + "", x + 2, y + 12);
		}
	}
}
