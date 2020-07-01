/*     */ package beyondOrigins.main.entities;
/*     */ 
/*     */ import beyondOrigins.main.Game;
/*     */ import beyondOrigins.main.gfx.ImageManager;
/*     */ import beyondOrigins.threads.Animate;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.util.Random;
/*     */ 
/*     */ public class TestDummy {
/*  13 */   private Random r = new Random();
/*     */   
/*     */   private int num;
/*     */   
/*     */   public static boolean isDead = false;
/*     */   
/*     */   public static boolean test;
/*     */   
/*     */   public static BufferedImage cf;
/*     */   
/*     */   private static Animate a;
/*     */   
/*  22 */   public static float x = 200.0F;
/*     */   
/*  22 */   public static float y = 200.0F;
/*     */   
/*     */   public static float rx;
/*     */   
/*     */   public static float ry;
/*     */   
/*  23 */   public static byte upCount = 1, downCount = 1, leftCount = 1;
/*     */   
/*  24 */   public static byte rightCount = 1;
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
/*  29 */   public static double maxHealth = 20.0D;
/*     */   
/*  29 */   public static double health = 20.0D;
/*     */   
/*     */   private static ImageManager im;
/*     */   
/*     */   public TestDummy(ImageManager im) {
/*  35 */     TestDummy.im = im;
/*  36 */     a = new Animate();
/*     */   }
/*     */   
/*     */   public void kill() {
/*  40 */     isDead = true;
/*     */   }
/*     */   
/*     */   private void decideMovement(int n) {
/*  44 */     if (n == 0 && stop == 0 && y >= 11.0F) {
/*  45 */       up = true;
/*     */     } else {
/*  47 */       up = false;
/*     */     } 
/*  48 */     if (n == 1 && stop == 0 && y <= 969.0F) {
/*  49 */       down = true;
/*     */     } else {
/*  51 */       down = false;
/*     */     } 
/*  52 */     if (n == 2 && stop == 0 && x >= 11.0F) {
/*  53 */       left = true;
/*     */     } else {
/*  55 */       left = false;
/*     */     } 
/*  56 */     if (n == 3 && stop == 0 && x <= 780.0F) {
/*  57 */       right = true;
/*     */     } else {
/*  59 */       right = false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void tick() {
/*  63 */     if (!isDead) {
/*  64 */       if (health <= 0.0D) {
/*  65 */         health = 0.0D;
/*  66 */         kill();
/*     */       } 
/*  70 */       if (lastDir == 0)
/*  71 */         lastDir = 2; 
/*  74 */       if (y <= 11.0F) {
/*  75 */         up = false;
/*  76 */         down = true;
/*     */       } 
/*  78 */       if (y >= 969.0F) {
/*  79 */         down = false;
/*  80 */         up = true;
/*     */       } 
/*  82 */       if (x <= 11.0F) {
/*  83 */         left = false;
/*  84 */         right = true;
/*     */       } 
/*  86 */       if (x >= 1000.0F) {
/*  87 */         right = false;
/*  88 */         left = true;
/*     */       } 
/*  91 */       t = (byte)(t + 1);
/*  92 */       if (t == 35) {
/*  93 */         this.num = this.r.nextInt(4);
/*  94 */         decideMovement(this.num);
/*     */       } 
/*  96 */       if (t >= 200) {
/*  97 */         t = 0;
/*  98 */         stopped = !stopped;
/*  99 */         if (stopped) {
/* 100 */           if (up)
/* 101 */             stop = 1; 
/* 103 */           if (down)
/* 104 */             stop = 2; 
/* 106 */           if (left)
/* 107 */             stop = 3; 
/* 109 */           if (right)
/* 110 */             stop = 4; 
/*     */         } else {
/* 113 */           stop = 0;
/*     */         } 
/*     */       } 
/* 125 */       if (up) {
/* 126 */         upCount = (byte)(upCount + 1);
/* 127 */         y--;
/* 128 */         if (upCount == 42)
/* 129 */           upCount = 1; 
/* 131 */         lastDir = 1;
/*     */       } else {
/* 133 */         upCount = 0;
/*     */       } 
/* 135 */       if (down) {
/* 136 */         downCount = (byte)(downCount + 1);
/* 137 */         y++;
/* 138 */         if (downCount == 42)
/* 139 */           downCount = 1; 
/* 141 */         lastDir = 2;
/*     */       } else {
/* 143 */         downCount = 0;
/*     */       } 
/* 145 */       if (left) {
/* 146 */         leftCount = (byte)(leftCount + 1);
/* 147 */         x--;
/* 148 */         if (leftCount == 42)
/* 149 */           leftCount = 1; 
/* 151 */         lastDir = 3;
/*     */       } else {
/* 153 */         leftCount = 0;
/*     */       } 
/* 155 */       if (right) {
/* 156 */         rightCount = (byte)(rightCount + 1);
/* 157 */         x++;
/* 158 */         if (rightCount == 42)
/* 159 */           rightCount = 1; 
/* 161 */         lastDir = 4;
/*     */       } else {
/* 163 */         rightCount = 0;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render(Graphics g) {
/* 169 */     if (!isDead) {
/* 170 */       rx = x - Player.mapX + Game.playerSpawnX;
/* 171 */       ry = y - Player.mapY + Game.playerSpawnY;
/* 173 */       a.animateEntity(g, (int)rx, (int)ry, im.tdu1, im.tdu2, im.tdu3, 
/* 174 */           im.tdu4, upCount);
/* 175 */       a.animateEntity(g, (int)rx, (int)ry, im.tdd1, im.tdd2, im.tdd3, 
/* 176 */           im.tdd4, downCount);
/* 177 */       a.animateEntity(g, (int)rx, (int)ry, im.tdl1, im.tdl2, im.tdl3, 
/* 178 */           im.tdl4, leftCount);
/* 179 */       a.animateEntity(g, (int)rx, (int)ry, im.tdr1, im.tdr2, im.tdr3, 
/* 180 */           im.tdr4, rightCount);
/* 182 */       if (!up && lastDir == 1) {
/* 183 */         g.drawImage(im.tdu1, (int)rx, (int)ry, null);
/* 184 */         cf = im.tdu1;
/*     */       } 
/* 186 */       if (!down && lastDir == 2) {
/* 187 */         g.drawImage(im.tdd1, (int)rx, (int)ry, null);
/* 188 */         cf = im.tdd1;
/*     */       } 
/* 190 */       if (!left && lastDir == 3) {
/* 191 */         g.drawImage(im.tdl1, (int)rx, (int)ry, null);
/* 192 */         cf = im.tdl1;
/*     */       } 
/* 194 */       if (!right && lastDir == 4) {
/* 195 */         g.drawImage(im.tdr1, (int)rx, (int)ry, null);
/* 196 */         cf = im.tdr1;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_5.jar!\beyondOrigins\main\entities\TestDummy.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */