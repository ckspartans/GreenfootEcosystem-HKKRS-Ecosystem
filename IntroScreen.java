import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class IntroScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IntroScreen extends World
{
    TitleButton title;
    MyWorld world;
    
    /**
     * Constructor for objects of class IntroScreen.
     * 
     */
    public IntroScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1); 
        
    }
    
        public IntroScreen(MyWorld w)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1); 
        world = w; 
        addObject(new TitleButton(), 500, 300); 
        addObject(new Authors(), 500, 350); 
        //showText("ABSTORGANISMS", 500, 300);
        //showText("Click to Start!", 500,400);
    }
    
    public void act(){
            if(Greenfoot.mouseClicked(title)){
                Greenfoot.setWorld(world);
            }
    }
}
