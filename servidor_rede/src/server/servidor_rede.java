package server;

import java.time.*;
import java.time.temporal.ChronoUnit;

import server.responsavel;

public class servidor_rede {

	private String cod_Identificacao;
	private String marca;
	private responsavel adm;
	private LocalDate data;
	
	/**
	 * Construtores
	 */
	
	public servidor_rede(String cod_Identificacao) {
		this.cod_Identificacao = cod_Identificacao;
	}

	public servidor_rede (String cod_Identificacao, responsavel adm){
		this.cod_Identificacao = cod_Identificacao;
		this.adm = adm;
	} 

	public servidor_rede (String cod_Identificacao, String marca, LocalDate data,responsavel adm){
		this.cod_Identificacao = cod_Identificacao;
		this.marca = marca;
		this.data = data;
		this.adm = adm;
		
	} 

	
	/**
	 * metodos Sets da classe 
	 */

	public void set_Cpf(String cod_Identificacao) {
		this.cod_Identificacao = cod_Identificacao;
	}


	public void set_Id_Marca(String cod_Identificacao, String marca){
		this.cod_Identificacao = cod_Identificacao;
		this.marca = marca;
	} 
	
	public void set_Tudo(String cod_Identificacao, String marca, LocalDate data,responsavel adm){
		this.cod_Identificacao = cod_Identificacao;
		this.marca = marca;
		this.data = data;
		this.adm = adm;
	} 

	
	
	/**
	 * Metodos Gets da clasee
	 */

	public String getcod_Identificacao() {
		return cod_Identificacao;
	}

	public String getmarca() {
		return marca;
	}

	public LocalDate getdata() {
		return data;
	}
	public responsavel getadm() {
		return adm;
	}

	/**
	 * toString
	 */
	@Override
	public String toString() {
		return "\n\n-----Servidor Rede----- \n\t Codigo de Identificacao: " + cod_Identificacao + "\n\t Marca:" + marca + "" + adm +
				"\n\t Data de aquisição: "+data;
	}

	
	/**
	 * equals
	 */
	
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		servidor_rede other = (servidor_rede) obj;
		if (adm == null) {
			if (other.adm != null)
				return false;
		} else if (!adm.equals(other.adm))
			return false;
		if (cod_Identificacao == null) {
			if (other.cod_Identificacao != null)
				return false;
		} else if (!cod_Identificacao.equals(other.cod_Identificacao))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		return true;
	}
	
	/**
	 * Metodo para tempo de dias da aquisição do servidor
	 * 
	 *@return retorna a quantidade de dias 
	 */
	
	public long conta_Dias(){                  		  
		  long totaldias = LocalDate.now().until(this.data,ChronoUnit.DAYS);
		return (totaldias*-1);
	}
}
