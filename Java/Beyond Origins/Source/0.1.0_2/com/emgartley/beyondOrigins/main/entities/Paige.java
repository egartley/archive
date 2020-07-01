/*     */ package com.emgartley.beyondOrigins.main.entities;
/*     */ 
/*     */ import com.emgartley.beyondOrigins.main.Game;
/*     */ import com.emgartley.beyondOrigins.main.gfx.Animate;
/*     */ import com.emgartley.beyondOrigins.main.gfx.ImageManager;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.image.BufferedImage;
/*     */ 
/*     */ public class Paige extends Entity {
/*     */   private static Animate a;
/*     */   
/*     */   public static BufferedImage cf;
/*     */   
/*  16 */   public static float x = 200.0F;
/*     */   
/*  16 */   public static float y = 200.0F;
/*     */   
/*     */   public static float rx;
/*     */   
/*     */   public static float ry;
/*     */   
/*  17 */   public static byte upCount = 1, downCount = 1, leftCount = 1;
/*     */   
/*  18 */   public static byte rightCount = 1;
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
/*  23 */     a = new Animate();
/*     */   }
/*     */   
/*     */   public void tick() {
/*  27 */     if (up) {
/*  28 */       upCount = (byte)(upCount + 1);
/*  29 */       y--;
/*  30 */       if (upCount == 42)
/*  31 */         upCount = 1; 
/*  33 */       lastDir = 1;
/*     */     } else {
/*  35 */       upCount = 0;
/*     */     } 
/*  37 */     if (down) {
/*  38 */       downCount = (byte)(downCount + 1);
/*  39 */       y++;
/*  40 */       if (downCount == 42)
/*  41 */         downCount = 1; 
/*  43 */       lastDir = 2;
/*     */     } else {
/*  45 */       downCount = 0;
/*     */     } 
/*  47 */     if (left) {
/*  48 */       leftCount = (byte)(leftCount + 1);
/*  49 */       x--;
/*  50 */       if (leftCount == 42)
/*  51 */         leftCount = 1; 
/*  53 */       lastDir = 3;
/*     */     } else {
/*  55 */       leftCount = 0;
/*     */     } 
/*  57 */     if (right) {
/*  58 */       rightCount = (byte)(rightCount + 1);
/*  59 */       x++;
/*  60 */       if (rightCount == 42)
/*  61 */         rightCount = 1; 
/*  63 */       lastDir = 4;
/*     */     } else {
/*  65 */       rightCount = 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setCords(int x, int y) {
/*  69 */     Paige.x = x;
/*  70 */     Paige.y = y;
/*     */   }
/*     */   
/*     */   public void render(Graphics g) {
/*  74 */     rx = x - (Game.getPlayer()).mapX + Game.playerSpawnX;
/*  75 */     ry = y - (Game.getPlayer()).mapY + Game.playerSpawnY;
/*  76 */     if (rx >= -33.0F && ry >= -33.0F && rx <= Game.width && ry <= Game.height) {
/*  77 */       a.animateEntity(g, (int)rx, (int)ry, ImageManager.paige_up, 
/*  78 */           upCount);
/*  79 */       a.animateEntity(g, (int)rx, (int)ry, ImageManager.paige_down, 
/*  80 */           downCount);
/*  81 */       a.animateEntity(g, (int)rx, (int)ry, ImageManager.paige_left, 
/*  82 */           leftCount);
/*  83 */       a.animateEntity(g, (int)rx, (int)ry, ImageManager.paige_right, 
/*  84 */           rightCount);
/*  85 */       if (!up && lastDir == 1) {
/*  86 */         g.drawImage(ImageManager.paige_up[1], (int)rx, (int)ry, null);
/*  87 */         cf = ImageManager.paige_up[1];
/*     */       } 
/*  89 */       if (!down && lastDir == 2) {
/*  90 */         g.drawImage(ImageManager.paige_down[1], (int)rx, (int)ry, 
/*  91 */             null);
/*  92 */         cf = ImageManager.paige_down[1];
/*     */       } 
/*  94 */       if (!left && lastDir == 3) {
/*  95 */         g.drawImage(ImageManager.paige_left[1], (int)rx, (int)ry, 
/*  96 */             null);
/*  97 */         cf = ImageManager.paige_left[1];
/*     */       } 
/*  99 */       if (!right && lastDir == 4) {
/* 100 */         g.drawImage(ImageManager.paige_right[1], (int)rx, (int)ry, 
/* 101 */             null);
/* 102 */         cf = ImageManager.paige_right[1];
/*     */       } 
/* 104 */       if (!up && !down && !left && !right && lastDir == 0) {
/* 105 */         g.drawImage(ImageManager.paige_down[1], (int)rx, (int)ry, 
/* 106 */             null);
/* 107 */         cf = ImageManager.paige_down[1];
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.1.0_2.jar!\com\emgartley\beyondOrigins\main\entities\Paige.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */