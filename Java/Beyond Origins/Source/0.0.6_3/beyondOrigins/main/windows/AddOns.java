/*    */ package beyondOrigins.main.windows;
/*    */ 
/*    */ import beyondOrigins.main.Game;
/*    */ import java.awt.Component;
/*    */ import java.awt.LayoutManager;
/*    */ import java.awt.Toolkit;
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.JLabel;
/*    */ 
/*    */ public class AddOns extends JFrame implements ActionListener {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/* 16 */   private String b1 = "Apply", b2 = "Cancel";
/*    */   
/*    */   public AddOns() {
/* 19 */     getContentPane().setLayout((LayoutManager)null);
/* 22 */     addText(208, 240, 100, 15, "Coming Soon!");
/*    */   }
/*    */   
/*    */   public void actionPerformed(ActionEvent ae) {
/* 27 */     String a = ae.getActionCommand();
/* 28 */     if (!a.equals(this.b1))
/* 30 */       a.equals(this.b2); 
/*    */   }
/*    */   
/*    */   private void addText(int x, int y, int w, int h, String text) {
/* 44 */     JLabel l = new JLabel(text);
/* 45 */     l.setBounds(x, y, w, h);
/* 46 */     l.setOpaque(true);
/* 47 */     add(l);
/*    */   }
/*    */   
/*    */   public void createWindow() {
/* 52 */     JFrame frame = new AddOns();
/* 53 */     frame.setTitle("Add-Ons");
/* 54 */     frame.setSize(500, 500);
/* 55 */     frame.setResizable(false);
/* 56 */     frame.setLocationRelativeTo((Component)null);
/* 57 */     frame.setDefaultCloseOperation(2);
/* 58 */     frame.setVisible(true);
/* 59 */     frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
/* 60 */           JFrame.class.getResource("/icon32.png")));
/* 62 */     Game.st.setSystemLookAndFeel(frame);
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.6_3.jar!\beyondOrigins\main\windows\AddOns.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */