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
public class BasicEnemy extends GameObject
{

    boolean direction;
    private Image image;
    private Paint paint;
    public BasicEnemy()
    {
    }

    public BasicEnemy(float x, float y, ID id, Handler handler,boolean direction)
    {
        super(x, y, id, handler);
        
        this.direction=direction;
        if (direction)
        {
            velX=5;
            velY=5;
            String imageURL="res/BasicEnemy.png";
            image=Toolkit.getDefaultToolkit().getImage(imageURL);
            paint=new Paint(image, imageURL);
        } else
        {
            velX=-10;
            velY=-10;
            String imageURL="res/FastEnemy.png";
            image=Toolkit.getDefaultToolkit().getImage(imageURL);
            paint=new Paint(image, imageURL);
        }
        
    }
    public Rectangle getBounds(){
        if (direction)
        {
            return new Rectangle((int)x,(int)y,16,16);
        } else
        {
            return new Rectangle((int)x,(int)y,14,14);
        }
    }
    public void render(Graphics g){
      Graphics2D g2d=(Graphics2D) g;
      g.setColor(Color.black);
      g2d.setColor(Color.black);
      g2d.draw(getBounds());
        if (direction) paint.paint(g, (int)x, (int)y);
        else paint.paint(g, (int)x, (int)y);
    }

    @Override
    public void tick()
    {
        x+=velX;
        y+=velY;
        
        if (Game.gamestate==Game.STATE.Game)
        {
            if (y<=0 || y>=Game.HEIGHT-36) velY*=-1;
            if (x<=0 || x>=Game.WIDTH-36) velX*=-1;
        }
        else if (Game.gamestate==Game.STATE.Help)
        {
            if (y>=320 || y<=190) velY*=-1;
            if (x>=390 || x<=220) velX*=-1;
        }
        
        if (direction)
        {
            handler.addObject(new Trail(image, 16, 16, (float)0.035, (int)x, (int)y, ID.BasicTrail, handler,"res/BasicEnemy.png"));

        } else
        {
            handler.addObject(new Trail(image, 14, 14, (float) 0.075, (int)x, (int)y, ID.BasicTrail, handler,"res/FastTrail.png"));
        }
    }
}
