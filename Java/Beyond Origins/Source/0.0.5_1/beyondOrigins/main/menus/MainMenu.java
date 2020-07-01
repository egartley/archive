/*     */ package beyondOrigins.main.menus;
/*     */ 
/*     */ import beyondOrigins.files.Load;
/*     */ import beyondOrigins.files.Save;
/*     */ import beyondOrigins.main.Game;
/*     */ import beyondOrigins.main.gfx.ImageManager;
/*     */ import beyondOrigins.threads.CloudThread;
/*     */ import beyondOrigins.userInput.MouseManager;
/*     */ import beyondOrigins.userInput.MouseMotion;
/*     */ import java.awt.Color;
/*     */ import java.awt.FontMetrics;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.Random;
/*     */ 
/*     */ public class MainMenu {
/*  22 */   static Random r = new Random();
/*     */   
/*     */   private static int r1;
/*     */   
/*     */   private static int r2;
/*     */   
/*     */   private static int r3;
/*     */   
/*     */   private FontMetrics fm;
/*     */   
/*  31 */   public static int menuState = 1;
/*     */   
/*     */   public static boolean clouds;
/*     */   
/*     */   private ImageManager im;
/*     */   
/*     */   public static int playState;
/*     */   
/*     */   private static int optionsState;
/*     */   
/*  40 */   public static int currentProfile = 0;
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
/*  45 */   public static String save1Name = "IfYouSeeThisSomethingIsWrong";
/*     */   
/*  46 */   public static String save2Name = "IfYouSeeThisSomethingIsWrong";
/*     */   
/*  47 */   public static String save3Name = "IfYouSeeThisSomethingIsWrong";
/*     */   
/*     */   public static int yesState;
/*     */   
/*     */   public static int noState;
/*     */   
/*     */   private static int autoSaveState;
/*     */   
/*     */   private static int addOnsState;
/*     */   
/*  54 */   public static String autoSaveToggle = "On";
/*     */   
/*     */   private static int createProfileState;
/*     */   
/*     */   public static int textBoxState;
/*     */   
/*     */   public static boolean isTyping = false;
/*     */   
/*     */   public MainMenu(ImageManager im) {
/*  64 */     this.im = im;
/*     */   }
/*     */   
/*     */   public static void init() {}
/*     */   
/*     */   public int getButtonState(int minX, int minY, int width, int height, int state) {
/*  80 */     if (MouseMotion.mouseX >= minX && MouseMotion.mouseX < minX + width && 
/*  81 */       MouseMotion.mouseY >= minY && 
/*  82 */       MouseMotion.mouseY < minY + height) {
/*  83 */       state = 2;
/*  84 */       if (MouseManager.mouseFullClick == 1) {
/*  85 */         state = 3;
/*     */       } else {
/*  87 */         state = 2;
/*     */       } 
/*     */     } else {
/*  89 */       state = 1;
/*     */     } 
/*  90 */     return state;
/*     */   }
/*     */   
/*     */   public int getGeneralImageState(int renderX, int renderY, int width, int height, int state) {
/*  97 */     if (MouseMotion.mouseX >= renderX && 
/*  98 */       MouseMotion.mouseX < renderX + width && 
/*  99 */       MouseMotion.mouseY >= renderY && 
/* 100 */       MouseMotion.mouseY < renderY + height && 
/* 101 */       MouseManager.mouseFullClick == 1) {
/* 102 */       state = 2;
/* 103 */     } else if (MouseManager.mouseFullClick == 1) {
/* 104 */       state = 1;
/*     */     } 
/* 106 */     return state;
/*     */   }
/*     */   
/*     */   public void drawButton(Graphics g, int state, int renderX, int renderY, int width, int height, String buttonText, BufferedImage state1Image, BufferedImage state2Image, BufferedImage state3Image, double clickEventType) {
/* 113 */     this.fm = g.getFontMetrics(Game.buttonTextFont);
/* 114 */     g.setFont(Game.buttonTextFont);
/* 115 */     if (getButtonState(renderX, renderY, width, height, state) == 1) {
/* 116 */       g.drawImage(state1Image, renderX, renderY, width, height, null);
/* 117 */       g.setColor(Game.buttonIdleColor);
/* 118 */       g.drawString(buttonText, renderX + state1Image.getWidth() / 2 - 
/* 119 */           this.fm.stringWidth(buttonText) / 2, 
/* 120 */           renderY + state1Image.getHeight() / 2 + 5);
/* 121 */     } else if (getButtonState(renderX, renderY, width, height, state) == 2) {
/* 122 */       g.drawImage(state2Image, renderX, renderY, width, height, null);
/* 123 */       g.setColor(Game.buttonSelectedColor);
/* 124 */       g.drawString(buttonText, renderX + state1Image.getWidth() / 2 - 
/* 125 */           this.fm.stringWidth(buttonText) / 2, 
/* 126 */           renderY + state1Image.getHeight() / 2 + 5);
/* 127 */     } else if (getButtonState(renderX, renderY, width, height, state) == 3) {
/* 128 */       g.drawImage(state3Image, renderX, renderY, width, height, null);
/* 129 */       g.setColor(Game.buttonClickedColor);
/* 130 */       g.drawString(buttonText, renderX + state1Image.getWidth() / 2 - 
/* 131 */           this.fm.stringWidth(buttonText) / 2, 
/* 132 */           renderY + state1Image.getHeight() / 2 + 5);
/* 134 */       if (clickEventType == 1.1D) {
/* 135 */         menuStateIs1_play();
/* 136 */       } else if (clickEventType == 1.2D) {
/* 137 */         menuStateIs1_options();
/*     */       } 
/* 140 */       if (clickEventType == 2.1D) {
/*     */         try {
/* 142 */           menuStateIs2_playProfile();
/* 143 */         } catch (IOException e) {
/* 144 */           e.printStackTrace();
/*     */         } 
/* 146 */       } else if (clickEventType == 2.2D) {
/* 147 */         menuState = 3;
/* 148 */       } else if (clickEventType == 2.3D) {
/* 149 */         menuStateIs2_back();
/*     */       } 
/* 152 */       if (clickEventType == 3.1D) {
/* 153 */         menuStateIs3_yes();
/* 154 */       } else if (clickEventType == 3.2D) {
/* 155 */         menuStateIs3_no();
/*     */       } 
/* 158 */       if (clickEventType == 4.1D) {
/* 159 */         menuStateIs4_autoSave();
/* 160 */       } else if (clickEventType == 4.2D) {
/* 161 */         menuStateIs4_addOns();
/*     */       } 
/* 164 */       if (clickEventType == 5.1D) {
/*     */         try {
/* 166 */           if (currentProfile == 1) {
/* 167 */             menuStateIs5_createProfile(Save.save1, Game.save1Path);
/* 168 */           } else if (currentProfile == 2) {
/* 169 */             menuStateIs5_createProfile(Save.save2, Game.save2Path);
/* 170 */           } else if (currentProfile == 3) {
/* 171 */             menuStateIs5_createProfile(Save.save3, Game.save3Path);
/*     */           } 
/* 173 */         } catch (IOException e) {
/* 174 */           e.printStackTrace();
/*     */         } 
/* 176 */       } else if (clickEventType == 5.2D) {
/* 177 */         currentProfile = 0;
/* 178 */         MouseManager.mouseFullClick = 0;
/* 179 */         menuState = 2;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void drawProfile(Graphics g, int state, int renderX, int renderY, String lastPlayed, String created, File file, int profileProgress, int profileNumber, String name, FontMetrics fm) {
/* 187 */     g.drawImage(this.im.profileSquare, renderX, renderY, 
/* 188 */         this.im.profileSquare.getWidth(), this.im.profileSquare.getHeight(), null);
/* 189 */     if (file.exists()) {
/* 190 */       g.setColor(Game.gameProgressColor);
/* 191 */       g.setFont(Game.gameProgressFont);
/* 192 */       g.drawString(
/* 193 */           String.valueOf(profileProgress) + "%", 
/* 194 */           this.im.profileSquare.getWidth() / 2 + 275 - 
/* 195 */           fm.stringWidth(String.valueOf(profileProgress) + "%") / 2, 
/* 196 */           profileNumber * 110);
/* 197 */     } else if (!file.exists()) {
/* 198 */       g.setColor(Game.gameProgressColor);
/* 199 */       g.setFont(Game.gameProgressFont);
/* 200 */       g.drawString("?", this.im.profileSquare.getWidth() / 2 + renderX - 
/* 201 */           fm.stringWidth("?") / 2, profileNumber * 110);
/*     */     } 
/* 203 */     if (currentProfile == profileNumber) {
/* 204 */       g.setColor(Color.white);
/*     */     } else {
/* 206 */       g.setColor(Game.profileInfoColor);
/*     */     } 
/* 208 */     g.setFont(Game.profileNameFont);
/* 209 */     g.drawString(name, 380, profileNumber * 110 - 40);
/* 210 */     g.setFont(Game.profileInfoFont);
/* 211 */     g.drawString("Last Played: " + lastPlayed, 380, 
/* 212 */         profileNumber * 110 - 40 + 33);
/* 213 */     g.drawString("Date Created: " + created, 380, 
/* 214 */         profileNumber * 110 - 40 + 66);
/*     */   }
/*     */   
/*     */   public static void enterGame() {
/* 219 */     Game.isInGame = true;
/* 220 */     menuState = 0;
/*     */   }
/*     */   
/*     */   public void tick() {
/* 227 */     if (menuState == 2)
/* 228 */       profileTick(); 
/*     */   }
/*     */   
/*     */   public void profileTick() {
/* 248 */     if (!Save.save1.exists())
/* 249 */       save1Name = "Play To Create Me"; 
/* 252 */     if (!Save.save2.exists())
/* 253 */       save2Name = "Play To Create Me"; 
/* 256 */     if (!Save.save3.exists())
/* 257 */       save3Name = "Play To Create Me"; 
/* 261 */     if (save1State == 3 || save2State == 3 || save3State == 3) {
/* 262 */       canPlayProfile = true;
/* 264 */     } else if (save1State == 0 && save2State == 0 && save3State == 0) {
/* 265 */       canPlayProfile = false;
/*     */     } 
/* 270 */     if (currentProfile == 0)
/* 271 */       canDeleteProfile = false; 
/* 274 */     if (currentProfile == 1 && !Save.save1.exists()) {
/* 275 */       canDeleteProfile = false;
/* 276 */     } else if (currentProfile == 1 && Save.save1.exists()) {
/* 277 */       canDeleteProfile = true;
/*     */     } 
/* 280 */     if (currentProfile == 2 && !Save.save2.exists()) {
/* 281 */       canDeleteProfile = false;
/* 282 */     } else if (currentProfile == 2 && Save.save2.exists()) {
/* 283 */       canDeleteProfile = true;
/*     */     } 
/* 286 */     if (currentProfile == 3 && !Save.save3.exists()) {
/* 287 */       canDeleteProfile = false;
/* 288 */     } else if (currentProfile == 3 && Save.save3.exists()) {
/* 289 */       canDeleteProfile = true;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void renderMain(Graphics g) {
/* 297 */     g.setColor(Game.skyColor);
/* 298 */     g.fillRect(0, 0, 838, 573);
/* 301 */     CloudThread.drawCloud(g, 1, this.im.cloud1);
/* 302 */     CloudThread.drawCloud(g, 2, this.im.cloud2);
/* 303 */     CloudThread.drawCloud(g, 3, this.im.cloud3);
/* 305 */     if (menuState == 1) {
/* 306 */       renderState1(g);
/* 307 */     } else if (menuState == 2) {
/* 308 */       renderState2(g);
/* 309 */     } else if (menuState == 3) {
/* 310 */       renderState3(g);
/* 311 */     } else if (menuState == 4) {
/* 312 */       renderState4(g);
/* 313 */     } else if (menuState == 5) {
/* 314 */       renderState5(g);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void renderState1(Graphics g) {
/* 326 */     g.drawImage(Game.logoImage, 419 - Game.logoImage.getWidth(), 
/* 327 */         -125, 512, 512, null);
/* 330 */     g.setFont(Game.buttonTextFont);
/* 331 */     g.setColor(Color.white);
/* 332 */     g.drawString(Game.title, 5, 535);
/* 333 */     g.drawString(Game.copyright, 659, 535);
/* 336 */     drawButton(g, playState, 251, 264, 336, 32, "Play", 
/* 337 */         this.im.button2_1, this.im.button2_2, this.im.button2_3, 1.1D);
/* 340 */     drawButton(g, optionsState, 251, 312, 
/* 341 */         this.im.button2_1.getWidth(), this.im.button2_1.getHeight(), "Options", 
/* 342 */         this.im.button2_1, this.im.button2_2, this.im.button2_3, 1.2D);
/*     */   }
/*     */   
/*     */   public void renderState2(Graphics g) {
/* 350 */     this.fm = g.getFontMetrics(Game.gameProgressFont);
/* 352 */     g.setFont(Game.profileInfoFont);
/* 353 */     g.setColor(Game.profileInfoColor);
/* 357 */     if (save1State == 3) {
/* 358 */       g.drawImage(this.im.profileSelection, 268, 43, 300, 117, null);
/* 359 */       currentProfile = 1;
/* 360 */     } else if (save2State == 3) {
/* 361 */       g.drawImage(this.im.profileSelection, 268, 153, 300, 117, null);
/* 362 */       currentProfile = 2;
/* 363 */     } else if (save3State == 3) {
/* 364 */       g.drawImage(this.im.profileSelection, 268, 263, 300, 117, null);
/* 365 */       currentProfile = 3;
/*     */     } 
/* 368 */     drawProfile(g, save1State, 275, 50, 
/* 369 */         Save.save1LastPlayed, Save.save1Made, Save.save1, 
/* 370 */         Save.save1Progress, 1, save1Name, this.fm);
/* 372 */     drawProfile(g, save2State, 275, 160, 
/* 373 */         Save.save2LastPlayed, Save.save2Made, Save.save2, 
/* 374 */         Save.save2Progress, 2, save2Name, this.fm);
/* 376 */     drawProfile(g, save3State, 275, 270, 
/* 377 */         Save.save3LastPlayed, Save.save3Made, Save.save3, 
/* 378 */         Save.save3Progress, 3, save3Name, this.fm);
/* 382 */     if (canPlayProfile) {
/* 383 */       drawButton(g, playSelectedState, 
/* 384 */           419 - this.im.button2_1.getWidth() / 2, 425, 
/* 385 */           this.im.button2_1.getWidth(), this.im.button2_1.getHeight(), 
/* 386 */           "Play Selected Profile", this.im.button2_1, this.im.button2_2, 
/* 387 */           this.im.button2_3, 2.1D);
/* 388 */     } else if (!canPlayProfile) {
/* 389 */       g.setFont(Game.buttonTextFont);
/* 390 */       g.drawImage(this.im.button2_3, 419 - 
/* 391 */           this.im.button2_3.getWidth() / 2, 425, 
/* 392 */           this.im.button2_3.getWidth(), this.im.button2_3.getHeight(), null);
/* 393 */       g.setColor(Game.buttonClickedColor);
/* 394 */       g.drawString("Play Selected Profile", 324, 446);
/*     */     } 
/* 399 */     if (canDeleteProfile) {
/* 400 */       drawButton(g, deleteState, 419 - 
/* 401 */           this.im.button2_1.getWidth() / 2, 473, 
/* 402 */           this.im.button1_1.getWidth(), this.im.button1_1.getHeight(), 
/* 403 */           "Delete", this.im.button1_1, this.im.button1_2, this.im.button1_3, 2.2D);
/* 404 */     } else if (!canDeleteProfile) {
/* 405 */       g.setFont(Game.buttonTextFont);
/* 406 */       g.drawImage(this.im.button1_3, 419 - 
/* 407 */           this.im.button2_1.getWidth() / 2, 473, 
/* 408 */           this.im.button1_3.getWidth(), this.im.button1_3.getHeight(), null);
/* 409 */       g.setColor(Game.buttonClickedColor);
/* 410 */       g.drawString("Delete", 300, 
/* 411 */           473 + this.im.button1_3.getHeight() / 2 + 5);
/*     */     } 
/* 416 */     drawButton(g, cancelState, 419 - this.im.button2_1.getWidth() / 2 + 
/* 417 */         176, 473, this.im.button1_1.getWidth(), 
/* 418 */         this.im.button1_1.getHeight(), "Back", this.im.button1_1, this.im.button1_2, 
/* 419 */         this.im.button1_3, 2.3D);
/*     */   }
/*     */   
/*     */   public void renderState3(Graphics g) {
/* 427 */     g.setFont(Game.areYouSureFont);
/* 428 */     g.setColor(Game.profileInfoColor);
/* 429 */     g.drawString("Are you sure?", 280, 190);
/* 431 */     g.setFont(Game.buttonTextFont);
/* 433 */     drawButton(g, yesState, 215, 325, this.im.button1_1.getWidth(), 
/* 434 */         this.im.button1_1.getHeight(), "Yes", this.im.button1_1, this.im.button1_2, 
/* 435 */         this.im.button1_3, 3.1D);
/* 437 */     drawButton(g, noState, 454, 325, this.im.button1_1.getWidth(), 
/* 438 */         this.im.button1_1.getHeight(), "No", this.im.button1_1, this.im.button1_2, 
/* 439 */         this.im.button1_3, 3.2D);
/*     */   }
/*     */   
/*     */   public void renderState4(Graphics g) {
/* 448 */     drawButton(g, autoSaveState, 419 - 
/* 449 */         this.im.button2_1.getWidth() + 8, 100, this.im.button2_1.getWidth(), 
/* 450 */         this.im.button2_1.getHeight(), "Auto Save: " + autoSaveToggle, 
/* 451 */         this.im.button2_1, this.im.button2_2, this.im.button2_3, 4.1D);
/* 452 */     g.setColor(Game.profileInfoColor);
/* 453 */     g.setFont(Game.profileInfoFont);
/* 454 */     g.drawString("Turning this option on will enable automatic saving.", 
/* 455 */         72, 156);
/* 458 */     drawButton(g, addOnsState, 
/* 459 */         419 - this.im.button2_1.getWidth() / 2, 373, 
/* 460 */         this.im.button2_1.getWidth(), this.im.button2_1.getHeight(), 
/* 461 */         "Add-Ons...", this.im.button2_1, this.im.button2_2, this.im.button2_3, 4.2D);
/* 464 */     drawButton(g, cancelState, 419 - this.im.button1_1.getWidth() / 2, 
/* 465 */         473, this.im.button1_1.getWidth(), this.im.button1_1.getHeight(), 
/* 466 */         "Back", this.im.button1_1, this.im.button1_2, this.im.button1_3, 2.3D);
/*     */   }
/*     */   
/*     */   public void renderState5(Graphics g) {
/* 473 */     this.fm = g.getFontMetrics(Game.buttonTextFont);
/* 475 */     textBoxState = getGeneralImageState(
/* 476 */         419 - this.im.button2_1.getWidth() / 2 + 1, 91, 
/* 477 */         this.im.button2_1.getWidth() - 1, this.im.button2_1.getHeight() - 1, 
/* 478 */         textBoxState);
/* 481 */     g.setColor(Game.profileInfoColor);
/* 482 */     g.setFont(Game.profileInfoFont);
/* 484 */     g.drawString("Enter a name for the profile:", 250, 78);
/* 485 */     g.drawString(
/* 486 */         "If left blank, the name will default to Profile 1, 2, or 3.", 
/* 487 */         250, 147);
/* 488 */     g.setColor(new Color(232, 232, 232));
/* 489 */     g.setFont(Game.buttonTextFont);
/* 491 */     g.drawRect(419 - this.im.button2_1.getWidth() / 2, 90, 
/* 492 */         this.im.button2_1.getWidth(), this.im.button2_1.getHeight());
/* 493 */     g.drawRect(419 - this.im.button2_1.getWidth() / 2 - 1, 89, 
/* 494 */         this.im.button2_1.getWidth() + 2, this.im.button2_1.getHeight() + 2);
/* 495 */     g.setColor(new Color(0, 0, 0, 180));
/* 497 */     g.fillRect(419 - this.im.button2_1.getWidth() / 2 + 1, 91, 
/* 498 */         this.im.button2_1.getWidth() - 1, this.im.button2_1.getHeight() - 1);
/* 500 */     g.setFont(Game.buttonTextFont);
/* 501 */     g.setColor(Color.white);
/* 502 */     if (currentProfile == 1) {
/* 503 */       g.drawString(save1Name, 258, 113);
/* 504 */       g.drawString("_", 258 + this.fm.stringWidth(save1Name), 113);
/* 505 */     } else if (currentProfile == 2) {
/* 506 */       g.drawString(save2Name, 258, 113);
/* 507 */       g.drawString("_", 258 + this.fm.stringWidth(save2Name), 113);
/* 508 */     } else if (currentProfile == 3) {
/* 509 */       g.drawString(save3Name, 258, 113);
/* 510 */       g.drawString("_", 258 + this.fm.stringWidth(save3Name), 113);
/*     */     } 
/* 512 */     if (textBoxState == 2) {
/* 513 */       isTyping = true;
/*     */     } else {
/* 515 */       isTyping = false;
/*     */     } 
/* 518 */     drawButton(g, createProfileState, 
/* 519 */         419 - this.im.button2_1.getWidth() / 2, 437, 
/* 520 */         this.im.button1_1.getWidth(), this.im.button1_1.getHeight(), 
/* 521 */         "Create Profile", this.im.button1_1, this.im.button1_2, this.im.button1_3, 5.1D);
/* 524 */     drawButton(
/* 525 */         g, 
/* 526 */         cancelState, 
/* 527 */         419 - 
/* 528 */         this.im.button2_1.getWidth() / 2 - this.im.button1_1
/* 529 */         .getWidth() + 16, 437, 
/* 530 */         this.im.button1_1.getWidth(), this.im.button1_1.getHeight(), "Back", 
/* 531 */         this.im.button1_1, this.im.button1_2, this.im.button1_3, 5.2D);
/*     */   }
/*     */   
/*     */   public void menuStateIs1_play() {
/* 538 */     menuState = 2;
/* 539 */     Load.loadData1(Game.dataPath);
/*     */   }
/*     */   
/*     */   public void menuStateIs1_options() {
/* 543 */     menuState = 4;
/* 544 */     Load.loadData1(Game.dataPath);
/* 545 */     if (autoSaveToggle == "On" && !Game.autoSave) {
/* 546 */       autoSaveToggle = "Off";
/* 547 */     } else if (autoSaveToggle == "Off" && Game.autoSave) {
/* 548 */       autoSaveToggle = "On";
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void menuStateIs2_playProfile() throws IOException {
/* 554 */     if (currentProfile == 1) {
/* 555 */       if (Save.save1.exists()) {
/* 556 */         Load.loadProfile(Game.save1Path);
/* 557 */         Save.profileSave(Save.save1, Game.save1Path, 1);
/* 558 */         enterGame();
/* 559 */       } else if (!Save.save1.exists()) {
/* 560 */         save1Name = "";
/* 561 */         cancelState = 0;
/* 562 */         menuState = 5;
/*     */       } 
/* 564 */     } else if (currentProfile == 2) {
/* 565 */       if (Save.save2.exists()) {
/* 566 */         Load.loadProfile(Game.save2Path);
/* 567 */         Save.profileSave(Save.save2, Game.save2Path, 2);
/* 568 */         enterGame();
/* 569 */       } else if (!Save.save2.exists()) {
/* 570 */         save2Name = "";
/* 571 */         cancelState = 0;
/* 572 */         menuState = 5;
/*     */       } 
/* 574 */     } else if (currentProfile == 3) {
/* 575 */       if (Save.save3.exists()) {
/* 576 */         Load.loadProfile(Game.save3Path);
/* 577 */         Save.profileSave(Save.save3, Game.save3Path, 3);
/* 578 */         enterGame();
/* 579 */       } else if (!Save.save3.exists()) {
/* 580 */         save3Name = "";
/* 581 */         cancelState = 0;
/* 582 */         menuState = 5;
/*     */       } 
/*     */     } 
/* 585 */     MouseManager.mouseFullClick = 0;
/* 586 */     save1State = 0;
/* 587 */     save2State = 0;
/* 588 */     save3State = 0;
/*     */   }
/*     */   
/*     */   public void menuStateIs2_deleteProfile() throws IOException {
/* 594 */     if (currentProfile == 1) {
/* 595 */       Save.save1.delete();
/* 596 */       Save.save1Made = "";
/* 597 */       Save.save1LastPlayed = "";
/* 598 */       Save.dataSave();
/* 599 */     } else if (currentProfile == 2) {
/* 600 */       Save.save2.delete();
/* 601 */       Save.save2Made = "";
/* 602 */       Save.save2LastPlayed = "";
/* 603 */       Save.dataSave();
/* 604 */     } else if (currentProfile == 3) {
/* 605 */       Save.save3.delete();
/* 606 */       Save.save3Made = " ";
/* 607 */       Save.save3LastPlayed = " ";
/* 608 */       Save.dataSave();
/*     */     } 
/* 611 */     menuState = 2;
/* 612 */     currentProfile = 0;
/*     */   }
/*     */   
/*     */   public void menuStateIs2_back() {
/* 617 */     save1State = 0;
/* 618 */     save2State = 0;
/* 619 */     save3State = 0;
/* 620 */     currentProfile = 0;
/* 621 */     menuState = 1;
/*     */   }
/*     */   
/*     */   public void menuStateIs3_yes() {
/*     */     try {
/* 627 */       menuStateIs2_deleteProfile();
/* 628 */     } catch (IOException e) {
/* 629 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void menuStateIs3_no() {
/* 636 */     menuState = 2;
/*     */   }
/*     */   
/*     */   public void menuStateIs4_autoSave() {
/* 642 */     if (autoSaveToggle == "On") {
/* 643 */       autoSaveToggle = "Off";
/* 644 */       Game.autoSave = false;
/* 645 */     } else if (autoSaveToggle == "Off") {
/* 646 */       autoSaveToggle = "On";
/* 647 */       Game.autoSave = true;
/*     */     } 
/* 649 */     MouseManager.mouseFullClick = 0;
/*     */     try {
/* 651 */       Save.dataSave();
/* 652 */     } catch (IOException e) {
/* 653 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void menuStateIs4_addOns() {}
/*     */   
/*     */   public void menuStateIs5_createProfile(File save, String path) throws IOException {
/* 664 */     if (currentProfile == 1 && save1Name.length() == 0) {
/* 665 */       save1Name = "Profile 1";
/* 666 */     } else if (currentProfile == 2 && save2Name.length() == 0) {
/* 667 */       save2Name = "Profile 2";
/* 668 */     } else if (currentProfile == 3 && save3Name.length() == 0) {
/* 669 */       save3Name = "Profile 3";
/*     */     } 
/* 671 */     Save.reset();
/* 672 */     Save.profileSave(save, path, currentProfile);
/* 673 */     Save.dataSave();
/* 674 */     enterGame();
/* 675 */     createProfileState = 0;
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_1.jar!\beyondOrigins\main\menus\MainMenu.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */