/*     */ package com.emgartley.beyondOriginsLauncher;
/*     */ 
/*     */ import java.awt.Component;
/*     */ import java.awt.LayoutManager;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTextArea;
/*     */ 
/*     */ public class More extends JFrame implements ActionListener {
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   public static JFrame frame;
/*     */   
/*     */   public static JTextArea license;
/*     */   
/*     */   public More() {
/*  20 */     getContentPane().setLayout((LayoutManager)null);
/*  21 */     JButton uninstall = new JButton("Uninstall Game");
/*  22 */     uninstall.setActionCommand("uninstall");
/*  23 */     uninstall.setBounds(61, 50, 178, 32);
/*  24 */     uninstall.setFocusable(false);
/*  25 */     JButton changes = new JButton("Show Change Log");
/*  26 */     changes.setActionCommand("changeLog");
/*  27 */     changes.setBounds(61, 98, 178, 32);
/*  28 */     changes.setFocusable(false);
/*  29 */     Main.st.addText(this, "By using this SOFTWARE, you agree to: ", 5, 260, 400, 13);
/*  30 */     license = new JTextArea();
/*  31 */     license.setBounds(5, 280, 283, 185);
/*  32 */     license.setFocusable(false);
/*  33 */     license.setText(Main.getCurrentLicense());
/*  34 */     JScrollPane sp = new JScrollPane(license);
/*  35 */     sp.setBounds(5, 280, 283, 185);
/*  37 */     uninstall.addActionListener(this);
/*  38 */     changes.addActionListener(this);
/*  40 */     add(uninstall);
/*  41 */     add(changes);
/*  42 */     add(sp);
/*     */   }
/*     */   
/*     */   public static void uninstallGame(boolean t) {
/*  46 */     if (t) {
/*  47 */       File directory = new File(Main.directory);
/*  48 */       if (!directory.exists())
/*     */         return; 
/*     */       try {
/*  52 */         deleteF(directory);
/*  53 */       } catch (IOException e) {
/*  54 */         e.printStackTrace();
/*     */       } 
/*  57 */       frame.dispose();
/*  58 */       Main.setStatus("Uninstalled the game! :(");
/*  59 */       Main.button_launch.setEnabled(false);
/*  60 */       Main.button_install.setEnabled(false);
/*     */     } else {
/*     */       return;
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void deleteF(File file) throws IOException {
/*  66 */     if (file.isDirectory()) {
/*  67 */       if ((file.list()).length == 0) {
/*  68 */         file.delete();
/*  69 */         Main.st.println("Deleted empty folder at: " + 
/*  70 */             file.getAbsolutePath());
/*     */       } else {
/*  72 */         String[] files = file.list();
/*     */         byte b;
/*     */         int i;
/*     */         String[] arrayOfString1;
/*  73 */         for (i = (arrayOfString1 = files).length, b = 0; b < i; ) {
/*  73 */           String temp = arrayOfString1[b];
/*  74 */           File fileDelete = new File(file, temp);
/*  75 */           deleteF(fileDelete);
/*     */           b++;
/*     */         } 
/*  77 */         if ((file.list()).length == 0)
/*  78 */           file.delete(); 
/*     */       } 
/*     */     } else {
/*  82 */       file.delete();
/*  83 */       Main.st.println("Deleted file at: " + file.getAbsolutePath());
/*     */     } 
/*     */   }
/*     */   
/*     */   public void createWindow() {
/*  88 */     frame = new More();
/*  89 */     frame.setTitle("More");
/*  90 */     frame.setSize(300, 500);
/*  91 */     frame.setResizable(false);
/*  92 */     frame.setLocationRelativeTo((Component)null);
/*  93 */     frame.setDefaultCloseOperation(2);
/*  94 */     frame.setVisible(true);
/*  95 */     frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
/*  96 */           JFrame.class.getResource("/icon32.png")));
/*  97 */     Main.st.setSystemLookAndFeel(frame);
/*     */   }
/*     */   
/*     */   public void actionPerformed(ActionEvent e) {
/* 101 */     String ac = e.getActionCommand();
/* 102 */     if (ac.equals("uninstall")) {
/* 103 */       Confirm c = new Confirm();
/* 104 */       c.createWindow();
/* 105 */     } else if (ac.equals("changeLog")) {
/* 106 */       ChangeLog cl = new ChangeLog();
/* 107 */       cl.createWindow();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\egart\Documents\GitHub\archive\Java\Beyond Origins Launcher\Builds\Launcher_v1.3.jar!\com\emgartley\beyondOriginsLauncher\More.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */