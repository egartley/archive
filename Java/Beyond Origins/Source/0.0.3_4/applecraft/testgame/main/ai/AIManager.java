/*    */ package applecraft.testgame.main.ai;
/*    */ 
/*    */ import applecraft.testgame.main.gfx.ImageManager;
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ public abstract class AIManager {
/*    */   protected ImageManager im;
/*    */   
/*    */   protected int x;
/*    */   
/*    */   protected int y;
/*    */   
/*    */   public AIManager(ImageManager im) {
/* 13 */     this.im = im;
/*    */   }
/*    */   
/*    */   public abstract void tick();
/*    */   
/*    */   public abstract void render(Graphics paramGraphics);
/*    */   
/*    */   public abstract void think();
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.3_4.jar!\applecraft\testgame\main\ai\AIManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */