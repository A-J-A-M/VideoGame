/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial;

import java.awt.Graphics;
import java.util.LinkedList;

/**
 *
 * @author Jordi
 */
public class Handler
{
    LinkedList<GameObject> object=new LinkedList<GameObject>();
    
    public void tick(){
        try
        {
            for (int i = 0; i < object.size(); i++)
            {
                GameObject tempObject=object.get(i);
                tempObject.tick();
            }
        } catch (Exception e)
        {
        }
    }
    public void clearEnemy(){
        for (int i = 0; i < object.size(); i++)
                {
                    GameObject tempObject=object.get(i);
                    if (tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.SmartEnemy || tempObject.getId() == ID.MenuParticle|| tempObject.getId() == ID.BasicTrail|| tempObject.getId() == ID.PoisonTrail)
                    {
                        removeObject(tempObject);
                        i--;
                    }
                }
    }
    public void render(Graphics g){

        try
        {
            for (int i = 0; i < object.size(); i++)
            {
                   GameObject tempObject=object.get(i);
                   tempObject.render(g); 
            }
        } catch (Exception e)
        {
        }
    }
    public void addObject(GameObject object){
        this.object.add(object);
    }
    public void removeObject(GameObject object){
        this.object.remove(object);
    }
}
