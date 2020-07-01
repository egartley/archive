/*     */ package beyondOrigins.main;
/*     */ 
/*     */ import beyondOrigins.main.buildings.BuildingRender;
/*     */ import beyondOrigins.main.buildings.shop.ShopManager;
/*     */ import beyondOrigins.main.entities.Cow;
/*     */ import beyondOrigins.main.entities.Player;
/*     */ import beyondOrigins.main.gfx.ImageLoader;
/*     */ import beyondOrigins.main.gfx.ImageManager;
/*     */ import beyondOrigins.main.gfx.SpriteSheet;
/*     */ import beyondOrigins.main.inventory.InventoryMain;
/*     */ import beyondOrigins.main.maps.GrassMap;
/*     */ import beyondOrigins.main.menus.F3Menu;
/*     */ import beyondOrigins.main.menus.MainMenu;
/*     */ import java.awt.Canvas;
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Font;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.image.BufferStrategy;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.File;
/*     */ import java.io.FileWriter;
/*     */ import java.io.IOException;
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
/*     */   public static FileWriter fw2;
/*     */   
/*     */   public static PrintWriter pw1;
/*     */   
/*     */   public static PrintWriter pw2;
/*     */   
/*     */   public static int frames;
/*     */   
/*     */   public static int currentFrames;
/*     */   
/*     */   public static int updates;
/*     */   
/*     */   public static int currentUpdates;
/*     */   
/*  53 */   public static int playerSpawnX = 398;
/*     */   
/*  54 */   public static int playerSpawnY = 263;
/*     */   
/*  57 */   public static String title = "Beyond Origins 0.0.4.7 Alpha";
/*     */   
/*  58 */   public static String copyright = "Copyright Evan Gartley 2014";
/*     */   
/*  59 */   public static String save1Path = "C:\\Users\\" + 
/*  60 */     System.getProperty("user.name") + 
/*  61 */     "\\AppData\\Roaming\\Beyond Origins\\save1.zan";
/*     */   
/*  62 */   public static String save2Path = "C:\\Users\\" + 
/*  63 */     System.getProperty("user.name") + 
/*  64 */     "\\AppData\\Roaming\\Beyond Origins\\save2.zan";
/*     */   
/*  65 */   public static String save3Path = "C:\\Users\\" + 
/*  66 */     System.getProperty("user.name") + 
/*  67 */     "\\AppData\\Roaming\\Beyond Origins\\save3.zan";
/*     */   
/*  68 */   public static String optionsPath = "C:\\Users\\" + 
/*  69 */     System.getProperty("user.name") + 
/*  70 */     "\\AppData\\Roaming\\Beyond Origins\\options.zan";
/*     */   
/*     */   public static boolean isInGame = false;
/*     */   
/*     */   public static boolean saveRequested = false;
/*     */   
/*     */   public static boolean loadRequested = false;
/*     */   
/*     */   public static boolean isOnMap = true;
/*     */   
/*  79 */   public static Font default1 = new Font("DejaVu Sans", 0, 12);
/*     */   
/*  80 */   public static Font default2 = new Font("MoolBoran", 0, 32);
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
/*     */   public static BufferedImage logoImage;
/*     */   
/*     */   public static BufferedImage inside1Image;
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
/*     */   private ImageManager imshp;
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
/* 113 */     ImageLoader loader = new ImageLoader();
/* 116 */     this.playerSheet = loader.load("/player.png");
/* 117 */     this.terrain1Sheet = loader.load("/terrain1.png");
/* 118 */     this.animal1Sheet = loader.load("/animals1.png");
/* 119 */     this.mainmenuSheet = loader.load("/mainmenu.png");
/* 120 */     this.inventorySheet = loader.load("/inventory.png");
/* 121 */     inside1Image = loader.load("/inside1.png");
/* 122 */     logoImage = loader.load("/logo.png");
/* 125 */     SpriteSheet ssplr = new SpriteSheet(this.playerSheet);
/* 126 */     SpriteSheet sstr1 = new SpriteSheet(this.terrain1Sheet);
/* 127 */     SpriteSheet sscow = new SpriteSheet(this.animal1Sheet);
/* 128 */     SpriteSheet ssmnm = new SpriteSheet(this.mainmenuSheet);
/* 129 */     SpriteSheet ssinv = new SpriteSheet(this.inventorySheet);
/* 132 */     this.implr = new ImageManager(ssplr);
/* 133 */     this.immnm = new ImageManager(ssmnm);
/* 134 */     this.imani = new ImageManager(sscow);
/* 135 */     this.iminv = new ImageManager(ssinv);
/* 136 */     this.imtr1 = new ImageManager(sstr1);
/* 139 */     mainmenu = new MainMenu(MainMenu.cloud1x, MainMenu.cloud1y, this.immnm);
/* 140 */     grassm = new GrassMap(this.imtr1);
/* 141 */     player = new Player(playerSpawnX, playerSpawnY, playerSpawnX, 
/* 142 */         playerSpawnY, this.implr);
/* 143 */     inventoryMain = new InventoryMain(this.iminv);
/* 144 */     buildingr = new BuildingRender(this.imtr1);
/* 145 */     shopManager = new ShopManager(this.imshp);
/* 146 */     f3menu = new F3Menu();
/* 147 */     cow = new Cow(this.imani);
/* 150 */     GrassMap.init();
/* 151 */     MainMenu.init();
/* 152 */     InventoryMain.init();
/* 153 */     BuildingRender.init();
/* 154 */     ShopManager.init();
/* 157 */     addKeyListener(new KeyManager());
/* 158 */     addMouseListener(new MouseManager());
/* 159 */     addMouseMotionListener(new MouseMotion());
/*     */   }
/*     */   
/*     */   public synchronized void start() {
/* 164 */     if (running)
/*     */       return; 
/* 167 */     running = true;
/* 168 */     this.gameThread = new Thread(this);
/* 169 */     this.gameThread.start();
/*     */   }
/*     */   
/*     */   public synchronized void stop() {
/* 174 */     if (!running)
/*     */       return; 
/* 177 */     running = false;
/*     */     try {
/* 179 */       this.gameThread.join();
/* 180 */     } catch (InterruptedException e) {
/* 181 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void run() {
/* 186 */     init();
/* 187 */     long lastTime = System.nanoTime();
/* 188 */     long timer = System.currentTimeMillis();
/* 189 */     double amountOfTicks = 60.0D;
/* 190 */     double ns = 1.6666666666666666E7D;
/* 191 */     double delta = 0.0D;
/* 192 */     requestFocus();
/* 195 */     while (running) {
/* 196 */       long now = System.nanoTime();
/* 197 */       delta += (now - lastTime) / ns;
/* 198 */       lastTime = now;
/* 199 */       if (delta >= 1.0D) {
/* 200 */         tick();
/* 201 */         updates++;
/* 202 */         delta--;
/*     */       } 
/* 204 */       render();
/* 205 */       frames++;
/* 206 */       if (System.currentTimeMillis() - timer > 1000L) {
/* 207 */         timer += 1000L;
/* 208 */         currentFrames = frames;
/* 209 */         currentUpdates = updates;
/* 210 */         updates = 0;
/* 211 */         frames = 0;
/*     */       } 
/*     */     } 
/* 214 */     stop();
/*     */   }
/*     */   
/*     */   public void tick() {
/* 220 */     if (KeyManager.enterPressed) {
/*     */       try {
/* 222 */         Save.save1();
/* 223 */       } catch (IOException e) {
/* 224 */         e.printStackTrace();
/*     */       } 
/* 226 */     } else if (KeyManager.onePressed) {
/* 227 */       Load.loadSave1();
/*     */     } 
/* 231 */     if (isInGame) {
/* 232 */       MainMenu.playState = 1;
/* 233 */       inventoryMain.tick();
/* 234 */       buildingr.tick();
/* 235 */       CollisionManager.tick();
/* 236 */       player.tick();
/* 237 */       f3menu.tick();
/* 238 */       ShopManager.tick();
/*     */     } else {
/* 240 */       mainmenu.tick();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render() {
/* 248 */     BufferStrategy bs = getBufferStrategy();
/* 250 */     if (bs == null) {
/* 251 */       createBufferStrategy(3);
/*     */       return;
/*     */     } 
/* 255 */     Graphics g = bs.getDrawGraphics();
/* 258 */     g.fillRect(0, 0, 573, 419);
/* 260 */     g.setColor(Color.WHITE);
/* 263 */     if (isInGame) {
/* 264 */       grassm.render(g);
/* 265 */       buildingr.render(g);
/* 266 */       ShopManager.render(g);
/* 267 */       player.render(g);
/* 269 */       inventoryMain.render(g);
/*     */     } else {
/* 271 */       mainmenu.renderMain(g);
/*     */     } 
/* 273 */     f3menu.render(g);
/* 276 */     g.dispose();
/* 277 */     bs.show();
/*     */   }
/*     */   
/*     */   public static void main(String[] args) throws Exception {
/* 284 */     Game game = new Game();
/* 285 */     game.setPreferredSize(new Dimension(838, 573));
/* 286 */     game.setMaximumSize(new Dimension(838, 573));
/* 287 */     game.setMinimumSize(new Dimension(838, 573));
/* 290 */     JFrame frame = new JFrame(title);
/* 291 */     frame.setSize(838, 573);
/* 292 */     frame.setDefaultCloseOperation(3);
/* 293 */     frame.setResizable(false);
/* 294 */     frame.add(game);
/* 295 */     frame.setVisible(true);
/* 296 */     frame.setLocationRelativeTo((Component)null);
/* 297 */     frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
/* 298 */           JFrame.class.getResource("/icon32.png")));
/*     */     try {
/* 303 */       boolean bool = (new File("C:\\Users\\" + 
/* 304 */           System.getProperty("user.name") + 
/* 305 */           "\\AppData\\Roaming\\Beyond Origins")).mkdir();
/* 307 */     } catch (Exception e) {
/* 308 */       e.printStackTrace();
/*     */     } 
/* 312 */     game.start();
/*     */   }
/*     */   
/*     */   public static GrassMap getGrassMap() {
/* 316 */     return grassm;
/*     */   }
/*     */   
/*     */   public static Player getPlayer() {
/* 320 */     return player;
/*     */   }
/*     */   
/*     */   public static Cow getCow() {
/* 324 */     return cow;
/*     */   }
/*     */   
/*     */   public static F3Menu getF3Menu() {
/* 328 */     return f3menu;
/*     */   }
/*     */   
/*     */   public static MainMenu getMainMenu() {
/* 332 */     return mainmenu;
/*     */   }
/*     */   
/*     */   public static InventoryMain getInventoryMain() {
/* 336 */     return inventoryMain;
/*     */   }
/*     */   
/*     */   public static BuildingRender getBuildingRender() {
/* 340 */     return buildingr;
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4.7.jar!\beyondOrigins\main\Game.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */