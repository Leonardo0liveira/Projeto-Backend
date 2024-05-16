package com.projeto.cptm.cptm;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Document(collection = "categorias")
@JsonPropertyOrder({"id", "tipo", "descricao"})
@Document(collection = "categorias")
public class Categorias {
	private String id;
	private String tipo;
	private String descricao;
	
	public Categorias(String id, String tipo, String descricao){
		this.id = id;
		this.tipo = tipo;
		this.descricao = descricao;
	}

	//getters e setters
<<<<<<< HEAD
=======
	
>>>>>>> 97cf9e7a1736fd577e0dc99b6642766502f91a2d
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
	
}
