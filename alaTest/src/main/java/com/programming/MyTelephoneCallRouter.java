package com.programming;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;


public class MyTelephoneCallRouter implements TelephoneCallRouter{
	
    Map<Integer, Double> opearatorA;
    
    Map<Integer, Double> opearatorB;
	public void initOperatorAEntry(){
		opearatorA = new TreeMap<Integer, Double>(
	            new Comparator<Integer>() {
	                public int compare(Integer o1, Integer o2) {
	                    return o2.compareTo(o1);
	                }
	            });
		
		//initialize all entry of OperatorA
		this.opearatorA.put(new Integer(1),new Double(0.9));
		this.opearatorA.put(new Integer(268),new Double(5.1));
		this.opearatorA.put(new Integer(46),new Double(0.17));
		this.opearatorA.put(new Integer(4620),new Double(0.0));
		this.opearatorA.put(new Integer(468),new Double(0.15));
		this.opearatorA.put(new Integer(4631),new Double(0.15));
		this.opearatorA.put(new Integer(4673),new Double(0.9));
		this.opearatorA.put(new Integer(46732),new Double(1.1));		
	}
	
	public void initOperatorBEntry(){
		this.opearatorB = new TreeMap<Integer, Double>(
	            new Comparator<Integer>() {
	                public int compare(Integer o1, Integer o2) {
	                    return o2.compareTo(o1);
	                }
	            });
		//initialize all entry of OperatorB
		this.opearatorB.put(new Integer(1),new Double(0.92));
		this.opearatorB.put(new Integer(44),new Double(0.5));
		this.opearatorB.put(new Integer(46),new Double(0.2));
		this.opearatorB.put(new Integer(467),new Double(1.0));
		this.opearatorB.put(new Integer(48),new Double(1.2));
	}
	
	
	public MyTelephoneCallRouter() {
		initOperatorAEntry();
		initOperatorBEntry();
	}

	public void displayOperatorAEntry(){
		//display all entry of OperatorA
		Iterator iter = this.opearatorA.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry mEntry = (Map.Entry) iter.next();
			System.out.println(mEntry.getKey() + " : " + mEntry.getValue());
		}
	}
	
		public void displayOperatorBEntry(){
			//display all entry of OperatorB
			Iterator iter = this.opearatorB.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry mEntry = (Map.Entry) iter.next();
				System.out.println(mEntry.getKey() + " : " + mEntry.getValue());
			}
	}
	
		public Map<String,String> getCheapOperator(Long phonenumber){	
			double priceA = lookupPriceAtOpeartorA(phonenumber);
			double priceB = lookupPriceAtOpeartorB(phonenumber);
			Map<String,String> cheapOperator = new HashMap();
/*		if(priceA==-1){
			System.out.println(" The Cheapest price for phone number "+ phonenumber + " is avaiable in operatorB with "+priceB);
			cheapOperator.put("Operator", "OperatorB");
			cheapOperator.put("price", String.valueOf(priceB));
		}
//		if(priceB==-1){
//			System.out.println(" The Cheapest price for phone number "+ phonenumber + " is avaiable in operatorA with "+priceA);
//			cheapOperator.put("Operator", "OperatorA");
//			cheapOperator.put("price", String.valueOf(priceA));
//		}
 */
		if((priceB<priceA)){
				System.out.println(" The Cheapest price for phone number "+ phonenumber + " is avaiable in operatorB with "+priceB);
				cheapOperator.put("Operator", "OperatorB");
				cheapOperator.put("price", String.valueOf(priceB));	
			}
		if(priceA<priceB){
			System.out.println(" The Cheapest price for phone number "+ phonenumber + " is avaiable in operatorA with "+priceA);
			cheapOperator.put("Operator", "OperatorA");
			cheapOperator.put("price", String.valueOf(priceA));
		}
		if(Double.isNaN(priceB) && Double.isNaN(priceB)){
			System.out.println(" The phone number "+ phonenumber +" cannot be dialed from Either Operator A or Operator B");
			return cheapOperator;
		}		
		if(Double.isNaN(priceB)){
			System.out.println(" The Cheapest price for phone number "+ phonenumber + " is avaiable in operatorA with "+priceA);
			cheapOperator.put("Operator", "OperatorA");
			cheapOperator.put("price", String.valueOf(priceA));
		}				
		if(Double.isNaN(priceA)){
			System.out.println(" The Cheapest price for phone number "+ phonenumber + " is avaiable in operatorB with "+priceB);
			cheapOperator.put("Operator", "OperatorB");
			cheapOperator.put("price", String.valueOf(priceB));
		}		
		return cheapOperator;

		}
		
		public double lookupPriceAtOpeartorA(Long phonenumber){
			int divider = 100000;
			int prefix=(int)(phonenumber/divider);
			double priceA=Double.NaN;
			while(divider<=1000000000){
				if(this.opearatorA.containsKey(prefix)){
					System.out.println("the prefix at operatorA is "+prefix);
					priceA=this.opearatorA.get(prefix);
					break;
				}
				divider=divider*10;
				prefix=(int)(phonenumber/divider);	
			}
			return priceA;
		}

		
		public double lookupPriceAtOpeartorB(Long phonenumber){
			int divider = 100000;
			int prefix=(int)(phonenumber/divider);
			double priceB = Double.NaN;
			while(divider<=1000000000){
				if(this.opearatorB.containsKey(prefix)){
					System.out.println("the prefix at operatorB is "+prefix);
					priceB=this.opearatorB.get(prefix);
					break;
				}
				divider=divider*10;
				prefix=(int)(phonenumber/divider);	
			}
			return priceB;
		}
		
public static void main(String[] args){
	
	TelephoneCallRouter myTelephoneCallRouter = new MyTelephoneCallRouter();
	//Long phonenumber = new Long("4603312345");  4803312345
	Long phonenumber = new Long("0083312345");
	System.out.println("the minimum price is "+ myTelephoneCallRouter.getCheapOperator(phonenumber));
	
		}


}




