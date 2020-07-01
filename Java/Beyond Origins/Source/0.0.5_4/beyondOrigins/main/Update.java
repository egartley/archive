/*    */ package beyondOrigins.main;
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
/*    */ public class Update extends JFrame implements ActionListener {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/* 15 */   private String b1Text = "Check For Updates";
/*    */   
/* 15 */   private String b2Text = "Install Update";
/*    */   
/*    */   private JLabel infoText1;
/*    */   
/*    */   public Update() {
/* 20 */     getContentPane().setLayout((LayoutManager)null);
/* 23 */     JButton button1 = new JButton(this.b1Text);
/* 24 */     JButton button2 = new JButton(this.b2Text);
/* 26 */     this.infoText1 = new JLabel("Current version: " + Game.version, 0);
/* 29 */     button1.setBounds(100, 432, 146, 32);
/* 30 */     button2.setBounds(254, 432, 146, 32);
/* 32 */     button1.addActionListener(this);
/* 33 */     button2.addActionListener(this);
/* 37 */     this.infoText1.setBounds(150, 400, 200, 32);
/* 38 */     this.infoText1.setOpaque(true);
/* 41 */     add(button1);
/* 42 */     add(button2);
/* 43 */     add(this.infoText1);
/*    */   }
/*    */   
/*    */   public void createWindow() {
/* 48 */     JFrame frame = new Update();
/* 49 */     frame.setTitle("Update Game");
/* 50 */     frame.setSize(500, 500);
/* 51 */     frame.setResizable(false);
/* 52 */     frame.setLocationRelativeTo((Component)null);
/* 53 */     frame.setDefaultCloseOperation(2);
/* 54 */     frame.setVisible(true);
/* 55 */     frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
/* 56 */           JFrame.class.getResource("/icon32Update.png")));
/*    */   }
/*    */   
/*    */   public void actionPerformed(ActionEvent ae) {
/* 61 */     String a = ae.getActionCommand();
/* 62 */     if (a.equals(this.b1Text)) {
/* 63 */       checkUpdates();
/* 64 */     } else if (a.equals(this.b2Text)) {
/* 65 */       installUpdates();
/*    */     } 
/*    */   }
/*    */   
/*    */   private void checkUpdates() {}
/*    */   
/*    */   private void installUpdates() {}
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_4.jar!\beyondOrigins\main\Update.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */