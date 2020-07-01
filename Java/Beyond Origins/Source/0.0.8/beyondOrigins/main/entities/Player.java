/*     */ package beyondOrigins.main.entities;
/*     */ 
/*     */ import beyondOrigins.main.Game;
/*     */ import beyondOrigins.main.gfx.Animate;
/*     */ import beyondOrigins.main.gfx.ImageManager;
/*     */ import beyondOrigins.main.maps.GrassMap;
/*     */ import beyondOrigins.main.menus.F3Menu;
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
/*     */   public int x;
/*     */   
/*     */   public int y;
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
/*     */   public boolean insideMovement = false;
/*     */   
/*     */   public int mapX;
/*     */   
/*     */   public int mapY;
/*     */   
/*  48 */   public short mbX = 1232;
/*     */   
/*  48 */   public short mbY = 800;
/*     */   
/*  48 */   public short pbX = 801;
/*     */   
/*  48 */   public short pbY = 1;
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
/*  81 */     this.tileX = (this.x + this.mapX) / 32 - 12;
/*  82 */     this.tileY = (this.y + this.mapY) / 32 - 8;
/*  85 */     this.time++;
/*  86 */     if (this.time >= this.regenTime && this.health < this.maxHealth) {
/*  87 */       this.health += 0.5D;
/*  88 */       this.time = 0;
/*  89 */       healthBarCheck();
/*     */     } 
/*  93 */     if (this.hpc >= 2 || this.health > 0.0D)
/*  94 */       this.hpc = (int)(this.health * 81.0D / this.maxHealth); 
/*  96 */     if (this.health == this.maxHealth)
/*  97 */       this.hpc = 81; 
/* 100 */     if (this.xpc >= 2 || this.exp > 0)
/* 101 */       this.xpc = 83 * (this.exp - this.expLevels[this.level]) / (
/* 102 */         this.expLevels[this.level + 1] - this.expLevels[this.level]); 
/* 104 */     if (this.exp >= this.expLevels[this.level + 1] && this.level < this.maxLevel)
/* 105 */       this.level = (short)(this.level + 1); 
/* 108 */     mapMovement();
/*     */   }
/*     */   
/*     */   public int getCurrentTile() {
/* 113 */     Game.getMap();
/* 113 */     return GrassMap.getTileID(this.tileX, this.tileY);
/*     */   }
/*     */   
/*     */   public boolean isNextTileValid(int dir) {
/* 118 */     if (dir == 1) {
/* 119 */       Game.getMap();
/* 119 */       if (GrassMap.getTileID((this.x - 15 + this.mapX) / 32 - 12, (
/* 120 */           this.y - 1 + this.mapY) / 32 - 8) == 0) {
/* 121 */         Game.getMap();
/* 121 */         if (GrassMap.getTileID((this.x + 14 + this.mapX) / 32 - 12, (
/* 122 */             this.y - 1 + this.mapY) / 32 - 8) != 0)
/* 123 */           return false; 
/*     */       } else {
/* 123 */         return false;
/*     */       } 
/* 125 */     } else if (dir == 2) {
/* 126 */       Game.getMap();
/* 126 */       if (GrassMap.getTileID((this.x + 15 + this.mapX) / 32 - 12, (
/* 127 */           this.y + 31 + this.mapY) / 32 - 8) == 0) {
/* 128 */         Game.getMap();
/* 128 */         if (GrassMap.getTileID((this.x + 15 + this.mapX) / 32 - 12, (
/* 129 */             this.y + this.mapY) / 32 - 8) != 0)
/* 130 */           return false; 
/*     */       } else {
/* 130 */         return false;
/*     */       } 
/* 132 */     } else if (dir == 3) {
/* 133 */       Game.getMap();
/* 133 */       if (GrassMap.getTileID((this.x - 14 + this.mapX) / 32 - 12, (
/* 134 */           this.y + 32 + this.mapY) / 32 - 8) == 0) {
/* 135 */         Game.getMap();
/* 135 */         if (GrassMap.getTileID((this.x + 14 + this.mapX) / 32 - 12, (
/* 136 */             this.y + 32 + this.mapY) / 32 - 8) != 0)
/* 137 */           return false; 
/*     */       } else {
/* 137 */         return false;
/*     */       } 
/* 139 */     } else if (dir == 4) {
/* 140 */       Game.getMap();
/* 140 */       if (GrassMap.getTileID((this.x + this.mapX - 17) / 32 - 12, (
/* 141 */           this.y + 31 + this.mapY) / 32 - 8) == 0) {
/* 142 */         Game.getMap();
/* 142 */         if (GrassMap.getTileID((this.x + this.mapX - 17) / 32 - 12, (
/* 143 */             this.y + this.mapY) / 32 - 8) != 0)
/* 144 */           return false; 
/*     */       } else {
/* 144 */         return false;
/*     */       } 
/*     */     } 
/* 147 */     return true;
/*     */   }
/*     */   
/*     */   public void attack() {
/* 151 */     this.isAttacking = true;
/* 152 */     if (Math.sqrt(((this.x - TestDummy.rx) * (this.x - TestDummy.rx) + (
/* 153 */         this.y - TestDummy.ry) * (this.y - TestDummy.ry))) <= this.attackRadius)
/* 154 */       TestDummy.takeDamage(this.damage); 
/*     */   }
/*     */   
/*     */   public void takeDamage(double d) {
/* 159 */     if (this.health >= d && !TestDummy.isDead) {
/* 160 */       this.health -= d;
/* 161 */       a.flashRequest = true;
/* 162 */     } else if (this.health == 0.0D) {
/* 163 */       kill();
/*     */     } 
/* 165 */     healthBarCheck();
/*     */   }
/*     */   
/*     */   public void fixPos() {
/* 169 */     if (this.mapX < Game.playerSpawnX) {
/* 170 */       this.mapX = Game.playerSpawnX;
/* 171 */     } else if (this.mapX > this.mbX) {
/* 172 */       this.mapX = this.mbX;
/*     */     } 
/* 174 */     if (this.mapY < Game.playerSpawnY) {
/* 175 */       this.mapY = Game.playerSpawnY;
/* 176 */     } else if (this.mapY > this.mbY) {
/* 177 */       this.mapY = this.mbY;
/*     */     } 
/* 179 */     if (this.x < 32) {
/* 180 */       this.x = 32;
/* 181 */     } else if (this.x > Game.width - 32) {
/* 182 */       this.x = Game.width - 32;
/*     */     } 
/* 184 */     if (this.y < 32) {
/* 185 */       this.y = 32;
/* 186 */     } else if (this.y > Game.height - 32) {
/* 187 */       this.y = Game.height - 32;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void kill() {
/* 192 */     Game.isInGame = false;
/* 193 */     (Game.getMainMenu()).menuState = 6;
/*     */   }
/*     */   
/*     */   public void respawn() {
/* 197 */     this.health = this.maxHealth;
/* 198 */     this.x = Game.playerSpawnX;
/* 199 */     this.y = Game.playerSpawnY;
/* 200 */     this.mapX = 400;
/* 201 */     this.mapY = 256;
/* 202 */     this.lastDir = 3;
/* 203 */     (Game.getMainMenu()).menuState = 0;
/* 204 */     Game.isInGame = true;
/* 205 */     healthBarCheck();
/*     */   }
/*     */   
/*     */   public void healthBarCheck() {
/* 209 */     if (this.health >= 0.0D && this.health <= this.maxHealth / 3.0D) {
/* 210 */       hColor = new Color(127, 0, 0);
/* 211 */     } else if (this.health > this.maxHealth / 3.0D && this.health <= this.maxHealth / 3.0D * 2.0D) {
/* 212 */       hColor = new Color(255, 216, 0);
/* 213 */     } else if (this.health <= this.maxHealth) {
/* 214 */       hColor = new Color(0, 255, 33);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void drawPlayerHUD(Graphics g) {
/* 219 */     g.drawImage(ImageManager.player_hud, 5, 5, null);
/* 220 */     g.setFont(Game.playerHUDFont);
/* 221 */     g.setColor(Color.black);
/* 222 */     fm = g.getFontMetrics(Game.playerHUDFont);
/* 223 */     g.drawString(String.valueOf(this.name) + " | Lvl " + this.level, 
/* 224 */         108 - fm.stringWidth(String.valueOf(this.name) + " | Lvl " + this.level) / 2, 21);
/* 225 */     drawHealthBar(g);
/* 226 */     drawExpBar(g);
/* 227 */     g.drawImage(ImageManager.player_down[1], 21, 21, null);
/*     */   }
/*     */   
/*     */   private void drawHealthBar(Graphics g) {
/* 231 */     fm = g.getFontMetrics(Game.pHUDBar);
/* 232 */     g.setColor(hColor);
/* 233 */     g.fillRect(69, 34, this.hpc, 8);
/* 234 */     g.setFont(Game.pHUDBar);
/* 235 */     g.setColor(Color.black);
/* 236 */     g.drawString(String.valueOf(this.health), 
/* 237 */         108 - fm.stringWidth(String.valueOf(this.health)) / 2, 42);
/*     */   }
/*     */   
/*     */   private void drawExpBar(Graphics g) {
/* 241 */     fm = g.getFontMetrics(Game.pHUDBar);
/* 242 */     g.setColor(Color.blue);
/* 243 */     g.fillRect(67, 50, this.xpc, 8);
/* 244 */     g.setFont(Game.pHUDBar);
/* 245 */     g.setColor(Color.white);
/* 246 */     g.drawString(String.valueOf(this.exp), 
/* 247 */         108 - fm.stringWidth(String.valueOf(this.exp)) / 2, 58);
/*     */   }
/*     */   
/*     */   public void mapMovement() {
/* 252 */     if (this.up && this.canMoveUp) {
/* 253 */       if (this.mapY <= Game.playerSpawnY && isNextTileValid(1)) {
/* 254 */         this.y = (int)(this.y - this.SPEED);
/* 255 */       } else if (this.catchingUp != 1 && this.y <= Game.playerSpawnY && 
/* 256 */         isNextTileValid(1)) {
/* 257 */         this.mapY = (int)(this.mapY - this.SPEED);
/*     */       } 
/* 259 */       upCount = (byte)(int)(upCount + this.SPEED);
/* 260 */       this.movingUp = true;
/* 261 */       this.lastDir = 1;
/* 262 */       if (upCount >= 42)
/* 263 */         upCount = 2; 
/*     */     } else {
/* 266 */       upCount = 1;
/* 267 */       this.movingUp = false;
/* 268 */       if (this.movingDown && this.y <= Game.playerSpawnY && isNextTileValid(3)) {
/* 269 */         this.y = (int)(this.y + this.SPEED);
/* 270 */         this.catchingUp = 1;
/*     */       } else {
/* 272 */         this.catchingUp = 0;
/*     */       } 
/*     */     } 
/* 276 */     if (this.down && this.y <= 511.0F && this.canMoveDown) {
/* 277 */       if (this.mapY >= this.mbY && this.y < 481 && isNextTileValid(3)) {
/* 278 */         this.y = (int)(this.y + this.SPEED);
/* 279 */       } else if (this.catchingUp != 3 && 
/* 280 */         this.y >= Game.playerSpawnY && isNextTileValid(3) && 
/* 281 */         this.y < 481) {
/* 282 */         this.mapY = (int)(this.mapY + this.SPEED);
/*     */       } 
/* 284 */       downCount = (byte)(int)(downCount + this.SPEED);
/* 285 */       this.movingDown = true;
/* 286 */       this.lastDir = 3;
/* 287 */       if (downCount >= 42)
/* 288 */         downCount = 2; 
/*     */     } else {
/* 291 */       downCount = 1;
/* 292 */       this.movingDown = false;
/* 293 */       if (this.movingUp && this.y >= Game.playerSpawnY && isNextTileValid(1)) {
/* 294 */         this.y = (int)(this.y - this.SPEED);
/* 295 */         this.catchingUp = 3;
/*     */       } else {
/* 297 */         this.catchingUp = 0;
/*     */       } 
/*     */     } 
/* 301 */     if (this.left && this.x >= 0.0F && this.canMoveLeft) {
/* 302 */       if (this.mapX <= Game.playerSpawnX && this.x > 30.0D + this.SPEED && 
/* 303 */         isNextTileValid(4)) {
/* 304 */         this.x = (int)(this.x - this.SPEED);
/* 305 */       } else if (this.catchingUp != 4 && 
/* 306 */         this.x <= Game.playerSpawnX && isNextTileValid(4) && 
/* 307 */         this.x > 30.0D + this.SPEED) {
/* 308 */         this.mapX = (int)(this.mapX - this.SPEED);
/*     */       } 
/* 310 */       leftCount = (byte)(int)(leftCount + this.SPEED);
/* 311 */       this.movingLeft = true;
/* 312 */       this.lastDir = 4;
/* 313 */       if (leftCount >= 42)
/* 314 */         leftCount = 2; 
/*     */     } else {
/* 317 */       leftCount = 1;
/* 318 */       this.movingLeft = false;
/* 319 */       if (this.movingRight && this.x <= Game.playerSpawnX && isNextTileValid(2)) {
/* 320 */         this.x = (int)(this.x + this.SPEED);
/* 321 */         this.catchingUp = 4;
/*     */       } else {
/* 323 */         this.catchingUp = 0;
/*     */       } 
/*     */     } 
/* 327 */     if (this.right && this.x <= this.pbX && this.canMoveRight) {
/* 328 */       if (this.mapX >= this.mbX && this.x < 771 && isNextTileValid(2)) {
/* 329 */         this.x = (int)(this.x + this.SPEED);
/* 330 */       } else if (this.catchingUp != 2 && 
/* 331 */         this.x >= Game.playerSpawnX && isNextTileValid(2) && 
/* 332 */         this.x < 771) {
/* 333 */         this.mapX = (int)(this.mapX + this.SPEED);
/*     */       } 
/* 335 */       rightCount = (byte)(int)(rightCount + this.SPEED);
/* 336 */       this.movingRight = true;
/* 337 */       this.lastDir = 2;
/* 338 */       if (rightCount >= 42)
/* 339 */         rightCount = 2; 
/*     */     } else {
/* 342 */       rightCount = 1;
/* 343 */       this.movingRight = false;
/* 344 */       if (this.movingLeft && this.x >= Game.playerSpawnX && isNextTileValid(4)) {
/* 345 */         this.x = (int)(this.x - this.SPEED);
/* 346 */         this.catchingUp = 2;
/*     */       } else {
/* 348 */         this.catchingUp = 0;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void insideMovement() {
/* 354 */     if (this.up && this.y >= 125.0F && this.canMoveUp) {
/* 355 */       this.y = (int)(this.y - this.SPEED);
/* 356 */       upCount = (byte)(upCount + 1);
/* 357 */       this.movingUp = true;
/* 358 */       this.lastDir = 1;
/* 359 */       if (upCount == 42)
/* 360 */         upCount = 1; 
/*     */     } else {
/* 363 */       upCount = 0;
/* 364 */       this.movingUp = false;
/*     */     } 
/* 366 */     if (this.down && this.y <= 423.0F && this.canMoveDown) {
/* 367 */       this.y = (int)(this.y + this.SPEED);
/* 368 */       downCount = (byte)(downCount + 1);
/* 369 */       this.movingDown = true;
/* 370 */       this.lastDir = 3;
/* 371 */       if (downCount == 42)
/* 372 */         downCount = 1; 
/*     */     } else {
/* 375 */       downCount = 0;
/* 376 */       this.movingDown = false;
/*     */     } 
/* 378 */     if (this.left && this.x >= 194.0F && this.canMoveLeft) {
/* 379 */       this.x = (int)(this.x - this.SPEED);
/* 380 */       leftCount = (byte)(leftCount + 1);
/* 381 */       this.movingLeft = true;
/* 382 */       this.lastDir = 4;
/* 383 */       if (leftCount == 42)
/* 384 */         leftCount = 1; 
/*     */     } else {
/* 387 */       leftCount = 0;
/* 388 */       this.movingLeft = false;
/*     */     } 
/* 390 */     if (this.right && this.x <= 612.0F && this.canMoveRight) {
/* 391 */       this.x = (int)(this.x + this.SPEED);
/* 392 */       rightCount = (byte)(rightCount + 1);
/* 393 */       this.movingRight = true;
/* 394 */       this.lastDir = 2;
/* 395 */       if (rightCount == 42)
/* 396 */         rightCount = 1; 
/*     */     } else {
/* 399 */       rightCount = 0;
/* 400 */       this.movingRight = false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render(Graphics g) {
/* 405 */     if (F3Menu.f3menu) {
/* 406 */       g.setColor(Color.yellow);
/* 407 */       g.drawRect(this.x / 32 * 32, this.y / 32 * 32, 32, 32);
/*     */     } 
/* 409 */     if (!this.isAttacking) {
/* 410 */       a.animateEntity(g, this.x, this.y, ImageManager.player_up, 
/* 411 */           upCount);
/* 412 */       a.animateEntity(g, this.x, this.y, ImageManager.player_down, 
/* 413 */           downCount);
/* 414 */       a.animateEntity(g, this.x, this.y, ImageManager.player_left, 
/* 415 */           leftCount);
/* 416 */       a.animateEntity(g, this.x, this.y, ImageManager.player_right, 
/* 417 */           rightCount);
/* 418 */     } else if (this.isAttacking) {
/* 419 */       a.animateEntity(g, this.x, this.y, ImageManager.player_up_attack, 
/* 420 */           upCount);
/* 421 */       a.animateEntity(g, this.x, this.y, 
/* 422 */           ImageManager.player_down_attack, downCount);
/* 423 */       a.animateEntity(g, this.x, this.y, 
/* 424 */           ImageManager.player_left_attack, leftCount);
/* 425 */       a.animateEntity(g, this.x, this.y, 
/* 426 */           ImageManager.player_right_attack, rightCount);
/*     */     } 
/* 429 */     if (!this.movingUp && !this.movingDown && !this.movingLeft && !this.movingRight && 
/* 430 */       this.lastDir == 0)
/* 432 */       g.drawImage(ImageManager.player_down[1], this.x, this.y, 32, 32, 
/* 433 */           null); 
/* 436 */     if (!this.movingRight && this.lastDir == 2) {
/* 437 */       g.drawImage(ImageManager.player_right[1], this.x, this.y, 32, 32, 
/* 438 */           null);
/* 439 */       if (a.flashRequest)
/* 440 */         a.imageFlash(g, ImageManager.player_right[1], this.x, this.y, new Color(
/* 441 */               255, 0, 0, 128)); 
/*     */     } 
/* 444 */     if (!this.movingLeft && this.lastDir == 4) {
/* 445 */       g.drawImage(ImageManager.player_left[1], this.x, this.y, 32, 32, 
/* 446 */           null);
/* 447 */       if (a.flashRequest)
/* 448 */         a.imageFlash(g, ImageManager.player_left[1], this.x, this.y, new Color(
/* 449 */               255, 0, 0, 128)); 
/*     */     } 
/* 452 */     if (!this.movingUp && this.lastDir == 1) {
/* 453 */       g.drawImage(ImageManager.player_up[1], this.x, this.y, 32, 32, 
/* 454 */           null);
/* 455 */       if (a.flashRequest)
/* 456 */         a.imageFlash(g, ImageManager.player_up[1], this.x, this.y, new Color(255, 
/* 457 */               0, 0, 128)); 
/*     */     } 
/* 460 */     if (!this.movingDown && this.lastDir == 3) {
/* 461 */       g.drawImage(ImageManager.player_down[1], this.x, this.y, 32, 32, 
/* 462 */           null);
/* 463 */       if (a.flashRequest)
/* 464 */         a.imageFlash(g, ImageManager.player_down[1], this.x, this.y, new Color(
/* 465 */               255, 0, 0, 128)); 
/*     */     } 
/* 468 */     if (a.flashRequest && (
/* 469 */       this.movingUp || this.movingDown || this.movingLeft || this.movingRight))
/* 470 */       a.imageFlash(g, a.getCurrentFrame(), this.x, this.y, 
/* 471 */           new Color(255, 0, 0, 128)); 
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.8_2.jar!\beyondOrigins\main\entities\Player.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */