package com.stucho.divide_service;

import static org.junit.Assert.assertNotNull;

import javax.ejb.EJBException;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class DivideBeanTest {

    private EJBContainer ejbContainer;
    private Context ctx;
    
    // Name of DivideBean in EJBContainer
    private static final String LOOKUP_DIVIDE_BEAN = "divideBean#com.stucho.divide_service.DivideBeanRemote";

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

    @Test(expected = EJBException.class)
    public void testZeroByZeroDivision() throws NamingException {
    	
    	DivideBeanRemote divideBean = (DivideBeanRemote) ctx.lookup(LOOKUP_DIVIDE_BEAN);
        assertNotNull(divideBean);
        divideBean.divide(0, 0);        
    }
    

}
