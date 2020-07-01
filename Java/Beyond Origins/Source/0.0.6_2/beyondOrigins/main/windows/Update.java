/*    */ package beyondOrigins.main.windows;
/*    */ 
/*    */ import java.awt.Component;
/*    */ import java.awt.FontMetrics;
/*    */ import java.awt.LayoutManager;
/*    */ import java.awt.Toolkit;
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import java.io.IOException;
/*    */ import javax.swing.JButton;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.JLabel;
/*    */ 
/*    */ public class Update extends JFrame implements ActionListener {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/* 19 */   private String b1 = "Check For Updates";
/*    */   
/* 19 */   private String b2 = "Install Update";
/*    */   
/*    */   private boolean selected = false;
/*    */   
/*    */   private FontMetrics fm;
/*    */   
/*    */   public Update() {
/* 25 */     getContentPane().setLayout((LayoutManager)null);
/* 27 */     addText(208, 240, 100, 15, "Coming Soon!");
/*    */   }
/*    */   
/*    */   private void addButton(int x, int y, int w, int h, String text) {
/* 45 */     JButton b = new JButton(text);
/* 46 */     b.setBounds(x, y, w, h);
/* 47 */     b.addActionListener(this);
/* 48 */     add(b);
/*    */   }
/*    */   
/*    */   private void addText(int x, int y, int w, int h, String text) {
/* 52 */     JLabel l = new JLabel(text);
/* 53 */     l.setBounds(x, y, w, h);
/* 54 */     l.setOpaque(true);
/* 55 */     add(l);
/*    */   }
/*    */   
/*    */   public void createWindow() {
/* 60 */     JFrame frame = new Update();
/* 61 */     frame.setTitle("Update");
/* 62 */     frame.setSize(500, 500);
/* 63 */     frame.setResizable(false);
/* 64 */     frame.setLocationRelativeTo((Component)null);
/* 65 */     frame.setDefaultCloseOperation(2);
/* 66 */     frame.setVisible(true);
/* 67 */     frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
/* 68 */           JFrame.class.getResource("/icon32Update.png")));
/*    */   }
/*    */   
/*    */   public void actionPerformed(ActionEvent ae) {
/* 73 */     String a = ae.getActionCommand();
/* 74 */     if (a.equals(this.b1)) {
/* 75 */       checkUpdates();
/* 76 */     } else if (a.equals(this.b2)) {
/*    */       try {
/* 78 */         installUpdates();
/* 79 */       } catch (IOException e) {
/* 80 */         e.printStackTrace();
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   private void checkUpdates() {}
/*    */   
/*    */   private void installUpdates() throws IOException {}
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.6_2.jar!\beyondOrigins\main\windows\Update.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */