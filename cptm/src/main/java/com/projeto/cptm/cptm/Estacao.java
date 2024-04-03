package com.projeto.cptm.cptm;
//sugestão
import java.util.List;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;

@JsonPropertyOrder({"id", "nome", "localizacao", "ocorrencias"})
public class Estacao {
	private String id;
	private String nome;
	private String localizacao;
	private List<Ocorrencia> ocorrencias;
	
	public Estacao(String id,String nome,String localizacao){
		this.id = id;
		this.nome = nome;
		this.localizacao = localizacao;
		this.ocorrencias = new ArrayList<>();
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
	@JsonGetter("localizacao")
	public String getLocalizacao() {
		return localizacao;
	}
	@JsonProperty("localizacao")
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	@JsonGetter("ocorrencias")
	public List<Ocorrencia> getOcorrencias() {
		return ocorrencias;
	}
	@JsonProperty("ocorrencias")
	public void setOcorrencias(List<Ocorrencia> ocorrencias) {
		this.ocorrencias = ocorrencias;
	}
	
}
