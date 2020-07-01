/*     */ package beyondOrigins.main.menus;
/*     */ 
/*     */ import beyondOrigins.files.Load;
/*     */ import beyondOrigins.files.Save;
/*     */ import beyondOrigins.main.Game;
/*     */ import beyondOrigins.main.entities.Player;
/*     */ import beyondOrigins.main.gfx.ImageManager;
/*     */ import beyondOrigins.threads.StoryText;
/*     */ import beyondOrigins.userInput.KeyManager;
/*     */ import beyondOrigins.userInput.MouseManager;
/*     */ import beyondOrigins.userInput.MouseMotion;
/*     */ import java.awt.Color;
/*     */ import java.awt.FontMetrics;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ 
/*     */ public class MainMenu {
/*     */   private FontMetrics fm;
/*     */   
/*  26 */   public static volatile int menuState = 1;
/*     */   
/*     */   private ImageManager im;
/*     */   
/*     */   private ImageManager im2;
/*     */   
/*  30 */   public static double cloud1x = 850.0D;
/*     */   
/*  31 */   public static double cloud1y = 200.0D;
/*     */   
/*  32 */   public static double cloud2x = 990.0D;
/*     */   
/*  33 */   public static double cloud2y = 22.0D;
/*     */   
/*  34 */   public static double cloud3x = -150.0D;
/*     */   
/*  35 */   public static double cloud3y = 365.0D;
/*     */   
/*  36 */   private static double cloudSpeed = 0.5D;
/*     */   
/*     */   public static int playState;
/*     */   
/*     */   private static int optionsState;
/*     */   
/*  43 */   public static int currentProfile = 0;
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
/*  48 */   public static String save1Name = "IfYouSeeThisSomethingIsWrong";
/*     */   
/*  49 */   public static String save2Name = "IfYouSeeThisSomethingIsWrong";
/*     */   
/*  50 */   public static String save3Name = "IfYouSeeThisSomethingIsWrong";
/*     */   
/*     */   public static String save1Name_backup;
/*     */   
/*     */   public static String save2Name_backup;
/*     */   
/*     */   public static String save3Name_backup;
/*     */   
/*     */   public static boolean enterProfile = false;
/*     */   
/*     */   public static int yesState;
/*     */   
/*     */   public static int noState;
/*     */   
/*     */   private static int autoSaveState;
/*     */   
/*     */   private static int addOnsState;
/*     */   
/*     */   private static int tdState;
/*     */   
/*  59 */   public static String autoSaveToggle = "On";
/*     */   
/*  59 */   public static String tdToggle = "Off";
/*     */   
/*     */   private static int createProfileState;
/*     */   
/*     */   public static int profileNameBoxState;
/*     */   
/*     */   public static int playerNameBoxState;
/*     */   
/*     */   public static boolean profileNameBoxInFocus = false;
/*     */   
/*     */   public static boolean playerNameBoxInFocus = false;
/*     */   
/*     */   public MainMenu(ImageManager im, ImageManager im2) {
/*  70 */     this.im = im;
/*  71 */     this.im2 = im2;
/*     */   }
/*     */   
/*     */   public static void init() {}
/*     */   
/*     */   public int getButtonState(int x, int y, int width, int height, int state) {
/*  86 */     if (MouseMotion.mouseX >= x && MouseMotion.mouseX < x + width && 
/*  87 */       MouseMotion.mouseY >= y && MouseMotion.mouseY < y + height) {
/*  88 */       state = 2;
/*  89 */       if (MouseManager.mouseFullClick == 1) {
/*  90 */         state = 3;
/*     */       } else {
/*  92 */         state = 2;
/*     */       } 
/*     */     } else {
/*  94 */       state = 1;
/*     */     } 
/*  95 */     return state;
/*     */   }
/*     */   
/*     */   public int getGeneralImageState(int x, int y, int width, int height, int state, boolean inFocus) {
/* 102 */     if (MouseMotion.mouseX >= x && 
/* 103 */       MouseMotion.mouseX < x + width && MouseMotion.mouseY >= y && 
/* 104 */       MouseMotion.mouseY < y + height) {
/* 105 */       if (!inFocus && MouseManager.mouseFullClick == 1) {
/* 106 */         state = 2;
/* 107 */         inFocus = true;
/* 108 */       } else if (inFocus) {
/* 109 */         state = 2;
/*     */       } 
/* 112 */     } else if (inFocus) {
/* 113 */       state = 2;
/* 115 */     } else if (MouseManager.mouseFullClick == 1) {
/* 116 */       state = 1;
/* 117 */       inFocus = false;
/*     */     } 
/* 122 */     return state;
/*     */   }
/*     */   
/*     */   public void drawButton(Graphics g, int state, int x, int y, int width, int height, String buttonText, BufferedImage state1Image, BufferedImage state2Image, BufferedImage state3Image, double clickEventType) {
/* 129 */     this.fm = g.getFontMetrics(Game.buttonTextFont);
/* 130 */     g.setFont(Game.buttonTextFont);
/* 131 */     if (getButtonState(x, y, width, height, state) == 1) {
/* 132 */       g.drawImage(state1Image, x, y, width, height, null);
/* 133 */       g.setColor(Game.buttonIdleColor);
/* 134 */       g.drawString(
/* 135 */           buttonText, 
/* 136 */           x + state1Image.getWidth() / 2 - 
/* 137 */           this.fm.stringWidth(buttonText) / 2, y + 
/* 138 */           state1Image.getHeight() / 2 + 5);
/* 139 */     } else if (getButtonState(x, y, width, height, state) == 2) {
/* 140 */       g.drawImage(state2Image, x, y, width, height, null);
/* 141 */       g.setColor(Game.buttonSelectedColor);
/* 142 */       g.drawString(
/* 143 */           buttonText, 
/* 144 */           x + state1Image.getWidth() / 2 - 
/* 145 */           this.fm.stringWidth(buttonText) / 2, y + 
/* 146 */           state1Image.getHeight() / 2 + 5);
/* 147 */     } else if (getButtonState(x, y, width, height, state) == 3) {
/* 148 */       g.drawImage(state3Image, x, y, width, height, null);
/* 149 */       g.setColor(Game.buttonClickedColor);
/* 150 */       g.drawString(
/* 151 */           buttonText, 
/* 152 */           x + state1Image.getWidth() / 2 - 
/* 153 */           this.fm.stringWidth(buttonText) / 2, y + 
/* 154 */           state1Image.getHeight() / 2 + 5);
/* 156 */       if (clickEventType == 1.1D) {
/* 157 */         menuStateIs1_play();
/* 158 */       } else if (clickEventType == 1.2D) {
/* 159 */         menuStateIs1_options();
/*     */       } 
/* 162 */       if (clickEventType == 2.1D) {
/*     */         try {
/* 164 */           menuStateIs2_playProfile();
/* 165 */         } catch (IOException e) {
/* 166 */           e.printStackTrace();
/*     */         } 
/* 168 */       } else if (clickEventType == 2.2D) {
/* 169 */         menuState = 3;
/* 170 */       } else if (clickEventType == 2.3D) {
/* 171 */         menuStateIs2_back();
/*     */       } 
/* 174 */       if (clickEventType == 3.1D) {
/* 175 */         menuStateIs3_yes();
/* 176 */       } else if (clickEventType == 3.2D) {
/* 177 */         menuStateIs3_no();
/*     */       } 
/* 180 */       if (clickEventType == 4.1D) {
/* 181 */         menuStateIs4_autoSave();
/* 182 */       } else if (clickEventType == 4.2D) {
/* 183 */         menuStateIs4_addOns();
/* 184 */       } else if (clickEventType == 4.3D) {
/* 185 */         menuStateIs4_testDummy();
/*     */       } 
/* 188 */       if (clickEventType == 5.1D) {
/*     */         try {
/* 190 */           if (currentProfile == 1) {
/* 191 */             menuStateIs5_createProfile(Save.save1, Game.save1Path);
/* 192 */           } else if (currentProfile == 2) {
/* 193 */             menuStateIs5_createProfile(Save.save2, Game.save2Path);
/* 194 */           } else if (currentProfile == 3) {
/* 195 */             menuStateIs5_createProfile(Save.save3, Game.save3Path);
/*     */           } 
/* 197 */         } catch (IOException e) {
/* 198 */           e.printStackTrace();
/*     */         } 
/* 200 */       } else if (clickEventType == 5.2D) {
/* 201 */         MouseManager.mouseFullClick = 0;
/* 202 */         menuState = 2;
/* 203 */         currentProfile = 0;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void drawProfile(Graphics g, int state, int x, int y, String lastPlayed, String created, File file, int profileNumber, String name, FontMetrics fm) {
/* 211 */     g.drawImage(this.im.profileSquare, x, y, this.im.profileSquare.getWidth(), 
/* 212 */         this.im.profileSquare.getHeight(), null);
/* 213 */     g.setColor(Game.gameProgressColor);
/* 214 */     g.setFont(Game.gameProgressFont);
/* 215 */     if (file.exists()) {
/* 216 */       g.drawImage(
/* 217 */           this.im2.playerd1, 
/* 218 */           this.im.profileSquare.getWidth() / 2 + x - 
/* 219 */           this.im2.playerd1.getWidth(), 
/* 220 */           y + this.im.profileSquare.getHeight() / 2 - 
/* 221 */           this.im2.playerd1.getHeight(), 64, 64, null);
/* 222 */     } else if (!file.exists()) {
/* 223 */       g.drawString(
/* 224 */           "?", 
/* 225 */           this.im.profileSquare.getWidth() / 2 + x - 
/* 226 */           fm.stringWidth("?") / 2, profileNumber * 110);
/*     */     } 
/* 228 */     if (currentProfile == profileNumber) {
/* 229 */       g.setColor(Color.white);
/*     */     } else {
/* 231 */       g.setColor(Game.profileInfoColor);
/*     */     } 
/* 233 */     g.setFont(Game.profileNameFont);
/* 234 */     g.drawString(name, 380, profileNumber * 110 - 40);
/* 235 */     g.setFont(Game.profileInfoFont);
/* 236 */     g.drawString("Last Played: " + lastPlayed, 380, 
/* 237 */         profileNumber * 110 - 40 + 33);
/* 238 */     g.drawString("Date Created: " + created, 380, 
/* 239 */         profileNumber * 110 - 40 + 66);
/*     */   }
/*     */   
/*     */   public void draw3WayTextBox(Graphics g, int state, int x, int y, int w, int h, String t1, String t2, String t3, String info, int optionalParam) {
/* 247 */     this.fm = g.getFontMetrics(Game.buttonTextFont);
/* 249 */     g.setColor(Game.profileInfoColor);
/* 250 */     g.setFont(Game.profileInfoFont);
/* 252 */     g.drawString(info, x, y - 9);
/* 254 */     g.setColor(new Color(232, 232, 232));
/* 255 */     g.drawRect(x + 1, y + 1, w - 2, h - 2);
/* 256 */     g.drawRect(x, y, w, h);
/* 258 */     g.setColor(new Color(0, 0, 0, 180));
/* 259 */     g.fillRect(x + 2, y + 2, w - 3, h - 3);
/* 261 */     g.setFont(Game.buttonTextFont);
/* 262 */     g.setColor(Color.white);
/* 263 */     if (optionalParam == 1) {
/* 264 */       g.drawString(t1, x + 8, y + 24);
/* 265 */       if (state == 2)
/* 266 */         g.drawString("_", x + 8 + this.fm.stringWidth(t1), y + 24); 
/* 268 */     } else if (optionalParam == 2) {
/* 269 */       g.drawString(t2, x + 8, y + 24);
/* 270 */       if (state == 2)
/* 271 */         g.drawString("_", x + 8 + this.fm.stringWidth(t2), y + 24); 
/* 273 */     } else if (optionalParam == 3) {
/* 274 */       g.drawString(t3, x + 8, y + 24);
/* 275 */       if (state == 2)
/* 276 */         g.drawString("_", x + 8 + this.fm.stringWidth(t3), y + 24); 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void drawTextBox(Graphics g, int state, int x, int y, int w, int h, String t, String info) {
/* 285 */     g.setColor(Game.profileInfoColor);
/* 286 */     g.setFont(Game.profileInfoFont);
/* 289 */     g.drawString(info, x, y - 9);
/* 292 */     g.setColor(new Color(232, 232, 232));
/* 293 */     g.drawRect(x + 1, y + 1, w - 2, h - 2);
/* 294 */     g.drawRect(x, y, w, h);
/* 297 */     g.setColor(new Color(0, 0, 0, 180));
/* 298 */     g.fillRect(x + 2, y + 2, w - 3, h - 3);
/* 301 */     g.setFont(Game.buttonTextFont);
/* 302 */     g.setColor(Color.white);
/* 305 */     g.drawString(t, x + 8, y + 24);
/* 306 */     if (state == 2)
/* 307 */       g.drawString("_", x + 8 + this.fm.stringWidth(t), y + 24); 
/*     */   }
/*     */   
/*     */   public static void drawCloud(Graphics g, int number, BufferedImage image) {
/* 312 */     if (number == 1) {
/* 313 */       g.drawImage(image, (int)cloud1x, (int)cloud1y, image.getWidth(), 
/* 314 */           image.getHeight(), null);
/* 315 */     } else if (number == 2) {
/* 316 */       g.drawImage(image, (int)cloud2x, (int)cloud2y, image.getWidth(), 
/* 317 */           image.getHeight(), null);
/* 318 */     } else if (number == 3) {
/* 319 */       g.drawImage(image, (int)cloud3x, (int)cloud3y, image.getWidth(), 
/* 320 */           image.getHeight(), null);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void getCloudX() {
/* 326 */     if (cloud1x > -150.0D) {
/* 327 */       cloud1x -= cloudSpeed + 0.1D;
/*     */     } else {
/* 329 */       cloud1x = 850.0D;
/* 330 */       cloud1y = 200.0D;
/*     */     } 
/* 334 */     if (cloud2x > -125.0D) {
/* 335 */       cloud2x -= cloudSpeed;
/*     */     } else {
/* 337 */       cloud2x = 990.0D;
/* 338 */       cloud2y = 22.0D;
/*     */     } 
/* 342 */     if (cloud3x <= 828.0D) {
/* 343 */       cloud3x += cloudSpeed;
/*     */     } else {
/* 345 */       cloud3x = -150.0D;
/* 346 */       cloud3y = 365.0D;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void enterGame() {
/* 351 */     Game.isInGame = true;
/* 352 */     menuState = 0;
/* 353 */     KeyManager.enterPressed = false;
/* 354 */     Player.up = false;
/* 355 */     Player.down = false;
/* 356 */     Player.left = false;
/* 357 */     Player.right = false;
/*     */   }
/*     */   
/*     */   public void tick() {
/* 364 */     if (menuState == 2)
/* 365 */       profileTick(); 
/* 368 */     getCloudX();
/*     */   }
/*     */   
/*     */   public void profileTick() {
/* 375 */     if (!Save.save1.exists()) {
/* 376 */       save1Name = "Play To Create Me";
/* 377 */     } else if (Save.save1.exists()) {
/* 378 */       save1Name = save1Name_backup;
/*     */     } 
/* 381 */     if (!Save.save2.exists()) {
/* 382 */       save2Name = "Play To Create Me";
/* 383 */     } else if (Save.save2.exists()) {
/* 384 */       save2Name = save2Name_backup;
/*     */     } 
/* 387 */     if (!Save.save3.exists()) {
/* 388 */       save3Name = "Play To Create Me";
/* 389 */     } else if (Save.save3.exists()) {
/* 390 */       save3Name = save3Name_backup;
/*     */     } 
/* 394 */     if (save1State == 3 || save2State == 3 || save3State == 3) {
/* 395 */       canPlayProfile = true;
/* 397 */     } else if (save1State == 0 && save2State == 0 && save3State == 0) {
/* 398 */       canPlayProfile = false;
/*     */     } 
/* 403 */     if (currentProfile == 0)
/* 404 */       canDeleteProfile = false; 
/* 407 */     if (currentProfile == 1 && !Save.save1.exists()) {
/* 408 */       canDeleteProfile = false;
/* 409 */     } else if (currentProfile == 1 && Save.save1.exists()) {
/* 410 */       canDeleteProfile = true;
/*     */     } 
/* 413 */     if (currentProfile == 2 && !Save.save2.exists()) {
/* 414 */       canDeleteProfile = false;
/* 415 */     } else if (currentProfile == 2 && Save.save2.exists()) {
/* 416 */       canDeleteProfile = true;
/*     */     } 
/* 419 */     if (currentProfile == 3 && !Save.save3.exists()) {
/* 420 */       canDeleteProfile = false;
/* 421 */     } else if (currentProfile == 3 && Save.save3.exists()) {
/* 422 */       canDeleteProfile = true;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void renderMain(Graphics g) {
/* 430 */     g.setColor(Game.skyColor);
/* 431 */     g.fillRect(0, 0, 838, 573);
/* 434 */     drawCloud(g, 1, this.im.cloud1);
/* 435 */     drawCloud(g, 2, this.im.cloud2);
/* 436 */     drawCloud(g, 3, this.im.cloud3);
/* 438 */     if (menuState == 1) {
/* 439 */       renderState1(g);
/* 440 */     } else if (menuState == 2) {
/* 441 */       renderState2(g);
/* 442 */     } else if (menuState == 3) {
/* 443 */       renderState3(g);
/* 444 */     } else if (menuState == 4) {
/* 445 */       renderState4(g);
/* 446 */     } else if (menuState == 5) {
/* 447 */       renderState5(g);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void renderState1(Graphics g) {
/* 458 */     this.fm = g.getFontMetrics(Game.profileInfoFont);
/* 461 */     g.drawImage(Game.logoImage, 419 - Game.logoImage.getWidth(), 
/* 462 */         20, Game.logoImage.getWidth() * 2, 
/* 463 */         Game.logoImage.getHeight() * 2, null);
/* 466 */     g.setFont(Game.profileInfoFont);
/* 467 */     g.setColor(Game.profileInfoColor);
/* 468 */     g.drawString(Game.identifer, 
/* 469 */         419 - this.fm.stringWidth(Game.identifer) / 2, 378);
/* 472 */     g.setFont(Game.buttonTextFont);
/* 473 */     g.setColor(Color.white);
/* 474 */     g.drawString(Game.title, 5, 535);
/* 475 */     g.drawString(Game.copyright, 659, 535);
/* 478 */     drawButton(g, playState, 251, 264, 336, 32, "Play", 
/* 479 */         this.im.button2_1, this.im.button2_2, this.im.button2_3, 1.1D);
/* 482 */     drawButton(g, optionsState, 251, 312, 
/* 483 */         this.im.button2_1.getWidth(), this.im.button2_1.getHeight(), "Options", 
/* 484 */         this.im.button2_1, this.im.button2_2, this.im.button2_3, 1.2D);
/*     */   }
/*     */   
/*     */   public void renderState2(Graphics g) {
/* 492 */     this.fm = g.getFontMetrics(Game.gameProgressFont);
/* 494 */     g.setFont(Game.profileInfoFont);
/* 495 */     g.setColor(Game.profileInfoColor);
/* 499 */     if (save1State == 3) {
/* 500 */       g.drawImage(this.im.profileSelection, 268, 43, 300, 117, null);
/* 501 */       currentProfile = 1;
/* 502 */     } else if (save2State == 3) {
/* 503 */       g.drawImage(this.im.profileSelection, 268, 153, 300, 117, null);
/* 504 */       currentProfile = 2;
/* 505 */     } else if (save3State == 3) {
/* 506 */       g.drawImage(this.im.profileSelection, 268, 263, 300, 117, null);
/* 507 */       currentProfile = 3;
/*     */     } 
/* 512 */     drawProfile(g, save1State, 275, 50, Save.save1LastPlayed, 
/* 513 */         Save.save1Made, Save.save1, 1, save1Name, this.fm);
/* 515 */     drawProfile(g, save2State, 275, 160, Save.save2LastPlayed, 
/* 516 */         Save.save2Made, Save.save2, 2, save2Name, this.fm);
/* 518 */     drawProfile(g, save3State, 275, 270, Save.save3LastPlayed, 
/* 519 */         Save.save3Made, Save.save3, 3, save3Name, this.fm);
/* 522 */     g.setColor(Game.profileInfoColor);
/* 523 */     g.setFont(Game.profileInfoFont);
/* 524 */     g.drawString("Use the WS or up and down keys to select a profile.", 
/* 525 */         498, 535);
/* 529 */     if (canPlayProfile) {
/* 530 */       drawButton(g, playSelectedState, 
/* 531 */           419 - this.im.button2_1.getWidth() / 2, 425, 
/* 532 */           this.im.button2_1.getWidth(), this.im.button2_1.getHeight(), 
/* 533 */           "Play Selected Profile", this.im.button2_1, this.im.button2_2, 
/* 534 */           this.im.button2_3, 2.1D);
/* 535 */     } else if (!canPlayProfile) {
/* 536 */       g.setFont(Game.buttonTextFont);
/* 537 */       g.drawImage(this.im.button2_3, 419 - 
/* 538 */           this.im.button2_3.getWidth() / 2, 425, 
/* 539 */           this.im.button2_3.getWidth(), this.im.button2_3.getHeight(), null);
/* 540 */       g.setColor(Game.buttonClickedColor);
/* 541 */       g.drawString("Play Selected Profile", 324, 446);
/*     */     } 
/* 546 */     if (canDeleteProfile) {
/* 547 */       drawButton(g, deleteState, 419 - 
/* 548 */           this.im.button2_1.getWidth() / 2, 473, 
/* 549 */           this.im.button1_1.getWidth(), this.im.button1_1.getHeight(), 
/* 550 */           "Delete", this.im.button1_1, this.im.button1_2, this.im.button1_3, 2.2D);
/* 551 */     } else if (!canDeleteProfile) {
/* 552 */       g.setFont(Game.buttonTextFont);
/* 553 */       g.drawImage(this.im.button1_3, 419 - 
/* 554 */           this.im.button2_1.getWidth() / 2, 473, 
/* 555 */           this.im.button1_3.getWidth(), this.im.button1_3.getHeight(), null);
/* 556 */       g.setColor(Game.buttonClickedColor);
/* 557 */       g.drawString("Delete", 300, 
/* 558 */           473 + this.im.button1_3.getHeight() / 2 + 5);
/*     */     } 
/* 563 */     drawButton(g, cancelState, 419 - this.im.button2_1.getWidth() / 2 + 
/* 564 */         176, 473, this.im.button1_1.getWidth(), 
/* 565 */         this.im.button1_1.getHeight(), "Back", this.im.button1_1, this.im.button1_2, 
/* 566 */         this.im.button1_3, 2.3D);
/*     */   }
/*     */   
/*     */   public void renderState3(Graphics g) {
/* 574 */     g.setFont(Game.areYouSureFont);
/* 575 */     g.setColor(Game.profileInfoColor);
/* 576 */     g.drawString("Are you sure?", 280, 190);
/* 578 */     g.setFont(Game.buttonTextFont);
/* 580 */     drawButton(g, yesState, 215, 325, this.im.button1_1.getWidth(), 
/* 581 */         this.im.button1_1.getHeight(), "Yes", this.im.button1_1, this.im.button1_2, 
/* 582 */         this.im.button1_3, 3.1D);
/* 584 */     drawButton(g, noState, 454, 325, this.im.button1_1.getWidth(), 
/* 585 */         this.im.button1_1.getHeight(), "No", this.im.button1_1, this.im.button1_2, 
/* 586 */         this.im.button1_3, 3.2D);
/*     */   }
/*     */   
/*     */   public void renderState4(Graphics g) {
/* 594 */     this.fm = g.getFontMetrics(Game.profileInfoFont);
/* 597 */     drawButton(g, autoSaveState, 419 - 
/* 598 */         this.im.button2_1.getWidth() + 8, 100, this.im.button2_1.getWidth(), 
/* 599 */         this.im.button2_1.getHeight(), "Auto Save: " + autoSaveToggle, 
/* 600 */         this.im.button2_1, this.im.button2_2, this.im.button2_3, 4.1D);
/* 601 */     g.setColor(Game.profileInfoColor);
/* 602 */     g.setFont(Game.profileInfoFont);
/* 605 */     drawButton(g, tdState, 427, 100, this.im.button2_1.getWidth(), 
/* 606 */         this.im.button2_1.getHeight(), "Test Dummy: " + tdToggle, 
/* 607 */         this.im.button2_1, this.im.button2_2, this.im.button2_3, 4.3D);
/* 610 */     g.setFont(Game.profileInfoFont);
/* 611 */     g.setColor(Game.profileInfoColor);
/* 612 */     drawButton(g, addOnsState, 419 - this.im.button2_1.getWidth() / 2, 
/* 613 */         473, this.im.button1_1.getWidth(), this.im.button1_1.getHeight(), 
/* 614 */         "Add-Ons...", this.im.button1_1, this.im.button1_2, this.im.button1_3, 4.2D);
/* 617 */     drawButton(g, cancelState, 419 - this.im.button2_1.getWidth() / 2 + 
/* 618 */         176, 473, this.im.button1_1.getWidth(), 
/* 619 */         this.im.button1_1.getHeight(), "Back", this.im.button1_1, this.im.button1_2, 
/* 620 */         this.im.button1_3, 2.3D);
/*     */   }
/*     */   
/*     */   public void renderState5(Graphics g) {
/* 628 */     profileNameBoxState = getGeneralImageState(
/* 629 */         419 - this.im.button2_1.getWidth() / 2 - 1, 89, 
/* 630 */         this.im.button2_1.getWidth() + 2, this.im.button2_1.getHeight() + 2, 
/* 631 */         profileNameBoxState, profileNameBoxInFocus);
/* 633 */     playerNameBoxState = getGeneralImageState(
/* 634 */         419 - this.im.button2_1.getWidth() / 2 - 1, 172, 
/* 635 */         this.im.button2_1.getWidth() + 2, this.im.button2_1.getHeight() + 2, 
/* 636 */         playerNameBoxState, playerNameBoxInFocus);
/* 639 */     draw3WayTextBox(g, profileNameBoxState, 
/* 640 */         419 - this.im.button2_1.getWidth() / 2 - 1, 89, 
/* 641 */         this.im.button2_1.getWidth() + 2, this.im.button2_1.getHeight() + 2, 
/* 642 */         save1Name, save2Name, save3Name, "Profile Name: ", 
/* 643 */         currentProfile);
/* 645 */     drawTextBox(g, playerNameBoxState, 
/* 646 */         419 - this.im.button2_1.getWidth() / 2 - 1, 172, 
/* 647 */         this.im.button2_1.getWidth() + 2, this.im.button2_1.getHeight() + 2, 
/* 648 */         Player.typedName, 
/* 649 */         "Character's Name (Cannot change after this!)");
/* 652 */     drawButton(g, createProfileState, 
/* 653 */         419 - this.im.button2_1.getWidth() / 2, 437, 
/* 654 */         this.im.button1_1.getWidth(), this.im.button1_1.getHeight(), 
/* 655 */         "Create Profile", this.im.button1_1, this.im.button1_2, this.im.button1_3, 5.1D);
/* 658 */     drawButton(
/* 659 */         g, 
/* 660 */         cancelState, 
/* 661 */         419 - 
/* 662 */         this.im.button2_1.getWidth() / 2 - this.im.button1_1
/* 663 */         .getWidth() + 16, 437, 
/* 664 */         this.im.button1_1.getWidth(), this.im.button1_1.getHeight(), "Back", 
/* 665 */         this.im.button1_1, this.im.button1_2, this.im.button1_3, 5.2D);
/*     */   }
/*     */   
/*     */   private void menuStateIs1_play() {
/* 672 */     menuState = 2;
/* 673 */     Load.loadData1(Game.dataPath);
/*     */   }
/*     */   
/*     */   private void menuStateIs1_options() {
/* 677 */     menuState = 4;
/* 678 */     Load.loadData1(Game.dataPath);
/* 680 */     if (autoSaveToggle == "On" && !Game.autoSave) {
/* 681 */       autoSaveToggle = "Off";
/* 682 */     } else if (autoSaveToggle == "Off" && Game.autoSave) {
/* 683 */       autoSaveToggle = "On";
/*     */     } 
/* 687 */     if (tdToggle == "On" && !Game.testDummy) {
/* 688 */       tdToggle = "Off";
/* 689 */     } else if (tdToggle == "Off" && Game.testDummy) {
/* 690 */       tdToggle = "On";
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void menuStateIs2_playProfile() throws IOException {
/* 696 */     if (currentProfile == 1) {
/* 697 */       if (Save.save1.exists()) {
/* 698 */         Load.loadProfile(Game.save1Path);
/* 699 */         Save.profileSave(Save.save1, Game.save1Path, 1);
/* 700 */         enterGame();
/* 701 */       } else if (!Save.save1.exists()) {
/* 702 */         save1Name = "";
/* 703 */         Player.typedName = "";
/* 704 */         cancelState = 0;
/* 705 */         menuState = 5;
/*     */       } 
/* 707 */     } else if (currentProfile == 2) {
/* 708 */       if (Save.save2.exists()) {
/* 709 */         Load.loadProfile(Game.save2Path);
/* 710 */         Save.profileSave(Save.save2, Game.save2Path, 2);
/* 711 */         enterGame();
/* 712 */       } else if (!Save.save2.exists()) {
/* 713 */         save2Name = "";
/* 714 */         Player.typedName = "";
/* 715 */         cancelState = 0;
/* 716 */         menuState = 5;
/*     */       } 
/* 718 */     } else if (currentProfile == 3) {
/* 719 */       if (Save.save3.exists()) {
/* 720 */         Load.loadProfile(Game.save3Path);
/* 721 */         Save.profileSave(Save.save3, Game.save3Path, 3);
/* 722 */         enterGame();
/* 723 */       } else if (!Save.save3.exists()) {
/* 724 */         save3Name = "";
/* 725 */         Player.typedName = "";
/* 726 */         cancelState = 0;
/* 727 */         menuState = 5;
/*     */       } 
/*     */     } 
/* 730 */     MouseManager.mouseFullClick = 0;
/* 731 */     save1State = 0;
/* 732 */     save2State = 0;
/* 733 */     save3State = 0;
/*     */   }
/*     */   
/*     */   private void menuStateIs2_deleteProfile() throws IOException {
/* 739 */     if (currentProfile == 1) {
/* 740 */       Save.save1.delete();
/* 741 */       Save.save1Made = "";
/* 742 */       Save.save1LastPlayed = "";
/* 743 */       Save.dataSave();
/* 744 */     } else if (currentProfile == 2) {
/* 745 */       Save.save2.delete();
/* 746 */       Save.save2Made = "";
/* 747 */       Save.save2LastPlayed = "";
/* 748 */       Save.dataSave();
/* 749 */     } else if (currentProfile == 3) {
/* 750 */       Save.save3.delete();
/* 751 */       Save.save3Made = " ";
/* 752 */       Save.save3LastPlayed = " ";
/* 753 */       Save.dataSave();
/*     */     } 
/* 756 */     menuState = 2;
/* 757 */     currentProfile = 0;
/*     */   }
/*     */   
/*     */   private void menuStateIs2_back() {
/* 762 */     save1State = 0;
/* 763 */     save2State = 0;
/* 764 */     save3State = 0;
/* 765 */     currentProfile = 0;
/* 766 */     menuState = 1;
/*     */   }
/*     */   
/*     */   private void menuStateIs3_yes() {
/*     */     try {
/* 772 */       menuStateIs2_deleteProfile();
/* 773 */     } catch (IOException e) {
/* 774 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void menuStateIs3_no() {
/* 781 */     menuState = 2;
/*     */   }
/*     */   
/*     */   private void menuStateIs4_autoSave() {
/* 786 */     if (autoSaveToggle == "On") {
/* 787 */       autoSaveToggle = "Off";
/* 788 */       Game.autoSave = false;
/* 789 */     } else if (autoSaveToggle == "Off") {
/* 790 */       autoSaveToggle = "On";
/* 791 */       Game.autoSave = true;
/*     */     } 
/* 793 */     MouseManager.mouseFullClick = 0;
/*     */     try {
/* 795 */       Save.dataSave();
/* 796 */     } catch (IOException e) {
/* 797 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void menuStateIs4_testDummy() {
/* 802 */     if (tdToggle == "On") {
/* 803 */       tdToggle = "Off";
/* 804 */       Game.testDummy = false;
/* 805 */     } else if (tdToggle == "Off") {
/* 806 */       tdToggle = "On";
/* 807 */       Game.testDummy = true;
/*     */     } 
/* 809 */     MouseManager.mouseFullClick = 0;
/*     */     try {
/* 811 */       Save.dataSave();
/* 812 */     } catch (IOException e) {
/* 813 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void menuStateIs4_addOns() {}
/*     */   
/*     */   private void menuStateIs5_createProfile(File save, String path) throws IOException {
/* 823 */     Save.reset();
/* 824 */     if (currentProfile == 1 && save1Name.length() == 0) {
/* 825 */       save1Name = "Profile 1";
/* 826 */       save1Name_backup = save1Name;
/* 827 */     } else if (currentProfile == 2 && save2Name.length() == 0) {
/* 828 */       save2Name = "Profile 2";
/* 829 */       save2Name_backup = save2Name;
/* 830 */     } else if (currentProfile == 3 && save3Name.length() == 0) {
/* 831 */       save3Name = "Profile 3";
/* 832 */       save3Name_backup = save3Name;
/*     */     } 
/* 834 */     if (Player.typedName.length() == 0) {
/* 835 */       Player.name = Player.defaultName;
/* 836 */     } else if (Player.typedName.length() >= 1) {
/* 837 */       Player.name = Player.typedName;
/*     */     } 
/* 839 */     Save.profileSave(save, path, currentProfile);
/* 840 */     Save.dataSave();
/* 841 */     Load.loadProfile(path);
/* 842 */     createProfileState = 0;
/* 843 */     enterGame();
/* 844 */     StoryText.request("Our story begins within a town called " + 
/* 845 */         Game.townName, 
/* 846 */         "For centuries, each generation has lived in peace, but", 
/* 847 */         "today, something will happen, something big.", 
/* 848 */         "It will distrub the natural balance of " + Game.townName + 
/* 849 */         " and its people.", "", 
/* 850 */         "One the first day, there was darkness.", "");
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_3.jar!\beyondOrigins\main\menus\MainMenu.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */