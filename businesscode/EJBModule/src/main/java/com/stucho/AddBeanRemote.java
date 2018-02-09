package com.stucho;

import javax.ejb.Remote;

@Remote
public interface AddBeanRemote {

	public int add(int num1, int num2);
	
}
