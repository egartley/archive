/*    */ package com.emgartley.beyondOrigins.main.windows;
/*    */ 
/*    */ import com.emgartley.beyondOrigins.main.Game;
/*    */ import javax.swing.JFrame;
/*    */ 
/*    */ public class Credits extends JFrame {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public Credits() {
/* 12 */     getContentPane().setLayout(null);
/* 13 */     Game.st.addFrameImage(this, Game.creds, 0, -10);
/*    */   }
/*    */   
/*    */   public void createWindow() {
/* 17 */     JFrame frame = new Credits();
/* 18 */     frame.setTitle("Credits");
/* 19 */     frame.setSize(500, 510);
/* 20 */     frame.setResizable(false);
/* 21 */     frame.setLocationRelativeTo(null);
/* 22 */     frame.setDefaultCloseOperation(2);
/* 23 */     frame.setVisible(true);
/* 24 */     Game.st.setFrameIconAbsoulute(frame, String.valueOf(Game.mainDir) + "assets\\icon32.png");
/* 25 */     Game.st.setSystemLookAndFeel(frame);
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.1.0_5.jar!\com\emgartley\beyondOrigins\main\windows\Credits.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */