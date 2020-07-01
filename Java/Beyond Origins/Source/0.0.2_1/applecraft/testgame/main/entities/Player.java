/*     */ package applecraft.testgame.main.entities;
/*     */ 
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
/*     */   public static float playerx;
/*     */   
/*     */   public static float playery;
/*     */   
/*     */   public static int tileX;
/*     */   
/*     */   public static int tileY;
/*     */   
/*     */   private ImageManager im;
/*     */   
/*  21 */   private static int lastDir = 0;
/*     */   
/*     */   public static boolean up = false;
/*     */   
/*     */   public static boolean down = false;
/*     */   
/*     */   public static boolean left = false;
/*     */   
/*     */   public static boolean right = false;
/*     */   
/*  28 */   public double SPEED = 1.0D;
/*     */   
/*  29 */   public static int speedToggle = 0;
/*     */   
/*     */   public Player(int x, int y, ImageManager im) {
/*  32 */     playerx = x;
/*  33 */     playery = y;
/*  34 */     this.im = im;
/*     */   }
/*     */   
/*     */   public void tick() {
/*  39 */     tileX = (int)playerx / 32;
/*  40 */     tileY = (int)playery / 32;
/*  46 */     if (up) {
/*  47 */       playery = (float)(playery - this.SPEED);
/*  48 */       this.upcount++;
/*  49 */       pUP = true;
/*  50 */       lastDir = 1;
/*  51 */       if (this.upcount == 42)
/*  52 */         this.upcount = 1; 
/*     */     } else {
/*  55 */       this.upcount = 0;
/*  56 */       pUP = false;
/*     */     } 
/*  59 */     if (down) {
/*  60 */       playery = (float)(playery + this.SPEED);
/*  61 */       this.downcount++;
/*  62 */       pDOWN = true;
/*  63 */       lastDir = 3;
/*  64 */       if (this.downcount == 42)
/*  65 */         this.downcount = 1; 
/*     */     } else {
/*  68 */       this.downcount = 0;
/*  69 */       pDOWN = false;
/*     */     } 
/*  72 */     if (left) {
/*  73 */       playerx = (float)(playerx - this.SPEED);
/*  74 */       this.leftcount++;
/*  75 */       pLEFT = true;
/*  76 */       lastDir = 4;
/*  77 */       if (this.leftcount == 42)
/*  78 */         this.leftcount = 1; 
/*     */     } else {
/*  81 */       this.leftcount = 0;
/*  82 */       pLEFT = false;
/*     */     } 
/*  85 */     if (right) {
/*  86 */       playerx = (float)(playerx + this.SPEED);
/*  87 */       this.rightcount++;
/*  88 */       pRIGHT = true;
/*  89 */       lastDir = 2;
/*  90 */       if (this.rightcount == 42)
/*  91 */         this.rightcount = 1; 
/*     */     } else {
/*  94 */       this.rightcount = 0;
/*  95 */       pRIGHT = false;
/*     */     } 
/*  98 */     if (speedToggle == 1)
/*  99 */       this.SPEED = 1.0D; 
/* 102 */     if (speedToggle == 2)
/* 103 */       this.SPEED = 2.0D; 
/* 106 */     if (speedToggle == 3)
/* 107 */       this.SPEED = 3.0D; 
/*     */   }
/*     */   
/*     */   public void render(Graphics g) {
/* 123 */     if (this.downcount >= 1 && this.downcount <= 11)
/* 124 */       g.drawImage(this.im.playerd1, (int)playerx, (int)playery, 32, 32, null); 
/* 127 */     if (this.downcount >= 12 && this.downcount <= 21)
/* 128 */       g.drawImage(this.im.playerd2, (int)playerx, (int)playery, 32, 32, null); 
/* 131 */     if (this.downcount >= 22 && this.downcount <= 31)
/* 132 */       g.drawImage(this.im.playerd3, (int)playerx, (int)playery, 32, 32, null); 
/* 135 */     if (this.downcount >= 32 && this.downcount <= 41)
/* 136 */       g.drawImage(this.im.playerd4, (int)playerx, (int)playery, 32, 32, null); 
/* 145 */     if (this.upcount >= 1 && this.upcount <= 11)
/* 146 */       g.drawImage(this.im.playeru1, (int)playerx, (int)playery, 32, 32, null); 
/* 149 */     if (this.upcount >= 12 && this.upcount <= 21)
/* 150 */       g.drawImage(this.im.playeru2, (int)playerx, (int)playery, 32, 32, null); 
/* 153 */     if (this.upcount >= 22 && this.upcount <= 31)
/* 154 */       g.drawImage(this.im.playeru3, (int)playerx, (int)playery, 32, 32, null); 
/* 157 */     if (this.upcount >= 32 && this.upcount <= 41)
/* 158 */       g.drawImage(this.im.playeru4, (int)playerx, (int)playery, 32, 32, null); 
/* 167 */     if (this.leftcount >= 1 && this.leftcount <= 11)
/* 168 */       g.drawImage(this.im.playerl1, (int)playerx, (int)playery, 32, 32, null); 
/* 171 */     if (this.leftcount >= 12 && this.leftcount <= 21)
/* 172 */       g.drawImage(this.im.playerl2, (int)playerx, (int)playery, 32, 32, null); 
/* 175 */     if (this.leftcount >= 22 && this.leftcount <= 31)
/* 176 */       g.drawImage(this.im.playerl3, (int)playerx, (int)playery, 32, 32, null); 
/* 179 */     if (this.leftcount >= 32 && this.leftcount <= 41)
/* 180 */       g.drawImage(this.im.playerl4, (int)playerx, (int)playery, 32, 32, null); 
/* 189 */     if (this.rightcount >= 1 && this.rightcount <= 11)
/* 190 */       g.drawImage(this.im.playerr1, (int)playerx, (int)playery, 32, 32, null); 
/* 193 */     if (this.rightcount >= 12 && this.rightcount <= 21)
/* 194 */       g.drawImage(this.im.playerr2, (int)playerx, (int)playery, 32, 32, null); 
/* 197 */     if (this.rightcount >= 22 && this.rightcount <= 31)
/* 198 */       g.drawImage(this.im.playerr3, (int)playerx, (int)playery, 32, 32, null); 
/* 201 */     if (this.rightcount >= 32 && this.rightcount <= 41)
/* 202 */       g.drawImage(this.im.playerr4, (int)playerx, (int)playery, 32, 32, null); 
/* 209 */     if (!pUP && !pDOWN && !pLEFT && !pRIGHT && lastDir == 0)
/* 210 */       g.drawImage(this.im.playerd1, (int)playerx, (int)playery, 32, 32, null); 
/* 213 */     if (!pRIGHT && lastDir == 2)
/* 214 */       g.drawImage(this.im.playerr1, (int)playerx, (int)playery, 32, 32, null); 
/* 217 */     if (!pLEFT && lastDir == 4)
/* 218 */       g.drawImage(this.im.playerl1, (int)playerx, (int)playery, 32, 32, null); 
/* 221 */     if (!pUP && lastDir == 1)
/* 222 */       g.drawImage(this.im.playeru1, (int)playerx, (int)playery, 32, 32, null); 
/* 225 */     if (!pDOWN && lastDir == 3)
/* 226 */       g.drawImage(this.im.playerd1, (int)playerx, (int)playery, 32, 32, null); 
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.2_1.jar!\applecraft\testgame\main\entities\Player.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */