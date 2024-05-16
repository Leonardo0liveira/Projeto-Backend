package com.projeto.cptm.cptm.repositorios;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.projeto.cptm.cptm.Categorias;

public interface CategoriasRepositorio extends MongoRepository<Categorias, String>{
    public List<Categorias> findByTipo(String tipo);
    public List<Categorias> findByDescricao(String descricao);
    public List<Categorias> findByTipoAndDescricao(String tipo, String descricao);
    public List<Categorias> findByTipoOrDescricao(String tipo, String descricao);
}
