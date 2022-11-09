public class Tecnico extends Usuario{
    private String nome;
    private Privilegios privilegio;
    private String email;
    private String senha;

    public Tecnico(String nome, String email, String senha){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public void printar(){
        System.out.printf("\t---->\t%s\t%s\n", nome, "Técnico");
    }

//  {------------------------------------Edições--------------------------------------
    public void alterarNome(String novoNome){ this.nome.replace(this.nome, novoNome); }
    
    public void alterarEmail(String email){ this.email.replace(this.email, email); }

    public void alterarSenha(String senha){ this.senha.replace(this.senha, senha); }
//  -------------------------------------Edições-------------------------------------}

//  {------------------------------------Getters--------------------------------------
    public String getNome(){ return nome; }

    public String getEmail(){ return email; }

    public boolean podeSerCordenador() {return false;}

    public Privilegios getPrivilegio(){ return privilegio; }

    public String getSenha(){ return senha; }
//  -------------------------------------Getters-------------------------------------}
}
