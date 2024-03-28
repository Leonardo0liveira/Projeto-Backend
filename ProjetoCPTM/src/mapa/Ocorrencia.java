package mapa;

import java.util.List;
import java.util.ArrayList;

//sugestão
public class Ocorrencia {
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Estacao getEstacao() {
		return estacao;
	}

	public void setEstacao(Estacao estacao) {
		this.estacao = estacao;
	}

	public List<Categorias> getCategoria() {
		return categoria;
	}

	public void setCategoria(List<Categorias> categoria) {
		this.categoria = categoria;
	}
	
	//getters e setters
	

}
