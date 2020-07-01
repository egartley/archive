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
/*     */   public void tick() {
/*  38 */     time++;
/*  39 */     time2++;
/*  40 */     if (time == 1)
/*  41 */       this.r1 = this.r.nextInt(101); 
/*  43 */     if (time == 100) {
/*  44 */       time = 0;
/*  46 */       isStopped = !isStopped;
/*  47 */       if (isStopped) {
/*  48 */         if (this.up)
/*  49 */           stop = 1; 
/*  51 */         if (this.down)
/*  52 */           stop = 2; 
/*  54 */         if (this.left)
/*  55 */           stop = 3; 
/*  57 */         if (this.right)
/*  58 */           stop = 4; 
/*     */       } else {
/*  61 */         stop = 0;
/*     */       } 
/*     */     } 
/*  64 */     if (time2 == 4)
/*  65 */       time2 = 0; 
/*  67 */     if (this.r1 <= 24 && stop == 0 && cowY >= 11.0F) {
/*  68 */       this.up = true;
/*     */     } else {
/*  70 */       this.up = false;
/*     */     } 
/*  72 */     if (this.r1 <= 49 && this.r1 > 24 && stop == 0 && 
/*  73 */       cowY <= 969.0F) {
/*  74 */       this.down = true;
/*     */     } else {
/*  76 */       this.down = false;
/*     */     } 
/*  78 */     if (this.r1 <= 74 && this.r1 > 49 && stop == 0 && cowX >= 11.0F) {
/*  79 */       this.left = true;
/*     */     } else {
/*  81 */       this.left = false;
/*     */     } 
/*  83 */     if (this.r1 <= 99 && this.r1 > 74 && stop == 0 && 
/*  84 */       cowX <= 780.0F) {
/*  85 */       this.right = true;
/*     */     } else {
/*  87 */       this.right = false;
/*     */     } 
/*  89 */     if (this.up) {
/*  90 */       this.upCount++;
/*  91 */       if (time2 != 1)
/*  92 */         cowY -= (int)cowSpeed; 
/*  94 */       if (this.upCount == 42)
/*  95 */         this.upCount = 1; 
/*  97 */       lastDir = 1;
/*     */     } else {
/*  99 */       this.upCount = 0;
/*     */     } 
/* 101 */     if (this.down) {
/* 102 */       this.downCount++;
/* 103 */       if (time2 != 1)
/* 104 */         cowY += (int)cowSpeed; 
/* 106 */       if (this.downCount == 42)
/* 107 */         this.downCount = 1; 
/* 109 */       lastDir = 2;
/*     */     } else {
/* 111 */       this.downCount = 0;
/*     */     } 
/* 113 */     if (this.left) {
/* 114 */       this.leftCount++;
/* 115 */       if (time2 != 1)
/* 116 */         cowX -= (int)cowSpeed; 
/* 118 */       if (this.leftCount == 42)
/* 119 */         this.leftCount = 1; 
/* 121 */       lastDir = 3;
/*     */     } else {
/* 123 */       this.leftCount = 0;
/*     */     } 
/* 125 */     if (this.right) {
/* 126 */       this.rightCount++;
/* 127 */       if (time2 != 1)
/* 128 */         cowX += (int)cowSpeed; 
/* 130 */       if (this.rightCount == 42)
/* 131 */         this.rightCount = 1; 
/* 133 */       lastDir = 4;
/*     */     } else {
/* 135 */       this.rightCount = 0;
/*     */     } 
/* 137 */     if (stop == 1 || stop == 2 || stop == 3 || stop == 4) {
/* 138 */       this.up = false;
/* 139 */       this.down = false;
/* 140 */       this.left = false;
/* 141 */       this.right = false;
/* 142 */       lastDir = stop;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render(Graphics g) {
/* 147 */     renderX = cowX - Player.mapX + Game.playerSpawnX;
/* 148 */     renderY = cowY - Player.mapY + Game.playerSpawnY;
/* 149 */     if (this.upCount >= 1 && this.upCount <= 11)
/* 150 */       g.drawImage(ImageManager.cowu1, (int)renderX, (int)renderY, 32, 32, 
/* 151 */           null); 
/* 153 */     if (this.upCount >= 12 && this.upCount <= 21)
/* 154 */       g.drawImage(ImageManager.cowu2, (int)renderX, (int)renderY, 32, 32, 
/* 155 */           null); 
/* 157 */     if (this.upCount >= 22 && this.upCount <= 31)
/* 158 */       g.drawImage(ImageManager.cowu3, (int)renderX, (int)renderY, 32, 32, 
/* 159 */           null); 
/* 161 */     if (this.upCount >= 32 && this.upCount <= 41)
/* 162 */       g.drawImage(ImageManager.cowu4, (int)renderX, (int)renderY, 32, 32, 
/* 163 */           null); 
/* 165 */     if (this.downCount >= 1 && this.downCount <= 11 && this.down)
/* 166 */       g.drawImage(ImageManager.cowd1, (int)renderX, (int)renderY, 32, 32, 
/* 167 */           null); 
/* 169 */     if (this.downCount >= 12 && this.downCount <= 21 && this.down)
/* 170 */       g.drawImage(ImageManager.cowd2, (int)renderX, (int)renderY, 32, 32, 
/* 171 */           null); 
/* 173 */     if (this.downCount >= 22 && this.downCount <= 31 && this.down)
/* 174 */       g.drawImage(ImageManager.cowd3, (int)renderX, (int)renderY, 32, 32, 
/* 175 */           null); 
/* 177 */     if (this.downCount >= 32 && this.downCount <= 41 && this.down)
/* 178 */       g.drawImage(ImageManager.cowd4, (int)renderX, (int)renderY, 32, 32, 
/* 179 */           null); 
/* 181 */     if (this.leftCount >= 1 && this.leftCount <= 11 && this.left)
/* 182 */       g.drawImage(ImageManager.cowl1, (int)renderX, (int)renderY, 32, 32, 
/* 183 */           null); 
/* 185 */     if (this.leftCount >= 12 && this.leftCount <= 21 && this.left)
/* 186 */       g.drawImage(ImageManager.cowl2, (int)renderX, (int)renderY, 32, 32, 
/* 187 */           null); 
/* 189 */     if (this.leftCount >= 22 && this.leftCount <= 31 && this.left)
/* 190 */       g.drawImage(ImageManager.cowl3, (int)renderX, (int)renderY, 32, 32, 
/* 191 */           null); 
/* 193 */     if (this.leftCount >= 32 && this.leftCount <= 41 && this.left)
/* 194 */       g.drawImage(ImageManager.cowl4, (int)renderX, (int)renderY, 32, 32, 
/* 195 */           null); 
/* 197 */     if (this.rightCount >= 1 && this.rightCount <= 11 && this.right)
/* 198 */       g.drawImage(ImageManager.cowr1, (int)renderX, (int)renderY, 32, 32, 
/* 199 */           null); 
/* 201 */     if (this.rightCount >= 12 && this.rightCount <= 21 && this.right)
/* 202 */       g.drawImage(ImageManager.cowr2, (int)renderX, (int)renderY, 32, 32, 
/* 203 */           null); 
/* 205 */     if (this.rightCount >= 22 && this.rightCount <= 31 && this.right)
/* 206 */       g.drawImage(ImageManager.cowr3, (int)renderX, (int)renderY, 32, 32, 
/* 207 */           null); 
/* 209 */     if (this.rightCount >= 32 && this.rightCount <= 41 && this.right)
/* 210 */       g.drawImage(ImageManager.cowr4, (int)renderX, (int)renderY, 32, 32, 
/* 211 */           null); 
/* 213 */     if (lastDir == 0 && !this.up && !this.down && !this.left && 
/* 214 */       !this.right)
/* 215 */       g.drawImage(ImageManager.cowd1, (int)renderX, (int)renderY, 32, 32, 
/* 216 */           null); 
/* 218 */     if (lastDir == 1 && !this.up)
/* 219 */       g.drawImage(ImageManager.cowu1, (int)renderX, (int)renderY, 32, 32, 
/* 220 */           null); 
/* 222 */     if (lastDir == 2 && !this.down)
/* 223 */       g.drawImage(ImageManager.cowd1, (int)renderX, (int)renderY, 32, 32, 
/* 224 */           null); 
/* 226 */     if (lastDir == 3 && !this.left)
/* 227 */       g.drawImage(ImageManager.cowl1, (int)renderX, (int)renderY, 32, 32, 
/* 228 */           null); 
/* 230 */     if (lastDir == 4 && !this.right)
/* 231 */       g.drawImage(ImageManager.cowr1, (int)renderX, (int)renderY, 32, 32, 
/* 232 */           null); 
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_6.jar!\beyondOrigins\main\entities\Cow.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */