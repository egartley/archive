/*     */ package applecraft.testgame.main.entities;
/*     */ 
/*     */ import applecraft.testgame.main.Game;
/*     */ import applecraft.testgame.main.gfx.ImageManager;
/*     */ import java.awt.Graphics;
/*     */ 
/*     */ public class Player {
/*  10 */   private int downcount = 0;
/*     */   
/*  10 */   private int upcount = 1;
/*     */   
/*  10 */   private int leftcount = 1;
/*     */   
/*  10 */   private int rightcount = 1;
/*     */   
/*     */   public static boolean pUP;
/*     */   
/*     */   public static boolean pDOWN;
/*     */   
/*     */   public static boolean pRIGHT;
/*     */   
/*     */   public static boolean pLEFT;
/*     */   
/*     */   public static float playerX;
/*     */   
/*     */   public static float playerY;
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
/*  45 */     tileX = ((int)playerX + 1 + (int)mapX) / 32 - 12;
/*  46 */     tileY = ((int)playerY + (int)mapY) / 32 - 7;
/*  50 */     if (up && playerY >= 0.0F) {
/*  52 */       if (mapY <= 263.0F) {
/*  53 */         playerY = (float)(playerY - SPEED);
/*  54 */       } else if (catchingUp != 1 && 
/*  55 */         playerY <= Game.playerSpawnY) {
/*  56 */         mapY = (float)(mapY - SPEED);
/*     */       } 
/*  59 */       this.upcount++;
/*  60 */       pUP = true;
/*  61 */       lastDir = 1;
/*  63 */       if (this.upcount == 42)
/*  64 */         this.upcount = 1; 
/*     */     } else {
/*  67 */       this.upcount = 0;
/*  68 */       pUP = false;
/*  70 */       if (pDOWN && playerY <= Game.playerSpawnY) {
/*  71 */         playerY = (float)(playerY + SPEED);
/*  72 */         catchingUp = 1;
/*     */       } else {
/*  74 */         catchingUp = 0;
/*     */       } 
/*     */     } 
/*  79 */     if (down && playerY <= 504.0F) {
/*  81 */       if (mapY >= 775.0F) {
/*  82 */         playerY = (float)(playerY + SPEED);
/*  83 */       } else if (catchingUp != 3 && 
/*  84 */         playerY >= Game.playerSpawnY) {
/*  85 */         mapY = (float)(mapY + SPEED);
/*     */       } 
/*  88 */       this.downcount++;
/*  89 */       pDOWN = true;
/*  90 */       lastDir = 3;
/*  92 */       if (this.downcount == 42)
/*  93 */         this.downcount = 1; 
/*     */     } else {
/*  96 */       this.downcount = 0;
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
/* 117 */       this.leftcount++;
/* 118 */       pLEFT = true;
/* 119 */       lastDir = 4;
/* 121 */       if (this.leftcount == 42)
/* 122 */         this.leftcount = 1; 
/*     */     } else {
/* 125 */       this.leftcount = 0;
/* 126 */       pLEFT = false;
/* 128 */       if (pRIGHT && playerX <= Game.playerSpawnX) {
/* 129 */         playerX = (float)(playerX + SPEED);
/* 130 */         catchingUp = 4;
/*     */       } else {
/* 132 */         catchingUp = 0;
/*     */       } 
/*     */     } 
/* 137 */     if (right && playerX <= 795.0F) {
/* 139 */       if (mapX >= 1198.0F) {
/* 140 */         playerX = (float)(playerX + SPEED);
/* 141 */       } else if (catchingUp != 2 && 
/* 142 */         playerX >= Game.playerSpawnX) {
/* 143 */         mapX = (float)(mapX + SPEED);
/*     */       } 
/* 146 */       this.rightcount++;
/* 147 */       pRIGHT = true;
/* 148 */       lastDir = 2;
/* 150 */       if (this.rightcount == 42)
/* 151 */         this.rightcount = 1; 
/*     */     } else {
/* 154 */       this.rightcount = 0;
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
/* 175 */     if (this.downcount >= 1 && this.downcount <= 11)
/* 176 */       g.drawImage(this.im.playerd1, (int)playerX, (int)playerY, 
/* 177 */           32, 32, null); 
/* 180 */     if (this.downcount >= 12 && this.downcount <= 21)
/* 181 */       g.drawImage(this.im.playerd2, (int)playerX, (int)playerY, 
/* 182 */           32, 32, null); 
/* 185 */     if (this.downcount >= 22 && this.downcount <= 31)
/* 186 */       g.drawImage(this.im.playerd3, (int)playerX, (int)playerY, 
/* 187 */           32, 32, null); 
/* 190 */     if (this.downcount >= 32 && this.downcount <= 41)
/* 191 */       g.drawImage(this.im.playerd4, (int)playerX, (int)playerY, 
/* 192 */           32, 32, null); 
/* 201 */     if (this.upcount >= 1 && this.upcount <= 11)
/* 202 */       g.drawImage(this.im.playeru1, (int)playerX, (int)playerY, 
/* 203 */           32, 32, null); 
/* 206 */     if (this.upcount >= 12 && this.upcount <= 21)
/* 207 */       g.drawImage(this.im.playeru2, (int)playerX, (int)playerY, 
/* 208 */           32, 32, null); 
/* 211 */     if (this.upcount >= 22 && this.upcount <= 31)
/* 212 */       g.drawImage(this.im.playeru3, (int)playerX, (int)playerY, 
/* 213 */           32, 32, null); 
/* 216 */     if (this.upcount >= 32 && this.upcount <= 41)
/* 217 */       g.drawImage(this.im.playeru4, (int)playerX, (int)playerY, 
/* 218 */           32, 32, null); 
/* 227 */     if (this.leftcount >= 1 && this.leftcount <= 11)
/* 228 */       g.drawImage(this.im.playerl1, (int)playerX, (int)playerY, 
/* 229 */           32, 32, null); 
/* 232 */     if (this.leftcount >= 12 && this.leftcount <= 21)
/* 233 */       g.drawImage(this.im.playerl2, (int)playerX, (int)playerY, 
/* 234 */           32, 32, null); 
/* 237 */     if (this.leftcount >= 22 && this.leftcount <= 31)
/* 238 */       g.drawImage(this.im.playerl3, (int)playerX, (int)playerY, 
/* 239 */           32, 32, null); 
/* 242 */     if (this.leftcount >= 32 && this.leftcount <= 41)
/* 243 */       g.drawImage(this.im.playerl4, (int)playerX, (int)playerY, 
/* 244 */           32, 32, null); 
/* 253 */     if (this.rightcount >= 1 && this.rightcount <= 11)
/* 254 */       g.drawImage(this.im.playerr1, (int)playerX, (int)playerY, 
/* 255 */           32, 32, null); 
/* 258 */     if (this.rightcount >= 12 && this.rightcount <= 21)
/* 259 */       g.drawImage(this.im.playerr2, (int)playerX, (int)playerY, 
/* 260 */           32, 32, null); 
/* 263 */     if (this.rightcount >= 22 && this.rightcount <= 31)
/* 264 */       g.drawImage(this.im.playerr3, (int)playerX, (int)playerY, 
/* 265 */           32, 32, null); 
/* 268 */     if (this.rightcount >= 32 && this.rightcount <= 41)
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


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.2_8.jar!\applecraft\testgame\main\entities\Player.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */