package P2;
import java.util.LinkedList;
import java.time.*;
//import java.util.Date;
//import javafx.util.*;

public class Atividade{
    int id;
    private String descricao;           //ok
    private LocalDateTime dhInicioAtv;  //ok
    private LocalDateTime dhFimAtv;     //ok
    private Usuario responsavel;        //ok
    private LinkedList<Usuario> profissionaisEnvolv = new LinkedList<Usuario>();    //ok
    private LinkedList<Tarefa> tarefas = new LinkedList<Tarefa>();                  //ok

    public Atividade(String descricao, Usuario responsavel, LocalDateTime dHIni, LocalDateTime dHFim){
        this.descricao = descricao;
        this.dhInicioAtv = dHIni;
        this.dhFimAtv = dHFim;
        this.responsavel = responsavel;
    }

    public void addProfissional(Usuario usuario){
        this.profissionaisEnvolv.add(usuario);
    }

    public void addTarefa(Tarefa tarefa){
        this.tarefas.add(tarefa);
    }
}