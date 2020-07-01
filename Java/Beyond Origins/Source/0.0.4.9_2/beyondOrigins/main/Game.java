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
/*  41 */   private long lastTime = System.currentTimeMillis() - Save.autoSaveTime;
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
/*  56 */   public static int playerSpawnX = 398;
/*     */   
/*  57 */   public static int playerSpawnY = 263;
/*     */   
/*  60 */   public static String title = "Beyond Origins 0.0.5 WIP";
/*     */   
/*  61 */   public static String copyright = "Evan Gartley 2014";
/*     */   
/*  62 */   public static String save1Path = "C:\\Users\\" + 
/*  63 */     System.getProperty("user.name") + 
/*  64 */     "\\AppData\\Roaming\\Beyond Origins\\save1.zan";
/*     */   
/*  65 */   public static String save2Path = "C:\\Users\\" + 
/*  66 */     System.getProperty("user.name") + 
/*  67 */     "\\AppData\\Roaming\\Beyond Origins\\save2.zan";
/*     */   
/*  68 */   public static String save3Path = "C:\\Users\\" + 
/*  69 */     System.getProperty("user.name") + 
/*  70 */     "\\AppData\\Roaming\\Beyond Origins\\save3.zan";
/*     */   
/*  71 */   public static String dataPath = "C:\\Users\\" + 
/*  72 */     System.getProperty("user.name") + 
/*  73 */     "\\AppData\\Roaming\\Beyond Origins\\data.zan";
/*     */   
/*  76 */   public static Color text1 = new Color(255, 255, 255);
/*     */   
/*  77 */   public static Color text2 = new Color(236, 210, 120);
/*     */   
/*  78 */   public static Color text3 = new Color(73, 73, 73);
/*     */   
/*  79 */   public static Color sky1 = new Color(86, 201, 255);
/*     */   
/*  80 */   public static Color text1Color = new Color(99, 99, 99);
/*     */   
/*  81 */   public static Color gameProgressColor = new Color(73, 73, 73);
/*     */   
/*  84 */   public static Font default1 = new Font("DejaVu Sans", 0, 12);
/*     */   
/*  85 */   public static Font default2 = new Font("MoolBoran", 0, 32);
/*     */   
/*  86 */   public static Font menuText1 = new Font("MoolBoran", 0, 23);
/*     */   
/*  87 */   public static Font menuText1_1 = new Font("MoolBoran", 3, 
/*  88 */       23);
/*     */   
/*  89 */   public static Font menuText3 = new Font("MoolBoran", 1, 62);
/*     */   
/*  90 */   public static Font gameProgressFont = new Font("MoolBoran", 0, 60);
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
/*     */   public void init() throws IOException {
/* 131 */     ImageLoader loader = new ImageLoader();
/* 134 */     this.playerSheet = loader.load("/player.png");
/* 135 */     this.terrain1Sheet = loader.load("/terrain1.png");
/* 136 */     this.animal1Sheet = loader.load("/animals1.png");
/* 137 */     this.mainmenuSheet = loader.load("/mainmenu.png");
/* 138 */     this.inventorySheet = loader.load("/inventory.png");
/* 139 */     inside1Image = loader.load("/inside1.png");
/* 140 */     logoImage = loader.load("/logo.png");
/* 144 */     SpriteSheet ssplr = new SpriteSheet(this.playerSheet);
/* 145 */     SpriteSheet sstr1 = new SpriteSheet(this.terrain1Sheet);
/* 146 */     SpriteSheet sscow = new SpriteSheet(this.animal1Sheet);
/* 147 */     SpriteSheet ssmnm = new SpriteSheet(this.mainmenuSheet);
/* 148 */     SpriteSheet ssinv = new SpriteSheet(this.inventorySheet);
/* 151 */     this.implr = new ImageManager(ssplr);
/* 152 */     this.immnm = new ImageManager(ssmnm);
/* 153 */     this.imani = new ImageManager(sscow);
/* 154 */     this.iminv = new ImageManager(ssinv);
/* 155 */     this.imtr1 = new ImageManager(sstr1);
/* 158 */     mainmenu = new MainMenu(MainMenu.cloud1x, MainMenu.cloud1y, this.immnm);
/* 159 */     pauseMenu = new PauseMenu(this.immnm);
/* 160 */     grassm = new GrassMap(this.imtr1);
/* 161 */     player = new Player(playerSpawnX, playerSpawnY, playerSpawnX, 
/* 162 */         playerSpawnY, this.implr);
/* 163 */     inventoryMain = new InventoryMain(this.iminv);
/* 164 */     buildingr = new BuildingRender(this.imtr1);
/* 166 */     f3menu = new F3Menu();
/* 167 */     cow = new Cow(this.imani);
/* 170 */     GrassMap.init();
/* 171 */     MainMenu.init();
/* 172 */     InventoryMain.init();
/* 173 */     BuildingRender.init();
/* 174 */     Shop.init();
/* 177 */     addKeyListener(new KeyManager());
/* 178 */     addMouseListener(new MouseManager());
/* 179 */     addMouseMotionListener(new MouseMotion());
/*     */   }
/*     */   
/*     */   public synchronized void start() {
/* 184 */     if (running)
/*     */       return; 
/* 187 */     running = true;
/* 188 */     this.gameThread = new Thread(this);
/* 189 */     this.gameThread.start();
/*     */   }
/*     */   
/*     */   public synchronized void stop() {
/* 194 */     if (!running)
/*     */       return; 
/* 197 */     running = false;
/*     */     try {
/* 199 */       this.gameThread.join();
/* 200 */     } catch (InterruptedException e) {
/* 201 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void run() {
/*     */     try {
/* 207 */       init();
/* 208 */     } catch (IOException e) {
/* 209 */       e.printStackTrace();
/*     */     } 
/* 211 */     long lastTime = System.nanoTime();
/* 212 */     long timer = System.currentTimeMillis();
/* 213 */     double amountOfTicks = 60.0D;
/* 214 */     double ns = 1.6666666666666666E7D;
/* 215 */     double delta = 0.0D;
/* 216 */     requestFocus();
/* 219 */     while (running) {
/* 220 */       long now = System.nanoTime();
/* 221 */       delta += (now - lastTime) / ns;
/* 222 */       lastTime = now;
/* 223 */       if (delta >= 1.0D) {
/* 224 */         tick();
/* 225 */         updates++;
/* 226 */         delta--;
/*     */       } 
/* 228 */       render();
/* 229 */       frames++;
/* 230 */       if (System.currentTimeMillis() - timer > 1000L) {
/* 231 */         timer += 1000L;
/* 232 */         currentFrames = frames;
/* 233 */         currentUpdates = updates;
/* 234 */         updates = 0;
/* 235 */         frames = 0;
/*     */       } 
/*     */     } 
/* 238 */     stop();
/*     */   }
/*     */   
/*     */   public void tick() {
/* 246 */     if (isInGame && !PauseMenu.isOpen) {
/* 247 */       if (autoSave) {
/* 248 */         long thisTime = System.currentTimeMillis();
/* 249 */         if (thisTime - this.lastTime >= Save.autoSaveTime) {
/* 250 */           this.lastTime = thisTime;
/* 251 */           Save.autoSave(this.lastTime);
/*     */         } 
/*     */       } 
/* 254 */       MainMenu.playState = 1;
/* 255 */       inventoryMain.tick();
/* 256 */       CollisionManager.tick();
/* 257 */       player.tick();
/* 259 */     } else if (!isInGame && !PauseMenu.isOpen) {
/* 260 */       mainmenu.tick();
/* 261 */     } else if (isInGame && PauseMenu.isOpen) {
/* 262 */       pauseMenu.tick();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render() {
/* 272 */     BufferStrategy bs = getBufferStrategy();
/* 274 */     if (bs == null) {
/* 275 */       createBufferStrategy(3);
/*     */       return;
/*     */     } 
/* 279 */     Graphics g = bs.getDrawGraphics();
/* 282 */     g.fillRect(0, 0, 838, 573);
/* 284 */     g.setColor(Color.WHITE);
/* 287 */     if (isInGame && !PauseMenu.isOpen) {
/* 288 */       grassm.render(g);
/* 292 */       player.render(g);
/* 293 */       inventoryMain.render(g);
/* 294 */     } else if (!isInGame && !PauseMenu.isOpen) {
/* 295 */       mainmenu.renderMain(g);
/* 296 */     } else if (isInGame && PauseMenu.isOpen) {
/* 297 */       pauseMenu.renderMain(g);
/*     */     } 
/* 300 */     if (F3Menu.f3menu)
/* 301 */       f3menu.render(g); 
/* 305 */     g.dispose();
/* 306 */     bs.show();
/*     */   }
/*     */   
/*     */   public static void main(String[] args) throws Exception {
/* 313 */     Game game = new Game();
/* 314 */     game.setPreferredSize(new Dimension(838, 573));
/* 315 */     game.setMaximumSize(new Dimension(838, 573));
/* 316 */     game.setMinimumSize(new Dimension(838, 573));
/* 319 */     JFrame frame = new JFrame(title);
/* 320 */     frame.setSize(838, 573);
/* 321 */     frame.setDefaultCloseOperation(3);
/* 322 */     frame.setResizable(false);
/* 323 */     frame.add(game);
/* 324 */     frame.setVisible(true);
/* 325 */     frame.setLocationRelativeTo((Component)null);
/* 326 */     frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
/* 327 */           JFrame.class.getResource("/icon32.png")));
/*     */     try {
/* 332 */       boolean bool = (new File("C:\\Users\\" + 
/* 333 */           System.getProperty("user.name") + 
/* 334 */           "\\AppData\\Roaming\\Beyond Origins")).mkdir();
/* 336 */     } catch (Exception e) {
/* 337 */       e.printStackTrace();
/*     */     } 
/* 341 */     game.start();
/*     */   }
/*     */   
/*     */   public static GrassMap getGrassMap() {
/* 345 */     return grassm;
/*     */   }
/*     */   
/*     */   public static Player getPlayer() {
/* 349 */     return player;
/*     */   }
/*     */   
/*     */   public static Cow getCow() {
/* 353 */     return cow;
/*     */   }
/*     */   
/*     */   public static F3Menu getF3Menu() {
/* 357 */     return f3menu;
/*     */   }
/*     */   
/*     */   public static MainMenu getMainMenu() {
/* 361 */     return mainmenu;
/*     */   }
/*     */   
/*     */   public static InventoryMain getInventoryMain() {
/* 365 */     return inventoryMain;
/*     */   }
/*     */   
/*     */   public static BuildingRender getBuildingRender() {
/* 369 */     return buildingr;
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4.9_2.jar!\beyondOrigins\main\Game.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */