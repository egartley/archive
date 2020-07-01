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
/* 30 */     logoLabel.setBounds(250 - image.getWidth(), 125 - image.getHeight() / 2 - 15, image.getWidth(), 
/* 31 */         image.getHeight());
/* 32 */     add(logoLabel);
/* 34 */     addText(350 - this.fm.stringWidth("v" + Game.version + 
/* 35 */           " | ©2014 Evan Gartley") / 2, 
/* 36 */         40, 
/* 37 */         this.fm.stringWidth("v" + Game.version + 
/* 38 */           " | ©2014 Evan Gartley"), 30, "v" + 
/* 39 */         Game.version + " | ©2014 Evan Gartley");
/* 41 */     addButton(300, 85, 100, 30, "Website");
/* 42 */     addButton(300, 123, 100, 30, "Credits");
/*    */   }
/*    */   
/*    */   public void actionPerformed(ActionEvent ae) {
/* 47 */     String a = ae.getActionCommand();
/* 48 */     if (!a.equals("test"))
/* 49 */       if (a.equals("Website")) {
/* 50 */         String url = "http://emgartley.wordpress.com/games/beyond-origins/";
/* 51 */         String cmd = "cmd.exe /c start " + url;
/*    */         try {
/* 53 */           Runtime.getRuntime().exec(cmd);
/* 54 */         } catch (IOException e) {
/* 55 */           e.printStackTrace();
/*    */         } 
/* 57 */       } else if (a.equals("Credits")) {
/* 58 */         Game.getMainMenu().m1Creds();
/*    */       }  
/*    */   }
/*    */   
/*    */   private void addButton(int x, int y, int w, int h, String t) {
/* 63 */     JButton b = new JButton(t);
/* 64 */     b.setBounds(x, y, w, h);
/* 65 */     b.addActionListener(this);
/* 66 */     b.setFocusable(false);
/* 67 */     add(b);
/*    */   }
/*    */   
/*    */   private void addText(int x, int y, int w, int h, String text) {
/* 71 */     JLabel l = new JLabel(text);
/* 72 */     l.setBounds(x, y, w, h);
/* 73 */     l.setFont(Game.f3MenuFont);
/* 74 */     l.setOpaque(true);
/* 75 */     add(l);
/*    */   }
/*    */   
/*    */   public void createWindow() {
/* 80 */     JFrame frame = new About();
/* 81 */     frame.setTitle("About");
/* 82 */     frame.setSize(500, 250);
/* 83 */     frame.setResizable(false);
/* 84 */     frame.setLocationRelativeTo((Component)null);
/* 85 */     frame.setDefaultCloseOperation(2);
/* 86 */     frame.setVisible(true);
/* 87 */     frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
/* 88 */           JFrame.class.getResource("/icon32.png")));
/* 90 */     Game.st.setSystemLookAndFeel(frame);
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.9_3.jar!\beyondOrigins\main\windows\About.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */