/*    */ package beyondOrigins.main.gfx;
/*    */ 
/*    */ import beyondOrigins.main.Game;
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ public class Notify {
/*    */   int t;
/*    */   
/*    */   public void render(Graphics g) {
/* 12 */     this.t++;
/* 13 */     if (this.t <= 45)
/* 14 */       for (int i = this.t + 48; i <= 93; i++)
/* 15 */         g.fillRect(Game.width / 2 - 128, i, 256, 48);  
/* 20 */     if (this.t >= 270)
/* 21 */       this.t = 1; 
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.7.jar!\beyondOrigins\main\gfx\Notify.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */