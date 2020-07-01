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
/*     */   public static boolean up = false;
/*     */   
/*     */   public static boolean down = false;
/*     */   
/*     */   public static boolean left = false;
/*     */   
/*     */   public static boolean right = false;
/*     */   
/*  31 */   public double SPEED = 1.0D;
/*     */   
/*  32 */   public static int speedToggle = 0;
/*     */   
/*     */   public Player(int x, int y, int mx, int my, ImageManager im) {
/*  35 */     playerX = x;
/*  36 */     playerY = y;
/*  37 */     mapX = mx;
/*  38 */     mapY = my;
/*  39 */     this.im = im;
/*     */   }
/*     */   
/*     */   public void tick() {
/*  44 */     tileX = ((int)playerX + (int)mapX) / 32 - 12;
/*  45 */     tileY = ((int)playerY + (int)mapY + 3) / 32 - 7;
/*  47 */     if (up && playerY >= 7.0F) {
/*  49 */       if (mapY <= 263.0F) {
/*  50 */         playerY = (float)(playerY - this.SPEED);
/*     */       } else {
/*  52 */         mapY = (float)(mapY - this.SPEED);
/*     */       } 
/*  54 */       this.upcount++;
/*  55 */       pUP = true;
/*  56 */       lastDir = 1;
/*  58 */       if (this.upcount == 42)
/*  59 */         this.upcount = 1; 
/*     */     } else {
/*  62 */       this.upcount = 0;
/*  63 */       pUP = false;
/*  65 */       if (pDOWN && playerY <= Game.PlayerSpawnY)
/*  66 */         playerY = (float)(playerY + this.SPEED); 
/*     */     } 
/*  70 */     if (down) {
/*  72 */       if (mapY >= 775.0F) {
/*  73 */         playerY = (float)(playerY + this.SPEED);
/*     */       } else {
/*  75 */         mapY = (float)(mapY + this.SPEED);
/*     */       } 
/*  77 */       this.downcount++;
/*  78 */       pDOWN = true;
/*  79 */       lastDir = 3;
/*  81 */       if (this.downcount == 42)
/*  82 */         this.downcount = 1; 
/*     */     } else {
/*  85 */       this.downcount = 0;
/*  86 */       pDOWN = false;
/*  88 */       if (pUP && playerY >= Game.PlayerSpawnY)
/*  89 */         playerY = (float)(playerY - this.SPEED); 
/*     */     } 
/*  93 */     if (left && playerX >= 7.0F) {
/*  95 */       if (mapX <= 398.0F) {
/*  96 */         playerX = (float)(playerX - this.SPEED);
/*     */       } else {
/*  98 */         mapX = (float)(mapX - this.SPEED);
/*     */       } 
/* 100 */       this.leftcount++;
/* 101 */       pLEFT = true;
/* 102 */       lastDir = 4;
/* 104 */       if (this.leftcount == 42)
/* 105 */         this.leftcount = 1; 
/*     */     } else {
/* 108 */       this.leftcount = 0;
/* 109 */       pLEFT = false;
/* 111 */       if (pRIGHT && playerX <= Game.PlayerSpawnX)
/* 112 */         playerX = (float)(playerX + this.SPEED); 
/*     */     } 
/* 116 */     if (right) {
/* 118 */       if (mapX >= 1198.0F) {
/* 119 */         playerX = (float)(playerX + this.SPEED);
/*     */       } else {
/* 121 */         mapX = (float)(mapX + this.SPEED);
/*     */       } 
/* 123 */       this.rightcount++;
/* 124 */       pRIGHT = true;
/* 125 */       lastDir = 2;
/* 127 */       if (this.rightcount == 42)
/* 128 */         this.rightcount = 1; 
/*     */     } else {
/* 131 */       this.rightcount = 0;
/* 132 */       pRIGHT = false;
/* 134 */       if (pLEFT && playerX >= Game.PlayerSpawnX)
/* 135 */         playerX = (float)(playerX - this.SPEED); 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render(Graphics g) {
/* 146 */     if (this.downcount >= 1 && this.downcount <= 11)
/* 147 */       g.drawImage(this.im.playerd1, (int)playerX, (int)playerY, 32, 32, null); 
/* 150 */     if (this.downcount >= 12 && this.downcount <= 21)
/* 151 */       g.drawImage(this.im.playerd2, (int)playerX, (int)playerY, 32, 32, null); 
/* 154 */     if (this.downcount >= 22 && this.downcount <= 31)
/* 155 */       g.drawImage(this.im.playerd3, (int)playerX, (int)playerY, 32, 32, null); 
/* 158 */     if (this.downcount >= 32 && this.downcount <= 41)
/* 159 */       g.drawImage(this.im.playerd4, (int)playerX, (int)playerY, 32, 32, null); 
/* 168 */     if (this.upcount >= 1 && this.upcount <= 11)
/* 169 */       g.drawImage(this.im.playeru1, (int)playerX, (int)playerY, 32, 32, null); 
/* 172 */     if (this.upcount >= 12 && this.upcount <= 21)
/* 173 */       g.drawImage(this.im.playeru2, (int)playerX, (int)playerY, 32, 32, null); 
/* 176 */     if (this.upcount >= 22 && this.upcount <= 31)
/* 177 */       g.drawImage(this.im.playeru3, (int)playerX, (int)playerY, 32, 32, null); 
/* 180 */     if (this.upcount >= 32 && this.upcount <= 41)
/* 181 */       g.drawImage(this.im.playeru4, (int)playerX, (int)playerY, 32, 32, null); 
/* 190 */     if (this.leftcount >= 1 && this.leftcount <= 11)
/* 191 */       g.drawImage(this.im.playerl1, (int)playerX, (int)playerY, 32, 32, null); 
/* 194 */     if (this.leftcount >= 12 && this.leftcount <= 21)
/* 195 */       g.drawImage(this.im.playerl2, (int)playerX, (int)playerY, 32, 32, null); 
/* 198 */     if (this.leftcount >= 22 && this.leftcount <= 31)
/* 199 */       g.drawImage(this.im.playerl3, (int)playerX, (int)playerY, 32, 32, null); 
/* 202 */     if (this.leftcount >= 32 && this.leftcount <= 41)
/* 203 */       g.drawImage(this.im.playerl4, (int)playerX, (int)playerY, 32, 32, null); 
/* 212 */     if (this.rightcount >= 1 && this.rightcount <= 11)
/* 213 */       g.drawImage(this.im.playerr1, (int)playerX, (int)playerY, 32, 32, null); 
/* 216 */     if (this.rightcount >= 12 && this.rightcount <= 21)
/* 217 */       g.drawImage(this.im.playerr2, (int)playerX, (int)playerY, 32, 32, null); 
/* 220 */     if (this.rightcount >= 22 && this.rightcount <= 31)
/* 221 */       g.drawImage(this.im.playerr3, (int)playerX, (int)playerY, 32, 32, null); 
/* 224 */     if (this.rightcount >= 32 && this.rightcount <= 41)
/* 225 */       g.drawImage(this.im.playerr4, (int)playerX, (int)playerY, 32, 32, null); 
/* 232 */     if (!pUP && !pDOWN && !pLEFT && !pRIGHT && lastDir == 0)
/* 233 */       g.drawImage(this.im.playerd1, (int)playerX, (int)playerY, 32, 32, null); 
/* 236 */     if (!pRIGHT && lastDir == 2)
/* 237 */       g.drawImage(this.im.playerr1, (int)playerX, (int)playerY, 32, 32, null); 
/* 240 */     if (!pLEFT && lastDir == 4)
/* 241 */       g.drawImage(this.im.playerl1, (int)playerX, (int)playerY, 32, 32, null); 
/* 244 */     if (!pUP && lastDir == 1)
/* 245 */       g.drawImage(this.im.playeru1, (int)playerX, (int)playerY, 32, 32, null); 
/* 248 */     if (!pDOWN && lastDir == 3)
/* 249 */       g.drawImage(this.im.playerd1, (int)playerX, (int)playerY, 32, 32, null); 
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.2_7.jar!\applecraft\testgame\main\entities\Player.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */