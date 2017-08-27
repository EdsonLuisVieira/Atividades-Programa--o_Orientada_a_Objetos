package server;

import java.util.StringTokenizer;

public class responsavel {

	/**
	 * Atributos da classe
	 */
	private String cpf;
	private String nome;
	private String funcao;

	/**
	 * construtores
	 * @param cpf
	 */

	public responsavel(String cpf) {
		this.cpf = cpf;
	}
	
	public responsavel(String nome, String funcao) {
		this.nome = nome;
	}
	
	public responsavel(String cpf, String nome, String funcao){
		this.cpf = cpf;
		this.nome = nome;
		this.funcao = funcao;
	} 
	
	/**
	 *  Sets da classe 
	 */
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public void setNome(String nome, String funcao) {
		this.nome = nome;
	}
	
	public void set_Tudo(String cpf, String nome, String funcao){
		this.cpf = cpf;
		this.nome = nome;
		this.funcao = funcao;
	} 
	
	/**
	 *  Gets da clasee
	 */
	
	public String getCpf() {
		return cpf;
	}
	
	public String getNome() {
		String x =ajusta_Nome();
		return x;
	}
	
	public String getFuncao() {
		return funcao;
	}
	
	
	/**
	 * Metodo toString
	 */
	
	public String toString() {
		String aux_nome =ajusta_Nome();
		return "\n------Responsavel------ \n\t Nome: " +aux_nome + "\n\t CPF: " +cpf  + "\n\t Função:" + funcao ;
	}

	
	/**
	 * Metodo Equals
	 */
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		responsavel other = (responsavel) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (funcao == null) {
			if (other.funcao != null)
				return false;
		} else if (!funcao.equals(other.funcao))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	/**
	 * Função que ajusta o nome parao formato Sobrenome,Nome 
	 * 
	 * @return retorna o nome de forma ajustada
	 */
	
	public String ajusta_Nome(){
	
		String aux1 = null;
	    StringTokenizer pri_palavra = new StringTokenizer(nome," ");
	    while(pri_palavra.hasMoreTokens()){
	        aux1 = pri_palavra.nextToken();
	    }
	    String tes=nome.replace(aux1,"");
	    String ajuste =aux1.concat(", "+tes);
		return ajuste;
	}

}
