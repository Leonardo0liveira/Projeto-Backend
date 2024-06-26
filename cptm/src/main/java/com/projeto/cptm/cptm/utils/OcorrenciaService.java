package com.projeto.cptm.cptm.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.math3.stat.correlation.PearsonsCorrelation;

import com.projeto.cptm.cptm.Estatisticas;
import com.projeto.cptm.cptm.Ocorrencia;
import com.projeto.cptm.cptm.repositorios.EstatisticasRepository;
import com.projeto.cptm.cptm.repositorios.OcorrenciaRepository;
import java.time.LocalDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.logging.Logger;

@Service
public class OcorrenciaService {

    @Autowired
    private OcorrenciaRepository ocorrenciaRepository;

    @Autowired
    private EstatisticasRepository estatisticasRepository;

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

    public LongSummaryStatistics calculateAverageDuration() {
        Logger logger = Logger.getLogger(OcorrenciaService.class.getName());
        
        // Obtém todas as ocorrências do repositório
        List<Ocorrencia> ocorrencias = ocorrenciaRepository.findAll();
    
        // Filtra as ocorrências que têm valores válidos para inicio e fim,
        // e calcula a duração em minutos entre inicio e fim
        List<Long> durations = ocorrencias.stream()
            .filter(o -> {
                boolean isValid = o.getInicio() != null && o.getFim() != null;
                if (!isValid) {
                    logger.warning("Ocorrência com datas inválidas: " + o.getId());
                }
                return isValid;
            })
            .map(o -> {
                LocalDateTime inicio = o.getInicio();
                LocalDateTime fim = o.getFim();
                long duration = java.time.Duration.between(inicio, fim).toMinutes();
                logger.info("Ocorrência " + o.getId() + ": início " + inicio + ", fim " + fim + ", duração " + duration + " minutos");
                return duration;
            })
            .filter(duration -> duration > 0 && duration < 1440) // 1440 minutos = 1 dia
            .collect(Collectors.toList());
    
        // Coleta as estatísticas resumidas das durações
        LongSummaryStatistics stats = durations.stream()
            .collect(Collectors.summarizingLong(Long::longValue));
    
        // Log das estatísticas
        logger.info("Duração média: " + stats.getAverage());
        logger.info("Duração total: " + stats.getSum());
        logger.info("Número de ocorrências: " + stats.getCount());
    
        return stats;
    }

    public double calculateCorrelationLineTrain() {
        List<Ocorrencia> ocorrencias = ocorrenciaRepository.findAll();
        Map<String, Integer> lineMapping = createMapping(ocorrencias.stream().map(Ocorrencia::getLine).collect(Collectors.toList()));
        Map<String, Integer> trainMapping = createMapping(ocorrencias.stream().map(Ocorrencia::getTrain).collect(Collectors.toList()));

        double[] lines = ocorrencias.stream().mapToDouble(o -> lineMapping.get(o.getLine())).toArray();
        double[] trains = ocorrencias.stream().mapToDouble(o -> trainMapping.get(o.getTrain())).toArray();

        PearsonsCorrelation pearsonsCorrelation = new PearsonsCorrelation();
        return pearsonsCorrelation.correlation(lines, trains);
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

    public Estatisticas calculateAndSaveEstatisticas() {
        LongSummaryStatistics stats = calculateAverageDuration();
        double correlation = calculateCorrelationLineTrain();

        Estatisticas estatisticas = new Estatisticas();
        estatisticas.setMediaDuracao(stats.getAverage());
        estatisticas.setTotalDuracao(stats.getSum());
        estatisticas.setNumeroOcorrencias(stats.getCount());
        estatisticas.setCorrelacaoLineTrain(correlation);

        return estatisticasRepository.save(estatisticas);
    }
}
