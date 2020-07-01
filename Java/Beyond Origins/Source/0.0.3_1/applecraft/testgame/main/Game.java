/*     */ package applecraft.testgame.main;
/*     */ 
/*     */ import applecraft.testgame.main.entities.Cow;
/*     */ import applecraft.testgame.main.entities.Player;
/*     */ import applecraft.testgame.main.gfx.ImageLoader;
/*     */ import applecraft.testgame.main.gfx.ImageManager;
/*     */ import applecraft.testgame.main.gfx.SpriteSheet;
/*     */ import applecraft.testgame.main.maps.GrassMap;
/*     */ import applecraft.testgame.main.menus.F3Menu;
/*     */ import applecraft.testgame.main.menus.MainMenu;
/*     */ import java.awt.Canvas;
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.image.BufferStrategy;
/*     */ import java.awt.image.BufferedImage;
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
/*     */   public static int frames;
/*     */   
/*     */   public static int currentFrames;
/*     */   
/*     */   public static int updates;
/*     */   
/*     */   public static int currentUpdates;
/*     */   
/*  31 */   public static int playerSpawnX = 398;
/*     */   
/*  32 */   public static int playerSpawnY = 263;
/*     */   
/*  34 */   public static String title = "Beyond Origins 0.0.3";
/*     */   
/*     */   public static boolean gameRequested = false;
/*     */   
/*     */   private BufferedImage playerSheet;
/*     */   
/*     */   private BufferedImage terrain1Sheet;
/*     */   
/*     */   private BufferedImage animal1Sheet;
/*     */   
/*     */   private BufferedImage mainSheet;
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
/*     */   public void init() {
/*  49 */     ImageLoader loader = new ImageLoader();
/*  51 */     this.playerSheet = loader.load("/player.png");
/*  52 */     this.terrain1Sheet = loader.load("/terrain1.png");
/*  53 */     this.animal1Sheet = loader.load("/animals1.png");
/*  54 */     this.mainSheet = loader.load("/mainmenu.png");
/*  56 */     SpriteSheet ssplr = new SpriteSheet(this.playerSheet, this.playerSheet);
/*  57 */     SpriteSheet sstr1 = new SpriteSheet(this.terrain1Sheet, this.terrain1Sheet);
/*  58 */     SpriteSheet sscow = new SpriteSheet(this.animal1Sheet, this.animal1Sheet);
/*  59 */     SpriteSheet ssmnm = new SpriteSheet(this.mainSheet, this.mainSheet);
/*  61 */     this.implr = new ImageManager(ssplr);
/*  62 */     this.immnm = new ImageManager(ssmnm);
/*  63 */     this.imani = new ImageManager(sscow);
/*  64 */     this.imtr1 = new ImageManager(sstr1);
/*  68 */     mainmenu = new MainMenu(this.immnm);
/*  70 */     grassm = new GrassMap(this.imtr1);
/*  71 */     player = new Player(playerSpawnX, playerSpawnY, playerSpawnX, 
/*  72 */         playerSpawnY, this.implr);
/*  73 */     f3menu = new F3Menu(this.imf3);
/*  74 */     cow = new Cow(this.imani);
/*  78 */     GrassMap.init();
/*  80 */     addKeyListener(new KeyManager());
/*  81 */     addMouseListener(new MouseManager());
/*  82 */     addMouseMotionListener(new MouseMotion());
/*     */   }
/*     */   
/*     */   public synchronized void start() {
/*  86 */     if (running)
/*     */       return; 
/*  88 */     running = true;
/*  89 */     this.gameThread = new Thread(this);
/*  90 */     this.gameThread.start();
/*     */   }
/*     */   
/*     */   public synchronized void stop() {
/*  94 */     if (!running)
/*     */       return; 
/*  96 */     running = false;
/*     */     try {
/*  98 */       this.gameThread.join();
/*  99 */     } catch (InterruptedException e) {
/* 100 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void run() {
/* 105 */     init();
/* 106 */     long lastTime = System.nanoTime();
/* 107 */     long timer = System.currentTimeMillis();
/* 108 */     double amountOfTicks = 60.0D;
/* 109 */     double ns = 1.6666666666666666E7D;
/* 110 */     double delta = 0.0D;
/* 111 */     requestFocus();
/* 112 */     while (running) {
/* 113 */       long now = System.nanoTime();
/* 114 */       delta += (now - lastTime) / ns;
/* 115 */       lastTime = now;
/* 116 */       if (delta >= 1.0D) {
/* 117 */         tick();
/* 118 */         updates++;
/* 119 */         delta--;
/*     */       } 
/* 121 */       render();
/* 122 */       frames++;
/* 124 */       if (System.currentTimeMillis() - timer > 1000L) {
/* 125 */         timer += 1000L;
/* 126 */         currentFrames = frames;
/* 127 */         currentUpdates = updates;
/* 128 */         updates = 0;
/* 129 */         frames = 0;
/*     */       } 
/*     */     } 
/* 133 */     stop();
/*     */   }
/*     */   
/*     */   public void tick() {
/* 137 */     if (gameRequested) {
/* 138 */       cow.tick();
/* 139 */       grassm.tick();
/* 140 */       player.tick();
/* 141 */       f3menu.tick();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render() {
/* 147 */     BufferStrategy bs = getBufferStrategy();
/* 148 */     if (bs == null) {
/* 149 */       createBufferStrategy(3);
/*     */       return;
/*     */     } 
/* 152 */     Graphics g = bs.getDrawGraphics();
/* 156 */     g.fillRect(0, 0, 838, 1146);
/* 159 */     g.setColor(Color.WHITE);
/* 161 */     mainmenu.render(g);
/* 163 */     if (gameRequested) {
/* 165 */       grassm.render(g);
/* 166 */       player.render(g);
/* 168 */       cow.render(g);
/*     */     } 
/* 171 */     f3menu.render(g);
/* 174 */     g.dispose();
/* 175 */     bs.show();
/*     */   }
/*     */   
/*     */   public static void main(String[] args) {
/* 179 */     Game game = new Game();
/* 180 */     game.setPreferredSize(new Dimension(838, 573));
/* 181 */     game.setMaximumSize(new Dimension(838, 573));
/* 182 */     game.setMinimumSize(new Dimension(838, 573));
/* 184 */     JFrame frame = new JFrame(title);
/* 185 */     frame.setSize(838, 573);
/* 186 */     frame.setDefaultCloseOperation(3);
/* 187 */     frame.setResizable(false);
/* 188 */     frame.add(game);
/* 189 */     frame.setVisible(true);
/* 190 */     frame.setLocationRelativeTo((Component)null);
/* 192 */     game.start();
/*     */   }
/*     */   
/*     */   public static GrassMap getGrassMap() {
/* 196 */     return grassm;
/*     */   }
/*     */   
/*     */   public static Player getPlayer() {
/* 200 */     return player;
/*     */   }
/*     */   
/*     */   public static Cow getCow() {
/* 204 */     return cow;
/*     */   }
/*     */   
/*     */   public static F3Menu getF3Menu() {
/* 208 */     return f3menu;
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.3_1.jar!\applecraft\testgame\main\Game.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */