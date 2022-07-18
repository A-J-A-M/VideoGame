/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial;


import java.util.Random;

/**
 *
 * @author Jordi
 */
public class Level6 
{
    private Random r=new Random();
    private boolean wave2=false;
    private int waveNum=75;
    
    public void tick(){
        
        if(HUD.HEALTH>0) Spawner.keep++;  
        else Spawner.handler.object.clear();
        if (Spawner.keep>=500)
        {
            Spawner.keep=0;
            Spawner.hud.setLevel(6);
            Spawner.scoreKeep++;
            switch(Spawner.scoreKeep){
            case 1:               
                Spawner.handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH-42), r.nextInt(Game.HEIGHT-64), ID.SmartEnemy, Spawner.handler));
                Spawner.handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-36), r.nextInt(Game.HEIGHT-64), ID.BasicEnemy, Spawner.handler, false));
                break;
            case 2: 
                Spawner.handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-36), r.nextInt(Game.HEIGHT-64), ID.BasicEnemy, Spawner.handler, false));
                break;
            case 3:
                Spawner.handler.clearEnemy();
                wave2=true;
                break;
            case 4:
                Spawner.handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH-36), r.nextInt(Game.HEIGHT-64), ID.BasicEnemy, Spawner.handler));
                break;
            case 6:
                Spawner.handler.clearEnemy();
                Spawner.handler.addObject(new Boss6((Game.WIDTH/2)-40, -290, ID.Boss, Spawner.handler));
                Spawner.bl=true;
                break;
            case 7:
                Spawner.handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-36), r.nextInt(Game.HEIGHT-64), ID.BasicEnemy, Spawner.handler,true));
                break;
            case 8:
                Spawner.handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-36), r.nextInt(Game.HEIGHT-64), ID.BasicEnemy, Spawner.handler, true));
                break;

        }
        }
        if(wave2)waveNum--;
        if(waveNum == 0){
           Spawner.handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-36), r.nextInt(Game.HEIGHT-64), ID.BasicEnemy, Spawner.handler, true)); 
           Spawner.handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-36), r.nextInt(Game.HEIGHT-64), ID.BasicEnemy, Spawner.handler, true)); 
           Spawner.handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-36), r.nextInt(Game.HEIGHT-64), ID.BasicEnemy, Spawner.handler, true)); 
           Spawner.handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-36), r.nextInt(Game.HEIGHT-64), ID.BasicEnemy, Spawner.handler, true)); 
           Spawner.handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-36), r.nextInt(Game.HEIGHT-64), ID.BasicEnemy, Spawner.handler, true)); 
           waveNum=75;
           wave2=false;
        }
        if(Spawner.bl)
        {
            Spawner.keep2++;
            if (Spawner.keep2>=3000){
                Spawner.handler.object.clear();
                if(Spawner.clear<7)Spawner.clear++;}
        }
    }
}
