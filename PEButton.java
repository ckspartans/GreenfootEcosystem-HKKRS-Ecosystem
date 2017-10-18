import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PEButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PEButton extends AbstButton
{
    public PEButton(){
        super("Plant Eater", 30);
    }
    
    public void onClick(){
        world.addObject(new PlantEater(), Greenfoot.getRandomNumber(world.getWidth()), Greenfoot.getRandomNumber(world.getHeight()));
    }
}
