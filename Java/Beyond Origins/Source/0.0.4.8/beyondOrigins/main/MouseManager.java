/*    */ package beyondOrigins.main;
/*    */ 
/*    */ import java.awt.event.MouseEvent;
/*    */ import java.awt.event.MouseListener;
/*    */ 
/*    */ public class MouseManager implements MouseListener {
/*  8 */   public static int mouseFullClick = 0;
/*    */   
/*    */   public static boolean canClick = true;
/*    */   
/*    */   public void mousePressed(MouseEvent e) {
/* 13 */     if (e.getButton() == 1 && canClick)
/* 14 */       mouseFullClick = 1; 
/*    */   }
/*    */   
/*    */   public void mouseReleased(MouseEvent e) {
/* 19 */     if (e.getButton() == 1)
/* 20 */       mouseFullClick = 0; 
/*    */   }
/*    */   
/*    */   public void mouseEntered(MouseEvent e) {}
/*    */   
/*    */   public void mouseExited(MouseEvent e) {}
/*    */   
/*    */   public void mouseClicked(MouseEvent e) {}
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4.8.jar!\beyondOrigins\main\MouseManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */