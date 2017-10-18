
import greenfoot.*;
import java.util.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    IntroScreen intro;
    PWorld pause;
    Algae alg;
    //PlantEater pe;
    int foodEaten = 0;
    int spawnTimer = 100;
    int numGrass = 0;
    int maxX = 800;
    int maxY = 700;
    boolean p = false;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1); //reference from World
        intro = new IntroScreen(this); //start with Intro screen
        AbstOrganism.lifeforms = new ArrayList(); //initialize the lifeforms arraylist
        alg = new Algae(); //initialize algae
        addObject(alg, Greenfoot.getRandomNumber(maxX), Greenfoot.getRandomNumber(maxY)); //add the Algae to a random location on the screen within boundaries
        //NOTE: The exponential spawning after the first Algae doesn't have boundaries, need to fix this
        Greenfoot.setWorld(intro); //set the start screen
        addObject(new AButton(), 870,100); //add the button that spawns Algae to the world
        addObject(new PEButton(), 870,150); //add the button that spawns Plant Eater to the world
        //UNCOMMENT THESE ONCE FINSIHED WITH NAME CHANGES IN THEIR CLASSES
        //addObject(new OtherOrg1(), 870, 200);
        //addObject(new OtherOrg2(), 870, 250);
    }
    
    public void act(){
        //
        if(AbstOrganism.lifeforms != null){
           showText("Lifeforms " + AbstOrganism.lifeforms.size(), 250, 20);
           
        }
        showText("Algae Eaten: " + foodEaten, 90,20); 
    }
    
    public static float getDist(Actor a, Actor b){
        double dist;
        double xLength = a.getX() - b.getX();
        double yLength = a.getY() - b.getY();
        dist = Math.sqrt(Math.pow(xLength, 2) + Math.pow(yLength, 2));
        return (float)dist;
    }
}
