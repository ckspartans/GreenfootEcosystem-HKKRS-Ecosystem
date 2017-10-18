
//import java.awt.*;
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class PlantGrass here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Algae extends AbstOrganism
{
    Color edge = new Color(0,0,0);
    Color fill = new Color(50,250,50);
    int [] newDna;
    public Algae(){
        prey = new ArrayList <Object>();
        predators = new ArrayList <Object>();
        trophicLevel = 0;
        age = 0;
        repro_energy = 100;
        lifespan = Greenfoot.getRandomNumber(900)+900;
        health = 100;
        energy = 10;
        siz =  (int)(0.2*energy+10.);
        att = 0;
        getImage(siz);
        def = 0;
        mutation_rate = 0.00;
        MyWorld world;
           
    }
    
    /**
     * Act - do whatever the PlantGrass wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(world == null){
            world = (MyWorld) getWorld();
        }
         
            feed();
            grow();
            if (lifeforms.size() < 400){
           
            reproduce();
        }
              age();
            //int x = AI.sampleMethod(3);
            //turnTowards(20,20);
            //move(1);
        // Add your action code here.
    }    
    
    public void feed(){
        //Increases energy
        getIntersectingObjects(Algae.class);
        double neighbourAmount = getIntersectingObjects(Algae.class).size();
        
       if (neighbourAmount > 1){
            energy += neighbourAmount *0.05 ;
            
            
        }else{
            energy += 0.5;
        }   
        //world.showText("energy: "+energy, 100,100);
        //say("Feed not implemented");
    }

    public void grow(){
        //increase size based on the current energy
        if ( siz <= 25){
            siz = (int)(0.2*energy+10.);
        }
        getImage(siz);
        
        //say("Grow not implemented");
    }
    public void getImage(int siz){
        
        GreenfootImage img = new GreenfootImage(siz,siz);
        img.setColor(edge);
        img.drawOval(0,0,siz-10,siz-10);
        img.setColor(fill);
        img.fillOval(0,0,siz-11,siz-11);

        
        setImage(img);
    }
    public void reproduce(){
        //check to see if there is enough energy to split
    
        int numKids = (Greenfoot.getRandomNumber(4)+1); //set a random number of children
        //int angle = 360/numKids;
       
        if(energy>=repro_energy){//when energy is bigger than required reproduction energy
            //System.out.println("Autism");
            for(int i =0; i<numKids; i++){ //make a number of tempkids
                Algae tempKid = new Algae();  //set algae to tempKid
                world.addObject(tempKid,getX(),getY()); //spawn a new tempKid
                mutate((int)this.lifespan,(int)this.repro_energy,this.def); //mutate the dna of parent
                
                tempKid.lifespan = newDna[0]; //set
                lifeforms.add(tempKid); //add the new kid to the lifeforms array
                
                tempKid.turn(Greenfoot.getRandomNumber(359)+1);   //make it turn once it respawns
                tempKid.move(Greenfoot.getRandomNumber(40)+20);     //make it move in the previous direction
                if (getX() >= 800 || getY() >=700){
                    tempKid.move((Greenfoot.getRandomNumber(40)+20)*-1);
                }                 else if (getX() <= 20 ||getY() <= 20){
                  tempKid.move((Greenfoot.getRandomNumber(40)+20)*-1);  

                }
            }

            die();//die after reproducing
        }
            //if yes then call the constructor for two new ones and kill the original
        //say("Reproduce not implemented");
    }

    public void age(){
        //increase age
        age ++;
        //world.showText("Age: "+age, 300,100);
        //and check to see if past lifespan
            if (AbstOrganism.lifeforms.size() >= 4){ //they will only die from age if theres more than 4 lifeforms
                if(age>= lifespan){// they will only die if they ve lived from 900 to 1800 frames
                    die();
                }
            }//if then kill them
        //say("Age not implemented");
    }

    public void die(){
        //remove them from all lists
        lifeforms.remove(this);
        //remove them from the world
        world.removeObject(this);
        //add a corpse object
    }

    public void move(){

        
        //say("Move not implemented");
    }
    
    
    public void mutate(int parentLifespan,int repro_energy,int def){
        newDna = Mutate.mutateAlgae(parentLifespan,repro_energy,def); //send dna of parent organism to be mutated and put new values in array
    }
}
