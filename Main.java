import java.util.Scanner;

public class Main{

    public static void menu(){
        
    }
    public static void main(String[] args){
        Sistema sistema = new Sistema();
        boolean login = true;
        boolean menu = true;
        Scanner input = new Scanner(System.in);
        while(login){
            //input.nextInt();
            System.out.println("---------------LOGIN---------------");
            System.out.println("Digite 1 para logar no sistema");
            System.out.println("Digite 2 para se cadastras no sistema");
            System.out.println("Digite 3 para se recuperar senha do sistema");
            System.out.println("Digite 4 para sair");
            //while(input.hasNextInt()){
                int opcao = Integer.parseInt(input.nextLine());
                if(opcao == 1){
                    //input.nextLine();
                    if(sistema.Logar()){ 
                        System.out.println("OI");
                        login = false; 
                    }
                }else if(opcao == 2){
                    sistema.addUsuario();
                    //login = false;
                }else if(opcao == 3){
                    sistema.recuperarSenha();
                }else{
                    login = false;
              //  }
                
            }
            System.out.println("OIe");
        }
        
        
        while(menu){
            System.out.println("---------------MENU---------------");
            System.out.println("Digite 01 para adicionar usuario no sistema");
            System.out.println("Digite 02 para remover usuario do sistema");
            System.out.println("Digite 03 para adicionar projeto no sistema");
            System.out.println("Digite 04 para remover projeto do sistema");
            System.out.println("Digite 05 para adicionar atividade em projeto");
            System.out.println("Digite 06 para remover atividade de projeto");
            System.out.println("Digite 07 para alterar usuario em projeto");
            System.out.println("Digite 08 para editar descricao de projeto");
            System.out.println("Digite 09 para editar de inicio de projeto");
            System.out.println("Digite 10 para editar data de fim de projeto");
            System.out.println("Digite 11 para editar coordenadador de projeto");
            System.out.println("Digite 12 para alterar profissional de projeto");
            System.out.println("Digite 13 para alterar atividade de projeto");
            System.out.println("Digite 14 para alterar bolsa de projeto");
            System.out.println("Digite 15 para editar status de projeto");
            System.out.println("Digite 16 para consultar um projeto que um usuario especifico participa");
            System.out.println("Digite 17 para consultar uma atividade que um usuario especifico realiza");
            System.out.println("Digite 18 para consultar os usuarios participantes de um projeto");
            System.out.println("Digite 19 para consultar as atividades ativas de um projeto");
            System.out.println("Digite 20 para consultar um projeto a partir de uma atividade especifica");
            System.out.println("Digite 21 para consultar os usuarios designados pra uma atividade");
            System.out.println("Digite 22 para receber relatorios dos projetos");
            System.out.println("Digite 23 para realizar intercambio de usuarios entre projetos");
            System.out.println("Digite 24 para pagar bolsas dos usuarios bolsistas");
            System.out.println("Digite 25 para deslogar do sistema");
            //Scanner input = new Scanner(System.in);
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
                sistema.removeAtividade();
            }else if(opcao == 7){
                sistema.alterarUsuario();
            }else if(opcao == 8){
                sistema.alterarDescricao();
            }else if(opcao == 9){
                sistema.alterarDataInicio();
            }else if(opcao == 10){
                sistema.alterarDataFim();
            }else if(opcao == 11){
                sistema.alterarCoordenador();
            }else if(opcao == 12){
                sistema.alterarProfissional();
            }else if(opcao == 13){
                sistema.alterarAtividade();
            }else if(opcao == 14){
                sistema.alterarBolsa();
            }else if(opcao == 15){
                sistema.editarStatus();
            }else if(opcao == 16){
                sistema.consultarProjetoPorUsuario();
            }else if(opcao == 17){
                sistema.consultarAtividadePorUsuario();
            }else if(opcao == 18){
                sistema.consultarUsuariosPorProjeto();
            }else if(opcao == 19){
                sistema.consultarAtividadePorProjeto();
            }else if(opcao == 20){
                sistema.consultarProjetoPorAtividade();
            }else if(opcao == 21){
                sistema.consultarUsuariosPorAtividade();
            }else if(opcao == 22){
                sistema.relatorio();
            }else if(opcao == 23){
                sistema.intercambio();
            }else if(opcao == 24){
                sistema.pagarBolsas();
            }else if(opcao == 25){
                sistema.deslogar();
                input.close();
                menu = false;
            }

        }
        input.close();
    }
}