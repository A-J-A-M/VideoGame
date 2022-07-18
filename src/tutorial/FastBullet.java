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
public class FastBullet extends GameObject
{

    private Random r=new Random();
    private boolean direction;
    public static Image image;
    public FastBullet()
    {
    }

    public FastBullet(float x, float y, ID id, Handler handler,boolean direction)
    {
        super(x, y, id, handler);
       
        this.direction = direction;
        velX=r.nextInt(10 - -10)+-10;
        if(direction)velY=r.nextInt(10 - 0)+10;
        else velY=r.nextInt(0 - -10)-20;
        

    }
    public Rectangle getBounds(){
    
        return new Rectangle((int)x,(int)y,22,22);
    }
    public void render(Graphics g){
      Graphics2D g2d=(Graphics2D) g;
      
      g.setColor(Color.red);
      g2d.draw(getBounds());
        /*if (direction)
        {
            g.fillRect(x, y, 16, 16);
        } else
        {
            g.fillRect(x, y, 12, 12);
        }*/
    }

    @Override
    public void tick()
    {
        x+=velX;
        y+=velY;
        
        if (y<=0 || y>=Game.WIDTH-36) handler.removeObject(this);
        if(x<=0 || x>=Game.HEIGHT-36) velX*=-1;
        
        //handler.addObject(new BasicTrail(new Color(235, 204, 51), 32, 32, (float) 0.02, (int)x, (int)y, ID.BasicTrail, handler));

    }
}
