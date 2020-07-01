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
/*     */ import java.awt.Font;
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
/*  32 */   public static int playerSpawnX = 398;
/*     */   
/*  33 */   public static int playerSpawnY = 263;
/*     */   
/*  35 */   public static String title = "Beyond Origins 0.0.3.8 Alpha";
/*     */   
/*  36 */   public static String copyright = "Evan Gartley";
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
/*  44 */   public static Font mminfo1 = new Font("Minecraft", 0, 16);
/*     */   
/*  45 */   public static Font default1 = new Font("DejaVu Sans", 1, 12);
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
/*  54 */     ImageLoader loader = new ImageLoader();
/*  56 */     this.playerSheet = loader.load("/player.png");
/*  57 */     this.terrain1Sheet = loader.load("/terrain1.png");
/*  58 */     this.animal1Sheet = loader.load("/animals1.png");
/*  59 */     this.mainSheet = loader.load("/mainmenu.png");
/*  61 */     SpriteSheet ssplr = new SpriteSheet(this.playerSheet, this.playerSheet);
/*  62 */     SpriteSheet sstr1 = new SpriteSheet(this.terrain1Sheet, this.terrain1Sheet);
/*  63 */     SpriteSheet sscow = new SpriteSheet(this.animal1Sheet, this.animal1Sheet);
/*  64 */     SpriteSheet ssmnm = new SpriteSheet(this.mainSheet, this.mainSheet);
/*  66 */     this.implr = new ImageManager(ssplr);
/*  67 */     this.immnm = new ImageManager(ssmnm);
/*  68 */     this.imani = new ImageManager(sscow);
/*  69 */     this.imtr1 = new ImageManager(sstr1);
/*  73 */     mainmenu = new MainMenu(MainMenu.cloud1x, MainMenu.cloud1y, this.immnm);
/*  75 */     grassm = new GrassMap(this.imtr1);
/*  76 */     player = new Player(playerSpawnX, playerSpawnY, playerSpawnX, 
/*  77 */         playerSpawnY, this.implr);
/*  78 */     f3menu = new F3Menu(this.imf3);
/*  79 */     cow = new Cow(this.imani);
/*  83 */     GrassMap.init();
/*  85 */     addKeyListener(new KeyManager());
/*  86 */     addMouseListener(new MouseManager());
/*  87 */     addMouseMotionListener(new MouseMotion());
/*     */   }
/*     */   
/*     */   public synchronized void start() {
/*  91 */     if (running)
/*     */       return; 
/*  93 */     running = true;
/*  94 */     this.gameThread = new Thread(this);
/*  95 */     this.gameThread.start();
/*     */   }
/*     */   
/*     */   public synchronized void stop() {
/*  99 */     if (!running)
/*     */       return; 
/* 101 */     running = false;
/*     */     try {
/* 103 */       this.gameThread.join();
/* 104 */     } catch (InterruptedException e) {
/* 105 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void run() {
/* 110 */     init();
/* 111 */     long lastTime = System.nanoTime();
/* 112 */     long timer = System.currentTimeMillis();
/* 113 */     double amountOfTicks = 60.0D;
/* 114 */     double ns = 1.6666666666666666E7D;
/* 115 */     double delta = 0.0D;
/* 116 */     requestFocus();
/* 117 */     while (running) {
/* 118 */       long now = System.nanoTime();
/* 119 */       delta += (now - lastTime) / ns;
/* 120 */       lastTime = now;
/* 121 */       if (delta >= 1.0D) {
/* 122 */         tick();
/* 123 */         updates++;
/* 124 */         delta--;
/*     */       } 
/* 126 */       render();
/* 127 */       frames++;
/* 129 */       if (System.currentTimeMillis() - timer > 1000L) {
/* 130 */         timer += 1000L;
/* 131 */         currentFrames = frames;
/* 132 */         currentUpdates = updates;
/* 133 */         updates = 0;
/* 134 */         frames = 0;
/*     */       } 
/*     */     } 
/* 138 */     stop();
/*     */   }
/*     */   
/*     */   public void tick() {
/* 142 */     mainmenu.tick();
/* 143 */     if (gameRequested) {
/* 144 */       cow.tick();
/* 145 */       grassm.tick();
/* 146 */       player.tick();
/* 147 */       f3menu.tick();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render() {
/* 153 */     BufferStrategy bs = getBufferStrategy();
/* 154 */     if (bs == null) {
/* 155 */       createBufferStrategy(3);
/*     */       return;
/*     */     } 
/* 158 */     Graphics g = bs.getDrawGraphics();
/* 162 */     g.fillRect(0, 0, 838, 1146);
/* 165 */     g.setColor(Color.WHITE);
/* 167 */     mainmenu.render(g);
/* 169 */     if (gameRequested) {
/* 170 */       grassm.render(g);
/* 171 */       player.render(g);
/* 172 */       cow.render(g);
/*     */     } 
/* 175 */     f3menu.render(g);
/* 178 */     g.dispose();
/* 179 */     bs.show();
/*     */   }
/*     */   
/*     */   public static void main(String[] args) {
/* 183 */     Game game = new Game();
/* 184 */     game.setPreferredSize(new Dimension(838, 573));
/* 185 */     game.setMaximumSize(new Dimension(838, 573));
/* 186 */     game.setMinimumSize(new Dimension(838, 573));
/* 188 */     JFrame frame = new JFrame(title);
/* 189 */     frame.setSize(838, 573);
/* 190 */     frame.setDefaultCloseOperation(3);
/* 191 */     frame.setResizable(false);
/* 192 */     frame.add(game);
/* 193 */     frame.setVisible(true);
/* 194 */     frame.setLocationRelativeTo((Component)null);
/* 196 */     game.start();
/*     */   }
/*     */   
/*     */   public static GrassMap getGrassMap() {
/* 200 */     return grassm;
/*     */   }
/*     */   
/*     */   public static Player getPlayer() {
/* 204 */     return player;
/*     */   }
/*     */   
/*     */   public static Cow getCow() {
/* 208 */     return cow;
/*     */   }
/*     */   
/*     */   public static F3Menu getF3Menu() {
/* 212 */     return f3menu;
/*     */   }
/*     */   
/*     */   public static MainMenu getMainMenu() {
/* 216 */     return mainmenu;
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.3_8.jar!\applecraft\testgame\main\Game.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */