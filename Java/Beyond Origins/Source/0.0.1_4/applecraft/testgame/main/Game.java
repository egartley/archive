/*     */ package applecraft.testgame.main;
/*     */ 
/*     */ import applecraft.testgame.main.entities.Cow;
/*     */ import applecraft.testgame.main.entities.Player;
/*     */ import applecraft.testgame.main.gfx.ImageLoader;
/*     */ import applecraft.testgame.main.gfx.ImageManager;
/*     */ import applecraft.testgame.main.gfx.SpriteSheet;
/*     */ import applecraft.testgame.main.maps.GrassMap;
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
/*     */   public static final int WIDTH = 419;
/*     */   
/*     */   public static final int HEIGHT = 573;
/*     */   
/*     */   public static final int SCALE = 2;
/*     */   
/*     */   public static boolean running = false;
/*     */   
/*     */   public Thread gameThread;
/*     */   
/*  24 */   private int PlayerSpawnX = 400;
/*     */   
/*  24 */   private int PlayerSpawnY = 242;
/*     */   
/*     */   private BufferedImage playerSheet;
/*     */   
/*     */   private BufferedImage terrain1Sheet;
/*     */   
/*     */   private BufferedImage cowSheet;
/*     */   
/*     */   private ImageManager implr;
/*     */   
/*     */   private ImageManager imtr1;
/*     */   
/*     */   private ImageManager imcow;
/*     */   
/*     */   private static Player player;
/*     */   
/*     */   private static GrassMap grassm;
/*     */   
/*     */   private static Cow cow;
/*     */   
/*     */   public void init() {
/*  34 */     ImageLoader loader = new ImageLoader();
/*  35 */     this.playerSheet = loader.load("/player.png");
/*  36 */     this.terrain1Sheet = loader.load("/terrain1.png");
/*  37 */     this.cowSheet = loader.load("/cow.png");
/*  39 */     SpriteSheet ssplr = new SpriteSheet(this.playerSheet, this.playerSheet, this.playerSheet);
/*  40 */     SpriteSheet sstr1 = new SpriteSheet(this.terrain1Sheet, this.terrain1Sheet, this.terrain1Sheet);
/*  41 */     SpriteSheet sscow = new SpriteSheet(this.cowSheet, this.cowSheet, this.cowSheet);
/*  43 */     this.implr = new ImageManager(ssplr);
/*  44 */     this.imtr1 = new ImageManager(sstr1);
/*  48 */     grassm = new GrassMap(this.imtr1);
/*  49 */     player = new Player(this.PlayerSpawnX, this.PlayerSpawnY, this.implr);
/*  50 */     cow = new Cow(this.imcow);
/*  54 */     GrassMap.init();
/*  56 */     addKeyListener(new KeyManager());
/*     */   }
/*     */   
/*     */   public synchronized void start() {
/*  60 */     if (running)
/*     */       return; 
/*  61 */     running = true;
/*  62 */     this.gameThread = new Thread(this);
/*  63 */     this.gameThread.start();
/*     */   }
/*     */   
/*     */   public synchronized void stop() {
/*  67 */     if (!running)
/*     */       return; 
/*  68 */     running = false;
/*     */     try {
/*  70 */       this.gameThread.join();
/*     */     } catch (InterruptedException e) {
/*  71 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void run() {
/*  75 */     init();
/*  76 */     long lastTime = System.nanoTime();
/*  77 */     double amountOfTicks = 60.0D;
/*  78 */     double ns = 1.6666666666666666E7D;
/*  79 */     double delta = 0.0D;
/*  81 */     while (running) {
/*  82 */       long now = System.nanoTime();
/*  83 */       delta += (now - lastTime) / ns;
/*  84 */       lastTime = now;
/*  85 */       if (delta >= 1.0D) {
/*  86 */         tick();
/*  87 */         delta--;
/*     */       } 
/*  89 */       render();
/*     */     } 
/*  91 */     stop();
/*     */   }
/*     */   
/*     */   public void tick() {
/*  94 */     cow.tick();
/*  95 */     grassm.tick();
/*  96 */     player.tick();
/*     */   }
/*     */   
/*     */   public void render() {
/*  99 */     BufferStrategy bs = getBufferStrategy();
/* 100 */     if (bs == null) {
/* 101 */       createBufferStrategy(3);
/*     */       return;
/*     */     } 
/* 104 */     Graphics g = bs.getDrawGraphics();
/* 108 */     g.fillRect(0, 0, 838, 1146);
/* 111 */     g.setColor(Color.WHITE);
/* 113 */     cow.render(g);
/* 114 */     grassm.render(g);
/* 115 */     player.render(g);
/* 118 */     g.dispose();
/* 119 */     bs.show();
/*     */   }
/*     */   
/*     */   public static void main(String[] args) {
/* 123 */     Game game = new Game();
/* 124 */     game.setPreferredSize(new Dimension(838, 573));
/* 125 */     game.setMaximumSize(new Dimension(838, 573));
/* 126 */     game.setMinimumSize(new Dimension(838, 573));
/* 128 */     JFrame frame = new JFrame("Beyond Origins 0.0.1.4");
/* 129 */     frame.setSize(838, 573);
/* 130 */     frame.setDefaultCloseOperation(3);
/* 131 */     frame.setResizable(false);
/* 132 */     frame.add(game);
/* 133 */     frame.setVisible(true);
/* 134 */     frame.setLocationRelativeTo((Component)null);
/* 135 */     frame.requestFocus();
/* 138 */     game.start();
/*     */   }
/*     */   
/*     */   public static GrassMap getGrassMap() {
/* 142 */     return grassm;
/*     */   }
/*     */   
/*     */   public static Player getPlayer() {
/* 146 */     return player;
/*     */   }
/*     */   
/*     */   public static Cow getCow() {
/* 150 */     return cow;
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.1_4.jar!\applecraft\testgame\main\Game.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */