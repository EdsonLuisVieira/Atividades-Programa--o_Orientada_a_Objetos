package pkginterface;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class Paciente {

	private String documento;
	private String nome;
	private String sexo;
	private Endereco endereco;
	private LocalDate data_nascimento;

	public Paciente(String nome, String documento, String sexo, Endereco endereco, LocalDate data){
		this.documento=documento;
		this.nome=nome;
		this.sexo=sexo;
		this.endereco=endereco;
		this.data_nascimento=data;
	}
	
	public Paciente(String documento, String nome, String sexo){
		this.documento=documento;
		this.nome=nome;
		this.sexo=sexo;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNome() {
		return nomeAjustado(nome);
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public LocalDate getData() {
		return data_nascimento;
	}

	public void setData(LocalDate data) {
		this.data_nascimento = data;
	}



	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paciente other = (Paciente) obj;
		if (data_nascimento == null) {
			if (other.data_nascimento != null)
				return false;
		} else if (!data_nascimento.equals(other.data_nascimento))
			return false;
		if (documento == null) {
			if (other.documento != null)
				return false;
		} else if (!documento.equals(other.documento))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (sexo == null) {
			if (other.sexo != null)
				return false;
		} else if (!sexo.equals(other.sexo))
			return false;
		return true;
	}

	public String toString() {
		return "--Paciente--\nDocumento: " + documento + "\nNome: " + nomeAjustado(nome) + "\nSexo: " + sexo + "\nEndereco:" + endereco
				+ "\nData de Nascimento: " + data_nascimento;
	}
	
	public int Idade(){
		LocalDate dataP = LocalDate.now();
		Period idade= Period.between(this.data_nascimento,dataP);
		return idade.getYears();
	}
	
	public String nomeAjustado (String nomepaciente) {
		int cont =0;
		String token ="";
		String aux="";
	    StringTokenizer teste = new StringTokenizer(nomepaciente," ");
	    while(teste.hasMoreTokens()){       
	    	token = teste.nextToken();
	    	if (cont==0)
	    		aux=aux.concat(", "+token.substring(0, 1));
	    	else
	    	    aux=aux.concat(". "+token.substring(0, 1));
	        cont++;
	    }
	    int tam=aux.length();
	    aux=aux.substring(0,tam-1);
	    String ajustada =token.concat(""+aux);
	    return ajustada;
	}
	
}

