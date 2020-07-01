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
/*  94 */     if (this.x < 0.0F)
/*  95 */       this.x = 0.0F; 
/*  97 */     if (this.y < 0.0F)
/*  98 */       this.y = 0.0F; 
/* 102 */     this.time++;
/* 103 */     if (this.time >= this.regenTime && this.health < this.maxHealth) {
/* 104 */       this.health += 0.5D;
/* 105 */       this.time = 0;
/* 106 */       healthBarCheck();
/*     */     } 
/* 110 */     if (this.hpc >= 2 || this.health > 0.0D)
/* 111 */       this.hpc = (int)(this.health * 81.0D / this.maxHealth); 
/* 113 */     if (this.health == this.maxHealth)
/* 114 */       this.hpc = 81; 
/* 117 */     if (this.xpc >= 2 || this.exp > 0)
/* 118 */       this.xpc = 83 * (this.exp - this.expLevels[this.level]) / (
/* 119 */         this.expLevels[this.level + 1] - this.expLevels[this.level]); 
/* 121 */     if (this.exp >= this.expLevels[this.level + 1] && this.level < this.maxLevel)
/* 122 */       this.level = (short)(this.level + 1); 
/* 126 */     if (this.mapMovement)
/* 127 */       mapMovement(); 
/* 129 */     if (this.insideMovement)
/* 130 */       insideMovement(); 
/*     */   }
/*     */   
/*     */   public int getCurrentTile() {
/* 135 */     return GrassMap.getTileID(this.tileX, this.tileY);
/*     */   }
/*     */   
/*     */   public boolean isNextTileValid(int dir) {
/* 140 */     if (dir == 1) {
/* 142 */       Game.getMap();
/* 142 */       System.out.println(GrassMap.getTileID((int)this.x / 32, (int)(this.y - 1.0F) / 32));
/* 143 */       Game.getMap();
/* 143 */       if (GrassMap.getTileID((int)this.x / 32, (int)(this.y - 1.0F) / 32) != 99)
/* 144 */         return true; 
/* 146 */     } else if (dir == 2) {
/* 148 */       Game.getMap();
/* 148 */       System.out.println(GrassMap.getTileID((int)(this.x + 1.0F + 32.0F) / 32, (int)this.y / 32));
/* 149 */       Game.getMap();
/* 149 */       if (GrassMap.getTileID((int)(this.x + 1.0F + 32.0F) / 32, (int)this.y / 32) != 99)
/* 150 */         return true; 
/* 152 */     } else if (dir == 3) {
/* 154 */       Game.getMap();
/* 154 */       System.out.println(GrassMap.getTileID((int)this.x / 32, (int)(this.y + 1.0F + 32.0F) / 32));
/* 155 */       Game.getMap();
/* 155 */       if (GrassMap.getTileID((int)this.x / 32, (int)(this.y + 1.0F + 32.0F) / 32) != 99)
/* 156 */         return true; 
/* 158 */     } else if (dir == 4) {
/* 160 */       Game.getMap();
/* 160 */       System.out.println(GrassMap.getTileID((int)(this.x - 1.0F) / 32, (int)this.y / 32));
/* 161 */       Game.getMap();
/* 161 */       if (GrassMap.getTileID((int)(this.x - 1.0F) / 32, (int)this.y / 32) != 99)
/* 162 */         return true; 
/*     */     } 
/* 165 */     return false;
/*     */   }
/*     */   
/*     */   public void attack() {
/* 169 */     if (Math.sqrt(((this.x - TestDummy.rx) * (this.x - TestDummy.rx) + (
/* 170 */         this.y - TestDummy.ry) * (this.y - TestDummy.ry))) <= this.attackRadius)
/* 171 */       TestDummy.takeDamage(this.damage); 
/*     */   }
/*     */   
/*     */   public void takeDamage(double d) {
/* 176 */     if (this.health >= d && !TestDummy.isDead) {
/* 177 */       this.health -= d;
/* 178 */       a.flashRequest = true;
/* 179 */     } else if (this.health == 0.0D) {
/* 180 */       kill();
/*     */     } 
/* 182 */     healthBarCheck();
/*     */   }
/*     */   
/*     */   public void kill() {
/* 186 */     Game.isInGame = false;
/* 187 */     (Game.getMainMenu()).menuState = 6;
/*     */   }
/*     */   
/*     */   public void respawn() {
/* 191 */     this.health = this.maxHealth;
/* 192 */     this.x = Game.playerSpawnX;
/* 193 */     this.y = Game.playerSpawnY;
/* 194 */     this.mapX = Game.playerSpawnX;
/* 195 */     this.mapY = Game.playerSpawnY;
/* 196 */     this.lastDir = 3;
/* 197 */     (Game.getMainMenu()).menuState = 0;
/* 198 */     Game.isInGame = true;
/* 199 */     healthBarCheck();
/*     */   }
/*     */   
/*     */   public void healthBarCheck() {
/* 203 */     if (this.health >= 0.0D && this.health <= this.maxHealth / 3.0D) {
/* 204 */       hColor = new Color(127, 0, 0);
/* 205 */     } else if (this.health > this.maxHealth / 3.0D && this.health <= this.maxHealth / 3.0D * 2.0D) {
/* 206 */       hColor = new Color(255, 216, 0);
/* 207 */     } else if (this.health <= this.maxHealth) {
/* 208 */       hColor = new Color(0, 255, 33);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void drawPlayerHUD(Graphics g) {
/* 213 */     g.drawImage(ImageManager.pHUD, 5, 5, null);
/* 214 */     g.setFont(Game.playerHUDFont);
/* 215 */     g.setColor(Color.black);
/* 216 */     fm = g.getFontMetrics(Game.playerHUDFont);
/* 217 */     g.drawString(String.valueOf(this.name) + " | Lvl " + this.level, 
/* 218 */         108 - fm.stringWidth(String.valueOf(this.name) + " | Lvl " + this.level) / 2, 21);
/* 219 */     drawHealthBar(g);
/* 220 */     drawExpBar(g);
/* 221 */     g.drawImage(ImageManager.playerd1, 21, 21, null);
/*     */   }
/*     */   
/*     */   private void drawHealthBar(Graphics g) {
/* 225 */     fm = g.getFontMetrics(Game.pHUDBar);
/* 226 */     g.setColor(hColor);
/* 227 */     g.fillRect(69, 34, this.hpc, 8);
/* 228 */     g.setFont(Game.pHUDBar);
/* 229 */     g.setColor(Color.black);
/* 230 */     g.drawString(String.valueOf(this.health), 
/* 231 */         108 - fm.stringWidth(String.valueOf(this.health)) / 2, 42);
/*     */   }
/*     */   
/*     */   private void drawExpBar(Graphics g) {
/* 235 */     fm = g.getFontMetrics(Game.pHUDBar);
/* 236 */     g.setColor(Color.blue);
/* 237 */     g.fillRect(67, 50, this.xpc, 8);
/* 238 */     g.setFont(Game.pHUDBar);
/* 239 */     g.setColor(Color.white);
/* 240 */     g.drawString(String.valueOf(this.exp), 
/* 241 */         108 - fm.stringWidth(String.valueOf(this.exp)) / 2, 58);
/*     */   }
/*     */   
/*     */   public void mapMovement() {
/* 246 */     if (this.up && this.y >= this.pbY && this.canMoveUp) {
/* 247 */       if (this.mapY <= Game.playerSpawnY && this.y > 30.0D + this.SPEED && isNextTileValid(1)) {
/* 248 */         this.y = (float)(this.y - this.SPEED);
/* 249 */       } else if (this.catchingUp != 1 && 
/* 250 */         this.y <= Game.playerSpawnY && this.y > 30.0D + this.SPEED && isNextTileValid(1)) {
/* 251 */         this.mapY = (float)(this.mapY - this.SPEED);
/*     */       } 
/* 253 */       upCount = (byte)(int)(upCount + this.SPEED);
/* 254 */       this.movingUp = true;
/* 255 */       this.lastDir = 1;
/* 256 */       if (upCount >= 42)
/* 257 */         upCount = 1; 
/*     */     } else {
/* 260 */       upCount = 0;
/* 261 */       this.movingUp = false;
/* 262 */       if (this.movingDown && this.y <= Game.playerSpawnY && isNextTileValid(3)) {
/* 263 */         this.y = (float)(this.y + this.SPEED);
/* 264 */         this.catchingUp = 1;
/*     */       } else {
/* 266 */         this.catchingUp = 0;
/*     */       } 
/*     */     } 
/* 270 */     if (this.down && this.y <= 511.0F && this.canMoveDown) {
/* 271 */       if (this.mapY >= this.mbY && this.y < 481.0F && isNextTileValid(3)) {
/* 272 */         this.y = (float)(this.y + this.SPEED);
/* 273 */       } else if (this.catchingUp != 3 && this.y >= Game.playerSpawnY && isNextTileValid(3) && 
/* 274 */         this.y < 481.0F) {
/* 275 */         this.mapY = (float)(this.mapY + this.SPEED);
/*     */       } 
/* 277 */       downCount = (byte)(int)(downCount + this.SPEED);
/* 278 */       this.movingDown = true;
/* 279 */       this.lastDir = 3;
/* 280 */       if (downCount >= 42)
/* 281 */         downCount = 1; 
/*     */     } else {
/* 284 */       downCount = 0;
/* 285 */       this.movingDown = false;
/* 286 */       if (this.movingUp && this.y >= Game.playerSpawnY && isNextTileValid(1)) {
/* 287 */         this.y = (float)(this.y - this.SPEED);
/* 288 */         this.catchingUp = 3;
/*     */       } else {
/* 290 */         this.catchingUp = 0;
/*     */       } 
/*     */     } 
/* 294 */     if (this.left && this.x >= 0.0F && this.canMoveLeft) {
/* 295 */       if (this.mapX <= Game.playerSpawnX && this.x > 30.0D + this.SPEED && isNextTileValid(4)) {
/* 296 */         this.x = (float)(this.x - this.SPEED);
/* 297 */       } else if (this.catchingUp != 4 && this.x <= Game.playerSpawnX && isNextTileValid(4) && 
/* 298 */         this.x > 30.0D + this.SPEED) {
/* 299 */         this.mapX = (float)(this.mapX - this.SPEED);
/*     */       } 
/* 301 */       leftCount = (byte)(int)(leftCount + this.SPEED);
/* 302 */       this.movingLeft = true;
/* 303 */       this.lastDir = 4;
/* 304 */       if (leftCount >= 42)
/* 305 */         leftCount = 1; 
/*     */     } else {
/* 308 */       leftCount = 0;
/* 309 */       this.movingLeft = false;
/* 310 */       if (this.movingRight && this.x <= Game.playerSpawnX && isNextTileValid(2)) {
/* 311 */         this.x = (float)(this.x + this.SPEED);
/* 312 */         this.catchingUp = 4;
/*     */       } else {
/* 314 */         this.catchingUp = 0;
/*     */       } 
/*     */     } 
/* 318 */     if (this.right && this.x <= this.pbX && this.canMoveRight) {
/* 319 */       if (this.mapX >= this.mbX && this.x < 771.0F && isNextTileValid(2)) {
/* 320 */         this.x = (float)(this.x + this.SPEED);
/* 321 */       } else if (this.catchingUp != 2 && this.x >= Game.playerSpawnX && isNextTileValid(2) && 
/* 322 */         this.x < 771.0F) {
/* 323 */         this.mapX = (float)(this.mapX + this.SPEED);
/*     */       } 
/* 325 */       rightCount = (byte)(int)(rightCount + this.SPEED);
/* 326 */       this.movingRight = true;
/* 327 */       this.lastDir = 2;
/* 328 */       if (rightCount >= 42)
/* 329 */         rightCount = 1; 
/*     */     } else {
/* 332 */       rightCount = 0;
/* 333 */       this.movingRight = false;
/* 334 */       if (this.movingLeft && this.x >= Game.playerSpawnX && isNextTileValid(4)) {
/* 335 */         this.x = (float)(this.x - this.SPEED);
/* 336 */         this.catchingUp = 2;
/*     */       } else {
/* 338 */         this.catchingUp = 0;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void insideMovement() {
/* 344 */     if (this.up && this.y >= 125.0F && this.canMoveUp) {
/* 345 */       this.y = (float)(this.y - this.SPEED);
/* 346 */       upCount = (byte)(upCount + 1);
/* 347 */       this.movingUp = true;
/* 348 */       this.lastDir = 1;
/* 349 */       if (upCount == 42)
/* 350 */         upCount = 1; 
/*     */     } else {
/* 353 */       upCount = 0;
/* 354 */       this.movingUp = false;
/*     */     } 
/* 356 */     if (this.down && this.y <= 423.0F && this.canMoveDown) {
/* 357 */       this.y = (float)(this.y + this.SPEED);
/* 358 */       downCount = (byte)(downCount + 1);
/* 359 */       this.movingDown = true;
/* 360 */       this.lastDir = 3;
/* 361 */       if (downCount == 42)
/* 362 */         downCount = 1; 
/*     */     } else {
/* 365 */       downCount = 0;
/* 366 */       this.movingDown = false;
/*     */     } 
/* 368 */     if (this.left && this.x >= 194.0F && this.canMoveLeft) {
/* 369 */       this.x = (float)(this.x - this.SPEED);
/* 370 */       leftCount = (byte)(leftCount + 1);
/* 371 */       this.movingLeft = true;
/* 372 */       this.lastDir = 4;
/* 373 */       if (leftCount == 42)
/* 374 */         leftCount = 1; 
/*     */     } else {
/* 377 */       leftCount = 0;
/* 378 */       this.movingLeft = false;
/*     */     } 
/* 380 */     if (this.right && this.x <= 612.0F && this.canMoveRight) {
/* 381 */       this.x = (float)(this.x + this.SPEED);
/* 382 */       rightCount = (byte)(rightCount + 1);
/* 383 */       this.movingRight = true;
/* 384 */       this.lastDir = 2;
/* 385 */       if (rightCount == 42)
/* 386 */         rightCount = 1; 
/*     */     } else {
/* 389 */       rightCount = 0;
/* 390 */       this.movingRight = false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render(Graphics g) {
/* 396 */     a.animateEntity(g, (int)this.x, (int)this.y, ImageManager.playeru1, 
/* 397 */         ImageManager.playeru2, ImageManager.playeru3, 
/* 398 */         ImageManager.playeru4, upCount);
/* 399 */     a.animateEntity(g, (int)this.x, (int)this.y, ImageManager.playerd1, 
/* 400 */         ImageManager.playerd2, ImageManager.playerd3, 
/* 401 */         ImageManager.playerd4, downCount);
/* 402 */     a.animateEntity(g, (int)this.x, (int)this.y, ImageManager.playerl1, 
/* 403 */         ImageManager.playerl2, ImageManager.playerl3, 
/* 404 */         ImageManager.playerl4, leftCount);
/* 405 */     a.animateEntity(g, (int)this.x, (int)this.y, ImageManager.playerr1, 
/* 406 */         ImageManager.playerr2, ImageManager.playerr3, 
/* 407 */         ImageManager.playerr4, rightCount);
/* 409 */     if (!this.movingUp && !this.movingDown && !this.movingLeft && !this.movingRight && 
/* 410 */       this.lastDir == 0)
/* 412 */       g.drawImage(ImageManager.playerd1, (int)this.x, (int)this.y, 32, 32, null); 
/* 415 */     if (!this.movingRight && this.lastDir == 2) {
/* 416 */       g.drawImage(ImageManager.playerr1, (int)this.x, (int)this.y, 32, 32, null);
/* 417 */       if (a.flashRequest)
/* 418 */         a.imageFlash(g, ImageManager.playerr1, this.x, this.y, new Color(255, 0, 
/* 419 */               0, 128)); 
/*     */     } 
/* 422 */     if (!this.movingLeft && this.lastDir == 4) {
/* 423 */       g.drawImage(ImageManager.playerl1, (int)this.x, (int)this.y, 32, 32, null);
/* 424 */       if (a.flashRequest)
/* 425 */         a.imageFlash(g, ImageManager.playerl1, this.x, this.y, new Color(255, 0, 
/* 426 */               0, 128)); 
/*     */     } 
/* 429 */     if (!this.movingUp && this.lastDir == 1) {
/* 430 */       g.drawImage(ImageManager.playeru1, (int)this.x, (int)this.y, 32, 32, null);
/* 431 */       if (a.flashRequest)
/* 432 */         a.imageFlash(g, ImageManager.playeru1, this.x, this.y, new Color(255, 0, 
/* 433 */               0, 128)); 
/*     */     } 
/* 436 */     if (!this.movingDown && this.lastDir == 3) {
/* 437 */       g.drawImage(ImageManager.playerd1, (int)this.x, (int)this.y, 32, 32, null);
/* 438 */       if (a.flashRequest)
/* 439 */         a.imageFlash(g, ImageManager.playerd1, this.x, this.y, new Color(255, 0, 
/* 440 */               0, 128)); 
/*     */     } 
/* 444 */     if (a.flashRequest && (
/* 445 */       this.movingUp || this.movingDown || this.movingLeft || this.movingRight))
/* 446 */       a.imageFlash(g, a.getCurrentFrame(), this.x, this.y, 
/* 447 */           new Color(255, 0, 0, 128)); 
/* 450 */     drawPlayerHUD(g);
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.6_3.jar!\beyondOrigins\main\entities\Player.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */