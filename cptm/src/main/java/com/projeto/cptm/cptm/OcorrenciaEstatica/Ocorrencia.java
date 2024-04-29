package com.projeto.cptm.cptm.OcorrenciaEstatica;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.projeto.cptm.cptm.Categorias;
import com.projeto.cptm.cptm.Estacao;


public class Ocorrencia {
    
    private String id;
	private String tipo;
	private String descricao;
	private Estacao estacao;
	private List<Categorias> categoria;
    private LocalDateTime inicio;
    private LocalDateTime fim;
    private boolean ocorre;
	
	public Ocorrencia(String id, String tipo, String descricao, Estacao estacao, boolean ocorre, LocalDateTime inicio, LocalDateTime fim){
		this.id = id;
		this.tipo = tipo;
		this.descricao = descricao;
		this.estacao = estacao;
        this.ocorre=ocorre; 
        this.inicio=inicio;
        this.fim=fim;
	}


    //Colocar condição de inicio(tempo) = valor minimo 
    public LocalDateTime getFim() {
        return fim;
    }
    public void setFim(LocalDateTime fim) {
        this.fim = fim;
    }
    public LocalDateTime getInicio() {
        return inicio;
    }
    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }
    public boolean isOcorre() {
        return ocorre;
    }
    public void setOcorre(boolean ocorre) {
        this.ocorre = ocorre;
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


