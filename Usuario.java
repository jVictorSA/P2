public abstract class Usuario{    
    public abstract void printar();

//  {------------------------------------Edições--------------------------------------
    public abstract void alterarNome(String novoNome);
    public abstract void alterarEmail(String email);
    public abstract void alterarSenha(String senha);
//  -------------------------------------Edições-------------------------------------}

//  {------------------------------------Getters--------------------------------------
    public abstract String getNome();
    public abstract Privilegios getPrivilegio();
    public abstract boolean podeSerCordenador();
    public abstract String getEmail();
    public abstract String getSenha();
//  -------------------------------------Getters-------------------------------------}

//  {----------------------------------Requisições------------------------------------
    public void candidatarProjeto(Projeto projeto){
        projeto.addRequisitante(this);
    }

    public void candidatarAtividade(Atividade atividade){
        atividade.addRequisitante(this);
    }
//  -----------------------------------Requisições-----------------------------------}
}