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
import java.util.Random;

/**
 *
 * @author Jordi
 */
public class MiniBullet extends GameObject
{

    private Random r=new Random();
    private boolean direction;
    public static Image image;
    private Paint paint;
    public MiniBullet()
    {
    }

    public MiniBullet(float x, float y, ID id, Handler handler,boolean direction)
    {
        super(x, y, id, handler);
        
        this.direction = direction;
        if(direction)velX=r.nextInt(10 - 0)+10;
        else velX=r.nextInt(0 - -10)-20;
        velY=r.nextInt(10 - -10)+-10;
        String imageURL="res/MiniBullet.png";
        image=Toolkit.getDefaultToolkit().getImage(imageURL);
        paint=new Paint(image, imageURL);
    }

    public Rectangle getBounds(){
    
        return new Rectangle((int)x,(int)y,22,22);
    }
    public void render(Graphics g){
      Graphics2D g2d=(Graphics2D) g;
      
      g.setColor(Color.yellow);
      g2d.draw(getBounds());
      paint.paint(g, (int)x, (int)y);
    }

    @Override
    public void tick()
    {
        x+=velX;
        y+=velY;
        
        if (x<=0 || x>=Game.WIDTH-36) handler.removeObject(this);
        if(y<=0 || y>=Game.HEIGHT-36) velY*=-1;
        
        handler.addObject(new Trail(image, 22, 22, (float) 0.06, (int)x, (int)y, ID.BasicTrail, handler,"res/MiniBullet.png"));

    }
}
