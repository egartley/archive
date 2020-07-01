/*     */ package beyondOrigins.userInput;
/*     */ 
/*     */ import beyondOrigins.main.Game;
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
/*     */   public static String removeCharAt(String s, int pos) {
/*  18 */     return String.valueOf(s.substring(0, pos)) + s.substring(pos + 1);
/*     */   }
/*     */   
/*     */   public void keyPressed(KeyEvent e) {
/*  23 */     if (MainMenu.isTyping && MainMenu.menuState == 5 && 
/*  24 */       !Game.isInGame && e.getKeyCode() == 8) {
/*  25 */       if (MainMenu.currentProfile == 1 && 
/*  26 */         MainMenu.save1Name.length() != 0)
/*  27 */         MainMenu.save1Name = removeCharAt(MainMenu.save1Name, 
/*  28 */             MainMenu.save1Name.length() - 1); 
/*  30 */       if (MainMenu.currentProfile == 2 && 
/*  31 */         MainMenu.save2Name.length() != 0) {
/*  32 */         MainMenu.save2Name = removeCharAt(MainMenu.save2Name, 
/*  33 */             MainMenu.save2Name.length() - 1);
/*  34 */       } else if (MainMenu.save2Name == "") {
/*  35 */         System.out.println("TEST");
/*     */       } 
/*  37 */       if (MainMenu.currentProfile == 3 && 
/*  38 */         MainMenu.save3Name.length() != 0)
/*  39 */         MainMenu.save3Name = removeCharAt(MainMenu.save3Name, 
/*  40 */             MainMenu.save3Name.length() - 1); 
/*     */     } 
/*  44 */     if ((e.getKeyCode() == 87 || e.getKeyCode() == 38) && 
/*  45 */       !InventoryMain.invOpen) {
/*  46 */       Player.up = true;
/*  47 */       if (MainMenu.menuState == 2)
/*  48 */         if (MainMenu.currentProfile == 0) {
/*  49 */           MainMenu.save1State = 3;
/*  50 */         } else if (MainMenu.currentProfile == 1) {
/*  51 */           MainMenu.save3State = 3;
/*  52 */           MainMenu.save1State = 0;
/*  53 */         } else if (MainMenu.currentProfile == 3) {
/*  54 */           MainMenu.save2State = 3;
/*  55 */           MainMenu.save3State = 0;
/*  56 */         } else if (MainMenu.currentProfile == 2) {
/*  57 */           MainMenu.save1State = 3;
/*  58 */           MainMenu.save2State = 0;
/*     */         }  
/*     */     } else {
/*  62 */       Player.up = false;
/*     */     } 
/*  65 */     if ((e.getKeyCode() == 83 || e.getKeyCode() == 40) && 
/*  66 */       !InventoryMain.invOpen) {
/*  67 */       Player.down = true;
/*  68 */       if (MainMenu.menuState != 0)
/*  69 */         if (MainMenu.currentProfile == 0) {
/*  70 */           MainMenu.save1State = 3;
/*  71 */         } else if (MainMenu.currentProfile == 1) {
/*  72 */           MainMenu.save2State = 3;
/*  73 */           MainMenu.save1State = 0;
/*  74 */         } else if (MainMenu.currentProfile == 2) {
/*  75 */           MainMenu.save3State = 3;
/*  76 */           MainMenu.save2State = 0;
/*  77 */         } else if (MainMenu.currentProfile == 3) {
/*  78 */           MainMenu.save1State = 3;
/*  79 */           MainMenu.save3State = 0;
/*     */         }  
/*     */     } else {
/*  83 */       Player.down = false;
/*     */     } 
/*  86 */     if ((e.getKeyCode() == 65 || e.getKeyCode() == 37) && 
/*  87 */       !InventoryMain.invOpen) {
/*  88 */       Player.left = true;
/*     */     } else {
/*  90 */       Player.left = false;
/*     */     } 
/*  93 */     if ((e.getKeyCode() == 68 || e.getKeyCode() == 39) && 
/*  94 */       !InventoryMain.invOpen) {
/*  95 */       Player.right = true;
/*     */     } else {
/*  97 */       Player.right = false;
/*     */     } 
/* 100 */     if (e.getKeyCode() == 69 && Game.isInGame && 
/* 101 */       !PauseMenu.isOpen)
/* 102 */       InventoryMain.invOpen = !InventoryMain.invOpen; 
/* 105 */     if (e.getKeyCode() == 114)
/* 106 */       F3Menu.f3menu = !F3Menu.f3menu; 
/* 109 */     if (e.getKeyCode() == 27) {
/* 110 */       escPressed = true;
/*     */     } else {
/* 112 */       escPressed = false;
/*     */     } 
/* 114 */     if (e.getKeyCode() == 27 && Game.isInGame && 
/* 115 */       !InventoryMain.invOpen && !PauseMenu.isOpen)
/* 116 */       PauseMenu.isOpen = true; 
/*     */   }
/*     */   
/*     */   public void keyReleased(KeyEvent e) {
/* 123 */     if (e.getKeyCode() == 87 || 
/* 124 */       e.getKeyCode() == 38)
/* 125 */       Player.up = false; 
/* 127 */     if (e.getKeyCode() == 83 || 
/* 128 */       e.getKeyCode() == 40)
/* 129 */       Player.down = false; 
/* 131 */     if (e.getKeyCode() == 65 || 
/* 132 */       e.getKeyCode() == 37)
/* 133 */       Player.left = false; 
/* 135 */     if (e.getKeyCode() == 68 || 
/* 136 */       e.getKeyCode() == 39)
/* 137 */       Player.right = false; 
/* 140 */     if (e.getKeyCode() == 27)
/* 141 */       escPressed = false; 
/* 144 */     if (e.getKeyCode() == 10 && (
/* 145 */       MainMenu.currentProfile == 1 || MainMenu.currentProfile == 2 || (
/* 146 */       MainMenu.currentProfile == 3 && MainMenu.menuState != 0)))
/*     */       try {
/* 148 */         MainMenu.menuStateIs2_playProfile();
/* 149 */       } catch (IOException e1) {
/* 150 */         e1.printStackTrace();
/*     */       }  
/*     */   }
/*     */   
/*     */   public void keyTyped(KeyEvent e) {
/* 158 */     String character = String.valueOf(e.getKeyChar());
/* 159 */     if (MainMenu.isTyping && MainMenu.menuState == 5 && 
/* 160 */       !Game.isInGame && e.getKeyChar() != '\b') {
/* 161 */       if (MainMenu.currentProfile == 1 && MainMenu.save1Name.length() <= 25)
/* 162 */         MainMenu.save1Name = String.valueOf(MainMenu.save1Name) + character; 
/* 164 */       if (MainMenu.currentProfile == 2 && MainMenu.save2Name.length() <= 25)
/* 165 */         MainMenu.save2Name = String.valueOf(MainMenu.save2Name) + character; 
/* 167 */       if (MainMenu.currentProfile == 3 && MainMenu.save3Name.length() <= 25)
/* 168 */         MainMenu.save3Name = String.valueOf(MainMenu.save3Name) + character; 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_1.jar!\beyondOrigin\\userInput\KeyManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */