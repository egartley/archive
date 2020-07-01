/*     */ package com.emgartley.beyondOrigins.main.entities;
/*     */ 
/*     */ import com.emgartley.beyondOrigins.main.Game;
/*     */ import com.emgartley.beyondOrigins.main.gfx.Animate;
/*     */ import com.emgartley.beyondOrigins.main.gfx.ImageManager;
/*     */ import com.emgartley.beyondOrigins.main.maps.GrassMap;
/*     */ import java.awt.Color;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.util.Random;
/*     */ 
/*     */ public class TestDummy extends Entity {
/*  15 */   private Random r = new Random();
/*     */   
/*     */   private int num;
/*     */   
/*  17 */   private static Random r2 = new Random();
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
/*  26 */   public static float x = 200.0F;
/*     */   
/*  26 */   public static float y = 200.0F;
/*     */   
/*     */   public static float rx;
/*     */   
/*     */   public static float ry;
/*     */   
/*  27 */   public static byte upCount = 1, downCount = 1, leftCount = 1;
/*     */   
/*  28 */   public static byte rightCount = 1;
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
/*  33 */   public static double maxHealth = 20.0D;
/*     */   
/*  33 */   public static double health = 20.0D;
/*     */   
/*  36 */   private static int attackRadius = 32;
/*     */   
/*     */   public TestDummy() {
/*  39 */     a = new Animate();
/*     */   }
/*     */   
/*     */   public static void kill() {
/*  43 */     if (!isDead) {
/*  44 */       num2 = r2.nextInt(5);
/*  45 */       (Game.getPlayer()).exp = (short)((Game.getPlayer()).exp + 15 + num2);
/*     */     } 
/*  47 */     isDead = true;
/*     */   }
/*     */   
/*     */   public static void takeDamage(double d) {
/*  51 */     if (!isDead)
/*  52 */       a.flashRequest = true; 
/*  53 */     if (health >= d)
/*  54 */       health -= d; 
/*  55 */     if (health <= d)
/*  56 */       kill(); 
/*     */   }
/*     */   
/*     */   public static void dealDamage() {
/*  60 */     t2 = (byte)(t2 + 1);
/*  61 */     if (t2 >= 42) {
/*  62 */       Game.getPlayer().takeDamage(2.0D);
/*  63 */       t2 = 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void reset() {
/*  68 */     isDead = false;
/*  69 */     health = maxHealth;
/*     */   }
/*     */   
/*     */   private void decideMovement(int n) {
/*  73 */     if (n == 0 && stop == 0 && y >= 11.0F) {
/*  74 */       up = true;
/*     */     } else {
/*  76 */       up = false;
/*     */     } 
/*  77 */     if (n == 1 && stop == 0 && y <= 969.0F) {
/*  78 */       down = true;
/*     */     } else {
/*  80 */       down = false;
/*     */     } 
/*  81 */     if (n == 2 && stop == 0 && x >= 11.0F) {
/*  82 */       left = true;
/*     */     } else {
/*  84 */       left = false;
/*     */     } 
/*  85 */     if (n == 3 && stop == 0 && x <= 780.0F) {
/*  86 */       right = true;
/*     */     } else {
/*  88 */       right = false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void tick() {
/*  92 */     if (!isDead) {
/*  95 */       if (lastDir == 0)
/*  96 */         lastDir = 2; 
/*  99 */       if (y <= 11.0F) {
/* 100 */         up = false;
/* 101 */         down = true;
/*     */       } 
/* 103 */       if (y >= 969.0F) {
/* 104 */         down = false;
/* 105 */         up = true;
/*     */       } 
/* 107 */       if (x <= 11.0F) {
/* 108 */         left = false;
/* 109 */         right = true;
/*     */       } 
/* 111 */       if (x >= 1000.0F) {
/* 112 */         right = false;
/* 113 */         left = true;
/*     */       } 
/* 116 */       t = (byte)(t + 1);
/* 117 */       if (t == 35) {
/* 118 */         this.num = this.r.nextInt(4);
/* 119 */         decideMovement(this.num);
/*     */       } 
/* 121 */       if (t >= 200) {
/* 122 */         t = 0;
/* 123 */         stopped = !stopped;
/* 124 */         if (stopped) {
/* 125 */           if (up)
/* 126 */             stop = 1; 
/* 128 */           if (down)
/* 129 */             stop = 2; 
/* 131 */           if (left)
/* 132 */             stop = 3; 
/* 134 */           if (right)
/* 135 */             stop = 4; 
/*     */         } else {
/* 138 */           stop = 0;
/*     */         } 
/*     */       } 
/* 147 */       if (up) {
/* 148 */         upCount = (byte)(upCount + 1);
/* 149 */         y--;
/* 150 */         if (upCount == 42)
/* 151 */           upCount = 1; 
/* 153 */         lastDir = 1;
/*     */       } else {
/* 155 */         upCount = 0;
/*     */       } 
/* 157 */       if (down) {
/* 158 */         downCount = (byte)(downCount + 1);
/* 159 */         y++;
/* 160 */         if (downCount == 42)
/* 161 */           downCount = 1; 
/* 163 */         lastDir = 2;
/*     */       } else {
/* 165 */         downCount = 0;
/*     */       } 
/* 167 */       if (left) {
/* 168 */         leftCount = (byte)(leftCount + 1);
/* 169 */         x--;
/* 170 */         if (leftCount == 42)
/* 171 */           leftCount = 1; 
/* 173 */         lastDir = 3;
/*     */       } else {
/* 175 */         leftCount = 0;
/*     */       } 
/* 177 */       if (right) {
/* 178 */         rightCount = (byte)(rightCount + 1);
/* 179 */         x++;
/* 180 */         if (rightCount == 42)
/* 181 */           rightCount = 1; 
/* 183 */         lastDir = 4;
/*     */       } else {
/* 185 */         rightCount = 0;
/*     */       } 
/*     */     } 
/* 188 */     if (Math.sqrt(((rx - (Game.getPlayer()).x) * (rx - (Game.getPlayer()).x) + (
/* 189 */         ry - (Game.getPlayer()).y) * (ry - (Game.getPlayer()).y))) <= attackRadius)
/* 190 */       dealDamage(); 
/*     */   }
/*     */   
/*     */   public void render(Graphics g) {
/* 196 */     if (!isDead) {
/* 197 */       rx = x - GrassMap.x;
/* 198 */       ry = y - GrassMap.y;
/* 199 */       if (rx >= -33.0F && ry >= -33.0F && rx <= Game.width && ry <= Game.height) {
/* 200 */         a.animateEntity(g, (int)rx, (int)ry, 
/* 201 */             ImageManager.testDummy_up, upCount);
/* 202 */         a.animateEntity(g, (int)rx, (int)ry, 
/* 203 */             ImageManager.testDummy_down, downCount);
/* 204 */         a.animateEntity(g, (int)rx, (int)ry, 
/* 205 */             ImageManager.testDummy_left, leftCount);
/* 206 */         a.animateEntity(g, (int)rx, (int)ry, 
/* 207 */             ImageManager.testDummy_right, rightCount);
/* 208 */         if (!up && lastDir == 1) {
/* 209 */           g.drawImage(ImageManager.testDummy_up[1], (int)rx, 
/* 210 */               (int)ry, null);
/* 211 */           cf = ImageManager.testDummy_up[1];
/*     */         } 
/* 213 */         if (!down && lastDir == 2) {
/* 214 */           g.drawImage(ImageManager.testDummy_down[1], (int)rx, 
/* 215 */               (int)ry, null);
/* 216 */           cf = ImageManager.testDummy_down[1];
/*     */         } 
/* 218 */         if (!left && lastDir == 3) {
/* 219 */           g.drawImage(ImageManager.testDummy_left[1], (int)rx, 
/* 220 */               (int)ry, null);
/* 221 */           cf = ImageManager.testDummy_left[1];
/*     */         } 
/* 223 */         if (!right && lastDir == 4) {
/* 224 */           g.drawImage(ImageManager.testDummy_right[1], (int)rx, 
/* 225 */               (int)ry, null);
/* 226 */           cf = ImageManager.testDummy_right[1];
/*     */         } 
/* 228 */         if (a.flashRequest)
/* 229 */           a.imageFlash(g, a.getCurrentFrame(), rx, ry, new Color(255, 
/* 230 */                 0, 0, 128)); 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.1.0_3.jar!\com\emgartley\beyondOrigins\main\entities\TestDummy.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */