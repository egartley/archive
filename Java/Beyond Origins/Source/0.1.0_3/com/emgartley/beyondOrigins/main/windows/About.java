/*    */ package com.emgartley.beyondOrigins.main.windows;
/*    */ 
/*    */ import com.emgartley.beyondOrigins.main.Game;
/*    */ import java.awt.Component;
/*    */ import java.awt.FontMetrics;
/*    */ import java.awt.LayoutManager;
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import java.awt.image.BufferedImage;
/*    */ import java.io.IOException;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JButton;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.JLabel;
/*    */ 
/*    */ public class About extends JFrame implements ActionListener {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   private FontMetrics fm;
/*    */   
/*    */   public About() {
/* 23 */     getContentPane().setLayout((LayoutManager)null);
/* 24 */     this.fm = getFontMetrics(Game.f3MenuFont);
/* 25 */     BufferedImage image = Game.logoImage;
/* 27 */     JLabel logoLabel = new JLabel();
/* 28 */     logoLabel.setIcon(new ImageIcon(image));
/* 29 */     logoLabel.setBounds(250 - image.getWidth(), 
/* 30 */         125 - image.getHeight() / 2 - 35, image.getWidth(), 
/* 31 */         image.getHeight());
/* 32 */     add(logoLabel);
/* 34 */     addText(250 - image.getWidth() / 2 - 
/* 35 */         this.fm.stringWidth(Game.copyright) / 2, 145, 
/* 36 */         this.fm.stringWidth(Game.copyright), 30, Game.copyright);
/* 37 */     addText(250 - image.getWidth() / 2 - this.fm.stringWidth(Game.title) / 2, 
/* 38 */         125, this.fm.stringWidth(Game.title), 27, Game.title);
/* 40 */     addButton(300, 72, 100, 30, "Website");
/* 41 */     addButton(300, 110, 100, 30, "Credits");
/*    */   }
/*    */   
/*    */   public void actionPerformed(ActionEvent ae) {
/* 46 */     String a = ae.getActionCommand();
/* 47 */     if (!a.equals("test"))
/* 48 */       if (a.equals("Website")) {
/* 49 */         String url = "http://emgartley.wordpress.com/games/beyond-origins/";
/* 50 */         String cmd = "cmd.exe /c start " + url;
/*    */         try {
/* 52 */           Runtime.getRuntime().exec(cmd);
/* 53 */         } catch (IOException e) {
/* 54 */           e.printStackTrace();
/*    */         } 
/* 56 */       } else if (a.equals("Credits")) {
/* 57 */         Game.getMainMenu().m1Creds();
/*    */       }  
/*    */   }
/*    */   
/*    */   private void addButton(int x, int y, int w, int h, String t) {
/* 62 */     JButton b = new JButton(t);
/* 63 */     b.setBounds(x, y, w, h);
/* 64 */     b.addActionListener(this);
/* 65 */     b.setFocusable(false);
/* 66 */     add(b);
/*    */   }
/*    */   
/*    */   private void addText(int x, int y, int w, int h, String text) {
/* 70 */     JLabel l = new JLabel(text);
/* 71 */     l.setBounds(x, y, w, h);
/* 72 */     l.setFont(Game.f3MenuFont);
/* 73 */     l.setOpaque(true);
/* 74 */     add(l);
/*    */   }
/*    */   
/*    */   public void createWindow() {
/* 79 */     JFrame frame = new About();
/* 80 */     frame.setTitle("About");
/* 81 */     frame.setSize(500, 250);
/* 82 */     frame.setResizable(false);
/* 83 */     frame.setLocationRelativeTo((Component)null);
/* 84 */     frame.setDefaultCloseOperation(2);
/* 85 */     frame.setVisible(true);
/* 86 */     Game.st.setFrameIconAbsoulute(frame, String.valueOf(Game.mainDir) + "assets\\icon32.png");
/* 87 */     Game.st.setSystemLookAndFeel(frame);
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.1.0_3.jar!\com\emgartley\beyondOrigins\main\windows\About.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */