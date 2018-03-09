package com.stucho.substract_service;
import static org.junit.Assert.*;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.stucho.substract_service.SubstractBeanRemote;

public class SubtractServiceIT {
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
System.out.println("Before Initial Context");
			InitialContext ic = getInitialContext("t3://localhost:7001");
			System.out.println("After Initial Context");
			final int value1 = 36;
			final int value2 = 6;
			
			System.out.println("Before Remote object"+ ic.lookup("substractBean#com.stucho.substract_service.SubstractBeanRemote"));
			SubstractBeanRemote ob2 = (SubstractBeanRemote) ic.lookup("substractBean#com.stucho.substract_service.SubstractBeanRemote");
			
			System.out.println("The difference of ("+value1+" , "+value2+") is : " + ob2.substract(value1, value2));
			
			
			
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
