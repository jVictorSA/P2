package P2;
public class Bolsa{
	double valorMensal;
	Usuario recebedor;
	
	public Bolsa(double valor, Usuario recebedor) {
		this.recebedor = recebedor;
		this.valorMensal = valor;
	}
}