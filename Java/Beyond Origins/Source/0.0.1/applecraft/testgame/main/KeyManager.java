/*    */ package applecraft.testgame.main;
/*    */ 
/*    */ import java.awt.event.KeyEvent;
/*    */ import java.awt.event.KeyListener;
/*    */ 
/*    */ public class KeyManager implements KeyListener {
/*    */   public void keyPressed(KeyEvent e) {
/* 10 */     if (e.getKeyCode() == 87) {
/* 11 */       (Game.getPlayer()).up = true;
/*    */     } else {
/* 12 */       (Game.getPlayer()).up = false;
/*    */     } 
/* 14 */     if (e.getKeyCode() == 83) {
/* 15 */       (Game.getPlayer()).down = true;
/*    */     } else {
/* 16 */       (Game.getPlayer()).down = false;
/*    */     } 
/* 18 */     if (e.getKeyCode() == 65) {
/* 19 */       (Game.getPlayer()).left = true;
/*    */     } else {
/* 20 */       (Game.getPlayer()).left = false;
/*    */     } 
/* 22 */     if (e.getKeyCode() == 68) {
/* 23 */       (Game.getPlayer()).right = true;
/*    */     } else {
/* 24 */       (Game.getPlayer()).right = false;
/*    */     } 
/*    */   }
/*    */   
/*    */   public void keyReleased(KeyEvent e) {
/* 30 */     if (e.getKeyCode() == 87)
/* 31 */       (Game.getPlayer()).up = false; 
/* 33 */     if (e.getKeyCode() == 83)
/* 34 */       (Game.getPlayer()).down = false; 
/* 36 */     if (e.getKeyCode() == 65)
/* 37 */       (Game.getPlayer()).left = false; 
/* 39 */     if (e.getKeyCode() == 68)
/* 40 */       (Game.getPlayer()).right = false; 
/*    */   }
/*    */   
/*    */   public void keyTyped(KeyEvent e) {}
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.1.jar!\applecraft\testgame\main\KeyManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */