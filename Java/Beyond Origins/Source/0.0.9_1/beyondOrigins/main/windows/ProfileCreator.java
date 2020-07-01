/*     */ package beyondOrigins.main.windows;
/*     */ 
/*     */ import beyondOrigins.files.Load;
/*     */ import beyondOrigins.files.Save;
/*     */ import beyondOrigins.main.Game;
/*     */ import java.awt.Component;
/*     */ import java.awt.FontMetrics;
/*     */ import java.awt.LayoutManager;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.io.File;
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
/*  27 */     getContentPane().setLayout((LayoutManager)null);
/*  29 */     addText(168, 71, 100, 22, "Profile Name:");
/*  30 */     this.proName = new JTextField();
/*  31 */     this.proName.setBounds(168, 96, 164, 22);
/*  32 */     add(this.proName);
/*  34 */     addText(168, 224, 200, 22, "Player Name (Male, can't change):");
/*  35 */     this.plrName = new JTextField();
/*  36 */     this.plrName.setBounds(168, 252, 164, 22);
/*  37 */     add(this.plrName);
/*  39 */     addButton(186, 375, "Create");
/*     */   }
/*     */   
/*     */   private void addText(int x, int y, int w, int h, String text) {
/*  50 */     JLabel l = new JLabel(text);
/*  51 */     l.setBounds(x, y, w, h);
/*  52 */     l.setOpaque(true);
/*  53 */     add(l);
/*     */   }
/*     */   
/*     */   private void addButton(int x, int y, String t) {
/*  57 */     JButton b = new JButton(t);
/*  58 */     b.setBounds(x, y, 128, 32);
/*  59 */     b.setFocusable(false);
/*  60 */     b.addActionListener(this);
/*  61 */     add(b);
/*     */   }
/*     */   
/*     */   public void createWindow(int cp) {
/*  65 */     JFrame frame = new ProfileCreator();
/*  66 */     this.cur = cp;
/*  67 */     frame.setTitle("Profile Creator");
/*  68 */     frame.setSize(500, 500);
/*  69 */     frame.setResizable(false);
/*  70 */     frame.setLocationRelativeTo((Component)null);
/*  71 */     frame.setDefaultCloseOperation(2);
/*  72 */     frame.setVisible(true);
/*  73 */     frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
/*  74 */           JFrame.class.getResource("/icon32.png")));
/*  76 */     Game.st.setSystemLookAndFeel(frame);
/*     */   }
/*     */   
/*     */   public void actionPerformed(ActionEvent e) {
/*  80 */     String a = e.getActionCommand();
/*  81 */     if (a.equals("Create")) {
/*     */       try {
/*  83 */         Save.profileReset();
/*  84 */         if ((Game.getMainMenu()).currentProfile == 1) {
/*  85 */           if (this.proName.getText().length() == 0) {
/*  86 */             (Game.getMainMenu()).save1Name = "Profile 1";
/*  87 */             (Game.getMainMenu()).save1Name_backup = 
/*  88 */               (Game.getMainMenu()).save1Name;
/*     */           } else {
/*  90 */             (Game.getMainMenu()).save1Name = this.proName.getText();
/*  91 */             (Game.getMainMenu()).save1Name_backup = 
/*  92 */               (Game.getMainMenu()).save1Name;
/*     */           } 
/*  94 */         } else if ((Game.getMainMenu()).currentProfile == 2) {
/*  95 */           if (this.proName.getText().length() == 0) {
/*  96 */             (Game.getMainMenu()).save2Name = "Profile 2";
/*  97 */             (Game.getMainMenu()).save2Name_backup = 
/*  98 */               (Game.getMainMenu()).save2Name;
/*     */           } else {
/* 100 */             (Game.getMainMenu()).save2Name = this.proName.getText();
/* 101 */             (Game.getMainMenu()).save2Name_backup = 
/* 102 */               (Game.getMainMenu()).save2Name;
/*     */           } 
/* 104 */         } else if ((Game.getMainMenu()).currentProfile == 3) {
/* 105 */           if (this.proName.getText().length() == 0) {
/* 106 */             (Game.getMainMenu()).save3Name = "Profile 3";
/* 107 */             (Game.getMainMenu()).save3Name_backup = 
/* 108 */               (Game.getMainMenu()).save3Name;
/*     */           } else {
/* 110 */             (Game.getMainMenu()).save3Name = this.proName.getText();
/* 111 */             (Game.getMainMenu()).save3Name_backup = 
/* 112 */               (Game.getMainMenu()).save3Name;
/*     */           } 
/*     */         } 
/* 115 */         if (this.plrName.getText().length() == 0) {
/* 116 */           (Game.getPlayer()).name = (Game.getPlayer()).defaultName;
/*     */         } else {
/* 118 */           (Game.getPlayer()).name = this.plrName.getText();
/*     */         } 
/* 120 */         if ((Game.getMainMenu()).currentProfile == 1) {
/* 121 */           Save.profileSave(new File(Game.save1Path), Game.save1Path, 
/* 122 */               (Game.getMainMenu()).currentProfile);
/* 123 */           Load.loadProfile(Game.save1Path, 1);
/* 124 */         } else if ((Game.getMainMenu()).currentProfile == 2) {
/* 125 */           Save.profileSave(new File(Game.save2Path), Game.save2Path, 
/* 126 */               (Game.getMainMenu()).currentProfile);
/* 127 */           Load.loadProfile(Game.save2Path, 2);
/* 128 */         } else if ((Game.getMainMenu()).currentProfile == 3) {
/* 129 */           Save.profileSave(new File(Game.save3Path), Game.save3Path, 
/* 130 */               (Game.getMainMenu()).currentProfile);
/* 131 */           Load.loadProfile(Game.save3Path, 3);
/*     */         } 
/* 133 */         Game.getMainMenu().enterGame();
/* 134 */         Game.getStoryText().request("Out story begins within a small village called", 
/* 135 */             String.valueOf(Game.townName) + ". Today, " + (Game.getPlayer()).name + 
/* 136 */             " is waking up from", 
/* 137 */             "an afternoon nap. " + (Game.getPlayer()).name + 
/* 138 */             " hears his mother's voice,", 
/* 139 */             "'Time for dinner honey!'", 
/* 140 */             "You best be off going downstairs now.", "", "- ???");
/* 141 */       } catch (IOException ea) {
/* 142 */         ea.printStackTrace();
/*     */       } 
/* 144 */       dispose();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.9_1.jar!\beyondOrigins\main\windows\ProfileCreator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */