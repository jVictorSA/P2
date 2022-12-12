public class Builder {
    private String descricao;
    private Usuario coordenador;

    Builder(){}
    
    Projeto build(){
        return new Projeto(descricao, coordenador);
    }

    public void setCoordenador(Usuario coordenador) {
        this.coordenador = coordenador;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
