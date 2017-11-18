/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

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
        SaveCSV app = new SaveCSV();
        app.saveGameCsv("P1", "Car", 0);
        File csvFie = new File("/Users/be0754kc/Documents/CS471/MonopolyDB.csv");
        
        System.out.println();
        // TODO code application logic here
    }
    
}
