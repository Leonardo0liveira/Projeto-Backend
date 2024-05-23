package com.projeto.cptm.cptm;
//sugestão
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;

@JsonPropertyOrder({"id", "nome", "capacidade", "estacoes"})
public class Trem extends Ocorrencia{
	private String nome;
	private int capacidade;
	private List<Estacao> estacoes;
	
	public Trem(String id, String tipo, String descricao, LocalDateTime inicio, LocalDateTime fim, int capacidade, List<Estacao> estacoes){
		super(id, tipo, descricao, inicio, fim); // Explicitly invoke the constructor of the superclass Ocorrencia
		this.capacidade = capacidade;
		this.estacoes = new ArrayList<>();
	}
	//getters e setters
	@JsonGetter("nome")
	public String getNome() {
		return nome;
	}
	@JsonProperty("nome")
	public void setNome(String nome) {
		this.nome = nome;
	}
	@JsonGetter("capacidade")
	public int getCapacidade() {
		return capacidade;
	}
	@JsonProperty("capacidade")
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	@JsonGetter("estacoes")
	public List<Estacao> getEstacoes() {
		return estacoes;
	}
	@JsonProperty("estacoes")
	public void setEstacoes(List<Estacao> estacoes) {
		this.estacoes = estacoes;
	}
	

}
