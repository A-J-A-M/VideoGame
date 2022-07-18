/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author Jordi
 */
public class Window extends Canvas
{
    private static final long serialVersionUID=4L;
    private Image image;
    
   
    public Window(int width, int height, String title, Game theGame){
        JFrame wind=new JFrame(title);
        image=Toolkit.getDefaultToolkit().getImage("res/BasicEnemy.png");
        
        wind.setPreferredSize(new Dimension(width,height));
        wind.setMaximumSize(new Dimension(width,height));
        wind.setMinimumSize(new Dimension(width,height));
        
        wind.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        wind.setResizable(false);
        wind.setLocationRelativeTo(null);
        wind.add(theGame);
        wind.setVisible(true);
        wind.setBackground(Color.black);
        wind.setIconImage(image);
        theGame.start();
    }
}
