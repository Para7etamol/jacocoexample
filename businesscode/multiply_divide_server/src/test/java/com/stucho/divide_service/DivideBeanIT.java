package com.stucho.divide_service;

import static org.junit.Assert.assertNotNull;

import javax.ejb.EJBException;
import javax.naming.NamingException;

import org.junit.Test;

import com.stucho.test.base.MultiplyDivideBaseTest;

public class DivideBeanIT extends MultiplyDivideBaseTest {

	private static final String LOOKUP_BEAN_NAME = "divideBean#com.stucho.divide_service.DivideBeanRemote";

	@Test(expected = EJBException.class)
	public void testZeroByZeroDivision() throws NamingException {

		DivideBeanRemote divideBean = (DivideBeanRemote) getBean();
		assertNotNull(divideBean);
		divideBean.divide(0, 0);
	}

	protected String getBeanName() {

		return LOOKUP_BEAN_NAME;
	}

}
