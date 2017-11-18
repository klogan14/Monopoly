/*
 * John Schiefert, Duc Thach, and Kyle Logan
 * CS 471 Object Oriented Programming Fall 2017
 * This project is for the demonstration of the Monopoly Game implementation
 */
package monopoly;

import java.util.List;

public interface LoadGame {

    /**
     *
     * @param filename this will be name that the game was saved as
     * @return a String array that contains the names, piece names, and locations of the players. 
     * Each piece of data should be stored in individual array blocks. 
     */
    public List savedGame(String filename);
    
}
