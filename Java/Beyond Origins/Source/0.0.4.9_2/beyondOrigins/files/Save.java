/*     */ package beyondOrigins.files;
/*     */ 
/*     */ import beyondOrigins.main.Game;
/*     */ import beyondOrigins.main.buildings.shop.Shop;
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
/*  17 */   public static File save1 = new File(Game.save1Path), save2 = new File(
/*  18 */       Game.save2Path);
/*     */   
/*  18 */   public static File save3 = new File(Game.save3Path);
/*     */   
/*  18 */   public static File data = new File(
/*  19 */       Game.dataPath);
/*     */   
/*     */   public static boolean canMakeNewGame = true;
/*     */   
/*  23 */   public static String save1LastPlayed = "", save2LastPlayed = "";
/*     */   
/*  24 */   public static String save3LastPlayed = "";
/*     */   
/*     */   public static int save1Progress;
/*     */   
/*     */   public static int save2Progress;
/*     */   
/*     */   public static int save3Progress;
/*     */   
/*  26 */   public static String save1Made = "";
/*     */   
/*  26 */   public static String save2Made = "";
/*     */   
/*  26 */   public static String save3Made = "";
/*     */   
/*  28 */   public static int autoSaveTime = 180000;
/*     */   
/*     */   public static FileWriter fw;
/*     */   
/*     */   public static FileWriter fwData;
/*     */   
/*     */   public static void autoSave(long lastTime) {
/*     */     try {
/*  34 */       System.out.println("Autosaving...");
/*  35 */       if (MainMenu.currentProfile == 1) {
/*  36 */         profileSave(save1, Game.save1Path, 1);
/*  37 */       } else if (MainMenu.currentProfile == 2) {
/*  38 */         profileSave(save2, Game.save2Path, 2);
/*  39 */       } else if (MainMenu.currentProfile == 3) {
/*  40 */         profileSave(save3, Game.save3Path, 3);
/*     */       } 
/*  42 */       System.out.println("Autosave Complete!");
/*  43 */     } catch (IOException e) {
/*  44 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void reset() {
/*  50 */     Player.playerX = 398.0F;
/*  51 */     Player.playerY = 263.0F;
/*  52 */     Player.mapX = 398.0F;
/*  53 */     Player.mapY = 263.0F;
/*  54 */     Player.mapMovement = true;
/*  55 */     Player.insideMovement = false;
/*  56 */     Shop.isInside = false;
/*  57 */     Shop.enter = 0;
/*  58 */     Shop.exit = 0;
/*  59 */     Shop.overlay = 0;
/*  62 */     Player.lastDir = 3;
/*     */   }
/*     */   
/*     */   public static void profileSave(File save, String path, int currentProfile) throws IOException {
/*  70 */     if (!save.exists()) {
/*  71 */       fw = new FileWriter(path);
/*  72 */       if (currentProfile == 1) {
/*  73 */         save1Made = (new SimpleDateFormat("MM-dd-yyyy")).format(
/*  74 */             Calendar.getInstance().getTime());
/*  75 */         save1LastPlayed = (new SimpleDateFormat("MM-dd-yyyy"))
/*  76 */           .format(Calendar.getInstance().getTime());
/*  77 */       } else if (currentProfile == 2) {
/*  78 */         save2Made = (new SimpleDateFormat("MM-dd-yyyy")).format(
/*  79 */             Calendar.getInstance().getTime());
/*  80 */         save2LastPlayed = (new SimpleDateFormat("MM-dd-yyyy"))
/*  81 */           .format(Calendar.getInstance().getTime());
/*  82 */       } else if (currentProfile == 3) {
/*  83 */         save3Made = (new SimpleDateFormat("MM-dd-yyyy")).format(
/*  84 */             Calendar.getInstance().getTime());
/*  85 */         save3LastPlayed = (new SimpleDateFormat("MM-dd-yyyy"))
/*  86 */           .format(Calendar.getInstance().getTime());
/*     */       } 
/*  88 */     } else if (save.exists()) {
/*  89 */       save.delete();
/*  90 */       fw = new FileWriter(path);
/*  91 */       if (currentProfile == 1) {
/*  92 */         save1LastPlayed = (new SimpleDateFormat("MM-dd-yyyy"))
/*  93 */           .format(Calendar.getInstance().getTime());
/*  94 */       } else if (currentProfile == 2) {
/*  95 */         save2LastPlayed = (new SimpleDateFormat("MM-dd-yyyy"))
/*  96 */           .format(Calendar.getInstance().getTime());
/*  97 */       } else if (currentProfile == 3) {
/*  98 */         save3LastPlayed = (new SimpleDateFormat("MM-dd-yyyy"))
/*  99 */           .format(Calendar.getInstance().getTime());
/*     */       } 
/*     */     } 
/* 102 */     dataSave();
/* 105 */     PrintWriter pw1 = new PrintWriter(fw);
/* 108 */     pw1.println(Player.playerX);
/* 109 */     pw1.println(Player.playerY);
/* 110 */     pw1.println(Player.mapX);
/* 111 */     pw1.println(Player.mapY);
/* 112 */     pw1.println(Player.mapMovement);
/* 113 */     pw1.println(Player.insideMovement);
/* 114 */     pw1.println(Shop.isInside);
/* 115 */     pw1.println(Shop.enter);
/* 116 */     pw1.println(Shop.exit);
/* 117 */     pw1.println(Shop.overlay);
/* 120 */     pw1.close();
/*     */   }
/*     */   
/*     */   public static void dataSave() throws IOException {
/* 125 */     if (!data.exists()) {
/* 126 */       fwData = new FileWriter(Game.dataPath);
/* 127 */     } else if (data.exists()) {
/* 128 */       data.delete();
/* 129 */       fwData = new FileWriter(Game.dataPath);
/*     */     } 
/* 133 */     PrintWriter pw1 = new PrintWriter(fwData);
/* 136 */     pw1.println(save1LastPlayed);
/* 137 */     pw1.println(save1Made);
/* 138 */     pw1.println(save2LastPlayed);
/* 139 */     pw1.println(save2Made);
/* 140 */     pw1.println(save3LastPlayed);
/* 141 */     pw1.println(save3Made);
/* 142 */     pw1.println(Game.autoSave);
/* 145 */     pw1.close();
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4.9_2.jar!\beyondOrigins\files\Save.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */