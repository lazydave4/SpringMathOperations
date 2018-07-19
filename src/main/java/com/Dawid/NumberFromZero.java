package com.Dawid;


public class NumberFromZero extends RuntimeException{

    ErrorDescription errorDescription;

    public NumberFromZero(ErrorDescription errorDescription){
        this.errorDescription=errorDescription;
    }

    public ErrorDescription getErrorDescription() {
        return errorDescription;
    }
}
