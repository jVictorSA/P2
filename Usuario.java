import java.time.LocalDateTime;

public class Usuario{
    private String nome;
    private Tipo tipo;
    private Privilegios privilegio;
    private double saldoBolsa = 0;
    private String email;
    private String senha;

    //Construtor
    public Usuario(String nome, Tipo tipo, String email, String senha){
        this.nome = nome;
        this.tipo = tipo;
    }

    public void printar(){
        System.out.printf("\t---->\t%s\t%s\n", nome, tipo.toString());
    }

//  {------------------------------------Edições--------------------------------------
    public void alterarNome(String novoNome){
        this.nome.replace(this.nome, novoNome);
    }
    
    public void alterarTipo(Tipo novoTipo){
        this.tipo = novoTipo;
    }

    public void alterarEmail(String email){
        this.email = email;
    }

    public void alterarSenha(String senha){
        this.senha = senha;
    }
//  -------------------------------------Edições-------------------------------------}

//  {------------------------------------Getters--------------------------------------
    public String getNome(){ return nome; }

    public Tipo getTipo(){ return tipo; }

    public Privilegios getPrivilegio(){ return privilegio; }

    public double getSaldoBolsa(){ return saldoBolsa; }

    public String getEmail(){ return email; }

    public String getSenha(){ return senha; }
//  -------------------------------------Getters-------------------------------------}

//  {------------------------------------Bolsas---------------------------------------
    public void receberBolsa(double valor){
        saldoBolsa += valor;
    }
//  -------------------------------------Bolsas--------------------------------------}

//  {----------------------------------Requisições------------------------------------
    public void candidatarProjeto(Projeto projeto){
        projeto.addRequisitante(this);
    }

    public void candidatarAtividade(Atividade atividade){
        atividade.addRequisitante(this);
    }
//  -----------------------------------Requisições-----------------------------------}

//  {-----------------------Atribuições Professor ou Pesquisador----------------------
    public void iniciarProjeto(Projeto projeto){
        if(this == projeto.getCoordenador() && projeto.informacoesAdicionadas()){
            projeto.editarStatus(Status.INICIADO);
        }
    }

    public void projetoEmAndamento(Projeto projeto){
        if(this == projeto.getCoordenador() && projeto.getDataInicio().isBefore(LocalDateTime.now())){
            projeto.editarStatus(Status.EM_ANDAMENTO);
        }
    }

    public void concluirProjeto(Projeto projeto){
        if(this == projeto.getCoordenador() && projeto.getStatus() == Status.EM_ANDAMENTO){
            projeto.editarStatus(Status.CONCLUIDO);
        }
    }
//  ------------------------Atribuições Professor ou Pesquisador---------------------}
}