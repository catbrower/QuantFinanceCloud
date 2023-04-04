package com.brower.quantfinance.simulation;

public class SimulationDoubleParameter extends SimulationParameter {
    public SimulationDoubleParameter(Number value) {
        super(value);
    }

    @Override
    public void add(Number amount) {
        setValue(this.getValue().doubleValue() + amount.doubleValue());
    }

    @Override
    public void subtract(Number amount) {
        setValue(this.getValue().doubleValue() - amount.doubleValue());
    }

    @Override
    public void multiply(Number amount) {
        this.setValue(this.getValue().doubleValue() * amount.doubleValue());
    }

    @Override
    public void divideBy(Number amount) {
        this.setValue(this.getValue().doubleValue() / amount.doubleValue());
    }
}
