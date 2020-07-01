/*    */ package applecraft.testgame.main;
/*    */ 
/*    */ import applecraft.testgame.main.entities.Player;
/*    */ import applecraft.testgame.main.menus.F3Menu;
/*    */ import java.awt.event.KeyEvent;
/*    */ import java.awt.event.KeyListener;
/*    */ 
/*    */ public class KeyManager implements KeyListener {
/* 12 */   private double keyTyped = 0.0D;
/*    */   
/*    */   public void keyPressed(KeyEvent e) {
/* 16 */     if (e.getKeyCode() == 87) {
/* 17 */       Player.up = true;
/*    */     } else {
/* 19 */       Player.up = false;
/*    */     } 
/* 22 */     if (e.getKeyCode() == 83) {
/* 23 */       Player.down = true;
/*    */     } else {
/* 25 */       Player.down = false;
/*    */     } 
/* 28 */     if (e.getKeyCode() == 65) {
/* 29 */       Player.left = true;
/*    */     } else {
/* 31 */       Player.left = false;
/*    */     } 
/* 34 */     if (e.getKeyCode() == 68) {
/* 35 */       Player.right = true;
/*    */     } else {
/* 37 */       Player.right = false;
/*    */     } 
/* 40 */     if (e.getKeyCode() == 114)
/* 41 */       F3Menu.f3menu = !F3Menu.f3menu; 
/* 44 */     if (e.getKeyCode() == 27 && Game.gameRequested)
/* 45 */       Game.gameRequested = !Game.gameRequested; 
/*    */   }
/*    */   
/*    */   public void keyReleased(KeyEvent e) {
/* 52 */     if (e.getKeyCode() == 87)
/* 53 */       Player.up = false; 
/* 55 */     if (e.getKeyCode() == 83)
/* 56 */       Player.down = false; 
/* 58 */     if (e.getKeyCode() == 65)
/* 59 */       Player.left = false; 
/* 61 */     if (e.getKeyCode() == 68)
/* 62 */       Player.right = false; 
/* 65 */     if (e.getKeyCode() == 49 && this.keyTyped == 1.05D)
/* 66 */       Player.SPEED = 1.0D; 
/* 69 */     if (e.getKeyCode() == 50 && this.keyTyped == 2.05D)
/* 70 */       Player.SPEED = 2.0D; 
/* 73 */     if (e.getKeyCode() == 51 && this.keyTyped == 3.05D)
/* 74 */       Player.SPEED = 3.0D; 
/*    */   }
/*    */   
/*    */   public void keyTyped(KeyEvent e) {}
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.3_4.jar!\applecraft\testgame\main\KeyManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */