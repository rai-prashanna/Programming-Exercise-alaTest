package com.programming;

import com.opencsv.CSVReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;

/** 
 * Contains infrastructure necessary for parsing csv files from resources folder 
 * and create OperatorEntry entities.
 * 
 * @author Prashanna Rai 
 */ 
public class MyCSVReader implements ICSVReader{
	private static URL url;
	  static 
	  { 
	    ClassLoader cldr = MyCSVReader.class.getClassLoader();
	    url = MyCSVReader.class.getResource("/com/programming/src/main/resources/Operator A.csv");
	  }

    public List<OperatorEntry> initalizeOperatorEntryfromCSVFiles() {
    	ClassLoader classLoader = getClass().getClassLoader();
    	String csvFile = "";
        CSVReader reader = null;
        List operatorlist= new ArrayList<OperatorEntry>();
        try {
        	File folder = new File("classes/target");
        	System.out.println("the path is "+folder.getAbsolutePath());
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
                            System.out.println(" [operator= "+ opeartor_name+ ", prefix= " + line[0] + ", price= " + line[1]+ "]");
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
