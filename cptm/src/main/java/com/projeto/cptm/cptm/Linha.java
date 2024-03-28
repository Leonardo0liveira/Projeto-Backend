package com.projeto.cptm.cptm;
//sugestão
import java.util.List;
import java.util.ArrayList;

public class Linha {
	private String id;
	private String nome;
	private List<Estacao> estacoes;
	
	public Linha(String id,String nome){
		this.id = id;
		this.nome = nome;
		this.estacoes = new ArrayList<>();
	}
	//getters e setters
}
