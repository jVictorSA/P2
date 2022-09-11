import java.time.*;

public class Main{
    public static void main(String[] args){
        Usuario user1 = new Usuario("Robson", Tipo.GRADUANDO, "rb.gmail.com", "ij9a0o");
        Usuario user2 = new Usuario("Alessa", Tipo.DOUTORANDO, "alessasilenthill@hotmail.com", "9u2saac");
        Usuario user3 = new Usuario("Menezes", Tipo.PROFESSOR, "menezes@ufal.edu", "hsaiu021");
        Usuario user4 = new Usuario("Julia", Tipo.DEV, "juju87@gmail.com", "j81239la");
        Usuario user5 = new Usuario("Epaminondas", Tipo.TECNICO, "vieira.epaminondas@uol.com", "9iuesadsc");
        Usuario user6 = new Usuario("Nicole", Tipo.ANALISTA, "nicoleramos@outlook.com", "l921_sac");
        Usuario user7 = new Usuario("Gabriel", Tipo.TESTADOR, "gabrieldasnovinhas69@hotmail.com", "j821uraca");
        Usuario user8 = new Usuario("Carlos", Tipo.PROFESSOR, "carlos.alberto@gmail.com", "y47-cal_1");
        
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

        System.out.printf("%s e %s",user1.getNome(), user1.getTipo());

        Projeto projeto = new Projeto("Projeto de manipulacao de variaveis", user3);
        projeto.addProfissional(user4);
        projeto.addDataInicio(inicio);
        projeto.addDataFim(fim);
        projeto.addProfissional(user7);
        projeto.addAtividade(atividade);
        projeto.addBolsa(bolsa);
        projeto.addUsuario(user1);
        projeto.addProfissional(user6);
        projeto.removeProfissional(user6);
    }
}