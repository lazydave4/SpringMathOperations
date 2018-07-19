package com.Dawid;

import org.springframework.stereotype.Component;

@Component
public class Division implements Operation {
    @Override
    public String name() {
        return "division";
    }

    @Override
    public int execut(int first, int second) {
        return first / second;
    }


}
