/*     */ package beyondOrigins.main.menus;
/*     */ 
/*     */ import beyondOrigins.files.Load;
/*     */ import beyondOrigins.files.Save;
/*     */ import beyondOrigins.main.Game;
/*     */ import beyondOrigins.main.gfx.ImageManager;
/*     */ import beyondOrigins.main.windows.About;
/*     */ import beyondOrigins.main.windows.AddOns;
/*     */ import beyondOrigins.main.windows.Keys;
/*     */ import beyondOrigins.userInput.MouseMotion;
/*     */ import java.awt.FontMetrics;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.IOException;
/*     */ 
/*     */ public class Options {
/*  19 */   public static String autoSaveToggle = "On";
/*     */   
/*  19 */   public static String tdToggle = "Off";
/*     */   
/*     */   private byte state;
/*     */   
/*  21 */   private AddOns a = new AddOns();
/*     */   
/*  22 */   private About ab = new About();
/*     */   
/*  23 */   private Keys k = new Keys();
/*     */   
/*     */   private FontMetrics fm;
/*     */   
/*     */   public Options() {
/*  27 */     Load.loadData(Game.dataPath);
/*  28 */     if (autoSaveToggle == "On" && !Game.autoSave) {
/*  29 */       autoSaveToggle = "Off";
/*  30 */     } else if (autoSaveToggle == "Off" && Game.autoSave) {
/*  31 */       autoSaveToggle = "On";
/*     */     } 
/*  33 */     if (tdToggle == "On" && !Game.dummy) {
/*  34 */       tdToggle = "Off";
/*  35 */     } else if (tdToggle == "Off" && Game.dummy) {
/*  36 */       tdToggle = "On";
/*     */     } 
/*     */   }
/*     */   
/*     */   private byte getButtonState(int x, int y, int width, int height, byte state) {
/*  44 */     if (MouseMotion.mouseX >= x && MouseMotion.mouseX < x + width && 
/*  45 */       MouseMotion.mouseY >= y && MouseMotion.mouseY < y + height) {
/*  46 */       state = 2;
/*  47 */       if (Game.mouseIsPressed()) {
/*  48 */         state = 3;
/*     */       } else {
/*  50 */         state = 2;
/*     */       } 
/*     */     } else {
/*  52 */       state = 1;
/*     */     } 
/*  53 */     return state;
/*     */   }
/*     */   
/*     */   private void drawButton(Graphics g, int x, int y, int width, int height, String buttonText, BufferedImage state1Image, BufferedImage state2Image, BufferedImage state3Image, double clickEventType) {
/*  60 */     this.fm = g.getFontMetrics(Game.buttonTextFont);
/*  62 */     g.setFont(Game.buttonTextFont);
/*  63 */     if (getButtonState(x, y, width, height, this.state) == 1) {
/*  64 */       g.drawImage(state1Image, x, y, width, height, null);
/*  65 */       g.setColor(Game.buttonIdleColor);
/*  66 */       g.drawString(
/*  67 */           buttonText, 
/*  68 */           x + state1Image.getWidth() / 2 - 
/*  69 */           this.fm.stringWidth(buttonText) / 2, y + 
/*  70 */           state1Image.getHeight() / 2 + 5);
/*  71 */     } else if (getButtonState(x, y, width, height, this.state) == 2) {
/*  72 */       g.drawImage(state2Image, x, y, width, height, null);
/*  73 */       g.setColor(Game.buttonSelectedColor);
/*  74 */       g.drawString(
/*  75 */           buttonText, 
/*  76 */           x + state1Image.getWidth() / 2 - 
/*  77 */           this.fm.stringWidth(buttonText) / 2, y + 
/*  78 */           state1Image.getHeight() / 2 + 5);
/*  79 */     } else if (getButtonState(x, y, width, height, this.state) == 3) {
/*  80 */       g.drawImage(state3Image, x, y, width, height, null);
/*  81 */       g.setColor(Game.buttonClickedColor);
/*  82 */       g.drawString(
/*  83 */           buttonText, 
/*  84 */           x + state1Image.getWidth() / 2 - 
/*  85 */           this.fm.stringWidth(buttonText) / 2, y + 
/*  86 */           state1Image.getHeight() / 2 + 5);
/*  87 */       clickEventHandler(clickEventType);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void clickEventHandler(double e) {
/*  92 */     if (e == 4.1D) {
/*  93 */       m4AutoSave();
/*  94 */     } else if (e == 4.2D) {
/*  95 */       m4AddOns();
/*  96 */     } else if (e == 4.3D) {
/*  97 */       m4TestDummy();
/*  98 */     } else if (e == 4.4D) {
/*  99 */       m4Reload();
/* 100 */     } else if (e == 4.5D) {
/* 101 */       m4About();
/* 102 */     } else if (e == 4.6D) {
/* 103 */       m4ResetFiles();
/* 104 */     } else if (e == 4.7D) {
/* 105 */       m4Keys();
/* 106 */     } else if (e == 4.0D) {
/* 107 */       m4Back();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render(Graphics g) {
/* 112 */     this.fm = g.getFontMetrics(Game.profileInfoFont);
/* 114 */     drawButton(g, Game.width / 2 - 
/* 115 */         ImageManager.button2_1.getWidth() + 8, 100, 
/* 116 */         ImageManager.button2_1.getWidth(), 
/* 117 */         ImageManager.button2_1.getHeight(), "Auto Save: " + 
/* 118 */         autoSaveToggle, ImageManager.button2_1, 
/* 119 */         ImageManager.button2_2, ImageManager.button2_3, 4.1D);
/* 120 */     g.setColor(Game.profileInfoColor);
/* 121 */     g.setFont(Game.profileInfoFont);
/* 123 */     drawButton(g, Game.width / 2 + 8, 100, 
/* 124 */         ImageManager.button2_1.getWidth(), 
/* 125 */         ImageManager.button2_1.getHeight(), "Test Dummy: " + tdToggle, 
/* 126 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 127 */         ImageManager.button2_3, 4.3D);
/* 129 */     drawButton(g, Game.width / 2 - 
/* 130 */         ImageManager.button2_1.getWidth() + 8, 148, 
/* 131 */         ImageManager.button2_1.getWidth(), 
/* 132 */         ImageManager.button2_1.getHeight(), "Reload Graphics", 
/* 133 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 134 */         ImageManager.button2_3, 4.4D);
/* 136 */     drawButton(g, Game.width / 2 + 8, 148, 
/* 137 */         ImageManager.button2_1.getWidth(), 
/* 138 */         ImageManager.button2_1.getHeight(), "Reset Files", 
/* 139 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 140 */         ImageManager.button2_3, 4.6D);
/* 142 */     drawButton(g, Game.width / 2 + 8, 445, 
/* 143 */         ImageManager.button1_1.getWidth(), 
/* 144 */         ImageManager.button1_1.getHeight(), "About...", 
/* 145 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 146 */         ImageManager.button1_3, 4.5D);
/* 148 */     drawButton(g, Game.width / 2 - 
/* 149 */         ImageManager.button1_1.getWidth() * 2 + 24, 
/* 150 */         445, ImageManager.button1_1.getWidth(), 
/* 151 */         ImageManager.button1_1.getHeight(), "Add-Ons...", 
/* 152 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 153 */         ImageManager.button1_3, 4.2D);
/* 155 */     drawButton(g, Game.width / 2 - 
/* 156 */         ImageManager.button1_1.getWidth() + 8, 445, 
/* 157 */         ImageManager.button1_1.getWidth(), 
/* 158 */         ImageManager.button1_1.getHeight(), "Keys...", 
/* 159 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 160 */         ImageManager.button1_3, 4.7D);
/* 162 */     drawButton(g, Game.width / 2 + 
/* 163 */         ImageManager.button1_1.getWidth() + 24, 
/* 164 */         445, ImageManager.button1_1.getWidth(), 
/* 165 */         ImageManager.button1_1.getHeight(), "Back", 
/* 166 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 167 */         ImageManager.button1_3, 4.0D);
/*     */   }
/*     */   
/*     */   private void m4AutoSave() {
/* 171 */     if (autoSaveToggle == "On") {
/* 172 */       autoSaveToggle = "Off";
/* 173 */       Game.autoSave = false;
/* 174 */     } else if (autoSaveToggle == "Off") {
/* 175 */       autoSaveToggle = "On";
/* 176 */       Game.autoSave = true;
/*     */     } 
/* 178 */     Game.endClick();
/*     */     try {
/* 180 */       Save.dataSave();
/* 181 */     } catch (IOException e) {
/* 182 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void m4TestDummy() {
/* 187 */     if (tdToggle == "On") {
/* 188 */       tdToggle = "Off";
/* 189 */       Game.dummy = false;
/* 190 */     } else if (tdToggle == "Off") {
/* 191 */       tdToggle = "On";
/* 192 */       Game.dummy = true;
/*     */     } 
/* 194 */     Game.endClick();
/*     */     try {
/* 196 */       Save.dataSave();
/* 197 */     } catch (IOException e) {
/* 198 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void m4AddOns() {
/* 203 */     this.a.createWindow();
/* 204 */     Game.endClick();
/*     */   }
/*     */   
/*     */   private void m4Reload() {
/* 208 */     Game.loadGfx();
/* 209 */     Game.startNotify(Game.gre);
/* 210 */     Game.endClick();
/*     */   }
/*     */   
/*     */   private void m4About() {
/* 214 */     this.ab.createWindow();
/* 215 */     Game.endClick();
/*     */   }
/*     */   
/*     */   private void m4ResetFiles() {
/* 219 */     if (!Save.save1.exists() && !Save.save2.exists() && 
/* 220 */       !Save.save3.exists() && !Save.data.exists() && 
/* 221 */       !Save.keys.exists()) {
/* 222 */       Game.fre.setText("No files were detected, but all values were reset!");
/* 223 */     } else if ((Save.save1.delete() || Save.save2.delete() || Save.save3
/* 224 */       .delete()) && Save.data.delete() && Save.keys.delete()) {
/* 225 */       Game.fre.setText("All files deleted and all values reset!");
/*     */     } else {
/* 227 */       Save.save1.delete();
/* 228 */       Save.save2.delete();
/* 229 */       Save.save3.delete();
/* 230 */       Save.data.delete();
/* 231 */       Save.keys.delete();
/* 232 */       Game.fre.setText("Some files deleted and all values were reset!");
/*     */     } 
/* 234 */     Save.dataReset();
/* 235 */     Save.profileReset();
/* 236 */     Game.startNotify(Game.fre);
/* 237 */     Game.endClick();
/*     */   }
/*     */   
/*     */   private void m4Keys() {
/* 241 */     this.k.createWindow();
/* 242 */     Game.endClick();
/*     */   }
/*     */   
/*     */   private void m4Back() {
/* 246 */     (Game.getMainMenu()).save1State = 0;
/* 247 */     (Game.getMainMenu()).save2State = 0;
/* 248 */     (Game.getMainMenu()).save3State = 0;
/* 249 */     (Game.getMainMenu()).currentProfile = 0;
/* 250 */     (Game.getMainMenu()).menuState = 1;
/* 251 */     Game.endClick();
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.8_2.jar!\beyondOrigins\main\menus\Options.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */