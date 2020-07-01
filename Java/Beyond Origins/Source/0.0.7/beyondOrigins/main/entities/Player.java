/*     */ package beyondOrigins.main.entities;
/*     */ 
/*     */ import beyondOrigins.main.Game;
/*     */ import beyondOrigins.main.gfx.Animate;
/*     */ import beyondOrigins.main.gfx.ImageManager;
/*     */ import beyondOrigins.main.maps.GrassMap;
/*     */ import java.awt.Color;
/*     */ import java.awt.FontMetrics;
/*     */ import java.awt.Graphics;
/*     */ 
/*     */ public class Player {
/*  15 */   public String name = "Roland";
/*     */   
/*  17 */   public String defaultName = "Roland";
/*     */   
/*  19 */   public String typedName = "";
/*     */   
/*  22 */   public double maxHealth = 50.0D;
/*     */   
/*  24 */   public double health = 50.0D;
/*     */   
/*  27 */   public double damage = 1.5D;
/*     */   
/*  28 */   public byte attackRadius = 32;
/*     */   
/*     */   public boolean flashRequest;
/*     */   
/*  32 */   public static byte upCount = 1, downCount = 1, leftCount = 1;
/*     */   
/*  33 */   public static byte rightCount = 1;
/*     */   
/*  36 */   public short level = 1;
/*     */   
/*  36 */   public short exp = 0;
/*     */   
/*  36 */   public short maxLevel = 99;
/*     */   
/*     */   public int[] expLevels;
/*     */   
/*     */   public boolean canMoveUp = true, canMoveDown = true, canMoveLeft = true;
/*     */   
/*     */   public boolean canMoveRight = true;
/*     */   
/*  42 */   public float x = 0.0F;
/*     */   
/*  42 */   public float y = 0.0F;
/*     */   
/*     */   public byte lastDir;
/*     */   
/*     */   public byte catchingUp;
/*     */   
/*     */   public boolean up = false;
/*     */   
/*     */   public boolean down = false;
/*     */   
/*     */   public boolean left = false;
/*     */   
/*     */   public boolean right = false;
/*     */   
/*  45 */   public double SPEED = 1.0D;
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
/*     */   public boolean insideMovement;
/*     */   
/*     */   public float mapX;
/*     */   
/*     */   public float mapY;
/*     */   
/*  49 */   public short mbX = 1232;
/*     */   
/*  49 */   public short mbY = 800;
/*     */   
/*  49 */   public short pbX = 801;
/*     */   
/*  49 */   public short pbY = 1;
/*     */   
/*     */   public short tileX;
/*     */   
/*     */   public short tileY;
/*     */   
/*     */   private static Animate a;
/*     */   
/*     */   private static FontMetrics fm;
/*     */   
/*     */   private static Color hColor;
/*     */   
/*     */   public boolean isAttacking = false;
/*     */   
/*  58 */   private int hpc = 81, xpc = 83, regenTime = 60;
/*     */   
/*     */   private int time;
/*     */   
/*     */   public Player(int x, int y, int mx, int my) {
/*  61 */     this.x = x;
/*  62 */     this.y = y;
/*  63 */     this.mapX = mx;
/*  64 */     this.mapY = my;
/*  65 */     a = new Animate();
/*  66 */     this.expLevels = new int[99];
/*  67 */     this.expLevels[1] = 0;
/*  68 */     this.expLevels[2] = 100;
/*  69 */     this.expLevels[3] = 300;
/*  70 */     this.expLevels[4] = 500;
/*  71 */     this.expLevels[5] = 800;
/*  72 */     this.expLevels[6] = 1100;
/*  73 */     this.expLevels[7] = 1400;
/*  74 */     this.expLevels[8] = 1700;
/*  75 */     this.expLevels[9] = 1900;
/*  76 */     this.expLevels[10] = 2100;
/*     */   }
/*     */   
/*     */   public void tick() {
/*  82 */     this.tileX = (short)((int)this.x / 32);
/*  83 */     this.tileY = (short)((int)this.y / 32);
/*  86 */     if (this.mapX > this.mbX)
/*  87 */       this.mapX = this.mbX; 
/*  89 */     if (this.mapX < Game.playerSpawnX)
/*  90 */       this.mapX = Game.playerSpawnX; 
/*  92 */     if (this.mapY > this.mbY)
/*  93 */       this.mapY = this.mbY; 
/*  95 */     if (this.mapY < Game.playerSpawnY)
/*  96 */       this.mapY = Game.playerSpawnY; 
/*  98 */     if (this.x < 0.0F)
/*  99 */       this.x = 0.0F; 
/* 101 */     if (this.y < 0.0F)
/* 102 */       this.y = 0.0F; 
/* 106 */     this.time++;
/* 107 */     if (this.time >= this.regenTime && this.health < this.maxHealth) {
/* 108 */       this.health += 0.5D;
/* 109 */       this.time = 0;
/* 110 */       healthBarCheck();
/*     */     } 
/* 114 */     if (this.hpc >= 2 || this.health > 0.0D)
/* 115 */       this.hpc = (int)(this.health * 81.0D / this.maxHealth); 
/* 117 */     if (this.health == this.maxHealth)
/* 118 */       this.hpc = 81; 
/* 121 */     if (this.xpc >= 2 || this.exp > 0)
/* 122 */       this.xpc = 83 * (this.exp - this.expLevels[this.level]) / (
/* 123 */         this.expLevels[this.level + 1] - this.expLevels[this.level]); 
/* 125 */     if (this.exp >= this.expLevels[this.level + 1] && this.level < this.maxLevel)
/* 126 */       this.level = (short)(this.level + 1); 
/* 130 */     if (this.mapMovement)
/* 131 */       mapMovement(); 
/* 133 */     if (this.insideMovement)
/* 134 */       insideMovement(); 
/*     */   }
/*     */   
/*     */   public int getCurrentTile() {
/* 139 */     return GrassMap.getTileID(this.tileX, this.tileY);
/*     */   }
/*     */   
/*     */   public boolean isNextTileValid(int dir) {
/* 144 */     if (dir == 1) {
/* 145 */       Game.getMap();
/* 146 */       if (GrassMap.getTileID((int)(this.x + 32.0F) / 32, (int)(this.y - 1.0F) / 32) == 0) {
/* 147 */         Game.getMap();
/* 147 */         if (GrassMap.getTileID((int)this.x / 32, 
/* 148 */             (int)(this.y - 1.0F) / 32) != 0)
/* 149 */           return false; 
/*     */       } else {
/* 149 */         return false;
/*     */       } 
/* 151 */     } else if (dir == 2) {
/* 152 */       Game.getMap();
/* 152 */       if (GrassMap.getTileID((int)(this.x + 33.0F) / 32, 
/* 153 */           (int)(this.y + 32.0F) / 32) == 0) {
/* 154 */         Game.getMap();
/* 154 */         if (GrassMap.getTileID((int)(this.x + 33.0F) / 32, 
/* 155 */             (int)this.y / 32) != 0)
/* 156 */           return false; 
/*     */       } else {
/* 156 */         return false;
/*     */       } 
/* 158 */     } else if (dir == 3) {
/* 159 */       Game.getMap();
/* 159 */       if (GrassMap.getTileID((int)(this.x + 32.0F) / 32, 
/* 160 */           (int)(this.y + 33.0F) / 32) == 0) {
/* 161 */         Game.getMap();
/* 161 */         if (GrassMap.getTileID((int)this.x / 32, 
/* 162 */             (int)(this.y + 33.0F) / 32) != 0)
/* 163 */           return false; 
/*     */       } else {
/* 163 */         return false;
/*     */       } 
/* 165 */     } else if (dir == 4) {
/* 166 */       Game.getMap();
/* 167 */       if (GrassMap.getTileID((int)(this.x - 1.0F) / 32, (int)(this.y + 32.0F) / 32) == 0) {
/* 168 */         Game.getMap();
/* 168 */         if (GrassMap.getTileID((int)(this.x - 1.0F) / 32, 
/* 169 */             (int)this.y / 32) != 0)
/* 170 */           return false; 
/*     */       } else {
/* 170 */         return false;
/*     */       } 
/*     */     } 
/* 173 */     return true;
/*     */   }
/*     */   
/*     */   public void attack() {
/* 177 */     this.isAttacking = true;
/* 178 */     if (Math.sqrt(((this.x - TestDummy.rx) * (this.x - TestDummy.rx) + (
/* 179 */         this.y - TestDummy.ry) * (this.y - TestDummy.ry))) <= this.attackRadius)
/* 180 */       TestDummy.takeDamage(this.damage); 
/*     */   }
/*     */   
/*     */   public void takeDamage(double d) {
/* 185 */     if (this.health >= d && !TestDummy.isDead) {
/* 186 */       this.health -= d;
/* 187 */       a.flashRequest = true;
/* 188 */     } else if (this.health == 0.0D) {
/* 189 */       kill();
/*     */     } 
/* 191 */     healthBarCheck();
/*     */   }
/*     */   
/*     */   public void kill() {
/* 195 */     Game.isInGame = false;
/* 196 */     (Game.getMainMenu()).menuState = 6;
/*     */   }
/*     */   
/*     */   public void respawn() {
/* 200 */     this.health = this.maxHealth;
/* 201 */     this.x = Game.playerSpawnX;
/* 202 */     this.y = Game.playerSpawnY;
/* 203 */     this.mapX = Game.playerSpawnX;
/* 204 */     this.mapY = Game.playerSpawnY;
/* 205 */     this.lastDir = 3;
/* 206 */     (Game.getMainMenu()).menuState = 0;
/* 207 */     Game.isInGame = true;
/* 208 */     healthBarCheck();
/*     */   }
/*     */   
/*     */   public void healthBarCheck() {
/* 212 */     if (this.health >= 0.0D && this.health <= this.maxHealth / 3.0D) {
/* 213 */       hColor = new Color(127, 0, 0);
/* 214 */     } else if (this.health > this.maxHealth / 3.0D && this.health <= this.maxHealth / 3.0D * 2.0D) {
/* 215 */       hColor = new Color(255, 216, 0);
/* 216 */     } else if (this.health <= this.maxHealth) {
/* 217 */       hColor = new Color(0, 255, 33);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void drawPlayerHUD(Graphics g) {
/* 222 */     g.drawImage(ImageManager.pHUD, 5, 5, null);
/* 223 */     g.setFont(Game.playerHUDFont);
/* 224 */     g.setColor(Color.black);
/* 225 */     fm = g.getFontMetrics(Game.playerHUDFont);
/* 226 */     g.drawString(String.valueOf(this.name) + " | Lvl " + this.level, 
/* 227 */         108 - fm.stringWidth(String.valueOf(this.name) + " | Lvl " + this.level) / 2, 21);
/* 228 */     drawHealthBar(g);
/* 229 */     drawExpBar(g);
/* 230 */     g.drawImage(ImageManager.playerd1, 21, 21, null);
/*     */   }
/*     */   
/*     */   private void drawHealthBar(Graphics g) {
/* 234 */     fm = g.getFontMetrics(Game.pHUDBar);
/* 235 */     g.setColor(hColor);
/* 236 */     g.fillRect(69, 34, this.hpc, 8);
/* 237 */     g.setFont(Game.pHUDBar);
/* 238 */     g.setColor(Color.black);
/* 239 */     g.drawString(String.valueOf(this.health), 
/* 240 */         108 - fm.stringWidth(String.valueOf(this.health)) / 2, 42);
/*     */   }
/*     */   
/*     */   private void drawExpBar(Graphics g) {
/* 244 */     fm = g.getFontMetrics(Game.pHUDBar);
/* 245 */     g.setColor(Color.blue);
/* 246 */     g.fillRect(67, 50, this.xpc, 8);
/* 247 */     g.setFont(Game.pHUDBar);
/* 248 */     g.setColor(Color.white);
/* 249 */     g.drawString(String.valueOf(this.exp), 
/* 250 */         108 - fm.stringWidth(String.valueOf(this.exp)) / 2, 58);
/*     */   }
/*     */   
/*     */   public void mapMovement() {
/* 255 */     if (this.up && this.canMoveUp) {
/* 256 */       if (this.mapY <= Game.playerSpawnY && isNextTileValid(1)) {
/* 257 */         this.y = (float)(this.y - this.SPEED);
/* 258 */       } else if (this.catchingUp != 1 && this.y <= Game.playerSpawnY && 
/* 259 */         isNextTileValid(1)) {
/* 260 */         this.mapY = (float)(this.mapY - this.SPEED);
/*     */       } 
/* 262 */       upCount = (byte)(int)(upCount + this.SPEED);
/* 263 */       this.movingUp = true;
/* 264 */       this.lastDir = 1;
/* 265 */       if (upCount >= 42)
/* 266 */         upCount = 1; 
/*     */     } else {
/* 269 */       upCount = 0;
/* 270 */       this.movingUp = false;
/* 271 */       if (this.movingDown && this.y <= Game.playerSpawnY && isNextTileValid(3)) {
/* 272 */         this.y = (float)(this.y + this.SPEED);
/* 273 */         this.catchingUp = 1;
/*     */       } else {
/* 275 */         this.catchingUp = 0;
/*     */       } 
/*     */     } 
/* 279 */     if (this.down && this.y <= 511.0F && this.canMoveDown) {
/* 280 */       if (this.mapY >= this.mbY && this.y < 481.0F && isNextTileValid(3)) {
/* 281 */         this.y = (float)(this.y + this.SPEED);
/* 282 */       } else if (this.catchingUp != 3 && 
/* 283 */         this.y >= Game.playerSpawnY && isNextTileValid(3) && 
/* 284 */         this.y < 481.0F) {
/* 285 */         this.mapY = (float)(this.mapY + this.SPEED);
/*     */       } 
/* 287 */       downCount = (byte)(int)(downCount + this.SPEED);
/* 288 */       this.movingDown = true;
/* 289 */       this.lastDir = 3;
/* 290 */       if (downCount >= 42)
/* 291 */         downCount = 1; 
/*     */     } else {
/* 294 */       downCount = 0;
/* 295 */       this.movingDown = false;
/* 296 */       if (this.movingUp && this.y >= Game.playerSpawnY && isNextTileValid(1)) {
/* 297 */         this.y = (float)(this.y - this.SPEED);
/* 298 */         this.catchingUp = 3;
/*     */       } else {
/* 300 */         this.catchingUp = 0;
/*     */       } 
/*     */     } 
/* 304 */     if (this.left && this.x >= 0.0F && this.canMoveLeft) {
/* 305 */       if (this.mapX <= Game.playerSpawnX && this.x > 30.0D + this.SPEED && 
/* 306 */         isNextTileValid(4)) {
/* 307 */         this.x = (float)(this.x - this.SPEED);
/* 308 */       } else if (this.catchingUp != 4 && 
/* 309 */         this.x <= Game.playerSpawnX && isNextTileValid(4) && 
/* 310 */         this.x > 30.0D + this.SPEED) {
/* 311 */         this.mapX = (float)(this.mapX - this.SPEED);
/*     */       } 
/* 313 */       leftCount = (byte)(int)(leftCount + this.SPEED);
/* 314 */       this.movingLeft = true;
/* 315 */       this.lastDir = 4;
/* 316 */       if (leftCount >= 42)
/* 317 */         leftCount = 1; 
/*     */     } else {
/* 320 */       leftCount = 0;
/* 321 */       this.movingLeft = false;
/* 322 */       if (this.movingRight && this.x <= Game.playerSpawnX && isNextTileValid(2)) {
/* 323 */         this.x = (float)(this.x + this.SPEED);
/* 324 */         this.catchingUp = 4;
/*     */       } else {
/* 326 */         this.catchingUp = 0;
/*     */       } 
/*     */     } 
/* 330 */     if (this.right && this.x <= this.pbX && this.canMoveRight) {
/* 331 */       if (this.mapX >= this.mbX && this.x < 771.0F && isNextTileValid(2)) {
/* 332 */         this.x = (float)(this.x + this.SPEED);
/* 333 */       } else if (this.catchingUp != 2 && 
/* 334 */         this.x >= Game.playerSpawnX && isNextTileValid(2) && 
/* 335 */         this.x < 771.0F) {
/* 336 */         this.mapX = (float)(this.mapX + this.SPEED);
/*     */       } 
/* 338 */       rightCount = (byte)(int)(rightCount + this.SPEED);
/* 339 */       this.movingRight = true;
/* 340 */       this.lastDir = 2;
/* 341 */       if (rightCount >= 42)
/* 342 */         rightCount = 1; 
/*     */     } else {
/* 345 */       rightCount = 0;
/* 346 */       this.movingRight = false;
/* 347 */       if (this.movingLeft && this.x >= Game.playerSpawnX && isNextTileValid(4)) {
/* 348 */         this.x = (float)(this.x - this.SPEED);
/* 349 */         this.catchingUp = 2;
/*     */       } else {
/* 351 */         this.catchingUp = 0;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void insideMovement() {
/* 357 */     if (this.up && this.y >= 125.0F && this.canMoveUp) {
/* 358 */       this.y = (float)(this.y - this.SPEED);
/* 359 */       upCount = (byte)(upCount + 1);
/* 360 */       this.movingUp = true;
/* 361 */       this.lastDir = 1;
/* 362 */       if (upCount == 42)
/* 363 */         upCount = 1; 
/*     */     } else {
/* 366 */       upCount = 0;
/* 367 */       this.movingUp = false;
/*     */     } 
/* 369 */     if (this.down && this.y <= 423.0F && this.canMoveDown) {
/* 370 */       this.y = (float)(this.y + this.SPEED);
/* 371 */       downCount = (byte)(downCount + 1);
/* 372 */       this.movingDown = true;
/* 373 */       this.lastDir = 3;
/* 374 */       if (downCount == 42)
/* 375 */         downCount = 1; 
/*     */     } else {
/* 378 */       downCount = 0;
/* 379 */       this.movingDown = false;
/*     */     } 
/* 381 */     if (this.left && this.x >= 194.0F && this.canMoveLeft) {
/* 382 */       this.x = (float)(this.x - this.SPEED);
/* 383 */       leftCount = (byte)(leftCount + 1);
/* 384 */       this.movingLeft = true;
/* 385 */       this.lastDir = 4;
/* 386 */       if (leftCount == 42)
/* 387 */         leftCount = 1; 
/*     */     } else {
/* 390 */       leftCount = 0;
/* 391 */       this.movingLeft = false;
/*     */     } 
/* 393 */     if (this.right && this.x <= 612.0F && this.canMoveRight) {
/* 394 */       this.x = (float)(this.x + this.SPEED);
/* 395 */       rightCount = (byte)(rightCount + 1);
/* 396 */       this.movingRight = true;
/* 397 */       this.lastDir = 2;
/* 398 */       if (rightCount == 42)
/* 399 */         rightCount = 1; 
/*     */     } else {
/* 402 */       rightCount = 0;
/* 403 */       this.movingRight = false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render(Graphics g) {
/* 408 */     if (!this.isAttacking) {
/* 409 */       a.animateEntity(g, (int)this.x, (int)this.y, ImageManager.playeru1, 
/* 410 */           ImageManager.playeru2, ImageManager.playeru3, 
/* 411 */           ImageManager.playeru4, upCount);
/* 412 */       a.animateEntity(g, (int)this.x, (int)this.y, ImageManager.playerd1, 
/* 413 */           ImageManager.playerd2, ImageManager.playerd3, 
/* 414 */           ImageManager.playerd4, downCount);
/* 415 */       a.animateEntity(g, (int)this.x, (int)this.y, ImageManager.playerl1, 
/* 416 */           ImageManager.playerl2, ImageManager.playerl3, 
/* 417 */           ImageManager.playerl4, leftCount);
/* 418 */       a.animateEntity(g, (int)this.x, (int)this.y, ImageManager.playerr1, 
/* 419 */           ImageManager.playerr2, ImageManager.playerr3, 
/* 420 */           ImageManager.playerr4, rightCount);
/* 421 */     } else if (this.isAttacking) {
/* 422 */       a.animateEntity(g, (int)this.x, (int)this.y, ImageManager.playeru1_a, 
/* 423 */           ImageManager.playeru2_a, ImageManager.playeru3_a, 
/* 424 */           ImageManager.playeru4_a, upCount);
/* 425 */       a.animateEntity(g, (int)this.x, (int)this.y, ImageManager.playerd1_a, 
/* 426 */           ImageManager.playerd2_a, ImageManager.playerd3_a, 
/* 427 */           ImageManager.playerd4_a, downCount);
/* 428 */       a.animateEntity(g, (int)this.x, (int)this.y, ImageManager.playerl1_a, 
/* 429 */           ImageManager.playerl2_a, ImageManager.playerl3_a, 
/* 430 */           ImageManager.playerl4_a, leftCount);
/* 431 */       a.animateEntity(g, (int)this.x, (int)this.y, ImageManager.playerr1_a, 
/* 432 */           ImageManager.playerr2_a, ImageManager.playerr3_a, 
/* 433 */           ImageManager.playerr4_a, rightCount);
/*     */     } 
/* 436 */     if (!this.movingUp && !this.movingDown && !this.movingLeft && !this.movingRight && 
/* 437 */       this.lastDir == 0)
/* 439 */       g.drawImage(ImageManager.playerd1, (int)this.x, (int)this.y, 32, 32, null); 
/* 442 */     if (!this.movingRight && this.lastDir == 2) {
/* 443 */       g.drawImage(ImageManager.playerr1, (int)this.x, (int)this.y, 32, 32, null);
/* 444 */       if (a.flashRequest)
/* 445 */         a.imageFlash(g, ImageManager.playerr1, this.x, this.y, new Color(255, 0, 
/* 446 */               0, 128)); 
/*     */     } 
/* 449 */     if (!this.movingLeft && this.lastDir == 4) {
/* 450 */       g.drawImage(ImageManager.playerl1, (int)this.x, (int)this.y, 32, 32, null);
/* 451 */       if (a.flashRequest)
/* 452 */         a.imageFlash(g, ImageManager.playerl1, this.x, this.y, new Color(255, 0, 
/* 453 */               0, 128)); 
/*     */     } 
/* 456 */     if (!this.movingUp && this.lastDir == 1) {
/* 457 */       g.drawImage(ImageManager.playeru1, (int)this.x, (int)this.y, 32, 32, null);
/* 458 */       if (a.flashRequest)
/* 459 */         a.imageFlash(g, ImageManager.playeru1, this.x, this.y, new Color(255, 0, 
/* 460 */               0, 128)); 
/*     */     } 
/* 463 */     if (!this.movingDown && this.lastDir == 3) {
/* 464 */       g.drawImage(ImageManager.playerd1, (int)this.x, (int)this.y, 32, 32, null);
/* 465 */       if (a.flashRequest)
/* 466 */         a.imageFlash(g, ImageManager.playerd1, this.x, this.y, new Color(255, 0, 
/* 467 */               0, 128)); 
/*     */     } 
/* 471 */     if (a.flashRequest && (
/* 472 */       this.movingUp || this.movingDown || this.movingLeft || this.movingRight))
/* 473 */       a.imageFlash(g, a.getCurrentFrame(), this.x, this.y, 
/* 474 */           new Color(255, 0, 0, 128)); 
/* 476 */     drawPlayerHUD(g);
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.7.jar!\beyondOrigins\main\entities\Player.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */