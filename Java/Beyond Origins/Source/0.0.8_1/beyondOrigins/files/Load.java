/*    */ package beyondOrigins.files;
/*    */ 
/*    */ import beyondOrigins.main.Game;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ 
/*    */ public class Load {
/*    */   public static void loadProfile(String path) {
/*    */     try {
/* 15 */       Exception exception2, exception1 = null;
/* 31 */     } catch (IOException e) {
/* 32 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */   
/*    */   public static void loadData(String path) {
/* 39 */     if (Save.data.exists()) {
/*    */       try {
/* 40 */         Exception exception2, exception1 = null;
/* 58 */       } catch (IOException e) {
/* 59 */         e.printStackTrace();
/*    */       } 
/* 61 */     } else if (!Save.data.exists()) {
/* 62 */       Save.save1LastPlayed = "";
/* 63 */       Save.save1Made = "";
/* 64 */       Save.save2LastPlayed = "";
/* 65 */       Save.save2Made = "";
/* 66 */       Save.save3LastPlayed = "";
/* 67 */       Save.save3Made = "";
/* 68 */       Game.autoSave = true;
/* 69 */       Game.dummy = false;
/*    */     } 
/*    */   }
/*    */   
/*    */   public static void loadKeys(String path) {
/* 74 */     File file = new File(path);
/* 75 */     if (file.exists()) {
/*    */       try {
/* 76 */         Exception exception2, exception1 = null;
/* 85 */       } catch (IOException e) {
/* 86 */         e.printStackTrace();
/*    */       } 
/* 88 */     } else if (!file.exists()) {
/*    */       try {
/* 90 */         Save.keysSave();
/* 91 */       } catch (IOException e) {
/* 92 */         e.printStackTrace();
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.8_1.jar!\beyondOrigins\files\Load.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */