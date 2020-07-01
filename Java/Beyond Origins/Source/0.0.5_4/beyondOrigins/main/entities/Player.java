/*     */ package beyondOrigins.main.entities;
/*     */ 
/*     */ import beyondOrigins.main.Game;
/*     */ import beyondOrigins.main.gfx.ImageManager;
/*     */ import beyondOrigins.threads.Animate;
/*     */ import beyondOrigins.threads.Dialogue;
/*     */ import java.awt.Graphics;
/*     */ 
/*     */ public class Player {
/*  13 */   public static String name = "Roland";
/*     */   
/*  14 */   public static String defaultName = "Roland";
/*     */   
/*  15 */   public static String typedName = "";
/*     */   
/*  18 */   public static double health = 35.0D;
/*     */   
/*  21 */   public static double damage = 1.5D;
/*     */   
/*  24 */   public static byte upCount = 1, downCount = 1, leftCount = 1, rightCount = 1;
/*     */   
/*  27 */   public static byte canMoveUp = 1;
/*     */   
/*  28 */   public static byte canMoveDown = 1;
/*     */   
/*  29 */   public static byte canMoveLeft = 1;
/*     */   
/*  30 */   public static byte canMoveRight = 1;
/*     */   
/*  31 */   public static float playerX = 0.0F;
/*     */   
/*  32 */   public static float playerY = 0.0F;
/*     */   
/*     */   public static byte lastDir;
/*     */   
/*     */   public static byte catchingUp;
/*     */   
/*     */   public static boolean up = false;
/*     */   
/*     */   public static boolean down = false;
/*     */   
/*     */   public static boolean left = false;
/*     */   
/*     */   public static boolean right = false;
/*     */   
/*  39 */   public static double SPEED = 1.0D;
/*     */   
/*     */   public static boolean movingUp;
/*     */   
/*     */   public static boolean movingDown;
/*     */   
/*     */   public static boolean movingLeft;
/*     */   
/*     */   public static boolean movingRight;
/*     */   
/*     */   public static boolean mapMovement = true;
/*     */   
/*     */   public static boolean insideMovement;
/*     */   
/*     */   public static float mapX;
/*     */   
/*     */   public static float mapY;
/*     */   
/*  44 */   public static short mbX = 1235;
/*     */   
/*  44 */   public static short mbY = 814;
/*     */   
/*  44 */   public static short pbX = 801;
/*     */   
/*  44 */   public static short pbY = 1;
/*     */   
/*     */   public static short tileX;
/*     */   
/*     */   public static short tileY;
/*     */   
/*     */   private ImageManager im;
/*     */   
/*  51 */   private int talk1State = 1;
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
/*  63 */     tileX = (short)(((int)playerX + (int)mapX) / 32 - 12);
/*  64 */     tileY = (short)(((int)playerY + (int)mapY) / 32 - 8);
/*  67 */     if (mapX > mbX)
/*  68 */       mapX = mbX; 
/*  70 */     if (mapX < Game.playerSpawnX)
/*  71 */       mapX = Game.playerSpawnX; 
/*  73 */     if (mapY > mbY)
/*  74 */       mapY = mbY; 
/*  76 */     if (mapY < Game.playerSpawnY)
/*  77 */       mapY = Game.playerSpawnY; 
/*  81 */     if (mapMovement)
/*  82 */       mapMovement(); 
/*  84 */     if (insideMovement)
/*  85 */       insideMovement(); 
/*     */   }
/*     */   
/*     */   public void mapMovement() {
/*  91 */     if (up && playerY >= pbY && canMoveUp == 1) {
/*  92 */       if (mapY <= Game.playerSpawnY) {
/*  93 */         playerY = (float)(playerY - SPEED);
/*  94 */       } else if (catchingUp != 1 && playerY <= Game.playerSpawnY) {
/*  95 */         mapY = (float)(mapY - SPEED);
/*     */       } 
/*  97 */       upCount = (byte)(int)(upCount + SPEED);
/*  98 */       movingUp = true;
/*  99 */       lastDir = 1;
/* 100 */       if (upCount >= 42)
/* 101 */         upCount = 1; 
/*     */     } else {
/* 104 */       upCount = 0;
/* 105 */       movingUp = false;
/* 106 */       if (movingDown && playerY <= Game.playerSpawnY) {
/* 107 */         playerY = (float)(playerY + SPEED);
/* 108 */         catchingUp = 1;
/*     */       } else {
/* 110 */         catchingUp = 0;
/*     */       } 
/*     */     } 
/* 114 */     if (down && playerY <= 511.0F && canMoveDown == 1) {
/* 115 */       if (mapY >= mbY) {
/* 116 */         playerY = (float)(playerY + SPEED);
/* 117 */       } else if (catchingUp != 3 && playerY >= Game.playerSpawnY) {
/* 118 */         mapY = (float)(mapY + SPEED);
/*     */       } 
/* 120 */       downCount = (byte)(int)(downCount + SPEED);
/* 121 */       movingDown = true;
/* 122 */       lastDir = 3;
/* 123 */       if (downCount >= 42)
/* 124 */         downCount = 1; 
/*     */     } else {
/* 127 */       downCount = 0;
/* 128 */       movingDown = false;
/* 129 */       if (movingUp && playerY >= Game.playerSpawnY) {
/* 130 */         playerY = (float)(playerY - SPEED);
/* 131 */         catchingUp = 3;
/*     */       } else {
/* 133 */         catchingUp = 0;
/*     */       } 
/*     */     } 
/* 137 */     if (left && playerX >= 0.0F && canMoveLeft == 1) {
/* 138 */       if (mapX <= Game.playerSpawnX) {
/* 139 */         playerX = (float)(playerX - SPEED);
/* 140 */       } else if (catchingUp != 4 && playerX <= Game.playerSpawnX) {
/* 141 */         mapX = (float)(mapX - SPEED);
/*     */       } 
/* 143 */       leftCount = (byte)(int)(leftCount + SPEED);
/* 144 */       movingLeft = true;
/* 145 */       lastDir = 4;
/* 146 */       if (leftCount >= 42)
/* 147 */         leftCount = 1; 
/*     */     } else {
/* 150 */       leftCount = 0;
/* 151 */       movingLeft = false;
/* 152 */       if (movingRight && playerX <= Game.playerSpawnX) {
/* 153 */         playerX = (float)(playerX + SPEED);
/* 154 */         catchingUp = 4;
/*     */       } else {
/* 156 */         catchingUp = 0;
/*     */       } 
/*     */     } 
/* 160 */     if (right && playerX <= pbX && canMoveRight == 1) {
/* 161 */       if (mapX >= mbX) {
/* 162 */         playerX = (float)(playerX + SPEED);
/* 163 */       } else if (catchingUp != 2 && playerX >= Game.playerSpawnX) {
/* 164 */         mapX = (float)(mapX + SPEED);
/*     */       } 
/* 166 */       rightCount = (byte)(int)(rightCount + SPEED);
/* 167 */       movingRight = true;
/* 168 */       lastDir = 2;
/* 169 */       if (rightCount >= 42)
/* 170 */         rightCount = 1; 
/*     */     } else {
/* 173 */       rightCount = 0;
/* 174 */       movingRight = false;
/* 175 */       if (movingLeft && playerX >= Game.playerSpawnX) {
/* 176 */         playerX = (float)(playerX - SPEED);
/* 177 */         catchingUp = 2;
/*     */       } else {
/* 179 */         catchingUp = 0;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void insideMovement() {
/* 185 */     if (up && playerY >= 125.0F && canMoveUp == 1) {
/* 186 */       playerY = (float)(playerY - SPEED);
/* 187 */       upCount = (byte)(upCount + 1);
/* 188 */       movingUp = true;
/* 189 */       lastDir = 1;
/* 190 */       if (upCount == 42)
/* 191 */         upCount = 1; 
/*     */     } else {
/* 194 */       upCount = 0;
/* 195 */       movingUp = false;
/*     */     } 
/* 197 */     if (down && playerY <= 423.0F && canMoveDown == 1) {
/* 198 */       playerY = (float)(playerY + SPEED);
/* 199 */       downCount = (byte)(downCount + 1);
/* 200 */       movingDown = true;
/* 201 */       lastDir = 3;
/* 202 */       if (downCount == 42)
/* 203 */         downCount = 1; 
/*     */     } else {
/* 206 */       downCount = 0;
/* 207 */       movingDown = false;
/*     */     } 
/* 209 */     if (left && playerX >= 194.0F && canMoveLeft == 1) {
/* 210 */       playerX = (float)(playerX - SPEED);
/* 211 */       leftCount = (byte)(leftCount + 1);
/* 212 */       movingLeft = true;
/* 213 */       lastDir = 4;
/* 214 */       if (leftCount == 42)
/* 215 */         leftCount = 1; 
/*     */     } else {
/* 218 */       leftCount = 0;
/* 219 */       movingLeft = false;
/*     */     } 
/* 221 */     if (right && playerX <= 612.0F && canMoveRight == 1) {
/* 222 */       playerX = (float)(playerX + SPEED);
/* 223 */       rightCount = (byte)(rightCount + 1);
/* 224 */       movingRight = true;
/* 225 */       lastDir = 2;
/* 226 */       if (rightCount == 42)
/* 227 */         rightCount = 1; 
/*     */     } else {
/* 230 */       rightCount = 0;
/* 231 */       movingRight = false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render(Graphics g) {
/* 237 */     Animate.animateEntity(g, (int)playerX, (int)playerY, this.im.playeru1, 
/* 238 */         this.im.playeru2, this.im.playeru3, this.im.playeru4, upCount);
/* 239 */     Animate.animateEntity(g, (int)playerX, (int)playerY, this.im.playerd1, 
/* 240 */         this.im.playerd2, this.im.playerd3, this.im.playerd4, downCount);
/* 241 */     Animate.animateEntity(g, (int)playerX, (int)playerY, this.im.playerl1, 
/* 242 */         this.im.playerl2, this.im.playerl3, this.im.playerl4, leftCount);
/* 243 */     Animate.animateEntity(g, (int)playerX, (int)playerY, this.im.playerr1, 
/* 244 */         this.im.playerr2, this.im.playerr3, this.im.playerr4, rightCount);
/* 246 */     if (!movingUp && !movingDown && !movingLeft && 
/* 247 */       !movingRight && lastDir == 0)
/* 249 */       g.drawImage(this.im.playerd1, (int)playerX, (int)playerY, 32, 32, 
/* 250 */           null); 
/* 252 */     if (!movingRight && lastDir == 2)
/* 253 */       g.drawImage(this.im.playerr1, (int)playerX, (int)playerY, 32, 32, 
/* 254 */           null); 
/* 256 */     if (!movingLeft && lastDir == 4)
/* 257 */       g.drawImage(this.im.playerl1, (int)playerX, (int)playerY, 32, 32, 
/* 258 */           null); 
/* 260 */     if (!movingUp && lastDir == 1)
/* 261 */       g.drawImage(this.im.playeru1, (int)playerX, (int)playerY, 32, 32, 
/* 262 */           null); 
/* 264 */     if (!movingDown && lastDir == 3)
/* 265 */       g.drawImage(this.im.playerd1, (int)playerX, (int)playerY, 32, 32, 
/* 266 */           null); 
/* 269 */     this.talk1State = Dialogue.getState(this.talk1State, 3);
/* 271 */     if (this.talk1State == 1) {
/* 272 */       Dialogue.drawDialogue(g, this.im.playerd1, name, "Hello! Welcome to BO005B4.", "This is a Beta Build, and may be unstable,", 
/* 273 */           "so please use caution. If anything goes wrong, or is", "odd, then please let me know, thanks!");
/* 274 */     } else if (this.talk1State == 2) {
/* 275 */       Dialogue.drawDialogue(g, this.im.playerd1, name, "BO005B4 Change Log:", 
/* 276 */           "- 'Finished' the test dummy", "- Added 'Quit Game' and 'Update' buttons", "- A few bug fixes");
/* 277 */     } else if (this.talk1State == 3) {
/* 278 */       Dialogue.drawDialogue(g, this.im.playerd1, name, "That is all for now!", 
/* 279 */           "Be sure to check out the website at:", "www.emgartley.wordpress.com", "Note: 'Update Game' is not done, yet.");
/*     */     } 
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_4.jar!\beyondOrigins\main\entities\Player.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */