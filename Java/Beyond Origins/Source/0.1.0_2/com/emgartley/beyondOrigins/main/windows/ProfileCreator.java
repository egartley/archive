/*     */ package com.emgartley.beyondOrigins.main.windows;
/*     */ 
/*     */ import com.emgartley.beyondOrigins.files.Load;
/*     */ import com.emgartley.beyondOrigins.files.Save;
/*     */ import com.emgartley.beyondOrigins.main.Game;
/*     */ import com.emgartley.beyondOrigins.main.Profile1;
/*     */ import com.emgartley.beyondOrigins.main.Profile2;
/*     */ import com.emgartley.beyondOrigins.main.Profile3;
/*     */ import java.awt.Component;
/*     */ import java.awt.FontMetrics;
/*     */ import java.awt.LayoutManager;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.io.IOException;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JTextField;
/*     */ 
/*     */ public class ProfileCreator extends JFrame implements ActionListener {
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   FontMetrics fm;
/*     */   
/*     */   int cur;
/*     */   
/*     */   JTextField proName;
/*     */   
/*     */   JTextField plrName;
/*     */   
/*     */   public ProfileCreator() {
/*  21 */     getContentPane().setLayout((LayoutManager)null);
/*  23 */     addText(168, 71, 100, 22, "Profile Name:");
/*  24 */     this.proName = new JTextField();
/*  25 */     this.proName.setBounds(168, 96, 164, 22);
/*  26 */     add(this.proName);
/*  28 */     addText(168, 224, 200, 22, 
/*  29 */         "Player Name (Male, can't change):");
/*  30 */     this.plrName = new JTextField();
/*  31 */     this.plrName.setBounds(168, 252, 164, 22);
/*  32 */     add(this.plrName);
/*  34 */     addButton(186, 375, "Create");
/*     */   }
/*     */   
/*     */   private void addText(int x, int y, int w, int h, String text) {
/*  44 */     JLabel l = new JLabel(text);
/*  45 */     l.setBounds(x, y, w, h);
/*  46 */     l.setOpaque(true);
/*  47 */     add(l);
/*     */   }
/*     */   
/*     */   private void addButton(int x, int y, String t) {
/*  51 */     JButton b = new JButton(t);
/*  52 */     b.setBounds(x, y, 128, 32);
/*  53 */     b.setFocusable(false);
/*  54 */     b.addActionListener(this);
/*  55 */     add(b);
/*     */   }
/*     */   
/*     */   public void createWindow(int cp) {
/*  59 */     JFrame frame = new ProfileCreator();
/*  60 */     this.cur = cp;
/*  61 */     frame.setTitle("Profile Creator");
/*  62 */     frame.setSize(500, 500);
/*  63 */     frame.setResizable(false);
/*  64 */     frame.setLocationRelativeTo((Component)null);
/*  65 */     frame.setDefaultCloseOperation(2);
/*  66 */     frame.setVisible(true);
/*  67 */     Game.st.setFrameIconAbsoulute(frame, String.valueOf(Game.mainDir) + "assets\\icon32.png");
/*  68 */     Game.st.setSystemLookAndFeel(frame);
/*     */   }
/*     */   
/*     */   public void actionPerformed(ActionEvent e) {
/*  72 */     String a = e.getActionCommand();
/*  73 */     if (a.equals("Create")) {
/*     */       try {
/*  75 */         Save.profileReset();
/*  76 */         if ((Game.getMainMenu()).currentProfile == 1) {
/*  77 */           if (this.proName.getText().length() == 0 || 
/*  78 */             this.proName.getText().equals("")) {
/*  79 */             Profile1.name = "Profile 1";
/*     */           } else {
/*  81 */             Profile1.name = this.proName.getText();
/*     */           } 
/*  83 */           Profile1.backup_name = Profile1.name;
/*  84 */         } else if ((Game.getMainMenu()).currentProfile == 2) {
/*  85 */           if (this.proName.getText().length() == 0 || 
/*  86 */             this.proName.getText().equals("")) {
/*  87 */             Profile2.name = "Profile 2";
/*     */           } else {
/*  89 */             Profile2.name = this.proName.getText();
/*     */           } 
/*  91 */           Profile2.backup_name = Profile2.name;
/*  92 */         } else if ((Game.getMainMenu()).currentProfile == 3) {
/*  93 */           if (this.proName.getText().length() == 0 || 
/*  94 */             this.proName.getText().equals("")) {
/*  95 */             Profile3.name = "Profile 3";
/*     */           } else {
/*  97 */             Profile3.name = this.proName.getText();
/*     */           } 
/*  99 */           Profile3.backup_name = Profile3.name;
/*     */         } 
/* 101 */         if (this.plrName.getText().length() == 0) {
/* 102 */           (Game.getPlayer()).name = (Game.getPlayer()).defaultName;
/*     */         } else {
/* 104 */           (Game.getPlayer()).name = this.plrName.getText();
/*     */         } 
/* 106 */         if ((Game.getMainMenu()).currentProfile == 1) {
/* 107 */           Profile1.save();
/* 108 */           Load.loadProfile(Game.save1Path, 1);
/* 109 */         } else if ((Game.getMainMenu()).currentProfile == 2) {
/* 110 */           Profile2.save();
/* 111 */           Load.loadProfile(Game.save2Path, 2);
/* 112 */         } else if ((Game.getMainMenu()).currentProfile == 3) {
/* 113 */           Profile3.save();
/* 114 */           Load.loadProfile(Game.save3Path, 3);
/*     */         } 
/* 116 */         Game.getMainMenu().enterGame(true);
/* 117 */       } catch (IOException ea) {
/* 118 */         ea.printStackTrace();
/*     */       } 
/* 120 */       dispose();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.1.0_2.jar!\com\emgartley\beyondOrigins\main\windows\ProfileCreator.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */