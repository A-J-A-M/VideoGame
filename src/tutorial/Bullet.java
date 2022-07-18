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
public class Bullet extends GameObject
{

    private Random r=new Random();
    public int num;
    private static Image image;
    public Bullet()
    {
    }

    public Bullet(float x, float y, ID id, Handler handler,int num)
    {
        super(x, y, id, handler);
        
        this.num=num;
        velX=r.nextInt(5 - -5)+-5;
        velY=r.nextInt(5 - -5)+-5;
        if (velY<=2 && velY>=0)velY=5;
        if (velY>=-2 && velY<0)velY=-5;
        if (velX<=2 && velX>=0)velX=5;
        if (velX>=-2 && velX<0)velX=-5;
        

    }
    public Rectangle getBounds(){
    
        return new Rectangle((int)x,(int)y,32,32);
    }
    public void render(Graphics g){
      Graphics2D g2d=(Graphics2D) g;
      
      switch(num){
          case 1:
              g.setColor(new Color(235, 204, 51));
              break;
          case 2:
              g.setColor(Color.red);
              break;
      }
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
        
        if (y<=0 || y>=Game.HEIGHT-36) velY*=-1;
        if (x<=0 || x>=Game.WIDTH-36) velX*=-1;
        
        //handler.addObject(new BasicTrail(new Color(235, 204, 51), 16, 16, (float) 0.02, (int)x, (int)y, ID.BasicTrail, handler));

    }
}
