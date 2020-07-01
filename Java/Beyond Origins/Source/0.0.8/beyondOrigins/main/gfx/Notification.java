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
/* 17 */   public String text = "";
/*    */   
/*    */   int time;
/*    */   
/*    */   int alpha;
/*    */   
/*    */   int alpha2;
/*    */   
/* 19 */   double yy = -36.0D;
/*    */   
/*    */   public boolean r1;
/*    */   
/*    */   public boolean rendering;
/*    */   
/*    */   public Notification(String t) {
/* 23 */     this.text = t;
/*    */   }
/*    */   
/*    */   public void tick() {
/* 27 */     this.time++;
/*    */   }
/*    */   
/*    */   public void setText(String text) {
/* 31 */     this.text = text;
/*    */   }
/*    */   
/*    */   public boolean isStarted() {
/* 35 */     return this.r1;
/*    */   }
/*    */   
/*    */   public void start() {
/* 39 */     this.r1 = true;
/* 40 */     Game.st.playSound("/notification.wav");
/*    */   }
/*    */   
/*    */   public void reset() {
/* 44 */     this.time = 0;
/* 45 */     this.alpha = 0;
/* 46 */     this.alpha2 = 0;
/* 47 */     this.yy = -36.0D;
/*    */   }
/*    */   
/*    */   public void cancel() {
/* 51 */     this.r1 = false;
/* 52 */     this.rendering = false;
/*    */   }
/*    */   
/*    */   public void render(Graphics g) {
/* 56 */     if (this.time < 240) {
/* 57 */       this.fm = g.getFontMetrics(Game.buttonTextFont);
/* 58 */       if (this.alpha < 255)
/* 59 */         this.alpha++; 
/* 61 */       if (this.alpha2 < 156)
/* 62 */         this.alpha2++; 
/* 64 */       if (this.yy < 0.0D)
/* 65 */         this.yy += 0.2D; 
/* 67 */       g.setColor(new Color(0, 0, 0, this.alpha2));
/* 68 */       g.fillRect(0, (int)this.yy, Game.width, 35);
/* 69 */       g.setFont(Game.buttonTextFont);
/* 70 */       g.setColor(new Color(255, 255, 255, this.alpha));
/* 71 */       g.drawString(this.text, Game.width / 2 - this.fm.stringWidth(this.text) / 2, (int)this.yy + 22);
/* 72 */     } else if (this.time >= 240 && this.time < 250.2D) {
/* 73 */       this.fm = g.getFontMetrics(Game.buttonTextFont);
/* 74 */       if (this.alpha > 0)
/* 75 */         this.alpha--; 
/* 77 */       if (this.alpha2 > 0)
/* 78 */         this.alpha2--; 
/* 80 */       if (this.yy > 0.0D)
/* 81 */         this.yy -= 0.2D; 
/* 83 */       g.setColor(new Color(0, 0, 0, this.alpha2));
/* 84 */       g.fillRect(0, (int)this.yy, Game.width, 35);
/* 85 */       g.setFont(Game.buttonTextFont);
/* 86 */       g.setColor(new Color(255, 255, 255, this.alpha));
/* 87 */       g.drawString(this.text, Game.width / 2 - this.fm.stringWidth(this.text) / 2, (int)this.yy + 22);
/* 88 */     } else if (this.time >= 250.2D) {
/* 89 */       reset();
/* 90 */       cancel();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.8_2.jar!\beyondOrigins\main\gfx\Notification.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */