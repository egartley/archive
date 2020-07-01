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
/*  26 */   public static int autoSaveTime = 150000;
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
/*  53 */     Game.startNotify(Game.aut);
/*     */   }
/*     */   
/*     */   public static void profileReset() {
/*  57 */     (Game.getPlayer()).x = 129;
/*  58 */     (Game.getPlayer()).y = 197;
/*  59 */     (Game.getPlayer()).mapX = 400;
/*  60 */     (Game.getPlayer()).mapY = 256;
/*  61 */     (Game.getPlayer()).mapMovement = true;
/*  62 */     (Game.getPlayer()).insideMovement = false;
/*  63 */     (Game.getPlayer()).health = 50.0D;
/*  64 */     (Game.getPlayer()).exp = 0;
/*  65 */     (Game.getPlayer()).level = 1;
/*  67 */     (Game.getPlayer()).lastDir = 3;
/*     */   }
/*     */   
/*     */   public static void profileSave(File save, String path, int currentProfile) throws IOException {
/*  74 */     if (!save.exists()) {
/*  75 */       profileReset();
/*  76 */       fw = new FileWriter(path);
/*  77 */       if (currentProfile == 1) {
/*  78 */         save1Made = (new SimpleDateFormat("MM-dd-yyyy")).format(
/*  79 */             Calendar.getInstance().getTime());
/*  80 */         save1LastPlayed = (new SimpleDateFormat("MM-dd-yyyy"))
/*  81 */           .format(Calendar.getInstance().getTime());
/*  82 */       } else if (currentProfile == 2) {
/*  83 */         save2Made = (new SimpleDateFormat("MM-dd-yyyy")).format(
/*  84 */             Calendar.getInstance().getTime());
/*  85 */         save2LastPlayed = (new SimpleDateFormat("MM-dd-yyyy"))
/*  86 */           .format(Calendar.getInstance().getTime());
/*  87 */       } else if (currentProfile == 3) {
/*  88 */         save3Made = (new SimpleDateFormat("MM-dd-yyyy")).format(
/*  89 */             Calendar.getInstance().getTime());
/*  90 */         save3LastPlayed = (new SimpleDateFormat("MM-dd-yyyy"))
/*  91 */           .format(Calendar.getInstance().getTime());
/*     */       } 
/*  93 */     } else if (save.exists()) {
/*  94 */       save.delete();
/*  95 */       fw = new FileWriter(path);
/*  96 */       if (currentProfile == 1) {
/*  97 */         save1LastPlayed = (new SimpleDateFormat("MM-dd-yyyy"))
/*  98 */           .format(Calendar.getInstance().getTime());
/*  99 */       } else if (currentProfile == 2) {
/* 100 */         save2LastPlayed = (new SimpleDateFormat("MM-dd-yyyy"))
/* 101 */           .format(Calendar.getInstance().getTime());
/* 102 */       } else if (currentProfile == 3) {
/* 103 */         save3LastPlayed = (new SimpleDateFormat("MM-dd-yyyy"))
/* 104 */           .format(Calendar.getInstance().getTime());
/*     */       } 
/*     */     } 
/* 107 */     dataSave();
/* 110 */     PrintWriter pw1 = new PrintWriter(fw);
/* 113 */     pw1.println((Game.getPlayer()).name);
/* 114 */     pw1.println((Game.getPlayer()).x);
/* 115 */     pw1.println((Game.getPlayer()).y);
/* 116 */     pw1.println((Game.getPlayer()).mapX);
/* 117 */     pw1.println((Game.getPlayer()).mapY);
/* 118 */     pw1.println((Game.getPlayer()).mapMovement);
/* 119 */     pw1.println((Game.getPlayer()).insideMovement);
/* 120 */     pw1.println((Game.getPlayer()).health);
/* 121 */     pw1.println((Game.getPlayer()).exp);
/* 122 */     pw1.println((Game.getPlayer()).level);
/* 125 */     pw1.close();
/*     */   }
/*     */   
/*     */   public static void dataReset() {
/* 129 */     save1LastPlayed = "";
/* 130 */     save1Made = "";
/* 131 */     save2LastPlayed = "";
/* 132 */     save2Made = "";
/* 133 */     save3LastPlayed = "";
/* 134 */     save3Made = "";
/* 135 */     (Game.getMainMenu()).save1Name = "IfYouSeeThisSomethingIsWrong";
/* 136 */     (Game.getMainMenu()).save2Name = "IfYouSeeThisSomethingIsWrong";
/* 137 */     (Game.getMainMenu()).save3Name = "IfYouSeeThisSomethingIsWrong";
/* 138 */     (Game.getMainMenu()).save1Name_backup = "";
/* 139 */     (Game.getMainMenu()).save2Name_backup = "";
/* 140 */     (Game.getMainMenu()).save3Name_backup = "";
/* 141 */     Options.autoSaveToggle = "On";
/* 142 */     Options.tdToggle = "Off";
/* 143 */     Options o = new Options();
/*     */   }
/*     */   
/*     */   public static void dataSave() throws IOException {
/* 147 */     if (!data.exists()) {
/* 148 */       fwData = new FileWriter(Game.dataPath);
/* 149 */     } else if (data.exists()) {
/* 150 */       data.delete();
/* 151 */       fwData = new FileWriter(Game.dataPath);
/*     */     } 
/* 154 */     PrintWriter pw1 = new PrintWriter(fwData);
/* 156 */     pw1.println(save1LastPlayed);
/* 157 */     pw1.println(save1Made);
/* 158 */     pw1.println(save2LastPlayed);
/* 159 */     pw1.println(save2Made);
/* 160 */     pw1.println(save3LastPlayed);
/* 161 */     pw1.println(save3Made);
/* 162 */     pw1.println((Game.getMainMenu()).save1Name);
/* 163 */     pw1.println((Game.getMainMenu()).save2Name);
/* 164 */     pw1.println((Game.getMainMenu()).save3Name);
/* 165 */     pw1.println((Game.getMainMenu()).save1Name_backup);
/* 166 */     pw1.println((Game.getMainMenu()).save2Name_backup);
/* 167 */     pw1.println((Game.getMainMenu()).save3Name_backup);
/* 168 */     pw1.println(Game.autoSave);
/* 169 */     pw1.println(Game.dummy);
/* 171 */     pw1.close();
/*     */   }
/*     */   
/*     */   public static void keysSave() throws IOException {
/* 175 */     if (!keys.exists()) {
/* 176 */       fwKeys = new FileWriter(Game.keysPath);
/* 177 */     } else if (keys.exists()) {
/* 178 */       keys.delete();
/* 179 */       fwKeys = new FileWriter(Game.keysPath);
/*     */     } 
/* 181 */     PrintWriter pw = new PrintWriter(fwKeys);
/* 182 */     pw.println(Keys.invToggle);
/* 183 */     pw.println(Keys.up);
/* 184 */     pw.println(Keys.down);
/* 185 */     pw.println(Keys.left);
/* 186 */     pw.println(Keys.right);
/* 187 */     pw.println(Keys.attack);
/* 188 */     pw.println(Keys.block);
/* 189 */     pw.println(Keys.sprint);
/* 190 */     pw.close();
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.8_2.jar!\beyondOrigins\files\Save.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */