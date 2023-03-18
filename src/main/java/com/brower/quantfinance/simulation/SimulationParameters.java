package com.brower.quantfinance.simulation;

import org.springframework.context.annotation.Bean;

import java.util.List;

public abstract class SimulationParameters {
    public abstract List<Parameter> getParameters();

    public Double arithmeticMean() {
        double sum = 0.0;
        double length = 0.0;
        for (Parameter parameter : this.getParameters()) {
            sum += parameter.getValue();
            length += 1.0;
        }

        return sum / length;
    }
}
