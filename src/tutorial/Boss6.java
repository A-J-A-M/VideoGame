/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

/**
 *
 * @author Jordi
 */
public class Boss6 extends GameObject
{

    private GameObject player;
    private Random r=new Random();
    private boolean epic=false;
    private int timer=100;
    private int timer2=100;
    private float trail;
    public static Image image;
    public Boss6()
    {
    }

    public Boss6(float x, float y, ID id, Handler handler)
    {
        super(x, y, id, handler);
        
        for (int i = 0; i < handler.object.size(); i++)
        {
            if (handler.object.get(i).getId()==id.Player)player=handler.object.get(i);
        }
        velX=0;
        velY=7.5f;
       
        
    }
    public Boss6(float x, float y, ID id, Handler handler, int timer)
    {
        super(x, y, id, handler);
        
        for (int i = 0; i < handler.object.size(); i++)
        {
            if (handler.object.get(i).getId()==id.Player)player=handler.object.get(i);
        }
        this.timer = timer;
        velX=0;
        velY=0;
        this.x=r.nextInt(Game.WIDTH-36);
        this.y=r.nextInt(Game.HEIGHT-36);
        
    }
    
    public Rectangle getBounds(){
            return new Rectangle((int)x,(int)y,75,75);
    }
    public void render(Graphics g){
      Graphics2D g2d=(Graphics2D) g;
      
      g.setColor(Color.green);
      g2d.draw(getBounds());
      g.fillRect((int)x, (int)y, 75, 75);
    }

    @Override
    public void tick()
    {
        if (timer<=0)
        {           
            if (timer2 <= 10){
                if(timer2 == 10){
                    for (int i = 0; i < handler.object.size(); i++)
                    {
                        GameObject tempObject =handler.object.get(i);
                        if (tempObject.id == ID.Boss)
                        {
                            handler.removeObject(tempObject);
                            i--;
                        }
                    }
                    handler.addObject(new Boss6(x, y, ID.Boss, handler,0));
                    handler.addObject(new BossPoison(x, y, ID.BasicEnemy, handler));
                    handler.addObject(new BasicTrail(Color.green, 75, 75, trail, (int)x, (int)y, ID.BasicTrail, handler));
                }
                else if (timer2==0)timer2=120;
                else timer2--;
            }else timer2--;
        trail=0.015f;    
        }else if(timer>=30) {
            x+=velX;
            y+=velY;
            timer--;
            trail=0.04f;
            handler.addObject(new BasicTrail(Color.green, 75, 75, trail, (int)x, (int)y, ID.BasicTrail, handler));
        }else timer--;
        
    }
}
