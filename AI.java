import greenfoot.*;
import java.util.*;
/**
 * Functions allow Actors to track and flee prey and predators, respectively
 * 
 * @author Ryan Brandrick 
 * @version 1.11
 */
public class AI
{
    public AI()
    {
    }
    public void trk(Actor a, ArrayList t, int sp, int s){//track function, requests itself, its target, its speed, and its sight
        Actor nearestTarg = (Actor)t.get(0);
        for(int i = 0; i < t.size(); i++){
            if((MyWorld.getDist(a, nearestTarg)>MyWorld.getDist(a, (Actor)t.get(i)))){//if target is closer than current target
                nearestTarg = (Actor)t.get(i);//set target to closest target
            }
        }
        if(MyWorld.getDist(a, nearestTarg) < s){//if target is within sights
            a.turnTowards(nearestTarg.getX(),nearestTarg.getY());//turn towards nearest target
            a.move(sp);//move forwards
        }
        else{//otherwise
            a.setRotation(a.getRotation()+((Greenfoot.getRandomNumber(40)-20)));//rotate randomly within limitations
            a.move(sp);//move forwards
        }
    }
    public void flee(Actor a, ArrayList t, int sp, int s){//flee function, requests itself, its target, its speed, and its sight
        Actor nearestPred = (Actor)t.get(0);
        for(int i = 0; i < t.size(); i++){
            if((MyWorld.getDist(a, nearestPred)>MyWorld.getDist(a, (Actor)t.get(i)))){//if target is closer than current targ
                nearestPred = (Actor)t.get(i);//set nearestTarg to nearest target
            }
        }
        if(MyWorld.getDist(a, nearestPred) < s){//if predator is within sights
                a.turnTowards(nearestPred.getX(),nearestPred.getY());//turn towards pred
                a.setRotation(a.getRotation()+180+(Greenfoot.getRandomNumber(40)-20));//turn randomly away from pred
                a.move(sp);//move
        }
        else{//otherwise
            a.setRotation(a.getRotation()+((Greenfoot.getRandomNumber(40)-20)));//rotate randomly within limitations
            a.move(sp);//move forwards
        }
    }
}