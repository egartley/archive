/*     */ package beyondOrigins.main.entities;
/*     */ 
/*     */ import beyondOrigins.main.Game;
/*     */ import beyondOrigins.main.gfx.Animate;
/*     */ import beyondOrigins.main.gfx.ImageManager;
/*     */ import java.awt.Color;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.util.Random;
/*     */ 
/*     */ public class TestDummy {
/*  14 */   private Random r = new Random();
/*     */   
/*     */   private int num;
/*     */   
/*  16 */   private static Random r2 = new Random();
/*     */   
/*     */   private static int num2;
/*     */   
/*     */   public static boolean isDead = false;
/*     */   
/*     */   public static boolean test;
/*     */   
/*     */   public static boolean flashRequest;
/*     */   
/*     */   public static BufferedImage cf;
/*     */   
/*     */   private static Animate a;
/*     */   
/*  25 */   public static float x = 200.0F;
/*     */   
/*  25 */   public static float y = 200.0F;
/*     */   
/*     */   public static float rx;
/*     */   
/*     */   public static float ry;
/*     */   
/*  26 */   public static byte upCount = 1, downCount = 1, leftCount = 1;
/*     */   
/*  27 */   public static byte rightCount = 1;
/*     */   
/*     */   public static boolean up;
/*     */   
/*     */   public static boolean down;
/*     */   
/*     */   public static boolean left;
/*     */   
/*     */   public static boolean right;
/*     */   
/*     */   public static boolean stopped;
/*     */   
/*     */   public static byte lastDir;
/*     */   
/*     */   public static byte speed;
/*     */   
/*     */   public static byte t;
/*     */   
/*     */   public static byte t2;
/*     */   
/*     */   public static byte stop;
/*     */   
/*  32 */   public static double maxHealth = 20.0D;
/*     */   
/*  32 */   public static double health = 20.0D;
/*     */   
/*  35 */   private static int attackRadius = 32;
/*     */   
/*     */   public TestDummy() {
/*  38 */     a = new Animate();
/*     */   }
/*     */   
/*     */   public static void kill() {
/*  42 */     if (!isDead) {
/*  43 */       num2 = r2.nextInt(5);
/*  44 */       Player.exp = (short)(Player.exp + 15 + num2);
/*     */     } 
/*  46 */     isDead = true;
/*     */   }
/*     */   
/*     */   public static void takeDamage(double d) {
/*  50 */     if (!isDead)
/*  50 */       a.flashRequest = true; 
/*  51 */     if (health >= d)
/*  51 */       health -= d; 
/*  52 */     if (health <= d)
/*  52 */       kill(); 
/*     */   }
/*     */   
/*     */   public static void dealDamage(double d) {
/*  56 */     t2 = (byte)(t2 + 1);
/*  57 */     if (t2 >= 42) {
/*  58 */       Player.takeDamage(2.0D);
/*  59 */       t2 = 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void reset() {
/*  64 */     isDead = false;
/*  65 */     health = maxHealth;
/*     */   }
/*     */   
/*     */   private void decideMovement(int n) {
/*  69 */     if (n == 0 && stop == 0 && y >= 11.0F) {
/*  70 */       up = true;
/*     */     } else {
/*  72 */       up = false;
/*     */     } 
/*  73 */     if (n == 1 && stop == 0 && y <= 969.0F) {
/*  74 */       down = true;
/*     */     } else {
/*  76 */       down = false;
/*     */     } 
/*  77 */     if (n == 2 && stop == 0 && x >= 11.0F) {
/*  78 */       left = true;
/*     */     } else {
/*  80 */       left = false;
/*     */     } 
/*  81 */     if (n == 3 && stop == 0 && x <= 780.0F) {
/*  82 */       right = true;
/*     */     } else {
/*  84 */       right = false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void tick() {
/*  88 */     if (!isDead) {
/*  91 */       if (lastDir == 0)
/*  92 */         lastDir = 2; 
/*  95 */       if (y <= 11.0F) {
/*  96 */         up = false;
/*  97 */         down = true;
/*     */       } 
/*  99 */       if (y >= 969.0F) {
/* 100 */         down = false;
/* 101 */         up = true;
/*     */       } 
/* 103 */       if (x <= 11.0F) {
/* 104 */         left = false;
/* 105 */         right = true;
/*     */       } 
/* 107 */       if (x >= 1000.0F) {
/* 108 */         right = false;
/* 109 */         left = true;
/*     */       } 
/* 112 */       t = (byte)(t + 1);
/* 113 */       if (t == 35) {
/* 114 */         this.num = this.r.nextInt(4);
/* 115 */         decideMovement(this.num);
/*     */       } 
/* 117 */       if (t >= 200) {
/* 118 */         t = 0;
/* 119 */         stopped = !stopped;
/* 120 */         if (stopped) {
/* 121 */           if (up)
/* 122 */             stop = 1; 
/* 124 */           if (down)
/* 125 */             stop = 2; 
/* 127 */           if (left)
/* 128 */             stop = 3; 
/* 130 */           if (right)
/* 131 */             stop = 4; 
/*     */         } else {
/* 134 */           stop = 0;
/*     */         } 
/*     */       } 
/* 145 */       if (up) {
/* 146 */         upCount = (byte)(upCount + 1);
/* 147 */         y--;
/* 148 */         if (upCount == 42)
/* 149 */           upCount = 1; 
/* 151 */         lastDir = 1;
/*     */       } else {
/* 153 */         upCount = 0;
/*     */       } 
/* 155 */       if (down) {
/* 156 */         downCount = (byte)(downCount + 1);
/* 157 */         y++;
/* 158 */         if (downCount == 42)
/* 159 */           downCount = 1; 
/* 161 */         lastDir = 2;
/*     */       } else {
/* 163 */         downCount = 0;
/*     */       } 
/* 165 */       if (left) {
/* 166 */         leftCount = (byte)(leftCount + 1);
/* 167 */         x--;
/* 168 */         if (leftCount == 42)
/* 169 */           leftCount = 1; 
/* 171 */         lastDir = 3;
/*     */       } else {
/* 173 */         leftCount = 0;
/*     */       } 
/* 175 */       if (right) {
/* 176 */         rightCount = (byte)(rightCount + 1);
/* 177 */         x++;
/* 178 */         if (rightCount == 42)
/* 179 */           rightCount = 1; 
/* 181 */         lastDir = 4;
/*     */       } else {
/* 183 */         rightCount = 0;
/*     */       } 
/*     */     } 
/* 186 */     if (Math.sqrt(((rx - Player.x) * (rx - Player.x) + (ry - Player.y) * (
/* 187 */         ry - Player.y))) <= attackRadius)
/* 188 */       dealDamage(0.5D); 
/*     */   }
/*     */   
/*     */   public void render(Graphics g) {
/* 194 */     if (!isDead) {
/* 195 */       rx = x - Player.mapX + Game.playerSpawnX;
/* 196 */       ry = y - Player.mapY + Game.playerSpawnY;
/* 198 */       a.animateEntity(g, (int)rx, (int)ry, ImageManager.tdu1, 
/* 199 */           ImageManager.tdu2, ImageManager.tdu3, ImageManager.tdu4, 
/* 200 */           upCount);
/* 201 */       a.animateEntity(g, (int)rx, (int)ry, ImageManager.tdd1, 
/* 202 */           ImageManager.tdd2, ImageManager.tdd3, ImageManager.tdd4, 
/* 203 */           downCount);
/* 204 */       a.animateEntity(g, (int)rx, (int)ry, ImageManager.tdl1, 
/* 205 */           ImageManager.tdl2, ImageManager.tdl3, ImageManager.tdl4, 
/* 206 */           leftCount);
/* 207 */       a.animateEntity(g, (int)rx, (int)ry, ImageManager.tdr1, 
/* 208 */           ImageManager.tdr2, ImageManager.tdr3, ImageManager.tdr4, 
/* 209 */           rightCount);
/* 211 */       if (!up && lastDir == 1) {
/* 212 */         g.drawImage(ImageManager.tdu1, (int)rx, (int)ry, null);
/* 213 */         cf = ImageManager.tdu1;
/*     */       } 
/* 215 */       if (!down && lastDir == 2) {
/* 216 */         g.drawImage(ImageManager.tdd1, (int)rx, (int)ry, null);
/* 217 */         cf = ImageManager.tdd1;
/*     */       } 
/* 219 */       if (!left && lastDir == 3) {
/* 220 */         g.drawImage(ImageManager.tdl1, (int)rx, (int)ry, null);
/* 221 */         cf = ImageManager.tdl1;
/*     */       } 
/* 223 */       if (!right && lastDir == 4) {
/* 224 */         g.drawImage(ImageManager.tdr1, (int)rx, (int)ry, null);
/* 225 */         cf = ImageManager.tdr1;
/*     */       } 
/*     */     } 
/* 229 */     if (a.flashRequest)
/* 230 */       a.imageFlash(g, a.getCurrentFrame(), rx, ry, new Color(255, 0, 0, 128)); 
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.6_2.jar!\beyondOrigins\main\entities\TestDummy.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */