package com.baselogic.tutorials.service;


public interface Lockable {

    void lock(String pattern);

    String getLockPattern();

    boolean matches(String methodName);
}
