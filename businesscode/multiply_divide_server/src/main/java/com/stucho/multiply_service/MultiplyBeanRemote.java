package com.stucho.multiply_service;

import javax.ejb.Remote;

@Remote
public interface MultiplyBeanRemote {

	public int multiply(int num1, int num2);
	
}
