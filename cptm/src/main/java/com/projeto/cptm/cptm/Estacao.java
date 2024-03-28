package com.projeto.cptm.cptm;
//sugestão
import java.util.List;
import java.util.ArrayList;

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
}
