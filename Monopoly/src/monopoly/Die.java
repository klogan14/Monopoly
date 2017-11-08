/*
 * John Schiefert, Duc Thach, and Kyle Logan
 * CS 471 Object Oriented Programming Fall 2017
 * This project is for the demonstration of the Monopoly Game implementation
 */
package monopoly;

public class Die {
    public static final int MAX = 6;
    private int faceValue;
    
    public Die(){
        roll();
    }
    
    public void roll(){
        faceValue = (int)((Math.random() * MAX) + 1);
    }
    
    public int getFaceValue(){
        return faceValue;
    }
    
}
