/*     */ package beyondOrigins.main.entities;
/*     */ 
/*     */ import beyondOrigins.main.Game;
/*     */ import beyondOrigins.main.gfx.ImageManager;
/*     */ import beyondOrigins.threads.Animate;
/*     */ import java.awt.Color;
/*     */ import java.awt.FontMetrics;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.image.BufferedImage;
/*     */ 
/*     */ public class Player {
/*  15 */   public static String name = "Roland";
/*     */   
/*  16 */   public static String defaultName = "Roland";
/*     */   
/*  17 */   public static String typedName = "";
/*     */   
/*  20 */   public static double maxHealth = 35.0D, health = 35.0D;
/*     */   
/*  23 */   public static double damage = 1.5D;
/*     */   
/*  24 */   public static byte attackRadius = 32;
/*     */   
/*  27 */   public static byte upCount = 1, downCount = 1, leftCount = 1;
/*     */   
/*  28 */   public static byte rightCount = 1;
/*     */   
/*  31 */   public static short level = 0;
/*     */   
/*  31 */   public static short exp = 0;
/*     */   
/*  31 */   public static short untilNextLvl = 0;
/*     */   
/*  31 */   public static short nextLvlAdd = 50;
/*     */   
/*     */   public static boolean canMoveUp = true, canMoveDown = true;
/*     */   
/*     */   public static boolean canMoveLeft = true;
/*     */   
/*     */   public static boolean canMoveRight = true;
/*     */   
/*  36 */   public static float x = 0.0F;
/*     */   
/*  36 */   public static float y = 0.0F;
/*     */   
/*     */   public static byte lastDir;
/*     */   
/*     */   public static byte catchingUp;
/*     */   
/*     */   public static boolean up = false;
/*     */   
/*     */   public static boolean down = false;
/*     */   
/*     */   public static boolean left = false;
/*     */   
/*     */   public static boolean right = false;
/*     */   
/*  43 */   public static double SPEED = 1.0D;
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
/*  48 */   public static short mbX = 1235;
/*     */   
/*  48 */   public static short mbY = 814;
/*     */   
/*  48 */   public static short pbX = 801;
/*     */   
/*  48 */   public static short pbY = 1;
/*     */   
/*     */   public static short tileX;
/*     */   
/*     */   public static short tileY;
/*     */   
/*     */   private ImageManager im;
/*     */   
/*     */   private ImageManager im2;
/*     */   
/*     */   private static Animate a;
/*     */   
/*     */   private static BufferedImage cf;
/*     */   
/*     */   private static FontMetrics fm;
/*     */   
/*     */   public Player(int x, int y, int mx, int my, ImageManager im, ImageManager im2) {
/*  61 */     Player.x = x;
/*  62 */     Player.y = y;
/*  63 */     mapX = mx;
/*  64 */     mapY = my;
/*  65 */     this.im = im;
/*  66 */     this.im2 = im2;
/*  67 */     a = new Animate();
/*     */   }
/*     */   
/*     */   public void tick() {
/*  72 */     tileX = (short)(((int)x + (int)mapX) / 32 - 12);
/*  73 */     tileY = (short)(((int)y + (int)mapY) / 32 - 8);
/*  76 */     if (mapX > mbX)
/*  77 */       mapX = mbX; 
/*  79 */     if (mapX < Game.playerSpawnX)
/*  80 */       mapX = Game.playerSpawnX; 
/*  82 */     if (mapY > mbY)
/*  83 */       mapY = mbY; 
/*  85 */     if (mapY < Game.playerSpawnY)
/*  86 */       mapY = Game.playerSpawnY; 
/*  88 */     if (x < 0.0F)
/*  89 */       x = 0.0F; 
/*  91 */     if (y < 0.0F)
/*  92 */       y = 0.0F; 
/*  96 */     if (mapMovement)
/*  97 */       mapMovement(); 
/*  99 */     if (insideMovement)
/* 100 */       insideMovement(); 
/*     */   }
/*     */   
/*     */   public static void attack() {
/* 105 */     if (Math.sqrt(((x - TestDummy.rx) * (x - TestDummy.rx) + (
/* 106 */         y - TestDummy.ry) * (y - TestDummy.ry))) <= attackRadius)
/* 107 */       TestDummy.health -= damage; 
/*     */   }
/*     */   
/*     */   private void drawPlayerHUD(Graphics g, ImageManager im, BufferedImage cf) {
/* 111 */     g.drawImage(im.pHUD, 5, 5, null);
/* 112 */     g.setFont(Game.playerHUDFont);
/* 113 */     g.setColor(Color.black);
/* 114 */     fm = g.getFontMetrics(Game.playerHUDFont);
/* 115 */     g.drawString(String.valueOf(name) + " | Lvl. " + level, 
/* 116 */         108 - fm.stringWidth(String.valueOf(name) + " | Lvl. " + level) / 2, 21);
/* 117 */     drawHealthBar(g);
/* 118 */     drawExpBar(g);
/* 119 */     g.drawImage(cf, 21, 21, null);
/*     */   }
/*     */   
/*     */   private void drawHealthBar(Graphics g) {
/* 123 */     fm = g.getFontMetrics(Game.pHUDBar);
/* 124 */     g.drawImage(this.im2.pHUDHealth, 69, 34, null);
/* 125 */     g.setFont(Game.pHUDBar);
/* 126 */     g.setColor(Color.white);
/* 127 */     g.drawString(String.valueOf(health), 
/* 128 */         108 - fm.stringWidth(String.valueOf(health)) / 2, 42);
/*     */   }
/*     */   
/*     */   private void drawExpBar(Graphics g) {
/* 132 */     fm = g.getFontMetrics(Game.pHUDBar);
/* 133 */     g.drawImage(this.im2.pHUDExp, 67, 50, null);
/* 134 */     g.setFont(Game.pHUDBar);
/* 135 */     g.setColor(Color.white);
/* 136 */     g.drawString(String.valueOf(exp), 
/* 137 */         108 - fm.stringWidth(String.valueOf(exp)) / 2, 58);
/*     */   }
/*     */   
/*     */   public void mapMovement() {
/* 142 */     if (up && y >= pbY && canMoveUp) {
/* 143 */       if (mapY <= Game.playerSpawnY && y >= 0.0F) {
/* 144 */         y = (float)(y - SPEED);
/* 145 */       } else if (catchingUp != 1 && y <= Game.playerSpawnY) {
/* 146 */         mapY = (float)(mapY - SPEED);
/*     */       } 
/* 148 */       upCount = (byte)(int)(upCount + SPEED);
/* 149 */       movingUp = true;
/* 150 */       lastDir = 1;
/* 151 */       if (upCount >= 42)
/* 152 */         upCount = 1; 
/*     */     } else {
/* 155 */       upCount = 0;
/* 156 */       movingUp = false;
/* 157 */       if (movingDown && y <= Game.playerSpawnY) {
/* 158 */         y = (float)(y + SPEED);
/* 159 */         catchingUp = 1;
/*     */       } else {
/* 161 */         catchingUp = 0;
/*     */       } 
/*     */     } 
/* 165 */     if (down && y <= 511.0F && canMoveDown) {
/* 166 */       if (mapY >= mbY && y < 513.0F) {
/* 167 */         y = (float)(y + SPEED);
/* 168 */       } else if (catchingUp != 3 && y >= Game.playerSpawnY && y < 513.0F) {
/* 169 */         mapY = (float)(mapY + SPEED);
/*     */       } 
/* 171 */       downCount = (byte)(int)(downCount + SPEED);
/* 172 */       movingDown = true;
/* 173 */       lastDir = 3;
/* 174 */       if (downCount >= 42)
/* 175 */         downCount = 1; 
/*     */     } else {
/* 178 */       downCount = 0;
/* 179 */       movingDown = false;
/* 180 */       if (movingUp && y >= Game.playerSpawnY) {
/* 181 */         y = (float)(y - SPEED);
/* 182 */         catchingUp = 3;
/*     */       } else {
/* 184 */         catchingUp = 0;
/*     */       } 
/*     */     } 
/* 188 */     if (left && x >= 0.0F && canMoveLeft) {
/* 189 */       if (mapX <= Game.playerSpawnX && x > 0.0F) {
/* 190 */         x = (float)(x - SPEED);
/* 191 */       } else if (catchingUp != 4 && x <= Game.playerSpawnX && x > 0.0F) {
/* 192 */         mapX = (float)(mapX - SPEED);
/*     */       } 
/* 194 */       leftCount = (byte)(int)(leftCount + SPEED);
/* 195 */       movingLeft = true;
/* 196 */       lastDir = 4;
/* 197 */       if (leftCount >= 42)
/* 198 */         leftCount = 1; 
/*     */     } else {
/* 201 */       leftCount = 0;
/* 202 */       movingLeft = false;
/* 203 */       if (movingRight && x <= Game.playerSpawnX) {
/* 204 */         x = (float)(x + SPEED);
/* 205 */         catchingUp = 4;
/*     */       } else {
/* 207 */         catchingUp = 0;
/*     */       } 
/*     */     } 
/* 211 */     if (right && x <= pbX && canMoveRight) {
/* 212 */       if (mapX >= mbX) {
/* 213 */         x = (float)(x + SPEED);
/* 214 */       } else if (catchingUp != 2 && x >= Game.playerSpawnX) {
/* 215 */         mapX = (float)(mapX + SPEED);
/*     */       } 
/* 217 */       rightCount = (byte)(int)(rightCount + SPEED);
/* 218 */       movingRight = true;
/* 219 */       lastDir = 2;
/* 220 */       if (rightCount >= 42)
/* 221 */         rightCount = 1; 
/*     */     } else {
/* 224 */       rightCount = 0;
/* 225 */       movingRight = false;
/* 226 */       if (movingLeft && x >= Game.playerSpawnX) {
/* 227 */         x = (float)(x - SPEED);
/* 228 */         catchingUp = 2;
/*     */       } else {
/* 230 */         catchingUp = 0;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void insideMovement() {
/* 236 */     if (up && y >= 125.0F && canMoveUp) {
/* 237 */       y = (float)(y - SPEED);
/* 238 */       upCount = (byte)(upCount + 1);
/* 239 */       movingUp = true;
/* 240 */       lastDir = 1;
/* 241 */       if (upCount == 42)
/* 242 */         upCount = 1; 
/*     */     } else {
/* 245 */       upCount = 0;
/* 246 */       movingUp = false;
/*     */     } 
/* 248 */     if (down && y <= 423.0F && canMoveDown) {
/* 249 */       y = (float)(y + SPEED);
/* 250 */       downCount = (byte)(downCount + 1);
/* 251 */       movingDown = true;
/* 252 */       lastDir = 3;
/* 253 */       if (downCount == 42)
/* 254 */         downCount = 1; 
/*     */     } else {
/* 257 */       downCount = 0;
/* 258 */       movingDown = false;
/*     */     } 
/* 260 */     if (left && x >= 194.0F && canMoveLeft) {
/* 261 */       x = (float)(x - SPEED);
/* 262 */       leftCount = (byte)(leftCount + 1);
/* 263 */       movingLeft = true;
/* 264 */       lastDir = 4;
/* 265 */       if (leftCount == 42)
/* 266 */         leftCount = 1; 
/*     */     } else {
/* 269 */       leftCount = 0;
/* 270 */       movingLeft = false;
/*     */     } 
/* 272 */     if (right && x <= 612.0F && canMoveRight) {
/* 273 */       x = (float)(x + SPEED);
/* 274 */       rightCount = (byte)(rightCount + 1);
/* 275 */       movingRight = true;
/* 276 */       lastDir = 2;
/* 277 */       if (rightCount == 42)
/* 278 */         rightCount = 1; 
/*     */     } else {
/* 281 */       rightCount = 0;
/* 282 */       movingRight = false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render(Graphics g) {
/* 288 */     a.animateEntity(g, (int)x, (int)y, this.im.playeru1, this.im.playeru2, 
/* 289 */         this.im.playeru3, this.im.playeru4, upCount);
/* 290 */     a.animateEntity(g, (int)x, (int)y, this.im.playerd1, this.im.playerd2, 
/* 291 */         this.im.playerd3, this.im.playerd4, downCount);
/* 292 */     a.animateEntity(g, (int)x, (int)y, this.im.playerl1, this.im.playerl2, 
/* 293 */         this.im.playerl3, this.im.playerl4, leftCount);
/* 294 */     a.animateEntity(g, (int)x, (int)y, this.im.playerr1, this.im.playerr2, 
/* 295 */         this.im.playerr3, this.im.playerr4, rightCount);
/* 297 */     cf = a.getCurrentFrame();
/* 299 */     if (!movingUp && !movingDown && !movingLeft && !movingRight && 
/* 300 */       lastDir == 0) {
/* 302 */       g.drawImage(this.im.playerd1, (int)x, (int)y, 32, 32, null);
/* 303 */       cf = this.im.playerd1;
/*     */     } 
/* 305 */     if (!movingRight && lastDir == 2) {
/* 306 */       g.drawImage(this.im.playerr1, (int)x, (int)y, 32, 32, null);
/* 307 */       cf = this.im.playerr1;
/*     */     } 
/* 309 */     if (!movingLeft && lastDir == 4) {
/* 310 */       g.drawImage(this.im.playerl1, (int)x, (int)y, 32, 32, null);
/* 311 */       cf = this.im.playerl1;
/*     */     } 
/* 313 */     if (!movingUp && lastDir == 1) {
/* 314 */       g.drawImage(this.im.playeru1, (int)x, (int)y, 32, 32, null);
/* 315 */       cf = this.im.playeru1;
/*     */     } 
/* 317 */     if (!movingDown && lastDir == 3) {
/* 318 */       g.drawImage(this.im.playerd1, (int)x, (int)y, 32, 32, null);
/* 319 */       cf = this.im.playerd1;
/*     */     } 
/* 322 */     drawPlayerHUD(g, this.im2, cf);
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_5.jar!\beyondOrigins\main\entities\Player.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */