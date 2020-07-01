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
/*     */ import java.io.BufferedReader;
/*     */ import java.io.FileReader;
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
/*     */   public static FileReader fr1;
/*     */   
/*     */   public static FileReader fr2;
/*     */   
/*     */   public static BufferedReader rdr1;
/*     */   
/*     */   public static BufferedReader rdr2;
/*     */   
/*     */   public static int frames;
/*     */   
/*     */   public static int currentFrames;
/*     */   
/*     */   public static int updates;
/*     */   
/*     */   public static int currentUpdates;
/*     */   
/*  47 */   public static int playerSpawnX = 398;
/*     */   
/*  48 */   public static int playerSpawnY = 263;
/*     */   
/*  50 */   public static String title = "Beyond Origins 0.0.4.2 Alpha";
/*     */   
/*  51 */   public static String copyright = "Copyright Evan Gartley 2014";
/*     */   
/*     */   public static boolean gameRequested = false;
/*     */   
/*     */   public static boolean saveRequested = false;
/*     */   
/*     */   public static boolean loadRequested = false;
/*     */   
/*     */   public static boolean isOnMap = true;
/*     */   
/*  58 */   public static Font default1 = new Font("DejaVu Sans", 0, 12);
/*     */   
/*  59 */   public static Font default2 = new Font("MoolBoran", 0, 32);
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
/*     */   private ImageManager imshp;
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
/*  79 */     ImageLoader loader = new ImageLoader();
/*  81 */     this.playerSheet = loader.load("/player.png");
/*  82 */     this.terrain1Sheet = loader.load("/terrain1.png");
/*  83 */     this.animal1Sheet = loader.load("/animals1.png");
/*  84 */     this.mainmenuSheet = loader.load("/mainmenu.png");
/*  85 */     this.inventorySheet = loader.load("/inventory.png");
/*  86 */     inside1Image = loader.load("/inside1.png");
/*  87 */     logoImage = loader.load("/logo.png");
/*  89 */     SpriteSheet ssplr = new SpriteSheet(this.playerSheet);
/*  90 */     SpriteSheet sstr1 = new SpriteSheet(this.terrain1Sheet);
/*  91 */     SpriteSheet sscow = new SpriteSheet(this.animal1Sheet);
/*  92 */     SpriteSheet ssmnm = new SpriteSheet(this.mainmenuSheet);
/*  93 */     SpriteSheet ssinv = new SpriteSheet(this.inventorySheet);
/*  95 */     this.implr = new ImageManager(ssplr);
/*  96 */     this.immnm = new ImageManager(ssmnm);
/*  97 */     this.imani = new ImageManager(sscow);
/*  98 */     this.iminv = new ImageManager(ssinv);
/*  99 */     this.imtr1 = new ImageManager(sstr1);
/* 103 */     mainmenu = new MainMenu(MainMenu.cloud1x, MainMenu.cloud1y, this.immnm);
/* 104 */     grassm = new GrassMap(this.imtr1);
/* 105 */     player = new Player(playerSpawnX, playerSpawnY, playerSpawnX, 
/* 106 */         playerSpawnY, this.implr);
/* 107 */     inventoryMain = new InventoryMain(this.iminv);
/* 108 */     buildingr = new BuildingRender(this.imtr1);
/* 109 */     shopManager = new ShopManager(this.imshp);
/* 110 */     f3menu = new F3Menu(this.imf3);
/* 111 */     cow = new Cow(this.imani);
/* 115 */     GrassMap.init();
/* 116 */     MainMenu.init();
/* 117 */     InventoryMain.init();
/* 118 */     BuildingRender.init();
/* 119 */     ShopManager.init();
/* 121 */     addKeyListener(new KeyManager());
/* 122 */     addMouseListener(new MouseManager());
/* 123 */     addMouseMotionListener(new MouseMotion());
/*     */   }
/*     */   
/*     */   public synchronized void start() {
/* 127 */     if (running)
/*     */       return; 
/* 129 */     running = true;
/* 130 */     this.gameThread = new Thread(this);
/* 131 */     this.gameThread.start();
/*     */   }
/*     */   
/*     */   public synchronized void stop() {
/* 135 */     if (!running)
/*     */       return; 
/* 137 */     running = false;
/*     */     try {
/* 139 */       this.gameThread.join();
/* 140 */     } catch (InterruptedException e) {
/* 141 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void run() {
/* 146 */     init();
/* 147 */     long lastTime = System.nanoTime();
/* 148 */     long timer = System.currentTimeMillis();
/* 149 */     double amountOfTicks = 60.0D;
/* 150 */     double ns = 1.6666666666666666E7D;
/* 151 */     double delta = 0.0D;
/* 152 */     requestFocus();
/* 153 */     while (running) {
/* 154 */       long now = System.nanoTime();
/* 155 */       delta += (now - lastTime) / ns;
/* 156 */       lastTime = now;
/* 157 */       if (delta >= 1.0D) {
/* 158 */         tick();
/* 159 */         updates++;
/* 160 */         delta--;
/*     */       } 
/* 162 */       render();
/* 163 */       frames++;
/* 165 */       if (System.currentTimeMillis() - timer > 1000L) {
/* 166 */         timer += 1000L;
/* 167 */         currentFrames = frames;
/* 168 */         currentUpdates = updates;
/* 169 */         updates = 0;
/* 170 */         frames = 0;
/*     */       } 
/*     */     } 
/* 174 */     stop();
/*     */   }
/*     */   
/*     */   public void tick() {
/* 179 */     if (KeyManager.enterPressed)
/* 180 */       Save.save1(); 
/* 183 */     if (gameRequested) {
/* 185 */       inventoryMain.tick();
/* 186 */       buildingr.tick();
/* 187 */       CollisionManager.tick();
/* 188 */       player.tick();
/* 189 */       f3menu.tick();
/* 190 */       ShopManager.tick();
/*     */     } else {
/* 193 */       mainmenu.tick();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render() {
/* 199 */     BufferStrategy bs = getBufferStrategy();
/* 200 */     if (bs == null) {
/* 201 */       createBufferStrategy(3);
/*     */       return;
/*     */     } 
/* 204 */     Graphics g = bs.getDrawGraphics();
/* 208 */     g.fillRect(0, 0, 838, 1146);
/* 211 */     g.setColor(Color.WHITE);
/* 213 */     if (gameRequested) {
/* 214 */       grassm.render(g);
/* 215 */       buildingr.render(g);
/* 216 */       ShopManager.render(g);
/* 217 */       player.render(g);
/* 219 */       inventoryMain.render(g);
/*     */     } else {
/* 221 */       mainmenu.render(g);
/*     */     } 
/* 223 */     f3menu.render(g);
/* 226 */     g.dispose();
/* 227 */     bs.show();
/*     */   }
/*     */   
/*     */   public static void main(String[] args) throws Exception {
/* 231 */     Game game = new Game();
/* 232 */     game.setPreferredSize(new Dimension(838, 573));
/* 233 */     game.setMaximumSize(new Dimension(838, 573));
/* 234 */     game.setMinimumSize(new Dimension(838, 573));
/* 236 */     JFrame frame = new JFrame(title);
/* 237 */     frame.setSize(838, 573);
/* 238 */     frame.setDefaultCloseOperation(3);
/* 239 */     frame.setResizable(false);
/* 240 */     frame.add(game);
/* 241 */     frame.setVisible(true);
/* 242 */     frame.setLocationRelativeTo((Component)null);
/* 243 */     frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
/* 244 */           JFrame.class.getResource("/icon32.png")));
/*     */     try {
/* 247 */       fw1 = new FileWriter("C:\\Users\\" + 
/* 248 */           System.getProperty("user.name") + 
/* 249 */           "\\AppData\\Roaming\\Beyond Origins\\save1.zan");
/* 250 */       fw2 = new FileWriter("C:\\Users\\" + 
/* 251 */           System.getProperty("user.name") + 
/* 252 */           "\\AppData\\Roaming\\Beyond Origins\\options.zan");
/* 254 */       pw1 = new PrintWriter(fw1);
/* 255 */       pw2 = new PrintWriter(fw2);
/* 257 */     } catch (IOException e) {
/* 258 */       e.printStackTrace();
/*     */     } 
/* 261 */     fr1 = new FileReader("C://Users/" + System.getProperty("user.name") + 
/* 262 */         "/AppData/Roaming/Beyond Origins/save1.zan");
/* 263 */     fr2 = new FileReader("C://Users/" + System.getProperty("user.name") + 
/* 264 */         "/AppData/Roaming/Beyond Origins/options.zan");
/* 265 */     rdr1 = new BufferedReader(fr1);
/* 266 */     rdr2 = new BufferedReader(fr2);
/* 268 */     game.start();
/*     */   }
/*     */   
/*     */   public static GrassMap getGrassMap() {
/* 272 */     return grassm;
/*     */   }
/*     */   
/*     */   public static Player getPlayer() {
/* 276 */     return player;
/*     */   }
/*     */   
/*     */   public static Cow getCow() {
/* 280 */     return cow;
/*     */   }
/*     */   
/*     */   public static F3Menu getF3Menu() {
/* 284 */     return f3menu;
/*     */   }
/*     */   
/*     */   public static MainMenu getMainMenu() {
/* 288 */     return mainmenu;
/*     */   }
/*     */   
/*     */   public static InventoryMain getInventoryMain() {
/* 292 */     return inventoryMain;
/*     */   }
/*     */   
/*     */   public static BuildingRender getBuildingRender() {
/* 296 */     return buildingr;
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4.2_7.jar!\applecraft\testgame\main\Game.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */