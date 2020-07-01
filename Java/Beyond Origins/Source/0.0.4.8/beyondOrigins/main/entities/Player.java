/*     */ package beyondOrigins.main.entities;
/*     */ 
/*     */ import beyondOrigins.main.Game;
/*     */ import beyondOrigins.main.gfx.ImageManager;
/*     */ import java.awt.Graphics;
/*     */ 
/*     */ public class Player {
/*  10 */   private int upCount = 1;
/*     */   
/*  11 */   private int leftCount = 1;
/*     */   
/*  12 */   private int rightCount = 1;
/*     */   
/*  13 */   private int downCount = 1;
/*     */   
/*  15 */   public static int canMoveUp = 1;
/*     */   
/*  16 */   public static int canMoveDown = 1;
/*     */   
/*  17 */   public static int canMoveLeft = 1;
/*     */   
/*  18 */   public static int canMoveRight = 1;
/*     */   
/*  19 */   public static float playerX = 0.0F;
/*     */   
/*  20 */   public static float playerY = 0.0F;
/*     */   
/*  21 */   public static int lastDir = 0;
/*     */   
/*  22 */   public static int catchingUp = 0;
/*     */   
/*     */   public static boolean up = false;
/*     */   
/*     */   public static boolean down = false;
/*     */   
/*     */   public static boolean left = false;
/*     */   
/*     */   public static boolean right = false;
/*     */   
/*  29 */   public static double SPEED = 1.0D;
/*     */   
/*  30 */   public static int speedToggle = 0;
/*     */   
/*     */   public static boolean pUp;
/*     */   
/*     */   public static boolean pDown;
/*     */   
/*     */   public static boolean pRight;
/*     */   
/*     */   public static boolean pLeft;
/*     */   
/*     */   public static boolean mapMovement = true;
/*     */   
/*     */   public static boolean insideMovement;
/*     */   
/*  40 */   public static float mapX = 0.0F;
/*     */   
/*  41 */   public static float mapY = 0.0F;
/*     */   
/*     */   public static int tileX;
/*     */   
/*     */   public static int tileY;
/*     */   
/*     */   private ImageManager im;
/*     */   
/*     */   public Player(int x, int y, int mx, int my, ImageManager im) {
/*  48 */     playerX = x;
/*  49 */     playerY = y;
/*  50 */     mapX = mx;
/*  51 */     mapY = my;
/*  52 */     this.im = im;
/*     */   }
/*     */   
/*     */   public void tick() {
/*  56 */     tileX = ((int)playerX + 0 + (int)mapX) / 32 - 12;
/*  57 */     tileY = ((int)playerY + 0 + (int)mapY) / 32 - 8;
/*  58 */     if (mapMovement) {
/*  59 */       if (up && playerY >= 1.0F && canMoveUp == 1) {
/*  60 */         if (mapY <= 263.0F) {
/*  61 */           playerY = (float)(playerY - SPEED);
/*  62 */         } else if (catchingUp != 1 && playerY <= Game.playerSpawnY) {
/*  63 */           mapY = (float)(mapY - SPEED);
/*     */         } 
/*  65 */         this.upCount++;
/*  66 */         pUp = true;
/*  67 */         lastDir = 1;
/*  68 */         if (this.upCount == 42)
/*  69 */           this.upCount = 1; 
/*     */       } else {
/*  72 */         this.upCount = 0;
/*  73 */         pUp = false;
/*  74 */         if (pDown && playerY <= Game.playerSpawnY) {
/*  75 */           playerY = (float)(playerY + SPEED);
/*  76 */           catchingUp = 1;
/*     */         } else {
/*  78 */           catchingUp = 0;
/*     */         } 
/*     */       } 
/*  81 */       if (down && playerY <= 511.0F && canMoveDown == 1) {
/*  82 */         if (mapY >= 775.0F) {
/*  83 */           playerY = (float)(playerY + SPEED);
/*  84 */         } else if (catchingUp != 3 && playerY >= Game.playerSpawnY) {
/*  85 */           mapY = (float)(mapY + SPEED);
/*     */         } 
/*  87 */         this.downCount++;
/*  88 */         pDown = true;
/*  89 */         lastDir = 3;
/*  90 */         if (this.downCount == 42)
/*  91 */           this.downCount = 1; 
/*     */       } else {
/*  94 */         this.downCount = 0;
/*  95 */         pDown = false;
/*  96 */         if (pUp && playerY >= Game.playerSpawnY) {
/*  97 */           playerY = (float)(playerY - SPEED);
/*  98 */           catchingUp = 3;
/*     */         } else {
/* 100 */           catchingUp = 0;
/*     */         } 
/*     */       } 
/* 103 */       if (left && playerX >= 0.0F && canMoveLeft == 1) {
/* 104 */         if (mapX <= 398.0F) {
/* 105 */           playerX = (float)(playerX - SPEED);
/* 106 */         } else if (catchingUp != 4 && playerX <= Game.playerSpawnX) {
/* 107 */           mapX = (float)(mapX - SPEED);
/*     */         } 
/* 109 */         this.leftCount++;
/* 110 */         pLeft = true;
/* 111 */         lastDir = 4;
/* 112 */         if (this.leftCount == 42)
/* 113 */           this.leftCount = 1; 
/*     */       } else {
/* 116 */         this.leftCount = 0;
/* 117 */         pLeft = false;
/* 118 */         if (pRight && playerX <= Game.playerSpawnX) {
/* 119 */           playerX = (float)(playerX + SPEED);
/* 120 */           catchingUp = 4;
/*     */         } else {
/* 122 */           catchingUp = 0;
/*     */         } 
/*     */       } 
/* 125 */       if (right && playerX <= 801.0F && canMoveRight == 1) {
/* 126 */         if (mapX >= 1198.0F) {
/* 127 */           playerX = (float)(playerX + SPEED);
/* 128 */         } else if (catchingUp != 2 && playerX >= Game.playerSpawnX) {
/* 129 */           mapX = (float)(mapX + SPEED);
/*     */         } 
/* 131 */         this.rightCount++;
/* 132 */         pRight = true;
/* 133 */         lastDir = 2;
/* 134 */         if (this.rightCount == 42)
/* 135 */           this.rightCount = 1; 
/*     */       } else {
/* 138 */         this.rightCount = 0;
/* 139 */         pRight = false;
/* 140 */         if (pLeft && playerX >= Game.playerSpawnX) {
/* 141 */           playerX = (float)(playerX - SPEED);
/* 142 */           catchingUp = 2;
/*     */         } else {
/* 144 */           catchingUp = 0;
/*     */         } 
/*     */       } 
/*     */     } 
/* 148 */     if (insideMovement) {
/* 149 */       if (up && playerY >= 125.0F && canMoveUp == 1) {
/* 150 */         playerY = (float)(playerY - SPEED);
/* 151 */         this.upCount++;
/* 152 */         pUp = true;
/* 153 */         lastDir = 1;
/* 154 */         if (this.upCount == 42)
/* 155 */           this.upCount = 1; 
/*     */       } else {
/* 158 */         this.upCount = 0;
/* 159 */         pUp = false;
/*     */       } 
/* 161 */       if (down && playerY <= 423.0F && canMoveDown == 1) {
/* 162 */         playerY = (float)(playerY + SPEED);
/* 163 */         this.downCount++;
/* 164 */         pDown = true;
/* 165 */         lastDir = 3;
/* 166 */         if (this.downCount == 42)
/* 167 */           this.downCount = 1; 
/*     */       } else {
/* 170 */         this.downCount = 0;
/* 171 */         pDown = false;
/*     */       } 
/* 173 */       if (left && playerX >= 194.0F && canMoveLeft == 1) {
/* 174 */         playerX = (float)(playerX - SPEED);
/* 175 */         this.leftCount++;
/* 176 */         pLeft = true;
/* 177 */         lastDir = 4;
/* 178 */         if (this.leftCount == 42)
/* 179 */           this.leftCount = 1; 
/*     */       } else {
/* 182 */         this.leftCount = 0;
/* 183 */         pLeft = false;
/*     */       } 
/* 185 */       if (right && playerX <= 612.0F && canMoveRight == 1) {
/* 186 */         playerX = (float)(playerX + SPEED);
/* 187 */         this.rightCount++;
/* 188 */         pRight = true;
/* 189 */         lastDir = 2;
/* 190 */         if (this.rightCount == 42)
/* 191 */           this.rightCount = 1; 
/*     */       } else {
/* 194 */         this.rightCount = 0;
/* 195 */         pRight = false;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render(Graphics g) {
/* 201 */     if (this.downCount >= 1 && this.downCount <= 11)
/* 202 */       g.drawImage(this.im.playerd1, (int)playerX, (int)playerY, 32, 32, 
/* 203 */           null); 
/* 205 */     if (this.downCount >= 12 && this.downCount <= 21)
/* 206 */       g.drawImage(this.im.playerd2, (int)playerX, (int)playerY, 32, 32, 
/* 207 */           null); 
/* 209 */     if (this.downCount >= 22 && this.downCount <= 31)
/* 210 */       g.drawImage(this.im.playerd3, (int)playerX, (int)playerY, 32, 32, 
/* 211 */           null); 
/* 213 */     if (this.downCount >= 32 && this.downCount <= 41)
/* 214 */       g.drawImage(this.im.playerd4, (int)playerX, (int)playerY, 32, 32, 
/* 215 */           null); 
/* 217 */     if (this.upCount >= 1 && this.upCount <= 11)
/* 218 */       g.drawImage(this.im.playeru1, (int)playerX, (int)playerY, 32, 32, 
/* 219 */           null); 
/* 221 */     if (this.upCount >= 12 && this.upCount <= 21)
/* 222 */       g.drawImage(this.im.playeru2, (int)playerX, (int)playerY, 32, 32, 
/* 223 */           null); 
/* 225 */     if (this.upCount >= 22 && this.upCount <= 31)
/* 226 */       g.drawImage(this.im.playeru3, (int)playerX, (int)playerY, 32, 32, 
/* 227 */           null); 
/* 229 */     if (this.upCount >= 32 && this.upCount <= 41)
/* 230 */       g.drawImage(this.im.playeru4, (int)playerX, (int)playerY, 32, 32, 
/* 231 */           null); 
/* 233 */     if (this.leftCount >= 1 && this.leftCount <= 11)
/* 234 */       g.drawImage(this.im.playerl1, (int)playerX, (int)playerY, 32, 32, 
/* 235 */           null); 
/* 237 */     if (this.leftCount >= 12 && this.leftCount <= 21)
/* 238 */       g.drawImage(this.im.playerl2, (int)playerX, (int)playerY, 32, 32, 
/* 239 */           null); 
/* 241 */     if (this.leftCount >= 22 && this.leftCount <= 31)
/* 242 */       g.drawImage(this.im.playerl3, (int)playerX, (int)playerY, 32, 32, 
/* 243 */           null); 
/* 245 */     if (this.leftCount >= 32 && this.leftCount <= 41)
/* 246 */       g.drawImage(this.im.playerl4, (int)playerX, (int)playerY, 32, 32, 
/* 247 */           null); 
/* 249 */     if (this.rightCount >= 1 && this.rightCount <= 11)
/* 250 */       g.drawImage(this.im.playerr1, (int)playerX, (int)playerY, 32, 32, 
/* 251 */           null); 
/* 253 */     if (this.rightCount >= 12 && this.rightCount <= 21)
/* 254 */       g.drawImage(this.im.playerr2, (int)playerX, (int)playerY, 32, 32, 
/* 255 */           null); 
/* 257 */     if (this.rightCount >= 22 && this.rightCount <= 31)
/* 258 */       g.drawImage(this.im.playerr3, (int)playerX, (int)playerY, 32, 32, 
/* 259 */           null); 
/* 261 */     if (this.rightCount >= 32 && this.rightCount <= 41)
/* 262 */       g.drawImage(this.im.playerr4, (int)playerX, (int)playerY, 32, 32, 
/* 263 */           null); 
/* 265 */     if (!pUp && !pDown && !pLeft && !pRight && lastDir == 0)
/* 266 */       g.drawImage(this.im.playerd1, (int)playerX, (int)playerY, 32, 32, 
/* 267 */           null); 
/* 269 */     if (!pRight && lastDir == 2)
/* 270 */       g.drawImage(this.im.playerr1, (int)playerX, (int)playerY, 32, 32, 
/* 271 */           null); 
/* 273 */     if (!pLeft && lastDir == 4)
/* 274 */       g.drawImage(this.im.playerl1, (int)playerX, (int)playerY, 32, 32, 
/* 275 */           null); 
/* 277 */     if (!pUp && lastDir == 1)
/* 278 */       g.drawImage(this.im.playeru1, (int)playerX, (int)playerY, 32, 32, 
/* 279 */           null); 
/* 281 */     if (!pDown && lastDir == 3)
/* 282 */       g.drawImage(this.im.playerd1, (int)playerX, (int)playerY, 32, 32, 
/* 283 */           null); 
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4.8.jar!\beyondOrigins\main\entities\Player.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */