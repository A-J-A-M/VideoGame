/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial;

import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author Jordi
 */
public class Spawner 
{    
   public static  Handler handler;
   public static HUD hud;
   public  static int scoreKeep=0;
   public static int keep=0;
   public  static int keep2=0;
   public int scoreLevel=1;
   public static int level;
   public static boolean bl=false;
   public static int clear;
   public static boolean perfect[]=new boolean[9];
   private Graphics g;
   private Random r=new Random();
   private final Level1 level1=new Level1();
   private final Level2 level2=new Level2();
   private final Level3 level3=new Level3();
   private final Level4 level4=new Level4();
   private final Level5 level5=new Level5();
   private final Level6 level6=new Level6();
   private final Level7 level7=new Level7();
   private final Level8 level8=new Level8();
   private final Level9 level9=new Level9();
   boolean pollo=false;

    public Spawner()
    {
    }

    public Spawner(Handler handler, HUD hud)
    {
        this.handler = handler;
        this.hud = hud;
        perfect[0]=false;
        perfect[1]=false;
        perfect[2]=false;
        perfect[3]=false;
        perfect[4]=false;
        perfect[5]=false;
        perfect[6]=false;
        perfect[7]=false;
        perfect[8]=false;
        
    }
    public void tick(){
        /*if(HUD.HEALTH>0) keep++;  
        else handler.object.clear();
        if (keep>=100)
        {
            keep=0;
            hud.setLevel(hud.getLevel()+1);
            scoreKeep++;
            switch(scoreKeep){
            case 1:
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BasicEnemy, handler, true));
                break;
            case 2:
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-36), r.nextInt(Game.HEIGHT-64), ID.BasicEnemy, handler, true));
                break;
            case 3:
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-36), r.nextInt(Game.HEIGHT-64), ID.BasicEnemy, handler, false));
                break;
            case 4:
                handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH-41), r.nextInt(Game.HEIGHT-64), ID.SmartEnemy, handler));
                break;
            case 5:
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-36), r.nextInt(Game.HEIGHT-64), ID.BasicEnemy, handler, false));
                break;
            case 6:
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-36), r.nextInt(Game.HEIGHT-64), ID.BasicEnemy, handler, false));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-36), r.nextInt(Game.HEIGHT-64), ID.BasicEnemy, handler, true));
                break;
            case 7:
                handler.clearEnemy();
                handler.addObject(new Boss1((Game.WIDTH/2)-45, -250, ID.Boss, handler));
                bl=true;
                break;

        }
        }
        if(bl)
        {
            keep2++;
            if (keep2>=2500)handler.object.clear();
        }*/
        switch(level){
            case 1:
                level1.tick();
                break;
            case 2:
                level2.tick();
                break;
            case 3:
                level3.tick(); 
                break;
            case 4:
                level4.tick();
                break;
            case 5:
                level5.tick();
                break;
            case 6:
                level6.tick();
                break;
            case 7:
                level7.tick();
                break;
            case 8:
                level8.tick();
                break;
            case 9:
                level9.tick();
                break;
        }
                
        
    }
    public static void revive(){
        keep=0;
        scoreKeep=0;
        keep2=0;
        bl=false;
        Game.windowClosing();
        Game.windowOpening();
    }
   
   
}
