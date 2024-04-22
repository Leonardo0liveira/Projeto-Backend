package Ocorrencia;
import java.time.LocalDateTime;

public class ErroHumano extends Ocorrencia{
    private String erroHumanoId, tipoErroHumano;
    private int qntErroHumano = 0, qntErroOperador = 0, qntErroPassageiro = 0, qntErroMaquinista = 0;

    //Contrutor 
    public ErroHumano(boolean ocorre,String erroHumanoId, LocalDateTime inicio, LocalDateTime fim, String tipoErroHumano){
        super(ocorre, inicio, fim);
        this.erroHumanoId=erroHumanoId;
        this.tipoErroHumano=tipoErroHumano;
    }
    @Override
    public void existeOcorrencia(){
        if(super.isOcorre()){
            System.out.println("Registro de ocorrencia de Erro humano");
            qntErroHumano++;
        }
    }
}

    //Comparar com Evento Externo
/*public void solucao(){
    switch (tipoErroHumano) {
        case "operador":
            @Override
        public void medidaDisciplinar(){
                System.out.println("Operador:");
                super.medidaDisciplinar;
                qntErroOperador++;
            }
            break;
        case "maquinista":
        @Override 
        public void medidaDisciplinar(){  
            System.out.println("Maquinista:");
            super.medidaDisciplinar;
            qntErroMaquinista++;
        }

            break;
        case "passageiro":
        @Override
        public void medidaDisciplinar(){
            System.out.println("Passageiro: ");
            super.medidaDisciplinar;
            qntErroPassageiro++;
        }
            break;
        default:
            System.out.println("A ocorrencia é de outro tipo \n Retorne ao menu \n");
            break;
    } */


// Getters e Setters

