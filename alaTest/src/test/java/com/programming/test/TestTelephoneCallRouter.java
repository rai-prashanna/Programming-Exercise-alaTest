package com.programming.test;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import com.programming.ICSVReader;
import com.programming.MyTelephoneCallRouter;
import com.programming.OperatorEntry;
import com.programming.TelephoneCallRouter;
import org.hamcrest.collection.IsMapContaining;

public class TestMyTelephoneCallRouter extends TestCase {
	private MyTelephoneCallRouter myTelephoneCallRouter;

	private ICSVReader mockCSVReader;
	
	@Before
	public void setUp() throws Exception {
		 this.mockCSVReader=Mockito.mock(ICSVReader.class);
	}

	@Test
	public void test_expect_cheap_price_from_operatorA_when_phonePrefix_is_46732_and_467() {
		Long phonenumber = new Long("4673212345");
		
		List<OperatorEntry> seedOperatorentrylist = new ArrayList<OperatorEntry>();
		seedOperatorentrylist.add(new OperatorEntry("OperatorA",new Integer(46732),new Double(1.2)));
		seedOperatorentrylist.add(new OperatorEntry("OperatorB",new Integer(467),new Double(1.0)));
		
		Map<String,String> expectedcheapOperator = new HashMap();
		expectedcheapOperator.put("Operator","OperatorB");
		expectedcheapOperator.put("price","1.0");
		
	    when(mockCSVReader.initalizeOperatorEntryfromCSVFiles()).thenReturn(seedOperatorentrylist);
		this.myTelephoneCallRouter = new MyTelephoneCallRouter(mockCSVReader);
	    Map<String,String> actualcheapPrice=myTelephoneCallRouter.getCheapOperator(phonenumber);
	    assertThat(actualcheapPrice, is(expectedcheapOperator));
	    
	}

}


