package com.brower.quantfinance.strategy;

import com.brower.quantfinance.simulation.InvalidSimulationParametersException;
import com.brower.quantfinance.simulation.SimulationParameter;
import com.brower.quantfinance.simulation.SimulationParameters;
import com.brower.quantfinance.simulation.SimulationResults;
import org.ta4j.core.AnalysisCriterion;
import org.ta4j.core.BarSeries;
import org.ta4j.core.TradingRecord;
import org.ta4j.core.criteria.ReturnOverMaxDrawdownCriterion;
import org.ta4j.core.criteria.WinningPositionsRatioCriterion;

/**
 * Base class for all strategies
 */
public abstract class Strategy {
    private SimulationParameters parameters;

    /**
     * All strategies should contain a zero argument constructor that sets the default parameters
     * This methods ensures that all the simulation parameters defined in the constructor are present
     * @param parameters
     * @throws InvalidSimulationParametersException
     */
    public void setParameters(SimulationParameters parameters) throws InvalidSimulationParametersException {
        if(parameters.size() != this.parameters.size()) {
            throw new InvalidSimulationParametersException();
        }

        for(String parameter : parameters.keySet()) {
            if(!this.parameters.containsKey(parameter)) {
                throw new InvalidSimulationParametersException();
            }
        }

        this.parameters = parameters;
    }
    protected SimulationResults calculateSimulationResults(BarSeries series, TradingRecord record) {
        AnalysisCriterion winningPositionsRatio = new WinningPositionsRatioCriterion();
        AnalysisCriterion romad = new ReturnOverMaxDrawdownCriterion();

        SimulationResults results = new SimulationResults();
        results.setWinningPositionsRatio(winningPositionsRatio.calculate(series, record).doubleValue());
        results.setRomad(romad.calculate(series, record).doubleValue());
        return results;
    }

    public SimulationParameters getAllParameters() {
        return parameters;
    }

    public SimulationParameter getParameterValue(String name) {
        return parameters.get(name);
    }

    public abstract SimulationResults executeStrategy(BarSeries series);
}
