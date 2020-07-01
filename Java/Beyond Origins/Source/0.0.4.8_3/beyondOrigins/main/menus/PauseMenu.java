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
/*     */   public void tick() {}
/*     */   
/*     */   public int getState_Button(int minX, int minY, int width, int height, int state) {
/*  31 */     if (MouseMotion.mouseX >= minX && MouseMotion.mouseX < minX + width && 
/*  32 */       MouseMotion.mouseY >= minY && 
/*  33 */       MouseMotion.mouseY < minY + height) {
/*  34 */       state = 2;
/*  35 */       if (MouseManager.mouseFullClick == 1) {
/*  36 */         state = 3;
/*     */       } else {
/*  38 */         state = 2;
/*     */       } 
/*     */     } else {
/*  40 */       state = 1;
/*     */     } 
/*  41 */     return state;
/*     */   }
/*     */   
/*     */   public void renderMain(Graphics g) {
/*  46 */     g.setColor(new Color(0, 0, 0, 145));
/*  47 */     g.fillRect(0, 0, 838, 573);
/*  49 */     g.setColor(Color.white);
/*  50 */     g.setFont(Game.default2);
/*  54 */     g.drawImage(im.button1_1, 251, 168, 160, 32, null);
/*  55 */     g.drawImage(im.button1_1, 427, 168, 160, 32, null);
/*  57 */     g.drawImage(im.button1_1, 251, 268, 160, 32, null);
/*  58 */     g.drawImage(im.button1_1, 427, 268, 160, 32, null);
/*  60 */     g.setColor(Color.gray);
/*  61 */     g.setFont(Game.menuText1);
/*  62 */     g.drawString("More stuff will be added here in the future.", 278, 440);
/*  64 */     g.setFont(Game.default2);
/*  66 */     if (getState_Button(251, 120, 336, 32, backToGameState) == 1) {
/*  67 */       g.drawImage(im.button2_1, 251, 120, 336, 32, null);
/*  68 */       g.setColor(Game.text1);
/*  69 */       g.drawString("Back To Game", 355, 143);
/*  70 */     } else if (getState_Button(251, 120, 336, 32, backToGameState) == 2) {
/*  71 */       g.drawImage(im.button2_2, 251, 120, 336, 32, null);
/*  72 */       g.setColor(Game.text2);
/*  73 */       g.drawString("Back To Game", 355, 143);
/*  74 */     } else if (getState_Button(251, 120, 336, 32, backToGameState) == 3) {
/*  75 */       g.drawImage(im.button2_3, 251, 120, 336, 32, null);
/*  76 */       g.setColor(Game.text3);
/*  77 */       g.drawString("Back To Game", 355, 143);
/*  78 */       isOpen = false;
/*  79 */       backToGameState = 1;
/*     */     } 
/*  82 */     if (getState_Button(251, 316, 336, 32, saveAndQuitState) == 1) {
/*  83 */       g.drawImage(im.button2_1, 251, 316, 336, 32, null);
/*  84 */       g.setColor(Game.text1);
/*  85 */       g.drawString("Save And Quit To Title", 315, 337);
/*  86 */     } else if (getState_Button(251, 316, 336, 32, saveAndQuitState) == 2) {
/*  87 */       g.drawImage(im.button2_2, 251, 316, 336, 32, null);
/*  88 */       g.setColor(Game.text2);
/*  89 */       g.drawString("Save And Quit To Title", 315, 337);
/*  90 */     } else if (getState_Button(251, 316, 336, 32, saveAndQuitState) == 3) {
/*  91 */       g.drawImage(im.button2_3, 251, 316, 336, 32, null);
/*  92 */       g.setColor(Game.text3);
/*  93 */       g.drawString("Save And Quit To Title", 315, 337);
/*     */       try {
/*  95 */         if (MainMenu.currentProfile == 1)
/*  95 */           Save.profileSave(Save.save1, Game.save1Path, 1); 
/*  96 */         if (MainMenu.currentProfile == 2)
/*  96 */           Save.profileSave(Save.save2, Game.save2Path, 2); 
/*  97 */         if (MainMenu.currentProfile == 3)
/*  97 */           Save.profileSave(Save.save3, Game.save3Path, 3); 
/*  98 */         Save.dataSave();
/*  99 */       } catch (IOException e) {
/* 100 */         e.printStackTrace();
/*     */       } 
/* 102 */       isOpen = false;
/* 103 */       Game.isInGame = false;
/* 104 */       saveAndQuitState = 1;
/* 105 */       MainMenu.menuState = 1;
/* 106 */       MainMenu.currentProfile = 0;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4.8_3.jar!\beyondOrigins\main\menus\PauseMenu.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */