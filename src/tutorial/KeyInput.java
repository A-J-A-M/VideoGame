/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial;

import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import static tutorial.Game.HEIGHT;
import static tutorial.Game.WIDTH;
import static tutorial.Game.r;

/**
 *
 * @author Jordi
 */
public class KeyInput extends KeyAdapter
{
    
    private Handler handler;
    private Image image;
    private Sound music;
    public static boolean []p=new boolean[4];

    public KeyInput()
    {
    }

    public KeyInput(Handler handler,Sound music)
    {
        this.handler = handler;
        this.music=music;
        
        p[0]=false;
        p[1]=false;
        p[2]=false;
        p[3]=false;
    }
    
    public void keyPressed(KeyEvent e){
        int key=e.getKeyCode();
        
        try
        {
            for (int i = 0; i < handler.object.size(); i++)
            {
                GameObject tempObject=handler.object.get(i);
                if (tempObject.id==ID.Player)
                {//Key Events for Player 
                    if (key==KeyEvent.VK_W){
                        p[0]=true;
                        tempObject.setVelY(-5);
                    }
                    if (key==KeyEvent.VK_S){
                        p[1]=true;
                        tempObject.setVelY(5);
                    }
                    if (key==KeyEvent.VK_A){
                        p[2]=true;
                        tempObject.setVelX(-5);
                    }
                    if (key==KeyEvent.VK_D){
                        p[3]=true;
                        tempObject.setVelX(5);
                    }              
                }
            }   
        } catch (Exception ex)
        {
        }
    
        if (key==KeyEvent.VK_P&&Game.gamestate==Game.STATE.Game&&HUD.HEALTH>0){
            Game.pause = !Game.pause;
            if (Option.sound) {
                if (Game.pause) music.pauseMusic();
                else music.resumeMusic();
            }
        }
        if (handler.object.size()==0){
            
                if (key==KeyEvent.VK_A)HUD.setBl2(true);

                if (key==KeyEvent.VK_D) HUD.setBl2(false);

                if(HUD.bl3==false&&HUD.isBl2()&&key==KeyEvent.VK_ENTER && Game.gamestate==Game.STATE.Game){
                    p[0]=false;
                    p[1]=false;
                    p[2]=false;
                    p[3]=false;
                    HUD.revive();
                    Spawner.revive();
                    handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, handler));
                    switch(Spawner.level){
                        case 1:
                            handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler, true));
                            break;
                        case 2:
                            handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler, true));
                            break;
                        case 3:
                            handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler, false));
                            break;
                        case 4:
                            handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler, false));
                            break;
                        case 5:
                            handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler, true));
                            break;
                        case 6:
                            handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler,false));
                            handler.addObject(new ShootEnemy(3, r.nextInt(Game.HEIGHT-64), ID.BasicEnemy, handler,true));
                            break;
                        case 7:
                            handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler,true));
                            handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler,true));
                            break;
                        case 8:
                            handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                            handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler,false));
                            break;
                        case 9:
                            handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                            handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler,false));
                            handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler,true));
                            break;
                    }
                    
                }
                if(HUD.bl3==false&&HUD.isBl2()==false&&key==KeyEvent.VK_ENTER){
                    p[0]=false;
                    p[1]=false;
                    p[2]=false;
                    p[3]=false;
                    try
                    {
                        for (int i = 0; i < 20; i++)
                        {
                            handler.addObject(new MenuParticle(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.MenuParticle, handler));
                        }
                    } catch (Exception ex)
                    {
                    }
                    Game.gamestate=Game.STATE.Menu;
                    HUD.revive();
                    Spawner.revive();
                }
            }
        if(key==KeyEvent.VK_ESCAPE)System.exit(0);
        
    }
    public void keyReleased(KeyEvent e){
         int key=e.getKeyCode();
        
        try
        {
             for (int i = 0; i < handler.object.size(); i++)
            {
                GameObject tempObject=handler.object.get(i);
                if (tempObject.id==ID.Player)
                {//Key Events for Player 1
                    if (key==KeyEvent.VK_W){
                        p[0]=false;
                        if (p[1])
                        {
                           tempObject.setVelY(5);
                        } else
                        {
                            tempObject.setVelY(0);
                        }
                    }
                    if (key==KeyEvent.VK_S){
                        p[1]=false;
                        if (p[0])
                        {
                           tempObject.setVelY(-5);
                        } else
                        {
                            tempObject.setVelY(0);
                        }
                    }
                    if (key==KeyEvent.VK_A){
                        p[2]=false;
                        if (p[3])
                        {
                           tempObject.setVelX(5);
                        } else
                        {
                            tempObject.setVelX(0);
                        }
                    }
                    if (key==KeyEvent.VK_D){
                        p[3]=false;
                        if (p[2])
                        {
                           tempObject.setVelX(-5);
                        } else
                        {
                            tempObject.setVelX(0);
                        }
                    }               
                }
            }
        } catch (Exception ex)
        {
        }
    }
}
