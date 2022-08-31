public class Tarefa{
    private String descricao;
    private Usuario responsavel;
    private boolean conclusao;

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
}