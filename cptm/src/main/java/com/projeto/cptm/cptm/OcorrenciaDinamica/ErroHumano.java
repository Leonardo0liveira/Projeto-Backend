package com.projeto.cptm.cptm.OcorrenciaDinamica;

import com.projeto.cptm.cptm.OcorrenciaEstatica.Ocorrencia;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class ErroHumano{
    private String erroHumanoId;
    private static int qntErroHumano = 0;
    private boolean operador;
    private boolean maquinista;
    private boolean passageiro;
    private boolean ocorre;
    private LocalDateTime inicio, fim;
    private static List<ErroHumano> listaErroHumano = new ArrayList<>();
    private ErroHumano erroHumano;

    public ErroHumano(boolean ocorre, String erroHumanoId, LocalDateTime inicio, LocalDateTime fim){
        this.ocorre = ocorre;
        this.erroHumanoId = erroHumanoId;
        this.inicio = inicio;
        this.fim = fim;
    }
    
    // Métodos Ativos
    public void qntErroHumano(){
        qntErroHumano++;
    }
    
    @Override
    public void existeOcorrencia(){
        if(super.isOcorre()){
            System.out.println("Registro de ocorrência de Erro humano");
        }
    }
    //Rever necessidade desse metodo estar aqui ou em outro local
    public static List<ErroHumano> getListaErroHumano(){
        return listaErroHumano;
    }

    // Métodos inativos
    public void evacuacao(){
    }
    public void chamaEquipe(){
    }
    public void medidaDisciplinar(){
    }
    public void infoPassageiro(){
    }

    public void insertErroHumano(){
        listaErroHumano.add(erroHumano);
    }

    
    //Getters e Setters 
    
}
