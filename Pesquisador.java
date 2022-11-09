import java.time.LocalDate;
import java.util.ArrayList;

public class Pesquisador extends Usuario{
    private String nome;
    private Privilegios privilegio;
    private String email;
    private String senha;
    private ArrayList<Projeto> projetosCoordenados = new ArrayList<Projeto>();
    
    public Pesquisador(String nome, String email, String senha){
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
        System.out.printf("\t---->\t%s\t%s\n", nome, "Pesquisador");
    }

//  {------------------------------------Getters--------------------------------------
    public String getNome(){ return nome; }
    
    public Privilegios getPrivilegio(){ return privilegio; }

    public boolean podeSerCordenador(){ return true; }

    public String getEmail(){ return email; }

    public String getSenha(){ return senha; }
//  -------------------------------------Getters-------------------------------------}

//  {------------------------------------Edições--------------------------------------
    public void alterarNome(String novoNome){ this.nome.replace(this.nome, novoNome); }

    public void alterarEmail(String email){ this.email.replace(this.email, email); }

    public void alterarSenha(String senha){ this.senha.replace(this.senha, senha); }
//  -------------------------------------Edições-------------------------------------}

    public void iniciarProjeto(Projeto projeto){
        if(this == projeto.getCoordenador() && projeto.informacoesAdicionadas()){
            projeto.editarStatus(Status.INICIADO);
        }
    }

    public void projetoEmAndamento(Projeto projeto){
        if(this == projeto.getCoordenador() && projeto.getDataInicio().isBefore(LocalDate.now())){
            projeto.editarStatus(Status.EM_ANDAMENTO);
        }
    }

    public void concluirProjeto(Projeto projeto){
        if(this == projeto.getCoordenador() && projeto.getStatus() == Status.EM_ANDAMENTO){
            projeto.editarStatus(Status.CONCLUIDO);
        }
    }
}
