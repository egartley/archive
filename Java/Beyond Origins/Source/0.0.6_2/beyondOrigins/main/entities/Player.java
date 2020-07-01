/*     */ package beyondOrigins.main.entities;
/*     */ 
/*     */ import beyondOrigins.main.Game;
/*     */ import beyondOrigins.main.gfx.Animate;
/*     */ import beyondOrigins.main.gfx.ImageManager;
/*     */ import beyondOrigins.main.menus.MainMenu;
/*     */ import java.awt.Color;
/*     */ import java.awt.FontMetrics;
/*     */ import java.awt.Graphics;
/*     */ 
/*     */ public class Player {
/*  15 */   public static String name = "Roland", defaultName = "Roland";
/*     */   
/*  16 */   public static String typedName = "";
/*     */   
/*  19 */   public static double maxHealth = 50.0D, health = 50.0D;
/*     */   
/*  22 */   public static double damage = 1.5D;
/*     */   
/*  23 */   public static byte attackRadius = 32;
/*     */   
/*     */   public static boolean flashRequest;
/*     */   
/*  27 */   public static byte upCount = 1, downCount = 1, leftCount = 1;
/*     */   
/*  28 */   public static byte rightCount = 1;
/*     */   
/*  31 */   public static short level = 1;
/*     */   
/*  31 */   public static short exp = 0;
/*     */   
/*  31 */   public static short untilNextLvl = 0;
/*     */   
/*  31 */   public static short maxLevel = 99;
/*     */   
/*     */   public static int[] expLevels;
/*     */   
/*     */   public static boolean canMoveUp = true, canMoveDown = true;
/*     */   
/*     */   public static boolean canMoveLeft = true;
/*     */   
/*     */   public static boolean canMoveRight = true;
/*     */   
/*  37 */   public static float x = 0.0F;
/*     */   
/*  37 */   public static float y = 0.0F;
/*     */   
/*     */   public static byte lastDir;
/*     */   
/*     */   public static byte catchingUp;
/*     */   
/*     */   public static boolean up = false, down = false, left = false;
/*     */   
/*     */   public static boolean right = false;
/*     */   
/*  41 */   public static double SPEED = 1.0D;
/*     */   
/*     */   public static boolean movingUp;
/*     */   
/*     */   public static boolean movingDown;
/*     */   
/*     */   public static boolean movingLeft;
/*     */   
/*     */   public static boolean movingRight;
/*     */   
/*     */   public static boolean mapMovement = true;
/*     */   
/*     */   public static boolean insideMovement;
/*     */   
/*     */   public static float mapX;
/*     */   
/*     */   public static float mapY;
/*     */   
/*  45 */   public static short mbX = 1235;
/*     */   
/*  45 */   public static short mbY = 814;
/*     */   
/*  45 */   public static short pbX = 801;
/*     */   
/*  45 */   public static short pbY = 1;
/*     */   
/*     */   public static short tileX;
/*     */   
/*     */   public static short tileY;
/*     */   
/*     */   private static Animate a;
/*     */   
/*     */   private static FontMetrics fm;
/*     */   
/*     */   private static Color hColor;
/*     */   
/*  53 */   private static int hpc = 81, xpc = 83, regenTime = 60;
/*     */   
/*     */   private static int time;
/*     */   
/*     */   public Player(int x, int y, int mx, int my) {
/*  56 */     Player.x = x;
/*  57 */     Player.y = y;
/*  58 */     mapX = mx;
/*  59 */     mapY = my;
/*  60 */     a = new Animate();
/*  61 */     expLevels = new int[99];
/*  62 */     expLevels[1] = 0;
/*  63 */     expLevels[2] = 100;
/*  64 */     expLevels[3] = 300;
/*  65 */     expLevels[4] = 500;
/*  66 */     expLevels[5] = 800;
/*  67 */     expLevels[6] = 1100;
/*  68 */     expLevels[7] = 1400;
/*  69 */     expLevels[8] = 1700;
/*  70 */     expLevels[9] = 1900;
/*  71 */     expLevels[10] = 2100;
/*     */   }
/*     */   
/*     */   public void tick() {
/*  77 */     tileX = (short)(((int)x + (int)mapX) / 32 - 12);
/*  78 */     tileY = (short)(((int)y + (int)mapY) / 32 - 8);
/*  81 */     if (mapX > mbX)
/*  82 */       mapX = mbX; 
/*  84 */     if (mapX < Game.playerSpawnX)
/*  85 */       mapX = Game.playerSpawnX; 
/*  87 */     if (mapY > mbY)
/*  88 */       mapY = mbY; 
/*  90 */     if (mapY < Game.playerSpawnY)
/*  91 */       mapY = Game.playerSpawnY; 
/*  93 */     if (x < 0.0F)
/*  94 */       x = 0.0F; 
/*  96 */     if (y < 0.0F)
/*  97 */       y = 0.0F; 
/* 101 */     time++;
/* 102 */     if (time >= regenTime && health < maxHealth) {
/* 103 */       health += 0.5D;
/* 104 */       time = 0;
/* 105 */       healthBarCheck();
/*     */     } 
/* 109 */     if (hpc >= 2 || health > 0.0D)
/* 110 */       hpc = (int)(health * 81.0D / maxHealth); 
/* 112 */     if (health == maxHealth)
/* 113 */       hpc = 81; 
/* 116 */     if (xpc >= 2 || exp > 0)
/* 117 */       xpc = 83 * (exp - expLevels[level]) / (
/* 118 */         expLevels[level + 1] - expLevels[level]); 
/* 120 */     if (exp >= expLevels[level + 1] && level < maxLevel)
/* 121 */       level = (short)(level + 1); 
/* 125 */     if (mapMovement)
/* 126 */       mapMovement(); 
/* 128 */     if (insideMovement)
/* 129 */       insideMovement(); 
/*     */   }
/*     */   
/*     */   public static void attack() {
/* 134 */     if (Math.sqrt(((x - TestDummy.rx) * (x - TestDummy.rx) + (
/* 135 */         y - TestDummy.ry) * (y - TestDummy.ry))) <= attackRadius)
/* 136 */       TestDummy.takeDamage(damage); 
/*     */   }
/*     */   
/*     */   public static void takeDamage(double d) {
/* 141 */     if (health >= d && !TestDummy.isDead) {
/* 142 */       health -= d;
/* 143 */       a.flashRequest = true;
/* 144 */     } else if (health == 0.0D) {
/* 145 */       kill();
/*     */     } 
/* 147 */     healthBarCheck();
/*     */   }
/*     */   
/*     */   public static void kill() {
/* 151 */     Game.isInGame = false;
/* 152 */     MainMenu.menuState = 6;
/*     */   }
/*     */   
/*     */   public static void respawn() {
/* 156 */     health = maxHealth;
/* 157 */     x = Game.playerSpawnX;
/* 158 */     y = Game.playerSpawnY;
/* 159 */     mapX = Game.playerSpawnX;
/* 160 */     mapY = Game.playerSpawnY;
/* 161 */     lastDir = 3;
/* 162 */     MainMenu.menuState = 0;
/* 163 */     Game.isInGame = true;
/* 164 */     healthBarCheck();
/*     */   }
/*     */   
/*     */   public static void healthBarCheck() {
/* 168 */     if (health >= 0.0D && health <= maxHealth / 3.0D) {
/* 169 */       hColor = new Color(127, 0, 0);
/* 170 */     } else if (health > maxHealth / 3.0D && health <= maxHealth / 3.0D * 2.0D) {
/* 171 */       hColor = new Color(255, 216, 0);
/* 172 */     } else if (health <= maxHealth) {
/* 173 */       hColor = new Color(0, 255, 33);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void drawPlayerHUD(Graphics g) {
/* 178 */     g.drawImage(ImageManager.pHUD, 5, 5, null);
/* 179 */     g.setFont(Game.playerHUDFont);
/* 180 */     g.setColor(Color.black);
/* 181 */     fm = g.getFontMetrics(Game.playerHUDFont);
/* 182 */     g.drawString(String.valueOf(name) + " | Lvl " + level, 
/* 183 */         108 - fm.stringWidth(String.valueOf(name) + " | Lvl " + level) / 2, 21);
/* 184 */     drawHealthBar(g);
/* 185 */     drawExpBar(g);
/* 186 */     g.drawImage(ImageManager.playerd1, 21, 21, null);
/*     */   }
/*     */   
/*     */   private void drawHealthBar(Graphics g) {
/* 190 */     fm = g.getFontMetrics(Game.pHUDBar);
/* 191 */     g.setColor(hColor);
/* 192 */     g.fillRect(69, 34, hpc, 8);
/* 193 */     g.setFont(Game.pHUDBar);
/* 194 */     g.setColor(Color.black);
/* 195 */     g.drawString(String.valueOf(health), 
/* 196 */         108 - fm.stringWidth(String.valueOf(health)) / 2, 42);
/*     */   }
/*     */   
/*     */   private void drawExpBar(Graphics g) {
/* 200 */     fm = g.getFontMetrics(Game.pHUDBar);
/* 201 */     g.setColor(Color.blue);
/* 202 */     g.fillRect(67, 50, xpc, 8);
/* 203 */     g.setFont(Game.pHUDBar);
/* 204 */     g.setColor(Color.white);
/* 205 */     g.drawString(String.valueOf(exp), 
/* 206 */         108 - fm.stringWidth(String.valueOf(exp)) / 2, 58);
/*     */   }
/*     */   
/*     */   public void mapMovement() {
/* 211 */     if (up && y >= pbY && canMoveUp) {
/* 212 */       if (mapY <= Game.playerSpawnY && y >= 0.0F) {
/* 213 */         y = (float)(y - SPEED);
/* 214 */       } else if (catchingUp != 1 && y <= Game.playerSpawnY) {
/* 215 */         mapY = (float)(mapY - SPEED);
/*     */       } 
/* 217 */       upCount = (byte)(int)(upCount + SPEED);
/* 218 */       movingUp = true;
/* 219 */       lastDir = 1;
/* 220 */       if (upCount >= 42)
/* 221 */         upCount = 1; 
/*     */     } else {
/* 224 */       upCount = 0;
/* 225 */       movingUp = false;
/* 226 */       if (movingDown && y <= Game.playerSpawnY) {
/* 227 */         y = (float)(y + SPEED);
/* 228 */         catchingUp = 1;
/*     */       } else {
/* 230 */         catchingUp = 0;
/*     */       } 
/*     */     } 
/* 234 */     if (down && y <= 511.0F && canMoveDown) {
/* 235 */       if (mapY >= mbY && y < 513.0F) {
/* 236 */         y = (float)(y + SPEED);
/* 237 */       } else if (catchingUp != 3 && y >= Game.playerSpawnY && y < 513.0F) {
/* 238 */         mapY = (float)(mapY + SPEED);
/*     */       } 
/* 240 */       downCount = (byte)(int)(downCount + SPEED);
/* 241 */       movingDown = true;
/* 242 */       lastDir = 3;
/* 243 */       if (downCount >= 42)
/* 244 */         downCount = 1; 
/*     */     } else {
/* 247 */       downCount = 0;
/* 248 */       movingDown = false;
/* 249 */       if (movingUp && y >= Game.playerSpawnY) {
/* 250 */         y = (float)(y - SPEED);
/* 251 */         catchingUp = 3;
/*     */       } else {
/* 253 */         catchingUp = 0;
/*     */       } 
/*     */     } 
/* 257 */     if (left && x >= 0.0F && canMoveLeft) {
/* 258 */       if (mapX <= Game.playerSpawnX && x > 0.0F) {
/* 259 */         x = (float)(x - SPEED);
/* 260 */       } else if (catchingUp != 4 && x <= Game.playerSpawnX && x > 0.0F) {
/* 261 */         mapX = (float)(mapX - SPEED);
/*     */       } 
/* 263 */       leftCount = (byte)(int)(leftCount + SPEED);
/* 264 */       movingLeft = true;
/* 265 */       lastDir = 4;
/* 266 */       if (leftCount >= 42)
/* 267 */         leftCount = 1; 
/*     */     } else {
/* 270 */       leftCount = 0;
/* 271 */       movingLeft = false;
/* 272 */       if (movingRight && x <= Game.playerSpawnX) {
/* 273 */         x = (float)(x + SPEED);
/* 274 */         catchingUp = 4;
/*     */       } else {
/* 276 */         catchingUp = 0;
/*     */       } 
/*     */     } 
/* 280 */     if (right && x <= pbX && canMoveRight) {
/* 281 */       if (mapX >= mbX) {
/* 282 */         x = (float)(x + SPEED);
/* 283 */       } else if (catchingUp != 2 && x >= Game.playerSpawnX) {
/* 284 */         mapX = (float)(mapX + SPEED);
/*     */       } 
/* 286 */       rightCount = (byte)(int)(rightCount + SPEED);
/* 287 */       movingRight = true;
/* 288 */       lastDir = 2;
/* 289 */       if (rightCount >= 42)
/* 290 */         rightCount = 1; 
/*     */     } else {
/* 293 */       rightCount = 0;
/* 294 */       movingRight = false;
/* 295 */       if (movingLeft && x >= Game.playerSpawnX) {
/* 296 */         x = (float)(x - SPEED);
/* 297 */         catchingUp = 2;
/*     */       } else {
/* 299 */         catchingUp = 0;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void insideMovement() {
/* 305 */     if (up && y >= 125.0F && canMoveUp) {
/* 306 */       y = (float)(y - SPEED);
/* 307 */       upCount = (byte)(upCount + 1);
/* 308 */       movingUp = true;
/* 309 */       lastDir = 1;
/* 310 */       if (upCount == 42)
/* 311 */         upCount = 1; 
/*     */     } else {
/* 314 */       upCount = 0;
/* 315 */       movingUp = false;
/*     */     } 
/* 317 */     if (down && y <= 423.0F && canMoveDown) {
/* 318 */       y = (float)(y + SPEED);
/* 319 */       downCount = (byte)(downCount + 1);
/* 320 */       movingDown = true;
/* 321 */       lastDir = 3;
/* 322 */       if (downCount == 42)
/* 323 */         downCount = 1; 
/*     */     } else {
/* 326 */       downCount = 0;
/* 327 */       movingDown = false;
/*     */     } 
/* 329 */     if (left && x >= 194.0F && canMoveLeft) {
/* 330 */       x = (float)(x - SPEED);
/* 331 */       leftCount = (byte)(leftCount + 1);
/* 332 */       movingLeft = true;
/* 333 */       lastDir = 4;
/* 334 */       if (leftCount == 42)
/* 335 */         leftCount = 1; 
/*     */     } else {
/* 338 */       leftCount = 0;
/* 339 */       movingLeft = false;
/*     */     } 
/* 341 */     if (right && x <= 612.0F && canMoveRight) {
/* 342 */       x = (float)(x + SPEED);
/* 343 */       rightCount = (byte)(rightCount + 1);
/* 344 */       movingRight = true;
/* 345 */       lastDir = 2;
/* 346 */       if (rightCount == 42)
/* 347 */         rightCount = 1; 
/*     */     } else {
/* 350 */       rightCount = 0;
/* 351 */       movingRight = false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render(Graphics g) {
/* 357 */     a.animateEntity(g, (int)x, (int)y, ImageManager.playeru1, 
/* 358 */         ImageManager.playeru2, ImageManager.playeru3, 
/* 359 */         ImageManager.playeru4, upCount);
/* 360 */     a.animateEntity(g, (int)x, (int)y, ImageManager.playerd1, 
/* 361 */         ImageManager.playerd2, ImageManager.playerd3, 
/* 362 */         ImageManager.playerd4, downCount);
/* 363 */     a.animateEntity(g, (int)x, (int)y, ImageManager.playerl1, 
/* 364 */         ImageManager.playerl2, ImageManager.playerl3, 
/* 365 */         ImageManager.playerl4, leftCount);
/* 366 */     a.animateEntity(g, (int)x, (int)y, ImageManager.playerr1, 
/* 367 */         ImageManager.playerr2, ImageManager.playerr3, 
/* 368 */         ImageManager.playerr4, rightCount);
/* 370 */     if (!movingUp && !movingDown && !movingLeft && !movingRight && 
/* 371 */       lastDir == 0)
/* 373 */       g.drawImage(ImageManager.playerd1, (int)x, (int)y, 32, 32, null); 
/* 376 */     if (!movingRight && lastDir == 2) {
/* 377 */       g.drawImage(ImageManager.playerr1, (int)x, (int)y, 32, 32, null);
/* 378 */       if (a.flashRequest)
/* 379 */         a.imageFlash(g, ImageManager.playerr1, x, y, new Color(255, 0, 
/* 380 */               0, 128)); 
/*     */     } 
/* 383 */     if (!movingLeft && lastDir == 4) {
/* 384 */       g.drawImage(ImageManager.playerl1, (int)x, (int)y, 32, 32, null);
/* 385 */       if (a.flashRequest)
/* 386 */         a.imageFlash(g, ImageManager.playerl1, x, y, new Color(255, 0, 
/* 387 */               0, 128)); 
/*     */     } 
/* 390 */     if (!movingUp && lastDir == 1) {
/* 391 */       g.drawImage(ImageManager.playeru1, (int)x, (int)y, 32, 32, null);
/* 392 */       if (a.flashRequest)
/* 393 */         a.imageFlash(g, ImageManager.playeru1, x, y, new Color(255, 0, 
/* 394 */               0, 128)); 
/*     */     } 
/* 397 */     if (!movingDown && lastDir == 3) {
/* 398 */       g.drawImage(ImageManager.playerd1, (int)x, (int)y, 32, 32, null);
/* 399 */       if (a.flashRequest)
/* 400 */         a.imageFlash(g, ImageManager.playerd1, x, y, new Color(255, 0, 
/* 401 */               0, 128)); 
/*     */     } 
/* 405 */     if (a.flashRequest && (
/* 406 */       movingUp || movingDown || movingLeft || movingRight))
/* 407 */       a.imageFlash(g, a.getCurrentFrame(), x, y, 
/* 408 */           new Color(255, 0, 0, 128)); 
/* 411 */     drawPlayerHUD(g);
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.6_2.jar!\beyondOrigins\main\entities\Player.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */