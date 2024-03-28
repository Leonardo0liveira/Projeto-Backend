package mapa;
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

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public List<Ocorrencia> getOcorrencias() {
		return ocorrencias;
	}

	public void setOcorrencias(List<Ocorrencia> ocorrencias) {
		this.ocorrencias = ocorrencias;
	}
	
}
