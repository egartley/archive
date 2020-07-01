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
/*  33 */   public static int playerSpawnX = 398;
/*     */   
/*  34 */   public static int playerSpawnY = 263;
/*     */   
/*  36 */   public static String title = "Beyond Origins 0.0.3 Alpha";
/*     */   
/*  37 */   public static String author = "Evan Gartley";
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
/*  45 */   public static Font mminfo1 = new Font("Minecraft", 0, 12);
/*     */   
/*  46 */   public static Font default1 = new Font("DejaVu Sans", 1, 12);
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
/*  55 */     ImageLoader loader = new ImageLoader();
/*  57 */     this.playerSheet = loader.load("/player.png");
/*  58 */     this.terrain1Sheet = loader.load("/terrain1.png");
/*  59 */     this.animal1Sheet = loader.load("/animals1.png");
/*  60 */     this.mainSheet = loader.load("/mainmenu.png");
/*  62 */     SpriteSheet ssplr = new SpriteSheet(this.playerSheet, this.playerSheet);
/*  63 */     SpriteSheet sstr1 = new SpriteSheet(this.terrain1Sheet, this.terrain1Sheet);
/*  64 */     SpriteSheet sscow = new SpriteSheet(this.animal1Sheet, this.animal1Sheet);
/*  65 */     SpriteSheet ssmnm = new SpriteSheet(this.mainSheet, this.mainSheet);
/*  67 */     this.implr = new ImageManager(ssplr);
/*  68 */     this.immnm = new ImageManager(ssmnm);
/*  69 */     this.imani = new ImageManager(sscow);
/*  70 */     this.imtr1 = new ImageManager(sstr1);
/*  74 */     mainmenu = new MainMenu(MainMenu.cloud1x, MainMenu.cloud1y, this.immnm);
/*  76 */     grassm = new GrassMap(this.imtr1);
/*  77 */     player = new Player(playerSpawnX, playerSpawnY, playerSpawnX, 
/*  78 */         playerSpawnY, this.implr);
/*  79 */     f3menu = new F3Menu(this.imf3);
/*  80 */     cow = new Cow(this.imani);
/*  84 */     GrassMap.init();
/*  86 */     addKeyListener(new KeyManager());
/*  87 */     addMouseListener(new MouseManager());
/*  88 */     addMouseMotionListener(new MouseMotion());
/*     */   }
/*     */   
/*     */   public synchronized void start() {
/*  92 */     if (running)
/*     */       return; 
/*  94 */     running = true;
/*  95 */     this.gameThread = new Thread(this);
/*  96 */     this.gameThread.start();
/*     */   }
/*     */   
/*     */   public synchronized void stop() {
/* 100 */     if (!running)
/*     */       return; 
/* 102 */     running = false;
/*     */     try {
/* 104 */       this.gameThread.join();
/* 105 */     } catch (InterruptedException e) {
/* 106 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void run() {
/* 111 */     init();
/* 112 */     long lastTime = System.nanoTime();
/* 113 */     long timer = System.currentTimeMillis();
/* 114 */     double amountOfTicks = 60.0D;
/* 115 */     double ns = 1.6666666666666666E7D;
/* 116 */     double delta = 0.0D;
/* 117 */     requestFocus();
/* 118 */     while (running) {
/* 119 */       long now = System.nanoTime();
/* 120 */       delta += (now - lastTime) / ns;
/* 121 */       lastTime = now;
/* 122 */       if (delta >= 1.0D) {
/* 123 */         tick();
/* 124 */         updates++;
/* 125 */         delta--;
/*     */       } 
/* 127 */       render();
/* 128 */       frames++;
/* 130 */       if (System.currentTimeMillis() - timer > 1000L) {
/* 131 */         timer += 1000L;
/* 132 */         currentFrames = frames;
/* 133 */         currentUpdates = updates;
/* 134 */         updates = 0;
/* 135 */         frames = 0;
/*     */       } 
/*     */     } 
/* 139 */     stop();
/*     */   }
/*     */   
/*     */   public void tick() {
/* 143 */     mainmenu.tick();
/* 144 */     if (gameRequested) {
/* 145 */       cow.tick();
/* 146 */       grassm.tick();
/* 147 */       player.tick();
/* 148 */       f3menu.tick();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render() {
/* 154 */     BufferStrategy bs = getBufferStrategy();
/* 155 */     if (bs == null) {
/* 156 */       createBufferStrategy(3);
/*     */       return;
/*     */     } 
/* 159 */     Graphics g = bs.getDrawGraphics();
/* 163 */     g.fillRect(0, 0, 838, 1146);
/* 166 */     g.setColor(Color.WHITE);
/* 168 */     mainmenu.render(g);
/* 170 */     if (gameRequested) {
/* 171 */       grassm.render(g);
/* 172 */       player.render(g);
/* 173 */       cow.render(g);
/*     */     } 
/* 176 */     f3menu.render(g);
/* 179 */     g.dispose();
/* 180 */     bs.show();
/*     */   }
/*     */   
/*     */   public static void main(String[] args) {
/* 184 */     Game game = new Game();
/* 185 */     game.setPreferredSize(new Dimension(838, 573));
/* 186 */     game.setMaximumSize(new Dimension(838, 573));
/* 187 */     game.setMinimumSize(new Dimension(838, 573));
/* 189 */     JFrame frame = new JFrame(title);
/* 190 */     frame.setSize(838, 573);
/* 191 */     frame.setDefaultCloseOperation(3);
/* 192 */     frame.setResizable(false);
/* 193 */     frame.add(game);
/* 194 */     frame.setVisible(true);
/* 195 */     frame.setLocationRelativeTo((Component)null);
/* 197 */     game.start();
/*     */   }
/*     */   
/*     */   public static GrassMap getGrassMap() {
/* 201 */     return grassm;
/*     */   }
/*     */   
/*     */   public static Player getPlayer() {
/* 205 */     return player;
/*     */   }
/*     */   
/*     */   public static Cow getCow() {
/* 209 */     return cow;
/*     */   }
/*     */   
/*     */   public static F3Menu getF3Menu() {
/* 213 */     return f3menu;
/*     */   }
/*     */   
/*     */   public static MainMenu getMainMenu() {
/* 217 */     return mainmenu;
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.3_4.jar!\applecraft\testgame\main\Game.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */