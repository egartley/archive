/*     */ package beyondOrigins.main.entities;
/*     */ 
/*     */ import beyondOrigins.main.Game;
/*     */ import beyondOrigins.main.gfx.ImageManager;
/*     */ import beyondOrigins.threads.Animate;
/*     */ import beyondOrigins.threads.Dialogue;
/*     */ import java.awt.Graphics;
/*     */ 
/*     */ public class Player {
/*  14 */   public static int talk1State = 1;
/*     */   
/*  16 */   private int upCount = 1;
/*     */   
/*  17 */   private int leftCount = 1;
/*     */   
/*  18 */   private int rightCount = 1;
/*     */   
/*  19 */   private int downCount = 1;
/*     */   
/*  21 */   public static int canMoveUp = 1;
/*     */   
/*  22 */   public static int canMoveDown = 1;
/*     */   
/*  23 */   public static int canMoveLeft = 1;
/*     */   
/*  24 */   public static int canMoveRight = 1;
/*     */   
/*  25 */   public static float playerX = 0.0F;
/*     */   
/*  26 */   public static float playerY = 0.0F;
/*     */   
/*     */   public static int lastDir;
/*     */   
/*     */   public static int catchingUp;
/*     */   
/*     */   public static boolean up = false;
/*     */   
/*     */   public static boolean down = false;
/*     */   
/*     */   public static boolean left = false;
/*     */   
/*     */   public static boolean right = false;
/*     */   
/*  35 */   public static double SPEED = 1.0D;
/*     */   
/*     */   public static boolean isMovingUp;
/*     */   
/*     */   public static boolean isMovingDown;
/*     */   
/*     */   public static boolean isMovingRight;
/*     */   
/*     */   public static boolean isMovingLeft;
/*     */   
/*     */   public static boolean mapMovement = true;
/*     */   
/*     */   public static boolean insideMovement;
/*     */   
/*     */   public static float mapX;
/*     */   
/*     */   public static float mapY;
/*     */   
/*     */   public static int tileX;
/*     */   
/*     */   public static int tileY;
/*     */   
/*     */   private ImageManager im;
/*     */   
/*     */   public Player(int x, int y, int mx, int my, ImageManager im) {
/*  54 */     playerX = x;
/*  55 */     playerY = y;
/*  56 */     mapX = mx;
/*  57 */     mapY = my;
/*  58 */     this.im = im;
/*     */   }
/*     */   
/*     */   public void tick() {
/*  62 */     tileX = ((int)playerX + (int)mapX) / 32 - 12;
/*  63 */     tileY = ((int)playerY + (int)mapY) / 32 - 8;
/*  64 */     if (mapMovement)
/*  65 */       mapMovement(); 
/*  67 */     if (insideMovement)
/*  68 */       insideMovement(); 
/*     */   }
/*     */   
/*     */   public void mapMovement() {
/*  74 */     if (up && playerY >= 1.0F && canMoveUp == 1) {
/*  75 */       if (mapY <= Game.playerSpawnY) {
/*  76 */         playerY = (float)(playerY - SPEED);
/*  77 */       } else if (catchingUp != 1 && playerY <= Game.playerSpawnY) {
/*  78 */         mapY = (float)(mapY - SPEED);
/*     */       } 
/*  80 */       this.upCount++;
/*  81 */       isMovingUp = true;
/*  82 */       lastDir = 1;
/*  83 */       if (this.upCount == 42)
/*  84 */         this.upCount = 1; 
/*     */     } else {
/*  87 */       this.upCount = 0;
/*  88 */       isMovingUp = false;
/*  89 */       if (isMovingDown && playerY <= Game.playerSpawnY) {
/*  90 */         playerY = (float)(playerY + SPEED);
/*  91 */         catchingUp = 1;
/*     */       } else {
/*  93 */         catchingUp = 0;
/*     */       } 
/*     */     } 
/*  97 */     if (down && playerY <= 511.0F && canMoveDown == 1) {
/*  98 */       if (mapY >= 814.0F) {
/*  99 */         playerY = (float)(playerY + SPEED);
/* 100 */       } else if (catchingUp != 3 && playerY >= Game.playerSpawnY) {
/* 101 */         mapY = (float)(mapY + SPEED);
/*     */       } 
/* 103 */       this.downCount++;
/* 104 */       isMovingDown = true;
/* 105 */       lastDir = 3;
/* 106 */       if (this.downCount == 42)
/* 107 */         this.downCount = 1; 
/*     */     } else {
/* 110 */       this.downCount = 0;
/* 111 */       isMovingDown = false;
/* 112 */       if (isMovingUp && playerY >= Game.playerSpawnY) {
/* 113 */         playerY = (float)(playerY - SPEED);
/* 114 */         catchingUp = 3;
/*     */       } else {
/* 116 */         catchingUp = 0;
/*     */       } 
/*     */     } 
/* 120 */     if (left && playerX >= 0.0F && canMoveLeft == 1) {
/* 121 */       if (mapX <= Game.playerSpawnX) {
/* 122 */         playerX = (float)(playerX - SPEED);
/* 123 */       } else if (catchingUp != 4 && playerX <= Game.playerSpawnX) {
/* 124 */         mapX = (float)(mapX - SPEED);
/*     */       } 
/* 126 */       this.leftCount++;
/* 127 */       isMovingLeft = true;
/* 128 */       lastDir = 4;
/* 129 */       if (this.leftCount == 42)
/* 130 */         this.leftCount = 1; 
/*     */     } else {
/* 133 */       this.leftCount = 0;
/* 134 */       isMovingLeft = false;
/* 135 */       if (isMovingRight && playerX <= Game.playerSpawnX) {
/* 136 */         playerX = (float)(playerX + SPEED);
/* 137 */         catchingUp = 4;
/*     */       } else {
/* 139 */         catchingUp = 0;
/*     */       } 
/*     */     } 
/* 143 */     if (right && playerX <= 801.0F && canMoveRight == 1) {
/* 144 */       if (mapX >= 1235.0F) {
/* 145 */         playerX = (float)(playerX + SPEED);
/* 146 */       } else if (catchingUp != 2 && playerX >= Game.playerSpawnX) {
/* 147 */         mapX = (float)(mapX + SPEED);
/*     */       } 
/* 149 */       this.rightCount++;
/* 150 */       isMovingRight = true;
/* 151 */       lastDir = 2;
/* 152 */       if (this.rightCount == 42)
/* 153 */         this.rightCount = 1; 
/*     */     } else {
/* 156 */       this.rightCount = 0;
/* 157 */       isMovingRight = false;
/* 158 */       if (isMovingLeft && playerX >= Game.playerSpawnX) {
/* 159 */         playerX = (float)(playerX - SPEED);
/* 160 */         catchingUp = 2;
/*     */       } else {
/* 162 */         catchingUp = 0;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void insideMovement() {
/* 168 */     if (up && playerY >= 125.0F && canMoveUp == 1) {
/* 169 */       playerY = (float)(playerY - SPEED);
/* 170 */       this.upCount++;
/* 171 */       isMovingUp = true;
/* 172 */       lastDir = 1;
/* 173 */       if (this.upCount == 42)
/* 174 */         this.upCount = 1; 
/*     */     } else {
/* 177 */       this.upCount = 0;
/* 178 */       isMovingUp = false;
/*     */     } 
/* 180 */     if (down && playerY <= 423.0F && canMoveDown == 1) {
/* 181 */       playerY = (float)(playerY + SPEED);
/* 182 */       this.downCount++;
/* 183 */       isMovingDown = true;
/* 184 */       lastDir = 3;
/* 185 */       if (this.downCount == 42)
/* 186 */         this.downCount = 1; 
/*     */     } else {
/* 189 */       this.downCount = 0;
/* 190 */       isMovingDown = false;
/*     */     } 
/* 192 */     if (left && playerX >= 194.0F && canMoveLeft == 1) {
/* 193 */       playerX = (float)(playerX - SPEED);
/* 194 */       this.leftCount++;
/* 195 */       isMovingLeft = true;
/* 196 */       lastDir = 4;
/* 197 */       if (this.leftCount == 42)
/* 198 */         this.leftCount = 1; 
/*     */     } else {
/* 201 */       this.leftCount = 0;
/* 202 */       isMovingLeft = false;
/*     */     } 
/* 204 */     if (right && playerX <= 612.0F && canMoveRight == 1) {
/* 205 */       playerX = (float)(playerX + SPEED);
/* 206 */       this.rightCount++;
/* 207 */       isMovingRight = true;
/* 208 */       lastDir = 2;
/* 209 */       if (this.rightCount == 42)
/* 210 */         this.rightCount = 1; 
/*     */     } else {
/* 213 */       this.rightCount = 0;
/* 214 */       isMovingRight = false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render(Graphics g) {
/* 222 */     Animate.animateEntity(g, (int)playerX, (int)playerY, this.im.playeru1, 
/* 223 */         this.im.playeru2, this.im.playeru3, this.im.playeru4, this.upCount);
/* 224 */     Animate.animateEntity(g, (int)playerX, (int)playerY, this.im.playerd1, 
/* 225 */         this.im.playerd2, this.im.playerd3, this.im.playerd4, this.downCount);
/* 226 */     Animate.animateEntity(g, (int)playerX, (int)playerY, this.im.playerl1, 
/* 227 */         this.im.playerl2, this.im.playerl3, this.im.playerl4, this.leftCount);
/* 228 */     Animate.animateEntity(g, (int)playerX, (int)playerY, this.im.playerr1, 
/* 229 */         this.im.playerr2, this.im.playerr3, this.im.playerr4, this.rightCount);
/* 231 */     talk1State = Dialogue.getState(talk1State, 3);
/* 233 */     if (talk1State == 1) {
/* 234 */       Dialogue.drawDialogue(g, this.im.playerd1, "Player", "line1", "line2", "line3", "line4");
/* 235 */     } else if (talk1State == 2) {
/* 236 */       Dialogue.drawDialogue(g, this.im.playerd1, "Player", "line2_1", "line2_2", "line2_3", "line2_4");
/* 237 */     } else if (talk1State == 3) {
/* 238 */       Dialogue.drawDialogue(g, this.im.playerd1, "Player", "line3_1", "line3_2", "line3_3", "line3_4");
/*     */     } 
/* 241 */     if (!isMovingUp && !isMovingDown && !isMovingLeft && 
/* 242 */       !isMovingRight && lastDir == 0)
/* 243 */       g.drawImage(this.im.playerd1, (int)playerX, (int)playerY, 32, 32, 
/* 244 */           null); 
/* 246 */     if (!isMovingRight && lastDir == 2)
/* 247 */       g.drawImage(this.im.playerr1, (int)playerX, (int)playerY, 32, 32, 
/* 248 */           null); 
/* 250 */     if (!isMovingLeft && lastDir == 4)
/* 251 */       g.drawImage(this.im.playerl1, (int)playerX, (int)playerY, 32, 32, 
/* 252 */           null); 
/* 254 */     if (!isMovingUp && lastDir == 1)
/* 255 */       g.drawImage(this.im.playeru1, (int)playerX, (int)playerY, 32, 32, 
/* 256 */           null); 
/* 258 */     if (!isMovingDown && lastDir == 3)
/* 259 */       g.drawImage(this.im.playerd1, (int)playerX, (int)playerY, 32, 32, 
/* 260 */           null); 
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_2.jar!\beyondOrigins\main\entities\Player.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */