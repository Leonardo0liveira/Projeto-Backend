package OcorrenciaEstatica;
import java.time.LocalDateTime;


public abstract class Ocorrencia implements Solucao{
    private LocalDateTime inicio;
    private LocalDateTime fim;
    private boolean ocorre;

    public Ocorrencia(boolean ocorre, LocalDateTime inicio, LocalDateTime fim){
        this.ocorre=ocorre; 
        this.inicio=inicio;
        this.fim=fim;
    }

    //Colocar condição de inicio(tempo) = valor minimo 
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


