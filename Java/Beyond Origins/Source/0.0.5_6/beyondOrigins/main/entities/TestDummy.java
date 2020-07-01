/*     */ package beyondOrigins.main.entities;
/*     */ 
/*     */ import beyondOrigins.main.Game;
/*     */ import beyondOrigins.main.gfx.Animate;
/*     */ import beyondOrigins.main.gfx.ImageManager;
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
/*  32 */   private static int attackRadius = 32;
/*     */   
/*     */   public TestDummy() {
/*  35 */     a = new Animate();
/*     */   }
/*     */   
/*     */   public void kill() {
/*  39 */     isDead = true;
/*     */   }
/*     */   
/*     */   public static void reset() {
/*  43 */     isDead = false;
/*  44 */     health = maxHealth;
/*     */   }
/*     */   
/*     */   private void decideMovement(int n) {
/*  48 */     if (n == 0 && stop == 0 && y >= 11.0F) {
/*  49 */       up = true;
/*     */     } else {
/*  51 */       up = false;
/*     */     } 
/*  52 */     if (n == 1 && stop == 0 && y <= 969.0F) {
/*  53 */       down = true;
/*     */     } else {
/*  55 */       down = false;
/*     */     } 
/*  56 */     if (n == 2 && stop == 0 && x >= 11.0F) {
/*  57 */       left = true;
/*     */     } else {
/*  59 */       left = false;
/*     */     } 
/*  60 */     if (n == 3 && stop == 0 && x <= 780.0F) {
/*  61 */       right = true;
/*     */     } else {
/*  63 */       right = false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void tick() {
/*  67 */     if (!isDead) {
/*  68 */       if (health <= 0.0D) {
/*  69 */         health = 0.0D;
/*  70 */         kill();
/*     */       } 
/*  74 */       if (lastDir == 0)
/*  75 */         lastDir = 2; 
/*  78 */       if (y <= 11.0F) {
/*  79 */         up = false;
/*  80 */         down = true;
/*     */       } 
/*  82 */       if (y >= 969.0F) {
/*  83 */         down = false;
/*  84 */         up = true;
/*     */       } 
/*  86 */       if (x <= 11.0F) {
/*  87 */         left = false;
/*  88 */         right = true;
/*     */       } 
/*  90 */       if (x >= 1000.0F) {
/*  91 */         right = false;
/*  92 */         left = true;
/*     */       } 
/*  95 */       t = (byte)(t + 1);
/*  96 */       if (t == 35) {
/*  97 */         this.num = this.r.nextInt(4);
/*  98 */         decideMovement(this.num);
/*     */       } 
/* 100 */       if (t >= 200) {
/* 101 */         t = 0;
/* 102 */         stopped = !stopped;
/* 103 */         if (stopped) {
/* 104 */           if (up)
/* 105 */             stop = 1; 
/* 107 */           if (down)
/* 108 */             stop = 2; 
/* 110 */           if (left)
/* 111 */             stop = 3; 
/* 113 */           if (right)
/* 114 */             stop = 4; 
/*     */         } else {
/* 117 */           stop = 0;
/*     */         } 
/*     */       } 
/* 128 */       if (up) {
/* 129 */         upCount = (byte)(upCount + 1);
/* 130 */         y--;
/* 131 */         if (upCount == 42)
/* 132 */           upCount = 1; 
/* 134 */         lastDir = 1;
/*     */       } else {
/* 136 */         upCount = 0;
/*     */       } 
/* 138 */       if (down) {
/* 139 */         downCount = (byte)(downCount + 1);
/* 140 */         y++;
/* 141 */         if (downCount == 42)
/* 142 */           downCount = 1; 
/* 144 */         lastDir = 2;
/*     */       } else {
/* 146 */         downCount = 0;
/*     */       } 
/* 148 */       if (left) {
/* 149 */         leftCount = (byte)(leftCount + 1);
/* 150 */         x--;
/* 151 */         if (leftCount == 42)
/* 152 */           leftCount = 1; 
/* 154 */         lastDir = 3;
/*     */       } else {
/* 156 */         leftCount = 0;
/*     */       } 
/* 158 */       if (right) {
/* 159 */         rightCount = (byte)(rightCount + 1);
/* 160 */         x++;
/* 161 */         if (rightCount == 42)
/* 162 */           rightCount = 1; 
/* 164 */         lastDir = 4;
/*     */       } else {
/* 166 */         rightCount = 0;
/*     */       } 
/*     */     } 
/* 169 */     if (Math.sqrt(((rx - Player.x) * (rx - Player.x) + (ry - Player.y) * (
/* 170 */         ry - Player.y))) <= attackRadius)
/* 171 */       Player.takeDamage(0.5D); 
/*     */   }
/*     */   
/*     */   public void render(Graphics g) {
/* 177 */     if (!isDead) {
/* 178 */       rx = x - Player.mapX + Game.playerSpawnX;
/* 179 */       ry = y - Player.mapY + Game.playerSpawnY;
/* 181 */       a.animateEntity(g, (int)rx, (int)ry, ImageManager.tdu1, 
/* 182 */           ImageManager.tdu2, ImageManager.tdu3, ImageManager.tdu4, 
/* 183 */           upCount);
/* 184 */       a.animateEntity(g, (int)rx, (int)ry, ImageManager.tdd1, 
/* 185 */           ImageManager.tdd2, ImageManager.tdd3, ImageManager.tdd4, 
/* 186 */           downCount);
/* 187 */       a.animateEntity(g, (int)rx, (int)ry, ImageManager.tdl1, 
/* 188 */           ImageManager.tdl2, ImageManager.tdl3, ImageManager.tdl4, 
/* 189 */           leftCount);
/* 190 */       a.animateEntity(g, (int)rx, (int)ry, ImageManager.tdr1, 
/* 191 */           ImageManager.tdr2, ImageManager.tdr3, ImageManager.tdr4, 
/* 192 */           rightCount);
/* 194 */       if (!up && lastDir == 1) {
/* 195 */         g.drawImage(ImageManager.tdu1, (int)rx, (int)ry, null);
/* 196 */         cf = ImageManager.tdu1;
/*     */       } 
/* 198 */       if (!down && lastDir == 2) {
/* 199 */         g.drawImage(ImageManager.tdd1, (int)rx, (int)ry, null);
/* 200 */         cf = ImageManager.tdd1;
/*     */       } 
/* 202 */       if (!left && lastDir == 3) {
/* 203 */         g.drawImage(ImageManager.tdl1, (int)rx, (int)ry, null);
/* 204 */         cf = ImageManager.tdl1;
/*     */       } 
/* 206 */       if (!right && lastDir == 4) {
/* 207 */         g.drawImage(ImageManager.tdr1, (int)rx, (int)ry, null);
/* 208 */         cf = ImageManager.tdr1;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_6.jar!\beyondOrigins\main\entities\TestDummy.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */