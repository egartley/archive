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
/*     */ import beyondOrigins.main.menus.PauseMenu;
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
/*     */ import java.io.PrintWriter;
/*     */ import javax.swing.JFrame;
/*     */ 
/*     */ public class Game extends Canvas implements Runnable {
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   public static final int HEIGHT = 573;
/*     */   
/*     */   public static final int WIDTH = 419;
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
/*  54 */   public static int playerSpawnX = 398;
/*     */   
/*  55 */   public static int playerSpawnY = 263;
/*     */   
/*  58 */   public static String title = "Beyond Origins 0.0.4.7 Alpha";
/*     */   
/*  59 */   public static String copyright = "Copyright Evan Gartley 2014";
/*     */   
/*  60 */   public static String save1Path = "C:\\Users\\" + 
/*  61 */     System.getProperty("user.name") + 
/*  62 */     "\\AppData\\Roaming\\Beyond Origins\\save1.zan";
/*     */   
/*  63 */   public static String save2Path = "C:\\Users\\" + 
/*  64 */     System.getProperty("user.name") + 
/*  65 */     "\\AppData\\Roaming\\Beyond Origins\\save2.zan";
/*     */   
/*  66 */   public static String save3Path = "C:\\Users\\" + 
/*  67 */     System.getProperty("user.name") + 
/*  68 */     "\\AppData\\Roaming\\Beyond Origins\\save3.zan";
/*     */   
/*  69 */   public static String optionsPath = "C:\\Users\\" + 
/*  70 */     System.getProperty("user.name") + 
/*  71 */     "\\AppData\\Roaming\\Beyond Origins\\options.zan";
/*     */   
/*  74 */   public static Color text1 = new Color(255, 255, 255);
/*     */   
/*  75 */   public static Color text2 = new Color(236, 210, 120);
/*     */   
/*  76 */   public static Color text3 = new Color(73, 73, 73);
/*     */   
/*  77 */   public static Color sky1 = new Color(86, 201, 255);
/*     */   
/*  78 */   public static Color text1Color = new Color(99, 99, 99);
/*     */   
/*  79 */   public static Color gameProgressColor = new Color(73, 73, 73);
/*     */   
/*  82 */   public static Font default1 = new Font("DejaVu Sans", 0, 12);
/*     */   
/*  83 */   public static Font default2 = new Font("MoolBoran", 0, 32);
/*     */   
/*  84 */   public static Font menuText1 = new Font("MoolBoran", 0, 23);
/*     */   
/*  85 */   public static Font menuText1_1 = new Font("MoolBoran", 3, 23);
/*     */   
/*  86 */   public static Font gameProgressFont = new Font("MoolBoran", 0, 60);
/*     */   
/*     */   public static boolean isInGame = false;
/*     */   
/*     */   public static boolean saveRequested = false;
/*     */   
/*     */   public static boolean loadRequested = false;
/*     */   
/*     */   public static boolean isOnMap = true;
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
/*     */   private static PauseMenu pauseMenu;
/*     */   
/*     */   public void init() {
/* 126 */     ImageLoader loader = new ImageLoader();
/* 129 */     this.playerSheet = loader.load("/player.png");
/* 130 */     this.terrain1Sheet = loader.load("/terrain1.png");
/* 131 */     this.animal1Sheet = loader.load("/animals1.png");
/* 132 */     this.mainmenuSheet = loader.load("/mainmenu.png");
/* 133 */     this.inventorySheet = loader.load("/inventory.png");
/* 134 */     inside1Image = loader.load("/inside1.png");
/* 135 */     logoImage = loader.load("/logo.png");
/* 138 */     SpriteSheet ssplr = new SpriteSheet(this.playerSheet);
/* 139 */     SpriteSheet sstr1 = new SpriteSheet(this.terrain1Sheet);
/* 140 */     SpriteSheet sscow = new SpriteSheet(this.animal1Sheet);
/* 141 */     SpriteSheet ssmnm = new SpriteSheet(this.mainmenuSheet);
/* 142 */     SpriteSheet ssinv = new SpriteSheet(this.inventorySheet);
/* 145 */     this.implr = new ImageManager(ssplr);
/* 146 */     this.immnm = new ImageManager(ssmnm);
/* 147 */     this.imani = new ImageManager(sscow);
/* 148 */     this.iminv = new ImageManager(ssinv);
/* 149 */     this.imtr1 = new ImageManager(sstr1);
/* 152 */     mainmenu = new MainMenu(MainMenu.cloud1x, MainMenu.cloud1y, this.immnm);
/* 153 */     pauseMenu = new PauseMenu(this.immnm);
/* 154 */     grassm = new GrassMap(this.imtr1);
/* 155 */     player = new Player(playerSpawnX, playerSpawnY, playerSpawnX, 
/* 156 */         playerSpawnY, this.implr);
/* 157 */     inventoryMain = new InventoryMain(this.iminv);
/* 158 */     buildingr = new BuildingRender(this.imtr1);
/* 159 */     shopManager = new ShopManager(this.imshp);
/* 160 */     f3menu = new F3Menu();
/* 161 */     cow = new Cow(this.imani);
/* 164 */     GrassMap.init();
/* 165 */     MainMenu.init();
/* 166 */     InventoryMain.init();
/* 167 */     BuildingRender.init();
/* 168 */     ShopManager.init();
/* 171 */     addKeyListener(new KeyManager());
/* 172 */     addMouseListener(new MouseManager());
/* 173 */     addMouseMotionListener(new MouseMotion());
/*     */   }
/*     */   
/*     */   public synchronized void start() {
/* 178 */     if (running)
/*     */       return; 
/* 181 */     running = true;
/* 182 */     this.gameThread = new Thread(this);
/* 183 */     this.gameThread.start();
/*     */   }
/*     */   
/*     */   public synchronized void stop() {
/* 188 */     if (!running)
/*     */       return; 
/* 191 */     running = false;
/*     */     try {
/* 193 */       this.gameThread.join();
/* 194 */     } catch (InterruptedException e) {
/* 195 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void run() {
/* 200 */     init();
/* 201 */     long lastTime = System.nanoTime();
/* 202 */     long timer = System.currentTimeMillis();
/* 203 */     double amountOfTicks = 60.0D;
/* 204 */     double ns = 1.6666666666666666E7D;
/* 205 */     double delta = 0.0D;
/* 206 */     requestFocus();
/* 209 */     while (running) {
/* 210 */       long now = System.nanoTime();
/* 211 */       delta += (now - lastTime) / ns;
/* 212 */       lastTime = now;
/* 213 */       if (delta >= 1.0D) {
/* 214 */         tick();
/* 215 */         updates++;
/* 216 */         delta--;
/*     */       } 
/* 218 */       render();
/* 219 */       frames++;
/* 220 */       if (System.currentTimeMillis() - timer > 1000L) {
/* 221 */         timer += 1000L;
/* 222 */         currentFrames = frames;
/* 223 */         currentUpdates = updates;
/* 224 */         updates = 0;
/* 225 */         frames = 0;
/*     */       } 
/*     */     } 
/* 228 */     stop();
/*     */   }
/*     */   
/*     */   public void tick() {
/* 234 */     if (PauseMenu.isOpen)
/* 235 */       pauseMenu.tick(); 
/* 238 */     if (isInGame && !PauseMenu.isOpen) {
/* 239 */       MainMenu.playState = 1;
/* 240 */       inventoryMain.tick();
/* 241 */       buildingr.tick();
/* 242 */       CollisionManager.tick();
/* 243 */       player.tick();
/* 244 */       f3menu.tick();
/* 245 */       ShopManager.tick();
/* 246 */     } else if (!isInGame) {
/* 247 */       mainmenu.tick();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render() {
/* 255 */     BufferStrategy bs = getBufferStrategy();
/* 257 */     if (bs == null) {
/* 258 */       createBufferStrategy(3);
/*     */       return;
/*     */     } 
/* 262 */     Graphics g = bs.getDrawGraphics();
/* 265 */     g.fillRect(0, 0, 838, 573);
/* 267 */     g.setColor(Color.WHITE);
/* 270 */     if (isInGame) {
/* 271 */       grassm.render(g);
/* 272 */       buildingr.render(g);
/* 273 */       ShopManager.render(g);
/* 274 */       player.render(g);
/* 276 */       inventoryMain.render(g);
/* 278 */       if (PauseMenu.isOpen)
/* 279 */         pauseMenu.renderMain(g); 
/*     */     } else {
/* 282 */       mainmenu.renderMain(g);
/*     */     } 
/* 284 */     f3menu.render(g);
/* 287 */     g.dispose();
/* 288 */     bs.show();
/*     */   }
/*     */   
/*     */   public static void main(String[] args) throws Exception {
/* 295 */     Game game = new Game();
/* 296 */     game.setPreferredSize(new Dimension(838, 573));
/* 297 */     game.setMaximumSize(new Dimension(838, 573));
/* 298 */     game.setMinimumSize(new Dimension(838, 573));
/* 301 */     JFrame frame = new JFrame(title);
/* 302 */     frame.setSize(838, 573);
/* 303 */     frame.setDefaultCloseOperation(3);
/* 304 */     frame.setResizable(false);
/* 305 */     frame.add(game);
/* 306 */     frame.setVisible(true);
/* 307 */     frame.setLocationRelativeTo((Component)null);
/* 308 */     frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
/* 309 */           JFrame.class.getResource("/icon32.png")));
/*     */     try {
/* 314 */       boolean bool = (new File("C:\\Users\\" + 
/* 315 */           System.getProperty("user.name") + 
/* 316 */           "\\AppData\\Roaming\\Beyond Origins")).mkdir();
/* 318 */     } catch (Exception e) {
/* 319 */       e.printStackTrace();
/*     */     } 
/* 323 */     game.start();
/*     */   }
/*     */   
/*     */   public static GrassMap getGrassMap() {
/* 327 */     return grassm;
/*     */   }
/*     */   
/*     */   public static Player getPlayer() {
/* 331 */     return player;
/*     */   }
/*     */   
/*     */   public static Cow getCow() {
/* 335 */     return cow;
/*     */   }
/*     */   
/*     */   public static F3Menu getF3Menu() {
/* 339 */     return f3menu;
/*     */   }
/*     */   
/*     */   public static MainMenu getMainMenu() {
/* 343 */     return mainmenu;
/*     */   }
/*     */   
/*     */   public static InventoryMain getInventoryMain() {
/* 347 */     return inventoryMain;
/*     */   }
/*     */   
/*     */   public static BuildingRender getBuildingRender() {
/* 351 */     return buildingr;
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4.7_1.jar!\beyondOrigins\main\Game.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */