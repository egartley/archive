/*     */ package com.emgartley.beyondOrigins.files;
/*     */ 
/*     */ import com.emgartley.beyondOrigins.main.Game;
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
/*  41 */     } catch (IOException e) {
/*  42 */       e.printStackTrace();
/*     */     } 
/*     */     try {
/*  46 */       Save.en.encrypt(Game.getSaveKey(cp), new File(path), new File(path));
/*  47 */     } catch (Exception e) {
/*  48 */       e.printStackTrace();
/*     */     } 
/*  50 */     Game.logger.log("Profile " + cp + " loaded");
/*     */   }
/*     */   
/*     */   public static void loadData(String path) {
/*  55 */     if (Save.data.exists()) {
/*     */       try {
/*  56 */         Exception exception2, exception1 = null;
/*  72 */       } catch (IOException e) {
/*  73 */         e.printStackTrace();
/*     */       } 
/*  75 */       Game.logger.log("Data loaded");
/*  76 */     } else if (!Save.data.exists()) {
/*  77 */       Save.save1LastPlayed = "";
/*  78 */       Save.save1Made = "";
/*  79 */       Save.save2LastPlayed = "";
/*  80 */       Save.save2Made = "";
/*  81 */       Save.save3LastPlayed = "";
/*  82 */       Save.save3Made = "";
/*  83 */       Game.autoSave = true;
/*  84 */       Game.dummy = false;
/*  85 */       Game.sound = true;
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


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.1.0_1.jar!\com\emgartley\beyondOrigins\files\Load.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */