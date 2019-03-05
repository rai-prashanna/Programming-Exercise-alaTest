package com.programming;

import java.util.List;
import java.util.Map;

public interface TelephoneCallRouter {
	public List<OperatorEntry> lookupPriceAtOpeartors(Long phonenumber);
	public Map<String,String> getCheapOperator(Long phonenumber);
}
