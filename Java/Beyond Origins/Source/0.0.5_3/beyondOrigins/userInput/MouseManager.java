/*    */ package beyondOrigins.userInput;
/*    */ 
/*    */ import java.awt.event.MouseEvent;
/*    */ import java.awt.event.MouseListener;
/*    */ 
/*    */ public class MouseManager implements MouseListener {
/*  8 */   public static int mouseFullClick = 0;
/*    */   
/*    */   public static boolean mouseClickRequested;
/*    */   
/*    */   public void mousePressed(MouseEvent e) {
/* 12 */     if (e.getButton() == 1)
/* 13 */       mouseFullClick = 1; 
/*    */   }
/*    */   
/*    */   public void mouseReleased(MouseEvent e) {
/* 18 */     if (e.getButton() == 1)
/* 19 */       mouseFullClick = 0; 
/*    */   }
/*    */   
/*    */   public void mouseEntered(MouseEvent e) {}
/*    */   
/*    */   public void mouseExited(MouseEvent e) {}
/*    */   
/*    */   public void mouseClicked(MouseEvent e) {}
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_3.jar!\beyondOrigin\\userInput\MouseManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */