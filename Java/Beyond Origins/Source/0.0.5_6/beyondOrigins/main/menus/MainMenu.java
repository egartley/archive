/*     */ package beyondOrigins.main.menus;
/*     */ 
/*     */ import beyondOrigins.files.Load;
/*     */ import beyondOrigins.files.Save;
/*     */ import beyondOrigins.main.Game;
/*     */ import beyondOrigins.main.entities.Player;
/*     */ import beyondOrigins.main.entities.TestDummy;
/*     */ import beyondOrigins.main.gfx.ImageManager;
/*     */ import beyondOrigins.main.story.StoryText;
/*     */ import beyondOrigins.main.windows.About;
/*     */ import beyondOrigins.main.windows.AddOns;
/*     */ import beyondOrigins.main.windows.Update;
/*     */ import beyondOrigins.userInput.KeyManager;
/*     */ import beyondOrigins.userInput.MouseMotion;
/*     */ import java.awt.Color;
/*     */ import java.awt.FontMetrics;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ 
/*     */ public class MainMenu {
/*  29 */   public static byte menuState = 1;
/*     */   
/*  35 */   public static double cloud1x = 850.0D;
/*     */   
/*  36 */   public static double cloud1y = 200.0D;
/*     */   
/*  37 */   public static double cloud2x = 990.0D;
/*     */   
/*  38 */   public static double cloud2y = 22.0D;
/*     */   
/*  39 */   public static double cloud3x = -150.0D;
/*     */   
/*  40 */   public static double cloud3y = 365.0D;
/*     */   
/*  41 */   private static double cloudSpeed = 0.5D;
/*     */   
/*  47 */   public static byte currentProfile = 0;
/*     */   
/*     */   public static boolean canPlayProfile = false;
/*     */   
/*     */   public static boolean canDeleteProfile = false;
/*     */   
/*  52 */   public static String save1Name = "IfYouSeeThisSomethingIsWrong";
/*     */   
/*  53 */   public static String save2Name = "IfYouSeeThisSomethingIsWrong";
/*     */   
/*  54 */   public static String save3Name = "IfYouSeeThisSomethingIsWrong";
/*     */   
/*     */   public static boolean enterProfile = false;
/*     */   
/*  62 */   public static String autoSaveToggle = "On";
/*     */   
/*  62 */   public static String tdToggle = "Off";
/*     */   
/*     */   public static boolean profileNameBoxInFocus = false;
/*     */   
/*     */   public static boolean playerNameBoxInFocus = false;
/*     */   
/*  72 */   private Update u = new Update();
/*     */   
/*  73 */   private AddOns a = new AddOns();
/*     */   
/*  74 */   private About ab = new About();
/*     */   
/*     */   private FontMetrics fm;
/*     */   
/*     */   private FontMetrics fm2;
/*     */   
/*     */   public static byte state;
/*     */   
/*     */   public static byte playState;
/*     */   
/*     */   public static byte playSelectedState;
/*     */   
/*     */   public static byte deleteState;
/*     */   
/*     */   public static byte cancelState;
/*     */   
/*     */   public static byte save1State;
/*     */   
/*     */   public static byte save2State;
/*     */   
/*     */   public static byte save3State;
/*     */   
/*     */   public static String save1Name_backup;
/*     */   
/*     */   public static String save2Name_backup;
/*     */   
/*     */   public static String save3Name_backup;
/*     */   
/*     */   public static byte yesState;
/*     */   
/*     */   public static byte noState;
/*     */   
/*     */   public static byte profileNameBoxState;
/*     */   
/*     */   public static byte playerNameBoxState;
/*     */   
/*     */   private byte getButtonState(int x, int y, int width, int height, byte state) {
/*  83 */     if (MouseMotion.mouseX >= x && MouseMotion.mouseX < x + width && 
/*  84 */       MouseMotion.mouseY >= y && MouseMotion.mouseY < y + height) {
/*  85 */       state = 2;
/*  86 */       if (Game.isPressed()) {
/*  87 */         state = 3;
/*     */       } else {
/*  89 */         state = 2;
/*     */       } 
/*     */     } else {
/*  91 */       state = 1;
/*     */     } 
/*  92 */     return state;
/*     */   }
/*     */   
/*     */   private byte getGeneralImageState(int x, int y, int width, int height, byte state, boolean inFocus) {
/*  99 */     if (MouseMotion.mouseX >= x && MouseMotion.mouseX < x + width && 
/* 100 */       MouseMotion.mouseY >= y && MouseMotion.mouseY < y + height) {
/* 101 */       if (!inFocus && Game.isPressed()) {
/* 102 */         state = 2;
/* 103 */         inFocus = true;
/* 104 */       } else if (inFocus) {
/* 105 */         state = 2;
/*     */       } 
/* 108 */     } else if (inFocus) {
/* 109 */       state = 2;
/* 111 */     } else if (Game.isPressed()) {
/* 112 */       state = 1;
/* 113 */       inFocus = false;
/*     */     } 
/* 118 */     return state;
/*     */   }
/*     */   
/*     */   private void drawButton(Graphics g, int x, int y, int width, int height, String buttonText, BufferedImage state1Image, BufferedImage state2Image, BufferedImage state3Image, double clickEventType) {
/* 125 */     this.fm = g.getFontMetrics(Game.buttonTextFont);
/* 127 */     g.setFont(Game.buttonTextFont);
/* 128 */     if (getButtonState(x, y, width, height, state) == 1) {
/* 129 */       g.drawImage(state1Image, x, y, width, height, null);
/* 130 */       g.setColor(Game.buttonIdleColor);
/* 131 */       g.drawString(
/* 132 */           buttonText, 
/* 133 */           x + state1Image.getWidth() / 2 - 
/* 134 */           this.fm.stringWidth(buttonText) / 2, y + 
/* 135 */           state1Image.getHeight() / 2 + 5);
/* 136 */     } else if (getButtonState(x, y, width, height, state) == 2) {
/* 137 */       g.drawImage(state2Image, x, y, width, height, null);
/* 138 */       g.setColor(Game.buttonSelectedColor);
/* 139 */       g.drawString(
/* 140 */           buttonText, 
/* 141 */           x + state1Image.getWidth() / 2 - 
/* 142 */           this.fm.stringWidth(buttonText) / 2, y + 
/* 143 */           state1Image.getHeight() / 2 + 5);
/* 144 */     } else if (getButtonState(x, y, width, height, state) == 3) {
/* 145 */       g.drawImage(state3Image, x, y, width, height, null);
/* 146 */       g.setColor(Game.buttonClickedColor);
/* 147 */       g.drawString(
/* 148 */           buttonText, 
/* 149 */           x + state1Image.getWidth() / 2 - 
/* 150 */           this.fm.stringWidth(buttonText) / 2, y + 
/* 151 */           state1Image.getHeight() / 2 + 5);
/* 152 */       clickEventHandler(clickEventType);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void clickEventHandler(double e) {
/* 158 */     if (e == 1.1D) {
/* 159 */       m1Play();
/* 160 */     } else if (e == 1.2D) {
/* 161 */       m1Options();
/* 162 */     } else if (e == 1.3D) {
/* 163 */       m1Update();
/* 164 */     } else if (e == 1.4D) {
/* 165 */       m1Quit();
/*     */     } 
/* 168 */     if (e == 2.1D) {
/*     */       try {
/* 170 */         m2PlayProfile();
/* 171 */       } catch (IOException ei) {
/* 172 */         ei.printStackTrace();
/*     */       } 
/* 174 */     } else if (e == 2.2D) {
/* 175 */       menuState = 3;
/* 176 */     } else if (e == 2.3D) {
/* 177 */       m2Back();
/*     */     } 
/* 180 */     if (e == 3.1D) {
/* 181 */       m3Yes();
/* 182 */     } else if (e == 3.2D) {
/* 183 */       m3No();
/*     */     } 
/* 186 */     if (e == 4.1D) {
/* 187 */       m4AutoSave();
/* 188 */     } else if (e == 4.2D) {
/* 189 */       m4AddOns();
/* 190 */     } else if (e == 4.3D) {
/* 191 */       m4TestDummy();
/* 192 */     } else if (e == 4.4D) {
/* 193 */       m4Reload();
/* 194 */     } else if (e == 4.5D) {
/* 195 */       m4About();
/*     */     } 
/* 198 */     if (e == 5.1D) {
/*     */       try {
/* 200 */         if (currentProfile == 1) {
/* 201 */           m5CreateProfile(Save.save1, Game.save1Path);
/* 202 */         } else if (currentProfile == 2) {
/* 203 */           m5CreateProfile(Save.save2, Game.save2Path);
/* 204 */         } else if (currentProfile == 3) {
/* 205 */           m5CreateProfile(Save.save3, Game.save3Path);
/*     */         } 
/* 207 */       } catch (IOException ei) {
/* 208 */         ei.printStackTrace();
/*     */       } 
/* 210 */     } else if (e == 5.2D) {
/* 211 */       Game.endClick();
/* 212 */       menuState = 2;
/* 213 */       currentProfile = 0;
/*     */     } 
/* 216 */     if (e == 6.1D) {
/* 217 */       Player.respawn();
/* 218 */     } else if (e == 6.2D) {
/* 219 */       Player.health = Player.maxHealth;
/*     */       try {
/* 221 */         if (currentProfile == 1)
/* 222 */           Save.profileSave(Save.save1, Game.save1Path, 1); 
/* 223 */         if (currentProfile == 2)
/* 224 */           Save.profileSave(Save.save2, Game.save2Path, 2); 
/* 225 */         if (currentProfile == 3)
/* 226 */           Save.profileSave(Save.save3, Game.save3Path, 3); 
/* 227 */         Save.dataSave();
/* 228 */       } catch (IOException e1) {
/* 229 */         e1.printStackTrace();
/*     */       } 
/* 231 */       Game.endClick();
/* 232 */       menuState = 1;
/* 233 */       currentProfile = 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void drawProfile(Graphics g, byte state, int x, int y, String lastPlayed, String created, File file, int profileNumber, String name, FontMetrics fm) {
/* 240 */     g.drawImage(ImageManager.profileSquare, x, y, 
/* 241 */         ImageManager.profileSquare.getWidth(), 
/* 242 */         ImageManager.profileSquare.getHeight(), null);
/* 243 */     g.setColor(Game.gameProgressColor);
/* 244 */     g.setFont(Game.gameProgressFont);
/* 245 */     if (file.exists()) {
/* 246 */       g.drawImage(ImageManager.playerd1, 
/* 247 */           ImageManager.profileSquare.getWidth() / 2 + x - 
/* 248 */           ImageManager.playerd1.getWidth(), 
/* 249 */           y + ImageManager.profileSquare.getHeight() / 2 - 
/* 250 */           ImageManager.playerd1.getHeight(), 64, 64, null);
/* 251 */     } else if (!file.exists()) {
/* 252 */       g.drawString("?", ImageManager.profileSquare.getWidth() / 2 + x - 
/* 253 */           fm.stringWidth("?") / 2, profileNumber * 110);
/*     */     } 
/* 255 */     if (currentProfile == profileNumber) {
/* 256 */       g.setColor(Color.white);
/*     */     } else {
/* 258 */       g.setColor(Game.profileInfoColor);
/*     */     } 
/* 260 */     g.setFont(Game.profileNameFont);
/* 261 */     g.drawString(name, 380, profileNumber * 110 - 40);
/* 262 */     g.setFont(Game.profileInfoFont);
/* 263 */     g.drawString("Last Played: " + lastPlayed, 380, 
/* 264 */         profileNumber * 110 - 40 + 33);
/* 265 */     g.drawString("Date Created: " + created, 380, 
/* 266 */         profileNumber * 110 - 40 + 66);
/*     */   }
/*     */   
/*     */   private void draw3WayTextBox(Graphics g, byte state, int x, int y, int w, int h, String t1, String t2, String t3, String info, int optionalParam) {
/* 274 */     this.fm = g.getFontMetrics(Game.buttonTextFont);
/* 276 */     g.setColor(Game.profileInfoColor);
/* 277 */     g.setFont(Game.profileInfoFont);
/* 279 */     g.drawString(info, x, y - 9);
/* 281 */     g.setColor(new Color(232, 232, 232));
/* 282 */     g.drawRect(x + 1, y + 1, w - 2, h - 2);
/* 283 */     g.drawRect(x, y, w, h);
/* 285 */     g.setColor(new Color(0, 0, 0, 180));
/* 286 */     g.fillRect(x + 2, y + 2, w - 3, h - 3);
/* 288 */     g.setFont(Game.buttonTextFont);
/* 289 */     g.setColor(Color.white);
/* 290 */     if (optionalParam == 1) {
/* 291 */       g.drawString(t1, x + 8, y + 24);
/* 292 */       if (state == 2)
/* 293 */         g.drawString("_", x + 8 + this.fm.stringWidth(t1), y + 24); 
/* 295 */     } else if (optionalParam == 2) {
/* 296 */       g.drawString(t2, x + 8, y + 24);
/* 297 */       if (state == 2)
/* 298 */         g.drawString("_", x + 8 + this.fm.stringWidth(t2), y + 24); 
/* 300 */     } else if (optionalParam == 3) {
/* 301 */       g.drawString(t3, x + 8, y + 24);
/* 302 */       if (state == 2)
/* 303 */         g.drawString("_", x + 8 + this.fm.stringWidth(t3), y + 24); 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void drawTextBox(Graphics g, byte state, int x, int y, int w, int h, String t, String info) {
/* 312 */     g.setColor(Game.profileInfoColor);
/* 313 */     g.setFont(Game.profileInfoFont);
/* 316 */     g.drawString(info, x, y - 9);
/* 319 */     g.setColor(new Color(232, 232, 232));
/* 320 */     g.drawRect(x + 1, y + 1, w - 2, h - 2);
/* 321 */     g.drawRect(x, y, w, h);
/* 324 */     g.setColor(new Color(0, 0, 0, 180));
/* 325 */     g.fillRect(x + 2, y + 2, w - 3, h - 3);
/* 328 */     g.setFont(Game.buttonTextFont);
/* 329 */     g.setColor(Color.white);
/* 332 */     g.drawString(t, x + 8, y + 24);
/* 333 */     if (state == 2)
/* 334 */       g.drawString("_", x + 8 + this.fm.stringWidth(t), y + 24); 
/*     */   }
/*     */   
/*     */   private static void drawCloud(Graphics g, int number, BufferedImage image) {
/* 339 */     if (number == 1) {
/* 340 */       g.drawImage(image, (int)cloud1x, (int)cloud1y, image.getWidth(), 
/* 341 */           image.getHeight(), null);
/* 342 */     } else if (number == 2) {
/* 343 */       g.drawImage(image, (int)cloud2x, (int)cloud2y, image.getWidth(), 
/* 344 */           image.getHeight(), null);
/* 345 */     } else if (number == 3) {
/* 346 */       g.drawImage(image, (int)cloud3x, (int)cloud3y, image.getWidth(), 
/* 347 */           image.getHeight(), null);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void setCurrentProfile(int i) {
/* 352 */     if (i == 1) {
/* 353 */       save1State = 3;
/* 354 */       save2State = 0;
/* 355 */       save3State = 0;
/* 356 */     } else if (i == 2) {
/* 357 */       save1State = 0;
/* 358 */       save2State = 3;
/* 359 */       save3State = 0;
/* 360 */     } else if (i == 3) {
/* 361 */       save1State = 0;
/* 362 */       save2State = 0;
/* 363 */       save3State = 3;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void moveClouds() {
/* 369 */     if (cloud1x > -150.0D) {
/* 370 */       cloud1x -= cloudSpeed + 0.1D;
/*     */     } else {
/* 372 */       cloud1x = 850.0D;
/* 373 */       cloud1y = 200.0D;
/*     */     } 
/* 377 */     if (cloud2x > -125.0D) {
/* 378 */       cloud2x -= cloudSpeed;
/*     */     } else {
/* 380 */       cloud2x = 990.0D;
/* 381 */       cloud2y = 22.0D;
/*     */     } 
/* 385 */     if (cloud3x <= 828.0D) {
/* 386 */       cloud3x += cloudSpeed;
/*     */     } else {
/* 388 */       cloud3x = -150.0D;
/* 389 */       cloud3y = 365.0D;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void enterGame() {
/* 394 */     Game.isInGame = true;
/* 395 */     menuState = 0;
/* 396 */     KeyManager.enterPressed = false;
/* 397 */     Player.up = false;
/* 398 */     Player.down = false;
/* 399 */     Player.left = false;
/* 400 */     Player.right = false;
/* 401 */     Player.colorCheck();
/*     */   }
/*     */   
/*     */   public void tick() {
/* 408 */     if (menuState == 2)
/* 409 */       profileTick(); 
/* 412 */     moveClouds();
/*     */   }
/*     */   
/*     */   private void profileTick() {
/* 419 */     if (!Save.save1.exists()) {
/* 420 */       save1Name = "Play To Create Me";
/* 421 */     } else if (Save.save1.exists()) {
/* 422 */       save1Name = save1Name_backup;
/*     */     } 
/* 425 */     if (!Save.save2.exists()) {
/* 426 */       save2Name = "Play To Create Me";
/* 427 */     } else if (Save.save2.exists()) {
/* 428 */       save2Name = save2Name_backup;
/*     */     } 
/* 431 */     if (!Save.save3.exists()) {
/* 432 */       save3Name = "Play To Create Me";
/* 433 */     } else if (Save.save3.exists()) {
/* 434 */       save3Name = save3Name_backup;
/*     */     } 
/* 438 */     if (save1State == 3 || save2State == 3 || save3State == 3) {
/* 439 */       canPlayProfile = true;
/* 441 */     } else if (save1State == 0 && save2State == 0 && save3State == 0) {
/* 442 */       canPlayProfile = false;
/*     */     } 
/* 447 */     if (currentProfile == 0)
/* 448 */       canDeleteProfile = false; 
/* 451 */     if (currentProfile == 1 && !Save.save1.exists()) {
/* 452 */       canDeleteProfile = false;
/* 453 */     } else if (currentProfile == 1 && Save.save1.exists()) {
/* 454 */       canDeleteProfile = true;
/*     */     } 
/* 457 */     if (currentProfile == 2 && !Save.save2.exists()) {
/* 458 */       canDeleteProfile = false;
/* 459 */     } else if (currentProfile == 2 && Save.save2.exists()) {
/* 460 */       canDeleteProfile = true;
/*     */     } 
/* 463 */     if (currentProfile == 3 && !Save.save3.exists()) {
/* 464 */       canDeleteProfile = false;
/* 465 */     } else if (currentProfile == 3 && Save.save3.exists()) {
/* 466 */       canDeleteProfile = true;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void renderMain(Graphics g) {
/* 474 */     g.setColor(Game.skyColor);
/* 475 */     g.fillRect(0, 0, 838, 573);
/* 478 */     drawCloud(g, 1, ImageManager.cloud1);
/* 479 */     drawCloud(g, 2, ImageManager.cloud2);
/* 480 */     drawCloud(g, 3, ImageManager.cloud3);
/* 482 */     if (menuState == 1) {
/* 483 */       renderState1(g);
/* 484 */     } else if (menuState == 2) {
/* 485 */       renderState2(g);
/* 486 */     } else if (menuState == 3) {
/* 487 */       renderState3(g);
/* 488 */     } else if (menuState == 4) {
/* 489 */       renderState4(g);
/* 490 */     } else if (menuState == 5) {
/* 491 */       renderState5(g);
/* 492 */     } else if (menuState == 6) {
/* 493 */       renderState6(g);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void renderState1(Graphics g) {
/* 504 */     this.fm = g.getFontMetrics(Game.profileInfoFont);
/* 505 */     this.fm2 = g.getFontMetrics(Game.buttonTextFont);
/* 508 */     g.drawImage(Game.logoImage, 419 - Game.logoImage.getWidth(), 
/* 509 */         20, Game.logoImage.getWidth() * 2, 
/* 510 */         Game.logoImage.getHeight() * 2, null);
/* 513 */     g.setFont(Game.profileInfoFont);
/* 514 */     g.setColor(Game.profileInfoColor);
/* 515 */     g.drawString(Game.identifer, 
/* 516 */         419 - this.fm.stringWidth(Game.identifer) / 2, 415);
/* 519 */     g.setFont(Game.buttonTextFont);
/* 520 */     g.setColor(Color.white);
/* 521 */     g.drawString(Game.title, 5, 535);
/* 522 */     g.drawString(Game.copyright, 
/* 523 */         838 - this.fm2.stringWidth(Game.copyright) + 10, 535);
/* 526 */     drawButton(g, 251, 254, 336, 32, "Play", 
/* 527 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 528 */         ImageManager.button2_3, 1.1D);
/* 531 */     drawButton(g, 251, 302, 
/* 532 */         ImageManager.button2_1.getWidth(), 
/* 533 */         ImageManager.button2_1.getHeight(), "Options", 
/* 534 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 535 */         ImageManager.button2_3, 1.2D);
/* 538 */     drawButton(g, 419 - ImageManager.button1_1.getWidth() + 8, 
/* 539 */         350, ImageManager.button1_1.getWidth(), 
/* 540 */         ImageManager.button1_1.getHeight(), "Update...", 
/* 541 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 542 */         ImageManager.button1_3, 1.3D);
/* 545 */     drawButton(g, 427, 350, 
/* 546 */         ImageManager.button1_1.getWidth(), 
/* 547 */         ImageManager.button1_1.getHeight(), "Quit Game", 
/* 548 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 549 */         ImageManager.button1_3, 1.4D);
/*     */   }
/*     */   
/*     */   private void renderState2(Graphics g) {
/* 557 */     this.fm = g.getFontMetrics(Game.gameProgressFont);
/* 559 */     g.setFont(Game.profileInfoFont);
/* 560 */     g.setColor(Game.profileInfoColor);
/* 564 */     if (save1State == 3) {
/* 565 */       g.drawImage(ImageManager.profileSelection, 268, 43, 300, 117, null);
/* 566 */       currentProfile = 1;
/* 567 */     } else if (save2State == 3) {
/* 568 */       g.drawImage(ImageManager.profileSelection, 268, 153, 300, 117, 
/* 569 */           null);
/* 570 */       currentProfile = 2;
/* 571 */     } else if (save3State == 3) {
/* 572 */       g.drawImage(ImageManager.profileSelection, 268, 263, 300, 117, 
/* 573 */           null);
/* 574 */       currentProfile = 3;
/*     */     } 
/* 579 */     drawProfile(g, save1State, 275, 50, Save.save1LastPlayed, 
/* 580 */         Save.save1Made, Save.save1, 1, save1Name, this.fm);
/* 582 */     drawProfile(g, save2State, 275, 160, Save.save2LastPlayed, 
/* 583 */         Save.save2Made, Save.save2, 2, save2Name, this.fm);
/* 585 */     drawProfile(g, save3State, 275, 270, Save.save3LastPlayed, 
/* 586 */         Save.save3Made, Save.save3, 3, save3Name, this.fm);
/* 590 */     if (canPlayProfile) {
/* 591 */       drawButton(g, 419 - ImageManager.button2_1.getWidth() / 2, 
/* 592 */           425, ImageManager.button2_1.getWidth(), 
/* 593 */           ImageManager.button2_1.getHeight(), 
/* 594 */           "Play Selected Profile", ImageManager.button2_1, 
/* 595 */           ImageManager.button2_2, ImageManager.button2_3, 2.1D);
/* 596 */     } else if (!canPlayProfile) {
/* 597 */       g.setFont(Game.buttonTextFont);
/* 598 */       g.drawImage(ImageManager.button2_3, 419 - 
/* 599 */           ImageManager.button2_3.getWidth() / 2, 425, 
/* 600 */           ImageManager.button2_3.getWidth(), 
/* 601 */           ImageManager.button2_3.getHeight(), null);
/* 602 */       g.setColor(Game.buttonClickedColor);
/* 603 */       g.drawString("Play Selected Profile", 324, 446);
/*     */     } 
/* 608 */     if (canDeleteProfile) {
/* 609 */       drawButton(g, 419 - ImageManager.button2_1.getWidth() / 2, 
/* 610 */           473, ImageManager.button1_1.getWidth(), 
/* 611 */           ImageManager.button1_1.getHeight(), "Delete", 
/* 612 */           ImageManager.button1_1, ImageManager.button1_2, 
/* 613 */           ImageManager.button1_3, 2.2D);
/* 614 */     } else if (!canDeleteProfile) {
/* 615 */       g.setFont(Game.buttonTextFont);
/* 616 */       g.drawImage(ImageManager.button1_3, 419 - 
/* 617 */           ImageManager.button2_1.getWidth() / 2, 473, 
/* 618 */           ImageManager.button1_3.getWidth(), 
/* 619 */           ImageManager.button1_3.getHeight(), null);
/* 620 */       g.setColor(Game.buttonClickedColor);
/* 621 */       g.drawString(
/* 622 */           "Delete", 
/* 623 */           300, 
/* 624 */           473 + ImageManager.button1_3.getHeight() / 2 + 5);
/*     */     } 
/* 629 */     drawButton(g, 419 - ImageManager.button2_1.getWidth() / 2 + 
/* 630 */         176, 473, ImageManager.button1_1.getWidth(), 
/* 631 */         ImageManager.button1_1.getHeight(), "Back", 
/* 632 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 633 */         ImageManager.button1_3, 2.3D);
/*     */   }
/*     */   
/*     */   private void renderState3(Graphics g) {
/* 641 */     g.setFont(Game.areYouSureFont);
/* 642 */     g.setColor(Game.profileInfoColor);
/* 643 */     g.drawString("Are you sure?", 280, 190);
/* 645 */     g.setFont(Game.buttonTextFont);
/* 647 */     drawButton(g, 215, 325, ImageManager.button1_1.getWidth(), 
/* 648 */         ImageManager.button1_1.getHeight(), "Yes", 
/* 649 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 650 */         ImageManager.button1_3, 3.1D);
/* 652 */     drawButton(g, 454, 325, ImageManager.button1_1.getWidth(), 
/* 653 */         ImageManager.button1_1.getHeight(), "No", 
/* 654 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 655 */         ImageManager.button1_3, 3.2D);
/*     */   }
/*     */   
/*     */   private void renderState4(Graphics g) {
/* 663 */     this.fm = g.getFontMetrics(Game.profileInfoFont);
/* 666 */     drawButton(g, 419 - ImageManager.button2_1.getWidth() + 8, 
/* 667 */         100, ImageManager.button2_1.getWidth(), 
/* 668 */         ImageManager.button2_1.getHeight(), "Auto Save: " + 
/* 669 */         autoSaveToggle, ImageManager.button2_1, 
/* 670 */         ImageManager.button2_2, ImageManager.button2_3, 4.1D);
/* 671 */     g.setColor(Game.profileInfoColor);
/* 672 */     g.setFont(Game.profileInfoFont);
/* 675 */     drawButton(g, 427, 100, ImageManager.button2_1.getWidth(), 
/* 676 */         ImageManager.button2_1.getHeight(), "Test Dummy: " + tdToggle, 
/* 677 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 678 */         ImageManager.button2_3, 4.3D);
/* 681 */     drawButton(g, 419 - ImageManager.button2_1.getWidth() + 8, 
/* 682 */         148, ImageManager.button2_1.getWidth(), 
/* 683 */         ImageManager.button2_1.getHeight(), "Reload Graphics", 
/* 684 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 685 */         ImageManager.button2_3, 4.4D);
/* 688 */     drawButton(g, 419 - ImageManager.button1_1.getWidth() / 2, 
/* 689 */         498, ImageManager.button1_1.getWidth(), 
/* 690 */         ImageManager.button1_1.getHeight(), "About", 
/* 691 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 692 */         ImageManager.button1_3, 4.5D);
/* 695 */     drawButton(g, 419 - 
/* 696 */         ImageManager.button2_1.getWidth() / 2 + 88, 498, 
/* 697 */         ImageManager.button1_1.getWidth(), 
/* 698 */         ImageManager.button1_1.getHeight(), "Add-Ons...", 
/* 699 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 700 */         ImageManager.button1_3, 4.2D);
/* 703 */     drawButton(g, 419 - ImageManager.button2_1.getWidth() / 2 + 
/* 704 */         176 + 88, 498, ImageManager.button1_1.getWidth(), 
/* 705 */         ImageManager.button1_1.getHeight(), "Back", 
/* 706 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 707 */         ImageManager.button1_3, 2.3D);
/*     */   }
/*     */   
/*     */   private void renderState5(Graphics g) {
/* 715 */     profileNameBoxState = getGeneralImageState(419 - 
/* 716 */         ImageManager.button2_1.getWidth() / 2 - 1, 89, 
/* 717 */         ImageManager.button2_1.getWidth() + 2, 
/* 718 */         ImageManager.button2_1.getHeight() + 2, profileNameBoxState, 
/* 719 */         profileNameBoxInFocus);
/* 721 */     playerNameBoxState = getGeneralImageState(419 - 
/* 722 */         ImageManager.button2_1.getWidth() / 2 - 1, 172, 
/* 723 */         ImageManager.button2_1.getWidth() + 2, 
/* 724 */         ImageManager.button2_1.getHeight() + 2, playerNameBoxState, 
/* 725 */         playerNameBoxInFocus);
/* 728 */     draw3WayTextBox(g, profileNameBoxState, 419 - 
/* 729 */         ImageManager.button2_1.getWidth() / 2 - 1, 89, 
/* 730 */         ImageManager.button2_1.getWidth() + 2, 
/* 731 */         ImageManager.button2_1.getHeight() + 2, save1Name, save2Name, 
/* 732 */         save3Name, "Profile Name: ", currentProfile);
/* 734 */     drawTextBox(g, playerNameBoxState, 419 - 
/* 735 */         ImageManager.button2_1.getWidth() / 2 - 1, 172, 
/* 736 */         ImageManager.button2_1.getWidth() + 2, 
/* 737 */         ImageManager.button2_1.getHeight() + 2, Player.typedName, 
/* 738 */         "Character's Name (Cannot change after this!)");
/* 741 */     drawButton(g, 419 - ImageManager.button2_1.getWidth() / 2, 
/* 742 */         437, ImageManager.button1_1.getWidth(), 
/* 743 */         ImageManager.button1_1.getHeight(), "Create Profile", 
/* 744 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 745 */         ImageManager.button1_3, 5.1D);
/* 748 */     drawButton(
/* 749 */         g, 
/* 750 */         419 - 
/* 751 */         ImageManager.button2_1.getWidth() / 2 - ImageManager.button1_1
/* 752 */         .getWidth() + 16, 437, 
/* 753 */         ImageManager.button1_1.getWidth(), 
/* 754 */         ImageManager.button1_1.getHeight(), "Back", 
/* 755 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 756 */         ImageManager.button1_3, 5.2D);
/*     */   }
/*     */   
/*     */   private void renderState6(Graphics g) {
/* 764 */     g.setFont(Game.buttonTextFont);
/* 765 */     g.setColor(Game.profileInfoColor);
/* 767 */     this.fm = g.getFontMetrics(Game.buttonTextFont);
/* 769 */     g.drawString("You were killed!", 
/* 770 */         419 - this.fm.stringWidth("You were killed!") / 2, 200);
/* 772 */     drawButton(g, 419 - ImageManager.button2_1.getWidth() / 2, 
/* 773 */         275, ImageManager.button2_1.getWidth(), 
/* 774 */         ImageManager.button2_1.getHeight(), "Respawn", 
/* 775 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 776 */         ImageManager.button2_3, 6.1D);
/* 778 */     drawButton(g, 419 - 
/* 779 */         ImageManager.button2_1.getWidth() / 2, 323, ImageManager.button2_1.getWidth(), 
/* 780 */         ImageManager.button2_1.getHeight(), 
/* 781 */         "Save and Quit to Title", ImageManager.button2_1, ImageManager.button2_2, 
/* 782 */         ImageManager.button2_3, 6.2D);
/*     */   }
/*     */   
/*     */   private void m1Play() {
/* 789 */     Game.endClick();
/* 790 */     menuState = 2;
/* 791 */     Load.loadData1(Game.dataPath);
/*     */   }
/*     */   
/*     */   private void m1Options() {
/* 795 */     menuState = 4;
/* 796 */     Load.loadData1(Game.dataPath);
/* 798 */     if (autoSaveToggle == "On" && !Game.autoSave) {
/* 799 */       autoSaveToggle = "Off";
/* 800 */     } else if (autoSaveToggle == "Off" && Game.autoSave) {
/* 801 */       autoSaveToggle = "On";
/*     */     } 
/* 805 */     if (tdToggle == "On" && !Game.dummy) {
/* 806 */       tdToggle = "Off";
/* 807 */     } else if (tdToggle == "Off" && Game.dummy) {
/* 808 */       tdToggle = "On";
/*     */     } 
/*     */   }
/*     */   
/*     */   private void m1Update() {
/* 813 */     Game.endClick();
/* 814 */     this.u.createWindow();
/*     */   }
/*     */   
/*     */   private void m1Quit() {
/* 818 */     System.exit(0);
/*     */   }
/*     */   
/*     */   public static void m2PlayProfile() throws IOException {
/* 823 */     if (currentProfile == 1) {
/* 824 */       if (Save.save1.exists()) {
/* 825 */         Load.loadProfile(Game.save1Path);
/* 826 */         Save.profileSave(Save.save1, Game.save1Path, 1);
/* 827 */         enterGame();
/* 828 */       } else if (!Save.save1.exists()) {
/* 829 */         save1Name = "";
/* 830 */         Player.typedName = "";
/* 831 */         cancelState = 0;
/* 832 */         menuState = 5;
/*     */       } 
/* 834 */     } else if (currentProfile == 2) {
/* 835 */       if (Save.save2.exists()) {
/* 836 */         Load.loadProfile(Game.save2Path);
/* 837 */         Save.profileSave(Save.save2, Game.save2Path, 2);
/* 838 */         enterGame();
/* 839 */       } else if (!Save.save2.exists()) {
/* 840 */         save2Name = "";
/* 841 */         Player.typedName = "";
/* 842 */         cancelState = 0;
/* 843 */         menuState = 5;
/*     */       } 
/* 845 */     } else if (currentProfile == 3) {
/* 846 */       if (Save.save3.exists()) {
/* 847 */         Load.loadProfile(Game.save3Path);
/* 848 */         Save.profileSave(Save.save3, Game.save3Path, 3);
/* 849 */         enterGame();
/* 850 */       } else if (!Save.save3.exists()) {
/* 851 */         save3Name = "";
/* 852 */         Player.typedName = "";
/* 853 */         cancelState = 0;
/* 854 */         menuState = 5;
/*     */       } 
/*     */     } 
/* 857 */     Game.endClick();
/* 858 */     TestDummy.reset();
/* 859 */     save1State = 0;
/* 860 */     save2State = 0;
/* 861 */     save3State = 0;
/*     */   }
/*     */   
/*     */   private void m2DeleteProfile() throws IOException {
/* 867 */     if (currentProfile == 1) {
/* 868 */       Save.save1.delete();
/* 869 */       Save.save1Made = "";
/* 870 */       Save.save1LastPlayed = "";
/* 871 */       Save.dataSave();
/* 872 */     } else if (currentProfile == 2) {
/* 873 */       Save.save2.delete();
/* 874 */       Save.save2Made = "";
/* 875 */       Save.save2LastPlayed = "";
/* 876 */       Save.dataSave();
/* 877 */     } else if (currentProfile == 3) {
/* 878 */       Save.save3.delete();
/* 879 */       Save.save3Made = " ";
/* 880 */       Save.save3LastPlayed = " ";
/* 881 */       Save.dataSave();
/*     */     } 
/* 884 */     menuState = 2;
/* 885 */     currentProfile = 0;
/*     */   }
/*     */   
/*     */   private void m2Back() {
/* 890 */     save1State = 0;
/* 891 */     save2State = 0;
/* 892 */     save3State = 0;
/* 893 */     currentProfile = 0;
/* 894 */     menuState = 1;
/*     */   }
/*     */   
/*     */   private void m3Yes() {
/*     */     try {
/* 900 */       m2DeleteProfile();
/* 901 */     } catch (IOException e) {
/* 902 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void m3No() {
/* 908 */     menuState = 2;
/*     */   }
/*     */   
/*     */   private void m4AutoSave() {
/* 912 */     if (autoSaveToggle == "On") {
/* 913 */       autoSaveToggle = "Off";
/* 914 */       Game.autoSave = false;
/* 915 */     } else if (autoSaveToggle == "Off") {
/* 916 */       autoSaveToggle = "On";
/* 917 */       Game.autoSave = true;
/*     */     } 
/* 919 */     Game.endClick();
/*     */     try {
/* 921 */       Save.dataSave();
/* 922 */     } catch (IOException e) {
/* 923 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void m4TestDummy() {
/* 928 */     if (tdToggle == "On") {
/* 929 */       tdToggle = "Off";
/* 930 */       Game.dummy = false;
/* 931 */     } else if (tdToggle == "Off") {
/* 932 */       tdToggle = "On";
/* 933 */       Game.dummy = true;
/*     */     } 
/* 935 */     Game.endClick();
/*     */     try {
/* 937 */       Save.dataSave();
/* 938 */     } catch (IOException e) {
/* 939 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void m4AddOns() {
/* 944 */     this.a.createWindow();
/* 945 */     Game.endClick();
/*     */   }
/*     */   
/*     */   private void m4Reload() {
/* 949 */     Game.loadGfx();
/*     */   }
/*     */   
/*     */   private void m4About() {
/* 953 */     this.ab.createWindow();
/* 954 */     Game.endClick();
/*     */   }
/*     */   
/*     */   private void m5CreateProfile(File save, String path) throws IOException {
/* 958 */     Save.reset();
/* 959 */     if (currentProfile == 1 && save1Name.length() == 0) {
/* 960 */       save1Name = "Profile 1";
/* 961 */       save1Name_backup = save1Name;
/* 962 */     } else if (currentProfile == 2 && save2Name.length() == 0) {
/* 963 */       save2Name = "Profile 2";
/* 964 */       save2Name_backup = save2Name;
/* 965 */     } else if (currentProfile == 3 && save3Name.length() == 0) {
/* 966 */       save3Name = "Profile 3";
/* 967 */       save3Name_backup = save3Name;
/*     */     } 
/* 969 */     if (Player.typedName.length() == 0) {
/* 970 */       Player.name = Player.defaultName;
/* 971 */     } else if (Player.typedName.length() >= 1) {
/* 972 */       Player.name = Player.typedName;
/*     */     } 
/* 974 */     Save.profileSave(save, path, currentProfile);
/* 975 */     Save.dataSave();
/* 976 */     Load.loadProfile(path);
/* 977 */     enterGame();
/* 978 */     StoryText.request("Our story begins within a town called " + 
/* 979 */         Game.townName, 
/* 980 */         "For centuries, each generation has lived in peace, but", 
/* 981 */         "today, something will happen, something big.", 
/* 982 */         "It will distrub the natural balance of " + Game.townName + 
/* 983 */         " and its people.", "", 
/* 984 */         "One the first day, there was darkness.", "");
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_6.jar!\beyondOrigins\main\menus\MainMenu.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */