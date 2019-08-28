package com.example.test;

public class SingletonResults {


    private static final SingletonResults ourInstance = new SingletonResults();

    public static SingletonResults getInstance() {
        return ourInstance;
    }

    private SingletonResults() {
    }




}
