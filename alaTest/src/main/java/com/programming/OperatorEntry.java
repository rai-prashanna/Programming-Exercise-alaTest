package com.programming;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class OperatorEntry {
	private String operatorName;
	private Map<Integer, Double> pricelist;
	
	public OperatorEntry(String operatorName, Integer prefix, Double price) {
		this();
		this.operatorName = operatorName;
		this.pricelist.put(prefix, price);
	}

	public OperatorEntry() {
		this.operatorName = null;
		this.pricelist = new TreeMap<Integer, Double>(
	            new Comparator<Integer>() {
	                public int compare(Integer o1, Integer o2) {
	                    return o2.compareTo(o1);
	                }
	            });
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public Map<Integer, Double> getPricelist() {
		return pricelist;
	}

	public void setPricelist(Integer prefix, Double price) {
		this.pricelist.put(prefix, price);
	}
	
	public void setPricelist(String operatorName,Integer prefix, Double price) {
		this.operatorName=operatorName;
		this.pricelist.put(prefix, price);
	}
	
}
