package OcorrenciaDinamica;
import OcorrenciaEstatica.Ocorrencia;
import java.util.ArrayList;
import java.util.List;

public abstract class PessoaPista{
    private static int qntPessoaPista;
    private static List<PessoaPista> listaPessoaPista = new ArrayList<>();

    //Metodos Ativos 
    public void chamaEquipe(){
        if(pessoaPista){
            System.out.println("Equipe chamada para resolver a ocorrencia");
            qntOcorrePessoa();
            infoPassageiro();
        }
    }
    public void qntOcorrePessoa(){
        qntPessoaPista++;
    }
       public void infoPassageiro(){ 
        System.out.println("Informe  a ocorrência aos passageiros");
    } 
}
// Metodos Inativos

// Getters e Setters
