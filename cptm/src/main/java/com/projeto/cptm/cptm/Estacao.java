package com.projeto.cptm.cptm;
//sugestão
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDateTime;
import java.util.ArrayList;
@Document(collection = "estacoes")
@JsonPropertyOrder({"id", "nome", "localizacao", "ocorrencias"})
public class Estacao extends Ocorrencia{
	private String nome;
	private String localizacao;
	private List<Ocorrencia> ocorrencias;
	
	public Estacao(String id, String tipo, String descricao, LocalDateTime inicio, LocalDateTime fim, String nome, String localizacao){
		super(id, tipo, descricao, inicio, fim);
		this.nome = nome;
		this.localizacao = localizacao;
		this.ocorrencias = new ArrayList<>();
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

	//metodos
	public void adicionarOcorrencia(Ocorrencia ocorrencia) {
		if (ocorrencia != null && !ocorrencias.contains(ocorrencia)) {
			ocorrencias.add(ocorrencia);
		}
	}

	public void removerOcorrencia(Ocorrencia ocorrencia) {
		ocorrencias.remove(ocorrencia);
	}

	public Ocorrencia buscarOcorrenciaPorId(String id) {
		for (Ocorrencia ocorrencia : ocorrencias) {
			if (ocorrencia.getId().equals(id)) {
				return ocorrencia;
			}
		}
		return null;
	}

	public List<Ocorrencia> listarOcorrencias() {
		return new ArrayList<>(ocorrencias);
	}

	public void atualizarOcorrencia(Ocorrencia ocorrenciaAtualizada) {
		for (int i = 0; i < ocorrencias.size(); i++) {
			if (ocorrencias.get(i).getId().equals(ocorrenciaAtualizada.getId())) {
				ocorrencias.set(i, ocorrenciaAtualizada);
				return;
			}
		}
	}
	
	
	
	
}
