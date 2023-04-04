package com.brower.quantfinance.simulation;

public class SimulationIntegerParameter extends SimulationParameter {
    public SimulationIntegerParameter(Number value) {
        super(value);
    }

    @Override
    public void add(Number amount) {
        this.setValue(this.getValue().intValue() + amount.intValue());
    }

    @Override
    public void subtract(Number amount) {
        this.setValue(this.getValue().intValue() - amount.intValue());
    }

    @Override
    public void multiply(Number amount) {
        this.setValue(this.getValue().intValue() * amount.intValue());
    }

    @Override
    public void divideBy(Number amount) {
        this.setValue(this.getValue().intValue() / amount.intValue());
    }
}
