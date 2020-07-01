/*     */ package com.emgartley.beyondOrigins.main.entities;
/*     */ 
/*     */ import com.emgartley.beyondOrigins.main.Game;
/*     */ import com.emgartley.beyondOrigins.main.gfx.Animate;
/*     */ import com.emgartley.beyondOrigins.main.gfx.ImageManager;
/*     */ import com.emgartley.beyondOrigins.main.maps.GrassMap;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.image.BufferedImage;
/*     */ 
/*     */ public class Paige extends Entity {
/*     */   private static Animate a;
/*     */   
/*     */   public static BufferedImage cf;
/*     */   
/*  17 */   public static float x = 200.0F;
/*     */   
/*  17 */   public static float y = 200.0F;
/*     */   
/*     */   public static float rx;
/*     */   
/*     */   public static float ry;
/*     */   
/*  18 */   public static byte upCount = 1, downCount = 1, leftCount = 1;
/*     */   
/*  19 */   public static byte rightCount = 1;
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
/*     */   public Paige() {
/*  24 */     a = new Animate();
/*     */   }
/*     */   
/*     */   public void tick() {
/*  28 */     if (up) {
/*  29 */       upCount = (byte)(upCount + 1);
/*  30 */       y--;
/*  31 */       if (upCount == 42)
/*  32 */         upCount = 1; 
/*  34 */       lastDir = 1;
/*     */     } else {
/*  36 */       upCount = 0;
/*     */     } 
/*  38 */     if (down) {
/*  39 */       downCount = (byte)(downCount + 1);
/*  40 */       y++;
/*  41 */       if (downCount == 42)
/*  42 */         downCount = 1; 
/*  44 */       lastDir = 2;
/*     */     } else {
/*  46 */       downCount = 0;
/*     */     } 
/*  48 */     if (left) {
/*  49 */       leftCount = (byte)(leftCount + 1);
/*  50 */       x--;
/*  51 */       if (leftCount == 42)
/*  52 */         leftCount = 1; 
/*  54 */       lastDir = 3;
/*     */     } else {
/*  56 */       leftCount = 0;
/*     */     } 
/*  58 */     if (right) {
/*  59 */       rightCount = (byte)(rightCount + 1);
/*  60 */       x++;
/*  61 */       if (rightCount == 42)
/*  62 */         rightCount = 1; 
/*  64 */       lastDir = 4;
/*     */     } else {
/*  66 */       rightCount = 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setCords(int x, int y) {
/*  70 */     Paige.x = x;
/*  71 */     Paige.y = y;
/*     */   }
/*     */   
/*     */   public void render(Graphics g) {
/*  75 */     rx = x - GrassMap.x;
/*  76 */     ry = y - GrassMap.y;
/*  77 */     if (rx >= -33.0F && ry >= -33.0F && rx <= Game.width && ry <= Game.height) {
/*  78 */       a.animateEntity(g, (int)rx, (int)ry, ImageManager.paige_up, 
/*  79 */           upCount);
/*  80 */       a.animateEntity(g, (int)rx, (int)ry, ImageManager.paige_down, 
/*  81 */           downCount);
/*  82 */       a.animateEntity(g, (int)rx, (int)ry, ImageManager.paige_left, 
/*  83 */           leftCount);
/*  84 */       a.animateEntity(g, (int)rx, (int)ry, ImageManager.paige_right, 
/*  85 */           rightCount);
/*  86 */       if (!up && lastDir == 1) {
/*  87 */         g.drawImage(ImageManager.paige_up[1], (int)rx, (int)ry, null);
/*  88 */         cf = ImageManager.paige_up[1];
/*     */       } 
/*  90 */       if (!down && lastDir == 2) {
/*  91 */         g.drawImage(ImageManager.paige_down[1], (int)rx, (int)ry, 
/*  92 */             null);
/*  93 */         cf = ImageManager.paige_down[1];
/*     */       } 
/*  95 */       if (!left && lastDir == 3) {
/*  96 */         g.drawImage(ImageManager.paige_left[1], (int)rx, (int)ry, 
/*  97 */             null);
/*  98 */         cf = ImageManager.paige_left[1];
/*     */       } 
/* 100 */       if (!right && lastDir == 4) {
/* 101 */         g.drawImage(ImageManager.paige_right[1], (int)rx, (int)ry, 
/* 102 */             null);
/* 103 */         cf = ImageManager.paige_right[1];
/*     */       } 
/* 105 */       if (!up && !down && !left && !right && lastDir == 0) {
/* 106 */         g.drawImage(ImageManager.paige_down[1], (int)rx, (int)ry, 
/* 107 */             null);
/* 108 */         cf = ImageManager.paige_down[1];
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.1.0_3.jar!\com\emgartley\beyondOrigins\main\entities\Paige.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */