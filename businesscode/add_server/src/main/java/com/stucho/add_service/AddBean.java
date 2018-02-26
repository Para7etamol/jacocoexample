package com.stucho.add_service;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class AddBean
 */
@Stateless(mappedName = "addBean")
public class AddBean implements AddBeanRemote {

    /**
     * Default constructor.
     */
    public AddBean() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public int add(final int num1, final int num2) {
        return new AddPojo().add(num1, num2);
    }

}
