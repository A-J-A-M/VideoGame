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
public class Level5 
{
    private Random r=new Random();
    
    public void tick(){
        
        if(HUD.HEALTH>0) Spawner.keep++;  
        else Spawner.handler.object.clear();
        if (Spawner.keep>=500)
        {
            Spawner.keep=0;
            Spawner.hud.setLevel(5);
            Spawner.scoreKeep++;
            switch(Spawner.scoreKeep){
            case 1:
                Spawner.handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BasicEnemy, Spawner.handler, false));
                break;
            case 2:
                Spawner.handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-36), r.nextInt(Game.HEIGHT-64), ID.BasicEnemy, Spawner.handler, false));
                break;
            case 3:
                Spawner.handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH-42), r.nextInt(Game.HEIGHT-64), ID.SmartEnemy, Spawner.handler));
                break;
            case 4:
                Spawner.handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-36), r.nextInt(Game.HEIGHT-64), ID.BasicEnemy, Spawner.handler, false));
                Spawner.handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-36), r.nextInt(Game.HEIGHT-64), ID.BasicEnemy, Spawner.handler, true));
                break;
            case 6:
                Spawner.handler.clearEnemy();
                Spawner.handler.addObject(new Boss5((Game.WIDTH/2)-40, -250, ID.Boss, Spawner.handler));
                Spawner.bl=true;
                break;
                
        }
        }
        for (int i = 0; i < Spawner.handler.object.size(); i++)
                {
                    GameObject tempObject=Spawner.handler.object.get(i);
                    if (tempObject.id == ID.Boss)
                    {
                       if (((Boss5)tempObject).timer <= 0 &&(tempObject.y<-10 || tempObject.y>Game.HEIGHT-60)){
                           Spawner.handler.removeObject(tempObject);
                           i--;
                           Spawner.handler.addObject(new Boss5((Game.WIDTH/2)-40, -250, ID.Boss, Spawner.handler));
                       } 
                       else if (((Boss5)tempObject).timer <= 0 &&(tempObject.x<-10 || tempObject.x>Game.WIDTH-40)){
                           Spawner.handler.removeObject(tempObject);
                           i--;
                           Spawner.handler.addObject(new Boss5((Game.WIDTH/2)-40, -250, ID.Boss, Spawner.handler));
                       } 
                    }
                }
        if(Spawner.bl)
        {
            Spawner.keep2++;
            if (Spawner.keep2>=3000){
                Spawner.handler.object.clear();
                if(Spawner.clear<6)Spawner.clear++;}
        }
    }
}
