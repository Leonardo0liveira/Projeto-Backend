package com.projeto.cptm.cptm.utils;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OcorrenciaServiceTest {

    @Autowired
    private OcorrenciaService ocorrenciaService;

    @Test
    void calculateCorrelationTimeTremLinha() {
        double correlation = ocorrenciaService.calculateCorrelationTimeTremLinha();
        assertEquals(0.0, correlation, 0.0001); // Adjust the expected value as per your actual data
    }

    @Test
    void calculateAverageDuration() {
        double averageDuration = ocorrenciaService.calculateAverageDuration();
        assertEquals(0.0, averageDuration, 0.0001); // Adjust the expected value as per your actual data
    }
}

