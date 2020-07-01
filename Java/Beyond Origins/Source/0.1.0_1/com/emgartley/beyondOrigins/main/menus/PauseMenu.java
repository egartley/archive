/*     */ package com.emgartley.beyondOrigins.main.menus;
/*     */ 
/*     */ import com.emgartley.beyondOrigins.files.Save;
/*     */ import com.emgartley.beyondOrigins.main.Game;
/*     */ import com.emgartley.beyondOrigins.main.Profile1;
/*     */ import com.emgartley.beyondOrigins.main.Profile2;
/*     */ import com.emgartley.beyondOrigins.main.Profile3;
/*     */ import com.emgartley.beyondOrigins.main.gfx.ImageManager;
/*     */ import com.emgartley.beyondOrigins.userInput.MouseMotion;
/*     */ import java.awt.Color;
/*     */ import java.awt.FontMetrics;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.IOException;
/*     */ 
/*     */ public class PauseMenu {
/*     */   public static boolean isOpen = false;
/*     */   
/*     */   private FontMetrics fm;
/*     */   
/*     */   private int backToGameState;
/*     */   
/*     */   private int saveAndQuitState;
/*     */   
/*     */   public int getButtonState(int minX, int minY, int width, int height, int state) {
/*  26 */     if (MouseMotion.mouseX >= minX && MouseMotion.mouseX < minX + width && 
/*  27 */       MouseMotion.mouseY >= minY && 
/*  28 */       MouseMotion.mouseY < minY + height) {
/*  29 */       state = 2;
/*  30 */       if (Game.mouseIsPressed()) {
/*  31 */         state = 3;
/*     */       } else {
/*  33 */         state = 2;
/*     */       } 
/*     */     } else {
/*  35 */       state = 1;
/*     */     } 
/*  36 */     return state;
/*     */   }
/*     */   
/*     */   public void drawButton(Graphics g, int state, int renderX, int renderY, int width, int height, String buttonText, BufferedImage state1Image, BufferedImage state2Image, BufferedImage state3Image, double clickEventType) {
/*  43 */     this.fm = g.getFontMetrics(Game.buttonTextFont);
/*  44 */     g.setFont(Game.buttonTextFont);
/*  45 */     if (getButtonState(renderX, renderY, width, height, state) == 1) {
/*  46 */       g.drawImage(state1Image, renderX, renderY, width, height, null);
/*  47 */       g.setColor(Game.buttonIdleColor);
/*  48 */       g.drawString(buttonText, renderX + state1Image.getWidth() / 2 - 
/*  49 */           this.fm.stringWidth(buttonText) / 2, 
/*  50 */           renderY + state1Image.getHeight() / 2 + 5);
/*  51 */     } else if (getButtonState(renderX, renderY, width, height, state) == 2) {
/*  52 */       g.drawImage(state2Image, renderX, renderY, width, height, null);
/*  53 */       g.setColor(Game.buttonSelectedColor);
/*  54 */       g.drawString(buttonText, renderX + state1Image.getWidth() / 2 - 
/*  55 */           this.fm.stringWidth(buttonText) / 2, 
/*  56 */           renderY + state1Image.getHeight() / 2 + 5);
/*  57 */     } else if (getButtonState(renderX, renderY, width, height, state) == 3) {
/*  58 */       g.drawImage(state3Image, renderX, renderY, width, height, null);
/*  59 */       g.setColor(Game.buttonClickedColor);
/*  60 */       g.drawString(buttonText, renderX + state1Image.getWidth() / 2 - 
/*  61 */           this.fm.stringWidth(buttonText) / 2, 
/*  62 */           renderY + state1Image.getHeight() / 2 + 5);
/*  64 */       if (clickEventType == 1.1D) {
/*     */         try {
/*  66 */           if ((Game.getMainMenu()).currentProfile == 1)
/*  67 */             Profile1.save(); 
/*  68 */           if ((Game.getMainMenu()).currentProfile == 2)
/*  69 */             Profile2.save(); 
/*  70 */           if ((Game.getMainMenu()).currentProfile == 3)
/*  71 */             Profile3.save(); 
/*  72 */           Save.dataSave();
/*  73 */         } catch (IOException e) {
/*  74 */           e.printStackTrace();
/*     */         } 
/*  76 */         isOpen = false;
/*  77 */         Game.isInGame = false;
/*  78 */         Game.endClick();
/*  79 */         this.saveAndQuitState = 1;
/*  80 */         (Game.getMainMenu()).menuState = 1;
/*  81 */         (Game.getMainMenu()).currentProfile = 0;
/*  82 */       } else if (clickEventType == 1.2D) {
/*  83 */         isOpen = false;
/*  84 */         this.backToGameState = 1;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void renderMain(Graphics g) {
/*  91 */     g.setColor(new Color(0, 0, 0, 145));
/*  92 */     g.fillRect(0, 0, 838, 573);
/*  94 */     g.setColor(Color.white);
/*  95 */     g.setFont(Game.buttonTextFont);
/*  99 */     g.drawImage(ImageManager.button1_1, 251, 168, 160, 32, null);
/* 100 */     g.drawImage(ImageManager.button1_1, 427, 168, 160, 32, null);
/* 102 */     g.drawImage(ImageManager.button1_1, 251, 268, 160, 32, null);
/* 103 */     g.drawImage(ImageManager.button1_1, 427, 268, 160, 32, null);
/* 105 */     g.setColor(Color.gray);
/* 106 */     g.setFont(Game.profileInfoFont);
/* 107 */     g.drawString("More stuff will be added here in the future.", 278, 440);
/* 109 */     drawButton(g, this.saveAndQuitState, 419 - 
/* 110 */         ImageManager.button2_1.getWidth() / 2, 316, ImageManager.button2_1.getWidth(), 
/* 111 */         ImageManager.button2_1.getHeight(), 
/* 112 */         "Save and Quit to Title", ImageManager.button2_1, ImageManager.button2_2, 
/* 113 */         ImageManager.button2_3, 1.1D);
/* 115 */     drawButton(g, this.backToGameState, 419 - 
/* 116 */         ImageManager.button2_1.getWidth() / 2, 120, ImageManager.button2_1.getWidth(), 
/* 117 */         ImageManager.button2_1.getHeight(), "Back to Game", ImageManager.button2_1, 
/* 118 */         ImageManager.button2_2, ImageManager.button2_3, 1.2D);
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.1.0_1.jar!\com\emgartley\beyondOrigins\main\menus\PauseMenu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */