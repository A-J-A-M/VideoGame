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
public class Player extends GameObject
{

    public boolean col=true;
    public int colNum=0;
    private Image image;
    private Paint paint;
    public Player()
    {
    }

    public Player(float x, float y, ID id, Handler handler)
    {
        super(x, y, id, handler);
        String imageURL = "res/Player.png";
        image=Toolkit.getDefaultToolkit().getImage(imageURL);
        paint=new Paint(image, imageURL);
    }

    public Player(float x, float y, ID id, float velX, float velY, Handler handler)
    {
        super(x, y, id, velX, velY, handler);
    }
    public Rectangle getBounds(){
        return new Rectangle((int)x,(int)y,32,32);
    }
    public void tick(){
        x+=velX;
        y+=velY;
        
        x=Game.clamp(x, 0, Game.WIDTH-34);
        y=Game.clamp(y, 0, Game.HEIGHT-61);
        
        if (Game.gamestate==Game.STATE.Help)
        {
            x=Game.clamp(x, 220, 390);
            y=Game.clamp(y, 190, 320);
        }
        
        handler.addObject(new Trail(image, 32, 32, (float)0.08, (int)x, (int)y, ID.BasicTrail, handler,"res/Player.png"));
        
        collision();
    }
    
    private void collision(){
        for (int i = 0; i < handler.object.size(); i++)
        {
            GameObject tempObject=handler.object.get(i);
            
            if (tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.SmartEnemy ||tempObject.getId() == ID.Boss )
            {
                if (getBounds().intersects(tempObject.getBounds()))
                {//collision code
                    HUD.HEALTH-=2;
                }
            }
            if (tempObject.getId() == ID.PoisonTrail)
            {
                if (getBounds().intersects(tempObject.getBounds()) || !col)
                {//collision code
                    col=false;
                    colNum++;
                    if (colNum<=10)HUD.HEALTH-=0.01;
                    else{
                        colNum=0;
                        col=true;
                    }
                }
            }
 
        }
    }
    public void render(Graphics g){
        paint.paint(g,(int)x,(int)y);
        /*g.setColor(Color.white);
        g2d.draw(getBounds());
 
        g.setColor(Color.white);
        g.fillRect((int)x,(int)y, 32, 32);*/
    }
}
