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
/*  32 */   private static int rounds = 0;
/*     */   
/*  33 */   private static int lastRound = 0;
/*     */   
/*     */   private ImageManager im;
/*     */   
/*     */   public Cow(ImageManager im) {
/*  37 */     this.im = im;
/*     */   }
/*     */   
/*     */   public void tick() {
/*  41 */     time++;
/*  42 */     time2++;
/*  43 */     if (time == 1)
/*  44 */       this.r1 = this.r.nextInt(101); 
/*  46 */     if (time == 100) {
/*  47 */       time = 0;
/*  49 */       isStopped = !isStopped;
/*  50 */       if (isStopped) {
/*  51 */         if (this.up)
/*  52 */           stop = 1; 
/*  54 */         if (this.down)
/*  55 */           stop = 2; 
/*  57 */         if (this.left)
/*  58 */           stop = 3; 
/*  60 */         if (this.right)
/*  61 */           stop = 4; 
/*     */       } else {
/*  64 */         stop = 0;
/*     */       } 
/*     */     } 
/*  67 */     if (time2 == 4)
/*  68 */       time2 = 0; 
/*  70 */     if (this.r1 <= 24 && stop == 0 && cowY >= 11.0F) {
/*  71 */       this.up = true;
/*     */     } else {
/*  73 */       this.up = false;
/*     */     } 
/*  75 */     if (this.r1 <= 49 && this.r1 > 24 && stop == 0 && 
/*  76 */       cowY <= 969.0F) {
/*  77 */       this.down = true;
/*     */     } else {
/*  79 */       this.down = false;
/*     */     } 
/*  81 */     if (this.r1 <= 74 && this.r1 > 49 && stop == 0 && cowX >= 11.0F) {
/*  82 */       this.left = true;
/*     */     } else {
/*  84 */       this.left = false;
/*     */     } 
/*  86 */     if (this.r1 <= 99 && this.r1 > 74 && stop == 0 && 
/*  87 */       cowX <= 780.0F) {
/*  88 */       this.right = true;
/*     */     } else {
/*  90 */       this.right = false;
/*     */     } 
/*  92 */     if (this.up) {
/*  93 */       this.upCount++;
/*  94 */       if (time2 != 1)
/*  95 */         cowY -= (int)cowSpeed; 
/*  97 */       if (this.upCount == 42)
/*  98 */         this.upCount = 1; 
/* 100 */       lastDir = 1;
/*     */     } else {
/* 102 */       this.upCount = 0;
/*     */     } 
/* 104 */     if (this.down) {
/* 105 */       this.downCount++;
/* 106 */       if (time2 != 1)
/* 107 */         cowY += (int)cowSpeed; 
/* 109 */       if (this.downCount == 42)
/* 110 */         this.downCount = 1; 
/* 112 */       lastDir = 2;
/*     */     } else {
/* 114 */       this.downCount = 0;
/*     */     } 
/* 116 */     if (this.left) {
/* 117 */       this.leftCount++;
/* 118 */       if (time2 != 1)
/* 119 */         cowX -= (int)cowSpeed; 
/* 121 */       if (this.leftCount == 42)
/* 122 */         this.leftCount = 1; 
/* 124 */       lastDir = 3;
/*     */     } else {
/* 126 */       this.leftCount = 0;
/*     */     } 
/* 128 */     if (this.right) {
/* 129 */       this.rightCount++;
/* 130 */       if (time2 != 1)
/* 131 */         cowX += (int)cowSpeed; 
/* 133 */       if (this.rightCount == 42)
/* 134 */         this.rightCount = 1; 
/* 136 */       lastDir = 4;
/*     */     } else {
/* 138 */       this.rightCount = 0;
/*     */     } 
/* 140 */     if (stop == 1) {
/* 141 */       this.up = false;
/* 142 */       this.down = false;
/* 143 */       this.left = false;
/* 144 */       this.right = false;
/* 145 */       lastDir = 1;
/*     */     } 
/* 147 */     if (stop == 2) {
/* 148 */       this.up = false;
/* 149 */       this.down = false;
/* 150 */       this.left = false;
/* 151 */       this.right = false;
/* 152 */       lastDir = 2;
/*     */     } 
/* 154 */     if (stop == 3) {
/* 155 */       this.up = false;
/* 156 */       this.down = false;
/* 157 */       this.left = false;
/* 158 */       this.right = false;
/* 159 */       lastDir = 3;
/*     */     } 
/* 161 */     if (stop == 4) {
/* 162 */       this.up = false;
/* 163 */       this.down = false;
/* 164 */       this.left = false;
/* 165 */       this.right = false;
/* 166 */       lastDir = 4;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render(Graphics g) {
/* 171 */     renderX = cowX - Player.mapX + Game.playerSpawnX;
/* 172 */     renderY = cowY - Player.mapY + Game.playerSpawnY;
/* 173 */     if (this.upCount >= 1 && this.upCount <= 11)
/* 174 */       g.drawImage(this.im.cowu1, (int)renderX, (int)renderY, 32, 32, 
/* 175 */           null); 
/* 177 */     if (this.upCount >= 12 && this.upCount <= 21)
/* 178 */       g.drawImage(this.im.cowu2, (int)renderX, (int)renderY, 32, 32, 
/* 179 */           null); 
/* 181 */     if (this.upCount >= 22 && this.upCount <= 31)
/* 182 */       g.drawImage(this.im.cowu3, (int)renderX, (int)renderY, 32, 32, 
/* 183 */           null); 
/* 185 */     if (this.upCount >= 32 && this.upCount <= 41)
/* 186 */       g.drawImage(this.im.cowu4, (int)renderX, (int)renderY, 32, 32, 
/* 187 */           null); 
/* 189 */     if (this.downCount >= 1 && this.downCount <= 11 && this.down)
/* 190 */       g.drawImage(this.im.cowd1, (int)renderX, (int)renderY, 32, 32, 
/* 191 */           null); 
/* 193 */     if (this.downCount >= 12 && this.downCount <= 21 && this.down)
/* 194 */       g.drawImage(this.im.cowd2, (int)renderX, (int)renderY, 32, 32, 
/* 195 */           null); 
/* 197 */     if (this.downCount >= 22 && this.downCount <= 31 && this.down)
/* 198 */       g.drawImage(this.im.cowd3, (int)renderX, (int)renderY, 32, 32, 
/* 199 */           null); 
/* 201 */     if (this.downCount >= 32 && this.downCount <= 41 && this.down)
/* 202 */       g.drawImage(this.im.cowd4, (int)renderX, (int)renderY, 32, 32, 
/* 203 */           null); 
/* 205 */     if (this.leftCount >= 1 && this.leftCount <= 11 && this.left)
/* 206 */       g.drawImage(this.im.cowl1, (int)renderX, (int)renderY, 32, 32, 
/* 207 */           null); 
/* 209 */     if (this.leftCount >= 12 && this.leftCount <= 21 && this.left)
/* 210 */       g.drawImage(this.im.cowl2, (int)renderX, (int)renderY, 32, 32, 
/* 211 */           null); 
/* 213 */     if (this.leftCount >= 22 && this.leftCount <= 31 && this.left)
/* 214 */       g.drawImage(this.im.cowl3, (int)renderX, (int)renderY, 32, 32, 
/* 215 */           null); 
/* 217 */     if (this.leftCount >= 32 && this.leftCount <= 41 && this.left)
/* 218 */       g.drawImage(this.im.cowl4, (int)renderX, (int)renderY, 32, 32, 
/* 219 */           null); 
/* 221 */     if (this.rightCount >= 1 && this.rightCount <= 11 && this.right)
/* 222 */       g.drawImage(this.im.cowr1, (int)renderX, (int)renderY, 32, 32, 
/* 223 */           null); 
/* 225 */     if (this.rightCount >= 12 && this.rightCount <= 21 && this.right)
/* 226 */       g.drawImage(this.im.cowr2, (int)renderX, (int)renderY, 32, 32, 
/* 227 */           null); 
/* 229 */     if (this.rightCount >= 22 && this.rightCount <= 31 && this.right)
/* 230 */       g.drawImage(this.im.cowr3, (int)renderX, (int)renderY, 32, 32, 
/* 231 */           null); 
/* 233 */     if (this.rightCount >= 32 && this.rightCount <= 41 && this.right)
/* 234 */       g.drawImage(this.im.cowr4, (int)renderX, (int)renderY, 32, 32, 
/* 235 */           null); 
/* 237 */     if (lastDir == 0 && !this.up && !this.down && !this.left && 
/* 238 */       !this.right)
/* 239 */       g.drawImage(this.im.cowd1, (int)renderX, (int)renderY, 32, 32, 
/* 240 */           null); 
/* 242 */     if (lastDir == 1 && !this.up)
/* 243 */       g.drawImage(this.im.cowu1, (int)renderX, (int)renderY, 32, 32, 
/* 244 */           null); 
/* 246 */     if (lastDir == 2 && !this.down)
/* 247 */       g.drawImage(this.im.cowd1, (int)renderX, (int)renderY, 32, 32, 
/* 248 */           null); 
/* 250 */     if (lastDir == 3 && !this.left)
/* 251 */       g.drawImage(this.im.cowl1, (int)renderX, (int)renderY, 32, 32, 
/* 252 */           null); 
/* 254 */     if (lastDir == 4 && !this.right)
/* 255 */       g.drawImage(this.im.cowr1, (int)renderX, (int)renderY, 32, 32, 
/* 256 */           null); 
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4.9_1.jar!\beyondOrigins\main\entities\Cow.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */