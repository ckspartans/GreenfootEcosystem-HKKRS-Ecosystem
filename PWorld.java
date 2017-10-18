import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PWorld extends World
{
    PWorld pause;
    /**
     * Constructor for objects of class PWorld.
     * 
     */
    public PWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
    }

    
    public void act(){
            if(Greenfoot.getKey() == "p"){
                Greenfoot.setWorld(pause);
            }
    }
}
