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
/*     */   private void released_k() {
/* 131 */     if (Game.isInGame)
/* 132 */       Player.attack(); 
/*     */   }
/*     */   
/*     */   public void keyPressed(KeyEvent e) {
/* 141 */     if (e.getKeyCode() == 8)
/* 142 */       pressed_backspace(); 
/* 146 */     if ((e.getKeyCode() == 87 || e.getKeyCode() == 38) && 
/* 147 */       !Inventory.invOpen) {
/* 148 */       Player.up = true;
/* 149 */     } else if (e.getKeyCode() != 16 && e.getKeyCode() != 75) {
/* 150 */       Player.up = false;
/*     */     } 
/* 154 */     if ((e.getKeyCode() == 83 || e.getKeyCode() == 40) && 
/* 155 */       !Inventory.invOpen) {
/* 156 */       Player.down = true;
/* 157 */     } else if (e.getKeyCode() != 16 && e.getKeyCode() != 75) {
/* 158 */       Player.down = false;
/*     */     } 
/* 162 */     if ((e.getKeyCode() == 65 || e.getKeyCode() == 37) && 
/* 163 */       !Inventory.invOpen) {
/* 164 */       Player.left = true;
/* 165 */     } else if (e.getKeyCode() != 16 && e.getKeyCode() != 75) {
/* 166 */       Player.left = false;
/*     */     } 
/* 170 */     if ((e.getKeyCode() == 68 || e.getKeyCode() == 39) && 
/* 171 */       !Inventory.invOpen) {
/* 172 */       Player.right = true;
/* 173 */     } else if (e.getKeyCode() != 16 && e.getKeyCode() != 75) {
/* 174 */       Player.right = false;
/*     */     } 
/* 178 */     if (e.getKeyCode() == 69 && Game.isInGame && 
/* 179 */       !PauseMenu.isOpen)
/* 180 */       Inventory.invOpen = !Inventory.invOpen; 
/* 184 */     if (e.getKeyCode() == 114)
/* 185 */       F3Menu.f3menu = !F3Menu.f3menu; 
/* 189 */     if (e.getKeyCode() == 27) {
/* 190 */       escPressed = true;
/*     */     } else {
/* 192 */       escPressed = false;
/*     */     } 
/* 193 */     if (e.getKeyCode() == 27 && Game.isInGame && 
/* 194 */       !Inventory.invOpen && !PauseMenu.isOpen)
/* 195 */       PauseMenu.isOpen = true; 
/* 199 */     if (e.getKeyCode() == 10)
/* 200 */       enterPressed = !enterPressed; 
/* 204 */     if (e.getKeyCode() == 16 && !Inventory.invOpen)
/* 205 */       Player.SPEED = 2.0D; 
/*     */   }
/*     */   
/*     */   public void keyReleased(KeyEvent e) {
/* 213 */     if (e.getKeyCode() == 87 || 
/* 214 */       e.getKeyCode() == 38)
/* 215 */       released_up(); 
/* 219 */     if (e.getKeyCode() == 83 || 
/* 220 */       e.getKeyCode() == 40)
/* 221 */       released_down(); 
/* 225 */     if (e.getKeyCode() == 65 || 
/* 226 */       e.getKeyCode() == 37)
/* 227 */       released_left(); 
/* 231 */     if (e.getKeyCode() == 68 || 
/* 232 */       e.getKeyCode() == 39)
/* 233 */       released_right(); 
/* 237 */     if (e.getKeyCode() == 16 && !Inventory.invOpen)
/* 238 */       Player.SPEED = 1.0D; 
/* 242 */     if (e.getKeyCode() == 27)
/* 243 */       escPressed = false; 
/* 247 */     if (e.getKeyCode() == 10)
/* 248 */       released_enter(); 
/* 252 */     if (e.getKeyCode() == 75 && !Inventory.invOpen)
/* 253 */       released_k(); 
/*     */   }
/*     */   
/*     */   public void keyTyped(KeyEvent e) {
/* 259 */     String c = String.valueOf(e.getKeyChar());
/* 260 */     if (MainMenu.profileNameBoxState == 2 && MainMenu.menuState == 5 && 
/* 261 */       !Game.isInGame && e.getKeyChar() != '\b')
/* 262 */       profileNameBoxAdd(c, MainMenu.currentProfile); 
/* 264 */     if (MainMenu.playerNameBoxState == 2 && MainMenu.menuState == 5 && 
/* 265 */       !Game.isInGame && e.getKeyChar() != '\b')
/* 266 */       playerNameBoxAdd(c, MainMenu.currentProfile); 
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_5.jar!\beyondOrigin\\userInput\KeyManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */