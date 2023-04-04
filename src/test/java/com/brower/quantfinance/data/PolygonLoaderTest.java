package com.brower.quantfinance.data;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.ta4j.core.BarSeries;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = {"classpath:secrets.properties", "classpath:application.properties"})
@SpringBootTest
class PolygonLoaderTest {
    @Autowired
    PolygonLoader polygonLoader;

    @Test
    public void testGetMinuteDate() {
        BarSeries barSeries = polygonLoader.getMinuteData("SPY", LocalDate.now().minusDays(1), LocalDate.now());

    }
}