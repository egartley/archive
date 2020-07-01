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
/*     */   public static FileWriter fw1;
/*     */   
/*     */   public static FileWriter fw2;
/*     */   
/*     */   public static FileWriter fw3;
/*     */   
/*     */   public static void save1() throws IOException {
/*  22 */     if (!save1.exists()) {
/*  23 */       fw1 = new FileWriter(Game.save1Path);
/*  24 */     } else if (save1.delete()) {
/*  25 */       fw1 = new FileWriter(Game.save1Path);
/*     */     } 
/*  29 */     PrintWriter pw1 = new PrintWriter(fw1);
/*  32 */     pw1.println(Player.playerX);
/*  33 */     pw1.println(Player.playerY);
/*  34 */     pw1.println(Player.mapX);
/*  35 */     pw1.println(Player.mapY);
/*  36 */     pw1.println(Player.mapMovement);
/*  37 */     pw1.println(Player.insideMovement);
/*  38 */     pw1.println(ShopManager.isInside);
/*  39 */     pw1.println(ShopManager.enter);
/*  40 */     pw1.println(ShopManager.exit);
/*  41 */     pw1.println(ShopManager.overlay);
/*  44 */     pw1.close();
/*     */   }
/*     */   
/*     */   public static void save2() throws IOException {
/*  51 */     if (!save2.exists()) {
/*  52 */       fw2 = new FileWriter(Game.save2Path);
/*  53 */     } else if (save2.delete()) {
/*  54 */       fw2 = new FileWriter(Game.save2Path);
/*     */     } 
/*  58 */     PrintWriter pw2 = new PrintWriter(fw2);
/*  61 */     pw2.println(Player.playerX);
/*  62 */     pw2.println(Player.playerY);
/*  63 */     pw2.println(Player.mapX);
/*  64 */     pw2.println(Player.mapY);
/*  65 */     pw2.println(Player.mapMovement);
/*  66 */     pw2.println(Player.insideMovement);
/*  67 */     pw2.println(ShopManager.isInside);
/*  68 */     pw2.println(ShopManager.enter);
/*  69 */     pw2.println(ShopManager.exit);
/*  70 */     pw2.println(ShopManager.overlay);
/*  73 */     pw2.close();
/*     */   }
/*     */   
/*     */   public static void save3() throws IOException {
/*  80 */     if (!save3.exists()) {
/*  81 */       fw3 = new FileWriter(Game.save3Path);
/*  82 */     } else if (save3.delete()) {
/*  83 */       fw3 = new FileWriter(Game.save3Path);
/*     */     } 
/*  87 */     PrintWriter pw3 = new PrintWriter(fw3);
/*  90 */     pw3.println(Player.playerX);
/*  91 */     pw3.println(Player.playerY);
/*  92 */     pw3.println(Player.mapX);
/*  93 */     pw3.println(Player.mapY);
/*  94 */     pw3.println(Player.mapMovement);
/*  95 */     pw3.println(Player.insideMovement);
/*  96 */     pw3.println(ShopManager.isInside);
/*  97 */     pw3.println(ShopManager.enter);
/*  98 */     pw3.println(ShopManager.exit);
/*  99 */     pw3.println(ShopManager.overlay);
/* 102 */     pw3.close();
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4.6_2.jar!\beyondOrigins\main\Save.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */