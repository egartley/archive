/*    */ package applecraft.testgame.main.menus;
/*    */ 
/*    */ import applecraft.testgame.main.Game;
/*    */ import applecraft.testgame.main.MouseMotion;
/*    */ import applecraft.testgame.main.entities.Player;
/*    */ import applecraft.testgame.main.gfx.ImageManager;
/*    */ import java.awt.Color;
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ public class F3Menu {
/*    */   public static boolean f3menu = false;
/*    */   
/*    */   private ImageManager im;
/*    */   
/*    */   public F3Menu(ImageManager im) {
/* 22 */     this.im = im;
/*    */   }
/*    */   
/*    */   public void tick() {}
/*    */   
/*    */   public void render(Graphics g) {
/* 31 */     if (f3menu) {
/* 32 */       g.setFont(Game.default1);
/* 33 */       if (!Game.gameRequested) {
/* 34 */         g.setColor(Color.black);
/*    */       } else {
/* 36 */         g.setColor(Color.WHITE);
/*    */       } 
/* 39 */       g.drawString(Game.title, 15, 25);
/* 40 */       g.drawString("Player X: " + Player.playerX + "   " + "Player Y: " + 
/* 41 */           Player.playerY, 15, 40);
/* 42 */       g.drawString("Tile X: " + Player.tileX + "  " + "Tile Y: " + 
/* 43 */           Player.tileY, 15, 55);
/* 44 */       g.drawString("Map X: " + Player.mapX + "  " + " Map Y: " + 
/* 45 */           Player.mapY, 15, 70);
/* 53 */       g.drawString("Made By: Evan Gartley", 650, 25);
/* 54 */       g.drawString("FPS: " + Game.currentFrames, 650, 40);
/* 55 */       g.drawString("MX: " + MouseMotion.mouseX + "  " + "MY: " + 
/* 56 */           MouseMotion.mouseY, 650, 55);
/* 57 */       g.drawString("CanMoveUp: " + Player.canMoveUp, 650, 70);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4.2_6.jar!\applecraft\testgame\main\menus\F3Menu.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */