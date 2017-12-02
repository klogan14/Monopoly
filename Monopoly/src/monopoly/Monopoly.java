/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;



import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author John
 */
public class Monopoly {

    
    /**
     * @param args the command line arguments
     */
  
    public static void main(String[] args) throws IOException 
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Would you like to play a new game or load an old one?"
                + "\n Type \"NEW\" for a new game and \"LOAD #\""
                + " for the old game number you wanted"
        );
        
        
        
        String input = scan.nextLine();
        
        if(input.equals("NEW"))
        {
                    MonopolyGame mpNew = new MonopolyGame();
                    System.out.println("Entered New");
        }
        else if(input.equals("LOAD"))
        {
            System.out.println("Would you like to load from database type \"DB\" or CSV File type \"CSV\"?");
            input = scan.nextLine();
            if(input.equals("DB"))
            {
               System.out.println("Entered DB");
            }
            else if(input.equals("CSV"))
            {
                System.out.println("Entered CSV");

            }
            else
            {
                System.out.println("You did not print DB or CSV");
                System.out.println("Exiting Game");
                System.exit(0);
            }
        }
        else
        {
            System.out.println("You did not print NEW or LOAD");
            System.out.println("Exiting Game");
            System.exit(0);
                    
        }
        
        
        MonopolyGame mp = new MonopolyGame();
        List<Player> players = mp.getPlayers();
        int roundsPlayed = 0;
        while(!input.equals("END") || roundsPlayed > 20/* OR playedRounds ==20*/)
        {
            System.out.println("Player one enter PLAY to take a turn or END to end the game");
            input = scan.nextLine();
                //players.get(0).setplayerTurn(1);
                if(input.equals("PLAY"))  
                {
                    players.get(0).takeTurn();
                    players.get(0).setplayerTurn(0);
                    players.get(1).setplayerTurn(1);
                    
                    System.out.println("p1 turn " +players.get(0).getPlayerTurn());
                    System.out.println("p2 turn " +players.get(1).getPlayerTurn());

                    //update csv and db
                }
                else if(input.equals("END"))
                {
                    System.out.println("You entered END");
                    System.out.println("Exiting Game");
                    System.out.println("p1 turn " +players.get(0).getPlayerTurn());
                    System.out.println("p2 turn " +players.get(1).getPlayerTurn());
                    //players.get(1).setplayerTurn(1);

                    //System.exit(0);
                }
                
            System.out.println("Player Two enter PLAY to take a turn or END to end the game");
            input = scan.nextLine();
            //update csv
            
            //increment played rounds
             if(input.equals("PLAY"))  
                {
                    players.get(1).takeTurn();
                    players.get(0).setplayerTurn(1);
                    players.get(1).setplayerTurn(0);

                    System.out.println("p1 turn " +players.get(0).getPlayerTurn());
                    System.out.println("p2 turn " +players.get(1).getPlayerTurn());
                    
                    //update csv and db
                }
                else if(input.equals("END"))
                {
                    System.out.println("You entered END");
                    System.out.println("Exiting Game");
                    System.out.println("p1 turn " +players.get(0).getPlayerTurn());
                    System.out.println("p2 turn " +players.get(1).getPlayerTurn());
                    //System.exit(0);
                }
            
            if(input.equals("PLAY"))
            {
                mp.setRoundsPlayed(roundsPlayed);
                roundsPlayed++;
            }
            
        }
        SaveCSV saveCSV = new SaveCSV();
        SaveCSVAdpater saveCSVAdapater = new SaveCSVAdpater(saveCSV);

        
        System.out.println("FOR NEXT GAME p1 turn " +players.get(0).getPlayerTurn());
        System.out.println("FOR NEXT GAME p2 turn " +players.get(1).getPlayerTurn());
        saveCSVAdapater.storeGame(players.get(0).getName(),players.get(0).getLocation(),players.get(0).getPlayerTurn(),
                players.get(1).getName(),  players.get(1).getLocation(), players.get(1).getPlayerTurn(),mp.getRoundsPlayed());
        


//File csvFie = new File("/Users/be0754kc/Documents/CS471/MonopolyDB.csv");
        
        System.out.println();
        
        if(input.equals("END"))
        {
            System.out.println("Exiting Program");
            System.out.println("FOR NEXT GAME p1 turn " +players.get(0).getPlayerTurn());
            System.out.println("FOR NEXT GAME p2 turn " +players.get(1).getPlayerTurn());
            System.exit(0);
        }
    }
    
}
