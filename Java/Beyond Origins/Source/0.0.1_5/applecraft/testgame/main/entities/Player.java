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
/*     */   private boolean pUP;
/*     */   
/*     */   private boolean pDOWN;
/*     */   
/*     */   private boolean pRIGHT;
/*     */   
/*     */   private boolean pLEFT;
/*     */   
/*     */   public static float playerx;
/*     */   
/*     */   public static float playery;
/*     */   
/*     */   public int tileX;
/*     */   
/*     */   public int tileY;
/*     */   
/*     */   private ImageManager im;
/*     */   
/*     */   public static boolean up = false;
/*     */   
/*     */   public static boolean down = false;
/*     */   
/*     */   public static boolean left = false;
/*     */   
/*     */   public static boolean right = false;
/*     */   
/*  25 */   public double SPEED = 1.5D;
/*     */   
/*     */   public static boolean f3menu = false;
/*     */   
/*  28 */   public static int f3menutoggle = 0;
/*     */   
/*     */   public Player(int x, int y, ImageManager im) {
/*  31 */     playerx = x;
/*  32 */     playery = y;
/*  33 */     this.im = im;
/*     */   }
/*     */   
/*     */   public void tick() {
/*  38 */     if (up && playery >= this.SPEED) {
/*  39 */       playery = (float)(playery - this.SPEED);
/*  40 */       this.upcount++;
/*  41 */       this.pUP = true;
/*  42 */       if (this.upcount == 42)
/*  43 */         this.upcount = 1; 
/*     */     } else {
/*  46 */       this.upcount = 0;
/*  47 */       this.pUP = false;
/*     */     } 
/*  50 */     if (down && playery != 512.0F) {
/*  51 */       playery = (float)(playery + this.SPEED);
/*  52 */       this.downcount++;
/*  53 */       this.pDOWN = true;
/*  54 */       if (this.downcount == 42)
/*  55 */         this.downcount = 1; 
/*     */     } else {
/*  58 */       this.downcount = 0;
/*  59 */       this.pDOWN = false;
/*     */     } 
/*  62 */     if (left && playerx >= 0.0F) {
/*  63 */       playerx = (float)(playerx - this.SPEED);
/*  64 */       this.leftcount++;
/*  65 */       this.pLEFT = true;
/*  66 */       if (this.leftcount == 42)
/*  67 */         this.leftcount = 1; 
/*     */     } else {
/*  70 */       this.leftcount = 0;
/*  71 */       this.pLEFT = false;
/*     */     } 
/*  74 */     if (right && playerx <= 800.0F) {
/*  75 */       playerx = (float)(playerx + this.SPEED);
/*  76 */       this.rightcount++;
/*  77 */       this.pRIGHT = true;
/*  78 */       if (this.rightcount == 42)
/*  79 */         this.rightcount = 1; 
/*     */     } else {
/*  82 */       this.rightcount = 0;
/*  83 */       this.pRIGHT = false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render(Graphics g) {
/*  99 */     if (this.downcount >= 1 && this.downcount <= 11)
/* 100 */       g.drawImage(this.im.playerd1, (int)playerx, (int)playery, 32, 32, null); 
/* 103 */     if (this.downcount >= 12 && this.downcount <= 21)
/* 104 */       g.drawImage(this.im.playerd2, (int)playerx, (int)playery, 32, 32, null); 
/* 107 */     if (this.downcount >= 22 && this.downcount <= 31)
/* 108 */       g.drawImage(this.im.playerd3, (int)playerx, (int)playery, 32, 32, null); 
/* 111 */     if (this.downcount >= 32 && this.downcount <= 41)
/* 112 */       g.drawImage(this.im.playerd4, (int)playerx, (int)playery, 32, 32, null); 
/* 121 */     if (this.upcount >= 1 && this.upcount <= 11)
/* 122 */       g.drawImage(this.im.playeru1, (int)playerx, (int)playery, 32, 32, null); 
/* 125 */     if (this.upcount >= 12 && this.upcount <= 21)
/* 126 */       g.drawImage(this.im.playeru2, (int)playerx, (int)playery, 32, 32, null); 
/* 129 */     if (this.upcount >= 22 && this.upcount <= 31)
/* 130 */       g.drawImage(this.im.playeru3, (int)playerx, (int)playery, 32, 32, null); 
/* 133 */     if (this.upcount >= 32 && this.upcount <= 41)
/* 134 */       g.drawImage(this.im.playeru4, (int)playerx, (int)playery, 32, 32, null); 
/* 143 */     if (this.leftcount >= 1 && this.leftcount <= 11)
/* 144 */       g.drawImage(this.im.playerl1, (int)playerx, (int)playery, 32, 32, null); 
/* 147 */     if (this.leftcount >= 12 && this.leftcount <= 21)
/* 148 */       g.drawImage(this.im.playerl2, (int)playerx, (int)playery, 32, 32, null); 
/* 151 */     if (this.leftcount >= 22 && this.leftcount <= 31)
/* 152 */       g.drawImage(this.im.playerl3, (int)playerx, (int)playery, 32, 32, null); 
/* 155 */     if (this.leftcount >= 32 && this.leftcount <= 41)
/* 156 */       g.drawImage(this.im.playerl4, (int)playerx, (int)playery, 32, 32, null); 
/* 165 */     if (this.rightcount >= 1 && this.rightcount <= 11)
/* 166 */       g.drawImage(this.im.playerr1, (int)playerx, (int)playery, 32, 32, null); 
/* 169 */     if (this.rightcount >= 12 && this.rightcount <= 21)
/* 170 */       g.drawImage(this.im.playerr2, (int)playerx, (int)playery, 32, 32, null); 
/* 173 */     if (this.rightcount >= 22 && this.rightcount <= 31)
/* 174 */       g.drawImage(this.im.playerr3, (int)playerx, (int)playery, 32, 32, null); 
/* 177 */     if (this.rightcount >= 32 && this.rightcount <= 41)
/* 178 */       g.drawImage(this.im.playerr4, (int)playerx, (int)playery, 32, 32, null); 
/* 185 */     if (!this.pUP && !this.pDOWN && !this.pLEFT && !this.pRIGHT)
/* 186 */       g.drawImage(this.im.playerd1, (int)playerx, (int)playery, 32, 32, null); 
/* 189 */     this.tileX = (int)playerx / 32;
/* 190 */     this.tileY = (int)playery / 32;
/* 192 */     if (f3menu) {
/* 193 */       g.drawString("Beyond Origins 0.0.1.4", 15, 25);
/* 194 */       g.drawString("Coded and Designed By: Evan Gartley", 15, 40);
/* 195 */       g.drawString("X: " + playerx, 15, 55);
/* 196 */       g.drawString("Y: " + playery, 15, 70);
/* 197 */       g.drawString("Tile X: " + this.tileX + " " + "Tile Y: " + this.tileY, 15, 85);
/* 198 */       g.drawString(" ", 15, 100);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.1_5.jar!\applecraft\testgame\main\entities\Player.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */