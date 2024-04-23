package OcorrenciaEstatica;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Manutencao extends Ocorrencia{
    private String manutencaoId, cnpjEmpresa;
    private LocalDateTime prevInicio, prevFim;
    private static int qntManutencao=0;

    //Criar uma lista de Ocorrencia
    public Manutencao(boolean ocorre, String manutencaoId, String cnpjEmpresa, LocalDateTime inicio, LocalDateTime fim, LocalDateTime prevInicio, LocalDateTime prevFim){
        super(ocorre, inicio, fim);
        this.manutencaoId=manutencaoId;
        this.cnpjEmpresa=cnpjEmpresa;
        this.prevInicio=prevInicio;
        this.prevFim=prevFim;
    }

    //Metodos Ativos 
    public void qntOcorrencia(){
        qntManutencao++;
    }
    @Override
    public void existeOcorrencia(){
        if(isOcorre()){
            System.out.println("Registro de ocorrência de manutenção");
            qntOcorrencia();
        }
    }

    //Metodos inativos 
    public void evacucao(){
    }
    public void chamaEquipe(){
    }
    public void servicoMedico(){
    }
    public void infoPassageiro(){
    }


    //Metodos getters e setters
    public String getManutencaoId() {
        return manutencaoId;
    }
    public void setManutencaoId(String manutencaoId) {
        this.manutencaoId = manutencaoId;
    }
    public String getCnpjEmpresa() {
        return cnpjEmpresa;
    }
    public void setCnpjEmpresa(String cnpjEmpresa) {
        this.cnpjEmpresa = cnpjEmpresa;
    }
    public LocalDateTime getPrevInicio() {
        return prevInicio;
    }
    public void setPrevInicio(LocalDateTime prevInicio) {
        this.prevInicio = prevInicio;
    }
    public LocalDateTime getPrevFim() {
        return prevFim;
    }
    public void setPrevFim(LocalDateTime prevFim) {
        this.prevFim = prevFim;
    }
    
}