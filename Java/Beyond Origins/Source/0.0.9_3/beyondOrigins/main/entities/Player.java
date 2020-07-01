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
/*  17 */   public String defaultName = this.name;
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
/*  47 */   public double SPEED = 1.0D;
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
/*  51 */   public short mbX = 1232;
/*     */   
/*  51 */   public short mbY = 800;
/*     */   
/*  51 */   public short pbX = 801;
/*     */   
/*  51 */   public short pbY = 1;
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
/*  60 */   private int hpc = 81, xpc = 83, regenTime = 60;
/*     */   
/*     */   private int time;
/*     */   
/*     */   public Player(int x, int y, int mx, int my) {
/*  63 */     this.x = x;
/*  64 */     this.y = y;
/*  65 */     this.mapX = mx;
/*  66 */     this.mapY = my;
/*  67 */     a = new Animate();
/*  68 */     this.expLevels = new int[99];
/*  69 */     this.expLevels[1] = 0;
/*  70 */     this.expLevels[2] = 100;
/*  71 */     this.expLevels[3] = 300;
/*  72 */     this.expLevels[4] = 500;
/*  73 */     this.expLevels[5] = 800;
/*  74 */     this.expLevels[6] = 1100;
/*  75 */     this.expLevels[7] = 1400;
/*  76 */     this.expLevels[8] = 1700;
/*  77 */     this.expLevels[9] = 1900;
/*  78 */     this.expLevels[10] = 2100;
/*     */   }
/*     */   
/*     */   public void tick() {
/*  84 */     this.tileX = (this.x + this.mapX) / 32 - 12;
/*  85 */     this.tileY = (this.y + this.mapY) / 32 - 8;
/*  88 */     this.time++;
/*  89 */     if (this.time >= this.regenTime && this.health < this.maxHealth) {
/*  90 */       this.health += 0.5D;
/*  91 */       this.time = 0;
/*  92 */       healthBarCheck();
/*     */     } 
/*  96 */     if (this.hpc >= 2 || this.health > 0.0D)
/*  97 */       this.hpc = (int)(this.health * 81.0D / this.maxHealth); 
/*  99 */     if (this.health == this.maxHealth)
/* 100 */       this.hpc = 81; 
/* 103 */     if (this.xpc >= 2 || this.exp > 0)
/* 104 */       this.xpc = 83 * (this.exp - this.expLevels[this.level]) / (
/* 105 */         this.expLevels[this.level + 1] - this.expLevels[this.level]); 
/* 107 */     if (this.exp >= this.expLevels[this.level + 1] && this.level < this.maxLevel)
/* 108 */       this.level = (short)(this.level + 1); 
/* 111 */     mapMovement();
/*     */   }
/*     */   
/*     */   public int getCurrentTile() {
/* 116 */     Game.getMap();
/* 116 */     return GrassMap.getTileID(this.tileX, this.tileY);
/*     */   }
/*     */   
/*     */   public boolean isNextTileValid(int dir) {
/* 121 */     if (dir == 1) {
/* 122 */       Game.getMap();
/* 122 */       if (GrassMap.getTileID((this.x - 15 + this.mapX) / 32 - 12, (
/* 123 */           this.y - 1 + this.mapY) / 32 - 8) == 0) {
/* 124 */         Game.getMap();
/* 124 */         if (GrassMap.getTileID((this.x + 14 + this.mapX) / 32 - 12, (
/* 125 */             this.y - 1 + this.mapY) / 32 - 8) != 0)
/* 126 */           return false; 
/*     */       } else {
/* 126 */         return false;
/*     */       } 
/* 128 */     } else if (dir == 2) {
/* 129 */       Game.getMap();
/* 129 */       if (GrassMap.getTileID((this.x + 15 + this.mapX) / 32 - 12, (
/* 130 */           this.y + 31 + this.mapY) / 32 - 8) == 0) {
/* 131 */         Game.getMap();
/* 131 */         if (GrassMap.getTileID((this.x + 15 + this.mapX) / 32 - 12, (
/* 132 */             this.y + this.mapY) / 32 - 8) != 0)
/* 133 */           return false; 
/*     */       } else {
/* 133 */         return false;
/*     */       } 
/* 135 */     } else if (dir == 3) {
/* 136 */       Game.getMap();
/* 136 */       if (GrassMap.getTileID((this.x - 14 + this.mapX) / 32 - 12, (
/* 137 */           this.y + 32 + this.mapY) / 32 - 8) == 0) {
/* 138 */         Game.getMap();
/* 138 */         if (GrassMap.getTileID((this.x + 14 + this.mapX) / 32 - 12, (
/* 139 */             this.y + 32 + this.mapY) / 32 - 8) != 0)
/* 140 */           return false; 
/*     */       } else {
/* 140 */         return false;
/*     */       } 
/* 142 */     } else if (dir == 4) {
/* 143 */       Game.getMap();
/* 143 */       if (GrassMap.getTileID((this.x + this.mapX - 17) / 32 - 12, (
/* 144 */           this.y + 31 + this.mapY) / 32 - 8) == 0) {
/* 145 */         Game.getMap();
/* 145 */         if (GrassMap.getTileID((this.x + this.mapX - 17) / 32 - 12, (
/* 146 */             this.y + this.mapY) / 32 - 8) != 0)
/* 147 */           return false; 
/*     */       } else {
/* 147 */         return false;
/*     */       } 
/*     */     } 
/* 150 */     return true;
/*     */   }
/*     */   
/*     */   public void attack() {
/* 154 */     this.isAttacking = true;
/* 155 */     if (Math.sqrt(((this.x - TestDummy.rx) * (this.x - TestDummy.rx) + (
/* 156 */         this.y - TestDummy.ry) * (this.y - TestDummy.ry))) <= this.attackRadius)
/* 157 */       TestDummy.takeDamage(this.damage); 
/*     */   }
/*     */   
/*     */   public void takeDamage(double d) {
/* 162 */     if (this.health >= d && !TestDummy.isDead) {
/* 163 */       this.health -= d;
/* 164 */       a.flashRequest = true;
/* 165 */     } else if (this.health == 0.0D) {
/* 166 */       kill();
/*     */     } 
/* 168 */     healthBarCheck();
/*     */   }
/*     */   
/*     */   public void fixPos() {
/* 172 */     if (this.mapX < 400) {
/* 173 */       this.mapX = 400;
/* 174 */     } else if (this.mapX > this.mbX) {
/* 175 */       this.mapX = this.mbX;
/*     */     } 
/* 177 */     if (this.mapY < 256) {
/* 178 */       this.mapY = 256;
/* 179 */     } else if (this.mapY > this.mbY) {
/* 180 */       this.mapY = this.mbY;
/*     */     } 
/* 182 */     if (this.x < 32) {
/* 183 */       this.x = 32;
/* 184 */     } else if (this.x > Game.width - 32) {
/* 185 */       this.x = Game.width - 32;
/*     */     } 
/* 187 */     if (this.y < 32) {
/* 188 */       this.y = 32;
/* 189 */     } else if (this.y > Game.height - 32) {
/* 190 */       this.y = Game.height - 32;
/*     */     } 
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
/* 203 */     this.mapX = 400;
/* 204 */     this.mapY = 256;
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
/*     */   public void drawPlayerHUD(Graphics g) {
/* 222 */     g.drawImage(ImageManager.player_hud, 5, 5, null);
/* 223 */     g.setFont(Game.playerHUDFont);
/* 224 */     g.setColor(Color.black);
/* 225 */     fm = g.getFontMetrics(Game.playerHUDFont);
/* 226 */     g.drawString(String.valueOf(this.name) + " | Lvl " + this.level, 
/* 227 */         108 - fm.stringWidth(String.valueOf(this.name) + " | Lvl " + this.level) / 2, 21);
/* 228 */     drawHealthBar(g);
/* 229 */     drawExpBar(g);
/* 230 */     g.drawImage(ImageManager.player_down[1], 21, 21, null);
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
/* 257 */         this.y = (int)(this.y - this.SPEED);
/* 258 */       } else if (catchingUp != 1 && this.y <= Game.playerSpawnY && 
/* 259 */         isNextTileValid(1)) {
/* 260 */         this.mapY = (int)(this.mapY - this.SPEED);
/*     */       } 
/* 262 */       upCount = (byte)(int)(upCount + this.SPEED);
/* 263 */       this.movingUp = true;
/* 264 */       this.lastDir = 1;
/* 265 */       if (upCount >= 42)
/* 266 */         upCount = 2; 
/*     */     } else {
/* 269 */       upCount = 1;
/* 270 */       this.movingUp = false;
/* 271 */       if (this.movingDown && this.y <= Game.playerSpawnY && isNextTileValid(3)) {
/* 272 */         this.y = (int)(this.y + this.SPEED);
/* 273 */         catchingUp = 1;
/*     */       } else {
/* 275 */         catchingUp = 0;
/*     */       } 
/*     */     } 
/* 279 */     if (this.down && this.y <= 511.0F && this.canMoveDown) {
/* 280 */       if (this.mapY >= this.mbY && this.y < 481 && isNextTileValid(3)) {
/* 281 */         this.y = (int)(this.y + this.SPEED);
/* 282 */       } else if (catchingUp != 3 && 
/* 283 */         this.y >= Game.playerSpawnY && isNextTileValid(3) && 
/* 284 */         this.y < 481) {
/* 285 */         this.mapY = (int)(this.mapY + this.SPEED);
/*     */       } 
/* 287 */       downCount = (byte)(int)(downCount + this.SPEED);
/* 288 */       this.movingDown = true;
/* 289 */       this.lastDir = 3;
/* 290 */       if (downCount >= 42)
/* 291 */         downCount = 2; 
/*     */     } else {
/* 294 */       downCount = 1;
/* 295 */       this.movingDown = false;
/* 296 */       if (this.movingUp && this.y >= Game.playerSpawnY && isNextTileValid(1)) {
/* 297 */         this.y = (int)(this.y - this.SPEED);
/* 298 */         catchingUp = 3;
/*     */       } else {
/* 300 */         catchingUp = 0;
/*     */       } 
/*     */     } 
/* 304 */     if (this.left && this.x >= 0.0F && this.canMoveLeft) {
/* 305 */       if (this.mapX <= Game.playerSpawnX && this.x > 30.0D + this.SPEED && 
/* 306 */         isNextTileValid(4)) {
/* 307 */         this.x = (int)(this.x - this.SPEED);
/* 308 */       } else if (catchingUp != 4 && 
/* 309 */         this.x <= Game.playerSpawnX && isNextTileValid(4) && 
/* 310 */         this.x > 30.0D + this.SPEED) {
/* 311 */         this.mapX = (int)(this.mapX - this.SPEED);
/*     */       } 
/* 313 */       leftCount = (byte)(int)(leftCount + this.SPEED);
/* 314 */       this.movingLeft = true;
/* 315 */       this.lastDir = 4;
/* 316 */       if (leftCount >= 42)
/* 317 */         leftCount = 2; 
/*     */     } else {
/* 320 */       leftCount = 1;
/* 321 */       this.movingLeft = false;
/* 322 */       if (this.movingRight && this.x <= Game.playerSpawnX && isNextTileValid(2)) {
/* 323 */         this.x = (int)(this.x + this.SPEED);
/* 324 */         catchingUp = 4;
/*     */       } else {
/* 326 */         catchingUp = 0;
/*     */       } 
/*     */     } 
/* 330 */     if (this.right && this.x <= this.pbX && this.canMoveRight) {
/* 331 */       if (this.mapX >= this.mbX && this.x < 771 && isNextTileValid(2)) {
/* 332 */         this.x = (int)(this.x + this.SPEED);
/* 333 */       } else if (catchingUp != 2 && 
/* 334 */         this.x >= Game.width / 2 - 16 && isNextTileValid(2) && 
/* 335 */         this.x < 771) {
/* 336 */         this.mapX = (int)(this.mapX + this.SPEED);
/*     */       } 
/* 338 */       rightCount = (byte)(int)(rightCount + this.SPEED);
/* 339 */       this.movingRight = true;
/* 340 */       this.lastDir = 2;
/* 341 */       if (rightCount >= 42)
/* 342 */         rightCount = 2; 
/*     */     } else {
/* 345 */       rightCount = 1;
/* 346 */       this.movingRight = false;
/* 347 */       if (this.movingLeft && this.x >= Game.playerSpawnX && isNextTileValid(4)) {
/* 348 */         this.x = (int)(this.x - this.SPEED);
/* 349 */         catchingUp = 2;
/*     */       } else {
/* 351 */         catchingUp = 0;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void insideMovement() {
/* 357 */     if (this.up && this.y >= 125.0F && this.canMoveUp) {
/* 358 */       this.y = (int)(this.y - this.SPEED);
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
/* 370 */       this.y = (int)(this.y + this.SPEED);
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
/* 382 */       this.x = (int)(this.x - this.SPEED);
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
/* 394 */       this.x = (int)(this.x + this.SPEED);
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
/* 408 */     if (F3Menu.f3menu) {
/* 409 */       g.setColor(Color.yellow);
/* 410 */       g.drawRect(this.x / 32 * 32, this.y / 32 * 32, 32, 32);
/*     */     } 
/* 412 */     if (!this.isAttacking) {
/* 413 */       a.animateEntity(g, this.x, this.y, ImageManager.player_up, 
/* 414 */           upCount);
/* 415 */       a.animateEntity(g, this.x, this.y, ImageManager.player_down, 
/* 416 */           downCount);
/* 417 */       a.animateEntity(g, this.x, this.y, ImageManager.player_left, 
/* 418 */           leftCount);
/* 419 */       a.animateEntity(g, this.x, this.y, ImageManager.player_right, 
/* 420 */           rightCount);
/* 421 */     } else if (this.isAttacking) {
/* 422 */       a.animateEntity(g, this.x, this.y, ImageManager.player_up_attack, 
/* 423 */           upCount);
/* 424 */       a.animateEntity(g, this.x, this.y, 
/* 425 */           ImageManager.player_down_attack, downCount);
/* 426 */       a.animateEntity(g, this.x, this.y, 
/* 427 */           ImageManager.player_left_attack, leftCount);
/* 428 */       a.animateEntity(g, this.x, this.y, 
/* 429 */           ImageManager.player_right_attack, rightCount);
/*     */     } 
/* 432 */     if (!this.up && !this.down && !this.left && !this.right && this.lastDir == 0)
/* 433 */       g.drawImage(ImageManager.player_down[1], this.x, this.y, 32, 32, 
/* 434 */           null); 
/* 437 */     if (!this.right && this.lastDir == 2) {
/* 438 */       g.drawImage(ImageManager.player_right[1], this.x, this.y, 32, 32, 
/* 439 */           null);
/* 440 */       if (a.flashRequest)
/* 441 */         a.imageFlash(g, ImageManager.player_right[1], this.x, this.y, new Color(
/* 442 */               255, 0, 0, 128)); 
/*     */     } 
/* 445 */     if (!this.left && this.lastDir == 4) {
/* 446 */       g.drawImage(ImageManager.player_left[1], this.x, this.y, 32, 32, 
/* 447 */           null);
/* 448 */       if (a.flashRequest)
/* 449 */         a.imageFlash(g, ImageManager.player_left[1], this.x, this.y, new Color(
/* 450 */               255, 0, 0, 128)); 
/*     */     } 
/* 453 */     if (!this.up && this.lastDir == 1) {
/* 454 */       g.drawImage(ImageManager.player_up[1], this.x, this.y, 32, 32, 
/* 455 */           null);
/* 456 */       if (a.flashRequest)
/* 457 */         a.imageFlash(g, ImageManager.player_up[1], this.x, this.y, new Color(255, 
/* 458 */               0, 0, 128)); 
/*     */     } 
/* 461 */     if (!this.down && this.lastDir == 3) {
/* 462 */       g.drawImage(ImageManager.player_down[1], this.x, this.y, 32, 32, 
/* 463 */           null);
/* 464 */       if (a.flashRequest)
/* 465 */         a.imageFlash(g, ImageManager.player_down[1], this.x, this.y, new Color(
/* 466 */               255, 0, 0, 128)); 
/*     */     } 
/* 469 */     if (a.flashRequest && (
/* 470 */       this.movingUp || this.movingDown || this.movingLeft || this.movingRight))
/* 471 */       a.imageFlash(g, a.getCurrentFrame(), this.x, this.y, 
/* 472 */           new Color(255, 0, 0, 128)); 
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.9_3.jar!\beyondOrigins\main\entities\Player.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */