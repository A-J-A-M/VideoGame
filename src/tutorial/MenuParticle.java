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
public class MenuParticle extends GameObject
{

    Random r=new Random();
    private static Image image;
    
    private Color col;
    
    public MenuParticle()
    {
    }

    public MenuParticle(float x, float y, ID id, Handler handler)
    {
        super(x, y, id, handler);
        

            velX=r.nextInt(7 - -7)+ -7;
            velY=r.nextInt(7 - -7)+ -7;
            if(velX==0)velX=1;
            if(velY==0)velY=1;

        col=new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255));
    }
    
    public Rectangle getBounds(){

        return new Rectangle((int)x,(int)y,14,14);
        
    }
    public void render(Graphics g){
      Graphics2D g2d=(Graphics2D) g;
      
      g.setColor(Color.red);
      g2d.draw(getBounds());
    }

    @Override
    public void tick()
    {
        x+=velX;
        y+=velY;
        
        if (y<=0 || y>=Game.HEIGHT-36) velY*=-1;
        if (x<=0 || x>=Game.WIDTH-36) velX*=-1;
        
        handler.addObject(new BasicTrail(col, 18, 18, (float) 0.05, (int)x, (int)y, ID.BasicTrail, handler));

    }
}
