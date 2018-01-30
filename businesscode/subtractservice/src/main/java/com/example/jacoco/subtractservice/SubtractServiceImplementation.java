package com.example.jacoco.subtractservice;

import javax.ejb.Stateless;

@Stateless
public class SubtractServiceImplementation implements SubtractServiceRemote {

    @Override
    public int subtract(int a, int b){
	return a-b;
    }

}
