package org.js.exception;

/**
 * Created by JiaShun on 2018/7/1.
 */

public class BeanDefinitionException extends RuntimeException {
    public BeanDefinitionException(String msg){
        super(msg);
    }
    public BeanDefinitionException(String msg,Throwable cause){
        super(msg,cause);
    }
}
