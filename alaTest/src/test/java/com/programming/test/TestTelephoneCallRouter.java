package com.programming.test;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.programming.TelephoneCallRouter;
import static org.hamcrest.CoreMatchers.is;
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import junit.framework.TestCase;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestTelephoneCallRouter extends TestCase {
	private static TelephoneCallRouter mockedTelephoneCallRouter;

	@Before
	public void setUp() throws Exception {
		mockedTelephoneCallRouter = mock(TelephoneCallRouter.class);
	}

	@Test
	public void test_expect_cheap_price_from_operatorA_when_phonePrefix_is_46732_and_467() {
		Long phonenumber = new Long("4673212345");
		Map<String,String> expectedcheapOperator = new HashMap();
		expectedcheapOperator.put("Operator","OperatorB");
		expectedcheapOperator.put("Price","1.0");
	    when(mockedTelephoneCallRouter.getCheapOperator(phonenumber)).thenReturn(expectedcheapOperator);
	    Map<String,String> actualcheapPrice=mockedTelephoneCallRouter.getCheapOperator(phonenumber);
	    assertThat(actualcheapPrice, is(expectedcheapOperator));
	}

	@Test
	public void test_expect_cheap_price_from_operatorA_when_phonePrefix_is_1() {
		Long phonenumber = new Long("1603312345");	
		Map<String,String> expectedcheapOperator = new HashMap();
		expectedcheapOperator.put("Operator","OperatorA");
		expectedcheapOperator.put("Price","0.9");
	    when(mockedTelephoneCallRouter.getCheapOperator(phonenumber)).thenReturn(expectedcheapOperator);
	    Map<String,String> actualcheapPrice=mockedTelephoneCallRouter.getCheapOperator(phonenumber);
	    assertThat(actualcheapPrice, is(expectedcheapOperator));
	}

	@Test
	public void test_expect_cheap_price_from_operatorA_when_phonePrefix_is_46() {
		Long phonenumber = new Long("4603312345");	
		Map<String,String> expectedcheapOperator = new HashMap();
		expectedcheapOperator.put("Operator","OperatorA");
		expectedcheapOperator.put("Price","0.17");
	    when(mockedTelephoneCallRouter.getCheapOperator(phonenumber)).thenReturn(expectedcheapOperator);
	    Map<String,String> actualcheapPrice=mockedTelephoneCallRouter.getCheapOperator(phonenumber);
	    assertThat(actualcheapPrice, is(expectedcheapOperator));
	}

	@Test
	public void test_expect_cheap_price_from_operatorB_when_phonePrefix_is_44() {
		Long phonenumber = new Long("4483312345");	
		Map<String,String> expectedcheapOperator = new HashMap();
		expectedcheapOperator.put("Operator","OperatorB");
		expectedcheapOperator.put("Price","0.5");
	    when(mockedTelephoneCallRouter.getCheapOperator(phonenumber)).thenReturn(expectedcheapOperator);
	    Map<String,String> actualcheapPrice=mockedTelephoneCallRouter.getCheapOperator(phonenumber);
	    assertThat(actualcheapPrice, is(expectedcheapOperator));
	}

	@Test
	public void test_expect_no_price_from_both_operator_when_phonePrefix_is_not_in_list_in_operators() {
		Long phonenumber = new Long("0083312345");	
		Map<String,String> expectedcheapOperator = new HashMap();
	    when(mockedTelephoneCallRouter.getCheapOperator(phonenumber)).thenReturn(expectedcheapOperator);
	    Map<String,String> actualcheapPrice=mockedTelephoneCallRouter.getCheapOperator(phonenumber);
	    assertThat(actualcheapPrice, is(expectedcheapOperator));
	}
	
}
