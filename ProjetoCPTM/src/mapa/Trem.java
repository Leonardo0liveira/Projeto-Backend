package mapa;
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

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public List<Estacao> getEstacoes() {
		return estacoes;
	}

	public void setEstacoes(List<Estacao> estacoes) {
		this.estacoes = estacoes;
	}
	
}
