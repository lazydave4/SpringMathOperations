package com.Dawid;

import org.springframework.stereotype.Component;

@Component
class Add implements Operation {
    @Override
    public String name() {
        return "adding";
    }

    @Override
    public int execut(int first, int second) {
        return first + second;
    }
}
