/*     */ package beyondOrigins.main;
/*     */ 
/*     */ import beyondOrigins.main.buildings.shop.ShopManager;
/*     */ import beyondOrigins.main.entities.Player;
/*     */ import java.io.File;
/*     */ import java.io.FileWriter;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintWriter;
/*     */ 
/*     */ public class Save {
/*  13 */   public static File save1 = new File(Game.save1Path);
/*     */   
/*  13 */   public static File save2 = new File(Game.save2Path);
/*     */   
/*  13 */   public static File save3 = new File(Game.save3Path);
/*     */   
/*     */   public static boolean canMakeNewGame = true;
/*     */   
/*  17 */   public static String save1LastPlayed = null;
/*     */   
/*  17 */   public static String save2LastPlayed = null;
/*     */   
/*  17 */   public static String save3LastPlayed = null;
/*     */   
/*     */   public static int save1Progress;
/*     */   
/*     */   public static int save2Progress;
/*     */   
/*     */   public static int save3Progress;
/*     */   
/*  19 */   public static String save1Made = "";
/*     */   
/*  19 */   public static String save2Made = "";
/*     */   
/*  19 */   public static String save3Made = "";
/*     */   
/*     */   public static FileWriter fw1;
/*     */   
/*     */   public static FileWriter fw2;
/*     */   
/*     */   public static FileWriter fw3;
/*     */   
/*     */   public static void reset() {
/*  25 */     Player.playerX = 398.0F;
/*  26 */     Player.playerY = 263.0F;
/*  27 */     Player.mapX = 398.0F;
/*  28 */     Player.mapY = 263.0F;
/*  29 */     Player.mapMovement = true;
/*  30 */     Player.insideMovement = false;
/*  31 */     ShopManager.isInside = false;
/*  32 */     ShopManager.enter = 0;
/*  33 */     ShopManager.exit = 0;
/*  34 */     ShopManager.overlay = 0;
/*  37 */     Player.lastDir = 3;
/*     */   }
/*     */   
/*     */   public static void save1() throws IOException {
/*  44 */     if (!save1.exists()) {
/*  45 */       fw1 = new FileWriter(Game.save1Path);
/*  46 */     } else if (save1.delete()) {
/*  47 */       fw1 = new FileWriter(Game.save1Path);
/*     */     } 
/*  51 */     PrintWriter pw1 = new PrintWriter(fw1);
/*  54 */     pw1.println(Player.playerX);
/*  55 */     pw1.println(Player.playerY);
/*  56 */     pw1.println(Player.mapX);
/*  57 */     pw1.println(Player.mapY);
/*  58 */     pw1.println(Player.mapMovement);
/*  59 */     pw1.println(Player.insideMovement);
/*  60 */     pw1.println(ShopManager.isInside);
/*  61 */     pw1.println(ShopManager.enter);
/*  62 */     pw1.println(ShopManager.exit);
/*  63 */     pw1.println(ShopManager.overlay);
/*  66 */     pw1.close();
/*     */   }
/*     */   
/*     */   public static void save2() throws IOException {
/*  73 */     if (!save2.exists()) {
/*  74 */       fw2 = new FileWriter(Game.save2Path);
/*  75 */     } else if (save2.delete()) {
/*  76 */       fw2 = new FileWriter(Game.save2Path);
/*     */     } 
/*  80 */     PrintWriter pw2 = new PrintWriter(fw2);
/*  83 */     pw2.println(Player.playerX);
/*  84 */     pw2.println(Player.playerY);
/*  85 */     pw2.println(Player.mapX);
/*  86 */     pw2.println(Player.mapY);
/*  87 */     pw2.println(Player.mapMovement);
/*  88 */     pw2.println(Player.insideMovement);
/*  89 */     pw2.println(ShopManager.isInside);
/*  90 */     pw2.println(ShopManager.enter);
/*  91 */     pw2.println(ShopManager.exit);
/*  92 */     pw2.println(ShopManager.overlay);
/*  95 */     pw2.close();
/*     */   }
/*     */   
/*     */   public static void save3() throws IOException {
/* 102 */     if (!save3.exists()) {
/* 103 */       fw3 = new FileWriter(Game.save3Path);
/* 104 */     } else if (save3.delete()) {
/* 105 */       fw3 = new FileWriter(Game.save3Path);
/*     */     } 
/* 109 */     PrintWriter pw3 = new PrintWriter(fw3);
/* 112 */     pw3.println(Player.playerX);
/* 113 */     pw3.println(Player.playerY);
/* 114 */     pw3.println(Player.mapX);
/* 115 */     pw3.println(Player.mapY);
/* 116 */     pw3.println(Player.mapMovement);
/* 117 */     pw3.println(Player.insideMovement);
/* 118 */     pw3.println(ShopManager.isInside);
/* 119 */     pw3.println(ShopManager.enter);
/* 120 */     pw3.println(ShopManager.exit);
/* 121 */     pw3.println(ShopManager.overlay);
/* 124 */     pw3.close();
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4.7_1.jar!\beyondOrigins\main\Save.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */