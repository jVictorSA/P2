import java.util.InputMismatchException;
import java.util.Scanner;

public class Main{

    public static void menu(){
        
    }
    public static void main(String[] args){
        Sistema sistema = new Sistema();
        boolean login = true;
        boolean menu = true;
        Scanner input = new Scanner(System.in);
        
        do {
            try {
                System.out.println("---------------LOGIN---------------");
                System.out.println("Digite 1 para logar no sistema");
                System.out.println("Digite 2 para se cadastras no sistema");
                System.out.println("Digite 3 para se recuperar senha do sistema");
                System.out.println("Digite 4 para sair");
                    int opcao = input.nextInt();
                    if(opcao == 1){
                        if(sistema.Logar()){ 
                            login = false; 
                        }
                    }else if(opcao == 2){
                        sistema.addUsuario();
                    }else if(opcao == 3){
                        sistema.recuperarSenha();
                    }else{
                        login = false;
                    }                    
            } catch (InputMismatchException e) {
                System.out.println("Voce digitou caracteres! Digite um numero dentre as opcoes:");
                input.nextLine();
            }
        } while (login);        
        
        do{
            try {
                System.out.println("---------------MENU---------------");
                System.out.println("Digite 01 para adicionar usuario no sistema");
                System.out.println("Digite 02 para remover usuario do sistema");
                System.out.println("Digite 03 para adicionar projeto no sistema");
                System.out.println("Digite 04 para remover projeto do sistema");
                System.out.println("Digite 05 para adicionar atividade em projeto");
                 
                System.out.println("Digite 06 para adicionar usuario em projeto");
                System.out.println("Digite 07 para adicionar data de inicio em projeto");
                System.out.println("Digite 08 para adicionar data de fim em projeto");
                System.out.println("Digite 09 para adicionar profissional em projeto");
                System.out.println("Digite 10 para adicionar bolsa em projeto");
                System.out.println("Digite 11 para adicionar requisitante em projeto");
                System.out.println("Digite 12 para adicionar requisitante em atividade");
                System.out.println("Digite 13 para remover usuario de um projeto");
                System.out.println("Digite 14 para remover profissional de um projeto");
                System.out.println("Digite 15 para remover atividade de um projeto");

                System.out.println("Digite 16 para remover atividade de projeto");
                System.out.println("Digite 17 para alterar usuario em projeto");
                System.out.println("Digite 18 para editar descricao de projeto");
                System.out.println("Digite 19 para editar de inicio de projeto");
                System.out.println("Digite 20 para editar data de fim de projeto");
                System.out.println("Digite 21 para editar coordenadador de projeto");
                System.out.println("Digite 22 para alterar profissional de projeto");
                System.out.println("Digite 23 para alterar atividade de projeto");
                System.out.println("Digite 24 para alterar bolsa de projeto");
                System.out.println("Digite 25 para editar status de projeto");
                System.out.println("Digite 26 para consultar um projeto que um usuario especifico participa");
                System.out.println("Digite 27 para consultar uma atividade que um usuario especifico realiza");
                System.out.println("Digite 28 para consultar os usuarios participantes de um projeto");
                System.out.println("Digite 29 para consultar as atividades ativas de um projeto");
                System.out.println("Digite 30 para consultar um projeto a partir de uma atividade especifica");
                System.out.println("Digite 31 para consultar os usuarios designados pra uma atividade");
                System.out.println("Digite 32 para receber relatorios dos projetos");
                System.out.println("Digite 33 para realizar intercambio de usuarios entre projetos");
                System.out.println("Digite 34 para pagar bolsas dos usuarios bolsistas");
                System.out.println("Digite 35 para deslogar do sistema");
                int opcao = input.nextInt();
                
                if(opcao == 1){
                    sistema.addUsuario();
                }else if(opcao == 2){
                    sistema.removeUsuario();
                }else if(opcao == 3){
                    sistema.addProjeto();
                }else if(opcao == 4){
                    sistema.removeProjeto();
                }else if(opcao == 5){
                    sistema.addAtividade();
                }else if(opcao == 6){
                    sistema.addUsuarioEmProjeto();
                }else if(opcao == 7){
                    sistema.addDataInicioEmProjeto();
                }else if(opcao == 8){
                    sistema.addDataFimoEmProjeto();
                }else if(opcao == 9){
                    sistema.addProfisionalEmProjeto();
                }else if(opcao == 10){
                    sistema.addBolsaEmProjeto();
                }else if(opcao == 11){
                    sistema.addRequisitanteEmProjeto();
                }else if(opcao == 12){
                    sistema.addRequisitanteEmAtividade();
                }else if(opcao == 13){
                    sistema.removeUsuarioEmProjeto();
                }else if(opcao == 14){
                    sistema.removeProfissionalEmProjeto();
                }else if(opcao == 15){
                    sistema.removeAtividadeEmProjeto();
                }else if(opcao == 16){
                    sistema.removeAtividade();
                }else if(opcao == 17){
                    sistema.alterarUsuario();
                }else if(opcao == 18){
                    sistema.alterarDescricao();
                }else if(opcao == 19){
                    sistema.alterarDataInicio();
                }else if(opcao == 20){
                    sistema.alterarDataFim();
                }else if(opcao == 21){
                    sistema.alterarCoordenador();
                }else if(opcao == 22){
                    sistema.alterarProfissional();
                }else if(opcao == 23){
                    sistema.alterarAtividade();
                }else if(opcao == 24){
                    sistema.alterarBolsa();
                }else if(opcao == 25){
                    sistema.editarStatus();
                }else if(opcao == 26){
                    sistema.consultarProjetoPorUsuario();
                }else if(opcao == 27){
                    sistema.consultarAtividadePorUsuario();
                }else if(opcao == 28){
                    sistema.consultarUsuariosPorProjeto();
                }else if(opcao == 29){
                    sistema.consultarAtividadePorProjeto();
                }else if(opcao == 30){
                    sistema.consultarProjetoPorAtividade();
                }else if(opcao == 31){
                    sistema.consultarUsuariosPorAtividade();
                }else if(opcao == 32){
                    sistema.relatorio();
                }else if(opcao == 33){
                    sistema.intercambio();
                }else if(opcao == 34){
                    sistema.pagarBolsas();
                }else if(opcao == 35){
                    sistema.deslogar();
                    input.close();
                    menu = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Voce digitou caracteres! Digite um numero dentre as opcoes:");
                input.nextLine();
            }

        } while (menu);        
            

        input.close();
    }
}