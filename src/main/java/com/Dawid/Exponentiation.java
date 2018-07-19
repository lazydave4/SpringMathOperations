package com.Dawid;

import org.springframework.stereotype.Component;

@Component
class Exponentiation implements Operation{
    @Override
    public String name() {
        return "exponentiation";
    }
    @Override
    public int execut(int first, int second) {
        if (first == 0){
            ErrorDescription errorDescription = new ErrorDescription(first,second,"error first argument number equal to zero");
            throw new NumberFromZero(errorDescription);
        }
        return (int)Math.pow(first, second);
    }
}