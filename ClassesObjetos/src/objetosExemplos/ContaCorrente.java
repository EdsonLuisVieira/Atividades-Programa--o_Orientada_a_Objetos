package objetosExemplos;

public class ContaCorrente {
	
	private int número;
	private Cliente correntista;
	private double saldo;
	
	public ContaCorrente(int número, Cliente correntista) {
		super();
		this.número = número;
		this.correntista = correntista;
		this.saldo = 0.0;
	}

	public int getNúmero() {
		return número;
	}

	public void setNúmero(int número) {
		this.número = número;
	}

	public Cliente getCorrentista() {
		return correntista;
	}

	public void setCorrentista(Cliente correntista) {
		this.correntista = correntista;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public void depositar(double valor){
		saldo += valor;
	}
	
	public boolean sacar(double valor){
		if (saldo >= valor){
			saldo-=valor;
			return true;
		}
		return false;
	}
	
	public boolean transferir(ContaCorrente destino, double valor){
		if (this.sacar(valor)){
			destino.depositar(valor);
			return true;
		} 
		return false;
	}

	@Override
	public String toString() {
		return "ContaCorrente [número=" + número + ", correntista=" + correntista + ", saldo=" + saldo + "]";
	}
	
	
	

}
