package com.stucho.substract_service;

import javax.ejb.Remote;

@Remote
public interface SubstractBeanRemote {
	
	public int substract(int num1, int num2);

}
