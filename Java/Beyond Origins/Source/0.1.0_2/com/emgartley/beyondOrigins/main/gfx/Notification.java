/*    */ package com.emgartley.beyondOrigins.main.gfx;
/*    */ 
/*    */ import com.emgartley.beyondOrigins.main.Game;
/*    */ import java.awt.Color;
/*    */ import java.awt.FontMetrics;
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ public class Notification {
/*    */   private FontMetrics fm;
/*    */   
/* 12 */   public String text = "";
/*    */   
/*    */   int time;
/*    */   
/*    */   int alpha;
/*    */   
/*    */   int alpha2;
/*    */   
/* 14 */   double yy = -36.0D;
/*    */   
/*    */   public boolean r1;
/*    */   
/*    */   public boolean rendering;
/*    */   
/*    */   public Notification(String t) {
/* 18 */     this.text = t;
/*    */   }
/*    */   
/*    */   public void tick() {
/* 22 */     this.time++;
/*    */   }
/*    */   
/*    */   public void setText(String text) {
/* 26 */     this.text = text;
/*    */   }
/*    */   
/*    */   public boolean isStarted() {
/* 30 */     return this.r1;
/*    */   }
/*    */   
/*    */   public void start() {
/* 34 */     this.r1 = true;
/* 35 */     if (Game.sound)
/* 36 */       Game.st.playSound(String.valueOf(Game.mainDir) + "assets\\notification.wav"); 
/* 38 */     Game.logger.log("Notification: '" + this.text + "'");
/*    */   }
/*    */   
/*    */   public void reset() {
/* 42 */     this.time = 0;
/* 43 */     this.alpha = 0;
/* 44 */     this.alpha2 = 0;
/* 45 */     this.yy = -36.0D;
/*    */   }
/*    */   
/*    */   public void cancel() {
/* 49 */     this.r1 = false;
/* 50 */     this.rendering = false;
/*    */   }
/*    */   
/*    */   public void render(Graphics g) {
/* 54 */     if (this.time < 240) {
/* 55 */       this.fm = g.getFontMetrics(Game.buttonTextFont);
/* 56 */       if (this.alpha < 247)
/* 57 */         this.alpha += 8; 
/* 59 */       if (this.alpha2 < 152)
/* 60 */         this.alpha2 += 4; 
/* 62 */       if (this.yy < 0.0D)
/* 63 */         this.yy += 2.0D; 
/* 65 */       g.setColor(new Color(0, 0, 0, this.alpha2));
/* 66 */       g.fillRect(0, (int)this.yy, Game.width, 35);
/* 67 */       g.setFont(Game.buttonTextFont);
/* 68 */       g.setColor(new Color(255, 255, 255, this.alpha));
/* 69 */       g.drawString(this.text, Game.width / 2 - this.fm.stringWidth(this.text) / 2, (int)this.yy + 22);
/* 70 */     } else if (this.time >= 240 && this.time < 250.2D) {
/* 71 */       this.fm = g.getFontMetrics(Game.buttonTextFont);
/* 72 */       if (this.alpha > 8 || this.alpha >= 0)
/* 73 */         this.alpha -= 8; 
/* 75 */       if (this.alpha2 > 4 || this.alpha2 >= 0)
/* 76 */         this.alpha2 -= 4; 
/* 78 */       if (this.yy <= 0.0D && this.yy > -38.0D)
/* 79 */         this.yy -= 2.0D; 
/* 81 */       g.setColor(new Color(0, 0, 0, this.alpha2));
/* 82 */       g.fillRect(0, (int)this.yy, Game.width, 35);
/* 83 */       g.setFont(Game.buttonTextFont);
/* 84 */       g.setColor(new Color(255, 255, 255, this.alpha));
/* 85 */       g.drawString(this.text, Game.width / 2 - this.fm.stringWidth(this.text) / 2, (int)this.yy + 22);
/* 86 */     } else if (this.time >= 250.2D) {
/* 87 */       reset();
/* 88 */       cancel();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.1.0_2.jar!\com\emgartley\beyondOrigins\main\gfx\Notification.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */