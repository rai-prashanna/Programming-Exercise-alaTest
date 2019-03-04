package com.programming;

import java.util.Map;

public interface TelephoneCallRouter {
	public double lookupPriceAtOpeartorA(Long phonenumber);
	public double lookupPriceAtOpeartorB(Long phonenumber);
	public Map<String,String> getCheapOperator(Long phonenumber);
}
