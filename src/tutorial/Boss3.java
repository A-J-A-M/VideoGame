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
public class Boss3 extends GameObject
{

    private GameObject player;
    private Random r=new Random();
    private boolean epic=false;
    private int timer=100;
    public static Image image;
    private Paint paint;
    public Boss3()
    {
    }

    public Boss3(float x, float y, ID id, Handler handler)
    {
        super(x, y, id, handler);
        
        for (int i = 0; i < handler.object.size(); i++)
        {
            if (handler.object.get(i).getId()==id.Player)player=handler.object.get(i);
        }
        velX=0;
        velY=5;
        String imageURL="res/Boss3.png";
        image=Toolkit.getDefaultToolkit().getImage(imageURL);
        paint=new Paint(image, imageURL);       
    }
    
    public Rectangle getBounds(){
            return new Rectangle((int)x,(int)y,32,32);
    }
    public void render(Graphics g){
      Graphics2D g2d=(Graphics2D) g;
      
      g.setColor(Color.gray);
      g2d.draw(getBounds());
      paint.paint(g, (int)x, (int)y);
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
                velY=r.nextInt(4 - -4)+-4;
                if (velY<3&&velY>=0)velY=4;
                if (velY>-3&&velY<0)velY=-4;
                handler.addObject(new MiniBoss3(x, y, ID.BasicEnemy, velX, -velY, handler));
            }
            if (y<=0 || y>=Game.HEIGHT-36){
                velY*=-1;
                velX=r.nextInt(4 - -4)+-4;
                if (velX<3&&velX>=0)velX=4;
                if (velX>-3&&velX<0)velX=-4;
                handler.addObject(new MiniBoss3(x, y, ID.BasicEnemy, -velX, velY, handler));
            }
        }else timer--;
        
        handler.addObject(new Trail(image, 32, 32, (float)0.08, (int)x, (int)y, ID.BasicTrail, handler,"res/Boss3.png"));
    }
}
