package com.stucho.multiply_service;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class MultiplyBean
 */
@Stateless(mappedName = "multiplyBean")
public class MultiplyBean implements MultiplyBeanRemote {

    /**
     * Default constructor. 
     */
    public MultiplyBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public int multiply(final int num1, final int num2) {
		
		if(num1 == 0 && num2 == 0){
			
			System.out.println("Unnecessary computation ! ");
			return 0;
		}else{
			
			System.out.println("Processing...");
			return num1*num2;
		}
		
		
	}

}
