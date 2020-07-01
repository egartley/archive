/*    */ package applecraft.testgame.main;
/*    */ 
/*    */ import java.awt.event.MouseEvent;
/*    */ import java.awt.event.MouseMotionListener;
/*    */ 
/*    */ public class MouseMotion implements MouseMotionListener {
/*  7 */   public static int mouseX = 0;
/*    */   
/*  8 */   public static int mouseY = 0;
/*    */   
/*    */   public void mouseMoved(MouseEvent e) {
/* 11 */     mouseX = e.getX();
/* 12 */     mouseY = e.getY();
/*    */   }
/*    */   
/*    */   public void mouseEntered(MouseEvent e) {}
/*    */   
/*    */   public void mouseExited(MouseEvent e) {}
/*    */   
/*    */   public void mouseDragged(MouseEvent e) {}
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4.2_6.jar!\applecraft\testgame\main\MouseMotion.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */