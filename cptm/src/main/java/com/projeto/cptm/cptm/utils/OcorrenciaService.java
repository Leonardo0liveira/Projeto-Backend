package com.projeto.cptm.cptm.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.cptm.cptm.Ocorrencia;
import com.projeto.cptm.cptm.repositorios.OcorrenciaRepository;

import org.apache.commons.math3.stat.correlation.PearsonsCorrelation;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.HashMap;



@Service
public class OcorrenciaService {

    @Autowired
    private OcorrenciaRepository ocorrenciaRepository;

    public List<Ocorrencia> findAll() {
        return ocorrenciaRepository.findAll();
    }

    public Ocorrencia findById(String id) {
        return ocorrenciaRepository.findById(id).orElse(null);
    }

    public Ocorrencia save(Ocorrencia ocorrencia) {
        return ocorrenciaRepository.save(ocorrencia);
    }

    public void deleteById(String id) {
        ocorrenciaRepository.deleteById(id);
    }

    public List<Ocorrencia> findByTipo(String tipo) {
        return ocorrenciaRepository.findByTipo(tipo);
    }

    private Map<String, Integer> createMapping(List<String> categories) {
        Map<String, Integer> mapping = new HashMap<>();
        int index = 0;
        for (String category : categories) {
            if (!mapping.containsKey(category)) {
                mapping.put(category, index++);
            }
        }
        return mapping;
    }

    public DoubleSummaryStatistics calculateAverageDuration() {
        List<Ocorrencia> ocorrencias = ocorrenciaRepository.findAll();
        // Supondo que você está calculando estatísticas com base na duração das ocorrências
        List<Long> durations = ocorrencias.stream()
            .filter(o -> o.getInicio() != null && o.getFim() != null)
            .map(o -> java.time.Duration.between(o.getInicio(), o.getFim()).toMinutes())
            .collect(Collectors.toList());

        return durations.stream()
            .collect(Collectors.summarizingDouble(Long::doubleValue));
    }

    public double calculateCorrelationTremLinha() {
        List<Ocorrencia> ocorrencias = ocorrenciaRepository.findAll();
        Map<String, Integer> lineMapping = createMapping(ocorrencias.stream().map(Ocorrencia::getLine).collect(Collectors.toList()));
        Map<String, Integer> trainMapping = createMapping(ocorrencias.stream().map(Ocorrencia::getTrain).collect(Collectors.toList()));

        double[] lines = ocorrencias.stream().mapToDouble(o -> lineMapping.get(o.getLine())).toArray();
        double[] trains = ocorrencias.stream().mapToDouble(o -> trainMapping.get(o.getTrain())).toArray();

        PearsonsCorrelation pearsonsCorrelation = new PearsonsCorrelation();
        return pearsonsCorrelation.correlation(lines, trains);
    }

    public double calculateCorrelationTimeTremLinha() {
        List<Ocorrencia> ocorrencias = ocorrenciaRepository.findAll();
        Map<Long, Integer> timeMapping = createMappingTime(ocorrencias.stream().map(Ocorrencia::getInicio).collect(Collectors.toList()));
        Map<String, Integer> lineMapping = createMappingLine(ocorrencias.stream().map(Ocorrencia::getLine).collect(Collectors.toList()));

        double[] times = ocorrencias.stream().mapToDouble(o -> timeMapping.get(o.getInicio())).toArray();
        double[] lines = ocorrencias.stream().mapToDouble(o -> lineMapping.get(o.getLine())).toArray();

        PearsonsCorrelation pearsonsCorrelation = new PearsonsCorrelation();
        return pearsonsCorrelation.correlation(times, lines);
    }
    
}