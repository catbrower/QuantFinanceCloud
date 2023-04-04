package com.brower.quantfinance.simulation;

import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class SimulationParametersBuilder {
    // TODO add a static seeding function for reproducible results
    private final Random random = new Random();
    private SimulationParameters simulationParameters;

    public SimulationParametersBuilder addParameter(String name, SimulationParameter param) {
        simulationParameters.put(name, param);
        return this;
    }

    public void translate(Number amount) {
        simulationParameters.keySet().forEach((paramName) -> {
            getParameter(paramName).add(amount);
        });
    }

    public void scale(Number amount) {
        simulationParameters.keySet().forEach((paramName) -> {
            getParameter(paramName).multiply(amount);
        });
    }

    public void addLinearNoise() {
        this.addLinearNoise(1);
    }

    public void addLinearNoise(double scale) {
        simulationParameters.keySet().forEach((paramName) -> {
            getParameter(paramName).add(random.nextDouble() * scale);
        });
    }

    public void addGaussianNoise() {
        this.addGaussianNoise(1);
    }

    public void addGaussianNoise(double scale) {
        this.simulationParameters.keySet().forEach((paramName) -> {
            getParameter(paramName).add(random.nextGaussian() * scale);
        });
    }

    public void multiplyLinearNoise() {
        this.multiplyLinearNoise(1);
    }
    public void multiplyLinearNoise(double scale) {
        this.simulationParameters.keySet().forEach((paramName) -> {
            getParameter(paramName).multiply(random.nextDouble() * scale);
        });
    }

    public void multiplyGaussianNoise(double scale) {
        this.simulationParameters.keySet().forEach((paramName) -> {
            getParameter(paramName).multiply(random.nextGaussian() * scale);
        });
    }

    private SimulationParameter getParameter(String paramName) {
        return simulationParameters.get(paramName);
    }

    public SimulationParameters build() {
        return simulationParameters;
    }
}
