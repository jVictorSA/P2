import java.util.LinkedList;
import java.time.*;
import java.util.UUID;
import java.util.Optional;

public class Projeto{
    private LinkedList<Usuario> usuarios = new LinkedList<Usuario>() ;                  //ok
    private UUID id;                                                                    //ok
    private Optional<String> descricao;                                                 //ok
    private Optional<LocalDateTime> dHInicio;                                           //ok
    private Optional<LocalDateTime> dHFim;                                              //ok
    private Usuario coordenador;                                                        //ok
    private LinkedList<Usuario> profissionais = new LinkedList<Usuario>();              //ok
    private LinkedList<Atividade> atividades = new LinkedList<Atividade>();             //ok
    private LinkedList<Bolsa> valoresBolsas = new LinkedList<Bolsa>();                  //ok
    private LinkedList<Usuario> requisitantes = new LinkedList<Usuario>();              //ok
    private Optional<Period> periodoVigencia;                                           //ok
    private Status status;                                                              //ok

    public void relatorio(){
        System.out.println("Projeto: " + id.toString());
        System.out.println("\tCoordenador: " + coordenador.getNome());
        System.out.println("\tDescricao: " + descricao.get());
        System.out.println("\tAlunos:");
        for (Usuario usuario : usuarios){
            usuario.printar();
        }
        System.out.println("\tData de inicio: " + dHInicio.get().toString());
        System.out.println("\tData de termino: " + dHFim.get().toString());
        System.out.println("\tProfissionais envolvidos: ");
        for (Usuario profissional : profissionais){
            profissional.printar();
        }
        System.out.println("\tAtividades:");
        for (Atividade atividade : atividades){
            atividade.relatorio();
        }
        System.out.println("\tBolsas do projeto:");
        for (Bolsa bolsa : valoresBolsas){
            bolsa.printar();
        }
        System.out.println("\tAlunos requisitando entrada no projeto:");
        for (Usuario aluno : requisitantes) {
            aluno.printar();
        }
        System.out.println("\tPeriodo de vigencia do projeto: " + periodoVigencia.get().toString());
        System.out.println("\tStatus do projeto: " + status.toString());
        System.out.println("\n-------------------------------------------------------------------------\n");
    }


    //Construtor
    public Projeto(String descricao, Usuario coordenador){
        Status status = Status.EM_PROCESSO_DE_CRIACAO;
        this.id = UUID.randomUUID();
        this.descricao = Optional.of(descricao);
        this.coordenador = coordenador;
        this.status = status;
    }
    
//  {-----------------------------------Inser????es-------------------------------------
    public void addUsuario(Usuario usuario){
        this.usuarios.add(usuario);
        if (usuario.getTipo() != Tipo.GRADUANDO && usuario.getTipo() != Tipo.MESTRANDO && usuario.getTipo() != Tipo.DOUTORANDO && usuario.getTipo() != Tipo.PROFESSOR){
            addProfissional(usuario);
        }
    }

    public void addDataInicio(LocalDateTime dhInicio){
        this.dHInicio = Optional.of(dhInicio);
        if(dHFim.isPresent()){
            this.addPeriodo();
        }
    }

    public void addDataFim(LocalDateTime dhFim){
        this.dHFim = Optional.of(dhFim);
        if(dHInicio.isPresent()){
            this.addPeriodo();
        }
    }

    public void addPeriodo(){
        LocalDate inicio = this.dHInicio.get().toLocalDate();
        LocalDate fim = this.dHFim.get().toLocalDate();
        this.periodoVigencia = Optional.of(Period.between(inicio, fim));
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
//  ------------------------------------Inser????es------------------------------------}

//  {------------------------------------Remo????es-------------------------------------
    public void removeProfissional(Usuario profissional) {
    	this.profissionais.remove(profissional);
    }
//  -------------------------------------Remo????es------------------------------------}

//  {------------------------------------Edi????es--------------------------------------
    public void editarUsuario(Usuario usuarioAtual, Usuario novoUsuario){
        this.usuarios.remove(usuarioAtual);
        this.usuarios.add(novoUsuario);
    }

    public void editarDescricao(String novaDescricao){
        this.descricao.get().replace(this.descricao.get(), novaDescricao);
    }

    public void editarDataInicio(LocalDateTime novaData){
        LocalDateTime agora = LocalDateTime.now();

        if(this.dHInicio.get().isAfter(agora)){
            this.dHInicio = Optional.of(novaData);
        }
    }

    public void editarDataFim(LocalDateTime novaData){
        LocalDateTime agora = LocalDateTime.now();

        if(novaData.isAfter(agora)){
            this.dHFim = Optional.of(novaData);
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
//  -------------------------------------Edi????es-------------------------------------}

//  {------------------------------------Status---------------------------------------
    public boolean informacoesAdicionadas(){
        if(!usuarios.isEmpty() && descricao.isPresent() && dHInicio.isPresent() && dHFim.isPresent() &&
           !profissionais.isEmpty() && !atividades.isEmpty() && !valoresBolsas.isEmpty() &&
           !requisitantes.isEmpty() && periodoVigencia.isPresent())
           { return true; }

        return false;
    }
//  -------------------------------------Status--------------------------------------}

//  {---------------------------------Interc??mbio-------------------------------------
    public void intercambio(Projeto projeto, Usuario usuario, Atividade atividade){
        if(this.usuarios.contains(usuario)){
            int index = projeto.atividades.indexOf(atividade);
            projeto.atividades.get(index).addProfissional(usuario);
        }
    }
//  ----------------------------------Interc??mbio------------------------------------}

//  {------------------------------Pagamento Bolsas-----------------------------------
    public void pagarBolsas(){
        for (Bolsa bolsa : valoresBolsas) {
            bolsa.pagar();
        }
    }

//  -------------------------------Pagamento Bolsas----------------------------------}

//  {-----------------------------------Getters---------------------------------------
    public LinkedList<Usuario> getUsuarios(){ return usuarios; }

    public UUID getId(){ return id; }

    public String getDescricao(){ return descricao.get(); }

    public LocalDateTime getDataInicio(){ return dHInicio.get(); }

    public LocalDateTime getDataFim(){ return dHFim.get(); }

    public Usuario getCoordenador(){ return coordenador; }

    public LinkedList<Usuario> getProfissionais(){ return profissionais; }

    public LinkedList<Atividade> getAtividades(){ return atividades; }

    public LinkedList<Bolsa> getBolsas(){ return valoresBolsas; }

    public LinkedList<Usuario> getRequisitantes(){ return requisitantes; }

    public Period getVigencia(){ return periodoVigencia.get(); }

    public Status getStatus(){ return status; }
//  ------------------------------------Getters--------------------------------------}
}