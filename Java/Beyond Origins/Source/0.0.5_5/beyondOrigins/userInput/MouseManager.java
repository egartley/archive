/*    */ package beyondOrigins.userInput;
/*    */ 
/*    */ import java.awt.event.MouseEvent;
/*    */ import java.awt.event.MouseListener;
/*    */ 
/*    */ public class MouseManager implements MouseListener {
/*    */   public static boolean mousePressed = false;
/*    */   
/*    */   public void mousePressed(MouseEvent e) {
/* 11 */     if (e.getButton() == 1)
/* 12 */       mousePressed = true; 
/*    */   }
/*    */   
/*    */   public void mouseReleased(MouseEvent e) {
/* 17 */     if (e.getButton() == 1)
/* 18 */       mousePressed = false; 
/*    */   }
/*    */   
/*    */   public void mouseEntered(MouseEvent e) {}
/*    */   
/*    */   public void mouseExited(MouseEvent e) {}
/*    */   
/*    */   public void mouseClicked(MouseEvent e) {}
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_5.jar!\beyondOrigin\\userInput\MouseManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */