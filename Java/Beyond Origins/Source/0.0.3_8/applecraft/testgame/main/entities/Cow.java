/*     */ package applecraft.testgame.main.entities;
/*     */ 
/*     */ import applecraft.testgame.main.Game;
/*     */ import applecraft.testgame.main.gfx.ImageManager;
/*     */ import java.awt.Graphics;
/*     */ import java.util.Random;
/*     */ 
/*     */ public class Cow {
/*  11 */   Random r = new Random();
/*     */   
/*     */   private int r1;
/*     */   
/*     */   private int r2;
/*     */   
/*     */   private int r3;
/*     */   
/*     */   private int r4;
/*     */   
/*     */   private boolean randomRequest = false;
/*     */   
/*  19 */   public static float cowX = 300.0F;
/*     */   
/*  20 */   public static float cowY = 300.0F;
/*     */   
/*     */   public static float renderX;
/*     */   
/*     */   public static float renderY;
/*     */   
/*  22 */   private static double cowSpeed = 1.0D;
/*     */   
/*     */   public int x;
/*     */   
/*     */   public int y;
/*     */   
/*     */   private boolean up;
/*     */   
/*     */   private boolean down;
/*     */   
/*     */   private boolean left;
/*     */   
/*     */   private boolean right;
/*     */   
/*  25 */   private int upCount = 1;
/*     */   
/*  25 */   private int downCount = 1;
/*     */   
/*  25 */   private int leftCount = 1;
/*     */   
/*  25 */   private int rightCount = 1;
/*     */   
/*  26 */   private static int lastDir = 0;
/*     */   
/*  27 */   private static int stop = 0;
/*     */   
/*     */   private static boolean isStopped = false;
/*     */   
/*  30 */   private static int time = 0;
/*     */   
/*  31 */   private static int time2 = 0;
/*     */   
/*  32 */   private static int rounds = 0;
/*     */   
/*  33 */   private static int lastRound = 0;
/*     */   
/*     */   private ImageManager im;
/*     */   
/*     */   public Cow(ImageManager im) {
/*  38 */     this.im = im;
/*     */   }
/*     */   
/*     */   public void tick() {
/*  43 */     time++;
/*  44 */     time2++;
/*  51 */     if (time == 1)
/*  52 */       this.r1 = this.r.nextInt(101); 
/*  56 */     if (time == 100) {
/*  58 */       time = 0;
/*  60 */       isStopped = !isStopped;
/*  62 */       if (isStopped) {
/*  64 */         if (this.up)
/*  65 */           stop = 1; 
/*  68 */         if (this.down)
/*  69 */           stop = 2; 
/*  72 */         if (this.left)
/*  73 */           stop = 3; 
/*  76 */         if (this.right)
/*  77 */           stop = 4; 
/*     */       } else {
/*  81 */         stop = 0;
/*     */       } 
/*     */     } 
/*  85 */     if (time2 == 4)
/*  86 */       time2 = 0; 
/*  89 */     if (this.r1 <= 24 && stop == 0 && cowY >= 11.0F) {
/*  90 */       this.up = true;
/*     */     } else {
/*  92 */       this.up = false;
/*     */     } 
/*  94 */     if (this.r1 <= 49 && this.r1 > 24 && stop == 0 && cowY <= 969.0F) {
/*  95 */       this.down = true;
/*     */     } else {
/*  97 */       this.down = false;
/*     */     } 
/*  99 */     if (this.r1 <= 74 && this.r1 > 49 && stop == 0 && cowX >= 11.0F) {
/* 100 */       this.left = true;
/*     */     } else {
/* 102 */       this.left = false;
/*     */     } 
/* 104 */     if (this.r1 <= 99 && this.r1 > 74 && stop == 0 && cowX <= 780.0F) {
/* 105 */       this.right = true;
/*     */     } else {
/* 107 */       this.right = false;
/*     */     } 
/* 109 */     if (this.up) {
/* 111 */       this.upCount++;
/* 113 */       if (time2 != 1)
/* 114 */         cowY -= (int)cowSpeed; 
/* 117 */       if (this.upCount == 42)
/* 118 */         this.upCount = 1; 
/* 121 */       lastDir = 1;
/*     */     } else {
/* 124 */       this.upCount = 0;
/*     */     } 
/* 126 */     if (this.down) {
/* 128 */       this.downCount++;
/* 130 */       if (time2 != 1)
/* 131 */         cowY += (int)cowSpeed; 
/* 134 */       if (this.downCount == 42)
/* 135 */         this.downCount = 1; 
/* 138 */       lastDir = 2;
/*     */     } else {
/* 141 */       this.downCount = 0;
/*     */     } 
/* 143 */     if (this.left) {
/* 145 */       this.leftCount++;
/* 147 */       if (time2 != 1)
/* 148 */         cowX -= (int)cowSpeed; 
/* 151 */       if (this.leftCount == 42)
/* 152 */         this.leftCount = 1; 
/* 155 */       lastDir = 3;
/*     */     } else {
/* 158 */       this.leftCount = 0;
/*     */     } 
/* 160 */     if (this.right) {
/* 162 */       this.rightCount++;
/* 164 */       if (time2 != 1)
/* 165 */         cowX += (int)cowSpeed; 
/* 168 */       if (this.rightCount == 42)
/* 169 */         this.rightCount = 1; 
/* 172 */       lastDir = 4;
/*     */     } else {
/* 175 */       this.rightCount = 0;
/*     */     } 
/* 177 */     if (stop == 1) {
/* 178 */       this.up = false;
/* 179 */       this.down = false;
/* 180 */       this.left = false;
/* 181 */       this.right = false;
/* 182 */       lastDir = 1;
/*     */     } 
/* 185 */     if (stop == 2) {
/* 186 */       this.up = false;
/* 187 */       this.down = false;
/* 188 */       this.left = false;
/* 189 */       this.right = false;
/* 190 */       lastDir = 2;
/*     */     } 
/* 193 */     if (stop == 3) {
/* 194 */       this.up = false;
/* 195 */       this.down = false;
/* 196 */       this.left = false;
/* 197 */       this.right = false;
/* 198 */       lastDir = 3;
/*     */     } 
/* 201 */     if (stop == 4) {
/* 202 */       this.up = false;
/* 203 */       this.down = false;
/* 204 */       this.left = false;
/* 205 */       this.right = false;
/* 206 */       lastDir = 4;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render(Graphics g) {
/* 224 */     renderX = cowX - Player.mapX + Game.playerSpawnX;
/* 225 */     renderY = cowY - Player.mapY + Game.playerSpawnY;
/* 229 */     if (this.upCount >= 1 && this.upCount <= 11)
/* 230 */       g.drawImage(this.im.cowu1, (int)renderX, (int)renderY, 
/* 231 */           32, 32, null); 
/* 234 */     if (this.upCount >= 12 && this.upCount <= 21)
/* 235 */       g.drawImage(this.im.cowu2, (int)renderX, (int)renderY, 
/* 236 */           32, 32, null); 
/* 239 */     if (this.upCount >= 22 && this.upCount <= 31)
/* 240 */       g.drawImage(this.im.cowu3, (int)renderX, (int)renderY, 
/* 241 */           32, 32, null); 
/* 244 */     if (this.upCount >= 32 && this.upCount <= 41)
/* 245 */       g.drawImage(this.im.cowu4, (int)renderX, (int)renderY, 
/* 246 */           32, 32, null); 
/* 251 */     if (this.downCount >= 1 && this.downCount <= 11 && this.down)
/* 252 */       g.drawImage(this.im.cowd1, (int)renderX, (int)renderY, 
/* 253 */           32, 32, null); 
/* 256 */     if (this.downCount >= 12 && this.downCount <= 21 && this.down)
/* 257 */       g.drawImage(this.im.cowd2, (int)renderX, (int)renderY, 
/* 258 */           32, 32, null); 
/* 261 */     if (this.downCount >= 22 && this.downCount <= 31 && this.down)
/* 262 */       g.drawImage(this.im.cowd3, (int)renderX, (int)renderY, 
/* 263 */           32, 32, null); 
/* 266 */     if (this.downCount >= 32 && this.downCount <= 41 && this.down)
/* 267 */       g.drawImage(this.im.cowd4, (int)renderX, (int)renderY, 
/* 268 */           32, 32, null); 
/* 273 */     if (this.leftCount >= 1 && this.leftCount <= 11 && this.left)
/* 274 */       g.drawImage(this.im.cowl1, (int)renderX, (int)renderY, 
/* 275 */           32, 32, null); 
/* 278 */     if (this.leftCount >= 12 && this.leftCount <= 21 && this.left)
/* 279 */       g.drawImage(this.im.cowl2, (int)renderX, (int)renderY, 
/* 280 */           32, 32, null); 
/* 283 */     if (this.leftCount >= 22 && this.leftCount <= 31 && this.left)
/* 284 */       g.drawImage(this.im.cowl3, (int)renderX, (int)renderY, 
/* 285 */           32, 32, null); 
/* 288 */     if (this.leftCount >= 32 && this.leftCount <= 41 && this.left)
/* 289 */       g.drawImage(this.im.cowl4, (int)renderX, (int)renderY, 
/* 290 */           32, 32, null); 
/* 295 */     if (this.rightCount >= 1 && this.rightCount <= 11 && this.right)
/* 296 */       g.drawImage(this.im.cowr1, (int)renderX, (int)renderY, 
/* 297 */           32, 32, null); 
/* 300 */     if (this.rightCount >= 12 && this.rightCount <= 21 && this.right)
/* 301 */       g.drawImage(this.im.cowr2, (int)renderX, (int)renderY, 
/* 302 */           32, 32, null); 
/* 305 */     if (this.rightCount >= 22 && this.rightCount <= 31 && this.right)
/* 306 */       g.drawImage(this.im.cowr3, (int)renderX, (int)renderY, 
/* 307 */           32, 32, null); 
/* 310 */     if (this.rightCount >= 32 && this.rightCount <= 41 && this.right)
/* 311 */       g.drawImage(this.im.cowr4, (int)renderX, (int)renderY, 
/* 312 */           32, 32, null); 
/* 317 */     if (lastDir == 0 && 
/* 318 */       !this.up && !this.down && !this.left && !this.right)
/* 319 */       g.drawImage(this.im.cowd1, (int)renderX, (int)renderY, 
/* 320 */           32, 32, null); 
/* 323 */     if (lastDir == 1 && !this.up)
/* 324 */       g.drawImage(this.im.cowu1, (int)renderX, (int)renderY, 
/* 325 */           32, 32, null); 
/* 328 */     if (lastDir == 2 && !this.down)
/* 329 */       g.drawImage(this.im.cowd1, (int)renderX, (int)renderY, 
/* 330 */           32, 32, null); 
/* 333 */     if (lastDir == 3 && !this.left)
/* 334 */       g.drawImage(this.im.cowl1, (int)renderX, (int)renderY, 
/* 335 */           32, 32, null); 
/* 338 */     if (lastDir == 4 && !this.right)
/* 339 */       g.drawImage(this.im.cowr1, (int)renderX, (int)renderY, 
/* 340 */           32, 32, null); 
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.3_8.jar!\applecraft\testgame\main\entities\Cow.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */