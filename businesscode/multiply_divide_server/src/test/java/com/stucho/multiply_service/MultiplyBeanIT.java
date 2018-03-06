package com.stucho.multiply_service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.naming.NamingException;

import org.junit.Test;

import com.stucho.test.base.MultiplyDivideBaseTest;

public class MultiplyBeanIT extends MultiplyDivideBaseTest {

	private static final String LOOKUP_BEAN_NAME = "multiplyBean#com.stucho.multiply_service.MultiplyBeanRemote";

	@Test
	public void testMultiplication() throws NamingException {

		MultiplyBeanRemote mulitiplierBean = (MultiplyBeanRemote) getBean();
		assertNotNull(mulitiplierBean);
		assertTrue(mulitiplierBean.multiply(5, 4) == 20);

	}

	protected String getBeanName() {

		return LOOKUP_BEAN_NAME;
	}

}
