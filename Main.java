package P2;
import java.time.*;

public class Main{
    public static void main(String[] args){
        Usuario user1 = new Usuario("Robson", Tipo.GRADUANDO);
        Usuario user2 = new Usuario("Alissa", Tipo.DOUTORANDO);
        Usuario user3 = new Usuario("Menezes", Tipo.PROFESSOR);
        Usuario user4 = new Usuario("Julia", Tipo.DEV);
        Usuario user5 = new Usuario("Epaminondas", Tipo.TECNICO);
        Usuario user6 = new Usuario("Nicole", Tipo.ANALISTA);
        Usuario user7 = new Usuario("Gabriel", Tipo.TESTADOR);
        Usuario user8 = new Usuario("Carlos", Tipo.PROFESSOR);
        
        LocalDate data = LocalDate.of(2022, 8, 01);
        LocalTime hora = LocalTime.of(9, 30);
        LocalDateTime inicio = LocalDateTime.of(data, hora);
        LocalDate data2 = LocalDate.of(2023, 5, 15);
        LocalTime hora2 = LocalTime.of(23, 59);
        LocalDateTime fim = LocalDateTime.of(data2, hora2);
        LocalDate data3 = LocalDate.of(2022, 8, 02);
        LocalTime hora3 = LocalTime.of(7, 0);
        LocalDateTime inicioAtv = LocalDateTime.of(data3, hora3);
        LocalDate data4 = LocalDate.of(2022, 10, 03);
        LocalTime hora4 = LocalTime.of(23, 59);
        LocalDateTime fimAtv = LocalDateTime.of(data4, hora4);

        Atividade atividade = new Atividade("Efetuar pesquisa exploratória", user1, inicioAtv , fimAtv);

        Bolsa bolsa = new Bolsa(200, user1);

        Period periodo = Period.between(data, data2);

        System.out.printf("%s e %s",user1.nome, user1.tipo);

        Projeto projeto = new Projeto(1, "Projeto de manipulacao de variaveis", user3, inicio, fim, user7, atividade, bolsa, periodo);
        projeto.addProfissional(user4);
        projeto.addUsuario(user1);
        projeto.addProfissional(user6);
        projeto.removeProfissional(user6);
    }
}