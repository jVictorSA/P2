public class Aluno extends Usuario{
    private String nome;
    private Privilegios privilegio;
    private double saldoBolsa = 0;
    private String email;
    private String senha;
    private enum Tipo {GRADUANDO, MESTRANDO, DOUTORANDO}
    private Tipo tipo;


    public Aluno(String nome, String email, String senha, int tipo){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        if(tipo == 1){
            this.tipo = Tipo.GRADUANDO;
        }else if(tipo == 2){
            this.tipo = Tipo.MESTRANDO;
        }else{
            this.tipo = Tipo.DOUTORANDO;
        }
    }

    public void printar(){
        System.out.printf("\t---->\t%s\t%s\n\t---->\t%s\n", nome, tipo.toString(),email);
    }

//  {------------------------------------Bolsas---------------------------------------
    public void receberBolsa(double valor){
        saldoBolsa += valor;
    }
//  -------------------------------------Bolsas--------------------------------------}

//  {------------------------------------Getters--------------------------------------
    public String getNome(){ return nome; }

    public Privilegios getPrivilegio(){ return privilegio; }

    public Tipo getTipo(){ return tipo; }

    public boolean podeSerCordenador() {return false;}

    public double getSaldoBolsa(){ return saldoBolsa; }

    public String getEmail(){ return email; }

    public String getSenha(){ return senha; }
//  -------------------------------------Getters-------------------------------------}

//  {------------------------------------Edições--------------------------------------
    public void alterarNome(String novoNome){
        this.nome.replace(this.nome, novoNome);
    }

    public void alterarEmail(String email){
        this.email.replace(this.email, email);
    }

    public void alterarSenha(String senha){
        this.senha.replace(this.senha, senha);
    }
//  -------------------------------------Edições-------------------------------------}


//  {----------------------------------Requisições------------------------------------
    public void candidatarProjeto(Projeto projeto){
        projeto.addRequisitante(this);
    }

    public void candidatarAtividade(Atividade atividade){
        atividade.addRequisitante(this);
    }
//  -----------------------------------Requisições-----------------------------------}
}
