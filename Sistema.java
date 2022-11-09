import java.util.ArrayList;
import java.util.InputMismatchException;
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
        if(projetos.isEmpty()){
            System.out.println("Nao ha projetos cadastrados no sistema!");
            return;
        }
        for (Projeto projeto : projetos) {
            projeto.relatorio();
        }
    }

    public boolean Logar(){
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
        int tipo = 0;
        do {
            try {
                System.out.println("----TIPO DE USUARIO----");
                System.out.println("\t1 - Aluno\n\t2 - Professor\n\t3 - Pesquisador\n\t4 - Profissional\n\t5 - Tecnico");
                System.out.println("Digite seu tipo: ");
                tipo = input.nextInt();
                input.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Voce digitou caracteres! Digite um numero dentre as opcoes:");
            }
            input.nextLine();
        } while (tipo == 0);
        
        System.out.println("Digite seu email: ");
        String email = input.nextLine();
        System.out.println("Digite sua senha: ");
        String senha = input.nextLine();
        if(tipo == 1){
            tipo = 0;
            do {
                try {
                    System.out.println("----TIPO DE USUARIO----");
                    System.out.println("\t1 - Graduando\n\t2 - Mestrando\n\t3 - Doutorando");
                    System.out.println("Digite seu tipo: ");
                    tipo = input.nextInt();                    
                } catch (InputMismatchException e) {
                    System.out.println("Voce digitou caracteres! Digite um numero dentre as opcoes:");
                }
                input.nextLine();
            } while (tipo == 0);
            
            Aluno usuario = new Aluno(nome, email, senha, tipo);
            this.usuarios.add(usuario);
            System.out.println(usuario);
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
            tipo = 0;
            do {
                try {
                    System.out.println("--TIPO DE PROFISSIONAL--");
                    System.out.println("\t1 - Desenvolvedor\n\t2 - Testador\n\t3 - Analista");
                    System.out.println("Digite seu tipo: ");
                    tipo = input.nextInt();
                    input.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Voce digitou caracteres! Digite um numero dentre as opcoes:");
                }
                input.nextLine();
            } while (tipo == 0);
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
        int tipo = 0;
        do {
            try {
                System.out.println("----TIPO DE USUARIO----");
                System.out.println("\t1 - Professor\n\t2 - Pesquisador");
                System.out.println("Digite seu tipo: ");
                tipo = input.nextInt();
                input.nextLine();
                break;        
            } catch (InputMismatchException e) {
                System.out.println("Voce digitou caracteres! Digite um numero dentre as opcoes:");
            }
            input.nextLine();
        } while (tipo == 0);
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

    public void addUsuarioEmProjeto(){
        System.out.println("INSERCAO DE ALUNO EM PROJETO");

        System.out.println("Digite o ID do projeto:");
        String id = input.nextLine();
        for (Projeto projeto : projetos) {
            if(projeto.getId().toString().equals(id)){
                System.out.println("Digite o email do aluno a inserir no projeto:");
                String email = input.nextLine();
                for (Usuario aluno : usuarios) {
                    if(aluno.getEmail().equals(email)){
                        projeto.addUsuario(aluno);
                        return;
                    }
                }
                System.out.println("Usuario nao encontrado!");
                return;
            }
        }
        System.out.println("Projeto nao encontrado!");
    }

    public void addDataInicioEmProjeto(){
        System.out.println("ADICIONAR DATA DE INICIO DE PROJETO");
        System.out.println("Digite o ID do projeto:");
        String id = input.nextLine();
        for (Projeto projeto : projetos) {
            if(projeto.getId().toString().equals(id)){
                int ano = 0;
                int dia = 0;
                int mes = 0;
                do {
                    try {
                        System.out.println("Digite o ano de inicio da atividade:");
                        ano = input.nextInt();
                        input.nextLine();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Voce digitou caracteres!");
                    }
                    input.nextLine();
                } while (ano == 0);

                do {
                    try {
                        System.out.println("Digite o mes de inicio da atividade:");
                        mes = input.nextInt();
                        input.nextLine();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Voce digitou caracteres!");
                    }
                    input.nextLine();
                } while (mes == 0);

                do {
                    try {
                        System.out.println("Digite o dia de inicio da atividade:");
                        dia = input.nextInt();
                        input.nextLine();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Voce digitou caracteres!");
                    }
                    input.nextLine();
                } while (dia == 0);

                LocalDate Data = LocalDate.of(ano, mes, dia);
                if(projeto.addDataInicio(Data)){
                    System.out.println("Data de inicio adicionada");
                }else{
                    System.out.println("Data de inicio tem de ser posterior a hoje!");    
                    return;
                }
            }
        }
        System.out.println("Projeto nao encontrado!");
    }
    public void addDataFimoEmProjeto(){
        System.out.println("ADICIONAR DATA DE FIM DE PROJETO");
        System.out.println("Digite o ID do projeto:");
        String id = input.nextLine();
        for (Projeto projeto : projetos) {
            if(projeto.getId().toString().equals(id)){
                int ano = 0;
                int dia = 0;
                int mes = 0;
                do {
                    try {
                        System.out.println("Digite o ano de fim da atividade:");
                        ano = input.nextInt();
                        input.nextLine();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Voce digitou caracteres!");
                    }
                    input.nextLine();
                } while (ano == 0);

                do {
                    try {
                        System.out.println("Digite o mes de fim da atividade:");
                        mes = input.nextInt();
                        input.nextLine();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Voce digitou caracteres!");
                    }
                    input.nextLine();
                } while (mes == 0);

                do {
                    try {
                        System.out.println("Digite o dia de fim da atividade:");
                        dia = input.nextInt();
                        input.nextLine();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Voce digitou caracteres!");
                    }
                    input.nextLine();
                } while (dia == 0);

                LocalDate Data = LocalDate.of(ano, mes, dia);
                if(projeto.addDataFim(Data)){
                    System.out.println("Data de fim adicionada");
                }else{
                    System.out.println("Data de fim tem de ser posterior a hoje!");
                    return;
                }
            }
        }
        System.out.println("Projeto nao encontrado!");
    }
    
    public void addProfisionalEmProjeto(){
        System.out.println("INSERCAO DE PROFISSIONAL EM PROJETO");

        System.out.println("Digite o ID do projeto:");
        String id = input.nextLine();
        for (Projeto projeto : projetos) {
            if(projeto.getId().toString().equals(id)){
                System.out.println("Digite o email do profissional a inserir no projeto:");
                String email = input.nextLine();
                for (Usuario profissional : usuarios) {
                    if(profissional.getEmail().equals(email)){
                        projeto.addProfissional(profissional);
                        return;
                    }
                }
                System.out.println("Usuario nao encontrado!");
                return;
            }
        }
        System.out.println("Projeto nao encontrado!");
    }
    
    public void addBolsaEmProjeto(){
        System.out.println("INSERCAO DE BOLSA EM PROJETO");
        int valor = 0;
        System.out.println("Digite o ID do projeto:");
        String id = input.nextLine();
        for (Projeto projeto : projetos) {
            if(projeto.getId().toString().equals(id)){
                System.out.println("Digite o email do aluno do projeto que vai receber a bolsa:");
                String email = input.nextLine();
                for (Usuario aluno : usuarios) {
                    if(aluno.getEmail().equals(email)){
                        do {
                            try {
                                System.out.println("Digite o valor da bolsa:");
                                valor = input.nextInt();        
                            } catch (InputMismatchException e) {
                                System.out.println("Voce digitou caracteres! Digite um numero!");
                            }
                        } while (valor == 0);

                        Bolsa bolsa = new Bolsa(valor, (Aluno)aluno);

                        projeto.addBolsa(bolsa);
                        System.out.println("Bolsa inserida");
                    }
                }
                System.out.println("Usuario nao encontrado!");
                return;
            }
        }
        System.out.println("Projeto nao encontrado!");
    }
    
    public void addRequisitanteEmProjeto(){
        System.out.println("ADICIONAR REQUISITANTE EM PROJETO");
        System.out.println("Digite o ID do projeto que o aluno requisitante deseja entrar:");
        String id = input.nextLine();
        for (Projeto projeto : projetos) {
            if(projeto.getId().toString().equals(id)){
                System.out.println("Digite o email do aluno requisitante");
                String email = input.nextLine();
                for (Usuario usuario : usuarios) {
                    if(usuario.getEmail().equals(email)){
                        usuario.candidatarProjeto(projeto);
                        System.out.println("Requisicao efetuada");
                        return;
                    }
                }
                System.out.println("Aluno nao encontrado!");
                return;
            }
        }
        System.out.println("Projeto nao encontrado!");
    }

    public void addRequisitanteEmAtividade(){
        System.out.println("ADICIONAR REQUISITANTE EM PROJETO");
        System.out.println("Digite o ID do projeto que o aluno requisitante deseja entrar:");
        String id = input.nextLine();
        for (Projeto projeto : projetos) {
            if(projeto.getId().toString().equals(id)){
                System.out.println("Digite o ID da atividade que o aluno requisitante desja entrar:");
                id = input.nextLine();
                for (Atividade atividade : projeto.getAtividades()) {
                    if(atividade.getId().toString().equals(id)){
                        System.out.println("Digite o email do aluno requisitante");
                        String email = input.nextLine();
                        for (Usuario usuario : usuarios) {
                            if(usuario.getEmail().equals(email)){
                                usuario.candidatarAtividade(atividade);
                                System.out.println("Requisicao efetuada");
                                return;
                            }
                        }
                        System.out.println("Aluno nao encontrado!");
                        return;
                    }
                }
                System.out.println("Atividade nao encontrada!");
                return;
            }
        }
        System.out.println("Projeto nao encontrado!");
    }

    public Atividade addAtividade(){
        System.out.println("ADICIONAR ATIVIDADE");
        System.out.println("Digite o ID do projeto:");
        String id = input.nextLine();
        for (Projeto projeto : projetos) {
            if(projeto.getId().toString().equals(id)){
                System.out.println("Digite a descricao da atividade:");
                String descricao = input.nextLine();
                int ano = 0;
                do {
                    try {
                        System.out.println("Digite o ano de inicio da atividade:");
                        ano = input.nextInt();
                        input.nextLine();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Voce digitou caracteres!");
                    }
                    input.nextLine();
                } while (ano == 0);
                
                int mes = 0;
                
                do {
                    try {
                        System.out.println("Digite o mes de inicio da atividade:");
                        mes = input.nextInt();
                        input.nextLine();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Voce digitou caracteres!");
                    }
                    input.nextLine();
                } while (mes == 0);

                int dia = 0;
                do {
                    try {
                        System.out.println("Digite o dia de inicio da atividade:");
                        dia = input.nextInt();
                        input.nextLine();
                        break;      
                    } catch (InputMismatchException e) {
                        System.out.println("Voce digitou caracteres!");
                    }
                    input.nextLine();
                } while (dia == 0);

                LocalDate dataInicio = LocalDate.of(ano, mes, dia);
                ano = 0;
                dia = 0;
                mes = 0;
                do {
                    try {
                        System.out.println("Digite o ano de fim da atividade:");
                        ano = input.nextInt();
                        input.nextLine();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Voce digitou caracteres!");
                    }
                    input.nextLine();
                } while (ano == 0);

                do {
                    try {
                        System.out.println("Digite o mes de fim da atividade:");
                        mes = input.nextInt();
                        input.nextLine();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Voce digitou caracteres!");
                    }
                    input.nextLine();
                } while (mes == 0);

                do {
                    try {
                        System.out.println("Digite o dia de fim da atividade:");
                        dia = input.nextInt();
                        input.nextLine();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Voce digitou caracteres!");
                    }
                    input.nextLine();
                } while (dia == 0);

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
                int ano = 0;
                int dia = 0;
                int mes = 0;
                do {
                    try {
                        System.out.println("Digite o ano de inicio da atividade:");
                        ano = input.nextInt();
                        input.nextLine();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Voce digitou caracteres!");
                    }
                    input.nextLine();
                } while (ano == 0);

                do {
                    try {
                        System.out.println("Digite o mes de inicio da atividade:");
                        mes = input.nextInt();
                        input.nextLine();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Voce digitou caracteres!");
                    }
                    input.nextLine();
                } while (mes == 0);

                do {
                    try {
                        System.out.println("Digite o dia de inicio da atividade:");
                        dia = input.nextInt();
                        input.nextLine();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Voce digitou caracteres!");
                    }
                    input.nextLine();
                } while (dia == 0);

                LocalDate novaData = LocalDate.of(ano, mes, dia);
                if(projeto.editarDataInicio(novaData)){
                    System.out.println("Data de inicio alterada");
                }else{
                    System.out.println("Data de inicio errada! A data que voce inseriu ja passou!");
                }
                return;
            }
        }
        System.out.println("Projeto nao encontrado!");
    }

    public void alterarDataFim(){
        System.out.println("Digite o ID do projeto que voce quer alterar a data de inicio:");
        String id = input.nextLine();

        for (Projeto projeto : projetos) {
            if (projeto.getId().toString().equals(id)){
                int ano = 0;
                int dia = 0;
                int mes = 0;
                do {
                    try {
                        System.out.println("Digite o ano de fim da atividade:");
                        ano = input.nextInt();
                        input.nextLine();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Voce digitou caracteres!");
                    }
                    input.nextLine();
                } while (ano == 0);

                do {
                    try {
                        System.out.println("Digite o mes de fim da atividade:");
                        mes = input.nextInt();
                        input.nextLine();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Voce digitou caracteres!");
                    }
                    input.nextLine();
                } while (mes == 0);

                do {
                    try {
                        System.out.println("Digite o dia de fim da atividade:");
                        dia = input.nextInt();
                        input.nextLine();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Voce digitou caracteres!");
                    }
                    input.nextLine();
                } while (dia == 0);

                LocalDate novaData = LocalDate.of(ano, mes, dia);
                if(projeto.editarDataFim(novaData)){
                    System.out.println("Data de inicio alterada");
                }else{
                    System.out.println("Data de fim errada! A data que voce inseriu ja passou!");
                }
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

                int valor = -1;
                do {
                    try {
                        System.out.println("Digite o valor da nova bolsa:");
                        valor = input.nextInt();
                        input.nextLine();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Erro! Valor negativo nao pode ser inserido!");
                    }
                } while (valor < 0);
                
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
                    int opcao = 0;
                    do {
                        try {
                            System.out.println("--SELECIONE UM DOS STATUS--");
                            System.out.println("1 - Iniciado");
                            System.out.println("2 - Em Andamento");
                            System.out.println("3 - Concluido");
                            System.out.println("Digite sua opcao:");
                            opcao = input.nextInt();
                            input.nextLine();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Voce digitou caracteres!");
                        }
                        input.nextLine();
                    } while (opcao == 0);

                    if(opcao == 1){
                        if(projeto.iniciarProjeto()){
                            System.out.println("Projeto iniciado");
                        }else{
                            System.out.println("Projeto nao pode ser iniciado! Faltam as informacoes basicas do mesmo!");
                            return;
                        }
                    }else if(opcao == 2){
                        if(projeto.projetoEmAndamento()){
                            System.out.println("Projeto em andamento");
                        }else{
                            System.out.println("Projeto nao pode entrar em andamento!\nO projeto nao esta nem iniciado! Faltam as informacoes basicas do mesmo!");
                            return;
                        }
                    }else{
                        if(projeto.concluir()){
                            System.out.println("Projeto concluido");
                        }else{
                            System.out.println("Projeto nao pode ser concluido! O projeto nao esta em andamento!");
                            return;
                        }
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

    public void removeUsuarioEmProjeto() {        
        System.out.println("REMOCAO DE USUARIO EM PROJETO\n");
        System.out.println("Digite o ID do projeto do usuario que voce quer remover de um projeto:");
        String id = input.nextLine();
        for (Projeto projeto : projetos) {
            if(projeto.getId().toString().equals(id)){
                System.out.println("Digite o email do usuario a remover: ");
                String email = input.nextLine();
                if(email.equals(usuarioLogado.getEmail())){
                    System.out.println("NAO EH POSSIVEL REMOVER UM USUARIO LOGADO\n");            
                    return;
                }
                
                for (Usuario usuario : projeto.getUsuarios()) {
                    if(usuario.getEmail().equals(email)){
                        projeto.removeUsuario(usuario);
                        System.out.println("Usuario removido do projeto...\n");
                        return;
                    }
                }
                System.out.println("Usuario nao encontrado...\n");
                return;
            }
        }    
        System.out.println("Projeto nao encontrado...\n");
        return;
    }

    public void removeProfissionalEmProjeto() {        
        System.out.println("REMOCAO DE PROFISSIONAL EM PROJETO\n");
        System.out.println("Digite o ID do projeto do profissional que voce quer remover de um projeto:");
        String id = input.nextLine();
        for (Projeto projeto : projetos) {
            if(projeto.getId().toString().equals(id)){
                System.out.println("Digite o email do profissional a remover: ");
                String email = input.nextLine();
                
                for (Usuario usuario : projeto.getProfissionais()) {
                    if(usuario.getEmail().equals(email)){
                        projeto.removeProfissional(usuario);
                        System.out.println("Profissional removido do projeto...\n");
                        return;
                    }
                }
                System.out.println("Profissional nao encontrado...\n");
                return;
            }
        }    
        System.out.println("Projeto nao encontrado...\n");
        return;
    }
    
    public void removeAtividadeEmProjeto() {        
        System.out.println("REMOCAO DE ATIVIDADE EM PROJETO\n");
        System.out.println("Digite o ID do projeto da atividade que voce quer remover:");
        String id = input.nextLine();
        for (Projeto projeto : projetos) {
            if(projeto.getId().toString().equals(id)){
                System.out.println("Digite o ID da atividade a remover: ");
                id = input.nextLine();
                
                for (Atividade atividade : projeto.getAtividades()) {
                    if(atividade.getId().toString().equals(id)){
                        projeto.removeAtividade(atividade);
                        System.out.println("Atividade removida do projeto...\n");
                        return;
                    }
                }
                System.out.println("Atividade nao encontrada...\n");
                return;
            }
        }    
        System.out.println("Projeto nao encontrado...\n");
        return;
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
