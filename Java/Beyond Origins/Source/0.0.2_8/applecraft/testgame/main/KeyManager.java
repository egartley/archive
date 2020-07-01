/*    */ package applecraft.testgame.main;
/*    */ 
/*    */ import applecraft.testgame.main.entities.Player;
/*    */ import applecraft.testgame.main.menus.F3Menu;
/*    */ import java.awt.event.KeyEvent;
/*    */ import java.awt.event.KeyListener;
/*    */ 
/*    */ public class KeyManager implements KeyListener {
/* 11 */   private double keyTyped = 0.0D;
/*    */   
/*    */   public void keyPressed(KeyEvent e) {
/* 15 */     if (e.getKeyCode() == 87) {
/* 16 */       Player.up = true;
/*    */     } else {
/* 18 */       Player.up = false;
/*    */     } 
/* 21 */     if (e.getKeyCode() == 83) {
/* 22 */       Player.down = true;
/*    */     } else {
/* 24 */       Player.down = false;
/*    */     } 
/* 27 */     if (e.getKeyCode() == 65) {
/* 28 */       Player.left = true;
/*    */     } else {
/* 30 */       Player.left = false;
/*    */     } 
/* 33 */     if (e.getKeyCode() == 68) {
/* 34 */       Player.right = true;
/*    */     } else {
/* 36 */       Player.right = false;
/*    */     } 
/* 39 */     if (e.getKeyCode() == 114)
/* 40 */       F3Menu.f3menu = !F3Menu.f3menu; 
/* 43 */     if (e.getKeyCode() == 49)
/* 44 */       this.keyTyped = 1.05D; 
/* 47 */     if (e.getKeyCode() == 50)
/* 48 */       this.keyTyped = 2.05D; 
/* 51 */     if (e.getKeyCode() == 51)
/* 52 */       this.keyTyped = 3.05D; 
/*    */   }
/*    */   
/*    */   public void keyReleased(KeyEvent e) {
/* 59 */     if (e.getKeyCode() == 87)
/* 60 */       Player.up = false; 
/* 62 */     if (e.getKeyCode() == 83)
/* 63 */       Player.down = false; 
/* 65 */     if (e.getKeyCode() == 65)
/* 66 */       Player.left = false; 
/* 68 */     if (e.getKeyCode() == 68)
/* 69 */       Player.right = false; 
/* 72 */     if (e.getKeyCode() == 49 && this.keyTyped == 1.05D)
/* 73 */       Player.SPEED = 1.0D; 
/* 76 */     if (e.getKeyCode() == 50 && this.keyTyped == 2.05D)
/* 77 */       Player.SPEED = 2.0D; 
/* 80 */     if (e.getKeyCode() == 51 && this.keyTyped == 3.05D)
/* 81 */       Player.SPEED = 3.0D; 
/*    */   }
/*    */   
/*    */   public void keyTyped(KeyEvent e) {}
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.2_8.jar!\applecraft\testgame\main\KeyManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */