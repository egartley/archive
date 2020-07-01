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
/*     */   public static boolean escPressed = false, enterPressed = false;
/*     */   
/*     */   public static String removeCharAt(String s, int pos) {
/*  18 */     return String.valueOf(s.substring(0, pos)) + s.substring(pos + 1);
/*     */   }
/*     */   
/*     */   private static void profileNameBoxAdd(String c, int cp) {
/*  22 */     if (cp == 1 && MainMenu.save1Name.length() <= 25) {
/*  23 */       MainMenu.save1Name = String.valueOf(MainMenu.save1Name) + c;
/*  24 */       MainMenu.save1Name_backup = MainMenu.save1Name;
/*     */     } 
/*  26 */     if (cp == 2 && MainMenu.save2Name.length() <= 25) {
/*  27 */       MainMenu.save2Name = String.valueOf(MainMenu.save2Name) + c;
/*  28 */       MainMenu.save2Name_backup = MainMenu.save2Name;
/*     */     } 
/*  30 */     if (cp == 3 && MainMenu.save3Name.length() <= 25) {
/*  31 */       MainMenu.save3Name = String.valueOf(MainMenu.save3Name) + c;
/*  32 */       MainMenu.save3Name_backup = MainMenu.save3Name;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void keyPressed(KeyEvent e) {
/*  39 */     if (MainMenu.profileNameBoxIsTyping && MainMenu.menuState == 5 && 
/*  40 */       !Game.isInGame && e.getKeyCode() == 8) {
/*  41 */       if (MainMenu.currentProfile == 1 && 
/*  42 */         MainMenu.save1Name.length() != 0)
/*  43 */         MainMenu.save1Name = removeCharAt(MainMenu.save1Name, 
/*  44 */             MainMenu.save1Name.length() - 1); 
/*  46 */       if (MainMenu.currentProfile == 2 && 
/*  47 */         MainMenu.save2Name.length() != 0)
/*  48 */         MainMenu.save2Name = removeCharAt(MainMenu.save2Name, 
/*  49 */             MainMenu.save2Name.length() - 1); 
/*  51 */       if (MainMenu.currentProfile == 3 && 
/*  52 */         MainMenu.save3Name.length() != 0)
/*  53 */         MainMenu.save3Name = removeCharAt(MainMenu.save3Name, 
/*  54 */             MainMenu.save3Name.length() - 1); 
/*     */     } 
/*  59 */     if ((e.getKeyCode() == 87 || e.getKeyCode() == 38) && 
/*  60 */       !InventoryMain.invOpen) {
/*  61 */       Player.up = true;
/*  62 */       if (MainMenu.menuState == 2)
/*  63 */         if (MainMenu.currentProfile == 0) {
/*  64 */           MainMenu.save1State = 3;
/*  65 */         } else if (MainMenu.currentProfile == 1) {
/*  66 */           MainMenu.save3State = 3;
/*  67 */           MainMenu.save1State = 0;
/*  68 */         } else if (MainMenu.currentProfile == 3) {
/*  69 */           MainMenu.save2State = 3;
/*  70 */           MainMenu.save3State = 0;
/*  71 */         } else if (MainMenu.currentProfile == 2) {
/*  72 */           MainMenu.save1State = 3;
/*  73 */           MainMenu.save2State = 0;
/*     */         }  
/*     */     } else {
/*  77 */       Player.up = false;
/*     */     } 
/*  81 */     if ((e.getKeyCode() == 83 || e.getKeyCode() == 40) && 
/*  82 */       !InventoryMain.invOpen) {
/*  83 */       Player.down = true;
/*  84 */       if (MainMenu.menuState != 0)
/*  85 */         if (MainMenu.currentProfile == 0) {
/*  86 */           MainMenu.save1State = 3;
/*  87 */         } else if (MainMenu.currentProfile == 1) {
/*  88 */           MainMenu.save2State = 3;
/*  89 */           MainMenu.save1State = 0;
/*  90 */         } else if (MainMenu.currentProfile == 2) {
/*  91 */           MainMenu.save3State = 3;
/*  92 */           MainMenu.save2State = 0;
/*  93 */         } else if (MainMenu.currentProfile == 3) {
/*  94 */           MainMenu.save1State = 3;
/*  95 */           MainMenu.save3State = 0;
/*     */         }  
/*     */     } else {
/*  99 */       Player.down = false;
/*     */     } 
/* 103 */     if ((e.getKeyCode() == 65 || e.getKeyCode() == 37) && 
/* 104 */       !InventoryMain.invOpen) {
/* 105 */       Player.left = true;
/*     */     } else {
/* 107 */       Player.left = false;
/*     */     } 
/* 111 */     if ((e.getKeyCode() == 68 || e.getKeyCode() == 39) && 
/* 112 */       !InventoryMain.invOpen) {
/* 113 */       Player.right = true;
/*     */     } else {
/* 115 */       Player.right = false;
/*     */     } 
/* 118 */     if (e.getKeyCode() == 69 && Game.isInGame && 
/* 119 */       !PauseMenu.isOpen)
/* 120 */       InventoryMain.invOpen = !InventoryMain.invOpen; 
/* 123 */     if (e.getKeyCode() == 114)
/* 124 */       F3Menu.f3menu = !F3Menu.f3menu; 
/* 127 */     if (e.getKeyCode() == 27) {
/* 128 */       escPressed = true;
/*     */     } else {
/* 130 */       escPressed = false;
/*     */     } 
/* 132 */     if (e.getKeyCode() == 27 && Game.isInGame && 
/* 133 */       !InventoryMain.invOpen && !PauseMenu.isOpen)
/* 134 */       PauseMenu.isOpen = true; 
/* 137 */     if (e.getKeyCode() == 10)
/* 138 */       enterPressed = !enterPressed; 
/*     */   }
/*     */   
/*     */   public void keyReleased(KeyEvent e) {
/* 145 */     if (e.getKeyCode() == 87 || 
/* 146 */       e.getKeyCode() == 38)
/* 147 */       Player.up = false; 
/* 149 */     if (e.getKeyCode() == 83 || 
/* 150 */       e.getKeyCode() == 40)
/* 151 */       Player.down = false; 
/* 153 */     if (e.getKeyCode() == 65 || 
/* 154 */       e.getKeyCode() == 37)
/* 155 */       Player.left = false; 
/* 157 */     if (e.getKeyCode() == 68 || 
/* 158 */       e.getKeyCode() == 39)
/* 159 */       Player.right = false; 
/* 162 */     if (e.getKeyCode() == 27)
/* 163 */       escPressed = false; 
/* 166 */     if (e.getKeyCode() == 10 && (
/* 167 */       MainMenu.currentProfile == 1 || MainMenu.currentProfile == 2 || 
/* 168 */       MainMenu.currentProfile == 3) && MainMenu.menuState != 0 && !Game.isInGame)
/*     */       try {
/* 170 */         MainMenu.menuStateIs2_playProfile();
/* 171 */       } catch (IOException e1) {
/* 172 */         e1.printStackTrace();
/*     */       }  
/*     */   }
/*     */   
/*     */   public void keyTyped(KeyEvent e) {
/* 180 */     String c = String.valueOf(e.getKeyChar());
/* 181 */     if (MainMenu.profileNameBoxIsTyping && MainMenu.menuState == 5 && 
/* 182 */       !Game.isInGame && e.getKeyChar() != '\b')
/* 183 */       profileNameBoxAdd(c, MainMenu.currentProfile); 
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_2.jar!\beyondOrigin\\userInput\KeyManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */