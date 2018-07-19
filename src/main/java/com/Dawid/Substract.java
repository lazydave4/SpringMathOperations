package com.Dawid;

import org.springframework.stereotype.Component;

@Component
public class Substract implements Operation {
    @Override
    public String name() {
        return "substract";
    }

    @Override
    public int execut(int first, int second) {
        return first-second;
    }
}
