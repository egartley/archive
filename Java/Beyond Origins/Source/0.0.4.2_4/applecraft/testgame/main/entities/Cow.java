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
/*  15 */   public static float cowX = 300.0F;
/*     */   
/*  16 */   public static float cowY = 300.0F;
/*     */   
/*     */   public static float renderX;
/*     */   
/*     */   public static float renderY;
/*     */   
/*  18 */   private static double cowSpeed = 1.0D;
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
/*  21 */   private int upCount = 1;
/*     */   
/*  21 */   private int downCount = 1;
/*     */   
/*  21 */   private int leftCount = 1;
/*     */   
/*  21 */   private int rightCount = 1;
/*     */   
/*  22 */   private static int lastDir = 0;
/*     */   
/*  23 */   private static int stop = 0;
/*     */   
/*     */   private static boolean isStopped = false;
/*     */   
/*  26 */   private static int time = 0;
/*     */   
/*  27 */   private static int time2 = 0;
/*     */   
/*  28 */   private static int rounds = 0;
/*     */   
/*  29 */   private static int lastRound = 0;
/*     */   
/*     */   private ImageManager im;
/*     */   
/*     */   public Cow(ImageManager im) {
/*  34 */     this.im = im;
/*     */   }
/*     */   
/*     */   public void tick() {
/*  39 */     time++;
/*  40 */     time2++;
/*  47 */     if (time == 1)
/*  48 */       this.r1 = this.r.nextInt(101); 
/*  52 */     if (time == 100) {
/*  54 */       time = 0;
/*  56 */       isStopped = !isStopped;
/*  58 */       if (isStopped) {
/*  60 */         if (this.up)
/*  61 */           stop = 1; 
/*  64 */         if (this.down)
/*  65 */           stop = 2; 
/*  68 */         if (this.left)
/*  69 */           stop = 3; 
/*  72 */         if (this.right)
/*  73 */           stop = 4; 
/*     */       } else {
/*  77 */         stop = 0;
/*     */       } 
/*     */     } 
/*  81 */     if (time2 == 4)
/*  82 */       time2 = 0; 
/*  85 */     if (this.r1 <= 24 && stop == 0 && cowY >= 11.0F) {
/*  86 */       this.up = true;
/*     */     } else {
/*  88 */       this.up = false;
/*     */     } 
/*  90 */     if (this.r1 <= 49 && this.r1 > 24 && stop == 0 && cowY <= 969.0F) {
/*  91 */       this.down = true;
/*     */     } else {
/*  93 */       this.down = false;
/*     */     } 
/*  95 */     if (this.r1 <= 74 && this.r1 > 49 && stop == 0 && cowX >= 11.0F) {
/*  96 */       this.left = true;
/*     */     } else {
/*  98 */       this.left = false;
/*     */     } 
/* 100 */     if (this.r1 <= 99 && this.r1 > 74 && stop == 0 && cowX <= 780.0F) {
/* 101 */       this.right = true;
/*     */     } else {
/* 103 */       this.right = false;
/*     */     } 
/* 105 */     if (this.up) {
/* 107 */       this.upCount++;
/* 109 */       if (time2 != 1)
/* 110 */         cowY -= (int)cowSpeed; 
/* 113 */       if (this.upCount == 42)
/* 114 */         this.upCount = 1; 
/* 117 */       lastDir = 1;
/*     */     } else {
/* 120 */       this.upCount = 0;
/*     */     } 
/* 122 */     if (this.down) {
/* 124 */       this.downCount++;
/* 126 */       if (time2 != 1)
/* 127 */         cowY += (int)cowSpeed; 
/* 130 */       if (this.downCount == 42)
/* 131 */         this.downCount = 1; 
/* 134 */       lastDir = 2;
/*     */     } else {
/* 137 */       this.downCount = 0;
/*     */     } 
/* 139 */     if (this.left) {
/* 141 */       this.leftCount++;
/* 143 */       if (time2 != 1)
/* 144 */         cowX -= (int)cowSpeed; 
/* 147 */       if (this.leftCount == 42)
/* 148 */         this.leftCount = 1; 
/* 151 */       lastDir = 3;
/*     */     } else {
/* 154 */       this.leftCount = 0;
/*     */     } 
/* 156 */     if (this.right) {
/* 158 */       this.rightCount++;
/* 160 */       if (time2 != 1)
/* 161 */         cowX += (int)cowSpeed; 
/* 164 */       if (this.rightCount == 42)
/* 165 */         this.rightCount = 1; 
/* 168 */       lastDir = 4;
/*     */     } else {
/* 171 */       this.rightCount = 0;
/*     */     } 
/* 173 */     if (stop == 1) {
/* 174 */       this.up = false;
/* 175 */       this.down = false;
/* 176 */       this.left = false;
/* 177 */       this.right = false;
/* 178 */       lastDir = 1;
/*     */     } 
/* 181 */     if (stop == 2) {
/* 182 */       this.up = false;
/* 183 */       this.down = false;
/* 184 */       this.left = false;
/* 185 */       this.right = false;
/* 186 */       lastDir = 2;
/*     */     } 
/* 189 */     if (stop == 3) {
/* 190 */       this.up = false;
/* 191 */       this.down = false;
/* 192 */       this.left = false;
/* 193 */       this.right = false;
/* 194 */       lastDir = 3;
/*     */     } 
/* 197 */     if (stop == 4) {
/* 198 */       this.up = false;
/* 199 */       this.down = false;
/* 200 */       this.left = false;
/* 201 */       this.right = false;
/* 202 */       lastDir = 4;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render(Graphics g) {
/* 220 */     renderX = cowX - Player.mapX + Game.playerSpawnX;
/* 221 */     renderY = cowY - Player.mapY + Game.playerSpawnY;
/* 225 */     if (this.upCount >= 1 && this.upCount <= 11)
/* 226 */       g.drawImage(this.im.cowu1, (int)renderX, (int)renderY, 
/* 227 */           32, 32, null); 
/* 230 */     if (this.upCount >= 12 && this.upCount <= 21)
/* 231 */       g.drawImage(this.im.cowu2, (int)renderX, (int)renderY, 
/* 232 */           32, 32, null); 
/* 235 */     if (this.upCount >= 22 && this.upCount <= 31)
/* 236 */       g.drawImage(this.im.cowu3, (int)renderX, (int)renderY, 
/* 237 */           32, 32, null); 
/* 240 */     if (this.upCount >= 32 && this.upCount <= 41)
/* 241 */       g.drawImage(this.im.cowu4, (int)renderX, (int)renderY, 
/* 242 */           32, 32, null); 
/* 247 */     if (this.downCount >= 1 && this.downCount <= 11 && this.down)
/* 248 */       g.drawImage(this.im.cowd1, (int)renderX, (int)renderY, 
/* 249 */           32, 32, null); 
/* 252 */     if (this.downCount >= 12 && this.downCount <= 21 && this.down)
/* 253 */       g.drawImage(this.im.cowd2, (int)renderX, (int)renderY, 
/* 254 */           32, 32, null); 
/* 257 */     if (this.downCount >= 22 && this.downCount <= 31 && this.down)
/* 258 */       g.drawImage(this.im.cowd3, (int)renderX, (int)renderY, 
/* 259 */           32, 32, null); 
/* 262 */     if (this.downCount >= 32 && this.downCount <= 41 && this.down)
/* 263 */       g.drawImage(this.im.cowd4, (int)renderX, (int)renderY, 
/* 264 */           32, 32, null); 
/* 269 */     if (this.leftCount >= 1 && this.leftCount <= 11 && this.left)
/* 270 */       g.drawImage(this.im.cowl1, (int)renderX, (int)renderY, 
/* 271 */           32, 32, null); 
/* 274 */     if (this.leftCount >= 12 && this.leftCount <= 21 && this.left)
/* 275 */       g.drawImage(this.im.cowl2, (int)renderX, (int)renderY, 
/* 276 */           32, 32, null); 
/* 279 */     if (this.leftCount >= 22 && this.leftCount <= 31 && this.left)
/* 280 */       g.drawImage(this.im.cowl3, (int)renderX, (int)renderY, 
/* 281 */           32, 32, null); 
/* 284 */     if (this.leftCount >= 32 && this.leftCount <= 41 && this.left)
/* 285 */       g.drawImage(this.im.cowl4, (int)renderX, (int)renderY, 
/* 286 */           32, 32, null); 
/* 291 */     if (this.rightCount >= 1 && this.rightCount <= 11 && this.right)
/* 292 */       g.drawImage(this.im.cowr1, (int)renderX, (int)renderY, 
/* 293 */           32, 32, null); 
/* 296 */     if (this.rightCount >= 12 && this.rightCount <= 21 && this.right)
/* 297 */       g.drawImage(this.im.cowr2, (int)renderX, (int)renderY, 
/* 298 */           32, 32, null); 
/* 301 */     if (this.rightCount >= 22 && this.rightCount <= 31 && this.right)
/* 302 */       g.drawImage(this.im.cowr3, (int)renderX, (int)renderY, 
/* 303 */           32, 32, null); 
/* 306 */     if (this.rightCount >= 32 && this.rightCount <= 41 && this.right)
/* 307 */       g.drawImage(this.im.cowr4, (int)renderX, (int)renderY, 
/* 308 */           32, 32, null); 
/* 313 */     if (lastDir == 0 && 
/* 314 */       !this.up && !this.down && !this.left && !this.right)
/* 315 */       g.drawImage(this.im.cowd1, (int)renderX, (int)renderY, 
/* 316 */           32, 32, null); 
/* 319 */     if (lastDir == 1 && !this.up)
/* 320 */       g.drawImage(this.im.cowu1, (int)renderX, (int)renderY, 
/* 321 */           32, 32, null); 
/* 324 */     if (lastDir == 2 && !this.down)
/* 325 */       g.drawImage(this.im.cowd1, (int)renderX, (int)renderY, 
/* 326 */           32, 32, null); 
/* 329 */     if (lastDir == 3 && !this.left)
/* 330 */       g.drawImage(this.im.cowl1, (int)renderX, (int)renderY, 
/* 331 */           32, 32, null); 
/* 334 */     if (lastDir == 4 && !this.right)
/* 335 */       g.drawImage(this.im.cowr1, (int)renderX, (int)renderY, 
/* 336 */           32, 32, null); 
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4.2_4.jar!\applecraft\testgame\main\entities\Cow.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */