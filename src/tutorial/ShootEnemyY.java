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
public class ShootEnemyY extends GameObject
{

    private GameObject player;
    private Random r=new Random();
    private int timer=75;
    private boolean direction=false;
    private Image image;
    private Paint paint;
    public ShootEnemyY()
    {
    }

    public ShootEnemyY(float x, float y, ID id, Handler handler,boolean direction)
    {
        super(x, y, id, handler);
        
        for (int i = 0; i < handler.object.size(); i++)
        {
            if (handler.object.get(i).getId()==id.Player)player=handler.object.get(i);
        }
        this.direction = direction;
        velX=16;
        velY=0;
        String imageURL;
        if (direction) imageURL="res/YellowEnemyD.png";
        else imageURL="res/YellowEnemyU.png";
        image=Toolkit.getDefaultToolkit().getImage(imageURL);
        paint=new Paint(image, imageURL);     
    }
    
    public Rectangle getBounds(){
            return new Rectangle((int)x,(int)y,20,20);
    }
    public void render(Graphics g){
      Graphics2D g2d=(Graphics2D) g;
      
      g.setColor(Color.black);
      g2d.draw(getBounds());
      paint.paint(g, (int)x, (int)y);
    }

    @Override
    public void tick()
    {
        x+=velX;
        y+=velY;
            
        if(timer<=0){
            handler.addObject(new MiniBulletY(x, y, ID.BasicEnemy, handler,direction));
            timer=75;
        }
        else timer--;


         

        if (x<=0 || x>=Game.WIDTH-36)velX*=-1;
        
        if (direction) handler.addObject(new Trail(image, 36, 36, (float) 0.08, x, y, ID.BasicTrail, handler,"res/YellowEnemyD.png"));
        else    handler.addObject(new Trail(image, 36, 36, (float) 0.08, x, y, ID.BasicTrail, handler,"res/YellowEnemyU.png"));
    }
}
