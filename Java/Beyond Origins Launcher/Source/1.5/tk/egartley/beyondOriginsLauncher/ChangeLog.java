/*    */ package tk.egartley.beyondOriginsLauncher;
/*    */ 
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import javax.swing.JEditorPane;
/*    */ import javax.swing.JFrame;
/*    */ 
/*    */ public class ChangeLog extends JFrame implements ActionListener {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public static JEditorPane changesPane;
/*    */   
/*    */   public void createWindow() {}
/*    */   
/*    */   public void actionPerformed(ActionEvent e) {
/* 25 */     String ac = e.getActionCommand();
/* 26 */     if (ac.equals("ok"))
/* 27 */       dispose(); 
/*    */   }
/*    */ }


/* Location:              C:\Users\egart\Documents\GitHub\archive\Java\Beyond Origins Launcher\Builds\Launcher_v1.5.jar!\tk\egartley\beyondOriginsLauncher\ChangeLog.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */