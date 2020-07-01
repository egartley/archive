/*     */ package beyondOrigins.files;
/*     */ 
/*     */ import beyondOrigins.main.Game;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ 
/*     */ public class Load {
/*  14 */   static Decrypter de = new Decrypter();
/*     */   
/*     */   public static void loadProfile(String path, int cp) {
/*     */     try {
/*  19 */       de.decrypt(Game.getSaveKey(cp), new File(path), new File(path));
/*  20 */     } catch (Exception e) {
/*  21 */       e.printStackTrace();
/*     */     } 
/*     */     try {
/*  24 */       Exception exception2, exception1 = null;
/*  40 */     } catch (IOException e) {
/*  41 */       e.printStackTrace();
/*     */     } 
/*     */     try {
/*  45 */       Save.en.encrypt(Game.getSaveKey(cp), new File(path), new File(path));
/*  46 */     } catch (Exception e) {
/*  47 */       e.printStackTrace();
/*     */     } 
/*  49 */     Game.logger.log("Profile " + cp + " loaded");
/*     */   }
/*     */   
/*     */   public static void loadData(String path) {
/*  54 */     if (Save.data.exists()) {
/*     */       try {
/*  55 */         Exception exception2, exception1 = null;
/*  71 */       } catch (IOException e) {
/*  72 */         e.printStackTrace();
/*     */       } 
/*  74 */       Game.logger.log("Data loaded");
/*  75 */     } else if (!Save.data.exists()) {
/*  76 */       Save.save1LastPlayed = "";
/*  77 */       Save.save1Made = "";
/*  78 */       Save.save2LastPlayed = "";
/*  79 */       Save.save2Made = "";
/*  80 */       Save.save3LastPlayed = "";
/*  81 */       Save.save3Made = "";
/*  82 */       Game.autoSave = true;
/*  83 */       Game.dummy = false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void loadKeys(String path) {
/*  88 */     File file = new File(path);
/*  89 */     if (file.exists()) {
/*     */       try {
/*  90 */         Exception exception2, exception1 = null;
/*  99 */       } catch (IOException e) {
/* 100 */         e.printStackTrace();
/*     */       } 
/* 102 */       Game.logger.log("Keys loaded");
/* 103 */     } else if (!file.exists()) {
/*     */       try {
/* 105 */         Save.keysSave();
/* 106 */       } catch (IOException e) {
/* 107 */         e.printStackTrace();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.9_1.jar!\beyondOrigins\files\Load.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */