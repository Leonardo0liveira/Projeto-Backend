package com.projeto.cptm.cptm.repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.projeto.cptm.cptm.Estatisticas;

public interface EstatisticasRepository extends MongoRepository<Estatisticas, String> {
}
