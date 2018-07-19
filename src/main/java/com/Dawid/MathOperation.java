package com.Dawid;

import org.springframework.stereotype.Component;

@Component
public class MathOperation implements Operation {

    @Override
    public String name() {
        return "dawid";
    }

    @Override
    public int execut(int first, int second) {
        if (first > 1000 || second > 1000) {
            ErrorDescription errorDescription = new ErrorDescription(first, second, "bigger number than thousand ");
            throw new BiggerNumbersThanThousand(errorDescription);

        }

        return ((first * 2) - (second * 10));
    }
}
