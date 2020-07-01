/*     */ package beyondOrigins.files;
/*     */ 
/*     */ import beyondOrigins.main.Game;
/*     */ import beyondOrigins.main.menus.Options;
/*     */ import beyondOrigins.main.windows.Keys;
/*     */ import java.io.File;
/*     */ import java.io.FileWriter;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintWriter;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Calendar;
/*     */ 
/*     */ public class Save {
/*  13 */   public static File save1 = new File(Game.save1Path), save2 = new File(
/*  14 */       Game.save2Path);
/*     */   
/*  14 */   public static File save3 = new File(Game.save3Path), data = new File(
/*  15 */       Game.dataPath);
/*     */   
/*  15 */   public static File keys = new File(Game.keysPath);
/*     */   
/*     */   public static boolean canMakeNewGame = true;
/*     */   
/*  19 */   public static String save1LastPlayed = "", save2LastPlayed = "";
/*     */   
/*  20 */   public static String save3LastPlayed = "";
/*     */   
/*  21 */   public static String save1Made = "";
/*     */   
/*  21 */   public static String save2Made = "";
/*     */   
/*  21 */   public static String save3Made = "";
/*     */   
/*  23 */   public static int autoSaveTime = 150000;
/*     */   
/*  24 */   private static long lastTime = System.currentTimeMillis() - autoSaveTime;
/*     */   
/*     */   public static FileWriter fw;
/*     */   
/*     */   public static FileWriter fwData;
/*     */   
/*     */   public static FileWriter fwKeys;
/*     */   
/*  27 */   static Encrypter en = new Encrypter();
/*     */   
/*     */   public static void tick() {
/*  30 */     if (Game.autoSave) {
/*  31 */       long thisTime = System.currentTimeMillis();
/*  32 */       if (thisTime - lastTime >= autoSaveTime) {
/*  33 */         lastTime = thisTime;
/*  34 */         autoSave();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void autoSave() {
/*     */     try {
/*  41 */       if ((Game.getMainMenu()).currentProfile == 1) {
/*  42 */         profileSave(save1, Game.save1Path, 1);
/*  43 */       } else if ((Game.getMainMenu()).currentProfile == 2) {
/*  44 */         profileSave(save2, Game.save2Path, 2);
/*  45 */       } else if ((Game.getMainMenu()).currentProfile == 3) {
/*  46 */         profileSave(save3, Game.save3Path, 3);
/*     */       } 
/*  48 */     } catch (IOException e) {
/*  49 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void profileReset() {
/*  55 */     (Game.getPlayer()).x = 129;
/*  56 */     (Game.getPlayer()).y = 197;
/*  57 */     (Game.getPlayer()).mapX = 400;
/*  58 */     (Game.getPlayer()).mapY = 256;
/*  59 */     (Game.getPlayer()).mapMovement = true;
/*  60 */     (Game.getPlayer()).insideMovement = false;
/*  61 */     (Game.getPlayer()).health = 50.0D;
/*  62 */     (Game.getPlayer()).exp = 0;
/*  63 */     (Game.getPlayer()).level = 1;
/*  65 */     (Game.getPlayer()).lastDir = 3;
/*  66 */     Game.logger.log("Profile has been ");
/*     */   }
/*     */   
/*     */   public static void profileSave(File save, String path, int currentProfile) throws IOException {
/*  73 */     if (!save.exists()) {
/*  74 */       profileReset();
/*  75 */       fw = new FileWriter(path);
/*  76 */       if (currentProfile == 1) {
/*  77 */         save1Made = (new SimpleDateFormat("MM-dd-yyyy")).format(
/*  78 */             Calendar.getInstance().getTime());
/*  79 */         save1LastPlayed = (new SimpleDateFormat("MM-dd-yyyy"))
/*  80 */           .format(Calendar.getInstance().getTime());
/*  81 */       } else if (currentProfile == 2) {
/*  82 */         save2Made = (new SimpleDateFormat("MM-dd-yyyy")).format(
/*  83 */             Calendar.getInstance().getTime());
/*  84 */         save2LastPlayed = (new SimpleDateFormat("MM-dd-yyyy"))
/*  85 */           .format(Calendar.getInstance().getTime());
/*  86 */       } else if (currentProfile == 3) {
/*  87 */         save3Made = (new SimpleDateFormat("MM-dd-yyyy")).format(
/*  88 */             Calendar.getInstance().getTime());
/*  89 */         save3LastPlayed = (new SimpleDateFormat("MM-dd-yyyy"))
/*  90 */           .format(Calendar.getInstance().getTime());
/*     */       } 
/*  92 */     } else if (save.exists()) {
/*  93 */       save.delete();
/*  94 */       fw = new FileWriter(path);
/*  95 */       if (currentProfile == 1) {
/*  96 */         save1LastPlayed = (new SimpleDateFormat("MM-dd-yyyy"))
/*  97 */           .format(Calendar.getInstance().getTime());
/*  98 */       } else if (currentProfile == 2) {
/*  99 */         save2LastPlayed = (new SimpleDateFormat("MM-dd-yyyy"))
/* 100 */           .format(Calendar.getInstance().getTime());
/* 101 */       } else if (currentProfile == 3) {
/* 102 */         save3LastPlayed = (new SimpleDateFormat("MM-dd-yyyy"))
/* 103 */           .format(Calendar.getInstance().getTime());
/*     */       } 
/*     */     } 
/* 106 */     dataSave();
/* 109 */     PrintWriter pw1 = new PrintWriter(fw);
/* 112 */     pw1.println((Game.getPlayer()).name);
/* 113 */     pw1.println((Game.getPlayer()).x);
/* 114 */     pw1.println((Game.getPlayer()).y);
/* 115 */     pw1.println((Game.getPlayer()).mapX);
/* 116 */     pw1.println((Game.getPlayer()).mapY);
/* 117 */     pw1.println((Game.getPlayer()).mapMovement);
/* 118 */     pw1.println((Game.getPlayer()).insideMovement);
/* 119 */     pw1.println((Game.getPlayer()).health);
/* 120 */     pw1.println((Game.getPlayer()).exp);
/* 121 */     pw1.println((Game.getPlayer()).level);
/* 124 */     pw1.close();
/*     */     try {
/* 127 */       en.encrypt(Game.getSaveKey(currentProfile), save, save);
/* 128 */     } catch (Exception e) {
/* 129 */       e.printStackTrace();
/*     */     } 
/* 132 */     Game.logger.log("Profile " + currentProfile + " saved");
/*     */   }
/*     */   
/*     */   public static void dataReset() {
/* 137 */     save1LastPlayed = "";
/* 138 */     save1Made = "";
/* 139 */     save2LastPlayed = "";
/* 140 */     save2Made = "";
/* 141 */     save3LastPlayed = "";
/* 142 */     save3Made = "";
/* 143 */     (Game.getMainMenu()).save1Name = "IfYouSeeThisSomethingIsWrong";
/* 144 */     (Game.getMainMenu()).save2Name = "IfYouSeeThisSomethingIsWrong";
/* 145 */     (Game.getMainMenu()).save3Name = "IfYouSeeThisSomethingIsWrong";
/* 146 */     (Game.getMainMenu()).save1Name_backup = "";
/* 147 */     (Game.getMainMenu()).save2Name_backup = "";
/* 148 */     (Game.getMainMenu()).save3Name_backup = "";
/* 149 */     Options.autoSaveToggle = "On";
/* 150 */     Options.tdToggle = "Off";
/* 151 */     Options o = new Options();
/* 152 */     Game.logger.log("Data reset");
/*     */   }
/*     */   
/*     */   public static void dataSave() throws IOException {
/* 156 */     if (!data.exists()) {
/* 157 */       fwData = new FileWriter(Game.dataPath);
/* 158 */     } else if (data.exists()) {
/* 159 */       data.delete();
/* 160 */       fwData = new FileWriter(Game.dataPath);
/*     */     } 
/* 163 */     PrintWriter pw1 = new PrintWriter(fwData);
/* 165 */     pw1.println(save1LastPlayed);
/* 166 */     pw1.println(save1Made);
/* 167 */     pw1.println(save2LastPlayed);
/* 168 */     pw1.println(save2Made);
/* 169 */     pw1.println(save3LastPlayed);
/* 170 */     pw1.println(save3Made);
/* 171 */     pw1.println((Game.getMainMenu()).save1Name);
/* 172 */     pw1.println((Game.getMainMenu()).save2Name);
/* 173 */     pw1.println((Game.getMainMenu()).save3Name);
/* 174 */     pw1.println((Game.getMainMenu()).save1Name_backup);
/* 175 */     pw1.println((Game.getMainMenu()).save2Name_backup);
/* 176 */     pw1.println((Game.getMainMenu()).save3Name_backup);
/* 177 */     pw1.println(Game.autoSave);
/* 178 */     pw1.println(Game.dummy);
/* 180 */     pw1.close();
/* 181 */     Game.logger.log("Data saved");
/*     */   }
/*     */   
/*     */   public static void keysSave() throws IOException {
/* 185 */     if (!keys.exists()) {
/* 186 */       fwKeys = new FileWriter(Game.keysPath);
/* 187 */     } else if (keys.exists()) {
/* 188 */       keys.delete();
/* 189 */       fwKeys = new FileWriter(Game.keysPath);
/*     */     } 
/* 191 */     PrintWriter pw = new PrintWriter(fwKeys);
/* 192 */     pw.println(Keys.invToggle);
/* 193 */     pw.println(Keys.up);
/* 194 */     pw.println(Keys.down);
/* 195 */     pw.println(Keys.left);
/* 196 */     pw.println(Keys.right);
/* 197 */     pw.println(Keys.attack);
/* 198 */     pw.println(Keys.block);
/* 199 */     pw.println(Keys.sprint);
/* 200 */     pw.close();
/* 201 */     Game.logger.log("Keys saved");
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.9_1.jar!\beyondOrigins\files\Save.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */