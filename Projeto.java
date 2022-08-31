package P2;
import java.util.LinkedList;
import java.time.*;

public class Projeto{
    private LinkedList<Usuario> usuarios = new LinkedList<Usuario>() ;                  //ok
    private int id;                                                                     //ok
    private String descricao;                                                           //ok
    private LocalDateTime dHInicio;                                                     //ok
    private LocalDateTime dHFim;                                                        //ok
    private Usuario coordenador;                                                        //ok
    private LinkedList<Usuario> profissionais = new LinkedList<Usuario>();              //ok
    private LinkedList<Atividade> atividades = new LinkedList<Atividade>();             //ok
    private LinkedList<Bolsa> valoresBolsas = new LinkedList<Bolsa>();                  //ok
    private Period periodoVigencia;                                                     //ok
    private Status status;                                                              //ok

    public Projeto(int id, String descricao, Usuario coordenador, LocalDateTime dHIni, LocalDateTime dHFim,
                   Usuario profissional, Atividade atividade, Bolsa bolsa, Period periodo){
        
        Status status = Status.EM_PROCESSO_DE_CRIACAO;
        this.id = id;
        this.descricao = descricao;
        this.dHInicio = dHIni;
        this.dHFim = dHFim;
        this.coordenador = coordenador;
        this.profissionais.add(profissional);
        this.atividades.add(atividade);
        this.valoresBolsas.add(bolsa);
        this.periodoVigencia = periodo ;
        this.status = status;
    }

    public void addUsuario(Usuario usuario){
        this.usuarios.add(usuario);
        if (usuario.tipo != Tipo.GRADUANDO && usuario.tipo != Tipo.MESTRANDO && usuario.tipo != Tipo.DOUTORANDO && usuario.tipo != Tipo.PROFESSOR){
            addProfissional(usuario);
        }
    }

    public void addProfissional(Usuario profissional){
        this.profissionais.add(profissional);
    }
    
    public void removeProfissional(Usuario profissional) {
    	this.profissionais.remove(profissional);
    }

    public void addAtividade(Atividade atividade){
        this.atividades.add(atividade);
    }

    public void addBolsa(Bolsa bolsa){
        this.valoresBolsas.add(bolsa);
    }
}