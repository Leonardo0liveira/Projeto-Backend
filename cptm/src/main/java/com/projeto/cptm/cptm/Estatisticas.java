package com.projeto.cptm.cptm;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "estatisticas")
public class Estatisticas {
    @Id
    private String id;
    private double mediaDuracao;
    private double totalDuracao;
    private long numeroOcorrencias;
    private double correlacaoLineTrain;

    // Getters e Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getMediaDuracao() {
        return mediaDuracao;
    }

    public void setMediaDuracao(double mediaDuracao) {
        this.mediaDuracao = mediaDuracao;
    }

    public double getTotalDuracao() {
        return totalDuracao;
    }

    public void setTotalDuracao(double totalDuracao) {
        this.totalDuracao = totalDuracao;
    }

    public long getNumeroOcorrencias() {
        return numeroOcorrencias;
    }

    public void setNumeroOcorrencias(long numeroOcorrencias) {
        this.numeroOcorrencias = numeroOcorrencias;
    }

    public double getCorrelacaoLineTrain() {
        return correlacaoLineTrain;
    }

    public void setCorrelacaoLineTrain(double correlacaoLineTrain) {
        this.correlacaoLineTrain = correlacaoLineTrain;
    }
}
