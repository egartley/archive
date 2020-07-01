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
/*  16 */   public String name = "Roland";
/*     */   
/*  18 */   public String defaultName = "Roland";
/*     */   
/*  20 */   public String typedName = "";
/*     */   
/*  23 */   public double maxHealth = 50.0D;
/*     */   
/*  25 */   public double health = 50.0D;
/*     */   
/*  28 */   public double damage = 1.5D;
/*     */   
/*  29 */   public byte attackRadius = 32;
/*     */   
/*     */   public boolean flashRequest;
/*     */   
/*  33 */   public static byte upCount = 1, downCount = 1, leftCount = 1;
/*     */   
/*  34 */   public static byte rightCount = 1;
/*     */   
/*  37 */   public short level = 1;
/*     */   
/*  37 */   public short exp = 0;
/*     */   
/*  37 */   public short maxLevel = 99;
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
/*  46 */   public double SPEED = 1.0D;
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
/*     */   public int mapX;
/*     */   
/*     */   public int mapY;
/*     */   
/*  50 */   public short mbX = 1232;
/*     */   
/*  50 */   public short mbY = 800;
/*     */   
/*  50 */   public short pbX = 801;
/*     */   
/*  50 */   public short pbY = 1;
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
/*  59 */   private int hpc = 81, xpc = 83, regenTime = 60;
/*     */   
/*     */   private int time;
/*     */   
/*     */   public Player(int x, int y, int mx, int my) {
/*  62 */     this.x = x;
/*  63 */     this.y = y;
/*  64 */     this.mapX = mx;
/*  65 */     this.mapY = my;
/*  66 */     a = new Animate();
/*  67 */     this.expLevels = new int[99];
/*  68 */     this.expLevels[1] = 0;
/*  69 */     this.expLevels[2] = 100;
/*  70 */     this.expLevels[3] = 300;
/*  71 */     this.expLevels[4] = 500;
/*  72 */     this.expLevels[5] = 800;
/*  73 */     this.expLevels[6] = 1100;
/*  74 */     this.expLevels[7] = 1400;
/*  75 */     this.expLevels[8] = 1700;
/*  76 */     this.expLevels[9] = 1900;
/*  77 */     this.expLevels[10] = 2100;
/*     */   }
/*     */   
/*     */   public void tick() {
/*  83 */     this.tileX = (this.x + this.mapX) / 32 - 12;
/*  84 */     this.tileY = (this.y + this.mapY) / 32 - 8;
/*  87 */     if (this.mapX > this.mbX)
/*  88 */       this.mapX = this.mbX; 
/*  90 */     if (this.mapX < Game.playerSpawnX)
/*  91 */       this.mapX = Game.playerSpawnX; 
/*  93 */     if (this.mapY > this.mbY)
/*  94 */       this.mapY = this.mbY; 
/*  96 */     if (this.mapY < Game.playerSpawnY)
/*  97 */       this.mapY = Game.playerSpawnY; 
/*  99 */     if (this.x < 0)
/* 100 */       this.x = 0; 
/* 102 */     if (this.y < 0)
/* 103 */       this.y = 0; 
/* 107 */     this.time++;
/* 108 */     if (this.time >= this.regenTime && this.health < this.maxHealth) {
/* 109 */       this.health += 0.5D;
/* 110 */       this.time = 0;
/* 111 */       healthBarCheck();
/*     */     } 
/* 115 */     if (this.hpc >= 2 || this.health > 0.0D)
/* 116 */       this.hpc = (int)(this.health * 81.0D / this.maxHealth); 
/* 118 */     if (this.health == this.maxHealth)
/* 119 */       this.hpc = 81; 
/* 122 */     if (this.xpc >= 2 || this.exp > 0)
/* 123 */       this.xpc = 83 * (this.exp - this.expLevels[this.level]) / (
/* 124 */         this.expLevels[this.level + 1] - this.expLevels[this.level]); 
/* 126 */     if (this.exp >= this.expLevels[this.level + 1] && this.level < this.maxLevel)
/* 127 */       this.level = (short)(this.level + 1); 
/* 131 */     if (this.mapMovement)
/* 132 */       mapMovement(); 
/* 134 */     if (this.insideMovement)
/* 135 */       insideMovement(); 
/*     */   }
/*     */   
/*     */   public int getCurrentTile() {
/* 141 */     Game.getMap();
/* 141 */     return GrassMap.getTileID(this.tileX, this.tileY);
/*     */   }
/*     */   
/*     */   public boolean isNextTileValid(int dir) {
/* 146 */     if (dir == 1) {
/* 147 */       Game.getMap();
/* 147 */       if (GrassMap.getTileID((this.x - 14 + this.mapX) / 32 - 12, (
/* 148 */           this.y - 1 + this.mapY) / 32 - 8) == 0) {
/* 149 */         Game.getMap();
/* 149 */         if (GrassMap.getTileID((this.x + 14 + this.mapX) / 32 - 12, (
/* 150 */             this.y - 1 + this.mapY) / 32 - 8) != 0)
/* 151 */           return false; 
/*     */       } else {
/* 151 */         return false;
/*     */       } 
/* 153 */     } else if (dir == 2) {
/* 154 */       Game.getMap();
/* 154 */       if (GrassMap.getTileID((this.x + 15 + this.mapX) / 32 - 12, (
/* 155 */           this.y + 31 + this.mapY) / 32 - 8) == 0) {
/* 156 */         Game.getMap();
/* 156 */         if (GrassMap.getTileID((this.x + 15 + this.mapX) / 32 - 12, (
/* 157 */             this.y + this.mapY) / 32 - 8) != 0)
/* 158 */           return false; 
/*     */       } else {
/* 158 */         return false;
/*     */       } 
/* 160 */     } else if (dir == 3) {
/* 161 */       Game.getMap();
/* 161 */       if (GrassMap.getTileID((this.x - 14 + this.mapX) / 32 - 12, (
/* 162 */           this.y + 32 + this.mapY) / 32 - 8) == 0) {
/* 163 */         Game.getMap();
/* 163 */         if (GrassMap.getTileID((this.x + 14 + this.mapX) / 32 - 12, (
/* 164 */             this.y + 32 + this.mapY) / 32 - 8) != 0)
/* 165 */           return false; 
/*     */       } else {
/* 165 */         return false;
/*     */       } 
/* 167 */     } else if (dir == 4) {
/* 168 */       Game.getMap();
/* 168 */       if (GrassMap.getTileID((this.x + this.mapX - 18) / 32 - 12, (
/* 169 */           this.y + 31 + this.mapY) / 32 - 8) == 0) {
/* 170 */         Game.getMap();
/* 170 */         if (GrassMap.getTileID((this.x + this.mapX - 18) / 32 - 12, (
/* 171 */             this.y + this.mapY) / 32 - 8) != 0)
/* 172 */           return false; 
/*     */       } else {
/* 172 */         return false;
/*     */       } 
/*     */     } 
/* 175 */     return true;
/*     */   }
/*     */   
/*     */   public void attack() {
/* 179 */     this.isAttacking = true;
/* 180 */     if (Math.sqrt(((this.x - TestDummy.rx) * (this.x - TestDummy.rx) + (
/* 181 */         this.y - TestDummy.ry) * (this.y - TestDummy.ry))) <= this.attackRadius)
/* 182 */       TestDummy.takeDamage(this.damage); 
/*     */   }
/*     */   
/*     */   public void takeDamage(double d) {
/* 187 */     if (this.health >= d && !TestDummy.isDead) {
/* 188 */       this.health -= d;
/* 189 */       a.flashRequest = true;
/* 190 */     } else if (this.health == 0.0D) {
/* 191 */       kill();
/*     */     } 
/* 193 */     healthBarCheck();
/*     */   }
/*     */   
/*     */   public void kill() {
/* 197 */     Game.isInGame = false;
/* 198 */     (Game.getMainMenu()).menuState = 6;
/*     */   }
/*     */   
/*     */   public void respawn() {
/* 202 */     this.health = this.maxHealth;
/* 203 */     this.x = Game.playerSpawnX;
/* 204 */     this.y = Game.playerSpawnY;
/* 205 */     this.mapX = 400;
/* 206 */     this.mapY = 256;
/* 207 */     this.lastDir = 3;
/* 208 */     (Game.getMainMenu()).menuState = 0;
/* 209 */     Game.isInGame = true;
/* 210 */     healthBarCheck();
/*     */   }
/*     */   
/*     */   public void healthBarCheck() {
/* 214 */     if (this.health >= 0.0D && this.health <= this.maxHealth / 3.0D) {
/* 215 */       hColor = new Color(127, 0, 0);
/* 216 */     } else if (this.health > this.maxHealth / 3.0D && this.health <= this.maxHealth / 3.0D * 2.0D) {
/* 217 */       hColor = new Color(255, 216, 0);
/* 218 */     } else if (this.health <= this.maxHealth) {
/* 219 */       hColor = new Color(0, 255, 33);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void drawPlayerHUD(Graphics g) {
/* 224 */     g.drawImage(ImageManager.player_hud, 5, 5, null);
/* 225 */     g.setFont(Game.playerHUDFont);
/* 226 */     g.setColor(Color.black);
/* 227 */     fm = g.getFontMetrics(Game.playerHUDFont);
/* 228 */     g.drawString(String.valueOf(this.name) + " | Lvl " + this.level, 
/* 229 */         108 - fm.stringWidth(String.valueOf(this.name) + " | Lvl " + this.level) / 2, 21);
/* 230 */     drawHealthBar(g);
/* 231 */     drawExpBar(g);
/* 232 */     g.drawImage(ImageManager.player_down[1], 21, 21, null);
/*     */   }
/*     */   
/*     */   private void drawHealthBar(Graphics g) {
/* 236 */     fm = g.getFontMetrics(Game.pHUDBar);
/* 237 */     g.setColor(hColor);
/* 238 */     g.fillRect(69, 34, this.hpc, 8);
/* 239 */     g.setFont(Game.pHUDBar);
/* 240 */     g.setColor(Color.black);
/* 241 */     g.drawString(String.valueOf(this.health), 
/* 242 */         108 - fm.stringWidth(String.valueOf(this.health)) / 2, 42);
/*     */   }
/*     */   
/*     */   private void drawExpBar(Graphics g) {
/* 246 */     fm = g.getFontMetrics(Game.pHUDBar);
/* 247 */     g.setColor(Color.blue);
/* 248 */     g.fillRect(67, 50, this.xpc, 8);
/* 249 */     g.setFont(Game.pHUDBar);
/* 250 */     g.setColor(Color.white);
/* 251 */     g.drawString(String.valueOf(this.exp), 
/* 252 */         108 - fm.stringWidth(String.valueOf(this.exp)) / 2, 58);
/*     */   }
/*     */   
/*     */   public void mapMovement() {
/* 257 */     if (this.up && this.canMoveUp) {
/* 258 */       if (this.mapY <= Game.playerSpawnY && isNextTileValid(1)) {
/* 259 */         this.y = (int)(this.y - this.SPEED);
/* 260 */       } else if (this.catchingUp != 1 && this.y <= Game.playerSpawnY && 
/* 261 */         isNextTileValid(1)) {
/* 262 */         this.mapY = (int)(this.mapY - this.SPEED);
/*     */       } 
/* 264 */       upCount = (byte)(int)(upCount + this.SPEED);
/* 265 */       this.movingUp = true;
/* 266 */       this.lastDir = 1;
/* 267 */       if (upCount >= 42)
/* 268 */         upCount = 1; 
/*     */     } else {
/* 271 */       upCount = 0;
/* 272 */       this.movingUp = false;
/* 273 */       if (this.movingDown && this.y <= Game.playerSpawnY && isNextTileValid(3)) {
/* 274 */         this.y = (int)(this.y + this.SPEED);
/* 275 */         this.catchingUp = 1;
/*     */       } else {
/* 277 */         this.catchingUp = 0;
/*     */       } 
/*     */     } 
/* 281 */     if (this.down && this.y <= 511.0F && this.canMoveDown) {
/* 282 */       if (this.mapY >= this.mbY && this.y < 481 && isNextTileValid(3)) {
/* 283 */         this.y = (int)(this.y + this.SPEED);
/* 284 */       } else if (this.catchingUp != 3 && 
/* 285 */         this.y >= Game.playerSpawnY && isNextTileValid(3) && 
/* 286 */         this.y < 481) {
/* 287 */         this.mapY = (int)(this.mapY + this.SPEED);
/*     */       } 
/* 289 */       downCount = (byte)(int)(downCount + this.SPEED);
/* 290 */       this.movingDown = true;
/* 291 */       this.lastDir = 3;
/* 292 */       if (downCount >= 42)
/* 293 */         downCount = 1; 
/*     */     } else {
/* 296 */       downCount = 0;
/* 297 */       this.movingDown = false;
/* 298 */       if (this.movingUp && this.y >= Game.playerSpawnY && isNextTileValid(1)) {
/* 299 */         this.y = (int)(this.y - this.SPEED);
/* 300 */         this.catchingUp = 3;
/*     */       } else {
/* 302 */         this.catchingUp = 0;
/*     */       } 
/*     */     } 
/* 306 */     if (this.left && this.x >= 0.0F && this.canMoveLeft) {
/* 307 */       if (this.mapX <= Game.playerSpawnX && this.x > 30.0D + this.SPEED && 
/* 308 */         isNextTileValid(4)) {
/* 309 */         this.x = (int)(this.x - this.SPEED);
/* 310 */       } else if (this.catchingUp != 4 && 
/* 311 */         this.x <= Game.playerSpawnX && isNextTileValid(4) && 
/* 312 */         this.x > 30.0D + this.SPEED) {
/* 313 */         this.mapX = (int)(this.mapX - this.SPEED);
/*     */       } 
/* 315 */       leftCount = (byte)(int)(leftCount + this.SPEED);
/* 316 */       this.movingLeft = true;
/* 317 */       this.lastDir = 4;
/* 318 */       if (leftCount >= 42)
/* 319 */         leftCount = 1; 
/*     */     } else {
/* 322 */       leftCount = 0;
/* 323 */       this.movingLeft = false;
/* 324 */       if (this.movingRight && this.x <= Game.playerSpawnX && isNextTileValid(2)) {
/* 325 */         this.x = (int)(this.x + this.SPEED);
/* 326 */         this.catchingUp = 4;
/*     */       } else {
/* 328 */         this.catchingUp = 0;
/*     */       } 
/*     */     } 
/* 332 */     if (this.right && this.x <= this.pbX && this.canMoveRight) {
/* 333 */       if (this.mapX >= this.mbX && this.x < 771 && isNextTileValid(2)) {
/* 334 */         this.x = (int)(this.x + this.SPEED);
/* 335 */       } else if (this.catchingUp != 2 && 
/* 336 */         this.x >= Game.playerSpawnX && isNextTileValid(2) && 
/* 337 */         this.x < 771) {
/* 338 */         this.mapX = (int)(this.mapX + this.SPEED);
/*     */       } 
/* 340 */       rightCount = (byte)(int)(rightCount + this.SPEED);
/* 341 */       this.movingRight = true;
/* 342 */       this.lastDir = 2;
/* 343 */       if (rightCount >= 42)
/* 344 */         rightCount = 1; 
/*     */     } else {
/* 347 */       rightCount = 0;
/* 348 */       this.movingRight = false;
/* 349 */       if (this.movingLeft && this.x >= Game.playerSpawnX && isNextTileValid(4)) {
/* 350 */         this.x = (int)(this.x - this.SPEED);
/* 351 */         this.catchingUp = 2;
/*     */       } else {
/* 353 */         this.catchingUp = 0;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void insideMovement() {
/* 359 */     if (this.up && this.y >= 125.0F && this.canMoveUp) {
/* 360 */       this.y = (int)(this.y - this.SPEED);
/* 361 */       upCount = (byte)(upCount + 1);
/* 362 */       this.movingUp = true;
/* 363 */       this.lastDir = 1;
/* 364 */       if (upCount == 42)
/* 365 */         upCount = 1; 
/*     */     } else {
/* 368 */       upCount = 0;
/* 369 */       this.movingUp = false;
/*     */     } 
/* 371 */     if (this.down && this.y <= 423.0F && this.canMoveDown) {
/* 372 */       this.y = (int)(this.y + this.SPEED);
/* 373 */       downCount = (byte)(downCount + 1);
/* 374 */       this.movingDown = true;
/* 375 */       this.lastDir = 3;
/* 376 */       if (downCount == 42)
/* 377 */         downCount = 1; 
/*     */     } else {
/* 380 */       downCount = 0;
/* 381 */       this.movingDown = false;
/*     */     } 
/* 383 */     if (this.left && this.x >= 194.0F && this.canMoveLeft) {
/* 384 */       this.x = (int)(this.x - this.SPEED);
/* 385 */       leftCount = (byte)(leftCount + 1);
/* 386 */       this.movingLeft = true;
/* 387 */       this.lastDir = 4;
/* 388 */       if (leftCount == 42)
/* 389 */         leftCount = 1; 
/*     */     } else {
/* 392 */       leftCount = 0;
/* 393 */       this.movingLeft = false;
/*     */     } 
/* 395 */     if (this.right && this.x <= 612.0F && this.canMoveRight) {
/* 396 */       this.x = (int)(this.x + this.SPEED);
/* 397 */       rightCount = (byte)(rightCount + 1);
/* 398 */       this.movingRight = true;
/* 399 */       this.lastDir = 2;
/* 400 */       if (rightCount == 42)
/* 401 */         rightCount = 1; 
/*     */     } else {
/* 404 */       rightCount = 0;
/* 405 */       this.movingRight = false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render(Graphics g) {
/* 410 */     if (F3Menu.f3menu) {
/* 411 */       g.setColor(Color.yellow);
/* 412 */       g.drawRect(this.tileX * 32, this.tileY * 32, 32, 32);
/*     */     } 
/* 414 */     if (!this.isAttacking) {
/* 415 */       a.animateEntity(g, this.x, this.y, ImageManager.player_up, 
/* 416 */           upCount);
/* 417 */       a.animateEntity(g, this.x, this.y, ImageManager.player_down, 
/* 418 */           downCount);
/* 419 */       a.animateEntity(g, this.x, this.y, ImageManager.player_left, 
/* 420 */           leftCount);
/* 421 */       a.animateEntity(g, this.x, this.y, ImageManager.player_right, 
/* 422 */           rightCount);
/* 423 */     } else if (this.isAttacking) {
/* 424 */       a.animateEntity(g, this.x, this.y, ImageManager.player_up_attack, 
/* 425 */           upCount);
/* 426 */       a.animateEntity(g, this.x, this.y, 
/* 427 */           ImageManager.player_down_attack, downCount);
/* 428 */       a.animateEntity(g, this.x, this.y, 
/* 429 */           ImageManager.player_left_attack, leftCount);
/* 430 */       a.animateEntity(g, this.x, this.y, 
/* 431 */           ImageManager.player_right_attack, rightCount);
/*     */     } 
/* 434 */     if (!this.movingUp && !this.movingDown && !this.movingLeft && !this.movingRight && 
/* 435 */       this.lastDir == 0)
/* 437 */       g.drawImage(ImageManager.player_down[1], this.x, this.y, 32, 32, 
/* 438 */           null); 
/* 441 */     if (!this.movingRight && this.lastDir == 2) {
/* 442 */       g.drawImage(ImageManager.player_right[1], this.x, this.y, 32, 32, 
/* 443 */           null);
/* 444 */       if (a.flashRequest)
/* 445 */         a.imageFlash(g, ImageManager.player_right[1], this.x, this.y, new Color(
/* 446 */               255, 0, 0, 128)); 
/*     */     } 
/* 449 */     if (!this.movingLeft && this.lastDir == 4) {
/* 450 */       g.drawImage(ImageManager.player_left[1], this.x, this.y, 32, 32, 
/* 451 */           null);
/* 452 */       if (a.flashRequest)
/* 453 */         a.imageFlash(g, ImageManager.player_left[1], this.x, this.y, new Color(
/* 454 */               255, 0, 0, 128)); 
/*     */     } 
/* 457 */     if (!this.movingUp && this.lastDir == 1) {
/* 458 */       g.drawImage(ImageManager.player_up[1], this.x, this.y, 32, 32, 
/* 459 */           null);
/* 460 */       if (a.flashRequest)
/* 461 */         a.imageFlash(g, ImageManager.player_up[1], this.x, this.y, new Color(255, 
/* 462 */               0, 0, 128)); 
/*     */     } 
/* 465 */     if (!this.movingDown && this.lastDir == 3) {
/* 466 */       g.drawImage(ImageManager.player_down[1], this.x, this.y, 32, 32, 
/* 467 */           null);
/* 468 */       if (a.flashRequest)
/* 469 */         a.imageFlash(g, ImageManager.player_down[1], this.x, this.y, new Color(
/* 470 */               255, 0, 0, 128)); 
/*     */     } 
/* 474 */     if (a.flashRequest && (
/* 475 */       this.movingUp || this.movingDown || this.movingLeft || this.movingRight))
/* 476 */       a.imageFlash(g, a.getCurrentFrame(), this.x, this.y, 
/* 477 */           new Color(255, 0, 0, 128)); 
/* 479 */     drawPlayerHUD(g);
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.8_0.jar!\beyondOrigins\main\entities\Player.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */