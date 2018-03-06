package com.stucho.substract_service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.naming.NamingException;

import org.junit.Test;

import com.stucho.test.base.AddServerBaseTest;


public class SubstractBeanIT extends AddServerBaseTest{

   
    // Name of SubstractBean in EJBContainer
    private final String LOOKUP_BEAN_NAME = "substractBean#com.stucho.substract_service.SubstractBeanRemote";

    @Test
    public void testSubstraction() throws NamingException {
    	
    	SubstractBeanRemote substractBean = (SubstractBeanRemote) getBean();
        assertNotNull(substractBean);
        assertTrue(substractBean.substract(0, 0) == 0);
        
    }
    
    protected String getBeanName() {

		return LOOKUP_BEAN_NAME;
	}
    

}
