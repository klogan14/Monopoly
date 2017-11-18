/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

import java.io.File;
import java.io.FileNotFoundException;
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
    public  void saveGameCsv(String pName1,Square pLocation1,
            String pName2, Square pLocation2) throws FileNotFoundException, IOException
    {
        File dataFile = new File("/Users/be0754kc/NetBeansProjects/Monopoly/Monopoly/data.csv");
        FileWriter pw = new FileWriter(dataFile,true);
        Scanner scanner = new Scanner(dataFile);
        //Path dataFilePath = (Path)dataFile.getPath();
        int id = 0;
        while(scanner.hasNext())
        {
            System.out.println(scanner.next());
            id++;
        }
        StringBuilder sb = new StringBuilder();
        //sb.append("PlayerName,Location");
        //sb.append('\n');
        sb.append('\n');
        sb.append(id);
        sb.append(", ");
        sb.append(pName1);
        sb.append(", ");
        sb.append(pLocation1.getIndex());
        sb.append('\n');

        sb.append(id);
        sb.append(", ");
        sb.append(pName2);
        sb.append(", ");
        sb.append(pLocation2.getIndex());
        sb.append('\n');
        
        pw.write(sb.toString());
        pw.close();
        System.out.println("done!");
//        List<String> lines = Files.readAllLines(dataFile.toPath());
//        lines.set(pLocation, pName);
//        System.out.println("File" + lines.toString());
    }
}
