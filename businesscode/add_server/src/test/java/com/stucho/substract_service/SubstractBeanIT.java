package com.stucho.substract_service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class SubstractBeanIT {

    private EJBContainer ejbContainer;
    private Context ctx;
    
    // Name of SubstractBean in EJBContainer
    private static final String LOOKUP_SUBSTRACT_BEAN = "substractBean#com.stucho.substract_service.SubstractBeanRemote";

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
    public void testSubstraction() throws NamingException {
    	
    	SubstractBeanRemote substractBean = (SubstractBeanRemote) ctx.lookup(LOOKUP_SUBSTRACT_BEAN);
        assertNotNull(substractBean);
        assertTrue(substractBean.substract(0, 0) == 0);
        
    }
    

}
