/*     */ package com.emgartley.beyondOrigins.files;
/*     */ 
/*     */ import com.emgartley.beyondOrigins.main.Game;
/*     */ import com.emgartley.beyondOrigins.main.Profile1;
/*     */ import com.emgartley.beyondOrigins.main.Profile2;
/*     */ import com.emgartley.beyondOrigins.main.Profile3;
/*     */ import com.emgartley.beyondOrigins.main.menus.Options;
/*     */ import com.emgartley.beyondOrigins.main.windows.Keys;
/*     */ import java.io.File;
/*     */ import java.io.FileWriter;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintWriter;
/*     */ 
/*     */ public class Save {
/*  11 */   public static File data = new File(Game.dataPath);
/*     */   
/*  11 */   public static File keys = new File(
/*  12 */       Game.keysPath);
/*     */   
/*     */   public static boolean canMakeNewGame = true;
/*     */   
/*  16 */   public static String save1LastPlayed = "", save2LastPlayed = "";
/*     */   
/*  17 */   public static String save3LastPlayed = "";
/*     */   
/*  18 */   public static String save1Made = "";
/*     */   
/*  18 */   public static String save2Made = "";
/*     */   
/*  18 */   public static String save3Made = "";
/*     */   
/*  20 */   public static int autoSaveTime = 150000;
/*     */   
/*  21 */   private static long lastTime = System.currentTimeMillis() - autoSaveTime;
/*     */   
/*     */   public static FileWriter fw;
/*     */   
/*     */   public static FileWriter fwData;
/*     */   
/*     */   public static FileWriter fwKeys;
/*     */   
/*  24 */   static Encrypter en = new Encrypter();
/*     */   
/*     */   public static void tick() {
/*  27 */     if (Game.autoSave) {
/*  28 */       long thisTime = System.currentTimeMillis();
/*  29 */       if (thisTime - lastTime >= autoSaveTime) {
/*  30 */         lastTime = thisTime;
/*  31 */         autoSave();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void autoSave() {
/*     */     try {
/*  38 */       int cp = (Game.getMainMenu()).currentProfile;
/*  39 */       if (cp == 1) {
/*  40 */         Profile1.save();
/*  41 */       } else if (cp == 2) {
/*  42 */         Profile2.save();
/*  43 */       } else if (cp == 3) {
/*  44 */         Profile3.save();
/*     */       } 
/*  46 */     } catch (IOException e) {
/*  47 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void profileReset() {
/*  52 */     (Game.getPlayer()).x = 129;
/*  53 */     (Game.getPlayer()).y = 197;
/*  54 */     (Game.getMap()).x = 0;
/*  55 */     (Game.getMap()).y = 0;
/*  56 */     (Game.getPlayer()).mapMovement = true;
/*  57 */     (Game.getPlayer()).insideMovement = false;
/*  58 */     (Game.getPlayer()).health = 50.0D;
/*  59 */     (Game.getPlayer()).exp = 0;
/*  60 */     (Game.getPlayer()).level = 1;
/*  62 */     (Game.getPlayer()).lastDir = 3;
/*  63 */     Game.logger.log("Profile has been reset");
/*     */   }
/*     */   
/*     */   public static void dataReset() {
/*  68 */     Profile1.lastPlayed = "";
/*  69 */     Profile1.made = "";
/*  70 */     Profile2.lastPlayed = "";
/*  71 */     Profile2.made = "";
/*  72 */     Profile3.lastPlayed = "";
/*  73 */     Profile3.made = "";
/*  74 */     Profile1.name = "IfYouSeeThisSomethingIsWrong";
/*  75 */     Profile2.name = "IfYouSeeThisSomethingIsWrong";
/*  76 */     Profile3.name = "IfYouSeeThisSomethingIsWrong";
/*  77 */     Profile1.backup_name = "";
/*  78 */     Profile2.backup_name = "";
/*  79 */     Profile3.backup_name = "";
/*  80 */     Options.autoSaveToggle = "On";
/*  81 */     Options.tdToggle = "Off";
/*  82 */     Options.soundToggle = "On";
/*  83 */     Options o = new Options();
/*  84 */     Game.logger.log("Data reset");
/*     */   }
/*     */   
/*     */   public static void dataSave() throws IOException {
/*  88 */     if (!data.exists()) {
/*  89 */       fwData = new FileWriter(Game.dataPath);
/*  90 */     } else if (data.exists()) {
/*  91 */       data.delete();
/*  92 */       fwData = new FileWriter(Game.dataPath);
/*     */     } 
/*  95 */     PrintWriter pw = new PrintWriter(fwData);
/*  97 */     pw.println(Profile1.lastPlayed);
/*  98 */     pw.println(Profile1.made);
/*  99 */     pw.println(Profile2.lastPlayed);
/* 100 */     pw.println(Profile2.made);
/* 101 */     pw.println(Profile3.lastPlayed);
/* 102 */     pw.println(Profile3.made);
/* 103 */     pw.println(Profile1.name);
/* 104 */     pw.println(Profile2.name);
/* 105 */     pw.println(Profile3.name);
/* 106 */     pw.println(Profile1.backup_name);
/* 107 */     pw.println(Profile2.backup_name);
/* 108 */     pw.println(Profile3.backup_name);
/* 109 */     pw.println(Game.autoSave);
/* 110 */     pw.println(Game.dummy);
/* 111 */     pw.println(Game.sound);
/* 113 */     pw.close();
/* 114 */     Game.logger.log("Data saved");
/*     */   }
/*     */   
/*     */   public static void keysSave() throws IOException {
/* 118 */     if (!keys.exists()) {
/* 119 */       fwKeys = new FileWriter(Game.keysPath);
/* 120 */     } else if (keys.exists()) {
/* 121 */       keys.delete();
/* 122 */       fwKeys = new FileWriter(Game.keysPath);
/*     */     } 
/* 124 */     PrintWriter pw = new PrintWriter(fwKeys);
/* 125 */     pw.println(Keys.invToggle);
/* 126 */     pw.println(Keys.up);
/* 127 */     pw.println(Keys.down);
/* 128 */     pw.println(Keys.left);
/* 129 */     pw.println(Keys.right);
/* 130 */     pw.println(Keys.attack);
/* 131 */     pw.println(Keys.block);
/* 132 */     pw.println(Keys.sprint);
/* 133 */     pw.close();
/* 134 */     Game.logger.log("Keys saved");
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.1.0_5.jar!\com\emgartley\beyondOrigins\files\Save.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */