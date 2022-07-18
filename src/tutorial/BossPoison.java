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
public class BossPoison extends GameObject
{

    private GameObject player;
    private Random r=new Random();
    private boolean epic=false;
    private float trail;
    public static Image image;
    public BossPoison()
    {
    }

    public BossPoison(float x, float y, ID id, Handler handler)
    {
        super(x, y, id, handler);
        
        for (int i = 0; i < handler.object.size(); i++)
        {
            if (handler.object.get(i).getId()==id.Player)player=handler.object.get(i);
        }              
    }
    public Rectangle getBounds(){
            return new Rectangle((int)x,(int)y,75,75);
    }
    public void render(Graphics g){
      Graphics2D g2d=(Graphics2D) g;
      
      g.setColor(Color.red);
      g2d.draw(getBounds());
      g.fillRect((int)x, (int)y, 75, 75);
    }

    @Override
    public void tick()
    {
        
    }
}
