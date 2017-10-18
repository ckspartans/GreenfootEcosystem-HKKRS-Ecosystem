import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class TestOrganism here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlantEater extends AbstOrganism
{
    public PlantEater(){
        prey = new ArrayList <Object>();
        predators = new ArrayList <Object>();
        
        trophicLevel = 0;
        age = 0;
        repro_energy = 100;
        Algae alg = new Algae();
        speed = 1;
        sight = 100;
        health = 100;
        energy = 10;
        att = 5;
        def = 0;
        mutation_rate = 0.00;
        MyWorld world = (MyWorld) getWorld();
        
        int spX = 0;
        int spY = 0;
         energy = 35.0;

    }
 
   
    //boolean target = false;

    public ArrayList <Algae> target;
    public boolean tracking = false;
    public Algae alg = new Algae();
    public Actor nearestTarg;
    //public AI ai = new AI();
    /**
     * Act - do whatever the TestOrganism wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        //ai.track(20,20);
        //turnTowards(20,20);
        //move(1);
        //System.out.println(getX()+", "+getY());
        //checkKeys();
        if(world == null){
            world = (MyWorld) getWorld();
        }
        target = (ArrayList) getWorld().getObjects(Algae.class);
        if (target.size() >0 ){
            trk(this, target,speed, sight);
        }else{
            setRotation(getRotation()+Greenfoot.getRandomNumber(40)-20);
            move(1);
        }
        //System.out.println("Bug: "+getRotation());
        //System.out.println(alg.siz);
        feed();
       
        age();
         reproduce();
        //world.showText("Energy"+energy, 20,20);
        //nearestTarg = target.get(0);
    }    
       public void trk(Actor a, ArrayList t, int sp, int s){//track function, requests itself, its target, its speed, and its sight
        Actor nearestTarg = (Actor)t.get(0);
        for(int i = 0; i < t.size(); i++){
            if((MyWorld.getDist(a, nearestTarg)>MyWorld.getDist(a, (Actor)t.get(i)))){//if target is closer than current target
                nearestTarg = (Actor)t.get(i);//set target to next target
            }
            if(MyWorld.getDist(a, (Actor)t.get(i)) < s){//if target is within sights
                a.turnTowards(nearestTarg.getX(),nearestTarg.getY());//turn towards nearest target
                a.move(sp/(i+1));//move forwards
            }
            else{
                a.setRotation(a.getRotation()+((Greenfoot.getRandomNumber(40)-20)/(i+1)));//rotate randomly within limitations
                a.move(sp/(i+1));//move forwards
            }
        }
    }
    public void moveTo(int preyX,int preyY){
        if(target != null){
            turnTowards(preyX,preyY);
            move(1);
            energy -= .1;
        }
    }
    public void feed(){
        for(int i = 0; i <target.size(); i++){
            if(MyWorld.getDist(this, target.get(i))<10){
                energy += alg.energy*0.09;
                removeTouching(Algae.class);
                target.remove(i);
                lifeforms.remove(this);
                System.out.println("energy" + energy);
                // MyWorld.AbstOrganism.lifeforms--;
                target = (ArrayList) getWorld().getObjects(Algae.class);
            }
        }
    }
    public void move(){
        
    }
    public void die(){
               //remove them from all lists
        lifeforms.remove(this);
        //remove them from the world
        world.removeObject(this);
    }
    public void age(){
        age ++;
        //world.showText("Age: "+age, 300,100);
        //and check to see if past lifespan
        
        if(age>= Greenfoot.getRandomNumber(900)+900){
            // die();
        }
       
    }
    public void mutate(){
        
    }
    public void reproduce(){
        int numKids = 2; //set a random number of children
       
            if(energy>repro_energy){//when energy is bigger than required reproduction energy
               
                for(int i =0; i<numKids; i++){ //make a number of tempkids
                PlantEater tempKidP = new PlantEater();  //set algae to tempKid
                
                world.addObject(tempKidP,getX(),getY()); //spawn a new tempKid
                lifeforms.add(tempKidP); //add the new kid to the lifeforms array
                tempKidP.turn(Greenfoot.getRandomNumber(359)+1);   //make it turn once it respawns
                tempKidP.move(Greenfoot.getRandomNumber(90)+20);     //make it move in the previous direction
            }

            die();
        }
    }
    public void grow(){
        
    }
}