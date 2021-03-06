/*    */ package com.emgartley.launcher;
/*    */ 
/*    */ import java.awt.Component;
/*    */ import java.awt.LayoutManager;
/*    */ import java.awt.Toolkit;
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import javax.swing.JButton;
/*    */ import javax.swing.JFrame;
/*    */ 
/*    */ public class More extends JFrame implements ActionListener {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public static JFrame frame;
/*    */   
/*    */   public More() {
/* 15 */     getContentPane().setLayout((LayoutManager)null);
/* 16 */     JButton uninstall = new JButton("Uninstall Game");
/* 17 */     uninstall.setActionCommand("uninstall");
/* 18 */     uninstall.setBounds(161, 50, 178, 32);
/* 19 */     uninstall.setFocusable(false);
/* 21 */     uninstall.addActionListener(this);
/* 23 */     add(uninstall);
/*    */   }
/*    */   
/*    */   public static void uninstallGame(boolean t) {
/* 27 */     if (t) {
/* 28 */       File directory = new File(Main.directory);
/* 29 */       if (!directory.exists())
/*    */         return; 
/*    */       try {
/* 33 */         deleteF(directory);
/* 34 */       } catch (IOException e) {
/* 35 */         e.printStackTrace();
/*    */       } 
/* 38 */       frame.dispose();
/* 39 */       Main.setStatus("Uninstalled the game! :(");
/* 40 */       Main.button_launch.setEnabled(false);
/* 41 */       Main.button_install.setEnabled(false);
/*    */     } else {
/*    */       return;
/*    */     } 
/*    */   }
/*    */   
/*    */   private static void deleteF(File file) throws IOException {
/* 47 */     if (file.isDirectory()) {
/* 48 */       if ((file.list()).length == 0) {
/* 49 */         file.delete();
/*    */       } else {
/* 51 */         String[] files = file.list();
/*    */         byte b;
/*    */         int i;
/*    */         String[] arrayOfString1;
/* 52 */         for (i = (arrayOfString1 = files).length, b = 0; b < i; ) {
/* 52 */           String temp = arrayOfString1[b];
/* 53 */           File fileDelete = new File(file, temp);
/* 54 */           deleteF(fileDelete);
/*    */           b++;
/*    */         } 
/* 56 */         if ((file.list()).length == 0)
/* 57 */           file.delete(); 
/*    */       } 
/*    */     } else {
/* 61 */       file.delete();
/*    */     } 
/*    */   }
/*    */   
/*    */   public void createWindow() {
/* 66 */     frame = new More();
/* 67 */     frame.setTitle("More");
/* 68 */     frame.setSize(500, 500);
/* 69 */     frame.setResizable(false);
/* 70 */     frame.setLocationRelativeTo((Component)null);
/* 71 */     frame.setDefaultCloseOperation(2);
/* 72 */     frame.setVisible(true);
/* 73 */     frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
/* 74 */           JFrame.class.getResource("/icon32.png")));
/* 75 */     Main.st.setSystemLookAndFeel(frame);
/*    */   }
/*    */   
/*    */   public void actionPerformed(ActionEvent e) {
/* 79 */     String ac = e.getActionCommand();
/* 80 */     if (ac.equals("uninstall")) {
/* 81 */       Confirm c = new Confirm();
/* 82 */       c.createWindow();
/*    */     } else {
/* 83 */       ac.equals("console");
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\egart\Documents\GitHub\archive\Java\Beyond Origins Launcher\Builds\Launcher_v1.1.jar!\com\emgartley\launcher\More.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */