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

    public void printar(){
        System.out.printf("\t\t---->\tResponsavel: %s\n\t\t---->\tDescricao: %s\n", responsavel.getNome(), descricao);
    }

//  {------------------------------------Edições--------------------------------------
    public void editarDescricao(String novaDescricao){
        this.descricao.replace(this.descricao, novaDescricao);
    }

    public void editarResponsavel(Usuario novoResponsavel){
        this.responsavel = novoResponsavel;
    }
//  -------------------------------------Edições-------------------------------------}

//  {-----------------------------------Getters---------------------------------------
    public String getDescricao(){
        return descricao;
    }

    public Usuario getResponsavel(){
        return responsavel;
    }
//  ------------------------------------Getters--------------------------------------}
}