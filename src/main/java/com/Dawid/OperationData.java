package com.Dawid;

import java.util.Objects;

public class OperationData {
    private int first;
    private int second;
    private String operation;

    public OperationData(String operation, int first, int second) {
        this.operation = operation;
        this.first = first;
        this.second = second;

    }

    public OperationData() {

    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OperationData)) return false;
        OperationData that = (OperationData) o;
        return getFirst() == that.getFirst() &&
                getSecond() == that.getSecond() &&
                Objects.equals(getOperation(), that.getOperation());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getFirst(), getSecond(), getOperation());
    }

}
