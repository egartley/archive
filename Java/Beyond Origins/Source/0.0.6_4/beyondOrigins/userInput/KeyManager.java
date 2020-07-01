/*     */ package beyondOrigins.userInput;
/*     */ 
/*     */ import beyondOrigins.main.Game;
/*     */ import beyondOrigins.main.inventory.Inventory;
/*     */ import beyondOrigins.main.menus.F3Menu;
/*     */ import beyondOrigins.main.menus.PauseMenu;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.KeyListener;
/*     */ import java.io.IOException;
/*     */ 
/*     */ public class KeyManager implements KeyListener {
/*     */   public static boolean escPressed = false, enterPressed = false;
/*     */   
/*     */   public static String removeCharAt(String s, int pos) {
/*  20 */     return String.valueOf(s.substring(0, pos)) + s.substring(pos + 1);
/*     */   }
/*     */   
/*     */   private void pressed_backspace() {
/*  45 */     if ((Game.getMainMenu()).profileNameBoxState == 2 && 
/*  46 */       (Game.getMainMenu()).playerNameBoxState != 2)
/*  47 */       if ((Game.getMainMenu()).currentProfile == 1 && 
/*  48 */         (Game.getMainMenu()).save1Name.length() != 0) {
/*  49 */         (Game.getMainMenu()).save1Name = removeCharAt((Game.getMainMenu()).save1Name, 
/*  50 */             (Game.getMainMenu()).save1Name.length() - 1);
/*  51 */       } else if ((Game.getMainMenu()).currentProfile == 2 && 
/*  52 */         (Game.getMainMenu()).save2Name.length() != 0) {
/*  53 */         (Game.getMainMenu()).save2Name = removeCharAt((Game.getMainMenu()).save2Name, 
/*  54 */             (Game.getMainMenu()).save2Name.length() - 1);
/*  55 */       } else if ((Game.getMainMenu()).currentProfile == 3 && 
/*  56 */         (Game.getMainMenu()).save3Name.length() != 0) {
/*  57 */         (Game.getMainMenu()).save3Name = removeCharAt((Game.getMainMenu()).save3Name, 
/*  58 */             (Game.getMainMenu()).save3Name.length() - 1);
/*     */       }  
/*  62 */     if ((Game.getMainMenu()).playerNameBoxState == 2 && 
/*  63 */       (Game.getMainMenu()).profileNameBoxState != 2 && 
/*  64 */       (Game.getPlayer()).typedName.length() != 0)
/*  65 */       (Game.getPlayer()).typedName = removeCharAt((Game.getPlayer()).typedName, 
/*  66 */           (Game.getPlayer()).typedName.length() - 1); 
/*     */   }
/*     */   
/*     */   private void released_up() {
/*  72 */     if (Game.isInGame && (Game.getMainMenu()).menuState == 0)
/*  73 */       (Game.getPlayer()).up = false; 
/*     */   }
/*     */   
/*     */   private void released_down() {
/*  78 */     if (Game.isInGame && (Game.getMainMenu()).menuState == 0)
/*  79 */       (Game.getPlayer()).down = false; 
/*     */   }
/*     */   
/*     */   private void released_left() {
/*  84 */     if (Game.isInGame && (Game.getMainMenu()).menuState == 0)
/*  85 */       (Game.getPlayer()).left = false; 
/*     */   }
/*     */   
/*     */   private void released_right() {
/*  90 */     if (Game.isInGame && (Game.getMainMenu()).menuState == 0)
/*  91 */       (Game.getPlayer()).right = false; 
/*     */   }
/*     */   
/*     */   private void released_enter() {
/*  96 */     if (((Game.getMainMenu()).currentProfile == 1 || (Game.getMainMenu()).currentProfile == 2 || (Game.getMainMenu()).currentProfile == 3) && 
/*  97 */       (Game.getMainMenu()).menuState == 2 && !Game.isInGame)
/*     */       try {
/*  99 */         Game.getMainMenu().m2PlayProfile();
/* 100 */       } catch (IOException e1) {
/* 101 */         e1.printStackTrace();
/*     */       }  
/*     */   }
/*     */   
/*     */   private void released_k() {
/* 107 */     if (Game.isInGame)
/* 108 */       Game.getPlayer().attack(); 
/*     */   }
/*     */   
/*     */   private void released_L() {
/* 113 */     if (Game.isInGame && (Game.getMainMenu()).menuState == 0)
/* 114 */       (Game.getPlayer()).exp = (short)((Game.getPlayer()).exp + 10); 
/*     */   }
/*     */   
/*     */   public void keyPressed(KeyEvent e) {
/* 123 */     if (e.getKeyCode() == 8)
/* 124 */       pressed_backspace(); 
/* 128 */     if ((e.getKeyCode() == 87 || e.getKeyCode() == 38) && 
/* 129 */       !Inventory.invOpen && (Game.getMainMenu()).menuState == 0) {
/* 130 */       (Game.getPlayer()).up = true;
/* 131 */     } else if (e.getKeyCode() != 16 && e.getKeyCode() != 75) {
/* 132 */       (Game.getPlayer()).up = false;
/*     */     } 
/* 136 */     if ((e.getKeyCode() == 83 || e.getKeyCode() == 40) && 
/* 137 */       !Inventory.invOpen && (Game.getMainMenu()).menuState == 0) {
/* 138 */       (Game.getPlayer()).down = true;
/* 139 */     } else if (e.getKeyCode() != 16 && e.getKeyCode() != 75) {
/* 140 */       (Game.getPlayer()).down = false;
/*     */     } 
/* 144 */     if ((e.getKeyCode() == 65 || e.getKeyCode() == 37) && 
/* 145 */       !Inventory.invOpen && (Game.getMainMenu()).menuState == 0) {
/* 146 */       (Game.getPlayer()).left = true;
/* 147 */     } else if (e.getKeyCode() != 16 && e.getKeyCode() != 75) {
/* 148 */       (Game.getPlayer()).left = false;
/*     */     } 
/* 152 */     if ((e.getKeyCode() == 68 || e.getKeyCode() == 39) && 
/* 153 */       !Inventory.invOpen && (Game.getMainMenu()).menuState == 0) {
/* 154 */       (Game.getPlayer()).right = true;
/* 155 */     } else if (e.getKeyCode() != 16 && e.getKeyCode() != 75) {
/* 156 */       (Game.getPlayer()).right = false;
/*     */     } 
/* 160 */     if (e.getKeyCode() == 69 && Game.isInGame && 
/* 161 */       !PauseMenu.isOpen)
/* 162 */       Inventory.invOpen = !Inventory.invOpen; 
/* 166 */     if (e.getKeyCode() == 114)
/* 167 */       F3Menu.f3menu = !F3Menu.f3menu; 
/* 171 */     if (e.getKeyCode() == 27) {
/* 172 */       escPressed = true;
/*     */     } else {
/* 174 */       escPressed = false;
/*     */     } 
/* 175 */     if (e.getKeyCode() == 27 && Game.isInGame && 
/* 176 */       !Inventory.invOpen && !PauseMenu.isOpen)
/* 177 */       PauseMenu.isOpen = true; 
/* 181 */     if (e.getKeyCode() == 10)
/* 182 */       enterPressed = !enterPressed; 
/* 186 */     if (e.getKeyCode() == 16 && !Inventory.invOpen)
/* 187 */       (Game.getPlayer()).SPEED = 2.0D; 
/*     */   }
/*     */   
/*     */   public void keyReleased(KeyEvent e) {
/* 208 */     if (e.getKeyCode() == 76)
/* 209 */       released_L(); 
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
/* 238 */       (Game.getPlayer()).SPEED = 1.0D; 
/* 242 */     if (e.getKeyCode() == 27)
/* 243 */       escPressed = false; 
/* 247 */     if (e.getKeyCode() == 10)
/* 248 */       released_enter(); 
/* 252 */     if (e.getKeyCode() == 75 && !Inventory.invOpen)
/* 253 */       released_k(); 
/*     */   }
/*     */   
/*     */   public void keyTyped(KeyEvent e) {}
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.6_4.jar!\beyondOrigin\\userInput\KeyManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */