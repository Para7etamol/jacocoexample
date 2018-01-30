package com/example/jacoco/subtractservice;

import javax.ejb.Stateless;

@Stateless
public class SubtracvtServiceImplementation implements CalculatorServiceRemote {

    @Override
    public int subtract(int a, int b){
	return a-b;
    }

}
