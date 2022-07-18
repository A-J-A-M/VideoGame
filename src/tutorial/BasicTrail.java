/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

/**
 *
 * @author Jordi
 */
public class BasicTrail extends GameObject
{

    private float alpha=1,life;
    private Color color;
    public static Image image;
    private int width,height;
    //life=0.01---0.1
    public BasicTrail()
    {
    }

    public BasicTrail(Color color, int width, int height, float life, float x, float y, ID id, Handler handler)
    {
        super(x, y, id, handler);
        this.color = color;
        this.width = width;
        this.height = height;
        this.life = life;
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
       
       g.setColor(color);
       g.fillRect((int)x,(int)y, width, height);
       
       g2d.setComposite(makeTransparent(1));
    }
    private AlphaComposite makeTransparent(float alpha){
        int type=AlphaComposite.SRC_OVER;
        return(AlphaComposite.getInstance(type, alpha));
    }

    @Override
    public Rectangle getBounds()
    {
       return null; 
    }
    
}
