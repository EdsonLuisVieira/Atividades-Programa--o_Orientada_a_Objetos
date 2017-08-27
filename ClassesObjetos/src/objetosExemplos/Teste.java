package objetosExemplos;

public class Teste {

	public static void main(String[] args) {
		
		Cliente c1 = new Cliente("223","José Carlos",new Endereço("Av. Bahia",900,"58000-000","Bairro dos Estados"));
		Endereço eee = c1.getEndereco();
		String rua = eee.getRua();
		System.out.println(rua);
		
		ContaCorrente conta1 = new ContaCorrente(1, c1);
		conta1.depositar(50000);
		ContaCorrente conta2 = new ContaCorrente(2, new Cliente("555","Ana"));
		conta1.transferir(conta2, 10000);
		System.out.println("Dados conta 1"+ conta1);
		
		String rua1 = conta1.getCorrentista().getEndereco().getRua();

	}

}
