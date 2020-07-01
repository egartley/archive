/*     */ package beyondOrigins.userInput;
/*     */ 
/*     */ import beyondOrigins.main.Game;
/*     */ import beyondOrigins.main.menus.MainMenu;
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
/*  20 */   private static final int clickInterval = ((Integer)Toolkit.getDefaultToolkit().getDesktopProperty("awt.multiClickInterval")).intValue();
/*     */   
/*     */   private MouseEvent lastEvent;
/*     */   
/*     */   private Timer timer;
/*     */   
/*     */   public MouseManager() {
/*  26 */     this(clickInterval);
/*     */   }
/*     */   
/*     */   public MouseManager(int delay) {
/*  30 */     this.timer = new Timer(delay, this);
/*     */   }
/*     */   
/*     */   public void doubleClick(MouseEvent e) {
/*  34 */     if (!Game.isInGame && 
/*  35 */       MainMenu.menuState == 2 && ((
/*  36 */       MouseMotion.mouseX >= 275 && 
/*  37 */       MouseMotion.mouseX < 575 && 
/*  38 */       MouseMotion.mouseY >= 50 && MouseMotion.mouseY < 167) || (
/*  39 */       MouseMotion.mouseX >= 275 && 
/*  40 */       MouseMotion.mouseX < 575 && 
/*  41 */       MouseMotion.mouseY >= 160 && MouseMotion.mouseY < 277) || (MouseMotion.mouseX >= 275 && 
/*  42 */       MouseMotion.mouseX < 575 && 
/*  43 */       MouseMotion.mouseY >= 270 && MouseMotion.mouseY < 387)))
/*     */       try {
/*  45 */         MainMenu.m2PlayProfile();
/*  46 */       } catch (IOException e1) {
/*  47 */         e1.printStackTrace();
/*     */       }  
/*     */   }
/*     */   
/*     */   public void singleClick(MouseEvent e) {}
/*     */   
/*     */   public void mousePressed(MouseEvent e) {
/*  57 */     if (e.getButton() == 1)
/*  58 */       mousePressed = true; 
/*  60 */     if (!Game.isInGame && MainMenu.menuState == 2)
/*  61 */       if (MouseMotion.mouseX >= 275 && 
/*  62 */         MouseMotion.mouseX < 575 && 
/*  63 */         MouseMotion.mouseY >= 50 && 
/*  64 */         MouseMotion.mouseY < 167) {
/*  65 */         MainMenu.setCurrentProfile(1);
/*  66 */       } else if (MouseMotion.mouseX >= 275 && 
/*  67 */         MouseMotion.mouseX < 575 && 
/*  68 */         MouseMotion.mouseY >= 160 && 
/*  69 */         MouseMotion.mouseY < 277) {
/*  70 */         MainMenu.setCurrentProfile(2);
/*  71 */       } else if (MouseMotion.mouseX >= 275 && 
/*  72 */         MouseMotion.mouseX < 575 && 
/*  73 */         MouseMotion.mouseY >= 270 && 
/*  74 */         MouseMotion.mouseY < 387) {
/*  75 */         MainMenu.setCurrentProfile(3);
/*     */       }  
/*     */   }
/*     */   
/*     */   public void mouseReleased(MouseEvent e) {
/*  81 */     if (e.getButton() == 1)
/*  82 */       mousePressed = false; 
/*     */   }
/*     */   
/*     */   public void mouseEntered(MouseEvent e) {}
/*     */   
/*     */   public void mouseExited(MouseEvent e) {}
/*     */   
/*     */   public void mouseClicked(MouseEvent e) {
/*  95 */     if (e.getClickCount() > 2)
/*     */       return; 
/*  97 */     this.lastEvent = e;
/*  98 */     if (this.timer.isRunning()) {
/*  99 */       this.timer.stop();
/* 100 */       doubleClick(this.lastEvent);
/*     */     } else {
/* 102 */       this.timer.restart();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void actionPerformed(ActionEvent arg0) {
/* 107 */     this.timer.stop();
/* 108 */     singleClick(this.lastEvent);
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_6.jar!\beyondOrigin\\userInput\MouseManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */