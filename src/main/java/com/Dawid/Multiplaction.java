package com.Dawid;

import org.springframework.stereotype.Component;

@Component
public class Multiplaction implements Operation {

    @Override
    public String name() {
        return "multiply";
    }

    @Override
    public int execut(int first, int second) {
        return first * second;
    }

}
