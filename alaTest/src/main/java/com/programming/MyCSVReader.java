package com.programming;

import com.opencsv.CSVReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.IOUtils;

public class MyCSVReader {

    public List<OperatorEntry> initalizeOperatorEntryfromCSVFiles() {
    	ClassLoader classLoader = getClass().getClassLoader();
    	String csvFile = "";
        CSVReader reader = null;
        List operatorlist= new ArrayList<OperatorEntry>();
        try {
        	File folder = new File(classLoader.getResource(csvFile).getFile());
            File[] listOfFiles = folder.listFiles();
            for (final File fileEntry : listOfFiles) { 
            OperatorEntry operatorEntry	= new OperatorEntry();
            String filename=fileEntry.getName();
            String opeartor_name = filename.split("\\.")[0];
            operatorEntry.setOperatorName(opeartor_name);
                    if(fileEntry.getName().contains(".csv")){
                    	reader = new CSVReader(new FileReader(fileEntry));
                        String[] line;
                        while ((line = reader.readNext()) != null) {
                            System.out.println(" [prefix= " + line[0] + ", price= " + line[1]+ "]");
                            operatorEntry.setPricelist(Integer.parseInt(line[0]), Double.parseDouble(line[1]));
                        }
                        operatorlist.add(operatorEntry);
                    }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    	return operatorlist;
      }
    
    
}