/*     */ package beyondOrigins.main.entities;
/*     */ 
/*     */ import beyondOrigins.main.Game;
/*     */ import beyondOrigins.main.gfx.ImageManager;
/*     */ import java.awt.Graphics;
/*     */ import java.util.Random;
/*     */ 
/*     */ public class Cow {
/*  10 */   Random r = new Random();
/*     */   
/*     */   private int r1;
/*     */   
/*  12 */   public static float cowX = 300.0F;
/*     */   
/*  13 */   public static float cowY = 300.0F;
/*     */   
/*     */   public static float renderX;
/*     */   
/*     */   public static float renderY;
/*     */   
/*  16 */   private static double cowSpeed = 1.0D;
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
/*  23 */   private int upCount = 1;
/*     */   
/*  24 */   private int downCount = 1;
/*     */   
/*  25 */   private int leftCount = 1;
/*     */   
/*  26 */   private int rightCount = 1;
/*     */   
/*  27 */   private static int lastDir = 0;
/*     */   
/*  28 */   private static int stop = 0;
/*     */   
/*     */   private static boolean isStopped = false;
/*     */   
/*  30 */   private static int time = 0;
/*     */   
/*  31 */   private static int time2 = 0;
/*     */   
/*     */   private ImageManager im;
/*     */   
/*     */   public Cow(ImageManager im) {
/*  35 */     this.im = im;
/*     */   }
/*     */   
/*     */   public void tick() {
/*  39 */     time++;
/*  40 */     time2++;
/*  41 */     if (time == 1)
/*  42 */       this.r1 = this.r.nextInt(101); 
/*  44 */     if (time == 100) {
/*  45 */       time = 0;
/*  47 */       isStopped = !isStopped;
/*  48 */       if (isStopped) {
/*  49 */         if (this.up)
/*  50 */           stop = 1; 
/*  52 */         if (this.down)
/*  53 */           stop = 2; 
/*  55 */         if (this.left)
/*  56 */           stop = 3; 
/*  58 */         if (this.right)
/*  59 */           stop = 4; 
/*     */       } else {
/*  62 */         stop = 0;
/*     */       } 
/*     */     } 
/*  65 */     if (time2 == 4)
/*  66 */       time2 = 0; 
/*  68 */     if (this.r1 <= 24 && stop == 0 && cowY >= 11.0F) {
/*  69 */       this.up = true;
/*     */     } else {
/*  71 */       this.up = false;
/*     */     } 
/*  73 */     if (this.r1 <= 49 && this.r1 > 24 && stop == 0 && 
/*  74 */       cowY <= 969.0F) {
/*  75 */       this.down = true;
/*     */     } else {
/*  77 */       this.down = false;
/*     */     } 
/*  79 */     if (this.r1 <= 74 && this.r1 > 49 && stop == 0 && cowX >= 11.0F) {
/*  80 */       this.left = true;
/*     */     } else {
/*  82 */       this.left = false;
/*     */     } 
/*  84 */     if (this.r1 <= 99 && this.r1 > 74 && stop == 0 && 
/*  85 */       cowX <= 780.0F) {
/*  86 */       this.right = true;
/*     */     } else {
/*  88 */       this.right = false;
/*     */     } 
/*  90 */     if (this.up) {
/*  91 */       this.upCount++;
/*  92 */       if (time2 != 1)
/*  93 */         cowY -= (int)cowSpeed; 
/*  95 */       if (this.upCount == 42)
/*  96 */         this.upCount = 1; 
/*  98 */       lastDir = 1;
/*     */     } else {
/* 100 */       this.upCount = 0;
/*     */     } 
/* 102 */     if (this.down) {
/* 103 */       this.downCount++;
/* 104 */       if (time2 != 1)
/* 105 */         cowY += (int)cowSpeed; 
/* 107 */       if (this.downCount == 42)
/* 108 */         this.downCount = 1; 
/* 110 */       lastDir = 2;
/*     */     } else {
/* 112 */       this.downCount = 0;
/*     */     } 
/* 114 */     if (this.left) {
/* 115 */       this.leftCount++;
/* 116 */       if (time2 != 1)
/* 117 */         cowX -= (int)cowSpeed; 
/* 119 */       if (this.leftCount == 42)
/* 120 */         this.leftCount = 1; 
/* 122 */       lastDir = 3;
/*     */     } else {
/* 124 */       this.leftCount = 0;
/*     */     } 
/* 126 */     if (this.right) {
/* 127 */       this.rightCount++;
/* 128 */       if (time2 != 1)
/* 129 */         cowX += (int)cowSpeed; 
/* 131 */       if (this.rightCount == 42)
/* 132 */         this.rightCount = 1; 
/* 134 */       lastDir = 4;
/*     */     } else {
/* 136 */       this.rightCount = 0;
/*     */     } 
/* 138 */     if (stop == 1) {
/* 139 */       this.up = false;
/* 140 */       this.down = false;
/* 141 */       this.left = false;
/* 142 */       this.right = false;
/* 143 */       lastDir = 1;
/*     */     } 
/* 145 */     if (stop == 2) {
/* 146 */       this.up = false;
/* 147 */       this.down = false;
/* 148 */       this.left = false;
/* 149 */       this.right = false;
/* 150 */       lastDir = 2;
/*     */     } 
/* 152 */     if (stop == 3) {
/* 153 */       this.up = false;
/* 154 */       this.down = false;
/* 155 */       this.left = false;
/* 156 */       this.right = false;
/* 157 */       lastDir = 3;
/*     */     } 
/* 159 */     if (stop == 4) {
/* 160 */       this.up = false;
/* 161 */       this.down = false;
/* 162 */       this.left = false;
/* 163 */       this.right = false;
/* 164 */       lastDir = 4;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render(Graphics g) {
/* 169 */     renderX = cowX - Player.mapX + Game.playerSpawnX;
/* 170 */     renderY = cowY - Player.mapY + Game.playerSpawnY;
/* 171 */     if (this.upCount >= 1 && this.upCount <= 11)
/* 172 */       g.drawImage(this.im.cowu1, (int)renderX, (int)renderY, 32, 32, 
/* 173 */           null); 
/* 175 */     if (this.upCount >= 12 && this.upCount <= 21)
/* 176 */       g.drawImage(this.im.cowu2, (int)renderX, (int)renderY, 32, 32, 
/* 177 */           null); 
/* 179 */     if (this.upCount >= 22 && this.upCount <= 31)
/* 180 */       g.drawImage(this.im.cowu3, (int)renderX, (int)renderY, 32, 32, 
/* 181 */           null); 
/* 183 */     if (this.upCount >= 32 && this.upCount <= 41)
/* 184 */       g.drawImage(this.im.cowu4, (int)renderX, (int)renderY, 32, 32, 
/* 185 */           null); 
/* 187 */     if (this.downCount >= 1 && this.downCount <= 11 && this.down)
/* 188 */       g.drawImage(this.im.cowd1, (int)renderX, (int)renderY, 32, 32, 
/* 189 */           null); 
/* 191 */     if (this.downCount >= 12 && this.downCount <= 21 && this.down)
/* 192 */       g.drawImage(this.im.cowd2, (int)renderX, (int)renderY, 32, 32, 
/* 193 */           null); 
/* 195 */     if (this.downCount >= 22 && this.downCount <= 31 && this.down)
/* 196 */       g.drawImage(this.im.cowd3, (int)renderX, (int)renderY, 32, 32, 
/* 197 */           null); 
/* 199 */     if (this.downCount >= 32 && this.downCount <= 41 && this.down)
/* 200 */       g.drawImage(this.im.cowd4, (int)renderX, (int)renderY, 32, 32, 
/* 201 */           null); 
/* 203 */     if (this.leftCount >= 1 && this.leftCount <= 11 && this.left)
/* 204 */       g.drawImage(this.im.cowl1, (int)renderX, (int)renderY, 32, 32, 
/* 205 */           null); 
/* 207 */     if (this.leftCount >= 12 && this.leftCount <= 21 && this.left)
/* 208 */       g.drawImage(this.im.cowl2, (int)renderX, (int)renderY, 32, 32, 
/* 209 */           null); 
/* 211 */     if (this.leftCount >= 22 && this.leftCount <= 31 && this.left)
/* 212 */       g.drawImage(this.im.cowl3, (int)renderX, (int)renderY, 32, 32, 
/* 213 */           null); 
/* 215 */     if (this.leftCount >= 32 && this.leftCount <= 41 && this.left)
/* 216 */       g.drawImage(this.im.cowl4, (int)renderX, (int)renderY, 32, 32, 
/* 217 */           null); 
/* 219 */     if (this.rightCount >= 1 && this.rightCount <= 11 && this.right)
/* 220 */       g.drawImage(this.im.cowr1, (int)renderX, (int)renderY, 32, 32, 
/* 221 */           null); 
/* 223 */     if (this.rightCount >= 12 && this.rightCount <= 21 && this.right)
/* 224 */       g.drawImage(this.im.cowr2, (int)renderX, (int)renderY, 32, 32, 
/* 225 */           null); 
/* 227 */     if (this.rightCount >= 22 && this.rightCount <= 31 && this.right)
/* 228 */       g.drawImage(this.im.cowr3, (int)renderX, (int)renderY, 32, 32, 
/* 229 */           null); 
/* 231 */     if (this.rightCount >= 32 && this.rightCount <= 41 && this.right)
/* 232 */       g.drawImage(this.im.cowr4, (int)renderX, (int)renderY, 32, 32, 
/* 233 */           null); 
/* 235 */     if (lastDir == 0 && !this.up && !this.down && !this.left && 
/* 236 */       !this.right)
/* 237 */       g.drawImage(this.im.cowd1, (int)renderX, (int)renderY, 32, 32, 
/* 238 */           null); 
/* 240 */     if (lastDir == 1 && !this.up)
/* 241 */       g.drawImage(this.im.cowu1, (int)renderX, (int)renderY, 32, 32, 
/* 242 */           null); 
/* 244 */     if (lastDir == 2 && !this.down)
/* 245 */       g.drawImage(this.im.cowd1, (int)renderX, (int)renderY, 32, 32, 
/* 246 */           null); 
/* 248 */     if (lastDir == 3 && !this.left)
/* 249 */       g.drawImage(this.im.cowl1, (int)renderX, (int)renderY, 32, 32, 
/* 250 */           null); 
/* 252 */     if (lastDir == 4 && !this.right)
/* 253 */       g.drawImage(this.im.cowr1, (int)renderX, (int)renderY, 32, 32, 
/* 254 */           null); 
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_3.jar!\beyondOrigins\main\entities\Cow.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */