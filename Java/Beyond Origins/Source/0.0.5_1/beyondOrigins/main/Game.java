/*     */ package beyondOrigins.main;
/*     */ 
/*     */ import beyondOrigins.files.Save;
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
/*     */ import beyondOrigins.threads.CloudThread;
/*     */ import beyondOrigins.userInput.KeyManager;
/*     */ import beyondOrigins.userInput.MouseManager;
/*     */ import beyondOrigins.userInput.MouseMotion;
/*     */ import java.awt.Canvas;
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Font;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.event.KeyListener;
/*     */ import java.awt.event.MouseListener;
/*     */ import java.awt.event.MouseMotionListener;
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
/*     */   public static Thread cloudThread;
/*     */   
/*     */   public static Thread mapThread;
/*     */   
/*  47 */   private long lastTime = System.currentTimeMillis() - Save.autoSaveTime;
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
/*  62 */   public static int playerSpawnX = 403;
/*     */   
/*  63 */   public static int playerSpawnY = 270;
/*     */   
/*  66 */   public static String title = "Beyond Origins 0.0.5 WIP";
/*     */   
/*  67 */   public static String copyright = "Evan Gartley 2014";
/*     */   
/*  68 */   public static String save1Path = "C:\\Users\\" + 
/*  69 */     System.getProperty("user.name") + 
/*  70 */     "\\AppData\\Roaming\\Beyond Origins\\save1.zan";
/*     */   
/*  71 */   public static String save2Path = "C:\\Users\\" + 
/*  72 */     System.getProperty("user.name") + 
/*  73 */     "\\AppData\\Roaming\\Beyond Origins\\save2.zan";
/*     */   
/*  74 */   public static String save3Path = "C:\\Users\\" + 
/*  75 */     System.getProperty("user.name") + 
/*  76 */     "\\AppData\\Roaming\\Beyond Origins\\save3.zan";
/*     */   
/*  77 */   public static String dataPath = "C:\\Users\\" + 
/*  78 */     System.getProperty("user.name") + 
/*  79 */     "\\AppData\\Roaming\\Beyond Origins\\data.zan";
/*     */   
/*  82 */   public static Color buttonIdleColor = new Color(255, 255, 255);
/*     */   
/*  83 */   public static Color buttonSelectedColor = new Color(236, 210, 120);
/*     */   
/*  84 */   public static Color buttonClickedColor = new Color(73, 73, 73);
/*     */   
/*  85 */   public static Color skyColor = new Color(86, 201, 255);
/*     */   
/*  86 */   public static Color profileInfoColor = new Color(99, 99, 99);
/*     */   
/*  87 */   public static Color gameProgressColor = new Color(73, 73, 73);
/*     */   
/*  90 */   public static Font f3MenuFont = new Font("DejaVu Sans", 0, 12);
/*     */   
/*  91 */   public static Font buttonTextFont = new Font("MoolBoran", 0, 32);
/*     */   
/*  92 */   public static Font profileInfoFont = new Font("MoolBoran", 0, 23);
/*     */   
/*  93 */   public static Font profileNameFont = new Font("MoolBoran", 3, 
/*  94 */       23);
/*     */   
/*  95 */   public static Font areYouSureFont = new Font("MoolBoran", 1, 62);
/*     */   
/*  96 */   public static Font gameProgressFont = new Font("MoolBoran", 0, 60);
/*     */   
/*     */   public static boolean isInGame = false;
/*     */   
/*     */   public static boolean saveRequested = false;
/*     */   
/*     */   public static boolean loadRequested = false;
/*     */   
/*     */   public static boolean isOnMap = true;
/*     */   
/*     */   public static boolean autoSave = true;
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
/*     */   public static BufferedImage mapGrid;
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
/*     */   public void init() throws IOException {
/* 136 */     ImageLoader loader = new ImageLoader();
/* 139 */     this.playerSheet = loader.load("/player.png");
/* 140 */     this.terrain1Sheet = loader.load("/terrain1.png");
/* 141 */     this.animal1Sheet = loader.load("/animals1.png");
/* 142 */     this.mainmenuSheet = loader.load("/mainmenu.png");
/* 143 */     this.inventorySheet = loader.load("/inventory.png");
/* 144 */     inside1Image = loader.load("/inside1.png");
/* 145 */     logoImage = loader.load("/logo.png");
/* 149 */     SpriteSheet ssplr = new SpriteSheet(this.playerSheet);
/* 150 */     SpriteSheet sstr1 = new SpriteSheet(this.terrain1Sheet);
/* 151 */     SpriteSheet sscow = new SpriteSheet(this.animal1Sheet);
/* 152 */     SpriteSheet ssmnm = new SpriteSheet(this.mainmenuSheet);
/* 153 */     SpriteSheet ssinv = new SpriteSheet(this.inventorySheet);
/* 156 */     this.implr = new ImageManager(ssplr);
/* 157 */     this.immnm = new ImageManager(ssmnm);
/* 158 */     this.imani = new ImageManager(sscow);
/* 159 */     this.iminv = new ImageManager(ssinv);
/* 160 */     this.imtr1 = new ImageManager(sstr1);
/* 163 */     mainmenu = new MainMenu(this.immnm);
/* 164 */     pauseMenu = new PauseMenu(this.immnm);
/* 165 */     grassm = new GrassMap(this.imtr1);
/* 166 */     player = new Player(playerSpawnX, playerSpawnY, playerSpawnX, 
/* 167 */         playerSpawnY, this.implr);
/* 168 */     inventoryMain = new InventoryMain(this.iminv);
/* 169 */     buildingr = new BuildingRender(this.imtr1);
/* 171 */     f3menu = new F3Menu();
/* 172 */     cow = new Cow(this.imani);
/* 175 */     GrassMap.init();
/* 176 */     MainMenu.init();
/* 177 */     BuildingRender.init();
/* 178 */     Shop.init();
/* 181 */     addKeyListener((KeyListener)new KeyManager());
/* 182 */     addMouseListener((MouseListener)new MouseManager());
/* 183 */     addMouseMotionListener((MouseMotionListener)new MouseMotion());
/*     */   }
/*     */   
/*     */   public synchronized void start() {
/* 188 */     if (running)
/*     */       return; 
/* 191 */     running = true;
/* 193 */     this.gameThread = new Thread(this);
/* 194 */     cloudThread = new Thread((Runnable)new CloudThread("Clouds"));
/* 197 */     cloudThread.setPriority(1);
/* 200 */     this.gameThread.start();
/*     */   }
/*     */   
/*     */   public synchronized void stop() {
/* 205 */     if (!running)
/*     */       return; 
/* 208 */     running = false;
/*     */     try {
/* 210 */       this.gameThread.join();
/* 211 */     } catch (InterruptedException e) {
/* 212 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void run() {
/*     */     try {
/* 218 */       init();
/* 219 */     } catch (IOException e) {
/* 220 */       e.printStackTrace();
/*     */     } 
/* 222 */     long lastTime = System.nanoTime();
/* 223 */     long timer = System.currentTimeMillis();
/* 224 */     double ns = 1.6666666666666666E7D;
/* 225 */     double delta = 0.0D;
/* 226 */     requestFocus();
/* 229 */     while (running) {
/* 230 */       long now = System.nanoTime();
/* 231 */       delta += (now - lastTime) / ns;
/* 232 */       lastTime = now;
/* 233 */       if (delta >= 1.0D) {
/* 234 */         tick();
/* 235 */         updates++;
/* 236 */         delta--;
/*     */       } 
/* 238 */       render();
/* 239 */       frames++;
/* 240 */       if (System.currentTimeMillis() - timer > 1000L) {
/* 241 */         timer += 1000L;
/* 242 */         currentFrames = frames;
/* 243 */         currentUpdates = updates;
/* 244 */         updates = 0;
/* 245 */         frames = 0;
/*     */       } 
/*     */     } 
/* 248 */     stop();
/*     */   }
/*     */   
/*     */   public static void addThread(Thread t, String name) {}
/*     */   
/*     */   public synchronized void tick() {
/* 260 */     if (isInGame && !PauseMenu.isOpen) {
/* 261 */       if (autoSave) {
/* 262 */         long thisTime = System.currentTimeMillis();
/* 263 */         if (thisTime - this.lastTime >= Save.autoSaveTime) {
/* 264 */           this.lastTime = thisTime;
/* 265 */           Save.autoSave(this.lastTime);
/*     */         } 
/*     */       } 
/* 268 */       MainMenu.playState = 1;
/* 269 */       inventoryMain.tick();
/* 270 */       CollisionManager.tick();
/* 271 */       player.tick();
/* 273 */     } else if (!isInGame && !PauseMenu.isOpen) {
/* 274 */       mainmenu.tick();
/* 275 */     } else if (isInGame && PauseMenu.isOpen) {
/* 276 */       pauseMenu.tick();
/*     */     } 
/*     */   }
/*     */   
/*     */   public synchronized void render() {
/* 286 */     BufferStrategy bs = getBufferStrategy();
/* 288 */     if (bs == null) {
/* 289 */       createBufferStrategy(3);
/*     */       return;
/*     */     } 
/* 293 */     Graphics g = bs.getDrawGraphics();
/* 296 */     g.fillRect(0, 0, 838, 573);
/* 298 */     g.setColor(Color.WHITE);
/* 301 */     if (isInGame && !PauseMenu.isOpen) {
/* 302 */       MainMenu.clouds = false;
/* 303 */       grassm.render(g);
/* 307 */       player.render(g);
/* 308 */       inventoryMain.render(g);
/* 309 */     } else if (!isInGame && !PauseMenu.isOpen) {
/* 310 */       MainMenu.clouds = true;
/* 311 */       mainmenu.renderMain(g);
/* 312 */     } else if (isInGame && PauseMenu.isOpen) {
/* 313 */       MainMenu.clouds = false;
/* 314 */       pauseMenu.renderMain(g);
/*     */     } 
/* 317 */     if (F3Menu.f3menu)
/* 318 */       f3menu.render(g); 
/* 322 */     g.dispose();
/* 323 */     bs.show();
/*     */   }
/*     */   
/*     */   public static void main(String[] args) throws Exception {
/* 330 */     Game game = new Game();
/* 331 */     game.setPreferredSize(new Dimension(838, 573));
/* 332 */     game.setMaximumSize(new Dimension(838, 573));
/* 333 */     game.setMinimumSize(new Dimension(838, 573));
/* 336 */     JFrame frame = new JFrame(title);
/* 337 */     frame.setSize(838, 573);
/* 338 */     frame.setDefaultCloseOperation(3);
/* 339 */     frame.setResizable(false);
/* 340 */     frame.add(game);
/* 341 */     frame.setVisible(true);
/* 342 */     frame.setLocationRelativeTo((Component)null);
/* 343 */     frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
/* 344 */           JFrame.class.getResource("/icon32.png")));
/*     */     try {
/* 349 */       boolean bool = (new File("C:\\Users\\" + 
/* 350 */           System.getProperty("user.name") + 
/* 351 */           "\\AppData\\Roaming\\Beyond Origins")).mkdir();
/* 353 */     } catch (Exception e) {
/* 354 */       e.printStackTrace();
/*     */     } 
/* 357 */     cloudThread = new Thread(game);
/* 359 */     System.out.println("Args: " + args);
/* 362 */     game.start();
/*     */   }
/*     */   
/*     */   public static GrassMap getGrassMap() {
/* 366 */     return grassm;
/*     */   }
/*     */   
/*     */   public static Player getPlayer() {
/* 370 */     return player;
/*     */   }
/*     */   
/*     */   public static Cow getCow() {
/* 374 */     return cow;
/*     */   }
/*     */   
/*     */   public static F3Menu getF3Menu() {
/* 378 */     return f3menu;
/*     */   }
/*     */   
/*     */   public static MainMenu getMainMenu() {
/* 382 */     return mainmenu;
/*     */   }
/*     */   
/*     */   public static InventoryMain getInventoryMain() {
/* 386 */     return inventoryMain;
/*     */   }
/*     */   
/*     */   public static BuildingRender getBuildingRender() {
/* 390 */     return buildingr;
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_1.jar!\beyondOrigins\main\Game.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */