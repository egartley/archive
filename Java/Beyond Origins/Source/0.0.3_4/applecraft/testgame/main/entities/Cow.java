/*    */ package applecraft.testgame.main.entities;
/*    */ 
/*    */ import applecraft.testgame.main.gfx.ImageManager;
/*    */ import java.awt.Graphics;
/*    */ import java.util.Random;
/*    */ 
/*    */ public class Cow {
/* 13 */   Random r = new Random();
/*    */   
/* 14 */   private int r1 = this.r.nextInt(51);
/*    */   
/* 15 */   private int r2 = this.r.nextInt(51);
/*    */   
/* 16 */   private int r3 = this.r.nextInt(51);
/*    */   
/* 17 */   private int r4 = this.r.nextInt(51);
/*    */   
/* 19 */   private static float cowX = 0.0F;
/*    */   
/* 20 */   private static float cowY = 0.0F;
/*    */   
/*    */   public int x;
/*    */   
/*    */   public int y;
/*    */   
/*    */   private boolean up;
/*    */   
/*    */   private boolean down;
/*    */   
/*    */   private boolean left;
/*    */   
/*    */   private boolean right;
/*    */   
/*    */   private int upThink;
/*    */   
/*    */   private int downThink;
/*    */   
/*    */   private int leftThink;
/*    */   
/*    */   private int rightThink;
/*    */   
/* 25 */   private static int time = 0;
/*    */   
/*    */   private ImageManager im;
/*    */   
/*    */   public Cow(ImageManager im) {
/* 30 */     this.im = im;
/*    */   }
/*    */   
/*    */   public void tick() {
/* 35 */     time++;
/* 37 */     this.r1 = this.r.nextInt(51);
/* 38 */     this.r2 = this.r.nextInt(51);
/* 39 */     this.r3 = this.r.nextInt(51);
/* 40 */     this.r4 = this.r.nextInt(51);
/* 42 */     if (time == 101)
/* 43 */       time = 0; 
/*    */   }
/*    */   
/*    */   public void think() {}
/*    */   
/*    */   public void render(Graphics g) {}
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.3_4.jar!\applecraft\testgame\main\entities\Cow.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */