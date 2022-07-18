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
import java.awt.Toolkit;

/**
 *
 * @author Jordi
 */
public class SmartEnemy extends GameObject
{

    private GameObject player;
    private Image image;
    private Paint paint;
    public SmartEnemy()
    {
    }

    public SmartEnemy(float x, float y, ID id, Handler handler)
    {
        super(x, y, id, handler);
        
        for (int i = 0; i < handler.object.size(); i++)
        {
            if (handler.object.get(i).getId()==id.Player)player=handler.object.get(i);
        }
        velX=5;
        velY=5;
        String imageURL="res/SmartEnemy.png";
        image=Toolkit.getDefaultToolkit().getImage(imageURL);
        paint=new Paint(image, imageURL);     
    }
    public Rectangle getBounds(){
            return new Rectangle((int)x,(int)y,16,16);
    }
    public void render(Graphics g){
      Graphics2D g2d=(Graphics2D) g;
      
      g.setColor(Color.black);
      g2d.setColor(Color.black);
      g2d.draw(getBounds());
      paint.paint(g, (int)x, (int)y);
    }

    @Override
    public void tick()
    {
        x+=velX;
        y+=velY;
        
        float diffX=x-player.getX()-20;
        float diffY=y-player.getY()-20;
        double distance=(double)Math.sqrt( (x-player.getX())* (x-player.getX()) + (y-player.getY()) * (y-player.getY()) );
        
        velX=((float)((-1.0/distance)*diffX));
        velY=((float)((-1.0/distance)*diffY));
        
        if (y<=0 || y>=Game.HEIGHT-41) velY*=-1;
        if (x<=0 || x>=Game.WIDTH-41) velX*=-1;
        

        handler.addObject(new Trail(image, 16, 16, (float) 0.02, x, y, ID.BasicTrail, handler,"res/SmartEnemy.png"));
    }
}
