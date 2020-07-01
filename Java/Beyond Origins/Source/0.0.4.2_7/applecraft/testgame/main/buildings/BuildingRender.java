/*    */ package applecraft.testgame.main.buildings;
/*    */ 
/*    */ import applecraft.testgame.main.Game;
/*    */ import applecraft.testgame.main.entities.Player;
/*    */ import applecraft.testgame.main.gfx.ImageManager;
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
/* 22 */     this.im = im;
/*    */   }
/*    */   
/*    */   public void tick() {}
/*    */   
/*    */   public void render(Graphics g) {
/* 31 */     shop1X = 1440;
/* 32 */     shop1Y = 32;
/* 34 */     render1X = shop1X - Player.mapX + Game.playerSpawnX;
/* 35 */     render1Y = shop1Y - Player.mapY + Game.playerSpawnY;
/* 37 */     g.drawImage(ImageManager.shop1, (int)render1X, (int)render1Y, 96, 96, null);
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4.2_7.jar!\applecraft\testgame\main\buildings\BuildingRender.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */