/*    */ package com.emgartley.launcher;
/*    */ 
/*    */ import java.awt.Component;
/*    */ import java.awt.LayoutManager;
/*    */ import java.awt.Toolkit;
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import javax.swing.JButton;
/*    */ import javax.swing.JFrame;
/*    */ 
/*    */ public class Confirm extends JFrame implements ActionListener {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public Confirm() {
/* 13 */     getContentPane().setLayout((LayoutManager)null);
/* 14 */     JButton yes = new JButton("Yes");
/* 15 */     JButton no = new JButton("No");
/* 16 */     yes.setActionCommand("yes:(");
/* 17 */     no.setActionCommand("ofCourseNot!");
/* 18 */     yes.setBounds(39, 44, 128, 32);
/* 19 */     no.setBounds(183, 44, 128, 32);
/* 20 */     yes.setFocusable(false);
/* 21 */     no.setFocusable(false);
/* 23 */     yes.addActionListener(this);
/* 24 */     no.addActionListener(this);
/* 26 */     add(yes);
/* 27 */     add(no);
/*    */   }
/*    */   
/*    */   public void createWindow() {
/* 31 */     JFrame frame = new Confirm();
/* 32 */     frame.setTitle("Are you sure?");
/* 33 */     frame.setSize(350, 150);
/* 34 */     frame.setResizable(false);
/* 35 */     frame.setLocationRelativeTo((Component)null);
/* 36 */     frame.setDefaultCloseOperation(2);
/* 37 */     frame.setVisible(true);
/* 38 */     frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
/* 39 */           JFrame.class.getResource("/icon32.png")));
/* 40 */     Main.st.setSystemLookAndFeel(frame);
/*    */   }
/*    */   
/*    */   public void actionPerformed(ActionEvent ae) {
/* 44 */     String ac = ae.getActionCommand();
/* 45 */     if (ac.equals("yes:(")) {
/* 46 */       More.uninstallGame(true);
/* 47 */       dispose();
/* 48 */     } else if (ac.equals("ofCourseNot!")) {
/* 49 */       More.uninstallGame(false);
/* 50 */       dispose();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\egart\Documents\GitHub\archive\Java\Beyond Origins Launcher\Builds\Launcher_v1.1.jar!\com\emgartley\launcher\Confirm.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */