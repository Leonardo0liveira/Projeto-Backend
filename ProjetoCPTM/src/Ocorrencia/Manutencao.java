package Ocorrencia;

import java.time.LocalDateTime;

public class Manutencao extends Ocorrencia{
    private String manutencaoId, cnpjEmpresa;
    private LocalDateTime prevInicio, prevFim;
    private int qntManutencao;

    public Manutencao(boolean ocorre, String manutencaoId, String cnpjEmpresa, LocalDateTime inicio, LocalDateTime fim ){
        super(ocorre, inicio, fim);
        this.manutencaoId=manutencaoId;
        this.cnpjEmpresa=cnpjEmpresa;
    }

    //Como garantir que esteja contabilizando ocorrencia de manutenção e não ocorrencia no geral - polimorfismo?
    // Transformar em operador ternario
    @Override
    public void existeOcorrencia(){
        if(isOcorre()){
            System.out.println("Registro de ocorrência de manutenção");
            qntManutencao++;
        }
    }
    //colocar metodo abstrata solucao

    
    //Getters e Setters
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

    public int getQntManutencao() {
        return qntManutencao;
    }

    public void setQntManutencao(int qntManutencao) {
        this.qntManutencao = qntManutencao;
    }

}