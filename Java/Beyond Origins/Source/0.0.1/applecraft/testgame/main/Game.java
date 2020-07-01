/*     */ package applecraft.testgame.main;
/*     */ 
/*     */ import applecraft.testgame.main.entities.Player;
/*     */ import applecraft.testgame.main.gfx.ImageLoader;
/*     */ import applecraft.testgame.main.gfx.ImageManager;
/*     */ import applecraft.testgame.main.gfx.SpriteSheet;
/*     */ import applecraft.testgame.main.maps.GrassMap;
/*     */ import java.awt.Canvas;
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
/*     */   private BufferedImage playerSheet;
/*     */   
/*     */   private BufferedImage terrain1Sheet;
/*     */   
/*     */   private ImageManager implr;
/*     */   
/*     */   private ImageManager imtr1;
/*     */   
/*     */   private static Player player;
/*     */   
/*     */   private static GrassMap grassm;
/*     */   
/*     */   public void init() {
/*  30 */     ImageLoader loader = new ImageLoader();
/*  31 */     this.playerSheet = loader.load("/player.png");
/*  32 */     this.terrain1Sheet = loader.load("/terrain1.png");
/*  34 */     SpriteSheet ssplr = new SpriteSheet(this.playerSheet, this.playerSheet);
/*  35 */     SpriteSheet sstr1 = new SpriteSheet(this.terrain1Sheet, this.terrain1Sheet);
/*  37 */     this.implr = new ImageManager(ssplr);
/*  38 */     this.imtr1 = new ImageManager(sstr1);
/*  42 */     grassm = new GrassMap(this.imtr1);
/*  43 */     player = new Player(400, 242, this.implr);
/*  47 */     addKeyListener(new KeyManager());
/*     */   }
/*     */   
/*     */   public synchronized void start() {
/*  51 */     if (running)
/*     */       return; 
/*  52 */     running = true;
/*  53 */     this.gameThread = new Thread(this);
/*  54 */     this.gameThread.start();
/*     */   }
/*     */   
/*     */   public synchronized void stop() {
/*  58 */     if (!running)
/*     */       return; 
/*  59 */     running = false;
/*     */     try {
/*  61 */       this.gameThread.join();
/*     */     } catch (InterruptedException e) {
/*  62 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void run() {
/*  66 */     init();
/*  67 */     long lastTime = System.nanoTime();
/*  68 */     double amountOfTicks = 60.0D;
/*  69 */     double ns = 1.6666666666666666E7D;
/*  70 */     double delta = 0.0D;
/*  72 */     while (running) {
/*  73 */       long now = System.nanoTime();
/*  74 */       delta += (now - lastTime) / ns;
/*  75 */       lastTime = now;
/*  76 */       if (delta >= 1.0D) {
/*  77 */         tick();
/*  78 */         delta--;
/*     */       } 
/*  80 */       render();
/*     */     } 
/*  82 */     stop();
/*     */   }
/*     */   
/*     */   public void tick() {
/*  85 */     grassm.tick();
/*  86 */     player.tick();
/*     */   }
/*     */   
/*     */   public void render() {
/*  89 */     BufferStrategy bs = getBufferStrategy();
/*  90 */     if (bs == null) {
/*  91 */       createBufferStrategy(3);
/*     */       return;
/*     */     } 
/*  94 */     Graphics g = bs.getDrawGraphics();
/*  98 */     g.fillRect(0, 0, 838, 1146);
/* 101 */     grassm.render(g);
/* 102 */     player.render(g);
/* 105 */     g.dispose();
/* 106 */     bs.show();
/*     */   }
/*     */   
/*     */   public static void main(String[] args) {
/* 110 */     Game game = new Game();
/* 111 */     game.setPreferredSize(new Dimension(838, 573));
/* 112 */     game.setMaximumSize(new Dimension(838, 573));
/* 113 */     game.setMinimumSize(new Dimension(838, 573));
/* 115 */     JFrame frame = new JFrame("Beyond Origins 0.0.1");
/* 116 */     frame.setSize(838, 573);
/* 117 */     frame.setDefaultCloseOperation(3);
/* 118 */     frame.setResizable(false);
/* 119 */     frame.add(game);
/* 120 */     frame.setVisible(true);
/* 121 */     frame.setLocationRelativeTo((Component)null);
/* 122 */     frame.requestFocus();
/* 124 */     game.start();
/*     */   }
/*     */   
/*     */   public static GrassMap getGrassMap() {
/* 128 */     return grassm;
/*     */   }
/*     */   
/*     */   public static Player getPlayer() {
/* 132 */     return player;
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.1.jar!\applecraft\testgame\main\Game.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */