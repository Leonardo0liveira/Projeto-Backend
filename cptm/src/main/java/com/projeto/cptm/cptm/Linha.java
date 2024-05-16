package com.projeto.cptm.cptm;
//sugestão
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;

@Document(collection = "linhas")
@JsonPropertyOrder({"id", "nome", "estacoes"})
public class Linha extends Ocorrencia{
	private String id;
	private String nome;
	private List<Estacao> estacoes;
	
	public Linha(String id, String nome){
		this.id = id;
		this.nome = nome;
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
	@JsonGetter("estacoes")
	public List<Estacao> getEstacoes() {
		return estacoes;
	}
	@JsonProperty("estacoes")
	public void setEstacoes(List<Estacao> estacoes) {
		this.estacoes = estacoes;
	}
	
}
