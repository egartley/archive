/*     */ package beyondOrigins.main.menus;
/*     */ 
/*     */ import beyondOrigins.files.Load;
/*     */ import beyondOrigins.files.Save;
/*     */ import beyondOrigins.main.Game;
/*     */ import beyondOrigins.main.gfx.ImageManager;
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
/*  24 */   public static volatile int menuState = 1;
/*     */   
/*     */   private ImageManager im;
/*     */   
/*  28 */   public static double cloud1x = 850.0D;
/*     */   
/*  29 */   public static double cloud1y = 200.0D;
/*     */   
/*  30 */   public static double cloud2x = 990.0D;
/*     */   
/*  31 */   public static double cloud2y = 22.0D;
/*     */   
/*  32 */   public static double cloud3x = -150.0D;
/*     */   
/*  33 */   public static double cloud3y = 365.0D;
/*     */   
/*  34 */   private static double cloudSpeed = 0.5D;
/*     */   
/*     */   public static int playState;
/*     */   
/*     */   private static int optionsState;
/*     */   
/*  41 */   public static int currentProfile = 0;
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
/*  46 */   public static String save1Name = "IfYouSeeThisSomethingIsWrong";
/*     */   
/*  47 */   public static String save2Name = "IfYouSeeThisSomethingIsWrong";
/*     */   
/*  48 */   public static String save3Name = "IfYouSeeThisSomethingIsWrong";
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
/*  57 */   public static String autoSaveToggle = "On";
/*     */   
/*     */   private static int createProfileState;
/*     */   
/*     */   public static int profileNameBoxState;
/*     */   
/*     */   public static boolean profileNameBoxIsTyping = false;
/*     */   
/*     */   public MainMenu(ImageManager im) {
/*  67 */     this.im = im;
/*     */   }
/*     */   
/*     */   public static void init() {}
/*     */   
/*     */   public int getButtonState(int minX, int minY, int width, int height, int state) {
/*  83 */     if (MouseMotion.mouseX >= minX && MouseMotion.mouseX < minX + width && 
/*  84 */       MouseMotion.mouseY >= minY && 
/*  85 */       MouseMotion.mouseY < minY + height) {
/*  86 */       state = 2;
/*  87 */       if (MouseManager.mouseFullClick == 1) {
/*  88 */         state = 3;
/*     */       } else {
/*  90 */         state = 2;
/*     */       } 
/*     */     } else {
/*  92 */       state = 1;
/*     */     } 
/*  93 */     return state;
/*     */   }
/*     */   
/*     */   public int getGeneralImageState(int renderX, int renderY, int width, int height, int state) {
/* 100 */     if (MouseMotion.mouseX >= renderX && 
/* 101 */       MouseMotion.mouseX < renderX + width && 
/* 102 */       MouseMotion.mouseY >= renderY && 
/* 103 */       MouseMotion.mouseY < renderY + height && 
/* 104 */       MouseManager.mouseFullClick == 1) {
/* 105 */       state = 2;
/* 106 */     } else if (MouseManager.mouseFullClick == 1) {
/* 107 */       state = 1;
/*     */     } 
/* 109 */     return state;
/*     */   }
/*     */   
/*     */   public void drawButton(Graphics g, int state, int renderX, int renderY, int width, int height, String buttonText, BufferedImage state1Image, BufferedImage state2Image, BufferedImage state3Image, double clickEventType) {
/* 116 */     this.fm = g.getFontMetrics(Game.buttonTextFont);
/* 117 */     g.setFont(Game.buttonTextFont);
/* 118 */     if (getButtonState(renderX, renderY, width, height, state) == 1) {
/* 119 */       g.drawImage(state1Image, renderX, renderY, width, height, null);
/* 120 */       g.setColor(Game.buttonIdleColor);
/* 121 */       g.drawString(buttonText, renderX + state1Image.getWidth() / 2 - 
/* 122 */           this.fm.stringWidth(buttonText) / 2, 
/* 123 */           renderY + state1Image.getHeight() / 2 + 5);
/* 124 */     } else if (getButtonState(renderX, renderY, width, height, state) == 2) {
/* 125 */       g.drawImage(state2Image, renderX, renderY, width, height, null);
/* 126 */       g.setColor(Game.buttonSelectedColor);
/* 127 */       g.drawString(buttonText, renderX + state1Image.getWidth() / 2 - 
/* 128 */           this.fm.stringWidth(buttonText) / 2, 
/* 129 */           renderY + state1Image.getHeight() / 2 + 5);
/* 130 */     } else if (getButtonState(renderX, renderY, width, height, state) == 3) {
/* 131 */       g.drawImage(state3Image, renderX, renderY, width, height, null);
/* 132 */       g.setColor(Game.buttonClickedColor);
/* 133 */       g.drawString(buttonText, renderX + state1Image.getWidth() / 2 - 
/* 134 */           this.fm.stringWidth(buttonText) / 2, 
/* 135 */           renderY + state1Image.getHeight() / 2 + 5);
/* 137 */       if (clickEventType == 1.1D) {
/* 138 */         menuStateIs1_play();
/* 139 */       } else if (clickEventType == 1.2D) {
/* 140 */         menuStateIs1_options();
/*     */       } 
/* 143 */       if (clickEventType == 2.1D) {
/*     */         try {
/* 145 */           menuStateIs2_playProfile();
/* 146 */         } catch (IOException e) {
/* 147 */           e.printStackTrace();
/*     */         } 
/* 149 */       } else if (clickEventType == 2.2D) {
/* 150 */         menuState = 3;
/* 151 */       } else if (clickEventType == 2.3D) {
/* 152 */         menuStateIs2_back();
/*     */       } 
/* 155 */       if (clickEventType == 3.1D) {
/* 156 */         menuStateIs3_yes();
/* 157 */       } else if (clickEventType == 3.2D) {
/* 158 */         menuStateIs3_no();
/*     */       } 
/* 161 */       if (clickEventType == 4.1D) {
/* 162 */         menuStateIs4_autoSave();
/* 163 */       } else if (clickEventType == 4.2D) {
/* 164 */         menuStateIs4_addOns();
/*     */       } 
/* 167 */       if (clickEventType == 5.1D) {
/*     */         try {
/* 169 */           if (currentProfile == 1) {
/* 170 */             menuStateIs5_createProfile(Save.save1, Game.save1Path);
/* 171 */           } else if (currentProfile == 2) {
/* 172 */             menuStateIs5_createProfile(Save.save2, Game.save2Path);
/* 173 */           } else if (currentProfile == 3) {
/* 174 */             menuStateIs5_createProfile(Save.save3, Game.save3Path);
/*     */           } 
/* 176 */         } catch (IOException e) {
/* 177 */           e.printStackTrace();
/*     */         } 
/* 179 */       } else if (clickEventType == 5.2D) {
/* 180 */         MouseManager.mouseFullClick = 0;
/* 181 */         menuState = 2;
/* 182 */         currentProfile = 0;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void drawProfile(Graphics g, int state, int renderX, int renderY, String lastPlayed, String created, File file, int profileProgress, int profileNumber, String name, FontMetrics fm) {
/* 190 */     g.drawImage(this.im.profileSquare, renderX, renderY, 
/* 191 */         this.im.profileSquare.getWidth(), this.im.profileSquare.getHeight(), null);
/* 192 */     if (file.exists()) {
/* 193 */       g.setColor(Game.gameProgressColor);
/* 194 */       g.setFont(Game.gameProgressFont);
/* 195 */       g.drawString(
/* 196 */           String.valueOf(profileProgress) + "%", 
/* 197 */           this.im.profileSquare.getWidth() / 2 + 275 - 
/* 198 */           fm.stringWidth(String.valueOf(profileProgress) + "%") / 2, 
/* 199 */           profileNumber * 110);
/* 200 */     } else if (!file.exists()) {
/* 201 */       g.setColor(Game.gameProgressColor);
/* 202 */       g.setFont(Game.gameProgressFont);
/* 203 */       g.drawString("?", this.im.profileSquare.getWidth() / 2 + renderX - 
/* 204 */           fm.stringWidth("?") / 2, profileNumber * 110);
/*     */     } 
/* 206 */     if (currentProfile == profileNumber) {
/* 207 */       g.setColor(Color.white);
/*     */     } else {
/* 209 */       g.setColor(Game.profileInfoColor);
/*     */     } 
/* 211 */     g.setFont(Game.profileNameFont);
/* 212 */     g.drawString(name, 380, profileNumber * 110 - 40);
/* 213 */     g.setFont(Game.profileInfoFont);
/* 214 */     g.drawString("Last Played: " + lastPlayed, 380, 
/* 215 */         profileNumber * 110 - 40 + 33);
/* 216 */     g.drawString("Date Created: " + created, 380, 
/* 217 */         profileNumber * 110 - 40 + 66);
/*     */   }
/*     */   
/*     */   public void drawOptionalTextBox(Graphics g, int state, int renderX, int renderY, int w, int h, String text1, String text2, String text3, String infoText1, String infoText2, int optionalParam, boolean isTyping) {
/* 226 */     this.fm = g.getFontMetrics(Game.buttonTextFont);
/* 228 */     g.setColor(Game.profileInfoColor);
/* 229 */     g.setFont(Game.profileInfoFont);
/* 231 */     g.drawString(infoText1, renderX, renderY - 9);
/* 232 */     g.drawString(infoText2, renderX, renderY + 53);
/* 234 */     g.setColor(new Color(232, 232, 232));
/* 235 */     g.drawRect(renderX + 1, renderY + 1, w - 2, h - 2);
/* 236 */     g.drawRect(renderX, renderY, w, h);
/* 238 */     g.setColor(new Color(0, 0, 0, 180));
/* 239 */     g.fillRect(renderX + 2, renderY + 2, w - 3, h - 3);
/* 241 */     g.setFont(Game.buttonTextFont);
/* 242 */     g.setColor(Color.white);
/* 243 */     if (optionalParam == 1) {
/* 244 */       g.drawString(text1, renderX + 8, renderY + 24);
/* 245 */       if (state == 2)
/* 246 */         g.drawString("_", renderX + 8 + this.fm.stringWidth(text1), 
/* 247 */             renderY + 24); 
/* 249 */     } else if (optionalParam == 2) {
/* 251 */       g.drawString(text2, renderX + 8, renderY + 24);
/* 252 */       if (state == 2)
/* 253 */         g.drawString("_", renderX + 8 + this.fm.stringWidth(text2), 
/* 254 */             renderY + 24); 
/* 256 */     } else if (optionalParam == 3) {
/* 257 */       g.drawString(text3, renderX + 8, renderY + 24);
/* 258 */       if (state == 2)
/* 259 */         g.drawString("_", renderX + 8 + this.fm.stringWidth(text3), 
/* 260 */             renderY + 24); 
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void drawCloud(Graphics g, int number, BufferedImage image) {
/* 267 */     if (number == 1) {
/* 268 */       g.drawImage(image, (int)cloud1x, (int)cloud1y, image.getWidth(), 
/* 269 */           image.getHeight(), null);
/* 270 */     } else if (number == 2) {
/* 271 */       g.drawImage(image, (int)cloud2x, (int)cloud2y, image.getWidth(), 
/* 272 */           image.getHeight(), null);
/* 273 */     } else if (number == 3) {
/* 274 */       g.drawImage(image, (int)cloud3x, (int)cloud3y, image.getWidth(), 
/* 275 */           image.getHeight(), null);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void getCloudX() {
/* 281 */     if (cloud1x > -150.0D) {
/* 282 */       cloud1x -= cloudSpeed + 0.1D;
/*     */     } else {
/* 284 */       cloud1x = 850.0D;
/* 285 */       cloud1y = 200.0D;
/*     */     } 
/* 289 */     if (cloud2x > -125.0D) {
/* 290 */       cloud2x -= cloudSpeed;
/*     */     } else {
/* 292 */       cloud2x = 990.0D;
/* 293 */       cloud2y = 22.0D;
/*     */     } 
/* 297 */     if (cloud3x <= 828.0D) {
/* 298 */       cloud3x += cloudSpeed;
/*     */     } else {
/* 300 */       cloud3x = -150.0D;
/* 301 */       cloud3y = 365.0D;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void enterGame() {
/* 306 */     Game.isInGame = true;
/* 307 */     menuState = 0;
/* 308 */     KeyManager.enterPressed = false;
/*     */   }
/*     */   
/*     */   public void tick() {
/* 315 */     if (menuState == 2)
/* 316 */       profileTick(); 
/* 319 */     getCloudX();
/*     */   }
/*     */   
/*     */   public void profileTick() {
/* 338 */     if (!Save.save1.exists()) {
/* 339 */       save1Name = "Play To Create Me";
/* 340 */     } else if (Save.save1.exists()) {
/* 341 */       save1Name = save1Name_backup;
/*     */     } 
/* 344 */     if (!Save.save2.exists()) {
/* 345 */       save2Name = "Play To Create Me";
/* 346 */     } else if (Save.save2.exists()) {
/* 347 */       save2Name = save2Name_backup;
/*     */     } 
/* 350 */     if (!Save.save3.exists()) {
/* 351 */       save3Name = "Play To Create Me";
/* 352 */     } else if (Save.save3.exists()) {
/* 353 */       save3Name = save3Name_backup;
/*     */     } 
/* 357 */     if (save1State == 3 || save2State == 3 || save3State == 3) {
/* 358 */       canPlayProfile = true;
/* 360 */     } else if (save1State == 0 && save2State == 0 && save3State == 0) {
/* 361 */       canPlayProfile = false;
/*     */     } 
/* 366 */     if (currentProfile == 0)
/* 367 */       canDeleteProfile = false; 
/* 370 */     if (currentProfile == 1 && !Save.save1.exists()) {
/* 371 */       canDeleteProfile = false;
/* 372 */     } else if (currentProfile == 1 && Save.save1.exists()) {
/* 373 */       canDeleteProfile = true;
/*     */     } 
/* 376 */     if (currentProfile == 2 && !Save.save2.exists()) {
/* 377 */       canDeleteProfile = false;
/* 378 */     } else if (currentProfile == 2 && Save.save2.exists()) {
/* 379 */       canDeleteProfile = true;
/*     */     } 
/* 382 */     if (currentProfile == 3 && !Save.save3.exists()) {
/* 383 */       canDeleteProfile = false;
/* 384 */     } else if (currentProfile == 3 && Save.save3.exists()) {
/* 385 */       canDeleteProfile = true;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void renderMain(Graphics g) {
/* 393 */     g.setColor(Game.skyColor);
/* 394 */     g.fillRect(0, 0, 838, 573);
/* 397 */     drawCloud(g, 1, this.im.cloud1);
/* 398 */     drawCloud(g, 2, this.im.cloud2);
/* 399 */     drawCloud(g, 3, this.im.cloud3);
/* 401 */     if (menuState == 1) {
/* 402 */       renderState1(g);
/* 403 */     } else if (menuState == 2) {
/* 404 */       renderState2(g);
/* 405 */     } else if (menuState == 3) {
/* 406 */       renderState3(g);
/* 407 */     } else if (menuState == 4) {
/* 408 */       renderState4(g);
/* 409 */     } else if (menuState == 5) {
/* 410 */       renderState5(g);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void renderState1(Graphics g) {
/* 421 */     this.fm = g.getFontMetrics(Game.profileInfoFont);
/* 424 */     g.drawImage(Game.logoImage, 419 - Game.logoImage.getWidth(), 
/* 425 */         -125, 512, 512, null);
/* 428 */     g.setFont(Game.profileInfoFont);
/* 429 */     g.setColor(Game.profileInfoColor);
/* 430 */     g.drawString(Game.identifer, 
/* 431 */         419 - this.fm.stringWidth(Game.identifer) / 2, 378);
/* 434 */     g.setFont(Game.buttonTextFont);
/* 435 */     g.setColor(Color.white);
/* 436 */     g.drawString(Game.title, 5, 535);
/* 437 */     g.drawString(Game.copyright, 659, 535);
/* 440 */     drawButton(g, playState, 251, 264, 336, 32, "Play", 
/* 441 */         this.im.button2_1, this.im.button2_2, this.im.button2_3, 1.1D);
/* 444 */     drawButton(g, optionsState, 251, 312, 
/* 445 */         this.im.button2_1.getWidth(), this.im.button2_1.getHeight(), "Options", 
/* 446 */         this.im.button2_1, this.im.button2_2, this.im.button2_3, 1.2D);
/*     */   }
/*     */   
/*     */   public void renderState2(Graphics g) {
/* 454 */     this.fm = g.getFontMetrics(Game.gameProgressFont);
/* 456 */     g.setFont(Game.profileInfoFont);
/* 457 */     g.setColor(Game.profileInfoColor);
/* 461 */     if (save1State == 3) {
/* 462 */       g.drawImage(this.im.profileSelection, 268, 43, 300, 117, null);
/* 463 */       currentProfile = 1;
/* 464 */     } else if (save2State == 3) {
/* 465 */       g.drawImage(this.im.profileSelection, 268, 153, 300, 117, null);
/* 466 */       currentProfile = 2;
/* 467 */     } else if (save3State == 3) {
/* 468 */       g.drawImage(this.im.profileSelection, 268, 263, 300, 117, null);
/* 469 */       currentProfile = 3;
/*     */     } 
/* 472 */     drawProfile(g, save1State, 275, 50, 
/* 473 */         Save.save1LastPlayed, Save.save1Made, Save.save1, 
/* 474 */         Save.save1Progress, 1, save1Name, this.fm);
/* 476 */     drawProfile(g, save2State, 275, 160, 
/* 477 */         Save.save2LastPlayed, Save.save2Made, Save.save2, 
/* 478 */         Save.save2Progress, 2, save2Name, this.fm);
/* 480 */     drawProfile(g, save3State, 275, 270, 
/* 481 */         Save.save3LastPlayed, Save.save3Made, Save.save3, 
/* 482 */         Save.save3Progress, 3, save3Name, this.fm);
/* 486 */     if (canPlayProfile) {
/* 487 */       drawButton(g, playSelectedState, 
/* 488 */           419 - this.im.button2_1.getWidth() / 2, 425, 
/* 489 */           this.im.button2_1.getWidth(), this.im.button2_1.getHeight(), 
/* 490 */           "Play Selected Profile", this.im.button2_1, this.im.button2_2, 
/* 491 */           this.im.button2_3, 2.1D);
/* 492 */     } else if (!canPlayProfile) {
/* 493 */       g.setFont(Game.buttonTextFont);
/* 494 */       g.drawImage(this.im.button2_3, 419 - 
/* 495 */           this.im.button2_3.getWidth() / 2, 425, 
/* 496 */           this.im.button2_3.getWidth(), this.im.button2_3.getHeight(), null);
/* 497 */       g.setColor(Game.buttonClickedColor);
/* 498 */       g.drawString("Play Selected Profile", 324, 446);
/*     */     } 
/* 503 */     if (canDeleteProfile) {
/* 504 */       drawButton(g, deleteState, 419 - 
/* 505 */           this.im.button2_1.getWidth() / 2, 473, 
/* 506 */           this.im.button1_1.getWidth(), this.im.button1_1.getHeight(), 
/* 507 */           "Delete", this.im.button1_1, this.im.button1_2, this.im.button1_3, 2.2D);
/* 508 */     } else if (!canDeleteProfile) {
/* 509 */       g.setFont(Game.buttonTextFont);
/* 510 */       g.drawImage(this.im.button1_3, 419 - 
/* 511 */           this.im.button2_1.getWidth() / 2, 473, 
/* 512 */           this.im.button1_3.getWidth(), this.im.button1_3.getHeight(), null);
/* 513 */       g.setColor(Game.buttonClickedColor);
/* 514 */       g.drawString("Delete", 300, 
/* 515 */           473 + this.im.button1_3.getHeight() / 2 + 5);
/*     */     } 
/* 520 */     drawButton(g, cancelState, 419 - this.im.button2_1.getWidth() / 2 + 
/* 521 */         176, 473, this.im.button1_1.getWidth(), 
/* 522 */         this.im.button1_1.getHeight(), "Back", this.im.button1_1, this.im.button1_2, 
/* 523 */         this.im.button1_3, 2.3D);
/*     */   }
/*     */   
/*     */   public void renderState3(Graphics g) {
/* 531 */     g.setFont(Game.areYouSureFont);
/* 532 */     g.setColor(Game.profileInfoColor);
/* 533 */     g.drawString("Are you sure?", 280, 190);
/* 535 */     g.setFont(Game.buttonTextFont);
/* 537 */     drawButton(g, yesState, 215, 325, this.im.button1_1.getWidth(), 
/* 538 */         this.im.button1_1.getHeight(), "Yes", this.im.button1_1, this.im.button1_2, 
/* 539 */         this.im.button1_3, 3.1D);
/* 541 */     drawButton(g, noState, 454, 325, this.im.button1_1.getWidth(), 
/* 542 */         this.im.button1_1.getHeight(), "No", this.im.button1_1, this.im.button1_2, 
/* 543 */         this.im.button1_3, 3.2D);
/*     */   }
/*     */   
/*     */   public void renderState4(Graphics g) {
/* 551 */     this.fm = g.getFontMetrics(Game.profileInfoFont);
/* 554 */     drawButton(g, autoSaveState, 419 - 
/* 555 */         this.im.button2_1.getWidth() + 8, 100, this.im.button2_1.getWidth(), 
/* 556 */         this.im.button2_1.getHeight(), "Auto Save: " + autoSaveToggle, 
/* 557 */         this.im.button2_1, this.im.button2_2, this.im.button2_3, 4.1D);
/* 558 */     g.setColor(Game.profileInfoColor);
/* 559 */     g.setFont(Game.profileInfoFont);
/* 560 */     g.drawString("Turning this option on will enable automatic saving.", 
/* 561 */         72, 156);
/* 564 */     g.drawString("Coming Soon!", 372, 429);
/* 565 */     drawButton(g, addOnsState, 
/* 566 */         419 - this.im.button2_1.getWidth() / 2, 373, 
/* 567 */         this.im.button2_1.getWidth(), this.im.button2_1.getHeight(), 
/* 568 */         "Add-Ons...", this.im.button2_1, this.im.button2_2, this.im.button2_3, 4.2D);
/* 571 */     drawButton(g, cancelState, 419 - this.im.button1_1.getWidth() / 2, 
/* 572 */         473, this.im.button1_1.getWidth(), this.im.button1_1.getHeight(), 
/* 573 */         "Back", this.im.button1_1, this.im.button1_2, this.im.button1_3, 2.3D);
/*     */   }
/*     */   
/*     */   public void renderState5(Graphics g) {
/* 580 */     profileNameBoxState = getGeneralImageState(
/* 581 */         419 - this.im.button2_1.getWidth() / 2 + 1, 91, 
/* 582 */         this.im.button2_1.getWidth() - 1, this.im.button2_1.getHeight() - 1, 
/* 583 */         profileNameBoxState);
/* 585 */     if (profileNameBoxState == 2) {
/* 586 */       profileNameBoxIsTyping = true;
/* 587 */     } else if (profileNameBoxState != 2) {
/* 588 */       profileNameBoxIsTyping = false;
/*     */     } 
/* 591 */     drawOptionalTextBox(g, profileNameBoxState, 
/* 592 */         419 - this.im.button2_1.getWidth() / 2 - 1, 89, 
/* 593 */         this.im.button2_1.getWidth() + 2, this.im.button2_1.getHeight() + 2, 
/* 594 */         save1Name, save2Name, save3Name, 
/* 595 */         "Enter a name for the profile: ", 
/* 596 */         "If left blank, the name will default to Profile 1, 2, or 3.", currentProfile, profileNameBoxIsTyping);
/* 599 */     drawButton(g, createProfileState, 
/* 600 */         419 - this.im.button2_1.getWidth() / 2, 437, 
/* 601 */         this.im.button1_1.getWidth(), this.im.button1_1.getHeight(), 
/* 602 */         "Create Profile", this.im.button1_1, this.im.button1_2, this.im.button1_3, 5.1D);
/* 605 */     drawButton(
/* 606 */         g, 
/* 607 */         cancelState, 
/* 608 */         419 - 
/* 609 */         this.im.button2_1.getWidth() / 2 - this.im.button1_1
/* 610 */         .getWidth() + 16, 437, 
/* 611 */         this.im.button1_1.getWidth(), this.im.button1_1.getHeight(), "Back", 
/* 612 */         this.im.button1_1, this.im.button1_2, this.im.button1_3, 5.2D);
/*     */   }
/*     */   
/*     */   public void menuStateIs1_play() {
/* 619 */     menuState = 2;
/* 620 */     Load.loadData1(Game.dataPath);
/*     */   }
/*     */   
/*     */   public void menuStateIs1_options() {
/* 624 */     menuState = 4;
/* 625 */     Load.loadData1(Game.dataPath);
/* 626 */     if (autoSaveToggle == "On" && !Game.autoSave) {
/* 627 */       autoSaveToggle = "Off";
/* 628 */     } else if (autoSaveToggle == "Off" && Game.autoSave) {
/* 629 */       autoSaveToggle = "On";
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void menuStateIs2_playProfile() throws IOException {
/* 635 */     if (currentProfile == 1) {
/* 636 */       if (Save.save1.exists()) {
/* 637 */         Load.loadProfile(Game.save1Path);
/* 638 */         Save.profileSave(Save.save1, Game.save1Path, 1);
/* 639 */         enterGame();
/* 640 */       } else if (!Save.save1.exists()) {
/* 641 */         save1Name = "";
/* 642 */         cancelState = 0;
/* 643 */         menuState = 5;
/*     */       } 
/* 645 */     } else if (currentProfile == 2) {
/* 646 */       if (Save.save2.exists()) {
/* 647 */         Load.loadProfile(Game.save2Path);
/* 648 */         Save.profileSave(Save.save2, Game.save2Path, 2);
/* 649 */         enterGame();
/* 650 */       } else if (!Save.save2.exists()) {
/* 651 */         save2Name = "";
/* 652 */         cancelState = 0;
/* 653 */         menuState = 5;
/*     */       } 
/* 655 */     } else if (currentProfile == 3) {
/* 656 */       if (Save.save3.exists()) {
/* 657 */         Load.loadProfile(Game.save3Path);
/* 658 */         Save.profileSave(Save.save3, Game.save3Path, 3);
/* 659 */         enterGame();
/* 660 */       } else if (!Save.save3.exists()) {
/* 661 */         save3Name = "";
/* 662 */         cancelState = 0;
/* 663 */         menuState = 5;
/*     */       } 
/*     */     } 
/* 666 */     MouseManager.mouseFullClick = 0;
/* 667 */     save1State = 0;
/* 668 */     save2State = 0;
/* 669 */     save3State = 0;
/*     */   }
/*     */   
/*     */   public void menuStateIs2_deleteProfile() throws IOException {
/* 675 */     if (currentProfile == 1) {
/* 676 */       Save.save1.delete();
/* 677 */       Save.save1Made = "";
/* 678 */       Save.save1LastPlayed = "";
/* 679 */       Save.dataSave();
/* 680 */     } else if (currentProfile == 2) {
/* 681 */       Save.save2.delete();
/* 682 */       Save.save2Made = "";
/* 683 */       Save.save2LastPlayed = "";
/* 684 */       Save.dataSave();
/* 685 */     } else if (currentProfile == 3) {
/* 686 */       Save.save3.delete();
/* 687 */       Save.save3Made = " ";
/* 688 */       Save.save3LastPlayed = " ";
/* 689 */       Save.dataSave();
/*     */     } 
/* 692 */     menuState = 2;
/* 693 */     currentProfile = 0;
/*     */   }
/*     */   
/*     */   public void menuStateIs2_back() {
/* 698 */     save1State = 0;
/* 699 */     save2State = 0;
/* 700 */     save3State = 0;
/* 701 */     currentProfile = 0;
/* 702 */     menuState = 1;
/*     */   }
/*     */   
/*     */   public void menuStateIs3_yes() {
/*     */     try {
/* 708 */       menuStateIs2_deleteProfile();
/* 709 */     } catch (IOException e) {
/* 710 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void menuStateIs3_no() {
/* 717 */     menuState = 2;
/*     */   }
/*     */   
/*     */   public void menuStateIs4_autoSave() {
/* 723 */     if (autoSaveToggle == "On") {
/* 724 */       autoSaveToggle = "Off";
/* 725 */       Game.autoSave = false;
/* 726 */     } else if (autoSaveToggle == "Off") {
/* 727 */       autoSaveToggle = "On";
/* 728 */       Game.autoSave = true;
/*     */     } 
/* 730 */     MouseManager.mouseFullClick = 0;
/*     */     try {
/* 732 */       Save.dataSave();
/* 733 */     } catch (IOException e) {
/* 734 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void menuStateIs4_addOns() {}
/*     */   
/*     */   public void menuStateIs5_createProfile(File save, String path) throws IOException {
/* 744 */     if (currentProfile == 1 && save1Name.length() == 0) {
/* 745 */       save1Name = "Profile 1";
/* 746 */     } else if (currentProfile == 2 && save2Name.length() == 0) {
/* 747 */       save2Name = "Profile 2";
/* 748 */     } else if (currentProfile == 3 && save3Name.length() == 0) {
/* 749 */       save3Name = "Profile 3";
/*     */     } 
/* 751 */     Save.reset();
/* 752 */     Save.profileSave(save, path, currentProfile);
/* 753 */     Save.dataSave();
/* 754 */     enterGame();
/* 755 */     createProfileState = 0;
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_2.jar!\beyondOrigins\main\menus\MainMenu.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */