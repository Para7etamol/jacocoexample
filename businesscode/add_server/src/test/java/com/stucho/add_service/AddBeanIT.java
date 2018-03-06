package com.stucho.add_service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.naming.NamingException;

import org.junit.Test;

import com.stucho.test.base.AddServerBaseTest;

public class AddBeanIT extends AddServerBaseTest {

	private final String LOOKUP_BEAN_NAME = "addBean#com.stucho.add_service.AddBeanRemote";

	AddBeanRemote obj1;

	@Test
	public void testAddition() throws NamingException {

		AddBeanRemote addBean = (AddBeanRemote) getBean();
		assertNotNull(addBean);
		assertTrue(addBean.add(5, 4) == 9);

	}

	protected String getBeanName() {

		return LOOKUP_BEAN_NAME;
	}
}
