/*     */ package beyondOrigins.files;
/*     */ 
/*     */ import beyondOrigins.main.Game;
/*     */ import java.io.File;
/*     */ import java.io.FileWriter;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintWriter;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Calendar;
/*     */ 
/*     */ public class Save {
/*  14 */   public static File save1 = new File(Game.save1Path), save2 = new File(
/*  15 */       Game.save2Path);
/*     */   
/*  15 */   public static File save3 = new File(Game.save3Path);
/*     */   
/*  15 */   public static File data = new File(
/*  16 */       Game.dataPath);
/*     */   
/*     */   public static boolean canMakeNewGame = true;
/*     */   
/*  20 */   public static String save1LastPlayed = "", save2LastPlayed = "";
/*     */   
/*  21 */   public static String save3LastPlayed = "";
/*     */   
/*     */   public static byte save1Progress;
/*     */   
/*     */   public static byte save2Progress;
/*     */   
/*     */   public static byte save3Progress;
/*     */   
/*  23 */   public static String save1Made = "";
/*     */   
/*  23 */   public static String save2Made = "";
/*     */   
/*  23 */   public static String save3Made = "";
/*     */   
/*  25 */   public static int autoSaveTime = 180000;
/*     */   
/*  26 */   private static long lastTime = System.currentTimeMillis() - autoSaveTime;
/*     */   
/*     */   public static FileWriter fw;
/*     */   
/*     */   public static FileWriter fwData;
/*     */   
/*     */   public static void tick() {
/*  31 */     if (Game.autoSave) {
/*  32 */       long thisTime = System.currentTimeMillis();
/*  33 */       if (thisTime - lastTime >= autoSaveTime) {
/*  34 */         lastTime = thisTime;
/*  35 */         autoSave();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void autoSave() {
/*     */     try {
/*  42 */       if ((Game.getMainMenu()).currentProfile == 1) {
/*  43 */         profileSave(save1, Game.save1Path, 1);
/*  44 */       } else if ((Game.getMainMenu()).currentProfile == 2) {
/*  45 */         profileSave(save2, Game.save2Path, 2);
/*  46 */       } else if ((Game.getMainMenu()).currentProfile == 3) {
/*  47 */         profileSave(save3, Game.save3Path, 3);
/*     */       } 
/*  49 */     } catch (IOException e) {
/*  50 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void reset() {
/*  56 */     (Game.getPlayer()).x = Game.playerSpawnX;
/*  57 */     (Game.getPlayer()).y = Game.playerSpawnY;
/*  58 */     (Game.getPlayer()).mapX = 400.0F;
/*  59 */     (Game.getPlayer()).mapY = 256.0F;
/*  60 */     (Game.getPlayer()).mapMovement = true;
/*  61 */     (Game.getPlayer()).insideMovement = false;
/*  64 */     (Game.getPlayer()).lastDir = 3;
/*     */   }
/*     */   
/*     */   public static void profileSave(File save, String path, int currentProfile) throws IOException {
/*  72 */     if (!save.exists()) {
/*  73 */       reset();
/*  74 */       fw = new FileWriter(path);
/*  75 */       if (currentProfile == 1) {
/*  76 */         save1Made = (new SimpleDateFormat("MM-dd-yyyy")).format(
/*  77 */             Calendar.getInstance().getTime());
/*  78 */         save1LastPlayed = (new SimpleDateFormat("MM-dd-yyyy"))
/*  79 */           .format(Calendar.getInstance().getTime());
/*  80 */       } else if (currentProfile == 2) {
/*  81 */         save2Made = (new SimpleDateFormat("MM-dd-yyyy")).format(
/*  82 */             Calendar.getInstance().getTime());
/*  83 */         save2LastPlayed = (new SimpleDateFormat("MM-dd-yyyy"))
/*  84 */           .format(Calendar.getInstance().getTime());
/*  85 */       } else if (currentProfile == 3) {
/*  86 */         save3Made = (new SimpleDateFormat("MM-dd-yyyy")).format(
/*  87 */             Calendar.getInstance().getTime());
/*  88 */         save3LastPlayed = (new SimpleDateFormat("MM-dd-yyyy"))
/*  89 */           .format(Calendar.getInstance().getTime());
/*     */       } 
/*  91 */     } else if (save.exists()) {
/*  92 */       save.delete();
/*  93 */       fw = new FileWriter(path);
/*  94 */       if (currentProfile == 1) {
/*  95 */         save1LastPlayed = (new SimpleDateFormat("MM-dd-yyyy"))
/*  96 */           .format(Calendar.getInstance().getTime());
/*  97 */       } else if (currentProfile == 2) {
/*  98 */         save2LastPlayed = (new SimpleDateFormat("MM-dd-yyyy"))
/*  99 */           .format(Calendar.getInstance().getTime());
/* 100 */       } else if (currentProfile == 3) {
/* 101 */         save3LastPlayed = (new SimpleDateFormat("MM-dd-yyyy"))
/* 102 */           .format(Calendar.getInstance().getTime());
/*     */       } 
/*     */     } 
/* 105 */     dataSave();
/* 108 */     PrintWriter pw1 = new PrintWriter(fw);
/* 111 */     pw1.println((Game.getPlayer()).name);
/* 112 */     pw1.println((Game.getPlayer()).x);
/* 113 */     pw1.println((Game.getPlayer()).y);
/* 114 */     pw1.println((Game.getPlayer()).mapX);
/* 115 */     pw1.println((Game.getPlayer()).mapY);
/* 116 */     pw1.println((Game.getPlayer()).mapMovement);
/* 117 */     pw1.println((Game.getPlayer()).insideMovement);
/* 118 */     pw1.println((Game.getPlayer()).health);
/* 119 */     pw1.println((Game.getPlayer()).exp);
/* 120 */     pw1.println((Game.getPlayer()).level);
/* 121 */     pw1.println((Game.getPlayer()).untilNextLvl);
/* 124 */     pw1.close();
/*     */   }
/*     */   
/*     */   public static void dataSave() throws IOException {
/* 129 */     if (!data.exists()) {
/* 130 */       fwData = new FileWriter(Game.dataPath);
/* 131 */     } else if (data.exists()) {
/* 132 */       data.delete();
/* 133 */       fwData = new FileWriter(Game.dataPath);
/*     */     } 
/* 137 */     PrintWriter pw1 = new PrintWriter(fwData);
/* 140 */     pw1.println(save1LastPlayed);
/* 141 */     pw1.println(save1Made);
/* 142 */     pw1.println(save2LastPlayed);
/* 143 */     pw1.println(save2Made);
/* 144 */     pw1.println(save3LastPlayed);
/* 145 */     pw1.println(save3Made);
/* 146 */     pw1.println((Game.getMainMenu()).save1Name);
/* 147 */     pw1.println((Game.getMainMenu()).save2Name);
/* 148 */     pw1.println((Game.getMainMenu()).save3Name);
/* 149 */     pw1.println((Game.getMainMenu()).save1Name_backup);
/* 150 */     pw1.println((Game.getMainMenu()).save2Name_backup);
/* 151 */     pw1.println((Game.getMainMenu()).save3Name_backup);
/* 152 */     pw1.println(Game.autoSave);
/* 153 */     pw1.println(Game.dummy);
/* 156 */     pw1.close();
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.6_4.jar!\beyondOrigins\files\Save.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */