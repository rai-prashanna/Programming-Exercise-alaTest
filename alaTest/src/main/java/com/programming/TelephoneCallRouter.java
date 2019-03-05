package com.programming;

import java.util.List;
import java.util.Map;

/** 
 * interface for TelephoneCallRouter with functionality of 
 * 1) lookup for price from all operators for given Phonenumber and 
 * 2) find cheapPrice for call among given operators
 * @author Prashanna Rai 
 */ 
public interface TelephoneCallRouter {
	public List<OperatorEntry> lookupPriceAtOpeartors(Long phonenumber);
	public Map<String,String> getCheapOperator(Long phonenumber);
}
