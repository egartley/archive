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
/*  16 */   public String name = "Roland";
/*     */   
/*  17 */   public String defaultName = this.name;
/*     */   
/*  18 */   public String typedName = "";
/*     */   
/*  19 */   public double maxHealth = 50.0D;
/*     */   
/*  19 */   public double health = 50.0D;
/*     */   
/*  19 */   public double damage = 1.5D;
/*     */   
/*  20 */   public byte attackRadius = 32;
/*     */   
/*     */   public boolean flashRequest;
/*     */   
/*  22 */   public byte moveCount = 1;
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
/*  62 */     this.tileX = (this.x + 16 + (Game.getMap()).x) / 32;
/*  63 */     this.tileY = (this.y + 16 + (Game.getMap()).y) / 32;
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
/*  85 */     if (getCurrentTile() == 1) {
/*  86 */       this.isSwimming = false;
/*  87 */     } else if (getCurrentTile() == 3) {
/*  88 */       this.isSwimming = true;
/*     */     } 
/*  91 */     mapMovement();
/*     */   }
/*     */   
/*     */   public int getCurrentTile() {
/*  95 */     Game.getMap();
/*  96 */     return GrassMap.getTileID(this.tileX, this.tileY);
/*     */   }
/*     */   
/*     */   public boolean isNextTileValid(int dir) {
/* 100 */     if (dir == 1) {
/* 101 */       int check1 = GrassMap.getTileID((
/* 102 */           this.x + 16 + (Game.getMap()).x + 16) / 32, (this.y + 
/* 103 */           (Game.getMap()).y - 1) / 32);
/* 104 */       int check2 = GrassMap.getTileID((
/* 105 */           this.x + 16 + (Game.getMap()).x - 16) / 32, (this.y + 
/* 106 */           (Game.getMap()).y - 1) / 32);
/* 107 */       if ((check1 != 1 && check1 != 3) || (check2 != 1 && check2 != 3))
/* 108 */         return false; 
/* 110 */     } else if (dir == 2) {
/* 111 */       int check1 = GrassMap.getTileID((
/* 112 */           this.x + (Game.getMap()).x + 33) / 32, (this.y + 16 + 
/* 113 */           (Game.getMap()).y - 16) / 32);
/* 114 */       int check2 = GrassMap.getTileID((
/* 115 */           this.x + (Game.getMap()).x + 33) / 32, (this.y + 16 + 
/* 116 */           (Game.getMap()).y + 16) / 32);
/* 117 */       if ((check1 != 1 && check1 != 3) || (check2 != 1 && check2 != 3))
/* 118 */         return false; 
/* 120 */     } else if (dir == 3) {
/* 121 */       int check1 = GrassMap.getTileID((
/* 122 */           this.x + 16 + (Game.getMap()).x + 16) / 32, (this.y + 
/* 123 */           (Game.getMap()).y + 33) / 32);
/* 124 */       int check2 = GrassMap.getTileID((
/* 125 */           this.x + 16 + (Game.getMap()).x - 16) / 32, (this.y + 
/* 126 */           (Game.getMap()).y + 33) / 32);
/* 127 */       if ((check1 != 1 && check1 != 3) || (check2 != 1 && check2 != 3))
/* 128 */         return false; 
/* 130 */     } else if (dir == 4) {
/* 131 */       int check1 = GrassMap.getTileID((
/* 132 */           this.x + (Game.getMap()).x - 1) / 32, (
/* 133 */           this.y + 32 + (Game.getMap()).y) / 32);
/* 134 */       int check2 = GrassMap.getTileID((
/* 135 */           this.x + (Game.getMap()).x - 1) / 32, (
/* 136 */           this.y + 32 + (Game.getMap()).y - 32) / 32);
/* 137 */       if ((check1 != 1 && check1 != 3) || (check2 != 1 && check2 != 3))
/* 138 */         return false; 
/*     */     } 
/* 141 */     return true;
/*     */   }
/*     */   
/*     */   public void attack() {
/* 145 */     this.isAttacking = true;
/* 146 */     if (Math.sqrt(((this.x - TestDummy.rx) * (this.x - TestDummy.rx) + (
/* 147 */         this.y - TestDummy.ry) * (this.y - TestDummy.ry))) <= this.attackRadius)
/* 148 */       TestDummy.takeDamage(this.damage); 
/*     */   }
/*     */   
/*     */   public void takeDamage(double d) {
/* 153 */     if (this.health >= d && !TestDummy.isDead) {
/* 154 */       this.health -= d;
/* 155 */       a.flashRequest = true;
/* 156 */     } else if (this.health == 0.0D) {
/* 157 */       kill();
/*     */     } 
/* 159 */     healthBarCheck();
/*     */   }
/*     */   
/*     */   public void fixPos() {
/* 163 */     if (this.x < 32) {
/* 164 */       this.x = 32;
/* 165 */     } else if (this.x > Game.width - 32) {
/* 166 */       this.x = Game.width - 32;
/*     */     } 
/* 168 */     if (this.y < 32) {
/* 169 */       this.y = 32;
/* 170 */     } else if (this.y > Game.height - 32) {
/* 171 */       this.y = Game.height - 32;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void kill() {
/* 176 */     Game.isInGame = false;
/* 177 */     (Game.getMainMenu()).menuState = 6;
/*     */   }
/*     */   
/*     */   public void respawn() {
/* 181 */     this.health = this.maxHealth;
/* 182 */     this.x = Game.pMidX;
/* 183 */     this.y = Game.pMidY;
/* 184 */     (Game.getMap()).x = 0;
/* 185 */     (Game.getMap()).y = 0;
/* 186 */     this.lastDir = 3;
/* 187 */     (Game.getMainMenu()).menuState = 0;
/* 188 */     Game.isInGame = true;
/* 189 */     healthBarCheck();
/*     */   }
/*     */   
/*     */   public void healthBarCheck() {
/* 193 */     if (this.health >= 0.0D && this.health <= this.maxHealth / 3.0D) {
/* 194 */       hColor = new Color(127, 0, 0);
/* 195 */     } else if (this.health > this.maxHealth / 3.0D && 
/* 196 */       this.health <= this.maxHealth / 3.0D * 2.0D) {
/* 197 */       hColor = new Color(255, 216, 0);
/* 198 */     } else if (this.health <= this.maxHealth) {
/* 199 */       hColor = new Color(0, 255, 33);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void drawPlayerHUD(Graphics g) {
/* 204 */     fm = g.getFontMetrics(new Font("MoolBoran", 1, 19));
/* 205 */     g.drawImage(ImageManager.player_hud, 5, 5, null);
/* 206 */     g.setFont(new Font("MoolBoran", 1, 19));
/* 207 */     g.setColor(new Color(0, 0, 0, 147));
/* 208 */     g.drawString(String.valueOf(this.name) + ": Lvl " + this.level, 
/* 209 */         108 - fm.stringWidth(String.valueOf(this.name) + ": Lvl " + this.level) / 2, 
/* 210 */         21);
/* 211 */     drawHealthBar(g);
/* 212 */     drawExpBar(g);
/* 213 */     g.drawImage(ImageManager.player_down[1], 22, 22, null);
/*     */   }
/*     */   
/*     */   private void drawHealthBar(Graphics g) {
/* 217 */     fm = g.getFontMetrics(Game.pHUDBar);
/* 218 */     g.setColor(hColor);
/* 219 */     g.fillRect(67, 34, this.hpc, 8);
/* 220 */     g.setFont(Game.pHUDBar);
/* 221 */     g.setColor(Color.black);
/* 222 */     g.drawString(String.valueOf(this.health), 
/* 223 */         108 - fm.stringWidth(String.valueOf(this.health)) / 2, 42);
/*     */   }
/*     */   
/*     */   private void drawExpBar(Graphics g) {
/* 227 */     fm = g.getFontMetrics(Game.pHUDBar);
/* 228 */     g.setColor(Color.blue);
/* 229 */     g.fillRect(67, 50, this.xpc, 8);
/* 230 */     g.setFont(Game.pHUDBar);
/* 231 */     g.setColor(Color.white);
/* 232 */     g.drawString(String.valueOf(this.exp), 
/* 233 */         108 - fm.stringWidth(String.valueOf(this.exp)) / 2, 58);
/*     */   }
/*     */   
/*     */   public void mapMovement() {
/* 237 */     if (this.up || this.down || this.left || this.right) {
/* 238 */       if (this.up && this.canMoveUp) {
/* 239 */         if (this.y <= Game.height / 2 - 16 && isNextTileValid(1) && 
/* 240 */           (Game.getMap()).y > 0) {
/* 241 */           (Game.getMap()).y = (int)((Game.getMap()).y - this.SPEED);
/* 242 */         } else if (isNextTileValid(1)) {
/* 243 */           this.y = (int)(this.y - this.SPEED);
/*     */         } 
/* 245 */         this.moveCount = (byte)(int)(this.moveCount + this.SPEED);
/* 246 */         this.movingDown = false;
/* 247 */         this.movingUp = true;
/* 248 */         this.movingLeft = false;
/* 249 */         this.movingRight = false;
/* 250 */         this.lastDir = 1;
/* 251 */         if (this.moveCount >= 42)
/* 252 */           this.moveCount = 2; 
/* 254 */       } else if (this.down && this.canMoveDown) {
/* 255 */         if (this.y >= Game.height / 2 - 16 && isNextTileValid(3) && 
/* 256 */           this.y < Game.height && (Game.getMap()).y < 608) {
/* 257 */           (Game.getMap()).y = (int)((Game.getMap()).y + this.SPEED);
/* 258 */         } else if (this.y + 32 < Game.height && isNextTileValid(3)) {
/* 259 */           this.y = (int)(this.y + this.SPEED);
/*     */         } 
/* 261 */         this.moveCount = (byte)(int)(this.moveCount + this.SPEED);
/* 262 */         this.movingDown = true;
/* 263 */         this.movingUp = false;
/* 264 */         this.movingLeft = false;
/* 265 */         this.movingRight = false;
/* 266 */         this.lastDir = 3;
/* 267 */         if (this.moveCount >= 42)
/* 268 */           this.moveCount = 2; 
/*     */       } 
/* 272 */       if (this.right && this.x <= this.pbX && this.canMoveRight) {
/* 273 */         if (this.x >= Game.width / 2 - 16 && isNextTileValid(2) && 
/* 274 */           this.x < 771 && (Game.getMap()).x < 896) {
/* 275 */           (Game.getMap()).x = (int)((Game.getMap()).x + this.SPEED);
/* 276 */         } else if (this.x < 771 && isNextTileValid(2)) {
/* 277 */           this.x = (int)(this.x + this.SPEED);
/*     */         } 
/* 279 */         this.moveCount = (byte)(int)(this.moveCount + this.SPEED);
/* 280 */         this.movingDown = false;
/* 281 */         this.movingUp = false;
/* 282 */         this.movingLeft = false;
/* 283 */         this.movingRight = true;
/* 284 */         this.lastDir = 2;
/* 285 */         if (this.moveCount >= 42)
/* 286 */           this.moveCount = 2; 
/* 288 */       } else if (this.left && this.canMoveLeft) {
/* 289 */         if (this.x <= Game.width / 2 - 16 && 
/* 290 */           isNextTileValid(4) && (Game.getMap()).x > 0) {
/* 291 */           (Game.getMap()).x = (int)((Game.getMap()).x - this.SPEED);
/* 292 */         } else if (isNextTileValid(4)) {
/* 293 */           this.x = (int)(this.x - this.SPEED);
/*     */         } 
/* 295 */         this.moveCount = (byte)(int)(this.moveCount + this.SPEED);
/* 296 */         this.movingDown = false;
/* 297 */         this.movingUp = false;
/* 298 */         this.movingLeft = true;
/* 299 */         this.movingRight = false;
/* 300 */         this.lastDir = 4;
/* 301 */         if (this.moveCount >= 42)
/* 302 */           this.moveCount = 2; 
/*     */       } 
/*     */     } else {
/* 306 */       this.moveCount = 1;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void insideMovement() {
/* 311 */     if (this.up && this.y >= 125.0F && this.canMoveUp) {
/* 312 */       this.y = (int)(this.y - this.SPEED);
/* 313 */       this.moveCount = (byte)(this.moveCount + 1);
/* 314 */       this.movingUp = true;
/* 315 */       this.lastDir = 1;
/* 316 */       if (this.moveCount == 42)
/* 317 */         this.moveCount = 1; 
/*     */     } else {
/* 320 */       this.movingUp = false;
/*     */     } 
/* 322 */     if (this.down && this.y <= 423.0F && this.canMoveDown) {
/* 323 */       this.y = (int)(this.y + this.SPEED);
/* 324 */       this.moveCount = (byte)(this.moveCount + 1);
/* 325 */       this.movingDown = true;
/* 326 */       this.lastDir = 3;
/* 327 */       if (this.moveCount == 42)
/* 328 */         this.moveCount = 1; 
/*     */     } else {
/* 331 */       this.movingDown = false;
/*     */     } 
/* 333 */     if (this.left && this.x >= 194.0F && this.canMoveLeft) {
/* 334 */       this.x = (int)(this.x - this.SPEED);
/* 335 */       this.moveCount = (byte)(this.moveCount + 1);
/* 336 */       this.movingLeft = true;
/* 337 */       this.lastDir = 4;
/* 338 */       if (this.moveCount == 42)
/* 339 */         this.moveCount = 1; 
/*     */     } else {
/* 342 */       this.movingLeft = false;
/*     */     } 
/* 344 */     if (this.right && this.x <= 612.0F && this.canMoveRight) {
/* 345 */       this.x = (int)(this.x + this.SPEED);
/* 346 */       this.moveCount = (byte)(this.moveCount + 1);
/* 347 */       this.movingRight = true;
/* 348 */       this.lastDir = 2;
/* 349 */       if (this.moveCount == 42)
/* 350 */         this.moveCount = 1; 
/*     */     } else {
/* 353 */       this.movingRight = false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render(Graphics g) {
/* 358 */     if (F3Menu.f3menu) {
/* 359 */       g.setColor(Color.yellow);
/* 360 */       g.drawRect(this.x, this.y, 32, 32);
/*     */     } 
/* 362 */     if (!this.isAttacking) {
/* 363 */       if (this.isSwimming) {
/* 364 */         if (this.movingUp) {
/* 365 */           a.animateEntity(g, this.x, this.y, 
/* 366 */               ImageManager.player_up_swim, this.moveCount);
/* 367 */         } else if (this.movingDown) {
/* 368 */           a.animateEntity(g, this.x, this.y, 
/* 369 */               ImageManager.player_down_swim, this.moveCount);
/* 370 */         } else if (this.movingLeft) {
/* 371 */           a.animateEntity(g, this.x, this.y, 
/* 372 */               ImageManager.player_left_swim, this.moveCount);
/* 373 */         } else if (this.movingRight) {
/* 374 */           a.animateEntity(g, this.x, this.y, 
/* 375 */               ImageManager.player_right_swim, this.moveCount);
/*     */         } 
/* 378 */       } else if (this.movingUp) {
/* 379 */         a.animateEntity(g, this.x, this.y, ImageManager.player_up, 
/* 380 */             this.moveCount);
/* 381 */       } else if (this.movingDown) {
/* 382 */         a.animateEntity(g, this.x, this.y, 
/* 383 */             ImageManager.player_down, this.moveCount);
/* 384 */       } else if (this.movingLeft) {
/* 385 */         a.animateEntity(g, this.x, this.y, 
/* 386 */             ImageManager.player_left, this.moveCount);
/* 387 */       } else if (this.movingRight) {
/* 388 */         a.animateEntity(g, this.x, this.y, 
/* 389 */             ImageManager.player_right, this.moveCount);
/*     */       } 
/* 392 */     } else if (this.isAttacking) {
/* 393 */       if (this.movingUp) {
/* 394 */         a.animateEntity(g, this.x, this.y, 
/* 395 */             ImageManager.player_up_attack, this.moveCount);
/* 396 */       } else if (this.movingDown) {
/* 397 */         a.animateEntity(g, this.x, this.y, 
/* 398 */             ImageManager.player_down_attack, this.moveCount);
/* 399 */       } else if (this.movingLeft) {
/* 400 */         a.animateEntity(g, this.x, this.y, 
/* 401 */             ImageManager.player_left_attack, this.moveCount);
/* 402 */       } else if (this.movingRight) {
/* 403 */         a.animateEntity(g, this.x, this.y, 
/* 404 */             ImageManager.player_right_attack, this.moveCount);
/*     */       } 
/*     */     } 
/* 407 */     if (!this.up && !this.down && !this.left && !this.right && 
/* 408 */       this.lastDir == 0)
/* 409 */       if (this.isSwimming) {
/* 410 */         g.drawImage(ImageManager.player_down_swim[1], this.x, this.y, 32, 32, 
/* 411 */             null);
/*     */       } else {
/* 413 */         g.drawImage(ImageManager.player_down[1], this.x, this.y, 32, 
/* 414 */             32, null);
/*     */       }  
/* 416 */     if (!this.right && this.lastDir == 2) {
/* 417 */       if (this.isSwimming) {
/* 418 */         g.drawImage(ImageManager.player_right_swim[1], this.x, this.y, 32, 32, 
/* 419 */             null);
/*     */       } else {
/* 421 */         g.drawImage(ImageManager.player_right[1], this.x, this.y, 32, 
/* 422 */             32, null);
/*     */       } 
/* 423 */       if (a.flashRequest)
/* 424 */         a.imageFlash(g, ImageManager.player_right[1], this.x, this.y, 
/* 425 */             new Color(255, 0, 0, 128)); 
/*     */     } 
/* 428 */     if (!this.left && this.lastDir == 4) {
/* 429 */       if (this.isSwimming) {
/* 430 */         g.drawImage(ImageManager.player_left_swim[1], this.x, this.y, 32, 32, 
/* 431 */             null);
/*     */       } else {
/* 433 */         g.drawImage(ImageManager.player_left[1], this.x, this.y, 32, 
/* 434 */             32, null);
/*     */       } 
/* 435 */       if (a.flashRequest)
/* 436 */         a.imageFlash(g, ImageManager.player_left[1], this.x, this.y, 
/* 437 */             new Color(255, 0, 0, 128)); 
/*     */     } 
/* 440 */     if (!this.up && this.lastDir == 1) {
/* 441 */       if (this.isSwimming) {
/* 442 */         g.drawImage(ImageManager.player_up_swim[1], this.x, this.y, 32, 32, null);
/*     */       } else {
/* 444 */         g.drawImage(ImageManager.player_up[1], this.x, this.y, 32, 32, 
/* 445 */             null);
/*     */       } 
/* 446 */       if (a.flashRequest)
/* 447 */         a.imageFlash(g, ImageManager.player_up[1], this.x, this.y, 
/* 448 */             new Color(255, 0, 0, 128)); 
/*     */     } 
/* 451 */     if (!this.down && this.lastDir == 3) {
/* 452 */       if (this.isSwimming) {
/* 453 */         g.drawImage(ImageManager.player_down_swim[1], this.x, this.y, 32, 32, 
/* 454 */             null);
/*     */       } else {
/* 456 */         g.drawImage(ImageManager.player_down[1], this.x, this.y, 32, 
/* 457 */             32, null);
/*     */       } 
/* 458 */       if (a.flashRequest)
/* 459 */         a.imageFlash(g, ImageManager.player_down[1], this.x, this.y, 
/* 460 */             new Color(255, 0, 0, 128)); 
/*     */     } 
/* 463 */     if (a.flashRequest && (
/* 464 */       this.movingUp || this.movingDown || this.movingLeft || this.movingRight))
/* 465 */       a.imageFlash(g, a.getCurrentFrame(), this.x, this.y, new Color(255, 
/* 466 */             0, 0, 128)); 
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.1.0_5.jar!\com\emgartley\beyondOrigins\main\entities\Player.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */