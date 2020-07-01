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
/*    */ public class About extends JFrame implements ActionListener {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public About() {
/* 16 */     getContentPane().setLayout((LayoutManager)null);
/* 19 */     addText(208, 240, 100, 15, "Coming Soon!");
/*    */   }
/*    */   
/*    */   public void actionPerformed(ActionEvent ae) {
/* 24 */     String a = ae.getActionCommand();
/* 25 */     a.equals("tefdsfsdfsf");
/*    */   }
/*    */   
/*    */   private void addButton(int x, int y, int w, int h, String text) {
/* 31 */     JButton b = new JButton(text);
/* 32 */     b.setBounds(x, y, w, h);
/* 33 */     b.addActionListener(this);
/* 34 */     add(b);
/*    */   }
/*    */   
/*    */   private void addText(int x, int y, int w, int h, String text) {
/* 38 */     JLabel l = new JLabel(text);
/* 39 */     l.setBounds(x, y, w, h);
/* 40 */     l.setOpaque(true);
/* 41 */     add(l);
/*    */   }
/*    */   
/*    */   public void createWindow() {
/* 46 */     JFrame frame = new AddOns();
/* 47 */     frame.setTitle("About");
/* 48 */     frame.setSize(500, 500);
/* 49 */     frame.setResizable(false);
/* 50 */     frame.setLocationRelativeTo((Component)null);
/* 51 */     frame.setDefaultCloseOperation(2);
/* 52 */     frame.setVisible(true);
/* 53 */     frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
/* 54 */           JFrame.class.getResource("/icon32About.png")));
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_5.jar!\beyondOrigins\main\windows\About.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */