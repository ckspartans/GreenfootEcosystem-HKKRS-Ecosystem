import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AButton extends AbstButton
{
    public AButton(){
        super("Algae", 30);
        
    }
    
    public void onClick(){
        world.addObject(new Algae(), Greenfoot.getRandomNumber(world.getWidth()), Greenfoot.getRandomNumber(world.getHeight()));
    }
}
