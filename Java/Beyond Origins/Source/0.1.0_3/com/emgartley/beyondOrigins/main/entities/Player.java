/*     */ package com.emgartley.beyondOrigins.main.entities;
/*     */ 
/*     */ import com.emgartley.beyondOrigins.main.Game;
/*     */ import com.emgartley.beyondOrigins.main.gfx.Animate;
/*     */ import com.emgartley.beyondOrigins.main.gfx.ImageManager;
/*     */ import com.emgartley.beyondOrigins.main.maps.GrassMap;
/*     */ import com.emgartley.beyondOrigins.main.menus.F3Menu;
/*     */ import java.awt.Color;
/*     */ import java.awt.FontMetrics;
/*     */ import java.awt.Graphics;
/*     */ 
/*     */ public class Player extends Entity {
/*  13 */   public String name = "Roland";
/*     */   
/*  14 */   public String defaultName = this.name;
/*     */   
/*  15 */   public String typedName = "";
/*     */   
/*  16 */   public double maxHealth = 50.0D;
/*     */   
/*  16 */   public double health = 50.0D;
/*     */   
/*  16 */   public double damage = 1.5D;
/*     */   
/*  17 */   public byte attackRadius = 32;
/*     */   
/*     */   public boolean flashRequest;
/*     */   
/*  19 */   public static byte upCount = 1, downCount = 1, leftCount = 1;
/*     */   
/*  20 */   public static byte rightCount = 1;
/*     */   
/*  21 */   public short level = 1;
/*     */   
/*  21 */   public short exp = 0;
/*     */   
/*  21 */   public short maxLevel = 99;
/*     */   
/*     */   public int[] expLevels;
/*     */   
/*     */   public boolean canMoveUp = true, canMoveDown = true, canMoveLeft = true;
/*     */   
/*     */   public boolean canMoveRight = true;
/*     */   
/*     */   public int x;
/*     */   
/*     */   public int y;
/*     */   
/*     */   public byte lastDir;
/*     */   
/*     */   public static byte catchingUp;
/*     */   
/*     */   public boolean up = false;
/*     */   
/*     */   public boolean down = false;
/*     */   
/*     */   public boolean left = false;
/*     */   
/*     */   public boolean right = false;
/*     */   
/*  29 */   public double SPEED = 1.0D;
/*     */   
/*     */   public boolean movingUp;
/*     */   
/*     */   public boolean movingDown;
/*     */   
/*     */   public boolean movingLeft;
/*     */   
/*     */   public boolean movingRight;
/*     */   
/*     */   public boolean mapMovement = true;
/*     */   
/*     */   public boolean insideMovement = false;
/*     */   
/*  32 */   public short mbX = 1232;
/*     */   
/*  32 */   public short mbY = 800;
/*     */   
/*  32 */   public short pbX = 801;
/*     */   
/*  32 */   public short pbY = 1;
/*     */   
/*     */   public int tileX;
/*     */   
/*     */   public int tileY;
/*     */   
/*     */   private static Animate a;
/*     */   
/*     */   private static FontMetrics fm;
/*     */   
/*     */   private static Color hColor;
/*     */   
/*     */   public boolean isAttacking = false;
/*     */   
/*  38 */   private int hpc = 81, xpc = 83;
/*     */   
/*  39 */   private int regenTime = 60;
/*     */   
/*     */   private int time;
/*     */   
/*     */   public Player(int x, int y, int mx, int my) {
/*  43 */     this.x = x;
/*  44 */     this.y = y;
/*  45 */     a = new Animate();
/*  46 */     this.expLevels = new int[99];
/*  47 */     this.expLevels[1] = 0;
/*  48 */     this.expLevels[2] = 100;
/*  49 */     this.expLevels[3] = 300;
/*  50 */     this.expLevels[4] = 500;
/*  51 */     this.expLevels[5] = 800;
/*  52 */     this.expLevels[6] = 1100;
/*  53 */     this.expLevels[7] = 1400;
/*  54 */     this.expLevels[8] = 1700;
/*  55 */     this.expLevels[9] = 1900;
/*  56 */     this.expLevels[10] = 2100;
/*     */   }
/*     */   
/*     */   public void tick() {
/*  60 */     this.tileX = (this.x + GrassMap.x) / 32;
/*  61 */     this.tileY = (this.y + GrassMap.y) / 32;
/*  63 */     this.time++;
/*  64 */     if (this.time >= this.regenTime && this.health < this.maxHealth) {
/*  65 */       this.health += 0.5D;
/*  66 */       this.time = 0;
/*  67 */       healthBarCheck();
/*     */     } 
/*  69 */     if (this.hpc >= 2 || this.health > 0.0D)
/*  70 */       this.hpc = (int)(this.health * 81.0D / this.maxHealth); 
/*  72 */     if (this.health == this.maxHealth)
/*  73 */       this.hpc = 81; 
/*  75 */     if (this.xpc >= 2 || this.exp > 0)
/*  76 */       this.xpc = 83 * (this.exp - this.expLevels[this.level]) / (this.expLevels[this.level + 1] - this.expLevels[this.level]); 
/*  78 */     if (this.exp >= this.expLevels[this.level + 1] && 
/*  79 */       this.level < this.maxLevel)
/*  80 */       this.level = (short)(this.level + 1); 
/*  82 */     mapMovement();
/*     */   }
/*     */   
/*     */   public int getCurrentTile() {
/*  86 */     Game.getMap();
/*  87 */     return GrassMap.getTileID(this.tileX, this.tileY);
/*     */   }
/*     */   
/*     */   public boolean isNextTileValid(int dir) {
/*  95 */     if (dir == 2) {
/*  96 */       if (GrassMap.getTileID((this.x + GrassMap.x + 33) / 32, this.tileY) == 1) {
/*  97 */         if (GrassMap.getTileID((this.x + GrassMap.x + 33) / 32, 
/*  98 */             this.tileY + 1) != 1)
/*  99 */           return false; 
/*     */       } else {
/*  99 */         return false;
/*     */       } 
/* 100 */     } else if (dir == 1) {
/* 101 */       if (GrassMap.getTileID(this.tileX, (this.y + GrassMap.y - 1) / 32) == 1) {
/* 102 */         if (GrassMap.getTileID(this.tileX + 1, (
/* 103 */             this.y + GrassMap.y - 1) / 32) != 1)
/* 104 */           return false; 
/*     */       } else {
/* 104 */         return false;
/*     */       } 
/* 105 */     } else if (dir == 3) {
/* 106 */       if (GrassMap.getTileID(this.tileX, (this.y + GrassMap.y + 33) / 32) == 1) {
/* 107 */         if (GrassMap.getTileID(this.tileX + 1, (
/* 108 */             this.y + GrassMap.y + 33) / 32) != 1)
/* 109 */           return false; 
/*     */       } else {
/* 109 */         return false;
/*     */       } 
/* 110 */     } else if (dir == 4) {
/* 111 */       if (GrassMap.getTileID((this.x + GrassMap.x - 1) / 32, this.tileY) == 1) {
/* 112 */         if (GrassMap.getTileID((this.x + GrassMap.x - 1) / 32, 
/* 113 */             this.tileY + 1) != 1)
/* 114 */           return false; 
/*     */       } else {
/* 114 */         return false;
/*     */       } 
/*     */     } 
/* 116 */     return true;
/*     */   }
/*     */   
/*     */   public void attack() {
/* 120 */     this.isAttacking = true;
/* 121 */     if (Math.sqrt(((this.x - TestDummy.rx) * (this.x - TestDummy.rx) + (
/* 122 */         this.y - TestDummy.ry) * (this.y - TestDummy.ry))) <= this.attackRadius)
/* 123 */       TestDummy.takeDamage(this.damage); 
/*     */   }
/*     */   
/*     */   public void takeDamage(double d) {
/* 128 */     if (this.health >= d && !TestDummy.isDead) {
/* 129 */       this.health -= d;
/* 130 */       a.flashRequest = true;
/* 131 */     } else if (this.health == 0.0D) {
/* 132 */       kill();
/*     */     } 
/* 134 */     healthBarCheck();
/*     */   }
/*     */   
/*     */   public void fixPos() {
/* 138 */     if (this.x < 32) {
/* 139 */       this.x = 32;
/* 140 */     } else if (this.x > Game.width - 32) {
/* 141 */       this.x = Game.width - 32;
/*     */     } 
/* 143 */     if (this.y < 32) {
/* 144 */       this.y = 32;
/* 145 */     } else if (this.y > Game.height - 32) {
/* 146 */       this.y = Game.height - 32;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void kill() {
/* 151 */     Game.isInGame = false;
/* 152 */     (Game.getMainMenu()).menuState = 6;
/*     */   }
/*     */   
/*     */   public void respawn() {
/* 156 */     this.health = this.maxHealth;
/* 157 */     this.x = Game.playerSpawnX;
/* 158 */     this.y = Game.playerSpawnY;
/* 159 */     GrassMap.x = 0;
/* 160 */     GrassMap.y = 0;
/* 161 */     this.lastDir = 3;
/* 162 */     (Game.getMainMenu()).menuState = 0;
/* 163 */     Game.isInGame = true;
/* 164 */     healthBarCheck();
/*     */   }
/*     */   
/*     */   public void healthBarCheck() {
/* 168 */     if (this.health >= 0.0D && this.health <= this.maxHealth / 3.0D) {
/* 169 */       hColor = new Color(127, 0, 0);
/* 170 */     } else if (this.health > this.maxHealth / 3.0D && 
/* 171 */       this.health <= this.maxHealth / 3.0D * 2.0D) {
/* 172 */       hColor = new Color(255, 216, 0);
/* 173 */     } else if (this.health <= this.maxHealth) {
/* 174 */       hColor = new Color(0, 255, 33);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void drawPlayerHUD(Graphics g) {
/* 179 */     g.drawImage(ImageManager.player_hud, 5, 5, null);
/* 180 */     g.setFont(Game.playerHUDFont);
/* 181 */     g.setColor(Color.black);
/* 182 */     fm = g.getFontMetrics(Game.playerHUDFont);
/* 183 */     g.drawString(String.valueOf(this.name) + " | Lvl " + this.level, 
/* 184 */         108 - fm.stringWidth(String.valueOf(this.name) + " | Lvl " + this.level) / 2, 
/* 185 */         21);
/* 186 */     drawHealthBar(g);
/* 187 */     drawExpBar(g);
/* 188 */     g.drawImage(ImageManager.player_down[1], 21, 21, null);
/*     */   }
/*     */   
/*     */   private void drawHealthBar(Graphics g) {
/* 192 */     fm = g.getFontMetrics(Game.pHUDBar);
/* 193 */     g.setColor(hColor);
/* 194 */     g.fillRect(69, 34, this.hpc, 8);
/* 195 */     g.setFont(Game.pHUDBar);
/* 196 */     g.setColor(Color.black);
/* 197 */     g.drawString(String.valueOf(this.health), 
/* 198 */         108 - fm.stringWidth(String.valueOf(this.health)) / 2, 42);
/*     */   }
/*     */   
/*     */   private void drawExpBar(Graphics g) {
/* 202 */     fm = g.getFontMetrics(Game.pHUDBar);
/* 203 */     g.setColor(Color.blue);
/* 204 */     g.fillRect(67, 50, this.xpc, 8);
/* 205 */     g.setFont(Game.pHUDBar);
/* 206 */     g.setColor(Color.white);
/* 207 */     g.drawString(String.valueOf(this.exp), 
/* 208 */         108 - fm.stringWidth(String.valueOf(this.exp)) / 2, 58);
/*     */   }
/*     */   
/*     */   public void mapMovement() {
/* 212 */     if (this.up && this.canMoveUp) {
/* 213 */       if (this.y <= Game.height / 2 - 16 && isNextTileValid(1) && 
/* 214 */         GrassMap.y > 0) {
/* 215 */         GrassMap.y = (int)(GrassMap.y - this.SPEED);
/* 216 */       } else if (isNextTileValid(1)) {
/* 217 */         this.y = (int)(this.y - this.SPEED);
/*     */       } 
/* 219 */       upCount = (byte)(int)(upCount + this.SPEED);
/* 220 */       this.movingDown = false;
/* 221 */       this.movingUp = true;
/* 222 */       this.movingLeft = false;
/* 223 */       this.movingRight = false;
/* 224 */       this.lastDir = 1;
/* 225 */       downCount = 0;
/* 226 */       if (upCount >= 42)
/* 227 */         upCount = 2; 
/* 229 */     } else if (this.down && this.canMoveDown) {
/* 230 */       if (this.y >= Game.height / 2 - 16 && isNextTileValid(3) && 
/* 231 */         this.y < Game.height && GrassMap.y < 608) {
/* 232 */         GrassMap.y = (int)(GrassMap.y + this.SPEED);
/* 233 */       } else if (this.y + 32 < Game.height && isNextTileValid(3)) {
/* 234 */         this.y = (int)(this.y + this.SPEED);
/*     */       } 
/* 236 */       downCount = (byte)(int)(downCount + this.SPEED);
/* 237 */       this.movingDown = true;
/* 238 */       this.movingUp = false;
/* 239 */       this.movingLeft = false;
/* 240 */       this.movingRight = false;
/* 241 */       this.lastDir = 3;
/* 242 */       upCount = 0;
/* 243 */       if (downCount >= 42)
/* 244 */         downCount = 2; 
/*     */     } else {
/* 247 */       downCount = 0;
/* 248 */       upCount = 0;
/*     */     } 
/* 251 */     if (this.right && this.x <= this.pbX && this.canMoveRight) {
/* 252 */       if (this.x >= Game.width / 2 - 16 && isNextTileValid(2) && 
/* 253 */         this.x < 771 && GrassMap.x < 896) {
/* 254 */         GrassMap.x = (int)(GrassMap.x + this.SPEED);
/* 255 */       } else if (this.x < 771 && isNextTileValid(2)) {
/* 256 */         this.x = (int)(this.x + this.SPEED);
/*     */       } 
/* 258 */       rightCount = (byte)(int)(rightCount + this.SPEED);
/* 259 */       this.movingDown = false;
/* 260 */       this.movingUp = false;
/* 261 */       this.movingLeft = false;
/* 262 */       this.movingRight = true;
/* 263 */       this.lastDir = 2;
/* 264 */       leftCount = 0;
/* 265 */       if (rightCount >= 42)
/* 266 */         rightCount = 2; 
/* 268 */     } else if (this.left && this.canMoveLeft) {
/* 269 */       if (this.x <= Game.width / 2 - 16 && 
/* 270 */         isNextTileValid(4) && GrassMap.x > 0) {
/* 271 */         GrassMap.x = (int)(GrassMap.x - this.SPEED);
/* 272 */       } else if (isNextTileValid(4)) {
/* 273 */         this.x = (int)(this.x - this.SPEED);
/*     */       } 
/* 275 */       leftCount = (byte)(int)(leftCount + this.SPEED);
/* 276 */       this.movingDown = false;
/* 277 */       this.movingUp = false;
/* 278 */       this.movingLeft = true;
/* 279 */       this.movingRight = false;
/* 280 */       this.lastDir = 4;
/* 281 */       rightCount = 0;
/* 282 */       if (leftCount >= 42)
/* 283 */         leftCount = 2; 
/*     */     } else {
/* 286 */       rightCount = 0;
/* 287 */       leftCount = 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void insideMovement() {
/* 292 */     if (this.up && this.y >= 125.0F && this.canMoveUp) {
/* 293 */       this.y = (int)(this.y - this.SPEED);
/* 294 */       upCount = (byte)(upCount + 1);
/* 295 */       this.movingUp = true;
/* 296 */       this.lastDir = 1;
/* 297 */       if (upCount == 42)
/* 298 */         upCount = 1; 
/*     */     } else {
/* 301 */       upCount = 0;
/* 302 */       this.movingUp = false;
/*     */     } 
/* 304 */     if (this.down && this.y <= 423.0F && this.canMoveDown) {
/* 305 */       this.y = (int)(this.y + this.SPEED);
/* 306 */       downCount = (byte)(downCount + 1);
/* 307 */       this.movingDown = true;
/* 308 */       this.lastDir = 3;
/* 309 */       if (downCount == 42)
/* 310 */         downCount = 1; 
/*     */     } else {
/* 313 */       downCount = 0;
/* 314 */       this.movingDown = false;
/*     */     } 
/* 316 */     if (this.left && this.x >= 194.0F && this.canMoveLeft) {
/* 317 */       this.x = (int)(this.x - this.SPEED);
/* 318 */       leftCount = (byte)(leftCount + 1);
/* 319 */       this.movingLeft = true;
/* 320 */       this.lastDir = 4;
/* 321 */       if (leftCount == 42)
/* 322 */         leftCount = 1; 
/*     */     } else {
/* 325 */       leftCount = 0;
/* 326 */       this.movingLeft = false;
/*     */     } 
/* 328 */     if (this.right && this.x <= 612.0F && this.canMoveRight) {
/* 329 */       this.x = (int)(this.x + this.SPEED);
/* 330 */       rightCount = (byte)(rightCount + 1);
/* 331 */       this.movingRight = true;
/* 332 */       this.lastDir = 2;
/* 333 */       if (rightCount == 42)
/* 334 */         rightCount = 1; 
/*     */     } else {
/* 337 */       rightCount = 0;
/* 338 */       this.movingRight = false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render(Graphics g) {
/* 343 */     if (F3Menu.f3menu) {
/* 344 */       g.setColor(Color.yellow);
/* 345 */       g.drawRect((this.x + 16) / 32 * 32, (this.y + 16) / 32 * 32, 32, 32);
/*     */     } 
/* 347 */     if (!this.isAttacking) {
/* 348 */       a.animateEntity(g, this.x, this.y, ImageManager.player_up, upCount);
/* 349 */       a.animateEntity(g, this.x, this.y, ImageManager.player_down, 
/* 350 */           downCount);
/* 351 */       a.animateEntity(g, this.x, this.y, ImageManager.player_left, 
/* 352 */           leftCount);
/* 353 */       a.animateEntity(g, this.x, this.y, ImageManager.player_right, 
/* 354 */           rightCount);
/* 355 */     } else if (this.isAttacking) {
/* 356 */       a.animateEntity(g, this.x, this.y, ImageManager.player_up_attack, 
/* 357 */           upCount);
/* 358 */       a.animateEntity(g, this.x, this.y, ImageManager.player_down_attack, 
/* 359 */           downCount);
/* 360 */       a.animateEntity(g, this.x, this.y, ImageManager.player_left_attack, 
/* 361 */           leftCount);
/* 362 */       a.animateEntity(g, this.x, this.y, 
/* 363 */           ImageManager.player_right_attack, rightCount);
/*     */     } 
/* 365 */     if (!this.up && !this.down && !this.left && !this.right && 
/* 366 */       this.lastDir == 0)
/* 367 */       g.drawImage(ImageManager.player_down[1], this.x, this.y, 32, 32, 
/* 368 */           null); 
/* 370 */     if (!this.right && this.lastDir == 2) {
/* 371 */       g.drawImage(ImageManager.player_right[1], this.x, this.y, 32, 32, 
/* 372 */           null);
/* 373 */       if (a.flashRequest)
/* 374 */         a.imageFlash(g, ImageManager.player_right[1], this.x, this.y, 
/* 375 */             new Color(255, 0, 0, 128)); 
/*     */     } 
/* 378 */     if (!this.left && this.lastDir == 4) {
/* 379 */       g.drawImage(ImageManager.player_left[1], this.x, this.y, 32, 32, 
/* 380 */           null);
/* 381 */       if (a.flashRequest)
/* 382 */         a.imageFlash(g, ImageManager.player_left[1], this.x, this.y, 
/* 383 */             new Color(255, 0, 0, 128)); 
/*     */     } 
/* 386 */     if (!this.up && this.lastDir == 1) {
/* 387 */       g.drawImage(ImageManager.player_up[1], this.x, this.y, 32, 32, null);
/* 388 */       if (a.flashRequest)
/* 389 */         a.imageFlash(g, ImageManager.player_up[1], this.x, this.y, 
/* 390 */             new Color(255, 0, 0, 128)); 
/*     */     } 
/* 393 */     if (!this.down && this.lastDir == 3) {
/* 394 */       g.drawImage(ImageManager.player_down[1], this.x, this.y, 32, 32, 
/* 395 */           null);
/* 396 */       if (a.flashRequest)
/* 397 */         a.imageFlash(g, ImageManager.player_down[1], this.x, this.y, 
/* 398 */             new Color(255, 0, 0, 128)); 
/*     */     } 
/* 401 */     if (a.flashRequest && (
/* 402 */       this.movingUp || this.movingDown || this.movingLeft || this.movingRight))
/* 403 */       a.imageFlash(g, a.getCurrentFrame(), this.x, this.y, new Color(255, 
/* 404 */             0, 0, 128)); 
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.1.0_3.jar!\com\emgartley\beyondOrigins\main\entities\Player.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */