package com.stucho.divide_service;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class DivideBean
 */
@Stateless(mappedName = "divideBean")
public class DivideBean implements DivideBeanRemote {

    /**
     * Default constructor. 
     */
    public DivideBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public int divide(final int num1, final int num2) {
		
		if(num1 == 0 && num2 == 0){
			
			System.out.println("You are asking for trouble ! ");
			throw new ArithmeticException();
		}else{
			
			System.out.println("Processing...");
			return num1/num2;
		}
	}

}
