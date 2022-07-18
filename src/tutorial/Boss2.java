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
public class Boss2 extends GameObject
{

    private GameObject player;
    private int timer=110;
    private int timer3=10;
    private Random r=new Random();
    private boolean direction;
    private boolean epic=false;
    public static Image image;
    public Boss2()
    {
    }

    public Boss2(float x, float y, ID id, Handler handler, boolean direction)
    {
        super(x, y, id, handler);
        
        for (int i = 0; i < handler.object.size(); i++)
        {
            if (handler.object.get(i).getId()==id.Player)player=handler.object.get(i);
        }
        this.direction = direction;
        velX=0;
        if(direction)velY=1.1f;
        else velY=-1.1f;
       
        
    }
    
    public Rectangle getBounds(){
            return new Rectangle((int)x,(int)y,76,76);
    }
    public void render(Graphics g){
      Graphics2D g2d=(Graphics2D) g;
      
      g.setColor(Color.ORANGE);
      g2d.draw(getBounds());
      g.fillRect((int)x, (int)y, 76, 76);
    }

    @Override
    public void tick()
    {
        x+=velX;
        y+=velY;
        if(timer<=0){
            velY=0;
            if (timer3<=0)
        {
            if (!epic)
            {
                if(direction)velX=-5;
                else velX=5;
            }
            epic=true;
            handler.addObject(new FastBullet(x, y, ID.BasicEnemy, handler,direction));
            timer3=10;
        } else timer3--;
        } 
        else timer--;
        if (x<=0 || x>=Game.WIDTH-36)velX*=-1;
        
        //handler.addObject(new BasicTrail(new Color(235, 204, 51), 96, 96, (float) 0.008, x, y, ID.BasicTrail, handler));
    }
}
