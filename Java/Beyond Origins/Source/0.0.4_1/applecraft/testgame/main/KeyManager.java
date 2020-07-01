/*    */ package applecraft.testgame.main;
/*    */ 
/*    */ import applecraft.testgame.main.entities.Player;
/*    */ import applecraft.testgame.main.inventory.InventoryMain;
/*    */ import applecraft.testgame.main.menus.F3Menu;
/*    */ import java.awt.event.KeyEvent;
/*    */ import java.awt.event.KeyListener;
/*    */ 
/*    */ public class KeyManager implements KeyListener {
/*    */   public void keyPressed(KeyEvent e) {
/* 15 */     if ((e.getKeyCode() == 87 || e.getKeyCode() == 38) && 
/* 16 */       !InventoryMain.invOpen) {
/* 17 */       Player.up = true;
/*    */     } else {
/* 19 */       Player.up = false;
/*    */     } 
/* 22 */     if ((e.getKeyCode() == 83 || e.getKeyCode() == 40) && 
/* 23 */       !InventoryMain.invOpen) {
/* 24 */       Player.down = true;
/*    */     } else {
/* 26 */       Player.down = false;
/*    */     } 
/* 29 */     if ((e.getKeyCode() == 65 || e.getKeyCode() == 37) && 
/* 30 */       !InventoryMain.invOpen) {
/* 31 */       Player.left = true;
/*    */     } else {
/* 33 */       Player.left = false;
/*    */     } 
/* 36 */     if ((e.getKeyCode() == 68 || e.getKeyCode() == 39) && 
/* 37 */       !InventoryMain.invOpen) {
/* 38 */       Player.right = true;
/*    */     } else {
/* 40 */       Player.right = false;
/*    */     } 
/* 43 */     if (e.getKeyCode() == 69 && Game.gameRequested)
/* 44 */       InventoryMain.invOpen = !InventoryMain.invOpen; 
/* 47 */     if (e.getKeyCode() == 114)
/* 48 */       F3Menu.f3menu = !F3Menu.f3menu; 
/* 51 */     if (e.getKeyCode() == 27 && Game.gameRequested && 
/* 52 */       !InventoryMain.invOpen)
/* 53 */       Game.gameRequested = !Game.gameRequested; 
/*    */   }
/*    */   
/*    */   public void keyReleased(KeyEvent e) {
/* 60 */     if (e.getKeyCode() == 87 || 
/* 61 */       e.getKeyCode() == 38)
/* 62 */       Player.up = false; 
/* 64 */     if (e.getKeyCode() == 83 || 
/* 65 */       e.getKeyCode() == 40)
/* 66 */       Player.down = false; 
/* 68 */     if (e.getKeyCode() == 65 || 
/* 69 */       e.getKeyCode() == 37)
/* 70 */       Player.left = false; 
/* 72 */     if (e.getKeyCode() == 68 || 
/* 73 */       e.getKeyCode() == 39)
/* 74 */       Player.right = false; 
/*    */   }
/*    */   
/*    */   public void keyTyped(KeyEvent e) {}
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4_1.jar!\applecraft\testgame\main\KeyManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */