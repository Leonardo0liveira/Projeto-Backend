package OcorrenciaEstatica;
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
}

