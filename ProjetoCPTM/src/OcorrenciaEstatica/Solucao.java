package OcorrenciaEstatica;

public interface Solucao {
    void evacuacao();
    void chamaEquipe();
    void servicoMedico();
    default void medidaDisciplinar(){
        System.out.println("Medida disciplinar aplicada");
    }
    void infoPassageiro();
    void existeOcorrencia();
    void qntOcorrencia();

}
