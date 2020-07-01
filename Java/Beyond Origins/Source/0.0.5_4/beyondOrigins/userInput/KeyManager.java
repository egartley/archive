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
/*     */   public static boolean enterPressed = false;
/*     */   
/*  17 */   private static short proNLength = 25, plrNLength = 16;
/*     */   
/*     */   public static String removeCharAt(String s, int pos) {
/*  22 */     return String.valueOf(s.substring(0, pos)) + s.substring(pos + 1);
/*     */   }
/*     */   
/*     */   private static void profileNameBoxAdd(String c, int currentProfile) {
/*  26 */     if (currentProfile == 1 && MainMenu.save1Name.length() <= proNLength) {
/*  27 */       MainMenu.save1Name = String.valueOf(MainMenu.save1Name) + c;
/*  28 */       MainMenu.save1Name_backup = MainMenu.save1Name;
/*     */     } 
/*  30 */     if (currentProfile == 2 && MainMenu.save2Name.length() <= proNLength) {
/*  31 */       MainMenu.save2Name = String.valueOf(MainMenu.save2Name) + c;
/*  32 */       MainMenu.save2Name_backup = MainMenu.save2Name;
/*     */     } 
/*  34 */     if (currentProfile == 3 && MainMenu.save3Name.length() <= proNLength) {
/*  35 */       MainMenu.save3Name = String.valueOf(MainMenu.save3Name) + c;
/*  36 */       MainMenu.save3Name_backup = MainMenu.save3Name;
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void playerNameBoxAdd(String c, int currentProfile) {
/*  41 */     if (Player.typedName.length() <= plrNLength)
/*  42 */       Player.typedName = String.valueOf(Player.typedName) + c; 
/*     */   }
/*     */   
/*     */   private void pressed_backspace() {
/*  47 */     if (MainMenu.profileNameBoxState == 2 && 
/*  48 */       MainMenu.playerNameBoxState != 2)
/*  49 */       if (MainMenu.currentProfile == 1 && 
/*  50 */         MainMenu.save1Name.length() != 0) {
/*  51 */         MainMenu.save1Name = removeCharAt(MainMenu.save1Name, 
/*  52 */             MainMenu.save1Name.length() - 1);
/*  53 */       } else if (MainMenu.currentProfile == 2 && 
/*  54 */         MainMenu.save2Name.length() != 0) {
/*  55 */         MainMenu.save2Name = removeCharAt(MainMenu.save2Name, 
/*  56 */             MainMenu.save2Name.length() - 1);
/*  57 */       } else if (MainMenu.currentProfile == 3 && 
/*  58 */         MainMenu.save3Name.length() != 0) {
/*  59 */         MainMenu.save3Name = removeCharAt(MainMenu.save3Name, 
/*  60 */             MainMenu.save3Name.length() - 1);
/*     */       }  
/*  64 */     if (MainMenu.playerNameBoxState == 2 && 
/*  65 */       MainMenu.profileNameBoxState != 2 && 
/*  66 */       Player.typedName.length() != 0)
/*  67 */       Player.typedName = removeCharAt(Player.typedName, 
/*  68 */           Player.typedName.length() - 1); 
/*     */   }
/*     */   
/*     */   private void released_up() {
/*  74 */     if (MainMenu.menuState == 2 && !Game.isInGame) {
/*  75 */       if (MainMenu.currentProfile == 0) {
/*  76 */         MainMenu.save1State = 3;
/*  77 */       } else if (MainMenu.currentProfile == 1) {
/*  78 */         MainMenu.save3State = 3;
/*  79 */         MainMenu.save1State = 0;
/*  80 */       } else if (MainMenu.currentProfile == 3) {
/*  81 */         MainMenu.save2State = 3;
/*  82 */         MainMenu.save3State = 0;
/*  83 */       } else if (MainMenu.currentProfile == 2) {
/*  84 */         MainMenu.save1State = 3;
/*  85 */         MainMenu.save2State = 0;
/*     */       } 
/*  87 */     } else if (Game.isInGame) {
/*  88 */       Player.up = false;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void released_down() {
/*  93 */     if (MainMenu.menuState == 2 && !Game.isInGame) {
/*  94 */       if (MainMenu.currentProfile == 0) {
/*  95 */         MainMenu.save1State = 3;
/*  96 */       } else if (MainMenu.currentProfile == 1) {
/*  97 */         MainMenu.save2State = 3;
/*  98 */         MainMenu.save1State = 0;
/*  99 */       } else if (MainMenu.currentProfile == 2) {
/* 100 */         MainMenu.save3State = 3;
/* 101 */         MainMenu.save2State = 0;
/* 102 */       } else if (MainMenu.currentProfile == 3) {
/* 103 */         MainMenu.save1State = 3;
/* 104 */         MainMenu.save3State = 0;
/*     */       } 
/* 106 */     } else if (Game.isInGame) {
/* 107 */       Player.down = false;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void released_left() {
/* 112 */     Player.left = false;
/*     */   }
/*     */   
/*     */   private void released_right() {
/* 116 */     Player.right = false;
/*     */   }
/*     */   
/*     */   private void released_enter() {
/* 120 */     if ((MainMenu.currentProfile == 1 || MainMenu.currentProfile == 2 || MainMenu.currentProfile == 3) && 
/* 121 */       MainMenu.menuState != 0 && !Game.isInGame)
/*     */       try {
/* 123 */         MainMenu.m2PlayProfile();
/* 124 */       } catch (IOException e1) {
/* 125 */         e1.printStackTrace();
/*     */       }  
/*     */   }
/*     */   
/*     */   private void released_k() {}
/*     */   
/*     */   public void keyPressed(KeyEvent e) {
/* 139 */     if (e.getKeyCode() == 8)
/* 140 */       pressed_backspace(); 
/* 144 */     if ((e.getKeyCode() == 87 || e.getKeyCode() == 38) && 
/* 145 */       !InventoryMain.invOpen) {
/* 146 */       Player.up = true;
/* 147 */     } else if (e.getKeyCode() != 16) {
/* 148 */       Player.up = false;
/*     */     } 
/* 152 */     if ((e.getKeyCode() == 83 || e.getKeyCode() == 40) && 
/* 153 */       !InventoryMain.invOpen) {
/* 154 */       Player.down = true;
/* 155 */     } else if (e.getKeyCode() != 16) {
/* 156 */       Player.down = false;
/*     */     } 
/* 160 */     if ((e.getKeyCode() == 65 || e.getKeyCode() == 37) && 
/* 161 */       !InventoryMain.invOpen) {
/* 162 */       Player.left = true;
/* 163 */     } else if (e.getKeyCode() != 16) {
/* 164 */       Player.left = false;
/*     */     } 
/* 168 */     if ((e.getKeyCode() == 68 || e.getKeyCode() == 39) && 
/* 169 */       !InventoryMain.invOpen) {
/* 170 */       Player.right = true;
/* 171 */     } else if (e.getKeyCode() != 16) {
/* 172 */       Player.right = false;
/*     */     } 
/* 176 */     if (e.getKeyCode() == 69 && Game.isInGame && 
/* 177 */       !PauseMenu.isOpen)
/* 178 */       InventoryMain.invOpen = !InventoryMain.invOpen; 
/* 182 */     if (e.getKeyCode() == 114)
/* 183 */       F3Menu.f3menu = !F3Menu.f3menu; 
/* 187 */     if (e.getKeyCode() == 27) {
/* 188 */       escPressed = true;
/*     */     } else {
/* 190 */       escPressed = false;
/*     */     } 
/* 191 */     if (e.getKeyCode() == 27 && Game.isInGame && 
/* 192 */       !InventoryMain.invOpen && !PauseMenu.isOpen)
/* 193 */       PauseMenu.isOpen = true; 
/* 197 */     if (e.getKeyCode() == 10)
/* 198 */       enterPressed = !enterPressed; 
/* 202 */     if (e.getKeyCode() == 16 && !InventoryMain.invOpen)
/* 203 */       Player.SPEED = 2.0D; 
/*     */   }
/*     */   
/*     */   public void keyReleased(KeyEvent e) {
/* 211 */     if (e.getKeyCode() == 87 || 
/* 212 */       e.getKeyCode() == 38)
/* 213 */       released_up(); 
/* 217 */     if (e.getKeyCode() == 83 || 
/* 218 */       e.getKeyCode() == 40)
/* 219 */       released_down(); 
/* 223 */     if (e.getKeyCode() == 65 || 
/* 224 */       e.getKeyCode() == 37)
/* 225 */       released_left(); 
/* 229 */     if (e.getKeyCode() == 68 || 
/* 230 */       e.getKeyCode() == 39)
/* 231 */       released_right(); 
/* 235 */     if (e.getKeyCode() == 16 && !InventoryMain.invOpen)
/* 236 */       Player.SPEED = 1.0D; 
/* 240 */     if (e.getKeyCode() == 27)
/* 241 */       escPressed = false; 
/* 245 */     if (e.getKeyCode() == 10)
/* 246 */       released_enter(); 
/* 250 */     if (e.getKeyCode() == 75 && !InventoryMain.invOpen)
/* 251 */       released_k(); 
/*     */   }
/*     */   
/*     */   public void keyTyped(KeyEvent e) {
/* 257 */     String c = String.valueOf(e.getKeyChar());
/* 258 */     if (MainMenu.profileNameBoxState == 2 && MainMenu.menuState == 5 && 
/* 259 */       !Game.isInGame && e.getKeyChar() != '\b')
/* 260 */       profileNameBoxAdd(c, MainMenu.currentProfile); 
/* 262 */     if (MainMenu.playerNameBoxState == 2 && MainMenu.menuState == 5 && 
/* 263 */       !Game.isInGame && e.getKeyChar() != '\b')
/* 264 */       playerNameBoxAdd(c, MainMenu.currentProfile); 
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_4.jar!\beyondOrigin\\userInput\KeyManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */