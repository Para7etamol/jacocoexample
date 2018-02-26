package com.stucho.add_service;

import org.junit.Test;

import javax.naming.NamingException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class AddPojoTest {

    @Test
    public void testAddition() throws NamingException {

        AddPojo addPojo = new AddPojo();
        assertTrue(addPojo.add(5, 4) == 9);

    }
}
