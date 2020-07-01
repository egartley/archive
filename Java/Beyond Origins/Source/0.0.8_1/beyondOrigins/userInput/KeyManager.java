/*     */ package beyondOrigins.userInput;
/*     */ 
/*     */ import beyondOrigins.main.Game;
/*     */ import beyondOrigins.main.inventory.Inventory;
/*     */ import beyondOrigins.main.menus.F3Menu;
/*     */ import beyondOrigins.main.menus.PauseMenu;
/*     */ import beyondOrigins.main.windows.Keys;
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
/*     */   private void pressed_backspace() {
/*  22 */     if ((Game.getMainMenu()).profileNameBoxState == 2 && 
/*  23 */       (Game.getMainMenu()).playerNameBoxState != 2)
/*  24 */       if ((Game.getMainMenu()).currentProfile == 1 && 
/*  25 */         (Game.getMainMenu()).save1Name.length() != 0) {
/*  26 */         (Game.getMainMenu()).save1Name = removeCharAt(
/*  27 */             (Game.getMainMenu()).save1Name, 
/*  28 */             (Game.getMainMenu()).save1Name.length() - 1);
/*  29 */       } else if ((Game.getMainMenu()).currentProfile == 2 && 
/*  30 */         (Game.getMainMenu()).save2Name.length() != 0) {
/*  31 */         (Game.getMainMenu()).save2Name = removeCharAt(
/*  32 */             (Game.getMainMenu()).save2Name, 
/*  33 */             (Game.getMainMenu()).save2Name.length() - 1);
/*  34 */       } else if ((Game.getMainMenu()).currentProfile == 3 && 
/*  35 */         (Game.getMainMenu()).save3Name.length() != 0) {
/*  36 */         (Game.getMainMenu()).save3Name = removeCharAt(
/*  37 */             (Game.getMainMenu()).save3Name, 
/*  38 */             (Game.getMainMenu()).save3Name.length() - 1);
/*     */       }  
/*  42 */     if ((Game.getMainMenu()).playerNameBoxState == 2 && 
/*  43 */       (Game.getMainMenu()).profileNameBoxState != 2 && 
/*  44 */       (Game.getPlayer()).typedName.length() != 0)
/*  45 */       (Game.getPlayer()).typedName = removeCharAt(
/*  46 */           (Game.getPlayer()).typedName, 
/*  47 */           (Game.getPlayer()).typedName.length() - 1); 
/*     */   }
/*     */   
/*     */   private void pressed_attack() {
/*  53 */     if (Game.isInGame)
/*  54 */       Game.getPlayer().attack(); 
/*     */   }
/*     */   
/*     */   private void released_esc() {
/*  59 */     if ((Game.getMainMenu()).menuState == 2) {
/*  60 */       (Game.getMainMenu()).menuState = 1;
/*  61 */     } else if ((Game.getMainMenu()).menuState == 4) {
/*  62 */       (Game.getMainMenu()).menuState = 1;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void released_up() {
/*  67 */     if (Game.isInGame && (Game.getMainMenu()).menuState == 0)
/*  68 */       (Game.getPlayer()).up = false; 
/*     */   }
/*     */   
/*     */   private void released_down() {
/*  73 */     if (Game.isInGame && (Game.getMainMenu()).menuState == 0)
/*  74 */       (Game.getPlayer()).down = false; 
/*     */   }
/*     */   
/*     */   private void released_left() {
/*  79 */     if (Game.isInGame && (Game.getMainMenu()).menuState == 0)
/*  80 */       (Game.getPlayer()).left = false; 
/*     */   }
/*     */   
/*     */   private void released_right() {
/*  85 */     if (Game.isInGame && (Game.getMainMenu()).menuState == 0)
/*  86 */       (Game.getPlayer()).right = false; 
/*     */   }
/*     */   
/*     */   private void released_enter() {
/*  91 */     if (((Game.getMainMenu()).currentProfile == 1 || 
/*  92 */       (Game.getMainMenu()).currentProfile == 2 || (Game.getMainMenu()).currentProfile == 3) && 
/*  93 */       (Game.getMainMenu()).menuState == 2 && !Game.isInGame)
/*     */       try {
/*  95 */         Game.getMainMenu().m2PlayProfile();
/*  96 */       } catch (IOException e1) {
/*  97 */         e1.printStackTrace();
/*     */       }  
/*     */   }
/*     */   
/*     */   private void released_block() {
/* 103 */     if (Game.isInGame && (Game.getMainMenu()).menuState == 0)
/* 104 */       (Game.getPlayer()).exp = (short)((Game.getPlayer()).exp + 10); 
/*     */   }
/*     */   
/*     */   public void keyPressed(KeyEvent e) {
/* 111 */     if (e.getKeyCode() == 8)
/* 112 */       pressed_backspace(); 
/* 116 */     if (e.getKeyCode() == Keys.up && !Inventory.invOpen && 
/* 117 */       (Game.getMainMenu()).menuState == 0) {
/* 118 */       (Game.getPlayer()).up = true;
/* 119 */     } else if (e.getKeyCode() != Keys.sprint && e.getKeyCode() != Keys.up && 
/* 120 */       e.getKeyCode() != Keys.attack) {
/* 121 */       (Game.getPlayer()).up = false;
/*     */     } 
/* 125 */     if (e.getKeyCode() == Keys.down && !Inventory.invOpen && 
/* 126 */       (Game.getMainMenu()).menuState == 0) {
/* 127 */       (Game.getPlayer()).down = true;
/* 128 */     } else if (e.getKeyCode() != Keys.sprint && e.getKeyCode() != Keys.down && 
/* 129 */       e.getKeyCode() != Keys.attack) {
/* 130 */       (Game.getPlayer()).down = false;
/*     */     } 
/* 134 */     if (e.getKeyCode() == Keys.left && !Inventory.invOpen && 
/* 135 */       (Game.getMainMenu()).menuState == 0) {
/* 136 */       (Game.getPlayer()).left = true;
/* 137 */     } else if (e.getKeyCode() != Keys.sprint && e.getKeyCode() != Keys.left && 
/* 138 */       e.getKeyCode() != Keys.attack) {
/* 139 */       (Game.getPlayer()).left = false;
/*     */     } 
/* 143 */     if (e.getKeyCode() == Keys.right && !Inventory.invOpen && 
/* 144 */       (Game.getMainMenu()).menuState == 0) {
/* 145 */       (Game.getPlayer()).right = true;
/* 146 */     } else if (e.getKeyCode() != Keys.sprint && 
/* 147 */       e.getKeyCode() != Keys.right && 
/* 148 */       e.getKeyCode() != Keys.attack) {
/* 149 */       (Game.getPlayer()).right = false;
/*     */     } 
/* 153 */     if (e.getKeyCode() == Keys.invToggle && Game.isInGame && 
/* 154 */       !PauseMenu.isOpen)
/* 155 */       Inventory.invOpen = !Inventory.invOpen; 
/* 159 */     if (e.getKeyCode() == 114)
/* 160 */       F3Menu.f3menu = !F3Menu.f3menu; 
/* 164 */     if (e.getKeyCode() == 27) {
/* 165 */       escPressed = true;
/*     */     } else {
/* 167 */       escPressed = false;
/*     */     } 
/* 168 */     if (e.getKeyCode() == 27 && Game.isInGame && 
/* 169 */       !Inventory.invOpen && !PauseMenu.isOpen)
/* 170 */       PauseMenu.isOpen = true; 
/* 174 */     if (e.getKeyCode() == 10)
/* 175 */       enterPressed = !enterPressed; 
/* 185 */     if (e.getKeyCode() == Keys.attack && !Inventory.invOpen)
/* 186 */       pressed_attack(); 
/*     */   }
/*     */   
/*     */   public void keyReleased(KeyEvent e) {
/* 194 */     if (e.getKeyCode() == Keys.block)
/* 195 */       released_block(); 
/* 199 */     if (e.getKeyCode() == Keys.attack && !Inventory.invOpen)
/* 200 */       (Game.getPlayer()).isAttacking = false; 
/* 204 */     if (e.getKeyCode() == Keys.up)
/* 205 */       released_up(); 
/* 209 */     if (e.getKeyCode() == Keys.down)
/* 210 */       released_down(); 
/* 214 */     if (e.getKeyCode() == Keys.left)
/* 215 */       released_left(); 
/* 219 */     if (e.getKeyCode() == Keys.right)
/* 220 */       released_right(); 
/* 230 */     if (e.getKeyCode() == 27) {
/* 231 */       escPressed = false;
/* 232 */       released_esc();
/*     */     } 
/* 236 */     if (e.getKeyCode() == 10)
/* 237 */       released_enter(); 
/*     */   }
/*     */   
/*     */   public void keyTyped(KeyEvent e) {}
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.8_1.jar!\beyondOrigin\\userInput\KeyManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */