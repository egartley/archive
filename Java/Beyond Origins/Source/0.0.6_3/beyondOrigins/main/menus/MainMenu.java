/*     */ package beyondOrigins.main.menus;
/*     */ 
/*     */ import beyondOrigins.files.Load;
/*     */ import beyondOrigins.files.Save;
/*     */ import beyondOrigins.main.Game;
/*     */ import beyondOrigins.main.entities.Cloud;
/*     */ import beyondOrigins.main.entities.TestDummy;
/*     */ import beyondOrigins.main.gfx.ImageManager;
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
/*  25 */   public byte menuState = 1;
/*     */   
/*     */   public byte state;
/*     */   
/*     */   public Cloud cloud1;
/*     */   
/*     */   public Cloud cloud2;
/*     */   
/*     */   public Cloud cloud3;
/*     */   
/*  33 */   public byte currentProfile = 0;
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
/*  38 */   public String save1Name = "IfYouSeeThisSomethingIsWrong";
/*     */   
/*  39 */   public String save2Name = "IfYouSeeThisSomethingIsWrong";
/*     */   
/*  40 */   public String save3Name = "IfYouSeeThisSomethingIsWrong";
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
/*     */   public MainMenu() {
/*  57 */     this.o = new Options();
/*  58 */     this.cloud1 = new Cloud(-195.0D, 135.0D);
/*  59 */     this.cloud2 = new Cloud(1033.0D, (286 - 
/*  60 */         ImageManager.cloud1.getHeight() / 2));
/*  61 */     this.cloud3 = new Cloud(-155.0D, 378.0D);
/*     */   }
/*     */   
/*     */   private byte getButtonState(int x, int y, int width, int height, byte state) {
/*  70 */     if (MouseMotion.mouseX >= x && MouseMotion.mouseX < x + width && 
/*  71 */       MouseMotion.mouseY >= y && MouseMotion.mouseY < y + height) {
/*  72 */       state = 2;
/*  73 */       if (Game.mouseIsPressed()) {
/*  74 */         state = 3;
/*     */       } else {
/*  76 */         state = 2;
/*     */       } 
/*     */     } else {
/*  78 */       state = 1;
/*     */     } 
/*  79 */     return state;
/*     */   }
/*     */   
/*     */   private byte getGeneralImageState(int x, int y, int width, int height, byte state, boolean inFocus) {
/*  86 */     if (MouseMotion.mouseX >= x && MouseMotion.mouseX < x + width && 
/*  87 */       MouseMotion.mouseY >= y && MouseMotion.mouseY < y + height) {
/*  88 */       if (!inFocus && Game.mouseIsPressed()) {
/*  89 */         state = 2;
/*  90 */         inFocus = true;
/*  91 */       } else if (inFocus) {
/*  92 */         state = 2;
/*     */       } 
/*  95 */     } else if (inFocus) {
/*  96 */       state = 2;
/*  98 */     } else if (Game.mouseIsPressed()) {
/*  99 */       state = 1;
/* 100 */       inFocus = false;
/*     */     } 
/* 105 */     return state;
/*     */   }
/*     */   
/*     */   private void drawButton(Graphics g, int x, int y, int width, int height, String buttonText, BufferedImage state1Image, BufferedImage state2Image, BufferedImage state3Image, double clickEventType) {
/* 112 */     this.fm = g.getFontMetrics(Game.buttonTextFont);
/* 114 */     g.setFont(Game.buttonTextFont);
/* 115 */     if (getButtonState(x, y, width, height, this.state) == 1) {
/* 116 */       g.drawImage(state1Image, x, y, width, height, null);
/* 117 */       g.setColor(Game.buttonIdleColor);
/* 118 */       g.drawString(
/* 119 */           buttonText, 
/* 120 */           x + state1Image.getWidth() / 2 - 
/* 121 */           this.fm.stringWidth(buttonText) / 2, y + 
/* 122 */           state1Image.getHeight() / 2 + 5);
/* 123 */     } else if (getButtonState(x, y, width, height, this.state) == 2) {
/* 124 */       g.drawImage(state2Image, x, y, width, height, null);
/* 125 */       g.setColor(Game.buttonSelectedColor);
/* 126 */       g.drawString(
/* 127 */           buttonText, 
/* 128 */           x + state1Image.getWidth() / 2 - 
/* 129 */           this.fm.stringWidth(buttonText) / 2, y + 
/* 130 */           state1Image.getHeight() / 2 + 5);
/* 131 */     } else if (getButtonState(x, y, width, height, this.state) == 3) {
/* 132 */       g.drawImage(state3Image, x, y, width, height, null);
/* 133 */       g.setColor(Game.buttonClickedColor);
/* 134 */       g.drawString(
/* 135 */           buttonText, 
/* 136 */           x + state1Image.getWidth() / 2 - 
/* 137 */           this.fm.stringWidth(buttonText) / 2, y + 
/* 138 */           state1Image.getHeight() / 2 + 5);
/* 139 */       clickEventHandler(clickEventType);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void clickEventHandler(double e) {
/* 145 */     if (e == 1.1D) {
/* 146 */       m1Play();
/* 147 */     } else if (e == 1.2D) {
/* 148 */       m1Options();
/* 149 */     } else if (e != 1.3D) {
/* 151 */       if (e == 1.4D)
/* 152 */         m1Quit(); 
/*     */     } 
/* 155 */     if (e == 2.1D) {
/*     */       try {
/* 157 */         m2PlayProfile();
/* 158 */       } catch (IOException ei) {
/* 159 */         ei.printStackTrace();
/*     */       } 
/* 161 */     } else if (e == 2.2D) {
/* 162 */       this.menuState = 3;
/* 163 */     } else if (e == 2.3D) {
/* 164 */       m2Back();
/*     */     } 
/* 167 */     if (e == 3.1D) {
/* 168 */       m3Yes();
/* 169 */     } else if (e == 3.2D) {
/* 170 */       m3No();
/*     */     } 
/* 173 */     if (e == 5.1D) {
/*     */       try {
/* 175 */         if (this.currentProfile == 1) {
/* 176 */           m5CreateProfile(Save.save1, Game.save1Path);
/* 177 */         } else if (this.currentProfile == 2) {
/* 178 */           m5CreateProfile(Save.save2, Game.save2Path);
/* 179 */         } else if (this.currentProfile == 3) {
/* 180 */           m5CreateProfile(Save.save3, Game.save3Path);
/*     */         } 
/* 182 */       } catch (IOException ei) {
/* 183 */         ei.printStackTrace();
/*     */       } 
/* 185 */     } else if (e == 5.2D) {
/* 186 */       Game.endClick();
/* 187 */       this.menuState = 2;
/* 188 */       this.currentProfile = 0;
/*     */     } 
/* 191 */     if (e == 6.1D) {
/* 192 */       Game.getPlayer().respawn();
/* 193 */     } else if (e == 6.2D) {
/* 194 */       (Game.getPlayer()).health = (Game.getPlayer()).maxHealth;
/*     */       try {
/* 196 */         if (this.currentProfile == 1)
/* 197 */           Save.profileSave(Save.save1, Game.save1Path, 1); 
/* 198 */         if (this.currentProfile == 2)
/* 199 */           Save.profileSave(Save.save2, Game.save2Path, 2); 
/* 200 */         if (this.currentProfile == 3)
/* 201 */           Save.profileSave(Save.save3, Game.save3Path, 3); 
/* 202 */         Save.dataSave();
/* 203 */       } catch (IOException e1) {
/* 204 */         e1.printStackTrace();
/*     */       } 
/* 206 */       Game.endClick();
/* 207 */       this.menuState = 1;
/* 208 */       this.currentProfile = 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void drawProfile(Graphics g, byte state, int x, int y, String lastPlayed, String created, File file, int profileNumber, String name, FontMetrics fm) {
/* 215 */     g.drawImage(ImageManager.profileSquare, x, y, 
/* 216 */         ImageManager.profileSquare.getWidth(), 
/* 217 */         ImageManager.profileSquare.getHeight(), null);
/* 218 */     g.setColor(Game.gameProgressColor);
/* 219 */     g.setFont(Game.gameProgressFont);
/* 220 */     if (file.exists()) {
/* 221 */       g.drawImage(ImageManager.playerd1, 
/* 222 */           ImageManager.profileSquare.getWidth() / 2 + x - 
/* 223 */           ImageManager.playerd1.getWidth(), 
/* 224 */           y + ImageManager.profileSquare.getHeight() / 2 - 
/* 225 */           ImageManager.playerd1.getHeight(), 64, 64, null);
/* 226 */     } else if (!file.exists()) {
/* 227 */       g.drawString("?", ImageManager.profileSquare.getWidth() / 2 + x - 
/* 228 */           fm.stringWidth("?") / 2, profileNumber * 110);
/*     */     } 
/* 230 */     if (this.currentProfile == profileNumber) {
/* 231 */       g.setColor(Color.white);
/*     */     } else {
/* 233 */       g.setColor(Game.profileInfoColor);
/*     */     } 
/* 235 */     g.setFont(Game.profileNameFont);
/* 236 */     g.drawString(name, 380, profileNumber * 110 - 40);
/* 237 */     g.setFont(Game.profileInfoFont);
/* 238 */     g.drawString("Last Played: " + lastPlayed, 380, 
/* 239 */         profileNumber * 110 - 40 + 33);
/* 240 */     g.drawString("Date Created: " + created, 380, 
/* 241 */         profileNumber * 110 - 40 + 66);
/*     */   }
/*     */   
/*     */   private void draw3WayTextBox(Graphics g, byte state, int x, int y, int w, int h, String t1, String t2, String t3, String info, int optionalParam) {
/* 249 */     this.fm = g.getFontMetrics(Game.buttonTextFont);
/* 251 */     g.setColor(Game.profileInfoColor);
/* 252 */     g.setFont(Game.profileInfoFont);
/* 254 */     g.drawString(info, x, y - 9);
/* 256 */     g.setColor(new Color(232, 232, 232));
/* 257 */     g.drawRect(x + 1, y + 1, w - 2, h - 2);
/* 258 */     g.drawRect(x, y, w, h);
/* 260 */     g.setColor(new Color(0, 0, 0, 180));
/* 261 */     g.fillRect(x + 2, y + 2, w - 3, h - 3);
/* 263 */     g.setFont(Game.buttonTextFont);
/* 264 */     g.setColor(Color.white);
/* 265 */     if (optionalParam == 1) {
/* 266 */       g.drawString(t1, x + 8, y + 24);
/* 267 */       if (state == 2)
/* 268 */         g.drawString("_", x + 8 + this.fm.stringWidth(t1), y + 24); 
/* 270 */     } else if (optionalParam == 2) {
/* 271 */       g.drawString(t2, x + 8, y + 24);
/* 272 */       if (state == 2)
/* 273 */         g.drawString("_", x + 8 + this.fm.stringWidth(t2), y + 24); 
/* 275 */     } else if (optionalParam == 3) {
/* 276 */       g.drawString(t3, x + 8, y + 24);
/* 277 */       if (state == 2)
/* 278 */         g.drawString("_", x + 8 + this.fm.stringWidth(t3), y + 24); 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void drawTextBox(Graphics g, byte state, int x, int y, int w, int h, String t, String info) {
/* 287 */     g.setColor(Game.profileInfoColor);
/* 288 */     g.setFont(Game.profileInfoFont);
/* 291 */     g.drawString(info, x, y - 9);
/* 294 */     g.setColor(new Color(232, 232, 232));
/* 295 */     g.drawRect(x + 1, y + 1, w - 2, h - 2);
/* 296 */     g.drawRect(x, y, w, h);
/* 299 */     g.setColor(new Color(0, 0, 0, 180));
/* 300 */     g.fillRect(x + 2, y + 2, w - 3, h - 3);
/* 303 */     g.setFont(Game.buttonTextFont);
/* 304 */     g.setColor(Color.white);
/* 307 */     g.drawString(t, x + 8, y + 24);
/* 308 */     if (state == 2)
/* 309 */       g.drawString("_", x + 8 + this.fm.stringWidth(t), y + 24); 
/*     */   }
/*     */   
/*     */   public void setCurrentProfile(int i) {
/* 314 */     if (i == 1) {
/* 315 */       this.save1State = 3;
/* 316 */       this.save2State = 0;
/* 317 */       this.save3State = 0;
/* 318 */     } else if (i == 2) {
/* 319 */       this.save1State = 0;
/* 320 */       this.save2State = 3;
/* 321 */       this.save3State = 0;
/* 322 */     } else if (i == 3) {
/* 323 */       this.save1State = 0;
/* 324 */       this.save2State = 0;
/* 325 */       this.save3State = 3;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void enterGame() {
/* 330 */     System.out.println("Entering game...");
/* 331 */     Game.isInGame = true;
/* 332 */     this.menuState = 0;
/* 333 */     KeyManager.enterPressed = false;
/* 334 */     (Game.getPlayer()).up = false;
/* 335 */     (Game.getPlayer()).down = false;
/* 336 */     (Game.getPlayer()).left = false;
/* 337 */     (Game.getPlayer()).right = false;
/* 338 */     Game.getPlayer().healthBarCheck();
/* 339 */     System.out.println("Game entered!");
/*     */   }
/*     */   
/*     */   public void tick() {
/* 346 */     this.cloud1.tick(Game.width, 0.3D, 1);
/* 347 */     this.cloud2.tick(-155, 0.4D, 0);
/* 348 */     this.cloud3.tick(Game.width + 145, 0.2D, 1);
/*     */   }
/*     */   
/*     */   private void profileCheck() {
/* 354 */     if (!Save.save1.exists()) {
/* 355 */       this.save1Name = "Play To Create Me";
/* 356 */     } else if (Save.save1.exists()) {
/* 357 */       this.save1Name = this.save1Name_backup;
/*     */     } 
/* 360 */     if (!Save.save2.exists()) {
/* 361 */       this.save2Name = "Play To Create Me";
/* 362 */     } else if (Save.save2.exists()) {
/* 363 */       this.save2Name = this.save2Name_backup;
/*     */     } 
/* 366 */     if (!Save.save3.exists()) {
/* 367 */       this.save3Name = "Play To Create Me";
/* 368 */     } else if (Save.save3.exists()) {
/* 369 */       this.save3Name = this.save3Name_backup;
/*     */     } 
/* 372 */     if (this.save1State == 3 || this.save2State == 3 || this.save3State == 3) {
/* 373 */       this.canPlayProfile = true;
/* 374 */     } else if (this.save1State == 0 && this.save2State == 0 && this.save3State == 0) {
/* 375 */       this.canPlayProfile = false;
/*     */     } 
/* 378 */     if ((this.currentProfile == 1 && !Save.save1.exists()) || (
/* 379 */       this.currentProfile == 2 && !Save.save2.exists()) || (
/* 380 */       this.currentProfile == 3 && !Save.save3.exists()) || 
/* 381 */       this.currentProfile == 0) {
/* 382 */       this.canDeleteProfile = false;
/* 383 */     } else if ((this.currentProfile == 1 && Save.save1.exists()) || (
/* 384 */       this.currentProfile == 2 && Save.save2.exists()) || (
/* 385 */       this.currentProfile == 3 && Save.save3.exists())) {
/* 386 */       this.canDeleteProfile = true;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render(Graphics g) {
/* 393 */     g.setColor(Game.skyColor);
/* 394 */     g.fillRect(0, 0, Game.width, Game.height);
/* 396 */     this.cloud1.render(g);
/* 397 */     this.cloud2.render(g);
/* 398 */     this.cloud3.render(g);
/* 400 */     if (this.menuState == 1) {
/* 401 */       renderState1(g);
/* 402 */     } else if (this.menuState == 2) {
/* 403 */       renderState2(g);
/* 404 */     } else if (this.menuState == 3) {
/* 405 */       renderState3(g);
/* 406 */     } else if (this.menuState == 4) {
/* 407 */       renderState4(g);
/* 408 */     } else if (this.menuState == 5) {
/* 409 */       renderState5(g);
/* 410 */     } else if (this.menuState == 6) {
/* 411 */       renderState6(g);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void renderState1(Graphics g) {
/* 420 */     this.fm = g.getFontMetrics(Game.profileInfoFont);
/* 421 */     this.fm2 = g.getFontMetrics(Game.buttonTextFont);
/* 424 */     g.drawImage(Game.logoImage, 
/* 425 */         Game.width / 2 - Game.logoImage.getWidth(), Game.height / 2 - 
/* 426 */         Game.logoImage.getWidth() - 45, 
/* 427 */         Game.logoImage.getWidth() * 2, Game.logoImage.getHeight() * 2, 
/* 428 */         null);
/* 431 */     g.setFont(Game.profileInfoFont);
/* 432 */     g.setColor(Game.profileInfoColor);
/* 433 */     g.drawString(Game.identifer, 
/* 434 */         Game.width / 2 - this.fm.stringWidth(Game.identifer) / 2, 
/* 435 */         Game.height / 2 + 48 + 110);
/* 438 */     g.setFont(Game.buttonTextFont);
/* 439 */     g.setColor(Color.white);
/* 440 */     g.drawString(Game.title, 5, Game.height - 13);
/* 441 */     g.drawString(Game.copyright, 
/* 442 */         Game.width - this.fm2.stringWidth(Game.copyright) + 10, 
/* 443 */         Game.height - 13);
/* 446 */     drawButton(g, Game.width / 2 - 168, Game.height / 2, 336, 32, "Play", 
/* 447 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 448 */         ImageManager.button2_3, 1.1D);
/* 451 */     drawButton(g, Game.width / 2 - 168, Game.height / 2 + 48, 
/* 452 */         ImageManager.button2_1.getWidth(), 
/* 453 */         ImageManager.button2_1.getHeight(), "Options", 
/* 454 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 455 */         ImageManager.button2_3, 1.2D);
/* 458 */     drawButton(g, Game.width / 2 - 168, Game.height / 2 + 48 + 48, 
/* 459 */         ImageManager.button2_1.getWidth(), 
/* 460 */         ImageManager.button2_1.getHeight(), "Quit Game", 
/* 461 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 462 */         ImageManager.button2_3, 1.4D);
/*     */   }
/*     */   
/*     */   private void renderState2(Graphics g) {
/* 470 */     this.fm = g.getFontMetrics(Game.gameProgressFont);
/* 472 */     g.setFont(Game.profileInfoFont);
/* 473 */     g.setColor(Game.profileInfoColor);
/* 477 */     if (this.save1State == 3) {
/* 478 */       g.drawImage(ImageManager.profileSelection, Game.width / 2 - 150, 
/* 479 */           43, 300, 117, null);
/* 480 */       this.currentProfile = 1;
/* 481 */       profileCheck();
/* 482 */     } else if (this.save2State == 3) {
/* 483 */       g.drawImage(ImageManager.profileSelection, Game.width / 2 - 150, 
/* 484 */           153, 300, 117, null);
/* 485 */       this.currentProfile = 2;
/* 486 */       profileCheck();
/* 487 */     } else if (this.save3State == 3) {
/* 488 */       g.drawImage(ImageManager.profileSelection, Game.width / 2 - 150, 
/* 489 */           263, 300, 117, null);
/* 490 */       this.currentProfile = 3;
/* 491 */       profileCheck();
/*     */     } 
/* 496 */     drawProfile(g, this.save1State, Game.width / 2 - 144, 50, 
/* 497 */         Save.save1LastPlayed, Save.save1Made, Save.save1, 1, this.save1Name, 
/* 498 */         this.fm);
/* 500 */     drawProfile(g, this.save2State, Game.width / 2 - 144, 160, 
/* 501 */         Save.save2LastPlayed, Save.save2Made, Save.save2, 2, this.save2Name, 
/* 502 */         this.fm);
/* 504 */     drawProfile(g, this.save3State, Game.width / 2 - 144, 270, 
/* 505 */         Save.save3LastPlayed, Save.save3Made, Save.save3, 3, this.save3Name, 
/* 506 */         this.fm);
/* 508 */     this.fm2 = g.getFontMetrics(Game.buttonTextFont);
/* 512 */     if (this.canPlayProfile) {
/* 513 */       drawButton(g, Game.width / 2 - 
/* 514 */           ImageManager.button2_1.getWidth() / 2, 425, 
/* 515 */           ImageManager.button2_1.getWidth(), 
/* 516 */           ImageManager.button2_1.getHeight(), "Play Profile", 
/* 517 */           ImageManager.button2_1, ImageManager.button2_2, 
/* 518 */           ImageManager.button2_3, 2.1D);
/* 519 */     } else if (!this.canPlayProfile) {
/* 520 */       g.setFont(Game.buttonTextFont);
/* 521 */       g.drawImage(ImageManager.button2_3, Game.width / 2 - 
/* 522 */           ImageManager.button2_3.getWidth() / 2, 425, 
/* 523 */           ImageManager.button2_3.getWidth(), 
/* 524 */           ImageManager.button2_3.getHeight(), null);
/* 525 */       g.setColor(Game.buttonClickedColor);
/* 526 */       g.drawString("Play Profile", 
/* 527 */           Game.width / 2 - this.fm2.stringWidth("Play Profile") / 2, 
/* 528 */           446);
/*     */     } 
/* 533 */     if (this.canDeleteProfile) {
/* 534 */       drawButton(g, Game.width / 2 - 
/* 535 */           ImageManager.button2_1.getWidth() / 2, 473, 
/* 536 */           ImageManager.button1_1.getWidth(), 
/* 537 */           ImageManager.button1_1.getHeight(), "Delete", 
/* 538 */           ImageManager.button1_1, ImageManager.button1_2, 
/* 539 */           ImageManager.button1_3, 2.2D);
/* 540 */     } else if (!this.canDeleteProfile) {
/* 541 */       g.setFont(Game.buttonTextFont);
/* 542 */       g.drawImage(ImageManager.button1_3, Game.width / 2 - 
/* 543 */           ImageManager.button2_1.getWidth() / 2, 473, 
/* 544 */           ImageManager.button1_3.getWidth(), 
/* 545 */           ImageManager.button1_3.getHeight(), null);
/* 546 */       g.setColor(Game.buttonClickedColor);
/* 547 */       g.drawString(
/* 548 */           "Delete", 
/* 549 */           Game.width / 2 - ImageManager.button1_1.getWidth() / 2 - 8 - 
/* 550 */           this.fm2.stringWidth("Delete") / 2, 
/* 551 */           473 + ImageManager.button1_3.getHeight() / 2 + 5);
/*     */     } 
/* 556 */     drawButton(g, Game.width / 2 - 
/* 557 */         ImageManager.button2_1.getWidth() / 2 + 176, 473, 
/* 558 */         ImageManager.button1_1.getWidth(), 
/* 559 */         ImageManager.button1_1.getHeight(), "Back", 
/* 560 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 561 */         ImageManager.button1_3, 2.3D);
/*     */   }
/*     */   
/*     */   private void renderState3(Graphics g) {
/* 569 */     g.setFont(Game.areYouSureFont);
/* 570 */     g.setColor(Game.profileInfoColor);
/* 571 */     g.drawString("Are you sure?", 280, 190);
/* 573 */     g.setFont(Game.buttonTextFont);
/* 575 */     drawButton(g, Game.width / 2 - 204, 325, 
/* 576 */         ImageManager.button1_1.getWidth(), 
/* 577 */         ImageManager.button1_1.getHeight(), "Yes", 
/* 578 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 579 */         ImageManager.button1_3, 3.1D);
/* 581 */     drawButton(g, Game.width / 2 + 35, 325, 
/* 582 */         ImageManager.button1_1.getWidth(), 
/* 583 */         ImageManager.button1_1.getHeight(), "No", 
/* 584 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 585 */         ImageManager.button1_3, 3.2D);
/*     */   }
/*     */   
/*     */   private void renderState4(Graphics g) {
/* 592 */     this.o.render(g);
/*     */   }
/*     */   
/*     */   private void renderState5(Graphics g) {
/* 600 */     this.profileNameBoxState = getGeneralImageState(Game.width / 2 - 
/* 601 */         ImageManager.button2_1.getWidth() / 2 - 1, 89, 
/* 602 */         ImageManager.button2_1.getWidth() + 2, 
/* 603 */         ImageManager.button2_1.getHeight() + 2, this.profileNameBoxState, 
/* 604 */         this.profileNameBoxInFocus);
/* 606 */     this.playerNameBoxState = getGeneralImageState(Game.width / 2 - 
/* 607 */         ImageManager.button2_1.getWidth() / 2 - 1, 172, 
/* 608 */         ImageManager.button2_1.getWidth() + 2, 
/* 609 */         ImageManager.button2_1.getHeight() + 2, this.playerNameBoxState, 
/* 610 */         this.playerNameBoxInFocus);
/* 613 */     draw3WayTextBox(g, this.profileNameBoxState, Game.width / 2 - 
/* 614 */         ImageManager.button2_1.getWidth() / 2 - 1, 89, 
/* 615 */         ImageManager.button2_1.getWidth() + 2, 
/* 616 */         ImageManager.button2_1.getHeight() + 2, this.save1Name, this.save2Name, 
/* 617 */         this.save3Name, "Profile Name: ", this.currentProfile);
/* 619 */     drawTextBox(g, this.playerNameBoxState, Game.width / 2 - 
/* 620 */         ImageManager.button2_1.getWidth() / 2 - 1, 172, 
/* 621 */         ImageManager.button2_1.getWidth() + 2, 
/* 622 */         ImageManager.button2_1.getHeight() + 2, 
/* 623 */         (Game.getPlayer()).typedName, 
/* 624 */         "Character's Name (Cannot change after this!)");
/* 627 */     drawButton(g, Game.width / 2 - 
/* 628 */         ImageManager.button2_1.getWidth() / 2, 437, 
/* 629 */         ImageManager.button1_1.getWidth(), 
/* 630 */         ImageManager.button1_1.getHeight(), "Create Profile", 
/* 631 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 632 */         ImageManager.button1_3, 5.1D);
/* 635 */     drawButton(
/* 636 */         g, 
/* 637 */         Game.width / 2 - 
/* 638 */         ImageManager.button2_1.getWidth() / 2 - ImageManager.button1_1
/* 639 */         .getWidth() + 16, 437, 
/* 640 */         ImageManager.button1_1.getWidth(), 
/* 641 */         ImageManager.button1_1.getHeight(), "Back", 
/* 642 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 643 */         ImageManager.button1_3, 5.2D);
/*     */   }
/*     */   
/*     */   private void renderState6(Graphics g) {
/* 651 */     g.setFont(Game.buttonTextFont);
/* 652 */     g.setColor(Game.profileInfoColor);
/* 654 */     this.fm = g.getFontMetrics(Game.buttonTextFont);
/* 656 */     g.drawString("You were killed!", 
/* 657 */         Game.width / 2 - this.fm.stringWidth("You were killed!") / 2, 
/* 658 */         200);
/* 660 */     drawButton(g, Game.width / 2 - 
/* 661 */         ImageManager.button2_1.getWidth() / 2, 275, 
/* 662 */         ImageManager.button2_1.getWidth(), 
/* 663 */         ImageManager.button2_1.getHeight(), "Respawn", 
/* 664 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 665 */         ImageManager.button2_3, 6.1D);
/* 667 */     drawButton(g, Game.width / 2 - 
/* 668 */         ImageManager.button2_1.getWidth() / 2, 323, 
/* 669 */         ImageManager.button2_1.getWidth(), 
/* 670 */         ImageManager.button2_1.getHeight(), "Save and Quit to Title", 
/* 671 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 672 */         ImageManager.button2_3, 6.2D);
/*     */   }
/*     */   
/*     */   private void m1Play() {
/* 679 */     Game.endClick();
/* 680 */     this.menuState = 2;
/* 681 */     Load.loadData(Game.dataPath);
/* 682 */     profileCheck();
/*     */   }
/*     */   
/*     */   private void m1Options() {
/* 686 */     this.menuState = 4;
/* 687 */     this.o = new Options();
/*     */   }
/*     */   
/*     */   private void m1Quit() {
/* 691 */     System.exit(0);
/*     */   }
/*     */   
/*     */   public void m2PlayProfile() throws IOException {
/* 695 */     if (this.currentProfile == 1) {
/* 696 */       if (Save.save1.exists()) {
/* 697 */         Load.loadProfile(Game.save1Path);
/* 698 */         Save.profileSave(Save.save1, Game.save1Path, 1);
/* 699 */         enterGame();
/* 700 */       } else if (!Save.save1.exists()) {
/* 701 */         this.save1Name = "";
/* 702 */         (Game.getPlayer()).typedName = "";
/* 703 */         this.cancelState = 0;
/* 704 */         this.menuState = 5;
/*     */       } 
/* 706 */     } else if (this.currentProfile == 2) {
/* 707 */       if (Save.save2.exists()) {
/* 708 */         Load.loadProfile(Game.save2Path);
/* 709 */         Save.profileSave(Save.save2, Game.save2Path, 2);
/* 710 */         enterGame();
/* 711 */       } else if (!Save.save2.exists()) {
/* 712 */         this.save2Name = "";
/* 713 */         (Game.getPlayer()).typedName = "";
/* 714 */         this.cancelState = 0;
/* 715 */         this.menuState = 5;
/*     */       } 
/* 717 */     } else if (this.currentProfile == 3) {
/* 718 */       if (Save.save3.exists()) {
/* 719 */         Load.loadProfile(Game.save3Path);
/* 720 */         Save.profileSave(Save.save3, Game.save3Path, 3);
/* 721 */         enterGame();
/* 722 */       } else if (!Save.save3.exists()) {
/* 723 */         this.save3Name = "";
/* 724 */         (Game.getPlayer()).typedName = "";
/* 725 */         this.cancelState = 0;
/* 726 */         this.menuState = 5;
/*     */       } 
/*     */     } 
/* 729 */     Game.endClick();
/* 730 */     TestDummy.reset();
/* 731 */     this.save1State = 0;
/* 732 */     this.save2State = 0;
/* 733 */     this.save3State = 0;
/*     */   }
/*     */   
/*     */   private void m2DeleteProfile() throws IOException {
/* 737 */     if (this.currentProfile == 1) {
/* 738 */       Save.save1.delete();
/* 739 */       Save.save1Made = "";
/* 740 */       Save.save1LastPlayed = "";
/* 741 */       Save.dataSave();
/* 742 */     } else if (this.currentProfile == 2) {
/* 743 */       Save.save2.delete();
/* 744 */       Save.save2Made = "";
/* 745 */       Save.save2LastPlayed = "";
/* 746 */       Save.dataSave();
/* 747 */     } else if (this.currentProfile == 3) {
/* 748 */       Save.save3.delete();
/* 749 */       Save.save3Made = " ";
/* 750 */       Save.save3LastPlayed = " ";
/* 751 */       Save.dataSave();
/*     */     } 
/* 753 */     this.menuState = 2;
/* 754 */     this.currentProfile = 0;
/* 755 */     profileCheck();
/*     */   }
/*     */   
/*     */   private void m2Back() {
/* 759 */     this.save1State = 0;
/* 760 */     this.save2State = 0;
/* 761 */     this.save3State = 0;
/* 762 */     this.currentProfile = 0;
/* 763 */     this.menuState = 1;
/*     */   }
/*     */   
/*     */   private void m3Yes() {
/*     */     try {
/* 769 */       m2DeleteProfile();
/* 770 */     } catch (IOException e) {
/* 771 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void m3No() {
/* 777 */     this.menuState = 2;
/*     */   }
/*     */   
/*     */   public void m5CreateProfile(File save, String path) throws IOException {
/* 781 */     Save.reset();
/* 782 */     if (this.currentProfile == 1 && this.save1Name.length() == 0) {
/* 783 */       this.save1Name = "Profile 1";
/* 784 */       this.save1Name_backup = this.save1Name;
/* 785 */     } else if (this.currentProfile == 2 && this.save2Name.length() == 0) {
/* 786 */       this.save2Name = "Profile 2";
/* 787 */       this.save2Name_backup = this.save2Name;
/* 788 */     } else if (this.currentProfile == 3 && this.save3Name.length() == 0) {
/* 789 */       this.save3Name = "Profile 3";
/* 790 */       this.save3Name_backup = this.save3Name;
/*     */     } 
/* 792 */     if ((Game.getPlayer()).typedName.length() == 0) {
/* 793 */       (Game.getPlayer()).name = (Game.getPlayer()).defaultName;
/* 794 */     } else if ((Game.getPlayer()).typedName.length() >= 1) {
/* 795 */       (Game.getPlayer()).name = (Game.getPlayer()).typedName;
/*     */     } 
/* 797 */     Save.profileSave(save, path, this.currentProfile);
/* 798 */     Load.loadProfile(path);
/* 799 */     System.out.println("About the enter game!");
/* 800 */     enterGame();
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.6_3.jar!\beyondOrigins\main\menus\MainMenu.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */