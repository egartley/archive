/*     */ package applecraft.testgame.main.menus;
/*     */ 
/*     */ import applecraft.testgame.main.Game;
/*     */ import applecraft.testgame.main.Load;
/*     */ import applecraft.testgame.main.MouseManager;
/*     */ import applecraft.testgame.main.MouseMotion;
/*     */ import applecraft.testgame.main.gfx.ImageManager;
/*     */ import java.awt.Color;
/*     */ import java.awt.Graphics;
/*     */ import java.util.Random;
/*     */ 
/*     */ public class MainMenu {
/*  15 */   static Random r = new Random();
/*     */   
/*     */   private static int r1;
/*     */   
/*     */   private static int r2;
/*     */   
/*     */   private static int r3;
/*     */   
/*  20 */   Color sky1 = new Color(86, 201, 255);
/*     */   
/*  21 */   Color color1 = new Color(255, 255, 255);
/*     */   
/*  22 */   Color color2 = new Color(236, 210, 120);
/*     */   
/*  23 */   Color color3 = new Color(73, 73, 73);
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
/*     */   public static boolean playButtonSelected = false;
/*     */   
/*     */   public static boolean loadButtonSelected = false;
/*     */   
/*     */   public static boolean newButtonSelected = false;
/*     */   
/*     */   public static int playState;
/*     */   
/*     */   public static int loadState;
/*     */   
/*     */   public static int newState;
/*     */   
/*  34 */   private static double cSpeed = 0.5D;
/*     */   
/*     */   private ImageManager im;
/*     */   
/*     */   public MainMenu(double x1, double y1, ImageManager im) {
/*  39 */     cloud1x = x1;
/*  40 */     cloud1y = y1;
/*  41 */     this.im = im;
/*     */   }
/*     */   
/*     */   public static void init() {
/*  46 */     r1 = r.nextInt(3);
/*  47 */     r2 = r.nextInt(3);
/*  48 */     r3 = r.nextInt(3);
/*  51 */     if (r1 == 0) {
/*  52 */       cloud1x = 850.0D;
/*  53 */       cloud1y = 160.0D;
/*  54 */     } else if (r1 == 1) {
/*  55 */       cloud1x = 850.0D;
/*  56 */       cloud1y = 200.0D;
/*  57 */     } else if (r1 == 2) {
/*  58 */       cloud1x = 850.0D;
/*  59 */       cloud1y = 220.0D;
/*     */     } 
/*  63 */     if (r2 == 0) {
/*  64 */       cloud2x = 990.0D;
/*  65 */       cloud2y = 2.0D;
/*  66 */     } else if (r2 == 1) {
/*  67 */       cloud2x = 990.0D;
/*  68 */       cloud2y = 22.0D;
/*  69 */     } else if (r2 == 2) {
/*  70 */       cloud2x = 990.0D;
/*  71 */       cloud2y = 42.0D;
/*     */     } 
/*  75 */     if (r3 == 0) {
/*  76 */       cloud3x = -150.0D;
/*  77 */       cloud3y = 315.0D;
/*  78 */     } else if (r3 == 1) {
/*  79 */       cloud3x = -150.0D;
/*  80 */       cloud3y = 340.0D;
/*  81 */     } else if (r3 == 2) {
/*  82 */       cloud3x = -150.0D;
/*  83 */       cloud3y = 365.0D;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void tick() {
/*  91 */     if (cloud1x > -150.0D) {
/*  92 */       cloud1x -= cSpeed + 0.1D;
/*     */     } else {
/*  94 */       cloud1x = 850.0D;
/*  95 */       cloud1y = 200.0D;
/*     */     } 
/*  99 */     if (cloud2x > -125.0D) {
/* 100 */       cloud2x -= cSpeed;
/*     */     } else {
/* 102 */       cloud2x = 990.0D;
/* 103 */       cloud2y = 22.0D;
/*     */     } 
/* 107 */     if (cloud3x <= 828.0D) {
/* 108 */       cloud3x += cSpeed;
/*     */     } else {
/* 110 */       cloud3x = -150.0D;
/* 111 */       cloud3y = 365.0D;
/*     */     } 
/* 115 */     if (MouseMotion.mouseX >= 336 && MouseMotion.mouseX <= 491 && 
/* 116 */       MouseMotion.mouseY >= 266 && MouseMotion.mouseY <= 292) {
/* 117 */       playState = 2;
/* 118 */       if (MouseManager.mouseFullClick == 1) {
/* 119 */         playState = 3;
/*     */       } else {
/* 121 */         playState = 2;
/*     */       } 
/*     */     } else {
/* 123 */       playState = 0;
/*     */     } 
/* 127 */     if (MouseMotion.mouseX >= 336 && MouseMotion.mouseX <= 491 && 
/* 128 */       MouseMotion.mouseY >= 304 && MouseMotion.mouseY <= 330 && 
/* 129 */       Load.canLoadGame) {
/* 130 */       loadState = 2;
/* 131 */       if (MouseManager.mouseFullClick == 1) {
/* 132 */         loadState = 3;
/*     */       } else {
/* 134 */         loadState = 2;
/*     */       } 
/*     */     } else {
/* 136 */       loadState = 0;
/*     */     } 
/* 140 */     if (MouseMotion.mouseX >= 336 && MouseMotion.mouseX <= 491 && 
/* 141 */       MouseMotion.mouseY >= 342 && MouseMotion.mouseY <= 370 && 
/* 142 */       Load.canMakeNewGame) {
/* 143 */       newState = 2;
/* 144 */       if (MouseManager.mouseFullClick == 1) {
/* 145 */         newState = 3;
/*     */       } else {
/* 147 */         newState = 2;
/*     */       } 
/*     */     } else {
/* 149 */       newState = 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render(Graphics g) {
/* 156 */     g.setColor(this.sky1);
/* 157 */     g.fillRect(0, 0, 838, 1146);
/* 159 */     g.drawImage(this.im.cloud1, (int)cloud1x, (int)cloud1y, 128, 96, null);
/* 160 */     g.drawImage(this.im.cloud2, (int)cloud2x, (int)cloud2y, 128, 96, null);
/* 161 */     g.drawImage(this.im.cloud3, (int)cloud3x, (int)cloud3y, 128, 96, null);
/* 163 */     g.drawImage(Game.logoImage, 160, -125, 512, 
/* 164 */         512, null);
/* 166 */     g.setFont(Game.default2);
/* 168 */     g.setColor(Color.white);
/* 169 */     g.drawString(Game.title, 5, 535);
/* 170 */     g.drawString(Game.copyright, 565, 535);
/* 174 */     g.drawImage(this.im.button1_1, 334, 264, 160, 32, null);
/* 175 */     g.setColor(this.color1);
/* 176 */     g.drawString("Play", 395, 285);
/* 178 */     if (Load.canLoadGame) {
/* 179 */       g.drawImage(this.im.button1_1, 334, 304, 160, 32, null);
/* 180 */       g.setColor(this.color1);
/* 181 */       g.drawString("Load Game...", 357, 327);
/*     */     } else {
/* 183 */       g.drawImage(this.im.button1_3, 334, 304, 160, 32, null);
/* 184 */       g.setColor(this.color3);
/* 185 */       g.drawString("Load Game...", 357, 327);
/*     */     } 
/* 188 */     if (Load.canMakeNewGame) {
/* 189 */       g.drawImage(this.im.button1_1, 334, 344, 160, 32, null);
/* 190 */       g.setColor(this.color1);
/* 191 */       g.drawString("New Game...", 357, 367);
/*     */     } else {
/* 193 */       g.drawImage(this.im.button1_3, 334, 344, 160, 32, null);
/* 194 */       g.setColor(this.color3);
/* 195 */       g.drawString("New Game...", 357, 367);
/*     */     } 
/* 200 */     if (playState == 2) {
/* 201 */       g.drawImage(this.im.button1_2, 334, 264, 160, 32, null);
/* 202 */       g.setColor(this.color2);
/* 203 */       g.drawString("Play", 395, 285);
/* 204 */     } else if (playState == 3) {
/* 205 */       g.drawImage(this.im.button1_3, 334, 264, 160, 32, null);
/* 206 */       g.setColor(this.color3);
/* 207 */       g.drawString("Play", 395, 285);
/* 208 */       Game.gameRequested = true;
/*     */     } 
/* 211 */     if (loadState == 2) {
/* 212 */       g.drawImage(this.im.button1_2, 334, 304, 160, 32, null);
/* 213 */       g.setColor(this.color2);
/* 214 */       g.drawString("Load Game...", 357, 327);
/* 215 */     } else if (loadState == 3) {
/* 216 */       g.drawImage(this.im.button1_3, 334, 304, 160, 32, null);
/* 217 */       g.setColor(this.color3);
/* 218 */       g.drawString("Load Game...", 357, 327);
/*     */     } 
/* 221 */     if (newState == 2) {
/* 222 */       g.drawImage(this.im.button1_2, 334, 344, 160, 32, null);
/* 223 */       g.setColor(this.color2);
/* 224 */       g.drawString("New Game...", 357, 367);
/* 225 */     } else if (newState == 3) {
/* 226 */       g.drawImage(this.im.button1_3, 334, 344, 160, 32, null);
/* 227 */       g.setColor(this.color3);
/* 228 */       g.drawString("New Game...", 357, 367);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4.2_7.jar!\applecraft\testgame\main\menus\MainMenu.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */