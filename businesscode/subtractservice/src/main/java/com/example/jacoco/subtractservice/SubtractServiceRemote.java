package com/example/jacoco/subtractservice;


import javax.ejb.Remote;

@Remote

public interface SubtractServiceRemote {
    public int subtract(int a, int b);
}
