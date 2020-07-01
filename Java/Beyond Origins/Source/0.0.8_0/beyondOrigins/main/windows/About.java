/*    */ package beyondOrigins.main.windows;
/*    */ 
/*    */ import beyondOrigins.main.Game;
/*    */ import java.awt.Component;
/*    */ import java.awt.FontMetrics;
/*    */ import java.awt.LayoutManager;
/*    */ import java.awt.Toolkit;
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
/* 24 */     getContentPane().setLayout((LayoutManager)null);
/* 25 */     this.fm = getFontMetrics(Game.f3MenuFont);
/* 26 */     BufferedImage image = Game.logoImage;
/* 28 */     JLabel logoLabel = new JLabel();
/* 29 */     logoLabel.setIcon(new ImageIcon(image));
/* 30 */     logoLabel.setBounds(250 - image.getWidth() / 2, 5, image.getWidth(), 
/* 31 */         image.getHeight());
/* 32 */     add(logoLabel);
/* 34 */     addText(250 - this.fm.stringWidth("v" + Game.version + 
/* 35 */           " | ©2014 Evan Gartley") / 2, 
/* 36 */         110, 
/* 37 */         this.fm.stringWidth("v" + Game.version + 
/* 38 */           " | ©2014 Evan Gartley"), 30, "v" + 
/* 39 */         Game.version + " | ©2014 Evan Gartley");
/* 41 */     addButton(200, 165, 100, 30, "Website");
/*    */   }
/*    */   
/*    */   public void actionPerformed(ActionEvent ae) {
/* 46 */     String a = ae.getActionCommand();
/* 47 */     if (!a.equals("test") && 
/* 48 */       a.equals("Website")) {
/* 49 */       String url = "http://emgartley.wordpress.com/games/beyond-origins/";
/* 50 */       String cmd = "cmd.exe /c start " + url;
/*    */       try {
/* 52 */         Runtime.getRuntime().exec(cmd);
/* 53 */       } catch (IOException e) {
/* 54 */         e.printStackTrace();
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   private void addButton(int x, int y, int w, int h, String t) {
/* 60 */     JButton b = new JButton(t);
/* 61 */     b.setBounds(x, y, w, h);
/* 62 */     b.addActionListener(this);
/* 63 */     b.setFocusable(false);
/* 64 */     add(b);
/*    */   }
/*    */   
/*    */   private void addText(int x, int y, int w, int h, String text) {
/* 68 */     JLabel l = new JLabel(text);
/* 69 */     l.setBounds(x, y, w, h);
/* 70 */     l.setFont(Game.f3MenuFont);
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
/* 85 */           JFrame.class.getResource("/icon32.png")));
/* 87 */     Game.st.setSystemLookAndFeel(frame);
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.8_0.jar!\beyondOrigins\main\windows\About.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */