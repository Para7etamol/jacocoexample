package com.stucho.substract_service;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class SubstractBean
 */
@Stateless(mappedName = "substractBean")
public class SubstractBean implements SubstractBeanRemote {

    /**
     * Default constructor. 
     */
    public SubstractBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public int substract(int num1, int num2) {
		
		if(num1 == 0 && num2 == 0){
			
			System.out.println("Unnecessary computation ! ");
			return 0;
		}else{
			
			System.out.println("Processing...");
			return num1-num2;
		}
	}

}
