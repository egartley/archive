/*    */ package beyondOrigins.main;
/*    */ 
/*    */ import java.awt.event.MouseEvent;
/*    */ import java.awt.event.MouseListener;
/*    */ 
/*    */ public class MouseManager implements MouseListener {
/*  7 */   public static int mouseFullClick = 0;
/*    */   
/*    */   public void mousePressed(MouseEvent e) {
/* 10 */     if (e.getButton() == 1)
/* 11 */       mouseFullClick = 1; 
/*    */   }
/*    */   
/*    */   public void mouseReleased(MouseEvent e) {
/* 16 */     if (e.getButton() == 1)
/* 17 */       mouseFullClick = 0; 
/*    */   }
/*    */   
/*    */   public void mouseEntered(MouseEvent e) {}
/*    */   
/*    */   public void mouseExited(MouseEvent e) {}
/*    */   
/*    */   public void mouseClicked(MouseEvent e) {}
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4.6_2.jar!\beyondOrigins\main\MouseManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */