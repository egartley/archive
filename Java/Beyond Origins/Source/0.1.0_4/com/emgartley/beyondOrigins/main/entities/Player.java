/*     */ package com.emgartley.beyondOrigins.main.entities;
/*     */ 
/*     */ import com.emgartley.beyondOrigins.main.Game;
/*     */ import com.emgartley.beyondOrigins.main.gfx.Animate;
/*     */ import com.emgartley.beyondOrigins.main.gfx.ImageManager;
/*     */ import com.emgartley.beyondOrigins.main.maps.GrassMap;
/*     */ import com.emgartley.beyondOrigins.main.menus.F3Menu;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.FontMetrics;
/*     */ import java.awt.Graphics;
/*     */ 
/*     */ public class Player extends Entity {
/*  15 */   public String name = "Roland";
/*     */   
/*  16 */   public String defaultName = this.name;
/*     */   
/*  17 */   public String typedName = "";
/*     */   
/*  18 */   public double maxHealth = 50.0D;
/*     */   
/*  18 */   public double health = 50.0D;
/*     */   
/*  18 */   public double damage = 1.5D;
/*     */   
/*  19 */   public byte attackRadius = 32;
/*     */   
/*     */   public boolean flashRequest;
/*     */   
/*  21 */   public static byte upCount = 1, downCount = 1, leftCount = 1;
/*     */   
/*  22 */   public static byte rightCount = 1;
/*     */   
/*  23 */   public short level = 1;
/*     */   
/*  23 */   public short exp = 0;
/*     */   
/*  23 */   public short maxLevel = 99;
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
/*  31 */   public double SPEED = 1.0D;
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
/*  34 */   public short mbX = 1232;
/*     */   
/*  34 */   public short mbY = 800;
/*     */   
/*  34 */   public short pbX = 801;
/*     */   
/*  34 */   public short pbY = 1;
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
/*     */   public boolean isSwimming = false;
/*     */   
/*  40 */   private int hpc = 83, xpc = 83;
/*     */   
/*  41 */   private int regenTime = 60;
/*     */   
/*     */   private int time;
/*     */   
/*     */   public Player(int x, int y, int mx, int my) {
/*  45 */     this.x = x;
/*  46 */     this.y = y;
/*  47 */     a = new Animate();
/*  48 */     this.expLevels = new int[99];
/*  49 */     this.expLevels[1] = 0;
/*  50 */     this.expLevels[2] = 100;
/*  51 */     this.expLevels[3] = 300;
/*  52 */     this.expLevels[4] = 500;
/*  53 */     this.expLevels[5] = 800;
/*  54 */     this.expLevels[6] = 1100;
/*  55 */     this.expLevels[7] = 1400;
/*  56 */     this.expLevels[8] = 1700;
/*  57 */     this.expLevels[9] = 1900;
/*  58 */     this.expLevels[10] = 2100;
/*     */   }
/*     */   
/*     */   public void tick() {
/*  62 */     this.tileX = (this.x + (Game.getMap()).x) / 32;
/*  63 */     this.tileY = (this.y + (Game.getMap()).y) / 32;
/*  65 */     this.time++;
/*  66 */     if (this.time >= this.regenTime && this.health < this.maxHealth) {
/*  67 */       this.health += 0.5D;
/*  68 */       this.time = 0;
/*  69 */       healthBarCheck();
/*     */     } 
/*  71 */     if (this.hpc >= 2 || this.health > 0.0D)
/*  72 */       this.hpc = (int)(this.health * 83.0D / this.maxHealth); 
/*  74 */     if (this.health == this.maxHealth)
/*  75 */       this.hpc = 83; 
/*  77 */     if (this.xpc >= 2 || this.exp > 0)
/*  78 */       this.xpc = 83 * (this.exp - this.expLevels[this.level]) / (this.expLevels[this.level + 1] - this.expLevels[this.level]); 
/*  80 */     if (this.exp >= this.expLevels[this.level + 1] && 
/*  81 */       this.level < this.maxLevel)
/*  82 */       this.level = (short)(this.level + 1); 
/*  85 */     int ct = getCurrentTile();
/*  86 */     if (ct == 3) {
/*  87 */       this.isSwimming = true;
/*  88 */     } else if (ct == 1) {
/*  89 */       this.isSwimming = false;
/*     */     } 
/*  92 */     mapMovement();
/*     */   }
/*     */   
/*     */   public int getCurrentTile() {
/*  96 */     Game.getMap();
/*  97 */     return GrassMap.getTileID(this.tileX, this.tileY);
/*     */   }
/*     */   
/*     */   public boolean isNextTileValid(int dir) {
/* 105 */     if (dir == 1) {
/* 106 */       int check1 = GrassMap.getTileID(this.tileX, (
/* 107 */           this.y + (Game.getMap()).y - 1) / 32);
/* 108 */       int check2 = GrassMap.getTileID(this.tileX + 1, (
/* 109 */           this.y + (Game.getMap()).y - 1) / 32);
/* 110 */       if ((check1 != 1 || check2 != 1) && (check1 != 3 || check2 != 3))
/* 111 */         return false; 
/* 113 */     } else if (dir == 2) {
/* 114 */       int check1 = GrassMap.getTileID((
/* 115 */           this.x + (Game.getMap()).x + 33) / 32, this.tileY);
/* 116 */       int check2 = GrassMap.getTileID((
/* 117 */           this.x + (Game.getMap()).x + 33) / 32, this.tileY + 1);
/* 118 */       if ((check1 != 1 || check2 != 1) && (check1 != 3 || check2 != 3))
/* 119 */         return false; 
/* 121 */     } else if (dir == 3) {
/* 122 */       int check1 = GrassMap.getTileID(this.tileX, (
/* 123 */           this.y + (Game.getMap()).y + 33) / 32);
/* 124 */       int check2 = GrassMap.getTileID(this.tileX + 1, (
/* 125 */           this.y + (Game.getMap()).y + 33) / 32);
/* 126 */       if ((check1 != 1 || check2 != 1) && (check1 != 3 || check2 != 3))
/* 127 */         return false; 
/* 129 */     } else if (dir == 4) {
/* 130 */       int check1 = GrassMap.getTileID((
/* 131 */           this.x + (Game.getMap()).x - 1) / 32, this.tileY);
/* 132 */       int check2 = GrassMap.getTileID((
/* 133 */           this.x + (Game.getMap()).x - 1) / 32, this.tileY + 1);
/* 134 */       if ((check1 != 1 || check2 != 1) && (check1 != 3 || check2 != 3))
/* 135 */         return false; 
/*     */     } 
/* 138 */     return true;
/*     */   }
/*     */   
/*     */   public void attack() {
/* 142 */     this.isAttacking = true;
/* 143 */     if (Math.sqrt(((this.x - TestDummy.rx) * (this.x - TestDummy.rx) + (
/* 144 */         this.y - TestDummy.ry) * (this.y - TestDummy.ry))) <= this.attackRadius)
/* 145 */       TestDummy.takeDamage(this.damage); 
/*     */   }
/*     */   
/*     */   public void takeDamage(double d) {
/* 150 */     if (this.health >= d && !TestDummy.isDead) {
/* 151 */       this.health -= d;
/* 152 */       a.flashRequest = true;
/* 153 */     } else if (this.health == 0.0D) {
/* 154 */       kill();
/*     */     } 
/* 156 */     healthBarCheck();
/*     */   }
/*     */   
/*     */   public void fixPos() {
/* 160 */     if (this.x < 32) {
/* 161 */       this.x = 32;
/* 162 */     } else if (this.x > Game.width - 32) {
/* 163 */       this.x = Game.width - 32;
/*     */     } 
/* 165 */     if (this.y < 32) {
/* 166 */       this.y = 32;
/* 167 */     } else if (this.y > Game.height - 32) {
/* 168 */       this.y = Game.height - 32;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void kill() {
/* 173 */     Game.isInGame = false;
/* 174 */     (Game.getMainMenu()).menuState = 6;
/*     */   }
/*     */   
/*     */   public void respawn() {
/* 178 */     this.health = this.maxHealth;
/* 179 */     this.x = Game.pMidX;
/* 180 */     this.y = Game.pMidY;
/* 181 */     (Game.getMap()).x = 0;
/* 182 */     (Game.getMap()).y = 0;
/* 183 */     this.lastDir = 3;
/* 184 */     (Game.getMainMenu()).menuState = 0;
/* 185 */     Game.isInGame = true;
/* 186 */     healthBarCheck();
/*     */   }
/*     */   
/*     */   public void healthBarCheck() {
/* 190 */     if (this.health >= 0.0D && this.health <= this.maxHealth / 3.0D) {
/* 191 */       hColor = new Color(127, 0, 0);
/* 192 */     } else if (this.health > this.maxHealth / 3.0D && 
/* 193 */       this.health <= this.maxHealth / 3.0D * 2.0D) {
/* 194 */       hColor = new Color(255, 216, 0);
/* 195 */     } else if (this.health <= this.maxHealth) {
/* 196 */       hColor = new Color(0, 255, 33);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void drawPlayerHUD(Graphics g) {
/* 201 */     fm = g.getFontMetrics(new Font("MoolBoran", 1, 19));
/* 202 */     g.drawImage(ImageManager.player_hud, 5, 5, null);
/* 203 */     g.setFont(new Font("MoolBoran", 1, 19));
/* 204 */     g.setColor(new Color(0, 0, 0, 147));
/* 205 */     g.drawString(String.valueOf(this.name) + ": Lvl " + this.level, 
/* 206 */         108 - fm.stringWidth(String.valueOf(this.name) + ": Lvl " + this.level) / 2, 
/* 207 */         21);
/* 208 */     drawHealthBar(g);
/* 209 */     drawExpBar(g);
/* 210 */     g.drawImage(ImageManager.player_down[1], 22, 22, null);
/*     */   }
/*     */   
/*     */   private void drawHealthBar(Graphics g) {
/* 214 */     fm = g.getFontMetrics(Game.pHUDBar);
/* 215 */     g.setColor(hColor);
/* 216 */     g.fillRect(67, 34, this.hpc, 8);
/* 217 */     g.setFont(Game.pHUDBar);
/* 218 */     g.setColor(Color.black);
/* 219 */     g.drawString(String.valueOf(this.health), 
/* 220 */         108 - fm.stringWidth(String.valueOf(this.health)) / 2, 42);
/*     */   }
/*     */   
/*     */   private void drawExpBar(Graphics g) {
/* 224 */     fm = g.getFontMetrics(Game.pHUDBar);
/* 225 */     g.setColor(Color.blue);
/* 226 */     g.fillRect(67, 50, this.xpc, 8);
/* 227 */     g.setFont(Game.pHUDBar);
/* 228 */     g.setColor(Color.white);
/* 229 */     g.drawString(String.valueOf(this.exp), 
/* 230 */         108 - fm.stringWidth(String.valueOf(this.exp)) / 2, 58);
/*     */   }
/*     */   
/*     */   public void mapMovement() {
/* 234 */     if (this.up && this.canMoveUp) {
/* 235 */       if (this.y <= Game.height / 2 - 16 && isNextTileValid(1) && 
/* 236 */         (Game.getMap()).y > 0) {
/* 237 */         (Game.getMap()).y = (int)((Game.getMap()).y - this.SPEED);
/* 238 */       } else if (isNextTileValid(1)) {
/* 239 */         this.y = (int)(this.y - this.SPEED);
/*     */       } 
/* 241 */       upCount = (byte)(int)(upCount + this.SPEED);
/* 242 */       this.movingDown = false;
/* 243 */       this.movingUp = true;
/* 244 */       this.movingLeft = false;
/* 245 */       this.movingRight = false;
/* 246 */       this.lastDir = 1;
/* 247 */       downCount = 1;
/* 248 */       if (upCount >= 42)
/* 249 */         upCount = 2; 
/* 251 */     } else if (this.down && this.canMoveDown) {
/* 252 */       if (this.y >= Game.height / 2 - 16 && isNextTileValid(3) && 
/* 253 */         this.y < Game.height && (Game.getMap()).y < 608) {
/* 254 */         (Game.getMap()).y = (int)((Game.getMap()).y + this.SPEED);
/* 255 */       } else if (this.y + 32 < Game.height && isNextTileValid(3)) {
/* 256 */         this.y = (int)(this.y + this.SPEED);
/*     */       } 
/* 258 */       downCount = (byte)(int)(downCount + this.SPEED);
/* 259 */       this.movingDown = true;
/* 260 */       this.movingUp = false;
/* 261 */       this.movingLeft = false;
/* 262 */       this.movingRight = false;
/* 263 */       this.lastDir = 3;
/* 264 */       upCount = 1;
/* 265 */       if (downCount >= 42)
/* 266 */         downCount = 2; 
/*     */     } else {
/* 269 */       downCount = 1;
/* 270 */       upCount = 1;
/*     */     } 
/* 273 */     if (this.right && this.x <= this.pbX && this.canMoveRight) {
/* 274 */       if (this.x >= Game.width / 2 - 16 && isNextTileValid(2) && 
/* 275 */         this.x < 771 && (Game.getMap()).x < 896) {
/* 276 */         (Game.getMap()).x = (int)((Game.getMap()).x + this.SPEED);
/* 277 */       } else if (this.x < 771 && isNextTileValid(2)) {
/* 278 */         this.x = (int)(this.x + this.SPEED);
/*     */       } 
/* 280 */       rightCount = (byte)(int)(rightCount + this.SPEED);
/* 281 */       this.movingDown = false;
/* 282 */       this.movingUp = false;
/* 283 */       this.movingLeft = false;
/* 284 */       this.movingRight = true;
/* 285 */       this.lastDir = 2;
/* 286 */       leftCount = 1;
/* 287 */       if (rightCount >= 42)
/* 288 */         rightCount = 2; 
/* 290 */     } else if (this.left && this.canMoveLeft) {
/* 291 */       if (this.x <= Game.width / 2 - 16 && 
/* 292 */         isNextTileValid(4) && (Game.getMap()).x > 0) {
/* 293 */         (Game.getMap()).x = (int)((Game.getMap()).x - this.SPEED);
/* 294 */       } else if (isNextTileValid(4)) {
/* 295 */         this.x = (int)(this.x - this.SPEED);
/*     */       } 
/* 297 */       leftCount = (byte)(int)(leftCount + this.SPEED);
/* 298 */       this.movingDown = false;
/* 299 */       this.movingUp = false;
/* 300 */       this.movingLeft = true;
/* 301 */       this.movingRight = false;
/* 302 */       this.lastDir = 4;
/* 303 */       rightCount = 1;
/* 304 */       if (leftCount >= 42)
/* 305 */         leftCount = 2; 
/*     */     } else {
/* 308 */       rightCount = 1;
/* 309 */       leftCount = 1;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void insideMovement() {
/* 314 */     if (this.up && this.y >= 125.0F && this.canMoveUp) {
/* 315 */       this.y = (int)(this.y - this.SPEED);
/* 316 */       upCount = (byte)(upCount + 1);
/* 317 */       this.movingUp = true;
/* 318 */       this.lastDir = 1;
/* 319 */       if (upCount == 42)
/* 320 */         upCount = 1; 
/*     */     } else {
/* 323 */       upCount = 0;
/* 324 */       this.movingUp = false;
/*     */     } 
/* 326 */     if (this.down && this.y <= 423.0F && this.canMoveDown) {
/* 327 */       this.y = (int)(this.y + this.SPEED);
/* 328 */       downCount = (byte)(downCount + 1);
/* 329 */       this.movingDown = true;
/* 330 */       this.lastDir = 3;
/* 331 */       if (downCount == 42)
/* 332 */         downCount = 1; 
/*     */     } else {
/* 335 */       downCount = 0;
/* 336 */       this.movingDown = false;
/*     */     } 
/* 338 */     if (this.left && this.x >= 194.0F && this.canMoveLeft) {
/* 339 */       this.x = (int)(this.x - this.SPEED);
/* 340 */       leftCount = (byte)(leftCount + 1);
/* 341 */       this.movingLeft = true;
/* 342 */       this.lastDir = 4;
/* 343 */       if (leftCount == 42)
/* 344 */         leftCount = 1; 
/*     */     } else {
/* 347 */       leftCount = 0;
/* 348 */       this.movingLeft = false;
/*     */     } 
/* 350 */     if (this.right && this.x <= 612.0F && this.canMoveRight) {
/* 351 */       this.x = (int)(this.x + this.SPEED);
/* 352 */       rightCount = (byte)(rightCount + 1);
/* 353 */       this.movingRight = true;
/* 354 */       this.lastDir = 2;
/* 355 */       if (rightCount == 42)
/* 356 */         rightCount = 1; 
/*     */     } else {
/* 359 */       rightCount = 0;
/* 360 */       this.movingRight = false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render(Graphics g) {
/* 365 */     if (F3Menu.f3menu) {
/* 366 */       g.setColor(Color.yellow);
/* 367 */       g.drawRect((this.x + 16) / 32 * 32, (this.y + 16) / 32 * 32, 32, 32);
/*     */     } 
/* 369 */     if (!this.isAttacking) {
/* 370 */       if (this.isSwimming) {
/* 371 */         a.animateEntity(g, this.x, this.y, ImageManager.player_up_swim, 
/* 372 */             upCount);
/* 373 */         a.animateEntity(g, this.x, this.y, 
/* 374 */             ImageManager.player_down_swim, downCount);
/* 375 */         a.animateEntity(g, this.x, this.y, 
/* 376 */             ImageManager.player_left_swim, leftCount);
/* 377 */         a.animateEntity(g, this.x, this.y, 
/* 378 */             ImageManager.player_right_swim, rightCount);
/*     */       } else {
/* 380 */         a.animateEntity(g, this.x, this.y, ImageManager.player_up, 
/* 381 */             upCount);
/* 382 */         a.animateEntity(g, this.x, this.y, ImageManager.player_down, 
/* 383 */             downCount);
/* 384 */         a.animateEntity(g, this.x, this.y, ImageManager.player_left, 
/* 385 */             leftCount);
/* 386 */         a.animateEntity(g, this.x, this.y, ImageManager.player_right, 
/* 387 */             rightCount);
/*     */       } 
/* 389 */     } else if (this.isAttacking) {
/* 390 */       a.animateEntity(g, this.x, this.y, ImageManager.player_up_attack, 
/* 391 */           upCount);
/* 392 */       a.animateEntity(g, this.x, this.y, ImageManager.player_down_attack, 
/* 393 */           downCount);
/* 394 */       a.animateEntity(g, this.x, this.y, ImageManager.player_left_attack, 
/* 395 */           leftCount);
/* 396 */       a.animateEntity(g, this.x, this.y, 
/* 397 */           ImageManager.player_right_attack, rightCount);
/*     */     } 
/* 399 */     if (!this.up && !this.down && !this.left && !this.right && 
/* 400 */       this.lastDir == 0)
/* 401 */       if (this.isSwimming) {
/* 402 */         g.drawImage(ImageManager.player_down_swim[1], this.x, this.y, 32, 32, 
/* 403 */             null);
/*     */       } else {
/* 405 */         g.drawImage(ImageManager.player_down[1], this.x, this.y, 32, 
/* 406 */             32, null);
/*     */       }  
/* 408 */     if (!this.right && this.lastDir == 2) {
/* 409 */       if (this.isSwimming) {
/* 410 */         g.drawImage(ImageManager.player_right_swim[1], this.x, this.y, 32, 32, 
/* 411 */             null);
/*     */       } else {
/* 413 */         g.drawImage(ImageManager.player_right[1], this.x, this.y, 32, 
/* 414 */             32, null);
/*     */       } 
/* 415 */       if (a.flashRequest)
/* 416 */         a.imageFlash(g, ImageManager.player_right[1], this.x, this.y, 
/* 417 */             new Color(255, 0, 0, 128)); 
/*     */     } 
/* 420 */     if (!this.left && this.lastDir == 4) {
/* 421 */       if (this.isSwimming) {
/* 422 */         g.drawImage(ImageManager.player_left_swim[1], this.x, this.y, 32, 32, 
/* 423 */             null);
/*     */       } else {
/* 425 */         g.drawImage(ImageManager.player_left[1], this.x, this.y, 32, 
/* 426 */             32, null);
/*     */       } 
/* 427 */       if (a.flashRequest)
/* 428 */         a.imageFlash(g, ImageManager.player_left[1], this.x, this.y, 
/* 429 */             new Color(255, 0, 0, 128)); 
/*     */     } 
/* 432 */     if (!this.up && this.lastDir == 1) {
/* 433 */       if (this.isSwimming) {
/* 434 */         g.drawImage(ImageManager.player_up_swim[1], this.x, this.y, 32, 32, null);
/*     */       } else {
/* 436 */         g.drawImage(ImageManager.player_up[1], this.x, this.y, 32, 32, 
/* 437 */             null);
/*     */       } 
/* 438 */       if (a.flashRequest)
/* 439 */         a.imageFlash(g, ImageManager.player_up[1], this.x, this.y, 
/* 440 */             new Color(255, 0, 0, 128)); 
/*     */     } 
/* 443 */     if (!this.down && this.lastDir == 3) {
/* 444 */       if (this.isSwimming) {
/* 445 */         g.drawImage(ImageManager.player_down_swim[1], this.x, this.y, 32, 32, 
/* 446 */             null);
/*     */       } else {
/* 448 */         g.drawImage(ImageManager.player_down[1], this.x, this.y, 32, 
/* 449 */             32, null);
/*     */       } 
/* 450 */       if (a.flashRequest)
/* 451 */         a.imageFlash(g, ImageManager.player_down[1], this.x, this.y, 
/* 452 */             new Color(255, 0, 0, 128)); 
/*     */     } 
/* 455 */     if (a.flashRequest && (
/* 456 */       this.movingUp || this.movingDown || this.movingLeft || this.movingRight))
/* 457 */       a.imageFlash(g, a.getCurrentFrame(), this.x, this.y, new Color(255, 
/* 458 */             0, 0, 128)); 
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.1.0_4.jar!\com\emgartley\beyondOrigins\main\entities\Player.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */