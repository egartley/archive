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
/* 125 */       this.leftCount = 0;
/* 126 */       pLEFT = false;
/* 128 */       if (pRIGHT && playerX <= Game.playerSpawnX) {
/* 129 */         playerX = (float)(playerX + SPEED);
/* 130 */         catchingUp = 4;
/*     */       } else {
/* 132 */         catchingUp = 0;
/*     */       } 
/*     */     } 
/* 137 */     if (right && playerX <= 801.0F) {
/* 139 */       if (mapX >= 1198.0F) {
/* 140 */         playerX = (float)(playerX + SPEED);
/* 141 */       } else if (catchingUp != 2 && 
/* 142 */         playerX >= Game.playerSpawnX) {
/* 143 */         mapX = (float)(mapX + SPEED);
/*     */       } 
/* 146 */       this.rightCount++;
/* 147 */       pRIGHT = true;
/* 148 */       lastDir = 2;
/* 150 */       if (this.rightCount == 42)
/* 151 */         this.rightCount = 1; 
/*     */     } else {
/* 154 */       this.rightCount = 0;
/* 155 */       pRIGHT = false;
/* 157 */       if (pLEFT && playerX >= Game.playerSpawnX) {
/* 158 */         playerX = (float)(playerX - SPEED);
/* 159 */         catchingUp = 2;
/*     */       } else {
/* 161 */         catchingUp = 0;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render(Graphics g) {
/* 175 */     if (this.downCount >= 1 && this.downCount <= 11)
/* 176 */       g.drawImage(this.im.playerd1, (int)playerX, (int)playerY, 
/* 177 */           32, 32, null); 
/* 180 */     if (this.downCount >= 12 && this.downCount <= 21)
/* 181 */       g.drawImage(this.im.playerd2, (int)playerX, (int)playerY, 
/* 182 */           32, 32, null); 
/* 185 */     if (this.downCount >= 22 && this.downCount <= 31)
/* 186 */       g.drawImage(this.im.playerd3, (int)playerX, (int)playerY, 
/* 187 */           32, 32, null); 
/* 190 */     if (this.downCount >= 32 && this.downCount <= 41)
/* 191 */       g.drawImage(this.im.playerd4, (int)playerX, (int)playerY, 
/* 192 */           32, 32, null); 
/* 201 */     if (this.upCount >= 1 && this.upCount <= 11)
/* 202 */       g.drawImage(this.im.playeru1, (int)playerX, (int)playerY, 
/* 203 */           32, 32, null); 
/* 206 */     if (this.upCount >= 12 && this.upCount <= 21)
/* 207 */       g.drawImage(this.im.playeru2, (int)playerX, (int)playerY, 
/* 208 */           32, 32, null); 
/* 211 */     if (this.upCount >= 22 && this.upCount <= 31)
/* 212 */       g.drawImage(this.im.playeru3, (int)playerX, (int)playerY, 
/* 213 */           32, 32, null); 
/* 216 */     if (this.upCount >= 32 && this.upCount <= 41)
/* 217 */       g.drawImage(this.im.playeru4, (int)playerX, (int)playerY, 
/* 218 */           32, 32, null); 
/* 227 */     if (this.leftCount >= 1 && this.leftCount <= 11)
/* 228 */       g.drawImage(this.im.playerl1, (int)playerX, (int)playerY, 
/* 229 */           32, 32, null); 
/* 232 */     if (this.leftCount >= 12 && this.leftCount <= 21)
/* 233 */       g.drawImage(this.im.playerl2, (int)playerX, (int)playerY, 
/* 234 */           32, 32, null); 
/* 237 */     if (this.leftCount >= 22 && this.leftCount <= 31)
/* 238 */       g.drawImage(this.im.playerl3, (int)playerX, (int)playerY, 
/* 239 */           32, 32, null); 
/* 242 */     if (this.leftCount >= 32 && this.leftCount <= 41)
/* 243 */       g.drawImage(this.im.playerl4, (int)playerX, (int)playerY, 
/* 244 */           32, 32, null); 
/* 253 */     if (this.rightCount >= 1 && this.rightCount <= 11)
/* 254 */       g.drawImage(this.im.playerr1, (int)playerX, (int)playerY, 
/* 255 */           32, 32, null); 
/* 258 */     if (this.rightCount >= 12 && this.rightCount <= 21)
/* 259 */       g.drawImage(this.im.playerr2, (int)playerX, (int)playerY, 
/* 260 */           32, 32, null); 
/* 263 */     if (this.rightCount >= 22 && this.rightCount <= 31)
/* 264 */       g.drawImage(this.im.playerr3, (int)playerX, (int)playerY, 
/* 265 */           32, 32, null); 
/* 268 */     if (this.rightCount >= 32 && this.rightCount <= 41)
/* 269 */       g.drawImage(this.im.playerr4, (int)playerX, (int)playerY, 
/* 270 */           32, 32, null); 
/* 277 */     if (!pUP && !pDOWN && !pLEFT && !pRIGHT && 
/* 278 */       lastDir == 0)
/* 279 */       g.drawImage(this.im.playerd1, (int)playerX, (int)playerY, 
/* 280 */           32, 32, null); 
/* 283 */     if (!pRIGHT && lastDir == 2)
/* 284 */       g.drawImage(this.im.playerr1, (int)playerX, (int)playerY, 
/* 285 */           32, 32, null); 
/* 288 */     if (!pLEFT && lastDir == 4)
/* 289 */       g.drawImage(this.im.playerl1, (int)playerX, (int)playerY, 
/* 290 */           32, 32, null); 
/* 293 */     if (!pUP && lastDir == 1)
/* 294 */       g.drawImage(this.im.playeru1, (int)playerX, (int)playerY, 
/* 295 */           32, 32, null); 
/* 298 */     if (!pDOWN && lastDir == 3)
/* 299 */       g.drawImage(this.im.playerd1, (int)playerX, (int)playerY, 
/* 300 */           32, 32, null); 
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.3_8.jar!\applecraft\testgame\main\entities\Player.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */