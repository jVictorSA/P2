public class Usuario{
    private String nome;
    private Tipo tipo;

    //Construtor
    public Usuario(String nome, Tipo tipo){
        this.nome = nome;
        this.tipo = tipo;
    }

//  {---------------Edições---------------------
    public void alterarNome(String novoNome){
        this.nome.replace(this.nome, novoNome);
    }
    
    public void alterarTipo(Tipo novoTipo){
        this.tipo = novoTipo;
    }
//  ----------------Edições--------------------}

//  {---------------Getters---------------------
    public String getNome(){
        return nome;
    }

    public Tipo getTipo(){
        return tipo;
    }
//  ----------------Getters--------------------}
}