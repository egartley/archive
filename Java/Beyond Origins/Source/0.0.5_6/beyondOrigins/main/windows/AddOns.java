/*    */ package beyondOrigins.main.windows;
/*    */ 
/*    */ import java.awt.Component;
/*    */ import java.awt.LayoutManager;
/*    */ import java.awt.Toolkit;
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import javax.swing.JButton;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.JLabel;
/*    */ 
/*    */ public class AddOns extends JFrame implements ActionListener {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/* 18 */   private String b1 = "Apply", b2 = "Cancel";
/*    */   
/*    */   public AddOns() {
/* 21 */     getContentPane().setLayout((LayoutManager)null);
/* 24 */     addText(208, 240, 100, 15, "Coming Soon!");
/*    */   }
/*    */   
/*    */   public void actionPerformed(ActionEvent ae) {
/* 29 */     String a = ae.getActionCommand();
/* 30 */     if (!a.equals(this.b1))
/* 32 */       a.equals(this.b2); 
/*    */   }
/*    */   
/*    */   private void addButton(int x, int y, int w, int h, String text) {
/* 38 */     JButton b = new JButton(text);
/* 39 */     b.setBounds(x, y, w, h);
/* 40 */     b.addActionListener(this);
/* 41 */     add(b);
/*    */   }
/*    */   
/*    */   private void addText(int x, int y, int w, int h, String text) {
/* 45 */     JLabel l = new JLabel(text);
/* 46 */     l.setBounds(x, y, w, h);
/* 47 */     l.setOpaque(true);
/* 48 */     add(l);
/*    */   }
/*    */   
/*    */   public void createWindow() {
/* 53 */     JFrame frame = new AddOns();
/* 54 */     frame.setTitle("Add-Ons");
/* 55 */     frame.setSize(500, 500);
/* 56 */     frame.setResizable(false);
/* 57 */     frame.setLocationRelativeTo((Component)null);
/* 58 */     frame.setDefaultCloseOperation(2);
/* 59 */     frame.setVisible(true);
/* 60 */     frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
/* 61 */           JFrame.class.getResource("/icon32AddOns.png")));
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_6.jar!\beyondOrigins\main\windows\AddOns.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */