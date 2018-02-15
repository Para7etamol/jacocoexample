package com.stucho.add_service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class AddBeanTest {

    private EJBContainer ejbContainer;
    private Context ctx;
    
    // Name of AddBean in EJBContainer
    private static final String LOOKUP_ADD_BEAN = "addBean#com.stucho.add_service.AddBeanRemote";

    @Before
    public void setupTest() {
        try {
            ejbContainer = EJBContainer.createEJBContainer();
            ctx = ejbContainer.getContext();
        } catch (Exception e) {
            System.out.println("Something wrong with the setup of the EJBContainer: " + e.getMessage());
            throw (e);
        }
    }

    @After
    public void finishTest() {
        if (ejbContainer != null) {
            ejbContainer.close();
        }
    }

    @Test
    public void testAddition() throws NamingException {
    	
    	AddBeanRemote addBean = (AddBeanRemote) ctx.lookup(LOOKUP_ADD_BEAN);
        assertNotNull(addBean);
        assertTrue(addBean.add(5, 4) == 9);
        
    }

}
