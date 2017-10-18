import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public class Mutate  
{
    int mutatedDna;
    //static boolean beneficial = true; //for future if we want to determine whether or not a mutation is benefitial or not//next iteration
    static int[] importedDna; //in array to hold dna value of current organism

    /**
     * Constructor for objects of class Mutate
     */
 
    
    //Different functions for different organism due to different traits associated with each organism
    
    
    public static int[] mutateAlgae(int lifespan, int reproduce, int def){ //etc, add more traits as we go on
       importedDna = new int[]{lifespan, reproduce, def}; //Set values of array to the parameters given

       for(int j = 0; j < importedDna.length; j++){
           if (importedDna[0] < 900){ 
               importedDna[j] += Greenfoot.getRandomNumber(200)-100;//test number to confirm mutation works and can modify values by given random number
           }
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
    
    
    public static int[] mutatePlantEater(int speed, int sight, int repro_energy){ //etc, add mroe as needed
       importedDna = new int[]{speed, sight, repro_energy}; //add more dna traits such as tracking range etc as needed
        
       for(int j = 0; j < importedDna.length; j++){
          if (importedDna[0] < 900){ 
               importedDna[j] += Math.abs(Greenfoot.getRandomNumber(2)-1);//test number to confirm mutation works and can modify values by given random number
           }
           /*if(beneficial){
              importedDna[j] += Greenfoot.getRandomNumber(3);//(int)maxGood);
          } else {
              importedDna[j]-= Greenfoot.getRandomNumber(2);
          }*/
       }
        
        
       return importedDna; //function sends back new modified planteater dna values
    }
    
    
    
}





