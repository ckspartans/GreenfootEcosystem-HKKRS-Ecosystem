import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AbstButton extends Label
{
    
    public AbstButton(String value, int fontSize){
        super(value, fontSize);
    }

    public AbstButton(){
        super("",20);
    }
    
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public void act(){
        if (world == null){
            world = getWorld();
        }
        if(Greenfoot.mouseClicked(this)){
            onClick();
            }
    }
    
    public void onClick(){
        //This line proceeds to do whatever is needed once the button is pressed.
        //world.addObject(new Algae(), Greenfoot.getRandomNumber(world.getWidth()), Greenfoot.getRandomNumber(world.getHeight()));
    }
    
}
