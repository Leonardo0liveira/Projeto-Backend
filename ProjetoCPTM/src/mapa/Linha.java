package mapa;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Estacao> getEstacoes() {
		return estacoes;
	}

	public void setEstacoes(List<Estacao> estacoes) {
		this.estacoes = estacoes;
	}
	
}
