/*
 * John Schiefert, Duc Thach, and Kyle Logan
 * CS 471 Object Oriented Programming Fall 2017
 * This project is for the demonstration of the Monopoly Game implementation
 * This is our main thread, it will allow you to play from the console.
 */
package monopoly;



import java.util.List;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Monopoly
{

    
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
  
    public static void main(String[] args) throws IOException 
    {
        
        System.out.println("Load GUI or play on Console? 1 for GUI or 2 for console");
        Scanner main = new Scanner(System.in);
        String decision = main.next();
        
        switch(decision){
            case "1":
                    //This code will bring up the main GUI when project is compiled and ran
                    SwingUtilities.invokeLater(new Runnable(){
                    @Override
                    public void run(){
                        BoardGame gui = new BoardGame();
                        JFrame frame = new JFrame();
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.getContentPane().add(gui);
                        frame.pack();
                        frame.setVisible(true);
                    }
                    });
                    break;       
            
            case "2":
                    Monopoly start = new Monopoly();
                    start.gameSelect();
                    break;
            
            default:
                    Monopoly.main(args);
                    break;
        }      
//File csvFie = new File("/Users/be0754kc/Documents/CS471/MonopolyDB.csv");
    }
    
    
public void gameSelect(){
    Scanner scan = new Scanner(System.in);
        System.out.println("Would you like to play a new game or load an old one?"
                + "\n Type \"NEW\" for a new game and \"LOAD\""
                + " for the old game number you wanted");
        
        String input = scan.nextLine();
        
        if(input.equals("NEW"))
        {
                    MonopolyGame mpNew = MonopolyGame.getMonopolyGame();
                    System.out.println("Entered New");
                    playGame(mpNew);
        }
        else if(input.equals("LOAD"))
        {
            MonopolyGame mpNew = MonopolyGame.getMonopolyGame();
            System.out.println("Would you like to load from database type \"DB\" or CSV File type \"CSV\"?");
            input = scan.nextLine();
            if(input.equals("DB"))
            {
               System.out.println("Entered DB");
               mpNew.loadingGameDB();
               playGame(mpNew);
            }
            else if(input.equals("CSV"))
            {
                System.out.println("Entered CSV");
                mpNew.loadingGameCSV(); 
                playGame(mpNew);
            }
            else
            {
                System.out.println("You did not print DB or CSV");
                gameSelect();
            }
        }
        else
        {
            System.out.println("You did not print NEW or LOAD");
            gameSelect();       
        }
    }

    public void playGame(MonopolyGame game)
    {
        String input = "";
        Scanner play1 = new Scanner(System.in);
        Scanner play2 = new Scanner(System.in);
        List<Player> players = game.getPlayers();
        
        SaveCSV saveCSV = new SaveCSV();
        SaveCSVAdpater saveCSVAdapater = new SaveCSVAdpater(saveCSV); //adapater implementation
      
        game.setRoundsPlayed(game.getRoundsPlayed());
        int roundsPlayed = game.getRoundsPlayed();
        DBentry dbEntry = new DBentry();

        
        System.out.println("Player1 = " + players.get(0).getName()+ " & turn is " + players.get(0).getTurn());
        System.out.println("Player2= " + players.get(1).getName()+ " & turn is " + players.get(1).getTurn());
        
        while(!input.equals("END") || roundsPlayed > game.getRoundsTotal())
        {
            if(players.get(0).getPlayerTurn() == 1)
            {
                    System.out.println("Player "+players.get(0).getName()+" enter PLAY to take a turn or END to end the game");
                    input = play1.nextLine();
                
                    if(input.equals("PLAY"))  
                    {
                        players.get(0).takeTurn();
                        players.get(0).setPlayerTurn(0);
                        players.get(1).setPlayerTurn(1);
                        //after doing players turn, save player information
                        try{
                            saveCSVAdapater.storeGame(players.get(0).getName(),players.get(0).getLocation(),players.get(0).getPlayerTurn(),
                            players.get(1).getName(),  players.get(1).getLocation(), players.get(1).getPlayerTurn(),game.getRoundsPlayed());
                            dbEntry.update(players.get(1).getName(), players.get(1).getLocation().getIndex(), players.get(1).getPlayerTurn(), game.getRoundsPlayed());
                            dbEntry.update(players.get(0).getName(), players.get(0).getLocation().getIndex(), players.get(0).getPlayerTurn(), game.getRoundsPlayed());
                        } 
                        catch (IOException ex){
                            Logger.getLogger(Monopoly.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    
                    }
                    else if(input.equals("END")){
                        System.out.println("You entered END");
                        System.out.println("Exiting Game");
                        System.out.println(players.get(0).getName()+" turn " +players.get(0).getPlayerTurn());
                        System.out.println(players.get(1).getName()+" turn " +players.get(1).getPlayerTurn());
                        System.exit(0);
                    }
     //This is not working correctly, need error handling to loop back to start of player one's turn. Currently skipping player one's turn.                
                    else
                    {
                        System.out.println("You entered an incorrect selection....");
                        System.out.println("Player " + players.get(0).getName()+ " enter PLAY to take a turn or END to end the game");
                        input = play1.next();
                    } 

            }
            
            else
            {    
                    System.out.println("Player "+players.get(1).getName()+" enter PLAY to take a turn or END to end the game");
                    input = play1.nextLine();
                
                    if(input.equals("PLAY"))
                    {
                        players.get(1).takeTurn();
                        players.get(0).setPlayerTurn(1);
                        players.get(1).setPlayerTurn(0);

                        System.out.println(players.get(0).getName()+" turn " +players.get(0).getPlayerTurn());
                        System.out.println(players.get(1).getName()+" turn " +players.get(1).getPlayerTurn());
                        roundsPlayed++;
                        game.setRoundsPlayed(roundsPlayed); 
                    
                        try{
                            saveCSVAdapater.storeGame(players.get(0).getName(),players.get(0).getLocation(),players.get(0).getPlayerTurn(),
                            players.get(1).getName(),  players.get(1).getLocation(), players.get(1).getPlayerTurn(),game.getRoundsPlayed());
                            dbEntry.update(players.get(1).getName(), players.get(1).getLocation().getIndex(), players.get(1).getPlayerTurn(), game.getRoundsPlayed());
                            dbEntry.update(players.get(0).getName(), players.get(0).getLocation().getIndex(), players.get(0).getPlayerTurn(), game.getRoundsPlayed());
                        } 
                        catch (IOException ex){
                            Logger.getLogger(Monopoly.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    
                    }
                    else if(input.equals("END"))
                    {
                        System.out.println("You entered END");
                        System.out.println("Exiting Game");
                        System.out.println(players.get(0).getName()+" turn " +players.get(0).getPlayerTurn());
                        System.out.println(players.get(1).getName()+" turn " +players.get(1).getPlayerTurn());
                        System.exit(0);
                    }
    //This is not working correctly, need error handling to loop back to start of player two's turn. Currently skipping player two's turn.
                    else
                    {
                        System.out.println("You entered an incorrect selection....");
                        System.out.println("Player " + players.get(1).getName()+ " enter PLAY to take a turn or END to end the game");
                        input = play2.next();
                    } 
            }         
        }
    }
}
    
    