/*    */ package beyondOrigins.main.buildings;
/*    */ 
/*    */ import beyondOrigins.main.Game;
/*    */ import beyondOrigins.main.entities.Player;
/*    */ import beyondOrigins.main.gfx.ImageManager;
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ public class BuildingRender {
/*    */   private ImageManager im;
/*    */   
/*    */   public static float render1X;
/*    */   
/*    */   public static float render1Y;
/*    */   
/*    */   public static int shop1X;
/*    */   
/*    */   public static int shop1Y;
/*    */   
/*    */   public static void init() {}
/*    */   
/*    */   public BuildingRender(ImageManager im) {
/* 20 */     this.im = im;
/*    */   }
/*    */   
/*    */   public void tick() {}
/*    */   
/*    */   public void render(Graphics g) {
/* 27 */     shop1X = 1440;
/* 28 */     shop1Y = 32;
/* 30 */     render1X = shop1X - Player.mapX + Game.playerSpawnX;
/* 31 */     render1Y = shop1Y - Player.mapY + Game.playerSpawnY;
/* 33 */     g.drawImage(ImageManager.shop1, (int)render1X, (int)render1Y, 96, 96, 
/* 34 */         null);
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4.7.jar!\beyondOrigins\main\buildings\BuildingRender.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */