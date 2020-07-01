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
/*  16 */   public static File save1 = new File(Game.save1Path), save2 = new File(
/*  17 */       Game.save2Path);
/*     */   
/*  17 */   public static File save3 = new File(Game.save3Path), data = new File(
/*  18 */       Game.dataPath);
/*     */   
/*  18 */   public static File keys = new File(Game.keysPath);
/*     */   
/*     */   public static boolean canMakeNewGame = true;
/*     */   
/*  22 */   public static String save1LastPlayed = "", save2LastPlayed = "";
/*     */   
/*  23 */   public static String save3LastPlayed = "";
/*     */   
/*  24 */   public static String save1Made = "";
/*     */   
/*  24 */   public static String save2Made = "";
/*     */   
/*  24 */   public static String save3Made = "";
/*     */   
/*  26 */   public static int autoSaveTime = 180000;
/*     */   
/*  27 */   private static long lastTime = System.currentTimeMillis() - autoSaveTime;
/*     */   
/*     */   public static FileWriter fw;
/*     */   
/*     */   public static FileWriter fwData;
/*     */   
/*     */   public static FileWriter fwKeys;
/*     */   
/*     */   public static void tick() {
/*  32 */     if (Game.autoSave) {
/*  33 */       long thisTime = System.currentTimeMillis();
/*  34 */       if (thisTime - lastTime >= autoSaveTime) {
/*  35 */         lastTime = thisTime;
/*  36 */         autoSave();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void autoSave() {
/*     */     try {
/*  43 */       if ((Game.getMainMenu()).currentProfile == 1) {
/*  44 */         profileSave(save1, Game.save1Path, 1);
/*  45 */       } else if ((Game.getMainMenu()).currentProfile == 2) {
/*  46 */         profileSave(save2, Game.save2Path, 2);
/*  47 */       } else if ((Game.getMainMenu()).currentProfile == 3) {
/*  48 */         profileSave(save3, Game.save3Path, 3);
/*     */       } 
/*  50 */     } catch (IOException e) {
/*  51 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void profileReset() {
/*  56 */     (Game.getPlayer()).x = 129;
/*  57 */     (Game.getPlayer()).y = 197;
/*  58 */     (Game.getPlayer()).mapX = 400;
/*  59 */     (Game.getPlayer()).mapY = 256;
/*  60 */     (Game.getPlayer()).mapMovement = true;
/*  61 */     (Game.getPlayer()).insideMovement = false;
/*  62 */     (Game.getPlayer()).health = 50.0D;
/*  63 */     (Game.getPlayer()).exp = 0;
/*  64 */     (Game.getPlayer()).level = 1;
/*  66 */     (Game.getPlayer()).lastDir = 3;
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
/*     */   }
/*     */   
/*     */   public static void dataReset() {
/* 128 */     save1LastPlayed = "";
/* 129 */     save1Made = "";
/* 130 */     save2LastPlayed = "";
/* 131 */     save2Made = "";
/* 132 */     save3LastPlayed = "";
/* 133 */     save3Made = "";
/* 134 */     (Game.getMainMenu()).save1Name = "IfYouSeeThisSomethingIsWrong";
/* 135 */     (Game.getMainMenu()).save2Name = "IfYouSeeThisSomethingIsWrong";
/* 136 */     (Game.getMainMenu()).save3Name = "IfYouSeeThisSomethingIsWrong";
/* 137 */     (Game.getMainMenu()).save1Name_backup = "";
/* 138 */     (Game.getMainMenu()).save2Name_backup = "";
/* 139 */     (Game.getMainMenu()).save3Name_backup = "";
/* 140 */     Options.autoSaveToggle = "On";
/* 141 */     Options.tdToggle = "Off";
/* 142 */     Options o = new Options();
/*     */   }
/*     */   
/*     */   public static void dataSave() throws IOException {
/* 146 */     if (!data.exists()) {
/* 147 */       fwData = new FileWriter(Game.dataPath);
/* 148 */     } else if (data.exists()) {
/* 149 */       data.delete();
/* 150 */       fwData = new FileWriter(Game.dataPath);
/*     */     } 
/* 153 */     PrintWriter pw1 = new PrintWriter(fwData);
/* 155 */     pw1.println(save1LastPlayed);
/* 156 */     pw1.println(save1Made);
/* 157 */     pw1.println(save2LastPlayed);
/* 158 */     pw1.println(save2Made);
/* 159 */     pw1.println(save3LastPlayed);
/* 160 */     pw1.println(save3Made);
/* 161 */     pw1.println((Game.getMainMenu()).save1Name);
/* 162 */     pw1.println((Game.getMainMenu()).save2Name);
/* 163 */     pw1.println((Game.getMainMenu()).save3Name);
/* 164 */     pw1.println((Game.getMainMenu()).save1Name_backup);
/* 165 */     pw1.println((Game.getMainMenu()).save2Name_backup);
/* 166 */     pw1.println((Game.getMainMenu()).save3Name_backup);
/* 167 */     pw1.println(Game.autoSave);
/* 168 */     pw1.println(Game.dummy);
/* 170 */     pw1.close();
/*     */   }
/*     */   
/*     */   public static void keysSave() throws IOException {
/* 174 */     if (!keys.exists()) {
/* 175 */       fwKeys = new FileWriter(Game.keysPath);
/* 176 */     } else if (keys.exists()) {
/* 177 */       keys.delete();
/* 178 */       fwKeys = new FileWriter(Game.keysPath);
/*     */     } 
/* 180 */     PrintWriter pw = new PrintWriter(fwKeys);
/* 181 */     pw.println(Keys.invToggle);
/* 182 */     pw.println(Keys.up);
/* 183 */     pw.println(Keys.down);
/* 184 */     pw.println(Keys.left);
/* 185 */     pw.println(Keys.right);
/* 186 */     pw.println(Keys.attack);
/* 187 */     pw.println(Keys.block);
/* 188 */     pw.println(Keys.sprint);
/* 189 */     pw.close();
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.8_0.jar!\beyondOrigins\files\Save.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */