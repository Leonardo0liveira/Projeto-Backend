package Ocorrencia;
import java.time.LocalDateTime;

public class EventoExterno extends Ocorrencia{
    public boolean pessoaPista;
    public boolean greve;
    public boolean alagamento;
    public boolean quedaEnergia;


    public EventoExterno(boolean ocorre, LocalDateTime inicio, LocalDateTime fim, boolean pessoaPista, boolean greve, boolean alagamento, boolean quedaEnergia){
        super(ocorre, inicio, fim);
        this.pessoaPista=pessoaPista;
        this.greve=greve;
        this.alagamento=alagamento;
        this.quedaEnergia=quedaEnergia;
    }

    @Override
    public void existeOcorrencia(){
        if(super.isOcorre()){
            System.out.println("Registro de Ocorrência de");
        }
    }

    //Comparar com o de Erro Humano
    public void solucao(){
        if(pessoaPista){
            System.out.println("pessoa na pista");
            chamaEquipe();
           } else if(greve){
                infoPassageiro();
                }
                else if(alagamento){
                    infoPassageiro();
                    } else if (quedaEnergia){
                        evacuacao();
                        infoPassageiro();
                    }
    }
}
