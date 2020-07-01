/*     */ package beyondOrigins.main.menus;
/*     */ 
/*     */ import beyondOrigins.main.Game;
/*     */ import beyondOrigins.main.KeyManager;
/*     */ import beyondOrigins.main.Load;
/*     */ import beyondOrigins.main.MouseManager;
/*     */ import beyondOrigins.main.MouseMotion;
/*     */ import beyondOrigins.main.Save;
/*     */ import beyondOrigins.main.gfx.ImageManager;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.Graphics;
/*     */ import java.io.IOException;
/*     */ import java.util.Random;
/*     */ 
/*     */ public class MainMenu {
/*  19 */   static Random r = new Random();
/*     */   
/*  21 */   public static int menuState = 1;
/*     */   
/*  23 */   private static Font profileSelectionFont = new Font("MoolBoran", 
/*  24 */       0, 23);
/*     */   
/*  25 */   public static String currentProfile = "None";
/*     */   
/*     */   public static boolean canSave1;
/*     */   
/*     */   public static boolean canSave2;
/*     */   
/*     */   public static boolean canSave3;
/*     */   
/*     */   public static int save1State;
/*     */   
/*     */   public static int save2State;
/*     */   
/*     */   public static int save3State;
/*     */   
/*     */   private static int r1;
/*     */   
/*     */   private static int r2;
/*     */   
/*     */   private static int r3;
/*     */   
/*  33 */   Color sky1 = new Color(86, 201, 255);
/*     */   
/*  34 */   Color text1 = new Color(255, 255, 255);
/*     */   
/*  35 */   Color text2 = new Color(236, 210, 120);
/*     */   
/*  36 */   Color text3 = new Color(73, 73, 73);
/*     */   
/*     */   public static double cloud1x;
/*     */   
/*     */   public static double cloud1y;
/*     */   
/*     */   public static double cloud2x;
/*     */   
/*     */   public static double cloud2y;
/*     */   
/*     */   public static double cloud3x;
/*     */   
/*     */   public static double cloud3y;
/*     */   
/*     */   public static boolean playButtonSelected = false;
/*     */   
/*     */   public static boolean loadButtonSelected = false;
/*     */   
/*     */   public static boolean newButtonSelected = false;
/*     */   
/*     */   public static int playState;
/*     */   
/*     */   public static int loadState;
/*     */   
/*     */   public static int newState;
/*     */   
/*  52 */   private static double cSpeed = 0.5D;
/*     */   
/*     */   private ImageManager im;
/*     */   
/*     */   public MainMenu(double x1, double y1, ImageManager im) {
/*  57 */     cloud1x = x1;
/*  58 */     cloud1y = y1;
/*  59 */     this.im = im;
/*     */   }
/*     */   
/*     */   public static void init() {
/*  64 */     r1 = r.nextInt(3);
/*  65 */     r2 = r.nextInt(3);
/*  66 */     r3 = r.nextInt(3);
/*  68 */     if (r1 == 0) {
/*  69 */       cloud1x = 850.0D;
/*  70 */       cloud1y = 160.0D;
/*  71 */     } else if (r1 == 1) {
/*  72 */       cloud1x = 850.0D;
/*  73 */       cloud1y = 200.0D;
/*  74 */     } else if (r1 == 2) {
/*  75 */       cloud1x = 850.0D;
/*  76 */       cloud1y = 220.0D;
/*     */     } 
/*  79 */     if (r2 == 0) {
/*  80 */       cloud2x = 990.0D;
/*  81 */       cloud2y = 2.0D;
/*  82 */     } else if (r2 == 1) {
/*  83 */       cloud2x = 990.0D;
/*  84 */       cloud2y = 22.0D;
/*  85 */     } else if (r2 == 2) {
/*  86 */       cloud2x = 990.0D;
/*  87 */       cloud2y = 42.0D;
/*     */     } 
/*  90 */     if (r3 == 0) {
/*  91 */       cloud3x = -150.0D;
/*  92 */       cloud3y = 315.0D;
/*  93 */     } else if (r3 == 1) {
/*  94 */       cloud3x = -150.0D;
/*  95 */       cloud3y = 340.0D;
/*  96 */     } else if (r3 == 2) {
/*  97 */       cloud3x = -150.0D;
/*  98 */       cloud3y = 365.0D;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void tick() {
/* 104 */     if (!Save.save1.exists() || !Save.save2.exists() || !Save.save3.exists()) {
/* 105 */       Save.canMakeNewGame = true;
/* 106 */     } else if (Save.save1.exists() && Save.save2.exists() && Save.save3.exists()) {
/* 107 */       Save.canMakeNewGame = false;
/*     */     } 
/* 110 */     buttonTick();
/* 113 */     if (cloud1x > -150.0D) {
/* 114 */       cloud1x -= cSpeed + 0.1D;
/*     */     } else {
/* 116 */       cloud1x = 850.0D;
/* 117 */       cloud1y = 200.0D;
/*     */     } 
/* 121 */     if (cloud2x > -125.0D) {
/* 122 */       cloud2x -= cSpeed;
/*     */     } else {
/* 124 */       cloud2x = 990.0D;
/* 125 */       cloud2y = 22.0D;
/*     */     } 
/* 129 */     if (cloud3x <= 828.0D) {
/* 130 */       cloud3x += cSpeed;
/*     */     } else {
/* 132 */       cloud3x = -150.0D;
/* 133 */       cloud3y = 365.0D;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void renderMain(Graphics g) {
/* 141 */     g.setColor(this.sky1);
/* 142 */     g.fillRect(0, 0, 838, 1146);
/* 145 */     g.drawImage(this.im.cloud1, (int)cloud1x, (int)cloud1y, 128, 96, null);
/* 146 */     g.drawImage(this.im.cloud2, (int)cloud2x, (int)cloud2y, 128, 96, null);
/* 147 */     g.drawImage(this.im.cloud3, (int)cloud3x, (int)cloud3y, 128, 96, null);
/* 149 */     if (menuState == 1) {
/* 150 */       renderState1(g);
/* 151 */     } else if (menuState == 2) {
/* 152 */       renderState2(g);
/* 153 */     } else if (menuState != 3) {
/* 155 */       if (menuState != 4);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void buttonTick() {
/* 165 */     if (menuState == 1) {
/* 167 */       if (MouseMotion.mouseX >= 336 && MouseMotion.mouseX <= 491 && 
/* 168 */         MouseMotion.mouseY >= 266 && 
/* 169 */         MouseMotion.mouseY <= 292) {
/* 170 */         playState = 2;
/* 171 */         if (MouseManager.mouseFullClick == 1) {
/* 172 */           playState = 3;
/*     */         } else {
/* 174 */           playState = 2;
/*     */         } 
/*     */       } else {
/* 177 */         playState = 1;
/*     */       } 
/* 180 */       if (MouseMotion.mouseX >= 336 && MouseMotion.mouseX <= 491 && 
/* 181 */         MouseMotion.mouseY >= 304 && 
/* 182 */         MouseMotion.mouseY <= 330 && Load.canLoadGame) {
/* 183 */         loadState = 2;
/* 184 */         if (MouseManager.mouseFullClick == 1) {
/* 185 */           loadState = 3;
/*     */         } else {
/* 187 */           loadState = 2;
/*     */         } 
/*     */       } else {
/* 190 */         loadState = 1;
/*     */       } 
/* 193 */       if (MouseMotion.mouseX >= 336 && MouseMotion.mouseX <= 491 && 
/* 194 */         MouseMotion.mouseY >= 342 && 
/* 195 */         MouseMotion.mouseY <= 370 && Save.canMakeNewGame) {
/* 196 */         newState = 2;
/* 197 */         if (MouseManager.mouseFullClick == 1) {
/* 198 */           newState = 3;
/*     */         } else {
/* 200 */           newState = 2;
/*     */         } 
/*     */       } else {
/* 203 */         newState = 1;
/*     */       } 
/*     */     } 
/* 207 */     if (menuState == 2) {
/* 209 */       if (MouseMotion.mouseX >= 139 && MouseMotion.mouseX <= 295 && 
/* 210 */         MouseMotion.mouseY >= 220 && 
/* 211 */         MouseMotion.mouseY <= 250) {
/* 212 */         save1State = 2;
/* 213 */         if (MouseManager.mouseFullClick == 1) {
/* 214 */           save1State = 3;
/*     */         } else {
/* 216 */           save1State = 2;
/*     */         } 
/*     */       } else {
/* 219 */         save1State = 1;
/*     */       } 
/* 222 */       if (MouseMotion.mouseX >= 339 && MouseMotion.mouseX <= 495 && 
/* 223 */         MouseMotion.mouseY >= 220 && 
/* 224 */         MouseMotion.mouseY <= 250) {
/* 225 */         save2State = 2;
/* 226 */         if (MouseManager.mouseFullClick == 1) {
/* 227 */           save2State = 3;
/*     */         } else {
/* 229 */           save2State = 2;
/*     */         } 
/*     */       } else {
/* 232 */         save2State = 1;
/*     */       } 
/* 235 */       if (MouseMotion.mouseX >= 539 && MouseMotion.mouseX <= 695 && 
/* 236 */         MouseMotion.mouseY >= 220 && 
/* 237 */         MouseMotion.mouseY <= 250) {
/* 238 */         save3State = 2;
/* 239 */         if (MouseManager.mouseFullClick == 1) {
/* 240 */           save3State = 3;
/*     */         } else {
/* 242 */           save3State = 2;
/*     */         } 
/*     */       } else {
/* 245 */         save3State = 1;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void renderState1(Graphics g) {
/* 255 */     g.drawImage(Game.logoImage, 163, -125, 512, 512, null);
/* 258 */     g.setFont(Game.default2);
/* 259 */     g.setColor(Color.white);
/* 260 */     g.drawString(Game.title, 5, 535);
/* 261 */     g.drawString(Game.copyright, 565, 535);
/* 264 */     g.drawImage(this.im.button1_1, 339, 264, 160, 32, null);
/* 265 */     g.setColor(this.text1);
/* 266 */     g.drawString("Play", 400, 285);
/* 268 */     if (Load.canLoadGame) {
/* 269 */       g.drawImage(this.im.button1_1, 339, 304, 160, 32, null);
/* 270 */       g.setColor(this.text1);
/* 271 */       g.drawString("Load Game...", 362, 327);
/*     */     } else {
/* 273 */       g.drawImage(this.im.button1_3, 339, 304, 160, 32, null);
/* 274 */       g.setColor(this.text3);
/* 275 */       g.drawString("Load Game...", 362, 327);
/*     */     } 
/* 278 */     if (Save.canMakeNewGame) {
/* 279 */       g.drawImage(this.im.button1_1, 339, 344, 160, 32, null);
/* 280 */       g.setColor(this.text1);
/* 281 */       g.drawString("New Game...", 362, 367);
/*     */     } else {
/* 283 */       g.drawImage(this.im.button1_3, 339, 344, 160, 32, null);
/* 284 */       g.setColor(this.text3);
/* 285 */       g.drawString("New Game...", 362, 367);
/*     */     } 
/* 289 */     if (playState == 2) {
/* 290 */       g.drawImage(this.im.button1_2, 339, 264, 160, 32, null);
/* 291 */       g.setColor(this.text2);
/* 292 */       g.drawString("Play", 400, 285);
/* 293 */     } else if (playState == 3) {
/* 294 */       Game.isInGame = true;
/* 295 */     } else if (playState == 3) {
/* 296 */       playState = 1;
/* 297 */       Game.isInGame = false;
/*     */     } 
/* 300 */     if (loadState == 2) {
/* 301 */       g.drawImage(this.im.button1_2, 339, 304, 160, 32, null);
/* 302 */       g.setColor(this.text2);
/* 303 */       g.drawString("Load Game...", 362, 327);
/* 304 */     } else if (loadState == 3) {
/* 305 */       g.drawImage(this.im.button1_3, 339, 304, 160, 32, null);
/* 306 */       g.setColor(this.text3);
/* 307 */       g.drawString("Load Game...", 362, 327);
/*     */     } 
/* 310 */     if (newState == 2) {
/* 311 */       g.drawImage(this.im.button1_2, 339, 344, 160, 32, null);
/* 312 */       g.setColor(this.text2);
/* 313 */       g.drawString("New Game...", 362, 367);
/* 314 */     } else if (newState == 3) {
/* 315 */       g.drawImage(this.im.button1_3, 339, 344, 160, 32, null);
/* 316 */       g.setColor(this.text3);
/* 317 */       g.drawString("New Game...", 362, 367);
/* 318 */       menuState = 2;
/*     */     } 
/* 322 */     g.setFont(profileSelectionFont);
/* 323 */     g.setColor(Color.darkGray);
/* 324 */     g.drawString("Save Selected: ", 369, 395);
/* 325 */     g.drawString(currentProfile, 399, 412);
/*     */   }
/*     */   
/*     */   public void renderState2(Graphics g) {
/* 332 */     if (KeyManager.escPressed) {
/* 333 */       menuState = 1;
/*     */     } else {
/* 334 */       menuState = 2;
/*     */     } 
/* 337 */     g.setFont(profileSelectionFont);
/* 338 */     g.setColor(Color.darkGray);
/* 339 */     g.drawString("Choose A Save Profile To Create: ", 313, 120);
/* 341 */     g.setFont(Game.default2);
/* 342 */     g.setColor(this.text1);
/* 346 */     if (Save.save1.exists()) {
/* 347 */       canSave1 = false;
/* 348 */       g.drawImage(this.im.button1_3, 139, 220, 160, 
/* 349 */           32, null);
/* 350 */       g.setColor(this.text3);
/* 351 */       g.drawString("Save 1", 189, 242);
/*     */     } else {
/* 353 */       canSave1 = true;
/* 354 */       if (save1State == 2) {
/* 355 */         g.drawImage(this.im.button1_2, 139, 220, 
/* 356 */             160, 32, null);
/* 357 */         g.setColor(this.text2);
/* 358 */         g.drawString("Save 1", 189, 242);
/* 359 */       } else if (save1State == 3) {
/* 360 */         g.drawImage(this.im.button1_3, 139, 220, 
/* 361 */             160, 32, null);
/* 362 */         g.setColor(this.text3);
/* 363 */         g.drawString("Save 1", 189, 242);
/*     */         try {
/* 365 */           Save.save1();
/* 366 */         } catch (IOException e) {
/* 367 */           e.printStackTrace();
/*     */         } 
/*     */       } else {
/* 370 */         g.drawImage(this.im.button1_1, 139, 220, 
/* 371 */             160, 32, null);
/* 372 */         g.setColor(this.text1);
/* 373 */         g.drawString("Save 1", 189, 242);
/*     */       } 
/*     */     } 
/* 380 */     if (Save.save2.exists()) {
/* 381 */       canSave2 = false;
/* 382 */       g.drawImage(this.im.button1_3, 339, 220, 160, 32, null);
/* 383 */       g.setColor(this.text3);
/* 384 */       g.drawString("Save 2", 389, 242);
/*     */     } else {
/* 386 */       canSave2 = true;
/* 387 */       if (save2State == 2) {
/* 388 */         g.drawImage(this.im.button1_2, 339, 220, 160, 32, 
/* 389 */             null);
/* 390 */         g.setColor(this.text2);
/* 391 */         g.drawString("Save 2", 389, 242);
/* 392 */       } else if (save2State == 3) {
/* 393 */         g.drawImage(this.im.button1_3, 339, 220, 160, 32, 
/* 394 */             null);
/* 395 */         g.setColor(this.text3);
/* 396 */         g.drawString("Save 2", 389, 242);
/*     */         try {
/* 398 */           Save.save2();
/* 399 */         } catch (IOException e) {
/* 400 */           e.printStackTrace();
/*     */         } 
/*     */       } else {
/* 403 */         g.drawImage(this.im.button1_1, 339, 220, 160, 32, 
/* 404 */             null);
/* 405 */         g.setColor(this.text1);
/* 406 */         g.drawString("Save 2", 389, 242);
/*     */       } 
/*     */     } 
/* 413 */     if (Save.save3.exists()) {
/* 414 */       canSave3 = false;
/* 415 */       g.drawImage(this.im.button1_3, 539, 220, 160, 
/* 416 */           32, null);
/* 417 */       g.setColor(this.text3);
/* 418 */       g.drawString("Save 3", 589, 242);
/*     */     } else {
/* 421 */       canSave3 = true;
/* 422 */       if (save3State == 2) {
/* 423 */         g.drawImage(this.im.button1_2, 539, 220, 
/* 424 */             160, 32, null);
/* 425 */         g.setColor(this.text2);
/* 426 */         g.drawString("Save 3", 589, 242);
/* 427 */       } else if (save3State == 3) {
/* 428 */         g.drawImage(this.im.button1_3, 539, 220, 
/* 429 */             160, 32, null);
/* 430 */         g.setColor(this.text3);
/* 431 */         g.drawString("Save 3", 589, 242);
/*     */         try {
/* 433 */           Save.save3();
/* 434 */         } catch (IOException e) {
/* 435 */           e.printStackTrace();
/*     */         } 
/*     */       } else {
/* 438 */         g.drawImage(this.im.button1_1, 539, 220, 
/* 439 */             160, 32, null);
/* 440 */         g.setColor(this.text1);
/* 441 */         g.drawString("Save 3", 589, 242);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4_6.jar!\beyondOrigins\main\menus\MainMenu.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */