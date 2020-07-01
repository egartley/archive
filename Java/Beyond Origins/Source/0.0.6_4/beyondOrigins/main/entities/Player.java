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
/*  36 */   public short untilNextLvl = 0;
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
/*  57 */   private int hpc = 81, xpc = 83, regenTime = 60;
/*     */   
/*     */   private int time;
/*     */   
/*     */   public Player(int x, int y, int mx, int my) {
/*  60 */     this.x = x;
/*  61 */     this.y = y;
/*  62 */     this.mapX = mx;
/*  63 */     this.mapY = my;
/*  64 */     a = new Animate();
/*  65 */     this.expLevels = new int[99];
/*  66 */     this.expLevels[1] = 0;
/*  67 */     this.expLevels[2] = 100;
/*  68 */     this.expLevels[3] = 300;
/*  69 */     this.expLevels[4] = 500;
/*  70 */     this.expLevels[5] = 800;
/*  71 */     this.expLevels[6] = 1100;
/*  72 */     this.expLevels[7] = 1400;
/*  73 */     this.expLevels[8] = 1700;
/*  74 */     this.expLevels[9] = 1900;
/*  75 */     this.expLevels[10] = 2100;
/*     */   }
/*     */   
/*     */   public void tick() {
/*  81 */     this.tileX = (short)((int)this.x / 32);
/*  82 */     this.tileY = (short)((int)this.y / 32);
/*  85 */     if (this.mapX > this.mbX)
/*  86 */       this.mapX = this.mbX; 
/*  88 */     if (this.mapX < Game.playerSpawnX)
/*  89 */       this.mapX = Game.playerSpawnX; 
/*  91 */     if (this.mapY > this.mbY)
/*  92 */       this.mapY = this.mbY; 
/*  94 */     if (this.mapY < Game.playerSpawnY)
/*  95 */       this.mapY = Game.playerSpawnY; 
/*  97 */     if (this.x < 0.0F)
/*  98 */       this.x = 0.0F; 
/* 100 */     if (this.y < 0.0F)
/* 101 */       this.y = 0.0F; 
/* 105 */     this.time++;
/* 106 */     if (this.time >= this.regenTime && this.health < this.maxHealth) {
/* 107 */       this.health += 0.5D;
/* 108 */       this.time = 0;
/* 109 */       healthBarCheck();
/*     */     } 
/* 113 */     if (this.hpc >= 2 || this.health > 0.0D)
/* 114 */       this.hpc = (int)(this.health * 81.0D / this.maxHealth); 
/* 116 */     if (this.health == this.maxHealth)
/* 117 */       this.hpc = 81; 
/* 120 */     if (this.xpc >= 2 || this.exp > 0)
/* 121 */       this.xpc = 83 * (this.exp - this.expLevels[this.level]) / (
/* 122 */         this.expLevels[this.level + 1] - this.expLevels[this.level]); 
/* 124 */     if (this.exp >= this.expLevels[this.level + 1] && this.level < this.maxLevel)
/* 125 */       this.level = (short)(this.level + 1); 
/* 129 */     if (this.mapMovement)
/* 130 */       mapMovement(); 
/* 132 */     if (this.insideMovement)
/* 133 */       insideMovement(); 
/*     */   }
/*     */   
/*     */   public int getCurrentTile() {
/* 138 */     return GrassMap.getTileID(this.tileX, this.tileY);
/*     */   }
/*     */   
/*     */   public boolean isNextTileValid(int dir) {
/* 143 */     if (dir == 1) {
/* 145 */       Game.getMap();
/* 145 */       if (GrassMap.getTileID((int)this.x / 32, (int)(this.y - 1.0F) / 32) != 99)
/* 146 */         return true; 
/* 148 */     } else if (dir == 2) {
/* 150 */       Game.getMap();
/* 150 */       if (GrassMap.getTileID((int)(this.x + 1.0F + 32.0F) / 32, (int)this.y / 32) != 99)
/* 151 */         return true; 
/* 153 */     } else if (dir == 3) {
/* 155 */       Game.getMap();
/* 155 */       if (GrassMap.getTileID((int)this.x / 32, (int)(this.y + 1.0F + 32.0F) / 32) != 99)
/* 156 */         return true; 
/* 158 */     } else if (dir == 4) {
/* 160 */       Game.getMap();
/* 160 */       if (GrassMap.getTileID((int)(this.x - 1.0F) / 32, (int)this.y / 32) != 99)
/* 161 */         return true; 
/*     */     } 
/* 164 */     return false;
/*     */   }
/*     */   
/*     */   public void attack() {
/* 168 */     if (Math.sqrt(((this.x - TestDummy.rx) * (this.x - TestDummy.rx) + (
/* 169 */         this.y - TestDummy.ry) * (this.y - TestDummy.ry))) <= this.attackRadius)
/* 170 */       TestDummy.takeDamage(this.damage); 
/*     */   }
/*     */   
/*     */   public void takeDamage(double d) {
/* 175 */     if (this.health >= d && !TestDummy.isDead) {
/* 176 */       this.health -= d;
/* 177 */       a.flashRequest = true;
/* 178 */     } else if (this.health == 0.0D) {
/* 179 */       kill();
/*     */     } 
/* 181 */     healthBarCheck();
/*     */   }
/*     */   
/*     */   public void kill() {
/* 185 */     Game.isInGame = false;
/* 186 */     (Game.getMainMenu()).menuState = 6;
/*     */   }
/*     */   
/*     */   public void respawn() {
/* 190 */     this.health = this.maxHealth;
/* 191 */     this.x = Game.playerSpawnX;
/* 192 */     this.y = Game.playerSpawnY;
/* 193 */     this.mapX = Game.playerSpawnX;
/* 194 */     this.mapY = Game.playerSpawnY;
/* 195 */     this.lastDir = 3;
/* 196 */     (Game.getMainMenu()).menuState = 0;
/* 197 */     Game.isInGame = true;
/* 198 */     healthBarCheck();
/*     */   }
/*     */   
/*     */   public void healthBarCheck() {
/* 202 */     if (this.health >= 0.0D && this.health <= this.maxHealth / 3.0D) {
/* 203 */       hColor = new Color(127, 0, 0);
/* 204 */     } else if (this.health > this.maxHealth / 3.0D && this.health <= this.maxHealth / 3.0D * 2.0D) {
/* 205 */       hColor = new Color(255, 216, 0);
/* 206 */     } else if (this.health <= this.maxHealth) {
/* 207 */       hColor = new Color(0, 255, 33);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void drawPlayerHUD(Graphics g) {
/* 212 */     g.drawImage(ImageManager.pHUD, 5, 5, null);
/* 213 */     g.setFont(Game.playerHUDFont);
/* 214 */     g.setColor(Color.black);
/* 215 */     fm = g.getFontMetrics(Game.playerHUDFont);
/* 216 */     g.drawString(String.valueOf(this.name) + " | Lvl " + this.level, 
/* 217 */         108 - fm.stringWidth(String.valueOf(this.name) + " | Lvl " + this.level) / 2, 21);
/* 218 */     drawHealthBar(g);
/* 219 */     drawExpBar(g);
/* 220 */     g.drawImage(ImageManager.playerd1, 21, 21, null);
/*     */   }
/*     */   
/*     */   private void drawHealthBar(Graphics g) {
/* 224 */     fm = g.getFontMetrics(Game.pHUDBar);
/* 225 */     g.setColor(hColor);
/* 226 */     g.fillRect(69, 34, this.hpc, 8);
/* 227 */     g.setFont(Game.pHUDBar);
/* 228 */     g.setColor(Color.black);
/* 229 */     g.drawString(String.valueOf(this.health), 
/* 230 */         108 - fm.stringWidth(String.valueOf(this.health)) / 2, 42);
/*     */   }
/*     */   
/*     */   private void drawExpBar(Graphics g) {
/* 234 */     fm = g.getFontMetrics(Game.pHUDBar);
/* 235 */     g.setColor(Color.blue);
/* 236 */     g.fillRect(67, 50, this.xpc, 8);
/* 237 */     g.setFont(Game.pHUDBar);
/* 238 */     g.setColor(Color.white);
/* 239 */     g.drawString(String.valueOf(this.exp), 
/* 240 */         108 - fm.stringWidth(String.valueOf(this.exp)) / 2, 58);
/*     */   }
/*     */   
/*     */   public void mapMovement() {
/* 245 */     if (this.up && this.y >= this.pbY && this.canMoveUp) {
/* 246 */       if (this.mapY <= Game.playerSpawnY && this.y > 30.0D + this.SPEED && isNextTileValid(1)) {
/* 247 */         this.y = (float)(this.y - this.SPEED);
/* 248 */       } else if (this.catchingUp != 1 && 
/* 249 */         this.y <= Game.playerSpawnY && this.y > 30.0D + this.SPEED && isNextTileValid(1)) {
/* 250 */         this.mapY = (float)(this.mapY - this.SPEED);
/*     */       } 
/* 252 */       upCount = (byte)(int)(upCount + this.SPEED);
/* 253 */       this.movingUp = true;
/* 254 */       this.lastDir = 1;
/* 255 */       if (upCount >= 42)
/* 256 */         upCount = 1; 
/*     */     } else {
/* 259 */       upCount = 0;
/* 260 */       this.movingUp = false;
/* 261 */       if (this.movingDown && this.y <= Game.playerSpawnY && isNextTileValid(3)) {
/* 262 */         this.y = (float)(this.y + this.SPEED);
/* 263 */         this.catchingUp = 1;
/*     */       } else {
/* 265 */         this.catchingUp = 0;
/*     */       } 
/*     */     } 
/* 269 */     if (this.down && this.y <= 511.0F && this.canMoveDown) {
/* 270 */       if (this.mapY >= this.mbY && this.y < 481.0F && isNextTileValid(3)) {
/* 271 */         this.y = (float)(this.y + this.SPEED);
/* 272 */       } else if (this.catchingUp != 3 && this.y >= Game.playerSpawnY && isNextTileValid(3) && 
/* 273 */         this.y < 481.0F) {
/* 274 */         this.mapY = (float)(this.mapY + this.SPEED);
/*     */       } 
/* 276 */       downCount = (byte)(int)(downCount + this.SPEED);
/* 277 */       this.movingDown = true;
/* 278 */       this.lastDir = 3;
/* 279 */       if (downCount >= 42)
/* 280 */         downCount = 1; 
/*     */     } else {
/* 283 */       downCount = 0;
/* 284 */       this.movingDown = false;
/* 285 */       if (this.movingUp && this.y >= Game.playerSpawnY && isNextTileValid(1)) {
/* 286 */         this.y = (float)(this.y - this.SPEED);
/* 287 */         this.catchingUp = 3;
/*     */       } else {
/* 289 */         this.catchingUp = 0;
/*     */       } 
/*     */     } 
/* 293 */     if (this.left && this.x >= 0.0F && this.canMoveLeft) {
/* 294 */       if (this.mapX <= Game.playerSpawnX && this.x > 30.0D + this.SPEED && isNextTileValid(4)) {
/* 295 */         this.x = (float)(this.x - this.SPEED);
/* 296 */       } else if (this.catchingUp != 4 && this.x <= Game.playerSpawnX && isNextTileValid(4) && 
/* 297 */         this.x > 30.0D + this.SPEED) {
/* 298 */         this.mapX = (float)(this.mapX - this.SPEED);
/*     */       } 
/* 300 */       leftCount = (byte)(int)(leftCount + this.SPEED);
/* 301 */       this.movingLeft = true;
/* 302 */       this.lastDir = 4;
/* 303 */       if (leftCount >= 42)
/* 304 */         leftCount = 1; 
/*     */     } else {
/* 307 */       leftCount = 0;
/* 308 */       this.movingLeft = false;
/* 309 */       if (this.movingRight && this.x <= Game.playerSpawnX && isNextTileValid(2)) {
/* 310 */         this.x = (float)(this.x + this.SPEED);
/* 311 */         this.catchingUp = 4;
/*     */       } else {
/* 313 */         this.catchingUp = 0;
/*     */       } 
/*     */     } 
/* 317 */     if (this.right && this.x <= this.pbX && this.canMoveRight) {
/* 318 */       if (this.mapX >= this.mbX && this.x < 771.0F && isNextTileValid(2)) {
/* 319 */         this.x = (float)(this.x + this.SPEED);
/* 320 */       } else if (this.catchingUp != 2 && this.x >= Game.playerSpawnX && isNextTileValid(2) && 
/* 321 */         this.x < 771.0F) {
/* 322 */         this.mapX = (float)(this.mapX + this.SPEED);
/*     */       } 
/* 324 */       rightCount = (byte)(int)(rightCount + this.SPEED);
/* 325 */       this.movingRight = true;
/* 326 */       this.lastDir = 2;
/* 327 */       if (rightCount >= 42)
/* 328 */         rightCount = 1; 
/*     */     } else {
/* 331 */       rightCount = 0;
/* 332 */       this.movingRight = false;
/* 333 */       if (this.movingLeft && this.x >= Game.playerSpawnX && isNextTileValid(4)) {
/* 334 */         this.x = (float)(this.x - this.SPEED);
/* 335 */         this.catchingUp = 2;
/*     */       } else {
/* 337 */         this.catchingUp = 0;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void insideMovement() {
/* 343 */     if (this.up && this.y >= 125.0F && this.canMoveUp) {
/* 344 */       this.y = (float)(this.y - this.SPEED);
/* 345 */       upCount = (byte)(upCount + 1);
/* 346 */       this.movingUp = true;
/* 347 */       this.lastDir = 1;
/* 348 */       if (upCount == 42)
/* 349 */         upCount = 1; 
/*     */     } else {
/* 352 */       upCount = 0;
/* 353 */       this.movingUp = false;
/*     */     } 
/* 355 */     if (this.down && this.y <= 423.0F && this.canMoveDown) {
/* 356 */       this.y = (float)(this.y + this.SPEED);
/* 357 */       downCount = (byte)(downCount + 1);
/* 358 */       this.movingDown = true;
/* 359 */       this.lastDir = 3;
/* 360 */       if (downCount == 42)
/* 361 */         downCount = 1; 
/*     */     } else {
/* 364 */       downCount = 0;
/* 365 */       this.movingDown = false;
/*     */     } 
/* 367 */     if (this.left && this.x >= 194.0F && this.canMoveLeft) {
/* 368 */       this.x = (float)(this.x - this.SPEED);
/* 369 */       leftCount = (byte)(leftCount + 1);
/* 370 */       this.movingLeft = true;
/* 371 */       this.lastDir = 4;
/* 372 */       if (leftCount == 42)
/* 373 */         leftCount = 1; 
/*     */     } else {
/* 376 */       leftCount = 0;
/* 377 */       this.movingLeft = false;
/*     */     } 
/* 379 */     if (this.right && this.x <= 612.0F && this.canMoveRight) {
/* 380 */       this.x = (float)(this.x + this.SPEED);
/* 381 */       rightCount = (byte)(rightCount + 1);
/* 382 */       this.movingRight = true;
/* 383 */       this.lastDir = 2;
/* 384 */       if (rightCount == 42)
/* 385 */         rightCount = 1; 
/*     */     } else {
/* 388 */       rightCount = 0;
/* 389 */       this.movingRight = false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render(Graphics g) {
/* 395 */     a.animateEntity(g, (int)this.x, (int)this.y, ImageManager.playeru1, 
/* 396 */         ImageManager.playeru2, ImageManager.playeru3, 
/* 397 */         ImageManager.playeru4, upCount);
/* 398 */     a.animateEntity(g, (int)this.x, (int)this.y, ImageManager.playerd1, 
/* 399 */         ImageManager.playerd2, ImageManager.playerd3, 
/* 400 */         ImageManager.playerd4, downCount);
/* 401 */     a.animateEntity(g, (int)this.x, (int)this.y, ImageManager.playerl1, 
/* 402 */         ImageManager.playerl2, ImageManager.playerl3, 
/* 403 */         ImageManager.playerl4, leftCount);
/* 404 */     a.animateEntity(g, (int)this.x, (int)this.y, ImageManager.playerr1, 
/* 405 */         ImageManager.playerr2, ImageManager.playerr3, 
/* 406 */         ImageManager.playerr4, rightCount);
/* 408 */     if (!this.movingUp && !this.movingDown && !this.movingLeft && !this.movingRight && 
/* 409 */       this.lastDir == 0)
/* 411 */       g.drawImage(ImageManager.playerd1, (int)this.x, (int)this.y, 32, 32, null); 
/* 414 */     if (!this.movingRight && this.lastDir == 2) {
/* 415 */       g.drawImage(ImageManager.playerr1, (int)this.x, (int)this.y, 32, 32, null);
/* 416 */       if (a.flashRequest)
/* 417 */         a.imageFlash(g, ImageManager.playerr1, this.x, this.y, new Color(255, 0, 
/* 418 */               0, 128)); 
/*     */     } 
/* 421 */     if (!this.movingLeft && this.lastDir == 4) {
/* 422 */       g.drawImage(ImageManager.playerl1, (int)this.x, (int)this.y, 32, 32, null);
/* 423 */       if (a.flashRequest)
/* 424 */         a.imageFlash(g, ImageManager.playerl1, this.x, this.y, new Color(255, 0, 
/* 425 */               0, 128)); 
/*     */     } 
/* 428 */     if (!this.movingUp && this.lastDir == 1) {
/* 429 */       g.drawImage(ImageManager.playeru1, (int)this.x, (int)this.y, 32, 32, null);
/* 430 */       if (a.flashRequest)
/* 431 */         a.imageFlash(g, ImageManager.playeru1, this.x, this.y, new Color(255, 0, 
/* 432 */               0, 128)); 
/*     */     } 
/* 435 */     if (!this.movingDown && this.lastDir == 3) {
/* 436 */       g.drawImage(ImageManager.playerd1, (int)this.x, (int)this.y, 32, 32, null);
/* 437 */       if (a.flashRequest)
/* 438 */         a.imageFlash(g, ImageManager.playerd1, this.x, this.y, new Color(255, 0, 
/* 439 */               0, 128)); 
/*     */     } 
/* 443 */     if (a.flashRequest && (
/* 444 */       this.movingUp || this.movingDown || this.movingLeft || this.movingRight))
/* 445 */       a.imageFlash(g, a.getCurrentFrame(), this.x, this.y, 
/* 446 */           new Color(255, 0, 0, 128)); 
/* 449 */     drawPlayerHUD(g);
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.6_4.jar!\beyondOrigins\main\entities\Player.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */