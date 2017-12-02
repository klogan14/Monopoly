/*
 * John Schiefert, Duc Thach, and Kyle Logan
 * CS 471 Object Oriented Programming Fall 2017
 * This project is for the demonstration of the Monopoly Game implementation
 */
package monopoly;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MonopolyGame {
    private static final int ROUNDS_TOTAL = 20;
    private static final int PLAYERS_TOTAL = 2;
    private List players = new ArrayList(PLAYERS_TOTAL);
    private Board board = new Board();
    private Die[] dice = {new Die(), new Die()};
    
    private MonopolyGame(){
        Player p;
        p = new Player("Horse", dice, board);
        players.add(p);
        p = new Player("Car", dice, board);
        players.add(p);
    }
    
    private static class MonopolyGameInstance{
        private static final MonopolyGame INSTANCE = new MonopolyGame();
    }   
    
    public static MonopolyGame getMonopolyGame(){
        return MonopolyGameInstance.INSTANCE;
    }
    
    public void playGame(){
        for(int i = 0; i < ROUNDS_TOTAL; i++){
            playRound();
        }
    }
    
    public List getPlayers(){
        return players;
    }
    
    private void playRound(){
        for(Iterator iter = players.iterator(); iter.hasNext();){
            Player player = (Player) iter.next();
            player.takeTurn();
        }
    }
    
}
