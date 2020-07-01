/*    */ package beyondOrigins.files;
/*    */ 
/*    */ import beyondOrigins.main.Game;
/*    */ import java.io.IOException;
/*    */ 
/*    */ public class Load {
/*    */   public static void loadProfile(String path) {
/*    */     try {
/* 13 */       Exception exception2, exception1 = null;
/* 30 */     } catch (IOException e) {
/* 31 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */   
/*    */   public static void loadData(String path) {
/* 38 */     if (Save.data.exists()) {
/*    */       try {
/* 39 */         Exception exception2, exception1 = null;
/* 57 */       } catch (IOException e) {
/* 58 */         e.printStackTrace();
/*    */       } 
/* 60 */     } else if (!Save.data.exists()) {
/* 61 */       Save.save1LastPlayed = "";
/* 62 */       Save.save1Made = "";
/* 63 */       Save.save2LastPlayed = "";
/* 64 */       Save.save2Made = "";
/* 65 */       Save.save3LastPlayed = "";
/* 66 */       Save.save3Made = "";
/* 67 */       Game.autoSave = true;
/* 68 */       Game.dummy = false;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.6_4.jar!\beyondOrigins\files\Load.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */