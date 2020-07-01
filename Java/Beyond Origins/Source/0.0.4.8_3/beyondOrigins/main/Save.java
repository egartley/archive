/*     */ package beyondOrigins.main;
/*     */ 
/*     */ import beyondOrigins.main.buildings.shop.Shop;
/*     */ import beyondOrigins.main.entities.Player;
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
/*     */   public static int save1Progress;
/*     */   
/*     */   public static int save2Progress;
/*     */   
/*     */   public static int save3Progress;
/*     */   
/*  25 */   public static String save1Made = "";
/*     */   
/*  25 */   public static String save2Made = "";
/*     */   
/*  25 */   public static String save3Made = "";
/*     */   
/*     */   public static FileWriter fw;
/*     */   
/*     */   public static FileWriter fwData;
/*     */   
/*     */   public static void reset() {
/*  31 */     Player.playerX = 398.0F;
/*  32 */     Player.playerY = 263.0F;
/*  33 */     Player.mapX = 398.0F;
/*  34 */     Player.mapY = 263.0F;
/*  35 */     Player.mapMovement = true;
/*  36 */     Player.insideMovement = false;
/*  37 */     Shop.isInside = false;
/*  38 */     Shop.enter = 0;
/*  39 */     Shop.exit = 0;
/*  40 */     Shop.overlay = 0;
/*  43 */     Player.lastDir = 3;
/*     */   }
/*     */   
/*     */   public static void profileSave(File save, String path, int currentProfile) throws IOException {
/*  50 */     if (!save.exists()) {
/*  51 */       fw = new FileWriter(path);
/*  52 */       if (currentProfile == 1) {
/*  53 */         save1Made = (new SimpleDateFormat("MM-dd-yyyy")).format(
/*  54 */             Calendar.getInstance().getTime());
/*  55 */         save1LastPlayed = (new SimpleDateFormat("MM-dd-yyyy"))
/*  56 */           .format(Calendar.getInstance().getTime());
/*  57 */       } else if (currentProfile == 2) {
/*  58 */         save2Made = (new SimpleDateFormat("MM-dd-yyyy")).format(
/*  59 */             Calendar.getInstance().getTime());
/*  60 */         save2LastPlayed = (new SimpleDateFormat("MM-dd-yyyy"))
/*  61 */           .format(Calendar.getInstance().getTime());
/*  62 */       } else if (currentProfile == 3) {
/*  63 */         save3Made = (new SimpleDateFormat("MM-dd-yyyy")).format(
/*  64 */             Calendar.getInstance().getTime());
/*  65 */         save3LastPlayed = (new SimpleDateFormat("MM-dd-yyyy"))
/*  66 */           .format(Calendar.getInstance().getTime());
/*     */       } 
/*  68 */     } else if (save.exists()) {
/*  69 */       save.delete();
/*  70 */       fw = new FileWriter(path);
/*  71 */       if (currentProfile == 1) {
/*  72 */         save1LastPlayed = (new SimpleDateFormat("MM-dd-yyyy"))
/*  73 */           .format(Calendar.getInstance().getTime());
/*  74 */       } else if (currentProfile == 2) {
/*  75 */         save2LastPlayed = (new SimpleDateFormat("MM-dd-yyyy"))
/*  76 */           .format(Calendar.getInstance().getTime());
/*  77 */       } else if (currentProfile == 3) {
/*  78 */         save3LastPlayed = (new SimpleDateFormat("MM-dd-yyyy"))
/*  79 */           .format(Calendar.getInstance().getTime());
/*     */       } 
/*     */     } 
/*  82 */     dataSave();
/*  85 */     PrintWriter pw1 = new PrintWriter(fw);
/*  88 */     pw1.println(Player.playerX);
/*  89 */     pw1.println(Player.playerY);
/*  90 */     pw1.println(Player.mapX);
/*  91 */     pw1.println(Player.mapY);
/*  92 */     pw1.println(Player.mapMovement);
/*  93 */     pw1.println(Player.insideMovement);
/*  94 */     pw1.println(Shop.isInside);
/*  95 */     pw1.println(Shop.enter);
/*  96 */     pw1.println(Shop.exit);
/*  97 */     pw1.println(Shop.overlay);
/* 100 */     pw1.close();
/*     */   }
/*     */   
/*     */   public static void dataSave() throws IOException {
/* 105 */     if (!data.exists()) {
/* 106 */       fwData = new FileWriter(Game.dataPath);
/* 107 */     } else if (data.exists()) {
/* 108 */       data.delete();
/* 109 */       fwData = new FileWriter(Game.dataPath);
/*     */     } 
/* 113 */     PrintWriter pw1 = new PrintWriter(fwData);
/* 116 */     pw1.println(save1LastPlayed);
/* 117 */     pw1.println(save1Made);
/* 118 */     pw1.println(save2LastPlayed);
/* 119 */     pw1.println(save2Made);
/* 120 */     pw1.println(save3LastPlayed);
/* 121 */     pw1.println(save3Made);
/* 124 */     pw1.close();
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4.8_3.jar!\beyondOrigins\main\Save.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */