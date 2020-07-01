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
/*     */   private int x;
/*     */   
/*     */   private int y;
/*     */   
/*     */   private ImageManager im;
/*     */   
/*     */   public boolean up = false;
/*     */   
/*     */   public boolean down = false;
/*     */   
/*     */   public boolean left = false;
/*     */   
/*     */   public boolean right = false;
/*     */   
/*  16 */   public static int SPEED = 1;
/*     */   
/*     */   public Player(int x, int y, ImageManager im) {
/*  19 */     this.x = x;
/*  20 */     this.y = y;
/*  21 */     this.im = im;
/*     */   }
/*     */   
/*     */   public void tick() {
/*  26 */     SPEED = 1;
/*  28 */     if (this.up && this.y >= SPEED) {
/*  29 */       this.y -= SPEED;
/*  30 */       this.upcount++;
/*  31 */       this.pUP = true;
/*  32 */       if (this.upcount == 42)
/*  33 */         this.upcount = 1; 
/*     */     } else {
/*  36 */       this.upcount = 0;
/*  37 */       this.pUP = false;
/*     */     } 
/*  40 */     if (this.down && this.y != 512) {
/*  41 */       this.y += SPEED;
/*  42 */       this.downcount++;
/*  43 */       this.pDOWN = true;
/*  44 */       if (this.downcount == 42)
/*  45 */         this.downcount = 1; 
/*     */     } else {
/*  48 */       this.downcount = 0;
/*  49 */       this.pDOWN = false;
/*     */     } 
/*  52 */     if (this.left && this.x >= SPEED) {
/*  53 */       this.x -= SPEED;
/*  54 */       this.leftcount++;
/*  55 */       this.pLEFT = true;
/*  56 */       if (this.leftcount == 42)
/*  57 */         this.leftcount = 1; 
/*     */     } else {
/*  60 */       this.leftcount = 0;
/*  61 */       this.pLEFT = false;
/*     */     } 
/*  64 */     if (this.right && this.x != 802) {
/*  65 */       this.x += SPEED;
/*  66 */       this.rightcount++;
/*  67 */       this.pRIGHT = true;
/*  68 */       if (this.rightcount == 42)
/*  69 */         this.rightcount = 1; 
/*     */     } else {
/*  72 */       this.rightcount = 0;
/*  73 */       this.pRIGHT = false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render(Graphics g) {
/*  86 */     if (this.downcount >= 1 && this.downcount <= 11)
/*  87 */       g.drawImage(this.im.playerd1, this.x, this.y, 32, 32, null); 
/*  90 */     if (this.downcount >= 12 && this.downcount <= 21)
/*  91 */       g.drawImage(this.im.playerd2, this.x, this.y, 32, 32, null); 
/*  94 */     if (this.downcount >= 22 && this.downcount <= 31)
/*  95 */       g.drawImage(this.im.playerd3, this.x, this.y, 32, 32, null); 
/*  98 */     if (this.downcount >= 32 && this.downcount <= 41)
/*  99 */       g.drawImage(this.im.playerd4, this.x, this.y, 32, 32, null); 
/* 108 */     if (this.upcount >= 1 && this.upcount <= 11)
/* 109 */       g.drawImage(this.im.playeru1, this.x, this.y, 32, 32, null); 
/* 112 */     if (this.upcount >= 12 && this.upcount <= 21)
/* 113 */       g.drawImage(this.im.playeru2, this.x, this.y, 32, 32, null); 
/* 116 */     if (this.upcount >= 22 && this.upcount <= 31)
/* 117 */       g.drawImage(this.im.playeru3, this.x, this.y, 32, 32, null); 
/* 120 */     if (this.upcount >= 32 && this.upcount <= 41)
/* 121 */       g.drawImage(this.im.playeru4, this.x, this.y, 32, 32, null); 
/* 130 */     if (this.leftcount >= 1 && this.leftcount <= 11)
/* 131 */       g.drawImage(this.im.playerl1, this.x, this.y, 32, 32, null); 
/* 134 */     if (this.leftcount >= 12 && this.leftcount <= 21)
/* 135 */       g.drawImage(this.im.playerl2, this.x, this.y, 32, 32, null); 
/* 138 */     if (this.leftcount >= 22 && this.leftcount <= 31)
/* 139 */       g.drawImage(this.im.playerl3, this.x, this.y, 32, 32, null); 
/* 142 */     if (this.leftcount >= 32 && this.leftcount <= 41)
/* 143 */       g.drawImage(this.im.playerl4, this.x, this.y, 32, 32, null); 
/* 152 */     if (this.rightcount >= 1 && this.rightcount <= 11)
/* 153 */       g.drawImage(this.im.playerr1, this.x, this.y, 32, 32, null); 
/* 156 */     if (this.rightcount >= 12 && this.rightcount <= 21)
/* 157 */       g.drawImage(this.im.playerr2, this.x, this.y, 32, 32, null); 
/* 160 */     if (this.rightcount >= 22 && this.rightcount <= 31)
/* 161 */       g.drawImage(this.im.playerr3, this.x, this.y, 32, 32, null); 
/* 164 */     if (this.rightcount >= 32 && this.rightcount <= 41)
/* 165 */       g.drawImage(this.im.playerr4, this.x, this.y, 32, 32, null); 
/* 172 */     if (!this.pUP && !this.pDOWN && !this.pLEFT && !this.pRIGHT)
/* 173 */       g.drawImage(this.im.playerd1, this.x, this.y, 32, 32, null); 
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.1.jar!\applecraft\testgame\main\entities\Player.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */