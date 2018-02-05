package com.stucho.add_service_enterprise;

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
	public int add(int num1, int num2) {
		// TODO Auto-generated method stub
		return num1+num2;
	}

}
