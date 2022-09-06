import java.util.LinkedList;
import java.time.*;
import java.util.UUID;

public class Projeto{
    private LinkedList<Usuario> usuarios = new LinkedList<Usuario>() ;                  //ok
    private UUID id;                                                                     //ok
    private String descricao;                                                           //ok
    private LocalDateTime dHInicio;                                                     //ok
    private LocalDateTime dHFim;                                                        //ok
    private Usuario coordenador;                                                        //ok
    private LinkedList<Usuario> profissionais = new LinkedList<Usuario>();              //ok
    private LinkedList<Atividade> atividades = new LinkedList<Atividade>();             //ok
    private LinkedList<Bolsa> valoresBolsas = new LinkedList<Bolsa>();                  //ok
    private LinkedList<Usuario> requisitantes = new LinkedList<Usuario>();
    private Period periodoVigencia;                                                     //ok
    private Status status;                                                              //ok

    //Construtor
    public Projeto(String descricao, Usuario coordenador, LocalDateTime dHIni, LocalDateTime dHFim,
                   Usuario profissional, Atividade atividade, Bolsa bolsa, Period periodo){
        
        Status status = Status.EM_PROCESSO_DE_CRIACAO;
        this.id = UUID.randomUUID();
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
    
//  {--------------Inserções--------------------
    public void addUsuario(Usuario usuario){
        this.usuarios.add(usuario);
        if (usuario.getTipo() != Tipo.GRADUANDO && usuario.getTipo() != Tipo.MESTRANDO && usuario.getTipo() != Tipo.DOUTORANDO && usuario.getTipo() != Tipo.PROFESSOR){
            addProfissional(usuario);
        }
    }

    public void addProfissional(Usuario profissional){
        this.profissionais.add(profissional);
    }

    public void addAtividade(Atividade atividade){
        this.atividades.add(atividade);
    }

    public void addBolsa(Bolsa bolsa){
        this.valoresBolsas.add(bolsa);
    }

    public void addRequisitante(Usuario usuario){
        this.requisitantes.add(usuario);
    }
//  ---------------Inserções-------------------}

//  {---------------Remoções--------------------
    public void removeProfissional(Usuario profissional) {
    	this.profissionais.remove(profissional);
    }
//  ----------------Remoções-------------------}

//  {---------------Edições---------------------
    public void editarUsuario(Usuario usuarioAtual, Usuario novoUsuario){
        this.usuarios.remove(usuarioAtual);
        this.usuarios.add(novoUsuario);
    }

    public void editarDescricao(String novaDescricao){
        this.descricao.replace(this.descricao, novaDescricao);
    }

    public void editarDataInicio(LocalDateTime novaData){
        LocalDateTime agora = LocalDateTime.now();

        if(this.dHInicio.isAfter(agora)){
            this.dHInicio = novaData;
        }
    }

    public void editarDataFim(LocalDateTime novaData){
        LocalDateTime agora = LocalDateTime.now();

        if(novaData.isAfter(agora)){
            this.dHFim = novaData;
        }
    }

    public void editarCoordenador(Usuario novoCoordenador){
        this.coordenador = novoCoordenador;
    }

    public void editarProfissional(Usuario profissionalAtual, Usuario novoProfisional){
        this.profissionais.remove(profissionalAtual);
        this.profissionais.add(novoProfisional);
    }

    public void editarAtividade(Atividade atvAtual, Atividade novaAtv){
        this.atividades.remove(atvAtual);
        this.atividades.add(novaAtv);
    }

    public void editarBolsa(Bolsa bolsaAtual, Bolsa novaBolsa){
        this.valoresBolsas.remove(bolsaAtual);
        this.valoresBolsas.add(novaBolsa);
    }

    public void editarStatus(Status novoStatus){
        this.status = novoStatus;
    }
//  ----------------Edições--------------------}

//  {--------------Consultas--------------------
    //private 



//  ---------------Consultas-------------------}

//  {-------------Intercâmbio-------------------
    public void intercambio(Projeto projeto, Usuario usuario, Atividade atividade){
        if(this.usuarios.contains(usuario)){
            int index = projeto.atividades.indexOf(atividade);
            projeto.atividades.get(index).addProfissional(usuario);
        }
    }
//  --------------Intercâmbio------------------}

//  {---------------Getters---------------------
    public UUID getId(){ return id; }

    public String getDescricao(){ return descricao; }

    public LocalDateTime getDataInicio(){ return dHInicio; }

    public LocalDateTime getDataFim(){ return dHFim; }

    public Usuario getCoordenador(){ return coordenador; }

    public Period getVigencia(){ return periodoVigencia; }

    public Status getStatus(){ return status; }
//  ----------------Getters--------------------}
}