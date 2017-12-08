/*
 * John Schiefert, Duc Thach, and Kyle Logan
 * CS 471 Object Oriented Programming Fall 2017
 * This project is for the demonstration of the Monopoly Game implementation
 */
package monopoly;
import java.util.ArrayList;
import java.util.List;

public class Board {
    private static final int SIZE = 40;
    private List squares = new ArrayList(SIZE);
    
    public Board(){
        buildSquares();
        linkSquares();
    }
    
    public Square getSquare(Square start, int distance){
        int endIndex = (start.getIndex() + distance) % SIZE;
        return (Square)squares.get(endIndex);
    }
    
    public Square getStartSquare(){
        return (Square) squares.get(0);
    }
    
    private void buildSquares(){
        for(int i = 1; i <= SIZE; i++){
            build(i);
        }
    }
    
    /*
        Factory Design Pattern
    */
    private void build(int i){
        
        if(i == 0){
            Square s = new goSquare();
            squares.add(s);
        }
        
        else{
            Square s = new regularSquare(i);
            squares.add(s);
        }

    }
    
    private void linkSquares(){
        for(int i = 0; i < (SIZE - 1); i++){
            link(i);
        }
        
        Square first = (Square) squares.get(0);
        Square last = (Square) squares.get(SIZE - 1);
        last.setNextSquare(first);
    }
    
    private void link(int i){
        Square current = (Square) squares.get(i);
        Square next = (Square) squares.get(i + 1);
        current.setNextSquare(next);
    }
    
}
