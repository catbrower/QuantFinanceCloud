package com.brower.quantfinance.simulation;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

/***
 * This class is responsible for returning parameters used to perform a backtesting simulation
 */
public class ParameterItemReader implements ItemReader {

    @Override
    public SimulationParameters read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        return new SimulationParametersBuilder()
                .addParameter("test", new SimulationDoubleParameter(0.0))
                .build();
    }
}
