/*     */ package com.emgartley.beyondOrigins.main.threads;
/*     */ 
/*     */ import com.emgartley.beyondOrigins.files.Logger;
/*     */ import com.emgartley.beyondOrigins.main.Game;
/*     */ import com.emgartley.beyondOrigins.main.buildings.BuildingRender;
/*     */ import com.emgartley.beyondOrigins.main.buildings.Shop;
/*     */ import com.emgartley.beyondOrigins.main.entities.Entity;
/*     */ import com.emgartley.beyondOrigins.main.gfx.ImageManager;
/*     */ import com.emgartley.beyondOrigins.main.inventory.Inventory;
/*     */ import com.emgartley.beyondOrigins.main.maps.GrassMap;
/*     */ import com.emgartley.beyondOrigins.main.menus.MainMenu;
/*     */ import com.emgartley.beyondOrigins.main.menus.PauseMenu;
/*     */ import com.emgartley.beyondOrigins.main.story.StoryText;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import javax.imageio.ImageIO;
/*     */ 
/*     */ public class Init implements Runnable {
/*  20 */   String name = "thread_init";
/*     */   
/*     */   public static Thread t;
/*     */   
/*     */   boolean shouldRun = true;
/*     */   
/*     */   public Init(String n) {
/*  25 */     this.name = n;
/*  26 */     t = new Thread(this, this.name);
/*  27 */     t.setPriority(1);
/*  28 */     t.start();
/*     */   }
/*     */   
/*     */   private static BufferedImage loadImage(String path) {
/*     */     try {
/*  33 */       BufferedImage reImage = ImageIO.read(new File(path));
/*  34 */       return reImage;
/*  35 */     } catch (IOException e) {
/*  36 */       e.printStackTrace();
/*  38 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void run() {
/*  42 */     long lastTime = System.nanoTime();
/*  43 */     long timer = System.currentTimeMillis();
/*  44 */     double ns = 1.6666666666666666E7D;
/*  45 */     double delta = 0.0D;
/*  46 */     while (Game.running && this.shouldRun) {
/*  47 */       long now = System.nanoTime();
/*  48 */       delta += (now - lastTime) / ns;
/*  49 */       lastTime = now;
/*  50 */       if (delta >= 1.0D) {
/*  51 */         tick();
/*  52 */         delta--;
/*  53 */         if (System.currentTimeMillis() - timer > 1000L)
/*  54 */           timer += 1000L; 
/*     */       } 
/*     */       try {
/*  58 */         Thread.sleep(1L);
/*  59 */       } catch (InterruptedException e) {
/*  60 */         e.printStackTrace();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void tick() {
/*  66 */     if (Game.initing) {
/*  67 */       go();
/*  68 */       Game.initing = false;
/*  69 */       this.shouldRun = false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void loadGfx() {
/*  74 */     Game.mapImage = loadImage(String.valueOf(Game.mainDir) + "assets\\grassMap.png");
/*  75 */     Game.playerSheet = loadImage(String.valueOf(Game.mainDir) + "assets\\player.png");
/*  76 */     Game.terrain1Sheet = loadImage(String.valueOf(Game.mainDir) + "assets\\terrain1.png");
/*  77 */     Game.mainmenuSheet = loadImage(String.valueOf(Game.mainDir) + "assets\\mainmenu.png");
/*  78 */     Game.inventorySheet = loadImage(String.valueOf(Game.mainDir) + "assets\\inventory.png");
/*  79 */     Game.widgetSheet = loadImage(String.valueOf(Game.mainDir) + "assets\\widgets1.png");
/*  80 */     Game.entitySheet = loadImage(String.valueOf(Game.mainDir) + "assets\\entities1.png");
/*  81 */     Game.inside1Image = loadImage(String.valueOf(Game.mainDir) + "assets\\inside1.png");
/*  82 */     Game.logoImage = loadImage(String.valueOf(Game.mainDir) + "assets\\logo.png");
/*  83 */     Game.creds = loadImage(String.valueOf(Game.mainDir) + "assets\\creds.png");
/*  84 */     Game.mapOverview = loadImage(String.valueOf(Game.mainDir) + "assets\\mapOverview.png");
/*  85 */     Game.im = new ImageManager();
/*  86 */     Game.logger.log("Loaded graphics");
/*     */   }
/*     */   
/*     */   private void go() {
/*  90 */     Game.loadingStatus = "Starting up... (1/3)";
/*  91 */     Game.initing = true;
/*  92 */     Game.logger = new Logger();
/*  93 */     Game.logger.log("Game started");
/*  94 */     Game.loadingStatus = "Loading in graphics... (2/3)";
/*  95 */     loadGfx();
/*  96 */     Game.loadingStatus = "Starting classes... (3/3)";
/*  97 */     Game.mainMenu = new MainMenu();
/*  98 */     Game.pauseMenu = new PauseMenu();
/*  99 */     Game.grassm = new GrassMap(Game.mapImage, 0, 0);
/* 100 */     Entity.init();
/* 101 */     Game.inv = new Inventory();
/* 102 */     Game.br = new BuildingRender();
/* 103 */     Game.storyText = new StoryText();
/* 104 */     BuildingRender.init();
/* 105 */     Shop.init();
/* 106 */     Game.loadingStatus = "Done loading!";
/*     */     try {
/* 108 */       Thread.sleep(1200L);
/* 109 */     } catch (InterruptedException e) {
/* 110 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.1.0_5.jar!\com\emgartley\beyondOrigins\main\threads\Init.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */