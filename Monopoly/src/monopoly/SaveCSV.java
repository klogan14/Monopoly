/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

import java.io.File;
import java.io.FileNotFoundException;
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
    public  void saveGameCsv(String pName, String pPiece, int pLocation) throws FileNotFoundException, IOException
    {
        File dataFile = new File("/Users/be0754kc/NetBeansProjects/Monopoly/Monopoly/data.csv");
        PrintWriter pw = new PrintWriter(dataFile);
        Scanner scanner = new Scanner(dataFile);
        //Path dataFilePath = (Path)dataFile.getPath();
        List<String> lines = Files.readAllLines(dataFile.toPath());
        lines.set(pLocation, pName);
        System.out.println("File" + lines.toString());
    }
}
