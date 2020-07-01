/*    */ package applecraft.testgame.main;
/*    */ 
/*    */ import java.awt.event.MouseEvent;
/*    */ import java.awt.event.MouseListener;
/*    */ 
/*    */ public class MouseManager implements MouseListener {
/* 10 */   public static int mouseFullClick = 0;
/*    */   
/*    */   public void mousePressed(MouseEvent e) {
/* 15 */     if (e.getButton() == 1)
/* 16 */       mouseFullClick = 1; 
/*    */   }
/*    */   
/*    */   public void mouseReleased(MouseEvent e) {
/* 23 */     if (e.getButton() == 1)
/* 24 */       mouseFullClick = 0; 
/*    */   }
/*    */   
/*    */   public void mouseEntered(MouseEvent e) {}
/*    */   
/*    */   public void mouseExited(MouseEvent e) {}
/*    */   
/*    */   public void mouseClicked(MouseEvent e) {}
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.3_1.jar!\applecraft\testgame\main\MouseManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */