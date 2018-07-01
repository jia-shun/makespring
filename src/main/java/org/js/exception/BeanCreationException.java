package org.js.exception;


/**
 * Created by JiaShun on 2018/7/1.
 */

public class BeanCreationException extends RuntimeException {
    private String name;
    public BeanCreationException(String msg){
        super(msg);
    }
    public BeanCreationException(String msg,Throwable cause){
        super(msg,cause);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
