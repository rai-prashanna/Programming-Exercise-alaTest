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


	@Test
	public void test_expect_cheap_price_from_operatorA_when_phonePrefix_is_1() {
		Long phonenumber = new Long("1603312345");	
		
		List<OperatorEntry> seedOperatorentrylist = new ArrayList<OperatorEntry>();
		seedOperatorentrylist.add(new OperatorEntry("OperatorA",new Integer(1),new Double(0.9)));
		seedOperatorentrylist.add(new OperatorEntry("OperatorB",new Integer(1),new Double(0.92)));

		Map<String,String> expectedcheapOperator = new HashMap();
		expectedcheapOperator.put("Operator","OperatorA");
		expectedcheapOperator.put("price","0.9");
	    when(mockCSVReader.initalizeOperatorEntryfromCSVFiles()).thenReturn(seedOperatorentrylist);
		this.myTelephoneCallRouter = new MyTelephoneCallRouter(mockCSVReader);
	    Map<String,String> actualcheapPrice=myTelephoneCallRouter.getCheapOperator(phonenumber);
	    assertThat(actualcheapPrice, is(expectedcheapOperator));
	}

	@Test
	public void test_expect_cheap_price_from_operatorA_when_phonePrefix_is_46() {
		Long phonenumber = new Long("4603312345");	

		List<OperatorEntry> seedOperatorentrylist = new ArrayList<OperatorEntry>();
		seedOperatorentrylist.add(new OperatorEntry("OperatorA",new Integer(46),new Double(0.17)));
		seedOperatorentrylist.add(new OperatorEntry("OperatorB",new Integer(46),new Double(0.2)));

		Map<String,String> expectedcheapOperator = new HashMap();
		expectedcheapOperator.put("Operator","OperatorA");
		expectedcheapOperator.put("price","0.17");
	    when(mockCSVReader.initalizeOperatorEntryfromCSVFiles()).thenReturn(seedOperatorentrylist);
		this.myTelephoneCallRouter = new MyTelephoneCallRouter(mockCSVReader);

	    Map<String,String> actualcheapPrice=myTelephoneCallRouter.getCheapOperator(phonenumber);
	    assertThat(actualcheapPrice, is(expectedcheapOperator));
	}

	@Test
	public void test_expect_cheap_price_from_operatorB_when_phonePrefix_is_44() {
		Long phonenumber = new Long("4483312345");
		
		List<OperatorEntry> seedOperatorentrylist = new ArrayList<OperatorEntry>();
		seedOperatorentrylist.add(new OperatorEntry("OperatorB",new Integer(44),new Double(0.5)));
		
		Map<String,String> expectedcheapOperator = new HashMap();
		expectedcheapOperator.put("Operator","OperatorB");
		expectedcheapOperator.put("price","0.5");
	    
		when(mockCSVReader.initalizeOperatorEntryfromCSVFiles()).thenReturn(seedOperatorentrylist);
		this.myTelephoneCallRouter = new MyTelephoneCallRouter(mockCSVReader);
		
	    Map<String,String> actualcheapPrice=myTelephoneCallRouter.getCheapOperator(phonenumber);
	    assertThat(actualcheapPrice, is(expectedcheapOperator));
	}

	
	@Test
	public void test_expect_no_price_from_both_operator_when_phonePrefix_is_not_in_list_in_operators() {
		Long phonenumber = new Long("0083312345");	
		
		List<OperatorEntry> seedOperatorentrylist = new ArrayList<OperatorEntry>();
		seedOperatorentrylist.add(new OperatorEntry("OperatorA",new Integer(46),new Double(0.17)));
		seedOperatorentrylist.add(new OperatorEntry("OperatorB",new Integer(44),new Double(0.5)));
		
		Map<String,String> expectedcheapOperator = new HashMap();
		when(mockCSVReader.initalizeOperatorEntryfromCSVFiles()).thenReturn(seedOperatorentrylist);
		this.myTelephoneCallRouter = new MyTelephoneCallRouter(mockCSVReader);

	    Map<String,String> actualcheapPrice=myTelephoneCallRouter.getCheapOperator(phonenumber);
	    assertThat(actualcheapPrice, is(expectedcheapOperator));
	}

}


