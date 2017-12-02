/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;


import java.util.List;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author John
 */
public class Monopoly {

    
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
  
    public static void main(String[] args) throws IOException 
    {
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
        
        MonopolyGame game1 = MonopolyGame.getMonopolyGame();
//        SaveCSV app = new SaveCSV();
//        app.saveGameCsv("P1", "Car", 0);
//        File csvFie = new File("/Users/be0754kc/Documents/CS471/MonopolyDB.csv");
        
        System.out.println();
        // TODO code application logic here
        System.out.println("database loading...");
        DBLoad MyLoad = new DBLoad();
        List testList = MyLoad.loadGame("Game1");
        
        for(int i=0; i < testList.size(); i++){
            System.out.println(testList.get(i));
        }
        
        System.out.println("csv loading...");
        CSVLoad csv = new CSVLoad();
        List testList1 = csv.loadGame("data");
        
        for(int i=0; i < testList1.size(); i++){
            System.out.println(testList.get(i));
        }
        
        
    }
    
}
