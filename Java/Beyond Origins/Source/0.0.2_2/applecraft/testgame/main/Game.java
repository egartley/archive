/*     */ package applecraft.testgame.main;
/*     */ 
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
/*     */   private ImageManager implr;
/*     */   
/*     */   private ImageManager imtr1;
/*     */   
/*     */   private ImageManager imf3;
/*     */   
/*     */   private static Player player;
/*     */   
/*     */   private static GrassMap grassm;
/*     */   
/*     */   private static F3Menu f3menu;
/*     */   
/*     */   public void init() {
/*  38 */     ImageLoader loader = new ImageLoader();
/*  39 */     this.playerSheet = loader.load("/player.png");
/*  40 */     this.terrain1Sheet = loader.load("/terrain1.png");
/*  43 */     SpriteSheet ssplr = new SpriteSheet(this.playerSheet, this.playerSheet, this.playerSheet);
/*  44 */     SpriteSheet sstr1 = new SpriteSheet(this.terrain1Sheet, this.terrain1Sheet, this.terrain1Sheet);
/*  47 */     this.implr = new ImageManager(ssplr);
/*  48 */     this.imtr1 = new ImageManager(sstr1);
/*  52 */     grassm = new GrassMap(this.imtr1);
/*  53 */     player = new Player(this.PlayerSpawnX, this.PlayerSpawnY, this.implr);
/*  54 */     f3menu = new F3Menu(this.imf3);
/*  59 */     GrassMap.init();
/*  61 */     addKeyListener(new KeyManager());
/*     */   }
/*     */   
/*     */   public synchronized void start() {
/*  65 */     if (running)
/*     */       return; 
/*  66 */     running = true;
/*  67 */     this.gameThread = new Thread(this);
/*  68 */     this.gameThread.start();
/*     */   }
/*     */   
/*     */   public synchronized void stop() {
/*  72 */     if (!running)
/*     */       return; 
/*  73 */     running = false;
/*     */     try {
/*  75 */       this.gameThread.join();
/*     */     } catch (InterruptedException e) {
/*  76 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void run() {
/*  80 */     init();
/*  81 */     long lastTime = System.nanoTime();
/*  82 */     long timer = System.currentTimeMillis();
/*  83 */     double amountOfTicks = 60.0D;
/*  84 */     double ns = 1.6666666666666666E7D;
/*  85 */     double delta = 0.0D;
/*  87 */     while (running) {
/*  88 */       long now = System.nanoTime();
/*  89 */       delta += (now - lastTime) / ns;
/*  90 */       lastTime = now;
/*  91 */       if (delta >= 1.0D) {
/*  92 */         tick();
/*  94 */         delta--;
/*     */       } 
/*  96 */       render();
/*  99 */       if (System.currentTimeMillis() - timer > 1000L)
/* 100 */         timer += 1000L; 
/*     */     } 
/* 107 */     stop();
/*     */   }
/*     */   
/*     */   public void tick() {
/* 111 */     grassm.tick();
/* 112 */     player.tick();
/*     */   }
/*     */   
/*     */   public void render() {
/* 115 */     BufferStrategy bs = getBufferStrategy();
/* 116 */     if (bs == null) {
/* 117 */       createBufferStrategy(3);
/*     */       return;
/*     */     } 
/* 120 */     Graphics g = bs.getDrawGraphics();
/* 124 */     g.fillRect(0, 0, 838, 1146);
/* 127 */     g.setColor(Color.WHITE);
/* 130 */     grassm.render(g);
/* 131 */     player.render(g);
/* 132 */     f3menu.render(g);
/* 135 */     g.dispose();
/* 136 */     bs.show();
/*     */   }
/*     */   
/*     */   public static void main(String[] args) {
/* 140 */     Game game = new Game();
/* 141 */     game.setPreferredSize(new Dimension(838, 573));
/* 142 */     game.setMaximumSize(new Dimension(838, 573));
/* 143 */     game.setMinimumSize(new Dimension(838, 573));
/* 145 */     JFrame frame = new JFrame("Beyond Origins 0.0.2");
/* 146 */     frame.setSize(838, 573);
/* 147 */     frame.setDefaultCloseOperation(3);
/* 148 */     frame.setResizable(false);
/* 149 */     frame.add(game);
/* 150 */     frame.setVisible(true);
/* 151 */     frame.setLocationRelativeTo((Component)null);
/* 152 */     frame.requestFocus();
/* 154 */     game.start();
/*     */   }
/*     */   
/*     */   public static GrassMap getGrassMap() {
/* 158 */     return grassm;
/*     */   }
/*     */   
/*     */   public static Player getPlayer() {
/* 162 */     return player;
/*     */   }
/*     */   
/*     */   public static F3Menu getF3Menu() {
/* 170 */     return f3menu;
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.2_2.jar!\applecraft\testgame\main\Game.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */