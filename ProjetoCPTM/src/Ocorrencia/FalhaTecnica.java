package Ocorrencia;
import java.time.LocalDateTime;


public class FalhaTecnica extends Ocorrencia{
    private String falhaId, tipoFalha;
    private int qntFalha;
    
    public FalhaTecnica(boolean ocorre,String falhaId, String tipoFalha, LocalDateTime inicio, LocalDateTime fim){
        super(ocorre, inicio, fim);
        this.falhaId=falhaId;
        this.tipoFalha=tipoFalha;
    }

//Transfomar em operador ternario
@Override
public void existeOcorrencia(){
    if(super.isOcorre()){
        System.out.println("Registro de ocorrência de Falha Técnica do tipo" + tipoFalha);
    }
}


//Desenvolver após descobrir melhor caso - vai ter que desenvolver muito mais
public void chamaEquipe(){
    super.chamaEquipe();
}
public void infoPassageiro(){
    super.infoPassageiro();
}

public String getFalhaId() {
    return falhaId;
}


//Getters e Setters
public void setFalhaId(String falhaId) {
    this.falhaId = falhaId;
}

public String getTipoFalha() {
    return tipoFalha;
}

public void setTipoFalha(String tipoFalha) {
    this.tipoFalha = tipoFalha;
}
public int getQntFalha() {
    return qntFalha;
}
public void setQntFalha(int qntFalha) {
    this.qntFalha = qntFalha;
}

}