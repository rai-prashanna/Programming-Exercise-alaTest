package com.programming;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/** 
 * Concrete implementation of TelephoneCallRouter 
 * 
 * @author Prashanna Rai 
 */ 
public class MyTelephoneCallRouter implements TelephoneCallRouter{
	// Entity holding all prices for prefix from all operators 
    private List<OperatorEntry> operatorentrylist;
    
    //Entity holding all prices for phonenumber from all operators 
    private List<OperatorEntry> matchedOperatorEntryList;
    
	public MyTelephoneCallRouter() {
		operatorentrylist = new MyCSVReader().initalizeOperatorEntryfromCSVFiles();
		matchedOperatorEntryList=new ArrayList<OperatorEntry>();
	}

	public MyTelephoneCallRouter(ICSVReader csvreader) {
		operatorentrylist = csvreader.initalizeOperatorEntryfromCSVFiles();
		matchedOperatorEntryList=new ArrayList<OperatorEntry>();
	}
	public List<OperatorEntry> lookupPriceAtOpeartors(Long phonenumber){
		int divider = 100000;
		int prefix=(int)(phonenumber/divider);
		double price = Double.NaN;
		String operatorName;
		Map<Integer, Double> pricelist;
		for(OperatorEntry operatorentry: operatorentrylist){
			operatorName = operatorentry.getOperatorName();
			 pricelist = operatorentry.getPricelist();
				while(divider<=1000000000){
					if(pricelist.containsKey(prefix)){
						System.out.println("the prefix is found at "+operatorName+" is "+prefix);
						price = pricelist.get(prefix);
						matchedOperatorEntryList.add(new OperatorEntry(operatorName,prefix,price));
						break;
					}
					divider=divider*10;
					prefix=(int)(phonenumber/divider);	
				}
		}
		return matchedOperatorEntryList;
	}

public Map<String,String> getCheapOperator(Long phonenumber){	
	List<OperatorEntry> matchedOperators= lookupPriceAtOpeartors(phonenumber);
	String cheapOperatorName=null;
	Double cheapPrice = Double.NaN;
	Map<String,String> cheapOperator = new HashMap<String, String>();
	for (OperatorEntry operatorEntry : matchedOperators) {
		Iterator iterator = operatorEntry.getPricelist().entrySet().iterator();
		while (iterator.hasNext()) {
	        Map.Entry pair = (Map.Entry)iterator.next();
	        Double currentPrice = (Double) pair.getValue();
	        if(!Double.isNaN(currentPrice)){
	        	if(Double.isNaN(cheapPrice)){
	        		cheapPrice=currentPrice;
        			cheapOperatorName=operatorEntry.getOperatorName();

	        		cheapOperator.put("Operator", cheapOperatorName);
        			cheapOperator.put("price", String.valueOf(cheapPrice));	        	}
	        	else{
	        		if(currentPrice<cheapPrice){
	        			cheapPrice=currentPrice;
	        			cheapOperator=new HashMap<String, String>();
	        			cheapOperatorName=operatorEntry.getOperatorName();
	        			cheapOperator.put("Operator", cheapOperatorName);
	        			cheapOperator.put("price", String.valueOf(cheapPrice));
	        		}
	        	}
	        }
	        cheapOperatorName = operatorEntry.getOperatorName();
	        iterator.remove();
	    } 
	}
		return cheapOperator;
		}
		
		
public static void main(String[] args){
	
	if(args.length==1){
		System.out.println("the phoneNumber is "+args[0]);

		TelephoneCallRouter myTelephoneCallRouter = new MyTelephoneCallRouter();
		Long phonenumber = Long.parseLong(args[0]);
		System.out.println("the minimum price is "+ myTelephoneCallRouter.getCheapOperator(phonenumber));
				
	}
	if(args.length==0){
		System.out.println("Please enter phoneNumber ");
	}
	else{
		System.out.println("Please enter only one phoneNumber ");

	}
		}


}




