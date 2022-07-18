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
public class LevelSelect extends MouseAdapter
{
    private Game game;
    private Menu menu;
    private Handler handler;
    private Spawner spawn;
    private float x;
    private float y;
    private Random r;
    private Image image;

    public LevelSelect()
    {
    }

    public LevelSelect(Game game, Handler handler, Menu menu,Spawner spawn)
    {
        this.game = game;
        this.handler = handler;
        this.menu = menu;
        this.spawn = spawn;
    }
    public void mousePressed(MouseEvent e){
        int mx=e.getX();
        int my=e.getY();
        r=new Random();
        if (Game.gamestate==Game.STATE.Section)
        {
            //play
            if (mouseOver(mx, my, 80, 30, 140, 70))
            {
                handler.object.clear();
                game.gamestate=Game.STATE.Game;
                spawn.level=1;
                handler.addObject(new Player(WIDTH / 2 - 32, HEIGHT / 2 - 32, ID.Player, handler));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler, true));
            }
            if (mouseOver(mx, my, 250, 30, 140, 70) && Spawner.clear>=2)
            {
                handler.object.clear();
                game.gamestate=Game.STATE.Game;
                spawn.level=2;
                handler.addObject(new Player(WIDTH / 2 - 32, HEIGHT / 2 - 32, ID.Player, handler));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler, true));
            }
            if (mouseOver(mx, my, 420, 30, 140, 70) && Spawner.clear>=3)
            {
                handler.object.clear();
                game.gamestate=Game.STATE.Game;
                spawn.level=3;
                handler.addObject(new Player(WIDTH / 2 - 32, HEIGHT / 2 - 32, ID.Player, handler));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler, false));
            }
            if (mouseOver(mx, my, 80, 140, 140, 70) && Spawner.clear>=4)
            {
                handler.object.clear();
                game.gamestate=Game.STATE.Game;
                spawn.level=4;
                handler.addObject(new Player(WIDTH / 2 - 32, HEIGHT / 2 - 32, ID.Player, handler));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler, false));
            }
            if (mouseOver(mx, my, 250, 140, 140, 70) && Spawner.clear>=5 && menu.bolo==true)
            {
                handler.object.clear();
                game.gamestate=Game.STATE.Game;
                spawn.level=5;
                handler.addObject(new Player(WIDTH / 2 - 32, HEIGHT / 2 - 32, ID.Player, handler));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler, true));
            }
            if (mouseOver(mx, my, 420, 140, 140, 70) && Spawner.clear>=6)
            {
                handler.object.clear();
                game.gamestate=Game.STATE.Game;
                spawn.level=6;
                handler.addObject(new Player(WIDTH / 2 - 32, HEIGHT / 2 - 32, ID.Player, handler));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler,false));
                handler.addObject(new ShootEnemy(3, r.nextInt(Game.HEIGHT-64), ID.BasicEnemy, handler,true));            }    
            if (mouseOver(mx, my, 80, 250, 140, 70) && Spawner.clear>=7)
            {
                handler.object.clear();
                game.gamestate=Game.STATE.Game;
                spawn.level=7;
                handler.addObject(new Player(WIDTH / 2 - 32, HEIGHT / 2 - 32, ID.Player, handler));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler,true));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler,true));
            }    
            if (mouseOver(mx, my, 250, 250, 140, 70) && Spawner.clear>=8)
            {
                handler.object.clear();
                game.gamestate=Game.STATE.Game;
                spawn.level=8;
                handler.addObject(new Player(WIDTH / 2 - 32, HEIGHT / 2 - 32, ID.Player, handler));
                handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler,false));           
            }    
            if (mouseOver(mx, my, 420, 250, 140, 70) && Spawner.clear>=9)
            {
                handler.object.clear();
                game.gamestate=Game.STATE.Game;
                spawn.level=9;
                handler.addObject(new Player(WIDTH / 2 - 32, HEIGHT / 2 - 32, ID.Player, handler));
                handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler,false));           
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler,true));           
            } 
            if (mouseOver(mx, my, 50, 350, 105, 64))
            {
                game.gamestate=Game.STATE.Menu;
            }
        }
    }
    public void mouseReleased(MouseEvent e){
        
    }
    private  boolean mouseOver(int mx, int my,int x,int y,int width,int height){
        if (mx>x&&mx<x+width)
        {
            if (my>y&&my<y+height)
            {
               return true; 
            } else return false;
        } else return false;

    }
    public void tick(){
        
    }
    public void render(Graphics g){
        Font fnt=new Font("arial",1,30);
        
        g.setFont(fnt);
        g.setColor(Color.white);
        
        if (Game.gamestate==Game.STATE.Section)
        {
            perfect(Spawner.perfect[0],g,HUD.getHighscore()[0]);
            g.drawString("Level 1", 100, 75);
            g.drawRect(80, 30, 140, 70);
            g.setColor(Color.white);
            
            if(Spawner.clear<2)g.setColor(Color.red);
            
            perfect(Spawner.perfect[1],g,HUD.getHighscore()[1]);
            g.drawString("Level 2", 270, 75);
            g.drawRect(250, 30, 140, 70);
            g.setColor(Color.white);
            
            if(Spawner.clear<3)g.setColor(Color.red);
            
            perfect(Spawner.perfect[2],g,HUD.getHighscore()[2]);
            g.drawString("Level 3", 440, 75);
            g.drawRect(420, 30, 140, 70);
            g.setColor(Color.white);
            
            if(Spawner.clear<4)g.setColor(Color.red);
            
            perfect(Spawner.perfect[3],g,HUD.getHighscore()[3]);
            g.drawString("Level 4", 100, 185);
            g.drawRect(80, 140, 140, 70);
            g.setColor(Color.white);
            
            if(Spawner.clear<5)g.setColor(Color.red);
            
            perfect(Spawner.perfect[4],g,HUD.getHighscore()[4]);
            g.drawString("Level 5", 270, 185);
            g.drawRect(250, 140, 140, 70);
            g.setColor(Color.white);
            
            if(Spawner.clear<6)g.setColor(Color.red);
            
            perfect(Spawner.perfect[5],g,HUD.getHighscore()[5]);
            g.drawString("Level 6", 440, 185);
            g.drawRect(420, 140, 140, 70);
            g.setColor(Color.white);
            
            if(Spawner.clear<7)g.setColor(Color.red);
            
            perfect(Spawner.perfect[6],g,HUD.getHighscore()[6]);
            g.drawString("Level 7", 100, 295);
            g.drawRect(80, 250, 140, 70);
            g.setColor(Color.white);
            
            if(Spawner.clear<8)g.setColor(Color.red);
            
            perfect(Spawner.perfect[7],g,HUD.getHighscore()[7]);
            g.drawString("Level 8", 270, 295);
            g.drawRect(250, 250, 140, 70);
            g.setColor(Color.white);
            
            if(Spawner.clear<9)g.setColor(Color.red);
            
            perfect(Spawner.perfect[8],g,HUD.getHighscore()[8]);
            g.drawString("Level 9", 440, 295);
            g.drawRect(420, 250, 140, 70);
            g.setColor(Color.white);
            
            g.drawRect(50, 350, 105, 64);
            g.drawString("Back", 60, 390);
        }
    }
    public void perfect(boolean level,Graphics g,int highscore){
        if (highscore == 8000) level=true;
        if (level) g.setColor(Color.yellow);
    }
    
}
