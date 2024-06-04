package com.projeto.cptm.cptm.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projeto.cptm.cptm.Ocorrencia;
import com.projeto.cptm.cptm.repositorios.OcorrenciaRepository;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

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

    public DoubleSummaryStatistics calculateStatistics() {
        List<Ocorrencia> ocorrencias = ocorrenciaRepository.findAll();
        // Supondo que você está calculando estatísticas com base na duração das ocorrências
        List<Long> durations = ocorrencias.stream()
            .filter(o -> o.getInicio() != null && o.getFim() != null)
            .map(o -> java.time.Duration.between(o.getInicio(), o.getFim()).toMinutes())
            .collect(Collectors.toList());

        return durations.stream()
            .collect(Collectors.summarizingDouble(Long::doubleValue));
    }

    public OcorrenciaEstatistica calculateExtendedStatistics() {
        List<Ocorrencia> ocorrencias = ocorrenciaRepository.findAll();
        return OcorrenciaEstatistica.calculate(ocorrencias);
    }
}
