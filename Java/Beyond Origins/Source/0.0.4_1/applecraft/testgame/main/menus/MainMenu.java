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
/*  54 */       if (this.r1 >= 0 && this.r1 <= 33 && !cloud11) {
/*  55 */         cloud1x = 850;
/*  56 */         cloud1y = 160;
/*  57 */         cloud11 = true;
/*     */       } 
/*  60 */       if (this.r1 >= 34 && this.r1 <= 66 && !cloud12) {
/*  61 */         cloud1x = 850;
/*  62 */         cloud1y = 200;
/*  63 */         cloud12 = true;
/*     */       } 
/*  66 */       if (this.r1 >= 65 && this.r1 <= 100 && !cloud13) {
/*  67 */         cloud1x = 850;
/*  68 */         cloud1y = 220;
/*  69 */         cloud13 = true;
/*     */       } 
/*  72 */       if ((cloud11 || cloud12 || cloud13) && cloud1x > -150 && (
/*  73 */         time == 1 || time == 2)) {
/*  74 */         cloud1x -= (int)cspeed;
/*  75 */       } else if (cloud1x == -150 && (
/*  76 */         cloud1y == 160 || cloud1y == 200 || cloud1y == 220)) {
/*  77 */         cloud1x = 850;
/*  78 */         cloud1y = 160;
/*     */       } 
/*  82 */       if (this.r2 >= 0 && this.r2 <= 33 && !cloud21) {
/*  83 */         cloud2x = 990;
/*  84 */         cloud2y = 2;
/*  85 */         cloud21 = true;
/*     */       } 
/*  88 */       if (this.r2 >= 34 && this.r2 <= 66 && !cloud22) {
/*  89 */         cloud2x = 990;
/*  90 */         cloud2y = 22;
/*  91 */         cloud22 = true;
/*     */       } 
/*  94 */       if (this.r2 >= 65 && this.r2 <= 100 && !cloud23) {
/*  95 */         cloud2x = 990;
/*  96 */         cloud2y = 42;
/*  97 */         cloud23 = true;
/*     */       } 
/* 100 */       if ((cloud21 || cloud22 || cloud23) && cloud2x > -150 && 
/* 101 */         time == 1) {
/* 102 */         cloud2x -= (int)cspeed;
/* 103 */       } else if (cloud2x == -150 && (
/* 104 */         cloud2y == 2 || cloud2y == 22 || cloud2y == 42)) {
/* 105 */         cloud2x = 990;
/* 106 */         cloud2y = 20;
/*     */       } 
/* 110 */       if (this.r3 >= 0 && this.r3 <= 33 && !cloud31) {
/* 111 */         cloud3x = -149;
/* 112 */         cloud3y = 315;
/* 113 */         cloud31 = true;
/*     */       } 
/* 116 */       if (this.r3 >= 34 && this.r3 <= 66 && !cloud32) {
/* 117 */         cloud3x = -149;
/* 118 */         cloud3y = 340;
/* 119 */         cloud32 = true;
/*     */       } 
/* 122 */       if (this.r3 >= 65 && this.r3 <= 100 && !cloud33) {
/* 123 */         cloud3x = -149;
/* 124 */         cloud3y = 365;
/* 125 */         cloud33 = true;
/*     */       } 
/* 128 */       if ((cloud31 || cloud32 || cloud33) && cloud3x > -150 && 
/* 129 */         time == 1) {
/* 130 */         cloud3x += (int)cspeed;
/* 131 */       } else if (cloud3x == 828 && (
/* 132 */         cloud3y == 365 || cloud3y == 340 || cloud3y == 315)) {
/* 133 */         cloud3x = -149;
/* 134 */         cloud3y = 340;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render(Graphics g) {
/* 141 */     if (!Game.gameRequested) {
/* 143 */       g.setColor(this.sky1);
/* 144 */       g.fillRect(0, 0, 838, 1146);
/* 146 */       g.drawImage(this.im.cloud1, cloud1x, cloud1y, 128, 96, null);
/* 147 */       g.drawImage(this.im.cloud2, cloud2x, cloud2y, 128, 96, null);
/* 148 */       g.drawImage(this.im.cloud3, cloud3x, cloud3y, 128, 96, null);
/* 150 */       g.setColor(Color.white);
/* 151 */       g.setFont(Game.mminfo1);
/* 152 */       g.drawString(Game.title, 5, 535);
/* 153 */       g.drawString(Game.copyright, 550, 535);
/* 155 */       g.drawImage(this.im.playButton1, 334, 264, 160, 32, null);
/* 157 */       if (MouseMotion.mouseX >= 325 && MouseMotion.mouseX <= 491 && 
/* 158 */         MouseMotion.mouseY >= 248 && MouseMotion.mouseY <= 292) {
/* 159 */         g.drawImage(this.im.playButton2, 334, 264, 160, 32, null);
/* 160 */         playButtonSelected = true;
/*     */       } else {
/* 162 */         playButtonSelected = false;
/*     */       } 
/* 164 */       if (playButtonSelected && MouseManager.mouseFullClick == 1) {
/* 165 */         g.drawImage(this.im.playButton3, 334, 264, 160, 32, null);
/* 166 */         Game.gameRequested = true;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4_1.jar!\applecraft\testgame\main\menus\MainMenu.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */