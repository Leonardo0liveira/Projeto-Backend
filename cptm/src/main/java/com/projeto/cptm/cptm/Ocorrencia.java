package com.projeto.cptm.cptm;

import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "tipo", "descricao", "inicio", "fim"})
@Document(collection = "ocorrencia")
public class Ocorrencia {
    @Id
    private String id;
    private String tipo;
    private String descricao;
    private LocalDateTime inicio;
    private LocalDateTime fim;
    private String line;
    private String train;

    public Ocorrencia() {
    }

    public Ocorrencia(String id, String tipo, String descricao, LocalDateTime inicio, LocalDateTime fim, String line, String train) {
        this.id = id;
        this.tipo = tipo;
        this.descricao = descricao;
        this.inicio = inicio;
        this.fim = fim;
        this.line = line;
        this.train = train;
    }

    @JsonGetter("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonGetter("tipo")
    public String getTipo() {
        return tipo;
    }

    @JsonProperty("tipo")
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @JsonGetter("descricao")
    public String getDescricao() {
        return descricao;
    }

    @JsonProperty("descricao")
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @JsonGetter("inicio")
    public LocalDateTime getInicio() {
        return inicio;
    }

    @JsonProperty("inicio")
    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    @JsonGetter("fim")
    public LocalDateTime getFim() {
        return fim;
    }

    @JsonProperty("fim")
    public void setFim(LocalDateTime fim) {
        this.fim = fim;
    }

    public String getLine(){
        return line;
    }

    public void setLine(String line){
        this.line = line;
    }

    public String getTrain(){
        return train;
    }
    
    public void setTrain(String train){
        this.train = train;
    }
}