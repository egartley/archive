/*     */ package com.emgartley.beyondOrigins.userInput;
/*     */ 
/*     */ import com.emgartley.beyondOrigins.main.Game;
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
/*  35 */       MouseMotion.mouseX >= 110 && 
/*  36 */       MouseMotion.mouseX < 410 && 
/*  37 */       MouseMotion.mouseY >= 114 && 
/*  38 */       MouseMotion.mouseY < 231) || (
/*  39 */       MouseMotion.mouseX >= 110 && 
/*  40 */       MouseMotion.mouseX < 410 && 
/*  41 */       MouseMotion.mouseY >= 224 && MouseMotion.mouseY < 341) || (MouseMotion.mouseX >= 110 && 
/*  42 */       MouseMotion.mouseX < 410 && 
/*  43 */       MouseMotion.mouseY >= 334 && MouseMotion.mouseY < 451)))
/*     */       try {
/*  45 */         Game.getMainMenu().m2PlayProfile();
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
/*  60 */     if (!Game.isInGame && (Game.getMainMenu()).menuState == 2)
/*  61 */       if (MouseMotion.mouseX >= 110 && MouseMotion.mouseX < 410 && 
/*  62 */         MouseMotion.mouseY >= 114 && 
/*  63 */         MouseMotion.mouseY < 231) {
/*  64 */         Game.getMainMenu().setCurrentProfile(1);
/*  65 */       } else if (MouseMotion.mouseX >= 110 && 
/*  66 */         MouseMotion.mouseX < 410 && 
/*  67 */         MouseMotion.mouseY >= 224 && 
/*  68 */         MouseMotion.mouseY < 341) {
/*  69 */         Game.getMainMenu().setCurrentProfile(2);
/*  70 */       } else if (MouseMotion.mouseX >= 110 && 
/*  71 */         MouseMotion.mouseX < 410 && 
/*  72 */         MouseMotion.mouseY >= 334 && 
/*  73 */         MouseMotion.mouseY < 451) {
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


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.1.0_5.jar!\com\emgartley\beyondOrigin\\userInput\MouseManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */