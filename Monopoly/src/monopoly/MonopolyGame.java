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

public class MonopolyGame 
{
    private static final int ROUNDS_TOTAL = 20;
    private static final int PLAYERS_TOTAL = 2;
    private List players = new ArrayList(PLAYERS_TOTAL);
    private Board board = new Board();
    private Die[] dice = {new Die(), new Die()};

    public int roundsPlayed = 0;
    
    /*
        Singleton you can only get one intance
    */
    
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
        players.remove(0);
        p = new Player(gameInfo.get(0).toString(),dice, board);
        
        int locIndex = Integer.parseInt(gameInfo.get(1).toString());
        int turnIndex = Integer.parseInt(gameInfo.get(2).toString());


        p.setLocation(locIndex);
        p.setTurn(turnIndex);

        players.add(p);
        players.remove(0);
        
        p = new Player(gameInfo.get(4).toString(),dice, board);
        locIndex = Integer.parseInt(gameInfo.get(5).toString());
        turnIndex = Integer.parseInt(gameInfo.get(6).toString());
        p.setLocation(locIndex);
        p.setTurn(turnIndex);
        players.add(p);            
        
        roundsPlayed = Integer.parseInt(gameInfo.get(7).toString());        
    }

    public void loadingGameCSV()
    {        
        CSVLoad game = new CSVLoad();
        List gameInfo = new ArrayList();
        gameInfo = game.loadGame("game1");
        
        
 for(int i = 0; i< gameInfo.size(); i++){
    System.out.println("spot " + i + ": " + gameInfo.get(i).toString());
 }
        
        
        Player p;
        int lastEntry = (gameInfo.size() - 1);
        String info = gameInfo.get(lastEntry).toString();
        String [] temp = info.split(",");
        
        players.remove(0);
        p = new Player(temp[0],dice, board);
        
        int locIndex = Integer.parseInt(temp[1]);
        int turnIndex = Integer.parseInt(temp[2]);


        p.setLocation(locIndex);
        p.setTurn(turnIndex);
        System.out.println("player "+p.getName() +" turn " + p.getPlayerTurn() );

        players.add(p);
        
        
        players.remove(0);
        p = new Player(temp[3],dice, board);
        locIndex = Integer.parseInt(temp[4]);
        turnIndex = Integer.parseInt(temp[5]);
        p.setLocation(locIndex);
        p.setTurn(turnIndex);
        System.out.println("player "+p.getName() +" turn " + p.getPlayerTurn() );
        players.add(p);

        roundsPlayed = Integer.parseInt(temp[6]);
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
    
    public void setPlayers(List ofPlayers){
        this.players = ofPlayers;
    }
    
    private void playRound(){
        for(Iterator iter = players.iterator(); iter.hasNext();){
            Player player = (Player) iter.next();
            player.takeTurn();
        }
    }
    
    public int getRoundsTotal(){
        return ROUNDS_TOTAL;
    }
    
}
