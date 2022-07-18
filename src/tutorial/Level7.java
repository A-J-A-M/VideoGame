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
public class Level7 
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
            Spawner.hud.setLevel(7);
            Spawner.scoreKeep++;
            switch(Spawner.scoreKeep){
            case 1:
                Spawner.handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, Spawner.handler,false));
                Spawner.handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, Spawner.handler,false));
                break;
            case 2:
                Spawner.handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, Spawner.handler));
                break;
            case 3:
                Spawner.handler.clearEnemy();
                wave2=true;
                break;
            case 4:
                Spawner.handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, Spawner.handler));                
                break;
            case 5:
                Spawner.handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, Spawner.handler,true));
                Spawner.handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, Spawner.handler,true));
                break;
            case 7:
                Spawner.handler.clearEnemy();
                Spawner.handler.addObject(new Boss2((Game.WIDTH/2)-180, -110, ID.Boss, Spawner.handler,true));
                Spawner.handler.addObject(new Boss2((Game.WIDTH/2)+130, 500, ID.Boss, Spawner.handler,false));
                Spawner.bl=true;
                break;

        }
        }
        if (wave2)waveNum--;
        if(waveNum<=0){
            Spawner.handler.addObject(new ShootEnemy(3, r.nextInt(Game.HEIGHT-64), ID.BasicEnemy, Spawner.handler,true));
            Spawner.handler.addObject(new ShootEnemy(Game.WIDTH-36, r.nextInt(Game.HEIGHT-64), ID.BasicEnemy, Spawner.handler,false));
            wave2=false;
            waveNum=75;
        }
        if(Spawner.bl)
        {
            Spawner.keep2++;
            if (Spawner.keep2>=2500){
                Spawner.handler.object.clear();
                if(Spawner.clear<8)Spawner.clear++;
        }
        }
    }
}
