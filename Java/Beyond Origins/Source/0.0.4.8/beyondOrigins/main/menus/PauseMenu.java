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
/*     */   public void buttonTick() {
/*  33 */     if (MouseMotion.mouseX >= 251 && MouseMotion.mouseX <= 584 && 
/*  34 */       MouseMotion.mouseY >= 120 && MouseMotion.mouseY <= 149) {
/*  35 */       backToGameState = 2;
/*  36 */       if (MouseManager.mouseFullClick == 1) {
/*  37 */         backToGameState = 3;
/*     */       } else {
/*  39 */         backToGameState = 2;
/*     */       } 
/*     */     } else {
/*  42 */       backToGameState = 1;
/*     */     } 
/*  45 */     if (MouseMotion.mouseX >= 251 && MouseMotion.mouseX <= 584 && 
/*  46 */       MouseMotion.mouseY >= 316 && MouseMotion.mouseY <= 344) {
/*  47 */       saveAndQuitState = 2;
/*  48 */       if (MouseManager.mouseFullClick == 1) {
/*  49 */         saveAndQuitState = 3;
/*     */       } else {
/*  51 */         saveAndQuitState = 2;
/*     */       } 
/*     */     } else {
/*  54 */       saveAndQuitState = 1;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void renderMain(Graphics g) {
/*  61 */     g.setColor(new Color(0, 0, 0, 145));
/*  62 */     g.fillRect(0, 0, 838, 573);
/*  64 */     g.setColor(Color.white);
/*  65 */     g.setFont(Game.default2);
/*  67 */     g.drawImage(im.button2_1, 251, 120, 336, 32, null);
/*  68 */     g.drawString("Back To Game", 355, 143);
/*  69 */     g.drawImage(im.button1_1, 251, 168, 160, 32, null);
/*  70 */     g.drawImage(im.button1_1, 427, 168, 160, 32, null);
/*  72 */     g.drawImage(im.button1_1, 251, 268, 160, 32, null);
/*  73 */     g.drawImage(im.button1_1, 427, 268, 160, 32, null);
/*  75 */     g.setColor(Color.gray);
/*  76 */     g.setFont(Game.menuText1);
/*  77 */     g.drawString("More stuff will be added here in the future.", 278, 440);
/*  79 */     g.setFont(Game.default2);
/*  81 */     if (backToGameState == 1) {
/*  82 */       g.drawImage(im.button2_1, 251, 120, 336, 32, null);
/*  83 */       g.setColor(Game.text1);
/*  84 */       g.drawString("Back To Game", 355, 143);
/*  85 */     } else if (backToGameState == 2) {
/*  86 */       g.drawImage(im.button2_2, 251, 120, 336, 32, null);
/*  87 */       g.setColor(Game.text2);
/*  88 */       g.drawString("Back To Game", 355, 143);
/*  89 */     } else if (backToGameState == 3) {
/*  90 */       g.drawImage(im.button2_3, 251, 120, 336, 32, null);
/*  91 */       g.setColor(Game.text3);
/*  92 */       g.drawString("Back To Game", 355, 143);
/*  93 */       isOpen = false;
/*  94 */       backToGameState = 1;
/*     */     } 
/*  97 */     if (saveAndQuitState == 1) {
/*  98 */       g.drawImage(im.button2_1, 251, 316, 336, 32, null);
/*  99 */       g.setColor(Game.text1);
/* 100 */       g.drawString("Save And Quit To Title", 315, 337);
/* 101 */     } else if (saveAndQuitState == 2) {
/* 102 */       g.drawImage(im.button2_2, 251, 316, 336, 32, null);
/* 103 */       g.setColor(Game.text2);
/* 104 */       g.drawString("Save And Quit To Title", 315, 337);
/* 105 */     } else if (saveAndQuitState == 3) {
/* 106 */       g.drawImage(im.button2_3, 251, 316, 336, 32, null);
/* 107 */       g.setColor(Game.text3);
/* 108 */       g.drawString("Save And Quit To Title", 315, 337);
/*     */       try {
/* 110 */         if (MainMenu.currentProfile == 1)
/* 110 */           Save.save1(); 
/* 111 */         if (MainMenu.currentProfile == 2)
/* 111 */           Save.save2(); 
/* 112 */         if (MainMenu.currentProfile == 3)
/* 112 */           Save.save3(); 
/* 113 */       } catch (IOException e) {
/* 114 */         e.printStackTrace();
/*     */       } 
/* 116 */       isOpen = false;
/* 117 */       Game.isInGame = false;
/* 118 */       saveAndQuitState = 1;
/* 119 */       MainMenu.menuState = 1;
/* 120 */       MainMenu.currentProfile = 0;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4.8.jar!\beyondOrigins\main\menus\PauseMenu.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */