/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

/**
 *
 * @author Jordi
 */
public class PoisonTrail extends GameObject
{

    private float alpha=1,life;
    private int width,height;
    private Image image;
    private Paint paint;
    //life=0.01---0.1
    public PoisonTrail()
    {
    }

    public PoisonTrail(Image image, int width, int height, float life, float x, float y, ID id, Handler handler)
    {
        super(x, y, id, handler);
        this.image = image;
        this.width = width;
        this.height = height;
        this.life = life;
        paint=new Paint(image, "res/Boss5.png");
    }
    @Override
    public void tick()
    {
        if (alpha>life)
        {
            alpha-=life-0.001f;
        }else handler.removeObject(this);
    }

    @Override
    public void render(Graphics g)
    {
       Graphics2D g2d=(Graphics2D)g;
       g2d.setComposite(makeTransparent(alpha));
       
       paint.paint(g, (int)x, (int)y);
       
       
       g2d.setComposite(makeTransparent(1));
    }
    private AlphaComposite makeTransparent(float alpha){
        int type=AlphaComposite.SRC_OVER;
        return(AlphaComposite.getInstance(type, alpha));
    }

    @Override
    public Rectangle getBounds()
    {
       return new Rectangle((int)x,(int)y,40,40);
    }
    
}
