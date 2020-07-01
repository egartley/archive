/*    */ package beyondOrigins.main.windows;
/*    */ 
/*    */ import beyondOrigins.files.Load;
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
/* 17 */   byte yBase = 61;
/*    */   
/* 17 */   byte yInit = 50;
/*    */   
/* 18 */   public static int invToggle = 69, up = 87, down = 83, left = 65;
/*    */   
/* 19 */   public static int right = 68, attack = 75, block = 76, sprint = 16;
/*    */   
/*    */   public Keys() {
/* 22 */     getContentPane().setLayout((LayoutManager)null);
/* 23 */     this.fm = getFontMetrics(Game.profileInfoFont);
/*    */   }
/*    */   
/*    */   public void actionPerformed(ActionEvent e) {
/* 27 */     String ac = e.getActionCommand();
/* 28 */     ac.equals("move_up");
/*    */   }
/*    */   
/*    */   public void createWindow() {
/* 34 */     JFrame frame = new Keys();
/* 35 */     Load.loadKeys(Game.keysPath);
/* 36 */     frame.setTitle("Key Config");
/* 37 */     frame.setSize(500, 500);
/* 38 */     frame.setResizable(false);
/* 39 */     frame.setLocationRelativeTo((Component)null);
/* 40 */     frame.setDefaultCloseOperation(2);
/* 41 */     frame.setVisible(true);
/* 42 */     frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
/* 43 */           JFrame.class.getResource("/icon32.png")));
/* 45 */     Game.st.setSystemLookAndFeel(frame);
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.8_1.jar!\beyondOrigins\main\windows\Keys.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */