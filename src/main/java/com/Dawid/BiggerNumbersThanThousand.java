package com.Dawid;

public class BiggerNumbersThanThousand extends RuntimeException {
    ErrorDescription detailedException;

    public BiggerNumbersThanThousand(ErrorDescription detailedException) {
        this.detailedException = detailedException;
    }

    public ErrorDescription getDetailedException() {
        return detailedException;
    }
}

