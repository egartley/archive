/*    */ package com.emgartley.beyondOrigins.main.windows;
/*    */ 
/*    */ import com.emgartley.beyondOrigins.main.Game;
/*    */ import java.awt.Component;
/*    */ import java.awt.LayoutManager;
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.JLabel;
/*    */ 
/*    */ public class AddOns extends JFrame implements ActionListener {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/* 15 */   private String b1 = "Apply", b2 = "Cancel";
/*    */   
/*    */   public AddOns() {
/* 18 */     getContentPane().setLayout((LayoutManager)null);
/* 21 */     addText(208, 240, 100, 15, "Coming Soon!");
/*    */   }
/*    */   
/*    */   public void actionPerformed(ActionEvent ae) {
/* 26 */     String a = ae.getActionCommand();
/* 27 */     if (!a.equals(this.b1))
/* 29 */       a.equals(this.b2); 
/*    */   }
/*    */   
/*    */   private void addText(int x, int y, int w, int h, String text) {
/* 43 */     JLabel l = new JLabel(text);
/* 44 */     l.setBounds(x, y, w, h);
/* 45 */     l.setOpaque(true);
/* 46 */     add(l);
/*    */   }
/*    */   
/*    */   public void createWindow() {
/* 51 */     JFrame frame = new AddOns();
/* 52 */     frame.setTitle("Add-Ons");
/* 53 */     frame.setSize(500, 500);
/* 54 */     frame.setResizable(false);
/* 55 */     frame.setLocationRelativeTo((Component)null);
/* 56 */     frame.setDefaultCloseOperation(2);
/* 57 */     frame.setVisible(true);
/* 58 */     Game.st.setFrameIconAbsoulute(frame, String.valueOf(Game.mainDir) + "assets\\icon32.png");
/* 59 */     Game.st.setSystemLookAndFeel(frame);
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.1.0_2.jar!\com\emgartley\beyondOrigins\main\windows\AddOns.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */