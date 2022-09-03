public class Tarefa{
    private String descricao;
    private Usuario responsavel;
    private boolean conclusao;

    //Construtor
    Tarefa(String descricao, Usuario responsavel){
        this.descricao = descricao;
        this.responsavel = responsavel;
        this.conclusao = false;
    }

    public boolean estaConcluido(){
        return this.conclusao;
    }

    public void concluir(){
        this.conclusao = true;
    }

//  {---------------Edições---------------------
    public void editarDescricao(String novaDescricao){
        this.descricao.replace(this.descricao, novaDescricao);
    }

    public void editarResponsavel(Usuario novoResponsavel){
        this.responsavel = novoResponsavel;
    }
//  ----------------Edições--------------------}

//  {---------------Getters---------------------
    public String getString(){
        return descricao;
    }

    public Usuario getResponsavel(){
        return responsavel;
    }
//  ----------------Getters--------------------}
}