/*    */ package applecraft.testgame.main.gfx;
/*    */ 
/*    */ import java.awt.image.BufferedImage;
/*    */ import java.io.IOException;
/*    */ import javax.imageio.ImageIO;
/*    */ 
/*    */ public class ImageLoader {
/*    */   public BufferedImage load(String path) {
/*    */     try {
/* 12 */       return ImageIO.read(getClass().getResource(path));
/* 13 */     } catch (IOException e) {
/* 14 */       e.printStackTrace();
/* 16 */       return null;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.3_1.jar!\applecraft\testgame\main\gfx\ImageLoader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */