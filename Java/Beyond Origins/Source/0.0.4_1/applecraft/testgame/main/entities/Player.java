/*     */ package applecraft.testgame.main.entities;
/*     */ 
/*     */ import applecraft.testgame.main.Game;
/*     */ import applecraft.testgame.main.gfx.ImageManager;
/*     */ import java.awt.Graphics;
/*     */ 
/*     */ public class Player {
/*  10 */   private int downCount = 1;
/*     */   
/*  10 */   private int upCount = 1;
/*     */   
/*  10 */   private int leftCount = 1;
/*     */   
/*  10 */   private int rightCount = 1;
/*     */   
/*     */   public static boolean pUP;
/*     */   
/*     */   public static boolean pDOWN;
/*     */   
/*     */   public static boolean pRIGHT;
/*     */   
/*     */   public static boolean pLEFT;
/*     */   
/*  13 */   public static float playerX = 0.0F;
/*     */   
/*  14 */   public static float playerY = 0.0F;
/*     */   
/*     */   public static float mapX;
/*     */   
/*     */   public static float mapY;
/*     */   
/*     */   public static int tileX;
/*     */   
/*     */   public static int tileY;
/*     */   
/*     */   private ImageManager im;
/*     */   
/*  24 */   private static int lastDir = 0;
/*     */   
/*  25 */   public static int catchingUp = 0;
/*     */   
/*     */   public static boolean up = false;
/*     */   
/*     */   public static boolean down = false;
/*     */   
/*     */   public static boolean left = false;
/*     */   
/*     */   public static boolean right = false;
/*     */   
/*  32 */   public static double SPEED = 1.0D;
/*     */   
/*  33 */   public static int speedToggle = 0;
/*     */   
/*     */   public Player(int x, int y, int mx, int my, ImageManager im) {
/*  36 */     playerX = x;
/*  37 */     playerY = y;
/*  38 */     mapX = mx;
/*  39 */     mapY = my;
/*  40 */     this.im = im;
/*     */   }
/*     */   
/*     */   public void tick() {
/*  45 */     tileX = ((int)playerX + 0 + (int)mapX) / 32 - 12;
/*  46 */     tileY = ((int)playerY + 0 + (int)mapY) / 32 - 8;
/*  50 */     if (up && playerY >= 1.0F) {
/*  52 */       if (mapY <= 263.0F) {
/*  53 */         playerY = (float)(playerY - SPEED);
/*  54 */       } else if (catchingUp != 1 && 
/*  55 */         playerY <= Game.playerSpawnY) {
/*  56 */         mapY = (float)(mapY - SPEED);
/*     */       } 
/*  59 */       this.upCount++;
/*  60 */       pUP = true;
/*  61 */       lastDir = 1;
/*  63 */       if (this.upCount == 42)
/*  64 */         this.upCount = 1; 
/*     */     } else {
/*  67 */       this.upCount = 0;
/*  68 */       pUP = false;
/*  70 */       if (pDOWN && playerY <= Game.playerSpawnY) {
/*  71 */         playerY = (float)(playerY + SPEED);
/*  72 */         catchingUp = 1;
/*     */       } else {
/*  74 */         catchingUp = 0;
/*     */       } 
/*     */     } 
/*  79 */     if (down && playerY <= 511.0F) {
/*  81 */       if (mapY >= 775.0F) {
/*  82 */         playerY = (float)(playerY + SPEED);
/*  83 */       } else if (catchingUp != 3 && 
/*  84 */         playerY >= Game.playerSpawnY) {
/*  85 */         mapY = (float)(mapY + SPEED);
/*     */       } 
/*  88 */       this.downCount++;
/*  89 */       pDOWN = true;
/*  90 */       lastDir = 3;
/*  92 */       if (this.downCount == 42)
/*  93 */         this.downCount = 1; 
/*     */     } else {
/*  96 */       this.downCount = 0;
/*  97 */       pDOWN = false;
/*  99 */       if (pUP && playerY >= Game.playerSpawnY) {
/* 100 */         playerY = (float)(playerY - SPEED);
/* 101 */         catchingUp = 3;
/*     */       } else {
/* 103 */         catchingUp = 0;
/*     */       } 
/*     */     } 
/* 108 */     if (left && playerX >= 0.0F) {
/* 110 */       if (mapX <= 398.0F) {
/* 111 */         playerX = (float)(playerX - SPEED);
/* 112 */       } else if (catchingUp != 4 && 
/* 113 */         playerX <= Game.playerSpawnX) {
/* 114 */         mapX = (float)(mapX - SPEED);
/*     */       } 
/* 117 */       this.leftCount++;
/* 118 */       pLEFT = true;
/* 119 */       lastDir = 4;
/* 121 */       if (this.leftCount == 42)
/* 122 */         this.leftCount = 1; 
/*     */     } else {
/* 126 */       this.leftCount = 0;
/* 127 */       pLEFT = false;
/* 129 */       if (pRIGHT && playerX <= Game.playerSpawnX) {
/* 130 */         playerX = (float)(playerX + SPEED);
/* 131 */         catchingUp = 4;
/*     */       } else {
/* 133 */         catchingUp = 0;
/*     */       } 
/*     */     } 
/* 138 */     if (right && playerX <= 801.0F) {
/* 140 */       if (mapX >= 1198.0F) {
/* 141 */         playerX = (float)(playerX + SPEED);
/* 142 */       } else if (catchingUp != 2 && 
/* 143 */         playerX >= Game.playerSpawnX) {
/* 144 */         mapX = (float)(mapX + SPEED);
/*     */       } 
/* 147 */       this.rightCount++;
/* 148 */       pRIGHT = true;
/* 149 */       lastDir = 2;
/* 151 */       if (this.rightCount == 42)
/* 152 */         this.rightCount = 1; 
/*     */     } else {
/* 155 */       this.rightCount = 0;
/* 156 */       pRIGHT = false;
/* 158 */       if (pLEFT && playerX >= Game.playerSpawnX) {
/* 159 */         playerX = (float)(playerX - SPEED);
/* 160 */         catchingUp = 2;
/*     */       } else {
/* 162 */         catchingUp = 0;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render(Graphics g) {
/* 176 */     if (this.downCount >= 1 && this.downCount <= 11)
/* 177 */       g.drawImage(this.im.playerd1, (int)playerX, (int)playerY, 
/* 178 */           32, 32, null); 
/* 181 */     if (this.downCount >= 12 && this.downCount <= 21)
/* 182 */       g.drawImage(this.im.playerd2, (int)playerX, (int)playerY, 
/* 183 */           32, 32, null); 
/* 186 */     if (this.downCount >= 22 && this.downCount <= 31)
/* 187 */       g.drawImage(this.im.playerd3, (int)playerX, (int)playerY, 
/* 188 */           32, 32, null); 
/* 191 */     if (this.downCount >= 32 && this.downCount <= 41)
/* 192 */       g.drawImage(this.im.playerd4, (int)playerX, (int)playerY, 
/* 193 */           32, 32, null); 
/* 202 */     if (this.upCount >= 1 && this.upCount <= 11)
/* 203 */       g.drawImage(this.im.playeru1, (int)playerX, (int)playerY, 
/* 204 */           32, 32, null); 
/* 207 */     if (this.upCount >= 12 && this.upCount <= 21)
/* 208 */       g.drawImage(this.im.playeru2, (int)playerX, (int)playerY, 
/* 209 */           32, 32, null); 
/* 212 */     if (this.upCount >= 22 && this.upCount <= 31)
/* 213 */       g.drawImage(this.im.playeru3, (int)playerX, (int)playerY, 
/* 214 */           32, 32, null); 
/* 217 */     if (this.upCount >= 32 && this.upCount <= 41)
/* 218 */       g.drawImage(this.im.playeru4, (int)playerX, (int)playerY, 
/* 219 */           32, 32, null); 
/* 228 */     if (this.leftCount >= 1 && this.leftCount <= 11)
/* 229 */       g.drawImage(this.im.playerl1, (int)playerX, (int)playerY, 
/* 230 */           32, 32, null); 
/* 233 */     if (this.leftCount >= 12 && this.leftCount <= 21)
/* 234 */       g.drawImage(this.im.playerl2, (int)playerX, (int)playerY, 
/* 235 */           32, 32, null); 
/* 238 */     if (this.leftCount >= 22 && this.leftCount <= 31)
/* 239 */       g.drawImage(this.im.playerl3, (int)playerX, (int)playerY, 
/* 240 */           32, 32, null); 
/* 243 */     if (this.leftCount >= 32 && this.leftCount <= 41)
/* 244 */       g.drawImage(this.im.playerl4, (int)playerX, (int)playerY, 
/* 245 */           32, 32, null); 
/* 254 */     if (this.rightCount >= 1 && this.rightCount <= 11)
/* 255 */       g.drawImage(this.im.playerr1, (int)playerX, (int)playerY, 
/* 256 */           32, 32, null); 
/* 259 */     if (this.rightCount >= 12 && this.rightCount <= 21)
/* 260 */       g.drawImage(this.im.playerr2, (int)playerX, (int)playerY, 
/* 261 */           32, 32, null); 
/* 264 */     if (this.rightCount >= 22 && this.rightCount <= 31)
/* 265 */       g.drawImage(this.im.playerr3, (int)playerX, (int)playerY, 
/* 266 */           32, 32, null); 
/* 269 */     if (this.rightCount >= 32 && this.rightCount <= 41)
/* 270 */       g.drawImage(this.im.playerr4, (int)playerX, (int)playerY, 
/* 271 */           32, 32, null); 
/* 278 */     if (!pUP && !pDOWN && !pLEFT && !pRIGHT && 
/* 279 */       lastDir == 0)
/* 280 */       g.drawImage(this.im.playerd1, (int)playerX, (int)playerY, 
/* 281 */           32, 32, null); 
/* 284 */     if (!pRIGHT && lastDir == 2)
/* 285 */       g.drawImage(this.im.playerr1, (int)playerX, (int)playerY, 
/* 286 */           32, 32, null); 
/* 289 */     if (!pLEFT && lastDir == 4)
/* 290 */       g.drawImage(this.im.playerl1, (int)playerX, (int)playerY, 
/* 291 */           32, 32, null); 
/* 294 */     if (!pUP && lastDir == 1)
/* 295 */       g.drawImage(this.im.playeru1, (int)playerX, (int)playerY, 
/* 296 */           32, 32, null); 
/* 299 */     if (!pDOWN && lastDir == 3)
/* 300 */       g.drawImage(this.im.playerd1, (int)playerX, (int)playerY, 
/* 301 */           32, 32, null); 
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4_1.jar!\applecraft\testgame\main\entities\Player.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */