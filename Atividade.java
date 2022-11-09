import java.util.LinkedList;
import java.time.*;
import java.util.UUID;

public class Atividade{
    private UUID id;
    private String descricao;           //ok
    private LocalDate dhInicioAtv;  //ok
    private LocalDate dhFimAtv;     //ok
    private Usuario responsavel;        //ok
    private LinkedList<Usuario> profissionaisEnvolv = new LinkedList<Usuario>();    //ok
    private LinkedList<Tarefa> tarefas = new LinkedList<Tarefa>();                  //ok
    private LinkedList<Usuario> requisitantes = new LinkedList<Usuario>();

    public void relatorio(){
        System.out.println("\tAtividade " + id.toString());
        System.out.println("\t\tResponsavel: " + responsavel.getNome());
        System.out.println("\t\tDescricao: " + descricao);
        System.out.println("\t\tData de inicio: " + dhInicioAtv.toString());
        System.out.println("\t\tData de termino: " + dhFimAtv.toString());
        System.out.println("\t\ttProfissionais envolvidos:");
        for (Usuario profissional : profissionaisEnvolv) {
            System.out.printf("\t");
            profissional.printar();
        }
        System.out.println("\t\tTarefas:");
        for (Tarefa tarefa : tarefas){
            tarefa.printar();
        }
        System.out.println("\t\tAlunos requisitando entrada na tarefa:");
        for (Usuario aluno : requisitantes){
            System.out.printf("\t");
            aluno.printar();
        }
        System.out.println("\n-------------------------------------------------------------------------\n");
    }

    //Construtor
    public Atividade(String descricao, Usuario responsavel, LocalDate dHIni, LocalDate dHFim){
        this.id = UUID.randomUUID();
        this.descricao = descricao;
        this.dhInicioAtv = dHIni;
        this.dhFimAtv = dHFim;
        this.responsavel = responsavel;
    }

//  {-----------------------------------Inserções-------------------------------------
    public void addProfissional(Usuario usuario){
        this.profissionaisEnvolv.add(usuario);
    }

    public void addTarefa(Tarefa tarefa){
        this.tarefas.add(tarefa);
    }

    public void addRequisitante(Usuario usuario){
        this.requisitantes.add(usuario);
    }
//  ------------------------------------Inserções------------------------------------}

//  {------------------------------------Remoções-------------------------------------
    public void removeProfissional(Usuario usuario){
        this.profissionaisEnvolv.remove(usuario);
    }

    public void removerTarefa(Tarefa tarefa){
        this.tarefas.remove(tarefa);
    }
//  -------------------------------------Remoções------------------------------------}

//  {------------------------------------Edições--------------------------------------
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

    public void editarDataInicio(LocalDate novaDataInicio){
        LocalDate agora = LocalDate.now();
        if(this.dhInicioAtv.isAfter(agora)){
            this.dhInicioAtv = novaDataInicio;
        }
    }

    public void editarDataFim(LocalDate novaDataFim){
        LocalDate agora = LocalDate.now();
        if(novaDataFim.isAfter(agora)){
            this.dhFimAtv = novaDataFim;
        }
    }
//  -------------------------------------Edições-------------------------------------}

//  {------------------------------------Getters--------------------------------------
    public UUID getId(){ return id; }

    public String getDescricao(){ return descricao; }

    public LocalDate getDataInicio(){ return dhInicioAtv; }

    public LocalDate getDataFim(){ return dhFimAtv; }

    public Usuario getResponsavel(){ return responsavel; }

    public LinkedList<Usuario> getProfissionais(){ return profissionaisEnvolv; }

    public LinkedList<Tarefa> getTarefas(){ return tarefas; }

    public LinkedList<Usuario> getRequisitantes(){ return requisitantes; }
//  -----------------------------------Getters----------------------------------}

}