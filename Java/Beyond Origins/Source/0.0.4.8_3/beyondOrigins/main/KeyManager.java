/*     */ package beyondOrigins.main;
/*     */ 
/*     */ import beyondOrigins.main.entities.Player;
/*     */ import beyondOrigins.main.inventory.InventoryMain;
/*     */ import beyondOrigins.main.menus.F3Menu;
/*     */ import beyondOrigins.main.menus.MainMenu;
/*     */ import beyondOrigins.main.menus.PauseMenu;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.KeyListener;
/*     */ import java.io.IOException;
/*     */ 
/*     */ public class KeyManager implements KeyListener {
/*     */   public static boolean escPressed = false;
/*     */   
/*     */   public void keyPressed(KeyEvent e) {
/*  17 */     if ((e.getKeyCode() == 87 || e.getKeyCode() == 38) && 
/*  18 */       !InventoryMain.invOpen) {
/*  19 */       Player.up = true;
/*  20 */       if (MainMenu.menuState != 0)
/*  21 */         if (MainMenu.currentProfile == 0) {
/*  22 */           MainMenu.save1State = 3;
/*  23 */         } else if (MainMenu.currentProfile == 1) {
/*  24 */           MainMenu.save3State = 3;
/*  25 */           MainMenu.save1State = 0;
/*  26 */         } else if (MainMenu.currentProfile == 3) {
/*  27 */           MainMenu.save2State = 3;
/*  28 */           MainMenu.save3State = 0;
/*  29 */         } else if (MainMenu.currentProfile == 2) {
/*  30 */           MainMenu.save1State = 3;
/*  31 */           MainMenu.save2State = 0;
/*     */         }  
/*     */     } else {
/*  35 */       Player.up = false;
/*     */     } 
/*  38 */     if ((e.getKeyCode() == 83 || e.getKeyCode() == 40) && 
/*  39 */       !InventoryMain.invOpen) {
/*  40 */       Player.down = true;
/*  41 */       if (MainMenu.menuState != 0)
/*  42 */         if (MainMenu.currentProfile == 0) {
/*  43 */           MainMenu.save1State = 3;
/*  44 */         } else if (MainMenu.currentProfile == 1) {
/*  45 */           MainMenu.save2State = 3;
/*  46 */           MainMenu.save1State = 0;
/*  47 */         } else if (MainMenu.currentProfile == 2) {
/*  48 */           MainMenu.save3State = 3;
/*  49 */           MainMenu.save2State = 0;
/*  50 */         } else if (MainMenu.currentProfile == 3) {
/*  51 */           MainMenu.save1State = 3;
/*  52 */           MainMenu.save3State = 0;
/*     */         }  
/*     */     } else {
/*  56 */       Player.down = false;
/*     */     } 
/*  59 */     if ((e.getKeyCode() == 65 || e.getKeyCode() == 37) && 
/*  60 */       !InventoryMain.invOpen) {
/*  61 */       Player.left = true;
/*     */     } else {
/*  63 */       Player.left = false;
/*     */     } 
/*  66 */     if ((e.getKeyCode() == 68 || e.getKeyCode() == 39) && 
/*  67 */       !InventoryMain.invOpen) {
/*  68 */       Player.right = true;
/*     */     } else {
/*  70 */       Player.right = false;
/*     */     } 
/*  73 */     if (e.getKeyCode() == 69 && Game.isInGame && !PauseMenu.isOpen)
/*  74 */       InventoryMain.invOpen = !InventoryMain.invOpen; 
/*  77 */     if (e.getKeyCode() == 114)
/*  78 */       F3Menu.f3menu = !F3Menu.f3menu; 
/*  81 */     if (e.getKeyCode() == 27) {
/*  82 */       escPressed = true;
/*     */     } else {
/*  84 */       escPressed = false;
/*     */     } 
/*  86 */     if (e.getKeyCode() == 27 && Game.isInGame && 
/*  87 */       !InventoryMain.invOpen && !PauseMenu.isOpen)
/*  88 */       PauseMenu.isOpen = true; 
/*     */   }
/*     */   
/*     */   public void keyReleased(KeyEvent e) {
/*  95 */     if (e.getKeyCode() == 87 || e.getKeyCode() == 38)
/*  96 */       Player.up = false; 
/*  98 */     if (e.getKeyCode() == 83 || e.getKeyCode() == 40)
/*  99 */       Player.down = false; 
/* 101 */     if (e.getKeyCode() == 65 || e.getKeyCode() == 37)
/* 102 */       Player.left = false; 
/* 104 */     if (e.getKeyCode() == 68 || e.getKeyCode() == 39)
/* 105 */       Player.right = false; 
/* 108 */     if (e.getKeyCode() == 27)
/* 109 */       escPressed = false; 
/* 112 */     if (e.getKeyCode() == 10 && 
/* 113 */       MainMenu.menuState != 0 && (
/* 114 */       MainMenu.currentProfile == 1 || MainMenu.currentProfile == 2 || MainMenu.currentProfile == 3))
/*     */       try {
/* 116 */         MainMenu.menuStateIs2_playProfile();
/* 117 */       } catch (IOException e1) {
/* 118 */         e1.printStackTrace();
/*     */       }  
/*     */   }
/*     */   
/*     */   public void keyTyped(KeyEvent e) {}
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4.8_3.jar!\beyondOrigins\main\KeyManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */