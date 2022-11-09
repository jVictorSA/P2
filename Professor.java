import java.util.ArrayList;

public class Professor extends Usuario{
    private String nome;
    private Privilegios privilegio;
    private String email;
    private String senha;
    private ArrayList<Projeto> projetosCoordenados = new ArrayList<Projeto>();
    
    public Professor(String nome, String email, String senha){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public boolean ehCoordenador(){
        if(projetosCoordenados.size() == 0){
            return false;
        }else{
            return true;
        }
    }
    
    public void projetosCoordenados(){
        for (Projeto projeto : projetosCoordenados) {
            projeto.relatorio();
        }
    }

    public void printar(){
        System.out.printf("\t---->\t%s\t%s\t%s\n", nome, "Professor", email);
    }

//  {------------------------------------Edições--------------------------------------
    public void alterarNome(String novoNome){ this.nome.replace(this.nome, novoNome); }

    public void alterarEmail(String email){ this.email.replace(this.email, email); }

    public void alterarSenha(String senha){ this.senha.replace(this.senha, senha); }
//  -------------------------------------Edições-------------------------------------}    


//  {------------------------------------Getters--------------------------------------
    public String getNome(){ return nome; }

    public Privilegios getPrivilegio(){ return privilegio; }

    public boolean podeSerCordenador(){ return true; }

    public String getEmail(){ return email; }

    public String getSenha(){ return senha; }
//  -------------------------------------Getters-------------------------------------}
}
