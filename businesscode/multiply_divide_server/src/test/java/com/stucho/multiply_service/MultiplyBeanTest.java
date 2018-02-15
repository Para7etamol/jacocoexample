package com.stucho.multiply_service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.stucho.multiply_service.MultiplyBeanRemote;


public class MultiplyBeanTest {

    private EJBContainer ejbContainer;
    private Context ctx;
    
    // Name of MultiplyBean in EJBContainer
    private static final String LOOKUP_MULTIPLY_BEAN = "multiplyBean#com.stucho.multiply_service.MultiplyBeanRemote";

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
    public void testMultiplication() throws NamingException {
    	
    	MultiplyBeanRemote mulitiplierBean = (MultiplyBeanRemote) ctx.lookup(LOOKUP_MULTIPLY_BEAN);
        assertNotNull(mulitiplierBean);
        assertTrue(mulitiplierBean.multiply(5, 4) == 20);
        
    }

}
