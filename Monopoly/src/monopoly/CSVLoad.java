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
    public List loadGame(String filename) {
        String data;
        List players = new ArrayList();
        
        try {
            //BufferedReader load = new BufferedReader(new FileReader("/Users/be0754kc/NetBeansProjects/Monopoly/Monopoly/data.csv"));
            BufferedReader load = new BufferedReader(new FileReader("C://Users//John//Monopoly//Monopoly//data.csv"));   //For John's pc
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
        
    return players;
    }
}
