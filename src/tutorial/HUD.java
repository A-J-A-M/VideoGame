/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author Jordi
 */
public class HUD
{
    public static float HEALTH=100;
    public int timer=100;
    public static int highscore[]=new int[9];
    public boolean pollo=true;
    public static boolean bl=true;
    public static boolean bl2=true;
    public static boolean bl3=false;
    private static int score=0;
    private int level=1;

    public static int getScore()
    {
        return score;
    }

    public static void setScore(int score)
    {
        HUD.score = score;
    }
    
    public int getLevel()
    {
        return level;
    }

    public void setLevel(int level)
    {
        this.level = level;
    }

    public static boolean isBl()
    {
        return bl;
    }

    public static void setBl(boolean bl)
    {
        HUD.bl = bl;
    }

    public static boolean isBl2()
    {
        return bl2;
    }

    public static void setBl2(boolean bl2)
    {
        HUD.bl2 = bl2;
    }

    public static float getHEALTH()
    {
        return HEALTH;
    }

    public static void setHEALTH(float HEALTH)
    {
        HUD.HEALTH = HEALTH;
    }

    public static int[] getHighscore()
    {
        return highscore;
    }

    public static void setHighscore(int[] highscore)
    {
        HUD.highscore = highscore;
    }
    
    public void tick(){
        
        
        HEALTH=Game.clamp(HEALTH, 0, 100);
        if(score<6000 && HEALTH>0)score++;
        if (HEALTH<=100 && Option.cheat)
            {
                HEALTH=100;
                //System.exit(0);
            }
    }
    public void render(Graphics g){
        g.setColor(new Color(140, 50, 25));
        g.fillRect(15, 15, 200, 32);
        if (HEALTH>=30)
        {
            g.setColor(Color.blue);
            g.fillRect(15, 15, (int)HEALTH*2, 32);  
        } else
        {
            g.setColor(new Color(200, 0, 0));
            g.fillRect(15, 15, (int)HEALTH*2, 32);
        }
        g.setColor(Color.green);
        g.drawRect(15, 15, 200, 32);
        
        Font ftn=new Font("arial",1,15);
        Font ftn2=new Font("arial",1,25);
        Font ftn3=new Font("arial",1,70);
        g.setFont(ftn);
        g.drawString("Time: "+score, 15, 70);
        g.drawString("High score: "+highscore[Spawner.level-1], 15, 86);       
        //g.drawString("Level: "+level, 15, 86);
        
        if(score>=6000 || HEALTH<=0){           
            double life=HEALTH*20;
            double total=life+score;
            if ((int)total>highscore[Spawner.level-1]){
                highscore[Spawner.level-1]=(int)total;
                Game.windowClosing();
                Game.windowOpening();
            }
            g.setFont(ftn3);
            if (HEALTH==100)g.drawString("Perfect!", (Game.WIDTH / 2 - 32)-103, (Game.HEIGHT / 2 - 32)-30);
            else if(HEALTH>0)g.drawString("You won!", (Game.WIDTH / 2 - 32)-123, (Game.HEIGHT / 2 - 32)-30);
            else g.drawString("You lost", (Game.WIDTH / 2 - 32)-117, (Game.HEIGHT / 2 - 32)-30);
            ftn.deriveFont(40);
            g.setFont(ftn2);
            g.drawString("Time--------------   "+(int)score, (Game.WIDTH / 2 - 32)-100, (Game.HEIGHT / 2 - 32)+12);
            g.drawString("Remaining life----   "+(int)life, (Game.WIDTH / 2 - 32)-100, (Game.HEIGHT / 2 - 32)+35);
            g.drawString("Total--------------   "+(int)total, (Game.WIDTH / 2 - 32)-100, (Game.HEIGHT / 2 - 32)+58);
            
            g.setFont(ftn);
            g.drawRect(200, 324, 100, 44);      
            g.drawRect(350, 324, 100, 44);
            
            if (pollo)
            {
                g.drawString("Press enter to select an option", (Game.WIDTH / 2 - 32)-60, (Game.HEIGHT / 2 - 32)+90);
                timer--;
            }else timer++;
            if (timer==0)
            {
                pollo=false;
            }
            if (timer==100)
            {
                pollo=true;
            }

            if (bl3==false)
            {
                if(bl2){
                    g.fillRect(201, 325, 99, 43);
                    g.setColor(Color.black);
                    g.drawString("Play Again", 212, 349);
                    g.setColor(Color.black);
                    g.fillRect(351, 325, 99, 43);
                    g.setColor(Color.green);
                    g.drawString("Exit", 385, 349);
                }
                if(bl2==false){
                    g.fillRect(351, 325, 99, 43);
                    g.setColor(Color.black);
                    g.drawString("Exit", 385, 349);
                    g.setColor(Color.black);
                    g.fillRect(201, 325, 99, 43);
                    g.setColor(Color.green);
                    g.drawString("Play Again", 212, 349);
                }
            }else{
                g.setColor(Color.black);
                g.fillRect(200, 280, 100, 44);
                g.setColor(Color.green);
                g.drawString("Play Again", 212, 305);
                g.setColor(Color.black);
                g.fillRect(350, 280, 100, 44);
                g.setColor(Color.green);
                g.drawString("Exit", 385, 305); 
            }
        }
    }
    public static void revive(){
        
        HUD.setScore(0);
        HUD.setHEALTH(100);
    }
}
