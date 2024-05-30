package com.projeto.cptm.cptm.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongodb.lang.NonNull;
import com.projeto.cptm.cptm.Ocorrencia;


public interface OcorrenciaRepository extends MongoRepository<Ocorrencia, String>{
    public List<Ocorrencia> findByTipo(String tipo);
    public List<Ocorrencia> findByDescricao(String descricao);
    public List<Ocorrencia> findByTipoAndDescricao(String tipo, String descricao);
    public List<Ocorrencia> findByTipoOrDescricao(String tipo, String descricao);
    public @NonNull Optional<Ocorrencia> findById(String id);
}
