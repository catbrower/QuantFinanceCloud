package com.brower.quantfinance.data;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = {"classpath:secrets.properties", "classpath:application.properties"})
@SpringBootTest
class DataSourceUrlServiceTest {
    @Autowired
    DataSourceUrlService dataSourceUrlService;

    @Test
    void getAggregatesUrl() {
        LocalDate dateTo = LocalDate.now();
        LocalDate dateFrom = dateTo.minusDays(1);

        String url = dataSourceUrlService.getAggregatesUrl("SPY", DataSourceUrlService.POLYGON_TIMESPAN_MINUTE, dateFrom, dateTo);
        System.out.println(url);
    }

    @Test
    void testGetAggregatesUrl() {
    }
}