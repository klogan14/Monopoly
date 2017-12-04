/*
 * John Schiefert, Duc Thach, and Kyle Logan
 * CS 471 Object Oriented Programming Fall 2017
 * This project is for the demonstration of the Monopoly Game implementation
 */
package monopoly;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//This is our Singleton design pattern 

public class MonopolyGame {
    private static final int ROUNDS_TOTAL = 20;
    private static final int PLAYERS_TOTAL = 2;
    private List players = new ArrayList(PLAYERS_TOTAL);
    private Board board = new Board();
    private Die[] dice = {new Die(), new Die()};

    public int roundsPlayed = 0;
    private MonopolyGame(){
        Player p;
        p = new Player("Horse", dice, board);
        p.setPlayerTurn(1);
        players.add(p);
        p = new Player("Car", dice, board);
        p.setPlayerTurn(0);
        players.add(p);
    }
    
    public void loadingGameDB(){
        DBLoad game = new DBLoad();
        List gameInfo = new ArrayList();
        gameInfo = game.loadGame("game1");
        Player p;
        p = new Player(gameInfo.get(0).toString(),dice, board);
        int locIndex = Integer.parseInt(gameInfo.get(1).toString());
        int turnIndex = Integer.parseInt(gameInfo.get(2).toString());
        p.setLocation(locIndex);
        p.setTurn(locIndex);
        p = new Player(gameInfo.get(4).toString(),dice, board);
        locIndex = Integer.parseInt(gameInfo.get(5).toString());
        turnIndex = Integer.parseInt(gameInfo.get(6).toString());
        p.setLocation(locIndex);
        p.setTurn(locIndex);
        roundsPlayed = Integer.parseInt(gameInfo.get(7).toString());
    }
    
    public void loadingGameCSV()
    {
        
        
        CSVLoad game = new CSVLoad();
        List gameInfo = new ArrayList();
        gameInfo = game.loadGame("game1");
        Player p;
        players.remove(0);
//        p = new Player(gameInfo.get(0).toString(),dice, board);
        p = new Player(gameInfo.get(3).toString(),dice, board);
        
        int locIndex = Integer.parseInt(gameInfo.get(4).toString());
        int turnIndex = Integer.parseInt(gameInfo.get(5).toString());

//        int locIndex = Integer.parseInt(gameInfo.get(1).toString());
//        int turnIndex = Integer.parseInt(gameInfo.get(2).toString());
        p.setLocation(locIndex);
        p.setTurn(turnIndex);
        System.out.println("player "+p.getName() +" turn " + p.getPlayerTurn() );

        players.add(p);
        
        
        players.remove(0);
        p = new Player(gameInfo.get(0).toString(),dice, board);
        locIndex = Integer.parseInt(gameInfo.get(1).toString());
        turnIndex = Integer.parseInt(gameInfo.get(2).toString());
       //p = new Player(gameInfo.get(3).toString(),dice, board);
       // locIndex = Integer.parseInt(gameInfo.get(4).toString());
       // turnIndex = Integer.parseInt(gameInfo.get(5).toString());
        p.setLocation(locIndex);
        p.setTurn(turnIndex);
        System.out.println("player "+p.getName() +" turn " + p.getPlayerTurn() );
        players.add(p);

        roundsPlayed = Integer.parseInt(gameInfo.get(6).toString());
    }
    
    
    public void setRoundsPlayed(int round)
    {
        this.roundsPlayed = round;
    }
    
    private static class MonopolyGameInstance{
        private static final MonopolyGame INSTANCE = new MonopolyGame();
    }   
    
    public static MonopolyGame getMonopolyGame(){
        return MonopolyGameInstance.INSTANCE;
    }
    

    public int getRoundsPlayed()
    {
        return this.roundsPlayed;
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
