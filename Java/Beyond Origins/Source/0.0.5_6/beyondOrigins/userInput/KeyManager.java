/*     */ package beyondOrigins.userInput;
/*     */ 
/*     */ import beyondOrigins.main.Game;
/*     */ import beyondOrigins.main.entities.Player;
/*     */ import beyondOrigins.main.inventory.Inventory;
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
/*  74 */     if (Game.isInGame)
/*  75 */       Player.up = false; 
/*     */   }
/*     */   
/*     */   private void released_down() {
/*  80 */     if (Game.isInGame)
/*  81 */       Player.down = false; 
/*     */   }
/*     */   
/*     */   private void released_left() {
/*  86 */     Player.left = false;
/*     */   }
/*     */   
/*     */   private void released_right() {
/*  90 */     Player.right = false;
/*     */   }
/*     */   
/*     */   private void released_enter() {
/*  94 */     if ((MainMenu.currentProfile == 1 || MainMenu.currentProfile == 2 || MainMenu.currentProfile == 3) && 
/*  95 */       MainMenu.menuState != 0 && !Game.isInGame)
/*     */       try {
/*  97 */         MainMenu.m2PlayProfile();
/*  98 */       } catch (IOException e1) {
/*  99 */         e1.printStackTrace();
/*     */       }  
/*     */   }
/*     */   
/*     */   private void released_k() {
/* 105 */     if (Game.isInGame)
/* 106 */       Player.attack(); 
/*     */   }
/*     */   
/*     */   public void keyPressed(KeyEvent e) {
/* 115 */     if (e.getKeyCode() == 8)
/* 116 */       pressed_backspace(); 
/* 120 */     if ((e.getKeyCode() == 87 || e.getKeyCode() == 38) && 
/* 121 */       !Inventory.invOpen) {
/* 122 */       Player.up = true;
/* 123 */     } else if (e.getKeyCode() != 16 && e.getKeyCode() != 75) {
/* 124 */       Player.up = false;
/*     */     } 
/* 128 */     if ((e.getKeyCode() == 83 || e.getKeyCode() == 40) && 
/* 129 */       !Inventory.invOpen) {
/* 130 */       Player.down = true;
/* 131 */     } else if (e.getKeyCode() != 16 && e.getKeyCode() != 75) {
/* 132 */       Player.down = false;
/*     */     } 
/* 136 */     if ((e.getKeyCode() == 65 || e.getKeyCode() == 37) && 
/* 137 */       !Inventory.invOpen) {
/* 138 */       Player.left = true;
/* 139 */     } else if (e.getKeyCode() != 16 && e.getKeyCode() != 75) {
/* 140 */       Player.left = false;
/*     */     } 
/* 144 */     if ((e.getKeyCode() == 68 || e.getKeyCode() == 39) && 
/* 145 */       !Inventory.invOpen) {
/* 146 */       Player.right = true;
/* 147 */     } else if (e.getKeyCode() != 16 && e.getKeyCode() != 75) {
/* 148 */       Player.right = false;
/*     */     } 
/* 152 */     if (e.getKeyCode() == 69 && Game.isInGame && 
/* 153 */       !PauseMenu.isOpen)
/* 154 */       Inventory.invOpen = !Inventory.invOpen; 
/* 158 */     if (e.getKeyCode() == 114)
/* 159 */       F3Menu.f3menu = !F3Menu.f3menu; 
/* 163 */     if (e.getKeyCode() == 27) {
/* 164 */       escPressed = true;
/*     */     } else {
/* 166 */       escPressed = false;
/*     */     } 
/* 167 */     if (e.getKeyCode() == 27 && Game.isInGame && 
/* 168 */       !Inventory.invOpen && !PauseMenu.isOpen)
/* 169 */       PauseMenu.isOpen = true; 
/* 173 */     if (e.getKeyCode() == 10)
/* 174 */       enterPressed = !enterPressed; 
/* 178 */     if (e.getKeyCode() == 16 && !Inventory.invOpen)
/* 179 */       Player.SPEED = 2.0D; 
/*     */   }
/*     */   
/*     */   public void keyReleased(KeyEvent e) {
/* 187 */     if (e.getKeyCode() == 87 || 
/* 188 */       e.getKeyCode() == 38)
/* 189 */       released_up(); 
/* 193 */     if (e.getKeyCode() == 83 || 
/* 194 */       e.getKeyCode() == 40)
/* 195 */       released_down(); 
/* 199 */     if (e.getKeyCode() == 65 || 
/* 200 */       e.getKeyCode() == 37)
/* 201 */       released_left(); 
/* 205 */     if (e.getKeyCode() == 68 || 
/* 206 */       e.getKeyCode() == 39)
/* 207 */       released_right(); 
/* 211 */     if (e.getKeyCode() == 16 && !Inventory.invOpen)
/* 212 */       Player.SPEED = 1.0D; 
/* 216 */     if (e.getKeyCode() == 27)
/* 217 */       escPressed = false; 
/* 221 */     if (e.getKeyCode() == 10)
/* 222 */       released_enter(); 
/* 226 */     if (e.getKeyCode() == 75 && !Inventory.invOpen)
/* 227 */       released_k(); 
/*     */   }
/*     */   
/*     */   public void keyTyped(KeyEvent e) {
/* 233 */     String c = String.valueOf(e.getKeyChar());
/* 234 */     if (MainMenu.profileNameBoxState == 2 && MainMenu.menuState == 5 && 
/* 235 */       !Game.isInGame && e.getKeyChar() != '\b')
/* 236 */       profileNameBoxAdd(c, MainMenu.currentProfile); 
/* 238 */     if (MainMenu.playerNameBoxState == 2 && MainMenu.menuState == 5 && 
/* 239 */       !Game.isInGame && e.getKeyChar() != '\b')
/* 240 */       playerNameBoxAdd(c, MainMenu.currentProfile); 
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_6.jar!\beyondOrigin\\userInput\KeyManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */