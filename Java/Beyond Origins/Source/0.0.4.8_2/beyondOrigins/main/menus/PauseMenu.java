/*     */ package beyondOrigins.main.menus;
/*     */ 
/*     */ import beyondOrigins.main.Game;
/*     */ import beyondOrigins.main.MouseManager;
/*     */ import beyondOrigins.main.MouseMotion;
/*     */ import beyondOrigins.main.Save;
/*     */ import beyondOrigins.main.gfx.ImageManager;
/*     */ import java.awt.Color;
/*     */ import java.awt.Graphics;
/*     */ import java.io.IOException;
/*     */ 
/*     */ public class PauseMenu {
/*     */   public static boolean isOpen = false;
/*     */   
/*     */   private static int backToGameState;
/*     */   
/*     */   private static int saveAndQuitState;
/*     */   
/*     */   private static ImageManager im;
/*     */   
/*     */   public PauseMenu(ImageManager im) {
/*  22 */     PauseMenu.im = im;
/*     */   }
/*     */   
/*     */   public void tick() {
/*  27 */     buttonTick();
/*     */   }
/*     */   
/*     */   public int getState_Button(int minX, int minY, int width, int height, int state) {
/*  33 */     if (MouseMotion.mouseX >= minX && MouseMotion.mouseX < minX + width && 
/*  34 */       MouseMotion.mouseY >= minY && 
/*  35 */       MouseMotion.mouseY < minY + height) {
/*  36 */       state = 2;
/*  37 */       if (MouseManager.mouseFullClick == 1) {
/*  38 */         state = 3;
/*     */       } else {
/*  40 */         state = 2;
/*     */       } 
/*     */     } else {
/*  42 */       state = 1;
/*     */     } 
/*  43 */     return state;
/*     */   }
/*     */   
/*     */   public void buttonTick() {
/*  48 */     if (MouseMotion.mouseX >= 251 && MouseMotion.mouseX <= 584 && 
/*  49 */       MouseMotion.mouseY >= 120 && MouseMotion.mouseY <= 149) {
/*  50 */       backToGameState = 2;
/*  51 */       if (MouseManager.mouseFullClick == 1) {
/*  52 */         backToGameState = 3;
/*     */       } else {
/*  54 */         backToGameState = 2;
/*     */       } 
/*     */     } else {
/*  57 */       backToGameState = 1;
/*     */     } 
/*  60 */     if (MouseMotion.mouseX >= 251 && MouseMotion.mouseX <= 584 && 
/*  61 */       MouseMotion.mouseY >= 316 && MouseMotion.mouseY <= 344) {
/*  62 */       saveAndQuitState = 2;
/*  63 */       if (MouseManager.mouseFullClick == 1) {
/*  64 */         saveAndQuitState = 3;
/*     */       } else {
/*  66 */         saveAndQuitState = 2;
/*     */       } 
/*     */     } else {
/*  69 */       saveAndQuitState = 1;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void renderMain(Graphics g) {
/*  76 */     g.setColor(new Color(0, 0, 0, 145));
/*  77 */     g.fillRect(0, 0, 838, 573);
/*  79 */     g.setColor(Color.white);
/*  80 */     g.setFont(Game.default2);
/*  82 */     g.drawImage(im.button2_1, 251, 120, 336, 32, null);
/*  83 */     g.drawString("Back To Game", 355, 143);
/*  84 */     g.drawImage(im.button1_1, 251, 168, 160, 32, null);
/*  85 */     g.drawImage(im.button1_1, 427, 168, 160, 32, null);
/*  87 */     g.drawImage(im.button1_1, 251, 268, 160, 32, null);
/*  88 */     g.drawImage(im.button1_1, 427, 268, 160, 32, null);
/*  90 */     g.setColor(Color.gray);
/*  91 */     g.setFont(Game.menuText1);
/*  92 */     g.drawString("More stuff will be added here in the future.", 278, 440);
/*  94 */     g.setFont(Game.default2);
/*  96 */     if (getState_Button(251, 120, 336, 32, backToGameState) == 1) {
/*  97 */       g.drawImage(im.button2_1, 251, 120, 336, 32, null);
/*  98 */       g.setColor(Game.text1);
/*  99 */       g.drawString("Back To Game", 355, 143);
/* 100 */     } else if (getState_Button(251, 120, 336, 32, backToGameState) == 2) {
/* 101 */       g.drawImage(im.button2_2, 251, 120, 336, 32, null);
/* 102 */       g.setColor(Game.text2);
/* 103 */       g.drawString("Back To Game", 355, 143);
/* 104 */     } else if (getState_Button(251, 120, 336, 32, backToGameState) == 3) {
/* 105 */       g.drawImage(im.button2_3, 251, 120, 336, 32, null);
/* 106 */       g.setColor(Game.text3);
/* 107 */       g.drawString("Back To Game", 355, 143);
/* 108 */       isOpen = false;
/* 109 */       backToGameState = 1;
/*     */     } 
/* 112 */     if (getState_Button(251, 316, 336, 32, saveAndQuitState) == 1) {
/* 113 */       g.drawImage(im.button2_1, 251, 316, 336, 32, null);
/* 114 */       g.setColor(Game.text1);
/* 115 */       g.drawString("Save And Quit To Title", 315, 337);
/* 116 */     } else if (getState_Button(251, 316, 336, 32, saveAndQuitState) == 2) {
/* 117 */       g.drawImage(im.button2_2, 251, 316, 336, 32, null);
/* 118 */       g.setColor(Game.text2);
/* 119 */       g.drawString("Save And Quit To Title", 315, 337);
/* 120 */     } else if (getState_Button(251, 316, 336, 32, saveAndQuitState) == 3) {
/* 121 */       g.drawImage(im.button2_3, 251, 316, 336, 32, null);
/* 122 */       g.setColor(Game.text3);
/* 123 */       g.drawString("Save And Quit To Title", 315, 337);
/*     */       try {
/* 125 */         if (MainMenu.currentProfile == 1)
/* 125 */           Save.save1(); 
/* 126 */         if (MainMenu.currentProfile == 2)
/* 126 */           Save.save2(); 
/* 127 */         if (MainMenu.currentProfile == 3)
/* 127 */           Save.save3(); 
/* 128 */       } catch (IOException e) {
/* 129 */         e.printStackTrace();
/*     */       } 
/* 131 */       isOpen = false;
/* 132 */       Game.isInGame = false;
/* 133 */       saveAndQuitState = 1;
/* 134 */       MainMenu.menuState = 1;
/* 135 */       MainMenu.currentProfile = 0;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4.8_2.jar!\beyondOrigins\main\menus\PauseMenu.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */