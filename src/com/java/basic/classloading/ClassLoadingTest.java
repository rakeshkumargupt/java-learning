package com.java.basic.classloading;

/**
 * Created by : Rakesh Gupta on 11/26/17
 * Package : com.java.basic
 */
public class ClassLoadingTest {
    public static void main(String[] args) {
        System.out.println("Starting Java Class Loading Test...");
        System.out.println(ClassLoadingTest.class.getDeclaredClasses().toString());
    }
}
