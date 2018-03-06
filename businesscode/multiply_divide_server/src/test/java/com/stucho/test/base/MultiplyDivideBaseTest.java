package com.stucho.test.base;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Before;

public abstract class MultiplyDivideBaseTest {

	/**
	 * Defines the JNDI context factory.
	 */
	public final static String JNDI_FACTORY = "weblogic.jndi.WLInitialContextFactory";
	
	private Context ctx;

	private String URL = "t3://localhost:7001";

	@After
	public void finishTest() {

		try {

			ctx.close();
		} catch (final NamingException e) {

			e.printStackTrace();
		}
	}

	protected Object getBean() throws NamingException {

		final String LOOKUP_BEAN_NAME = getBeanName();
		if (StringUtils.isEmpty(LOOKUP_BEAN_NAME)) {

			throw new UnsupportedOperationException("Invalid bean name.");
		}

		return ctx.lookup(LOOKUP_BEAN_NAME);
	}

	protected abstract String getBeanName();

	@Before
	public void setupTest() {

		final Hashtable<String, String> env = new Hashtable<String, String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, JNDI_FACTORY);
		env.put(Context.PROVIDER_URL, URL);
		try {

			ctx = new InitialContext(env);
		} catch (final NamingException e) {

			e.printStackTrace();
		}
	}

}
