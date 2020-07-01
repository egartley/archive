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
/*  31 */   public byte currentProfile = 0;
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
/*  36 */   public String save1Name = "IfYouSeeThisSomethingIsWrong";
/*     */   
/*  37 */   public String save2Name = "IfYouSeeThisSomethingIsWrong";
/*     */   
/*  38 */   public String save3Name = "IfYouSeeThisSomethingIsWrong";
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
/*  54 */     this.cloud1 = new Cloud(-195.0D, 135.0D);
/*  55 */     this.cloud2 = new Cloud(1033.0D, (286 - 
/*  56 */         ImageManager.cloud1.getHeight() / 2));
/*  57 */     this.cloud3 = new Cloud(-155.0D, 378.0D);
/*     */   }
/*     */   
/*     */   private byte getButtonState(int x, int y, int width, int height, byte state) {
/*  64 */     if (MouseMotion.mouseX >= x && MouseMotion.mouseX < x + width && 
/*  65 */       MouseMotion.mouseY >= y && MouseMotion.mouseY < y + height) {
/*  66 */       state = 2;
/*  67 */       if (Game.mouseIsPressed()) {
/*  68 */         state = 3;
/*     */       } else {
/*  70 */         state = 2;
/*     */       } 
/*     */     } else {
/*  72 */       state = 1;
/*     */     } 
/*  73 */     return state;
/*     */   }
/*     */   
/*     */   private void drawButton(Graphics g, int x, int y, int width, int height, String buttonText, BufferedImage state1Image, BufferedImage state2Image, BufferedImage state3Image, double clickEventType) {
/*  80 */     this.fm = g.getFontMetrics(Game.buttonTextFont);
/*  81 */     g.setFont(Game.buttonTextFont);
/*  82 */     if (getButtonState(x, y, width, height, this.state) == 1) {
/*  83 */       g.drawImage(state1Image, x, y, width, height, null);
/*  84 */       g.setColor(Game.buttonIdleColor);
/*  85 */       g.drawString(
/*  86 */           buttonText, 
/*  87 */           x + state1Image.getWidth() / 2 - 
/*  88 */           this.fm.stringWidth(buttonText) / 2, y + 
/*  89 */           state1Image.getHeight() / 2 + 5);
/*  90 */     } else if (getButtonState(x, y, width, height, this.state) == 2) {
/*  91 */       g.drawImage(state2Image, x, y, width, height, null);
/*  92 */       g.setColor(Game.buttonSelectedColor);
/*  93 */       g.drawString(
/*  94 */           buttonText, 
/*  95 */           x + state1Image.getWidth() / 2 - 
/*  96 */           this.fm.stringWidth(buttonText) / 2, y + 
/*  97 */           state1Image.getHeight() / 2 + 5);
/*  98 */     } else if (getButtonState(x, y, width, height, this.state) == 3) {
/*  99 */       g.drawImage(state3Image, x, y, width, height, null);
/* 100 */       g.setColor(Game.buttonClickedColor);
/* 101 */       g.drawString(
/* 102 */           buttonText, 
/* 103 */           x + state1Image.getWidth() / 2 - 
/* 104 */           this.fm.stringWidth(buttonText) / 2, y + 
/* 105 */           state1Image.getHeight() / 2 + 5);
/* 106 */       clickEventHandler(clickEventType);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void clickEventHandler(double e) {
/* 112 */     if (e == 1.1D) {
/* 113 */       m1Play();
/* 114 */     } else if (e == 1.2D) {
/* 115 */       m1Options();
/* 116 */     } else if (e != 1.3D) {
/* 118 */       if (e == 1.4D)
/* 119 */         m1Quit(); 
/*     */     } 
/* 122 */     if (e == 2.1D) {
/*     */       try {
/* 124 */         m2PlayProfile();
/* 125 */       } catch (IOException ei) {
/* 126 */         ei.printStackTrace();
/*     */       } 
/* 128 */     } else if (e == 2.2D) {
/* 129 */       this.menuState = 3;
/* 130 */     } else if (e == 2.3D) {
/* 131 */       m2Back();
/*     */     } 
/* 134 */     if (e == 3.1D) {
/* 135 */       m3Yes();
/* 136 */     } else if (e == 3.2D) {
/* 137 */       m3No();
/*     */     } 
/* 140 */     if (e == 5.1D) {
/*     */       try {
/* 142 */         if (this.currentProfile == 1) {
/* 143 */           m5CreateProfile(Save.save1, Game.save1Path);
/* 144 */         } else if (this.currentProfile == 2) {
/* 145 */           m5CreateProfile(Save.save2, Game.save2Path);
/* 146 */         } else if (this.currentProfile == 3) {
/* 147 */           m5CreateProfile(Save.save3, Game.save3Path);
/*     */         } 
/* 149 */       } catch (IOException ei) {
/* 150 */         ei.printStackTrace();
/*     */       } 
/* 152 */     } else if (e == 5.2D) {
/* 153 */       Game.endClick();
/* 154 */       this.menuState = 2;
/* 155 */       this.currentProfile = 0;
/*     */     } 
/* 158 */     if (e == 6.1D) {
/* 159 */       Game.getPlayer().respawn();
/* 160 */     } else if (e == 6.2D) {
/* 161 */       (Game.getPlayer()).health = (Game.getPlayer()).maxHealth;
/*     */       try {
/* 163 */         if (this.currentProfile == 1)
/* 164 */           Save.profileSave(Save.save1, Game.save1Path, 1); 
/* 165 */         if (this.currentProfile == 2)
/* 166 */           Save.profileSave(Save.save2, Game.save2Path, 2); 
/* 167 */         if (this.currentProfile == 3)
/* 168 */           Save.profileSave(Save.save3, Game.save3Path, 3); 
/* 169 */         Save.dataSave();
/* 170 */       } catch (IOException e1) {
/* 171 */         e1.printStackTrace();
/*     */       } 
/* 173 */       Game.endClick();
/* 174 */       this.menuState = 1;
/* 175 */       this.currentProfile = 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void drawProfile(Graphics g, byte state, int x, int y, String lastPlayed, String created, File file, int profileNumber, String name, FontMetrics fm) {
/* 182 */     g.drawImage(ImageManager.profileSquare, x, y, 
/* 183 */         ImageManager.profileSquare.getWidth(), 
/* 184 */         ImageManager.profileSquare.getHeight(), null);
/* 185 */     g.setColor(Game.gameProgressColor);
/* 186 */     g.setFont(Game.gameProgressFont);
/* 187 */     if (file.exists()) {
/* 188 */       g.drawImage(ImageManager.player_down[1], 
/* 189 */           ImageManager.profileSquare.getWidth() / 2 + x - 
/* 190 */           ImageManager.player_down[1].getWidth(), 
/* 191 */           y + ImageManager.profileSquare.getHeight() / 2 - 
/* 192 */           ImageManager.player_down[1].getHeight(), 64, 64, 
/* 193 */           null);
/* 194 */     } else if (!file.exists()) {
/* 195 */       g.drawString("?", ImageManager.profileSquare.getWidth() / 2 + x - 
/* 196 */           fm.stringWidth("?") / 2, profileNumber * 110);
/*     */     } 
/* 198 */     if (this.currentProfile == profileNumber) {
/* 199 */       g.setColor(Color.white);
/*     */     } else {
/* 201 */       g.setColor(Game.profileInfoColor);
/*     */     } 
/* 203 */     g.setFont(Game.profileNameFont);
/* 204 */     g.drawString(name, 380, profileNumber * 110 - 40);
/* 205 */     g.setFont(Game.profileInfoFont);
/* 206 */     g.drawString("Last Played: " + lastPlayed, 380, 
/* 207 */         profileNumber * 110 - 40 + 33);
/* 208 */     g.drawString("Date Created: " + created, 380, 
/* 209 */         profileNumber * 110 - 40 + 66);
/*     */   }
/*     */   
/*     */   public void setCurrentProfile(int i) {
/* 214 */     if (i == 1) {
/* 215 */       this.save1State = 3;
/* 216 */       this.save2State = 0;
/* 217 */       this.save3State = 0;
/* 218 */     } else if (i == 2) {
/* 219 */       this.save1State = 0;
/* 220 */       this.save2State = 3;
/* 221 */       this.save3State = 0;
/* 222 */     } else if (i == 3) {
/* 223 */       this.save1State = 0;
/* 224 */       this.save2State = 0;
/* 225 */       this.save3State = 3;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void enterGame() {
/* 230 */     Game.isInGame = true;
/* 231 */     this.menuState = 0;
/* 232 */     Game.isLoading = true;
/* 233 */     KeyManager.enterPressed = false;
/* 234 */     (Game.getPlayer()).up = false;
/* 235 */     (Game.getPlayer()).down = false;
/* 236 */     (Game.getPlayer()).left = false;
/* 237 */     (Game.getPlayer()).right = false;
/* 238 */     Game.getPlayer().healthBarCheck();
/* 239 */     Game.endClick();
/*     */   }
/*     */   
/*     */   public void tick() {
/* 243 */     this.cloud1.tick(Game.width, 0.3D, 1);
/* 244 */     this.cloud2.tick(-155, 0.4D, 0);
/* 245 */     this.cloud3.tick(Game.width + 145, 0.2D, 1);
/*     */   }
/*     */   
/*     */   private void profileCheck() {
/* 250 */     if (!Save.save1.exists()) {
/* 251 */       this.save1Name = "Play To Create Me";
/* 252 */     } else if (Save.save1.exists()) {
/* 253 */       this.save1Name = this.save1Name_backup;
/*     */     } 
/* 256 */     if (!Save.save2.exists()) {
/* 257 */       this.save2Name = "Play To Create Me";
/* 258 */     } else if (Save.save2.exists()) {
/* 259 */       this.save2Name = this.save2Name_backup;
/*     */     } 
/* 262 */     if (!Save.save3.exists()) {
/* 263 */       this.save3Name = "Play To Create Me";
/* 264 */     } else if (Save.save3.exists()) {
/* 265 */       this.save3Name = this.save3Name_backup;
/*     */     } 
/* 268 */     if (this.save1State == 3 || this.save2State == 3 || this.save3State == 3) {
/* 269 */       this.canPlayProfile = true;
/* 270 */     } else if (this.save1State == 0 && this.save2State == 0 && this.save3State == 0) {
/* 271 */       this.canPlayProfile = false;
/*     */     } 
/* 274 */     if ((this.currentProfile == 1 && !Save.save1.exists()) || (
/* 275 */       this.currentProfile == 2 && !Save.save2.exists()) || (
/* 276 */       this.currentProfile == 3 && !Save.save3.exists()) || 
/* 277 */       this.currentProfile == 0) {
/* 278 */       this.canDeleteProfile = false;
/* 279 */     } else if ((this.currentProfile == 1 && Save.save1.exists()) || (
/* 280 */       this.currentProfile == 2 && Save.save2.exists()) || (
/* 281 */       this.currentProfile == 3 && Save.save3.exists())) {
/* 282 */       this.canDeleteProfile = true;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render(Graphics g) {
/* 289 */     g.setColor(Game.skyColor);
/* 290 */     g.fillRect(0, 0, Game.width, Game.height);
/* 292 */     this.cloud1.render(g);
/* 293 */     this.cloud2.render(g);
/* 294 */     this.cloud3.render(g);
/* 296 */     if (this.menuState == 1) {
/* 297 */       renderState1(g);
/* 298 */     } else if (this.menuState == 2) {
/* 299 */       renderState2(g);
/* 300 */     } else if (this.menuState == 3) {
/* 301 */       renderState3(g);
/* 302 */     } else if (this.menuState == 4) {
/* 303 */       renderState4(g);
/* 304 */     } else if (this.menuState != 5) {
/* 306 */       if (this.menuState == 6)
/* 307 */         renderState6(g); 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void renderState1(Graphics g) {
/* 316 */     this.fm = g.getFontMetrics(Game.profileInfoFont);
/* 317 */     this.fm2 = g.getFontMetrics(Game.buttonTextFont);
/* 320 */     g.drawImage(Game.logoImage, 
/* 321 */         Game.width / 2 - Game.logoImage.getWidth(), Game.height / 2 - 
/* 322 */         Game.logoImage.getWidth() - 45, 
/* 323 */         Game.logoImage.getWidth() * 2, Game.logoImage.getHeight() * 2, 
/* 324 */         null);
/* 327 */     g.setFont(Game.buttonTextFont);
/* 328 */     g.setColor(Color.white);
/* 329 */     g.drawString(Game.title, 5, Game.height - 13);
/* 330 */     g.drawString(Game.copyright, 
/* 331 */         Game.width - this.fm2.stringWidth(Game.copyright) + 10, 
/* 332 */         Game.height - 13);
/* 335 */     drawButton(g, Game.width / 2 - 168, Game.height / 2, 336, 32, "Play", 
/* 336 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 337 */         ImageManager.button2_3, 1.1D);
/* 340 */     drawButton(g, Game.width / 2 - 168, Game.height / 2 + 48, 
/* 341 */         ImageManager.button2_1.getWidth(), 
/* 342 */         ImageManager.button2_1.getHeight(), "Options", 
/* 343 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 344 */         ImageManager.button2_3, 1.2D);
/* 347 */     drawButton(g, Game.width / 2 - 168, Game.height / 2 + 48 + 48, 
/* 348 */         ImageManager.button2_1.getWidth(), 
/* 349 */         ImageManager.button2_1.getHeight(), "Quit", 
/* 350 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 351 */         ImageManager.button2_3, 1.4D);
/*     */   }
/*     */   
/*     */   private void renderState2(Graphics g) {
/* 359 */     this.fm = g.getFontMetrics(Game.gameProgressFont);
/* 361 */     g.setFont(Game.profileInfoFont);
/* 362 */     g.setColor(Game.profileInfoColor);
/* 366 */     if (this.save1State == 3) {
/* 367 */       g.drawImage(ImageManager.profileSelection, Game.width / 2 - 150, 
/* 368 */           43, 300, 117, null);
/* 369 */       this.currentProfile = 1;
/* 370 */       profileCheck();
/* 371 */     } else if (this.save2State == 3) {
/* 372 */       g.drawImage(ImageManager.profileSelection, Game.width / 2 - 150, 
/* 373 */           153, 300, 117, null);
/* 374 */       this.currentProfile = 2;
/* 375 */       profileCheck();
/* 376 */     } else if (this.save3State == 3) {
/* 377 */       g.drawImage(ImageManager.profileSelection, Game.width / 2 - 150, 
/* 378 */           263, 300, 117, null);
/* 379 */       this.currentProfile = 3;
/* 380 */       profileCheck();
/*     */     } 
/* 385 */     drawProfile(g, this.save1State, Game.width / 2 - 144, 50, 
/* 386 */         Save.save1LastPlayed, Save.save1Made, Save.save1, 1, this.save1Name, 
/* 387 */         this.fm);
/* 389 */     drawProfile(g, this.save2State, Game.width / 2 - 144, 160, 
/* 390 */         Save.save2LastPlayed, Save.save2Made, Save.save2, 2, this.save2Name, 
/* 391 */         this.fm);
/* 393 */     drawProfile(g, this.save3State, Game.width / 2 - 144, 270, 
/* 394 */         Save.save3LastPlayed, Save.save3Made, Save.save3, 3, this.save3Name, 
/* 395 */         this.fm);
/* 397 */     this.fm2 = g.getFontMetrics(Game.buttonTextFont);
/* 401 */     if (this.canPlayProfile) {
/* 402 */       drawButton(g, Game.width / 2 - 
/* 403 */           ImageManager.button2_1.getWidth() / 2, 425, 
/* 404 */           ImageManager.button2_1.getWidth(), 
/* 405 */           ImageManager.button2_1.getHeight(), "Play Profile", 
/* 406 */           ImageManager.button2_1, ImageManager.button2_2, 
/* 407 */           ImageManager.button2_3, 2.1D);
/* 408 */     } else if (!this.canPlayProfile) {
/* 409 */       g.setFont(Game.buttonTextFont);
/* 410 */       g.drawImage(ImageManager.button2_3, Game.width / 2 - 
/* 411 */           ImageManager.button2_3.getWidth() / 2, 425, 
/* 412 */           ImageManager.button2_3.getWidth(), 
/* 413 */           ImageManager.button2_3.getHeight(), null);
/* 414 */       g.setColor(Game.buttonClickedColor);
/* 415 */       g.drawString("Play Profile", 
/* 416 */           Game.width / 2 - this.fm2.stringWidth("Play Profile") / 2, 
/* 417 */           446);
/*     */     } 
/* 422 */     if (this.canDeleteProfile) {
/* 423 */       drawButton(g, Game.width / 2 - 
/* 424 */           ImageManager.button2_1.getWidth() / 2, 473, 
/* 425 */           ImageManager.button1_1.getWidth(), 
/* 426 */           ImageManager.button1_1.getHeight(), "Delete", 
/* 427 */           ImageManager.button1_1, ImageManager.button1_2, 
/* 428 */           ImageManager.button1_3, 2.2D);
/* 429 */     } else if (!this.canDeleteProfile) {
/* 430 */       g.setFont(Game.buttonTextFont);
/* 431 */       g.drawImage(ImageManager.button1_3, Game.width / 2 - 
/* 432 */           ImageManager.button2_1.getWidth() / 2, 473, 
/* 433 */           ImageManager.button1_3.getWidth(), 
/* 434 */           ImageManager.button1_3.getHeight(), null);
/* 435 */       g.setColor(Game.buttonClickedColor);
/* 436 */       g.drawString(
/* 437 */           "Delete", 
/* 438 */           Game.width / 2 - ImageManager.button1_1.getWidth() / 2 - 8 - 
/* 439 */           this.fm2.stringWidth("Delete") / 2, 
/* 440 */           473 + ImageManager.button1_3.getHeight() / 2 + 5);
/*     */     } 
/* 445 */     drawButton(g, Game.width / 2 - 
/* 446 */         ImageManager.button2_1.getWidth() / 2 + 176, 473, 
/* 447 */         ImageManager.button1_1.getWidth(), 
/* 448 */         ImageManager.button1_1.getHeight(), "Back", 
/* 449 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 450 */         ImageManager.button1_3, 2.3D);
/*     */   }
/*     */   
/*     */   private void renderState3(Graphics g) {
/* 458 */     g.setFont(Game.areYouSureFont);
/* 459 */     g.setColor(Game.profileInfoColor);
/* 460 */     g.drawString("Are you sure?", 280, 190);
/* 462 */     g.setFont(Game.buttonTextFont);
/* 464 */     drawButton(g, Game.width / 2 - 204, 325, 
/* 465 */         ImageManager.button1_1.getWidth(), 
/* 466 */         ImageManager.button1_1.getHeight(), "Yes", 
/* 467 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 468 */         ImageManager.button1_3, 3.1D);
/* 470 */     drawButton(g, Game.width / 2 + 35, 325, 
/* 471 */         ImageManager.button1_1.getWidth(), 
/* 472 */         ImageManager.button1_1.getHeight(), "No", 
/* 473 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 474 */         ImageManager.button1_3, 3.2D);
/*     */   }
/*     */   
/*     */   private void renderState4(Graphics g) {
/* 481 */     this.o.render(g);
/*     */   }
/*     */   
/*     */   private void renderState6(Graphics g) {
/* 488 */     g.setFont(Game.buttonTextFont);
/* 489 */     g.setColor(Game.profileInfoColor);
/* 491 */     this.fm = g.getFontMetrics(Game.buttonTextFont);
/* 493 */     g.drawString("You were killed!", 
/* 494 */         Game.width / 2 - this.fm.stringWidth("You were killed!") / 2, 
/* 495 */         200);
/* 497 */     drawButton(g, Game.width / 2 - 
/* 498 */         ImageManager.button2_1.getWidth() / 2, 275, 
/* 499 */         ImageManager.button2_1.getWidth(), 
/* 500 */         ImageManager.button2_1.getHeight(), "Respawn", 
/* 501 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 502 */         ImageManager.button2_3, 6.1D);
/* 504 */     drawButton(g, Game.width / 2 - 
/* 505 */         ImageManager.button2_1.getWidth() / 2, 323, 
/* 506 */         ImageManager.button2_1.getWidth(), 
/* 507 */         ImageManager.button2_1.getHeight(), "Save and Quit to Title", 
/* 508 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 509 */         ImageManager.button2_3, 6.2D);
/*     */   }
/*     */   
/*     */   private void m1Play() {
/* 514 */     this.menuState = 2;
/* 515 */     Load.loadData(Game.dataPath);
/* 516 */     profileCheck();
/* 517 */     Game.endClick();
/*     */   }
/*     */   
/*     */   public void m1Options() {
/* 521 */     this.menuState = 4;
/* 522 */     this.o = new Options();
/* 523 */     Game.endClick();
/*     */   }
/*     */   
/*     */   private void m1Quit() {
/* 527 */     System.exit(0);
/*     */   }
/*     */   
/*     */   public void m2PlayProfile() throws IOException {
/* 531 */     if (this.currentProfile == 1) {
/* 532 */       if (Save.save1.exists()) {
/* 533 */         Load.loadProfile(Game.save1Path);
/* 534 */         Save.profileSave(Save.save1, Game.save1Path, 1);
/* 535 */         enterGame();
/* 536 */       } else if (!Save.save1.exists()) {
/* 537 */         this.save1Name = "";
/* 538 */         (Game.getPlayer()).typedName = "";
/* 539 */         this.cancelState = 0;
/* 540 */         this.proc = new ProfileCreator();
/* 541 */         this.proc.createWindow(1);
/*     */       } 
/* 543 */     } else if (this.currentProfile == 2) {
/* 544 */       if (Save.save2.exists()) {
/* 545 */         Load.loadProfile(Game.save2Path);
/* 546 */         Save.profileSave(Save.save2, Game.save2Path, 2);
/* 547 */         enterGame();
/* 548 */       } else if (!Save.save2.exists()) {
/* 549 */         this.save2Name = "";
/* 550 */         (Game.getPlayer()).typedName = "";
/* 551 */         this.cancelState = 0;
/* 552 */         this.proc = new ProfileCreator();
/* 553 */         this.proc.createWindow(2);
/*     */       } 
/* 555 */     } else if (this.currentProfile == 3) {
/* 556 */       if (Save.save3.exists()) {
/* 557 */         Load.loadProfile(Game.save3Path);
/* 558 */         Save.profileSave(Save.save3, Game.save3Path, 3);
/* 559 */         enterGame();
/* 560 */       } else if (!Save.save3.exists()) {
/* 561 */         this.save3Name = "";
/* 562 */         (Game.getPlayer()).typedName = "";
/* 563 */         this.cancelState = 0;
/* 564 */         this.proc = new ProfileCreator();
/* 565 */         this.proc.createWindow(3);
/*     */       } 
/*     */     } 
/* 568 */     Game.endClick();
/* 569 */     TestDummy.reset();
/* 570 */     this.save1State = 0;
/* 571 */     this.save2State = 0;
/* 572 */     this.save3State = 0;
/*     */   }
/*     */   
/*     */   private void m2DeleteProfile() throws IOException {
/* 576 */     if (this.currentProfile == 1) {
/* 577 */       Save.save1.delete();
/* 578 */       Save.save1Made = "";
/* 579 */       Save.save1LastPlayed = "";
/* 580 */       Save.dataSave();
/* 581 */     } else if (this.currentProfile == 2) {
/* 582 */       Save.save2.delete();
/* 583 */       Save.save2Made = "";
/* 584 */       Save.save2LastPlayed = "";
/* 585 */       Save.dataSave();
/* 586 */     } else if (this.currentProfile == 3) {
/* 587 */       Save.save3.delete();
/* 588 */       Save.save3Made = " ";
/* 589 */       Save.save3LastPlayed = " ";
/* 590 */       Save.dataSave();
/*     */     } 
/* 592 */     this.menuState = 2;
/* 593 */     this.currentProfile = 0;
/* 594 */     profileCheck();
/* 595 */     Game.endClick();
/*     */   }
/*     */   
/*     */   private void m2Back() {
/* 599 */     this.save1State = 0;
/* 600 */     this.save2State = 0;
/* 601 */     this.save3State = 0;
/* 602 */     this.currentProfile = 0;
/* 603 */     this.menuState = 1;
/* 604 */     Game.endClick();
/*     */   }
/*     */   
/*     */   private void m3Yes() {
/*     */     try {
/* 609 */       m2DeleteProfile();
/* 610 */     } catch (IOException e) {
/* 611 */       e.printStackTrace();
/*     */     } 
/* 613 */     Game.endClick();
/*     */   }
/*     */   
/*     */   private void m3No() {
/* 617 */     this.menuState = 2;
/* 618 */     Game.endClick();
/*     */   }
/*     */   
/*     */   public void m5CreateProfile(File save, String path) throws IOException {
/* 622 */     Save.profileReset();
/* 623 */     if (this.currentProfile == 1 && this.save1Name.length() == 0) {
/* 624 */       this.save1Name = "Profile 1";
/* 625 */       this.save1Name_backup = this.save1Name;
/* 626 */     } else if (this.currentProfile == 2 && this.save2Name.length() == 0) {
/* 627 */       this.save2Name = "Profile 2";
/* 628 */       this.save2Name_backup = this.save2Name;
/* 629 */     } else if (this.currentProfile == 3 && this.save3Name.length() == 0) {
/* 630 */       this.save3Name = "Profile 3";
/* 631 */       this.save3Name_backup = this.save3Name;
/*     */     } 
/* 633 */     if ((Game.getPlayer()).typedName.length() == 0) {
/* 634 */       (Game.getPlayer()).name = (Game.getPlayer()).defaultName;
/* 635 */     } else if ((Game.getPlayer()).typedName.length() >= 1) {
/* 636 */       (Game.getPlayer()).name = (Game.getPlayer()).typedName;
/*     */     } 
/* 638 */     Save.profileSave(save, path, this.currentProfile);
/* 639 */     Load.loadProfile(path);
/* 640 */     enterGame();
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.8_0.jar!\beyondOrigins\main\menus\MainMenu.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */