package com.projeto.cptm.cptm.OcorrenciaEstatica;

import java.time.LocalDateTime;

public class Manutencao extends Ocorrencia{
    private String manutencaoId, cnpjEmpresa;
    private LocalDateTime prevInicio, prevFim;
    private static int qntManutencao = 0;

    public Manutencao(boolean ocorre, String manutencaoId, String cnpjEmpresa, LocalDateTime inicio, LocalDateTime fim, LocalDateTime prevInicio, LocalDateTime prevFim) {
        super(ocorre, inicio, fim);
        this.manutencaoId = manutencaoId;
        this.cnpjEmpresa = cnpjEmpresa;
        this.prevInicio = prevInicio;
        this.prevFim = prevFim;
    }

    // Métodos Ativos 
    public void qntOcorrencia() {
        qntManutencao++;
    }

    @Override
    public void existeOcorrencia() {
        if (isOcorre()) {
            System.out.println("Registro de ocorrência de manutenção");
            qntOcorrencia();
        }
    }

    // Métodos inativos 
    @Override
    public void evacuacao() {
        
    }

    public void chamaEquipe() {
    }

    public void servicoMedico() {
    }

    public void infoPassageiro() {
    }

    // Getters e Setters
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

    public static int getQntManutencao() {
        return qntManutencao;
    }

    public static void setQntManutencao(int qntManutencao) {
        Manutencao.qntManutencao = qntManutencao;
    }
}
