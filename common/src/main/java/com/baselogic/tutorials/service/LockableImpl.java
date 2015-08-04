package com.baselogic.tutorials.service;

public class LockableImpl implements Lockable{

    private String lockPattern = "";

    public void lock(String lockPattern){
        this.lockPattern = lockPattern;
    }

    public String getLockPattern(){
        return lockPattern;
    }

    public boolean matches(String methodName){
        return methodName.matches(lockPattern);
    }

}
