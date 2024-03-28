package com.projeto.cptm.cptm;

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
	
	//getters e setters
}
