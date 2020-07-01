/*     */ package beyondOrigins.main.entities;
/*     */ 
/*     */ import beyondOrigins.main.Game;
/*     */ import beyondOrigins.main.gfx.ImageManager;
/*     */ import beyondOrigins.threads.Animate;
/*     */ import java.awt.Graphics;
/*     */ import java.util.Random;
/*     */ 
/*     */ public class TestDummy {
/*  12 */   private Random r = new Random();
/*     */   
/*     */   private int num;
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
/*     */   public static byte stop;
/*     */   
/*     */   private static ImageManager im;
/*     */   
/*     */   public TestDummy(ImageManager im) {
/*  26 */     TestDummy.im = im;
/*     */   }
/*     */   
/*     */   private void decideMovement(int n) {
/*  30 */     if (n == 0 && stop == 0 && y >= 11.0F) {
/*  31 */       up = true;
/*     */     } else {
/*  33 */       up = false;
/*     */     } 
/*  34 */     if (n == 1 && stop == 0 && y <= 969.0F) {
/*  35 */       down = true;
/*     */     } else {
/*  37 */       down = false;
/*     */     } 
/*  38 */     if (n == 2 && stop == 0 && x >= 11.0F) {
/*  39 */       left = true;
/*     */     } else {
/*  41 */       left = false;
/*     */     } 
/*  42 */     if (n == 3 && stop == 0 && x <= 780.0F) {
/*  43 */       right = true;
/*     */     } else {
/*  45 */       right = false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void tick() {
/*  51 */     if (lastDir == 0)
/*  52 */       lastDir = 2; 
/*  55 */     if (y <= 11.0F) {
/*  56 */       up = false;
/*  57 */       down = true;
/*     */     } 
/*  59 */     if (y >= 969.0F) {
/*  60 */       down = false;
/*  61 */       up = true;
/*     */     } 
/*  63 */     if (x <= 11.0F) {
/*  64 */       left = false;
/*  65 */       right = true;
/*     */     } 
/*  67 */     if (x >= 1000.0F) {
/*  68 */       right = false;
/*  69 */       left = true;
/*     */     } 
/*  72 */     t = (byte)(t + 1);
/*  73 */     if (t == 35) {
/*  74 */       this.num = this.r.nextInt(4);
/*  75 */       decideMovement(this.num);
/*     */     } 
/*  77 */     if (t >= 200) {
/*  78 */       t = 0;
/*  79 */       stopped = !stopped;
/*  80 */       if (stopped) {
/*  81 */         if (up)
/*  82 */           stop = 1; 
/*  84 */         if (down)
/*  85 */           stop = 2; 
/*  87 */         if (left)
/*  88 */           stop = 3; 
/*  90 */         if (right)
/*  91 */           stop = 4; 
/*     */       } else {
/*  94 */         stop = 0;
/*     */       } 
/*     */     } 
/* 106 */     if (up) {
/* 107 */       upCount = (byte)(upCount + 1);
/* 108 */       y--;
/* 109 */       if (upCount == 42)
/* 110 */         upCount = 1; 
/* 112 */       lastDir = 1;
/*     */     } else {
/* 114 */       upCount = 0;
/*     */     } 
/* 116 */     if (down) {
/* 117 */       downCount = (byte)(downCount + 1);
/* 118 */       y++;
/* 119 */       if (downCount == 42)
/* 120 */         downCount = 1; 
/* 122 */       lastDir = 2;
/*     */     } else {
/* 124 */       downCount = 0;
/*     */     } 
/* 126 */     if (left) {
/* 127 */       leftCount = (byte)(leftCount + 1);
/* 128 */       x--;
/* 129 */       if (leftCount == 42)
/* 130 */         leftCount = 1; 
/* 132 */       lastDir = 3;
/*     */     } else {
/* 134 */       leftCount = 0;
/*     */     } 
/* 136 */     if (right) {
/* 137 */       rightCount = (byte)(rightCount + 1);
/* 138 */       x++;
/* 139 */       if (rightCount == 42)
/* 140 */         rightCount = 1; 
/* 142 */       lastDir = 4;
/*     */     } else {
/* 144 */       rightCount = 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render(Graphics g) {
/* 150 */     rx = x - Player.mapX + Game.playerSpawnX;
/* 151 */     ry = y - Player.mapY + Game.playerSpawnY;
/* 153 */     Animate.animateEntity(g, (int)rx, (int)ry, im.tdu1, im.tdu2, im.tdu3, 
/* 154 */         im.tdu4, upCount);
/* 155 */     Animate.animateEntity(g, (int)rx, (int)ry, im.tdd1, im.tdd2, im.tdd3, 
/* 156 */         im.tdd4, downCount);
/* 157 */     Animate.animateEntity(g, (int)rx, (int)ry, im.tdl1, im.tdl2, im.tdl3, 
/* 158 */         im.tdl4, leftCount);
/* 159 */     Animate.animateEntity(g, (int)rx, (int)ry, im.tdr1, im.tdr2, im.tdr3, 
/* 160 */         im.tdr4, rightCount);
/* 162 */     if (!up && lastDir == 1)
/* 163 */       g.drawImage(im.tdu1, (int)x, (int)y, null); 
/* 165 */     if (!down && lastDir == 2)
/* 166 */       g.drawImage(im.tdd1, (int)x, (int)y, null); 
/* 168 */     if (!left && lastDir == 3)
/* 169 */       g.drawImage(im.tdl1, (int)x, (int)y, null); 
/* 171 */     if (!right && lastDir == 4)
/* 172 */       g.drawImage(im.tdr1, (int)x, (int)y, null); 
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_4.jar!\beyondOrigins\main\entities\TestDummy.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */