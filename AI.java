import greenfoot.*;
import java.util.*;
/**
 * Functions allow Actors to track and flee prey and predators, respectively
 * 
 * @author Ryan Brandrick 
 * @version 1.16
 */
public class AI
{
    public void trk(Actor a, ArrayList t, int sp, int s){//track function, requests itself, its target, its speed, and its sight
        Actor nearestTarg = (Actor)t.get(0);//nearest target is the first in arraylist
        if(a!=null&&t!=null){
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
    }
    public void eat(AbstOrganism a, AbstOrganism b){//eat function, requests itslef, and its target
        if(a.att>=b.def){//if attack is greater than target defense
            b.health -= (a.att - b.def);//target health minus (attack minus target defense)
        }
        a.move(-a.speed*10);//move back
        b.f = false;//set target flee to false
        b.turnTowards(a.getX(),a.getY());//target turn towards
        b.move(b.speed*5);//target move towards
        if(b.att>=a.def){//if target attack is greater than defense
            a.health -= (b.att - a.def);//health minus (target attack minus defense)
        }
        if (b.health <= 0){//if health below or equal to 0
            a.energy += b.energy*0.09;//gain 0.09 times target energy            
            b.die();//run target die function
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
