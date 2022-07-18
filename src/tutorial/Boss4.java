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
public class Boss4 extends GameObject
{

    private GameObject player;
    private int timer=205;
    private int timer2=21;
    private int timer3=100;
    private int z=0;
    private Random r=new Random();
    public static Image image;
    public Boss4()
    {
    }

    public Boss4(float x, float y, ID id, Handler handler)
    {
        super(x, y, id, handler);
        
        for (int i = 0; i < handler.object.size(); i++)
        {
            if (handler.object.get(i).getId()==id.Player)player=handler.object.get(i);
        }
        velX=0;
        velY=1.4f;
       
        
    }
    
    public Rectangle getBounds(){
            return new Rectangle((int)x,(int)y,116,116);
    }
    public void render(Graphics g){
      Graphics2D g2d=(Graphics2D) g;
      
      g.setColor(Color.red);
      g2d.draw(getBounds());
      g.fillRect((int)x, (int)y, 116, 116);
    }

    @Override
    public void tick()
    {
        x+=velX;
        y+=velY;
        if(timer<=0){
            velY=0;
            timer2--;
        } 
        else timer--;
        if(timer2<=0){
            if (timer3<=0 && z<=4)
            {
               handler.addObject(new Bullet(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.BasicEnemy, handler,2));
               handler.addObject(new Bullet(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.BasicEnemy, handler,2));
               timer3=250;
               z++;
            } else
            {
                timer3--;
            }
        }
        
        //handler.addObject(new BasicTrail(new Color(235, 204, 51), 96, 96, (float) 0.008, x, y, ID.BasicTrail, handler));
    }
}
