package com.projeto.cptm.cptm;

//sugestão
public class Categorias {
	private String id;
	private String tipo;
	private String descricao;
	
	public Categorias(String id, String tipo, String descricao){
		this.id = id;
		this.tipo = tipo;
		this.descricao = descricao;
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
	
	//getters e setters
	
}
