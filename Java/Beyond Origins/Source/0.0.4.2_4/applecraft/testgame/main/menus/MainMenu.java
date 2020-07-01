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
/*  14 */   static Random r = new Random();
/*     */   
/*     */   private static int r1;
/*     */   
/*     */   private static int r2;
/*     */   
/*     */   private static int r3;
/*     */   
/*  19 */   Color sky1 = new Color(86, 201, 255);
/*     */   
/*     */   public static double cloud1x;
/*     */   
/*     */   public static double cloud1y;
/*     */   
/*     */   public static double cloud2x;
/*     */   
/*     */   public static double cloud2y;
/*     */   
/*     */   public static double cloud3x;
/*     */   
/*     */   public static double cloud3y;
/*     */   
/*  24 */   private static int cloud1Position = 0;
/*     */   
/*  25 */   private static int cloud2Position = 0;
/*     */   
/*  26 */   private static int cloud3Position = 0;
/*     */   
/*     */   public static boolean playButtonSelected = false;
/*     */   
/*  30 */   private static double cSpeed = 0.5D;
/*     */   
/*     */   private ImageManager im;
/*     */   
/*     */   public MainMenu(double x1, double y1, ImageManager im) {
/*  35 */     cloud1x = x1;
/*  36 */     cloud1y = y1;
/*  37 */     this.im = im;
/*     */   }
/*     */   
/*     */   public static void init() {
/*  42 */     r1 = r.nextInt(3);
/*  43 */     r2 = r.nextInt(3);
/*  44 */     r3 = r.nextInt(3);
/*  47 */     if (r1 == 0) {
/*  48 */       cloud1x = 850.0D;
/*  49 */       cloud1y = 160.0D;
/*  50 */       cloud1Position = 1;
/*  51 */     } else if (r1 == 1) {
/*  52 */       cloud1x = 850.0D;
/*  53 */       cloud1y = 200.0D;
/*  54 */       cloud1Position = 2;
/*  55 */     } else if (r1 == 2) {
/*  56 */       cloud1x = 850.0D;
/*  57 */       cloud1y = 220.0D;
/*  58 */       cloud1Position = 3;
/*     */     } 
/*  62 */     if (r2 == 0) {
/*  63 */       cloud2x = 990.0D;
/*  64 */       cloud2y = 2.0D;
/*  65 */       cloud2Position = 1;
/*  66 */     } else if (r2 == 1) {
/*  67 */       cloud2x = 990.0D;
/*  68 */       cloud2y = 22.0D;
/*  69 */       cloud2Position = 2;
/*  70 */     } else if (r2 == 2) {
/*  71 */       cloud2x = 990.0D;
/*  72 */       cloud2y = 42.0D;
/*  73 */       cloud2Position = 3;
/*     */     } 
/*  77 */     if (r3 == 0) {
/*  78 */       cloud3x = -150.0D;
/*  79 */       cloud3y = 315.0D;
/*  80 */       cloud3Position = 1;
/*  82 */     } else if (r3 == 1) {
/*  83 */       cloud3x = -150.0D;
/*  84 */       cloud3y = 340.0D;
/*  85 */       cloud3Position = 2;
/*  86 */     } else if (r3 == 2) {
/*  87 */       cloud3x = -150.0D;
/*  88 */       cloud3y = 365.0D;
/*  89 */       cloud3Position = 3;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void tick() {
/*  97 */     if (cloud1x > -150.0D) {
/*  98 */       cloud1x -= cSpeed + 0.1D;
/*     */     } else {
/* 100 */       cloud1x = 850.0D;
/* 101 */       cloud1y = 200.0D;
/*     */     } 
/* 105 */     if (cloud2x > -125.0D) {
/* 106 */       cloud2x -= cSpeed;
/*     */     } else {
/* 108 */       cloud2x = 990.0D;
/* 109 */       cloud2y = 22.0D;
/*     */     } 
/* 113 */     if (cloud3x <= 828.0D) {
/* 114 */       cloud3x += cSpeed;
/*     */     } else {
/* 116 */       cloud3x = -150.0D;
/* 117 */       cloud3y = 365.0D;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render(Graphics g) {
/* 124 */     g.setColor(this.sky1);
/* 125 */     g.fillRect(0, 0, 838, 1146);
/* 127 */     g.drawImage(this.im.cloud1, (int)cloud1x, (int)cloud1y, 128, 96, null);
/* 128 */     g.drawImage(this.im.cloud2, (int)cloud2x, (int)cloud2y, 128, 96, null);
/* 129 */     g.drawImage(this.im.cloud3, (int)cloud3x, (int)cloud3y, 128, 96, null);
/* 131 */     g.drawImage(Game.logoImage, 160, -125, 512, 
/* 132 */         512, null);
/* 134 */     g.setColor(Color.white);
/* 135 */     g.setFont(Game.mminfo1);
/* 136 */     g.drawString(Game.title, 5, 535);
/* 137 */     g.drawString(Game.copyright, 550, 535);
/* 139 */     g.drawImage(this.im.playButton1, 334, 264, 160, 32, null);
/* 141 */     if (MouseMotion.mouseX >= 325 && MouseMotion.mouseX <= 491 && 
/* 142 */       MouseMotion.mouseY >= 248 && MouseMotion.mouseY <= 292) {
/* 143 */       g.drawImage(this.im.playButton2, 334, 264, 160, 32, null);
/* 144 */       playButtonSelected = true;
/*     */     } else {
/* 146 */       playButtonSelected = false;
/*     */     } 
/* 148 */     if (playButtonSelected && MouseManager.mouseFullClick == 1) {
/* 149 */       g.drawImage(this.im.playButton3, 334, 264, 160, 32, null);
/* 150 */       Game.gameRequested = true;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4.2_4.jar!\applecraft\testgame\main\menus\MainMenu.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */