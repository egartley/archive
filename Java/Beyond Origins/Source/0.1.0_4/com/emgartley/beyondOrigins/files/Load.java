/*    */ package com.emgartley.beyondOrigins.files;
/*    */ 
/*    */ import com.emgartley.beyondOrigins.main.Game;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ 
/*    */ public class Load {
/* 16 */   static Decrypter de = new Decrypter();
/*    */   
/*    */   public static void loadProfile(String path, int num) {
/* 19 */     LoadXML.load(path, new File(path), num);
/* 20 */     Game.logger.log("Profile " + num + " loaded");
/*    */   }
/*    */   
/*    */   public static void loadData(String path) {
/* 24 */     if (Save.data.exists()) {
/*    */       try {
/* 25 */         Exception exception2, exception1 = null;
/* 41 */       } catch (IOException e) {
/* 42 */         e.printStackTrace();
/*    */       } 
/* 44 */       Game.logger.log("Data loaded");
/* 45 */     } else if (!Save.data.exists()) {
/* 46 */       Save.save1LastPlayed = "";
/* 47 */       Save.save1Made = "";
/* 48 */       Save.save2LastPlayed = "";
/* 49 */       Save.save2Made = "";
/* 50 */       Save.save3LastPlayed = "";
/* 51 */       Save.save3Made = "";
/* 52 */       Game.autoSave = true;
/* 53 */       Game.dummy = false;
/* 54 */       Game.sound = true;
/*    */     } 
/*    */   }
/*    */   
/*    */   public static void loadKeys(String path) {
/* 59 */     File file = new File(path);
/* 60 */     if (file.exists()) {
/*    */       try {
/* 61 */         Exception exception2, exception1 = null;
/* 70 */       } catch (IOException e) {
/* 71 */         e.printStackTrace();
/*    */       } 
/* 73 */       Game.logger.log("Keys loaded");
/* 74 */     } else if (!file.exists()) {
/*    */       try {
/* 76 */         Save.keysSave();
/* 77 */       } catch (IOException e) {
/* 78 */         e.printStackTrace();
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public static void loadMastery() {}
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.1.0_4.jar!\com\emgartley\beyondOrigins\files\Load.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */