public class Bolsa{
	double valorBolsa;
	Usuario recebedor;
	
	//Construtor
	public Bolsa(double valor, Usuario recebedor) {
		this.recebedor = recebedor;
		this.valorBolsa = valor;
	}

//  {------------------------------------Edições--------------------------------------
	public void editarValorBolsa(double novoValor){
		if(novoValor >= 0){
			this.valorBolsa = novoValor;
		}
	}

	public void editarRecebedor(Usuario novoRecebedor){
		this.recebedor = novoRecebedor;
	}
//  -------------------------------------Edições-------------------------------------}

//  {-----------------------------------Getters---------------------------------------
	public double getValorBolsa(){
		return valorBolsa;
	}

	public Usuario getRecebedor(){
		return recebedor;
	}
//  ------------------------------------Getters--------------------------------------}
}