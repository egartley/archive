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
/*  19 */   public static double maxHealth = 50.0D, health = 35.0D;
/*     */   
/*  22 */   public static double damage = 1.5D;
/*     */   
/*  23 */   public static byte attackRadius = 32;
/*     */   
/*  26 */   public static byte upCount = 1, downCount = 1, leftCount = 1;
/*     */   
/*  27 */   public static byte rightCount = 1;
/*     */   
/*  30 */   public static short level = 0;
/*     */   
/*  30 */   public static short exp = 0;
/*     */   
/*  30 */   public static short untilNextLvl = 0;
/*     */   
/*  30 */   public static short nextLvlAdd = 50;
/*     */   
/*     */   public static boolean canMoveUp = true, canMoveDown = true;
/*     */   
/*     */   public static boolean canMoveLeft = true;
/*     */   
/*     */   public static boolean canMoveRight = true;
/*     */   
/*  35 */   public static float x = 0.0F;
/*     */   
/*  35 */   public static float y = 0.0F;
/*     */   
/*     */   public static byte lastDir;
/*     */   
/*     */   public static byte catchingUp;
/*     */   
/*     */   public static boolean up = false, down = false, left = false;
/*     */   
/*     */   public static boolean right = false;
/*     */   
/*  39 */   public static double SPEED = 1.0D;
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
/*  43 */   public static short mbX = 1235;
/*     */   
/*  43 */   public static short mbY = 814;
/*     */   
/*  43 */   public static short pbX = 801;
/*     */   
/*  43 */   public static short pbY = 1;
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
/*  51 */   private static int hpc = 81, xpc = 83, regenTime = 60;
/*     */   
/*     */   private static int time;
/*     */   
/*     */   public Player(int x, int y, int mx, int my) {
/*  54 */     Player.x = x;
/*  55 */     Player.y = y;
/*  56 */     mapX = mx;
/*  57 */     mapY = my;
/*  58 */     a = new Animate();
/*     */   }
/*     */   
/*     */   public void tick() {
/*  64 */     tileX = (short)(((int)x + (int)mapX) / 32 - 12);
/*  65 */     tileY = (short)(((int)y + (int)mapY) / 32 - 8);
/*  68 */     if (mapX > mbX)
/*  69 */       mapX = mbX; 
/*  71 */     if (mapX < Game.playerSpawnX)
/*  72 */       mapX = Game.playerSpawnX; 
/*  74 */     if (mapY > mbY)
/*  75 */       mapY = mbY; 
/*  77 */     if (mapY < Game.playerSpawnY)
/*  78 */       mapY = Game.playerSpawnY; 
/*  80 */     if (x < 0.0F)
/*  81 */       x = 0.0F; 
/*  83 */     if (y < 0.0F)
/*  84 */       y = 0.0F; 
/*  87 */     time++;
/*  89 */     if (time >= regenTime && health < maxHealth) {
/*  90 */       health += 0.5D;
/*  91 */       time = 0;
/*  92 */       colorCheck();
/*     */     } 
/*  97 */     if (hpc >= 2 || health > 0.0D)
/*  98 */       hpc = (int)(health * 81.0D / maxHealth); 
/* 100 */     if (health == maxHealth)
/* 100 */       hpc = 81; 
/* 103 */     if (mapMovement)
/* 104 */       mapMovement(); 
/* 106 */     if (insideMovement)
/* 107 */       insideMovement(); 
/*     */   }
/*     */   
/*     */   public static void attack() {
/* 112 */     if (Math.sqrt(((x - TestDummy.rx) * (x - TestDummy.rx) + (
/* 113 */         y - TestDummy.ry) * (y - TestDummy.ry))) <= attackRadius)
/* 114 */       TestDummy.health -= damage; 
/*     */   }
/*     */   
/*     */   public static void takeDamage(double damage) {
/* 118 */     if (health >= damage && !TestDummy.isDead) {
/* 119 */       health -= damage;
/* 120 */     } else if (health == 0.0D) {
/* 121 */       kill();
/*     */     } 
/* 123 */     colorCheck();
/*     */   }
/*     */   
/*     */   public static void kill() {
/* 127 */     Game.isInGame = false;
/* 128 */     MainMenu.menuState = 6;
/*     */   }
/*     */   
/*     */   public static void respawn() {
/* 132 */     health = maxHealth;
/* 133 */     x = Game.playerSpawnX;
/* 134 */     y = Game.playerSpawnY;
/* 135 */     mapX = Game.playerSpawnX;
/* 136 */     mapY = Game.playerSpawnY;
/* 137 */     lastDir = 3;
/* 138 */     MainMenu.menuState = 0;
/* 139 */     Game.isInGame = true;
/* 140 */     colorCheck();
/*     */   }
/*     */   
/*     */   public static void colorCheck() {
/* 144 */     if (health >= 0.0D && health <= maxHealth / 3.0D) {
/* 145 */       hColor = new Color(127, 0, 0);
/* 146 */     } else if (health > maxHealth / 3.0D && health <= maxHealth / 3.0D * 2.0D) {
/* 147 */       hColor = new Color(255, 216, 0);
/* 148 */     } else if (health <= maxHealth) {
/* 149 */       hColor = new Color(0, 255, 33);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void drawPlayerHUD(Graphics g) {
/* 154 */     g.drawImage(ImageManager.pHUD, 5, 5, null);
/* 155 */     g.setFont(Game.playerHUDFont);
/* 156 */     g.setColor(Color.black);
/* 157 */     fm = g.getFontMetrics(Game.playerHUDFont);
/* 158 */     g.drawString(String.valueOf(name) + " | Lvl " + level, 
/* 159 */         108 - fm.stringWidth(String.valueOf(name) + " | Lvl " + level) / 2, 21);
/* 160 */     drawHealthBar(g);
/* 161 */     drawExpBar(g);
/* 162 */     g.drawImage(ImageManager.playerd1, 21, 21, null);
/*     */   }
/*     */   
/*     */   private void drawHealthBar(Graphics g) {
/* 166 */     fm = g.getFontMetrics(Game.pHUDBar);
/* 167 */     g.setColor(hColor);
/* 168 */     g.fillRect(69, 34, hpc, 8);
/* 169 */     g.setFont(Game.pHUDBar);
/* 170 */     g.setColor(Color.black);
/* 171 */     g.drawString(String.valueOf(health), 
/* 172 */         108 - fm.stringWidth(String.valueOf(health)) / 2, 42);
/*     */   }
/*     */   
/*     */   private void drawExpBar(Graphics g) {
/* 176 */     fm = g.getFontMetrics(Game.pHUDBar);
/* 177 */     g.setColor(Color.blue);
/* 178 */     g.fillRect(67, 50, xpc, 8);
/* 179 */     g.setFont(Game.pHUDBar);
/* 180 */     g.setColor(Color.white);
/* 181 */     g.drawString(String.valueOf(exp), 
/* 182 */         108 - fm.stringWidth(String.valueOf(exp)) / 2, 58);
/*     */   }
/*     */   
/*     */   public void mapMovement() {
/* 187 */     if (up && y >= pbY && canMoveUp) {
/* 188 */       if (mapY <= Game.playerSpawnY && y >= 0.0F) {
/* 189 */         y = (float)(y - SPEED);
/* 190 */       } else if (catchingUp != 1 && y <= Game.playerSpawnY) {
/* 191 */         mapY = (float)(mapY - SPEED);
/*     */       } 
/* 193 */       upCount = (byte)(int)(upCount + SPEED);
/* 194 */       movingUp = true;
/* 195 */       lastDir = 1;
/* 196 */       if (upCount >= 42)
/* 197 */         upCount = 1; 
/*     */     } else {
/* 200 */       upCount = 0;
/* 201 */       movingUp = false;
/* 202 */       if (movingDown && y <= Game.playerSpawnY) {
/* 203 */         y = (float)(y + SPEED);
/* 204 */         catchingUp = 1;
/*     */       } else {
/* 206 */         catchingUp = 0;
/*     */       } 
/*     */     } 
/* 210 */     if (down && y <= 511.0F && canMoveDown) {
/* 211 */       if (mapY >= mbY && y < 513.0F) {
/* 212 */         y = (float)(y + SPEED);
/* 213 */       } else if (catchingUp != 3 && y >= Game.playerSpawnY && y < 513.0F) {
/* 214 */         mapY = (float)(mapY + SPEED);
/*     */       } 
/* 216 */       downCount = (byte)(int)(downCount + SPEED);
/* 217 */       movingDown = true;
/* 218 */       lastDir = 3;
/* 219 */       if (downCount >= 42)
/* 220 */         downCount = 1; 
/*     */     } else {
/* 223 */       downCount = 0;
/* 224 */       movingDown = false;
/* 225 */       if (movingUp && y >= Game.playerSpawnY) {
/* 226 */         y = (float)(y - SPEED);
/* 227 */         catchingUp = 3;
/*     */       } else {
/* 229 */         catchingUp = 0;
/*     */       } 
/*     */     } 
/* 233 */     if (left && x >= 0.0F && canMoveLeft) {
/* 234 */       if (mapX <= Game.playerSpawnX && x > 0.0F) {
/* 235 */         x = (float)(x - SPEED);
/* 236 */       } else if (catchingUp != 4 && x <= Game.playerSpawnX && x > 0.0F) {
/* 237 */         mapX = (float)(mapX - SPEED);
/*     */       } 
/* 239 */       leftCount = (byte)(int)(leftCount + SPEED);
/* 240 */       movingLeft = true;
/* 241 */       lastDir = 4;
/* 242 */       if (leftCount >= 42)
/* 243 */         leftCount = 1; 
/*     */     } else {
/* 246 */       leftCount = 0;
/* 247 */       movingLeft = false;
/* 248 */       if (movingRight && x <= Game.playerSpawnX) {
/* 249 */         x = (float)(x + SPEED);
/* 250 */         catchingUp = 4;
/*     */       } else {
/* 252 */         catchingUp = 0;
/*     */       } 
/*     */     } 
/* 256 */     if (right && x <= pbX && canMoveRight) {
/* 257 */       if (mapX >= mbX) {
/* 258 */         x = (float)(x + SPEED);
/* 259 */       } else if (catchingUp != 2 && x >= Game.playerSpawnX) {
/* 260 */         mapX = (float)(mapX + SPEED);
/*     */       } 
/* 262 */       rightCount = (byte)(int)(rightCount + SPEED);
/* 263 */       movingRight = true;
/* 264 */       lastDir = 2;
/* 265 */       if (rightCount >= 42)
/* 266 */         rightCount = 1; 
/*     */     } else {
/* 269 */       rightCount = 0;
/* 270 */       movingRight = false;
/* 271 */       if (movingLeft && x >= Game.playerSpawnX) {
/* 272 */         x = (float)(x - SPEED);
/* 273 */         catchingUp = 2;
/*     */       } else {
/* 275 */         catchingUp = 0;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void insideMovement() {
/* 281 */     if (up && y >= 125.0F && canMoveUp) {
/* 282 */       y = (float)(y - SPEED);
/* 283 */       upCount = (byte)(upCount + 1);
/* 284 */       movingUp = true;
/* 285 */       lastDir = 1;
/* 286 */       if (upCount == 42)
/* 287 */         upCount = 1; 
/*     */     } else {
/* 290 */       upCount = 0;
/* 291 */       movingUp = false;
/*     */     } 
/* 293 */     if (down && y <= 423.0F && canMoveDown) {
/* 294 */       y = (float)(y + SPEED);
/* 295 */       downCount = (byte)(downCount + 1);
/* 296 */       movingDown = true;
/* 297 */       lastDir = 3;
/* 298 */       if (downCount == 42)
/* 299 */         downCount = 1; 
/*     */     } else {
/* 302 */       downCount = 0;
/* 303 */       movingDown = false;
/*     */     } 
/* 305 */     if (left && x >= 194.0F && canMoveLeft) {
/* 306 */       x = (float)(x - SPEED);
/* 307 */       leftCount = (byte)(leftCount + 1);
/* 308 */       movingLeft = true;
/* 309 */       lastDir = 4;
/* 310 */       if (leftCount == 42)
/* 311 */         leftCount = 1; 
/*     */     } else {
/* 314 */       leftCount = 0;
/* 315 */       movingLeft = false;
/*     */     } 
/* 317 */     if (right && x <= 612.0F && canMoveRight) {
/* 318 */       x = (float)(x + SPEED);
/* 319 */       rightCount = (byte)(rightCount + 1);
/* 320 */       movingRight = true;
/* 321 */       lastDir = 2;
/* 322 */       if (rightCount == 42)
/* 323 */         rightCount = 1; 
/*     */     } else {
/* 326 */       rightCount = 0;
/* 327 */       movingRight = false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render(Graphics g) {
/* 333 */     a.animateEntity(g, (int)x, (int)y, ImageManager.playeru1, ImageManager.playeru2, 
/* 334 */         ImageManager.playeru3, ImageManager.playeru4, upCount);
/* 335 */     a.animateEntity(g, (int)x, (int)y, ImageManager.playerd1, ImageManager.playerd2, 
/* 336 */         ImageManager.playerd3, ImageManager.playerd4, downCount);
/* 337 */     a.animateEntity(g, (int)x, (int)y, ImageManager.playerl1, ImageManager.playerl2, 
/* 338 */         ImageManager.playerl3, ImageManager.playerl4, leftCount);
/* 339 */     a.animateEntity(g, (int)x, (int)y, ImageManager.playerr1, ImageManager.playerr2, 
/* 340 */         ImageManager.playerr3, ImageManager.playerr4, rightCount);
/* 342 */     if (!movingUp && !movingDown && !movingLeft && !movingRight && 
/* 343 */       lastDir == 0)
/* 345 */       g.drawImage(ImageManager.playerd1, (int)x, (int)y, 32, 32, null); 
/* 348 */     if (!movingRight && lastDir == 2)
/* 349 */       g.drawImage(ImageManager.playerr1, (int)x, (int)y, 32, 32, null); 
/* 351 */     if (!movingLeft && lastDir == 4)
/* 352 */       g.drawImage(ImageManager.playerl1, (int)x, (int)y, 32, 32, null); 
/* 354 */     if (!movingUp && lastDir == 1)
/* 355 */       g.drawImage(ImageManager.playeru1, (int)x, (int)y, 32, 32, null); 
/* 357 */     if (!movingDown && lastDir == 3)
/* 358 */       g.drawImage(ImageManager.playerd1, (int)x, (int)y, 32, 32, null); 
/* 361 */     drawPlayerHUD(g);
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_6.jar!\beyondOrigins\main\entities\Player.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */