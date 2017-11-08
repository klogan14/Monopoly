/*
 * John Schiefert, Duc Thach, and Kyle Logan
 * CS 471 Object Oriented Programming Fall 2017
 * This project is for the demonstration of the Monopoly Game implementation
 */
package monopoly;

public class Square {
    private String name;
    private Square nextSquare;
    private int index;
    
    public Square(String name, int index){
        this.name = name;
        this.index = index;
    }
    
    public void setNextSquare(Square s){
        nextSquare = s;
    }
    
    public Square getNextSquare(){
        return nextSquare;
    }
    
    public String getName(){
        return name;
    }
    
    public int getIndex(){
        return index;
    }
    
}
