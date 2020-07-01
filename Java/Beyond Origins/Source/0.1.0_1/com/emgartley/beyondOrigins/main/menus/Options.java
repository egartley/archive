/*     */ package com.emgartley.beyondOrigins.main.menus;
/*     */ 
/*     */ import com.emgartley.beyondOrigins.files.Load;
/*     */ import com.emgartley.beyondOrigins.files.Save;
/*     */ import com.emgartley.beyondOrigins.main.Game;
/*     */ import com.emgartley.beyondOrigins.main.Profile1;
/*     */ import com.emgartley.beyondOrigins.main.Profile2;
/*     */ import com.emgartley.beyondOrigins.main.Profile3;
/*     */ import com.emgartley.beyondOrigins.main.gfx.ImageManager;
/*     */ import com.emgartley.beyondOrigins.main.threads.Noti;
/*     */ import com.emgartley.beyondOrigins.main.windows.About;
/*     */ import com.emgartley.beyondOrigins.main.windows.Keys;
/*     */ import com.emgartley.beyondOrigins.userInput.MouseMotion;
/*     */ import java.awt.FontMetrics;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.IOException;
/*     */ 
/*     */ public class Options {
/*  22 */   public static String autoSaveToggle = "On", tdToggle = "Off";
/*     */   
/*  23 */   public static String soundToggle = "On";
/*     */   
/*     */   private byte state;
/*     */   
/*  26 */   private About ab = new About();
/*     */   
/*  27 */   private Keys k = new Keys();
/*     */   
/*     */   private FontMetrics fm;
/*     */   
/*     */   public Options() {
/*  31 */     Load.loadData(Game.dataPath);
/*  32 */     if (autoSaveToggle == "On" && !Game.autoSave) {
/*  33 */       autoSaveToggle = "Off";
/*  34 */     } else if (autoSaveToggle == "Off" && Game.autoSave) {
/*  35 */       autoSaveToggle = "On";
/*     */     } 
/*  37 */     if (tdToggle == "On" && !Game.dummy) {
/*  38 */       tdToggle = "Off";
/*  39 */     } else if (tdToggle == "Off" && Game.dummy) {
/*  40 */       tdToggle = "On";
/*     */     } 
/*  42 */     if (soundToggle == "On" && !Game.sound) {
/*  43 */       soundToggle = "Off";
/*  44 */     } else if (soundToggle == "Off" && Game.sound) {
/*  45 */       soundToggle = "On";
/*     */     } 
/*     */   }
/*     */   
/*     */   private int getPosX(int num) {
/*  50 */     int re = 0;
/*  51 */     if (num == 0) {
/*  52 */       re = 72;
/*  53 */     } else if (num == 1) {
/*  54 */       re = 424;
/*     */     } 
/*  56 */     return re;
/*     */   }
/*     */   
/*     */   private int getPosY(int num) {
/*  60 */     int re = 100;
/*  61 */     if (num == 0) {
/*  62 */       re += 0;
/*     */     } else {
/*  64 */       for (int i = 0; i < num; i++) {
/*  65 */         re += 32;
/*  66 */         re += 16;
/*     */       } 
/*     */     } 
/*  69 */     return re;
/*     */   }
/*     */   
/*     */   private byte getButtonState(int x, int y, int width, int height, byte state) {
/*  76 */     if (MouseMotion.mouseX >= x && MouseMotion.mouseX < x + width && 
/*  77 */       MouseMotion.mouseY >= y && MouseMotion.mouseY < y + height) {
/*  78 */       state = 2;
/*  79 */       if (Game.mouseIsPressed()) {
/*  80 */         state = 3;
/*     */       } else {
/*  82 */         state = 2;
/*     */       } 
/*     */     } else {
/*  84 */       state = 1;
/*     */     } 
/*  85 */     return state;
/*     */   }
/*     */   
/*     */   private void drawButton(Graphics g, int x, int y, int width, int height, String buttonText, BufferedImage state1Image, BufferedImage state2Image, BufferedImage state3Image, double clickEventType) {
/*  92 */     this.fm = g.getFontMetrics(Game.buttonTextFont);
/*  94 */     g.setFont(Game.buttonTextFont);
/*  95 */     if (getButtonState(x, y, width, height, this.state) == 1) {
/*  96 */       g.drawImage(state1Image, x, y, width, height, null);
/*  97 */       g.setColor(Game.buttonIdleColor);
/*  98 */       g.drawString(
/*  99 */           buttonText, 
/* 100 */           x + state1Image.getWidth() / 2 - 
/* 101 */           this.fm.stringWidth(buttonText) / 2, y + 
/* 102 */           state1Image.getHeight() / 2 + 5);
/* 103 */     } else if (getButtonState(x, y, width, height, this.state) == 2) {
/* 104 */       g.drawImage(state2Image, x, y, width, height, null);
/* 105 */       g.setColor(Game.buttonSelectedColor);
/* 106 */       g.drawString(
/* 107 */           buttonText, 
/* 108 */           x + state1Image.getWidth() / 2 - 
/* 109 */           this.fm.stringWidth(buttonText) / 2, y + 
/* 110 */           state1Image.getHeight() / 2 + 5);
/* 111 */     } else if (getButtonState(x, y, width, height, this.state) == 3) {
/* 112 */       g.drawImage(state3Image, x, y, width, height, null);
/* 113 */       g.setColor(Game.buttonClickedColor);
/* 114 */       g.drawString(
/* 115 */           buttonText, 
/* 116 */           x + state1Image.getWidth() / 2 - 
/* 117 */           this.fm.stringWidth(buttonText) / 2, y + 
/* 118 */           state1Image.getHeight() / 2 + 5);
/* 119 */       clickEventHandler(clickEventType);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void clickEventHandler(double e) {
/* 124 */     if (e == 4.1D) {
/* 125 */       m4AutoSave();
/* 126 */     } else if (e == 4.2D) {
/* 127 */       m4AddOns();
/* 128 */     } else if (e == 4.3D) {
/* 129 */       m4TestDummy();
/* 130 */     } else if (e == 4.4D) {
/* 131 */       m4Reload();
/* 132 */     } else if (e == 4.5D) {
/* 133 */       m4About();
/* 134 */     } else if (e == 4.6D) {
/* 135 */       m4ResetFiles();
/* 136 */     } else if (e == 4.7D) {
/* 137 */       m4Keys();
/* 138 */     } else if (e == 4.8D) {
/* 139 */       m4Sound();
/* 140 */     } else if (e == 4.0D) {
/* 141 */       m4Back();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render(Graphics g) {
/* 146 */     this.fm = g.getFontMetrics(Game.profileInfoFont);
/* 148 */     drawButton(g, getPosX(0), getPosY(0), 
/* 149 */         ImageManager.button2_1.getWidth(), 
/* 150 */         ImageManager.button2_1.getHeight(), "Auto Save: " + 
/* 151 */         autoSaveToggle, ImageManager.button2_1, 
/* 152 */         ImageManager.button2_2, ImageManager.button2_3, 4.1D);
/* 153 */     g.setColor(Game.profileInfoColor);
/* 154 */     g.setFont(Game.profileInfoFont);
/* 156 */     drawButton(g, getPosX(1), getPosY(0), 
/* 157 */         ImageManager.button2_1.getWidth(), 
/* 158 */         ImageManager.button2_1.getHeight(), "Test Dummy: " + tdToggle, 
/* 159 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 160 */         ImageManager.button2_3, 4.3D);
/* 162 */     drawButton(g, getPosX(0), getPosY(1), 
/* 163 */         ImageManager.button2_1.getWidth(), 
/* 164 */         ImageManager.button2_1.getHeight(), "Reload Graphics", 
/* 165 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 166 */         ImageManager.button2_3, 4.4D);
/* 168 */     drawButton(g, getPosX(1), getPosY(1), 
/* 169 */         ImageManager.button2_1.getWidth(), 
/* 170 */         ImageManager.button2_1.getHeight(), "Reset Files", 
/* 171 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 172 */         ImageManager.button2_3, 4.6D);
/* 174 */     drawButton(g, getPosX(0), getPosY(2), 
/* 175 */         ImageManager.button2_1.getWidth(), 
/* 176 */         ImageManager.button2_1.getHeight(), "Sound: " + soundToggle, 
/* 177 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 178 */         ImageManager.button2_3, 4.8D);
/* 180 */     drawButton(g, Game.width / 2 + 8, 445, 
/* 181 */         ImageManager.button1_1.getWidth(), 
/* 182 */         ImageManager.button1_1.getHeight(), "About...", 
/* 183 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 184 */         ImageManager.button1_3, 4.5D);
/* 186 */     drawButton(g, Game.width / 2 - 
/* 187 */         ImageManager.button1_1.getWidth() * 2 + 24, 
/* 188 */         445, ImageManager.button1_1.getWidth(), 
/* 189 */         ImageManager.button1_1.getHeight(), "Add-Ons...", 
/* 190 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 191 */         ImageManager.button1_3, 4.2D);
/* 193 */     drawButton(g, Game.width / 2 - 
/* 194 */         ImageManager.button1_1.getWidth() + 8, 445, 
/* 195 */         ImageManager.button1_1.getWidth(), 
/* 196 */         ImageManager.button1_1.getHeight(), "Keys...", 
/* 197 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 198 */         ImageManager.button1_3, 4.7D);
/* 200 */     drawButton(g, Game.width / 2 + 
/* 201 */         ImageManager.button1_1.getWidth() + 24, 
/* 202 */         445, ImageManager.button1_1.getWidth(), 
/* 203 */         ImageManager.button1_1.getHeight(), "Back", 
/* 204 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 205 */         ImageManager.button1_3, 4.0D);
/*     */   }
/*     */   
/*     */   private void m4AutoSave() {
/* 209 */     if (autoSaveToggle == "On") {
/* 210 */       autoSaveToggle = "Off";
/* 211 */       Game.autoSave = false;
/* 212 */     } else if (autoSaveToggle == "Off") {
/* 213 */       autoSaveToggle = "On";
/* 214 */       Game.autoSave = true;
/*     */     } 
/* 216 */     Game.endClick();
/*     */     try {
/* 218 */       Save.dataSave();
/* 219 */     } catch (IOException e) {
/* 220 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void m4TestDummy() {
/* 225 */     if (tdToggle == "On") {
/* 226 */       tdToggle = "Off";
/* 227 */       Game.dummy = false;
/* 228 */     } else if (tdToggle == "Off") {
/* 229 */       tdToggle = "On";
/* 230 */       Game.dummy = true;
/*     */     } 
/* 232 */     Game.endClick();
/*     */     try {
/* 234 */       Save.dataSave();
/* 235 */     } catch (IOException e) {
/* 236 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void m4Sound() {
/* 241 */     if (soundToggle == "On") {
/* 242 */       soundToggle = "Off";
/* 243 */       Game.sound = false;
/* 244 */     } else if (soundToggle == "Off") {
/* 245 */       soundToggle = "On";
/* 246 */       Game.sound = true;
/*     */     } 
/* 248 */     Game.endClick();
/*     */     try {
/* 250 */       Save.dataSave();
/* 251 */     } catch (IOException e) {
/* 252 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void m4AddOns() {
/* 258 */     Noti.startNotify(Noti.cms);
/* 259 */     Game.endClick();
/*     */   }
/*     */   
/*     */   private void m4Reload() {
/* 263 */     Game.loadGfx();
/* 264 */     Noti.startNotify(Noti.gre);
/* 265 */     Game.endClick();
/*     */   }
/*     */   
/*     */   private void m4About() {
/* 269 */     this.ab.createWindow();
/* 270 */     Game.endClick();
/*     */   }
/*     */   
/*     */   private void m4ResetFiles() {
/* 274 */     if (!Profile1.file.exists() && !Profile2.file.exists() && 
/* 275 */       !Profile3.file.exists() && !Save.data.exists() && 
/* 276 */       !Save.keys.exists()) {
/* 277 */       Noti.fre.setText("No files were detected, but all values were reset!");
/* 278 */     } else if ((Profile1.file.delete() || Profile2.file.delete() || Profile3.file
/* 279 */       .delete()) && Save.data.delete() && Save.keys.delete()) {
/* 280 */       Noti.fre.setText("All files deleted and all values reset!");
/*     */     } else {
/* 282 */       Profile1.file.delete();
/* 283 */       Profile2.file.delete();
/* 284 */       Profile3.file.delete();
/* 285 */       Save.data.delete();
/* 286 */       Save.keys.delete();
/* 287 */       Noti.fre.setText("Some files deleted and all values were reset!");
/*     */     } 
/* 289 */     Save.dataReset();
/* 290 */     Save.profileReset();
/* 291 */     Game.logger.log.delete();
/* 292 */     Noti.startNotify(Noti.fre);
/* 293 */     Game.endClick();
/*     */   }
/*     */   
/*     */   private void m4Keys() {
/* 297 */     this.k.createWindow();
/* 298 */     Game.endClick();
/*     */   }
/*     */   
/*     */   private void m4Back() {
/* 302 */     (Game.getMainMenu()).save1State = 0;
/* 303 */     (Game.getMainMenu()).save2State = 0;
/* 304 */     (Game.getMainMenu()).save3State = 0;
/* 305 */     (Game.getMainMenu()).currentProfile = 0;
/* 306 */     (Game.getMainMenu()).menuState = 1;
/* 307 */     Game.endClick();
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.1.0_1.jar!\com\emgartley\beyondOrigins\main\menus\Options.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */