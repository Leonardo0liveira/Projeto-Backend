package com.projeto.cptm.cptm.repositorios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.projeto.cptm.cptm.Ocorrencia;
import com.projeto.cptm.cptm.utils.OcorrenciaService;

import java.util.DoubleSummaryStatistics;
import java.util.List;

@RestController
@RequestMapping("/ocorrencias")
public class OcorrenciaController {

    @Autowired
    private OcorrenciaService ocorrenciaService;

    @GetMapping
    public List<Ocorrencia> getAllOcorrencias() {
        return ocorrenciaService.findAll();
    }

    @GetMapping("/{id}")
    public Ocorrencia getOcorrenciaById(@PathVariable String id) {
        return ocorrenciaService.findById(id);
    }

    @PostMapping
    public Ocorrencia createOcorrencia(@RequestBody Ocorrencia ocorrencia) {
        return ocorrenciaService.save(ocorrencia);
    }

    @PutMapping("/{id}")
    public Ocorrencia updateOcorrencia(@PathVariable String id, @RequestBody Ocorrencia ocorrencia) {
        ocorrencia.setId(id);
        return ocorrenciaService.save(ocorrencia);
    }

    @DeleteMapping("/{id}")
    public void deleteOcorrencia(@PathVariable String id) {
        ocorrenciaService.deleteById(id);
    }

    @GetMapping("/tipo/{tipo}")
    public List<Ocorrencia> getOcorrenciasByTipo(@PathVariable String tipo) {
        return ocorrenciaService.findByTipo(tipo);
    }

    @GetMapping("/estatisticas")
    public DoubleSummaryStatistics getEstatisticas() {
        return ocorrenciaService.calculateAverageDuration();
    }

    @GetMapping("/correlation")
    public ResponseEntity<Double> getCorrelation() {
        double correlation = ocorrenciaService.calculateCorrelationTremLinha();
        return ResponseEntity.ok(correlation);
    }
}