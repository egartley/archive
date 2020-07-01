/*    */ package com.emgartley.beyondOrigins.main.windows;
/*    */ 
/*    */ import com.emgartley.beyondOrigins.files.Load;
/*    */ import com.emgartley.beyondOrigins.main.Game;
/*    */ import java.awt.Component;
/*    */ import java.awt.FontMetrics;
/*    */ import java.awt.LayoutManager;
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.JTextField;
/*    */ 
/*    */ public class Keys extends JFrame implements ActionListener {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   FontMetrics fm;
/*    */   
/* 17 */   byte yBase = 61;
/*    */   
/* 17 */   byte yInit = 50;
/*    */   
/* 18 */   public static int invToggle = 69, up = 87, down = 83, left = 65;
/*    */   
/* 19 */   public static int right = 68;
/*    */   
/* 19 */   public static int attack = 75;
/*    */   
/* 19 */   public static int block = 76;
/*    */   
/* 19 */   public static int sprint = 16;
/*    */   
/*    */   public JTextField moveUp;
/*    */   
/*    */   public JTextField moveDown;
/*    */   
/*    */   public JTextField moveLeft;
/*    */   
/*    */   public JTextField moveRight;
/*    */   
/*    */   public Keys() {
/* 23 */     getContentPane().setLayout((LayoutManager)null);
/* 24 */     this.fm = getFontMetrics(Game.profileInfoFont);
/*    */   }
/*    */   
/*    */   public void actionPerformed(ActionEvent e) {
/* 82 */     String ac = e.getActionCommand();
/* 83 */     ac.equals("move_up");
/*    */   }
/*    */   
/*    */   public void createWindow() {
/* 89 */     JFrame frame = new Keys();
/* 90 */     Load.loadKeys(Game.keysPath);
/* 91 */     frame.setTitle("Key Config");
/* 92 */     frame.setSize(500, 500);
/* 93 */     frame.setResizable(false);
/* 94 */     frame.setLocationRelativeTo((Component)null);
/* 95 */     frame.setDefaultCloseOperation(2);
/* 96 */     frame.setVisible(true);
/* 97 */     Game.st.setFrameIconAbsoulute(frame, String.valueOf(Game.mainDir) + "assets\\icon32.png");
/* 98 */     Game.st.setSystemLookAndFeel(frame);
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.1.0_3.jar!\com\emgartley\beyondOrigins\main\windows\Keys.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */