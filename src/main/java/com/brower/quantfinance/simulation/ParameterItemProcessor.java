package com.brower.quantfinance.simulation;

import org.springframework.batch.item.ItemProcessor;

public class ParameterItemProcessor implements ItemProcessor<SimulationParameters, SimulationResults> {
    @Override
    public SimulationResults process(SimulationParameters item) throws Exception {
        return null;
    }
}
