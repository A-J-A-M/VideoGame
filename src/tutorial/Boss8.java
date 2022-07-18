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
public class Boss8 extends GameObject
{

    private GameObject player;
    private Random r=new Random();
    private boolean epic=false;
    private int timer=100;
    public static Image image;
    public Boss8()
    {
    }

    public Boss8(float x, float y, ID id, Handler handler)
    {
        super(x, y, id, handler);
        
        for (int i = 0; i < handler.object.size(); i++)
        {
            if (handler.object.get(i).getId()==id.Player)player=handler.object.get(i);
        }
        velX=0;
        velY=5;
       
        
    }
    
    public Rectangle getBounds(){
            return new Rectangle((int)x,(int)y,32,32);
    }
    public void render(Graphics g){
      Graphics2D g2d=(Graphics2D) g;
      
      g.setColor(Color.red);
      g2d.draw(getBounds());
      g.fillRect((int)x, (int)y, 32, 32);
    }

    @Override
    public void tick()
    {
        x+=velX;
        y+=velY;
        if (timer<=0)
        {
            if (x<=0 || x>=Game.WIDTH-36){
                velX*=-1;
                velY=r.nextInt(5 - -5)+-5;
                if (velY<3&&velY>=0)velY=5;
                if (velY>-3&&velY<0)velY=-5;
                handler.addObject(new MiniBoss8(x, y, ID.BasicEnemy, velX, -velY, handler));
            }
            if (y<=0 || y>=Game.HEIGHT-36){
                velY*=-1;
                velX=r.nextInt(5 - -5)+-5;
                if (velX<3&&velX>=0)velX=5;
                if (velX>-3&&velX<0)velX=-5;
                handler.addObject(new MiniBoss8(x, y, ID.BasicEnemy, -velX, velY, handler));
            }
        }else timer--;
        
        handler.addObject(new BasicTrail(Color.red, 32, 32, (float)0.08, (int)x, (int)y, ID.BasicTrail, handler));
    }
}
