/*     */ package applecraft.testgame.main;
/*     */ 
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
/*  41 */   public static int playerSpawnX = 398;
/*     */   
/*  42 */   public static int playerSpawnY = 263;
/*     */   
/*  44 */   public static String title = "Beyond Origins 0.0.4 Alpha";
/*     */   
/*  45 */   public static String copyright = "Copyright Evan Gartley 2014";
/*     */   
/*     */   public static boolean gameRequested = false;
/*     */   
/*  48 */   public static Font mminfo1 = new Font("Minecraft", 0, 16);
/*     */   
/*  49 */   public static Font default1 = new Font("DejaVu Sans", 0, 12);
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
/*     */   public void init() {
/*  64 */     ImageLoader loader = new ImageLoader();
/*  66 */     this.playerSheet = loader.load("/player.png");
/*  67 */     this.terrain1Sheet = loader.load("/terrain1.png");
/*  68 */     this.animal1Sheet = loader.load("/animals1.png");
/*  69 */     this.mainmenuSheet = loader.load("/mainmenu.png");
/*  70 */     this.inventorySheet = loader.load("/inventory.png");
/*  72 */     SpriteSheet ssplr = new SpriteSheet(this.playerSheet, this.playerSheet, 
/*  73 */         this.playerSheet);
/*  74 */     SpriteSheet sstr1 = new SpriteSheet(this.terrain1Sheet, this.terrain1Sheet, 
/*  75 */         this.terrain1Sheet);
/*  76 */     SpriteSheet sscow = new SpriteSheet(this.animal1Sheet, this.animal1Sheet, 
/*  77 */         this.animal1Sheet);
/*  78 */     SpriteSheet ssmnm = new SpriteSheet(this.mainmenuSheet, this.mainmenuSheet, 
/*  79 */         this.mainmenuSheet);
/*  80 */     SpriteSheet ssinv = new SpriteSheet(this.inventorySheet, this.inventorySheet, 
/*  81 */         this.inventorySheet);
/*  83 */     this.implr = new ImageManager(ssplr);
/*  84 */     this.immnm = new ImageManager(ssmnm);
/*  85 */     this.imani = new ImageManager(sscow);
/*  86 */     this.iminv = new ImageManager(ssinv);
/*  87 */     this.imtr1 = new ImageManager(sstr1);
/*  91 */     mainmenu = new MainMenu(MainMenu.cloud1x, MainMenu.cloud1y, this.immnm);
/*  93 */     grassm = new GrassMap(this.imtr1);
/*  94 */     player = new Player(playerSpawnX, playerSpawnY, playerSpawnX, 
/*  95 */         playerSpawnY, this.implr);
/*  96 */     inventoryMain = new InventoryMain(this.iminv, 1024, 1024);
/*  98 */     f3menu = new F3Menu(this.imf3);
/*  99 */     cow = new Cow(this.imani);
/* 103 */     GrassMap.init();
/* 104 */     InventoryMain.init();
/* 106 */     addKeyListener(new KeyManager());
/* 107 */     addMouseListener(new MouseManager());
/* 108 */     addMouseMotionListener(new MouseMotion());
/*     */   }
/*     */   
/*     */   public synchronized void start() {
/* 112 */     if (running)
/*     */       return; 
/* 114 */     running = true;
/* 115 */     this.gameThread = new Thread(this);
/* 116 */     this.gameThread.start();
/*     */   }
/*     */   
/*     */   public synchronized void stop() {
/* 120 */     if (!running)
/*     */       return; 
/* 122 */     running = false;
/*     */     try {
/* 124 */       this.gameThread.join();
/* 125 */     } catch (InterruptedException e) {
/* 126 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void run() {
/* 131 */     init();
/* 132 */     long lastTime = System.nanoTime();
/* 133 */     long timer = System.currentTimeMillis();
/* 134 */     double amountOfTicks = 60.0D;
/* 135 */     double ns = 1.6666666666666666E7D;
/* 136 */     double delta = 0.0D;
/* 137 */     requestFocus();
/* 138 */     while (running) {
/* 139 */       long now = System.nanoTime();
/* 140 */       delta += (now - lastTime) / ns;
/* 141 */       lastTime = now;
/* 142 */       if (delta >= 1.0D) {
/* 143 */         tick();
/* 144 */         updates++;
/* 145 */         delta--;
/*     */       } 
/* 147 */       render();
/* 148 */       frames++;
/* 150 */       if (System.currentTimeMillis() - timer > 1000L) {
/* 151 */         timer += 1000L;
/* 152 */         currentFrames = frames;
/* 153 */         currentUpdates = updates;
/* 154 */         updates = 0;
/* 155 */         frames = 0;
/*     */       } 
/*     */     } 
/* 159 */     stop();
/*     */   }
/*     */   
/*     */   public void tick() {
/* 163 */     mainmenu.tick();
/* 164 */     if (gameRequested) {
/* 166 */       grassm.tick();
/* 167 */       player.tick();
/* 168 */       f3menu.tick();
/* 169 */       inventoryMain.tick();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render() {
/* 175 */     BufferStrategy bs = getBufferStrategy();
/* 176 */     if (bs == null) {
/* 177 */       createBufferStrategy(3);
/*     */       return;
/*     */     } 
/* 180 */     Graphics g = bs.getDrawGraphics();
/* 184 */     g.fillRect(0, 0, 838, 1146);
/* 187 */     g.setColor(Color.WHITE);
/* 189 */     mainmenu.render(g);
/* 191 */     if (gameRequested) {
/* 192 */       grassm.render(g);
/* 193 */       player.render(g);
/* 195 */       inventoryMain.render(g);
/*     */     } 
/* 198 */     f3menu.render(g);
/* 201 */     g.dispose();
/* 202 */     bs.show();
/*     */   }
/*     */   
/*     */   public static void main(String[] args) {
/* 206 */     Game game = new Game();
/* 207 */     game.setPreferredSize(new Dimension(838, 573));
/* 208 */     game.setMaximumSize(new Dimension(838, 573));
/* 209 */     game.setMinimumSize(new Dimension(838, 573));
/* 211 */     JFrame frame = new JFrame(title);
/* 212 */     frame.setSize(838, 573);
/* 213 */     frame.setDefaultCloseOperation(3);
/* 214 */     frame.setResizable(false);
/* 215 */     frame.add(game);
/* 216 */     frame.setVisible(true);
/* 217 */     frame.setLocationRelativeTo((Component)null);
/* 218 */     frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
/* 219 */           JFrame.class.getResource("/icon32.png")));
/* 232 */     game.start();
/*     */   }
/*     */   
/*     */   public static GrassMap getGrassMap() {
/* 236 */     return grassm;
/*     */   }
/*     */   
/*     */   public static Player getPlayer() {
/* 240 */     return player;
/*     */   }
/*     */   
/*     */   public static Cow getCow() {
/* 244 */     return cow;
/*     */   }
/*     */   
/*     */   public static F3Menu getF3Menu() {
/* 248 */     return f3menu;
/*     */   }
/*     */   
/*     */   public static MainMenu getMainMenu() {
/* 252 */     return mainmenu;
/*     */   }
/*     */   
/*     */   public static InventoryMain getInventoryMain() {
/* 256 */     return inventoryMain;
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4_1.jar!\applecraft\testgame\main\Game.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */