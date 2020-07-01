/*     */ package beyondOrigins.main.windows;
/*     */ 
/*     */ import beyondOrigins.files.Load;
/*     */ import beyondOrigins.files.Save;
/*     */ import beyondOrigins.main.Game;
/*     */ import beyondOrigins.main.Profile1;
/*     */ import beyondOrigins.main.Profile2;
/*     */ import beyondOrigins.main.Profile3;
/*     */ import java.awt.Component;
/*     */ import java.awt.FontMetrics;
/*     */ import java.awt.LayoutManager;
/*     */ import java.awt.Toolkit;
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
/*  29 */     getContentPane().setLayout((LayoutManager)null);
/*  31 */     addText(168, 71, 100, 22, "Profile Name:");
/*  32 */     this.proName = new JTextField();
/*  33 */     this.proName.setBounds(168, 96, 164, 22);
/*  34 */     add(this.proName);
/*  36 */     addText(168, 224, 200, 22, 
/*  37 */         "Player Name (Male, can't change):");
/*  38 */     this.plrName = new JTextField();
/*  39 */     this.plrName.setBounds(168, 252, 164, 22);
/*  40 */     add(this.plrName);
/*  42 */     addButton(186, 375, "Create");
/*     */   }
/*     */   
/*     */   private void addText(int x, int y, int w, int h, String text) {
/*  52 */     JLabel l = new JLabel(text);
/*  53 */     l.setBounds(x, y, w, h);
/*  54 */     l.setOpaque(true);
/*  55 */     add(l);
/*     */   }
/*     */   
/*     */   private void addButton(int x, int y, String t) {
/*  59 */     JButton b = new JButton(t);
/*  60 */     b.setBounds(x, y, 128, 32);
/*  61 */     b.setFocusable(false);
/*  62 */     b.addActionListener(this);
/*  63 */     add(b);
/*     */   }
/*     */   
/*     */   public void createWindow(int cp) {
/*  67 */     JFrame frame = new ProfileCreator();
/*  68 */     this.cur = cp;
/*  69 */     frame.setTitle("Profile Creator");
/*  70 */     frame.setSize(500, 500);
/*  71 */     frame.setResizable(false);
/*  72 */     frame.setLocationRelativeTo((Component)null);
/*  73 */     frame.setDefaultCloseOperation(2);
/*  74 */     frame.setVisible(true);
/*  75 */     frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
/*  76 */           JFrame.class.getResource("/icon32.png")));
/*  78 */     Game.st.setSystemLookAndFeel(frame);
/*     */   }
/*     */   
/*     */   public void actionPerformed(ActionEvent e) {
/*  82 */     String a = e.getActionCommand();
/*  83 */     if (a.equals("Create")) {
/*     */       try {
/*  85 */         Save.profileReset();
/*  86 */         if ((Game.getMainMenu()).currentProfile == 1) {
/*  87 */           if (this.proName.getText().length() == 0 || this.proName.getText().equals("")) {
/*  88 */             Profile1.name = "Profile 1";
/*     */           } else {
/*  90 */             Profile1.name = this.proName.getText();
/*     */           } 
/*  92 */           Profile1.backup_name = Profile1.name;
/*  93 */         } else if ((Game.getMainMenu()).currentProfile == 2) {
/*  94 */           if (this.proName.getText().length() == 0 || this.proName.getText().equals("")) {
/*  95 */             Profile2.name = "Profile 2";
/*     */           } else {
/*  97 */             Profile2.name = this.proName.getText();
/*     */           } 
/*  99 */           Profile2.backup_name = Profile2.name;
/* 100 */         } else if ((Game.getMainMenu()).currentProfile == 3) {
/* 101 */           if (this.proName.getText().length() == 0 || this.proName.getText().equals("")) {
/* 102 */             Profile3.name = "Profile 3";
/*     */           } else {
/* 104 */             Profile3.name = this.proName.getText();
/*     */           } 
/* 106 */           Profile3.backup_name = Profile3.name;
/*     */         } 
/* 108 */         if (this.plrName.getText().length() == 0) {
/* 109 */           (Game.getPlayer()).name = (Game.getPlayer()).defaultName;
/*     */         } else {
/* 111 */           (Game.getPlayer()).name = this.plrName.getText();
/*     */         } 
/* 113 */         if ((Game.getMainMenu()).currentProfile == 1) {
/* 114 */           Profile1.save();
/* 115 */           Load.loadProfile(Game.save1Path, 1);
/* 116 */         } else if ((Game.getMainMenu()).currentProfile == 2) {
/* 117 */           Profile2.save();
/* 118 */           Load.loadProfile(Game.save2Path, 2);
/* 119 */         } else if ((Game.getMainMenu()).currentProfile == 3) {
/* 120 */           Profile3.save();
/* 121 */           Load.loadProfile(Game.save3Path, 3);
/*     */         } 
/* 123 */         Game.getMainMenu().enterGame();
/* 124 */         Game.getStoryText().request(
/* 125 */             "Out story begins within a small village called", 
/* 126 */             String.valueOf(Game.townName) + ". Today, " + (Game.getPlayer()).name + 
/* 127 */             " is waking up from", 
/* 128 */             "an afternoon nap. " + (Game.getPlayer()).name + 
/* 129 */             " hears his mother's voice,", 
/* 130 */             "'Time for dinner honey!'", 
/* 131 */             "You best be off going downstairs now.", "", "- ???");
/* 132 */       } catch (IOException ea) {
/* 133 */         ea.printStackTrace();
/*     */       } 
/* 135 */       dispose();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.9_3.jar!\beyondOrigins\main\windows\ProfileCreator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */