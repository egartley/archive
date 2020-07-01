/*    */ package beyondOrigins.main.gfx;
/*    */ 
/*    */ import java.awt.image.BufferedImage;
/*    */ import java.io.IOException;
/*    */ import javax.imageio.ImageIO;
/*    */ 
/*    */ public class ImageLoader {
/*    */   public BufferedImage load(String path) {
/*    */     try {
/* 13 */       return ImageIO.read(getClass().getResource(path));
/* 14 */     } catch (IOException e) {
/* 15 */       e.printStackTrace();
/* 17 */       return null;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_1.jar!\beyondOrigins\main\gfx\ImageLoader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */