import java.util.LinkedList;
import java.time.*;

public class Atividade{
    private String descricao;           //ok
    private LocalDateTime dhInicioAtv;  //ok
    private LocalDateTime dhFimAtv;     //ok
    private Usuario responsavel;        //ok
    private LinkedList<Usuario> profissionaisEnvolv = new LinkedList<Usuario>();    //ok
    private LinkedList<Tarefa> tarefas = new LinkedList<Tarefa>();                  //ok

    //Construtor
    public Atividade(String descricao, Usuario responsavel, LocalDateTime dHIni, LocalDateTime dHFim){
        this.descricao = descricao;
        this.dhInicioAtv = dHIni;
        this.dhFimAtv = dHFim;
        this.responsavel = responsavel;
    }

//  {--------------Inserções--------------------
    public void addProfissional(Usuario usuario){
        this.profissionaisEnvolv.add(usuario);
    }

    public void addTarefa(Tarefa tarefa){
        this.tarefas.add(tarefa);
    }
//  --------------Inserções--------------------}

//  {--------------Remoções---------------------
    public void removeProfissional(Usuario usuario){
        this.profissionaisEnvolv.remove(usuario);
    }

    public void removerTarefa(Tarefa tarefa){
        this.tarefas.remove(tarefa);
    }
//  ---------------Remoções--------------------}

//  {---------------Edições---------------------
    public void editarProfissional(Usuario atual, Usuario proximo){
        this.profissionaisEnvolv.remove(atual);
        this.profissionaisEnvolv.add(proximo);
    }

    public void editarTarefa(Tarefa atual, Tarefa proxima){
        this.tarefas.remove(atual);
        this.tarefas.add(proxima);
    }

    public void editarDescricao(String descricao){
        this.descricao.replace(this.descricao, descricao);
    }

    public void editarResponsavel(Usuario novoResponsavel){
        this.responsavel = novoResponsavel;
    }

    public void editarDataInicio(LocalDateTime novaDataInicio){
        LocalDateTime agora = LocalDateTime.now();
        if(this.dhInicioAtv.isAfter(agora)){
            this.dhInicioAtv = novaDataInicio;
        }
    }

    public void editarDataFim(LocalDateTime novaDataFim){
        LocalDateTime agora = LocalDateTime.now();
        if(novaDataFim.isAfter(agora)){
            this.dhFimAtv = novaDataFim;
        }
    }
//  ----------------Edições--------------------}

//  {---------------Getters---------------------

    public String getDescricao(){
        return descricao;
    }

    public LocalDateTime getDataInicio(){
        return dhInicioAtv;
    }

    public LocalDateTime getDataFim(){
        return dhFimAtv;
    }

    public Usuario getResponsavel(){
        return responsavel;
    }
//  ----------------Getters--------------------}

}