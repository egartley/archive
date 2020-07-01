/*    */ package beyondOrigins.main.gfx;
/*    */ 
/*    */ import beyondOrigins.main.Game;
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
/* 35 */     Game.st.playSound("/notification.wav");
/* 36 */     Game.logger.log("Notification: '" + this.text + "'");
/*    */   }
/*    */   
/*    */   public void reset() {
/* 40 */     this.time = 0;
/* 41 */     this.alpha = 0;
/* 42 */     this.alpha2 = 0;
/* 43 */     this.yy = -36.0D;
/*    */   }
/*    */   
/*    */   public void cancel() {
/* 47 */     this.r1 = false;
/* 48 */     this.rendering = false;
/*    */   }
/*    */   
/*    */   public void render(Graphics g) {
/* 52 */     if (this.time < 240) {
/* 53 */       this.fm = g.getFontMetrics(Game.buttonTextFont);
/* 54 */       if (this.alpha < 247)
/* 55 */         this.alpha += 8; 
/* 57 */       if (this.alpha2 < 152)
/* 58 */         this.alpha2 += 4; 
/* 60 */       if (this.yy < 0.0D)
/* 61 */         this.yy += 2.0D; 
/* 63 */       g.setColor(new Color(0, 0, 0, this.alpha2));
/* 64 */       g.fillRect(0, (int)this.yy, Game.width, 35);
/* 65 */       g.setFont(Game.buttonTextFont);
/* 66 */       g.setColor(new Color(255, 255, 255, this.alpha));
/* 67 */       g.drawString(this.text, Game.width / 2 - this.fm.stringWidth(this.text) / 2, (int)this.yy + 22);
/* 68 */     } else if (this.time >= 240 && this.time < 250.2D) {
/* 69 */       this.fm = g.getFontMetrics(Game.buttonTextFont);
/* 70 */       if (this.alpha > 8 || this.alpha >= 0)
/* 71 */         this.alpha -= 8; 
/* 73 */       if (this.alpha2 > 4 || this.alpha2 >= 0)
/* 74 */         this.alpha2 -= 4; 
/* 76 */       if (this.yy <= 0.0D && this.yy > -38.0D)
/* 77 */         this.yy -= 2.0D; 
/* 79 */       g.setColor(new Color(0, 0, 0, this.alpha2));
/* 80 */       g.fillRect(0, (int)this.yy, Game.width, 35);
/* 81 */       g.setFont(Game.buttonTextFont);
/* 82 */       g.setColor(new Color(255, 255, 255, this.alpha));
/* 83 */       g.drawString(this.text, Game.width / 2 - this.fm.stringWidth(this.text) / 2, (int)this.yy + 22);
/* 84 */     } else if (this.time >= 250.2D) {
/* 85 */       reset();
/* 86 */       cancel();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.9_3.jar!\beyondOrigins\main\gfx\Notification.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */