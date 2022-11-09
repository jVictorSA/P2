import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.time.*;

public class Sistema {
    private LinkedList<Projeto> projetos = new LinkedList<Projeto>();
    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    public Usuario usuarioLogado;
    Scanner input = new Scanner(System.in);

//  {-----------------------------------Construtor-------------------------------------
    public Sistema(){}
//  ------------------------------------Construtor------------------------------------}

    public void relatorio(){
        for (Projeto projeto : projetos) {
            projeto.relatorio();
        }
    }

    public boolean Logar(){
        //Scanner input = new Scanner(System.in);
        System.out.println("Digite seu email: ");
        String login = input.nextLine();
        System.out.println("Digite sua senha: ");
        String senha = input.nextLine();
        for (Usuario usuario : usuarios) {
            if(usuario.getEmail().equals(login)){
                if(senha.equals(usuario.getSenha()) ){
                    usuarioLogado = usuario;
                    return true;
                }
            }
        }
        System.out.println("Usuario nao cadastrado!");
        return false;
    }

    public void deslogar(){ usuarioLogado = null;}

    public void recuperarSenha(){
        System.out.println("Digite seu email: ");
        String login = input.nextLine();
        for (Usuario usuario : usuarios) {
            if(login.equals(usuario.getEmail())){
                System.out.println("Digite sua nova senha: ");
                String novaSenha = input.nextLine();
                usuario.alterarSenha(novaSenha);
                System.out.println("Senha alterada com sucesso");
                return;
            }
        }
        System.out.println("Usuario nao encontrado!");
    }

//  {-----------------------------------Inserções-------------------------------------
    public void addProjeto(){
        System.out.println("Digite a descricao do projeto:");
        String descricao = input.nextLine();
        System.out.println("Digite o email do coordenador do projeto:");
        String email = input.nextLine();

        for (Usuario usuario : usuarios) {
            if(usuario.getEmail().equals(email)){
                    Projeto projeto = new Projeto(descricao, usuario);
                    this.projetos.add(projeto);
                    return;
            }
        }
        System.out.println("Usuario nao encontrado!");
    }

    public Usuario addUsuario(){
        System.out.println("CADASTRO DE USUARIO\n");
        System.out.println("Digite seu nome: ");
        String nome = input.nextLine();
        System.out.println("----TIPO DE USUARIO----");
        System.out.println("\t1 - Aluno\n\t2 - Professor\n\t3 - Pesquisador\n\t4 - Profissional\n\t5 - Tecnico");
        System.out.println("Digite seu tipo: ");
        int tipo = input.nextInt();
        input.nextLine();
        System.out.println("Digite seu email: ");
        String email = input.nextLine();
        System.out.println("Digite sua senha: ");
        String senha = input.nextLine();
        if(tipo == 1){
            System.out.println("----TIPO DE USUARIO----");
            System.out.println("\t1 - Graduando\n\t2 - Mestrando\n\t3 - Doutorando");
            System.out.println("Digite seu tipo: ");
            tipo = input.nextInt();            
            Aluno usuario = new Aluno(nome, email, senha, tipo);
            this.usuarios.add(usuario);
            System.out.println(usuario);
            for (Usuario usuario1 : usuarios) {
                usuario1.printar();
            }
            return usuario;
        }else if(tipo == 2){
            Professor usuario = new Professor(nome, email, senha);
            this.usuarios.add(usuario);
            return usuario;
        }else if(tipo == 3){
            Pesquisador usuario = new Pesquisador(nome, email, senha);
            this.usuarios.add(usuario);
            return usuario;
        }else if(tipo == 4){
            System.out.println("--TIPO DE PROFISSIONAL--");
            System.out.println("\t1 - Desenvolvedor\n\t2 - Testador\n\t3 - Analista");
            System.out.println("Digite seu tipo: ");
            tipo = input.nextInt();
            input.nextLine();
            Profissional usuario = new Profissional(nome, email, senha, tipo);
            this.usuarios.add(usuario);
            return usuario;
        }else{
            Tecnico usuario = new Tecnico(nome, email, senha);
            this.usuarios.add(usuario);
            return usuario;
        }
    }

    public Usuario addCoordenador(){
        System.out.println("CADASTRO DE Coordenador\n");
        System.out.println("Digite seu nome: ");
        String nome = input.nextLine();
        System.out.println("----TIPO DE USUARIO----");
        System.out.println("\t1 - Professor\n\t2 - Pesquisador");
        System.out.println("Digite seu tipo: ");
        int tipo = input.nextInt();
        System.out.println("Digite seu email: ");
        String email = input.nextLine();
        System.out.println("Digite sua senha: ");
        String senha = input.nextLine();
        if(tipo == 1){
            Professor usuario = new Professor(nome, email, senha);
            this.usuarios.add(usuario);
            return usuario;
        }else if(tipo == 2){
            Pesquisador usuario = new Pesquisador(nome, email, senha);
            this.usuarios.add(usuario);
            return usuario;
        }
        return null;
    }

    public Atividade addAtividade(){
        System.out.println("ADICIONAR ATIVIDADE");
        System.out.println("Digite o ID do projeto:");
        String id = input.nextLine();
        for (Projeto projeto : projetos) {
            if(projeto.getId().toString().equals(id)){
                System.out.println("Digite a descricao da atividade:");
                String descricao = input.nextLine();
                System.out.println("Digite o ano de inicio da atividade:");
                int ano = input.nextInt();
                System.out.println("Digite o mes de inicio da atividade:");
                int mes = input.nextInt();
                System.out.println("Digite o dia de inicio da atividade:");
                int dia = input.nextInt();
                LocalDate dataInicio = LocalDate.of(ano, mes, dia);
                System.out.println("Digite o ano de inicio da atividade:");
                ano = input.nextInt();
                System.out.println("Digite o mes de inicio da atividade:");
                mes = input.nextInt();
                System.out.println("Digite o dia de inicio da atividade:");
                dia = input.nextInt();
                System.out.println("Digite o email do responsavel pela atividade:");
                String email = input.nextLine();
                LocalDate dataFim = LocalDate.of(ano, mes, dia);
                for (Usuario usuario : usuarios) {
                    if(usuario.getEmail().equals(email)){
                        Atividade atividade = new Atividade(descricao, usuario, dataInicio, dataFim);
                        projeto.addAtividade(atividade);
                        System.out.println("Atividade adicionada");
                        return atividade;
                    }                    
                }
                System.out.println("Usuario nao encontrado!");
                return null;
            }
        }
        System.out.println("Projeto nao encontrada!");
        return null;
    }
//  ------------------------------------Inserções------------------------------------}

//  {------------------------------------Edições--------------------------------------

    public void alterarUsuario(){
        System.out.println("Digite o ID do projeto que o usuario participa:");
        String id = input.nextLine();

        for (Projeto projeto : projetos) {
            if(projeto.getId().toString().equals(id)){
                System.out.println("Digite o email do usuario que voce deseja trocar:");
                String email = input.nextLine();

                for (Usuario usuario : usuarios) {
                    if(usuario.getEmail().equals(email)){
                        Usuario novoUsuario = addUsuario();
                        projeto.editarUsuario(usuario, novoUsuario);
                        return;
                    }
                }
                System.out.println("Usuario nao encontrado!");
                return;
            }
        }
        System.out.println("Projeto nao encontrado!");
        return;
    }

    public void alterarDescricao(){
        System.out.println("Digite o ID do projeto que voce quer alterar a descricao:");
        String id = input.nextLine();

        for (Projeto projeto : projetos) {
            if (projeto.getId().toString().equals(id)){
                System.out.println("Digite a descricao:");
                String descricao = input.nextLine();
                projeto.editarDescricao(descricao);
                System.out.println("Descricao alterada");
                return;
            }
        }
        System.out.println("Projeto nao encontrado!");
        return;
    }

    public void alterarDataInicio(){
        System.out.println("Digite o ID do projeto que voce quer alterar a data de inicio:");
        String id = input.nextLine();

        for (Projeto projeto : projetos) {
            if (projeto.getId().toString().equals(id)){
                System.out.println("Digite o novo ano de inicio:");
                int ano = input.nextInt();
                System.out.println("Digite o novo ano de inicio:");
                int mes = input.nextInt();
                System.out.println("Digite o novo ano de inicio:");
                int dia = input.nextInt();
                LocalDate novaData = LocalDate.of(ano, mes, dia);
                projeto.editarDataInicio(novaData);
                System.out.println("Data de inicio alterada alterada");
                return;
            }
        }
        System.out.println("Projeto nao encontrado!");
        return;
    }

    public void alterarDataFim(){
        System.out.println("Digite o ID do projeto que voce quer alterar a data de inicio:");
        String id = input.nextLine();

        for (Projeto projeto : projetos) {
            if (projeto.getId().toString().equals(id)){
                System.out.println("Digite o novo ano de inicio:");
                int ano = input.nextInt();
                System.out.println("Digite o novo ano de inicio:");
                int mes = input.nextInt();
                System.out.println("Digite o novo ano de inicio:");
                int dia = input.nextInt();
                LocalDate novaData = LocalDate.of(ano, mes, dia);
                projeto.editarDataFim(novaData);
                System.out.println("Data de inicio alterada alterada");
                return;
            }
        }
        System.out.println("Projeto nao encontrado!");
        return;
    }

    public void alterarCoordenador(){
        System.out.println("Digite o ID do projeto que voce quer alterar o coordenador");
        String id = input.nextLine();

        for (Projeto projeto : projetos) {
            if (projeto.getId().toString().equals(id)){
                System.out.println("Digite o email do coordenador que voce quer substituir no lugar do atual:");
                String email = input.nextLine();
                for (Usuario novoCoordenador : usuarios) {
                    if(novoCoordenador.getEmail().equals(email)){
                        if(novoCoordenador.podeSerCordenador()){
                            projeto.editarCoordenador(novoCoordenador);
                        }
                        System.out.println("Usuario nao eh elegivel para ser coordenador de projetos!");
                        return;
                    }
                }
                System.out.println("Usuario nao encontrado!");
                return;
            }
        }
        System.out.println("Projeto nao encontrado!");
        return;
    }

    public void alterarProfissional(){
        System.out.println("Digite o ID do projeto que voce quer alterar o profissional");
        String id = input.nextLine();
        
        for (Projeto projeto : projetos) {
            if(projeto.getId().toString().equals(id)){
                System.out.println("Digite o email do profissional que voce que substituir no lugar do atual");
                String email = input.nextLine();
                System.out.println("Digite o email do profissional atual");
                String emailatual = input.nextLine();
                Usuario novoProfissional = null;
                for (Usuario usuario : usuarios) {
                    if(usuario.getEmail().equals(email)){
                        novoProfissional = usuario;
                    }
                }
                if(novoProfissional.equals(null)){
                    System.out.println("Profissional substituto nao encontrado!");
                    return;
                }
                for (Usuario usuario : usuarios) {
                    if(usuario.getEmail().equals(emailatual)){
                        projeto.editarProfissional(usuario, novoProfissional);
                        System.out.println("Profissional substituido");
                        return;
                    }
                }
                System.out.println("Profissional atual nao encontrado!");                
                return;
            }
        }
        System.out.println("Projeto nao encontrado!");
    }

    public void alterarAtividade(){
        System.out.println("Digite o ID do projeto que voce quer alterar o atividade:");
        String id = input.nextLine();
        
        for (Projeto projeto : projetos) {
            if(projeto.getId().toString().equals(id)){
                System.out.println("Digite o ID da atividade que voce quer alterar:");
                id = input.nextLine();
                for (Atividade atividade : projeto.getAtividades()) {
                    if(atividade.getId().toString().equals(id)){
                        Atividade novaAtividade = addAtividade();
                        projeto.editarAtividade(atividade, novaAtividade);
                        System.out.println("Atividade alterada");
                        return;
                    }
                }
                System.out.println("Atividade nao encontrada!");                
                return;
            }
        }
        System.out.println("Projeto nao encontrado!");
    }

    public void alterarBolsa(){
        System.out.println("Digite o ID do projeto que voce quer alterar a bolsa:");
        String id = input.nextLine();
        
        for (Projeto projeto : projetos) {
            if(projeto.getId().toString().equals(id)){
                System.out.println("Digite o email do aluno que voce quer alterar a bolsa:");
                String email = input.nextLine();
                System.out.println("Digite o email do aluno que recebera a nova bolsa:");
                String novoEmail = input.nextLine();
                System.out.println("Digite o valor da nova bolsa:");
                int valor = input.nextInt();
                Aluno alunoAtual = null;
                Bolsa bolsaAtual = null;
                for (Usuario aluno : usuarios) {
                    if (aluno.getEmail().equals(email)){
                        alunoAtual = (Aluno)aluno;
                    }
                }
                if(alunoAtual.equals(null)){
                    System.out.println("Aluno atual nao encontrado!");                    
                    return;
                }

                for (Bolsa bolsa : projeto.getBolsas()) {
                    if(bolsa.getRecebedor().equals(alunoAtual)){
                        bolsaAtual = bolsa;
                    }
                }

                for (Usuario novoAluno : usuarios) {
                    if(novoAluno.getEmail().equals(novoEmail)){
                        Bolsa novaBolsa = new Bolsa(valor, (Aluno)novoAluno);
                        projeto.editarBolsa(bolsaAtual, novaBolsa);                        
                    }
                }
            }
        }
    }

    public void editarStatus(){
        if(!usuarioLogado.podeSerCordenador()){
            System.out.println("Usuario nao pode mudar status de projetos!");
            return;
        }

        System.out.println("Digite o ID do projeto que voce quer alterar o status:");
        String id = input.nextLine();

        for (Projeto projeto : projetos) {
            if(projeto.getId().toString().equals(id)){
                if(usuarioLogado.equals(projeto.getCoordenador())){
                    System.out.println("--SELECIONE UM DOS STATUS--");
                    System.out.println("1 - Iniciado");
                    System.out.println("2 - Em Andamento");
                    System.out.println("3 - Concluido");
                    System.out.println("Digite sua opcao:");
                    int opcao = input.nextInt();

                    if(opcao == 1){
                        projeto.editarStatus(Status.INICIADO);
                    }else if(opcao == 2){
                        projeto.editarStatus(Status.EM_ANDAMENTO);
                    }else{
                        projeto.editarStatus(Status.CONCLUIDO);
                    }
                    System.out.println("Status de projeto alterado");
                    return;
                }
                System.out.println("Voce nao eh coordenador deste projeto!");
                return;
            }
        }

        System.out.println("Projeto nao encontrado!");
    }
//  -------------------------------------Edições-------------------------------------}

//  {-----------------------------------Remoções--------------------------------------
    public void removeProjeto(){
        if(!usuarioLogado.podeSerCordenador()){
            System.out.println("Somente Administradores podem remover projetos");
            return;
        }
        
        System.out.println("Digite o ID do projeto que queira remover:");
        String id = input.nextLine();
        for (Projeto projeto : projetos) {
            if(projeto.getId().toString().equals(id)){
                this.projetos.remove(projeto);
                System.out.println("Projeto removido");                
                return;
            }
        }
        System.out.println("Projeto não encontrado!");        
    }

    public void removeAtividade(){
        System.out.println("Digite o ID do projeto que queira remover a atividade:");
        String id = input.nextLine();
        for (Projeto projeto : projetos) {
            if(projeto.getId().toString().equals(id)){
                System.out.println("Digite o ID da atividade que voce quer remover:");
                id = input.nextLine();
                for (Atividade atividade : projeto.getAtividades()) {
                    if(atividade.getId().toString().equals(id)){
                        projeto.removeAtividade(atividade);
                        System.out.println("Atividade removida");                        
                        return;
                    }
                }
                System.out.println("Atividade nao encotrada!");                
                return;
            }
        }
        System.out.println("Projeto nao encontrado!");        
    }

    public void removeUsuario() {        
        System.out.println("REMOCAO DE USUARIO\n");
        System.out.println("Digite o email do usuario a remover: ");
        String email = input.nextLine();
        if(email.equals(usuarioLogado.getEmail())){
            System.out.println("NAO EH POSSIVEL REMOVER UM USUARIO LOGADO\n");            
            return;
        }

        for (Usuario usuario : usuarios) {
            if(usuario.getEmail().equals(email)){
                this.usuarios.remove(usuario);
                System.out.println("Usuario removido...\n");
                return;
            }
        }
        System.out.println("Usuario nao encontrado...\n");        
    }
//  ------------------------------------Remoções-------------------------------------}

//  {---------------------------------Intercâmbio-------------------------------------
    public void intercambio(){
        System.out.println("Digite o ID do projeto que voce quer intercambiar um aluno:");
        String id = input.nextLine();
        Usuario aluno = null;
        Projeto projetoInicial = null;

        for (Projeto projeto : projetos) {
            if(projeto.getId().toString().equals(id)){
                System.out.println("Digite o email do aluno que voce quer intercambiar:");
                String email = input.nextLine();
                for (Usuario usuario : projeto.getUsuarios()) {
                    if(usuario.getEmail().equals(email)){
                        aluno = usuario;
                        projetoInicial = projeto;

                        System.out.println("Digite o ID do projeto que voce quer intercambiar um aluno:");
                        id = input.nextLine();
                        for (Projeto projetoIntercambio : projetos) {
                            if(projeto.getId().toString().equals(id)){
                                System.out.println("Digite o ID da atividade que voce quer intercambiar o aluno:");
                                id = input.nextLine();
                                for (Atividade atividade : projetoIntercambio.getAtividades()) {
                                    if(atividade.getId().toString().equals(id)){
                                        atividade.addProfissional(aluno);
                                        System.out.println("Aluno intercambiado");                                        
                                        return;
                                    }
                                }
                                System.out.println("Atividade nao encontrada!");                                
                                return;
                            }
                        }
                        System.out.println("Projeto nao encontrado!");                        
                    }
                }
                System.out.println("Aluno nao encontrado!");                
                return;
            }
        }
        System.out.println("Projeto nao encontrado!");
    }
//  ----------------------------------Intercâmbio------------------------------------}

//  {----------------------------------Consultas--------------------------------------
    public void consultarProjetoPorUsuario(){
        System.out.println("Digite o email do usuario:");
        String email = input.nextLine();
        
        for (Usuario usuario : usuarios) {
            if(usuario.getEmail().equals(email)){
                for (Projeto projeto : projetos) {
                    if(projeto.getUsuarios().contains(usuario)){
                        projeto.relatorio();                        
                        return;
                    }
                }
                System.out.println("Projeto nao encontrado");                
                return;
            }
        }
        System.out.println("Usuario nao encontrado");        
    }

    public void consultarAtividadePorUsuario(){        
        System.out.println("Digite o email do usuario:");
        String email = input.nextLine();
        
        for (Usuario usuario : usuarios) {
            if(usuario.getEmail().equals(email)){
                System.out.println("Digite o ID do projeto:");
                String id = input.nextLine();
                for (Projeto projeto : projetos) {
                    if(projeto.getId().toString().equals(id)){
                        for (Atividade atividade : projeto.getAtividades()) {
                            if(atividade.getProfissionais().contains(usuario)){
                                atividade.relatorio();                                
                                return;
                            }
                        }
                        System.out.println("Atividade nao encontrada!");                        
                        return;
                    }
                }
                System.out.println("Projeto nao encontrado!");                
                return;
            }
        }
        System.out.println("Usuario nao encontrado!");        
    }

    public void consultarUsuariosPorProjeto(){        
        System.out.println("Digite o ID do projeto:");
        String id = input.nextLine();
        
        for (Projeto projeto : projetos) {
            if(projeto.getId().toString().equals(id)){
                for (Usuario usuario : projeto.getUsuarios()) {
                    usuario.printar();
                }                
                return;
            }
        }
        System.out.println("Projeto nao encontrado");        
    }

    public void consultarAtividadePorProjeto(){        
        System.out.println("Digite o ID do projeto:");
        String id = input.nextLine();
        
        for (Projeto projeto : projetos) {
            if(projeto.getId().toString().equals(id)){
                for (Atividade atividade : projeto.getAtividades()) {
                    atividade.relatorio();
                }                
                return;
            }
        }
        System.out.println("Projeto nao encontrado");        
    }

    public void consultarProjetoPorAtividade(){        
        System.out.println("Digite o ID da atividade:");
        String id = input.nextLine();

        for (Projeto projeto : projetos) {
            for (Atividade atividade : projeto.getAtividades()) {
                if(atividade.getId().toString().equals(id)){
                    projeto.relatorio();                    
                    return;
                }
            }
            System.out.println("Atividade nao encontrada!");            
            return;    
        }
        System.out.println("Projeto nao encontrado!");        
    }

    public void consultarUsuariosPorAtividade(){        
        System.out.println("Digite o ID da atividade:");
        String id = input.nextLine();

        for (Projeto projeto : projetos) {
            for (Atividade atividade : projeto.getAtividades()) {
                if(atividade.getId().toString().equals(id)){
                    for (Usuario envolvido : atividade.getProfissionais()) {
                        envolvido.printar();
                    }                    
                    return;
                }
            }
            System.out.println("Atividade nao encontrada!");
            return;    
        }
        System.out.println("Projeto nao encontrado!");        
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
