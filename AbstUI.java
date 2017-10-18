import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class AbstOrgansim here.
 * 
 * @author Rowbottom 
 * @version Sept. 27 2017
 */
public abstract class AbstUI extends Actor{

    MyWorld world;
    SimpleTimer timer = new SimpleTimer();
    int duration ;
    public int time;
    public boolean pDown = false;
    public boolean choose = false;
    public int spawnNum;
    

 public abstract void pause();    
  
    public abstract void pMenu();
   
    public abstract void sMenu();
   
    public abstract void numMenu();
   
    public abstract void draw();
    
    public void say(String phrase){
        System.out.println(phrase);
    }
                  
};