public class Bolsa{
	private double valorBolsa;
	private Aluno recebedor;
	
	//Construtor
	public Bolsa(double valor, Aluno recebedor) {
		this.recebedor = recebedor;
		this.valorBolsa = valor;
	}

	public void printar(){
		System.out.printf("\t---->\t%s\t%lf R$\n", recebedor.getNome(), valorBolsa);
	}

//  {------------------------------------Edições--------------------------------------
	public void editarValorBolsa(double novoValor){
		if(novoValor >= 0){
			this.valorBolsa = novoValor;
		}
	}

	public void editarRecebedor(Aluno novoRecebedor){
		this.recebedor = novoRecebedor;
	}
//  -------------------------------------Edições-------------------------------------}

//  {-----------------------------------Pagamento-------------------------------------
	public void pagar(){
		recebedor.receberBolsa(valorBolsa);
	}
//  ------------------------------------Pagamento------------------------------------}

//  {-----------------------------------Getters---------------------------------------
	public double getValorBolsa(){
		return valorBolsa;
	}

	public Usuario getRecebedor(){
		return recebedor;
	}
//  ------------------------------------Getters--------------------------------------}
}