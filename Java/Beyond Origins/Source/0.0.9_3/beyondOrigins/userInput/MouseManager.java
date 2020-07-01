/*     */ package beyondOrigins.userInput;
/*     */ 
/*     */ import beyondOrigins.main.Game;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.event.MouseListener;
/*     */ import java.io.IOException;
/*     */ import javax.swing.Timer;
/*     */ 
/*     */ public class MouseManager implements MouseListener, ActionListener {
/*     */   public static boolean mousePressed = false;
/*     */   
/*  19 */   private static final int clickInterval = ((Integer)Toolkit.getDefaultToolkit().getDesktopProperty("awt.multiClickInterval")).intValue();
/*     */   
/*     */   private MouseEvent lastEvent;
/*     */   
/*     */   private Timer timer;
/*     */   
/*     */   public MouseManager() {
/*  25 */     this(clickInterval);
/*     */   }
/*     */   
/*     */   public MouseManager(int delay) {
/*  29 */     this.timer = new Timer(delay, this);
/*     */   }
/*     */   
/*     */   public void doubleClick(MouseEvent e) {
/*  33 */     if (!Game.isInGame && 
/*  34 */       (Game.getMainMenu()).menuState == 2 && ((
/*  35 */       MouseMotion.mouseX >= 275 && 
/*  36 */       MouseMotion.mouseX < 575 && 
/*  37 */       MouseMotion.mouseY >= 50 && MouseMotion.mouseY < 167) || (
/*  38 */       MouseMotion.mouseX >= 275 && 
/*  39 */       MouseMotion.mouseX < 575 && 
/*  40 */       MouseMotion.mouseY >= 160 && MouseMotion.mouseY < 277) || (MouseMotion.mouseX >= 275 && 
/*  41 */       MouseMotion.mouseX < 575 && 
/*  42 */       MouseMotion.mouseY >= 270 && MouseMotion.mouseY < 387)))
/*     */       try {
/*  44 */         Game.getMainMenu().m2PlayProfile();
/*  45 */       } catch (IOException e1) {
/*  46 */         e1.printStackTrace();
/*     */       }  
/*     */   }
/*     */   
/*     */   public void singleClick(MouseEvent e) {}
/*     */   
/*     */   public void mousePressed(MouseEvent e) {
/*  56 */     if (e.getButton() == 1)
/*  57 */       mousePressed = true; 
/*  59 */     if (!Game.isInGame && (Game.getMainMenu()).menuState == 2)
/*  60 */       if (MouseMotion.mouseX >= 275 && 
/*  61 */         MouseMotion.mouseX < 575 && 
/*  62 */         MouseMotion.mouseY >= 50 && 
/*  63 */         MouseMotion.mouseY < 167) {
/*  64 */         Game.getMainMenu().setCurrentProfile(1);
/*  65 */       } else if (MouseMotion.mouseX >= 275 && 
/*  66 */         MouseMotion.mouseX < 575 && 
/*  67 */         MouseMotion.mouseY >= 160 && 
/*  68 */         MouseMotion.mouseY < 277) {
/*  69 */         Game.getMainMenu().setCurrentProfile(2);
/*  70 */       } else if (MouseMotion.mouseX >= 275 && 
/*  71 */         MouseMotion.mouseX < 575 && 
/*  72 */         MouseMotion.mouseY >= 270 && 
/*  73 */         MouseMotion.mouseY < 387) {
/*  74 */         Game.getMainMenu().setCurrentProfile(3);
/*     */       }  
/*     */   }
/*     */   
/*     */   public void mouseReleased(MouseEvent e) {
/*  80 */     if (e.getButton() == 1)
/*  81 */       mousePressed = false; 
/*     */   }
/*     */   
/*     */   public void mouseEntered(MouseEvent e) {}
/*     */   
/*     */   public void mouseExited(MouseEvent e) {}
/*     */   
/*     */   public void mouseClicked(MouseEvent e) {
/*  94 */     if (e.getClickCount() > 2)
/*     */       return; 
/*  96 */     this.lastEvent = e;
/*  97 */     if (this.timer.isRunning()) {
/*  98 */       this.timer.stop();
/*  99 */       doubleClick(this.lastEvent);
/*     */     } else {
/* 101 */       this.timer.restart();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void actionPerformed(ActionEvent arg0) {
/* 106 */     this.timer.stop();
/* 107 */     singleClick(this.lastEvent);
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.9_3.jar!\beyondOrigin\\userInput\MouseManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */