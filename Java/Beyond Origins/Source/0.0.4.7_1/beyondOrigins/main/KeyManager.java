/*    */ package beyondOrigins.main;
/*    */ 
/*    */ import beyondOrigins.main.entities.Player;
/*    */ import beyondOrigins.main.inventory.InventoryMain;
/*    */ import beyondOrigins.main.menus.F3Menu;
/*    */ import beyondOrigins.main.menus.PauseMenu;
/*    */ import java.awt.event.KeyEvent;
/*    */ import java.awt.event.KeyListener;
/*    */ 
/*    */ public class KeyManager implements KeyListener {
/*    */   public static boolean enterPressed = false;
/*    */   
/*    */   public static boolean onePressed = false;
/*    */   
/*    */   public static boolean escPressed = false;
/*    */   
/*    */   public void keyPressed(KeyEvent e) {
/* 17 */     if ((e.getKeyCode() == 87 || e.getKeyCode() == 38) && 
/* 18 */       !InventoryMain.invOpen) {
/* 19 */       Player.up = true;
/*    */     } else {
/* 21 */       Player.up = false;
/*    */     } 
/* 24 */     if ((e.getKeyCode() == 83 || e.getKeyCode() == 40) && 
/* 25 */       !InventoryMain.invOpen) {
/* 26 */       Player.down = true;
/*    */     } else {
/* 28 */       Player.down = false;
/*    */     } 
/* 31 */     if ((e.getKeyCode() == 65 || e.getKeyCode() == 37) && 
/* 32 */       !InventoryMain.invOpen) {
/* 33 */       Player.left = true;
/*    */     } else {
/* 35 */       Player.left = false;
/*    */     } 
/* 38 */     if ((e.getKeyCode() == 68 || e.getKeyCode() == 39) && 
/* 39 */       !InventoryMain.invOpen) {
/* 40 */       Player.right = true;
/*    */     } else {
/* 42 */       Player.right = false;
/*    */     } 
/* 45 */     if (e.getKeyCode() == 69 && Game.isInGame && !PauseMenu.isOpen)
/* 46 */       InventoryMain.invOpen = !InventoryMain.invOpen; 
/* 49 */     if (e.getKeyCode() == 114)
/* 50 */       F3Menu.f3menu = !F3Menu.f3menu; 
/* 53 */     if (e.getKeyCode() == 27) {
/* 54 */       escPressed = true;
/*    */     } else {
/* 56 */       escPressed = false;
/*    */     } 
/* 58 */     if (e.getKeyCode() == 27 && Game.isInGame && 
/* 59 */       !InventoryMain.invOpen && !PauseMenu.isOpen)
/* 60 */       PauseMenu.isOpen = true; 
/* 63 */     if (e.getKeyCode() == 10) {
/* 64 */       enterPressed = true;
/*    */     } else {
/* 66 */       enterPressed = false;
/*    */     } 
/* 69 */     if (e.getKeyCode() == 49) {
/* 70 */       onePressed = true;
/*    */     } else {
/* 72 */       onePressed = false;
/*    */     } 
/*    */   }
/*    */   
/*    */   public void keyReleased(KeyEvent e) {
/* 78 */     if (e.getKeyCode() == 87 || e.getKeyCode() == 38)
/* 79 */       Player.up = false; 
/* 81 */     if (e.getKeyCode() == 83 || e.getKeyCode() == 40)
/* 82 */       Player.down = false; 
/* 84 */     if (e.getKeyCode() == 65 || e.getKeyCode() == 37)
/* 85 */       Player.left = false; 
/* 87 */     if (e.getKeyCode() == 68 || e.getKeyCode() == 39)
/* 88 */       Player.right = false; 
/* 91 */     if (e.getKeyCode() == 27)
/* 92 */       escPressed = false; 
/* 95 */     if (e.getKeyCode() == 10)
/* 96 */       enterPressed = false; 
/* 98 */     if (e.getKeyCode() == 49)
/* 99 */       onePressed = false; 
/*    */   }
/*    */   
/*    */   public void keyTyped(KeyEvent e) {}
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4.7_1.jar!\beyondOrigins\main\KeyManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */