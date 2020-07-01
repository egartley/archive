/*     */ package applecraft.testgame.main.menus;
/*     */ 
/*     */ import applecraft.testgame.main.Game;
/*     */ import applecraft.testgame.main.MouseManager;
/*     */ import applecraft.testgame.main.MouseMotion;
/*     */ import applecraft.testgame.main.gfx.ImageManager;
/*     */ import java.awt.Color;
/*     */ import java.awt.Graphics;
/*     */ import java.util.Random;
/*     */ 
/*     */ public class MainMenu {
/*  16 */   Random r = new Random();
/*     */   
/*  17 */   private int r1 = this.r.nextInt(101);
/*     */   
/*  18 */   private int r2 = this.r.nextInt(101);
/*     */   
/*  19 */   private int r3 = this.r.nextInt(101);
/*     */   
/*  21 */   Color sky1 = new Color(86, 201, 255);
/*     */   
/*     */   public static int cloud1x;
/*     */   
/*     */   public static int cloud1y;
/*     */   
/*     */   public static int cloud2x;
/*     */   
/*     */   public static int cloud2y;
/*     */   
/*     */   public static int cloud3x;
/*     */   
/*     */   public static int cloud3y;
/*     */   
/*     */   private static boolean cloud11;
/*     */   
/*     */   private static boolean cloud12;
/*     */   
/*     */   private static boolean cloud13;
/*     */   
/*     */   private static boolean cloud21;
/*     */   
/*     */   private static boolean cloud22;
/*     */   
/*     */   private static boolean cloud23;
/*     */   
/*     */   private static boolean cloud31;
/*     */   
/*     */   private static boolean cloud32;
/*     */   
/*     */   private static boolean cloud33;
/*     */   
/*  30 */   private static int time = 0;
/*     */   
/*     */   public static boolean playButtonSelected = false;
/*     */   
/*  33 */   private static int playPressed = 0;
/*     */   
/*  35 */   private static double cspeed = 1.0D;
/*     */   
/*     */   private ImageManager im;
/*     */   
/*     */   public MainMenu(int x1, int y1, ImageManager im) {
/*  40 */     cloud1x = x1;
/*  41 */     cloud1y = y1;
/*  42 */     this.im = im;
/*     */   }
/*     */   
/*     */   public void tick() {
/*  47 */     if (!Game.gameRequested) {
/*  49 */       time++;
/*  51 */       if (time == 3)
/*  52 */         time = 0; 
/*  56 */       if (this.r1 >= 0 && this.r1 <= 33 && !cloud11) {
/*  57 */         cloud1x = 850;
/*  58 */         cloud1y = 160;
/*  59 */         cloud11 = true;
/*     */       } 
/*  62 */       if (this.r1 >= 34 && this.r1 <= 66 && !cloud12) {
/*  63 */         cloud1x = 850;
/*  64 */         cloud1y = 200;
/*  65 */         cloud12 = true;
/*     */       } 
/*  68 */       if (this.r1 >= 65 && this.r1 <= 100 && !cloud13) {
/*  69 */         cloud1x = 850;
/*  70 */         cloud1y = 220;
/*  71 */         cloud13 = true;
/*     */       } 
/*  74 */       if ((cloud11 || cloud12 || cloud13) && cloud1x > -150 && (
/*  75 */         time == 1 || time == 2)) {
/*  76 */         cloud1x -= (int)cspeed;
/*  77 */       } else if (cloud1x == -150 && (
/*  78 */         cloud1y == 160 || cloud1y == 200 || cloud1y == 220)) {
/*  79 */         cloud1x = 850;
/*  80 */         cloud1y = 160;
/*     */       } 
/*  84 */       if (this.r2 >= 0 && this.r2 <= 33 && !cloud21) {
/*  85 */         cloud2x = 990;
/*  86 */         cloud2y = 2;
/*  87 */         cloud21 = true;
/*     */       } 
/*  90 */       if (this.r2 >= 34 && this.r2 <= 66 && !cloud22) {
/*  91 */         cloud2x = 990;
/*  92 */         cloud2y = 22;
/*  93 */         cloud22 = true;
/*     */       } 
/*  96 */       if (this.r2 >= 65 && this.r2 <= 100 && !cloud23) {
/*  97 */         cloud2x = 990;
/*  98 */         cloud2y = 42;
/*  99 */         cloud23 = true;
/*     */       } 
/* 102 */       if ((cloud21 || cloud22 || cloud23) && cloud2x > -150 && 
/* 103 */         time == 1) {
/* 104 */         cloud2x -= (int)cspeed;
/* 105 */       } else if (cloud2x == -150 && (
/* 106 */         cloud2y == 2 || cloud2y == 22 || cloud2y == 42)) {
/* 107 */         cloud2x = 990;
/* 108 */         cloud2y = 20;
/*     */       } 
/* 112 */       if (this.r3 >= 0 && this.r3 <= 33 && !cloud31) {
/* 113 */         cloud3x = -149;
/* 114 */         cloud3y = 315;
/* 115 */         cloud31 = true;
/*     */       } 
/* 118 */       if (this.r3 >= 34 && this.r3 <= 66 && !cloud32) {
/* 119 */         cloud3x = -149;
/* 120 */         cloud3y = 340;
/* 121 */         cloud32 = true;
/*     */       } 
/* 124 */       if (this.r3 >= 65 && this.r3 <= 100 && !cloud33) {
/* 125 */         cloud3x = -149;
/* 126 */         cloud3y = 365;
/* 127 */         cloud33 = true;
/*     */       } 
/* 130 */       if ((cloud31 || cloud32 || cloud33) && cloud3x > -150 && 
/* 131 */         time == 1) {
/* 132 */         cloud3x += (int)cspeed;
/* 133 */       } else if (cloud3x == 828 && (
/* 134 */         cloud3y == 365 || cloud3y == 340 || cloud3y == 315)) {
/* 135 */         cloud3x = -149;
/* 136 */         cloud3y = 340;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render(Graphics g) {
/* 143 */     if (!Game.gameRequested) {
/* 145 */       g.setColor(this.sky1);
/* 146 */       g.fillRect(0, 0, 838, 1146);
/* 148 */       g.drawImage(this.im.cloud1, cloud1x, cloud1y, 128, 96, null);
/* 149 */       g.drawImage(this.im.cloud2, cloud2x, cloud2y, 128, 96, null);
/* 150 */       g.drawImage(this.im.cloud3, cloud3x, cloud3y, 128, 96, null);
/* 152 */       g.setColor(Color.white);
/* 153 */       g.setFont(Game.mminfo1);
/* 154 */       g.drawString(Game.title, 5, 535);
/* 155 */       g.drawString(Game.author, 730, 535);
/* 157 */       g.drawImage(this.im.playButton1, 334, 264, 160, 32, null);
/* 159 */       if (MouseMotion.mouseX >= 325 && MouseMotion.mouseX <= 491 && 
/* 160 */         MouseMotion.mouseY >= 248 && MouseMotion.mouseY <= 292) {
/* 161 */         g.drawImage(this.im.playButton2, 334, 264, 160, 32, null);
/* 162 */         playButtonSelected = true;
/*     */       } else {
/* 164 */         playButtonSelected = false;
/*     */       } 
/* 166 */       if (playButtonSelected && MouseManager.mouseFullClick == 1) {
/* 167 */         g.drawImage(this.im.playButton3, 334, 264, 160, 32, null);
/* 168 */         Game.gameRequested = true;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.3_4.jar!\applecraft\testgame\main\menus\MainMenu.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */