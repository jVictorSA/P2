public abstract class Usuario{
    // private String nome;
    // private Privilegios privilegio;
    // private double saldoBolsa = 0;
    // private String email;
    // private String senha;

    //Construtor
    // public Usuario(String nome, Tipo tipo, String email, String senha){
    //     this.nome = nome;
    //     this.tipo = tipo;
    //     this.email = email;
    //     this.senha = senha;
    // }

    // public Usuario(String nome, String email, String senha){
    //     this.nome = nome;
    //     this.email = email;
    //     this.senha = senha;
    // }


    public abstract void printar();
        //System.out.printf("\t---->\t%s\t%s\n", nome);

//  {------------------------------------Edições--------------------------------------
    public abstract void alterarNome(String novoNome);
    // {
    //     this.nome.replace(this.nome, novoNome);
    // }

    public abstract void alterarEmail(String email);
    //{this.email = email;}

    public abstract void alterarSenha(String senha);
    //{this.senha = senha;}
//  -------------------------------------Edições-------------------------------------}

//  {------------------------------------Getters--------------------------------------
    public abstract String getNome();//{ return nome; }

    public abstract Privilegios getPrivilegio();//{ return privilegio; }

    public abstract boolean podeSerCordenador();

    //public abstract double getSaldoBolsa();//{ return saldoBolsa; }

    public abstract String getEmail();//{ return email; }

    public abstract String getSenha();//{ return senha; }
//  -------------------------------------Getters-------------------------------------}

//  {----------------------------------Requisições------------------------------------
    public void candidatarProjeto(Projeto projeto){
        projeto.addRequisitante(this);
    }

    public void candidatarAtividade(Atividade atividade){
        atividade.addRequisitante(this);
    }
//  -----------------------------------Requisições-----------------------------------}

//  {-----------------------Atribuições Professor ou Pesquisador----------------------
    // public void iniciarProjeto(Projeto projeto){
    //     if(this == projeto.getCoordenador() && projeto.informacoesAdicionadas()){
    //         projeto.editarStatus(Status.INICIADO);
    //     }
    // }

    // public void projetoEmAndamento(Projeto projeto){
    //     if(this == projeto.getCoordenador() && projeto.getDataInicio().isBefore(LocalDateTime.now())){
    //         projeto.editarStatus(Status.EM_ANDAMENTO);
    //     }
    // }

    // public void concluirProjeto(Projeto projeto){
    //     if(this == projeto.getCoordenador() && projeto.getStatus() == Status.EM_ANDAMENTO){
    //         projeto.editarStatus(Status.CONCLUIDO);
    //     }
    // }
//  ------------------------Atribuições Professor ou Pesquisador---------------------}
}