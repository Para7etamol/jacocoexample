package com.stucho.add_service_client;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.stucho.add_service_enterprise.AddBeanRemote;

public class AddServiceClient {

	public static void main(String[] args) {
		
		Properties properties = new Properties();
		properties.put(Context.PROVIDER_URL, "t3://localhost:7001");
		properties.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
		
		try {
			Context context = new InitialContext(properties);
			AddBeanRemote addBeanRemote = (AddBeanRemote) context.lookup("addBean#com.stucho.add_service_enterprise.AddBeanRemote");
			System.out.println("The result is : "+addBeanRemote.add(45, 32));
			
		} catch (final NamingException e) {
			
			e.printStackTrace();
		}
	}

}
