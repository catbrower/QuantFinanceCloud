package com.brower.quantfinance.data;

import org.ta4j.core.BarSeries;
import org.ta4j.core.BaseBarSeriesBuilder;

import java.util.List;

public class PolygonBarSeries {
    private String ticker;
    private int queryCount;
    private int resultsCount;
    private boolean adjusted;

    private List<PolygonBar> results;

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public boolean isAdjusted() {
        return adjusted;
    }

    public void setAdjusted(boolean adjusted) {
        this.adjusted = adjusted;
    }

    public List<PolygonBar> getResults() {
        return results;
    }

    public void setResults(List<PolygonBar> results) {
        this.results = results;
    }

    public int getQueryCount() {
        return queryCount;
    }

    public void setQueryCount(int queryCount) {
        this.queryCount = queryCount;
    }

    public int getResultsCount() {
        return resultsCount;
    }

    public void setResultsCount(int resultsCount) {
        this.resultsCount = resultsCount;
    }

    public BarSeries toBarSeries() {
        BarSeries series = new BaseBarSeriesBuilder().withName("").build();
        for (PolygonBar polygonBar : results) {
            series.addBar(polygonBar.toBar());
        }

        return series;
    }
}
