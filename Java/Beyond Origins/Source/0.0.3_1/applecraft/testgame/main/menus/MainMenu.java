/*    */ package applecraft.testgame.main.menus;
/*    */ 
/*    */ import applecraft.testgame.main.Game;
/*    */ import applecraft.testgame.main.MouseManager;
/*    */ import applecraft.testgame.main.MouseMotion;
/*    */ import applecraft.testgame.main.gfx.ImageManager;
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ public class MainMenu {
/*    */   public static boolean playButtonSelected = false;
/*    */   
/* 13 */   private static int playPressed = 0;
/*    */   
/*    */   private ImageManager im;
/*    */   
/*    */   public MainMenu(ImageManager im) {
/* 18 */     this.im = im;
/*    */   }
/*    */   
/*    */   public void tick() {}
/*    */   
/*    */   public void render(Graphics g) {
/* 27 */     if (!Game.gameRequested) {
/* 29 */       g.drawImage(this.im.playButton1, 334, 264, 160, 32, null);
/* 31 */       g.drawString(Game.title, 5, 535);
/* 32 */       g.drawString("Evan Gartley", 757, 535);
/* 34 */       if (MouseMotion.mouseX >= 325 && MouseMotion.mouseX <= 491 && 
/* 35 */         MouseMotion.mouseY >= 248 && MouseMotion.mouseY <= 292) {
/* 36 */         g.drawImage(this.im.playButton2, 334, 264, 160, 32, null);
/* 37 */         playButtonSelected = true;
/*    */       } else {
/* 39 */         playButtonSelected = false;
/*    */       } 
/* 41 */       if (playButtonSelected && MouseManager.mouseFullClick == 1) {
/* 42 */         g.drawImage(this.im.playButton3, 334, 264, 160, 32, null);
/* 43 */         Game.gameRequested = true;
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.3_1.jar!\applecraft\testgame\main\menus\MainMenu.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */