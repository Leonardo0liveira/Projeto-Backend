package com.projeto.cptm.cptm;
//sugestão
import java.util.List;
import java.util.ArrayList;

public class Trem {
	private String id;
	private String nome;
	private int capacidade;
	private List<Estacao> estacoes;
	
	public Trem(String id,String nome,int capacidade){
		this.id = id;
		this.nome = nome;
		this.capacidade = capacidade;
		this.estacoes = new ArrayList<>();
	}
	//getters e setters
}
