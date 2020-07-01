/*    */ package applecraft.testgame.main;
/*    */ 
/*    */ import applecraft.testgame.main.entities.Player;
/*    */ import applecraft.testgame.main.menus.F3Menu;
/*    */ import java.awt.event.KeyEvent;
/*    */ import java.awt.event.KeyListener;
/*    */ 
/*    */ public class KeyManager implements KeyListener {
/*    */   public void keyPressed(KeyEvent e) {
/* 14 */     if (e.getKeyCode() == 87 || e.getKeyCode() == 38) {
/* 15 */       Player.up = true;
/*    */     } else {
/* 17 */       Player.up = false;
/*    */     } 
/* 20 */     if (e.getKeyCode() == 83 || e.getKeyCode() == 40) {
/* 21 */       Player.down = true;
/*    */     } else {
/* 23 */       Player.down = false;
/*    */     } 
/* 26 */     if (e.getKeyCode() == 65 || e.getKeyCode() == 37) {
/* 27 */       Player.left = true;
/*    */     } else {
/* 29 */       Player.left = false;
/*    */     } 
/* 32 */     if (e.getKeyCode() == 68 || e.getKeyCode() == 39) {
/* 33 */       Player.right = true;
/*    */     } else {
/* 35 */       Player.right = false;
/*    */     } 
/* 38 */     if (e.getKeyCode() == 114)
/* 39 */       F3Menu.f3menu = !F3Menu.f3menu; 
/* 42 */     if (e.getKeyCode() == 27 && Game.gameRequested)
/* 43 */       Game.gameRequested = !Game.gameRequested; 
/*    */   }
/*    */   
/*    */   public void keyReleased(KeyEvent e) {
/* 50 */     if (e.getKeyCode() == 87 || e.getKeyCode() == 38)
/* 51 */       Player.up = false; 
/* 53 */     if (e.getKeyCode() == 83 || e.getKeyCode() == 40)
/* 54 */       Player.down = false; 
/* 56 */     if (e.getKeyCode() == 65 || e.getKeyCode() == 37)
/* 57 */       Player.left = false; 
/* 59 */     if (e.getKeyCode() == 68 || e.getKeyCode() == 39)
/* 60 */       Player.right = false; 
/*    */   }
/*    */   
/*    */   public void keyTyped(KeyEvent e) {}
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.3_8.jar!\applecraft\testgame\main\KeyManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */