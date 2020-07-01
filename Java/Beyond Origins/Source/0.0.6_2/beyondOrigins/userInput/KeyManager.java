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
/*     */   private void released_L() {
/* 111 */     Player.exp = (short)(Player.exp + 10);
/*     */   }
/*     */   
/*     */   public void keyPressed(KeyEvent e) {
/* 119 */     if (e.getKeyCode() == 8)
/* 120 */       pressed_backspace(); 
/* 124 */     if ((e.getKeyCode() == 87 || e.getKeyCode() == 38) && 
/* 125 */       !Inventory.invOpen) {
/* 126 */       Player.up = true;
/* 127 */     } else if (e.getKeyCode() != 16 && e.getKeyCode() != 75) {
/* 128 */       Player.up = false;
/*     */     } 
/* 132 */     if ((e.getKeyCode() == 83 || e.getKeyCode() == 40) && 
/* 133 */       !Inventory.invOpen) {
/* 134 */       Player.down = true;
/* 135 */     } else if (e.getKeyCode() != 16 && e.getKeyCode() != 75) {
/* 136 */       Player.down = false;
/*     */     } 
/* 140 */     if ((e.getKeyCode() == 65 || e.getKeyCode() == 37) && 
/* 141 */       !Inventory.invOpen) {
/* 142 */       Player.left = true;
/* 143 */     } else if (e.getKeyCode() != 16 && e.getKeyCode() != 75) {
/* 144 */       Player.left = false;
/*     */     } 
/* 148 */     if ((e.getKeyCode() == 68 || e.getKeyCode() == 39) && 
/* 149 */       !Inventory.invOpen) {
/* 150 */       Player.right = true;
/* 151 */     } else if (e.getKeyCode() != 16 && e.getKeyCode() != 75) {
/* 152 */       Player.right = false;
/*     */     } 
/* 156 */     if (e.getKeyCode() == 69 && Game.isInGame && 
/* 157 */       !PauseMenu.isOpen)
/* 158 */       Inventory.invOpen = !Inventory.invOpen; 
/* 162 */     if (e.getKeyCode() == 114)
/* 163 */       F3Menu.f3menu = !F3Menu.f3menu; 
/* 167 */     if (e.getKeyCode() == 27) {
/* 168 */       escPressed = true;
/*     */     } else {
/* 170 */       escPressed = false;
/*     */     } 
/* 171 */     if (e.getKeyCode() == 27 && Game.isInGame && 
/* 172 */       !Inventory.invOpen && !PauseMenu.isOpen)
/* 173 */       PauseMenu.isOpen = true; 
/* 177 */     if (e.getKeyCode() == 10)
/* 178 */       enterPressed = !enterPressed; 
/* 182 */     if (e.getKeyCode() == 16 && !Inventory.invOpen)
/* 183 */       Player.SPEED = 2.0D; 
/*     */   }
/*     */   
/*     */   public void keyReleased(KeyEvent e) {
/* 191 */     if (e.getKeyCode() == 76)
/* 192 */       released_L(); 
/* 196 */     if (e.getKeyCode() == 87 || 
/* 197 */       e.getKeyCode() == 38)
/* 198 */       released_up(); 
/* 202 */     if (e.getKeyCode() == 83 || 
/* 203 */       e.getKeyCode() == 40)
/* 204 */       released_down(); 
/* 208 */     if (e.getKeyCode() == 65 || 
/* 209 */       e.getKeyCode() == 37)
/* 210 */       released_left(); 
/* 214 */     if (e.getKeyCode() == 68 || 
/* 215 */       e.getKeyCode() == 39)
/* 216 */       released_right(); 
/* 220 */     if (e.getKeyCode() == 16 && !Inventory.invOpen)
/* 221 */       Player.SPEED = 1.0D; 
/* 225 */     if (e.getKeyCode() == 27)
/* 226 */       escPressed = false; 
/* 230 */     if (e.getKeyCode() == 10)
/* 231 */       released_enter(); 
/* 235 */     if (e.getKeyCode() == 75 && !Inventory.invOpen)
/* 236 */       released_k(); 
/*     */   }
/*     */   
/*     */   public void keyTyped(KeyEvent e) {
/* 242 */     String c = String.valueOf(e.getKeyChar());
/* 243 */     if (MainMenu.profileNameBoxState == 2 && MainMenu.menuState == 5 && 
/* 244 */       !Game.isInGame && e.getKeyChar() != '\b')
/* 245 */       profileNameBoxAdd(c, MainMenu.currentProfile); 
/* 247 */     if (MainMenu.playerNameBoxState == 2 && MainMenu.menuState == 5 && 
/* 248 */       !Game.isInGame && e.getKeyChar() != '\b')
/* 249 */       playerNameBoxAdd(c, MainMenu.currentProfile); 
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.6_2.jar!\beyondOrigin\\userInput\KeyManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */