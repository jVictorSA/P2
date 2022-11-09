import java.util.LinkedList;
import java.time.*;
import java.util.UUID;
import java.util.Optional;

public class Projeto{
    private LinkedList<Usuario> usuarios = new LinkedList<Usuario>() ;                  //ok
    private UUID id;                                                                    //ok
    private Optional<String> descricao;                                                 //ok
    private Optional<LocalDate> dHInicio;                                           //ok
    private Optional<LocalDate> dHFim;                                              //ok
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
        if(usuarios == null || (usuarios.size() == 0)){
            System.out.println("\tNao ha alunos cadastrados!");
        }else{
            for (Usuario usuario : usuarios){
                usuario.printar();
            }
        }
        if(dHInicio == null){
            System.out.println("\tData de inicio nao inserida!");
        }else{
            System.out.println("\tData de inicio: " + dHInicio.get().toString());
        }
        if(dHFim == null){
            System.out.println("\tData de inicio nao inserida!");
        }else{
            System.out.println("\tData de termino: " + dHFim.get().toString());
        }
        System.out.println("\tProfissionais envolvidos: ");
        if(profissionais == null || profissionais.size() == 0){
            System.out.println("\tNao ha profissionais cadastrados!");            
        }else{
            for (Usuario profissional : profissionais){
                profissional.printar();
            }
        }
        System.out.println("\tAtividades:");
        if(atividades == null || atividades.size() == 0){            
            System.out.println("\tNao ha atividades cadastradas!");
        }else{
            for (Atividade atividade : atividades){
                atividade.relatorio();
            }
        }
        System.out.println("\tBolsas do projeto:");
        if(valoresBolsas == null || valoresBolsas.size() == 0){
            System.out.println("\tNao ha bolsas cadastradas!");
        }else{
            for (Bolsa bolsa : valoresBolsas){
                bolsa.printar();
            }
        }
        System.out.println("\tAlunos requisitando entrada no projeto:");
        if(requisitantes == null || requisitantes.size() == 0){
            System.out.println("\tNao ha alunos requisitantes!");
        }else{
            for (Usuario aluno : requisitantes) {
                aluno.printar();
            }
        }
        if(periodoVigencia == null){
            System.out.println("\tPeriodo de vigencia de projeto nao cadastrado!");
        }else{
            System.out.println("\tPeriodo de vigencia do projeto: " + periodoVigencia.get().toString());
        }
        System.out.println("\tStatus do projeto: " + status.toString());
        System.out.println("\n-------------------------------------------------------------------------\n");
    }


    //Construtores
    public Projeto(String descricao, Usuario coordenador){
        Status status = Status.EM_PROCESSO_DE_CRIACAO;
        this.id = UUID.randomUUID();
        this.descricao = Optional.of(descricao);
        this.coordenador = coordenador;
        this.status = status;
    }
    
    
//  {-----------------------------------Inserções-------------------------------------
    public void addUsuario(Usuario usuario){
        this.usuarios.add(usuario);
    }

    public boolean addDataInicio(LocalDate dhInicio){
        if(dhInicio.isAfter(LocalDate.now())){
            this.dHInicio = Optional.of(dhInicio);
            if(dHFim.isPresent()){
                this.addPeriodo();
            }
            return true;
        }else{
            return false;
        }
    }

    public boolean addDataFim(LocalDate dhFim){
        if (dhFim.isAfter(LocalDate.now())) {    
            this.dHFim = Optional.of(dhFim);
            if(dHInicio.isPresent()){
                this.addPeriodo();
            }
            return true;
        } else {
            return false;
        }

    }

    public void addPeriodo(){
        LocalDate inicio = this.dHInicio.get();
        LocalDate fim = this.dHFim.get();
        this.periodoVigencia = Optional.of(Period.between(inicio, fim));
        System.out.println("\nPeriodo de vigencia adicionado");
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
//  ------------------------------------Inserções------------------------------------}

//  {------------------------------------Remoções-------------------------------------
    public void removeProfissional(Usuario profissional) {
    	this.profissionais.remove(profissional);
    }

    public void removeUsuario(Usuario usuario) {
    	this.usuarios.remove(usuario);
    }

    public void removeAtividade(Atividade atividade) {
    	this.atividades.remove(atividade);
    }
//  -------------------------------------Remoções------------------------------------}

//  {------------------------------------Edições--------------------------------------
    public void editarUsuario(Usuario usuarioAtual, Usuario novoUsuario){
        this.usuarios.remove(usuarioAtual);
        this.usuarios.add(novoUsuario);
    }

    public void editarDescricao(String novaDescricao){
        this.descricao.get().replace(this.descricao.get(), novaDescricao);
    }

    public boolean editarDataInicio(LocalDate novaData){
        LocalDate agora = LocalDate.now();

        if(this.dHInicio.get().isAfter(agora)){
            this.dHInicio = Optional.of(novaData);
            return true;
        }
        return false;
    }

    public boolean editarDataFim(LocalDate novaData){
        LocalDate agora = LocalDate.now();

        if(novaData.isAfter(agora)){
            this.dHFim = Optional.of(novaData);
            return true;
        }
        return false;
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

    public boolean iniciarProjeto(){
        if(informacoesAdicionadas()){
            this.status = Status.INICIADO;
            return true;
        }
        return false;
    }
//  -------------------------------------Edições-------------------------------------}

//  {------------------------------------Status---------------------------------------

    public boolean projetoEmAndamento(){
        if(this.status == Status.INICIADO){
            this.status = Status.EM_ANDAMENTO;
            return true;
        }
        return false;
    }

    public boolean concluir(){
        if(this.status == Status.EM_ANDAMENTO){
            this.status = Status.CONCLUIDO;
            return true;
        }
        return false;
    }

    public boolean informacoesAdicionadas(){
        if(!usuarios.isEmpty() && descricao.isPresent() && dHInicio.isPresent() && dHFim.isPresent() &&
           !profissionais.isEmpty() && !atividades.isEmpty() && !valoresBolsas.isEmpty() &&
           !requisitantes.isEmpty() && periodoVigencia.isPresent())
           { return true; }

        return false;
    }
//  -------------------------------------Status--------------------------------------}

//  {---------------------------------Intercâmbio-------------------------------------
    public void intercambio(Projeto projeto, Usuario usuario, Atividade atividade){
        if(this.usuarios.contains(usuario)){
            int index = projeto.atividades.indexOf(atividade);
            projeto.atividades.get(index).addProfissional(usuario);
        }
    }
//  ----------------------------------Intercâmbio------------------------------------}

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

    public LocalDate getDataInicio(){ return dHInicio.get(); }

    public LocalDate getDataFim(){ return dHFim.get(); }

    public Usuario getCoordenador(){ return coordenador; }

    public LinkedList<Usuario> getProfissionais(){ return profissionais; }

    public LinkedList<Atividade> getAtividades(){ return atividades; }

    public LinkedList<Bolsa> getBolsas(){ return valoresBolsas; }

    public LinkedList<Usuario> getRequisitantes(){ return requisitantes; }

    public Period getVigencia(){ return periodoVigencia.get(); }

    public Status getStatus(){ return status; }
//  ------------------------------------Getters--------------------------------------}
}