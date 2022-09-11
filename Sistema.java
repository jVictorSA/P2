import java.util.LinkedList;
import java.util.Scanner;

public class Sistema {
    private LinkedList<Projeto> projetos = new LinkedList<Projeto>();
    public Usuario usuarioLogado;

//  {---------------------------------Construtores------------------------------------
    public Sistema(){
    }
    public Sistema(Projeto projeto){
        if(usuarioLogado.getPrivilegio() == Privilegios.ADMIN){
            this.projetos.add(projeto);
        }else{
            System.out.println("Somente Administradores podem adicionar projetos");
        }
    }
    public Sistema(LinkedList<Projeto> projetos){
        if(usuarioLogado.getPrivilegio() == Privilegios.ADMIN){
            this.projetos = projetos;
        }else{
            System.out.println("Somente Administradores podem adicionar projetos");
        }
    }
//  ----------------------------------Construtores-----------------------------------}

    public void relatorio(){
        for (Projeto projeto : projetos) {
            projeto.relatorio();
        }
    }

    public boolean Logar(Usuario usuario){
        Scanner input = new Scanner(System.in);
        System.out.println("Digite seu email: ");
        String login = input.nextLine();
        System.out.println("Digite sua senha: ");
        String senha = input.nextLine();
        if(login == usuario.getEmail() && senha == usuario.getSenha()){
            usuarioLogado = usuario;
            input.close();
            return true;
        }
        
        input.close();
        return false;
    }

    public void recuperarSenha(Usuario usuario){
        Scanner input = new Scanner(System.in);
        System.out.println("Digite seu email: ");
        String login = input.nextLine();
        if(login == usuario.getEmail()){
            System.out.println("Digite sua nova senha: ");
            String novaSenha = input.nextLine();
            usuario.alterarSenha(novaSenha);
            System.out.println("Senha alterada com sucesso");
        }
        input.close();
    }

//  {-----------------------------------Inserções-------------------------------------
    public void addProjeto(Projeto projeto, Usuario usuario){
        if(usuario.getPrivilegio() == Privilegios.ADMIN){
            this.projetos.add(projeto);
        }else{
            System.out.println("Somente Administradores podem adicionar projetos");
        }
    }
//  ------------------------------------Inserções------------------------------------}


//  {-----------------------------------Remoções--------------------------------------
    public void removeProjeto(Projeto projeto, Usuario usuario){
        if(usuario.getPrivilegio() == Privilegios.ADMIN){
            this.projetos.remove(projeto);
        }else{
            System.out.println("Somente Administradores podem remover projetos");
        }
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

//  {------------------------------Pagamento Bolsas-----------------------------------
    public void pagarBolsas(){
        for (Projeto projeto : projetos){
            projeto.pagarBolsas();
        }
    }
//  -------------------------------Pagamento Bolsas----------------------------------}

}
