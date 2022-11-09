public class Profissional extends Usuario{
    private String nome;
    private Privilegios privilegio;
    private String email;
    private String senha;
    private enum Tipo{ DEV, TESTADOR, ANALISTA }
    private Tipo tipo;
    public Profissional(String nome, String email, String senha, int tipo){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        if(tipo == 1){
            this.tipo = Tipo.DEV;
        }else if(tipo == 2){
            this.tipo = Tipo.TESTADOR;
        }else{
            this.tipo = Tipo.ANALISTA;
        }
    }

    public void printar(){
        System.out.printf("\t---->\t%s\t%s\n", nome, tipo.toString());
    }

//  {------------------------------------Edições--------------------------------------
    public void alterarNome(String novoNome){ this.nome.replace(this.nome, novoNome); }
    
    public void alterarTipo(Tipo novoTipo){ this.tipo = novoTipo; }

    public void alterarEmail(String email){ this.email.replace(this.email, email); }

    public void alterarSenha(String senha){ this.senha.replace(this.senha, senha); }
//  -------------------------------------Edições-------------------------------------}

//  {------------------------------------Getters--------------------------------------
    public String getNome(){ return nome; }

    public Tipo getTipo(){ return tipo; }

    public boolean podeSerCordenador() {return false;}

    public Privilegios getPrivilegio(){ return privilegio; }

    public String getEmail(){ return email; }

    public String getSenha(){ return email; }
//  -------------------------------------Getters-------------------------------------}
}