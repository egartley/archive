/*    */ package beyondOrigins.main.maps;
/*    */ 
/*    */ import beyondOrigins.main.gfx.ImageManager;
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ public abstract class Map {
/*    */   protected ImageManager im;
/*    */   
/*    */   protected int x;
/*    */   
/*    */   protected int y;
/*    */   
/*    */   public Map(ImageManager im) {
/* 13 */     this.im = im;
/*    */   }
/*    */   
/*    */   public abstract void tick();
/*    */   
/*    */   public abstract void render(Graphics paramGraphics);
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_5.jar!\beyondOrigins\main\maps\Map.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */