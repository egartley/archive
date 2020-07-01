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
/*  29 */   public static int PlayerSpawnX = 398;
/*     */   
/*  30 */   public static int PlayerSpawnY = 263;
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
/*  42 */     ImageLoader loader = new ImageLoader();
/*  43 */     this.playerSheet = loader.load("/player.png");
/*  44 */     this.terrain1Sheet = loader.load("/terrain1.png");
/*  45 */     this.animal1Sheet = loader.load("/animals1.png");
/*  47 */     SpriteSheet ssplr = new SpriteSheet(this.playerSheet, this.playerSheet, this.playerSheet);
/*  48 */     SpriteSheet sstr1 = new SpriteSheet(this.terrain1Sheet, this.terrain1Sheet, this.terrain1Sheet);
/*  49 */     SpriteSheet sscow = new SpriteSheet(this.animal1Sheet, this.animal1Sheet, this.animal1Sheet);
/*  51 */     this.implr = new ImageManager(ssplr);
/*  52 */     this.imani = new ImageManager(sscow);
/*  53 */     this.imtr1 = new ImageManager(sstr1);
/*  57 */     grassm = new GrassMap(this.imtr1);
/*  58 */     player = new Player(PlayerSpawnX, PlayerSpawnY, PlayerSpawnX, PlayerSpawnY, this.implr);
/*  59 */     f3menu = new F3Menu(this.imf3);
/*  60 */     cow = new Cow(this.imani);
/*  64 */     GrassMap.init();
/*  66 */     addKeyListener(new KeyManager());
/*     */   }
/*     */   
/*     */   public synchronized void start() {
/*  70 */     if (running)
/*     */       return; 
/*  71 */     running = true;
/*  72 */     this.gameThread = new Thread(this);
/*  73 */     this.gameThread.start();
/*     */   }
/*     */   
/*     */   public synchronized void stop() {
/*  77 */     if (!running)
/*     */       return; 
/*  78 */     running = false;
/*     */     try {
/*  80 */       this.gameThread.join();
/*     */     } catch (InterruptedException e) {
/*  81 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void run() {
/*  85 */     init();
/*  86 */     long lastTime = System.nanoTime();
/*  87 */     long timer = System.currentTimeMillis();
/*  88 */     double amountOfTicks = 60.0D;
/*  89 */     double ns = 1.6666666666666666E7D;
/*  90 */     double delta = 0.0D;
/*  91 */     requestFocus();
/*  92 */     while (running) {
/*  93 */       long now = System.nanoTime();
/*  94 */       delta += (now - lastTime) / ns;
/*  95 */       lastTime = now;
/*  96 */       if (delta >= 1.0D) {
/*  97 */         tick();
/*  98 */         updates++;
/*  99 */         delta--;
/*     */       } 
/* 101 */       render();
/* 102 */       frames++;
/* 104 */       if (System.currentTimeMillis() - timer > 1000L) {
/* 105 */         timer += 1000L;
/* 106 */         currentFrames = frames;
/* 107 */         currentUpdates = updates;
/* 108 */         updates = 0;
/* 109 */         frames = 0;
/*     */       } 
/*     */     } 
/* 113 */     stop();
/*     */   }
/*     */   
/*     */   public void tick() {
/* 116 */     cow.tick();
/* 117 */     grassm.tick();
/* 118 */     player.tick();
/*     */   }
/*     */   
/*     */   public void render() {
/* 121 */     BufferStrategy bs = getBufferStrategy();
/* 122 */     if (bs == null) {
/* 123 */       createBufferStrategy(3);
/*     */       return;
/*     */     } 
/* 126 */     Graphics g = bs.getDrawGraphics();
/* 130 */     g.fillRect(0, 0, 838, 1146);
/* 133 */     g.setColor(Color.WHITE);
/* 136 */     grassm.render(g);
/* 137 */     player.render(g);
/* 138 */     f3menu.render(g);
/* 139 */     cow.render(g);
/* 142 */     g.dispose();
/* 143 */     bs.show();
/*     */   }
/*     */   
/*     */   public static void main(String[] args) {
/* 147 */     Game game = new Game();
/* 148 */     game.setPreferredSize(new Dimension(838, 573));
/* 149 */     game.setMaximumSize(new Dimension(838, 573));
/* 150 */     game.setMinimumSize(new Dimension(838, 573));
/* 152 */     JFrame frame = new JFrame("Beyond Origins 0.0.2.7 DEV BUILD");
/* 153 */     frame.setSize(838, 573);
/* 154 */     frame.setDefaultCloseOperation(3);
/* 155 */     frame.setResizable(false);
/* 156 */     frame.add(game);
/* 157 */     frame.setVisible(true);
/* 158 */     frame.setLocationRelativeTo((Component)null);
/* 160 */     game.start();
/*     */   }
/*     */   
/*     */   public static GrassMap getGrassMap() {
/* 164 */     return grassm;
/*     */   }
/*     */   
/*     */   public static Player getPlayer() {
/* 168 */     return player;
/*     */   }
/*     */   
/*     */   public static Cow getCow() {
/* 172 */     return cow;
/*     */   }
/*     */   
/*     */   public static F3Menu getF3Menu() {
/* 176 */     return f3menu;
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.2_7.jar!\applecraft\testgame\main\Game.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */