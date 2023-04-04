package com.brower.quantfinance.data;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.client.RestTemplate;
import org.ta4j.core.BarSeries;

import java.time.LocalDate;

@Service
public class PolygonLoader {
    @Autowired
    DataSourceUrlService dataSourceUrlService;

    public BarSeries getMinuteData(String ticker, LocalDate from, LocalDate to) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        String uri = dataSourceUrlService.getAggregatesUrl("SPY", DataSourceUrlService.POLYGON_TIMESPAN_MINUTE, from, to);

        ResponseEntity<PolygonBarSeries> result = restTemplate.exchange(uri, HttpMethod.GET, entity, PolygonBarSeries.class);
        return result.getBody().toBarSeries();
    }
}
