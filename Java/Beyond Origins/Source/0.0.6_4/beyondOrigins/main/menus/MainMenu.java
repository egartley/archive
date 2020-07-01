/*     */ package beyondOrigins.main.menus;
/*     */ 
/*     */ import beyondOrigins.files.Load;
/*     */ import beyondOrigins.files.Save;
/*     */ import beyondOrigins.main.Game;
/*     */ import beyondOrigins.main.entities.Cloud;
/*     */ import beyondOrigins.main.entities.TestDummy;
/*     */ import beyondOrigins.main.gfx.ImageManager;
/*     */ import beyondOrigins.main.windows.ProfileCreator;
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
/*     */   private FontMetrics fm;
/*     */   
/*     */   private FontMetrics fm2;
/*     */   
/*  26 */   public byte menuState = 1;
/*     */   
/*     */   public byte state;
/*     */   
/*     */   public Cloud cloud1;
/*     */   
/*     */   public Cloud cloud2;
/*     */   
/*     */   public Cloud cloud3;
/*     */   
/*  34 */   public byte currentProfile = 0;
/*     */   
/*     */   public boolean canPlayProfile = false;
/*     */   
/*     */   public boolean canDeleteProfile = false;
/*     */   
/*     */   public byte cancelState;
/*     */   
/*     */   public byte save1State;
/*     */   
/*     */   public byte save2State;
/*     */   
/*     */   public byte save3State;
/*     */   
/*  39 */   public String save1Name = "IfYouSeeThisSomethingIsWrong";
/*     */   
/*  40 */   public String save2Name = "IfYouSeeThisSomethingIsWrong";
/*     */   
/*  41 */   public String save3Name = "IfYouSeeThisSomethingIsWrong";
/*     */   
/*     */   public String save1Name_backup;
/*     */   
/*     */   public String save2Name_backup;
/*     */   
/*     */   public String save3Name_backup;
/*     */   
/*     */   public boolean enterProfile = false;
/*     */   
/*     */   public byte yesState;
/*     */   
/*     */   public byte noState;
/*     */   
/*     */   public byte profileNameBoxState;
/*     */   
/*     */   public byte playerNameBoxState;
/*     */   
/*     */   public boolean profileNameBoxInFocus = false;
/*     */   
/*     */   public boolean playerNameBoxInFocus = false;
/*     */   
/*     */   private Options o;
/*     */   
/*     */   private ProfileCreator proc;
/*     */   
/*     */   public MainMenu() {
/*  59 */     this.proc = new ProfileCreator();
/*  60 */     this.cloud1 = new Cloud(-195.0D, 135.0D);
/*  61 */     this.cloud2 = new Cloud(1033.0D, (286 - 
/*  62 */         ImageManager.cloud1.getHeight() / 2));
/*  63 */     this.cloud3 = new Cloud(-155.0D, 378.0D);
/*     */   }
/*     */   
/*     */   private byte getButtonState(int x, int y, int width, int height, byte state) {
/*  72 */     if (MouseMotion.mouseX >= x && MouseMotion.mouseX < x + width && 
/*  73 */       MouseMotion.mouseY >= y && MouseMotion.mouseY < y + height) {
/*  74 */       state = 2;
/*  75 */       if (Game.mouseIsPressed()) {
/*  76 */         state = 3;
/*     */       } else {
/*  78 */         state = 2;
/*     */       } 
/*     */     } else {
/*  80 */       state = 1;
/*     */     } 
/*  81 */     return state;
/*     */   }
/*     */   
/*     */   private void drawButton(Graphics g, int x, int y, int width, int height, String buttonText, BufferedImage state1Image, BufferedImage state2Image, BufferedImage state3Image, double clickEventType) {
/* 114 */     this.fm = g.getFontMetrics(Game.buttonTextFont);
/* 116 */     g.setFont(Game.buttonTextFont);
/* 117 */     if (getButtonState(x, y, width, height, this.state) == 1) {
/* 118 */       g.drawImage(state1Image, x, y, width, height, null);
/* 119 */       g.setColor(Game.buttonIdleColor);
/* 120 */       g.drawString(
/* 121 */           buttonText, 
/* 122 */           x + state1Image.getWidth() / 2 - 
/* 123 */           this.fm.stringWidth(buttonText) / 2, y + 
/* 124 */           state1Image.getHeight() / 2 + 5);
/* 125 */     } else if (getButtonState(x, y, width, height, this.state) == 2) {
/* 126 */       g.drawImage(state2Image, x, y, width, height, null);
/* 127 */       g.setColor(Game.buttonSelectedColor);
/* 128 */       g.drawString(
/* 129 */           buttonText, 
/* 130 */           x + state1Image.getWidth() / 2 - 
/* 131 */           this.fm.stringWidth(buttonText) / 2, y + 
/* 132 */           state1Image.getHeight() / 2 + 5);
/* 133 */     } else if (getButtonState(x, y, width, height, this.state) == 3) {
/* 134 */       g.drawImage(state3Image, x, y, width, height, null);
/* 135 */       g.setColor(Game.buttonClickedColor);
/* 136 */       g.drawString(
/* 137 */           buttonText, 
/* 138 */           x + state1Image.getWidth() / 2 - 
/* 139 */           this.fm.stringWidth(buttonText) / 2, y + 
/* 140 */           state1Image.getHeight() / 2 + 5);
/* 141 */       clickEventHandler(clickEventType);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void clickEventHandler(double e) {
/* 147 */     if (e == 1.1D) {
/* 148 */       m1Play();
/* 149 */     } else if (e == 1.2D) {
/* 150 */       m1Options();
/* 151 */     } else if (e != 1.3D) {
/* 153 */       if (e == 1.4D)
/* 154 */         m1Quit(); 
/*     */     } 
/* 157 */     if (e == 2.1D) {
/*     */       try {
/* 159 */         m2PlayProfile();
/* 160 */       } catch (IOException ei) {
/* 161 */         ei.printStackTrace();
/*     */       } 
/* 163 */     } else if (e == 2.2D) {
/* 164 */       this.menuState = 3;
/* 165 */     } else if (e == 2.3D) {
/* 166 */       m2Back();
/*     */     } 
/* 169 */     if (e == 3.1D) {
/* 170 */       m3Yes();
/* 171 */     } else if (e == 3.2D) {
/* 172 */       m3No();
/*     */     } 
/* 175 */     if (e == 5.1D) {
/*     */       try {
/* 177 */         if (this.currentProfile == 1) {
/* 178 */           m5CreateProfile(Save.save1, Game.save1Path);
/* 179 */         } else if (this.currentProfile == 2) {
/* 180 */           m5CreateProfile(Save.save2, Game.save2Path);
/* 181 */         } else if (this.currentProfile == 3) {
/* 182 */           m5CreateProfile(Save.save3, Game.save3Path);
/*     */         } 
/* 184 */       } catch (IOException ei) {
/* 185 */         ei.printStackTrace();
/*     */       } 
/* 187 */     } else if (e == 5.2D) {
/* 188 */       Game.endClick();
/* 189 */       this.menuState = 2;
/* 190 */       this.currentProfile = 0;
/*     */     } 
/* 193 */     if (e == 6.1D) {
/* 194 */       Game.getPlayer().respawn();
/* 195 */     } else if (e == 6.2D) {
/* 196 */       (Game.getPlayer()).health = (Game.getPlayer()).maxHealth;
/*     */       try {
/* 198 */         if (this.currentProfile == 1)
/* 199 */           Save.profileSave(Save.save1, Game.save1Path, 1); 
/* 200 */         if (this.currentProfile == 2)
/* 201 */           Save.profileSave(Save.save2, Game.save2Path, 2); 
/* 202 */         if (this.currentProfile == 3)
/* 203 */           Save.profileSave(Save.save3, Game.save3Path, 3); 
/* 204 */         Save.dataSave();
/* 205 */       } catch (IOException e1) {
/* 206 */         e1.printStackTrace();
/*     */       } 
/* 208 */       Game.endClick();
/* 209 */       this.menuState = 1;
/* 210 */       this.currentProfile = 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void drawProfile(Graphics g, byte state, int x, int y, String lastPlayed, String created, File file, int profileNumber, String name, FontMetrics fm) {
/* 217 */     g.drawImage(ImageManager.profileSquare, x, y, 
/* 218 */         ImageManager.profileSquare.getWidth(), 
/* 219 */         ImageManager.profileSquare.getHeight(), null);
/* 220 */     g.setColor(Game.gameProgressColor);
/* 221 */     g.setFont(Game.gameProgressFont);
/* 222 */     if (file.exists()) {
/* 223 */       g.drawImage(ImageManager.playerd1, 
/* 224 */           ImageManager.profileSquare.getWidth() / 2 + x - 
/* 225 */           ImageManager.playerd1.getWidth(), 
/* 226 */           y + ImageManager.profileSquare.getHeight() / 2 - 
/* 227 */           ImageManager.playerd1.getHeight(), 64, 64, null);
/* 228 */     } else if (!file.exists()) {
/* 229 */       g.drawString("?", ImageManager.profileSquare.getWidth() / 2 + x - 
/* 230 */           fm.stringWidth("?") / 2, profileNumber * 110);
/*     */     } 
/* 232 */     if (this.currentProfile == profileNumber) {
/* 233 */       g.setColor(Color.white);
/*     */     } else {
/* 235 */       g.setColor(Game.profileInfoColor);
/*     */     } 
/* 237 */     g.setFont(Game.profileNameFont);
/* 238 */     g.drawString(name, 380, profileNumber * 110 - 40);
/* 239 */     g.setFont(Game.profileInfoFont);
/* 240 */     g.drawString("Last Played: " + lastPlayed, 380, 
/* 241 */         profileNumber * 110 - 40 + 33);
/* 242 */     g.drawString("Date Created: " + created, 380, 
/* 243 */         profileNumber * 110 - 40 + 66);
/*     */   }
/*     */   
/*     */   public void setCurrentProfile(int i) {
/* 316 */     if (i == 1) {
/* 317 */       this.save1State = 3;
/* 318 */       this.save2State = 0;
/* 319 */       this.save3State = 0;
/* 320 */     } else if (i == 2) {
/* 321 */       this.save1State = 0;
/* 322 */       this.save2State = 3;
/* 323 */       this.save3State = 0;
/* 324 */     } else if (i == 3) {
/* 325 */       this.save1State = 0;
/* 326 */       this.save2State = 0;
/* 327 */       this.save3State = 3;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void enterGame() {
/* 332 */     System.out.println("Entering game...");
/* 333 */     Game.isInGame = true;
/* 334 */     this.menuState = 0;
/* 335 */     KeyManager.enterPressed = false;
/* 336 */     (Game.getPlayer()).up = false;
/* 337 */     (Game.getPlayer()).down = false;
/* 338 */     (Game.getPlayer()).left = false;
/* 339 */     (Game.getPlayer()).right = false;
/* 340 */     Game.getPlayer().healthBarCheck();
/* 341 */     System.out.println("Game entered!");
/*     */   }
/*     */   
/*     */   public void tick() {
/* 348 */     this.cloud1.tick(Game.width, 0.3D, 1);
/* 349 */     this.cloud2.tick(-155, 0.4D, 0);
/* 350 */     this.cloud3.tick(Game.width + 145, 0.2D, 1);
/*     */   }
/*     */   
/*     */   private void profileCheck() {
/* 356 */     if (!Save.save1.exists()) {
/* 357 */       this.save1Name = "Play To Create Me";
/* 358 */     } else if (Save.save1.exists()) {
/* 359 */       this.save1Name = this.save1Name_backup;
/*     */     } 
/* 362 */     if (!Save.save2.exists()) {
/* 363 */       this.save2Name = "Play To Create Me";
/* 364 */     } else if (Save.save2.exists()) {
/* 365 */       this.save2Name = this.save2Name_backup;
/*     */     } 
/* 368 */     if (!Save.save3.exists()) {
/* 369 */       this.save3Name = "Play To Create Me";
/* 370 */     } else if (Save.save3.exists()) {
/* 371 */       this.save3Name = this.save3Name_backup;
/*     */     } 
/* 374 */     if (this.save1State == 3 || this.save2State == 3 || this.save3State == 3) {
/* 375 */       this.canPlayProfile = true;
/* 376 */     } else if (this.save1State == 0 && this.save2State == 0 && this.save3State == 0) {
/* 377 */       this.canPlayProfile = false;
/*     */     } 
/* 380 */     if ((this.currentProfile == 1 && !Save.save1.exists()) || (
/* 381 */       this.currentProfile == 2 && !Save.save2.exists()) || (
/* 382 */       this.currentProfile == 3 && !Save.save3.exists()) || 
/* 383 */       this.currentProfile == 0) {
/* 384 */       this.canDeleteProfile = false;
/* 385 */     } else if ((this.currentProfile == 1 && Save.save1.exists()) || (
/* 386 */       this.currentProfile == 2 && Save.save2.exists()) || (
/* 387 */       this.currentProfile == 3 && Save.save3.exists())) {
/* 388 */       this.canDeleteProfile = true;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render(Graphics g) {
/* 395 */     g.setColor(Game.skyColor);
/* 396 */     g.fillRect(0, 0, Game.width, Game.height);
/* 398 */     this.cloud1.render(g);
/* 399 */     this.cloud2.render(g);
/* 400 */     this.cloud3.render(g);
/* 402 */     if (this.menuState == 1) {
/* 403 */       renderState1(g);
/* 404 */     } else if (this.menuState == 2) {
/* 405 */       renderState2(g);
/* 406 */     } else if (this.menuState == 3) {
/* 407 */       renderState3(g);
/* 408 */     } else if (this.menuState == 4) {
/* 409 */       renderState4(g);
/* 410 */     } else if (this.menuState != 5) {
/* 412 */       if (this.menuState == 6)
/* 413 */         renderState6(g); 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void renderState1(Graphics g) {
/* 422 */     this.fm = g.getFontMetrics(Game.profileInfoFont);
/* 423 */     this.fm2 = g.getFontMetrics(Game.buttonTextFont);
/* 426 */     g.drawImage(Game.logoImage, 
/* 427 */         Game.width / 2 - Game.logoImage.getWidth(), Game.height / 2 - 
/* 428 */         Game.logoImage.getWidth() - 45, 
/* 429 */         Game.logoImage.getWidth() * 2, Game.logoImage.getHeight() * 2, 
/* 430 */         null);
/* 433 */     g.setFont(Game.profileInfoFont);
/* 434 */     g.setColor(Game.profileInfoColor);
/* 435 */     g.drawString(Game.identifer, 
/* 436 */         Game.width / 2 - this.fm.stringWidth(Game.identifer) / 2, 
/* 437 */         Game.height / 2 + 48 + 110);
/* 440 */     g.setFont(Game.buttonTextFont);
/* 441 */     g.setColor(Color.white);
/* 442 */     g.drawString(Game.title, 5, Game.height - 13);
/* 443 */     g.drawString(Game.copyright, 
/* 444 */         Game.width - this.fm2.stringWidth(Game.copyright) + 10, 
/* 445 */         Game.height - 13);
/* 448 */     drawButton(g, Game.width / 2 - 168, Game.height / 2, 336, 32, "Play", 
/* 449 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 450 */         ImageManager.button2_3, 1.1D);
/* 453 */     drawButton(g, Game.width / 2 - 168, Game.height / 2 + 48, 
/* 454 */         ImageManager.button2_1.getWidth(), 
/* 455 */         ImageManager.button2_1.getHeight(), "Options", 
/* 456 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 457 */         ImageManager.button2_3, 1.2D);
/* 460 */     drawButton(g, Game.width / 2 - 168, Game.height / 2 + 48 + 48, 
/* 461 */         ImageManager.button2_1.getWidth(), 
/* 462 */         ImageManager.button2_1.getHeight(), "Quit Game", 
/* 463 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 464 */         ImageManager.button2_3, 1.4D);
/*     */   }
/*     */   
/*     */   private void renderState2(Graphics g) {
/* 472 */     this.fm = g.getFontMetrics(Game.gameProgressFont);
/* 474 */     g.setFont(Game.profileInfoFont);
/* 475 */     g.setColor(Game.profileInfoColor);
/* 479 */     if (this.save1State == 3) {
/* 480 */       g.drawImage(ImageManager.profileSelection, Game.width / 2 - 150, 
/* 481 */           43, 300, 117, null);
/* 482 */       this.currentProfile = 1;
/* 483 */       profileCheck();
/* 484 */     } else if (this.save2State == 3) {
/* 485 */       g.drawImage(ImageManager.profileSelection, Game.width / 2 - 150, 
/* 486 */           153, 300, 117, null);
/* 487 */       this.currentProfile = 2;
/* 488 */       profileCheck();
/* 489 */     } else if (this.save3State == 3) {
/* 490 */       g.drawImage(ImageManager.profileSelection, Game.width / 2 - 150, 
/* 491 */           263, 300, 117, null);
/* 492 */       this.currentProfile = 3;
/* 493 */       profileCheck();
/*     */     } 
/* 498 */     drawProfile(g, this.save1State, Game.width / 2 - 144, 50, 
/* 499 */         Save.save1LastPlayed, Save.save1Made, Save.save1, 1, this.save1Name, 
/* 500 */         this.fm);
/* 502 */     drawProfile(g, this.save2State, Game.width / 2 - 144, 160, 
/* 503 */         Save.save2LastPlayed, Save.save2Made, Save.save2, 2, this.save2Name, 
/* 504 */         this.fm);
/* 506 */     drawProfile(g, this.save3State, Game.width / 2 - 144, 270, 
/* 507 */         Save.save3LastPlayed, Save.save3Made, Save.save3, 3, this.save3Name, 
/* 508 */         this.fm);
/* 510 */     this.fm2 = g.getFontMetrics(Game.buttonTextFont);
/* 514 */     if (this.canPlayProfile) {
/* 515 */       drawButton(g, Game.width / 2 - 
/* 516 */           ImageManager.button2_1.getWidth() / 2, 425, 
/* 517 */           ImageManager.button2_1.getWidth(), 
/* 518 */           ImageManager.button2_1.getHeight(), "Play Profile", 
/* 519 */           ImageManager.button2_1, ImageManager.button2_2, 
/* 520 */           ImageManager.button2_3, 2.1D);
/* 521 */     } else if (!this.canPlayProfile) {
/* 522 */       g.setFont(Game.buttonTextFont);
/* 523 */       g.drawImage(ImageManager.button2_3, Game.width / 2 - 
/* 524 */           ImageManager.button2_3.getWidth() / 2, 425, 
/* 525 */           ImageManager.button2_3.getWidth(), 
/* 526 */           ImageManager.button2_3.getHeight(), null);
/* 527 */       g.setColor(Game.buttonClickedColor);
/* 528 */       g.drawString("Play Profile", 
/* 529 */           Game.width / 2 - this.fm2.stringWidth("Play Profile") / 2, 
/* 530 */           446);
/*     */     } 
/* 535 */     if (this.canDeleteProfile) {
/* 536 */       drawButton(g, Game.width / 2 - 
/* 537 */           ImageManager.button2_1.getWidth() / 2, 473, 
/* 538 */           ImageManager.button1_1.getWidth(), 
/* 539 */           ImageManager.button1_1.getHeight(), "Delete", 
/* 540 */           ImageManager.button1_1, ImageManager.button1_2, 
/* 541 */           ImageManager.button1_3, 2.2D);
/* 542 */     } else if (!this.canDeleteProfile) {
/* 543 */       g.setFont(Game.buttonTextFont);
/* 544 */       g.drawImage(ImageManager.button1_3, Game.width / 2 - 
/* 545 */           ImageManager.button2_1.getWidth() / 2, 473, 
/* 546 */           ImageManager.button1_3.getWidth(), 
/* 547 */           ImageManager.button1_3.getHeight(), null);
/* 548 */       g.setColor(Game.buttonClickedColor);
/* 549 */       g.drawString(
/* 550 */           "Delete", 
/* 551 */           Game.width / 2 - ImageManager.button1_1.getWidth() / 2 - 8 - 
/* 552 */           this.fm2.stringWidth("Delete") / 2, 
/* 553 */           473 + ImageManager.button1_3.getHeight() / 2 + 5);
/*     */     } 
/* 558 */     drawButton(g, Game.width / 2 - 
/* 559 */         ImageManager.button2_1.getWidth() / 2 + 176, 473, 
/* 560 */         ImageManager.button1_1.getWidth(), 
/* 561 */         ImageManager.button1_1.getHeight(), "Back", 
/* 562 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 563 */         ImageManager.button1_3, 2.3D);
/*     */   }
/*     */   
/*     */   private void renderState3(Graphics g) {
/* 571 */     g.setFont(Game.areYouSureFont);
/* 572 */     g.setColor(Game.profileInfoColor);
/* 573 */     g.drawString("Are you sure?", 280, 190);
/* 575 */     g.setFont(Game.buttonTextFont);
/* 577 */     drawButton(g, Game.width / 2 - 204, 325, 
/* 578 */         ImageManager.button1_1.getWidth(), 
/* 579 */         ImageManager.button1_1.getHeight(), "Yes", 
/* 580 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 581 */         ImageManager.button1_3, 3.1D);
/* 583 */     drawButton(g, Game.width / 2 + 35, 325, 
/* 584 */         ImageManager.button1_1.getWidth(), 
/* 585 */         ImageManager.button1_1.getHeight(), "No", 
/* 586 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 587 */         ImageManager.button1_3, 3.2D);
/*     */   }
/*     */   
/*     */   private void renderState4(Graphics g) {
/* 594 */     this.o.render(g);
/*     */   }
/*     */   
/*     */   private void renderState6(Graphics g) {
/* 653 */     g.setFont(Game.buttonTextFont);
/* 654 */     g.setColor(Game.profileInfoColor);
/* 656 */     this.fm = g.getFontMetrics(Game.buttonTextFont);
/* 658 */     g.drawString("You were killed!", 
/* 659 */         Game.width / 2 - this.fm.stringWidth("You were killed!") / 2, 
/* 660 */         200);
/* 662 */     drawButton(g, Game.width / 2 - 
/* 663 */         ImageManager.button2_1.getWidth() / 2, 275, 
/* 664 */         ImageManager.button2_1.getWidth(), 
/* 665 */         ImageManager.button2_1.getHeight(), "Respawn", 
/* 666 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 667 */         ImageManager.button2_3, 6.1D);
/* 669 */     drawButton(g, Game.width / 2 - 
/* 670 */         ImageManager.button2_1.getWidth() / 2, 323, 
/* 671 */         ImageManager.button2_1.getWidth(), 
/* 672 */         ImageManager.button2_1.getHeight(), "Save and Quit to Title", 
/* 673 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 674 */         ImageManager.button2_3, 6.2D);
/*     */   }
/*     */   
/*     */   private void m1Play() {
/* 681 */     Game.endClick();
/* 682 */     this.menuState = 2;
/* 683 */     Load.loadData(Game.dataPath);
/* 684 */     profileCheck();
/*     */   }
/*     */   
/*     */   private void m1Options() {
/* 688 */     this.menuState = 4;
/* 689 */     this.o = new Options();
/*     */   }
/*     */   
/*     */   private void m1Quit() {
/* 693 */     System.exit(0);
/*     */   }
/*     */   
/*     */   public void m2PlayProfile() throws IOException {
/* 697 */     if (this.currentProfile == 1) {
/* 698 */       if (Save.save1.exists()) {
/* 699 */         Load.loadProfile(Game.save1Path);
/* 700 */         Save.profileSave(Save.save1, Game.save1Path, 1);
/* 701 */         enterGame();
/* 702 */       } else if (!Save.save1.exists()) {
/* 703 */         this.save1Name = "";
/* 704 */         (Game.getPlayer()).typedName = "";
/* 705 */         this.cancelState = 0;
/* 706 */         this.proc.createWindow(1);
/*     */       } 
/* 708 */     } else if (this.currentProfile == 2) {
/* 709 */       if (Save.save2.exists()) {
/* 710 */         Load.loadProfile(Game.save2Path);
/* 711 */         Save.profileSave(Save.save2, Game.save2Path, 2);
/* 712 */         enterGame();
/* 713 */       } else if (!Save.save2.exists()) {
/* 714 */         this.save2Name = "";
/* 715 */         (Game.getPlayer()).typedName = "";
/* 716 */         this.cancelState = 0;
/* 717 */         this.proc.createWindow(2);
/*     */       } 
/* 719 */     } else if (this.currentProfile == 3) {
/* 720 */       if (Save.save3.exists()) {
/* 721 */         Load.loadProfile(Game.save3Path);
/* 722 */         Save.profileSave(Save.save3, Game.save3Path, 3);
/* 723 */         enterGame();
/* 724 */       } else if (!Save.save3.exists()) {
/* 725 */         this.save3Name = "";
/* 726 */         (Game.getPlayer()).typedName = "";
/* 727 */         this.cancelState = 0;
/* 728 */         this.proc.createWindow(3);
/*     */       } 
/*     */     } 
/* 731 */     Game.endClick();
/* 732 */     TestDummy.reset();
/* 733 */     this.save1State = 0;
/* 734 */     this.save2State = 0;
/* 735 */     this.save3State = 0;
/*     */   }
/*     */   
/*     */   private void m2DeleteProfile() throws IOException {
/* 739 */     if (this.currentProfile == 1) {
/* 740 */       Save.save1.delete();
/* 741 */       Save.save1Made = "";
/* 742 */       Save.save1LastPlayed = "";
/* 743 */       Save.dataSave();
/* 744 */     } else if (this.currentProfile == 2) {
/* 745 */       Save.save2.delete();
/* 746 */       Save.save2Made = "";
/* 747 */       Save.save2LastPlayed = "";
/* 748 */       Save.dataSave();
/* 749 */     } else if (this.currentProfile == 3) {
/* 750 */       Save.save3.delete();
/* 751 */       Save.save3Made = " ";
/* 752 */       Save.save3LastPlayed = " ";
/* 753 */       Save.dataSave();
/*     */     } 
/* 755 */     this.menuState = 2;
/* 756 */     this.currentProfile = 0;
/* 757 */     profileCheck();
/*     */   }
/*     */   
/*     */   private void m2Back() {
/* 761 */     this.save1State = 0;
/* 762 */     this.save2State = 0;
/* 763 */     this.save3State = 0;
/* 764 */     this.currentProfile = 0;
/* 765 */     this.menuState = 1;
/*     */   }
/*     */   
/*     */   private void m3Yes() {
/*     */     try {
/* 771 */       m2DeleteProfile();
/* 772 */     } catch (IOException e) {
/* 773 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void m3No() {
/* 779 */     this.menuState = 2;
/*     */   }
/*     */   
/*     */   public void m5CreateProfile(File save, String path) throws IOException {
/* 783 */     Save.reset();
/* 784 */     if (this.currentProfile == 1 && this.save1Name.length() == 0) {
/* 785 */       this.save1Name = "Profile 1";
/* 786 */       this.save1Name_backup = this.save1Name;
/* 787 */     } else if (this.currentProfile == 2 && this.save2Name.length() == 0) {
/* 788 */       this.save2Name = "Profile 2";
/* 789 */       this.save2Name_backup = this.save2Name;
/* 790 */     } else if (this.currentProfile == 3 && this.save3Name.length() == 0) {
/* 791 */       this.save3Name = "Profile 3";
/* 792 */       this.save3Name_backup = this.save3Name;
/*     */     } 
/* 794 */     if ((Game.getPlayer()).typedName.length() == 0) {
/* 795 */       (Game.getPlayer()).name = (Game.getPlayer()).defaultName;
/* 796 */     } else if ((Game.getPlayer()).typedName.length() >= 1) {
/* 797 */       (Game.getPlayer()).name = (Game.getPlayer()).typedName;
/*     */     } 
/* 799 */     Save.profileSave(save, path, this.currentProfile);
/* 800 */     Load.loadProfile(path);
/* 801 */     System.out.println("About the enter game!");
/* 802 */     enterGame();
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.6_4.jar!\beyondOrigins\main\menus\MainMenu.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */