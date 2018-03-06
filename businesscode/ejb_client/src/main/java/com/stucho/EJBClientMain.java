package com.stucho;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.stucho.add_service.AddBeanRemote;
import com.stucho.divide_service.DivideBeanRemote;
import com.stucho.multiply_service.MultiplyBeanRemote;
import com.stucho.substract_service.SubstractBeanRemote;

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

	public EJBClientMain() {
	}

	public static void main(String[] argv) throws Exception {
		
		try {

			InitialContext ic = getInitialContext("t3://localhost:7001");

			final int value1 = 36;
			final int value2 = 9;
			
			AddBeanRemote obj1 = (AddBeanRemote) ic.lookup("addBean#com.stucho.add_service.AddBeanRemote");
			System.out.println("The sum of ("+value1+" , "+value2+") is : " + obj1.add(value1, value2));
			
			SubstractBeanRemote ob2 = (SubstractBeanRemote) ic.lookup("substractBean#com.stucho.substract_service.SubstractBeanRemote");
			System.out.println("The difference of ("+value1+" , "+value2+") is : " + ob2.substract(value1, value2));
			
			DivideBeanRemote obj3 = (DivideBeanRemote) ic.lookup("divideBean#com.stucho.divide_service.DivideBeanRemote");
			System.out.println("The division result of ("+value1+" , "+value2+") is : " + obj3.divide(value1, value2));
			
			MultiplyBeanRemote obj4 = (MultiplyBeanRemote) ic.lookup("multiplyBean#com.stucho.multiply_service.MultiplyBeanRemote");
			System.out.println("The product of ("+value1+" , "+value2+") is : " + obj4.multiply(value1, value2));
			
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