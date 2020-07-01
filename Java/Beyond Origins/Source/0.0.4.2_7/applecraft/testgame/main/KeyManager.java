/*    */ package applecraft.testgame.main;
/*    */ 
/*    */ import applecraft.testgame.main.entities.Player;
/*    */ import applecraft.testgame.main.inventory.InventoryMain;
/*    */ import applecraft.testgame.main.menus.F3Menu;
/*    */ import java.awt.event.KeyEvent;
/*    */ import java.awt.event.KeyListener;
/*    */ 
/*    */ public class KeyManager implements KeyListener {
/*    */   public static boolean enterPressed = false;
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
/* 45 */     if (e.getKeyCode() == 69 && Game.gameRequested)
/* 46 */       InventoryMain.invOpen = !InventoryMain.invOpen; 
/* 49 */     if (e.getKeyCode() == 114)
/* 50 */       F3Menu.f3menu = !F3Menu.f3menu; 
/* 53 */     if (e.getKeyCode() == 27 && Game.gameRequested && 
/* 54 */       !InventoryMain.invOpen)
/* 55 */       Game.gameRequested = !Game.gameRequested; 
/* 58 */     if (e.getKeyCode() == 10) {
/* 59 */       enterPressed = true;
/*    */     } else {
/* 60 */       enterPressed = false;
/*    */     } 
/*    */   }
/*    */   
/*    */   public void keyReleased(KeyEvent e) {
/* 65 */     if (e.getKeyCode() == 87 || 
/* 66 */       e.getKeyCode() == 38)
/* 67 */       Player.up = false; 
/* 69 */     if (e.getKeyCode() == 83 || 
/* 70 */       e.getKeyCode() == 40)
/* 71 */       Player.down = false; 
/* 73 */     if (e.getKeyCode() == 65 || 
/* 74 */       e.getKeyCode() == 37)
/* 75 */       Player.left = false; 
/* 77 */     if (e.getKeyCode() == 68 || 
/* 78 */       e.getKeyCode() == 39)
/* 79 */       Player.right = false; 
/* 82 */     if (e.getKeyCode() == 10)
/* 83 */       enterPressed = false; 
/*    */   }
/*    */   
/*    */   public void keyTyped(KeyEvent e) {}
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4.2_7.jar!\applecraft\testgame\main\KeyManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */