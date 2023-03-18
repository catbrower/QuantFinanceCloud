package com.brower.quantfinance.simulation;

public class Parameter {
    private String name;
    private double value;

    public Parameter(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public void add(double amount) {
        this.value += amount;
    }

    public void multiply(double amount) {
        this.value *= amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
