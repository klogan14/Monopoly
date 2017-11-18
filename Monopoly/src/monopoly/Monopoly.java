/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;


import java.util.List;
import java.io.File;
import java.io.IOException;

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
        MonopolyGame mp = new MonopolyGame();
        List<Player> players = mp.getPlayers();
        mp.playGame();
        players.get(0).takeTurn();
        
        SaveCSV app = new SaveCSV();
        app.saveGameCsv(players.get(0).getName(),players.get(0).getLocation()
                ,players.get(1).getName(),  players.get(1).getLocation());
        File csvFie = new File("/Users/be0754kc/Documents/CS471/MonopolyDB.csv");
        
        System.out.println();
        // TODO code application logic here
        
//        DBLoad MyLoad = new DBLoad();
//        
//        List testList = MyLoad.savedGame("Players");
//        
//        for(int i=0; i < testList.size(); i++)
//        {
//            System.out.println(testList.get(i));
//        }
    }
    
}
