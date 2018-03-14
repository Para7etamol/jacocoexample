package com.stucho.divide_service;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DivideServiceIT {
	
	public final static String JNDI_FACTORY = "weblogic.jndi.WLInitialContextFactory";


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMain() {
		try {

			InitialContext ic = getInitialContext("t3://localhost:7001");

			final int value1 = 36;
			final int value2 = 6;
			
			
			DivideBeanRemote ob2 = (DivideBeanRemote) ic.lookup("divideBean#com.stucho.divide_service.DivideBeanRemote");
			System.out.println("The difference of ("+value1+" , "+value2+") is : " + ob2.divide(value1, value2));
			
			
	} catch (final Throwable t) {
			
			t.printStackTrace();
			System.exit(-1);
		}

	}
	
private static InitialContext getInitialContext(final String url) throws NamingException {
		
		Hashtable<String, String> env = new Hashtable<String, String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, JNDI_FACTORY);
		env.put(Context.PROVIDER_URL, url);
		return new InitialContext(env);
	}

}
