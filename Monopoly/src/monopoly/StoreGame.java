/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author be0754kc
 */
public interface StoreGame
{

    public void storeGame(String pName1, Square pLocation1,int p1_Turn, String pName2, Square pLocation2, int p2_Turn, int RoundNumber)throws FileNotFoundException, IOException;

}

