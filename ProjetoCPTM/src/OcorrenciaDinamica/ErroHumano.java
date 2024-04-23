package OcorrenciaDinamica;

import OcorrenciaEstatica.Ocorrencia;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class ErroHumano{
    private String erroHumanoId;
    private static int qntErroHumano = 0;
    private boolean operador;
    private boolean maquinista;
    private boolean passageiro;
    private static List<ErroHumano> listaErroHumano = new ArrayList<>();

    public ErroHumano(boolean ocorre, String erroHumanoId, LocalDateTime inicio, LocalDateTime fim){
        super(ocorre, inicio, fim);
        this.erroHumanoId = erroHumanoId;
        this.listaErroHumano.add(this);
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

    
    //Getters e Setters 
    public boolean isOperador() {
        return operador;
    }

    public void setOperador(boolean operador) {
        this.operador = operador;
    }

    public boolean isMaquinista() {
        return maquinista;
    }

    public void setMaquinista(boolean maquinista) {
        this.maquinista = maquinista;
    }

    public boolean isPassageiro() {
        return passageiro;
    }

    public void setPassageiro(boolean passageiro) {
        this.passageiro = passageiro;
    }

    public String getErroHumanoId() {
        return erroHumanoId;
    }

    public void setErroHumanoId(String erroHumanoId) {
        this.erroHumanoId = erroHumanoId;
    }

    public static List<ErroHumano> getListaErroHumano() {
        return listaErroHumano;
    }

    public static void setListaErroHumano(List<ErroHumano> listaErroHumano) {
        ErroHumano.listaErroHumano = listaErroHumano;
    }
     
}
