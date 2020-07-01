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
/*     */   private float x;
/*     */   
/*     */   private float y;
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
/*  19 */   public double SPEED = 1.5D;
/*     */   
/*     */   public boolean f3menu = false;
/*     */   
/*  21 */   public static int f3menutoggle = 0;
/*     */   
/*     */   public Player(int x, int y, ImageManager im) {
/*  24 */     this.x = x;
/*  25 */     this.y = y;
/*  26 */     this.im = im;
/*     */   }
/*     */   
/*     */   public void tick() {
/*  31 */     if (up && this.y >= this.SPEED) {
/*  32 */       this.y = (float)(this.y - this.SPEED);
/*  33 */       this.upcount++;
/*  34 */       this.pUP = true;
/*  35 */       if (this.upcount == 42)
/*  36 */         this.upcount = 1; 
/*     */     } else {
/*  39 */       this.upcount = 0;
/*  40 */       this.pUP = false;
/*     */     } 
/*  43 */     if (down && this.y != 512.0F) {
/*  44 */       this.y = (float)(this.y + this.SPEED);
/*  45 */       this.downcount++;
/*  46 */       this.pDOWN = true;
/*  47 */       if (this.downcount == 42)
/*  48 */         this.downcount = 1; 
/*     */     } else {
/*  51 */       this.downcount = 0;
/*  52 */       this.pDOWN = false;
/*     */     } 
/*  55 */     if (left && this.x >= 0.0F) {
/*  56 */       this.x = (float)(this.x - this.SPEED);
/*  57 */       this.leftcount++;
/*  58 */       this.pLEFT = true;
/*  59 */       if (this.leftcount == 42)
/*  60 */         this.leftcount = 1; 
/*     */     } else {
/*  63 */       this.leftcount = 0;
/*  64 */       this.pLEFT = false;
/*     */     } 
/*  67 */     if (right && this.x <= 800.0F) {
/*  68 */       this.x = (float)(this.x + this.SPEED);
/*  69 */       this.rightcount++;
/*  70 */       this.pRIGHT = true;
/*  71 */       if (this.rightcount == 42)
/*  72 */         this.rightcount = 1; 
/*     */     } else {
/*  75 */       this.rightcount = 0;
/*  76 */       this.pRIGHT = false;
/*     */     } 
/*  83 */     int tileX = (int)this.x / 32;
/*  84 */     int tileY = (int)this.y / 32;
/*     */   }
/*     */   
/*     */   public void render(Graphics g) {
/*  97 */     if (this.downcount >= 1 && this.downcount <= 11)
/*  98 */       g.drawImage(this.im.playerd1, (int)this.x, (int)this.y, 32, 32, null); 
/* 101 */     if (this.downcount >= 12 && this.downcount <= 21)
/* 102 */       g.drawImage(this.im.playerd2, (int)this.x, (int)this.y, 32, 32, null); 
/* 105 */     if (this.downcount >= 22 && this.downcount <= 31)
/* 106 */       g.drawImage(this.im.playerd3, (int)this.x, (int)this.y, 32, 32, null); 
/* 109 */     if (this.downcount >= 32 && this.downcount <= 41)
/* 110 */       g.drawImage(this.im.playerd4, (int)this.x, (int)this.y, 32, 32, null); 
/* 119 */     if (this.upcount >= 1 && this.upcount <= 11)
/* 120 */       g.drawImage(this.im.playeru1, (int)this.x, (int)this.y, 32, 32, null); 
/* 123 */     if (this.upcount >= 12 && this.upcount <= 21)
/* 124 */       g.drawImage(this.im.playeru2, (int)this.x, (int)this.y, 32, 32, null); 
/* 127 */     if (this.upcount >= 22 && this.upcount <= 31)
/* 128 */       g.drawImage(this.im.playeru3, (int)this.x, (int)this.y, 32, 32, null); 
/* 131 */     if (this.upcount >= 32 && this.upcount <= 41)
/* 132 */       g.drawImage(this.im.playeru4, (int)this.x, (int)this.y, 32, 32, null); 
/* 141 */     if (this.leftcount >= 1 && this.leftcount <= 11)
/* 142 */       g.drawImage(this.im.playerl1, (int)this.x, (int)this.y, 32, 32, null); 
/* 145 */     if (this.leftcount >= 12 && this.leftcount <= 21)
/* 146 */       g.drawImage(this.im.playerl2, (int)this.x, (int)this.y, 32, 32, null); 
/* 149 */     if (this.leftcount >= 22 && this.leftcount <= 31)
/* 150 */       g.drawImage(this.im.playerl3, (int)this.x, (int)this.y, 32, 32, null); 
/* 153 */     if (this.leftcount >= 32 && this.leftcount <= 41)
/* 154 */       g.drawImage(this.im.playerl4, (int)this.x, (int)this.y, 32, 32, null); 
/* 163 */     if (this.rightcount >= 1 && this.rightcount <= 11)
/* 164 */       g.drawImage(this.im.playerr1, (int)this.x, (int)this.y, 32, 32, null); 
/* 167 */     if (this.rightcount >= 12 && this.rightcount <= 21)
/* 168 */       g.drawImage(this.im.playerr2, (int)this.x, (int)this.y, 32, 32, null); 
/* 171 */     if (this.rightcount >= 22 && this.rightcount <= 31)
/* 172 */       g.drawImage(this.im.playerr3, (int)this.x, (int)this.y, 32, 32, null); 
/* 175 */     if (this.rightcount >= 32 && this.rightcount <= 41)
/* 176 */       g.drawImage(this.im.playerr4, (int)this.x, (int)this.y, 32, 32, null); 
/* 183 */     if (!this.pUP && !this.pDOWN && !this.pLEFT && !this.pRIGHT)
/* 184 */       g.drawImage(this.im.playerd1, (int)this.x, (int)this.y, 32, 32, null); 
/* 188 */     if (this.f3menu) {
/* 189 */       g.drawString("Beyond Origins 0.0.1.4", 15, 25);
/* 190 */       g.drawString("Made By: Evan Gartley", 15, 40);
/* 191 */       g.drawString("X: " + this.x, 15, 55);
/* 192 */       g.drawString("Y: " + this.y, 15, 70);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.1_4.jar!\applecraft\testgame\main\entities\Player.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */