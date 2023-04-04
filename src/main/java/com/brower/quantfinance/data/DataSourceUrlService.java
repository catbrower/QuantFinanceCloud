package com.brower.quantfinance.data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class DataSourceUrlService {
    public static final String POLYGON_TIMESPAN_MINUTE = "minute";
    public static final String POLYGON_TIMESPAN_HOUR = "hour";
    public static final String POLYGON_TIMESPAN_DAY = "day";
    public static final String POLYGON_TIMESPAN_WEEK = "week";
    public static final String POLYGON_TIMESPAN_MONTH = "month";
    public static final String POLYGON_TIMESPAN_QUARTER = "quarter";
    public static final String POLYGON_TIMESPAN_YEAR = "year";

    public static final String POLYGON_SORT_ASCENDING = "asc";
    public static final String POLYGON_SORT_DESCENDING = "desc";

    public static final int POLYGON_LIMIT_MAX = 50000;

    @Value("${dataserver.url.base}")
    private String baseUrl;

    @Value("${secret.polygon}")
    private String polygonApiKey;

    public String getAggregatesUrl(String ticker, String timespan, LocalDate dateFrom, LocalDate dateTo) {
        return getAggregatesUrl(ticker, 1, timespan, dateFrom, dateTo, true, POLYGON_SORT_ASCENDING, POLYGON_LIMIT_MAX);
    }

    public String getAggregatesUrl(String ticker, int multiplier, String timespan, LocalDate dateFrom, LocalDate dateTo, boolean adjusted, String sort, int limit) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(baseUrl)
                .append("/aggs/ticker/")
                .append(ticker)
                .append("/range/")
                .append(multiplier)
                .append("/")
                .append(timespan)
                .append("/")
                .append(dateFrom.toString())
                .append("/")
                .append(dateTo.toString())
                .append("?adjusted=")
                .append(adjusted)
                .append("&sort=")
                .append(sort)
                .append("&limit=")
                .append(limit)
                .append("&apiKey=")
                .append(polygonApiKey);

        return stringBuilder.toString();
    }
}
