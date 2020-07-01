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
/* 38 */     if (!a.equals("test"))
/* 40 */       if (a.equals("Website")) {
/* 41 */         String url = "http://emgartley.wordpress.com/games/beyond-origins/";
/* 42 */         String cmd = "cmd.exe /c start " + url;
/*    */         try {
/* 45 */           Runtime.getRuntime().exec(cmd);
/* 46 */         } catch (IOException e) {
/* 47 */           e.printStackTrace();
/*    */         } 
/*    */       }  
/*    */   }
/*    */   
/*    */   private void addButton(int x, int y, int w, int h, String t) {
/* 53 */     JButton b = new JButton(t);
/* 54 */     b.setBounds(x, y, w, h);
/* 55 */     b.addActionListener(this);
/* 56 */     add(b);
/*    */   }
/*    */   
/*    */   private void addButton(int x, int y, int w, int h, String t, String tt) {
/* 60 */     JButton b = new JButton(t);
/* 61 */     b.setBounds(x, y, w, h);
/* 62 */     b.setToolTipText(tt);
/* 63 */     b.addActionListener(this);
/* 64 */     add(b);
/*    */   }
/*    */   
/*    */   private void addText(int x, int y, int w, int h, String text) {
/* 68 */     JLabel l = new JLabel(text);
/* 69 */     l.setBounds(x, y, w, h);
/* 70 */     l.setFont(Game.buttonTextFont);
/* 71 */     l.setOpaque(true);
/* 72 */     add(l);
/*    */   }
/*    */   
/*    */   public void createWindow() {
/* 77 */     JFrame frame = new About();
/* 78 */     frame.setTitle("About");
/* 79 */     frame.setSize(500, 250);
/* 80 */     frame.setResizable(false);
/* 81 */     frame.setLocationRelativeTo((Component)null);
/* 82 */     frame.setDefaultCloseOperation(2);
/* 83 */     frame.setVisible(true);
/* 84 */     frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
/* 85 */           JFrame.class.getResource("/icon32About.png")));
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.6_2.jar!\beyondOrigins\main\windows\About.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */