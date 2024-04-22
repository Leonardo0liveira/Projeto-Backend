package Ocorrencia;
import java.time.LocalDateTime;

//Colocar condição de inicio(tempo) = valor minimo 

public abstract class Ocorrencia{
    private LocalDateTime inicio;
    private LocalDateTime fim;
    private boolean ocorre;

    public Ocorrencia(boolean ocorre, LocalDateTime inicio, LocalDateTime fim){
        this.ocorre=ocorre; 
        this.inicio=inicio;
        this.fim=fim;
    }
    //Metodos Concretos
    public void evacuacao(){
        System.out.println("O local será evacuado");
    }
    public void chamaEquipe(){
        System.out.println("Equipe chamada para resolver a ocorrencia");
    }
    public void servicoMedico(){
        System.out.println("Informe o serviço médico");
    }
    public void medidaDisciplinar(){
        System.out.println("Medida disciplinar aplicada");
    }
    public void infoPassageiro(){ 
        System.out.println("Informe  a ocorrência aos passageiros");
    }
    
    //Metodos Abstratos
    public abstract void existeOcorrencia();


    //Getters e Setters
    public LocalDateTime getFim() {
        return fim;
    }
    public void setFim(LocalDateTime fim) {
        this.fim = fim;
    }
    public LocalDateTime getInicio() {
        return inicio;
    }
    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }
    public boolean isOcorre() {
        return ocorre;
    }
    public void setOcorre(boolean ocorre) {
        this.ocorre = ocorre;
        }
    }


