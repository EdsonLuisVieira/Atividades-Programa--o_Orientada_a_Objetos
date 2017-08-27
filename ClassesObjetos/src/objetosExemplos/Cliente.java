package objetosExemplos;

public class Cliente {
	
	/**
	 * Atributos da classe
	 */
	
	private String cpf;
	private String nome;
	private Endere�o endereco;
	
	public Cliente(String cpf, String nome) {
		this.cpf = cpf;
		this.nome = nome;
	}

	public Cliente(String cpf, String nome, Endere�o endereco) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.endereco = endereco;
	}
	
	public Cliente(String cpf, String rua, int numero, String cep, String bairro){
		this.cpf = cpf;
		this.endereco = new Endereço(rua, numero, cep, bairro);
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endere�o getEndereco() {
		return endereco;
	}

	public void setEndereco(Endere�o endereco) {
		this.endereco = endereco;
	}
	
	public String toString() {
		return "Cliente [cpf=" + cpf + ", nome=" + nome + ", endereco=" + endereco + "]";
	}
	
	public boolean contemString(String c){
		String x = "A casa dos budas ditosos";
		if (x.contains(c)){
			return true;
		}
		return false;
	}


	@Override
	public boolean equals(Object obj) {

		Cliente other = (Cliente) obj;
		
		if (!endereco.equals(other.endereco)){
			return false;
		} else if (!nome.equals(other.nome)){
			return false;
		} else if (!cpf.equals(other.getCpf())){
			return false;
		}
		return true;
	}
	
	public static void main(String[] args){
		Cliente c = new Cliente("333","casa");
		System.out.println(c.contemString("casa"));
	}
	
	
	
	
}
	
	