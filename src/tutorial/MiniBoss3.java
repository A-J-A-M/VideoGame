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
public class MiniBoss3 extends GameObject
{

    private GameObject player;
    private Random r=new Random();
    private int epic=0;
    public static Image image;
    private Paint paint;
    public MiniBoss3()
    {
    }

    public MiniBoss3(float x, float y, ID id, Handler handler)
    {
        super(x, y, id, handler);
        
        for (int i = 0; i < handler.object.size(); i++)
        {
            if (handler.object.get(i).getId()==id.Player)player=handler.object.get(i);
        }
        velX=r.nextInt(5 - -5)+-5;
        velY=r.nextInt(5 - -5)+-5;
        String imageURL="res/Boss3_1.png";
        image=Toolkit.getDefaultToolkit().getImage(imageURL);       
    }

    public MiniBoss3(float x, float y, ID id, float velX, float velY, Handler handler)
    {
        super(x, y, id, velX, velY, handler);
         for (int i = 0; i < handler.object.size(); i++)
        {
            if (handler.object.get(i).getId()==id.Player)player=handler.object.get(i);
        }
        String imageURL="res/Boss3_1.png";
        image=Toolkit.getDefaultToolkit().getImage(imageURL);
        paint= new Paint(image, imageURL);
    }
    
    public Rectangle getBounds(){
            return new Rectangle((int)x,(int)y,32,32);
    }
    public void render(Graphics g){
      Graphics2D g2d=(Graphics2D) g;
      
      g.setColor(Color.darkGray);
      g2d.draw(getBounds());
      paint.paint(g, (int)x, (int)y);
    }

    @Override
    public void tick()
    {
        x+=velX;
        y+=velY;
        if (epic<=3)
        {
            if (x<=0 || x>=Game.WIDTH-36){
                velX*=-1;
                velY=r.nextInt(5 - -5)+-5;
                if (velY<5&&velY>=0)velY=5;
                if (velY>-3&&velY<0)velY=-5;
                epic++;
            }
            if (y<=0 || y>=Game.HEIGHT-36){
                velY*=-1;
                if (velX<3&&velX>=0)velX=5;
                if (velX>-3&&velX<0)velX=-5;
                epic++;
            }
        }else 
        {
            if (x<=0 || x>=Game.WIDTH-36)handler.removeObject(this);
            if (y<=0 || y>=Game.HEIGHT-36)handler.removeObject(this);
        }
        handler.addObject(new Trail(image, 32, 32, (float)0.08, (int)x, (int)y, ID.BasicTrail, handler,"res/Boss3_1.png"));
    }
}
