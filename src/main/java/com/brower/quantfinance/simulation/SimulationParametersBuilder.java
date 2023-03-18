package com.brower.quantfinance.simulation;

import java.util.List;
import java.util.Random;

public class SimulationParametersBuilder {
    // TODO add a static seeding function for reproducible results
    private final Random random = new Random();
    private List<Parameter> parameters;

    public void addParameter(String name) {
        parameters.add(new Parameter(name, 0.0));
    }

    public void addParameters(List<String> params) {
        params.forEach((name) -> {
            this.parameters.add(new Parameter(name, 0.0));
        });
    }

    public void translate(double amount) {
        this.parameters.forEach((param) -> {
            param.add(amount);
        });
    }

    public void scale(double amount) {
        this.parameters.forEach((param) -> {
            param.multiply(amount);
        });
    }

    public void addLinearNoise() {
        this.addLinearNoise(1);
    }

    public void addLinearNoise(double scale) {
        this.parameters.forEach((param) -> {
            param.add(random.nextDouble() * scale);
        });
    }

    public void addGaussianNoise() {
        this.addGaussianNoise(1);
    }

    public void addGaussianNoise(double scale) {
        this.parameters.forEach((param) -> {
            param.add(random.nextGaussian() * scale);
        });
    }

    public void multiplyLinearNoise() {
        this.multiplyLinearNoise(1);
    }
    public void multiplyLinearNoise(double scale) {
        this.parameters.forEach((param) -> {
            param.multiply(random.nextDouble() * scale);
        });
    }

    public void multiplyGaussianNoise(double scale) {
        this.parameters.forEach((param) -> {
            param.multiply(random.nextGaussian() * scale);
        });
    }
}
