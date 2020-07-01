/*    */ package tk.egartley.beyondOriginsLauncher;
/*    */ 
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.JTextArea;
/*    */ 
/*    */ public class ConsoleSIM extends JFrame {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public static JTextArea text;
/*    */   
/*    */   public static void appendText(String newText) {
/* 15 */     text.append(String.valueOf(newText) + "\n");
/*    */   }
/*    */ }


/* Location:              C:\Users\egart\Documents\GitHub\archive\Java\Beyond Origins Launcher\Builds\Launcher_v1.6.jar!\tk\egartley\beyondOriginsLauncher\ConsoleSIM.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */