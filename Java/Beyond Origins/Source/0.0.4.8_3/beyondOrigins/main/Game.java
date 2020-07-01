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
/*  40 */   private final long PERIOD = 180000L;
/*     */   
/*  41 */   private long lastTime = System.currentTimeMillis() - 180000L;
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
/*  60 */   public static String title = "Beyond Origins 0.0.4.8 Alpha";
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
/*     */   public void init() throws IOException {
/* 129 */     ImageLoader loader = new ImageLoader();
/* 132 */     this.playerSheet = loader.load("/player.png");
/* 133 */     this.terrain1Sheet = loader.load("/terrain1.png");
/* 134 */     this.animal1Sheet = loader.load("/animals1.png");
/* 135 */     this.mainmenuSheet = loader.load("/mainmenu.png");
/* 136 */     this.inventorySheet = loader.load("/inventory.png");
/* 137 */     inside1Image = loader.load("/inside1.png");
/* 138 */     logoImage = loader.load("/logo.png");
/* 141 */     SpriteSheet ssplr = new SpriteSheet(this.playerSheet);
/* 142 */     SpriteSheet sstr1 = new SpriteSheet(this.terrain1Sheet);
/* 143 */     SpriteSheet sscow = new SpriteSheet(this.animal1Sheet);
/* 144 */     SpriteSheet ssmnm = new SpriteSheet(this.mainmenuSheet);
/* 145 */     SpriteSheet ssinv = new SpriteSheet(this.inventorySheet);
/* 148 */     this.implr = new ImageManager(ssplr);
/* 149 */     this.immnm = new ImageManager(ssmnm);
/* 150 */     this.imani = new ImageManager(sscow);
/* 151 */     this.iminv = new ImageManager(ssinv);
/* 152 */     this.imtr1 = new ImageManager(sstr1);
/* 155 */     mainmenu = new MainMenu(MainMenu.cloud1x, MainMenu.cloud1y, this.immnm);
/* 156 */     pauseMenu = new PauseMenu(this.immnm);
/* 157 */     grassm = new GrassMap(this.imtr1);
/* 158 */     player = new Player(playerSpawnX, playerSpawnY, playerSpawnX, 
/* 159 */         playerSpawnY, this.implr);
/* 160 */     inventoryMain = new InventoryMain(this.iminv);
/* 161 */     buildingr = new BuildingRender(this.imtr1);
/* 163 */     f3menu = new F3Menu();
/* 164 */     cow = new Cow(this.imani);
/* 167 */     GrassMap.init();
/* 168 */     MainMenu.init();
/* 169 */     InventoryMain.init();
/* 170 */     BuildingRender.init();
/* 171 */     Shop.init();
/* 174 */     addKeyListener(new KeyManager());
/* 175 */     addMouseListener(new MouseManager());
/* 176 */     addMouseMotionListener(new MouseMotion());
/*     */   }
/*     */   
/*     */   public synchronized void start() {
/* 181 */     if (running)
/*     */       return; 
/* 184 */     running = true;
/* 185 */     this.gameThread = new Thread(this);
/* 186 */     this.gameThread.start();
/*     */   }
/*     */   
/*     */   public synchronized void stop() {
/* 191 */     if (!running)
/*     */       return; 
/* 194 */     running = false;
/*     */     try {
/* 196 */       this.gameThread.join();
/* 197 */     } catch (InterruptedException e) {
/* 198 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void run() {
/*     */     try {
/* 204 */       init();
/* 205 */     } catch (IOException e) {
/* 206 */       e.printStackTrace();
/*     */     } 
/* 208 */     long lastTime = System.nanoTime();
/* 209 */     long timer = System.currentTimeMillis();
/* 210 */     double amountOfTicks = 60.0D;
/* 211 */     double ns = 1.6666666666666666E7D;
/* 212 */     double delta = 0.0D;
/* 213 */     requestFocus();
/* 216 */     while (running) {
/* 217 */       long now = System.nanoTime();
/* 218 */       delta += (now - lastTime) / ns;
/* 219 */       lastTime = now;
/* 220 */       if (delta >= 1.0D) {
/* 221 */         tick();
/* 222 */         updates++;
/* 223 */         delta--;
/*     */       } 
/* 225 */       render();
/* 226 */       frames++;
/* 227 */       if (System.currentTimeMillis() - timer > 1000L) {
/* 228 */         timer += 1000L;
/* 229 */         currentFrames = frames;
/* 230 */         currentUpdates = updates;
/* 231 */         updates = 0;
/* 232 */         frames = 0;
/*     */       } 
/*     */     } 
/* 235 */     stop();
/*     */   }
/*     */   
/*     */   public void tick() {
/* 243 */     if (isInGame && !PauseMenu.isOpen) {
/* 244 */       long thisTime = System.currentTimeMillis();
/* 245 */       if (thisTime - this.lastTime >= 180000L) {
/* 246 */         this.lastTime = thisTime;
/*     */         try {
/* 248 */           if (MainMenu.currentProfile == 1) {
/* 249 */             Save.profileSave(Save.save1, save1Path, 1);
/* 250 */           } else if (MainMenu.currentProfile == 2) {
/* 251 */             Save.profileSave(Save.save2, save2Path, 2);
/* 252 */           } else if (MainMenu.currentProfile == 3) {
/* 253 */             Save.profileSave(Save.save3, save3Path, 3);
/*     */           } 
/* 255 */         } catch (IOException e) {
/* 256 */           e.printStackTrace();
/*     */         } 
/*     */       } 
/* 259 */       MainMenu.playState = 1;
/* 260 */       inventoryMain.tick();
/* 261 */       CollisionManager.tick();
/* 262 */       player.tick();
/* 264 */     } else if (!isInGame && !PauseMenu.isOpen) {
/* 265 */       mainmenu.tick();
/* 266 */     } else if (isInGame && PauseMenu.isOpen) {
/* 267 */       pauseMenu.tick();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render() {
/* 277 */     BufferStrategy bs = getBufferStrategy();
/* 279 */     if (bs == null) {
/* 280 */       createBufferStrategy(3);
/*     */       return;
/*     */     } 
/* 284 */     Graphics g = bs.getDrawGraphics();
/* 287 */     g.fillRect(0, 0, 838, 573);
/* 289 */     g.setColor(Color.WHITE);
/* 292 */     if (isInGame && !PauseMenu.isOpen) {
/* 293 */       grassm.render(g);
/* 296 */       player.render(g);
/* 297 */       inventoryMain.render(g);
/* 298 */     } else if (!isInGame && !PauseMenu.isOpen) {
/* 299 */       mainmenu.renderMain(g);
/* 300 */     } else if (isInGame && PauseMenu.isOpen) {
/* 301 */       pauseMenu.renderMain(g);
/*     */     } 
/* 304 */     if (F3Menu.f3menu)
/* 305 */       f3menu.render(g); 
/* 309 */     g.dispose();
/* 310 */     bs.show();
/*     */   }
/*     */   
/*     */   public static void main(String[] args) throws Exception {
/* 317 */     Game game = new Game();
/* 318 */     game.setPreferredSize(new Dimension(838, 573));
/* 319 */     game.setMaximumSize(new Dimension(838, 573));
/* 320 */     game.setMinimumSize(new Dimension(838, 573));
/* 323 */     JFrame frame = new JFrame(title);
/* 324 */     frame.setSize(838, 573);
/* 325 */     frame.setDefaultCloseOperation(3);
/* 326 */     frame.setResizable(false);
/* 327 */     frame.add(game);
/* 328 */     frame.setVisible(true);
/* 329 */     frame.setLocationRelativeTo((Component)null);
/* 330 */     frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
/* 331 */           JFrame.class.getResource("/icon32.png")));
/*     */     try {
/* 336 */       boolean bool = (new File("C:\\Users\\" + 
/* 337 */           System.getProperty("user.name") + 
/* 338 */           "\\AppData\\Roaming\\Beyond Origins")).mkdir();
/* 340 */     } catch (Exception e) {
/* 341 */       e.printStackTrace();
/*     */     } 
/* 345 */     game.start();
/*     */   }
/*     */   
/*     */   public static GrassMap getGrassMap() {
/* 349 */     return grassm;
/*     */   }
/*     */   
/*     */   public static Player getPlayer() {
/* 353 */     return player;
/*     */   }
/*     */   
/*     */   public static Cow getCow() {
/* 357 */     return cow;
/*     */   }
/*     */   
/*     */   public static F3Menu getF3Menu() {
/* 361 */     return f3menu;
/*     */   }
/*     */   
/*     */   public static MainMenu getMainMenu() {
/* 365 */     return mainmenu;
/*     */   }
/*     */   
/*     */   public static InventoryMain getInventoryMain() {
/* 369 */     return inventoryMain;
/*     */   }
/*     */   
/*     */   public static BuildingRender getBuildingRender() {
/* 373 */     return buildingr;
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4.8_3.jar!\beyondOrigins\main\Game.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */