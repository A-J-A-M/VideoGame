/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Jordi
 */
public class Option extends MouseAdapter
{
    private Game game;
    private Handler handler;
    public static boolean cheat=false;
    public static boolean sound=true;
    public static boolean other=false;
    private Menu menu;
    private Sound music;

    public Option()
    {
    }

    public Option(Game game, Handler handler, Menu menu, Sound music)
    {
        this.game = game;
        this.handler = handler;
        this.menu = menu;
        this.music=music;
    }

    public static boolean isCheat()
    {
        return cheat;
    }

    public static void setCheat(boolean cheat)
    {
        Option.cheat = cheat;
    }
    public void mousePressed(MouseEvent e){
        int mx=e.getX();
        int my=e.getY();
        if (menu.mouseOver(mx, my, 405, 120, 35, 35))cheat=!cheat;
        if (menu.mouseOver(mx, my, 405, 200, 35, 35)){
            sound=!sound;
            if (sound) music.loopMusic("res/Magic Vibes.wav");
            else music.stopMusic();           
        }
        if (menu.mouseOver(mx, my, 405, 280, 35, 35))other=!other;
        if(menu.mouseOver(mx, my, 15, 350, 100, 64))Game.gamestate = Game.STATE.Menu;
    }
    public void tick(){
        
    }
    public void render(Graphics g){
        Font fnt2=new Font("arial",3,30);
        Font fnt=new Font("arial",3,40);
        g.setFont(fnt);
        g.setColor(Color.yellow);
        
        g.drawString("Options", (Game.WIDTH/2)-60, 35);
        g.setFont(fnt2);
        
        //g.drawRect(130, 80, 120, 54);
        g.drawRect(405, 120, 35, 35);
        g.drawString("Cheats------------", 185, 145);

        //g.drawRect(130, 200, 120, 54);
        g.drawRect(405, 200, 35, 35);
        g.drawString("Sound-------------", 183, 225);

        //g.drawRect(130, 320, 120, 54);
        g.drawRect(405, 280, 35, 35);
        g.drawString("Don't know------", 185, 305);
        
        g.drawRect(15, 350, 100, 64);
        g.drawString("Menu", 25, 390);
        if (cheat)g.fillRect(413, 128, 19, 19);
        if (sound)g.fillRect(413, 208, 19, 19);
        if (other)g.fillRect(413, 288, 19, 19);
    }
    
}
