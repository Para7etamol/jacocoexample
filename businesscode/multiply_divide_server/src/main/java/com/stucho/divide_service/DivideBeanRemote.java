package com.stucho.divide_service;

import javax.ejb.Remote;

@Remote
public interface DivideBeanRemote {
	
	public int divide(int num1, int num2);

}
