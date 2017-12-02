/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SaveCSVAdpater implements StoreGame
{
    private SaveCSV adaptee;
    
    public SaveCSVAdpater(SaveCSV saveCsv)
    {
        this.adaptee = saveCsv;
    }
            
    
    @Override
    public void storeGame(String pName1, Square pLocation1,int p1_Turn, String pName2, Square pLocation2, int p2_Turn, int RoundNumber) throws FileNotFoundException, IOException
    {
       
            adaptee.saveGameCsv(pName1, pLocation1, p1_Turn, pName2, pLocation2, p2_Turn, RoundNumber);
        
    }
    
}
