package com.brower.quantfinance.strategy;

import com.brower.quantfinance.simulation.SimulationIntegerParameter;
import com.brower.quantfinance.simulation.SimulationParameters;
import com.brower.quantfinance.simulation.SimulationParametersBuilder;
import com.brower.quantfinance.simulation.SimulationResults;
import org.ta4j.core.*;
import org.ta4j.core.indicators.SMAIndicator;
import org.ta4j.core.indicators.helpers.ClosePriceIndicator;
import org.ta4j.core.rules.CrossedDownIndicatorRule;
import org.ta4j.core.rules.CrossedUpIndicatorRule;

public class SMAStrategy extends Strategy {
    public static final String PARAM_SHORT_MA = "shortSMA";
    public static final String PARAM_LONG_MA = "longSMA";
    private SimulationParameters parameters;

    /**
     * Create an SMAStrategy with default parameters
     */
    public SMAStrategy() {
        parameters = new SimulationParametersBuilder()
                .addParameter(PARAM_SHORT_MA, new SimulationIntegerParameter(5))
                .addParameter(PARAM_LONG_MA, new SimulationIntegerParameter(15))
                .build();
    }

    @Override
    public SimulationResults executeStrategy(BarSeries series) {
        ClosePriceIndicator close = new ClosePriceIndicator(series);

        SMAIndicator shortSMA = new SMAIndicator(close, getParameterValue(PARAM_SHORT_MA).intValue());
        SMAIndicator longSMA = new SMAIndicator(close, getParameterValue(PARAM_LONG_MA).intValue());

        Rule buyingRule = new CrossedUpIndicatorRule(shortSMA, longSMA);
        Rule sellingRule = new CrossedDownIndicatorRule(shortSMA, longSMA);

        BarSeriesManager seriesManager = new BarSeriesManager(series);
        TradingRecord tradingRecord = seriesManager.run(new BaseStrategy(buyingRule, sellingRule));

        return calculateSimulationResults(series, tradingRecord);
    }
}
