package com.projeto.cptm.cptm.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.cptm.cptm.Ocorrencia;
import com.projeto.cptm.cptm.repositorios.OcorrenciaRepository;

import java.util.List;

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
}