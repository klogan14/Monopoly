/*
 * John Schiefert, Duc Thach, and Kyle Logan
 * CS 471 Object Oriented Programming Fall 2017
 * This project is for the demonstration of the Monopoly Game implementation
 */
package monopoly;

public class Piece {
    private Square location;
    
    public Piece(Square location){
        this.location = location;
    }
    
    public Square getLocation(){
        return location;
    }
    
    public void setLocation(Square location){
        this.location = location;
    }
    
}
