package com.projeto.cptm.cptm;

import java.util.List;

//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;


//import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
//import com.fasterxml.jackson.annotation.JsonSetter;

//sugestão
@JsonPropertyOrder({"id", "tipo", "descricao", "estacao", "categoria"})
public class Ocorrencia {
	@SuppressWarnings("unused")
	private String id;
	private String tipo;
	private String descricao;
	private Estacao estacao;
	private List<Categorias> categoria;
	
	public Ocorrencia(String id, String tipo, String descricao,Estacao estacao){
		this.id = id;
		this.tipo = tipo;
		this.descricao = descricao;
		this.estacao = estacao;
	}

	//getters e setters
	@JsonGetter("id")
	public String getId(@RequestParam("id") String id) {
		return "ID: " + id;
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

	@JsonGetter("estacao")
	public Estacao getEstacao() {
		return estacao;
	}

	@JsonProperty("estacao")
	public void setEstacao(Estacao estacao) {
		this.estacao = estacao;
	}

	@JsonGetter("categoria")
	public List<Categorias> getCategoria() {
		return categoria;
	}

	@JsonProperty("categoria")
	public void setCategoria(List<Categorias> categoria) {
		this.categoria = categoria;
	}
	
	
	
}
