package com.stucho;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * This client uses the remote HelloServer methods.
 *
 * @author Copyright (c) Oracle. All Rights Reserved.
 */
public class EJBClientMain {

	/**
	 * Defines the JNDI context factory.
	 */
	public final static String JNDI_FACTORY = "weblogic.jndi.WLInitialContextFactory";

	int port;
	String host;


	public EJBClientMain() {
	}

	public static void main(String[] argv) throws Exception {
		
		try {

			InitialContext ic = getInitialContext("t3://localhost:7001");

			AddBeanRemote obj = (AddBeanRemote) ic.lookup("addBean#com.stucho.AddBeanRemote");
			System.out.println("The resut is : " + obj.add(31, 42));
		} catch (Throwable t) {
			t.printStackTrace();
			System.exit(-1);
		}

	}

	private static InitialContext getInitialContext(String url) throws NamingException {
		Hashtable<String, String> env = new Hashtable<String, String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, JNDI_FACTORY);
		env.put(Context.PROVIDER_URL, url);
		return new InitialContext(env);
	}
}