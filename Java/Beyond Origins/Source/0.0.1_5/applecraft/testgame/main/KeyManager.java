/*    */ package applecraft.testgame.main;
/*    */ 
/*    */ import applecraft.testgame.main.entities.Player;
/*    */ import java.awt.event.KeyEvent;
/*    */ import java.awt.event.KeyListener;
/*    */ 
/*    */ public class KeyManager implements KeyListener {
/*    */   public void keyPressed(KeyEvent e) {
/* 13 */     if (e.getKeyCode() == 87) {
/* 14 */       Player.up = true;
/*    */     } else {
/* 16 */       Player.up = false;
/*    */     } 
/* 19 */     if (e.getKeyCode() == 83) {
/* 20 */       Player.down = true;
/*    */     } else {
/* 22 */       Player.down = false;
/*    */     } 
/* 25 */     if (e.getKeyCode() == 65) {
/* 26 */       Player.left = true;
/*    */     } else {
/* 28 */       Player.left = false;
/*    */     } 
/* 31 */     if (e.getKeyCode() == 68) {
/* 32 */       Player.right = true;
/*    */     } else {
/* 34 */       Player.right = false;
/*    */     } 
/* 37 */     if (e.getKeyCode() == 114)
/* 38 */       Player.f3menu = true; 
/*    */   }
/*    */   
/*    */   public void keyReleased(KeyEvent e) {
/* 45 */     if (e.getKeyCode() == 87)
/* 46 */       Player.up = false; 
/* 48 */     if (e.getKeyCode() == 83)
/* 49 */       Player.down = false; 
/* 51 */     if (e.getKeyCode() == 65)
/* 52 */       Player.left = false; 
/* 54 */     if (e.getKeyCode() == 68)
/* 55 */       Player.right = false; 
/*    */   }
/*    */   
/*    */   public void keyTyped(KeyEvent e) {}
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.1_5.jar!\applecraft\testgame\main\KeyManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */