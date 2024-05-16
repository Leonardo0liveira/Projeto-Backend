package com.projeto.cptm.cptm;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

//import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
//import com.fasterxml.jackson.annotation.JsonSetter;


@JsonPropertyOrder({"id", "tipo", "descricao", "incio", "fim"})
@Document(collection = "ocorrencia")
public class Ocorrencia {
	@SuppressWarnings("unused")
	private String id;
	private String tipo;
	private String descricao;
	private LocalDateTime inicio;
    private LocalDateTime fim;

	
	public Ocorrencia(String id, String tipo, String descricao, LocalDateTime inicio, LocalDateTime fim){
		this.id = id;
		this.tipo = tipo;
		this.descricao = descricao;
		this.inicio = inicio;
		this.fim = fim;
	}

	//getters e setters
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

	@JsonProperty("inicio")
	public void setInicio(LocalDateTime inicio){
		this.inicio = inicio ;
	}
	
	@JsonProperty("inicio")
	public LocalDateTime getInicio(LocalDateTime inicio){
		return inicio;
	}
	
	@JsonProperty("fim")
	public void setFim(LocalDateTime fim){
		this.fim = fim ;
	}
	
	@JsonProperty("fim")
	public LocalDateTime getFim(LocalDateTime fim){
		return fim;
	}
}
