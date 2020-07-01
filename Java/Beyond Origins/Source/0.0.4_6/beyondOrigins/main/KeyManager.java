/*    */ package beyondOrigins.main;
/*    */ 
/*    */ import beyondOrigins.main.entities.Player;
/*    */ import beyondOrigins.main.inventory.InventoryMain;
/*    */ import beyondOrigins.main.menus.F3Menu;
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
/* 16 */     if ((e.getKeyCode() == 87 || e.getKeyCode() == 38) && 
/* 17 */       !InventoryMain.invOpen) {
/* 18 */       Player.up = true;
/*    */     } else {
/* 20 */       Player.up = false;
/*    */     } 
/* 23 */     if ((e.getKeyCode() == 83 || e.getKeyCode() == 40) && 
/* 24 */       !InventoryMain.invOpen) {
/* 25 */       Player.down = true;
/*    */     } else {
/* 27 */       Player.down = false;
/*    */     } 
/* 30 */     if ((e.getKeyCode() == 65 || e.getKeyCode() == 37) && 
/* 31 */       !InventoryMain.invOpen) {
/* 32 */       Player.left = true;
/*    */     } else {
/* 34 */       Player.left = false;
/*    */     } 
/* 37 */     if ((e.getKeyCode() == 68 || e.getKeyCode() == 39) && 
/* 38 */       !InventoryMain.invOpen) {
/* 39 */       Player.right = true;
/*    */     } else {
/* 41 */       Player.right = false;
/*    */     } 
/* 44 */     if (e.getKeyCode() == 69 && Game.isInGame)
/* 45 */       InventoryMain.invOpen = !InventoryMain.invOpen; 
/* 48 */     if (e.getKeyCode() == 114)
/* 49 */       F3Menu.f3menu = !F3Menu.f3menu; 
/* 52 */     if (e.getKeyCode() == 27) {
/* 53 */       escPressed = true;
/*    */     } else {
/* 55 */       escPressed = false;
/*    */     } 
/* 57 */     if (e.getKeyCode() == 27 && Game.isInGame && 
/* 58 */       !InventoryMain.invOpen)
/* 59 */       Game.isInGame = false; 
/* 62 */     if (e.getKeyCode() == 10) {
/* 63 */       enterPressed = true;
/*    */     } else {
/* 65 */       enterPressed = false;
/*    */     } 
/* 68 */     if (e.getKeyCode() == 49) {
/* 69 */       onePressed = true;
/*    */     } else {
/* 71 */       onePressed = false;
/*    */     } 
/*    */   }
/*    */   
/*    */   public void keyReleased(KeyEvent e) {
/* 77 */     if (e.getKeyCode() == 87 || e.getKeyCode() == 38)
/* 78 */       Player.up = false; 
/* 80 */     if (e.getKeyCode() == 83 || e.getKeyCode() == 40)
/* 81 */       Player.down = false; 
/* 83 */     if (e.getKeyCode() == 65 || e.getKeyCode() == 37)
/* 84 */       Player.left = false; 
/* 86 */     if (e.getKeyCode() == 68 || e.getKeyCode() == 39)
/* 87 */       Player.right = false; 
/* 90 */     if (e.getKeyCode() == 27)
/* 91 */       escPressed = false; 
/* 94 */     if (e.getKeyCode() == 10)
/* 95 */       enterPressed = false; 
/* 97 */     if (e.getKeyCode() == 49)
/* 98 */       onePressed = false; 
/*    */   }
/*    */   
/*    */   public void keyTyped(KeyEvent e) {}
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4_6.jar!\beyondOrigins\main\KeyManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */