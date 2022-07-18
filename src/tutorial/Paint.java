/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

/**
 *
 * @author Jordi
 */
public class Paint extends Component
{
   Image image;
   String imageURL;

    public Paint(Image image,String imageURL)
    {
        this.image = image;
        this.imageURL = imageURL;
    }
    public void paint(Graphics g,int x,int y){
        Graphics2D g2d = (Graphics2D)g;
        
        g2d.drawImage(image, x, y, this);
    }
   
}
