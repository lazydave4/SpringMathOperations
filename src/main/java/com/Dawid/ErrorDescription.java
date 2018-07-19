package com.Dawid;

public class ErrorDescription {
    int firstArgument;
    int secondArgument;
    String message;

    public ErrorDescription(int firstArgument, int secondArgument, String message) {
        this.firstArgument = firstArgument;
        this.secondArgument = secondArgument;
        this.message = message;
    }

    public int getFirstArgument() {
        return firstArgument;
    }

    public int getSecondArgument() {
        return secondArgument;
    }

    public String getMessage() {
        return message;
    }
}
