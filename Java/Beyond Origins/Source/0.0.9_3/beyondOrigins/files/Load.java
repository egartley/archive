/*     */ package beyondOrigins.files;
/*     */ 
/*     */ import beyondOrigins.main.Game;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ 
/*     */ public class Load {
/*  16 */   static Decrypter de = new Decrypter();
/*     */   
/*     */   public static void loadProfile(String path, int cp) {
/*     */     try {
/*  21 */       de.decrypt(Game.getSaveKey(cp), new File(path), new File(path));
/*  22 */     } catch (Exception e) {
/*  23 */       e.printStackTrace();
/*     */     } 
/*     */     try {
/*  26 */       Exception exception2, exception1 = null;
/*  43 */     } catch (IOException e) {
/*  44 */       e.printStackTrace();
/*     */     } 
/*     */     try {
/*  48 */       Save.en.encrypt(Game.getSaveKey(cp), new File(path), new File(path));
/*  49 */     } catch (Exception e) {
/*  50 */       e.printStackTrace();
/*     */     } 
/*  52 */     Game.logger.log("Profile " + cp + " loaded");
/*     */   }
/*     */   
/*     */   public static void loadData(String path) {
/*  57 */     if (Save.data.exists()) {
/*     */       try {
/*  58 */         Exception exception2, exception1 = null;
/*  73 */       } catch (IOException e) {
/*  74 */         e.printStackTrace();
/*     */       } 
/*  76 */       Game.logger.log("Data loaded");
/*  77 */     } else if (!Save.data.exists()) {
/*  78 */       Save.save1LastPlayed = "";
/*  79 */       Save.save1Made = "";
/*  80 */       Save.save2LastPlayed = "";
/*  81 */       Save.save2Made = "";
/*  82 */       Save.save3LastPlayed = "";
/*  83 */       Save.save3Made = "";
/*  84 */       Game.autoSave = true;
/*  85 */       Game.dummy = false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void loadKeys(String path) {
/*  90 */     File file = new File(path);
/*  91 */     if (file.exists()) {
/*     */       try {
/*  92 */         Exception exception2, exception1 = null;
/* 101 */       } catch (IOException e) {
/* 102 */         e.printStackTrace();
/*     */       } 
/* 104 */       Game.logger.log("Keys loaded");
/* 105 */     } else if (!file.exists()) {
/*     */       try {
/* 107 */         Save.keysSave();
/* 108 */       } catch (IOException e) {
/* 109 */         e.printStackTrace();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void loadMastery() {}
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.9_3.jar!\beyondOrigins\files\Load.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */