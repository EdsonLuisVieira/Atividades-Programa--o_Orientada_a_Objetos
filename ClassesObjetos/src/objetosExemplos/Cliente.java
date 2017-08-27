package objetosExemplos;

public class Cliente {
	
	/**
	 * Atributos da classe
	 */
	
	private String cpf;
	private String nome;
	private Endereço endereco;
	
	public Cliente(String cpf, String nome) {
		this.cpf = cpf;
		this.nome = nome;
	}

	public Cliente(String cpf, String nome, Endereço endereco) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.endereco = endereco;
	}
	
	public Cliente(String cpf, String rua, int numero, String cep, String bairro){
		this.cpf = cpf;
		this.endereco = new EndereÃ§o(rua, numero, cep, bairro);
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

	public Endereço getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereço endereco) {
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
	
	