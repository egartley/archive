/*     */ package beyondOrigins.files;
/*     */ 
/*     */ import beyondOrigins.main.Game;
/*     */ import beyondOrigins.main.entities.Player;
/*     */ import beyondOrigins.main.menus.MainMenu;
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
/*  17 */   public static File save3 = new File(Game.save3Path);
/*     */   
/*  17 */   public static File data = new File(
/*  18 */       Game.dataPath);
/*     */   
/*     */   public static boolean canMakeNewGame = true;
/*     */   
/*  22 */   public static String save1LastPlayed = "", save2LastPlayed = "";
/*     */   
/*  23 */   public static String save3LastPlayed = "";
/*     */   
/*     */   public static byte save1Progress;
/*     */   
/*     */   public static byte save2Progress;
/*     */   
/*     */   public static byte save3Progress;
/*     */   
/*  25 */   public static String save1Made = "";
/*     */   
/*  25 */   public static String save2Made = "";
/*     */   
/*  25 */   public static String save3Made = "";
/*     */   
/*  27 */   public static int autoSaveTime = 180000;
/*     */   
/*  28 */   private static long lastTime = System.currentTimeMillis() - autoSaveTime;
/*     */   
/*     */   public static FileWriter fw;
/*     */   
/*     */   public static FileWriter fwData;
/*     */   
/*     */   public static void tick() {
/*  33 */     if (Game.autoSave) {
/*  34 */       long thisTime = System.currentTimeMillis();
/*  35 */       if (thisTime - lastTime >= autoSaveTime) {
/*  36 */         lastTime = thisTime;
/*  37 */         autoSave();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void autoSave() {
/*     */     try {
/*  44 */       if (MainMenu.currentProfile == 1) {
/*  45 */         profileSave(save1, Game.save1Path, 1);
/*  46 */       } else if (MainMenu.currentProfile == 2) {
/*  47 */         profileSave(save2, Game.save2Path, 2);
/*  48 */       } else if (MainMenu.currentProfile == 3) {
/*  49 */         profileSave(save3, Game.save3Path, 3);
/*     */       } 
/*  51 */     } catch (IOException e) {
/*  52 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void reset() {
/*  58 */     Player.x = Game.playerSpawnX;
/*  59 */     Player.y = Game.playerSpawnY;
/*  60 */     Player.mapX = Game.playerSpawnX;
/*  61 */     Player.mapY = Game.playerSpawnY;
/*  62 */     Player.mapMovement = true;
/*  63 */     Player.insideMovement = false;
/*  66 */     Player.lastDir = 3;
/*     */   }
/*     */   
/*     */   public static void profileSave(File save, String path, int currentProfile) throws IOException {
/*  74 */     if (!save.exists()) {
/*  75 */       reset();
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
/* 113 */     pw1.println(Player.name);
/* 114 */     pw1.println(Player.x);
/* 115 */     pw1.println(Player.y);
/* 116 */     pw1.println(Player.mapX);
/* 117 */     pw1.println(Player.mapY);
/* 118 */     pw1.println(Player.mapMovement);
/* 119 */     pw1.println(Player.insideMovement);
/* 120 */     pw1.println(Player.health);
/* 123 */     pw1.close();
/*     */   }
/*     */   
/*     */   public static void dataSave() throws IOException {
/* 128 */     if (!data.exists()) {
/* 129 */       fwData = new FileWriter(Game.dataPath);
/* 130 */     } else if (data.exists()) {
/* 131 */       data.delete();
/* 132 */       fwData = new FileWriter(Game.dataPath);
/*     */     } 
/* 136 */     PrintWriter pw1 = new PrintWriter(fwData);
/* 139 */     pw1.println(save1LastPlayed);
/* 140 */     pw1.println(save1Made);
/* 141 */     pw1.println(save2LastPlayed);
/* 142 */     pw1.println(save2Made);
/* 143 */     pw1.println(save3LastPlayed);
/* 144 */     pw1.println(save3Made);
/* 145 */     pw1.println(MainMenu.save1Name);
/* 146 */     pw1.println(MainMenu.save2Name);
/* 147 */     pw1.println(MainMenu.save3Name);
/* 148 */     pw1.println(MainMenu.save1Name_backup);
/* 149 */     pw1.println(MainMenu.save2Name_backup);
/* 150 */     pw1.println(MainMenu.save3Name_backup);
/* 151 */     pw1.println(Game.autoSave);
/* 152 */     pw1.println(Game.dummy);
/* 155 */     pw1.close();
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_6.jar!\beyondOrigins\files\Save.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */