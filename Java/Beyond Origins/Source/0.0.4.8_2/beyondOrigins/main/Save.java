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
/*  15 */   public static File save1 = new File(Game.save1Path);
/*     */   
/*  15 */   public static File save2 = new File(Game.save2Path);
/*     */   
/*  15 */   public static File save3 = new File(Game.save3Path);
/*     */   
/*     */   public static boolean canMakeNewGame = true;
/*     */   
/*  19 */   public static String save1LastPlayed = "";
/*     */   
/*  19 */   public static String save2LastPlayed = "";
/*     */   
/*  19 */   public static String save3LastPlayed = "";
/*     */   
/*     */   public static int save1Progress;
/*     */   
/*     */   public static int save2Progress;
/*     */   
/*     */   public static int save3Progress;
/*     */   
/*  21 */   public static String save1Made = "";
/*     */   
/*  21 */   public static String save2Made = "";
/*     */   
/*  21 */   public static String save3Made = "";
/*     */   
/*     */   public static FileWriter fw1;
/*     */   
/*     */   public static FileWriter fw2;
/*     */   
/*     */   public static FileWriter fw3;
/*     */   
/*     */   public static void reset() {
/*  27 */     Player.playerX = 398.0F;
/*  28 */     Player.playerY = 263.0F;
/*  29 */     Player.mapX = 398.0F;
/*  30 */     Player.mapY = 263.0F;
/*  31 */     Player.mapMovement = true;
/*  32 */     Player.insideMovement = false;
/*  33 */     Shop.isInside = false;
/*  34 */     Shop.enter = 0;
/*  35 */     Shop.exit = 0;
/*  36 */     Shop.overlay = 0;
/*  39 */     Player.lastDir = 3;
/*     */   }
/*     */   
/*     */   public static void save1() throws IOException {
/*  46 */     if (!save1.exists()) {
/*  47 */       fw1 = new FileWriter(Game.save1Path);
/*  48 */       save1Made = (new SimpleDateFormat("MM-dd-yyyy")).format(Calendar.getInstance().getTime());
/*  49 */       save1LastPlayed = (new SimpleDateFormat("MM-dd-yyyy")).format(Calendar.getInstance().getTime());
/*  50 */     } else if (save1.delete()) {
/*  51 */       fw1 = new FileWriter(Game.save1Path);
/*  52 */       save1LastPlayed = (new SimpleDateFormat("MM-dd-yyyy")).format(Calendar.getInstance().getTime());
/*     */     } 
/*  56 */     PrintWriter pw1 = new PrintWriter(fw1);
/*  59 */     pw1.println(Player.playerX);
/*  60 */     pw1.println(Player.playerY);
/*  61 */     pw1.println(Player.mapX);
/*  62 */     pw1.println(Player.mapY);
/*  63 */     pw1.println(Player.mapMovement);
/*  64 */     pw1.println(Player.insideMovement);
/*  65 */     pw1.println(Shop.isInside);
/*  66 */     pw1.println(Shop.enter);
/*  67 */     pw1.println(Shop.exit);
/*  68 */     pw1.println(Shop.overlay);
/*  71 */     pw1.close();
/*     */   }
/*     */   
/*     */   public static void save2() throws IOException {
/*  78 */     if (!save2.exists()) {
/*  79 */       fw2 = new FileWriter(Game.save2Path);
/*  80 */       save2Made = (new SimpleDateFormat("MM-dd-yyyy")).format(Calendar.getInstance().getTime());
/*  81 */       save2LastPlayed = (new SimpleDateFormat("MM-dd-yyyy")).format(Calendar.getInstance().getTime());
/*  82 */     } else if (save2.delete()) {
/*  83 */       fw2 = new FileWriter(Game.save2Path);
/*  84 */       save2LastPlayed = (new SimpleDateFormat("MM-dd-yyyy")).format(Calendar.getInstance().getTime());
/*     */     } 
/*  88 */     PrintWriter pw2 = new PrintWriter(fw2);
/*  91 */     pw2.println(Player.playerX);
/*  92 */     pw2.println(Player.playerY);
/*  93 */     pw2.println(Player.mapX);
/*  94 */     pw2.println(Player.mapY);
/*  95 */     pw2.println(Player.mapMovement);
/*  96 */     pw2.println(Player.insideMovement);
/*  97 */     pw2.println(Shop.isInside);
/*  98 */     pw2.println(Shop.enter);
/*  99 */     pw2.println(Shop.exit);
/* 100 */     pw2.println(Shop.overlay);
/* 103 */     pw2.close();
/*     */   }
/*     */   
/*     */   public static void save3() throws IOException {
/* 110 */     if (!save3.exists()) {
/* 111 */       fw3 = new FileWriter(Game.save3Path);
/* 112 */       save3Made = (new SimpleDateFormat("MM-dd-yyyy")).format(Calendar.getInstance().getTime());
/* 113 */       save3LastPlayed = (new SimpleDateFormat("MM-dd-yyyy")).format(Calendar.getInstance().getTime());
/* 114 */     } else if (save3.delete()) {
/* 115 */       fw3 = new FileWriter(Game.save3Path);
/* 116 */       save3LastPlayed = (new SimpleDateFormat("MM-dd-yyyy")).format(Calendar.getInstance().getTime());
/*     */     } 
/* 120 */     PrintWriter pw3 = new PrintWriter(fw3);
/* 123 */     pw3.println(Player.playerX);
/* 124 */     pw3.println(Player.playerY);
/* 125 */     pw3.println(Player.mapX);
/* 126 */     pw3.println(Player.mapY);
/* 127 */     pw3.println(Player.mapMovement);
/* 128 */     pw3.println(Player.insideMovement);
/* 129 */     pw3.println(Shop.isInside);
/* 130 */     pw3.println(Shop.enter);
/* 131 */     pw3.println(Shop.exit);
/* 132 */     pw3.println(Shop.overlay);
/* 135 */     pw3.close();
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4.8_2.jar!\beyondOrigins\main\Save.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */