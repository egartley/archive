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
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.JLabel;
/*    */ 
/*    */ public class Credits extends JFrame implements ActionListener {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   FontMetrics fm;
/*    */   
/*    */   public Credits() {
/* 21 */     getContentPane().setLayout((LayoutManager)null);
/* 22 */     this.fm = getFontMetrics(Game.profileInfoFont);
/* 24 */     JLabel label = new JLabel();
/* 25 */     BufferedImage image = Game.st.loadImage("/creds.png");
/* 26 */     label.setIcon(new ImageIcon(image));
/* 27 */     label.setBounds(0, 0, image.getWidth(), image.getHeight());
/* 28 */     add(label);
/*    */   }
/*    */   
/*    */   public void actionPerformed(ActionEvent e) {
/* 32 */     String a = e.getActionCommand();
/* 33 */     a.equals("Sign Up");
/*    */   }
/*    */   
/*    */   public void createWindow() {
/* 39 */     JFrame frame = new Credits();
/* 40 */     frame.setTitle("Credits");
/* 41 */     frame.setSize(500, 520);
/* 42 */     frame.setResizable(false);
/* 43 */     frame.setLocationRelativeTo((Component)null);
/* 44 */     frame.setDefaultCloseOperation(2);
/* 45 */     frame.setVisible(true);
/* 46 */     frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
/* 47 */           JFrame.class.getResource("/icon32.png")));
/* 49 */     Game.st.setSystemLookAndFeel(frame);
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.6_3.jar!\beyondOrigins\main\windows\Credits.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */