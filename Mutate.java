import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public class Mutate  
{
    int mutatedDna;
    static boolean benefitial = true; //for future if we want to determine whether or not a mutation is benefitial or not
    static int[] importedDna; //in array to hold dna value of current organism

    /**
     * Constructor for objects of class Mutate
     */
    public Mutate()
    {
        
    }
    
    //Different functions for different organism due to different traits associated with each organism
    
    
    public static int[] mutateAlgae(int lifespan, int reproduce, int def){ //etc, add more traits as we go on
       importedDna = new int[]{lifespan, reproduce, def}; //Set values of array to the parameters given

       for(int j = 0; j < importedDna.length; j++){
          importedDna[j] -= Greenfoot.getRandomNumber(200);//test number to confirm mutation works and can modify values by given random number
           
          /*
          if(benefitial){
              importedDna[j] += Greenfoot.getRandomNumber(10) - 5; // substitute int in randomNumber later with a user changable varialbe to determine how good/bad a mutation is
          } else {
              importedDna[j]-= Greenfoot.getRandomNumber(10); 
          }
          */
       }
       
       return importedDna; //function sends back new modified algae dna values
    }
    
    
    public static int[] mutatePlanteater(int speed, int health, int trackingDistance){ //etc, add mroe as needed
       importedDna = new int[]{speed, health, trackingDistance}; //add more dna traits such as tracking range etc as needed
        
       for(int j = 0; j < importedDna.length; j++){
          if(benefitial){
              importedDna[j] += Greenfoot.getRandomNumber(3);//(int)maxGood);
          } else {
              importedDna[j]-= Greenfoot.getRandomNumber(2);
          }
       }
        
        
       return importedDna; //function sends back new modified planteater dna values
    }
    
    
    
}





