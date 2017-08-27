package objects;

public class classecliente {

	/**
	 * Atributos da classe
	 */
	
	private String cpf;
	private String nome;
	private String endereco;
	
	public classecliente (String cpf, String nome){
		this.cpf = cpf;
		this.nome = nome;
				
	} 
	
	public classecliente (String cpf, String nome, String endereco){
		this.cpf = cpf;
		this.nome = nome;
		this.endereco = endereco;
	}


	/**
	 * Construtores 
	 */

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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	

	/**
	 * equals
	 */

	@Override
	public boolean equals(Object obj) {
	
		classecliente other = (classecliente) obj;
	    if (!cpf.equals(other.cpf)){
			return false;
		} else if (!endereco.equals(other.endereco)){
			return false;
		} else if (!nome.equals(other.nome)){
			return false;
		}
		return true;
	}

	
	
	@Override
	public String toString() {
		return "NOME=" + nome + "\n CPF=" + cpf + "\n endereco=" + endereco + "";
	}


	
}
