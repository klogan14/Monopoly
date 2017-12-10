/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

import java.io.IOException;
import java.util.Observable;

/**
 *
 * @author be0754kc
 */
public class SaveBothObservable extends Observable 
{
    SaveCSV saveCSV = new SaveCSV();
    DBentry dbEntry = new DBentry();
    SaveCSVAdpater saveCSVAdapater = new SaveCSVAdpater(saveCSV); //adapater implementation
    
    public void saveCSV(String p1,Square p1Location, int p1Turn, String p2, Square p2Location,int  p2Turn, int round) throws IOException
    {
        setChanged();
        saveCSVAdapater.storeGame(p1, p1Location, p1Turn, p2, p2Location, p2Turn, round);
        notifyObservers("CSV Changed");

//        saveCSV.saveGameCsv(p1, p1Location, p1Turn, p2, p2Location, p2Turn, round);
    }
    
    public void saveDB(String piece, int location, int turn, int round)
    {
        setChanged();
        dbEntry.insert(piece, location, turn, round);
        notifyObservers("DB Changed");
    }
}
