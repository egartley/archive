/*     */ package applecraft.testgame.main;
/*     */ 
/*     */ import applecraft.testgame.main.buildings.BuildingRender;
/*     */ import applecraft.testgame.main.buildings.shop.ShopManager;
/*     */ import applecraft.testgame.main.entities.Cow;
/*     */ import applecraft.testgame.main.entities.Player;
/*     */ import applecraft.testgame.main.gfx.ImageLoader;
/*     */ import applecraft.testgame.main.gfx.ImageManager;
/*     */ import applecraft.testgame.main.gfx.SpriteSheet;
/*     */ import applecraft.testgame.main.inventory.InventoryMain;
/*     */ import applecraft.testgame.main.maps.GrassMap;
/*     */ import applecraft.testgame.main.menus.F3Menu;
/*     */ import applecraft.testgame.main.menus.MainMenu;
/*     */ import java.awt.Canvas;
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Font;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.image.BufferStrategy;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.FileWriter;
/*     */ import java.io.PrintWriter;
/*     */ import javax.swing.JFrame;
/*     */ 
/*     */ public class Game extends Canvas implements Runnable {
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   public static final int WIDTH = 573;
/*     */   
/*     */   public static final int HEIGHT = 419;
/*     */   
/*     */   public static final int SCALE = 2;
/*     */   
/*     */   public static boolean running = false;
/*     */   
/*     */   public Thread gameThread;
/*     */   
/*     */   public static FileWriter fw1;
/*     */   
/*     */   public static PrintWriter pw;
/*     */   
/*     */   public static int frames;
/*     */   
/*     */   public static int currentFrames;
/*     */   
/*     */   public static int updates;
/*     */   
/*     */   public static int currentUpdates;
/*     */   
/*  42 */   public static int playerSpawnX = 398;
/*     */   
/*  43 */   public static int playerSpawnY = 263;
/*     */   
/*  45 */   public static String title = "Beyond Origins 0.0.4.2 Alpha";
/*     */   
/*  46 */   public static String copyright = "Copyright Evan Gartley 2014";
/*     */   
/*     */   public static boolean gameRequested = false;
/*     */   
/*     */   public static boolean isOnMap = true;
/*     */   
/*  50 */   public static Font mminfo1 = new Font("Minecraft", 0, 16);
/*     */   
/*  51 */   public static Font default1 = new Font("DejaVu Sans", 0, 12);
/*     */   
/*     */   private BufferedImage playerSheet;
/*     */   
/*     */   private BufferedImage terrain1Sheet;
/*     */   
/*     */   private BufferedImage animal1Sheet;
/*     */   
/*     */   private BufferedImage mainmenuSheet;
/*     */   
/*     */   private BufferedImage inventorySheet;
/*     */   
/*     */   private ImageManager implr;
/*     */   
/*     */   private ImageManager imtr1;
/*     */   
/*     */   private ImageManager imani;
/*     */   
/*     */   private ImageManager imf3;
/*     */   
/*     */   private ImageManager immnm;
/*     */   
/*     */   private ImageManager iminv;
/*     */   
/*     */   public static BufferedImage logoImage;
/*     */   
/*     */   public static BufferedImage inside1Image;
/*     */   
/*     */   private static Player player;
/*     */   
/*     */   private static GrassMap grassm;
/*     */   
/*     */   private static Cow cow;
/*     */   
/*     */   private static F3Menu f3menu;
/*     */   
/*     */   private static MainMenu mainmenu;
/*     */   
/*     */   private static InventoryMain inventoryMain;
/*     */   
/*     */   private static BuildingRender buildingr;
/*     */   
/*     */   private static ShopManager shopManager;
/*     */   
/*     */   public void init() {
/*  74 */     ImageLoader loader = new ImageLoader();
/*  76 */     this.playerSheet = loader.load("/player.png");
/*  77 */     this.terrain1Sheet = loader.load("/terrain1.png");
/*  78 */     this.animal1Sheet = loader.load("/animals1.png");
/*  79 */     this.mainmenuSheet = loader.load("/mainmenu.png");
/*  80 */     this.inventorySheet = loader.load("/inventory.png");
/*  81 */     inside1Image = loader.load("/inside1.png");
/*  82 */     logoImage = loader.load("/logo.png");
/*  84 */     SpriteSheet ssplr = new SpriteSheet(this.playerSheet);
/*  85 */     SpriteSheet sstr1 = new SpriteSheet(this.terrain1Sheet);
/*  86 */     SpriteSheet sscow = new SpriteSheet(this.animal1Sheet);
/*  87 */     SpriteSheet ssmnm = new SpriteSheet(this.mainmenuSheet);
/*  88 */     SpriteSheet ssinv = new SpriteSheet(this.inventorySheet);
/*  90 */     this.implr = new ImageManager(ssplr);
/*  91 */     this.immnm = new ImageManager(ssmnm);
/*  92 */     this.imani = new ImageManager(sscow);
/*  93 */     this.iminv = new ImageManager(ssinv);
/*  94 */     this.imtr1 = new ImageManager(sstr1);
/*  98 */     mainmenu = new MainMenu(MainMenu.cloud1x, MainMenu.cloud1y, this.immnm);
/*  99 */     grassm = new GrassMap(this.imtr1);
/* 100 */     player = new Player(playerSpawnX, playerSpawnY, playerSpawnX, 
/* 101 */         playerSpawnY, this.implr);
/* 102 */     inventoryMain = new InventoryMain(this.iminv);
/* 103 */     buildingr = new BuildingRender(this.imtr1);
/* 104 */     shopManager = new ShopManager(ShopManager.shopEnter);
/* 105 */     f3menu = new F3Menu(this.imf3);
/* 106 */     cow = new Cow(this.imani);
/* 110 */     GrassMap.init();
/* 111 */     MainMenu.init();
/* 112 */     InventoryMain.init();
/* 113 */     BuildingRender.init();
/* 114 */     ShopManager.init();
/* 116 */     addKeyListener(new KeyManager());
/* 117 */     addMouseListener(new MouseManager());
/* 118 */     addMouseMotionListener(new MouseMotion());
/*     */   }
/*     */   
/*     */   public synchronized void start() {
/* 122 */     if (running)
/*     */       return; 
/* 124 */     running = true;
/* 125 */     this.gameThread = new Thread(this);
/* 126 */     this.gameThread.start();
/*     */   }
/*     */   
/*     */   public synchronized void stop() {
/* 130 */     if (!running)
/*     */       return; 
/* 132 */     running = false;
/*     */     try {
/* 134 */       this.gameThread.join();
/* 135 */     } catch (InterruptedException e) {
/* 136 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void run() {
/* 141 */     init();
/* 142 */     long lastTime = System.nanoTime();
/* 143 */     long timer = System.currentTimeMillis();
/* 144 */     double amountOfTicks = 60.0D;
/* 145 */     double ns = 1.6666666666666666E7D;
/* 146 */     double delta = 0.0D;
/* 147 */     requestFocus();
/* 148 */     while (running) {
/* 149 */       long now = System.nanoTime();
/* 150 */       delta += (now - lastTime) / ns;
/* 151 */       lastTime = now;
/* 152 */       if (delta >= 1.0D) {
/* 153 */         tick();
/* 154 */         updates++;
/* 155 */         delta--;
/*     */       } 
/* 157 */       render();
/* 158 */       frames++;
/* 160 */       if (System.currentTimeMillis() - timer > 1000L) {
/* 161 */         timer += 1000L;
/* 162 */         currentFrames = frames;
/* 163 */         currentUpdates = updates;
/* 164 */         updates = 0;
/* 165 */         frames = 0;
/*     */       } 
/*     */     } 
/* 169 */     stop();
/*     */   }
/*     */   
/*     */   public void tick() {
/* 174 */     if (gameRequested) {
/* 176 */       inventoryMain.tick();
/* 177 */       buildingr.tick();
/* 178 */       player.tick();
/* 179 */       f3menu.tick();
/* 180 */       ShopManager.tick();
/*     */     } else {
/* 183 */       mainmenu.tick();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render() {
/* 189 */     BufferStrategy bs = getBufferStrategy();
/* 190 */     if (bs == null) {
/* 191 */       createBufferStrategy(3);
/*     */       return;
/*     */     } 
/* 194 */     Graphics g = bs.getDrawGraphics();
/* 198 */     g.fillRect(0, 0, 838, 1146);
/* 201 */     g.setColor(Color.WHITE);
/* 203 */     if (gameRequested) {
/* 204 */       grassm.render(g);
/* 205 */       buildingr.render(g);
/* 206 */       ShopManager.render(g);
/* 207 */       player.render(g);
/* 209 */       inventoryMain.render(g);
/*     */     } else {
/* 211 */       mainmenu.render(g);
/*     */     } 
/* 213 */     f3menu.render(g);
/* 216 */     g.dispose();
/* 217 */     bs.show();
/*     */   }
/*     */   
/*     */   public static void main(String[] args) {
/* 221 */     Game game = new Game();
/* 222 */     game.setPreferredSize(new Dimension(838, 573));
/* 223 */     game.setMaximumSize(new Dimension(838, 573));
/* 224 */     game.setMinimumSize(new Dimension(838, 573));
/* 226 */     JFrame frame = new JFrame(title);
/* 227 */     frame.setSize(838, 573);
/* 228 */     frame.setDefaultCloseOperation(3);
/* 229 */     frame.setResizable(false);
/* 230 */     frame.add(game);
/* 231 */     frame.setVisible(true);
/* 232 */     frame.setLocationRelativeTo((Component)null);
/* 233 */     frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
/* 234 */           JFrame.class.getResource("/icon32.png")));
/* 244 */     game.start();
/*     */   }
/*     */   
/*     */   public static GrassMap getGrassMap() {
/* 248 */     return grassm;
/*     */   }
/*     */   
/*     */   public static Player getPlayer() {
/* 252 */     return player;
/*     */   }
/*     */   
/*     */   public static Cow getCow() {
/* 256 */     return cow;
/*     */   }
/*     */   
/*     */   public static F3Menu getF3Menu() {
/* 260 */     return f3menu;
/*     */   }
/*     */   
/*     */   public static MainMenu getMainMenu() {
/* 264 */     return mainmenu;
/*     */   }
/*     */   
/*     */   public static InventoryMain getInventoryMain() {
/* 268 */     return inventoryMain;
/*     */   }
/*     */   
/*     */   public static BuildingRender getBuildingRender() {
/* 272 */     return buildingr;
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4.2_4.jar!\applecraft\testgame\main\Game.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */