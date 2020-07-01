/*    */ package com.emgartley.beyondOriginsLauncher;
/*    */ 
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import javax.swing.JEditorPane;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.JPanel;
/*    */ 
/*    */ public class EULA extends JPanel implements ActionListener {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public static JFrame frame;
/*    */   
/*    */   public static JEditorPane license;
/*    */   
/*    */   public static void uninstallGame(boolean t) {
/* 23 */     if (t) {
/* 24 */       File directory = new File(Main.directory);
/* 25 */       if (!directory.exists())
/*    */         return; 
/*    */       try {
/* 29 */         deleteF(directory);
/* 30 */       } catch (IOException e) {
/* 31 */         e.printStackTrace();
/*    */       } 
/* 34 */       frame.dispose();
/* 35 */       Main.setStatus("Uninstalled the game! :(");
/* 36 */       Main.button_launch.setEnabled(false);
/* 37 */       Main.button_install.setEnabled(false);
/*    */     } else {
/*    */       return;
/*    */     } 
/*    */   }
/*    */   
/*    */   private static void deleteF(File file) throws IOException {
/* 43 */     if (file.isDirectory()) {
/* 44 */       if ((file.list()).length == 0) {
/* 45 */         file.delete();
/* 46 */         Main.st.println("Deleted empty folder at: " + 
/* 47 */             file.getAbsolutePath());
/*    */       } else {
/* 49 */         String[] files = file.list();
/*    */         byte b;
/*    */         int i;
/*    */         String[] arrayOfString1;
/* 50 */         for (i = (arrayOfString1 = files).length, b = 0; b < i; ) {
/* 50 */           String temp = arrayOfString1[b];
/* 51 */           File fileDelete = new File(file, temp);
/* 52 */           deleteF(fileDelete);
/*    */           b++;
/*    */         } 
/* 54 */         if ((file.list()).length == 0)
/* 55 */           file.delete(); 
/*    */       } 
/*    */     } else {
/* 59 */       file.delete();
/* 60 */       Main.st.println("Deleted file at: " + file.getAbsolutePath());
/* 61 */       ConsoleSIM.text.append("Deleted file at: " + file.getAbsolutePath() + " \n");
/*    */     } 
/*    */   }
/*    */   
/*    */   public void actionPerformed(ActionEvent e) {
/* 66 */     String ac = e.getActionCommand();
/* 67 */     if (ac.equals("uninstall")) {
/* 68 */       Confirm c = new Confirm();
/* 69 */       c.createWindow();
/* 70 */     } else if (ac.equals("changeLog")) {
/* 71 */       ChangeLog cl = new ChangeLog();
/* 72 */       cl.createWindow();
/*    */     } else {
/* 73 */       ac.equals("dispose");
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\egart\Documents\GitHub\archive\Java\Beyond Origins Launcher\Builds\Launcher_v1.4.jar!\com\emgartley\beyondOriginsLauncher\EULA.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */