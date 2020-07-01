/*    */ package com.emgartley.launcher;
/*    */ 
/*    */ import java.awt.Component;
/*    */ import java.awt.LayoutManager;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.JTextArea;
/*    */ 
/*    */ public class ConsoleDisplay extends JFrame {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   private static JTextArea txt;
/*    */   
/*    */   public static JFrame jf;
/*    */   
/*    */   public ConsoleDisplay() {
/* 13 */     getContentPane().setLayout((LayoutManager)null);
/* 14 */     txt = new JTextArea();
/* 15 */     txt.setBounds(5, 5, 295, 295);
/* 16 */     txt.setLineWrap(true);
/* 17 */     txt.setEditable(false);
/* 18 */     txt.setVisible(true);
/* 19 */     add(txt);
/*    */   }
/*    */   
/*    */   public void output(String text) {
/* 23 */     txt.append(text);
/*    */   }
/*    */   
/*    */   public void createWindow() {
/* 27 */     jf = new ConsoleDisplay();
/* 28 */     jf.setTitle("Are you sure?");
/* 29 */     jf.setSize(300, 300);
/* 30 */     jf.setResizable(false);
/* 31 */     jf.setLocationRelativeTo((Component)null);
/* 32 */     jf.setDefaultCloseOperation(2);
/* 33 */     jf.setVisible(true);
/* 34 */     Main.st.setFrameIcon(jf, "/icon32.png");
/* 35 */     Main.st.setSystemLookAndFeel(jf);
/*    */   }
/*    */ }


/* Location:              C:\Users\egart\Documents\GitHub\archive\Java\Beyond Origins Launcher\Builds\Launcher_v1.2.jar!\com\emgartley\launcher\ConsoleDisplay.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */