/*    */ package beyondOrigins.main.gfx;
/*    */ 
/*    */ import beyondOrigins.main.Game;
/*    */ import java.awt.Color;
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ public class Notify {
/*    */   int t;
/*    */   
/*    */   public void render(Graphics g) {
/* 13 */     this.t++;
/* 14 */     if (this.t <= 45) {
/* 15 */       g.setColor(Color.black);
/* 16 */       for (int i = this.t + 48; i <= 93; i++)
/* 17 */         g.fillRect(Game.width / 2 - 128, i, 256, 48); 
/*    */     } 
/* 22 */     if (this.t >= 270)
/* 23 */       this.t = 1; 
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.8_0.jar!\beyondOrigins\main\gfx\Notify.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */