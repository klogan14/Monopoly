/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author be0754kc
 */
public class SaveCSV 
{
    public  void saveGameCsv(String pName1,Square pLocation1, int p1_Turn, String pName2, Square pLocation2, int p2_Turn, int round) throws FileNotFoundException, IOException
    {
        
        File dataFile = new File("/Users/be0754kc/NetBeansProjects/Monopoly/Monopoly/data.csv");
       // File dataFile = new File("C:/Users/John/Monopoly/Monopoly/data.csv");    // For John's pc
        BufferedReader file = new BufferedReader(new FileReader(dataFile));
        //try (FileOutputStream fileOut = new FileOutputStream("/Users/be0754kc/NetBeansProjects/Monopoly/Monopoly/data.csv")) {
        try (
            FileOutputStream fileOut = new FileOutputStream(dataFile)) {
            Scanner scanner = new Scanner(dataFile);
            
            StringBuilder sb = new StringBuilder();
            //sb.append("PlayerName,Location");
            //sb.append('\n');
            sb.append(pName1);
            sb.append(",");
            sb.append(pLocation1.getIndex());
            sb.append(",");
            sb.append(p1_Turn);
            sb.append(",");
            
            sb.append(pName2);
            sb.append(",");
            sb.append(pLocation2.getIndex());
            sb.append(",");
            sb.append(p2_Turn);
            sb.append(",");
            //sb.append('\n');
            sb.append(round);
            sb.append('\n');
            
            fileOut.write(sb.toString().getBytes());
        }
      //  System.out.println("done!");
//        List<String> lines = Files.readAllLines(dataFile.toPath());
//        lines.set(pLocation, pName);
//        System.out.println("File" + lines.toString());
    }

}
