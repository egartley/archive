/*     */ package applecraft.testgame.main;
/*     */ 
/*     */ import applecraft.testgame.main.entities.Cow;
/*     */ import applecraft.testgame.main.entities.Player;
/*     */ import applecraft.testgame.main.gfx.ImageLoader;
/*     */ import applecraft.testgame.main.gfx.ImageManager;
/*     */ import applecraft.testgame.main.gfx.SpriteSheet;
/*     */ import applecraft.testgame.main.maps.GrassMap;
/*     */ import applecraft.testgame.main.menus.F3Menu;
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
/*  29 */   public static int playerSpawnX = 398;
/*     */   
/*  30 */   public static int playerSpawnY = 263;
/*     */   
/*  32 */   public static String title = "Beyond Origins 0.0.2.8 DEV BUILD";
/*     */   
/*     */   private BufferedImage playerSheet;
/*     */   
/*     */   private BufferedImage terrain1Sheet;
/*     */   
/*     */   private BufferedImage animal1Sheet;
/*     */   
/*     */   private ImageManager implr;
/*     */   
/*     */   private ImageManager imtr1;
/*     */   
/*     */   private ImageManager imani;
/*     */   
/*     */   private ImageManager imf3;
/*     */   
/*     */   private static Player player;
/*     */   
/*     */   private static GrassMap grassm;
/*     */   
/*     */   private static Cow cow;
/*     */   
/*     */   private static F3Menu f3menu;
/*     */   
/*     */   public void init() {
/*  44 */     ImageLoader loader = new ImageLoader();
/*  45 */     this.playerSheet = loader.load("/player.png");
/*  46 */     this.terrain1Sheet = loader.load("/terrain1.png");
/*  47 */     this.animal1Sheet = loader.load("/animals1.png");
/*  49 */     SpriteSheet ssplr = new SpriteSheet(this.playerSheet, this.playerSheet, 
/*  50 */         this.playerSheet);
/*  51 */     SpriteSheet sstr1 = new SpriteSheet(this.terrain1Sheet, this.terrain1Sheet, 
/*  52 */         this.terrain1Sheet);
/*  53 */     SpriteSheet sscow = new SpriteSheet(this.animal1Sheet, this.animal1Sheet, 
/*  54 */         this.animal1Sheet);
/*  56 */     this.implr = new ImageManager(ssplr);
/*  57 */     this.imani = new ImageManager(sscow);
/*  58 */     this.imtr1 = new ImageManager(sstr1);
/*  62 */     grassm = new GrassMap(this.imtr1);
/*  63 */     player = new Player(playerSpawnX, playerSpawnY, playerSpawnX, 
/*  64 */         playerSpawnY, this.implr);
/*  65 */     f3menu = new F3Menu(this.imf3);
/*  66 */     cow = new Cow(this.imani);
/*  70 */     GrassMap.init();
/*  72 */     addKeyListener(new KeyManager());
/*     */   }
/*     */   
/*     */   public synchronized void start() {
/*  76 */     if (running)
/*     */       return; 
/*  78 */     running = true;
/*  79 */     this.gameThread = new Thread(this);
/*  80 */     this.gameThread.start();
/*     */   }
/*     */   
/*     */   public synchronized void stop() {
/*  84 */     if (!running)
/*     */       return; 
/*  86 */     running = false;
/*     */     try {
/*  88 */       this.gameThread.join();
/*  89 */     } catch (InterruptedException e) {
/*  90 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void run() {
/*  95 */     init();
/*  96 */     long lastTime = System.nanoTime();
/*  97 */     long timer = System.currentTimeMillis();
/*  98 */     double amountOfTicks = 60.0D;
/*  99 */     double ns = 1.6666666666666666E7D;
/* 100 */     double delta = 0.0D;
/* 101 */     requestFocus();
/* 102 */     while (running) {
/* 103 */       long now = System.nanoTime();
/* 104 */       delta += (now - lastTime) / ns;
/* 105 */       lastTime = now;
/* 106 */       if (delta >= 1.0D) {
/* 107 */         tick();
/* 108 */         updates++;
/* 109 */         delta--;
/*     */       } 
/* 111 */       render();
/* 112 */       frames++;
/* 114 */       if (System.currentTimeMillis() - timer > 1000L) {
/* 115 */         timer += 1000L;
/* 116 */         currentFrames = frames;
/* 117 */         currentUpdates = updates;
/* 118 */         updates = 0;
/* 119 */         frames = 0;
/*     */       } 
/*     */     } 
/* 123 */     stop();
/*     */   }
/*     */   
/*     */   public void tick() {
/* 127 */     cow.tick();
/* 128 */     grassm.tick();
/* 129 */     player.tick();
/*     */   }
/*     */   
/*     */   public void render() {
/* 133 */     BufferStrategy bs = getBufferStrategy();
/* 134 */     if (bs == null) {
/* 135 */       createBufferStrategy(3);
/*     */       return;
/*     */     } 
/* 138 */     Graphics g = bs.getDrawGraphics();
/* 142 */     g.fillRect(0, 0, 838, 1146);
/* 145 */     g.setColor(Color.WHITE);
/* 148 */     grassm.render(g);
/* 149 */     player.render(g);
/* 150 */     f3menu.render(g);
/* 151 */     cow.render(g);
/* 154 */     g.dispose();
/* 155 */     bs.show();
/*     */   }
/*     */   
/*     */   public static void main(String[] args) {
/* 159 */     Game game = new Game();
/* 160 */     game.setPreferredSize(new Dimension(838, 573));
/* 161 */     game.setMaximumSize(new Dimension(838, 573));
/* 162 */     game.setMinimumSize(new Dimension(838, 573));
/* 164 */     JFrame frame = new JFrame(title);
/* 165 */     frame.setSize(838, 573);
/* 166 */     frame.setDefaultCloseOperation(3);
/* 167 */     frame.setResizable(false);
/* 168 */     frame.add(game);
/* 169 */     frame.setVisible(true);
/* 170 */     frame.setLocationRelativeTo((Component)null);
/* 172 */     game.start();
/*     */   }
/*     */   
/*     */   public static GrassMap getGrassMap() {
/* 176 */     return grassm;
/*     */   }
/*     */   
/*     */   public static Player getPlayer() {
/* 180 */     return player;
/*     */   }
/*     */   
/*     */   public static Cow getCow() {
/* 184 */     return cow;
/*     */   }
/*     */   
/*     */   public static F3Menu getF3Menu() {
/* 188 */     return f3menu;
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.2_8.jar!\applecraft\testgame\main\Game.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */