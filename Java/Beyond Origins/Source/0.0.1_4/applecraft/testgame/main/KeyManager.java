/*    */ package applecraft.testgame.main;
/*    */ 
/*    */ import applecraft.testgame.main.entities.Player;
/*    */ import java.awt.event.KeyEvent;
/*    */ import java.awt.event.KeyListener;
/*    */ 
/*    */ public class KeyManager implements KeyListener {
/*    */   public void keyPressed(KeyEvent e) {
/* 12 */     if (e.getKeyCode() == 87) {
/* 13 */       Player.up = true;
/*    */     } else {
/* 15 */       Player.up = false;
/*    */     } 
/* 18 */     if (e.getKeyCode() == 83) {
/* 19 */       Player.down = true;
/*    */     } else {
/* 21 */       Player.down = false;
/*    */     } 
/* 24 */     if (e.getKeyCode() == 65) {
/* 25 */       Player.left = true;
/*    */     } else {
/* 27 */       Player.left = false;
/*    */     } 
/* 30 */     if (e.getKeyCode() == 68) {
/* 31 */       Player.right = true;
/*    */     } else {
/* 33 */       Player.right = false;
/*    */     } 
/* 36 */     if (e.getKeyCode() == 114)
/* 37 */       (Game.getPlayer()).f3menu = true; 
/*    */   }
/*    */   
/*    */   public void keyReleased(KeyEvent e) {
/* 44 */     if (e.getKeyCode() == 87)
/* 45 */       Player.up = false; 
/* 47 */     if (e.getKeyCode() == 83)
/* 48 */       Player.down = false; 
/* 50 */     if (e.getKeyCode() == 65)
/* 51 */       Player.left = false; 
/* 53 */     if (e.getKeyCode() == 68)
/* 54 */       Player.right = false; 
/*    */   }
/*    */   
/*    */   public void keyTyped(KeyEvent e) {}
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.1_4.jar!\applecraft\testgame\main\KeyManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */