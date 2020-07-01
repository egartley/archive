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
/*     */   private void released_up() {
/*  59 */     if (Game.isInGame && (Game.getMainMenu()).menuState == 0)
/*  60 */       (Game.getPlayer()).up = false; 
/*     */   }
/*     */   
/*     */   private void released_down() {
/*  65 */     if (Game.isInGame && (Game.getMainMenu()).menuState == 0)
/*  66 */       (Game.getPlayer()).down = false; 
/*     */   }
/*     */   
/*     */   private void released_left() {
/*  71 */     if (Game.isInGame && (Game.getMainMenu()).menuState == 0)
/*  72 */       (Game.getPlayer()).left = false; 
/*     */   }
/*     */   
/*     */   private void released_right() {
/*  77 */     if (Game.isInGame && (Game.getMainMenu()).menuState == 0)
/*  78 */       (Game.getPlayer()).right = false; 
/*     */   }
/*     */   
/*     */   private void released_enter() {
/*  83 */     if (((Game.getMainMenu()).currentProfile == 1 || 
/*  84 */       (Game.getMainMenu()).currentProfile == 2 || (Game.getMainMenu()).currentProfile == 3) && 
/*  85 */       (Game.getMainMenu()).menuState == 2 && !Game.isInGame)
/*     */       try {
/*  87 */         Game.getMainMenu().m2PlayProfile();
/*  88 */       } catch (IOException e1) {
/*  89 */         e1.printStackTrace();
/*     */       }  
/*     */   }
/*     */   
/*     */   private void released_block() {
/*  95 */     if (Game.isInGame && (Game.getMainMenu()).menuState == 0)
/*  96 */       (Game.getPlayer()).exp = (short)((Game.getPlayer()).exp + 10); 
/*     */   }
/*     */   
/*     */   public void keyPressed(KeyEvent e) {
/* 103 */     if (e.getKeyCode() == 8)
/* 104 */       pressed_backspace(); 
/* 108 */     if (e.getKeyCode() == Keys.up && !Inventory.invOpen && 
/* 109 */       (Game.getMainMenu()).menuState == 0) {
/* 110 */       (Game.getPlayer()).up = true;
/* 111 */     } else if (e.getKeyCode() != Keys.sprint && e.getKeyCode() != Keys.up && 
/* 112 */       e.getKeyCode() != Keys.attack) {
/* 113 */       (Game.getPlayer()).up = false;
/*     */     } 
/* 117 */     if (e.getKeyCode() == Keys.down && !Inventory.invOpen && 
/* 118 */       (Game.getMainMenu()).menuState == 0) {
/* 119 */       (Game.getPlayer()).down = true;
/* 120 */     } else if (e.getKeyCode() != Keys.sprint && e.getKeyCode() != Keys.down && 
/* 121 */       e.getKeyCode() != Keys.attack) {
/* 122 */       (Game.getPlayer()).down = false;
/*     */     } 
/* 126 */     if (e.getKeyCode() == Keys.left && !Inventory.invOpen && 
/* 127 */       (Game.getMainMenu()).menuState == 0) {
/* 128 */       (Game.getPlayer()).left = true;
/* 129 */     } else if (e.getKeyCode() != Keys.sprint && e.getKeyCode() != Keys.left && 
/* 130 */       e.getKeyCode() != Keys.attack) {
/* 131 */       (Game.getPlayer()).left = false;
/*     */     } 
/* 135 */     if (e.getKeyCode() == Keys.right && !Inventory.invOpen && 
/* 136 */       (Game.getMainMenu()).menuState == 0) {
/* 137 */       (Game.getPlayer()).right = true;
/* 138 */     } else if (e.getKeyCode() != Keys.sprint && 
/* 139 */       e.getKeyCode() != Keys.right && 
/* 140 */       e.getKeyCode() != Keys.attack) {
/* 141 */       (Game.getPlayer()).right = false;
/*     */     } 
/* 145 */     if (e.getKeyCode() == Keys.invToggle && Game.isInGame && 
/* 146 */       !PauseMenu.isOpen)
/* 147 */       Inventory.invOpen = !Inventory.invOpen; 
/* 151 */     if (e.getKeyCode() == 114)
/* 152 */       F3Menu.f3menu = !F3Menu.f3menu; 
/* 156 */     if (e.getKeyCode() == 27) {
/* 157 */       escPressed = true;
/*     */     } else {
/* 159 */       escPressed = false;
/*     */     } 
/* 160 */     if (e.getKeyCode() == 27 && Game.isInGame && 
/* 161 */       !Inventory.invOpen && !PauseMenu.isOpen)
/* 162 */       PauseMenu.isOpen = true; 
/* 166 */     if (e.getKeyCode() == 10)
/* 167 */       enterPressed = !enterPressed; 
/* 177 */     if (e.getKeyCode() == Keys.attack && !Inventory.invOpen)
/* 178 */       pressed_attack(); 
/*     */   }
/*     */   
/*     */   public void keyReleased(KeyEvent e) {
/* 186 */     if (e.getKeyCode() == Keys.block)
/* 187 */       released_block(); 
/* 191 */     if (e.getKeyCode() == Keys.attack && !Inventory.invOpen)
/* 192 */       (Game.getPlayer()).isAttacking = false; 
/* 196 */     if (e.getKeyCode() == Keys.up)
/* 197 */       released_up(); 
/* 201 */     if (e.getKeyCode() == Keys.down)
/* 202 */       released_down(); 
/* 206 */     if (e.getKeyCode() == Keys.left)
/* 207 */       released_left(); 
/* 211 */     if (e.getKeyCode() == Keys.right)
/* 212 */       released_right(); 
/* 222 */     if (e.getKeyCode() == 27)
/* 223 */       escPressed = false; 
/* 227 */     if (e.getKeyCode() == 10)
/* 228 */       released_enter(); 
/*     */   }
/*     */   
/*     */   public void keyTyped(KeyEvent e) {}
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.7.jar!\beyondOrigin\\userInput\KeyManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */