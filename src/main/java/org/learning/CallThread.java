package org.learning;

import java.util.concurrent.Callable;


public class CallThread implements Callable<Object> {

    @Override
    public Object call(){
        return new Object();
    }

}
