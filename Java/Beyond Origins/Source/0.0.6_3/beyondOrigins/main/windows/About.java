/*    */ package beyondOrigins.main.windows;
/*    */ 
/*    */ import beyondOrigins.main.Game;
/*    */ import java.awt.Component;
/*    */ import java.awt.FontMetrics;
/*    */ import java.awt.LayoutManager;
/*    */ import java.awt.Toolkit;
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import java.io.IOException;
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
/* 22 */     getContentPane().setLayout((LayoutManager)null);
/* 24 */     this.fm = getFontMetrics(Game.buttonTextFont);
/* 27 */     addText(250 - this.fm.stringWidth("Beyond Origins") / 2, 30, 150, 30, 
/* 28 */         "Beyond Origins");
/* 29 */     addText(250 - this.fm.stringWidth("v" + Game.version) / 2, 60, 100, 30, 
/* 30 */         "v" + Game.version);
/* 32 */     addButton(200, 125, 100, 30, "Website", "Click to head to the website!");
/*    */   }
/*    */   
/*    */   public void actionPerformed(ActionEvent ae) {
/* 37 */     String a = ae.getActionCommand();
/* 38 */     if (!a.equals("test") && 
/* 39 */       a.equals("Website")) {
/* 40 */       String url = "http://emgartley.wordpress.com/games/beyond-origins/";
/* 41 */       String cmd = "cmd.exe /c start " + url;
/*    */       try {
/* 43 */         Runtime.getRuntime().exec(cmd);
/* 44 */       } catch (IOException e) {
/* 45 */         e.printStackTrace();
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   private void addButton(int x, int y, int w, int h, String t, String tip) {
/* 58 */     JButton b = new JButton(t);
/* 59 */     b.setBounds(x, y, w, h);
/* 60 */     b.setToolTipText(tip);
/* 61 */     b.setFocusable(false);
/* 62 */     b.addActionListener(this);
/* 63 */     add(b);
/*    */   }
/*    */   
/*    */   private void addText(int x, int y, int w, int h, String text) {
/* 67 */     JLabel l = new JLabel(text);
/* 68 */     l.setBounds(x, y, w, h);
/* 69 */     l.setFont(Game.buttonTextFont);
/* 70 */     l.setOpaque(true);
/* 71 */     add(l);
/*    */   }
/*    */   
/*    */   public void createWindow() {
/* 76 */     JFrame frame = new About();
/* 77 */     frame.setTitle("About");
/* 78 */     frame.setSize(500, 250);
/* 79 */     frame.setResizable(false);
/* 80 */     frame.setLocationRelativeTo((Component)null);
/* 81 */     frame.setDefaultCloseOperation(2);
/* 82 */     frame.setVisible(true);
/* 83 */     frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
/* 84 */           JFrame.class.getResource("/icon32.png")));
/* 86 */     Game.st.setSystemLookAndFeel(frame);
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.6_3.jar!\beyondOrigins\main\windows\About.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */