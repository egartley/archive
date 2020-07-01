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
/*     */   public static int frames;
/*     */   
/*     */   public static int updates;
/*     */   
/*  26 */   private int PlayerSpawnX = 400;
/*     */   
/*  26 */   private int PlayerSpawnY = 242;
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
/*  36 */     ImageLoader loader = new ImageLoader();
/*  37 */     this.playerSheet = loader.load("/player.png");
/*  38 */     this.terrain1Sheet = loader.load("/terrain1.png");
/*  39 */     this.cowSheet = loader.load("/cow.png");
/*  41 */     SpriteSheet ssplr = new SpriteSheet(this.playerSheet, this.playerSheet, this.playerSheet);
/*  42 */     SpriteSheet sstr1 = new SpriteSheet(this.terrain1Sheet, this.terrain1Sheet, this.terrain1Sheet);
/*  43 */     SpriteSheet sscow = new SpriteSheet(this.cowSheet, this.cowSheet, this.cowSheet);
/*  45 */     this.implr = new ImageManager(ssplr);
/*  46 */     this.imtr1 = new ImageManager(sstr1);
/*  50 */     grassm = new GrassMap(this.imtr1);
/*  51 */     player = new Player(this.PlayerSpawnX, this.PlayerSpawnY, this.implr);
/*  52 */     cow = new Cow(this.imcow);
/*  56 */     GrassMap.init();
/*  58 */     addKeyListener(new KeyManager());
/*     */   }
/*     */   
/*     */   public synchronized void start() {
/*  62 */     if (running)
/*     */       return; 
/*  63 */     running = true;
/*  64 */     this.gameThread = new Thread(this);
/*  65 */     this.gameThread.start();
/*     */   }
/*     */   
/*     */   public synchronized void stop() {
/*  69 */     if (!running)
/*     */       return; 
/*  70 */     running = false;
/*     */     try {
/*  72 */       this.gameThread.join();
/*     */     } catch (InterruptedException e) {
/*  73 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void run() {
/*  77 */     init();
/*  78 */     long lastTime = System.nanoTime();
/*  79 */     long timer = System.currentTimeMillis();
/*  80 */     double amountOfTicks = 60.0D;
/*  81 */     double ns = 1.6666666666666666E7D;
/*  82 */     double delta = 0.0D;
/*  84 */     while (running) {
/*  85 */       long now = System.nanoTime();
/*  86 */       delta += (now - lastTime) / ns;
/*  87 */       lastTime = now;
/*  88 */       if (delta >= 1.0D) {
/*  89 */         tick();
/*  90 */         updates++;
/*  91 */         delta--;
/*     */       } 
/*  93 */       render();
/*  94 */       frames++;
/*  96 */       if (System.currentTimeMillis() - timer > 1000L) {
/*  97 */         timer += 1000L;
/*  98 */         System.out.println(frames);
/*  99 */         updates = 0;
/* 100 */         frames = 0;
/*     */       } 
/*     */     } 
/* 104 */     stop();
/*     */   }
/*     */   
/*     */   public void tick() {
/* 107 */     cow.tick();
/* 108 */     grassm.tick();
/* 109 */     player.tick();
/*     */   }
/*     */   
/*     */   public void render() {
/* 112 */     BufferStrategy bs = getBufferStrategy();
/* 113 */     if (bs == null) {
/* 114 */       createBufferStrategy(3);
/*     */       return;
/*     */     } 
/* 117 */     Graphics g = bs.getDrawGraphics();
/* 121 */     g.fillRect(0, 0, 838, 1146);
/* 124 */     g.setColor(Color.WHITE);
/* 126 */     cow.render(g);
/* 127 */     grassm.render(g);
/* 128 */     player.render(g);
/* 131 */     g.dispose();
/* 132 */     bs.show();
/*     */   }
/*     */   
/*     */   public static void main(String[] args) {
/* 136 */     Game game = new Game();
/* 137 */     game.setPreferredSize(new Dimension(838, 573));
/* 138 */     game.setMaximumSize(new Dimension(838, 573));
/* 139 */     game.setMinimumSize(new Dimension(838, 573));
/* 141 */     JFrame frame = new JFrame("Beyond Origins 0.0.1.4");
/* 142 */     frame.setSize(838, 573);
/* 143 */     frame.setDefaultCloseOperation(3);
/* 144 */     frame.setResizable(false);
/* 145 */     frame.add(game);
/* 146 */     frame.setVisible(true);
/* 147 */     frame.setLocationRelativeTo((Component)null);
/* 148 */     frame.requestFocus();
/* 151 */     game.start();
/*     */   }
/*     */   
/*     */   public static GrassMap getGrassMap() {
/* 155 */     return grassm;
/*     */   }
/*     */   
/*     */   public static Player getPlayer() {
/* 159 */     return player;
/*     */   }
/*     */   
/*     */   public static Cow getCow() {
/* 163 */     return cow;
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.1_5.jar!\applecraft\testgame\main\Game.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */