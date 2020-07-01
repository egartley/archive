/*     */ package com.emgartley.beyondOrigins.main.entities;
/*     */ 
/*     */ import com.emgartley.beyondOrigins.main.Game;
/*     */ import com.emgartley.beyondOrigins.main.gfx.Animate;
/*     */ import com.emgartley.beyondOrigins.main.gfx.ImageManager;
/*     */ import java.awt.Color;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.util.Random;
/*     */ 
/*     */ public class TestDummy extends Entity {
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
/*  44 */       (Game.getPlayer()).exp = (short)((Game.getPlayer()).exp + 15 + num2);
/*     */     } 
/*  46 */     isDead = true;
/*     */   }
/*     */   
/*     */   public static void takeDamage(double d) {
/*  50 */     if (!isDead)
/*  51 */       a.flashRequest = true; 
/*  52 */     if (health >= d)
/*  53 */       health -= d; 
/*  54 */     if (health <= d)
/*  55 */       kill(); 
/*     */   }
/*     */   
/*     */   public static void dealDamage() {
/*  59 */     t2 = (byte)(t2 + 1);
/*  60 */     if (t2 >= 42) {
/*  61 */       Game.getPlayer().takeDamage(2.0D);
/*  62 */       t2 = 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void reset() {
/*  67 */     isDead = false;
/*  68 */     health = maxHealth;
/*     */   }
/*     */   
/*     */   private void decideMovement(int n) {
/*  72 */     if (n == 0 && stop == 0 && y >= 11.0F) {
/*  73 */       up = true;
/*     */     } else {
/*  75 */       up = false;
/*     */     } 
/*  76 */     if (n == 1 && stop == 0 && y <= 969.0F) {
/*  77 */       down = true;
/*     */     } else {
/*  79 */       down = false;
/*     */     } 
/*  80 */     if (n == 2 && stop == 0 && x >= 11.0F) {
/*  81 */       left = true;
/*     */     } else {
/*  83 */       left = false;
/*     */     } 
/*  84 */     if (n == 3 && stop == 0 && x <= 780.0F) {
/*  85 */       right = true;
/*     */     } else {
/*  87 */       right = false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void tick() {
/*  91 */     if (!isDead) {
/*  94 */       if (lastDir == 0)
/*  95 */         lastDir = 2; 
/*  98 */       if (y <= 11.0F) {
/*  99 */         up = false;
/* 100 */         down = true;
/*     */       } 
/* 102 */       if (y >= 969.0F) {
/* 103 */         down = false;
/* 104 */         up = true;
/*     */       } 
/* 106 */       if (x <= 11.0F) {
/* 107 */         left = false;
/* 108 */         right = true;
/*     */       } 
/* 110 */       if (x >= 1000.0F) {
/* 111 */         right = false;
/* 112 */         left = true;
/*     */       } 
/* 115 */       t = (byte)(t + 1);
/* 116 */       if (t == 35) {
/* 117 */         this.num = this.r.nextInt(4);
/* 118 */         decideMovement(this.num);
/*     */       } 
/* 120 */       if (t >= 200) {
/* 121 */         t = 0;
/* 122 */         stopped = !stopped;
/* 123 */         if (stopped) {
/* 124 */           if (up)
/* 125 */             stop = 1; 
/* 127 */           if (down)
/* 128 */             stop = 2; 
/* 130 */           if (left)
/* 131 */             stop = 3; 
/* 133 */           if (right)
/* 134 */             stop = 4; 
/*     */         } else {
/* 137 */           stop = 0;
/*     */         } 
/*     */       } 
/* 146 */       if (up) {
/* 147 */         upCount = (byte)(upCount + 1);
/* 148 */         y--;
/* 149 */         if (upCount == 42)
/* 150 */           upCount = 1; 
/* 152 */         lastDir = 1;
/*     */       } else {
/* 154 */         upCount = 0;
/*     */       } 
/* 156 */       if (down) {
/* 157 */         downCount = (byte)(downCount + 1);
/* 158 */         y++;
/* 159 */         if (downCount == 42)
/* 160 */           downCount = 1; 
/* 162 */         lastDir = 2;
/*     */       } else {
/* 164 */         downCount = 0;
/*     */       } 
/* 166 */       if (left) {
/* 167 */         leftCount = (byte)(leftCount + 1);
/* 168 */         x--;
/* 169 */         if (leftCount == 42)
/* 170 */           leftCount = 1; 
/* 172 */         lastDir = 3;
/*     */       } else {
/* 174 */         leftCount = 0;
/*     */       } 
/* 176 */       if (right) {
/* 177 */         rightCount = (byte)(rightCount + 1);
/* 178 */         x++;
/* 179 */         if (rightCount == 42)
/* 180 */           rightCount = 1; 
/* 182 */         lastDir = 4;
/*     */       } else {
/* 184 */         rightCount = 0;
/*     */       } 
/*     */     } 
/* 187 */     if (Math.sqrt(((rx - (Game.getPlayer()).x) * (rx - (Game.getPlayer()).x) + (
/* 188 */         ry - (Game.getPlayer()).y) * (ry - (Game.getPlayer()).y))) <= attackRadius)
/* 189 */       dealDamage(); 
/*     */   }
/*     */   
/*     */   public void render(Graphics g) {
/* 195 */     if (!isDead) {
/* 196 */       rx = x - (Game.getMap()).x;
/* 197 */       ry = y - (Game.getMap()).y;
/* 198 */       if (rx >= -33.0F && ry >= -33.0F && rx <= Game.width && ry <= Game.height) {
/* 199 */         a.animateEntity(g, (int)rx, (int)ry, 
/* 200 */             ImageManager.testDummy_up, upCount);
/* 201 */         a.animateEntity(g, (int)rx, (int)ry, 
/* 202 */             ImageManager.testDummy_down, downCount);
/* 203 */         a.animateEntity(g, (int)rx, (int)ry, 
/* 204 */             ImageManager.testDummy_left, leftCount);
/* 205 */         a.animateEntity(g, (int)rx, (int)ry, 
/* 206 */             ImageManager.testDummy_right, rightCount);
/* 207 */         if (!up && lastDir == 1) {
/* 208 */           g.drawImage(ImageManager.testDummy_up[1], (int)rx, 
/* 209 */               (int)ry, null);
/* 210 */           cf = ImageManager.testDummy_up[1];
/*     */         } 
/* 212 */         if (!down && lastDir == 2) {
/* 213 */           g.drawImage(ImageManager.testDummy_down[1], (int)rx, 
/* 214 */               (int)ry, null);
/* 215 */           cf = ImageManager.testDummy_down[1];
/*     */         } 
/* 217 */         if (!left && lastDir == 3) {
/* 218 */           g.drawImage(ImageManager.testDummy_left[1], (int)rx, 
/* 219 */               (int)ry, null);
/* 220 */           cf = ImageManager.testDummy_left[1];
/*     */         } 
/* 222 */         if (!right && lastDir == 4) {
/* 223 */           g.drawImage(ImageManager.testDummy_right[1], (int)rx, 
/* 224 */               (int)ry, null);
/* 225 */           cf = ImageManager.testDummy_right[1];
/*     */         } 
/* 227 */         if (a.flashRequest)
/* 228 */           a.imageFlash(g, a.getCurrentFrame(), rx, ry, new Color(255, 
/* 229 */                 0, 0, 128)); 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.1.0_4.jar!\com\emgartley\beyondOrigins\main\entities\TestDummy.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */