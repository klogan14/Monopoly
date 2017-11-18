/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

import java.util.List;

/**
 *
 * @author John
 */
public class Monopoly {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       DBLoad MyLoad = new DBLoad();
        
        List testList = MyLoad.savedGame("Players");
        
        for(int i=0; i < testList.size(); i++){
            System.out.println(testList.get(i));
        }
        
    }
    
}
