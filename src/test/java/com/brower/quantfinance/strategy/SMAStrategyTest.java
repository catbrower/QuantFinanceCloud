package com.brower.quantfinance.strategy;

import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = {"classpath:secrets.properties", "classpath:application.properties"})
@SpringBootTest
class SMAStrategyTest {
        public void testSMAStrategySimulationRuns() {

            SMAStrategy strategy = new SMAStrategy();
        }
}