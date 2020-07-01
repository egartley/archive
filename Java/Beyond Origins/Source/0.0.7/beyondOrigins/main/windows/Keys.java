/*    */ package beyondOrigins.main.windows;
/*    */ 
/*    */ import beyondOrigins.main.Game;
/*    */ import java.awt.Component;
/*    */ import java.awt.FontMetrics;
/*    */ import java.awt.LayoutManager;
/*    */ import java.awt.Toolkit;
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import javax.swing.JFrame;
/*    */ 
/*    */ public class Keys extends JFrame implements ActionListener {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   FontMetrics fm;
/*    */   
/* 16 */   byte yBase = 61;
/*    */   
/* 16 */   byte yInit = 50;
/*    */   
/* 17 */   public static int invToggle = 69, up = 87, down = 83, left = 65;
/*    */   
/* 18 */   public static int right = 68, attack = 75, block = 76, sprint = 16;
/*    */   
/*    */   public Keys() {
/* 21 */     getContentPane().setLayout((LayoutManager)null);
/* 22 */     this.fm = getFontMetrics(Game.profileInfoFont);
/*    */   }
/*    */   
/*    */   public void actionPerformed(ActionEvent e) {
/* 26 */     String a = e.getActionCommand();
/* 27 */     a.equals(" ");
/*    */   }
/*    */   
/*    */   public void createWindow() {
/* 33 */     JFrame frame = new Keys();
/* 34 */     frame.setTitle("Key Config");
/* 35 */     frame.setSize(500, 500);
/* 36 */     frame.setResizable(false);
/* 37 */     frame.setLocationRelativeTo((Component)null);
/* 38 */     frame.setDefaultCloseOperation(2);
/* 39 */     frame.setVisible(true);
/* 40 */     frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
/* 41 */           JFrame.class.getResource("/icon32.png")));
/* 43 */     Game.st.setSystemLookAndFeel(frame);
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.7.jar!\beyondOrigins\main\windows\Keys.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */