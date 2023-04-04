package com.brower.quantfinance.simulation;

/**
 * An individual simulation parameter which is a wrapper for Number
 * Contains basic mathematical operations for convenience
 */
public abstract class SimulationParameter {
    private Number value;

    public SimulationParameter(Number value) {
        this.value = value;
    }

    public Number getValue() {
        return value;
    }

    public void setValue(Number value) {
        this.value = value;
    }

    public int intValue() {
        return value.intValue();
    }

    public double doubleValue() {
        return value.doubleValue();
    }

    public abstract void add(Number amount);

    public abstract void subtract(Number amount);

    public abstract void multiply(Number amount);

    public abstract void divideBy(Number amount);
}
