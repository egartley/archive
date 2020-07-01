/*     */ package beyondOrigins.main.menus;
/*     */ 
/*     */ import beyondOrigins.main.Game;
/*     */ import beyondOrigins.main.Load;
/*     */ import beyondOrigins.main.MouseManager;
/*     */ import beyondOrigins.main.MouseMotion;
/*     */ import beyondOrigins.main.Save;
/*     */ import beyondOrigins.main.gfx.ImageManager;
/*     */ import java.awt.Color;
/*     */ import java.awt.Graphics;
/*     */ import java.io.IOException;
/*     */ import java.util.Random;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ 
/*     */ public class MainMenu {
/*  20 */   static Random r = new Random();
/*     */   
/*  22 */   public static int menuState = 1;
/*     */   
/*  24 */   public static int currentProfile = 0;
/*     */   
/*     */   public static boolean canPlayProfile = false;
/*     */   
/*     */   public static boolean canDeleteProfile = false;
/*     */   
/*     */   public static int playSelectedState;
/*     */   
/*     */   public static int deleteState;
/*     */   
/*     */   public static int cancelState;
/*     */   
/*     */   public static int save1State;
/*     */   
/*     */   public static int save2State;
/*     */   
/*     */   public static int save3State;
/*     */   
/*  29 */   public static String save1Name = "";
/*     */   
/*  29 */   public static String save2Name = "";
/*     */   
/*  29 */   public static String save3Name = "";
/*     */   
/*     */   private static int r1;
/*     */   
/*     */   private static int r2;
/*     */   
/*     */   private static int r3;
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
/*     */   public static int playState;
/*     */   
/*  44 */   private static double cloudSpeed = 0.5D;
/*     */   
/*     */   private ImageManager im;
/*     */   
/*     */   public MainMenu(double x1, double y1, ImageManager im) {
/*  51 */     cloud1x = x1;
/*  52 */     cloud1y = y1;
/*  53 */     this.im = im;
/*     */   }
/*     */   
/*     */   public static void init() {
/*  60 */     r1 = r.nextInt(3);
/*  61 */     r2 = r.nextInt(3);
/*  62 */     r3 = r.nextInt(3);
/*  64 */     if (r1 == 0) {
/*  65 */       cloud1x = 850.0D;
/*  66 */       cloud1y = 160.0D;
/*  67 */     } else if (r1 == 1) {
/*  68 */       cloud1x = 850.0D;
/*  69 */       cloud1y = 200.0D;
/*  70 */     } else if (r1 == 2) {
/*  71 */       cloud1x = 850.0D;
/*  72 */       cloud1y = 220.0D;
/*     */     } 
/*  75 */     if (r2 == 0) {
/*  76 */       cloud2x = 990.0D;
/*  77 */       cloud2y = 2.0D;
/*  78 */     } else if (r2 == 1) {
/*  79 */       cloud2x = 990.0D;
/*  80 */       cloud2y = 22.0D;
/*  81 */     } else if (r2 == 2) {
/*  82 */       cloud2x = 990.0D;
/*  83 */       cloud2y = 42.0D;
/*     */     } 
/*  86 */     if (r3 == 0) {
/*  87 */       cloud3x = -150.0D;
/*  88 */       cloud3y = 315.0D;
/*  89 */     } else if (r3 == 1) {
/*  90 */       cloud3x = -150.0D;
/*  91 */       cloud3y = 340.0D;
/*  92 */     } else if (r3 == 2) {
/*  93 */       cloud3x = -150.0D;
/*  94 */       cloud3y = 365.0D;
/*     */     } 
/*     */   }
/*     */   
/*     */   public int getState_Button(int minX, int minY, int width, int height, int state) {
/* 102 */     if (MouseMotion.mouseX >= minX && MouseMotion.mouseX < minX + width && 
/* 103 */       MouseMotion.mouseY >= minY && 
/* 104 */       MouseMotion.mouseY < minY + height) {
/* 105 */       state = 2;
/* 106 */       if (MouseManager.mouseFullClick == 1) {
/* 107 */         state = 3;
/*     */       } else {
/* 109 */         state = 2;
/*     */       } 
/*     */     } else {
/* 111 */       state = 1;
/*     */     } 
/* 112 */     return state;
/*     */   }
/*     */   
/*     */   public int getState_Selection(int minX, int minY, int width, int height, int mainState, int extraState1, int extraState2) {
/* 117 */     if (MouseMotion.mouseX >= minX && MouseMotion.mouseX < minX + width && 
/* 118 */       MouseMotion.mouseY >= minY && 
/* 119 */       MouseMotion.mouseY < minY + height && 
/* 120 */       MouseManager.mouseFullClick == 1) {
/* 121 */       mainState = 3;
/* 122 */     } else if (extraState1 == 3 || extraState2 == 3) {
/* 123 */       mainState = 1;
/*     */     } 
/* 125 */     return mainState;
/*     */   }
/*     */   
/*     */   public void tick() {
/* 133 */     if (cloud1x > -150.0D) {
/* 134 */       cloud1x -= cloudSpeed + 0.1D;
/*     */     } else {
/* 136 */       cloud1x = 850.0D;
/* 137 */       cloud1y = 200.0D;
/*     */     } 
/* 141 */     if (cloud2x > -125.0D) {
/* 142 */       cloud2x -= cloudSpeed;
/*     */     } else {
/* 144 */       cloud2x = 990.0D;
/* 145 */       cloud2y = 22.0D;
/*     */     } 
/* 149 */     if (cloud3x <= 828.0D) {
/* 150 */       cloud3x += cloudSpeed;
/*     */     } else {
/* 152 */       cloud3x = -150.0D;
/* 153 */       cloud3y = 365.0D;
/*     */     } 
/* 156 */     if (menuState == 2) {
/* 158 */       if (!Save.save1.exists()) {
/* 159 */         save1Name = "Play To Create Me";
/* 160 */       } else if (Save.save1.exists()) {
/* 161 */         save1Name = "Profile 1";
/*     */       } 
/* 164 */       if (!Save.save2.exists()) {
/* 165 */         save2Name = "Play To Create Me";
/* 166 */       } else if (Save.save2.exists()) {
/* 167 */         save2Name = "Profile 2";
/*     */       } 
/* 170 */       if (!Save.save3.exists()) {
/* 171 */         save3Name = "Play To Create Me";
/* 172 */       } else if (Save.save3.exists()) {
/* 173 */         save3Name = "Profile 3";
/*     */       } 
/* 177 */       if (save1State == 3 || save2State == 3 || save3State == 3) {
/* 178 */         canPlayProfile = true;
/* 180 */       } else if (save1State == 0 && save2State == 0 && save3State == 0) {
/* 181 */         canPlayProfile = false;
/*     */       } 
/* 186 */       if (currentProfile == 1 && !Save.save1.exists()) {
/* 187 */         canDeleteProfile = false;
/* 188 */       } else if (currentProfile == 1 && Save.save1.exists()) {
/* 189 */         canDeleteProfile = true;
/*     */       } 
/* 192 */       if (currentProfile == 2 && !Save.save2.exists()) {
/* 193 */         canDeleteProfile = false;
/* 194 */       } else if (currentProfile == 2 && Save.save2.exists()) {
/* 195 */         canDeleteProfile = true;
/*     */       } 
/* 198 */       if (currentProfile == 3 && !Save.save3.exists()) {
/* 199 */         canDeleteProfile = false;
/* 200 */       } else if (currentProfile == 3 && Save.save3.exists()) {
/* 201 */         canDeleteProfile = true;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void renderMain(Graphics g) {
/* 211 */     g.setColor(Game.sky1);
/* 212 */     g.fillRect(0, 0, 838, 573);
/* 215 */     g.drawImage(this.im.cloud1, (int)cloud1x, (int)cloud1y, 128, 96, null);
/* 216 */     g.drawImage(this.im.cloud2, (int)cloud2x, (int)cloud2y, 128, 96, null);
/* 217 */     g.drawImage(this.im.cloud3, (int)cloud3x, (int)cloud3y, 128, 96, null);
/* 219 */     if (menuState == 1) {
/* 220 */       renderState1(g);
/* 221 */     } else if (menuState == 2) {
/* 222 */       renderState2(g);
/* 223 */     } else if (menuState != 3) {
/* 225 */       if (menuState != 4);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void renderState1(Graphics g) {
/* 235 */     playState = getState_Button(251, 264, 336, 32, 
/* 236 */         playState);
/* 239 */     g.drawImage(Game.logoImage, 163, -125, 512, 512, null);
/* 242 */     g.setFont(Game.default2);
/* 243 */     g.setColor(Color.white);
/* 244 */     g.drawString(Game.title, 5, 535);
/* 245 */     g.drawString(Game.copyright, 659, 535);
/* 248 */     if (playState == 1) {
/* 249 */       g.drawImage(this.im.button2_1, 251, 264, 336, 32, null);
/* 250 */       g.setColor(Game.text1);
/* 251 */       g.drawString("Play", 400, 285);
/* 252 */     } else if (playState == 2) {
/* 253 */       g.drawImage(this.im.button2_2, 251, 264, 336, 32, null);
/* 254 */       g.setColor(Game.text2);
/* 255 */       g.drawString("Play", 400, 285);
/* 256 */     } else if (playState == 3) {
/* 257 */       menuStateIs1_play();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void renderState2(Graphics g) {
/* 264 */     MouseManager.canClick = true;
/* 266 */     g.setFont(Game.menuText1);
/* 267 */     g.setColor(Game.text1Color);
/* 271 */     if (save1State == 3) {
/* 272 */       g.drawImage(this.im.profileSelection, 268, 43, 300, 117, null);
/* 273 */       currentProfile = 1;
/* 274 */     } else if (save2State == 3) {
/* 275 */       g.drawImage(this.im.profileSelection, 268, 153, 300, 117, null);
/* 276 */       currentProfile = 2;
/* 277 */     } else if (save3State == 3) {
/* 278 */       g.drawImage(this.im.profileSelection, 268, 263, 300, 117, null);
/* 279 */       currentProfile = 3;
/*     */     } 
/* 283 */     save1State = getState_Selection(268, 43, 244, 92, save1State, 
/* 284 */         save2State, save3State);
/* 285 */     save2State = getState_Selection(268, 153, 300, 117, 
/* 286 */         save2State, save1State, save3State);
/* 287 */     save3State = getState_Selection(268, 263, 300, 117, 
/* 288 */         save3State, save1State, save2State);
/* 290 */     playSelectedState = getState_Button(
/* 291 */         419 - this.im.button2_1.getWidth() / 2, 425, 
/* 292 */         this.im.button2_1.getWidth(), this.im.button2_1.getHeight(), 
/* 293 */         playSelectedState);
/* 294 */     deleteState = getState_Button(
/* 295 */         419 - this.im.button2_1.getWidth() / 2, 473, 
/* 296 */         this.im.button1_1.getWidth(), this.im.button1_1.getHeight(), deleteState);
/* 297 */     cancelState = getState_Button(
/* 298 */         419 - this.im.button2_1.getWidth() / 2 + 176, 473, 
/* 299 */         this.im.button1_1.getWidth(), this.im.button1_3.getHeight(), cancelState);
/* 303 */     g.drawImage(this.im.profileSquare, 275, 50, 96, 96, null);
/* 304 */     if (Save.save1.exists()) {
/* 305 */       g.setColor(Game.gameProgressColor);
/* 306 */       g.setFont(Game.gameProgressFont);
/* 307 */       g.drawString(String.valueOf(Save.save1Progress) + "%", 298, 110);
/*     */     } else {
/* 309 */       g.drawImage(this.im.profileEmpty, 290, 66, 64, 64, 
/* 310 */           null);
/*     */     } 
/* 311 */     if (currentProfile == 1) {
/* 312 */       g.setColor(Color.white);
/*     */     } else {
/* 314 */       g.setColor(Game.text1Color);
/*     */     } 
/* 315 */     g.setFont(Game.menuText1_1);
/* 316 */     g.drawString(save1Name, 380, 70);
/* 317 */     g.setFont(Game.menuText1);
/* 318 */     g.drawString("Last Played: " + Save.save1LastPlayed, 380, 103);
/* 319 */     g.drawString("Date Created: " + Save.save1Made, 380, 135);
/* 323 */     g.drawImage(this.im.profileSquare, 275, 160, 96, 96, null);
/* 324 */     g.drawImage(this.im.profileEmpty, 290, 176, 64, 64, 
/* 325 */         null);
/* 326 */     if (Save.save2.exists()) {
/* 327 */       g.setColor(Game.gameProgressColor);
/* 328 */       g.setFont(Game.gameProgressFont);
/* 329 */       g.drawString(String.valueOf(Save.save2Progress) + "%", 298, 220);
/*     */     } else {
/* 331 */       g.drawImage(this.im.profileEmpty, 290, 176, 64, 64, 
/* 332 */           null);
/*     */     } 
/* 333 */     if (currentProfile == 2) {
/* 334 */       g.setColor(Color.white);
/*     */     } else {
/* 336 */       g.setColor(Game.text1Color);
/*     */     } 
/* 337 */     g.setFont(Game.menuText1_1);
/* 338 */     g.drawString(save2Name, 380, 180);
/* 339 */     g.setFont(Game.menuText1);
/* 340 */     g.drawString("Last Played: " + Save.save2LastPlayed, 380, 213);
/* 341 */     g.drawString("Date Created: " + Save.save2Made, 380, 245);
/* 345 */     g.drawImage(this.im.profileSquare, 275, 270, 96, 96, null);
/* 346 */     g.drawImage(this.im.profileEmpty, 290, 286, 64, 64, 
/* 347 */         null);
/* 348 */     if (Save.save3.exists()) {
/* 349 */       g.setColor(Game.gameProgressColor);
/* 350 */       g.setFont(Game.gameProgressFont);
/* 351 */       g.drawString(String.valueOf(Save.save3Progress) + "%", 298, 330);
/*     */     } else {
/* 353 */       g.drawImage(this.im.profileEmpty, 290, 286, 64, 64, 
/* 354 */           null);
/*     */     } 
/* 355 */     if (currentProfile == 3) {
/* 356 */       g.setColor(Color.white);
/*     */     } else {
/* 358 */       g.setColor(Game.text1Color);
/*     */     } 
/* 359 */     g.setFont(Game.menuText1_1);
/* 360 */     g.drawString(save3Name, 380, 290);
/* 361 */     g.setFont(Game.menuText1);
/* 362 */     g.drawString("Last Played: " + Save.save3LastPlayed, 380, 323);
/* 363 */     g.drawString("Date Created: " + Save.save3Made, 380, 355);
/* 365 */     g.setFont(Game.default2);
/* 366 */     g.setColor(Game.text1);
/* 370 */     if (canPlayProfile) {
/* 371 */       if (playSelectedState == 1) {
/* 372 */         g.drawImage(this.im.button2_1, 419 - 
/* 373 */             this.im.button2_1.getWidth() / 2, 425, 
/* 374 */             this.im.button2_1.getWidth(), this.im.button2_1.getHeight(), null);
/* 375 */         g.setColor(Game.text1);
/* 376 */         g.drawString("Play Selected Profile", 324, 446);
/* 377 */       } else if (playSelectedState == 2) {
/* 378 */         g.drawImage(this.im.button2_2, 419 - 
/* 379 */             this.im.button2_1.getWidth() / 2, 425, 
/* 380 */             this.im.button2_1.getWidth(), this.im.button2_1.getHeight(), null);
/* 381 */         g.setColor(Game.text2);
/* 382 */         g.drawString("Play Selected Profile", 324, 446);
/* 383 */       } else if (playSelectedState == 3) {
/* 384 */         g.drawImage(this.im.button2_3, 419 - 
/* 385 */             this.im.button2_1.getWidth() / 2, 425, 
/* 386 */             this.im.button2_1.getWidth(), this.im.button2_1.getHeight(), null);
/* 387 */         g.setColor(Game.text3);
/* 388 */         g.drawString("Play Selected Profile", 324, 446);
/*     */         try {
/* 390 */           menuStateIs2_playProfile();
/* 391 */         } catch (IOException e) {
/* 392 */           e.printStackTrace();
/*     */         } 
/*     */       } 
/* 395 */     } else if (!canPlayProfile) {
/* 396 */       g.drawImage(this.im.button2_3, 419 - 
/* 397 */           this.im.button2_3.getWidth() / 2, 425, 
/* 398 */           this.im.button2_3.getWidth(), this.im.button2_3.getHeight(), null);
/* 399 */       g.setColor(Game.text3);
/* 400 */       g.drawString("Play Selected Profile", 324, 446);
/*     */     } 
/* 405 */     if (canDeleteProfile) {
/* 406 */       if (deleteState == 1) {
/* 407 */         g.drawImage(this.im.button1_1, 419 - 
/* 408 */             this.im.button2_1.getWidth() / 2, 473, 
/* 409 */             this.im.button1_2.getWidth(), this.im.button1_2.getHeight(), null);
/* 410 */         g.setColor(Game.text1);
/* 411 */         g.drawString("Delete", 297, 496);
/* 412 */       } else if (deleteState == 2) {
/* 413 */         g.drawImage(this.im.button1_2, 419 - 
/* 414 */             this.im.button2_1.getWidth() / 2, 473, 
/* 415 */             this.im.button1_2.getWidth(), this.im.button1_2.getHeight(), null);
/* 416 */         g.setColor(Game.text2);
/* 417 */         g.drawString("Delete", 297, 496);
/* 418 */       } else if (deleteState == 3) {
/* 419 */         g.drawImage(this.im.button1_3, 419 - 
/* 420 */             this.im.button2_1.getWidth() / 2, 473, 
/* 421 */             this.im.button1_3.getWidth(), this.im.button1_3.getHeight(), null);
/* 422 */         g.setColor(Game.text3);
/* 423 */         g.drawString("Delete", 297, 496);
/* 424 */         menuStateIs2_deleteProfile();
/*     */       } 
/* 426 */     } else if (!canDeleteProfile) {
/* 427 */       g.drawImage(this.im.button1_3, 419 - 
/* 428 */           this.im.button2_1.getWidth() / 2, 473, 
/* 429 */           this.im.button1_3.getWidth(), this.im.button1_3.getHeight(), null);
/* 430 */       g.setColor(Game.text3);
/* 431 */       g.drawString("Delete", 297, 496);
/*     */     } 
/* 436 */     if (cancelState == 1) {
/* 437 */       g.drawImage(this.im.button1_1, 
/* 438 */           419 - this.im.button2_1.getWidth() / 2 + 176, 
/* 439 */           473, this.im.button1_2.getWidth(), 
/* 440 */           this.im.button1_2.getHeight(), null);
/* 441 */       g.setColor(Game.text1);
/* 442 */       g.drawString("Cancel", 473, 496);
/* 443 */     } else if (cancelState == 2) {
/* 444 */       g.drawImage(this.im.button1_2, 
/* 445 */           419 - this.im.button2_1.getWidth() / 2 + 176, 
/* 446 */           473, this.im.button1_2.getWidth(), 
/* 447 */           this.im.button1_2.getHeight(), null);
/* 448 */       g.setColor(Game.text2);
/* 449 */       g.drawString("Cancel", 473, 496);
/* 450 */     } else if (cancelState == 3) {
/* 451 */       g.drawImage(this.im.button1_3, 
/* 452 */           419 - this.im.button2_1.getWidth() / 2 + 176, 
/* 453 */           473, this.im.button1_1.getWidth(), 
/* 454 */           this.im.button1_3.getHeight(), null);
/* 455 */       g.setColor(Game.text3);
/* 456 */       g.drawString("Cancel", 473, 496);
/*     */       try {
/* 459 */         TimeUnit.MILLISECONDS.sleep(75L);
/* 460 */       } catch (InterruptedException e) {
/* 461 */         e.printStackTrace();
/*     */       } 
/* 463 */       save1State = 0;
/* 464 */       save2State = 0;
/* 465 */       save3State = 0;
/* 466 */       currentProfile = 0;
/* 467 */       menuState = 1;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void menuStateIs2_playProfile() throws IOException {
/* 476 */     Save.reset();
/* 478 */     if (currentProfile == 1) {
/* 479 */       if (!Save.save1.exists()) {
/* 480 */         Save.save1();
/* 481 */         Game.isInGame = true;
/* 482 */         Load.loadProfile1(Game.save1Path);
/* 483 */       } else if (Save.save1.exists()) {
/* 484 */         Game.isInGame = true;
/* 485 */         Load.loadProfile1(Game.save1Path);
/*     */       } 
/* 487 */     } else if (currentProfile == 2) {
/* 488 */       if (!Save.save2.exists()) {
/* 489 */         Save.save2();
/* 490 */         Game.isInGame = true;
/* 491 */         Load.loadProfile1(Game.save2Path);
/* 492 */       } else if (Save.save2.exists()) {
/* 493 */         Game.isInGame = true;
/* 494 */         Load.loadProfile1(Game.save2Path);
/*     */       } 
/* 496 */     } else if (currentProfile == 3) {
/* 497 */       if (!Save.save3.exists()) {
/* 498 */         Save.save3();
/* 499 */         Game.isInGame = true;
/* 500 */         Load.loadProfile1(Game.save3Path);
/* 501 */       } else if (Save.save3.exists()) {
/* 502 */         Game.isInGame = true;
/* 503 */         Load.loadProfile1(Game.save3Path);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void menuStateIs2_deleteProfile() {
/* 511 */     if (currentProfile == 1 && Save.save1.exists()) {
/* 512 */       Save.save1.delete();
/* 513 */     } else if (currentProfile == 2 && Save.save2.exists()) {
/* 514 */       Save.save2.delete();
/* 515 */     } else if (currentProfile == 3 && Save.save3.exists()) {
/* 516 */       Save.save3.delete();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void menuStateIs2_cancel() {}
/*     */   
/*     */   public void menuStateIs1_play() {
/* 526 */     MouseManager.canClick = false;
/* 527 */     menuState = 2;
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4.8.jar!\beyondOrigins\main\menus\MainMenu.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */