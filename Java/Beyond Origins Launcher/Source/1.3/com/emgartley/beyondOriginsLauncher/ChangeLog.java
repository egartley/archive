/*    */ package com.emgartley.beyondOriginsLauncher;
/*    */ 
/*    */ import java.awt.Component;
/*    */ import java.awt.LayoutManager;
/*    */ import java.awt.Toolkit;
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import javax.swing.JButton;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.JTextArea;
/*    */ 
/*    */ public class ChangeLog extends JFrame implements ActionListener {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public ChangeLog() {
/* 17 */     getContentPane().setLayout((LayoutManager)null);
/* 18 */     JTextArea clp = new JTextArea();
/* 19 */     clp.setBounds(5, 5, 284, 411);
/* 20 */     clp.setEditable(false);
/* 21 */     clp.setText(Main.getCurrentChangeLog());
/* 22 */     clp.setLineWrap(true);
/* 23 */     JButton button_ok = new JButton("Okay");
/* 24 */     button_ok.setBounds(74, 427, 152, 32);
/* 25 */     button_ok.setFocusable(false);
/* 26 */     button_ok.addActionListener(this);
/* 27 */     button_ok.setActionCommand("ok");
/* 28 */     add(clp);
/* 29 */     add(button_ok);
/*    */   }
/*    */   
/*    */   public void createWindow() {
/* 33 */     JFrame frame = new ChangeLog();
/* 34 */     frame.setTitle("Change Log");
/* 35 */     frame.setSize(300, 500);
/* 36 */     frame.setResizable(false);
/* 37 */     frame.setLocationRelativeTo((Component)null);
/* 38 */     frame.setDefaultCloseOperation(2);
/* 39 */     frame.setVisible(true);
/* 40 */     frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
/* 41 */           JFrame.class.getResource("/icon32.png")));
/* 42 */     Main.st.setSystemLookAndFeel(frame);
/*    */   }
/*    */   
/*    */   public void actionPerformed(ActionEvent e) {
/* 46 */     String ac = e.getActionCommand();
/* 47 */     if (ac.equals("ok"))
/* 48 */       dispose(); 
/*    */   }
/*    */ }


/* Location:              C:\Users\egart\Documents\GitHub\archive\Java\Beyond Origins Launcher\Builds\Launcher_v1.3.jar!\com\emgartley\beyondOriginsLauncher\ChangeLog.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */