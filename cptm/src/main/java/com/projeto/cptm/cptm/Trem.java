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

import java.util.ArrayList;

@Document(collection = "trens")
@JsonPropertyOrder({"id", "nome", "capacidade", "estacoes"})
@Document(collection = "trens")
public class Trem {
	@Id
	private String id;
	private String nome;
	private int capacidade;
	private List<Estacao> estacoes;
	
	public Trem(String id,String nome,int capacidade){
		this.id = id;
		this.nome = nome;
		this.capacidade = capacidade;
		this.estacoes = new ArrayList<>();
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
