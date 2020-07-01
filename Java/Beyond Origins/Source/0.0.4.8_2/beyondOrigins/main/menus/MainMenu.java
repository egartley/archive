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
/*  22 */   static Random r = new Random();
/*     */   
/*  24 */   public static int menuState = 1;
/*     */   
/*  26 */   public static int currentProfile = 0;
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
/*  31 */   public static String save1Name = "";
/*     */   
/*  31 */   public static String save2Name = "";
/*     */   
/*  31 */   public static String save3Name = "";
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
/*  46 */   private static double cloudSpeed = 0.5D;
/*     */   
/*     */   private ImageManager im;
/*     */   
/*     */   public MainMenu(double x1, double y1, ImageManager im) {
/*  53 */     cloud1x = x1;
/*  54 */     cloud1y = y1;
/*  55 */     this.im = im;
/*     */   }
/*     */   
/*     */   public static void init() {
/*  62 */     r1 = r.nextInt(3);
/*  63 */     r2 = r.nextInt(3);
/*  64 */     r3 = r.nextInt(3);
/*  66 */     if (r1 == 0) {
/*  67 */       cloud1x = 850.0D;
/*  68 */       cloud1y = 160.0D;
/*  69 */     } else if (r1 == 1) {
/*  70 */       cloud1x = 850.0D;
/*  71 */       cloud1y = 200.0D;
/*  72 */     } else if (r1 == 2) {
/*  73 */       cloud1x = 850.0D;
/*  74 */       cloud1y = 220.0D;
/*     */     } 
/*  77 */     if (r2 == 0) {
/*  78 */       cloud2x = 990.0D;
/*  79 */       cloud2y = 2.0D;
/*  80 */     } else if (r2 == 1) {
/*  81 */       cloud2x = 990.0D;
/*  82 */       cloud2y = 22.0D;
/*  83 */     } else if (r2 == 2) {
/*  84 */       cloud2x = 990.0D;
/*  85 */       cloud2y = 42.0D;
/*     */     } 
/*  88 */     if (r3 == 0) {
/*  89 */       cloud3x = -150.0D;
/*  90 */       cloud3y = 315.0D;
/*  91 */     } else if (r3 == 1) {
/*  92 */       cloud3x = -150.0D;
/*  93 */       cloud3y = 340.0D;
/*  94 */     } else if (r3 == 2) {
/*  95 */       cloud3x = -150.0D;
/*  96 */       cloud3y = 365.0D;
/*     */     } 
/*     */   }
/*     */   
/*     */   public int getState_Button(int minX, int minY, int width, int height, int state) {
/* 104 */     if (MouseMotion.mouseX >= minX && MouseMotion.mouseX < minX + width && 
/* 105 */       MouseMotion.mouseY >= minY && 
/* 106 */       MouseMotion.mouseY < minY + height) {
/* 107 */       state = 2;
/* 108 */       if (MouseManager.mouseFullClick == 1) {
/* 109 */         state = 3;
/*     */       } else {
/* 111 */         state = 2;
/*     */       } 
/*     */     } else {
/* 113 */       state = 1;
/*     */     } 
/* 114 */     return state;
/*     */   }
/*     */   
/*     */   public int getState_Selection(int minX, int minY, int width, int height, int mainState, int extraState1, int extraState2) {
/* 119 */     if (MouseMotion.mouseX >= minX && MouseMotion.mouseX < minX + width && 
/* 120 */       MouseMotion.mouseY >= minY && 
/* 121 */       MouseMotion.mouseY < minY + height && 
/* 122 */       MouseManager.mouseFullClick == 1) {
/* 123 */       mainState = 3;
/* 124 */     } else if (extraState1 == 3 || extraState2 == 3) {
/* 125 */       mainState = 1;
/*     */     } 
/* 127 */     return mainState;
/*     */   }
/*     */   
/*     */   public void tick() {
/* 135 */     if (cloud1x > -150.0D) {
/* 136 */       cloud1x -= cloudSpeed + 0.1D;
/*     */     } else {
/* 138 */       cloud1x = 850.0D;
/* 139 */       cloud1y = 200.0D;
/*     */     } 
/* 143 */     if (cloud2x > -125.0D) {
/* 144 */       cloud2x -= cloudSpeed;
/*     */     } else {
/* 146 */       cloud2x = 990.0D;
/* 147 */       cloud2y = 22.0D;
/*     */     } 
/* 151 */     if (cloud3x <= 828.0D) {
/* 152 */       cloud3x += cloudSpeed;
/*     */     } else {
/* 154 */       cloud3x = -150.0D;
/* 155 */       cloud3y = 365.0D;
/*     */     } 
/* 158 */     if (menuState == 2) {
/* 160 */       if (!Save.save1.exists()) {
/* 161 */         save1Name = "Play To Create Me";
/* 162 */       } else if (Save.save1.exists()) {
/* 163 */         save1Name = "Profile 1";
/*     */       } 
/* 166 */       if (!Save.save2.exists()) {
/* 167 */         save2Name = "Play To Create Me";
/* 168 */       } else if (Save.save2.exists()) {
/* 169 */         save2Name = "Profile 2";
/*     */       } 
/* 172 */       if (!Save.save3.exists()) {
/* 173 */         save3Name = "Play To Create Me";
/* 174 */       } else if (Save.save3.exists()) {
/* 175 */         save3Name = "Profile 3";
/*     */       } 
/* 179 */       if (save1State == 3 || save2State == 3 || save3State == 3) {
/* 180 */         canPlayProfile = true;
/* 182 */       } else if (save1State == 0 && save2State == 0 && save3State == 0) {
/* 183 */         canPlayProfile = false;
/*     */       } 
/* 188 */       if (currentProfile == 1 && !Save.save1.exists()) {
/* 189 */         canDeleteProfile = false;
/* 190 */       } else if (currentProfile == 1 && Save.save1.exists()) {
/* 191 */         canDeleteProfile = true;
/*     */       } 
/* 194 */       if (currentProfile == 2 && !Save.save2.exists()) {
/* 195 */         canDeleteProfile = false;
/* 196 */       } else if (currentProfile == 2 && Save.save2.exists()) {
/* 197 */         canDeleteProfile = true;
/*     */       } 
/* 200 */       if (currentProfile == 3 && !Save.save3.exists()) {
/* 201 */         canDeleteProfile = false;
/* 202 */       } else if (currentProfile == 3 && Save.save3.exists()) {
/* 203 */         canDeleteProfile = true;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void renderMain(Graphics g) {
/* 213 */     g.setColor(Game.sky1);
/* 214 */     g.fillRect(0, 0, 838, 573);
/* 217 */     g.drawImage(this.im.cloud1, (int)cloud1x, (int)cloud1y, 128, 96, null);
/* 218 */     g.drawImage(this.im.cloud2, (int)cloud2x, (int)cloud2y, 128, 96, null);
/* 219 */     g.drawImage(this.im.cloud3, (int)cloud3x, (int)cloud3y, 128, 96, null);
/* 221 */     if (menuState == 1) {
/* 222 */       renderState1(g);
/* 223 */     } else if (menuState == 2) {
/* 224 */       renderState2(g);
/* 225 */     } else if (menuState != 3) {
/* 227 */       if (menuState != 4);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void renderState1(Graphics g) {
/* 237 */     playState = getState_Button(251, 264, 336, 32, 
/* 238 */         playState);
/* 241 */     g.drawImage(Game.logoImage, 163, -125, 512, 512, null);
/* 244 */     g.setFont(Game.default2);
/* 245 */     g.setColor(Color.white);
/* 246 */     g.drawString(Game.title, 5, 535);
/* 247 */     g.drawString(Game.copyright, 659, 535);
/* 250 */     if (playState == 1) {
/* 251 */       g.drawImage(this.im.button2_1, 251, 264, 336, 32, null);
/* 252 */       g.setColor(Game.text1);
/* 253 */       g.drawString("Play", 400, 285);
/* 254 */     } else if (playState == 2) {
/* 255 */       g.drawImage(this.im.button2_2, 251, 264, 336, 32, null);
/* 256 */       g.setColor(Game.text2);
/* 257 */       g.drawString("Play", 400, 285);
/* 258 */     } else if (playState == 3) {
/* 259 */       menuStateIs1_play();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void renderState2(Graphics g) {
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
/* 324 */     if (Save.save2.exists()) {
/* 325 */       g.setColor(Game.gameProgressColor);
/* 326 */       g.setFont(Game.gameProgressFont);
/* 327 */       g.drawString(String.valueOf(Save.save2Progress) + "%", 298, 220);
/*     */     } else {
/* 329 */       g.drawImage(this.im.profileEmpty, 290, 176, 64, 64, 
/* 330 */           null);
/*     */     } 
/* 332 */     if (currentProfile == 2) {
/* 333 */       g.setColor(Color.white);
/*     */     } else {
/* 335 */       g.setColor(Game.text1Color);
/*     */     } 
/* 336 */     g.setFont(Game.menuText1_1);
/* 337 */     g.drawString(save2Name, 380, 180);
/* 338 */     g.setFont(Game.menuText1);
/* 339 */     g.drawString("Last Played: " + Save.save2LastPlayed, 380, 213);
/* 340 */     g.drawString("Date Created: " + Save.save2Made, 380, 245);
/* 344 */     g.drawImage(this.im.profileSquare, 275, 270, 96, 96, null);
/* 345 */     if (Save.save3.exists()) {
/* 346 */       g.setColor(Game.gameProgressColor);
/* 347 */       g.setFont(Game.gameProgressFont);
/* 348 */       g.drawString(String.valueOf(Save.save3Progress) + "%", 298, 330);
/*     */     } else {
/* 350 */       g.drawImage(this.im.profileEmpty, 290, 286, 64, 64, 
/* 351 */           null);
/*     */     } 
/* 352 */     if (currentProfile == 3) {
/* 353 */       g.setColor(Color.white);
/*     */     } else {
/* 355 */       g.setColor(Game.text1Color);
/*     */     } 
/* 356 */     g.setFont(Game.menuText1_1);
/* 357 */     g.drawString(save3Name, 380, 290);
/* 358 */     g.setFont(Game.menuText1);
/* 359 */     g.drawString("Last Played: " + Save.save3LastPlayed, 380, 323);
/* 360 */     g.drawString("Date Created: " + Save.save3Made, 380, 355);
/* 362 */     g.setFont(Game.default2);
/* 363 */     g.setColor(Game.text1);
/* 367 */     if (canPlayProfile) {
/* 368 */       if (playSelectedState == 1) {
/* 369 */         g.drawImage(this.im.button2_1, 419 - 
/* 370 */             this.im.button2_1.getWidth() / 2, 425, 
/* 371 */             this.im.button2_1.getWidth(), this.im.button2_1.getHeight(), null);
/* 372 */         g.setColor(Game.text1);
/* 373 */         g.drawString("Play Selected Profile", 324, 446);
/* 374 */       } else if (playSelectedState == 2) {
/* 375 */         g.drawImage(this.im.button2_2, 419 - 
/* 376 */             this.im.button2_1.getWidth() / 2, 425, 
/* 377 */             this.im.button2_1.getWidth(), this.im.button2_1.getHeight(), null);
/* 378 */         g.setColor(Game.text2);
/* 379 */         g.drawString("Play Selected Profile", 324, 446);
/* 380 */       } else if (playSelectedState == 3) {
/* 381 */         g.drawImage(this.im.button2_3, 419 - 
/* 382 */             this.im.button2_1.getWidth() / 2, 425, 
/* 383 */             this.im.button2_1.getWidth(), this.im.button2_1.getHeight(), null);
/* 384 */         g.setColor(Game.text3);
/* 385 */         g.drawString("Play Selected Profile", 324, 446);
/*     */         try {
/* 387 */           menuStateIs2_playProfile();
/* 388 */         } catch (IOException e) {
/* 389 */           e.printStackTrace();
/*     */         } 
/*     */       } 
/* 392 */     } else if (!canPlayProfile) {
/* 393 */       g.drawImage(this.im.button2_3, 419 - 
/* 394 */           this.im.button2_3.getWidth() / 2, 425, 
/* 395 */           this.im.button2_3.getWidth(), this.im.button2_3.getHeight(), null);
/* 396 */       g.setColor(Game.text3);
/* 397 */       g.drawString("Play Selected Profile", 324, 446);
/*     */     } 
/* 402 */     if (canDeleteProfile) {
/* 403 */       if (deleteState == 1) {
/* 404 */         g.drawImage(this.im.button1_1, 419 - 
/* 405 */             this.im.button2_1.getWidth() / 2, 473, 
/* 406 */             this.im.button1_2.getWidth(), this.im.button1_2.getHeight(), null);
/* 407 */         g.setColor(Game.text1);
/* 408 */         g.drawString("Delete", 297, 496);
/* 409 */       } else if (deleteState == 2) {
/* 410 */         g.drawImage(this.im.button1_2, 419 - 
/* 411 */             this.im.button2_1.getWidth() / 2, 473, 
/* 412 */             this.im.button1_2.getWidth(), this.im.button1_2.getHeight(), null);
/* 413 */         g.setColor(Game.text2);
/* 414 */         g.drawString("Delete", 297, 496);
/* 415 */       } else if (deleteState == 3) {
/* 416 */         g.drawImage(this.im.button1_3, 419 - 
/* 417 */             this.im.button2_1.getWidth() / 2, 473, 
/* 418 */             this.im.button1_3.getWidth(), this.im.button1_3.getHeight(), null);
/* 419 */         g.setColor(Game.text3);
/* 420 */         g.drawString("Delete", 297, 496);
/* 421 */         menuStateIs2_deleteProfile();
/*     */       } 
/* 423 */     } else if (!canDeleteProfile) {
/* 424 */       g.drawImage(this.im.button1_3, 419 - 
/* 425 */           this.im.button2_1.getWidth() / 2, 473, 
/* 426 */           this.im.button1_3.getWidth(), this.im.button1_3.getHeight(), null);
/* 427 */       g.setColor(Game.text3);
/* 428 */       g.drawString("Delete", 297, 496);
/*     */     } 
/* 433 */     if (cancelState == 1) {
/* 434 */       g.drawImage(this.im.button1_1, 
/* 435 */           419 - this.im.button2_1.getWidth() / 2 + 176, 
/* 436 */           473, this.im.button1_2.getWidth(), 
/* 437 */           this.im.button1_2.getHeight(), null);
/* 438 */       g.setColor(Game.text1);
/* 439 */       g.drawString("Cancel", 473, 496);
/* 440 */     } else if (cancelState == 2) {
/* 441 */       g.drawImage(this.im.button1_2, 
/* 442 */           419 - this.im.button2_1.getWidth() / 2 + 176, 
/* 443 */           473, this.im.button1_2.getWidth(), 
/* 444 */           this.im.button1_2.getHeight(), null);
/* 445 */       g.setColor(Game.text2);
/* 446 */       g.drawString("Cancel", 473, 496);
/* 447 */     } else if (cancelState == 3) {
/* 448 */       g.drawImage(this.im.button1_3, 
/* 449 */           419 - this.im.button2_1.getWidth() / 2 + 176, 
/* 450 */           473, this.im.button1_1.getWidth(), 
/* 451 */           this.im.button1_3.getHeight(), null);
/* 452 */       g.setColor(Game.text3);
/* 453 */       g.drawString("Cancel", 473, 496);
/*     */       try {
/* 456 */         TimeUnit.MILLISECONDS.sleep(75L);
/* 457 */       } catch (InterruptedException e) {
/* 458 */         e.printStackTrace();
/*     */       } 
/* 460 */       save1State = 0;
/* 461 */       save2State = 0;
/* 462 */       save3State = 0;
/* 463 */       currentProfile = 0;
/* 464 */       menuState = 1;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void menuStateIs2_playProfile() throws IOException {
/* 473 */     Save.reset();
/* 475 */     if (currentProfile == 1) {
/* 476 */       if (!Save.save1.exists()) {
/* 477 */         Save.save1();
/* 478 */         Game.isInGame = true;
/* 479 */         Load.loadProfile1(Game.save1Path);
/* 480 */       } else if (Save.save1.exists()) {
/* 481 */         Game.isInGame = true;
/* 482 */         Load.loadProfile1(Game.save1Path);
/*     */       } 
/* 484 */     } else if (currentProfile == 2) {
/* 485 */       if (!Save.save2.exists()) {
/* 486 */         Save.save2();
/* 487 */         Game.isInGame = true;
/* 488 */         Load.loadProfile1(Game.save2Path);
/* 489 */       } else if (Save.save2.exists()) {
/* 490 */         Game.isInGame = true;
/* 491 */         Load.loadProfile1(Game.save2Path);
/*     */       } 
/* 493 */     } else if (currentProfile == 3) {
/* 494 */       if (!Save.save3.exists()) {
/* 495 */         Save.save3();
/* 496 */         Game.isInGame = true;
/* 497 */         Load.loadProfile1(Game.save3Path);
/* 498 */       } else if (Save.save3.exists()) {
/* 499 */         Game.isInGame = true;
/* 500 */         Load.loadProfile1(Game.save3Path);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void menuStateIs2_deleteProfile() {
/* 508 */     if (currentProfile == 1 && Save.save1.exists()) {
/* 509 */       Save.save1.delete();
/* 510 */       Save.save1Made = " ";
/* 511 */       Save.save1LastPlayed = " ";
/* 512 */     } else if (currentProfile == 2 && Save.save2.exists()) {
/* 513 */       Save.save2.delete();
/* 514 */       Save.save2Made = " ";
/* 515 */       Save.save2LastPlayed = " ";
/* 516 */     } else if (currentProfile == 3 && Save.save3.exists()) {
/* 517 */       Save.save3.delete();
/* 518 */       Save.save3Made = " ";
/* 519 */       Save.save3LastPlayed = " ";
/*     */     } 
/*     */   }
/*     */   
/*     */   public void menuStateIs2_cancel() {}
/*     */   
/*     */   public void menuStateIs1_play() {
/* 529 */     menuState = 2;
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4.8_2.jar!\beyondOrigins\main\menus\MainMenu.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */