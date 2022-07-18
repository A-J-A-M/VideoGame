/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.util.Random;

/**
 *
 * @author Jordi
 */
public class Game extends Canvas implements Runnable
{

    private static final long serialVersionUID = 4L;

    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
    
    private Thread epic;
    private boolean bl = false;
    private Handler handler;
    
    public static boolean pause=false;
    private HUD hud;
    public static Spawner spawn;
    public static  Random r = new Random();
    private Menu menu;
    private Option option;
    private LevelSelect levelSelect;
    private Paint paint;
    private Image image;
    private int timer=100;
    public static Sound music;
    
    public enum STATE{
        Menu,
        Help,
        Game,
        Section,
        Options
    }
    
    public static STATE gamestate=STATE.Menu;

    public Game()
    {
        handler = new Handler();
        image=Toolkit.getDefaultToolkit().getImage("res/background.jpg");
        paint=new Paint(image, "res/background.jpg");
        menu=new Menu(this,handler);
        music=new Sound();
        option=new Option(this, handler, menu, music);       
        this.addKeyListener(new KeyInput(handler,music));
        this.addMouseListener(menu);
        this.addMouseListener(option);
        hud = new HUD();
        if (spawn == null)spawn = new Spawner(handler, hud);
        levelSelect=new LevelSelect(this, handler,menu,spawn);
        this.addMouseListener(levelSelect);
        hud.highscore=ManipulaArchivos.carga3("highscore.dat");
        music.loopMusic("res/Magic Vibes.wav");

        while (timer>=0)timer--; 
        new Window(WIDTH, HEIGHT, "Game Beta", this);

        if (gamestate==STATE.Game)
        {
            handler.addObject(new Player(WIDTH / 2 - 32, HEIGHT / 2 - 32, ID.Player, handler));
            handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler, true));
        }else for (int i = 0; i < 20; i++) handler.addObject(new MenuParticle(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.MenuParticle, handler));
    }

    public synchronized void start()
    {
        epic = new Thread(this);
        epic.start();
        bl = true;
    }

    public synchronized void stop()
    {
        try
        {
            epic.join();
            bl = false;
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void run()
    {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (bl)
        {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1)
            {
                tick();
                delta--;
            }
            if (bl)
            {
                render();
            }
            frames++;
            if (System.currentTimeMillis() - timer > 1000)
            {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    private void tick()
    {
        if(!pause){
            handler.tick();
            if (gamestate==STATE.Game)
            {
                hud.tick();
                spawn.tick();
            }
        }
        
    }

    private void render()
    {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null)
        {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        //g.setColor(Color.black);
        paint.paint(g, -720, -1050);
      
        handler.render(g);
        
        if (pause)
        {
            g.setColor(Color.green);
            Font ftn=new Font("arial", 1, 27);
            g.setFont(ftn);
            g.drawString("PAUSED", WIDTH/2 - 50, HEIGHT/2);
        }

        if (gamestate==STATE.Game)hud.render(g);
        else if (gamestate==STATE.Menu || gamestate==STATE.Help)menu.render(g);
        else if (gamestate==STATE.Section)levelSelect.render(g);
        else if (gamestate==STATE.Options)option.render(g);
            
        
        g.dispose();
        bs.show();
    }

    public static float clamp(float var, float min, float max)
    {
        if (var >= max)
        {
            return var = max;
        } else if (var <= min)
        {
            return var = min;

        } else
        {
            return var;
        }

    }
    public static void windowClosing(){
        ManipulaArchivos.guarda("highscore.dat", HUD.getHighscore());
        ManipulaArchivos.guarda("level.dat", Spawner.clear);
    }
    public static void windowOpening(){
        HUD.setHighscore(ManipulaArchivos.carga3("highscore.dat"));
        Spawner.clear=ManipulaArchivos.carga4("level.dat");
    }

    public static void main(String[] args)
    {
        /*try
        {
            spawn=(Spawner)ManipulaArchivos.carga("spawner.dat");
        } catch (Exception e)
        {
            
        }*/
        windowOpening();
        new Game();
        
        //ManipulaArchivos.guarda("spawner.dat", spawn);
    }

}
