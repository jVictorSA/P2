import java.util.LinkedList;

public class Sistema {
    private LinkedList<Projeto> projetos = new LinkedList<Projeto>();

//  {---------------------------------Construtores------------------------------------
    public Sistema(){}
    public Sistema(Projeto projeto){
        this.projetos.add(projeto);
    }
    public Sistema(LinkedList<Projeto> projetos){
        this.projetos = projetos;
    }
//  ----------------------------------Construtores-----------------------------------}

//  {-----------------------------------Inserções-------------------------------------
    public void addProjeto(Projeto projeto){
        this.projetos.add(projeto);
    }
//  ------------------------------------Inserções------------------------------------}


//  {-----------------------------------Remoções--------------------------------------
    public void removeProjeto(Projeto projeto){
        this.projetos.remove(projeto);
    }
//  ------------------------------------Remoções-------------------------------------}

//  {----------------------------------Consultas--------------------------------------
    public Projeto consultarProjeto(Usuario usuario){
        for (Projeto projeto : projetos) {
            if(projeto.getUsuarios().contains(usuario)){
                return projeto;
            }
        }
        return null;
    }

    public Atividade consultarAtividade(Usuario usuario){
        for (Projeto projeto : projetos) {
            for (Atividade atividade : projeto.getAtividades()) {
                if(atividade.getProfissionais().contains(usuario)){
                    return atividade;
                }
            }
        }

        return null;
    }

    public LinkedList<Usuario> consultarUsuarios(Projeto projeto){
        return projeto.getUsuarios();
    }

    public LinkedList<Atividade> consultarAtividade(Projeto projeto){
        return projeto.getAtividades();
    }

    public Projeto consultarProjeto(Atividade atividade){
        for (Projeto projeto : projetos) {
            if(projeto.getAtividades().contains(atividade)){
                return projeto;
            }
        }

        return null;
    }

    public LinkedList<Usuario> consultarUsuarios(Atividade atividade){
        return atividade.getProfissionais();
    }
//  -----------------------------------Consultas-------------------------------------}

}
