/*
 * John Schiefert, Duc Thach, and Kyle Logan
 * CS 471 Object Oriented Programming Fall 2017
 * This project is for the demonstration of the Monopoly Game implementation
 */
package monopoly;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CSVLoad implements LoadGame{

    @Override
    public List savedGame(String filename) {
        String data;
        List players = new ArrayList();
        
        try {
            BufferedReader load = new BufferedReader(new FileReader(filename));
    
            while((data = load.readLine()) != null && !data.isEmpty()){
                String [] temp = data.split(",");
                int tempSize = temp.length;
                for(int i = 0; i < tempSize; i++){
                    players.add(temp[i]);
                }
            } 
            load.close();
        } 
        catch (FileNotFoundException ex) {
            Logger.getLogger(CSVLoad.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("The file specified could not be found.");
        } 
        catch (IOException ex) {
            Logger.getLogger(CSVLoad.class.getName()).log(Level.SEVERE, null, ex);
        }
//        
//        
//        File game = new File(filename);
//        try {
//            Scanner loading = new Scanner(game);
//            while(loading.hasNext()){
//                String read = loading.next();
//                String [] players = read.split(",");
//            
//            }
//            
//        } 
//        catch (FileNotFoundException ex) {
//            Logger.getLogger(CSVLoad.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println("Can't find file: " + filename);
//        }
    return players;
    }
}
