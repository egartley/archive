/*     */ package beyondOrigins.main;
/*     */ 
/*     */ import beyondOrigins.main.buildings.BuildingRender;
/*     */ import beyondOrigins.main.buildings.shop.Shop;
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
/*  58 */   public static String title = "Beyond Origins 0.0.4.8 Alpha";
/*     */   
/*  59 */   public static String copyright = "Evan Gartley 2014";
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
/*     */   private static PauseMenu pauseMenu;
/*     */   
/*     */   public void init() {
/* 125 */     ImageLoader loader = new ImageLoader();
/* 128 */     this.playerSheet = loader.load("/player.png");
/* 129 */     this.terrain1Sheet = loader.load("/terrain1.png");
/* 130 */     this.animal1Sheet = loader.load("/animals1.png");
/* 131 */     this.mainmenuSheet = loader.load("/mainmenu.png");
/* 132 */     this.inventorySheet = loader.load("/inventory.png");
/* 133 */     inside1Image = loader.load("/inside1.png");
/* 134 */     logoImage = loader.load("/logo.png");
/* 137 */     SpriteSheet ssplr = new SpriteSheet(this.playerSheet);
/* 138 */     SpriteSheet sstr1 = new SpriteSheet(this.terrain1Sheet);
/* 139 */     SpriteSheet sscow = new SpriteSheet(this.animal1Sheet);
/* 140 */     SpriteSheet ssmnm = new SpriteSheet(this.mainmenuSheet);
/* 141 */     SpriteSheet ssinv = new SpriteSheet(this.inventorySheet);
/* 144 */     this.implr = new ImageManager(ssplr);
/* 145 */     this.immnm = new ImageManager(ssmnm);
/* 146 */     this.imani = new ImageManager(sscow);
/* 147 */     this.iminv = new ImageManager(ssinv);
/* 148 */     this.imtr1 = new ImageManager(sstr1);
/* 151 */     mainmenu = new MainMenu(MainMenu.cloud1x, MainMenu.cloud1y, this.immnm);
/* 152 */     pauseMenu = new PauseMenu(this.immnm);
/* 153 */     grassm = new GrassMap(this.imtr1);
/* 154 */     player = new Player(playerSpawnX, playerSpawnY, playerSpawnX, 
/* 155 */         playerSpawnY, this.implr);
/* 156 */     inventoryMain = new InventoryMain(this.iminv);
/* 157 */     buildingr = new BuildingRender(this.imtr1);
/* 159 */     f3menu = new F3Menu();
/* 160 */     cow = new Cow(this.imani);
/* 163 */     GrassMap.init();
/* 164 */     MainMenu.init();
/* 165 */     InventoryMain.init();
/* 166 */     BuildingRender.init();
/* 167 */     Shop.init();
/* 170 */     addKeyListener(new KeyManager());
/* 171 */     addMouseListener(new MouseManager());
/* 172 */     addMouseMotionListener(new MouseMotion());
/*     */   }
/*     */   
/*     */   public synchronized void start() {
/* 177 */     if (running)
/*     */       return; 
/* 180 */     running = true;
/* 181 */     this.gameThread = new Thread(this);
/* 182 */     this.gameThread.start();
/*     */   }
/*     */   
/*     */   public synchronized void stop() {
/* 187 */     if (!running)
/*     */       return; 
/* 190 */     running = false;
/*     */     try {
/* 192 */       this.gameThread.join();
/* 193 */     } catch (InterruptedException e) {
/* 194 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void run() {
/* 199 */     init();
/* 200 */     long lastTime = System.nanoTime();
/* 201 */     long timer = System.currentTimeMillis();
/* 202 */     double amountOfTicks = 60.0D;
/* 203 */     double ns = 1.6666666666666666E7D;
/* 204 */     double delta = 0.0D;
/* 205 */     requestFocus();
/* 208 */     while (running) {
/* 209 */       long now = System.nanoTime();
/* 210 */       delta += (now - lastTime) / ns;
/* 211 */       lastTime = now;
/* 212 */       if (delta >= 1.0D) {
/* 213 */         tick();
/* 214 */         updates++;
/* 215 */         delta--;
/*     */       } 
/* 217 */       render();
/* 218 */       frames++;
/* 219 */       if (System.currentTimeMillis() - timer > 1000L) {
/* 220 */         timer += 1000L;
/* 221 */         currentFrames = frames;
/* 222 */         currentUpdates = updates;
/* 223 */         updates = 0;
/* 224 */         frames = 0;
/*     */       } 
/*     */     } 
/* 227 */     stop();
/*     */   }
/*     */   
/*     */   public void tick() {
/* 232 */     long timer = System.currentTimeMillis();
/* 233 */     if (System.currentTimeMillis() - timer > 15000L)
/* 234 */       System.out.println("15 seconds have passed!"); 
/* 238 */     if (isInGame && !PauseMenu.isOpen) {
/* 239 */       MainMenu.playState = 1;
/* 240 */       inventoryMain.tick();
/* 241 */       buildingr.tick();
/* 242 */       CollisionManager.tick();
/* 243 */       player.tick();
/* 244 */       Shop.tick();
/* 245 */     } else if (!isInGame && !PauseMenu.isOpen) {
/* 246 */       mainmenu.tick();
/* 247 */     } else if (isInGame && PauseMenu.isOpen) {
/* 248 */       pauseMenu.tick();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render() {
/* 256 */     BufferStrategy bs = getBufferStrategy();
/* 258 */     if (bs == null) {
/* 259 */       createBufferStrategy(3);
/*     */       return;
/*     */     } 
/* 263 */     Graphics g = bs.getDrawGraphics();
/* 266 */     g.fillRect(0, 0, 838, 573);
/* 268 */     g.setColor(Color.WHITE);
/* 271 */     if (isInGame && !PauseMenu.isOpen) {
/* 272 */       grassm.render(g);
/* 273 */       buildingr.render(g);
/* 274 */       Shop.render(g);
/* 275 */       player.render(g);
/* 276 */       inventoryMain.render(g);
/* 277 */     } else if (!isInGame && !PauseMenu.isOpen) {
/* 278 */       mainmenu.renderMain(g);
/* 279 */     } else if (isInGame && PauseMenu.isOpen) {
/* 280 */       pauseMenu.renderMain(g);
/*     */     } 
/* 283 */     if (F3Menu.f3menu)
/* 284 */       f3menu.render(g); 
/* 288 */     g.dispose();
/* 289 */     bs.show();
/*     */   }
/*     */   
/*     */   public static void main(String[] args) throws Exception {
/* 296 */     Game game = new Game();
/* 297 */     game.setPreferredSize(new Dimension(838, 573));
/* 298 */     game.setMaximumSize(new Dimension(838, 573));
/* 299 */     game.setMinimumSize(new Dimension(838, 573));
/* 302 */     JFrame frame = new JFrame(title);
/* 303 */     frame.setSize(838, 573);
/* 304 */     frame.setDefaultCloseOperation(3);
/* 305 */     frame.setResizable(false);
/* 306 */     frame.add(game);
/* 307 */     frame.setVisible(true);
/* 308 */     frame.setLocationRelativeTo((Component)null);
/* 309 */     frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
/* 310 */           JFrame.class.getResource("/icon32.png")));
/*     */     try {
/* 315 */       boolean bool = (new File("C:\\Users\\" + 
/* 316 */           System.getProperty("user.name") + 
/* 317 */           "\\AppData\\Roaming\\Beyond Origins")).mkdir();
/* 319 */     } catch (Exception e) {
/* 320 */       e.printStackTrace();
/*     */     } 
/* 324 */     game.start();
/*     */   }
/*     */   
/*     */   public static GrassMap getGrassMap() {
/* 328 */     return grassm;
/*     */   }
/*     */   
/*     */   public static Player getPlayer() {
/* 332 */     return player;
/*     */   }
/*     */   
/*     */   public static Cow getCow() {
/* 336 */     return cow;
/*     */   }
/*     */   
/*     */   public static F3Menu getF3Menu() {
/* 340 */     return f3menu;
/*     */   }
/*     */   
/*     */   public static MainMenu getMainMenu() {
/* 344 */     return mainmenu;
/*     */   }
/*     */   
/*     */   public static InventoryMain getInventoryMain() {
/* 348 */     return inventoryMain;
/*     */   }
/*     */   
/*     */   public static BuildingRender getBuildingRender() {
/* 352 */     return buildingr;
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4.8_2.jar!\beyondOrigins\main\Game.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */