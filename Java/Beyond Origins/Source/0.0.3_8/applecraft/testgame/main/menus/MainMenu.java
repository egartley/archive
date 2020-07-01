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
/*  14 */   Random r = new Random();
/*     */   
/*  15 */   private int r1 = this.r.nextInt(101);
/*     */   
/*  16 */   private int r2 = this.r.nextInt(101);
/*     */   
/*  17 */   private int r3 = this.r.nextInt(101);
/*     */   
/*  19 */   Color sky1 = new Color(86, 201, 255);
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
/*  28 */   private static int time = 0;
/*     */   
/*     */   public static boolean playButtonSelected = false;
/*     */   
/*  31 */   private static int playPressed = 0;
/*     */   
/*  33 */   private static double cspeed = 1.0D;
/*     */   
/*     */   private ImageManager im;
/*     */   
/*     */   public MainMenu(int x1, int y1, ImageManager im) {
/*  38 */     cloud1x = x1;
/*  39 */     cloud1y = y1;
/*  40 */     this.im = im;
/*     */   }
/*     */   
/*     */   public void tick() {
/*  45 */     if (!Game.gameRequested) {
/*  47 */       time++;
/*  49 */       if (time == 3)
/*  50 */         time = 0; 
/*  55 */       if (this.r1 >= 0 && this.r1 <= 33 && !cloud11) {
/*  56 */         cloud1x = 850;
/*  57 */         cloud1y = 160;
/*  58 */         cloud11 = true;
/*     */       } 
/*  61 */       if (this.r1 >= 34 && this.r1 <= 66 && !cloud12) {
/*  62 */         cloud1x = 850;
/*  63 */         cloud1y = 200;
/*  64 */         cloud12 = true;
/*     */       } 
/*  67 */       if (this.r1 >= 65 && this.r1 <= 100 && !cloud13) {
/*  68 */         cloud1x = 850;
/*  69 */         cloud1y = 220;
/*  70 */         cloud13 = true;
/*     */       } 
/*  73 */       if ((cloud11 || cloud12 || cloud13) && cloud1x > -150 && (
/*  74 */         time == 1 || time == 2)) {
/*  75 */         cloud1x -= (int)cspeed;
/*  76 */       } else if (cloud1x == -150 && (
/*  77 */         cloud1y == 160 || cloud1y == 200 || cloud1y == 220)) {
/*  78 */         cloud1x = 850;
/*  79 */         cloud1y = 160;
/*     */       } 
/*  83 */       if (this.r2 >= 0 && this.r2 <= 33 && !cloud21) {
/*  84 */         cloud2x = 990;
/*  85 */         cloud2y = 2;
/*  86 */         cloud21 = true;
/*     */       } 
/*  89 */       if (this.r2 >= 34 && this.r2 <= 66 && !cloud22) {
/*  90 */         cloud2x = 990;
/*  91 */         cloud2y = 22;
/*  92 */         cloud22 = true;
/*     */       } 
/*  95 */       if (this.r2 >= 65 && this.r2 <= 100 && !cloud23) {
/*  96 */         cloud2x = 990;
/*  97 */         cloud2y = 42;
/*  98 */         cloud23 = true;
/*     */       } 
/* 101 */       if ((cloud21 || cloud22 || cloud23) && cloud2x > -150 && 
/* 102 */         time == 1) {
/* 103 */         cloud2x -= (int)cspeed;
/* 104 */       } else if (cloud2x == -150 && (
/* 105 */         cloud2y == 2 || cloud2y == 22 || cloud2y == 42)) {
/* 106 */         cloud2x = 990;
/* 107 */         cloud2y = 20;
/*     */       } 
/* 111 */       if (this.r3 >= 0 && this.r3 <= 33 && !cloud31) {
/* 112 */         cloud3x = -149;
/* 113 */         cloud3y = 315;
/* 114 */         cloud31 = true;
/*     */       } 
/* 117 */       if (this.r3 >= 34 && this.r3 <= 66 && !cloud32) {
/* 118 */         cloud3x = -149;
/* 119 */         cloud3y = 340;
/* 120 */         cloud32 = true;
/*     */       } 
/* 123 */       if (this.r3 >= 65 && this.r3 <= 100 && !cloud33) {
/* 124 */         cloud3x = -149;
/* 125 */         cloud3y = 365;
/* 126 */         cloud33 = true;
/*     */       } 
/* 129 */       if ((cloud31 || cloud32 || cloud33) && cloud3x > -150 && 
/* 130 */         time == 1) {
/* 131 */         cloud3x += (int)cspeed;
/* 132 */       } else if (cloud3x == 828 && (
/* 133 */         cloud3y == 365 || cloud3y == 340 || cloud3y == 315)) {
/* 134 */         cloud3x = -149;
/* 135 */         cloud3y = 340;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render(Graphics g) {
/* 142 */     if (!Game.gameRequested) {
/* 144 */       g.setColor(this.sky1);
/* 145 */       g.fillRect(0, 0, 838, 1146);
/* 147 */       g.drawImage(this.im.cloud1, cloud1x, cloud1y, 128, 96, null);
/* 148 */       g.drawImage(this.im.cloud2, cloud2x, cloud2y, 128, 96, null);
/* 149 */       g.drawImage(this.im.cloud3, cloud3x, cloud3y, 128, 96, null);
/* 151 */       g.setColor(Color.white);
/* 152 */       g.setFont(Game.mminfo1);
/* 153 */       g.drawString(Game.title, 5, 535);
/* 154 */       g.drawString(Game.copyright, 700, 535);
/* 156 */       g.drawImage(this.im.playButton1, 334, 264, 160, 32, null);
/* 158 */       if (MouseMotion.mouseX >= 325 && MouseMotion.mouseX <= 491 && 
/* 159 */         MouseMotion.mouseY >= 248 && MouseMotion.mouseY <= 292) {
/* 160 */         g.drawImage(this.im.playButton2, 334, 264, 160, 32, null);
/* 161 */         playButtonSelected = true;
/*     */       } else {
/* 163 */         playButtonSelected = false;
/*     */       } 
/* 165 */       if (playButtonSelected && MouseManager.mouseFullClick == 1) {
/* 166 */         g.drawImage(this.im.playButton3, 334, 264, 160, 32, null);
/* 167 */         Game.gameRequested = true;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.3_8.jar!\applecraft\testgame\main\menus\MainMenu.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */