/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import static tutorial.Game.HEIGHT;
import static tutorial.Game.WIDTH;

/**
 *
 * @author Jordi
 */
public class Menu extends MouseAdapter
{
    private Game game;
    private Handler handler;
    private Random r;
    private boolean bol=true;
    public boolean bolo=false;
    private float x;
    private float y;
    private int page=1;
    private Image image;
    
    public Menu()
    {
    }
    public Menu(Game game,Handler handler)
    {
        this.game = game;
        this.handler = handler;
    }
    public void returnMenu(){
            try
                {
                    r=new Random();
                    handler.object.clear();
                    for (int i = 0; i < 20; i++)
                    {
                        handler.addObject(new MenuParticle(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.MenuParticle, handler));
                    }
                } catch (Exception ex)
                {
                }
                for (int i = 0; i < handler.object.size(); i++)
                {
                   GameObject tempObject=handler.object.get(i);
                    if (tempObject.getId()==ID.Player)
                    {
                       handler.removeObject(tempObject);
                       i--;
                    }
                }
                bol=true;
                game.gamestate = Game.STATE.Menu;
}
    public void mousePressed(MouseEvent e){
        int mx=e.getX();
        int my=e.getY();
        
        if (game.gamestate == Game.STATE.Menu)
        {
            //levelselect
            if (mouseOver(mx, my, 210, 150, 200, 64))game.gamestate=Game.STATE.Section;
            //help
            if (mouseOver(mx, my, 210, 250, 200, 64))
            {
                handler.object.clear();
                bol=true;
                page=1;
                game.gamestate = Game.STATE.Help;
            }     
            //quit
            if (mouseOver(mx, my, 210, 350, 200, 64))
            {
               Game.windowClosing();
               System.exit(0);
            }
            if (mouseOver(mx, my, 480, 360, 105, 44))game.gamestate = Game.STATE.Options;
        }
        else if (game.gamestate == Game.STATE.Help)
        {
           //back buttom
            
            if (mouseOver(mx,my,80, 350, 120, 64)&&page<=1)returnMenu();           
            if (mouseOver(mx,my,80, 350, 120, 64)&&page>1){
                page--;
                handler.object.clear();
                bol=true;
                
            }
            //next buttom
            
            if (mouseOver(mx, my, 480, 350, 105, 64))
            {
                page++;
                handler.object.clear();
                bol=true;
                
            }
            if (mouseOver(mx, my, 480, 350, 105, 64)&&page>3)returnMenu();
           
        
        }
        /*else if(game.gamestate==Game.STATE.Game && HUD.HEALTH==0){
            if(mouseOver(mx,my,200, 280, 100, 44)){
                HUD.bl2=true;
                HUD.bl3=false;
                KeyInput.p[0]=false;
                KeyInput.p[1]=false;
                KeyInput.p[2]=false;
                KeyInput.p[3]=false;
                HUD.revive();
                Spawner.revive();
                handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, handler));
                handler.addObject(new BasicEnemy(Game.r.nextInt(Game.WIDTH - 50), Game.r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler, true));
            }
            else if(mouseOver(mx,my,350, 280, 100, 44)){
                HUD.bl2=false;
                HUD.bl3=false;
                KeyInput.p[0]=false;
                KeyInput.p[1]=false;
                KeyInput.p[2]=false;
                KeyInput.p[3]=false;
                Game.gamestate=Game.STATE.Menu;
                HUD.revive();
                Spawner.revive();
            }
            else HUD.bl3=true;
        }*/
    }
    public void mouseReleased(MouseEvent e){
        if (Game.gamestate == Game.STATE.Section)bolo=true;
        else bolo=false;
    }
    public  boolean mouseOver(int mx, int my,int x,int y,int width,int height){
        if (mx>x&&mx<x+width)
        {
            if (my>y&&my<y+height)return true; 
            else return false;
        } else return false;

    }
    public void tick(){
        
    }
    public void render(Graphics g){
        Font fnt=new Font("arial",1,50);
        Font fnt2=new Font("arial",1,30);
        Font fnt3=new Font("arial",1,25);
        
        g.setFont(fnt);
        g.setColor(Color.white);
        if (game.gamestate == Game.STATE.Menu)
        {            

            g.drawString("The Game", 205, 50);
            g.setFont(fnt2);

            g.drawRect(210, 150, 200, 64);
            g.drawString("Play", 220, 190);

            g.drawRect(210, 250, 200, 64);
            g.drawString("Help", 220, 290);

            g.drawRect(210, 350, 200, 64);
            g.drawString("Quit", 220, 390);
            
            g.setFont(fnt3);
            g.drawRect(480, 360, 105, 44);
            g.drawString("Options", 487, 390);
        } else if (game.gamestate == Game.STATE.Help)
        {
            switch(page){
                case 1:
                    g.drawString("Help", 240, 70);
                    g.setFont(fnt2);

                    g.drawRect(80, 350, 105, 64);
                    g.drawString("Menu", 90, 390);

                    g.drawRect(480, 350, 105, 64);
                    g.drawString("Next", 490, 390);

                    g.setFont(fnt3);
                    g.drawString("Use the WASD keys to move. Try avoiding enemies", 25, 110);
                    g.drawString("until the timer reaches up to 6000.", 25, 140);

                    g.drawRect(210, 180, 220, 180);

                    if (bol)
                    {
                        handler.addObject(new Player(260, 240, ID.Player, handler));
                        bol=false;
                    }
                break;
                case 2:
                    g.drawString("Help", 240, 70);
                    g.setFont(fnt2);

                    g.drawRect(80, 350, 105, 64);
                    g.drawString("Back", 90, 390);

                    g.drawRect(480, 350, 105, 64);
                    g.drawString("Next", 490, 390);
                    
                    g.setFont(fnt3);
                    g.drawString("Every time you get hit by an enemy, your health", 25, 110);
                    g.drawString("will decrease.", 25, 140);
                    
                    g.drawRect(210, 180, 220, 180);
                    
                    if (bol)
                    {
                        handler.addObject(new BasicEnemy(260, 240, ID.BasicEnemy, handler,true));
                        bol=false;
                    }
                break;
                case 3:
                    g.drawString("Help", 240, 70);
                    g.setFont(fnt2);

                    g.drawRect(80, 350, 105, 64);
                    g.drawString("Back", 90, 390);

                    g.drawRect(480, 350, 105, 64);
                    g.drawString("Menu", 490, 390);
                    
                    g.setFont(fnt3);
                    g.drawString("The more time passes, the harder it gets. Use the", 25, 110);
                    g.drawString("P buttom to pause the game and rest.", 25, 140);
                    
                    g.drawRect(210, 180, 220, 180);
                    
                    if (bol)
                    {
                        handler.addObject(new BasicEnemy(260, 240, ID.BasicEnemy, handler,false));
                        bol=false;
                    }
                break;
                    
            }
            /*for (int i = 0; i < handler.object.size(); i++)
                {
                    GameObject tempObject=handler.object.get(i);
                    if (tempObject.getId()==ID.Player)
                    {
                        x=tempObject.getX();
                        y=tempObject.getY();
                    }

                }*/
        }
 
        }
}
