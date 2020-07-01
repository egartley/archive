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
/*  25 */   private About ab = new About();
/*     */   
/*  26 */   private Keys k = new Keys();
/*     */   
/*     */   private FontMetrics fm;
/*     */   
/*     */   public Options() {
/*  30 */     Load.loadData(Game.dataPath);
/*  31 */     if (autoSaveToggle == "On" && !Game.autoSave) {
/*  32 */       autoSaveToggle = "Off";
/*  33 */     } else if (autoSaveToggle == "Off" && Game.autoSave) {
/*  34 */       autoSaveToggle = "On";
/*     */     } 
/*  36 */     if (tdToggle == "On" && !Game.dummy) {
/*  37 */       tdToggle = "Off";
/*  38 */     } else if (tdToggle == "Off" && Game.dummy) {
/*  39 */       tdToggle = "On";
/*     */     } 
/*  41 */     if (soundToggle == "On" && !Game.sound) {
/*  42 */       soundToggle = "Off";
/*  43 */     } else if (soundToggle == "Off" && Game.sound) {
/*  44 */       soundToggle = "On";
/*     */     } 
/*     */   }
/*     */   
/*     */   private int getPosX(int num) {
/*  49 */     int re = 0;
/*  50 */     if (num == 0) {
/*  51 */       re = 72;
/*  52 */     } else if (num == 1) {
/*  53 */       re = 424;
/*     */     } 
/*  55 */     return re;
/*     */   }
/*     */   
/*     */   private int getPosY(int num) {
/*  59 */     int re = 100;
/*  60 */     if (num == 0) {
/*  61 */       re += 0;
/*     */     } else {
/*  63 */       for (int i = 0; i < num; i++) {
/*  64 */         re += 32;
/*  65 */         re += 16;
/*     */       } 
/*     */     } 
/*  68 */     return re;
/*     */   }
/*     */   
/*     */   private byte getButtonState(int x, int y, int width, int height, byte state) {
/*  75 */     if (MouseMotion.mouseX >= x && MouseMotion.mouseX < x + width && 
/*  76 */       MouseMotion.mouseY >= y && MouseMotion.mouseY < y + height) {
/*  77 */       state = 2;
/*  78 */       if (Game.mouseIsPressed()) {
/*  79 */         state = 3;
/*     */       } else {
/*  81 */         state = 2;
/*     */       } 
/*     */     } else {
/*  83 */       state = 1;
/*     */     } 
/*  84 */     return state;
/*     */   }
/*     */   
/*     */   private void drawButton(Graphics g, int x, int y, int width, int height, String buttonText, BufferedImage state1Image, BufferedImage state2Image, BufferedImage state3Image, double clickEventType) {
/*  91 */     this.fm = g.getFontMetrics(Game.buttonTextFont);
/*  93 */     g.setFont(Game.buttonTextFont);
/*  94 */     if (getButtonState(x, y, width, height, this.state) == 1) {
/*  95 */       g.drawImage(state1Image, x, y, width, height, null);
/*  96 */       g.setColor(Game.buttonIdleColor);
/*  97 */       g.drawString(
/*  98 */           buttonText, 
/*  99 */           x + state1Image.getWidth() / 2 - 
/* 100 */           this.fm.stringWidth(buttonText) / 2, y + 
/* 101 */           state1Image.getHeight() / 2 + 5);
/* 102 */     } else if (getButtonState(x, y, width, height, this.state) == 2) {
/* 103 */       g.drawImage(state2Image, x, y, width, height, null);
/* 104 */       g.setColor(Game.buttonSelectedColor);
/* 105 */       g.drawString(
/* 106 */           buttonText, 
/* 107 */           x + state1Image.getWidth() / 2 - 
/* 108 */           this.fm.stringWidth(buttonText) / 2, y + 
/* 109 */           state1Image.getHeight() / 2 + 5);
/* 110 */     } else if (getButtonState(x, y, width, height, this.state) == 3) {
/* 111 */       g.drawImage(state3Image, x, y, width, height, null);
/* 112 */       g.setColor(Game.buttonClickedColor);
/* 113 */       g.drawString(
/* 114 */           buttonText, 
/* 115 */           x + state1Image.getWidth() / 2 - 
/* 116 */           this.fm.stringWidth(buttonText) / 2, y + 
/* 117 */           state1Image.getHeight() / 2 + 5);
/* 118 */       clickEventHandler(clickEventType);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void clickEventHandler(double e) {
/* 123 */     if (e == 4.1D) {
/* 124 */       m4AutoSave();
/* 125 */     } else if (e == 4.2D) {
/* 126 */       m4AddOns();
/* 127 */     } else if (e == 4.3D) {
/* 128 */       m4TestDummy();
/* 129 */     } else if (e == 4.4D) {
/* 130 */       m4Reload();
/* 131 */     } else if (e == 4.5D) {
/* 132 */       m4About();
/* 133 */     } else if (e == 4.6D) {
/* 134 */       m4ResetFiles();
/* 135 */     } else if (e == 4.7D) {
/* 136 */       m4Keys();
/* 137 */     } else if (e == 4.8D) {
/* 138 */       m4Sound();
/* 139 */     } else if (e == 4.0D) {
/* 140 */       m4Back();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render(Graphics g) {
/* 145 */     this.fm = g.getFontMetrics(Game.profileInfoFont);
/* 147 */     drawButton(g, getPosX(0), getPosY(0), 
/* 148 */         ImageManager.button2_1.getWidth(), 
/* 149 */         ImageManager.button2_1.getHeight(), "Auto Save: " + 
/* 150 */         autoSaveToggle, ImageManager.button2_1, 
/* 151 */         ImageManager.button2_2, ImageManager.button2_3, 4.1D);
/* 152 */     g.setColor(Game.profileInfoColor);
/* 153 */     g.setFont(Game.profileInfoFont);
/* 155 */     drawButton(g, getPosX(1), getPosY(0), 
/* 156 */         ImageManager.button2_1.getWidth(), 
/* 157 */         ImageManager.button2_1.getHeight(), "Test Dummy: " + tdToggle, 
/* 158 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 159 */         ImageManager.button2_3, 4.3D);
/* 161 */     drawButton(g, getPosX(0), getPosY(1), 
/* 162 */         ImageManager.button2_1.getWidth(), 
/* 163 */         ImageManager.button2_1.getHeight(), "Reload Graphics", 
/* 164 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 165 */         ImageManager.button2_3, 4.4D);
/* 167 */     drawButton(g, getPosX(1), getPosY(1), 
/* 168 */         ImageManager.button2_1.getWidth(), 
/* 169 */         ImageManager.button2_1.getHeight(), "Reset Files", 
/* 170 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 171 */         ImageManager.button2_3, 4.6D);
/* 173 */     drawButton(g, getPosX(0), getPosY(2), 
/* 174 */         ImageManager.button2_1.getWidth(), 
/* 175 */         ImageManager.button2_1.getHeight(), "Sound: " + soundToggle, 
/* 176 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 177 */         ImageManager.button2_3, 4.8D);
/* 179 */     drawButton(g, Game.width / 2 + 8, 445, 
/* 180 */         ImageManager.button1_1.getWidth(), 
/* 181 */         ImageManager.button1_1.getHeight(), "About...", 
/* 182 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 183 */         ImageManager.button1_3, 4.5D);
/* 185 */     drawButton(g, Game.width / 2 - 
/* 186 */         ImageManager.button1_1.getWidth() * 2 + 24, 
/* 187 */         445, ImageManager.button1_1.getWidth(), 
/* 188 */         ImageManager.button1_1.getHeight(), "Add-Ons...", 
/* 189 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 190 */         ImageManager.button1_3, 4.2D);
/* 192 */     drawButton(g, Game.width / 2 - 
/* 193 */         ImageManager.button1_1.getWidth() + 8, 445, 
/* 194 */         ImageManager.button1_1.getWidth(), 
/* 195 */         ImageManager.button1_1.getHeight(), "Keys...", 
/* 196 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 197 */         ImageManager.button1_3, 4.7D);
/* 199 */     drawButton(g, Game.width / 2 + 
/* 200 */         ImageManager.button1_1.getWidth() + 24, 
/* 201 */         445, ImageManager.button1_1.getWidth(), 
/* 202 */         ImageManager.button1_1.getHeight(), "Back", 
/* 203 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 204 */         ImageManager.button1_3, 4.0D);
/*     */   }
/*     */   
/*     */   private void m4AutoSave() {
/* 208 */     if (autoSaveToggle == "On") {
/* 209 */       autoSaveToggle = "Off";
/* 210 */       Game.autoSave = false;
/* 211 */     } else if (autoSaveToggle == "Off") {
/* 212 */       autoSaveToggle = "On";
/* 213 */       Game.autoSave = true;
/*     */     } 
/* 215 */     Game.endClick();
/*     */     try {
/* 217 */       Save.dataSave();
/* 218 */     } catch (IOException e) {
/* 219 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void m4TestDummy() {
/* 224 */     if (tdToggle == "On") {
/* 225 */       tdToggle = "Off";
/* 226 */       Game.dummy = false;
/* 227 */     } else if (tdToggle == "Off") {
/* 228 */       tdToggle = "On";
/* 229 */       Game.dummy = true;
/*     */     } 
/* 231 */     Game.endClick();
/*     */     try {
/* 233 */       Save.dataSave();
/* 234 */     } catch (IOException e) {
/* 235 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void m4Sound() {
/* 240 */     if (soundToggle == "On") {
/* 241 */       soundToggle = "Off";
/* 242 */       Game.sound = false;
/* 243 */     } else if (soundToggle == "Off") {
/* 244 */       soundToggle = "On";
/* 245 */       Game.sound = true;
/*     */     } 
/* 247 */     Game.endClick();
/*     */     try {
/* 249 */       Save.dataSave();
/* 250 */     } catch (IOException e) {
/* 251 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void m4AddOns() {
/* 257 */     Noti.startNotify(Noti.cms);
/* 258 */     Game.endClick();
/*     */   }
/*     */   
/*     */   private void m4Reload() {
/* 262 */     Game.loadGfx();
/* 263 */     Noti.startNotify(Noti.gre);
/* 264 */     Game.endClick();
/*     */   }
/*     */   
/*     */   private void m4About() {
/* 268 */     this.ab.createWindow();
/* 269 */     Game.endClick();
/*     */   }
/*     */   
/*     */   private void m4ResetFiles() {
/* 273 */     if (!Profile1.file.exists() && !Profile2.file.exists() && 
/* 274 */       !Profile3.file.exists() && !Save.data.exists() && 
/* 275 */       !Save.keys.exists()) {
/* 276 */       Noti.fre.setText("No files were detected, but all values were reset!");
/* 277 */     } else if ((Profile1.file.delete() || Profile2.file.delete() || Profile3.file
/* 278 */       .delete()) && Save.data.delete() && Save.keys.delete()) {
/* 279 */       Noti.fre.setText("All files deleted and all values reset!");
/*     */     } else {
/* 281 */       Profile1.file.delete();
/* 282 */       Profile2.file.delete();
/* 283 */       Profile3.file.delete();
/* 284 */       Save.data.delete();
/* 285 */       Save.keys.delete();
/* 286 */       Noti.fre.setText("Some files deleted and all values were reset!");
/*     */     } 
/* 288 */     Save.dataReset();
/* 289 */     Save.profileReset();
/* 290 */     Game.logger.log.delete();
/* 291 */     Noti.startNotify(Noti.fre);
/* 292 */     Game.endClick();
/*     */   }
/*     */   
/*     */   private void m4Keys() {
/* 296 */     this.k.createWindow();
/* 297 */     Game.endClick();
/*     */   }
/*     */   
/*     */   private void m4Back() {
/* 301 */     (Game.getMainMenu()).save1State = 0;
/* 302 */     (Game.getMainMenu()).save2State = 0;
/* 303 */     (Game.getMainMenu()).save3State = 0;
/* 304 */     (Game.getMainMenu()).currentProfile = 0;
/* 305 */     (Game.getMainMenu()).menuState = 1;
/* 306 */     Game.endClick();
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.1.0_4.jar!\com\emgartley\beyondOrigins\main\menus\Options.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */