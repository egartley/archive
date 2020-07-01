/*    */ package applecraft.testgame.main;
/*    */ 
/*    */ import applecraft.testgame.main.entities.Player;
/*    */ 
/*    */ public class Save {
/*    */   public static void save1() {
/*  9 */     Game.pw1.println(Player.playerX);
/* 10 */     Game.pw1.println(Player.playerY);
/* 11 */     Game.pw1.println(Player.mapX);
/* 12 */     Game.pw1.println(Player.mapY);
/* 14 */     Game.pw1.close();
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4.2_7.jar!\applecraft\testgame\main\Save.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */