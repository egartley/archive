/*     */ package com.emgartley.beyondOrigins.userInput;
/*     */ 
/*     */ import com.emgartley.beyondOrigins.main.Game;
/*     */ import com.emgartley.beyondOrigins.main.inventory.Inventory;
/*     */ import com.emgartley.beyondOrigins.main.menus.F3Menu;
/*     */ import com.emgartley.beyondOrigins.main.menus.PauseMenu;
/*     */ import com.emgartley.beyondOrigins.main.windows.Keys;
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
/*     */   private void pressed_attack() {
/*  22 */     if (Game.isInGame)
/*  23 */       Game.getPlayer().attack(); 
/*     */   }
/*     */   
/*     */   private void released_esc() {
/*  28 */     if ((Game.getMainMenu()).menuState == 2) {
/*  29 */       (Game.getMainMenu()).menuState = 1;
/*  30 */     } else if ((Game.getMainMenu()).menuState == 4) {
/*  31 */       (Game.getMainMenu()).menuState = 1;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void released_up() {
/*  36 */     if (Game.isInGame && (Game.getMainMenu()).menuState == 0)
/*  37 */       (Game.getPlayer()).up = false; 
/*     */   }
/*     */   
/*     */   private void released_down() {
/*  42 */     if (Game.isInGame && (Game.getMainMenu()).menuState == 0)
/*  43 */       (Game.getPlayer()).down = false; 
/*     */   }
/*     */   
/*     */   private void released_left() {
/*  48 */     if (Game.isInGame && (Game.getMainMenu()).menuState == 0)
/*  49 */       (Game.getPlayer()).left = false; 
/*     */   }
/*     */   
/*     */   private void released_right() {
/*  54 */     if (Game.isInGame && (Game.getMainMenu()).menuState == 0)
/*  55 */       (Game.getPlayer()).right = false; 
/*     */   }
/*     */   
/*     */   private void released_enter() {
/*  60 */     if (((Game.getMainMenu()).currentProfile == 1 || 
/*  61 */       (Game.getMainMenu()).currentProfile == 2 || (Game.getMainMenu()).currentProfile == 3) && 
/*  62 */       (Game.getMainMenu()).menuState == 2 && !Game.isInGame)
/*     */       try {
/*  64 */         Game.getMainMenu().m2PlayProfile();
/*  65 */       } catch (IOException e1) {
/*  66 */         e1.printStackTrace();
/*     */       }  
/*     */   }
/*     */   
/*     */   private void released_block() {
/*  72 */     if (Game.isInGame && (Game.getMainMenu()).menuState == 0)
/*  73 */       (Game.getPlayer()).exp = (short)((Game.getPlayer()).exp + 10); 
/*     */   }
/*     */   
/*     */   public void keyPressed(KeyEvent e) {
/*  80 */     if (e.getKeyCode() == Keys.up && !Inventory.invOpen && 
/*  81 */       (Game.getMainMenu()).menuState == 0) {
/*  82 */       (Game.getPlayer()).up = true;
/*  83 */     } else if (e.getKeyCode() != Keys.sprint && e.getKeyCode() != Keys.up && 
/*  84 */       e.getKeyCode() != Keys.attack) {
/*  85 */       (Game.getPlayer()).up = false;
/*     */     } 
/*  89 */     if (e.getKeyCode() == Keys.down && !Inventory.invOpen && 
/*  90 */       (Game.getMainMenu()).menuState == 0) {
/*  91 */       (Game.getPlayer()).down = true;
/*  92 */     } else if (e.getKeyCode() != Keys.sprint && e.getKeyCode() != Keys.down && 
/*  93 */       e.getKeyCode() != Keys.attack) {
/*  94 */       (Game.getPlayer()).down = false;
/*     */     } 
/*  98 */     if (e.getKeyCode() == Keys.left && !Inventory.invOpen && 
/*  99 */       (Game.getMainMenu()).menuState == 0) {
/* 100 */       (Game.getPlayer()).left = true;
/* 101 */     } else if (e.getKeyCode() != Keys.sprint && e.getKeyCode() != Keys.left && 
/* 102 */       e.getKeyCode() != Keys.attack) {
/* 103 */       (Game.getPlayer()).left = false;
/*     */     } 
/* 107 */     if (e.getKeyCode() == Keys.right && !Inventory.invOpen && 
/* 108 */       (Game.getMainMenu()).menuState == 0) {
/* 109 */       (Game.getPlayer()).right = true;
/* 110 */     } else if (e.getKeyCode() != Keys.sprint && 
/* 111 */       e.getKeyCode() != Keys.right && 
/* 112 */       e.getKeyCode() != Keys.attack) {
/* 113 */       (Game.getPlayer()).right = false;
/*     */     } 
/* 117 */     if (e.getKeyCode() == Keys.invToggle && Game.isInGame && 
/* 118 */       !PauseMenu.isOpen)
/* 119 */       Inventory.invOpen = !Inventory.invOpen; 
/* 123 */     if (e.getKeyCode() == 114)
/* 124 */       F3Menu.f3menu = !F3Menu.f3menu; 
/* 128 */     if (e.getKeyCode() == 27) {
/* 129 */       escPressed = true;
/*     */     } else {
/* 131 */       escPressed = false;
/*     */     } 
/* 132 */     if (e.getKeyCode() == 27 && Game.isInGame && 
/* 133 */       !Inventory.invOpen && !PauseMenu.isOpen)
/* 134 */       PauseMenu.isOpen = true; 
/* 138 */     if (e.getKeyCode() == 10)
/* 139 */       enterPressed = !enterPressed; 
/* 149 */     if (e.getKeyCode() == Keys.attack && !Inventory.invOpen)
/* 150 */       pressed_attack(); 
/*     */   }
/*     */   
/*     */   public void keyReleased(KeyEvent e) {
/* 158 */     if (e.getKeyCode() == Keys.block)
/* 159 */       released_block(); 
/* 163 */     if (e.getKeyCode() == Keys.attack && !Inventory.invOpen)
/* 164 */       (Game.getPlayer()).isAttacking = false; 
/* 168 */     if (e.getKeyCode() == Keys.up)
/* 169 */       released_up(); 
/* 173 */     if (e.getKeyCode() == Keys.down)
/* 174 */       released_down(); 
/* 178 */     if (e.getKeyCode() == Keys.left)
/* 179 */       released_left(); 
/* 183 */     if (e.getKeyCode() == Keys.right)
/* 184 */       released_right(); 
/* 194 */     if (e.getKeyCode() == 27) {
/* 195 */       escPressed = false;
/* 196 */       released_esc();
/*     */     } 
/* 200 */     if (e.getKeyCode() == 10)
/* 201 */       released_enter(); 
/*     */   }
/*     */   
/*     */   public void keyTyped(KeyEvent e) {}
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.1.0_1.jar!\com\emgartley\beyondOrigin\\userInput\KeyManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */